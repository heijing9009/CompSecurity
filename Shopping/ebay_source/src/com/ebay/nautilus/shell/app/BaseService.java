// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.app.Service;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            FwService

public abstract class BaseService extends Service
    implements FwService
{

    private FwService.ServiceContext serviceContext;

    public BaseService()
    {
    }

    public final EbayContext getEbayContext()
    {
        this;
        JVM INSTR monitorenter ;
        FwService.ServiceContext servicecontext;
        if (serviceContext == null)
        {
            serviceContext = new FwService.ServiceContext(this);
        }
        servicecontext = serviceContext;
        this;
        JVM INSTR monitorexit ;
        return servicecontext;
        Exception exception;
        exception;
        throw exception;
    }
}
