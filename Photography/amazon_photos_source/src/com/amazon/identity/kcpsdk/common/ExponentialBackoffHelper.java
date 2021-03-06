// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.security.SecureRandom;
import java.util.Random;

public class ExponentialBackoffHelper
{

    private static final String TAG = com/amazon/identity/kcpsdk/common/ExponentialBackoffHelper.getName();
    private int mCurrentMultiple;
    private int mFirstRetryIntervalMs;
    private int mJitterRange;
    private int mMaxRetryIntervalMs;
    private int mRetryAttempts;
    private final Random mRng;

    public ExponentialBackoffHelper(int i, int j)
    {
        this(i, j, (byte)0);
    }

    public ExponentialBackoffHelper(int i, int j, byte byte0)
    {
        mRng = new SecureRandom();
        mFirstRetryIntervalMs = i;
        mMaxRetryIntervalMs = j;
        mRetryAttempts = 0;
        mCurrentMultiple = 1;
        mJitterRange = 30;
        if (mFirstRetryIntervalMs <= 0)
        {
            mFirstRetryIntervalMs = 10;
            MAPLog.formattedWarning(TAG, "ExponentialBackoffHelper: was constructed with a first retry interval value less than or equal to zero. It has been set to a default value (%d ms)", new Object[] {
                Integer.valueOf(mFirstRetryIntervalMs)
            });
        }
        if (mJitterRange <= 0)
        {
            mJitterRange = 10;
            MAPLog.formattedWarning(TAG, "ExponentialBackoffHelper: was constructed with a jitter percent range less than or equal to zero. It has been set to a default value (%d percent)", new Object[] {
                Integer.valueOf(mJitterRange)
            });
        }
    }

    public int nextRetryInterval()
    {
        mRetryAttempts = mRetryAttempts + 1;
        int j = mFirstRetryIntervalMs * mCurrentMultiple;
        if (j * 2 <= mMaxRetryIntervalMs)
        {
            mCurrentMultiple = mCurrentMultiple * 2;
        }
        int k = (int)Math.min(0x7fffffffL, (2L * (long)mJitterRange * (long)j) / 100L);
        int i = j;
        if (k != 0)
        {
            i = mRng.nextInt(k);
            i = (j - k / 2) + i;
        }
        return i;
    }

    public int numberOfRetryAttempts()
    {
        return mRetryAttempts;
    }

}
