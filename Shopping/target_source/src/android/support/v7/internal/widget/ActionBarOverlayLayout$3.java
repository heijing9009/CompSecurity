// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v4.view.ai;
import android.support.v4.view.ba;

// Referenced classes of package android.support.v7.internal.widget:
//            ActionBarOverlayLayout, ActionBarContainer

class a
    implements Runnable
{

    final ActionBarOverlayLayout a;

    public void run()
    {
        ActionBarOverlayLayout.a(a);
        ActionBarOverlayLayout.a(a, ai.s(ActionBarOverlayLayout.c(a)).c(0.0F).a(ActionBarOverlayLayout.b(a)));
        if (ActionBarOverlayLayout.d(a) != null && ActionBarOverlayLayout.d(a).getVisibility() != 8)
        {
            ActionBarOverlayLayout.b(a, ai.s(ActionBarOverlayLayout.d(a)).c(0.0F).a(ActionBarOverlayLayout.e(a)));
        }
    }

    A(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        a = actionbaroverlaylayout;
        super();
    }
}
