// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.playlog.internal:
//            LogEvent

public class zzc
    implements android.os.Parcelable.Creator
{

    public zzc()
    {
    }

    static void zza(LogEvent logevent, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, logevent.versionCode);
        zzb.zza(parcel, 2, logevent.zzaKG);
        zzb.zza(parcel, 3, logevent.tag, false);
        zzb.zza(parcel, 4, logevent.zzaKI, false);
        zzb.zza(parcel, 5, logevent.zzaKJ, false);
        zzb.zza(parcel, 6, logevent.zzaKH);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzfP(parcel);
    }

    public Object[] newArray(int i)
    {
        return zziD(i);
    }

    public LogEvent zzfP(Parcel parcel)
    {
        long l = 0L;
        android.os.Bundle bundle = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        byte abyte0[] = null;
        String s = null;
        long l1 = 0L;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 4: // '\004'
                    abyte0 = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, k);
                    break;

                case 5: // '\005'
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, k);
                    break;

                case 6: // '\006'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new LogEvent(i, l1, l, s, abyte0, bundle);
            }
        } while (true);
    }

    public LogEvent[] zziD(int i)
    {
        return new LogEvent[i];
    }
}
