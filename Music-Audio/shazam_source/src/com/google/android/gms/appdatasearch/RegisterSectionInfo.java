// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            i, Feature

public class RegisterSectionInfo
    implements SafeParcelable
{
    public static final class a
    {

        final String a;
        String b;
        boolean c;
        int d;
        boolean e;
        String f;
        final List g = new ArrayList();
        BitSet h;
        String i;

        public a(String s)
        {
            a = s;
            d = 1;
        }
    }


    public static final i CREATOR = new i();
    final int a;
    public final String b;
    public final String c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final String g;
    public final Feature h[];
    final int i[];
    public final String j;

    RegisterSectionInfo(int k, String s, String s1, boolean flag, int l, boolean flag1, String s2, 
            Feature afeature[], int ai[], String s3)
    {
        a = k;
        b = s;
        c = s1;
        d = flag;
        e = l;
        f = flag1;
        g = s2;
        h = afeature;
        i = ai;
        j = s3;
    }

    RegisterSectionInfo(String s, String s1, boolean flag, int k, boolean flag1, String s2, Feature afeature[], 
            int ai[], String s3)
    {
        this(2, s, s1, flag, k, flag1, s2, afeature, ai, s3);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int k)
    {
        com.google.android.gms.appdatasearch.i.a(this, parcel, k);
    }

}
