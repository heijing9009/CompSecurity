// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.os.Bundle;
import android.webkit.WebView;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPAndroidWebViewHelper

class val.url
    implements Callback
{

    final MAPAndroidWebViewHelper this$0;
    final String val$url;
    final WebView val$webView;

    public void onError(Bundle bundle)
    {
        MAPAndroidWebViewHelper.access$800(MAPAndroidWebViewHelper.this, val$webView, bundle, val$url);
    }

    public void onSuccess(Bundle bundle)
    {
        MAPAndroidWebViewHelper.access$700(MAPAndroidWebViewHelper.this, val$webView, bundle, val$url);
    }

    ()
    {
        this$0 = final_mapandroidwebviewhelper;
        val$webView = webview;
        val$url = String.this;
        super();
    }
}
