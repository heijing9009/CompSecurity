// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.facebook:
//            GraphRequest, FacebookRequestError, AccessToken, FacebookException, 
//            LoggingBehavior, GraphRequestBatch

public class GraphResponse
{

    private final HttpURLConnection connection;
    private final FacebookRequestError error;
    private final JSONObject graphObject;
    private final JSONArray graphObjectArray;
    private final String rawResponse;
    private final GraphRequest request;

    GraphResponse(GraphRequest graphrequest, HttpURLConnection httpurlconnection, FacebookRequestError facebookrequesterror)
    {
        this(graphrequest, httpurlconnection, null, null, null, facebookrequesterror);
    }

    GraphResponse(GraphRequest graphrequest, HttpURLConnection httpurlconnection, String s, JSONArray jsonarray)
    {
        this(graphrequest, httpurlconnection, s, null, jsonarray, null);
    }

    GraphResponse(GraphRequest graphrequest, HttpURLConnection httpurlconnection, String s, JSONObject jsonobject)
    {
        this(graphrequest, httpurlconnection, s, jsonobject, null, null);
    }

    GraphResponse(GraphRequest graphrequest, HttpURLConnection httpurlconnection, String s, JSONObject jsonobject, JSONArray jsonarray, FacebookRequestError facebookrequesterror)
    {
        request = graphrequest;
        connection = httpurlconnection;
        rawResponse = s;
        graphObject = jsonobject;
        graphObjectArray = jsonarray;
        error = facebookrequesterror;
    }

    static List constructErrorResponses(List list, HttpURLConnection httpurlconnection, FacebookException facebookexception)
    {
        int j = list.size();
        ArrayList arraylist = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            arraylist.add(new GraphResponse((GraphRequest)list.get(i), httpurlconnection, new FacebookRequestError(httpurlconnection, facebookexception)));
        }

