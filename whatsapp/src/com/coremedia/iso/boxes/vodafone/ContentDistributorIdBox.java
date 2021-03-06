// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.coremedia.iso.boxes.vodafone;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.runtime.reflect.Factory;

public class ContentDistributorIdBox extends AbstractFullBox
{

    public static final String TYPE = "cdis";
    private static final org.aspectj.lang.JoinPoint.StaticPart ajc$tjp_0;
    private static final org.aspectj.lang.JoinPoint.StaticPart ajc$tjp_1;
    private static final org.aspectj.lang.JoinPoint.StaticPart ajc$tjp_2;
    private String contentDistributorId;
    private String language;

    public ContentDistributorIdBox()
    {
        super("cdis");
    }

    private static void ajc$preClinit()
    {
        Factory factory = new Factory("ContentDistributorIdBox.java", com/coremedia/iso/boxes/vodafone/ContentDistributorIdBox);
        ajc$tjp_0 = factory.makeSJP("method-execution", factory.makeMethodSig("1", "getLanguage", "com.coremedia.iso.boxes.vodafone.ContentDistributorIdBox", "", "", "", "java.lang.String"), 40);
        ajc$tjp_1 = factory.makeSJP("method-execution", factory.makeMethodSig("1", "getContentDistributorId", "com.coremedia.iso.boxes.vodafone.ContentDistributorIdBox", "", "", "", "java.lang.String"), 44);
        ajc$tjp_2 = factory.makeSJP("method-execution", factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.vodafone.ContentDistributorIdBox", "", "", "", "java.lang.String"), 68);
    }

    public void _parseDetails(ByteBuffer bytebuffer)
    {
        parseVersionAndFlags(bytebuffer);
        language = IsoTypeReader.readIso639(bytebuffer);
        contentDistributorId = IsoTypeReader.readString(bytebuffer);
    }

    protected void getContent(ByteBuffer bytebuffer)
    {
        writeVersionAndFlags(bytebuffer);
        IsoTypeWriter.writeIso639(bytebuffer, language);
        bytebuffer.put(Utf8.convert(contentDistributorId));
        bytebuffer.put((byte)0);
    }

    public String getContentDistributorId()
    {
        org.aspectj.lang.JoinPoint joinpoint = Factory.makeJP(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.aspectOf().before(joinpoint);
        return contentDistributorId;
    }

    protected long getContentSize()
    {
        return (long)(Utf8.utf8StringLengthInBytes(contentDistributorId) + 2 + 5);
    }

    public String getLanguage()
    {
        org.aspectj.lang.JoinPoint joinpoint = Factory.makeJP(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.aspectOf().before(joinpoint);
        return language;
    }

    public String toString()
    {
        org.aspectj.lang.JoinPoint joinpoint = Factory.makeJP(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.aspectOf().before(joinpoint);
        return (new StringBuilder("ContentDistributorIdBox[language=")).append(getLanguage()).append(";contentDistributorId=").append(getContentDistributorId()).append("]").toString();
    }

    static 
    {
        ajc$preClinit();
    }
}
