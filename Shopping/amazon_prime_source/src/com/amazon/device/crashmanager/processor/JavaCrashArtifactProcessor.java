// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.processor;

import com.amazon.device.crashmanager.Artifact;
import com.amazon.device.crashmanager.utils.CrashDescriptorDedupeUtil;
import com.amazon.device.crashmanager.utils.CrashDescriptorUtil;
import com.amazon.device.utils.DetUtil;
import com.amazon.dp.logger.DPLogger;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.device.crashmanager.processor:
//            AbstractDetArtifactProcessor, MetricsHeaderProcessorFactory, ExtractJavaVersionHeaderProcessor, MetricsHeaderProcessor

public class JavaCrashArtifactProcessor extends AbstractDetArtifactProcessor
{

    public static final Set JAVA_CRASH_ARTIFACT_TAGS;
    public static final Set JAVA_STACK_TRACE_TAGS;
    private static final DPLogger log = new DPLogger("JavaCrashArtifactProcessor");
    private final CrashDescriptorDedupeUtil mCrashDedupeUtil;
    private final com.amazon.device.utils.DetUtil.HeaderProcessor mJavaHeaderProcessor;
    private final MetricsHeaderProcessor mMetricsHeaderProcessor;

    public JavaCrashArtifactProcessor(DetUtil detutil, String s, String s1, Map map, MetricsHeaderProcessorFactory metricsheaderprocessorfactory, CrashDescriptorDedupeUtil crashdescriptordedupeutil)
    {
        super(detutil, s, s1, map);
        if (metricsheaderprocessorfactory == null)
        {
            throw new IllegalArgumentException("Metrics header processor factory must not be null.");
        }
        if (crashdescriptordedupeutil == null)
        {
            throw new IllegalArgumentException("CrashDedupeUtil must not be null.");
        } else
        {
            mMetricsHeaderProcessor = metricsheaderprocessorfactory.construct(mHeaderWriter);
            detutil = new HashMap(3);
            detutil.put("Process", mMetricsHeaderProcessor);
            detutil.put("hasForegroundActivities", mMetricsHeaderProcessor);
            detutil.put("Package", new ExtractJavaVersionHeaderProcessor(mHeaderWriter));
            mJavaHeaderProcessor = new com.amazon.device.utils.DetUtil.DefaultHeaderProcessor(detutil, mHeaderWriter);
            mCrashDedupeUtil = crashdescriptordedupeutil;
            return;
        }
    }

    protected void addSpecificHeaders(Artifact artifact, BufferedReader bufferedreader, Writer writer)
        throws Exception
    {
        mMetricsHeaderProcessor.setProcessTag(artifact.getTag());
        mJavaHeaderProcessor.process("ContentType", "JavaCrash", writer);
        mDetUtil.processHeaders(bufferedreader, writer, mJavaHeaderProcessor);
        if (JAVA_STACK_TRACE_TAGS.contains(artifact.getTag()))
        {
            bufferedreader = extractJavaCrashInfoFromCrashBody(bufferedreader, writer, mJavaHeaderProcessor);
            if (bufferedreader != null)
            {
                Integer integer = Integer.valueOf(mCrashDedupeUtil.getCount(bufferedreader));
                if (integer != null && integer.intValue() > 1)
                {
                    mJavaHeaderProcessor.process("CrashDuplicateCount", integer.toString(), writer);
                }
            }
            artifact.setCrashDescriptor(bufferedreader);
        }
    }

    public boolean canProcessTag(String s)
    {
        return JAVA_CRASH_ARTIFACT_TAGS.contains(s);
    }

    protected String extractJavaCrashInfoFromCrashBody(BufferedReader bufferedreader, Writer writer, com.amazon.device.utils.DetUtil.HeaderProcessor headerprocessor)
        throws Exception
    {
        bufferedreader = CrashDescriptorUtil.calculateCrashDescriptor(bufferedreader, writer, headerprocessor, mMetricsHeaderProcessor.getProcessName());
        headerprocessor.process("CrashDescriptor", bufferedreader, writer);
        return bufferedreader;
    }

    public volatile InputStream processArtifact(Artifact artifact)
        throws Exception
    {
        return super.processArtifact(artifact);
    }

    static 
    {
        HashSet hashset = new HashSet(8);
        hashset.add("system_app_crash");
        hashset.add("data_app_crash");
        hashset.add("system_app_wtf");
        hashset.add("system_server_crash");
        hashset.add("system_server_watchdog");
        hashset.add("system_server_wtf");
        JAVA_CRASH_ARTIFACT_TAGS = Collections.unmodifiableSet(hashset);
        hashset = new HashSet(4);
        hashset.add("system_app_crash");
        hashset.add("data_app_crash");
        hashset.add("system_server_crash");
        hashset.add("system_app_wtf");
        hashset.add("system_server_wtf");
        JAVA_STACK_TRACE_TAGS = Collections.unmodifiableSet(hashset);
    }
}
