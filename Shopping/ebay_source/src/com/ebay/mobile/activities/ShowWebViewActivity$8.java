// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.DialogInterface;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewActivity

class this._cls0
    implements android.content.kListener
{

    final ShowWebViewActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        isHandlingError = false;
        onRefresh();
        dialoginterface.cancel();
    }

    ()
    {
        this$0 = ShowWebViewActivity.this;
        super();
    }
}
