// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            CharMatcher

static final class nit> extends CharMatcher
{

    public final volatile boolean apply(Object obj)
    {
        return super.apply((Character)obj);
    }

    public final boolean matches(char c)
    {
        return Character.isDigit(c);
    }

    (String s)
    {
        super(s);
    }
}
