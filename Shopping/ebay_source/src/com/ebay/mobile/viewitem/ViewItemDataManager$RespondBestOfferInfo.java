// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.common.net.api.trading.RespondToBestOfferResponse;
import com.ebay.mobile.viewitem.message.PlaceOfferResultStatus;
import com.ebay.nautilus.domain.content.Content;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

public final class item
{

    public String action;
    public Content item;
    public RespondToBestOfferResponse response;
    final ViewItemDataManager this$0;

    public ()
    {
        this$0 = ViewItemDataManager.this;
        super();
    }

    public this._cls0(Content content, PlaceOfferResultStatus placeofferresultstatus)
    {
        this$0 = ViewItemDataManager.this;
        super();
        item = content;
    }
}
