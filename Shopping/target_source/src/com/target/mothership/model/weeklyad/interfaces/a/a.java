// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class com.target.mothership.model.weeklyad.interfaces.a.a extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_NETWORK;
        public static final a ERR_NO_PAGES;
        private c mCode[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/weeklyad/interfaces/a/a$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        public c[] a()
        {
            return mCode;
        }

        static 
        {
            ERR_NETWORK = new a("ERR_NETWORK", 0, new c[0]);
            ERR_NO_PAGES = new a("ERR_NO_PAGES", 1, new c[0]);
            $VALUES = (new a[] {
                ERR_NETWORK, ERR_NO_PAGES
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mCode = ac;
        }
    }


    public com.target.mothership.model.weeklyad.interfaces.a.a()
    {
    }

    public a[] a()
    {
        return a.values();
    }

    public j[] c()
    {
        return a();
    }
}
