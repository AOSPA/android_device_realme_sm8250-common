package org.ifaa.android.manager;

import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Parcel;
import android.os.UserHandle;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.Log;
import android.util.Slog;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public class IFAAManagerImpl extends IFAAManagerV4 {
    private static final boolean DEBUG = false;

    public static final int BIOMETRIC_NOUSE_NOSET_KEYGUARD = 1003;
    public static final int BIOMETRIC_NOUSE_NOT_ENROLLED = 1002;
    public static final int BIOMETRIC_NOUSE_SYSTEMLOCKED = 1001;
    public static final int BIOMETRIC_USE_READY = 1000;

    private static Context mContext;

    private static FingerprintManager mFingerprintManager = null;
    private static KeyguardManager mKeyguardManager = null;

    private static volatile IFAAManagerImpl INSTANCE = null;

    private static final String TAG = "IfaaManagerImpl";

    private static final String mIfaaActName = "org.ifaa.android.manager.IFAAService";
    private static final String mIfaaPackName = "org.ifaa.android.manager";
    private static IIFAAService mService = null;

    private static void initService() {
        Intent intent = new Intent();
        intent.setClassName(mIfaaPackName, mIfaaActName);
        if (!mContext.bindService(intent, ifaaconn, Context.BIND_AUTO_CREATE)) {
            if (DEBUG) Slog.e(TAG, "cannot bind service org.ifaa.android.manager.IFAAService");
        }
    }

    private static ServiceConnection ifaaconn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = IIFAAService.Stub.asInterface(service);
            try {
                mService.asBinder().linkToDeath(mDeathRecipient, 0);
            } catch (RemoteException e) {
                if (DEBUG) Slog.e(TAG, "linkToDeath fail.", e);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            if (mContext != null) {
                if (DEBUG) Slog.i(TAG, "re-bind the service.");
                initService();
            }
        }
    };

    public static IFAAManager getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (IFAAManagerImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new IFAAManagerImpl();
                    if (VERSION.SDK_INT >= 28) {
                        mContext = context;
                        initService();
                    }
                }
            }
        }
        return INSTANCE;
    }

    private static void ensureNeedServiceAvailable() {
        if (mFingerprintManager == null) {
            mFingerprintManager = (FingerprintManager) mContext.getSystemService("fingerprint");
            if (mFingerprintManager == null) {
                Log.e(TAG, "getIFAAManager: mFingerprintManager = null!");
            }
        }
        if (mKeyguardManager == null) {
            mKeyguardManager = (KeyguardManager) mContext.getSystemService("keyguard");
        }
    }

    public int getSupportBIOTypes(Context context) {
        return IFAAManager.AUTH_TYPE_OPTICAL_FINGERPRINT;
    }

    public int startBIOManager(Context context, int authType) {
        if (authType != 1) {
            return -1;
        }
        try {
            Log.e(TAG, "startBIOManager" + context);
            context.startActivityAsUser(new Intent("android.settings.FINGERPRINT_SETTINGS"), UserHandle.OWNER);
            return 0;
        } catch (ActivityNotFoundException e) {
            return -1;
        }
    }

    public String getDeviceModel() {
        String model = "OPPO-R9065";
        return model;
    }

    public int getVersion() {
        int version = 4;
        return version;
    }

    public String getExtInfo(int authType, String keyExtInfo) {
        String extStr = "";
        JSONObject obj = new JSONObject();
        JSONObject keyInfo = new JSONObject();
        try {
            keyInfo.put("startX", 569);
            keyInfo.put("startY", 2393);
            keyInfo.put("width", 303);
            keyInfo.put("height", 303);
            keyInfo.put("navConflict", true);
            obj.put("type", 0);
            obj.put("fullView", keyInfo);
            extStr = obj.toString();
        } catch (Exception e) {
            Slog.e(TAG, "Exception , ExtInfo generation failed", e);
        }
        return extStr;
    }

    public void setExtInfo(int authType, String keyExtInfo, String valExtInfo) {
    }

    public int getEnabled(int bioType) {
        ensureNeedServiceAvailable();
        boolean isKeyguardSecure = this.mKeyguardManager.isKeyguardSecure();
        if (!isKeyguardSecure) {
            Log.e(TAG, "Security keyguard no set");
            return BIOMETRIC_NOUSE_NOSET_KEYGUARD;
        } else if (bioType == 1) {
            return BIOMETRIC_USE_READY;
        } else if (bioType == 4) {
            Log.w(TAG, "Face Hardware not available!");
            return BIOMETRIC_NOUSE_SYSTEMLOCKED;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("bioType err:");
            stringBuilder.append(bioType);
            Log.w(TAG, stringBuilder.toString());
            return 0;
        }
    }

    public int[] getIDList(int bioType) {
        ensureNeedServiceAvailable();
        int[] myIDList;
        int i;
        if (bioType == 4) {
            Log.w(TAG, "getIDList: no mFaceManager!");
            return null;
        } else if (bioType == 1) {
            if (this.mFingerprintManager == null) {
                Log.w(TAG, "getIDList: no FingerprintManager!");
                return null;
            }
            Log.w(TAG, "getIDList:fingerprint list!");
            List<Fingerprint> myFingerprintList = this.mFingerprintManager.getEnrolledFingerprints();
            if (!(myFingerprintList == null || myFingerprintList.size() == 0)) {
                myIDList = new int[myFingerprintList.size()];
                for (i = 0; i < myFingerprintList.size() - 1; i++) {
                    if (myFingerprintList.get(i) != null) {
                        myIDList[i] = ((Fingerprint) myFingerprintList.get(i)).getBiometricId();
                    }
                }
                return myIDList;
            }
        }
        return null;
    }

    public String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int v : src) {
            String hv = Integer.toHexString(v & 255);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public byte[] processCmdV2(Context context, byte[] data) {
        if (DEBUG) Slog.i(TAG, "processCmdV2 sdk:" + VERSION.SDK_INT);

        try {
            return mService.processCmd_v2(data);
        } catch (RemoteException e) {
            if (DEBUG) Slog.e(TAG, "processCmdV2 transact failed. " + e);
        }
        return null;
    }

    private static DeathRecipient mDeathRecipient = new DeathRecipient() {
        public void binderDied() {
            if (mService != null) {
                Slog.d(TAG, "binderDied, unlink the service.");
                mService.asBinder().unlinkToDeath(mDeathRecipient, 0);
            }
        }
    };
}