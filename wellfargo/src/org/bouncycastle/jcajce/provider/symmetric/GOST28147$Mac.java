// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.crypto.macs.GOST28147Mac;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;

public class init> extends BaseMac
{

    public ()
    {
        super(new GOST28147Mac());
    }
}
