// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.data.NameValue;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

class val.nameValue extends com.ebay.nautilus.kernel.util._cls1
{

    final val.nameValue this$1;
    final NameValue val$nameValue;

    public void text(String s)
        throws SAXException
    {
        val$nameValue.setName(s);
    }

    Q()
    {
        this$1 = final_q;
        val$nameValue = NameValue.this;
        super();
    }
}
