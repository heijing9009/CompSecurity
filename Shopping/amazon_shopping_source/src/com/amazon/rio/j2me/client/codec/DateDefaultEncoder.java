// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.Date;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class DateDefaultEncoder
    implements Encoder
{

    public DateDefaultEncoder()
    {
    }

    public void encode(Date date, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getIntegerInstance(1800L, 2055L).encode(new Integer(date.getYear()), dataoutputstream);
        DefaultEncoder.getIntegerInstance(1L, 12L).encode(new Integer(date.getMonth()), dataoutputstream);
        DefaultEncoder.getIntegerInstance(1L, 31L).encode(new Integer(date.getDay()), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((Date)obj, dataoutputstream);
    }
}
