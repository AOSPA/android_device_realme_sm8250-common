package org.ifaa.android.manager;

import android.content.Context;
import android.annotation.UnsupportedAppUsage;

public abstract class IFAAManager {
    public static final int AUTH_TYPE_FINGERPRINT = 1;
    public static final int AUTH_TYPE_IRIS = 2;
    public static final int AUTH_TYPE_NOT_SUPPORT = 0;
    public static final int AUTH_TYPE_OPTICAL_FINGERPRINT = 17;
    public static final int COMMAND_FAIL = -1;
    public static final int COMMAND_OK = 0;

    @UnsupportedAppUsage
    public abstract String getDeviceModel();

    @UnsupportedAppUsage
    public abstract int getSupportBIOTypes(Context context);

    @UnsupportedAppUsage
    public abstract int getVersion();

    @UnsupportedAppUsage
    public native byte[] processCmd(Context context, byte[] bArr);

    @UnsupportedAppUsage
    public abstract int startBIOManager(Context context, int i);
}
