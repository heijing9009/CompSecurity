// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            PlayersImpl

class zzQs
    implements com.google.android.gms.games.ResultImpl._cls1
{

    final Status zzQs;
    final zzQs zzavx;

    public Status getStatus()
    {
        return zzQs;
    }

    public boolean isProfileVisible()
    {
        return true;
    }

    public boolean isVisibilityExplicitlySet()
    {
        return false;
    }

    ( , Status status)
    {
        zzavx = ;
        zzQs = status;
        super();
    }
}
