// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.plus.internal.e;

// Referenced classes of package com.google.android.gms.internal:
//            kn

class <init> extends <init>
{

    final kn ack;
    final String acm[];

    protected volatile void a(com.google.android.gms.common.api. )
        throws RemoteException
    {
        a((e));
    }

    protected void a(e e1)
    {
        e1.d(this, acm);
    }

    e(kn kn1, String as[])
    {
        ack = kn1;
        acm = as;
        super(null);
    }
}
