// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ad

class a
    implements android.view.OnClickListener
{

    final ad a;

    public void onClick(View view)
    {
        view = a;
        byte byte0;
        if (ad.a(a))
        {
            byte0 = 4;
        } else
        {
            byte0 = 3;
        }
        view.setResult(byte0);
        a.finish();
    }

    (ad ad1)
    {
        a = ad1;
        super();
    }
}
