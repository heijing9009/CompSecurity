// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.content.DialogInterface;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            MobileDataWarningState, VideoStateController

class this._cls0
    implements android.content.stener
{

    final MobileDataWarningState this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        stateController.setIgnoreMobileDataWarningSettingThisSession(true);
        stateController.transitionToState(MobileDataWarningState.access$000(MobileDataWarningState.this));
        dialoginterface.dismiss();
    }

    ()
    {
        this$0 = MobileDataWarningState.this;
        super();
    }
}
