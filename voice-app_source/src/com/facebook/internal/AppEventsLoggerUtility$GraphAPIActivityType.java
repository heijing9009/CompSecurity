// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;


// Referenced classes of package com.facebook.internal:
//            AppEventsLoggerUtility

public static final class  extends Enum
{

    public static final CUSTOM_APP_EVENTS CUSTOM_APP_EVENTS;
    private static final CUSTOM_APP_EVENTS ENUM$VALUES[];
    public static final CUSTOM_APP_EVENTS MOBILE_INSTALL_EVENT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/facebook/internal/AppEventsLoggerUtility$GraphAPIActivityType, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        MOBILE_INSTALL_EVENT = new <init>("MOBILE_INSTALL_EVENT", 0);
        CUSTOM_APP_EVENTS = new <init>("CUSTOM_APP_EVENTS", 1);
        ENUM$VALUES = (new ENUM.VALUES[] {
            MOBILE_INSTALL_EVENT, CUSTOM_APP_EVENTS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
