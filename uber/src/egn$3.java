// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ang.Object
    implements hst
{

    final ego a;
    final egn b;

    private dqt b()
    {
        dqt dqt = ego.a(a).aM();
        if (dqt == null)
        {
            throw new NullPointerException("Cannot return null from a non-@Nullable component method");
        } else
        {
            return dqt;
        }
    }

    public final Object a()
    {
        return b();
    }

    (egn egn1, ego ego1)
    {
        b = egn1;
        a = ego1;
        super();
    }
}
