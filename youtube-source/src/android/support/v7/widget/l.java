// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package android.support.v7.widget:
//            SearchView

final class l
    implements android.widget.TextView.OnEditorActionListener
{

    final SearchView a;

    l(SearchView searchview)
    {
        a = searchview;
        super();
    }

    public final boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        SearchView.j(a);
        return true;
    }
}
