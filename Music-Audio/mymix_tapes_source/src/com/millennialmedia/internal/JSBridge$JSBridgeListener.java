// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;


// Referenced classes of package com.millennialmedia.internal:
//            JSBridge

public static interface Params
{

    public abstract void close();

    public abstract boolean expand(Params params);

    public abstract void onAdLeftApplication();

    public abstract void onInjectedScriptsLoaded();

    public abstract void onJSBridgeReady();

    public abstract boolean resize(Params params);

    public abstract void setOrientation(int i);

    public abstract void showCloseIndicator(boolean flag);
}
