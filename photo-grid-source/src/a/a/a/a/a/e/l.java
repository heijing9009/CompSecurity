// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a.a.a.a.e;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

// Referenced classes of package a.a.a.a.a.e:
//            e

public final class l extends BufferedOutputStream
{

    private final CharsetEncoder a;

    public l(OutputStream outputstream, String s, int i)
    {
        super(outputstream, i);
        a = Charset.forName(e.b(s)).newEncoder();
    }

    public final l a(String s)
    {
        s = a.encode(CharBuffer.wrap(s));
        super.write(s.array(), 0, s.limit());
        return this;
    }
}
