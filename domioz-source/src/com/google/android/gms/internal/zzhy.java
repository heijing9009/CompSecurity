// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            fk

public final class zzhy
    implements SafeParcelable
{

    public static final fk CREATOR = new fk();
    public final int a;
    public String b;
    public int c;
    public int d;
    public boolean e;

    zzhy(int i, String s, int j, int k, boolean flag)
    {
        a = i;
        b = s;
        c = j;
        d = k;
        e = flag;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        fk.a(this, parcel);
    }

}
