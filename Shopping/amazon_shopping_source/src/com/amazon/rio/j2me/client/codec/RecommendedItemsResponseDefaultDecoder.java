// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, StreamedResponseListener, SearchResultDefaultDecoder, 
//            CategoryResultDefaultDecoder

public class RecommendedItemsResponseDefaultDecoder
    implements Decoder
{
    final class _cls1ArrayResponseListener
        implements StreamedResponseListener
    {

        private final int path[];
        final RecommendedItemsResponseDefaultDecoder this$0;
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
            this$0 = RecommendedItemsResponseDefaultDecoder.this;
            fieldPath = ai;
            callback = streamedresponselistener;
            super();
            path = (new int[] {
                fieldPath[0], -1
            });
        }
    }


    public RecommendedItemsResponseDefaultDecoder()
    {
    }

    public Object decode(DataInputStream datainputstream, final StreamedResponseListener callback)
        throws IOException
    {
        final int fieldPath[] = new int[1];
        if (!datainputstream.readBoolean())
        {
            callback.receivedObject((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null), fieldPath);
        }
        fieldPath[0] = fieldPath[0] + 1;
        callback.receivedObject((List)DefaultDecoder.getArrayInstance(new SearchResultDefaultDecoder()).decode(datainputstream, new _cls1ArrayResponseListener()), fieldPath);
        fieldPath[0] = fieldPath[0] + 1;
        callback.receivedObject((List)DefaultDecoder.getArrayInstance(DefaultDecoder.getOctetArrayInstance()).decode(datainputstream, new _cls1ArrayResponseListener()), fieldPath);
        fieldPath[0] = fieldPath[0] + 1;
        if (!datainputstream.readBoolean())
        {
            callback.receivedObject((List)DefaultDecoder.getArrayInstance(new CategoryResultDefaultDecoder()).decode(datainputstream, new _cls1ArrayResponseListener()), fieldPath);
        }
        fieldPath[0] = fieldPath[0] + 1;
        if (!datainputstream.readBoolean())
        {
            callback.receivedObject((String)DefaultDecoder.getStringInstance().decode(datainputstream, null), fieldPath);
        }
        fieldPath[0] = fieldPath[0] + 1;
        callback.receivedObject(null, new int[0]);
        return null;
    }
}
