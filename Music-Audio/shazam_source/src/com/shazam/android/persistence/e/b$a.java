// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.e;


// Referenced classes of package com.shazam.android.persistence.e:
//            b

public static class on
    implements b
{

    public Object a()
    {
        throw new UnsupportedOperationException((new StringBuilder("loadConfig() not supported by ")).append(getClass().getName()).toString());
    }

    public void a(Object obj)
    {
        throw new UnsupportedOperationException((new StringBuilder("storeConfig(T config) not supported by ")).append(getClass().getName()).toString());
    }

    public on()
    {
    }
}
