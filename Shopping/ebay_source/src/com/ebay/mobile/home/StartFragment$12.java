// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.sell.lists.SellingListActivity;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements com.ebay.mobile.common.view.Listener
{

    final StartFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        view = new Intent(getActivity(), com/ebay/mobile/sell/lists/SellingListActivity);
        view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("HomePage", "drafts", "sell"));
        view.putExtra("listType", com.ebay.mobile.sell.lists.ty.ListType.DRAFT);
        startActivity(view);
    }

    Activity.ListType()
    {
        this$0 = StartFragment.this;
        super();
    }
}
