// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.entity.mime.content;

import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package cz.msebera.android.httpclient.entity.mime.content:
//            AbstractContentBody

public class ByteArrayBody extends AbstractContentBody
{

    private final byte data[];
    private final String filename;

    public ByteArrayBody(byte abyte0[], ContentType contenttype, String s)
    {
        super(contenttype);
        Args.notNull(abyte0, "byte[]");
        data = abyte0;
        filename = s;
    }

    public ByteArrayBody(byte abyte0[], String s)
    {
        this(abyte0, "application/octet-stream", s);
    }

    public ByteArrayBody(byte abyte0[], String s, String s1)
    {
        this(abyte0, ContentType.create(s), s1);
    }

    public String getCharset()
    {
        return null;
    }

    public long getContentLength()
    {
        return (long)data.length;
    }

    public String getFilename()
    {
        return filename;
    }

    public String getTransferEncoding()
    {
        return "binary";
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        outputstream.write(data);
    }
}
