// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzs, zzx

static abstract class ent extends zzs
{

    public com.google.android.gms.drive.der.DriveFolderResult zzE(Status status)
    {
        return new <init>(status, null);
    }

    public Result zzb(Status status)
    {
        return zzE(status);
    }

    ent(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }
}
