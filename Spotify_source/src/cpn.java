// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

final class cpn
    implements cpq
{

    private Context a;

    private cpn(Context context)
    {
        a = context;
    }

    cpn(Context context, byte byte0)
    {
        this(context);
    }

    public final Drawable a(int i)
    {
        return a.getResources().getDrawable(0x1080004);
    }

    public final boolean a()
    {
        return true;
    }
}
