// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.flurry.sdk:
//            lb, iq, hw, hx, 
//            hq, lv, hr, ia, 
//            ht, ib, id, lt, 
//            kg

public class it
    implements lb
{

    private static final String a = com/flurry/sdk/it.getSimpleName();

    public it()
    {
    }

    private iq a(String s)
    {
        iq iq1;
label0:
        {
            iq1 = iq.a;
            try
            {
                if (TextUtils.isEmpty(s))
                {
                    break label0;
                }
                s = (iq)Enum.valueOf(com/flurry/sdk/iq, s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return iq1;
            }
            return s;
        }
        return iq1;
    }

    private void a(hq hq1, JSONArray jsonarray)
    {
        if (jsonarray != null)
        {
            List list = null;
            int i = 0;
            while (i < jsonarray.length()) 
            {
                JSONObject jsonobject = jsonarray.optJSONObject(i);
                Object obj1 = list;
                if (jsonobject != null)
                {
                    if (jsonobject.has("string"))
                    {
                        obj1 = list;
                        if (list == null)
                        {
                            obj1 = new ArrayList();
                        }
                        list = new hw();
                        list.a = jsonobject.optString("string", "");
                        ((List) (obj1)).add(list);
                    } else
                    {
                        obj1 = list;
                        if (jsonobject.has("com.flurry.proton.generated.avro.v2.EventParameterCallbackTrigger"))
                        {
                            Object obj = list;
                            if (list == null)
                            {
                                obj = new ArrayList();
                            }
                            list = jsonobject.optJSONObject("com.flurry.proton.generated.avro.v2.EventParameterCallbackTrigger");
                            obj1 = obj;
                            if (list != null)
                            {
                                obj1 = new hx();
                                obj1.a = list.optString("event_name", "");
                                obj1.c = list.optString("event_parameter_name", "");
                                JSONArray jsonarray1 = list.optJSONArray("event_parameter_values");
                                if (jsonarray1 != null)
                                {
                                    list = new String[jsonarray1.length()];
                                    for (int j = 0; j < jsonarray1.length(); j++)
                                    {
                                        list[j] = jsonarray1.optString(j, "");
                                    }

                                } else
                                {
                                    list = new String[0];
                                }
                                obj1.d = list;
                                ((List) (obj)).add(obj1);
                                obj1 = obj;
                            }
                        }
                    }
                }
                i++;
                list = ((List) (obj1));
            }
            hq1.c = list;
        }
    }

    private void a(hr hr1, JSONArray jsonarray)
    {
        if (jsonarray != null)
        {
            ArrayList arraylist = new ArrayList();
            for (int i = 0; i < jsonarray.length(); i++)
            {
                JSONObject jsonobject = jsonarray.optJSONObject(i);
                if (jsonobject == null)
                {
                    continue;
                }
                hq hq1 = new hq();
                hq1.b = jsonobject.optString("partner", "");
                a(hq1, jsonobject.optJSONArray("events"));
                hq1.d = a(jsonobject.optString("method"));
                hq1.e = jsonobject.optString("uri_template", "");
                Object obj = jsonobject.optJSONObject("body_template");
                if (obj != null)
                {
                    obj = ((JSONObject) (obj)).optString("string", "null");
                    if (!((String) (obj)).equals("null"))
                    {
                        hq1.f = ((String) (obj));
                    }
                }
                hq1.g = jsonobject.optInt("max_redirects", 5);
                hq1.h = jsonobject.optInt("connect_timeout", 20);
                hq1.i = jsonobject.optInt("request_timeout", 20);
                hq1.a = jsonobject.optLong("callback_id", -1L);
                jsonobject = jsonobject.optJSONObject("headers");
                if (jsonobject != null)
                {
                    jsonobject = jsonobject.optJSONObject("map");
                    if (jsonobject != null)
                    {
                        hq1.j = lv.a(jsonobject);
                    }
                }
                arraylist.add(hq1);
            }

            hr1.a = arraylist;
        }
    }

    private void a(ht ht1, JSONObject jsonobject)
    {
        jsonobject = jsonobject.optJSONObject("global_settings");
        ht1.d = new ia();
        if (jsonobject != null)
        {
            ht1.d.a = b(jsonobject.optString("log_level"));
        }
    }

    private ib b(String s)
    {
        ib ib1;
label0:
        {
            ib1 = ib.f;
            try
            {
                if (TextUtils.isEmpty(s))
                {
                    break label0;
                }
                s = (ib)Enum.valueOf(com/flurry/sdk/ib, s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return ib1;
            }
            return s;
        }
        return ib1;
    }

    private void b(ht ht1, JSONObject jsonobject)
    {
        jsonobject = jsonobject.optJSONObject("pulse");
        hr hr1 = new hr();
        if (jsonobject != null)
        {
            a(hr1, jsonobject.optJSONArray("callbacks"));
            hr1.b = jsonobject.optInt("max_callback_retries", 3);
            hr1.c = jsonobject.optInt("max_callback_attempts_per_report", 15);
            hr1.d = jsonobject.optInt("max_report_delay_seconds", 600);
            hr1.e = jsonobject.optString("agent_report_url", "");
        }
        ht1.e = hr1;
    }

    private void c(ht ht1, JSONObject jsonobject)
    {
        jsonobject = jsonobject.optJSONObject("analytics");
        ht1.f = new id();
        if (jsonobject != null)
        {
            ht1.f.b = jsonobject.optBoolean("analytics_enabled", true);
            ht1.f.a = jsonobject.optInt("max_session_properties", 10);
        }
    }

    public ht a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        }
        Object obj = new String(lt.a(inputstream));
        kg.a(5, a, (new StringBuilder()).append("Proton response string: ").append(((String) (obj))).toString());
        inputstream = new ht();
        try
        {
            obj = new JSONObject(((String) (obj)));
            inputstream.a = ((JSONObject) (obj)).optLong("issued_at", -1L);
            inputstream.b = ((JSONObject) (obj)).optLong("refresh_ttl", 3600L);
            inputstream.c = ((JSONObject) (obj)).optLong("expiration_ttl", 0x15180L);
            a(((ht) (inputstream)), ((JSONObject) (obj)));
            b(inputstream, ((JSONObject) (obj)));
            c(inputstream, ((JSONObject) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IOException("Exception while deserialize: ", inputstream);
        }
        return inputstream;
    }

    public void a(OutputStream outputstream, ht ht1)
    {
        throw new IOException("Serialize not supported for response");
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (ht)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

}
