// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzhq, zzdn, zzip, zzhu

public static class zzF extends zzhq
{

    private final String zzF;
    private final zzip zzoL;
    private final String zzxn = "play.google.com";
    private final String zzxo = "market";
    private final int zzxp = 10;

    public void onStop()
    {
    }

    public Intent zzY(String s)
    {
        s = Uri.parse(s);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(0x10000000);
        intent.setData(s);
        return intent;
    }

    public void zzdG()
    {
        Object obj;
        int i;
        i = 0;
        obj = zzF;
_L11:
        if (i >= 10) goto _L2; else goto _L1
_L1:
        Object obj1;
        boolean flag;
        obj1 = new URL(((String) (obj)));
        flag = "play.google.com".equalsIgnoreCase(((URL) (obj1)).getHost());
        if (!flag) goto _L3; else goto _L2
_L2:
        obj = zzY(((String) (obj)));
        zzoL.getContext().startActivity(((Intent) (obj)));
        return;
_L3:
        if (!"market".equalsIgnoreCase(((URL) (obj1)).getProtocol())) goto _L4; else goto _L2
_L4:
        HttpURLConnection httpurlconnection = (HttpURLConnection)((URL) (obj1)).openConnection();
        Map map;
        int j;
        zzp.zzbx().zza(zzoL.getContext(), zzoL.zzgV().zzIz, false, httpurlconnection);
        j = httpurlconnection.getResponseCode();
        map = httpurlconnection.getHeaderFields();
        if (j < 300 || j > 399)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        obj1 = null;
        if (!map.containsKey("Location")) goto _L6; else goto _L5
_L5:
        obj1 = (List)map.get("Location");
_L10:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        if (((List) (obj1)).size() <= 0)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        obj1 = (String)((List) (obj1)).get(0);
_L15:
        if (!TextUtils.isEmpty(((CharSequence) (obj1)))) goto _L8; else goto _L7
_L7:
        zzb.zzaE("Arrived at landing page, this ideally should not happen. Will open it in browser.");
        httpurlconnection.disconnect();
          goto _L2
_L6:
        if (!map.containsKey("location")) goto _L10; else goto _L9
_L9:
        obj1 = (List)map.get("location");
          goto _L10
_L8:
        httpurlconnection.disconnect();
        i++;
        obj = obj1;
          goto _L11
        obj1;
        httpurlconnection.disconnect();
        throw obj1;
        obj1;
_L14:
        zzb.zzd((new StringBuilder()).append("Error while parsing ping URL: ").append(((String) (obj))).toString(), ((Throwable) (obj1)));
          goto _L2
        obj1;
_L13:
        zzb.zzd((new StringBuilder()).append("Error while pinging URL: ").append(((String) (obj))).toString(), ((Throwable) (obj1)));
          goto _L2
        obj1;
_L12:
        zzb.zzd((new StringBuilder()).append("Error while pinging URL: ").append(((String) (obj))).toString(), ((Throwable) (obj1)));
          goto _L2
        Object obj2;
        obj2;
        obj = obj1;
        obj1 = obj2;
          goto _L12
        obj2;
        obj = obj1;
        obj1 = obj2;
          goto _L13
        obj2;
        obj = obj1;
        obj1 = obj2;
          goto _L14
        obj1 = "";
          goto _L15
    }

    public client.zzb(zzip zzip1, String s)
    {
        zzoL = zzip1;
        zzF = s;
    }
}
