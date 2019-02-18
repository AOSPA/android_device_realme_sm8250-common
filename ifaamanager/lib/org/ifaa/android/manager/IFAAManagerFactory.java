package org.ifaa.android.manager;

import android.compat.annotation.UnsupportedAppUsage;
import android.content.Context;

public class IFAAManagerFactory {
    public static final String TAG = "IFAAManagerFactory";
    private static IFAAManager IFAAManager;

    @UnsupportedAppUsage
    public static IFAAManager getIFAAManager(Context context, int authType) {
        if (IFAAManager == null) {
            IFAAManager = IFAAManagerImpl.getInstance(context);
        }
        return IFAAManager;
    }
}
