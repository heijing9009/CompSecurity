// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.PostEventsResponse;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, StreamedResponseListener

public class PostEventsResponseDefaultDecoder
    implements Decoder
{

    public PostEventsResponseDefaultDecoder()
    {
    }

    public PostEventsResponse decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return new PostEventsResponse();
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
