// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.internal:
//            zzit

public final class gn
    implements android.os.Parcelable.Creator
{

    public gn()
    {
    }

    static void a(zzit zzit1, Parcel parcel)
    {
        int i = c.a(parcel);
        c.a(parcel, 1, zzit1.b);
        c.a(parcel, 1000, zzit1.a);
        c.a(parcel, 2, zzit1.c);
        c.a(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int j = 0;
        int k = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        android.os.Bundle bundle = null;
        int i = 0;
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
                    j = com.google.android.gms.common.internal.safeparcel.a.f(parcel, l);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.a.f(parcel, l);
                    break;

                case 2: // '\002'
                    bundle = com.google.android.gms.common.internal.safeparcel.a.n(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new zzit(i, j, bundle);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new zzit[i];
    }
}
