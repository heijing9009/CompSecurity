// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            MoPubRewardedVideoManager, MoPubRewardedVideoListener

final class rEachMoPubIdRunnable extends rEachMoPubIdRunnable
{

    protected final void forEach(String s)
    {
        if (MoPubRewardedVideoManager.access$400(MoPubRewardedVideoManager.access$200()) != null)
        {
            MoPubRewardedVideoManager.access$400(MoPubRewardedVideoManager.access$200()).onRewardedVideoClosed(s);
        }
    }

    rEachMoPubIdRunnable(Class class1, String s)
    {
        super(class1, s);
    }
}
