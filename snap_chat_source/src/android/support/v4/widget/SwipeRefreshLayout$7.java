// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package android.support.v4.widget:
//            SwipeRefreshLayout

final class a extends Animation
{

    private SwipeRefreshLayout a;

    public final void applyTransformation(float f, Transformation transformation)
    {
        SwipeRefreshLayout.b(a, f);
    }

    (SwipeRefreshLayout swiperefreshlayout)
    {
        a = swiperefreshlayout;
        super();
    }
}
