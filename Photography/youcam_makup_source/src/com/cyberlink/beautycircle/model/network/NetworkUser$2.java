// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkUser, NetworkManager

final class b extends j
{

    final String a;
    final long b;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.user.unfollow == null)
        {
            b(.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.user.unfollow);
            networkmanager.a("token", a);
            networkmanager.a("userId", Long.valueOf(b));
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    (String s, long l)
    {
        a = s;
        b = l;
        super();
    }
}
