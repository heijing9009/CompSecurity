// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.app;

import android.content.DialogInterface;

// Referenced classes of package com.ebay.app:
//            AlertDialogFragment, DialogFragmentCallback

class this._cls0
    implements android.content.kListener
{

    final AlertDialogFragment this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (getTargetFragment() == null || !(getTargetFragment() instanceof DialogFragmentCallback)) goto _L2; else goto _L1
_L1:
        ((DialogFragmentCallback)getTargetFragment()).onDialogFragmentResult(AlertDialogFragment.this, getTargetRequestCode(), 1);
_L4:
        dialoginterface.dismiss();
        return;
_L2:
        if (getActivity() instanceof DialogFragmentCallback)
        {
            ((DialogFragmentCallback)getActivity()).onDialogFragmentResult(AlertDialogFragment.this, getTargetRequestCode(), 1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ()
    {
        this$0 = AlertDialogFragment.this;
        super();
    }
}
