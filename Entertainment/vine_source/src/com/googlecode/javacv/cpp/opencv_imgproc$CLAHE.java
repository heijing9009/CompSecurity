// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_imgproc

public static class  extends 
{

    public native void apply( ,  1);

    public native void collectGarbage();

    public native double getClipLimit();

    public native  getTilesGridSize();

    public native void setClipLimit(double d);

    public native void setTilesGridSize( );

    static 
    {
        Loader.load();
    }

    public ()
    {
    }

    public (Pointer pointer)
    {
        super(pointer);
    }
}
