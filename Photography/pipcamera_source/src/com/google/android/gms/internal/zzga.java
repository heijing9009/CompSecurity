// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzfy, zzhv

public class zzga
    implements zzfy.zza
{

    private final boolean zzBY;
    private final boolean zzBZ;

    public zzga(boolean flag, boolean flag1)
    {
        zzBY = flag;
        zzBZ = flag1;
    }

    public com.google.android.gms.ads.internal.formats.zzg.zza zza(zzfy zzfy1, JSONObject jsonobject)
    {
        return zzc(zzfy1, jsonobject);
    }

    public zze zzc(zzfy zzfy1, JSONObject jsonobject)
    {
        Object obj = zzfy1.zza(jsonobject, "images", true, zzBY, zzBZ);
        zzhv zzhv1 = zzfy1.zza(jsonobject, "secondary_image", false, zzBY);
        zzfy1 = zzfy1.zze(jsonobject);
        ArrayList arraylist = new ArrayList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((zzhv)((Iterator) (obj)).next()).get())) { }
        return new zze(jsonobject.getString("headline"), arraylist, jsonobject.getString("body"), (zzc)zzhv1.get(), jsonobject.getString("call_to_action"), jsonobject.getString("advertiser"), (zza)zzfy1.get());
    }
}
