// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzbt

public class zzbs
    implements zzbt
{

    public zzbs()
    {
    }

    public List zza(AdRequestInfoParcel adrequestinfoparcel)
    {
        if (adrequestinfoparcel.zzED == null)
        {
            return Collections.emptyList();
        } else
        {
            return adrequestinfoparcel.zzED;
        }
    }
}
