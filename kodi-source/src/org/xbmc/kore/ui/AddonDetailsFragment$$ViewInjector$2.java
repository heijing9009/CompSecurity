// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.xbmc.kore.ui;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

// Referenced classes of package org.xbmc.kore.ui:
//            AddonDetailsFragment

class val.target extends DebouncingOnClickListener
{

    final  this$0;
    final AddonDetailsFragment val$target;

    public void doClick(View view)
    {
        val$target.onEnabledClicked(view);
    }

    ()
    {
        this$0 = final_;
        val$target = AddonDetailsFragment.this;
        super();
    }
}
