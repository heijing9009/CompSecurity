// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.entity.mime;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.a.c;
import org.apache.http.message.BasicHeader;

// Referenced classes of package org.apache.http.entity.mime:
//            HttpMultipartMode, c, a

public class f
    implements HttpEntity
{

    private static final char a[] = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final org.apache.http.entity.mime.c b;
    private final Header c;
    private long d;
    private volatile boolean e;

    public f()
    {
        this(HttpMultipartMode.STRICT, null, null);
    }

    public f(HttpMultipartMode httpmultipartmode)
    {
        this(httpmultipartmode, null, null);
    }

    public f(HttpMultipartMode httpmultipartmode, String s, Charset charset)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = a();
        }
        s = httpmultipartmode;
        if (httpmultipartmode == null)
        {
            s = HttpMultipartMode.STRICT;
        }
        b = new org.apache.http.entity.mime.c("form-data", charset, s1, s);
        c = new BasicHeader("Content-Type", a(s1, charset));
        e = true;
    }

    protected String a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Random random = new Random();
        int j = random.nextInt(11);
        for (int i = 0; i < j + 30; i++)
        {
            stringbuilder.append(a[random.nextInt(a.length)]);
        }

        return stringbuilder.toString();
    }

    protected String a(String s, Charset charset)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("multipart/form-data; boundary=");
        stringbuilder.append(s);
        if (charset != null)
        {
            stringbuilder.append("; charset=");
            stringbuilder.append(charset.name());
        }
        return stringbuilder.toString();
    }

    public void a(String s, c c1)
    {
        a(new a(s, c1));
    }

    public void a(a a1)
    {
        b.a(a1);
        e = true;
    }

    public void consumeContent()
        throws IOException, UnsupportedOperationException
    {
        if (isStreaming())
        {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        } else
        {
            return;
        }
    }

    public InputStream getContent()
        throws IOException, UnsupportedOperationException
    {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public Header getContentEncoding()
    {
        return null;
    }

    public long getContentLength()
    {
        if (e)
        {
            d = b.c();
            e = false;
        }
        return d;
    }

    public Header getContentType()
    {
        return c;
    }

    public boolean isChunked()
    {
        return !isRepeatable();
    }

    public boolean isRepeatable()
    {
        for (Iterator iterator = b.a().iterator(); iterator.hasNext();)
        {
            if (((a)iterator.next()).b().e() < 0L)
            {
                return false;
            }
        }

        return true;
    }

    public boolean isStreaming()
    {
        return !isRepeatable();
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        b.a(outputstream);
    }

}
