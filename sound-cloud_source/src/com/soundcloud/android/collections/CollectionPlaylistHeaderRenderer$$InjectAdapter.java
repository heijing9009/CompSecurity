// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.collections;

import dagger.a.b;
import javax.inject.Provider;

// Referenced classes of package com.soundcloud.android.collections:
//            CollectionPlaylistHeaderRenderer

public final class  extends b
    implements Provider
{

    public final CollectionPlaylistHeaderRenderer get()
    {
        return new CollectionPlaylistHeaderRenderer();
    }

    public final volatile Object get()
    {
        return get();
    }

    public ()
    {
        super("com.soundcloud.android.collections.CollectionPlaylistHeaderRenderer", "members/com.soundcloud.android.collections.CollectionPlaylistHeaderRenderer", false, com/soundcloud/android/collections/CollectionPlaylistHeaderRenderer);
    }
}
