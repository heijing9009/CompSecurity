// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkUser

final class stFollowingResult extends j
{

    protected stFollowingResult a(String s)
    {
        return (stFollowingResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkUser$ListFollowingResult, s);
    }

    protected volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    stFollowingResult()
    {
    }
}
