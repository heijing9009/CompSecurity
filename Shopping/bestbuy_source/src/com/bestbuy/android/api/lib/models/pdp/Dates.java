// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;

public class Dates
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String streetDate;

    public Dates()
    {
    }

    public String getStreetDate()
    {
        return streetDate;
    }

    public void setStreetDate(String s)
    {
        streetDate = s;
    }
}
