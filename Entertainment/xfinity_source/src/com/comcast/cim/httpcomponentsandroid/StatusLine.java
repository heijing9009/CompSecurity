// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid;


// Referenced classes of package com.comcast.cim.httpcomponentsandroid:
//            ProtocolVersion

public interface StatusLine
{

    public abstract ProtocolVersion getProtocolVersion();

    public abstract String getReasonPhrase();

    public abstract int getStatusCode();
}
