// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import java.io.Closeable;
import java.io.InputStream;

// Referenced classes of package com.mopub.common:
//            DiskLruCacheUtil, DiskLruCache

public final class <init>
    implements Closeable
{

    private final InputStream ins[];
    private final String key;
    private final long lengths[];
    private final long sequenceNumber;
    final DiskLruCache this$0;

    public final void close()
    {
        InputStream ainputstream[] = ins;
        int j = ainputstream.length;
        for (int i = 0; i < j; i++)
        {
            DiskLruCacheUtil.closeQuietly(ainputstream[i]);
        }

    }

    public final Quietly edit()
    {
        return DiskLruCache.access$1600(DiskLruCache.this, key, sequenceNumber);
    }

    public final InputStream getInputStream(int i)
    {
        return ins[i];
    }

    public final long getLength(int i)
    {
        return lengths[i];
    }

    public final String getString(int i)
    {
        return DiskLruCache.access$1700(getInputStream(i));
    }

    private (String s, long l, InputStream ainputstream[], long al[])
    {
        this$0 = DiskLruCache.this;
        super();
        key = s;
        sequenceNumber = l;
        ins = ainputstream;
        lengths = al;
    }

    lengths(String s, long l, InputStream ainputstream[], long al[], lengths lengths1)
    {
        this(s, l, ainputstream, al);
    }
}
