// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLng, PolylineOptions

public final class n
    implements android.os.Parcelable.Creator
{

    public n()
    {
    }

    public static PolylineOptions a(Parcel parcel)
    {
        float f = 0.0F;
        boolean flag = false;
        int k = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        java.util.ArrayList arraylist = null;
        boolean flag1 = false;
        int i = 0;
        float f1 = 0.0F;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = parcel.readInt();
                switch (0xffff & l)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l);
                    break;

                case 2: // '\002'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    f1 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, l);
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l);
                    break;

                case 5: // '\005'
                    f = com.google.android.gms.common.internal.safeparcel.a.h(parcel, l);
                    break;

                case 6: // '\006'
                    flag1 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l);
                    break;

                case 7: // '\007'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new PolylineOptions(j, arraylist, f1, i, f, flag1, flag);
            }
        } while (true);
    }

    static void a(PolylineOptions polylineoptions, Parcel parcel)
    {
        int i = b.a(parcel, 20293);
        b.b(parcel, 1, polylineoptions.a);
        b.a(parcel, 2, polylineoptions.b, false);
        b.a(parcel, 3, polylineoptions.c);
        b.b(parcel, 4, polylineoptions.d);
        b.a(parcel, 5, polylineoptions.e);
        b.a(parcel, 6, polylineoptions.f);
        b.a(parcel, 7, polylineoptions.g);
        b.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new PolylineOptions[i];
    }
}
