// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import com.ebay.common.net.api.search.SearchParameters;

// Referenced classes of package com.ebay.mobile.search:
//            RefinementLocks

static final class nit> extends nit>
{

    void apply(SearchParameters searchparameters, String s)
    {
        searchparameters.bestOfferOnly = Boolean.parseBoolean(s);
    }

    boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
    {
        return searchparameters.bestOfferOnly == searchparameters1.bestOfferOnly;
    }

    A(String s, int i)
    {
        super(s, i, null);
    }
}
