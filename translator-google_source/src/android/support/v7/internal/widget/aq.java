// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v4.view.eh;
import android.support.v7.widget.Toolbar;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            ao

final class aq extends eh
{

    final ao a;
    private boolean b;

    aq(ao ao1)
    {
        a = ao1;
        super();
        b = false;
    }

    public final void b(View view)
    {
        if (!b)
        {
            a.a.setVisibility(8);
        }
    }

    public final void c(View view)
    {
        b = true;
    }
}
