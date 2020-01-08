package org.ifaa.android.manager;

import android.content.Context;
import android.compat.annotation.UnsupportedAppUsage;

public abstract class IFAAManagerV2 extends IFAAManager {

    @UnsupportedAppUsage
    public abstract byte[] processCmdV2(Context context, byte[] bArr);
}
