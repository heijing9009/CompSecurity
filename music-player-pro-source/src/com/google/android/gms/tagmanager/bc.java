// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            aj, di

class bc extends aj
{

    private static final String ID;

    public bc()
    {
        super(ID, new String[0]);
    }

    public com.google.android.gms.internal.d.a B(Map map)
    {
        map = Locale.getDefault();
        if (map == null)
        {
            return di.rb();
        }
        map = map.getLanguage();
        if (map == null)
        {
            return di.rb();
        } else
        {
            return di.u(map.toLowerCase());
        }
    }

    public boolean pe()
    {
        return false;
    }

    static 
    {
        ID = a.N.toString();
    }
}
