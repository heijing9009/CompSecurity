// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adf
{

    protected transient boolean a;
    private transient long b;

    public static void a(Bitmap bitmap, float f)
    {
        fotobeautyengineJNI.BeautyUtilityWrapper_getBeautyMaigc(bitmap, f);
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (b != 0L)
        {
            if (a)
            {
                a = false;
                fotobeautyengineJNI.delete_BeautyUtilityWrapper(b);
            }
            b = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize()
    {
        a();
    }
}
