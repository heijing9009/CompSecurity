// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.activity:
//            MyDownloaderList

class this._cls0 extends TimerTask
{

    final MyDownloaderList this$0;

    public void run()
    {
        Message message = new Message();
        message.what = 100;
        handler.sendMessage(message);
    }

    ()
    {
        this$0 = MyDownloaderList.this;
        super();
    }
}
