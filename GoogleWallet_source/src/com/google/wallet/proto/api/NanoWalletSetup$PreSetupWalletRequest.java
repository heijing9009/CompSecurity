// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.wallet.proto.api;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

// Referenced classes of package com.google.wallet.proto.api:
//            NanoWalletSetup

public static final class clear extends ExtendableMessageNano
{

    public com.google.wallet.proto.est.walletContext deviceContext;
    public com.google.wallet.proto.est.walletContext walletContext;

    private clear clear()
    {
        deviceContext = null;
        walletContext = null;
        unknownFieldData = null;
        cachedSize = -1;
        return this;
    }

    private cachedSize mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
        throws IOException
    {
        do
        {
            int i = codedinputbytebuffernano.readTag();
            switch (i)
            {
            default:
                if (storeUnknownField(codedinputbytebuffernano, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                if (deviceContext == null)
                {
                    deviceContext = new com.google.wallet.proto.est.deviceContext();
                }
                codedinputbytebuffernano.readMessage(deviceContext);
                break;

            case 18: // '\022'
                if (walletContext == null)
                {
                    walletContext = new com.google.wallet.proto.est.walletContext();
                }
                codedinputbytebuffernano.readMessage(walletContext);
                break;
            }
        } while (true);
    }

    protected final int computeSerializedSize()
    {
        int j = super.computeSerializedSize();
        int i = j;
        if (deviceContext != null)
        {
            i = j + CodedOutputByteBufferNano.computeMessageSize(1, deviceContext);
        }
        j = i;
        if (walletContext != null)
        {
            j = i + CodedOutputByteBufferNano.computeMessageSize(2, walletContext);
        }
        return j;
    }

    public final volatile MessageNano mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
        throws IOException
    {
        return mergeFrom(codedinputbytebuffernano);
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if (deviceContext != null)
        {
            codedoutputbytebuffernano.writeMessage(1, deviceContext);
        }
        if (walletContext != null)
        {
            codedoutputbytebuffernano.writeMessage(2, walletContext);
        }
        super.writeTo(codedoutputbytebuffernano);
    }

    public ()
    {
        clear();
    }
}
