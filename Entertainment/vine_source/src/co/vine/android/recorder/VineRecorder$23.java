// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.View;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder

class this._cls0
    implements android.view.ener
{

    final VineRecorder this$0;

    public void onClick(View view)
    {
        boolean flag = true;
        if (VineRecorder.access$3500(VineRecorder.this) && VineRecorder.access$3600(VineRecorder.this) >= (long)mThresholdMs)
        {
            VineRecorder.access$3700(VineRecorder.this, true);
            VineRecorder.access$3800(VineRecorder.this, false);
            return;
        }
        view = VineRecorder.this;
        View view1 = VineRecorder.access$3900(VineRecorder.this);
        if (VineRecorder.access$4000(VineRecorder.this))
        {
            flag = false;
        }
        view.setEditMode(view1, flag, false);
    }

    ()
    {
        this$0 = VineRecorder.this;
        super();
    }
}
