// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.upstream;

import java.io.IOException;

// Referenced classes of package shared_presage.com.google.android.exoplayer.upstream:
//            NetworkLock

public static class  extends IOException
{

    public (int i, int j)
    {
        super((new StringBuilder("Priority too low [priority=")).append(i).append(", highest=").append(j).append("]").toString());
    }
}
