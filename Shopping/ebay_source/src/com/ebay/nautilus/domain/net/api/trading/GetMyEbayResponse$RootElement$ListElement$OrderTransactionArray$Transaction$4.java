// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.MyEbayListItem;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

class this._cls0 extends com.ebay.nautilus.kernel.util.nsaction._cls4
{

    final em this$0;

    public void text(String s)
        throws SAXException
    {
        em.transaction.item = s;
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
