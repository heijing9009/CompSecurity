// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zzc
    implements android.os.Parcelable.Creator
{

    public zzc()
    {
    }

    static void zza(PersonEntity.CoverEntity coverentity, Parcel parcel, int i)
    {
        int j = zzb.zzac(parcel);
        Set set = coverentity.zzaHQ;
        if (set.contains(Integer.valueOf(1)))
        {
            zzb.zzc(parcel, 1, coverentity.zzCY);
        }
        if (set.contains(Integer.valueOf(2)))
        {
            zzb.zza(parcel, 2, coverentity.zzaJj, i, true);
        }
        if (set.contains(Integer.valueOf(3)))
        {
            zzb.zza(parcel, 3, coverentity.zzaJk, i, true);
        }
        if (set.contains(Integer.valueOf(4)))
        {
            zzb.zzc(parcel, 4, coverentity.zzaJl);
        }
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzfO(parcel);
    }

    public Object[] newArray(int i)
    {
        return zziE(i);
    }

    public PersonEntity.CoverEntity zzfO(Parcel parcel)
    {
        PersonEntity.CoverEntity.CoverPhotoEntity coverphotoentity = null;
        int i = 0;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        HashSet hashset = new HashSet();
        PersonEntity.CoverEntity.CoverInfoEntity coverinfoentity = null;
        int j = 0;
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
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    coverinfoentity = (PersonEntity.CoverEntity.CoverInfoEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, PersonEntity.CoverEntity.CoverInfoEntity.CREATOR);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 3: // '\003'
                    coverphotoentity = (PersonEntity.CoverEntity.CoverPhotoEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, PersonEntity.CoverEntity.CoverPhotoEntity.CREATOR);
                    hashset.add(Integer.valueOf(3));
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    hashset.add(Integer.valueOf(4));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != k)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
                }
                return new PersonEntity.CoverEntity(hashset, j, coverinfoentity, coverphotoentity, i);
            }
        } while (true);
    }

    public PersonEntity.CoverEntity[] zziE(int i)
    {
        return new PersonEntity.CoverEntity[i];
    }
}
