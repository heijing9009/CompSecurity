// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONObject;

final class tter
    implements tter
{

    public final void setOnBundle(Bundle bundle, String s, Object obj)
    {
        throw new IllegalArgumentException("Unexpected type from JSON");
    }

    public final void setOnJSON(JSONObject jsonobject, String s, Object obj)
    {
        JSONArray jsonarray = new JSONArray();
        obj = (String[])(String[])obj;
        int j = obj.length;
        for (int i = 0; i < j; i++)
        {
            jsonarray.put(obj[i]);
        }

        jsonobject.put(s, jsonarray);
    }

    tter()
    {
    }
}
