// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class fkt
{

    private dff a;
    private dfe b;
    private dph c;
    private dfp d;

    private fkt()
    {
    }

    fkt(byte byte0)
    {
        this();
    }

    static dfp a(fkt fkt1)
    {
        return fkt1.d;
    }

    static dff b(fkt fkt1)
    {
        return fkt1.a;
    }

    static dfe c(fkt fkt1)
    {
        return fkt1.b;
    }

    static dph d(fkt fkt1)
    {
        return fkt1.c;
    }

    public final fkt a(dfe dfe)
    {
        b = dfe;
        return this;
    }

    public final fkt a(dfp dfp)
    {
        if (dfp == null)
        {
            throw new NullPointerException("riderApplicationComponent");
        } else
        {
            d = dfp;
            return this;
        }
    }

    public final fmf a()
    {
        if (a == null)
        {
            a = new dff();
        }
        if (b == null)
        {
            throw new IllegalStateException("riderActivityModule must be set");
        }
        if (c == null)
        {
            c = new dph();
        }
        if (d == null)
        {
            throw new IllegalStateException("riderApplicationComponent must be set");
        } else
        {
            return new fks(this, (byte)0);
        }
    }
}
