// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.util.Log;

// Referenced classes of package com.google.android.gms.tagmanager:
//            u

final class bl
    implements u
{

    private int a;

    bl()
    {
        a = 5;
    }

    public final void a(String s)
    {
        if (a <= 6)
        {
            Log.e("GoogleTagManager", s);
        }
    }

    public final void a(String s, Throwable throwable)
    {
        if (a <= 6)
        {
            Log.e("GoogleTagManager", s, throwable);
        }
    }

    public final void b(String s)
    {
        if (a <= 5)
        {
            Log.w("GoogleTagManager", s);
        }
    }

    public final void c(String s)
    {
        if (a <= 4)
        {
            Log.i("GoogleTagManager", s);
        }
    }

    public final void d(String s)
    {
        if (a <= 2)
        {
            Log.v("GoogleTagManager", s);
        }
    }
}
