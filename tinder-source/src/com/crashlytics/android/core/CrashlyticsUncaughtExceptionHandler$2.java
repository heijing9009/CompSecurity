// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsUncaughtExceptionHandler

static final class 
    implements Comparator
{

    public final int compare(Object obj, Object obj1)
    {
        obj = (File)obj;
        return ((File)obj1).getName().compareTo(((File) (obj)).getName());
    }

    ()
    {
    }
}
