// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model:
//            MapDisplayableItem

static final class 
    implements android.os.leItem._cls1
{

    public MapDisplayableItem a(Parcel parcel)
    {
        return new MapDisplayableItem(parcel, null);
    }

    public MapDisplayableItem[] a(int i)
    {
        return new MapDisplayableItem[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}
