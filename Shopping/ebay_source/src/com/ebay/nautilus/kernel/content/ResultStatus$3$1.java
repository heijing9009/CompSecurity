// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;

import java.util.Collections;

// Referenced classes of package com.ebay.nautilus.kernel.content:
//            EbayContext, ResultStatus

class this._cls0
    implements age
{

    final rity.Error this$0;

    public boolean displayToUser()
    {
        return false;
    }

    public String getCategory()
    {
        return null;
    }

    public String getDomain()
    {
        return null;
    }

    public int getId()
    {
        return -2;
    }

    public String getLongMessage(EbayContext ebaycontext)
    {
        return null;
    }

    public String getRemediationUrl()
    {
        return null;
    }

    public rity getSeverity()
    {
        return rity.Error;
    }

    public String getShortMessage(EbayContext ebaycontext)
    {
        return "A pending call was canceled.";
    }

    public boolean isLongMessageHtml(EbayContext ebaycontext)
    {
        return false;
    }

    public String toString()
    {
        return "A pending call was canceled.";
    }

    <init>()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/ebay/nautilus/kernel/content/ResultStatus$3

/* anonymous class */
    static final class ResultStatus._cls3 extends ResultStatus
    {

            
            {
                _messages = Collections.unmodifiableList(Collections.singletonList(new ResultStatus._cls3._cls1()));
            }
    }

}
