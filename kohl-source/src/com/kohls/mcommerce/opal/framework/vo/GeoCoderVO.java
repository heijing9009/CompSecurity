// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kohls.mcommerce.opal.framework.vo;

import java.io.Serializable;
import java.util.List;

// Referenced classes of package com.kohls.mcommerce.opal.framework.vo:
//            IValueObject

public class GeoCoderVO
    implements IValueObject, Serializable
{
    public class GeoCodeResult
        implements Serializable
    {

        private static final long serialVersionUID = 2L;
        private List address_components;
        private String formatted_address;
        private Geometry geometry;
        final GeoCoderVO this$0;
        private List types;

        public List getAddress_components()
        {
            return address_components;
        }

        public String getFormatted_address()
        {
            return formatted_address;
        }

        public Geometry getGeometry()
        {
            return geometry;
        }

        public List getTypes()
        {
            return types;
        }

        public void setAddress_components(List list)
        {
            address_components = list;
        }

        public void setFormatted_address(String s)
        {
            formatted_address = s;
        }

        public void setGeometry(Geometry geometry1)
        {
            geometry = geometry1;
        }

        public void setTypes(List list)
        {
            types = list;
        }

        public GeoCodeResult()
        {
            this$0 = GeoCoderVO.this;
            super();
        }
    }

    public class GeoCodeResult.AddressComponent
        implements Serializable
    {

        private static final long serialVersionUID = 3L;
        private String long_name;
        private String short_name;
        final GeoCodeResult this$1;
        private List types;

        public String getLong_name()
        {
            return long_name;
        }

        public String getShort_name()
        {
            return short_name;
        }

        public List getTypes()
        {
            return types;
        }

        public void setLong_name(String s)
        {
            long_name = s;
        }

        public void setShort_name(String s)
        {
            short_name = s;
        }

        public void setTypes(List list)
        {
            types = list;
        }

        public GeoCodeResult.AddressComponent()
        {
            this$1 = GeoCodeResult.this;
            super();
        }
    }


    private static final long serialVersionUID = 1L;
    private List results;

    public GeoCoderVO()
    {
    }

    public List getResults()
    {
        return results;
    }

    public void setResults(List list)
    {
        results = list;
    }

    // Unreferenced inner class com/kohls/mcommerce/opal/framework/vo/GeoCoderVO$GeoCodeResult$Geometry
    /* block-local class not found */
    class GeoCodeResult.Geometry {}

}
