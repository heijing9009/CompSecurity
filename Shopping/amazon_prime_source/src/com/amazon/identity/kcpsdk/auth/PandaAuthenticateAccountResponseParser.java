// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            JsonWebResponseParser, PandaAuthenticateAccountResponseJsonParser

public class PandaAuthenticateAccountResponseParser extends JsonWebResponseParser
{

    public PandaAuthenticateAccountResponseParser()
    {
        super(com/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountResponseParser.getName(), new PandaAuthenticateAccountResponseJsonParser());
    }
}
