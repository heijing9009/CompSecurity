// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.kit.activity;

import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.base.Events;
import com.pinterest.kit.data.Preferences;
import com.pinterest.kit.data.PreferencesManager;
import com.pinterest.network.json.PinterestJsonObject;
import com.pinterest.schemas.event.EventType;

// Referenced classes of package com.pinterest.kit.activity:
//            SocialConnectActivity

class this._cls0 extends ApiResponseHandler
{

    final SocialConnectActivity this$0;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        Events.post(new com.pinterest.base.>(com.pinterest.base.>, false));
        super.onFailure(throwable, apiresponse);
    }

    public void onSuccess(PinterestJsonObject pinterestjsonobject)
    {
        Pinalytics.a(EventType.USER_ENABLE_TWITTER, "0");
        Preferences.user().set("PREF_CONNETED_TWITTER", true);
        Preferences.user().set("PREF_SHARE_TWITTER", true);
        Events.post(new com.pinterest.base.>(com.pinterest.base.>));
        super.onSuccess(pinterestjsonobject);
    }

    (boolean flag)
    {
        this$0 = SocialConnectActivity.this;
        super(flag);
    }
}
