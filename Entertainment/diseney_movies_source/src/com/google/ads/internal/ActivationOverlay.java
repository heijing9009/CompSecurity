// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.os.Handler;
import com.google.ads.AdView;
import com.google.ads.m;
import com.google.ads.n;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;

// Referenced classes of package com.google.ads.internal:
//            AdWebView, d, a, i

public class ActivationOverlay extends AdWebView
{

    private volatile boolean b;
    private boolean c;
    private int d;
    private int e;
    private final i f;

    public ActivationOverlay(n n1)
    {
        super(n1, null);
        b = true;
        c = true;
        d = 0;
        e = 0;
        com.google.ads.m.a a1 = (com.google.ads.m.a)((m)n1.d.a()).b.a();
        if (AdUtil.a < ((Integer)a1.c.a()).intValue())
        {
            com.google.ads.util.b.a("Disabling hardware acceleration for an activation overlay.");
            g();
        }
        f = i.a((d)n1.b.a(), a.c, true, true);
        setWebViewClient(f);
    }

    public boolean a()
    {
        return b;
    }

    public boolean b()
    {
        return c;
    }

    public int c()
    {
        return e;
    }

    public boolean canScrollHorizontally(int j)
    {
        return false;
    }

    public boolean canScrollVertically(int j)
    {
        return false;
    }

    public int d()
    {
        return d;
    }

    public i e()
    {
        return f;
    }

    public void setOverlayActivated(boolean flag)
    {
        c = flag;
    }

    public void setOverlayEnabled(boolean flag)
    {
        if (!flag)
        {
            ((Handler)m.a().c.a()).post(new Runnable(this) {

                final ActivationOverlay a;
                final ActivationOverlay b;

                public void run()
                {
                    ((AdView)b.a.j.a()).removeView(a);
                }

            
            {
                b = ActivationOverlay.this;
                a = activationoverlay1;
                super();
            }
            });
        }
        b = flag;
    }

    public void setXPosition(int j)
    {
        d = j;
    }

    public void setYPosition(int j)
    {
        e = j;
    }
}
