// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package rx;


// Referenced classes of package rx:
//            a

public static final class ng.String extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static ng.String valueOf(String s)
    {
        return ()Enum.valueOf(rx/a$a, s);
    }

    public static ng.String[] values()
    {
        return (ng[])d.clone();
    }

    static 
    {
        a = new <init>("OnNext", 0);
        b = new <init>("OnError", 1);
        c = new <init>("OnCompleted", 2);
        d = (new d[] {
            a, b, c
        });
    }

    private ng.String(String s, int i)
    {
        super(s, i);
    }
}
