// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzcr, zzcq

public class zzdb extends zzcw.zza
{

    private final com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener zzxj;

    public zzdb(com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener onappinstalladloadedlistener)
    {
        zzxj = onappinstalladloadedlistener;
    }

    public void zza(zzcq zzcq)
    {
        zzxj.onAppInstallAdLoaded(zzb(zzcq));
    }

    zzcr zzb(zzcq zzcq)
    {
        return new zzcr(zzcq);
    }
}
