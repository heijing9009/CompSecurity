// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import java.io.File;

// Referenced classes of package com.google.android.gms.internal:
//            lm, lg, ie, li, 
//            lj

public final class d
{

    public static ie a(Context context)
    {
        File file = new File(context.getCacheDir(), "volley");
        String s = "volley/0";
        try
        {
            String s1 = context.getPackageName();
            context = context.getPackageManager().getPackageInfo(s1, 0);
            context = (new StringBuilder()).append(s1).append("/").append(((PackageInfo) (context)).versionCode).toString();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = s;
        }
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            context = new lm();
        } else
        {
            context = new lj(AndroidHttpClient.newInstance(context));
        }
        context = new lg(context);
        context = new ie(new li(file, (byte)0), context, (byte)0);
        context.a();
        return context;
    }
}
