// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;

import com.ebay.nautilus.kernel.content.EbayContext;

public interface TrackableDictionary
{

    public abstract void addKeyValuePair(String s, String s1);

    public abstract void send(EbayContext ebaycontext);
}
