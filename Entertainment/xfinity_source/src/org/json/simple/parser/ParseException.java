// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.simple.parser;


public class ParseException extends Exception
{

    private int errorType;
    private int position;
    private Object unexpectedObject;

    public ParseException(int i, int j, Object obj)
    {
        position = i;
        errorType = j;
        unexpectedObject = obj;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        errorType;
        JVM INSTR tableswitch 0 2: default 40
    //                   0 64
    //                   1 98
    //                   2 132;
           goto _L1 _L2 _L3 _L4
_L1:
        stringbuffer.append("Unkown error at position ").append(position).append(".");
_L6:
        return stringbuffer.toString();
_L2:
        stringbuffer.append("Unexpected character (").append(unexpectedObject).append(") at position ").append(position).append(".");
        continue; /* Loop/switch isn't completed */
_L3:
        stringbuffer.append("Unexpected token ").append(unexpectedObject).append(" at position ").append(position).append(".");
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuffer.append("Unexpected exception at position ").append(position).append(": ").append(unexpectedObject);
        if (true) goto _L6; else goto _L5
_L5:
    }
}
