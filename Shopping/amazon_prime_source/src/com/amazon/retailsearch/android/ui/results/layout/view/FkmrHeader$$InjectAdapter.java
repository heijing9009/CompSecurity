// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.view:
//            FkmrHeader

public final class  extends Binding
    implements MembersInjector
{

    private Binding preferencesManager;
    private Binding userInteractionListener;

    public void attach(Linker linker)
    {
        userInteractionListener = linker.requestBinding("com.amazon.retailsearch.interaction.UserInteractionListener", com/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader, getClass().getClassLoader());
        preferencesManager = linker.requestBinding("com.amazon.retailsearch.userpreferences.UserPreferenceManager", com/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(userInteractionListener);
        set1.add(preferencesManager);
    }

    public void injectMembers(FkmrHeader fkmrheader)
    {
        fkmrheader.userInteractionListener = (UserInteractionListener)userInteractionListener.get();
        fkmrheader.preferencesManager = (UserPreferenceManager)preferencesManager.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((FkmrHeader)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.results.layout.view.FkmrHeader", false, com/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader);
    }
}
