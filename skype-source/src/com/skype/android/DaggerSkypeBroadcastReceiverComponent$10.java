// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.skype.android;

import dagger.internal.Factory;

// Referenced classes of package com.skype.android:
//            DaggerSkypeBroadcastReceiverComponent, SkypeApplicationComponent

final class a
    implements Factory
{

    final lder a;
    final DaggerSkypeBroadcastReceiverComponent b;
    private final SkypeApplicationComponent c;

    public final Object get()
    {
        com.skype.android.push.PushManager pushmanager = c.pushManager();
        if (pushmanager == null)
        {
            throw new NullPointerException("Cannot return null from a non-@Nullable component method");
        } else
        {
            return pushmanager;
        }
    }

    lder(DaggerSkypeBroadcastReceiverComponent daggerskypebroadcastreceivercomponent, lder lder)
    {
        b = daggerskypebroadcastreceivercomponent;
        a = lder;
        super();
        c = com.skype.android.lder.a(a);
    }
}
