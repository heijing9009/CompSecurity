// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import android.app.Application;
import android.content.Intent;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.android.apiv3.request.UploadParams;
import com.socialin.android.util.b;
import com.socialin.asyncnet.Request;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class AddPhotoController extends BaseSocialinApiRequestController
{

    int requestId;

    public AddPhotoController()
    {
        requestId = -1;
        params = new UploadParams();
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (UploadParams)requestparams);
    }

    public void doRequest(String s, UploadParams uploadparams)
    {
        params = uploadparams;
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().addPhoto(uploadparams, s, this);
            return;
        }
    }

    public int getRequestId()
    {
        return requestId;
    }

    public void onSuccess(ImageItem imageitem, Request request)
    {
        if (imageitem != null && "success".equals(imageitem.status) && SocialinV3.getInstance().isRegistered())
        {
            if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
            {
                b.a(SocialinV3.getInstance().getContext()).b("# of Photos on Picsart", 1);
            }
            User user = SocialinV3.getInstance().getUser();
            user.photosCount = user.photosCount + 1;
            SocialinV3.getInstance().getContext().sendBroadcast(new Intent("com.picsart.studio.update.user.action"));
        }
        super.onSuccess(imageitem, request);
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((ImageItem)response, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((ImageItem)obj, request);
    }
}
