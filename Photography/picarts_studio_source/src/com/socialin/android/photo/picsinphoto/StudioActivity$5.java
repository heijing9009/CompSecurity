// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;


// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            StudioActivity

final class a
    implements Runnable
{

    private StudioActivity a;

    public final void run()
    {
        a.finish();
    }

    (StudioActivity studioactivity)
    {
        a = studioactivity;
        super();
    }
}
