// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


// Referenced classes of package com.google.android.gms.tagmanager:
//            zzcw, zzba, zzl

class zzm
{
    public static interface zza
    {

        public abstract int sizeOf(Object obj, Object obj1);
    }


    final zza zzaOQ = new zza() {

        final zzm zzaOR;

        public int sizeOf(Object obj, Object obj1)
        {
            return 1;
        }

            
            {
                zzaOR = zzm.this;
                super();
            }
    };

    public zzm()
    {
    }

    public zzl zza(int i, zza zza1)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (zzzz() < 12)
        {
            return new zzcw(i, zza1);
        } else
        {
            return new zzba(i, zza1);
        }
    }

    int zzzz()
    {
        return android.os.Build.VERSION.SDK_INT;
    }
}
