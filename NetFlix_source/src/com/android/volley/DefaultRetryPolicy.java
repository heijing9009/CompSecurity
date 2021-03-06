// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.volley;

import android.util.Log;

// Referenced classes of package com.android.volley:
//            RetryPolicy, VolleyError

public class DefaultRetryPolicy
    implements RetryPolicy
{

    public static final float DEFAULT_BACKOFF_MULT = 1F;
    public static final int DEFAULT_MAX_RETRIES = 1;
    public static final int DEFAULT_TIMEOUT_MS = 2500;
    private static final String TAG = "DefaultRetryPolicy";
    private final float mBackoffMultiplier;
    private int mCurrentRetryCount;
    private int mCurrentTimeoutMs;
    private final int mMaxNumRetries;

    public DefaultRetryPolicy()
    {
        this(2500, 1, 1.0F);
    }

    public DefaultRetryPolicy(int i, int j, float f)
    {
        mCurrentTimeoutMs = i;
        mMaxNumRetries = j;
        mBackoffMultiplier = f;
    }

    public int getCurrentRetryCount()
    {
        return mCurrentRetryCount;
    }

    public int getCurrentTimeout()
    {
        return mCurrentTimeoutMs;
    }

    protected boolean hasAttemptRemaining()
    {
        if (Log.isLoggable("DefaultRetryPolicy", 3))
        {
            Log.d("DefaultRetryPolicy", (new StringBuilder()).append("hasAttemptRemaining() - ").append(toString()).toString());
        }
        return mCurrentRetryCount <= mMaxNumRetries;
    }

    public void retry(VolleyError volleyerror)
        throws VolleyError
    {
        if (Log.isLoggable("DefaultRetryPolicy", 3))
        {
            Log.d("DefaultRetryPolicy", (new StringBuilder()).append("retrying - ").append(toString()).toString());
        }
        mCurrentRetryCount = mCurrentRetryCount + 1;
        mCurrentTimeoutMs = (int)((float)mCurrentTimeoutMs + (float)mCurrentTimeoutMs * mBackoffMultiplier);
        if (!hasAttemptRemaining())
        {
            throw volleyerror;
        } else
        {
            return;
        }
    }

    public String toString()
    {
        return String.format((new StringBuilder()).append(getClass().getSimpleName()).append(": %d, %d / %d [%dms]").toString(), new Object[] {
            Integer.valueOf(hashCode()), Integer.valueOf(mCurrentRetryCount), Integer.valueOf(mMaxNumRetries), Integer.valueOf(mCurrentTimeoutMs)
        });
    }
}
