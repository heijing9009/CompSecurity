// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.activity.Login;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            LogInFragment

class this._cls0
    implements android.view.ener
{

    final LogInFragment this$0;

    public void onClick(View view)
    {
        facebook.startSpinning();
        logger.logClick("", "facebook_signin_click", com/groupon/activity/Login.getSimpleName(), "");
        fbSignUp();
    }

    r()
    {
        this$0 = LogInFragment.this;
        super();
    }
}
