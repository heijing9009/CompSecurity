// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnDriveIdResponse

public class ak
    implements android.os.Parcelable.Creator
{

    public ak()
    {
    }

    static void a(OnDriveIdResponse ondriveidresponse, Parcel parcel, int i)
    {
        int j = b.D(parcel);
        b.c(parcel, 1, ondriveidresponse.BR);
        b.a(parcel, 2, ondriveidresponse.Od, i, false);
        b.H(parcel, j);
    }

    public OnDriveIdResponse am(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.C(parcel);
        int i = 0;
        DriveId driveid = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.a.B(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.aD(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, DriveId.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new OnDriveIdResponse(i, driveid);
            }
        } while (true);
    }

    public OnDriveIdResponse[] by(int i)
    {
        return new OnDriveIdResponse[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return am(parcel);
    }

    public Object[] newArray(int i)
    {
        return by(i);
    }
}
