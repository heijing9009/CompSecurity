// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.bouncycastle.voms;

import java.util.Vector;

public class VOMSAttribute
{
    public class FQAN
    {

        String a;
        String b;
        String c;
        String d;

        public String toString()
        {
            if (a != null)
            {
                return a;
            }
            StringBuilder stringbuilder = (new StringBuilder()).append(b).append("/Role=");
            String s;
            if (c != null)
            {
                s = c;
            } else
            {
                s = "";
            }
            stringbuilder = stringbuilder.append(s);
            if (d != null)
            {
                s = (new StringBuilder("/Capability=")).append(d).toString();
            } else
            {
                s = "";
            }
            a = stringbuilder.append(s).toString();
            return a;
        }
    }


    private String a;
    private String b;
    private Vector c;

    public String toString()
    {
        return (new StringBuilder("VO      :")).append(b).append("\nHostPort:").append(a).append("\nFQANs   :").append(c).toString();
    }
}
