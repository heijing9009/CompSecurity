// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.org.codehaus.jackson.util;

import com.amazon.org.codehaus.jackson.JsonGenerationException;
import com.amazon.org.codehaus.jackson.JsonGenerator;
import com.amazon.org.codehaus.jackson.impl.Indenter;
import java.io.IOException;

// Referenced classes of package com.amazon.org.codehaus.jackson.util:
//            DefaultPrettyPrinter

public static class 
    implements Indenter
{

    public boolean isInline()
    {
        return true;
    }

    public void writeIndentation(JsonGenerator jsongenerator, int i)
        throws IOException, JsonGenerationException
    {
        jsongenerator.writeRaw(' ');
    }

    public ()
    {
    }
}
