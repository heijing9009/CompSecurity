// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Iterator;

// Referenced classes of package android.support.v7:
//            ay, au

final class b
    implements Iterator, java.util.ntry
{

    int a;
    int b;
    boolean c;
    final ay d;

    public java.util.ntry a()
    {
        b = b + 1;
        c = true;
        return this;
    }

    public final boolean equals(Object obj)
    {
        boolean flag = true;
        if (!c)
        {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof java.util.ntry))
        {
            return false;
        }
        obj = (java.util.ntry)obj;
        if (!au.a(((java.util.ntry) (obj)).getKey(), d.a(b, 0)) || !au.a(((java.util.ntry) (obj)).getValue(), d.a(b, 1)))
        {
            flag = false;
        }
        return flag;
    }

    public Object getKey()
    {
        if (!c)
        {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else
        {
            return d.a(b, 0);
        }
    }

    public Object getValue()
    {
        if (!c)
        {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else
        {
            return d.a(b, 1);
        }
    }

    public boolean hasNext()
    {
        return b < a;
    }

    public final int hashCode()
    {
        int j = 0;
        if (!c)
        {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        Object obj = d.a(b, 0);
        Object obj1 = d.a(b, 1);
        int i;
        if (obj == null)
        {
            i = 0;
        } else
        {
            i = obj.hashCode();
        }
        if (obj1 != null)
        {
            j = obj1.hashCode();
        }
        return j ^ i;
    }

    public Object next()
    {
        return a();
    }

    public void remove()
    {
        if (!c)
        {
            throw new IllegalStateException();
        } else
        {
            d.a(b);
            b = b - 1;
            a = a - 1;
            c = false;
            return;
        }
    }

    public Object setValue(Object obj)
    {
        if (!c)
        {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else
        {
            return d.a(b, obj);
        }
    }

    public final String toString()
    {
        return (new StringBuilder()).append(getKey()).append("=").append(getValue()).toString();
    }

    ception(ay ay1)
    {
        d = ay1;
        super();
        c = false;
        a = ay1.a() - 1;
        b = -1;
    }
}
