// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;
import java.util.Iterator;

public class IteratorSerializer extends AsArraySerializerBase
{

    public IteratorSerializer(JavaType javatype, boolean flag, TypeSerializer typeserializer, BeanProperty beanproperty)
    {
        super(java/util/Iterator, javatype, flag, typeserializer, beanproperty, null);
    }

    public IteratorSerializer(IteratorSerializer iteratorserializer, BeanProperty beanproperty, TypeSerializer typeserializer, JsonSerializer jsonserializer)
    {
        super(iteratorserializer, beanproperty, typeserializer, jsonserializer);
    }

    public ContainerSerializer _withValueTypeSerializer(TypeSerializer typeserializer)
    {
        return new IteratorSerializer(_elementType, _staticTyping, typeserializer, _property);
    }

    public volatile boolean hasSingleElement(Object obj)
    {
        return hasSingleElement((Iterator)obj);
    }

    public boolean hasSingleElement(Iterator iterator)
    {
        return false;
    }

    public volatile boolean isEmpty(Object obj)
    {
        return isEmpty((Iterator)obj);
    }

    public boolean isEmpty(Iterator iterator)
    {
        return iterator == null || !iterator.hasNext();
    }

    public volatile void serializeContents(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
    {
        serializeContents((Iterator)obj, jsongenerator, serializerprovider);
    }

    public void serializeContents(Iterator iterator, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
    {
        Object obj = null;
        if (iterator.hasNext())
        {
            TypeSerializer typeserializer = _valueTypeSerializer;
            JsonSerializer jsonserializer = null;
            do
            {
                Object obj2 = iterator.next();
                if (obj2 == null)
                {
                    serializerprovider.defaultSerializeNull(jsongenerator);
                } else
                {
                    Object obj1 = obj2.getClass();
                    if (obj1 == obj)
                    {
                        obj1 = jsonserializer;
                    } else
                    {
                        jsonserializer = serializerprovider.findValueSerializer(((Class) (obj1)), _property);
                        obj = obj1;
                        obj1 = jsonserializer;
                    }
                    if (typeserializer == null)
                    {
                        ((JsonSerializer) (obj1)).serialize(obj2, jsongenerator, serializerprovider);
                    } else
                    {
                        ((JsonSerializer) (obj1)).serializeWithType(obj2, jsongenerator, serializerprovider, typeserializer);
                    }
                }
            } while (iterator.hasNext());
        }
    }

    public IteratorSerializer withResolved(BeanProperty beanproperty, TypeSerializer typeserializer, JsonSerializer jsonserializer)
    {
        return new IteratorSerializer(this, beanproperty, typeserializer, jsonserializer);
    }

    public volatile AsArraySerializerBase withResolved(BeanProperty beanproperty, TypeSerializer typeserializer, JsonSerializer jsonserializer)
    {
        return withResolved(beanproperty, typeserializer, jsonserializer);
    }
}
