// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.whatsapp;

import android.os.Handler;
import com.whatsapp.contact.b;
import com.whatsapp.contact.j;

// Referenced classes of package com.whatsapp:
//            App, ContactPicker, kk

class aoc
    implements Runnable
{

    final ContactPicker a;
    final boolean b;

    aoc(ContactPicker contactpicker, boolean flag)
    {
        a = contactpicker;
        b = flag;
        super();
    }

    public void run()
    {
        if (App.l >= 1)
        {
            ContactPicker.h(a);
        }
        android.content.Context context = a.getApplicationContext();
        Object obj;
        if (b)
        {
            obj = j.INTERACTIVE_FULL;
        } else
        {
            obj = j.INTERACTIVE_DELTA;
        }
        obj = com.whatsapp.contact.b.b(context, ((j) (obj)));
        if (App.l >= 1)
        {
            ContactPicker.h(a);
        }
        ContactPicker.u(a).post(new kk(this, ((com.whatsapp.contact.n) (obj))));
    }
}
