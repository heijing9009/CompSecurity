// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.interfaces;

import java.math.BigDecimal;
import java.util.List;

// Referenced classes of package com.target.mothership.model.guest.interfaces:
//            OrderSummaryProduct

public interface OrderDetailsProduct
    extends OrderSummaryProduct
{

    public abstract List a();

    public abstract BigDecimal b();
}
