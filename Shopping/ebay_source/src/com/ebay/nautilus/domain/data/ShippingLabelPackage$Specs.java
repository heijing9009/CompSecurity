// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingLabelPackage

public static class Weight
{
    public static class Dimension
    {

        public double height;
        public double length;
        public String unit;
        public double width;

        public Dimension()
        {
        }
    }

    public static class Weight
    {

        public String unit;
        public double value;

        public Weight()
        {
        }
    }


    public Dimension dimensionMeasure;
    public eShapeType packageShape;
    public Weight weight;

    public Weight()
    {
    }
}
