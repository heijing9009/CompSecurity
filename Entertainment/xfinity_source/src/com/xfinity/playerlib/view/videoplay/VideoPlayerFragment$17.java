// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.videoplay;

import android.view.View;
import android.widget.LinearLayout;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.xfinity.playerlib.view.videoplay:
//            VideoPlayerFragment

class this._cls0
    implements android.view.r
{

    final VideoPlayerFragment this$0;

    public boolean onLongClick(View view)
    {
        view = (PlayerUserSettings)VideoPlayerFragment.access$2700(VideoPlayerFragment.this).getUserSettings();
        boolean flag;
        if (!((PlayerUserSettings)VideoPlayerFragment.access$2700(VideoPlayerFragment.this).getUserSettings()).getWantsVolumeControl())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setWantsVolumeControl(flag);
        updateVolumeSlider();
        if (((PlayerUserSettings)VideoPlayerFragment.access$2700(VideoPlayerFragment.this).getUserSettings()).getWantsVolumeControl() && VideoPlayerFragment.access$2600(VideoPlayerFragment.this).getVisibility() == 0)
        {
            volumeSliderLayout.setVisibility(0);
        } else
        if (!((PlayerUserSettings)VideoPlayerFragment.access$2700(VideoPlayerFragment.this).getUserSettings()).getWantsVolumeControl() && volumeSliderLayout.getVisibility() == 0)
        {
            volumeSliderLayout.setVisibility(4);
            return false;
        }
        return false;
    }

    A()
    {
        this$0 = VideoPlayerFragment.this;
        super();
    }
}
