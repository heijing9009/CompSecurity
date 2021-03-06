// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.oauth.signpost.commonshttpandroid;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import com.comcast.cim.httpcomponentsandroid.HttpEntityEnclosingRequest;
import com.comcast.cim.httpcomponentsandroid.RequestLine;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import oauth.signpost.http.HttpRequest;

public class HttpRequestAdapter
    implements HttpRequest
{

    private HttpEntity entity;
    private HttpUriRequest request;

    public HttpRequestAdapter(HttpUriRequest httpurirequest)
    {
        request = httpurirequest;
        if (httpurirequest instanceof HttpEntityEnclosingRequest)
        {
            entity = ((HttpEntityEnclosingRequest)httpurirequest).getEntity();
        }
    }

    public Map getAllHeaders()
    {
        Header aheader[] = request.getAllHeaders();
        HashMap hashmap = new HashMap();
        int j = aheader.length;
        for (int i = 0; i < j; i++)
        {
            Header header = aheader[i];
            hashmap.put(header.getName(), header.getValue());
        }

        return hashmap;
    }

    public String getContentType()
    {
        Header header;
        if (entity != null)
        {
            if ((header = entity.getContentType()) != null)
            {
                return header.getValue();
            }
        }
        return null;
    }

    public String getHeader(String s)
    {
        s = request.getFirstHeader(s);
        if (s == null)
        {
            return null;
        } else
        {
            return s.getValue();
        }
    }

    public InputStream getMessagePayload()
        throws IOException
    {
        if (entity == null)
        {
            return null;
        } else
        {
            return entity.getContent();
        }
    }

    public String getMethod()
    {
        return request.getRequestLine().getMethod();
    }

    public String getRequestUrl()
    {
        return request.getURI().toString();
    }

    public void setHeader(String s, String s1)
    {
        request.setHeader(s, s1);
    }

    public void setRequestUrl(String s)
    {
        throw new RuntimeException(new UnsupportedOperationException());
    }
}
