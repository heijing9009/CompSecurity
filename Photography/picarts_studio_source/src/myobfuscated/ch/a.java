// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.photo.effect.EffectParameter;
import java.util.ArrayList;
import myobfuscated.cg.b;
import myobfuscated.cg.c;
import myobfuscated.cg.g;
import myobfuscated.f.m;

public final class a extends c
{

    private boolean i;

    public a(Context context, ArrayList arraylist)
    {
        super(context, arraylist);
        i = true;
    }

    static b a(a a1)
    {
        return a1.c;
    }

    static boolean a(a a1, boolean flag)
    {
        a1.i = flag;
        return flag;
    }

    static boolean b(a a1)
    {
        return a1.i;
    }

    static b c(a a1)
    {
        return a1.c;
    }

    public final View a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(1, 0, 0, 0);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0300d1, null);
        m.a(a, linearlayout, layoutparams);
        layoutparams = new g();
        layoutparams.a = (SeekBar)linearlayout.findViewById(0x7f10043c);
        layoutparams.b = (TextView)linearlayout.findViewById(0x7f10043a);
        layoutparams.c = (TextView)linearlayout.findViewById(0x7f10043b);
        layoutparams.d = EffectParameter.a(b, "Radius");
        d.add(layoutparams);
        layoutparams = (CheckBox)linearlayout.findViewById(0x7f100434);
        layoutparams.setOnCheckedChangeListener(null);
        layoutparams.setChecked(i);
        layoutparams.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            private a a;

            public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                a.a(a, flag);
                if (a.a(a) != null)
                {
                    myobfuscated.ch.a.c(a).b(myobfuscated.ch.a.b(a));
                }
            }

            
            {
                a = a.this;
                super();
            }
        });
        b();
        return linearlayout;
    }

    public final boolean a()
    {
        return i;
    }
}
