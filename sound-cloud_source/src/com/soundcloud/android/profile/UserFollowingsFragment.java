// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.soundcloud.android.SoundCloudApplication;
import com.soundcloud.android.analytics.SearchQuerySourceInfo;
import com.soundcloud.android.main.Screen;
import com.soundcloud.android.model.Urn;
import com.soundcloud.android.view.MultiSwipeRefreshLayout;
import dagger.b;

// Referenced classes of package com.soundcloud.android.profile:
//            ScrollableProfileFragment, ProfileArguments, UserFollowingsPresenter

public class UserFollowingsFragment extends ScrollableProfileFragment
{

    UserFollowingsPresenter presenter;

    public UserFollowingsFragment()
    {
        setRetainInstance(true);
        SoundCloudApplication.getObjectGraph().a(this);
    }

    public static UserFollowingsFragment create(Urn urn, Screen screen, SearchQuerySourceInfo searchquerysourceinfo)
    {
        UserFollowingsFragment userfollowingsfragment = new UserFollowingsFragment();
        userfollowingsfragment.setArguments(ProfileArguments.from(urn, screen, searchquerysourceinfo));
        return userfollowingsfragment;
    }

    public MultiSwipeRefreshLayout getRefreshLayout()
    {
        return (MultiSwipeRefreshLayout)getView().findViewById(0x7f0f0153);
    }

    public View[] getRefreshableViews()
    {
        return (new View[] {
            presenter.getRecyclerView(), presenter.getEmptyView()
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030056, viewgroup, false);
    }
}
