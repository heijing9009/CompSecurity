// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.recommendations;


public interface RecommendationsRatingSubscriber
{

    public abstract void onRecsRatingCallCancelled();

    public abstract void onRecsRatingCallCompleted();

    public abstract void onRecsRatingCallError();

    public abstract void onRecsRatingCallStarted();
}