        return arraylist;
    }

    private static GraphResponse createResponseFromObject(GraphRequest graphrequest, HttpURLConnection httpurlconnection, Object obj, Object obj1)
        throws JSONException
    {
        Object obj2 = obj;
        if (obj instanceof JSONObject)
        {
            obj = (JSONObject)obj;
            obj1 = FacebookRequestError.checkResponseAndCreateError(((JSONObject) (obj)), obj1, httpurlconnection);
            if (obj1 != null)
            {
                if (((FacebookRequestError) (obj1)).getErrorCode() == 190 && Utility.isCurrentAccessToken(graphrequest.getAccessToken()))
                {
                    AccessToken.setCurrentAccessToken(null);
                }
                return new GraphResponse(graphrequest, httpurlconnection, ((FacebookRequestError) (obj1)));
            }
            obj = Utility.getStringPropertyAsJSON(((JSONObject) (obj)), "body", "FACEBOOK_NON_JSON_RESULT");
            if (obj instanceof JSONObject)
            {
                return new GraphResponse(graphrequest, httpurlconnection, obj.toString(), (JSONObject)obj);
            }
            if (obj instanceof JSONArray)
            {
                return new GraphResponse(graphrequest, httpurlconnection, obj.toString(), (JSONArray)obj);
            }
            obj2 = JSONObject.NULL;
        }
        if (obj2 == JSONObject.NULL)
        {
            return new GraphResponse(graphrequest, httpurlconnection, obj2.toString(), (JSONObject)null);
        } else
        {
            throw new FacebookException((new StringBuilder()).append("Got unexpected object type in response, class: ").append(obj2.getClass().getSimpleName()).toString());
        }
    }

    private static List createResponsesFromObject(HttpURLConnection httpurlconnection, List list, Object obj)
        throws FacebookException, JSONException
    {
        Object obj1;
        ArrayList arraylist;
        int k;
        k = list.size();
        arraylist = new ArrayList(k);
        obj1 = obj;
        if (k != 1) goto _L2; else goto _L1
_L1:
        GraphRequest graphrequest = (GraphRequest)list.get(0);
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("body", obj);
        if (httpurlconnection == null) goto _L4; else goto _L3
_L3:
        int i = httpurlconnection.getResponseCode();
_L5:
        jsonobject.put("code", i);
        obj1 = new JSONArray();
        ((JSONArray) (obj1)).put(jsonobject);
_L2:
        if (!(obj1 instanceof JSONArray) || ((JSONArray)obj1).length() != k)
        {
            throw new FacebookException("Unexpected number of results");
        }
        break MISSING_BLOCK_LABEL_195;
_L4:
        i = 200;
          goto _L5
        obj1;
        arraylist.add(new GraphResponse(graphrequest, httpurlconnection, new FacebookRequestError(httpurlconnection, ((Exception) (obj1)))));
        obj1 = obj;
          goto _L2
        obj1;
        arraylist.add(new GraphResponse(graphrequest, httpurlconnection, new FacebookRequestError(httpurlconnection, ((Exception) (obj1)))));
        obj1 = obj;
          goto _L2
        obj1 = (JSONArray)obj1;
        int j = 0;
        while (j < ((JSONArray) (obj1)).length()) 
        {
            GraphRequest graphrequest1 = (GraphRequest)list.get(j);
            try
            {
                arraylist.add(createResponseFromObject(graphrequest1, httpurlconnection, ((JSONArray) (obj1)).get(j), obj));
            }
            catch (JSONException jsonexception)
            {
                arraylist.add(new GraphResponse(graphrequest1, httpurlconnection, new FacebookRequestError(httpurlconnection, jsonexception)));
            }
            catch (FacebookException facebookexception)
            {
                arraylist.add(new GraphResponse(graphrequest1, httpurlconnection, new FacebookRequestError(httpurlconnection, facebookexception)));
            }
            j++;
        }
        return arraylist;
          goto _L5
    }

    static List createResponsesFromStream(InputStream inputstream, HttpURLConnection httpurlconnection, GraphRequestBatch graphrequestbatch)
        throws FacebookException, JSONException, IOException
    {
        inputstream = Utility.readStreamToString(inputstream);
        Logger.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", new Object[] {
            Integer.valueOf(inputstream.length()), inputstream
        });
        return createResponsesFromString(inputstream, httpurlconnection, graphrequestbatch);
    }

    static List createResponsesFromString(String s, HttpURLConnection httpurlconnection, GraphRequestBatch graphrequestbatch)
        throws FacebookException, JSONException, IOException
    {
        httpurlconnection = createResponsesFromObject(httpurlconnection, graphrequestbatch, (new JSONTokener(s)).nextValue());
        Logger.log(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", new Object[] {
            graphrequestbatch.getId(), Integer.valueOf(s.length()), httpurlconnection
        });
        return httpurlconnection;
    }

    static List fromHttpConnection(HttpURLConnection httpurlconnection, GraphRequestBatch graphrequestbatch)
    {
        InputStream inputstream;
        Object obj1;
        InputStream inputstream1;
        Object obj2;
        InputStream inputstream2;
        InputStream inputstream3;
        List list;
        Object obj3;
        Object obj4;
        Object obj5;
        list = null;
        obj3 = null;
        obj4 = null;
        obj5 = null;
        inputstream = null;
        inputstream1 = inputstream;
        obj2 = list;
        inputstream2 = obj3;
        inputstream3 = obj4;
        obj1 = obj5;
        if (httpurlconnection.getResponseCode() < 400) goto _L2; else goto _L1
_L1:
        inputstream1 = inputstream;
        obj2 = list;
        inputstream2 = obj3;
        inputstream3 = obj4;
        obj1 = obj5;
        inputstream = httpurlconnection.getErrorStream();
_L4:
        inputstream1 = inputstream;
        obj2 = inputstream;
        inputstream2 = inputstream;
        inputstream3 = inputstream;
        obj1 = inputstream;
        list = createResponsesFromStream(inputstream, httpurlconnection, graphrequestbatch);
        Utility.closeQuietly(inputstream);
        return list;
_L2:
        inputstream1 = inputstream;
        obj2 = list;
        inputstream2 = obj3;
        inputstream3 = obj4;
        obj1 = obj5;
        inputstream = httpurlconnection.getInputStream();
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        obj1 = inputstream1;
        Logger.log(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = inputstream1;
        httpurlconnection = constructErrorResponses(graphrequestbatch, httpurlconnection, ((FacebookException) (obj)));
        Utility.closeQuietly(inputstream1);
        return httpurlconnection;
        obj;
        obj1 = obj2;
        Logger.log(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = obj2;
        httpurlconnection = constructErrorResponses(graphrequestbatch, httpurlconnection, new FacebookException(((Throwable) (obj))));
        Utility.closeQuietly(((java.io.Closeable) (obj2)));
        return httpurlconnection;
        obj;
        obj1 = inputstream2;
        Logger.log(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = inputstream2;
        httpurlconnection = constructErrorResponses(graphrequestbatch, httpurlconnection, new FacebookException(((Throwable) (obj))));
        Utility.closeQuietly(inputstream2);
        return httpurlconnection;
        obj;
        obj1 = inputstream3;
        Logger.log(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", new Object[] {
            obj
        });
        obj1 = inputstream3;
        httpurlconnection = constructErrorResponses(graphrequestbatch, httpurlconnection, new FacebookException(((Throwable) (obj))));
        Utility.closeQuietly(inputstream3);
        return httpurlconnection;
        httpurlconnection;
        Utility.closeQuietly(((java.io.Closeable) (obj1)));
        throw httpurlconnection;
    }

    public final FacebookRequestError getError()
    {
        return error;
    }

    public final JSONObject getJSONObject()
    {
        return graphObject;
    }

    public String toString()
    {
        Object obj = Locale.US;
        if (connection == null) goto _L2; else goto _L1
_L1:
        int i = connection.getResponseCode();
_L3:
        obj = String.format(((Locale) (obj)), "%d", new Object[] {
            Integer.valueOf(i)
        });
_L4:
        return (new StringBuilder()).append("{Response: ").append(" responseCode: ").append(((String) (obj))).append(", graphObject: ").append(graphObject).append(", error: ").append(error).append("}").toString();
_L2:
        i = 200;
          goto _L3
        IOException ioexception;
        ioexception;
        ioexception = "unknown";
          goto _L4
    }
}
