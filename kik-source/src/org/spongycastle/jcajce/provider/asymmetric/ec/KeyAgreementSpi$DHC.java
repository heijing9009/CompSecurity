// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ec;

import org.spongycastle.crypto.agreement.ECDHCBasicAgreement;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.ec:
//            KeyAgreementSpi

public static class t> extends KeyAgreementSpi
{

    public ()
    {
        super("ECDHC", new ECDHCBasicAgreement(), null);
    }
}
