// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.spotify.mobile.android.porcelain.json.item;

import android.os.Parcel;
import com.spotify.mobile.android.porcelain.json.subitem.PorcelainJsonImage;
import com.spotify.mobile.android.porcelain.json.subitem.PorcelainJsonMetricsData;
import com.spotify.mobile.android.porcelain.json.subitem.PorcelainJsonNavigationLink;
import com.spotify.mobile.android.porcelain.json.subitem.PorcelainJsonPlayable;
import drn;

// Referenced classes of package com.spotify.mobile.android.porcelain.json.item:
//            PorcelainJsonBillboardItem, PorcelainJsonBaseItem

final class k extends drn
{

    public final PorcelainJsonBaseItem a(String s, PorcelainJsonMetricsData porcelainjsonmetricsdata, Parcel parcel)
    {
        return new PorcelainJsonBillboardItem(s, porcelainjsonmetricsdata, (PorcelainJsonImage)parcel.readParcelable(com/spotify/mobile/android/porcelain/json/subitem/PorcelainJsonImage.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), (PorcelainJsonNavigationLink)parcel.readParcelable(com/spotify/mobile/android/porcelain/json/subitem/PorcelainJsonNavigationLink.getClassLoader()), (PorcelainJsonNavigationLink)parcel.readParcelable(com/spotify/mobile/android/porcelain/json/subitem/PorcelainJsonNavigationLink.getClassLoader()), (PorcelainJsonPlayable)parcel.readParcelable(com/spotify/mobile/android/porcelain/json/subitem/PorcelainJsonPlayable.getClassLoader()));
    }

    public final volatile Object[] newArray(int i)
    {
        return new PorcelainJsonBillboardItem[i];
    }

    k()
    {
    }
}
