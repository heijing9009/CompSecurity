// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.orca.g;

import android.content.Context;
import com.facebook.d.d.a;
import com.google.common.a.es;

// Referenced classes of package com.facebook.orca.g:
//            ap

public class aa extends a
{

    private static final es a = es.a("threads_db");
    private final ap b;

    public aa(Context context, com.facebook.common.executors.a a1, com.facebook.d.b.a a2, ap ap1)
    {
        super(context, a1, a2, es.a(ap1), "threads_db2", a);
        b = ap1;
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        b.b(e());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        b.c(e());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
