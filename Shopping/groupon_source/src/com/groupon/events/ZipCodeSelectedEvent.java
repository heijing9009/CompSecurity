// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.events;


public class ZipCodeSelectedEvent
{

    private String zipcode;

    public ZipCodeSelectedEvent(String s)
    {
        zipcode = s;
    }

    public String getZipcode()
    {
        return zipcode;
    }
}
