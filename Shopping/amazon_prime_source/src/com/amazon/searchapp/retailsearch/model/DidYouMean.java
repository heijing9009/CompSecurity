// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

public interface DidYouMean
{

    public abstract List getCorrectedQuery();

    public abstract List getDetailLabel();

    public abstract List getFormattedLabel();

    public abstract List getFormattedOriginalQueryLabel();

    public abstract String getLabel();

    public abstract void setCorrectedQuery(List list);

    public abstract void setDetailLabel(List list);

    public abstract void setFormattedLabel(List list);

    public abstract void setFormattedOriginalQueryLabel(List list);

    public abstract void setLabel(String s);
}
