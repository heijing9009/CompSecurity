// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import com.appboy.c.b;
import com.appboy.f.a;
import org.json.JSONException;

// Referenced classes of package a.a:
//            ak, o, at, au, 
//            bu

public final class v
    implements b
{

    final o a;

    public v(o o1)
    {
        a = o1;
        super();
    }

    public final void a(Object obj)
    {
        obj = (ak)obj;
        at at1 = o.j(a);
        try
        {
            at1.a(a.a.bu.a(((ak) (obj)), at1.b.c()));
            return;
        }
        catch (JSONException jsonexception)
        {
            try
            {
                com.appboy.f.a.c(a.a.at.a, String.format("Failed to create database exception event from %s.", new Object[] {
                    obj
                }), jsonexception);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.appboy.f.a.c(a.a.o.a(), "Failed to log the database exception.", ((Throwable) (obj)));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        com.appboy.f.a.c(a.a.at.a, "Failed to log error.", ((Throwable) (obj)));
        return;
    }
}
