// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class aad extends Exception
{

    private final int a;

    public aad(String s, int i)
    {
        super(s);
        a = i;
    }

    public int a()
    {
        return a;
    }
}
