// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.kb;
import android.support.v7.kc;
import android.support.v7.p;
import android.util.Log;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            GraphRequest, q, k, a, 
//            AccessToken, c, o, p

final class b
{
    private static class a
    {

        public String a;
        public int b;

        private a()
        {
        }

    }


    private static volatile b a;
    private final p b;
    private final com.facebook.a c;
    private AccessToken d;
    private AtomicBoolean e;
    private Date f;

    b(p p1, com.facebook.a a1)
    {
        e = new AtomicBoolean(false);
        f = new Date(0L);
        kc.a(p1, "localBroadcastManager");
        kc.a(a1, "accessTokenCache");
        b = p1;
        c = a1;
    }

    private static GraphRequest a(AccessToken accesstoken, GraphRequest.b b1)
    {
        return new GraphRequest(accesstoken, "me/permissions", new Bundle(), q.a, b1);
    }

    static b a()
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        com/facebook/b;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new b(p.a(k.f()), new com.facebook.a());
        }
        com/facebook/b;
        JVM INSTR monitorexit ;
_L2:
        return a;
        Exception exception;
        exception;
        com/facebook/b;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void a(AccessToken accesstoken, AccessToken accesstoken1)
    {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accesstoken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accesstoken1);
        b.a(intent);
    }

    private void a(AccessToken accesstoken, boolean flag)
    {
        AccessToken accesstoken1 = d;
        d = accesstoken;
        e.set(false);
        f = new Date(0L);
        if (flag)
        {
            if (accesstoken != null)
            {
                c.a(accesstoken);
            } else
            {
                c.b();
                kb.b(k.f());
            }
        }
        if (!kb.a(accesstoken1, accesstoken))
        {
            a(accesstoken1, accesstoken);
        }
    }

    static void a(b b1)
    {
        b1.g();
    }

    private static GraphRequest b(AccessToken accesstoken, GraphRequest.b b1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        return new GraphRequest(accesstoken, "oauth/access_token", bundle, q.a, b1);
    }

    static AtomicBoolean b(b b1)
    {
        return b1.e;
    }

    private boolean f()
    {
        if (d != null)
        {
            Long long1 = Long.valueOf((new Date()).getTime());
            if (d.f().a() && long1.longValue() - f.getTime() > 0x36ee80L && long1.longValue() - d.g().getTime() > 0x5265c00L)
            {
                return true;
            }
        }
        return false;
    }

    private void g()
    {
        AccessToken accesstoken;
        for (accesstoken = d; accesstoken == null || !e.compareAndSet(false, true);)
        {
            return;
        }

        kc.a();
        f = new Date();
        HashSet hashset = new HashSet();
        HashSet hashset1 = new HashSet();
        AtomicBoolean atomicboolean = new AtomicBoolean(false);
        a a1 = new a();
        o o1 = new o(new GraphRequest[] {
            a(accesstoken, new GraphRequest.b(atomicboolean, hashset, hashset1) {

                final AtomicBoolean a;
                final Set b;
                final Set c;
                final b d;

                public void a(com.facebook.p p1)
                {
                    p1 = p1.b();
                    if (p1 != null)
                    {
                        if ((p1 = p1.optJSONArray("data")) != null)
                        {
                            a.set(true);
                            int i = 0;
                            while (i < p1.length()) 
                            {
                                Object obj = p1.optJSONObject(i);
                                if (obj != null)
                                {
                                    String s = ((JSONObject) (obj)).optString("permission");
                                    obj = ((JSONObject) (obj)).optString("status");
                                    if (!kb.a(s) && !kb.a(((String) (obj))))
                                    {
                                        obj = ((String) (obj)).toLowerCase(Locale.US);
                                        if (((String) (obj)).equals("granted"))
                                        {
                                            b.add(s);
                                        } else
                                        if (((String) (obj)).equals("declined"))
                                        {
                                            c.add(s);
                                        } else
                                        {
                                            Log.w("AccessTokenManager", (new StringBuilder()).append("Unexpected status: ").append(((String) (obj))).toString());
                                        }
                                    }
                                }
                                i++;
                            }
                        }
                    }
                }

            
            {
                d = b.this;
                a = atomicboolean;
                b = set;
                c = set1;
                super();
            }
            }), b(accesstoken, new GraphRequest.b(a1) {

                final a a;
                final b b;

                public void a(com.facebook.p p1)
                {
                    p1 = p1.b();
                    if (p1 == null)
                    {
                        return;
                    } else
                    {
                        a.a = p1.optString("access_token");
                        a.b = p1.optInt("expires_at");
                        return;
                    }
                }

            
            {
                b = b.this;
                a = a1;
                super();
            }
            })
        });
        o1.a(new o.a(accesstoken, atomicboolean, a1, hashset, hashset1) {

            final AccessToken a;
            final AtomicBoolean b;
            final a c;
            final Set d;
            final Set e;
            final b f;

            public void a(o o2)
            {
                if (b.a().b() == null || b.a().b().i() != a.i())
                {
                    return;
                }
                int i;
                if (b.get() || c.a != null)
                {
                    break MISSING_BLOCK_LABEL_75;
                }
                i = c.b;
                if (i == 0)
                {
                    b.b(f).set(false);
                    return;
                }
                if (c.a == null) goto _L2; else goto _L1
_L1:
                o2 = c.a;
_L9:
                String s;
                String s1;
                s = a.h();
                s1 = a.i();
                if (!b.get()) goto _L4; else goto _L3
_L3:
                Set set = d;
_L10:
                if (!b.get()) goto _L6; else goto _L5
_L5:
                Set set1 = e;
_L11:
                c c1 = a.f();
                if (c.b == 0) goto _L8; else goto _L7
_L7:
                Date date = new Date((long)c.b * 1000L);
_L12:
                o2 = new AccessToken(o2, s, s1, set, set1, c1, date, new Date());
                b.a().a(o2);
                b.b(f).set(false);
                return;
_L2:
                o2 = a.b();
                  goto _L9
_L4:
                set = a.d();
                  goto _L10
_L6:
                set1 = a.e();
                  goto _L11
_L8:
                date = a.c();
                  goto _L12
                o2;
                b.b(f).set(false);
                throw o2;
                  goto _L9
            }

            
            {
                f = b.this;
                a = accesstoken;
                b = atomicboolean;
                c = a1;
                d = set;
                e = set1;
                super();
            }
        });
        o1.h();
    }

    void a(AccessToken accesstoken)
    {
        a(accesstoken, true);
    }

    AccessToken b()
    {
        return d;
    }

    boolean c()
    {
        boolean flag = false;
        AccessToken accesstoken = c.a();
        if (accesstoken != null)
        {
            a(accesstoken, false);
            flag = true;
        }
        return flag;
    }

    void d()
    {
        if (!f())
        {
            return;
        } else
        {
            e();
            return;
        }
    }

    void e()
    {
        if (Looper.getMainLooper().equals(Looper.myLooper()))
        {
            g();
            return;
        } else
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable() {

                final b a;

                public void run()
                {
                    b.a(a);
                }

            
            {
                a = b.this;
                super();
            }
            });
            return;
        }
    }
}
