// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.snapchat.android.ui;

import android.animation.Animator;
import android.widget.ImageView;

// Referenced classes of package com.snapchat.android.ui:
//            ProfilePictureView

public final class a
    implements android.animation.ener
{

    private ProfilePictureView a;

    public final void onAnimationCancel(Animator animator)
    {
    }

    public final void onAnimationEnd(Animator animator)
    {
        ProfilePictureView.e(a).setVisibility(4);
    }

    public final void onAnimationRepeat(Animator animator)
    {
    }

    public final void onAnimationStart(Animator animator)
    {
        ProfilePictureView.e(a).setVisibility(0);
    }

    public (ProfilePictureView profilepictureview)
    {
        a = profilepictureview;
        super();
    }
}
