// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kik.android.chat.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;

// Referenced classes of package kik.android.chat.activity:
//            KikIqActivityBase

final class ah
    implements android.content.DialogInterface.OnClickListener
{

    final AlertDialog a;
    final KikIqActivityBase b;

    ah(KikIqActivityBase kikiqactivitybase, AlertDialog alertdialog)
    {
        b = kikiqactivitybase;
        a = alertdialog;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        a.dismiss();
    }
}
