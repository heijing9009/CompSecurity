// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKFeatures;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.q;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            g, BeautyToolPanel

class a
    implements android.view..OnClickListener
{

    final g a;

    public void onClick(View view)
    {
        if (a.o)
        {
            return;
        } else
        {
            view.setClickable(false);
            view = new Runnable(new ch(view) {

                final View a;
                final g._cls1 b;

                public void onAnimationEnd(Animator animator)
                {
                    a.setClickable(true);
                }

            
            {
                b = g._cls1.this;
                a = view;
                super();
            }
            }) {

                final ch a;
                final g._cls1 b;

                public void run()
                {
                    Object obj = null;
                    if (b.a.f != null)
                    {
                        obj = h.b().a(b.a.f.b(), b.a.f.a()).d();
                    }
                    com.cyberlink.youcammakeup.clflurry.b.a(new q(((String) (obj)), YMKFeatures.a(StatusManager.j().s())));
                    obj = b.a.m;
                    boolean flag;
                    if (b.a.m.q() != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    ((BeautyToolPanel) (obj)).a(flag, a);
                }

            
            {
                b = g._cls1.this;
                a = ch;
                super();
            }
            };
            a.h.post(view);
            return;
        }
    }

    _cls2.a(g g1)
    {
        a = g1;
        super();
    }
}
