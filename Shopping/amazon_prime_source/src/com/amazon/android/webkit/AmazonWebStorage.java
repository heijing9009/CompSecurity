// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonValueCallback

public abstract class AmazonWebStorage
{
    public static class Origin
    {

        private final String mOrigin;
        private final long mQuota;
        private final long mUsage;

        public String getOrigin()
        {
            return mOrigin;
        }

        public long getQuota()
        {
            return mQuota;
        }

        public long getUsage()
        {
            return mUsage;
        }

        public Origin(String s, long l, long l1)
        {
            mOrigin = s;
            mQuota = l;
            mUsage = l1;
        }
    }

    public static interface QuotaUpdater
    {

        public abstract void updateQuota(long l);
    }


    public AmazonWebStorage()
    {
    }

    public abstract void deleteAllData();

    public abstract void deleteOrigin(String s);

    public abstract void getOrigins(AmazonValueCallback amazonvaluecallback);

    public abstract void getQuotaForOrigin(String s, AmazonValueCallback amazonvaluecallback);

    public abstract void getUsageForOrigin(String s, AmazonValueCallback amazonvaluecallback);

    public abstract void setQuotaForOrigin(String s, long l);
}
