// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;


// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient, MShopWebViewContainer

class this._cls0
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;

    public void run()
    {
        if (MShopWebViewJavaScriptClient.access$400(MShopWebViewJavaScriptClient.this) != null)
        {
            MShopWebViewJavaScriptClient.access$400(MShopWebViewJavaScriptClient.this).dismissSpinnerOnNonWebviewAnimation();
        }
    }

    ()
    {
        this$0 = MShopWebViewJavaScriptClient.this;
        super();
    }
}
