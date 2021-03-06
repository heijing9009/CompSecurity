// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package okio;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package okio:
//            BufferedSink, BufferedSource, Segment, Util, 
//            SegmentPool, ByteString, Timeout, Source

public final class Buffer
    implements Cloneable, BufferedSink, BufferedSource
{

    private static final byte DIGITS[] = {
        48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
        97, 98, 99, 100, 101, 102
    };
    Segment head;
    long size;

    public Buffer()
    {
    }

    public Buffer buffer()
    {
        return this;
    }

    public void clear()
    {
        try
        {
            skip(size);
            return;
        }
        catch (EOFException eofexception)
        {
            throw new AssertionError(eofexception);
        }
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public Buffer clone()
    {
        Buffer buffer1 = new Buffer();
        if (size == 0L)
        {
            return buffer1;
        }
        buffer1.head = new Segment(head);
        Segment segment = buffer1.head;
        Segment segment2 = buffer1.head;
        Segment segment3 = buffer1.head;
        segment2.prev = segment3;
        segment.next = segment3;
        for (Segment segment1 = head.next; segment1 != head; segment1 = segment1.next)
        {
            buffer1.head.prev.push(new Segment(segment1));
        }

        buffer1.size = size;
        return buffer1;
    }

    public void close()
    {
    }

    public long completeSegmentByteCount()
    {
        long l1 = size;
        if (l1 == 0L)
        {
            return 0L;
        }
        Segment segment = head.prev;
        long l = l1;
        if (segment.limit < 2048)
        {
            l = l1;
            if (segment.owner)
            {
                l = l1 - (long)(segment.limit - segment.pos);
            }
        }
        return l;
    }

    public Buffer copyTo(Buffer buffer1, long l, long l1)
    {
        if (buffer1 == null)
        {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(size, l, l1);
        if (l1 != 0L)
        {
            buffer1.size = buffer1.size + l1;
            Segment segment = head;
            Segment segment2;
            long l2;
            long l3;
            do
            {
                segment2 = segment;
                l2 = l;
                l3 = l1;
                if (l < (long)(segment.limit - segment.pos))
                {
                    break;
                }
                l -= segment.limit - segment.pos;
                segment = segment.next;
            } while (true);
            while (l3 > 0L) 
            {
                Segment segment1 = new Segment(segment2);
                segment1.pos = (int)((long)segment1.pos + l2);
                segment1.limit = Math.min(segment1.pos + (int)l3, segment1.limit);
                if (buffer1.head == null)
                {
                    segment1.prev = segment1;
                    segment1.next = segment1;
                    buffer1.head = segment1;
                } else
                {
                    buffer1.head.prev.push(segment1);
                }
                l3 -= segment1.limit - segment1.pos;
                l2 = 0L;
                segment2 = segment2.next;
            }
        }
        return this;
    }

    public BufferedSink emit()
    {
        return this;
    }

    public Buffer emitCompleteSegments()
    {
        return this;
    }

    public volatile BufferedSink emitCompleteSegments()
        throws IOException
    {
        return emitCompleteSegments();
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof Buffer))
        {
            return false;
        }
        obj = (Buffer)obj;
        if (size != ((Buffer) (obj)).size)
        {
            return false;
        }
        if (size == 0L)
        {
            return true;
        }
        Segment segment = head;
        obj = ((Buffer) (obj)).head;
        int i = segment.pos;
        int j = ((Segment) (obj)).pos;
        long l = 0L;
        while (l < size) 
        {
            long l1 = Math.min(segment.limit - i, ((Segment) (obj)).limit - j);
            boolean flag = false;
            int k = i;
            i = j;
            j = k;
            for (k = ((flag) ? 1 : 0); (long)k < l1;)
            {
                if (segment.data[j] != ((Segment) (obj)).data[i])
                {
                    return false;
                }
                k++;
                i++;
                j++;
            }

            if (j == segment.limit)
            {
                segment = segment.next;
                j = segment.pos;
            }
            if (i == ((Segment) (obj)).limit)
            {
                obj = ((Segment) (obj)).next;
                k = ((Segment) (obj)).pos;
            } else
            {
                k = i;
            }
            l += l1;
            i = j;
            j = k;
        }
        return true;
    }

    public boolean exhausted()
    {
        return size == 0L;
    }

    public void flush()
    {
    }

    public byte getByte(long l)
    {
        Util.checkOffsetAndCount(size, l, 1L);
        Segment segment = head;
        do
        {
            int i = segment.limit - segment.pos;
            if (l < (long)i)
            {
                return segment.data[segment.pos + (int)l];
            }
            l -= i;
            segment = segment.next;
        } while (true);
    }

    public int hashCode()
    {
        Segment segment = head;
        if (segment == null)
        {
            return 0;
        }
        int j = 1;
        Segment segment1;
        int i;
        do
        {
            int k = segment.pos;
            int l = segment.limit;
            i = j;
            for (j = k; j < l; j++)
            {
                i = i * 31 + segment.data[j];
            }

            segment1 = segment.next;
            j = i;
            segment = segment1;
        } while (segment1 != head);
        return i;
    }

    public long indexOf(byte byte0)
    {
        return indexOf(byte0, 0L);
    }

    public long indexOf(byte byte0, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = head;
        if (segment == null)
        {
            return -1L;
        }
        long l1 = 0L;
        do
        {
            int i = segment.limit - segment.pos;
            Segment segment1;
            if (l >= (long)i)
            {
                l -= i;
            } else
            {
                byte abyte0[] = segment.data;
                l = (long)segment.pos + l;
                for (long l2 = segment.limit; l < l2; l++)
                {
                    if (abyte0[(int)l] == byte0)
                    {
                        return (l1 + l) - (long)segment.pos;
                    }
                }

                l = 0L;
            }
            l1 += i;
            segment1 = segment.next;
            segment = segment1;
        } while (segment1 != head);
        return -1L;
    }

    public int read(byte abyte0[], int i, int j)
    {
        Util.checkOffsetAndCount(abyte0.length, i, j);
        Segment segment = head;
        if (segment == null)
        {
            i = -1;
        } else
        {
            j = Math.min(j, segment.limit - segment.pos);
            System.arraycopy(segment.data, segment.pos, abyte0, i, j);
            segment.pos = segment.pos + j;
            size = size - (long)j;
            i = j;
            if (segment.pos == segment.limit)
            {
                head = segment.pop();
                SegmentPool.recycle(segment);
                return j;
            }
        }
        return i;
    }

    public long read(Buffer buffer1, long l)
    {
        if (buffer1 == null)
        {
            throw new IllegalArgumentException("sink == null");
        }
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
        }
        if (size == 0L)
        {
            return -1L;
        }
        long l1 = l;
        if (l > size)
        {
            l1 = size;
        }
        buffer1.write(this, l1);
        return l1;
    }

    public byte readByte()
    {
        if (size == 0L)
        {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = head;
        int i = segment.pos;
        int j = segment.limit;
        byte abyte0[] = segment.data;
        int k = i + 1;
        byte byte0 = abyte0[i];
        size = size - 1L;
        if (k == j)
        {
            head = segment.pop();
            SegmentPool.recycle(segment);
            return byte0;
        } else
        {
            segment.pos = k;
            return byte0;
        }
    }

    public byte[] readByteArray()
    {
        byte abyte0[];
        try
        {
            abyte0 = readByteArray(size);
        }
        catch (EOFException eofexception)
        {
            throw new AssertionError(eofexception);
        }
        return abyte0;
    }

    public byte[] readByteArray(long l)
        throws EOFException
    {
        Util.checkOffsetAndCount(size, 0L, l);
        if (l > 0x7fffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount > Integer.MAX_VALUE: ").append(l).toString());
        } else
        {
            byte abyte0[] = new byte[(int)l];
            readFully(abyte0);
            return abyte0;
        }
    }

    public ByteString readByteString()
    {
        return new ByteString(readByteArray());
    }

    public ByteString readByteString(long l)
        throws EOFException
    {
        return new ByteString(readByteArray(l));
    }

    public void readFully(byte abyte0[])
        throws EOFException
    {
        int j;
        for (int i = 0; i < abyte0.length; i += j)
        {
            j = read(abyte0, i, abyte0.length - i);
            if (j == -1)
            {
                throw new EOFException();
            }
        }

    }

    public long readHexadecimalUnsignedLong()
    {
        int i;
        int j;
        long l1;
        if (size == 0L)
        {
            throw new IllegalStateException("size == 0");
        }
        l1 = 0L;
        i = 0;
        j = 0;
_L6:
        Object obj;
        byte abyte0[];
        int k;
        int l;
        int i1;
        long l2;
        obj = head;
        abyte0 = ((Segment) (obj)).data;
        l = ((Segment) (obj)).pos;
        i1 = ((Segment) (obj)).limit;
        l2 = l1;
        k = i;
_L7:
        byte byte0;
        i = j;
        if (l >= i1)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        byte0 = abyte0[l];
        if (byte0 < 48 || byte0 > 57) goto _L2; else goto _L1
_L1:
        i = byte0 - 48;
_L4:
        if ((0xf000000000000000L & l2) != 0L)
        {
            obj = (new Buffer()).writeHexadecimalUnsignedLong(l2).writeByte(byte0);
            throw new NumberFormatException((new StringBuilder()).append("Number too large: ").append(((Buffer) (obj)).readUtf8()).toString());
        }
        break MISSING_BLOCK_LABEL_296;
_L2:
        if (byte0 >= 97 && byte0 <= 102)
        {
            i = (byte0 - 97) + 10;
            continue; /* Loop/switch isn't completed */
        }
        if (byte0 < 65 || byte0 > 70)
        {
            break; /* Loop/switch isn't completed */
        }
        i = (byte0 - 65) + 10;
        if (true) goto _L4; else goto _L3
_L3:
        if (k == 0)
        {
            throw new NumberFormatException((new StringBuilder()).append("Expected leading [0-9a-fA-F] character but was 0x").append(Integer.toHexString(byte0)).toString());
        }
        i = 1;
        if (l == i1)
        {
            head = ((Segment) (obj)).pop();
            SegmentPool.recycle(((Segment) (obj)));
        } else
        {
            obj.pos = l;
        }
        if (i != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i;
        i = k;
        l1 = l2;
        if (head != null) goto _L6; else goto _L5
_L5:
        size = size - (long)k;
        return l2;
        l2 = l2 << 4 | (long)i;
        l++;
        k++;
          goto _L7
    }

    public int readInt()
    {
        if (size < 4L)
        {
            throw new IllegalStateException((new StringBuilder()).append("size < 4: ").append(size).toString());
        }
        Segment segment = head;
        int j = segment.pos;
        int i = segment.limit;
        if (i - j < 4)
        {
            return (readByte() & 0xff) << 24 | (readByte() & 0xff) << 16 | (readByte() & 0xff) << 8 | readByte() & 0xff;
        }
        byte abyte0[] = segment.data;
        int k = j + 1;
        j = abyte0[j];
        int i1 = k + 1;
        k = abyte0[k];
        int l = i1 + 1;
        byte byte0 = abyte0[i1];
        i1 = l + 1;
        j = (j & 0xff) << 24 | (k & 0xff) << 16 | (byte0 & 0xff) << 8 | abyte0[l] & 0xff;
        size = size - 4L;
        if (i1 == i)
        {
            head = segment.pop();
            SegmentPool.recycle(segment);
            return j;
        } else
        {
            segment.pos = i1;
            return j;
        }
    }

    public int readIntLe()
    {
        return Util.reverseBytesInt(readInt());
    }

    public short readShort()
    {
        if (size < 2L)
        {
            throw new IllegalStateException((new StringBuilder()).append("size < 2: ").append(size).toString());
        }
        Segment segment = head;
        int k = segment.pos;
        int i = segment.limit;
        if (i - k < 2)
        {
            return (short)((readByte() & 0xff) << 8 | readByte() & 0xff);
        }
        byte abyte0[] = segment.data;
        int j = k + 1;
        k = abyte0[k];
        int l = j + 1;
        j = abyte0[j];
        size = size - 2L;
        if (l == i)
        {
            head = segment.pop();
            SegmentPool.recycle(segment);
        } else
        {
            segment.pos = l;
        }
        return (short)((k & 0xff) << 8 | j & 0xff);
    }

    public short readShortLe()
    {
        return Util.reverseBytesShort(readShort());
    }

    public String readString(long l, Charset charset)
        throws EOFException
    {
        Util.checkOffsetAndCount(size, 0L, l);
        if (charset == null)
        {
            throw new IllegalArgumentException("charset == null");
        }
        if (l > 0x7fffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount > Integer.MAX_VALUE: ").append(l).toString());
        }
        if (l == 0L)
        {
            charset = "";
        } else
        {
            Segment segment = head;
            if ((long)segment.pos + l > (long)segment.limit)
            {
                return new String(readByteArray(l), charset);
            }
            String s = new String(segment.data, segment.pos, (int)l, charset);
            segment.pos = (int)((long)segment.pos + l);
            size = size - l;
            charset = s;
            if (segment.pos == segment.limit)
            {
                head = segment.pop();
                SegmentPool.recycle(segment);
                return s;
            }
        }
        return charset;
    }

    public String readUtf8()
    {
        String s;
        try
        {
            s = readString(size, Util.UTF_8);
        }
        catch (EOFException eofexception)
        {
            throw new AssertionError(eofexception);
        }
        return s;
    }

    public String readUtf8(long l)
        throws EOFException
    {
        return readString(l, Util.UTF_8);
    }

    String readUtf8Line(long l)
        throws EOFException
    {
        if (l > 0L && getByte(l - 1L) == 13)
        {
            String s = readUtf8(l - 1L);
            skip(2L);
            return s;
        } else
        {
            String s1 = readUtf8(l);
            skip(1L);
            return s1;
        }
    }

    public String readUtf8LineStrict()
        throws EOFException
    {
        long l = indexOf((byte)10);
        if (l == -1L)
        {
            Buffer buffer1 = new Buffer();
            copyTo(buffer1, 0L, Math.min(32L, size));
            throw new EOFException((new StringBuilder()).append("\\n not found: size=").append(size()).append(" content=").append(buffer1.readByteString().hex()).append("...").toString());
        } else
        {
            return readUtf8Line(l);
        }
    }

    public void require(long l)
        throws EOFException
    {
        if (size < l)
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public long size()
    {
        return size;
    }

    public void skip(long l)
        throws EOFException
    {
        do
        {
            if (l <= 0L)
            {
                break;
            }
            if (head == null)
            {
                throw new EOFException();
            }
            int i = (int)Math.min(l, head.limit - head.pos);
            size = size - (long)i;
            long l1 = l - (long)i;
            Segment segment = head;
            segment.pos = segment.pos + i;
            l = l1;
            if (head.pos == head.limit)
            {
                Segment segment1 = head;
                head = segment1.pop();
                SegmentPool.recycle(segment1);
                l = l1;
            }
        } while (true);
    }

    public Timeout timeout()
    {
        return Timeout.NONE;
    }

    public String toString()
    {
        if (size == 0L)
        {
            return "Buffer[size=0]";
        }
        if (size <= 16L)
        {
            ByteString bytestring = clone().readByteString();
            return String.format("Buffer[size=%s data=%s]", new Object[] {
                Long.valueOf(size), bytestring.hex()
            });
        }
        String s;
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(head.data, head.pos, head.limit - head.pos);
            for (Segment segment = head.next; segment != head; segment = segment.next)
            {
                messagedigest.update(segment.data, segment.pos, segment.limit - segment.pos);
            }

        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new AssertionError();
        }
        s = String.format("Buffer[size=%s md5=%s]", new Object[] {
            Long.valueOf(size), ByteString.of(messagedigest.digest()).hex()
        });
        return s;
    }

    Segment writableSegment(int i)
    {
        if (i < 1 || i > 2048)
        {
            throw new IllegalArgumentException();
        }
        if (head != null) goto _L2; else goto _L1
_L1:
        Segment segment;
        head = SegmentPool.take();
        Segment segment1 = head;
        Segment segment3 = head;
        segment = head;
        segment3.prev = segment;
        segment1.next = segment;
_L4:
        return segment;
_L2:
        Segment segment2;
        segment2 = head.prev;
        if (segment2.limit + i > 2048)
        {
            break; /* Loop/switch isn't completed */
        }
        segment = segment2;
        if (segment2.owner) goto _L4; else goto _L3
_L3:
        return segment2.push(SegmentPool.take());
    }

    public Buffer write(ByteString bytestring)
    {
        if (bytestring == null)
        {
            throw new IllegalArgumentException("byteString == null");
        } else
        {
            bytestring.write(this);
            return this;
        }
    }

    public Buffer write(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            return write(abyte0, 0, abyte0.length);
        }
    }

    public Buffer write(byte abyte0[], int i, int j)
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        Util.checkOffsetAndCount(abyte0.length, i, j);
        for (int k = i + j; i < k;)
        {
            Segment segment = writableSegment(1);
            int l = Math.min(k - i, 2048 - segment.limit);
            System.arraycopy(abyte0, i, segment.data, segment.limit, l);
            i += l;
            segment.limit = segment.limit + l;
        }

        size = size + (long)j;
        return this;
    }

    public volatile BufferedSink write(ByteString bytestring)
        throws IOException
    {
        return write(bytestring);
    }

    public volatile BufferedSink write(byte abyte0[])
        throws IOException
    {
        return write(abyte0);
    }

    public void write(Buffer buffer1, long l)
    {
        if (buffer1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer1 == this)
        {
            throw new IllegalArgumentException("source == this");
        }
        Util.checkOffsetAndCount(buffer1.size, 0L, l);
        do
        {
label0:
            {
label1:
                {
                    if (l > 0L)
                    {
                        if (l >= (long)(buffer1.head.limit - buffer1.head.pos))
                        {
                            break label0;
                        }
                        Segment segment;
                        int i;
                        long l1;
                        if (head != null)
                        {
                            segment = head.prev;
                        } else
                        {
                            segment = null;
                        }
                        if (segment == null || !segment.owner)
                        {
                            break label1;
                        }
                        l1 = segment.limit;
                        if (segment.shared)
                        {
                            i = 0;
                        } else
                        {
                            i = segment.pos;
                        }
                        if ((l + l1) - (long)i > 2048L)
                        {
                            break label1;
                        }
                        buffer1.head.writeTo(segment, (int)l);
                        buffer1.size = buffer1.size - l;
                        size = size + l;
                    }
                    return;
                }
                buffer1.head = buffer1.head.split((int)l);
            }
            Segment segment1 = buffer1.head;
            long l2 = segment1.limit - segment1.pos;
            buffer1.head = segment1.pop();
            if (head == null)
            {
                head = segment1;
                segment1 = head;
                Segment segment2 = head;
                Segment segment3 = head;
                segment2.prev = segment3;
                segment1.next = segment3;
            } else
            {
                head.prev.push(segment1).compact();
            }
            buffer1.size = buffer1.size - l2;
            size = size + l2;
            l -= l2;
        } while (true);
    }

    public long writeAll(Source source)
        throws IOException
    {
        if (source == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        long l = 0L;
        do
        {
            long l1 = source.read(this, 2048L);
            if (l1 != -1L)
            {
                l += l1;
            } else
            {
                return l;
            }
        } while (true);
    }

    public Buffer writeByte(int i)
    {
        Segment segment = writableSegment(1);
        byte abyte0[] = segment.data;
        int j = segment.limit;
        segment.limit = j + 1;
        abyte0[j] = (byte)i;
        size = size + 1L;
        return this;
    }

    public volatile BufferedSink writeByte(int i)
        throws IOException
    {
        return writeByte(i);
    }

    public Buffer writeHexadecimalUnsignedLong(long l)
    {
        if (l == 0L)
        {
            return writeByte(48);
        }
        int j = Long.numberOfTrailingZeros(Long.highestOneBit(l)) / 4 + 1;
        Segment segment = writableSegment(j);
        byte abyte0[] = segment.data;
        int i = (segment.limit + j) - 1;
        for (int k = segment.limit; i >= k; i--)
        {
            abyte0[i] = DIGITS[(int)(15L & l)];
            l >>>= 4;
        }

        segment.limit = segment.limit + j;
        size = size + (long)j;
        return this;
    }

    public volatile BufferedSink writeHexadecimalUnsignedLong(long l)
        throws IOException
    {
        return writeHexadecimalUnsignedLong(l);
    }

    public Buffer writeInt(int i)
    {
        Segment segment = writableSegment(4);
        byte abyte0[] = segment.data;
        int k = segment.limit;
        int j = k + 1;
        abyte0[k] = (byte)(i >>> 24 & 0xff);
        k = j + 1;
        abyte0[j] = (byte)(i >>> 16 & 0xff);
        j = k + 1;
        abyte0[k] = (byte)(i >>> 8 & 0xff);
        abyte0[j] = (byte)(i & 0xff);
        segment.limit = j + 1;
        size = size + 4L;
        return this;
    }

    public volatile BufferedSink writeInt(int i)
        throws IOException
    {
        return writeInt(i);
    }

    public Buffer writeShort(int i)
    {
        Segment segment = writableSegment(2);
        byte abyte0[] = segment.data;
        int j = segment.limit;
        int k = j + 1;
        abyte0[j] = (byte)(i >>> 8 & 0xff);
        abyte0[k] = (byte)(i & 0xff);
        segment.limit = k + 1;
        size = size + 2L;
        return this;
    }

    public volatile BufferedSink writeShort(int i)
        throws IOException
    {
        return writeShort(i);
    }

    public Buffer writeUtf8(String s)
    {
        return writeUtf8(s, 0, s.length());
    }

    public Buffer writeUtf8(String s, int i, int j)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0)
        {
            throw new IllegalAccessError((new StringBuilder()).append("beginIndex < 0: ").append(i).toString());
        }
        if (j < i)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("endIndex < beginIndex: ").append(j).append(" < ").append(i).toString());
        }
        if (j > s.length())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("endIndex > string.length: ").append(j).append(" > ").append(s.length()).toString());
        }
