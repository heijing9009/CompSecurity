// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.groupon.view:
//            MapSliceImprovedView

private class <init>
    implements Callback
{

    final MapSliceImprovedView this$0;

    public void onError(ImageView imageview)
    {
    }

    public void onSuccess(ImageView imageview)
    {
        if (((BitmapDrawable)imageview.getDrawable()).getBitmap() == null)
        {
            message.setVisibility(0);
        }
    }

    private ()
    {
        this$0 = MapSliceImprovedView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
