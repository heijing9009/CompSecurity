// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.smule.android.f.p;
import com.smule.android.network.core.o;
import com.smule.android.network.managers.UserManager;

// Referenced classes of package com.smule.android.facebook:
//            a, b

class a
    implements com.facebook.equest.Callback
{

    final k a;

    public void onCompleted(GraphResponse graphresponse)
    {
    }

    .Editor(.Editor editor)
    {
        a = editor;
        super();
    }

    // Unreferenced inner class com/smule/android/facebook/a$4

/* anonymous class */
    class a._cls4
        implements Runnable
    {

        final boolean a;
        final b b;
        final a c;

        public void run()
        {
            SharedPreferences sharedpreferences;
            boolean flag1;
            boolean flag2;
            if (c.c())
            {
                flag1 = UserManager.n().q().a();
            } else
            {
                flag1 = false;
            }
            sharedpreferences = com.smule.android.facebook.a.a(c).getSharedPreferences("MagicFacebook", 0);
            p.a(sharedpreferences.edit().remove("access_token"));
            p.a(sharedpreferences.edit().remove("access_expires"));
            flag2 = flag1;
            if (a)
            {
                boolean flag;
                if (GraphRequest.newDeleteObjectRequest(c.b(), "me/permissions", new a._cls4._cls1(this)).executeAndWait().getError() == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                flag2 = flag1 & flag;
            }
            if (flag2)
            {
                if (c.c())
                {
                    LoginManager.getInstance().logOut();
                }
                c.a(false);
                com.smule.android.facebook.a.a(c, null);
            }
            b.a(flag2);
        }

            
            {
                c = a1;
                a = flag;
                b = b1;
                super();
            }
    }

}
