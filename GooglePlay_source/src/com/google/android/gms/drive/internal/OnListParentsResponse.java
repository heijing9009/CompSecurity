// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnListParentsResponseCreator

public class OnListParentsResponse extends WriteAwareParcelable
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new OnListParentsResponseCreator();
    final DataHolder mParents;
    final int mVersionCode;

    OnListParentsResponse(int i, DataHolder dataholder)
    {
        mVersionCode = i;
        mParents = dataholder;
    }

    public int describeContents()
    {
        return 0;
    }

    protected final void doWriteToParcel(Parcel parcel, int i)
    {
        OnListParentsResponseCreator.writeToParcel(this, parcel, i);
    }

}
