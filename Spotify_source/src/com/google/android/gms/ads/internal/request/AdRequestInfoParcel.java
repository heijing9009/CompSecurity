// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import biq;
import bja;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            CapabilityParcel

public final class AdRequestInfoParcel
    implements SafeParcelable
{

    public static final bja CREATOR = new bja();
    public final List A;
    public final long B;
    public final CapabilityParcel C;
    public final String D;
    public final int a;
    public final Bundle b;
    public final AdRequestParcel c;
    public final AdSizeParcel d;
    public final String e;
    public final ApplicationInfo f;
    public final PackageInfo g;
    public final String h;
    public final String i;
    public final String j;
    public final VersionInfoParcel k;
    public final Bundle l;
    public final int m;
    public final List n;
    public final Bundle o;
    public final boolean p;
    public final Messenger q;
    public final int r;
    public final int s;
    public final float t;
    public final String u;
    public final long v;
    public final String w;
    public final List x;
    public final String y;
    public final NativeAdOptionsParcel z;

    public AdRequestInfoParcel(int i1, Bundle bundle, AdRequestParcel adrequestparcel, AdSizeParcel adsizeparcel, String s1, ApplicationInfo applicationinfo, PackageInfo packageinfo, 
            String s2, String s3, String s4, VersionInfoParcel versioninfoparcel, Bundle bundle1, int j1, List list, 
            Bundle bundle2, boolean flag, Messenger messenger, int k1, int l1, float f1, String s5, 
            long l2, String s6, List list1, String s7, NativeAdOptionsParcel nativeadoptionsparcel, List list2, 
            long l3, CapabilityParcel capabilityparcel, String s8)
    {
        a = i1;
        b = bundle;
        c = adrequestparcel;
        d = adsizeparcel;
        e = s1;
        f = applicationinfo;
        g = packageinfo;
        h = s2;
        i = s3;
        j = s4;
        k = versioninfoparcel;
        l = bundle1;
        m = j1;
        n = list;
        if (list2 == null)
        {
            bundle = Collections.emptyList();
        } else
        {
            bundle = Collections.unmodifiableList(list2);
        }
        A = bundle;
        o = bundle2;
        p = flag;
        q = messenger;
        r = k1;
        s = l1;
        t = f1;
        u = s5;
        v = l2;
        w = s6;
        if (list1 == null)
        {
            bundle = Collections.emptyList();
        } else
        {
            bundle = Collections.unmodifiableList(list1);
        }
        x = bundle;
        y = s7;
        z = nativeadoptionsparcel;
        B = l3;
        C = capabilityparcel;
        D = s8;
    }

    private AdRequestInfoParcel(Bundle bundle, AdRequestParcel adrequestparcel, AdSizeParcel adsizeparcel, String s1, ApplicationInfo applicationinfo, PackageInfo packageinfo, String s2, 
            String s3, String s4, VersionInfoParcel versioninfoparcel, Bundle bundle1, int i1, List list, List list1, 
            Bundle bundle2, boolean flag, Messenger messenger, int j1, int k1, float f1, String s5, 
            long l1, String s6, List list2, String s7, NativeAdOptionsParcel nativeadoptionsparcel, long l2, CapabilityParcel capabilityparcel, String s8)
    {
        this(12, bundle, adrequestparcel, adsizeparcel, s1, applicationinfo, packageinfo, s2, s3, s4, versioninfoparcel, bundle1, i1, list, bundle2, flag, messenger, j1, k1, f1, s5, l1, s6, list2, s7, nativeadoptionsparcel, list1, l2, capabilityparcel, s8);
    }

    public AdRequestInfoParcel(biq biq1, String s1, long l1)
    {
        this(biq1.a, biq1.b, biq1.c, biq1.d, biq1.e, biq1.f, s1, biq1.g, biq1.h, biq1.j, biq1.i, biq1.k, biq1.l, biq1.m, biq1.n, biq1.o, biq1.p, biq1.q, biq1.r, biq1.s, biq1.t, biq1.u, biq1.v, biq1.w, biq1.x, biq1.y, l1, biq1.z, biq1.A);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        bja.a(this, parcel, i1);
    }

}
