// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.metrics;

import android.content.Context;
import com.amazon.identity.platform.metric.MetricUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsCollector;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;

public final class WebserviceCallMetrics
{

    private static PlatformMetricsCollector sCollector;
    private static Context sContext;

    private static void doInit()
    {
        com/amazon/identity/auth/device/metrics/WebserviceCallMetrics;
        JVM INSTR monitorenter ;
        if (sContext == null) goto _L2; else goto _L1
_L1:
        PlatformMetricsCollector platformmetricscollector = sCollector;
        if (platformmetricscollector == null) goto _L3; else goto _L2
_L2:
        com/amazon/identity/auth/device/metrics/WebserviceCallMetrics;
        JVM INSTR monitorexit ;
        return;
_L3:
        sCollector = MetricsHelper.getMetricsCollectorInstance(sContext);
        if (true) goto _L2; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public static PlatformMetricsTimer getTimer(String s)
    {
        doInit();
        return PlatformMetricsTimer.getInstance(sCollector, "WebserviceCallTime", MetricUtils.getMAPUrlType(s));
    }

    private static transient void incrementMetricCounter(String s, String as[])
    {
        if (sCollector == null)
        {
            return;
        } else
        {
            sCollector.incrementMetricCounter("GenericMetrics_WebserviceCall", s, as);
            return;
        }
    }

    public static void init(Context context)
    {
        sContext = context.getApplicationContext();
    }

    public static void reportNetworkFailure(String s)
    {
        doInit();
        incrementMetricCounter("NetworkFailure", new String[] {
            MetricUtils.getMAPUrlType(s)
        });
    }

    public static void reportNetworkNotAvailableFailure(String s)
    {
        doInit();
        incrementMetricCounter("NetworkNotAvailable", new String[] {
            (new StringBuilder()).append(MetricUtils.getMAPUrlType(s)).append("NetworkNotAvailable").toString()
        });
    }
}
