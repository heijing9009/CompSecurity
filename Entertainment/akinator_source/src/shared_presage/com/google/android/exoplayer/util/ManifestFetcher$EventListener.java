// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.util;

import java.io.IOException;

// Referenced classes of package shared_presage.com.google.android.exoplayer.util:
//            ManifestFetcher

public static interface 
{

    public abstract void onManifestError(IOException ioexception);

    public abstract void onManifestRefreshStarted();

    public abstract void onManifestRefreshed();
}
