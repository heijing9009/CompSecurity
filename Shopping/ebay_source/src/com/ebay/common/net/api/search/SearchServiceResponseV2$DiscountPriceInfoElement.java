// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class item extends com.ebay.nautilus.kernel.util.
{

    final EbaySearchListItem item;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("originalRetailPrice".equals(s1))
        {
            s = SearchServiceResponseV2.this;
            s1 = item;
            s2 = new ItemCurrency();
            s1.originalRetailPrice = s2;
            return new item(s, s2);
        }
        if ("pricingTreatment".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.DiscountPriceInfoElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.pricingTreatment = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.DiscountPriceInfoElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    public _cls1.this._cls1(EbaySearchListItem ebaysearchlistitem)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        item = ebaysearchlistitem;
    }
}
