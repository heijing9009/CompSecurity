// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.y.e;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.c;

// Referenced classes of package com.shazam.android.y.e:
//            a

final class a
    implements c
{

    final String a;
    final a b;

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("request", a);
        sqlitedatabase.insert("guaranteed_requests", null, contentvalues);
    }

    iteDatabase(a a1, String s)
    {
        b = a1;
        a = s;
        super();
    }
}
