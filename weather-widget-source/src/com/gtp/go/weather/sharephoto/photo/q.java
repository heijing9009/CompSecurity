// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gtp.go.weather.sharephoto.photo;

import android.view.animation.Animation;
import android.widget.TextView;

// Referenced classes of package com.gtp.go.weather.sharephoto.photo:
//            PhotoActivity

class q
    implements android.view.animation.Animation.AnimationListener
{

    final PhotoActivity a;

    q(PhotoActivity photoactivity)
    {
        a = photoactivity;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        PhotoActivity.r(a).setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
