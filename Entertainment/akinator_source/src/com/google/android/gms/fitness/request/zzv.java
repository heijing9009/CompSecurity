// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

// Referenced classes of package com.google.android.gms.fitness.request:
//            SessionReadRequest

public class zzv
    implements android.os.Parcelable.Creator
{

    public zzv()
    {
    }

    static void zza(SessionReadRequest sessionreadrequest, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, sessionreadrequest.getSessionName(), false);
        zzb.zzc(parcel, 1000, sessionreadrequest.getVersionCode());
        zzb.zza(parcel, 2, sessionreadrequest.getSessionId(), false);
        zzb.zza(parcel, 3, sessionreadrequest.zzkX());
        zzb.zza(parcel, 4, sessionreadrequest.zzsi());
        zzb.zzc(parcel, 5, sessionreadrequest.getDataTypes(), false);
        zzb.zzc(parcel, 6, sessionreadrequest.getDataSources(), false);
        zzb.zza(parcel, 7, sessionreadrequest.zzti());
        zzb.zza(parcel, 8, sessionreadrequest.zzsT());
        zzb.zzb(parcel, 9, sessionreadrequest.getExcludedPackages(), false);
        zzb.zza(parcel, 10, sessionreadrequest.zzsO(), false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdq(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzfi(i);
    }

    public SessionReadRequest zzdq(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        String s1 = null;
        String s = null;
        long l1 = 0L;
        long l = 0L;
        java.util.ArrayList arraylist2 = null;
        java.util.ArrayList arraylist1 = null;
        boolean flag1 = false;
        boolean flag = false;
        java.util.ArrayList arraylist = null;
        android.os.IBinder ibinder = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 3: // '\003'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;

                case 4: // '\004'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;

                case 5: // '\005'
                    arraylist2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, DataType.CREATOR);
                    break;

                case 6: // '\006'
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, DataSource.CREATOR);
                    break;

                case 7: // '\007'
                    flag1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 8: // '\b'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 9: // '\t'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, k);
                    break;

                case 10: // '\n'
                    ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new SessionReadRequest(i, s1, s, l1, l, arraylist2, arraylist1, flag1, flag, arraylist, ibinder);
            }
        } while (true);
    }

    public SessionReadRequest[] zzfi(int i)
    {
        return new SessionReadRequest[i];
    }
}
