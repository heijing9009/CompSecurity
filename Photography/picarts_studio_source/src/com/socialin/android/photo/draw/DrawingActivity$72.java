// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.animation.Animator;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements android.animation.stener
{

    private DrawingActivity a;

    public final void onAnimationCancel(Animator animator)
    {
        onAnimationEnd(animator);
    }

    public final void onAnimationEnd(Animator animator)
    {
        DrawingActivity.a(a, erPanelState.CLOSED);
    }

    public final void onAnimationRepeat(Animator animator)
    {
    }

    public final void onAnimationStart(Animator animator)
    {
    }

    erPanelState(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
