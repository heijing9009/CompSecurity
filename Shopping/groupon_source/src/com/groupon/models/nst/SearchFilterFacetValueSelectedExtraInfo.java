// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class SearchFilterFacetValueSelectedExtraInfo extends JsonEncodedNSTField
{

    public String facetName;
    public String query;
    public String valueName;

    public SearchFilterFacetValueSelectedExtraInfo(String s, String s1, String s2)
    {
        query = s;
        facetName = s1;
        valueName = s2;
    }
}
