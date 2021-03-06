// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.runtime.reflect.Factory;

public class TrackReferenceTypeBox extends AbstractBox
{

    public static final String TYPE1 = "hint";
    public static final String TYPE2 = "cdsc";
    private static final org.aspectj.lang.JoinPoint.StaticPart ajc$tjp_0;
    private static final org.aspectj.lang.JoinPoint.StaticPart ajc$tjp_1;
    private long trackIds[];

    public TrackReferenceTypeBox(String s)
    {
        super(s);
    }

    private static void ajc$preClinit()
    {
        Factory factory = new Factory("TrackReferenceTypeBox.java", com/coremedia/iso/boxes/TrackReferenceTypeBox);
        ajc$tjp_0 = factory.makeSJP("method-execution", factory.makeMethodSig("1", "getTrackIds", "com.coremedia.iso.boxes.TrackReferenceTypeBox", "", "", "", "[J"), 40);
        ajc$tjp_1 = factory.makeSJP("method-execution", factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.TrackReferenceTypeBox", "", "", "", "java.lang.String"), 65);
    }

    public void _parseDetails(ByteBuffer bytebuffer)
    {
        int j = bytebuffer.remaining() / 4;
        trackIds = new long[j];
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            trackIds[i] = IsoTypeReader.readUInt32(bytebuffer);
            i++;
        } while (true);
    }

    protected void getContent(ByteBuffer bytebuffer)
    {
        long al[] = trackIds;
        int j = al.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            IsoTypeWriter.writeUInt32(bytebuffer, al[i]);
            i++;
        } while (true);
    }

    protected long getContentSize()
    {
        return (long)(trackIds.length * 4);
    }

    public long[] getTrackIds()
    {
        org.aspectj.lang.JoinPoint joinpoint = Factory.makeJP(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.aspectOf().before(joinpoint);
        return trackIds;
    }

    public String toString()
    {
        Object obj = Factory.makeJP(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.aspectOf().before(((org.aspectj.lang.JoinPoint) (obj)));
        obj = new StringBuilder();
        ((StringBuilder) (obj)).append("TrackReferenceTypeBox[type=").append(getType());
        int i = 0;
        do
        {
            if (i >= trackIds.length)
            {
                ((StringBuilder) (obj)).append("]");
                return ((StringBuilder) (obj)).toString();
            }
            ((StringBuilder) (obj)).append(";trackId");
            ((StringBuilder) (obj)).append(i);
            ((StringBuilder) (obj)).append("=");
            ((StringBuilder) (obj)).append(trackIds[i]);
            i++;
        } while (true);
    }

    static 
    {
        ajc$preClinit();
    }
}
