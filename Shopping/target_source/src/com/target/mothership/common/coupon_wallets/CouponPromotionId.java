// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.coupon_wallets;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.util.o;

public class CouponPromotionId
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CouponPromotionId a(Parcel parcel)
        {
            return new CouponPromotionId(parcel);
        }

        public CouponPromotionId[] a(int i)
        {
            return new CouponPromotionId[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private String mRawId;

    public CouponPromotionId(Parcel parcel)
    {
        mRawId = parcel.readString();
    }

    public CouponPromotionId(String s)
    {
        if (o.c(s))
        {
            throw new IllegalArgumentException("coupon code may not be blank or null");
        } else
        {
            mRawId = s;
            return;
        }
    }

    public String a()
    {
        return mRawId;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (CouponPromotionId)obj;
            if (mRawId == null ? ((CouponPromotionId) (obj)).mRawId != null : !mRawId.equals(((CouponPromotionId) (obj)).mRawId))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return mRawId.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mRawId);
    }

}
