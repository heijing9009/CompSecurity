// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.LoginRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder, NotificationTargetDefaultEncoder

public class LoginRequestDefaultEncoder
    implements Encoder
{

    public LoginRequestDefaultEncoder()
    {
    }

    public void encode(LoginRequest loginrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(loginrequest.getEmail(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(loginrequest.getPassword(), dataoutputstream);
        boolean flag;
        if (loginrequest.getOneClickDeviceName() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(loginrequest.getOneClickDeviceName(), dataoutputstream);
        }
        if (loginrequest.getNotificationTarget() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            (new NotificationTargetDefaultEncoder()).encode(loginrequest.getNotificationTarget(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((LoginRequest)obj, dataoutputstream);
    }
}
