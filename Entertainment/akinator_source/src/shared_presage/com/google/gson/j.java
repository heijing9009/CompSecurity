// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson;

import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson:
//            TypeAdapter, Gson

final class j extends TypeAdapter
{

    final Gson a;

    j(Gson gson)
    {
        a = gson;
        super();
    }

    public final Object read(JsonReader jsonreader)
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        } else
        {
            return Float.valueOf((float)jsonreader.nextDouble());
        }
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        obj = (Number)obj;
        if (obj == null)
        {
            jsonwriter.nullValue();
            return;
        } else
        {
            float f = ((Number) (obj)).floatValue();
            Gson.access$000(a, f);
            jsonwriter.value(((Number) (obj)));
            return;
        }
    }
}
