// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.activity.a;

import com.target.ui.util.deep_link.PromotionParams;

// Referenced classes of package com.target.ui.activity.a:
//            b

public class a
    implements b
{

    private b.a mPromotionDeepLinkFeatureListener;

    public a(b.a a1)
    {
        mPromotionDeepLinkFeatureListener = a1;
    }

    public void a(PromotionParams promotionparams)
    {
        mPromotionDeepLinkFeatureListener.a(promotionparams);
    }
}
