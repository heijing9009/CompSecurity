// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

// Referenced classes of package com.facebook.login.widget:
//            f

private final class on_xout extends FrameLayout
{

    final f a;
    private ImageView b;
    private ImageView c;
    private View d;
    private ImageView e;

    static View a(on_xout on_xout)
    {
        return on_xout.d;
    }

    static ImageView b(d d1)
    {
        return d1.c;
    }

    static ImageView c(c c1)
    {
        return c1.b;
    }

    static ImageView d(b b1)
    {
        return b1.e;
    }

    public final void a()
    {
        b.setVisibility(0);
        c.setVisibility(4);
    }

    public final void b()
    {
        b.setVisibility(4);
        c.setVisibility(0);
    }

    public (f f1, Context context)
    {
        a = f1;
        super(context);
        LayoutInflater.from(getContext()).inflate(com.facebook.com_facebook_tooltip_bubble, this);
        b = (ImageView)findViewById(com.facebook.com_facebook_tooltip_bubble_view_top_pointer);
        c = (ImageView)findViewById(com.facebook.com_facebook_tooltip_bubble_view_bottom_pointer);
        d = findViewById(com.facebook.com_facebook_body_frame);
        e = (ImageView)findViewById(com.facebook.com_facebook_button_xout);
    }
}
