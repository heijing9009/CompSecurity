// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TProtocolFactory, TJSONProtocol, TProtocol

public static class 
    implements TProtocolFactory
{

    public TProtocol getProtocol(TTransport ttransport)
    {
        return new TJSONProtocol(ttransport);
    }

    public ()
    {
    }
}
