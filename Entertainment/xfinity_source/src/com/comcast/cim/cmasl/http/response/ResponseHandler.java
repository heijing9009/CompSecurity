// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.response;

import java.io.InputStream;

// Referenced classes of package com.comcast.cim.cmasl.http.response:
//            ResponseHeadersHandler

public interface ResponseHandler
    extends ResponseHeadersHandler
{

    public abstract void handleResponseBody(InputStream inputstream);
}
