// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.SeekBar;
import com.fotoable.shareinstagram.HandleBmpView;
import com.fotoable.shareinstagram.InstagramPhotoShareActivity;

public class aus
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final InstagramPhotoShareActivity a;

    public aus(InstagramPhotoShareActivity instagramphotoshareactivity)
    {
        a = instagramphotoshareactivity;
        super();
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        a.s = i;
        if (a.p != null)
        {
            a.p.setCornerRadius(a.s);
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
    }
}
