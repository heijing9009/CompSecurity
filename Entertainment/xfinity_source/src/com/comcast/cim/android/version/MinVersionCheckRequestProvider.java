// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.version;

import com.comcast.cim.cmasl.http.request.CacheableRequestProvider;
import com.comcast.cim.cmasl.http.request.RevalidatingRequestProvider;

public class MinVersionCheckRequestProvider extends RevalidatingRequestProvider
    implements CacheableRequestProvider
{

    private final String cacheKey;

    public String getCacheKey()
    {
        return cacheKey;
    }
}
