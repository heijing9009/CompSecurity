// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.xwalk.core.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package org.xwalk.core.internal:
//            XWalkNotificationServiceImpl, XWalkViewInternal

class this._cls0 extends BroadcastReceiver
{

    final XWalkNotificationServiceImpl this$0;

    public void onReceive(Context context, Intent intent)
    {
        XWalkNotificationServiceImpl.access$000(XWalkNotificationServiceImpl.this).onNewIntent(intent);
    }

    ()
    {
        this$0 = XWalkNotificationServiceImpl.this;
        super();
    }
}
