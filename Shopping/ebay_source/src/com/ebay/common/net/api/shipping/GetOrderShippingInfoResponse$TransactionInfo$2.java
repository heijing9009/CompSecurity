// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import com.ebay.common.model.OrderShippingInfo;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetOrderShippingInfoResponse

class this._cls1 extends com.ebay.nautilus.kernel.util.._cls2
{

    final this._cls1 this$1;

    public void text(String s)
        throws SAXException
    {
        info.actualDeliveryDate = EbayDateUtils.parseXml(s);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
