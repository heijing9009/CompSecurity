// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.view.animation.Animation;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls1
    implements android.view.animation.ationListener
{

    final llScreen this$1;

    public void onAnimationEnd(Animation animation)
    {
        if (getRequestedOrientation() == 6 && SCREEN_STATE == 1)
        {
            setFullScreen();
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    tionListener()
    {
        this$1 = this._cls1.this;
        super();
    }
}
