// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import org.json.JSONObject;

// Referenced classes of package com.crashlytics.android.core:
//            UserMetaData

final class il extends JSONObject
{

    final UserMetaData val$userData;

    ()
    {
        val$userData = usermetadata;
        super();
        put("userId", val$userData.id);
        put("userName", val$userData.name);
        put("userEmail", val$userData.email);
    }
}
