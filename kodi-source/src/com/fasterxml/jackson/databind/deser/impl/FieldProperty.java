// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;
import java.lang.reflect.Field;

public final class FieldProperty extends SettableBeanProperty
{

    protected final AnnotatedField _annotated;
    protected final transient Field _field;

    protected FieldProperty(FieldProperty fieldproperty, JsonDeserializer jsondeserializer)
    {
        super(fieldproperty, jsondeserializer);
        _annotated = fieldproperty._annotated;
        _field = fieldproperty._field;
    }

    protected FieldProperty(FieldProperty fieldproperty, PropertyName propertyname)
    {
        super(fieldproperty, propertyname);
        _annotated = fieldproperty._annotated;
        _field = fieldproperty._field;
    }

    public FieldProperty(BeanPropertyDefinition beanpropertydefinition, JavaType javatype, TypeDeserializer typedeserializer, Annotations annotations, AnnotatedField annotatedfield)
    {
        super(beanpropertydefinition, javatype, typedeserializer, annotations);
        _annotated = annotatedfield;
        _field = annotatedfield.getAnnotated();
    }

    public void deserializeAndSet(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
        throws IOException
    {
        jsonparser = ((JsonParser) (deserialize(jsonparser, deserializationcontext)));
        try
        {
            _field.set(obj, jsonparser);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DeserializationContext deserializationcontext)
        {
            _throwAsIOE(deserializationcontext, jsonparser);
        }
    }

    public Object deserializeSetAndReturn(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
        throws IOException
    {
        jsonparser = ((JsonParser) (deserialize(jsonparser, deserializationcontext)));
        try
        {
            _field.set(obj, jsonparser);
        }
        // Misplaced declaration of an exception variable
        catch (DeserializationContext deserializationcontext)
        {
            _throwAsIOE(deserializationcontext, jsonparser);
            return obj;
        }
        return obj;
    }

    public AnnotatedMember getMember()
    {
        return _annotated;
    }

    public final void set(Object obj, Object obj1)
        throws IOException
    {
        try
        {
            _field.set(obj, obj1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            _throwAsIOE(((Exception) (obj)), obj1);
        }
    }

    public Object setAndReturn(Object obj, Object obj1)
        throws IOException
    {
        try
        {
            _field.set(obj, obj1);
        }
        catch (Exception exception)
        {
            _throwAsIOE(exception, obj1);
            return obj;
        }
        return obj;
    }

    public volatile SettableBeanProperty withName(PropertyName propertyname)
    {
        return withName(propertyname);
    }

    public FieldProperty withName(PropertyName propertyname)
    {
        return new FieldProperty(this, propertyname);
    }

    public volatile SettableBeanProperty withValueDeserializer(JsonDeserializer jsondeserializer)
    {
        return withValueDeserializer(jsondeserializer);
    }

    public FieldProperty withValueDeserializer(JsonDeserializer jsondeserializer)
    {
        return new FieldProperty(this, jsondeserializer);
    }
}
