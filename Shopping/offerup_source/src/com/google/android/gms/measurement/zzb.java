// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.measurement:
//            zzi, zzc, zze

public final class zzb
    implements zzi
{

    private static final Uri zzaKM;
    private final LogPrinter zzaKN = new LogPrinter(4, "GA/LogCatTransport");

    public zzb()
    {
    }

    public final void zzb(zzc zzc1)
    {
        Object obj = new ArrayList(zzc1.zzyf());
        Collections.sort(((List) (obj)), new _cls1());
        zzc1 = new StringBuilder();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = ((zze)((Iterator) (obj)).next()).toString();
            if (!TextUtils.isEmpty(s))
            {
                if (zzc1.length() != 0)
                {
                    zzc1.append(", ");
                }
                zzc1.append(s);
            }
        } while (true);
        zzaKN.println(zzc1.toString());
    }

    public final Uri zzhI()
    {
        return zzaKM;
    }

    static 
    {
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme("uri");
        builder.authority("local");
        zzaKM = builder.build();
    }

    private class _cls1
        implements Comparator
    {

        final zzb zzaKO;

        public int compare(Object obj, Object obj1)
        {
            return zza((zze)obj, (zze)obj1);
        }

        public int zza(zze zze1, zze zze2)
        {
            return zze1.getClass().getCanonicalName().compareTo(zze2.getClass().getCanonicalName());
        }

        _cls1()
        {
            zzaKO = zzb.this;
            super();
        }
    }

}
