// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.internal;

import com.amazon.geo.mapsv2.model.internal.IMarkerDelegate;

// Referenced classes of package com.amazon.geo.mapsv2.internal:
//            IMapDelegate

public static interface 
{

    public abstract void onMarkerDrag(IMarkerDelegate imarkerdelegate);

    public abstract void onMarkerDragEnd(IMarkerDelegate imarkerdelegate);

    public abstract void onMarkerDragStart(IMarkerDelegate imarkerdelegate);
}
