// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package android.support.v4.widget:
//            DrawerLayout

public static final class gravity extends android.view.ms
{

    public int gravity;
    boolean isPeeking;
    boolean knownOpen;
    float onScreen;

    public _cls9()
    {
        super(-1, -1);
        gravity = 0;
    }

    public gravity(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        gravity = 0;
        context = context.obtainStyledAttributes(attributeset, DrawerLayout.access$100());
        gravity = context.getInt(0, 0);
        context.recycle();
    }

    public gravity(gravity gravity1)
    {
        super(gravity1);
        gravity = 0;
        gravity = gravity1.gravity;
    }

    public gravity(android.view.LayoutParams layoutparams)
    {
        super(layoutparams);
        gravity = 0;
    }

    public gravity(android.view.ms ms)
    {
        super(ms);
        gravity = 0;
    }
}
