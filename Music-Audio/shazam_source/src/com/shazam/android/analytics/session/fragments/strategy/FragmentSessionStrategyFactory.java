// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.fragments.strategy;

import com.shazam.android.analytics.session.SessionStrategyType;

// Referenced classes of package com.shazam.android.analytics.session.fragments.strategy:
//            FragmentSessionStrategy

public interface FragmentSessionStrategyFactory
{

    public abstract FragmentSessionStrategy createSessionStrategy(SessionStrategyType sessionstrategytype);
}
