// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;


// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GoodJobActivity

class a
    implements Runnable
{

    final GoodJobActivity a;

    public void run()
    {
        a.setResult(2);
        a.finish();
    }

    (GoodJobActivity goodjobactivity)
    {
        a = goodjobactivity;
        super();
    }
}
