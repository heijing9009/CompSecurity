// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

interface PreferredMarketplaceRetriever
{
    public static class NullPreferredMarketplaceRetriever
        implements PreferredMarketplaceRetriever
    {

        public String retrievePreferredMarketplace(Context context)
        {
            return null;
        }

        public NullPreferredMarketplaceRetriever()
        {
        }
    }


    public abstract String retrievePreferredMarketplace(Context context);
}
