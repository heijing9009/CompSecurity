// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.jumio.netswipe.sdk.core.ScanCardActivity;

// Referenced classes of package netswipe:
//            cc

public class n extends AnimatorListenerAdapter
{

    final ScanCardActivity a;

    public n(ScanCardActivity scancardactivity)
    {
        a = scancardactivity;
        super();
    }

    public void onAnimationEnd(Animator animator)
    {
        a.topInfoBar.setVisibility(8);
    }
}
