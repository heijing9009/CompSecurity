// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uservoice.uservoicesdk.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public abstract class DialogFragmentBugfixed extends DialogFragment
{

    public DialogFragmentBugfixed()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setRetainInstance(true);
    }

    public void onDestroyView()
    {
        if (getDialog() != null && getRetainInstance())
        {
            getDialog().setOnDismissListener(null);
        }
        super.onDestroyView();
    }
}
