// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            StringPredicate

class ContainsPredicate extends StringPredicate
{

    private static final String ID;

    public ContainsPredicate()
    {
        super(ID);
    }

    public static String getFunctionId()
    {
        return ID;
    }

    protected boolean evaluateString(String s, String s1, Map map)
    {
        return s.contains(s1);
    }

    static 
    {
        ID = FunctionType.CONTAINS.toString();
    }
}
