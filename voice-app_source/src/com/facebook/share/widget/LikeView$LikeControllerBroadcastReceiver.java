// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;

// Referenced classes of package com.facebook.share.widget:
//            LikeView

private class <init> extends BroadcastReceiver
{

    final LikeView this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        intent = intent.getExtras();
        boolean flag = true;
        if (intent != null)
        {
            String s = intent.getString("com.facebook.sdk.LikeActionController.OBJECT_ID");
            if (!Utility.isNullOrEmpty(s) && !Utility.areObjectsEqual(LikeView.access$0(LikeView.this), s))
            {
                flag = false;
            } else
            {
                flag = true;
            }
        }
        if (flag) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ("com.facebook.sdk.LikeActionController.UPDATED".equals(context))
        {
            LikeView.access$1(LikeView.this);
            return;
        }
        if (!"com.facebook.sdk.LikeActionController.DID_ERROR".equals(context))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (LikeView.access$2(LikeView.this) == null) goto _L1; else goto _L3
_L3:
        LikeView.access$2(LikeView.this)._mth0(NativeProtocol.getExceptionFromErrorData(intent));
        return;
        if (!"com.facebook.sdk.LikeActionController.DID_RESET".equals(context)) goto _L1; else goto _L4
_L4:
        LikeView.access$4(LikeView.this, LikeView.access$0(LikeView.this), LikeView.access$3(LikeView.this));
        LikeView.access$1(LikeView.this);
        return;
    }

    private ()
    {
        this$0 = LikeView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
