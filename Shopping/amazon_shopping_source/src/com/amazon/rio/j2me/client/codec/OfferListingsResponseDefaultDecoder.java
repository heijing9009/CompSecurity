// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, PrimeOneClickStatusDefaultDecoder, StreamedResponseListener, OfferListingDefaultDecoder, 
//            DefaultDecoder

public class OfferListingsResponseDefaultDecoder
    implements Decoder
{
    final class _cls1ArrayResponseListener
        implements StreamedResponseListener
    {

        private final int path[];
        final OfferListingsResponseDefaultDecoder this$0;
        final StreamedResponseListener val$callback;
        final int val$fieldPath[];

        public void aboutToReceiveArrayOfSize(int i, int ai[])
        {
            callback.aboutToReceiveArrayOfSize(i, fieldPath);
        }

        public void receivedObject(Object obj, int ai[])
        {
            if (ai.length > 0)
            {
                path[1] = ai[0];
                callback.receivedObject(obj, path);
            }
        }

        _cls1ArrayResponseListener()
        {
            this$0 = OfferListingsResponseDefaultDecoder.this;
            fieldPath = ai;
            callback = streamedresponselistener;
            super();
            path = (new int[] {
                fieldPath[0], -1
            });
        }
    }


    public OfferListingsResponseDefaultDecoder()
    {
    }

    public Object decode(DataInputStream datainputstream, final StreamedResponseListener callback)
        throws IOException
    {
        final int fieldPath[] = new int[1];
        callback.receivedObject((new PrimeOneClickStatusDefaultDecoder()).decode(datainputstream, null), fieldPath);
        fieldPath[0] = fieldPath[0] + 1;
        callback.receivedObject((List)DefaultDecoder.getArrayInstance(new OfferListingDefaultDecoder()).decode(datainputstream, new _cls1ArrayResponseListener()), fieldPath);
        fieldPath[0] = fieldPath[0] + 1;
        callback.receivedObject(null, new int[0]);
        return null;
    }
}
