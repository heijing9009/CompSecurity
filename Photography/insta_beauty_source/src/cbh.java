// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cbh
    implements Runnable
{

    final cbg a;

    cbh(cbg cbg1)
    {
        a = cbg1;
        super();
    }

    public void run()
    {
        if (cbg.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cbg.a(a, OpenGlUtils.a(cbg.b(a), -1, true));
        }
    }
}
