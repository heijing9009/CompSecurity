// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;

// Referenced classes of package com.google.android.gms.internal:
//            cy

static final class jd
    implements android.content.gInterface.OnClickListener
{

    final JsResult jd;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        jd.cancel();
    }

    ckListener(JsResult jsresult)
    {
        jd = jsresult;
        super();
    }
}
