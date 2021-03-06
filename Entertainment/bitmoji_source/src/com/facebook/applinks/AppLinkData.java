// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.applinks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLinkData
{
    public static interface CompletionHandler
    {

        public abstract void onDeferredAppLinkDataFetched(AppLinkData applinkdata);
    }


    private static final String APPLINK_BRIDGE_ARGS_KEY = "bridge_args";
    private static final String APPLINK_METHOD_ARGS_KEY = "method_args";
    private static final String APPLINK_VERSION_KEY = "version";
    public static final String ARGUMENTS_NATIVE_CLASS_KEY = "com.facebook.platform.APPLINK_NATIVE_CLASS";
    public static final String ARGUMENTS_NATIVE_URL = "com.facebook.platform.APPLINK_NATIVE_URL";
    public static final String ARGUMENTS_REFERER_DATA_KEY = "referer_data";
    public static final String ARGUMENTS_TAPTIME_KEY = "com.facebook.platform.APPLINK_TAP_TIME_UTC";
    private static final String BRIDGE_ARGS_METHOD_KEY = "method";
    private static final String BUNDLE_AL_APPLINK_DATA_KEY = "al_applink_data";
    static final String BUNDLE_APPLINK_ARGS_KEY = "com.facebook.platform.APPLINK_ARGS";
    private static final String DEFERRED_APP_LINK_ARGS_FIELD = "applink_args";
    private static final String DEFERRED_APP_LINK_CLASS_FIELD = "applink_class";
    private static final String DEFERRED_APP_LINK_CLICK_TIME_FIELD = "click_time";
    private static final String DEFERRED_APP_LINK_EVENT = "DEFERRED_APP_LINK";
    private static final String DEFERRED_APP_LINK_PATH = "%s/activities";
    private static final String DEFERRED_APP_LINK_URL_FIELD = "applink_url";
    private static final String METHOD_ARGS_REF_KEY = "ref";
    private static final String METHOD_ARGS_TARGET_URL_KEY = "target_url";
    private static final String REFERER_DATA_REF_KEY = "fb_ref";
    private static final String TAG = com/facebook/applinks/AppLinkData.getCanonicalName();
    private Bundle argumentBundle;
    private JSONObject arguments;
    private String ref;
    private Uri targetUri;

    private AppLinkData()
    {
    }

    public static AppLinkData createFromActivity(Activity activity)
    {
        Validate.notNull(activity, "activity");
        Intent intent = activity.getIntent();
        Object obj;
        if (intent == null)
        {
            obj = null;
        } else
        {
            obj = createFromAlApplinkData(intent);
            activity = ((Activity) (obj));
            if (obj == null)
            {
                activity = createFromJson(intent.getStringExtra("com.facebook.platform.APPLINK_ARGS"));
            }
            obj = activity;
            if (activity == null)
            {
                return createFromUri(intent.getData());
            }
        }
        return ((AppLinkData) (obj));
    }

    public static AppLinkData createFromAlApplinkData(Intent intent)
    {
        if (intent == null)
        {
            intent = null;
        } else
        {
            Bundle bundle = intent.getBundleExtra("al_applink_data");
            if (bundle == null)
            {
                return null;
            }
            AppLinkData applinkdata = new AppLinkData();
            applinkdata.targetUri = intent.getData();
            if (applinkdata.targetUri == null)
            {
                intent = bundle.getString("target_url");
                if (intent != null)
                {
                    applinkdata.targetUri = Uri.parse(intent);
                }
            }
            applinkdata.argumentBundle = bundle;
            applinkdata.arguments = null;
            bundle = bundle.getBundle("referer_data");
            intent = applinkdata;
            if (bundle != null)
            {
                applinkdata.ref = bundle.getString("fb_ref");
                return applinkdata;
            }
        }
        return intent;
    }

    private static AppLinkData createFromJson(String s)
    {
        if (s == null)
        {
            return null;
        }
        Object obj;
        s = new JSONObject(s);
        obj = s.getString("version");
        if (!s.getJSONObject("bridge_args").getString("method").equals("applink") || !((String) (obj)).equals("2")) goto _L2; else goto _L1
_L1:
        obj = new AppLinkData();
        obj.arguments = s.getJSONObject("method_args");
        if (!((AppLinkData) (obj)).arguments.has("ref")) goto _L4; else goto _L3
_L3:
        obj.ref = ((AppLinkData) (obj)).arguments.getString("ref");
_L6:
        if (((AppLinkData) (obj)).arguments.has("target_url"))
        {
            obj.targetUri = Uri.parse(((AppLinkData) (obj)).arguments.getString("target_url"));
        }
        obj.argumentBundle = toBundle(((AppLinkData) (obj)).arguments);
        return ((AppLinkData) (obj));
        s;
        Log.d(TAG, "Unable to parse AppLink JSON", s);
_L2:
        return null;
_L4:
        if (!((AppLinkData) (obj)).arguments.has("referer_data")) goto _L6; else goto _L5
_L5:
        s = ((AppLinkData) (obj)).arguments.getJSONObject("referer_data");
        if (s.has("fb_ref"))
        {
            obj.ref = s.getString("fb_ref");
        }
          goto _L6
        s;
        Log.d(TAG, "Unable to parse AppLink JSON", s);
          goto _L2
    }

    private static AppLinkData createFromUri(Uri uri)
    {
        if (uri == null)
        {
            return null;
        } else
        {
            AppLinkData applinkdata = new AppLinkData();
            applinkdata.targetUri = uri;
            return applinkdata;
        }
    }

    public static void fetchDeferredAppLinkData(Context context, CompletionHandler completionhandler)
    {
        fetchDeferredAppLinkData(context, null, completionhandler);
    }

    public static void fetchDeferredAppLinkData(Context context, String s, CompletionHandler completionhandler)
    {
        Validate.notNull(context, "context");
        Validate.notNull(completionhandler, "completionHandler");
        String s1 = s;
        if (s == null)
        {
            s1 = Utility.getMetadataApplicationId(context);
        }
        Validate.notNull(s1, "applicationId");
        context = context.getApplicationContext();
        FacebookSdk.getExecutor().execute(new Runnable(context, s1, completionhandler) {

            final Context val$applicationContext;
            final String val$applicationIdCopy;
            final CompletionHandler val$completionHandler;

            public void run()
            {
                AppLinkData.fetchDeferredAppLinkFromServer(applicationContext, applicationIdCopy, completionHandler);
            }

            
            {
                applicationContext = context;
                applicationIdCopy = s;
                completionHandler = completionhandler;
                super();
            }
        });
    }

    private static void fetchDeferredAppLinkFromServer(Context context, String s, CompletionHandler completionhandler)
    {
        AppLinkData applinkdata;
        Object obj1 = new JSONObject();
        Object obj;
        Object obj2;
        String s1;
        long l;
        try
        {
            ((JSONObject) (obj1)).put("event", "DEFERRED_APP_LINK");
            Utility.setAppEventAttributionParameters(((JSONObject) (obj1)), AttributionIdentifiers.getAttributionIdentifiers(context), AppEventsLogger.getAnonymousAppDeviceGUID(context), FacebookSdk.getLimitEventAndDataUsage(context));
            ((JSONObject) (obj1)).put("application_package_name", context.getPackageName());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new FacebookException("An error occurred while preparing deferred app link", context);
        }
        s = String.format("%s/activities", new Object[] {
            s
        });
        obj = null;
        applinkdata = null;
        context = obj;
        obj2 = GraphRequest.newPostRequest(null, s, ((JSONObject) (obj1)), null).executeAndWait().getJSONObject();
        s = applinkdata;
        if (obj2 == null) goto _L2; else goto _L1
_L1:
        context = obj;
        s1 = ((JSONObject) (obj2)).optString("applink_args");
        context = obj;
        l = ((JSONObject) (obj2)).optLong("click_time", -1L);
        context = obj;
        obj1 = ((JSONObject) (obj2)).optString("applink_class");
        context = obj;
        obj2 = ((JSONObject) (obj2)).optString("applink_url");
        s = applinkdata;
        context = obj;
        if (TextUtils.isEmpty(s1)) goto _L2; else goto _L3
_L3:
        context = obj;
        applinkdata = createFromJson(s1);
        if (l == -1L)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        context = applinkdata;
        if (applinkdata.arguments == null)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        context = applinkdata;
        applinkdata.arguments.put("com.facebook.platform.APPLINK_TAP_TIME_UTC", l);
        context = applinkdata;
        if (applinkdata.argumentBundle == null)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        context = applinkdata;
        applinkdata.argumentBundle.putString("com.facebook.platform.APPLINK_TAP_TIME_UTC", Long.toString(l));
_L6:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        context = applinkdata;
        if (applinkdata.arguments == null)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        context = applinkdata;
        applinkdata.arguments.put("com.facebook.platform.APPLINK_NATIVE_CLASS", obj1);
        context = applinkdata;
        if (applinkdata.argumentBundle == null)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        context = applinkdata;
        applinkdata.argumentBundle.putString("com.facebook.platform.APPLINK_NATIVE_CLASS", ((String) (obj1)));
_L7:
        s = applinkdata;
        if (obj2 == null) goto _L2; else goto _L4
_L4:
        context = applinkdata;
        if (applinkdata.arguments == null)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        context = applinkdata;
        applinkdata.arguments.put("com.facebook.platform.APPLINK_NATIVE_URL", obj2);
        s = applinkdata;
        context = applinkdata;
        if (applinkdata.argumentBundle == null) goto _L2; else goto _L5
_L5:
        context = applinkdata;
        applinkdata.argumentBundle.putString("com.facebook.platform.APPLINK_NATIVE_URL", ((String) (obj2)));
        s = applinkdata;
_L2:
        completionhandler.onDeferredAppLinkDataFetched(s);
        return;
        context;
        context = applinkdata;
        Log.d(TAG, "Unable to put tap time in AppLinkData.arguments");
          goto _L6
        s;
        Utility.logd(TAG, "Unable to fetch deferred applink from server");
        s = context;
          goto _L2
        context;
        context = applinkdata;
        Log.d(TAG, "Unable to put tap time in AppLinkData.arguments");
          goto _L7
        context;
        context = applinkdata;
        Log.d(TAG, "Unable to put tap time in AppLinkData.arguments");
        s = applinkdata;
          goto _L2
    }

    private static Bundle toBundle(JSONObject jsonobject)
        throws JSONException
    {
        Bundle bundle = new Bundle();
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            Object obj = jsonobject.get(s);
            if (obj instanceof JSONObject)
            {
                bundle.putBundle(s, toBundle((JSONObject)obj));
            } else
            if (obj instanceof JSONArray)
            {
                obj = (JSONArray)obj;
                if (((JSONArray) (obj)).length() == 0)
                {
                    bundle.putStringArray(s, new String[0]);
                } else
                {
                    Object aobj[] = ((Object []) (((JSONArray) (obj)).get(0)));
                    if (aobj instanceof JSONObject)
                    {
                        aobj = new Bundle[((JSONArray) (obj)).length()];
                        for (int i = 0; i < ((JSONArray) (obj)).length(); i++)
                        {
                            aobj[i] = toBundle(((JSONArray) (obj)).getJSONObject(i));
                        }

                        bundle.putParcelableArray(s, ((android.os.Parcelable []) (aobj)));
                    } else
                    {
                        if (aobj instanceof JSONArray)
                        {
                            throw new FacebookException("Nested arrays are not supported.");
                        }
                        aobj = new String[((JSONArray) (obj)).length()];
                        for (int j = 0; j < ((JSONArray) (obj)).length(); j++)
                        {
                            aobj[j] = ((JSONArray) (obj)).get(j).toString();
                        }

                        bundle.putStringArray(s, ((String []) (aobj)));
                    }
                }
            } else
            {
                bundle.putString(s, obj.toString());
            }
        }

        return bundle;
    }

    public Bundle getArgumentBundle()
    {
        return argumentBundle;
    }

    public String getRef()
    {
        return ref;
    }

    public Bundle getRefererData()
    {
        if (argumentBundle != null)
        {
            return argumentBundle.getBundle("referer_data");
        } else
        {
            return null;
        }
    }

    public Uri getTargetUri()
    {
        return targetUri;
    }


}
