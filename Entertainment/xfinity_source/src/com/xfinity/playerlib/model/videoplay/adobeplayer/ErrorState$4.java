// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;


// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            ErrorState, VideoStateController

class this._cls0
    implements com.comcast.cim.android.view.common.ment.TryAgainListener
{

    final ErrorState this$0;

    public void tryAgain()
    {
        ErrorState.access$200(ErrorState.this).transitionToState(ErrorState.access$300(ErrorState.this));
    }

    troller()
    {
        this$0 = ErrorState.this;
        super();
    }
}
