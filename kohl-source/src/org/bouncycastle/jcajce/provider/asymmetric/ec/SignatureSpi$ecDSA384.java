// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.jcajce.provider.asymmetric.ec;

import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.signers.ECDSASigner;

// Referenced classes of package org.bouncycastle.jcajce.provider.asymmetric.ec:
//            SignatureSpi

public static class oder extends SignatureSpi
{

    public oder()
    {
        super(new SHA384Digest(), new ECDSASigner(), new oder(null));
    }
}
