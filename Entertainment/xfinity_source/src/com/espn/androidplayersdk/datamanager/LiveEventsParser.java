// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.content.ContentValues;
import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            JSONParserAbstract, DataManager, FeedsDB

class LiveEventsParser extends JSONParserAbstract
{

    boolean sendPartialErrorBroadcast;
    boolean sendSuccessBroadcast;

    LiveEventsParser()
    {
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = false;
    }

    public void errorHandler(int i)
    {
        if (i == 2)
        {
            sendBroadcast("com.espn.action.LIVE_EVENT_DATA_ERROR");
        }
    }

    public void parse(JSONObject jsonobject, HashMap hashmap)
    {
        Utils.sdkLog("LiveEventsParser", 3, null);
        ContentValues contentvalues;
        ContentValues contentvalues1;
        JSONArray jsonarray;
        int j;
        contentvalues1 = new ContentValues();
        contentvalues = new ContentValues();
        if (hashmap.containsKey("eventWhere") && hashmap.containsKey("eventWhereArg"))
        {
            DataManager.feedsDbConn.delAllRows("events", (String)hashmap.get("eventWhere"), (String[])hashmap.get("eventWhereArg"));
        }
        jsonarray = jsonobject.getJSONArray("listings");
        j = jsonarray.length();
        if (j <= 0) goto _L2; else goto _L1
_L1:
        sendSuccessBroadcast = true;
        int i = 0;
_L14:
        if (i < j) goto _L4; else goto _L3
_L3:
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        boolean flag = hashmap.containsKey("ttl");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        contentvalues.put("ttl", Utils.getExpiryTime(Integer.parseInt((String)hashmap.get("ttl"))));
_L9:
        contentvalues.put("eventsType", "live");
        if (jsonobject.has("omniture") && !jsonobject.isNull("omniture"))
        {
            contentvalues.put("omnitureJson", jsonobject.getJSONObject("omniture").toString());
        }
        if (jsonobject.has("resultsLimit") && !jsonobject.isNull("resultsLimit"))
        {
            contentvalues.put("count", jsonobject.getString("resultsLimit"));
        }
        contentvalues.put("eventRelationId", "1");
        DataManager.feedsDbConn.insertOrUpdateMetaEventsTable(contentvalues);
_L2:
        if (!sendSuccessBroadcast) goto _L6; else goto _L5
_L5:
        sendBroadcast("com.espn.action.LIVE_EVENT_UPDATED");
_L11:
        return;
_L4:
        contentvalues1.clear();
        JSONObject jsonobject1 = jsonarray.getJSONObject(i);
        if (jsonobject1.has("broadcastStartTime") && !jsonobject1.isNull("broadcastStartTime"))
        {
            contentvalues1.put("broadcastStartTime", jsonobject1.getString("broadcastStartTime"));
        }
        if (jsonobject1.has("description") && !jsonobject1.isNull("description"))
        {
            contentvalues1.put("description", jsonobject1.getString("description"));
        }
        if (jsonobject1.has("blackouts") && !jsonobject1.isNull("blackouts"))
        {
            contentvalues1.put("blackoutsJason", jsonobject1.getJSONArray("blackouts").toString());
        }
        if (jsonobject1.has("categories") && !jsonobject1.isNull("categories"))
        {
            Object obj = jsonobject1.getJSONArray("categories");
            if (((JSONArray) (obj)).length() > 0)
            {
                obj = ((JSONArray) (obj)).getJSONObject(0);
                if (((JSONObject) (obj)).has("name") && !((JSONObject) (obj)).isNull("name"))
                {
                    contentvalues1.put("SPORT", ((JSONObject) (obj)).getString("name"));
                }
                if (((JSONObject) (obj)).has("abbreviation") && !((JSONObject) (obj)).isNull("abbreviation"))
                {
                    contentvalues1.put("sportCode", ((JSONObject) (obj)).getString("abbreviation"));
                }
            }
        }
        if (jsonobject1.has("program") && !jsonobject1.isNull("program"))
        {
            JSONObject jsonobject2 = jsonobject1.getJSONObject("program");
            if (jsonobject2.has("code") && !jsonobject2.isNull("code"))
            {
                contentvalues1.put("programingCode", jsonobject2.getString("code"));
            }
        }
        if (jsonobject1.has("type") && !jsonobject1.isNull("type"))
        {
            contentvalues1.put("eventType", jsonobject1.getString("type"));
        }
        if (jsonobject1.has("endTime") && !jsonobject1.isNull("endTime"))
        {
            contentvalues1.put("endTime", jsonobject1.getString("endTime"));
        }
        if (jsonobject1.has("subcategories") && !jsonobject1.isNull("subcategories"))
        {
            Object obj1 = jsonobject1.getJSONArray("subcategories");
            if (((JSONArray) (obj1)).length() > 0)
            {
                obj1 = ((JSONArray) (obj1)).getJSONObject(0);
                if (((JSONObject) (obj1)).has("id") && !((JSONObject) (obj1)).isNull("id"))
                {
                    contentvalues1.put("league", ((JSONObject) (obj1)).getString("id"));
                }
                if (((JSONObject) (obj1)).has("name") && !((JSONObject) (obj1)).isNull("name"))
                {
                    contentvalues1.put("leagueName", ((JSONObject) (obj1)).getString("name"));
                }
            }
        }
        if (jsonobject1.has("broadcasts") && !jsonobject1.isNull("broadcasts"))
        {
            Object obj2 = jsonobject1.getJSONArray("broadcasts");
            if (((JSONArray) (obj2)).length() > 0)
            {
                obj2 = ((JSONArray) (obj2)).getJSONObject(0);
                if (((JSONObject) (obj2)).has("abbreviation") && !((JSONObject) (obj2)).isNull("abbreviation"))
                {
                    contentvalues1.put("networkCode", ((JSONObject) (obj2)).getString("abbreviation"));
                }
                if (((JSONObject) (obj2)).has("name") && !((JSONObject) (obj2)).isNull("name"))
                {
                    contentvalues1.put("networkName", ((JSONObject) (obj2)).getString("name"));
                }
                if (((JSONObject) (obj2)).has("ncsId") && !((JSONObject) (obj2)).isNull("ncsId"))
                {
                    contentvalues1.put("networkId", ((JSONObject) (obj2)).getString("ncsId"));
                    contentvalues.put("networkId", ((JSONObject) (obj2)).getString("ncsId"));
                }
                if (((JSONObject) (obj2)).has("adobeResource") && !((JSONObject) (obj2)).isNull("adobeResource"))
                {
                    contentvalues1.put("networkResourceId", ((JSONObject) (obj2)).getString("adobeResource"));
                }
            }
        }
        if (jsonobject1.has("guid") && !jsonobject1.isNull("guid"))
        {
            contentvalues1.put("guid", jsonobject1.getString("guid"));
        }
        if (jsonobject1.has("startTime") && !jsonobject1.isNull("startTime"))
        {
            contentvalues1.put("startTime", jsonobject1.getString("startTime"));
        }
        if (jsonobject1.has("id") && !jsonobject1.isNull("id"))
        {
            contentvalues1.put("eventId", jsonobject1.getString("id"));
        }
        if (jsonobject1.has("name") && !jsonobject1.isNull("name"))
        {
            contentvalues1.put("showName", jsonobject1.getString("name"));
        }
        if (jsonobject1.has("simulcastAiringId") && !jsonobject1.isNull("simulcastAiringId"))
        {
            contentvalues1.put("simulcastAiringId", jsonobject1.getString("simulcastAiringId"));
        }
        if (jsonobject1.has("seekInSeconds") && !jsonobject1.isNull("seekInSeconds"))
        {
            contentvalues1.put("seekInSeconds", jsonobject1.getString("seekInSeconds"));
        }
        if (jsonobject1.has("parentalRating") && !jsonobject1.isNull("parentalRating"))
        {
            contentvalues1.put("parentalRating", jsonobject1.getString("parentalRating"));
        }
        if (jsonobject1.has("omniture") && !jsonobject1.isNull("omniture"))
        {
            contentvalues1.put("omnitureJson", jsonobject1.getJSONObject("omniture").toString());
        }
        if (jsonobject1.has("thumbnails") && !jsonobject1.isNull("thumbnails"))
        {
            JSONObject jsonobject3 = jsonobject1.getJSONObject("thumbnails");
            if (jsonobject3.has("small") && !jsonobject3.isNull("small"))
            {
                JSONObject jsonobject7 = jsonobject3.getJSONObject("small");
                if (jsonobject7.has("href") && !jsonobject7.isNull("href"))
                {
                    contentvalues1.put("imageSmall", jsonobject7.getString("href"));
                }
            }
            if (jsonobject3.has("medium") && !jsonobject3.isNull("medium"))
            {
                JSONObject jsonobject8 = jsonobject3.getJSONObject("medium");
                if (jsonobject8.has("href") && !jsonobject8.isNull("href"))
                {
                    contentvalues1.put("imageMed", jsonobject8.getString("href"));
                }
            }
            if (jsonobject3.has("large") && !jsonobject3.isNull("large"))
            {
                jsonobject3 = jsonobject3.getJSONObject("large");
                if (jsonobject3.has("href") && !jsonobject3.isNull("href"))
                {
                    contentvalues1.put("imageLarge", jsonobject3.getString("href"));
                }
            }
        }
        if (jsonobject1.has("name") && !jsonobject1.isNull("name"))
        {
            contentvalues1.put("eventName", jsonobject1.getString("name"));
        }
        if (jsonobject1.has("links") && !jsonobject1.isNull("links"))
        {
            jsonobject1 = jsonobject1.getJSONObject("links");
            if (jsonobject1.has("source") && !jsonobject1.isNull("source"))
            {
                jsonobject1 = jsonobject1.getJSONObject("source");
                if (jsonobject1.has("hls") && !jsonobject1.isNull("hls"))
                {
                    jsonobject1 = jsonobject1.getJSONObject("hls");
                    if (jsonobject1.has("default") && !jsonobject1.isNull("default"))
                    {
                        JSONObject jsonobject4 = jsonobject1.getJSONObject("default");
                        if (jsonobject4.has("href") && !jsonobject4.isNull("href"))
                        {
                            contentvalues1.put("videoURLDefault", jsonobject4.getString("href"));
                        }
                    }
                    if (jsonobject1.has("high") && !jsonobject1.isNull("high"))
                    {
                        JSONObject jsonobject5 = jsonobject1.getJSONObject("high");
                        if (jsonobject5.has("href") && !jsonobject5.isNull("href"))
                        {
                            contentvalues1.put("videoURLLarge", jsonobject5.getString("href"));
                        }
                    }
                    if (jsonobject1.has("mid") && !jsonobject1.isNull("mid"))
                    {
                        JSONObject jsonobject6 = jsonobject1.getJSONObject("mid");
                        if (jsonobject6.has("href") && !jsonobject6.isNull("href"))
                        {
                            contentvalues1.put("videoURLMed", jsonobject6.getString("href"));
                        }
                    }
                    if (jsonobject1.has("low") && !jsonobject1.isNull("low"))
                    {
                        jsonobject1 = jsonobject1.getJSONObject("low");
                        if (jsonobject1.has("href") && !jsonobject1.isNull("href"))
                        {
                            contentvalues1.put("videoURLSmall", jsonobject1.getString("href"));
                        }
                    }
                }
            }
        }
        contentvalues1.put("metaEventRelationId", "1");
        contentvalues1.put("sportId", "");
        DataManager.feedsDbConn.insertIntoEventsTable(contentvalues1);
_L8:
        i++;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        Utils.sdkLog("LiveEventsParser", 5, exception);
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = true;
        if (true) goto _L8; else goto _L7
_L7:
        jsonobject;
        Utils.sdkLog("LiveEventsParser", 5, jsonobject);
        sendSuccessBroadcast = false;
        sendPartialErrorBroadcast = false;
        errorHandler(2);
        if (sendSuccessBroadcast)
        {
            sendBroadcast("com.espn.action.LIVE_EVENT_UPDATED");
            return;
        }
        continue; /* Loop/switch isn't completed */
        hashmap;
        Utils.sdkLog("LiveEventsParser", 5, hashmap);
        contentvalues.put("ttl", "");
          goto _L9
        jsonobject;
        if (sendSuccessBroadcast)
        {
            sendBroadcast("com.espn.action.LIVE_EVENT_UPDATED");
        } else
        if (sendPartialErrorBroadcast)
        {
            sendBroadcast("com.espn.action.LIVE_EVENT_PARTIAL_DATA_ERROR");
        }
        throw jsonobject;
        if (!sendPartialErrorBroadcast) goto _L11; else goto _L10
_L10:
        sendBroadcast("com.espn.action.LIVE_EVENT_PARTIAL_DATA_ERROR");
        return;
_L6:
        if (!sendPartialErrorBroadcast) goto _L11; else goto _L12
_L12:
        sendBroadcast("com.espn.action.LIVE_EVENT_PARTIAL_DATA_ERROR");
        return;
        if (true) goto _L14; else goto _L13
_L13:
    }
}