label0:
        do
        {
            if (i >= j)
            {
                break;
            }
            char c = s.charAt(i);
            if (c < '\200')
            {
                Segment segment = writableSegment(1);
                byte abyte0[] = segment.data;
                int k = segment.limit - i;
                int i1 = Math.min(j, 2048 - k);
                abyte0[k + i] = (byte)c;
                i++;
                do
                {
label1:
                    {
                        if (i < i1)
                        {
                            c = s.charAt(i);
                            if (c < '\200')
                            {
                                break label1;
                            }
                        }
                        k = (i + k) - segment.limit;
                        segment.limit = segment.limit + k;
                        size = size + (long)k;
                        continue label0;
                    }
                    abyte0[k + i] = (byte)c;
                    i++;
                } while (true);
            }
            if (c < '\u0800')
            {
                writeByte(c >> 6 | 0xc0);
                writeByte(c & 0x3f | 0x80);
                i++;
            } else
            if (c < '\uD800' || c > '\uDFFF')
            {
                writeByte(c >> 12 | 0xe0);
                writeByte(c >> 6 & 0x3f | 0x80);
                writeByte(c & 0x3f | 0x80);
                i++;
            } else
            {
                int l;
                if (i + 1 < j)
                {
                    l = s.charAt(i + 1);
                } else
                {
                    l = 0;
                }
                if (c > '\uDBFF' || l < '\uDC00' || l > '\uDFFF')
                {
                    writeByte(63);
                    i++;
                } else
                {
                    l = 0x10000 + ((0xffff27ff & c) << 10 | 0xffff23ff & l);
                    writeByte(l >> 18 | 0xf0);
                    writeByte(l >> 12 & 0x3f | 0x80);
                    writeByte(l >> 6 & 0x3f | 0x80);
                    writeByte(l & 0x3f | 0x80);
                    i += 2;
                }
            }
        } while (true);
        return this;
    }

    public volatile BufferedSink writeUtf8(String s)
        throws IOException
    {
        return writeUtf8(s);
    }

    public Buffer writeUtf8CodePoint(int i)
    {
        if (i < 128)
        {
            writeByte(i);
            return this;
        }
        if (i < 2048)
        {
            writeByte(i >> 6 | 0xc0);
            writeByte(i & 0x3f | 0x80);
            return this;
        }
        if (i < 0x10000)
        {
            if (i >= 55296 && i <= 57343)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unexpected code point: ").append(Integer.toHexString(i)).toString());
            } else
            {
                writeByte(i >> 12 | 0xe0);
                writeByte(i >> 6 & 0x3f | 0x80);
                writeByte(i & 0x3f | 0x80);
                return this;
            }
        }
        if (i <= 0x10ffff)
        {
            writeByte(i >> 18 | 0xf0);
            writeByte(i >> 12 & 0x3f | 0x80);
            writeByte(i >> 6 & 0x3f | 0x80);
            writeByte(i & 0x3f | 0x80);
            return this;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unexpected code point: ").append(Integer.toHexString(i)).toString());
        }
    }

}
