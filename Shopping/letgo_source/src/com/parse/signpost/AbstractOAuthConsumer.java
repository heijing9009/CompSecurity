// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.signpost;

import com.parse.signpost.basic.UrlStringRequestAdapter;
import com.parse.signpost.exception.OAuthCommunicationException;
import com.parse.signpost.exception.OAuthExpectationFailedException;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;
import com.parse.signpost.signature.AuthorizationHeaderSigningStrategy;
import com.parse.signpost.signature.HmacSha1MessageSigner;
import com.parse.signpost.signature.OAuthMessageSigner;
import com.parse.signpost.signature.QueryStringSigningStrategy;
import com.parse.signpost.signature.SigningStrategy;
import java.io.IOException;
import java.util.Random;

// Referenced classes of package com.parse.signpost:
//            OAuthConsumer, OAuth

public abstract class AbstractOAuthConsumer
    implements OAuthConsumer
{

    private static final long serialVersionUID = 1L;
    private HttpParameters additionalParameters;
    private String consumerKey;
    private String consumerSecret;
    private OAuthMessageSigner messageSigner;
    private HttpParameters requestParameters;
    private boolean sendEmptyTokens;
    private SigningStrategy signingStrategy;
    private String token;

    public AbstractOAuthConsumer(String s, String s1)
    {
        consumerKey = s;
        consumerSecret = s1;
        setMessageSigner(new HmacSha1MessageSigner());
        setSigningStrategy(new AuthorizationHeaderSigningStrategy());
    }

    protected void collectBodyParameters(HttpRequest httprequest, HttpParameters httpparameters)
        throws IOException
    {
        String s = httprequest.getContentType();
        if (s != null && s.startsWith("application/x-www-form-urlencoded"))
        {
            httpparameters.putAll(OAuth.decodeForm(httprequest.getMessagePayload()), true);
        }
    }

    protected void collectHeaderParameters(HttpRequest httprequest, HttpParameters httpparameters)
    {
        httpparameters.putAll(OAuth.oauthHeaderToParamsMap(httprequest.getHeader("Authorization")), false);
    }

    protected void collectQueryParameters(HttpRequest httprequest, HttpParameters httpparameters)
    {
        httprequest = httprequest.getRequestUrl();
        int i = httprequest.indexOf('?');
        if (i >= 0)
        {
            httpparameters.putAll(OAuth.decodeForm(httprequest.substring(i + 1)), true);
        }
    }

    protected void completeOAuthParameters(HttpParameters httpparameters)
    {
        if (!httpparameters.containsKey("oauth_consumer_key"))
        {
            httpparameters.put("oauth_consumer_key", consumerKey, true);
        }
        if (!httpparameters.containsKey("oauth_signature_method"))
        {
            httpparameters.put("oauth_signature_method", messageSigner.getSignatureMethod(), true);
        }
        if (!httpparameters.containsKey("oauth_timestamp"))
        {
            httpparameters.put("oauth_timestamp", generateTimestamp(), true);
        }
        if (!httpparameters.containsKey("oauth_nonce"))
        {
            httpparameters.put("oauth_nonce", generateNonce(), true);
        }
        if (!httpparameters.containsKey("oauth_version"))
        {
            httpparameters.put("oauth_version", "1.0", true);
        }
        if (!httpparameters.containsKey("oauth_token") && (token != null && !token.equals("") || sendEmptyTokens))
        {
            httpparameters.put("oauth_token", token, true);
        }
    }

    protected String generateNonce()
    {
        return Long.toString((new Random()).nextLong());
    }

    protected String generateTimestamp()
    {
        return Long.toString(System.currentTimeMillis() / 1000L);
    }

    public String getConsumerKey()
    {
        return consumerKey;
    }

    public String getConsumerSecret()
    {
        return consumerSecret;
    }

    public HttpParameters getRequestParameters()
    {
        return requestParameters;
    }

    public String getToken()
    {
        return token;
    }

    public String getTokenSecret()
    {
        return messageSigner.getTokenSecret();
    }

    public void setAdditionalParameters(HttpParameters httpparameters)
    {
        additionalParameters = httpparameters;
    }

    public void setMessageSigner(OAuthMessageSigner oauthmessagesigner)
    {
        messageSigner = oauthmessagesigner;
        oauthmessagesigner.setConsumerSecret(consumerSecret);
    }

    public void setSendEmptyTokens(boolean flag)
    {
        sendEmptyTokens = flag;
    }

    public void setSigningStrategy(SigningStrategy signingstrategy)
    {
        signingStrategy = signingstrategy;
    }

    public void setTokenWithSecret(String s, String s1)
    {
        token = s;
        messageSigner.setTokenSecret(s1);
    }

    public HttpRequest sign(HttpRequest httprequest)
        throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException
    {
        if (consumerKey == null)
        {
            throw new OAuthExpectationFailedException("consumer key not set");
        }
        if (consumerSecret == null)
        {
            throw new OAuthExpectationFailedException("consumer secret not set");
        }
        requestParameters = new HttpParameters();
        String s;
        try
        {
            if (additionalParameters != null)
            {
                requestParameters.putAll(additionalParameters, false);
            }
            collectHeaderParameters(httprequest, requestParameters);
            collectQueryParameters(httprequest, requestParameters);
            collectBodyParameters(httprequest, requestParameters);
            completeOAuthParameters(requestParameters);
            requestParameters.remove("oauth_signature");
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequest httprequest)
        {
            throw new OAuthCommunicationException(httprequest);
        }
        s = messageSigner.sign(httprequest, requestParameters);
        OAuth.debugOut("signature", s);
        signingStrategy.writeSignature(s, httprequest, requestParameters);
        OAuth.debugOut("Auth header", httprequest.getHeader("Authorization"));
        OAuth.debugOut("Request URL", httprequest.getRequestUrl());
        return httprequest;
    }

    public HttpRequest sign(Object obj)
        throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException
    {
        return sign(wrap(obj));
    }

    public String sign(String s)
        throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException
    {
        s = new UrlStringRequestAdapter(s);
        SigningStrategy signingstrategy = signingStrategy;
        signingStrategy = new QueryStringSigningStrategy();
        sign(((HttpRequest) (s)));
        signingStrategy = signingstrategy;
        return s.getRequestUrl();
    }

    protected abstract HttpRequest wrap(Object obj);
}
