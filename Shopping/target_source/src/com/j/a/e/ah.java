// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.j.a.g.m;
import com.j.a.g.w;
import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            ai, az

class ah
    implements com.d.a.b.a.a
{

    final az a;

    ah(az az)
    {
        a = az;
        super();
    }

    public transient void a(Object aobj[])
    {
        w.a("dataUpdated Socket");
        m.a(new ai(this, (JSONObject)aobj[0]));
    }
}
