// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.b;

import android.view.View;
import com.helpshift.HSMessagesFragment;
import com.helpshift.k.a;

// Referenced classes of package com.helpshift.b:
//            a

class t>
    implements android.view.OnClickListener
{

    final a a;
    final int b;
    final com.helpshift.b.a c;

    public void onClick(View view)
    {
        if (a.i.booleanValue())
        {
            com.helpshift.b.a.a(c).c(b);
        }
    }

    gesFragment(com.helpshift.b.a a1, a a2, int i)
    {
        c = a1;
        a = a2;
        b = i;
        super();
    }
}
