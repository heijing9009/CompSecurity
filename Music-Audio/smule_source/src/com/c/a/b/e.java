// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.c.a.b.f.a;

// Referenced classes of package com.c.a.b:
//            a, d

public class e
{

    private int a;
    private int b;
    private int c;
    private Drawable d;
    private Drawable e;
    private Drawable f;
    private boolean g;
    private boolean h;
    private boolean i;
    private com.c.a.b.a.e j;
    private android.graphics.BitmapFactory.Options k;
    private int l;
    private boolean m;
    private Object n;
    private a o;
    private a p;
    private com.c.a.b.c.a q;
    private Handler r;
    private boolean s;

    public e()
    {
        a = 0;
        b = 0;
        c = 0;
        d = null;
        e = null;
        f = null;
        g = false;
        h = false;
        i = false;
        j = com.c.a.b.a.e.b;
        k = new android.graphics.BitmapFactory.Options();
        l = 0;
        m = false;
        n = null;
        o = null;
        p = null;
        q = com.c.a.b.a.b();
        r = null;
        s = false;
        k.inPurgeable = true;
        k.inInputShareable = true;
    }

    static int a(e e1)
    {
        return e1.a;
    }

    static int b(e e1)
    {
        return e1.b;
    }

    static int c(e e1)
    {
        return e1.c;
    }

    static Drawable d(e e1)
    {
        return e1.d;
    }

    static Drawable e(e e1)
    {
        return e1.e;
    }

    static Drawable f(e e1)
    {
        return e1.f;
    }

    static boolean g(e e1)
    {
        return e1.g;
    }

    static boolean h(e e1)
    {
        return e1.h;
    }

    static boolean i(e e1)
    {
        return e1.i;
    }

    static com.c.a.b.a.e j(e e1)
    {
        return e1.j;
    }

    static android.graphics.BitmapFactory.Options k(e e1)
    {
        return e1.k;
    }

    static int l(e e1)
    {
        return e1.l;
    }

    static boolean m(e e1)
    {
        return e1.m;
    }

    static Object n(e e1)
    {
        return e1.n;
    }

    static a o(e e1)
    {
        return e1.o;
    }

    static a p(e e1)
    {
        return e1.p;
    }

    static com.c.a.b.c.a q(e e1)
    {
        return e1.q;
    }

    static Handler r(e e1)
    {
        return e1.r;
    }

    static boolean s(e e1)
    {
        return e1.s;
    }

    public e a()
    {
        h = true;
        return this;
    }

    public e a(int i1)
    {
        a = i1;
        return this;
    }

    public e a(com.c.a.b.a.e e1)
    {
        j = e1;
        return this;
    }

    public e a(com.c.a.b.c.a a1)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("displayer can't be null");
        } else
        {
            q = a1;
            return this;
        }
    }

    public e a(d d1)
    {
        a = com.c.a.b.d.a(d1);
        b = com.c.a.b.d.b(d1);
        c = com.c.a.b.d.c(d1);
        d = com.c.a.b.d.d(d1);
        e = com.c.a.b.d.e(d1);
        f = com.c.a.b.d.f(d1);
        g = com.c.a.b.d.g(d1);
        h = com.c.a.b.d.h(d1);
        i = com.c.a.b.d.i(d1);
        j = com.c.a.b.d.j(d1);
        k = com.c.a.b.d.k(d1);
        l = com.c.a.b.d.l(d1);
        m = com.c.a.b.d.m(d1);
        n = com.c.a.b.d.n(d1);
        o = com.c.a.b.d.o(d1);
        p = com.c.a.b.d.p(d1);
        q = com.c.a.b.d.q(d1);
        r = com.c.a.b.d.r(d1);
        s = com.c.a.b.d.s(d1);
        return this;
    }

    e a(boolean flag)
    {
        s = flag;
        return this;
    }

    public e b()
    {
        i = true;
        return this;
    }

    public d c()
    {
        return new d(this, null);
    }
}
