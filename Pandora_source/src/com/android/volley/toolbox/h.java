// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import p.k.l;
import p.k.m;
import p.k.s;

// Referenced classes of package com.android.volley.toolbox:
//            i

public class h
{
    private class a
    {

        final h a;
        private final l b;
        private Bitmap c;
        private s d;
        private final LinkedList e = new LinkedList();

        static Bitmap a(a a1, Bitmap bitmap)
        {
            a1.c = bitmap;
            return bitmap;
        }

        static LinkedList a(a a1)
        {
            return a1.e;
        }

        static Bitmap b(a a1)
        {
            return a1.c;
        }

        public s a()
        {
            return d;
        }

        public void a(c c1)
        {
            e.add(c1);
        }

        public void a(s s)
        {
            d = s;
        }

        public boolean b(c c1)
        {
            e.remove(c1);
            if (e.size() == 0)
            {
                b.g();
                return true;
            } else
            {
                return false;
            }
        }

        public a(l l1, c c1)
        {
            a = h.this;
            super();
            b = l1;
            e.add(c1);
        }
    }

    public static interface b
    {

        public abstract Bitmap a(String s);

        public abstract void a(String s, Bitmap bitmap);
    }

    public class c
    {

        final h a;
        private Bitmap b;
        private final d c;
        private final String d;
        private final String e;

        static Bitmap a(c c1, Bitmap bitmap)
        {
            c1.b = bitmap;
            return bitmap;
        }

        static d a(c c1)
        {
            return c1.c;
        }

        public void a()
        {
            if (c != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            a a1 = (a)h.a(a).get(d);
            if (a1 == null)
            {
                break; /* Loop/switch isn't completed */
            }
            if (a1.b(this))
            {
                h.a(a).remove(d);
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
            a a2 = (a)h.b(a).get(d);
            if (a2 != null)
            {
                a2.b(this);
                if (a.a(a2).size() == 0)
                {
                    h.b(a).remove(d);
                    return;
                }
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        public Bitmap b()
        {
            return b;
        }

        public String c()
        {
            return e;
        }

        public c(Bitmap bitmap, String s, String s1, d d1)
        {
            a = h.this;
            super();
            b = bitmap;
            e = s;
            d = s1;
            c = d1;
        }
    }

    public static interface d
        extends p.k.n.a
    {

        public abstract void a(c c1, boolean flag);
    }


    private final m a;
    private int b;
    private final b c;
    private final HashMap d;
    private final HashMap e;
    private final Handler f;
    private Runnable g;

    static Runnable a(h h1, Runnable runnable)
    {
        h1.g = runnable;
        return runnable;
    }

    private static String a(String s, int j, int k)
    {
        return (new StringBuilder(s.length() + 12)).append("#W").append(j).append("#H").append(k).append(s).toString();
    }

    static HashMap a(h h1)
    {
        return h1.d;
    }

    private void a()
    {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        } else
        {
            return;
        }
    }

    private void a(String s, a a1)
    {
        e.put(s, a1);
        if (g == null)
        {
            g = new Runnable() {

                final h a;

                public void run()
                {
                    for (Iterator iterator = h.b(a).values().iterator(); iterator.hasNext();)
                    {
                        a a2 = (a)iterator.next();
                        Iterator iterator1 = a.a(a2).iterator();
                        while (iterator1.hasNext()) 
                        {
                            c c1 = (c)iterator1.next();
                            if (c.a(c1) != null)
                            {
                                if (a2.a() == null)
                                {
                                    c.a(c1, a.b(a2));
                                    c.a(c1).a(c1, false);
                                } else
                                {
                                    c.a(c1).a(a2.a());
                                }
                            }
                        }
                    }

                    h.b(a).clear();
                    h.a(a, null);
                }

            
            {
                a = h.this;
                super();
            }
            };
            f.postDelayed(g, b);
        }
    }

    static HashMap b(h h1)
    {
        return h1.e;
    }

    public c a(String s, d d1, int j, int k)
    {
        a();
        String s1 = a(s, j, k);
        Object obj = c.a(s1);
        if (obj != null)
        {
            s = new c(((Bitmap) (obj)), s, null, null);
            d1.a(s, true);
            return s;
        }
        obj = new c(null, s, s1, d1);
        d1.a(((c) (obj)), true);
        d1 = (a)d.get(s1);
        if (d1 != null)
        {
            d1.a(((c) (obj)));
            return ((c) (obj));
        } else
        {
            s = a(s, j, k, s1);
            a.a(s);
            d.put(s1, new a(s, ((c) (obj))));
            return ((c) (obj));
        }
    }

    protected l a(String s, int j, int k, String s1)
    {
        return new i(s, new p.k.n.b(s1) {

            final String a;
            final h b;

            public void a(Bitmap bitmap)
            {
                b.a(a, bitmap);
            }

            public volatile void a(Object obj)
            {
                a((Bitmap)obj);
            }

            
            {
                b = h.this;
                a = s;
                super();
            }
        }, j, k, android.graphics.Bitmap.Config.RGB_565, new p.k.n.a(s1) {

            final String a;
            final h b;

            public void a(s s2)
            {
                b.a(a, s2);
            }

            
            {
                b = h.this;
                a = s;
                super();
            }
        });
    }

    protected void a(String s, Bitmap bitmap)
    {
        c.a(s, bitmap);
        a a1 = (a)d.remove(s);
        if (a1 != null)
        {
            a.a(a1, bitmap);
            a(s, a1);
        }
    }

    protected void a(String s, s s1)
    {
        a a1 = (a)d.remove(s);
        if (a1 != null)
        {
            a1.a(s1);
            a(s, a1);
        }
    }
}
