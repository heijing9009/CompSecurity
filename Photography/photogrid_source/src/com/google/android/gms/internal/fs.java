// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            fz, ry

final class fs
    implements fz
{

    fs()
    {
    }

    public final void zza(ry ry1, Map map)
    {
        map = (String)map.get("urls");
        if (TextUtils.isEmpty(map))
        {
            zzb.zzaH("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String as[] = map.split(",");
        HashMap hashmap = new HashMap();
        PackageManager packagemanager = ry1.getContext().getPackageManager();
        int j = as.length;
        int i = 0;
        while (i < j) 
        {
            String s = as[i];
            map = s.split(";", 2);
            String s1 = map[0].trim();
            boolean flag;
            if (map.length > 1)
            {
                map = map[1].trim();
            } else
            {
                map = "android.intent.action.VIEW";
            }
            if (packagemanager.resolveActivity(new Intent(map, Uri.parse(s1)), 0x10000) != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            hashmap.put(s, Boolean.valueOf(flag));
            i++;
        }
        ry1.a("openableURLs", hashmap);
    }
}
