// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.MessageLiteOrBuilder;

// Referenced classes of package com.google.analytics.containertag.proto:
//            Serving

public static interface l
    extends MessageLiteOrBuilder
{

    public abstract int getExpirationSeconds();

    public abstract int getGcacheExpirationSeconds();

    public abstract l getLevel();

    public abstract boolean hasExpirationSeconds();

    public abstract boolean hasGcacheExpirationSeconds();

    public abstract boolean hasLevel();
}
