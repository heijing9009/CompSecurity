// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;


// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            DibicProgramFilter

public interface DibicProgramFilterFactory
{

    public abstract DibicProgramFilter createDefaultFilter();

    public abstract DibicProgramFilter createNetworkFilter();
}
