// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import com.poshmark.analytics.Analytics;
import com.poshmark.config.NewRelicWrapper;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.utils:
//            ShareManager_Old, NewRelicCustomInteractions

class this._cls0
    implements PMApiResponseHandler
{

    final ShareManager_Old this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        NewRelicWrapper.stopCustomInteraction(NewRelicCustomInteractions.SHARE_LISTING_TO_PARTY);
        ShareManager_Old.access$200(ShareManager_Old.this).hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            ShareManager_Old.access$200(ShareManager_Old.this).showAutoHideProgressDialogWithMessage(ShareManager_Old.access$300(ShareManager_Old.this).getString(0x7f060259), dismissListener);
            pmapiresponse = (new StringBuilder()).append(ShareManager_Old.access$400(ShareManager_Old.this).getIdAsString()).append("/").append(ShareManager_Old.access$400(ShareManager_Old.this).getTitle()).toString();
            Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_poshmark_poshparty", pmapiresponse);
            return;
        } else
        {
            String s = (new StringBuilder()).append(ShareManager_Old.access$400(ShareManager_Old.this).getIdAsString()).append("/").append(ShareManager_Old.access$400(ShareManager_Old.this).getTitle()).toString();
            Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_failed", s);
            ShareManager_Old.access$200(ShareManager_Old.this).showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionContext.SHARE_LISTING, ShareManager_Old.access$300(ShareManager_Old.this).getString(0x7f0600fa)));
            return;
        }
    }

    xt.ActionContext()
    {
        this$0 = ShareManager_Old.this;
        super();
    }
}
