// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            GetChannelOutputStreamResponse

public class zzah
    implements android.os.Parcelable.Creator
{

    public zzah()
    {
    }

    static void zza(GetChannelOutputStreamResponse getchanneloutputstreamresponse, Parcel parcel, int i)
    {
        int j = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getchanneloutputstreamresponse.versionCode);
        zzb.zzc(parcel, 2, getchanneloutputstreamresponse.statusCode);
        zzb.zza(parcel, 3, getchanneloutputstreamresponse.zzaUs, i, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgZ(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzkh(i);
    }

    public GetChannelOutputStreamResponse zzgZ(Parcel parcel)
    {
        int j = 0;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        ParcelFileDescriptor parcelfiledescriptor = null;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 3: // '\003'
                    parcelfiledescriptor = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, ParcelFileDescriptor.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new GetChannelOutputStreamResponse(i, j, parcelfiledescriptor);
            }
        } while (true);
    }

    public GetChannelOutputStreamResponse[] zzkh(int i)
    {
        return new GetChannelOutputStreamResponse[i];
    }
}
