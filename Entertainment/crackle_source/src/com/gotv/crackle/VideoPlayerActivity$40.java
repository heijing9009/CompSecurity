// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import com.gotv.crackle.adapters.DeviceListAdapter;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements android.widget.Listener
{

    final VideoPlayerActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        VideoPlayerActivity.access$8102(VideoPlayerActivity.this, VideoPlayerActivity.access$7700(VideoPlayerActivity.this).getItem(i));
        VideoPlayerActivity.access$7700(VideoPlayerActivity.this).setCurIndex(i);
        VideoPlayerActivity.access$7700(VideoPlayerActivity.this).notifyDataSetChanged();
        VideoPlayerActivity.access$8000(VideoPlayerActivity.this).getButton(-1).setEnabled(true);
    }

    ter()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
