// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.os.AsyncTask;
import com.elokence.limuleapi.SessionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity

class this._cls0 extends AsyncTask
{

    final AkActivity this$0;

    protected transient Integer doInBackground(Void avoid[])
    {
        return Integer.valueOf(SessionFactory.sharedInstance().cancelSession());
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    ()
    {
        this$0 = AkActivity.this;
        super();
    }
}
