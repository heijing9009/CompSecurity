// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.location:
//            DetectedActivityCreator

public class DetectedActivity
    implements SafeParcelable
{

    public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    private final int iM;
    int oy;
    int oz;

    public DetectedActivity(int i, int j)
    {
        iM = 1;
        oy = i;
        oz = j;
    }

    public DetectedActivity(int i, int j, int k)
    {
        iM = i;
        oy = j;
        oz = k;
    }

    private int W(int i)
    {
        int j = i;
        if (i > 6)
        {
            j = 4;
        }
        return j;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getConfidence()
    {
        return oz;
    }

    public int getType()
    {
        return W(oy);
    }

    public int getVersionCode()
    {
        return iM;
    }

    public String toString()
    {
        return (new StringBuilder()).append("DetectedActivity [type=").append(getType()).append(", confidence=").append(oz).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        DetectedActivityCreator.a(this, parcel, i);
    }

}
