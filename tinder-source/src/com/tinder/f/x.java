// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tinder.f;

import android.content.Context;
import com.tinder.managers.ManagerNotifications;
import com.tinder.managers.ad;
import com.tinder.managers.ae;
import com.tinder.managers.i;
import com.tinder.managers.z;
import dagger.internal.a;
import de.greenrobot.event.c;

// Referenced classes of package com.tinder.f:
//            m

public final class x
    implements a
{

    static final boolean a;
    private final m b;
    private final a.a.a c;
    private final a.a.a d;
    private final a.a.a e;
    private final a.a.a f;
    private final a.a.a g;
    private final a.a.a h;

    private x(m m, a.a.a a1, a.a.a a2, a.a.a a3, a.a.a a4, a.a.a a5, a.a.a a6)
    {
        if (!a && m == null)
        {
            throw new AssertionError();
        }
        b = m;
        if (!a && a1 == null)
        {
            throw new AssertionError();
        }
        c = a1;
        if (!a && a2 == null)
        {
            throw new AssertionError();
        }
        d = a2;
        if (!a && a3 == null)
        {
            throw new AssertionError();
        }
        e = a3;
        if (!a && a4 == null)
        {
            throw new AssertionError();
        }
        f = a4;
        if (!a && a5 == null)
        {
            throw new AssertionError();
        }
        g = a5;
        if (!a && a6 == null)
        {
            throw new AssertionError();
        } else
        {
            h = a6;
            return;
        }
    }

    public static a a(m m, a.a.a a1, a.a.a a2, a.a.a a3, a.a.a a4, a.a.a a5, a.a.a a6)
    {
        return new x(m, a1, a2, a3, a4, a5, a6);
    }

    public final Object a()
    {
        return new ManagerNotifications((Context)c.a(), (i)d.a(), (z)e.a(), (ad)f.a(), (ae)g.a(), (c)h.a());
    }

    static 
    {
        boolean flag;
        if (!com/tinder/f/x.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
