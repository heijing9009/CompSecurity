// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseUser

class 
    implements ct
{

    final ParseUser this$0;
    final Map val$authData;
    final String val$authType;
    final String val$sessionToken;

    public cu then(cu cu)
        throws Exception
    {
        return ParseUser.access$2400(ParseUser.this, val$authType, val$authData, cu, val$sessionToken);
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    ()
    {
        this$0 = final_parseuser;
        val$authType = s;
        val$authData = map;
        val$sessionToken = String.this;
        super();
    }
}
