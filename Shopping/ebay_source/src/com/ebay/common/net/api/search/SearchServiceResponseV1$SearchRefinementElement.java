// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1

private class <init> extends com.ebay.nautilus.kernel.util.
{

    final SearchServiceResponseV1 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("categoryHistogram".equals(s1))
        {
            return new (SearchServiceResponseV1.this, new com.ebay.common.model.search.t.this._cls0());
        }
        if ("scopedAspectHistogram".equals(s1))
        {
            return new init>(SearchServiceResponseV1.this);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private ()
    {
        this$0 = SearchServiceResponseV1.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
