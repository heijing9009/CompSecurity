// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bo.app;

import android.content.Context;
import com.amazon.device.messaging.development.ADMManifest;
import com.appboy.d;

// Referenced classes of package bo.app:
//            cc

public class bn
{

    public static final String c;
    public final Context a;
    public final cc b;

    public bn(Context context, cc cc)
    {
        a = context;
        b = cc;
    }

    private static boolean a()
    {
        try
        {
            Class.forName("com.amazon.device.messaging.ADM");
        }
        catch (Exception exception)
        {
            return false;
        }
        return true;
    }

    public static boolean a(Context context)
    {
        return a() && b(context);
    }

    private static boolean b(Context context)
    {
        try
        {
            ADMManifest.checkManifestAuthoredProperly(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    static 
    {
        c = String.format("%s.%s", new Object[] {
            d.a, bo/app/bn.getName()
        });
    }
}
