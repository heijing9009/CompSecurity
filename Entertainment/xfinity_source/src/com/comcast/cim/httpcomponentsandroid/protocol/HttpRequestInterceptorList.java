// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.protocol;

import java.util.List;

public interface HttpRequestInterceptorList
{

    public abstract int getRequestInterceptorCount();

    public abstract void setInterceptors(List list);
}
