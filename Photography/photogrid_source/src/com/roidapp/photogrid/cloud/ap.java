// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.roidapp.photogrid.cloud;

import android.widget.CheckBox;
import android.widget.CompoundButton;

// Referenced classes of package com.roidapp.photogrid.cloud:
//            PGShareActivity

final class ap
    implements android.widget.CompoundButton.OnCheckedChangeListener
{

    final PGShareActivity a;

    ap(PGShareActivity pgshareactivity)
    {
        a = pgshareactivity;
        super();
    }

    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (!compoundbutton.isPressed())
        {
            return;
        }
        compoundbutton = compoundbutton.getText().toString();
        if (flag)
        {
            a.a(compoundbutton, false);
            PGShareActivity.d(a).setTextColor(-1);
            return;
        } else
        {
            a.a(compoundbutton, true);
            PGShareActivity.d(a).setTextColor(PGShareActivity.e(a));
            return;
        }
    }
}
