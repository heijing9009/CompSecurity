// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;

final class iac
    implements Runnable
{

    private iaa a;

    iac(iaa iaa1)
    {
        a = iaa1;
        super();
    }

    public final void run()
    {
        View view = a.a.findViewById(p.aG);
        if (view != null)
        {
            view.setContentDescription(a.a.getString(b.yt));
        }
    }
}
