// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fitbit.data.bl;


// Referenced classes of package com.fitbit.data.bl:
//            SyncDataForDayOperation

public static final class  extends Enum
{

    public static final t a;
    public static final t b;
    public static final t c;
    public static final t d;
    public static final t e;
    public static final t f;
    public static final t g;
    public static final t h;
    public static final t i;
    public static final t j;
    public static final t k;
    public static final t l;
    public static final t m;
    public static final t n;
    public static final t o;
    public static final t p;
    public static final t q;
    public static final t r;
    public static final t s;
    public static final t t;
    private static final t u[];

    public static  valueOf(String s1)
    {
        return ()Enum.valueOf(com/fitbit/data/bl/SyncDataForDayOperation$DailyDataType, s1);
    }

    public static [] values()
    {
        return ([])u.clone();
    }

    static 
    {
        a = new <init>("ACTIVITY_LOGS", 0);
        b = new <init>("CALORIES_TIME_SERIES", 1);
        c = new <init>("FOOD_LOGS", 2);
        d = new <init>("WATER_LOGS", 3);
        e = new <init>("SLEEP_LOGS", 4);
        f = new <init>("FLOORS_TIME_SERIES", 5);
        g = new <init>("STEPS_TIME_SERIES", 6);
        h = new <init>("STEPS_INTRADAY_TIME_SERIES", 7);
        i = new <init>("CALORIES_INTRADAY_TIME_SERIES", 8);
        j = new <init>("FLOORS_INTRADAY_TIME_SERIES", 9);
        k = new <init>("DISTANCE_TIME_SERIES", 10);
        l = new <init>("BODY_LOGS", 11);
        m = new <init>("WEIGHT_GOAL", 12);
        n = new <init>("PROFILE", 13);
        o = new <init>("DEVICES", 14);
        p = new <init>("WATER_GOAL", 15);
        q = new <init>("HEART_RATE_INTRADAY_TIME_SERIES", 16);
        r = new <init>("HEART_RATE_SUMMARY", 17);
        s = new <init>("BODY_FAT_GOAL", 18);
        t = new <init>("SLEEP_GOAL", 19);
        u = (new u[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t
        });
    }

    private (String s1, int i1)
    {
        super(s1, i1);
    }
}
