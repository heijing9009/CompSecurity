// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control;

import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.control:
//            PagedListingBrowser

class 
    implements Runnable
{

    final PagedListingBrowser this$0;
    final byte val$image[];
    final int val$intraPageIndex;
    final ServiceCall val$serviceCall;

    public void run()
    {
        addToListAndNotify(listingImages, val$image, val$intraPageIndex, val$serviceCall);
    }

    ()
    {
        this$0 = final_pagedlistingbrowser;
        val$image = abyte0;
        val$intraPageIndex = i;
        val$serviceCall = ServiceCall.this;
        super();
    }
}
