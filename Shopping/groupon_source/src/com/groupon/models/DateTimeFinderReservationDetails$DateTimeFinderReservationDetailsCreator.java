// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import android.os.Parcel;

// Referenced classes of package com.groupon.models:
//            DateTimeFinderReservationDetails

private static class <init>
    implements android.os.Creator
{

    public DateTimeFinderReservationDetails createFromParcel(Parcel parcel)
    {
        return new DateTimeFinderReservationDetails(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public DateTimeFinderReservationDetails[] newArray(int i)
    {
        return new DateTimeFinderReservationDetails[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    private a()
    {
    }

    a(a a)
    {
        this();
    }
}
