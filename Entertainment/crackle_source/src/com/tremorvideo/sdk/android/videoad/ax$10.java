// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;


// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ax, ab

class a
    implements a
{

    final ax a;

    public void a(int i, String s)
    {
        ab ab1;
        if (i == -1)
        {
            ax.a(a, true);
            return;
        }
        ab1 = new ab(a.b, a.d, , new ab.b() {

            final ax._cls10 a;

            public void a(boolean flag)
            {
                ax.a(a.a, true);
            }

            
            {
                a = ax._cls10.this;
                super();
            }
        });
        if (i != 0) goto _L2; else goto _L1
_L1:
        ab1.setTitle("Error");
        if (s.compareTo("") == 0)
        {
            ab1.a("There was an error sending your Tweet.");
        }
_L4:
        if (s.compareTo("") != 0)
        {
            ab1.a(s);
        }
        ab1.setCanceledOnTouchOutside(false);
        ab1.a("OK", "");
        ab1.show();
        return;
_L2:
        ab1.setTitle("Success");
        if (s.compareTo("") == 0)
        {
            ab1.a("Your tweet was sent successfully.");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    _cls1.a(ax ax1)
    {
        a = ax1;
        super();
    }
}
