// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;

// Referenced classes of package org.bouncycastle.jcajce.provider.symmetric:
//            RC6

public static class hmParameters extends IvAlgorithmParameters
{

    protected String engineToString()
    {
        return "RC6 IV";
    }

    public hmParameters()
    {
    }
}
