// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.database.impl.provider;

import android.net.Uri;
import android.provider.BaseColumns;

// Referenced classes of package com.penthera.virtuososdk.database.impl.provider:
//            Registry

public static final class 
    implements BaseColumns
{

    public static final Uri CONTENT_URI(String s)
    {
        return Uri.parse((new StringBuilder("content://")).append(s).append("/registry").toString());
    }
}
