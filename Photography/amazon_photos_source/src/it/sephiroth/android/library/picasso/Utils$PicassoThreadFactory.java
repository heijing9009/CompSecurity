// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.picasso;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package it.sephiroth.android.library.picasso:
//            Utils

static class 
    implements ThreadFactory
{

    public Thread newThread(Runnable runnable)
    {
        return new (runnable);
    }

    ()
    {
    }
}
