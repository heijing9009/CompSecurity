// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;

public final class afh extends aep
{

    private final Activity b;
    private final bqe c;
    private final blu d;
    private final bov e;
    private final bxe f;

    public afh(Activity activity, bqe bqe1, blu blu1, bov bov1, bxe bxe1)
    {
        b = (Activity)b.a(activity);
        c = (bqe)b.a(bqe1);
        d = (blu)b.a(blu1);
        e = (bov)b.a(bov1);
        f = (bxe)b.a(bxe1);
    }

    public final bn a()
    {
        return (afe)super.a();
    }

    protected final bn b()
    {
        return new afe(b, c, d, e, f);
    }

    protected final bn b(View view)
    {
        Activity activity = b;
        bqe bqe1 = c;
        blu blu1 = d;
        return new afe(activity, view, bqe1, e, f);
    }

    protected final int c()
    {
        return 15;
    }

    public final afe d()
    {
        return (afe)super.a();
    }
}
