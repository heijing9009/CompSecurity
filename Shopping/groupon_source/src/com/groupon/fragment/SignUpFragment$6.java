// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.view.View;
import com.groupon.activity.IntentFactory;

// Referenced classes of package com.groupon.fragment:
//            SignUpFragment

class this._cls0
    implements android.view.ner
{

    final SignUpFragment this$0;

    public void onClick(View view)
    {
        getActivity().startActivity(SignUpFragment.access$400(SignUpFragment.this).newGrouponSupportWithoutIdIntent());
    }

    ()
    {
        this$0 = SignUpFragment.this;
        super();
    }
}
