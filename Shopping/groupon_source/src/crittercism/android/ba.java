// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import com.crittercism.app.CrittercismConfig;
import java.util.List;

public final class ba extends CrittercismConfig
{

    private String a;
    private String b;
    private String c;

    public ba()
    {
        a = "https://api.crittercism.com";
        b = "https://apm.crittercism.com";
        c = "524c99a04002057fcd000001";
    }

    public ba(CrittercismConfig crittercismconfig)
    {
        super(crittercismconfig);
        a = "https://api.crittercism.com";
        b = "https://apm.crittercism.com";
        c = "524c99a04002057fcd000001";
    }

    public final String a()
    {
        return a;
    }

    public final String b()
    {
        return b;
    }

    public final String c()
    {
        return c;
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof ba))
        {
            return false;
        }
        ba ba1 = (ba)obj;
        return super.equals(obj) && a(a, ba1.a) && a(b, ba1.b) && a(c, ba1.c);
    }

    public final List getOptmzBlackListURLPatterns()
    {
        List list = super.getOptmzBlackListURLPatterns();
        list.add(b);
        return list;
    }

    public final int hashCode()
    {
        return ((super.hashCode() * 31 + a.hashCode()) * 31 + b.hashCode()) * 31 + c.hashCode();
    }
}
