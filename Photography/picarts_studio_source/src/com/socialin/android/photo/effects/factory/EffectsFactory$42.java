// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.factory;

import android.graphics.Point;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.util.Log;
import com.photo.effect.EffectParameter;
import com.photo.effect.a;
import com.photo.effect.b;
import com.photo.effect.c;
import com.photo.effect.d;
import com.socialin.android.photo.imgop.ImageOp;
import java.util.ArrayList;
import myobfuscated.ay.e;

// Referenced classes of package com.socialin.android.photo.effects.factory:
//            EffectsFactory

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        int i = EffectParameter.b(arraylist, "Lines");
        int j = EffectParameter.b(arraylist, "Brightness");
        int k = EffectParameter.b(arraylist, "Contrast");
        int l = EffectParameter.b(arraylist, "Fade");
        String s = (String)EffectParameter.a(arraylist, "texture").c;
        Log.e("ex1", (new StringBuilder("lines = ")).append(i).toString());
        Log.e("ex1", (new StringBuilder("brightness = ")).append(j).toString());
        Log.e("ex1", (new StringBuilder("contrast = ")).append(k).toString());
        Log.e("ex1", (new StringBuilder("fade = ")).append(l).toString());
        Log.e("ex1", (new StringBuilder("textureName = ")).append(s).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$2700((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, a1.a, i, j, k, s, l);
        } else
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            d = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            android.content.Context context = a1.a;
            int i1 = point.x;
            int j1 = point.y;
            boolean flag = a1.f;
            int k1 = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(k1).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(i1).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(j1).toString());
            a1 = e.a(context, "sinEnc", s, i1, j1);
            if (a1 != null)
            {
                ImageOp.bleaching4buf(d, bytebuffer, i1, j1, i1, j1, a1, i1, j1, i, j, k, l, flag, k1);
                e.a(a1);
                arraylist.a = true;
                return arraylist;
            }
        }
        return arraylist;
    }

    ()
    {
    }
}
