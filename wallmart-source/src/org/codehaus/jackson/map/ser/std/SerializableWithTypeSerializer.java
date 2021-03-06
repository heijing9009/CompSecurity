// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.ser.std;

import java.io.IOException;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializableWithType;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.schema.JsonSerializableSchema;

// Referenced classes of package org.codehaus.jackson.map.ser.std:
//            SerializerBase

public class SerializableWithTypeSerializer extends SerializerBase
{

    public static final SerializableWithTypeSerializer instance = new SerializableWithTypeSerializer();

    protected SerializableWithTypeSerializer()
    {
        super(org/codehaus/jackson/map/JsonSerializableWithType);
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        throws JsonMappingException
    {
        ObjectNode objectnode = createObjectNode();
        String s1 = "any";
        Object obj2 = null;
        serializerprovider = null;
        Object obj1 = null;
        String s = obj1;
        SerializerProvider serializerprovider1 = obj2;
        Object obj = s1;
        if (type != null)
        {
            type = TypeFactory.rawClass(type);
            s = obj1;
            serializerprovider1 = obj2;
            obj = s1;
            if (type.isAnnotationPresent(org/codehaus/jackson/schema/JsonSerializableSchema))
            {
                JsonSerializableSchema jsonserializableschema = (JsonSerializableSchema)type.getAnnotation(org/codehaus/jackson/schema/JsonSerializableSchema);
                type = jsonserializableschema.schemaType();
                if (!"##irrelevant".equals(jsonserializableschema.schemaObjectPropertiesDefinition()))
                {
                    serializerprovider = jsonserializableschema.schemaObjectPropertiesDefinition();
                }
                s = obj1;
                serializerprovider1 = serializerprovider;
                obj = type;
                if (!"##irrelevant".equals(jsonserializableschema.schemaItemDefinition()))
                {
                    s = jsonserializableschema.schemaItemDefinition();
                    obj = type;
                    serializerprovider1 = serializerprovider;
                }
            }
        }
        objectnode.put("type", ((String) (obj)));
        if (serializerprovider1 != null)
        {
            try
            {
                objectnode.put("properties", (JsonNode)(new ObjectMapper()).readValue(serializerprovider1, org/codehaus/jackson/JsonNode));
            }
            // Misplaced declaration of an exception variable
            catch (SerializerProvider serializerprovider)
            {
                throw new IllegalStateException(serializerprovider);
            }
        }
        if (s != null)
        {
            try
            {
                objectnode.put("items", (JsonNode)(new ObjectMapper()).readValue(s, org/codehaus/jackson/JsonNode));
            }
            // Misplaced declaration of an exception variable
            catch (SerializerProvider serializerprovider)
            {
                throw new IllegalStateException(serializerprovider);
            }
        }
        return objectnode;
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serialize((JsonSerializableWithType)obj, jsongenerator, serializerprovider);
    }

    public void serialize(JsonSerializableWithType jsonserializablewithtype, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        jsonserializablewithtype.serialize(jsongenerator, serializerprovider);
    }

    public volatile void serializeWithType(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonProcessingException
    {
        serializeWithType((JsonSerializableWithType)obj, jsongenerator, serializerprovider, typeserializer);
    }

    public final void serializeWithType(JsonSerializableWithType jsonserializablewithtype, JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonGenerationException
    {
        jsonserializablewithtype.serializeWithType(jsongenerator, serializerprovider, typeserializer);
    }

}
