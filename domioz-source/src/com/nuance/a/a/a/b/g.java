// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.a.a.a.b;

import android.os.Looper;

final class g
    implements Runnable
{

    g()
    {
    }

    public final void run()
    {
        Looper.myLooper().quit();
    }
}
