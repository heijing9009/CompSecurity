// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.ui.development;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

// Referenced classes of package me.lyft.android.ui.development:
//            DeepLinksView

class val.target extends DebouncingOnClickListener
{

    final val.target this$0;
    final DeepLinksView val$target;

    public void doClick(View view)
    {
        val$target.performRoute();
    }

    ()
    {
        this$0 = final_;
        val$target = DeepLinksView.this;
        super();
    }
}
