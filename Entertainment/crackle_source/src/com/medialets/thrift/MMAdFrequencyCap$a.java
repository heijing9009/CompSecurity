// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.io.Serializable;

// Referenced classes of package com.medialets.thrift:
//            MMAdFrequencyCap

private static final class dayModifier
    implements Serializable
{

    public boolean dayModifier;
    public boolean maxImpressions;

    ()
    {
        this((byte)0);
    }

    private <init>(byte byte0)
    {
        maxImpressions = false;
        dayModifier = false;
    }
}
