// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2, SearchConfiguration

class this._cls1 extends com.ebay.nautilus.kernel.util.
{

    final em this$1;

    public void text(String s)
        throws SAXException
    {
        if (config.isEEKEnabled)
        {
            em.eekRating = s;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
