// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightcove.player.analytics;

import com.brightcove.player.event.Event;
import com.brightcove.player.event.EventListener;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.brightcove.player.analytics:
//            Analytics

final class a
    implements EventListener
{

    private Analytics a;

    public final void processEvent(Event event)
    {
        URI uri = (URI)event.properties.get("catalogUrl");
        long l = ((Long)event.properties.get("responseTimeMs")).longValue();
        HashMap hashmap = new HashMap();
        hashmap.put("catalog_url", uri.toString());
        hashmap.put("response_time_ms", Long.toString(l));
        Analytics.a(a, event, "catalog_response", hashmap);
        Analytics.c(a, System.currentTimeMillis());
    }

    (Analytics analytics)
    {
        a = analytics;
        super();
    }
}
