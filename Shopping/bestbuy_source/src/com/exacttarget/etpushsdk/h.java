// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import com.exacttarget.etpushsdk.util.m;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETLocationManager, ETException

class h
    implements Runnable
{

    final Thread a;
    final ETLocationManager b;

    h(ETLocationManager etlocationmanager, Thread thread)
    {
        b = etlocationmanager;
        a = thread;
        super();
    }

    public void run()
    {
        try
        {
            m.a("~!ETLocationManager", "Waiting for stopWatchingProximity() to finish");
            if (!ETLocationManager.i().await(25000L, TimeUnit.MILLISECONDS))
            {
                throw new ETException("ETLocationManager startWatchingProximity() timed out waiting for state change.");
            }
        }
        catch (Exception exception)
        {
            m.c("~!ETLocationManager", exception.getMessage(), exception);
            return;
        }
        m.a("~!ETLocationManager", "stopWatchingProximity() finished.  So continue to start watching proximity.");
        ETLocationManager.b(new CountDownLatch(1));
        a.start();
        return;
    }
}
