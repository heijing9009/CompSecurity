// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import java.util.Map;

// Referenced classes of package com.facebook.internal:
//            Utility, FacebookRequestErrorClassification

public static class ication
{

    private Map dialogConfigMap;
    private FacebookRequestErrorClassification errorClassification;
    private String nuxContent;
    private boolean nuxEnabled;
    private boolean supportsImplicitLogging;

    public FacebookRequestErrorClassification getErrorClassification()
    {
        return errorClassification;
    }

    public boolean supportsImplicitLogging()
    {
        return supportsImplicitLogging;
    }

    private ication(boolean flag, String s, boolean flag1, Map map, FacebookRequestErrorClassification facebookrequesterrorclassification)
    {
        supportsImplicitLogging = flag;
        nuxContent = s;
        nuxEnabled = flag1;
        dialogConfigMap = map;
        errorClassification = facebookrequesterrorclassification;
    }

    ication(boolean flag, String s, boolean flag1, Map map, FacebookRequestErrorClassification facebookrequesterrorclassification, ication ication)
    {
        this(flag, s, flag1, map, facebookrequesterrorclassification);
    }
}
