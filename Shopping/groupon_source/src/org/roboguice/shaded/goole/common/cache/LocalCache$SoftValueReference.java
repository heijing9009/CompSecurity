// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            LocalCache

static class entry extends SoftReference
    implements entry
{

    final get entry;

    public entry copyFor(ReferenceQueue referencequeue, Object obj, entry entry1)
    {
        return new <init>(referencequeue, obj, entry1);
    }

    public <init> getEntry()
    {
        return entry;
    }

    public int getWeight()
    {
        return 1;
    }

    public boolean isActive()
    {
        return true;
    }

    public boolean isLoading()
    {
        return false;
    }

    public void notifyNewValue(Object obj)
    {
    }

    public Object waitForValue()
    {
        return get();
    }

    (ReferenceQueue referencequeue, Object obj,  )
    {
        super(obj, referencequeue);
        entry = ;
    }
}
