// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.stats;

import com.google.android.gms.d.hy;

// Referenced classes of package com.google.android.gms.common.stats:
//            d

public final class c
{
    public static final class a
    {

        public static hy a;
        public static hy b = hy.a("gms:common:stats:connections:ignored_calling_processes", "");
        public static hy c = hy.a("gms:common:stats:connections:ignored_calling_services", "");
        public static hy d = hy.a("gms:common:stats:connections:ignored_target_processes", "");
        public static hy e = hy.a("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static hy f = hy.a("gms:common:stats:connections:time_out_duration", Long.valueOf(0x927c0L));

        static 
        {
            a = hy.a("gms:common:stats:connections:level", Integer.valueOf(d.a));
        }
    }

    public static final class b
    {

        public static hy a;
        public static hy b = hy.a("gms:common:stats:wakelocks:time_out_duration", Long.valueOf(0x927c0L));

        static 
        {
            a = hy.a("gms:common:stats:wakeLocks:level", Integer.valueOf(d.a));
        }
    }


    public static hy a = hy.a("gms:common:stats:max_num_of_events", Integer.valueOf(100));

}
