// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.libraries.commerce.ocr.loyalty.fragments;

import com.google.android.libraries.commerce.ocr.cv.CardRectifier;
import dagger.internal.ProvidesBinding;
import javax.inject.Provider;

// Referenced classes of package com.google.android.libraries.commerce.ocr.loyalty.fragments:
//            OcrModule

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private final OcrModule module;

    public final CardRectifier get()
    {
        OcrModule ocrmodule = module;
        return OcrModule.provideCardRectifier();
    }

    public final volatile Object get()
    {
        return get();
    }

    public (OcrModule ocrmodule)
    {
        super("com.google.android.libraries.commerce.ocr.cv.CardRectifier", true, "com.google.android.libraries.commerce.ocr.loyalty.fragments.OcrModule", "provideCardRectifier");
        module = ocrmodule;
        setLibrary(true);
    }
}
