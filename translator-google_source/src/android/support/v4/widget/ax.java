// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.view.View;
import android.widget.PopupWindow;

// Referenced classes of package android.support.v4.widget:
//            aw

class ax extends aw
{

    ax()
    {
    }

    public final void a(PopupWindow popupwindow, View view, int i, int j, int k)
    {
        popupwindow.showAsDropDown(view, i, j, k);
    }
}
