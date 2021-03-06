// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

// Referenced classes of package okio:
//            Source, Okio, InflaterSource, BufferedSource, 
//            Buffer, Segment, Timeout

public final class GzipSource
    implements Source
{

    private static final byte FCOMMENT = 4;
    private static final byte FEXTRA = 2;
    private static final byte FHCRC = 1;
    private static final byte FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;
    private final CRC32 crc = new CRC32();
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private int section;
    private final BufferedSource source;

    public GzipSource(Source source1)
    {
        section = 0;
        if (source1 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            inflater = new Inflater(true);
            source = Okio.buffer(source1);
            inflaterSource = new InflaterSource(source, inflater);
            return;
        }
    }

    private void checkEqual(String s, int i, int j)
    {
        if (j != i)
        {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[] {
                s, Integer.valueOf(j), Integer.valueOf(i)
            }));
        } else
        {
            return;
        }
    }

    private void consumeHeader()
    {
        source.require(10L);
        byte byte0 = source.buffer().getByte(3L);
        boolean flag;
        if ((byte0 >> 1 & 1) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            updateCrc(source.buffer(), 0L, 10L);
        }
        checkEqual("ID1ID2", 8075, source.readShort());
        source.skip(8L);
        if ((byte0 >> 2 & 1) == 1)
        {
            source.require(2L);
            if (flag)
            {
                updateCrc(source.buffer(), 0L, 2L);
            }
            int i = source.buffer().readShortLe();
            source.require(i);
            if (flag)
            {
                updateCrc(source.buffer(), 0L, i);
            }
            source.skip(i);
        }
        if ((byte0 >> 3 & 1) == 1)
        {
            long l = source.indexOf((byte)0);
            if (l == -1L)
            {
                throw new EOFException();
            }
            if (flag)
            {
                updateCrc(source.buffer(), 0L, 1L + l);
            }
            source.skip(1L + l);
        }
        if ((byte0 >> 4 & 1) == 1)
        {
            long l1 = source.indexOf((byte)0);
            if (l1 == -1L)
            {
                throw new EOFException();
            }
            if (flag)
            {
                updateCrc(source.buffer(), 0L, 1L + l1);
            }
            source.skip(1L + l1);
        }
        if (flag)
        {
            checkEqual("FHCRC", source.readShortLe(), (short)(int)crc.getValue());
            crc.reset();
        }
    }

    private void consumeTrailer()
    {
        checkEqual("CRC", source.readIntLe(), (int)crc.getValue());
        checkEqual("ISIZE", source.readIntLe(), inflater.getTotalOut());
    }

    private void updateCrc(Buffer buffer, long l, long l1)
    {
        buffer = buffer.head;
        Object obj;
        long l2;
        long l3;
        do
        {
            obj = buffer;
            l2 = l;
            l3 = l1;
            if (l < (long)(((Segment) (buffer)).limit - ((Segment) (buffer)).pos))
            {
                break;
            }
            l -= ((Segment) (buffer)).limit - ((Segment) (buffer)).pos;
            buffer = ((Segment) (buffer)).next;
        } while (true);
        while (l3 > 0L) 
        {
            int i = (int)((long)((Segment) (obj)).pos + l2);
            int j = (int)Math.min(((Segment) (obj)).limit - i, l3);
            crc.update(((Segment) (obj)).data, i, j);
            l3 -= j;
            obj = ((Segment) (obj)).next;
            l2 = 0L;
        }
    }

    public void close()
    {
        inflaterSource.close();
    }

    public long read(Buffer buffer, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
        }
        if (l == 0L)
        {
            return 0L;
        }
        if (section == 0)
        {
            consumeHeader();
            section = 1;
        }
        if (section == 1)
        {
            long l1 = buffer.size;
            l = inflaterSource.read(buffer, l);
            if (l != -1L)
            {
                updateCrc(buffer, l1, l);
                return l;
            }
            section = 2;
        }
        if (section == 2)
        {
            consumeTrailer();
            section = 3;
            if (!source.exhausted())
            {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    public Timeout timeout()
    {
        return source.timeout();
    }
}
