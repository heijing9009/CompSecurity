// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package com.amazon.mShop.search:
//            SearchResultsContainer

class this._cls0
    implements android.view.ontainer._cls2
{

    final SearchResultsContainer this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if ((66 == i || 23 == i) && 1 == keyevent.getAction())
        {
            SearchResultsContainer.access$100(SearchResultsContainer.this);
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = SearchResultsContainer.this;
        super();
    }
}
