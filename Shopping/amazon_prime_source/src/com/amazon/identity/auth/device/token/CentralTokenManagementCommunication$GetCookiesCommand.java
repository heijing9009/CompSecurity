// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.os.Bundle;
import com.amazon.identity.auth.device.framework.IPCCommand;
import com.amazon.identity.auth.device.framework.Tracer;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            CentralTokenManagementCommunication

public static class a
    implements IPCCommand
{

    public static Bundle parametersToBundle(String s, String s1, Bundle bundle, Tracer tracer)
    {
        Bundle bundle1 = new Bundle();
        bundle1.putString("directed_id", s);
        bundle1.putString("domain", s1);
        bundle1.putBundle("options_key", bundle);
        tracer.addToBundle(bundle1);
        return bundle1;
    }

    public a()
    {
    }
}
