// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.media;

import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.model.media:
//            Photo

public interface OrderedGroupPhoto
    extends Photo
{

    public abstract void clearFrames();

    public abstract List getFrames();

    public abstract void setFrames(List list);
}
