// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

// Referenced classes of package com.b.a:
//            i, l, j

public class a
    implements i
{

    public a()
    {
    }

    public void a(Context context, String s, String s1, j j, Runnable runnable)
    {
        l.a(new AsyncTask(context, s, j, runnable) {

            final Context a;
            final String b;
            final j c;
            final Runnable d;
            final a e;

            protected transient Void a(Void avoid[])
            {
                try
                {
                    avoid = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(a.getContentResolver(), Uri.parse(b));
                    c.a(e, avoid, null);
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    return null;
                }
                return null;
            }

            protected void a(Void void1)
            {
                d.run();
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Void)obj);
            }

            
            {
                e = a.this;
                a = context;
                b = s;
                c = j1;
                d = runnable;
                super();
            }
        });
    }

    public boolean a()
    {
        return false;
    }

    public boolean a(String s)
    {
        return s.startsWith(android.provider.ContactsContract.Contacts.CONTENT_URI.toString());
    }
}
