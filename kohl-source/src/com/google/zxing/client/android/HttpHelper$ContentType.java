// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.android;


// Referenced classes of package com.google.zxing.client.android:
//            HttpHelper

public static final class  extends Enum
{

    private static final TEXT $VALUES[];
    public static final TEXT HTML;
    public static final TEXT JSON;
    public static final TEXT TEXT;
    public static final TEXT XML;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/zxing/client/android/HttpHelper$ContentType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HTML = new <init>("HTML", 0);
        JSON = new <init>("JSON", 1);
        XML = new <init>("XML", 2);
        TEXT = new <init>("TEXT", 3);
        $VALUES = (new .VALUES[] {
            HTML, JSON, XML, TEXT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
