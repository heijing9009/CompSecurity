// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import android.app.Activity;
import com.smule.android.f.h;
import com.smule.android.network.managers.ar;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            i

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        ar.a().a(i.a(a.a), true);
        h.a().b("APP_SETTINGS_LOADED_EVENT", i.b(a.a));
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/b/i$7

/* anonymous class */
    class i._cls7
        implements Observer
    {

        final i a;

        public void update(Observable observable, Object obj)
        {
            i.a(a).runOnUiThread(new i._cls7._cls1(this));
        }

            
            {
                a = j;
                super();
            }
    }

}
