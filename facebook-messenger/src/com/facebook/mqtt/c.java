// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.mqtt;


// Referenced classes of package com.facebook.mqtt:
//            b

class c
    implements Runnable
{

    final b a;

    c(b b1)
    {
        a = b1;
        super();
    }

    public void run()
    {
        b.a(a);
    }
}
