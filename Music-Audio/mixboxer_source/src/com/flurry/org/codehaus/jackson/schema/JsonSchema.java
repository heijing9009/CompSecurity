// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.schema;

import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.node.JsonNodeFactory;
import com.flurry.org.codehaus.jackson.node.ObjectNode;

public class JsonSchema
{

    private final ObjectNode schema;

    public JsonSchema(ObjectNode objectnode)
    {
        schema = objectnode;
    }

    public static JsonNode getDefaultSchemaNode()
    {
        ObjectNode objectnode = JsonNodeFactory.instance.objectNode();
        objectnode.put("type", "any");
        return objectnode;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj == null)
            {
                return false;
            }
            if (!(obj instanceof JsonSchema))
            {
                return false;
            }
            obj = (JsonSchema)obj;
            if (schema == null)
            {
                if (((JsonSchema) (obj)).schema != null)
                {
                    return false;
                }
            } else
            {
                return schema.equals(((JsonSchema) (obj)).schema);
            }
        }
        return true;
    }

    public ObjectNode getSchemaNode()
    {
        return schema;
    }

    public String toString()
    {
        return schema.toString();
    }
}
