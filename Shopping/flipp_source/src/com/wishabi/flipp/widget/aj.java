// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;

// Referenced classes of package com.wishabi.flipp.widget:
//            af, ak

final class aj
    implements android.view.View.OnClickListener
{

    final af a;

    aj(af af1)
    {
        a = af1;
        super();
    }

    public final void onClick(View view)
    {
        if (af.a(a) == null)
        {
            return;
        } else
        {
            af.a(a).d();
            return;
        }
    }
}
