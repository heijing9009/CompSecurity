// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import retrofit.Callback;
import retrofit.mime.TypedOutput;

public interface UserFavoritesService
{

    public abstract void deleteFavorite(String s, String s1, Callback callback);

    public abstract void insertFavorite(String s, String s1, TypedOutput typedoutput, Callback callback);
}
