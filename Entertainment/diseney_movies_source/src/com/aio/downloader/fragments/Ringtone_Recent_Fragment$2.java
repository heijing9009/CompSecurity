// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.aio.downloader.utils.ProgressWheel;

// Referenced classes of package com.aio.downloader.fragments:
//            Ringtone_Recent_Fragment

class this._cls0 extends BroadcastReceiver
{

    final Ringtone_Recent_Fragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        Ringtone_Recent_Fragment.access$0(Ringtone_Recent_Fragment.this).setVisibility(8);
    }

    ()
    {
        this$0 = Ringtone_Recent_Fragment.this;
        super();
    }
}
