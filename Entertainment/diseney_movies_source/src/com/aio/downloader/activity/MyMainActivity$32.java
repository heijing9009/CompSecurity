// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.DialogInterface;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0
    implements android.content.ClickListener
{

    final MyMainActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    r()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
