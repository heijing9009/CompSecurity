// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.android.gms.ads.internal.d;
import com.google.android.gms.internal.u;
import com.google.android.gms.internal.v;

public final class b
{

    public static void a(String s)
    {
        if (a(3))
        {
            Log.d("Ads", s);
        }
    }

    public static void a(String s, Throwable throwable)
    {
        if (a(3))
        {
            Log.d("Ads", s, throwable);
        }
    }

    public static boolean a(int i)
    {
label0:
        {
            if (i < 5 && !Log.isLoggable("Ads", i))
            {
                break label0;
            }
            if (i == 2)
            {
                com.google.android.gms.internal.r r = v.ab;
                if (!((Boolean)com.google.android.gms.ads.internal.d.i().a(r)).booleanValue())
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    public static void b(String s)
    {
        if (a(6))
        {
            Log.e("Ads", s);
        }
    }

    public static void b(String s, Throwable throwable)
    {
        if (a(6))
        {
            Log.e("Ads", s, throwable);
        }
    }

    public static void c(String s)
    {
        if (a(4))
        {
            Log.i("Ads", s);
        }
    }

    public static void c(String s, Throwable throwable)
    {
        if (a(5))
        {
            Log.w("Ads", s, throwable);
        }
    }

    public static void d(String s)
    {
        if (a(2))
        {
            Log.v("Ads", s);
        }
    }

    public static void e(String s)
    {
        if (a(5))
        {
            Log.w("Ads", s);
        }
    }
}
