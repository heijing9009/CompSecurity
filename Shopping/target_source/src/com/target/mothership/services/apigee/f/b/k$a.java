// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.b;

import com.google.b.f;
import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import com.target.mothership.b;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.services.apigee.f.b:
//            k, m

public static class 
    implements k
{

    public com.target.mothership.services.apigee.f.b.k a(l l1, Type type, j j)
        throws p
    {
        type = new com.target.mothership.services.apigee.f.b.k();
        j = b.a().k();
        l1 = l1.m();
        if (l1.a("CheckoutProfile"))
        {
            m m1;
            for (l1 = l1.b("CheckoutProfile").n().iterator(); l1.hasNext(); k.a(type).add(m1))
            {
                m1 = (m)j.a((l)l1.next(), com/target/mothership/services/apigee/f/b/m);
            }

        }
        return type;
    }

    public Object deserialize(l l1, Type type, j j)
        throws p
    {
        return a(l1, type, j);
    }

    public ()
    {
    }
}
