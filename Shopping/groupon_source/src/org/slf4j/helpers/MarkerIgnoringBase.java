// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j.helpers;

import org.slf4j.Logger;

public abstract class MarkerIgnoringBase
    implements Logger
{

    public MarkerIgnoringBase()
    {
    }

    public String toString()
    {
        return getClass().getName() + "(" + getName() + ")";
    }
}
