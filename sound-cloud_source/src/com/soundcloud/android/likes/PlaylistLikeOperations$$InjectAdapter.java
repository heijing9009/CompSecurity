// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.likes;

import com.soundcloud.android.sync.SyncInitiator;
import com.soundcloud.android.utils.NetworkConnectionHelper;
import com.soundcloud.rx.eventbus.EventBus;
import dagger.a.b;
import dagger.a.l;
import java.util.Set;
import javax.inject.Provider;
import rx.R;

// Referenced classes of package com.soundcloud.android.likes:
//            PlaylistLikeOperations, PlaylistLikesStorage

public final class  extends b
    implements Provider
{

    private b eventBus;
    private b networkConnectionHelper;
    private b scheduler;
    private b storage;
    private b syncInitiator;

    public final void attach(l l1)
    {
        storage = l1.a("com.soundcloud.android.likes.PlaylistLikesStorage", com/soundcloud/android/likes/PlaylistLikeOperations, getClass().getClassLoader());
        syncInitiator = l1.a("com.soundcloud.android.sync.SyncInitiator", com/soundcloud/android/likes/PlaylistLikeOperations, getClass().getClassLoader());
        eventBus = l1.a("com.soundcloud.rx.eventbus.EventBus", com/soundcloud/android/likes/PlaylistLikeOperations, getClass().getClassLoader());
        scheduler = l1.a("@javax.inject.Named(value=HighPriority)/rx.Scheduler", com/soundcloud/android/likes/PlaylistLikeOperations, getClass().getClassLoader());
        networkConnectionHelper = l1.a("com.soundcloud.android.utils.NetworkConnectionHelper", com/soundcloud/android/likes/PlaylistLikeOperations, getClass().getClassLoader());
    }

    public final PlaylistLikeOperations get()
    {
        return new PlaylistLikeOperations((PlaylistLikesStorage)storage.get(), (SyncInitiator)syncInitiator.get(), (EventBus)eventBus.get(), (R)scheduler.get(), (NetworkConnectionHelper)networkConnectionHelper.get());
    }

    public final volatile Object get()
    {
        return get();
    }

    public final void getDependencies(Set set, Set set1)
    {
        set.add(storage);
        set.add(syncInitiator);
        set.add(eventBus);
        set.add(scheduler);
        set.add(networkConnectionHelper);
    }

    public ()
    {
        super("com.soundcloud.android.likes.PlaylistLikeOperations", "members/com.soundcloud.android.likes.PlaylistLikeOperations", false, com/soundcloud/android/likes/PlaylistLikeOperations);
    }
}
