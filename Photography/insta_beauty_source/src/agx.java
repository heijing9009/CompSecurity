// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.animation.Animation;
import com.fotoable.fotoproedit.activity.ProEditFontActivity;

public class agx
    implements android.view.animation.Animation.AnimationListener
{

    final boolean a;
    final View b;
    final ProEditFontActivity c;

    public agx(ProEditFontActivity proeditfontactivity, boolean flag, View view)
    {
        c = proeditfontactivity;
        a = flag;
        b = view;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        if (a && b != null)
        {
            b.setVisibility(0);
            return;
        } else
        {
            b.setVisibility(4);
            return;
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
