// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.jce.provider.symmetric;

import java.util.HashMap;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.XTEAEngine;
import org.bouncycastle.jce.provider.JCEBlockCipher;
import org.bouncycastle.jce.provider.JCEKeyGenerator;

public final class XTEA
{
    public static class AlgParams extends org.bouncycastle.jce.provider.JDKAlgorithmParameters.IVAlgorithmParameters
    {

        protected String engineToString()
        {
            return "XTEA IV";
        }

        public AlgParams()
        {
        }
    }

    public static class ECB extends JCEBlockCipher
    {

        public ECB()
        {
            super(new XTEAEngine());
        }
    }

    public static class KeyGen extends JCEKeyGenerator
    {

        public KeyGen()
        {
            super("XTEA", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends HashMap
    {

        public Mappings()
        {
            put("Cipher.XTEA", "org.bouncycastle.jce.provider.symmetric.XTEA$ECB");
            put("KeyGenerator.XTEA", "org.bouncycastle.jce.provider.symmetric.XTEA$KeyGen");
            put("AlgorithmParameters.XTEA", "org.bouncycastle.jce.provider.symmetric.XTEA$AlgParams");
        }
    }


    private XTEA()
    {
    }
}
