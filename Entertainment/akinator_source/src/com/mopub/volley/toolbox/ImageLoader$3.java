// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.volley.toolbox;

import com.mopub.volley.VolleyError;

// Referenced classes of package com.mopub.volley.toolbox:
//            ImageLoader

class val.cacheKey
    implements com.mopub.volley.Listener
{

    final ImageLoader this$0;
    final String val$cacheKey;

    public void onErrorResponse(VolleyError volleyerror)
    {
        onGetImageError(val$cacheKey, volleyerror);
    }

    ()
    {
        this$0 = final_imageloader;
        val$cacheKey = String.this;
        super();
    }
}
