// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONException;

// Referenced classes of package com.parse:
//            ParseObject, ParseObjectEncodingStrategy

interface ParseFieldOperation
{

    public abstract Object apply(Object obj, ParseObject parseobject, String s);

    public abstract Object encode(ParseObjectEncodingStrategy parseobjectencodingstrategy)
        throws JSONException;

    public abstract ParseFieldOperation mergeWithPrevious(ParseFieldOperation parsefieldoperation);
}
