// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.model.b;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.a.r;
import com.target.mothership.model.guest.interfaces.a.m;
import com.target.mothership.services.apigee.f.b.n;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            TGTPaymentTender

public class u extends b
{

    public u(d d)
    {
        super(d);
    }

    protected PaymentTender a(n n1)
    {
        TGTPaymentTender tgtpaymenttender = new TGTPaymentTender();
        tgtpaymenttender.c(n1.a());
        return tgtpaymenttender;
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((n)obj);
    }

    protected m b(x x)
    {
        return (new r()).a(x);
    }
}
