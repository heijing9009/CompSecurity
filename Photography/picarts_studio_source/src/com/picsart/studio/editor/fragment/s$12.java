// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.bumptech.glide.load.engine.GlideException;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.custommasks.Mask;
import com.picsart.studio.editor.custommasks.MaskStateHolder;
import com.picsart.studio.editor.custommasks.c;
import com.picsart.studio.editor.custommasks.d;
import com.picsart.studio.editor.custommasks.g;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            s

final class a
    implements g
{

    final s a;

    public final void a(Mask mask)
    {
        com.picsart.studio.editor.fragment.s.g(a);
        if (s.h(a).getVisibility() != 0)
        {
            s.h(a).setVisibility(0);
            ((SlidingDrawer)s.h(a).findViewById(0x7f10057c)).open();
        }
        Spinner spinner = (Spinner)s.i(a).findViewById(0x7f100709);
        spinner.setEnabled(true);
        SpinnerAdapter spinneradapter = spinner.getAdapter();
        com.picsart.studio.editor.custommasks.BlendMode blendmode = mask.a(false);
        int j = spinneradapter.getCount();
        int i;
        for (i = 0; i < j && spinneradapter.getItem(i) != blendmode; i++) { }
        spinner.setSelection(i);
        a.getView().findViewById(0x7f1006f9).setEnabled(true);
        s.a(a, mask);
        s.f(a).a = s.e(a).b.indexOf(mask);
        s.f(a).g = 0.0F;
        s.f(a).h = false;
        s.f(a).i = false;
        ((EditorActivity)a.getActivity()).d();
        (new AsyncTask(mask) {

            final s._cls12 a;
            private Mask b;

            protected final Object doInBackground(Object aobj[])
            {
                b.a(a.a.getActivity(), s.j(a.a).getWidth(), s.j(a.a).getHeight(), new c(this) {

                    final _cls1 a;

                    public final void a(GlideException glideexception)
                    {
                        s.a(a.a.a, glideexception);
                    }

                    public final void a(Mask mask)
                    {
                        if (!a.a.a.isAdded() || a.a.a.getActivity() == null)
                        {
                            return;
                        } else
                        {
                            a.a.a.getActivity().runOnUiThread(new Runnable(this, mask) {

                                private Mask a;
                                private _cls1 b;

                                public final void run()
                                {
                                    s.a(b.a.a.a, b.a.a.a.getActivity(), a);
                                    ((EditorActivity)b.a.a.a.getActivity()).e();
                                }

            
            {
                b = _pcls1;
                a = mask;
                super();
            }
                            });
                            return;
                        }
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
                return null;
            }

            
            {
                a = s._cls12.this;
                b = mask;
                super();
            }
        }).execute(new Void[0]);
    }

    _cls1.b(s s1)
    {
        a = s1;
        super();
    }
}
