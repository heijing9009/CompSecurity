// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package twitter4j:
//            AsyncTwitterImpl, Twitter, TwitterListener, TwitterMethod

class ncTask extends ncTask
{

    final AsyncTwitterImpl this$0;
    final long val$ids[];

    public void invoke(List list)
    {
        ResponseList responselist = AsyncTwitterImpl.access$000(AsyncTwitterImpl.this).lookupFriendships(val$ids);
        for (list = list.iterator(); list.hasNext();)
        {
            TwitterListener twitterlistener = (TwitterListener)list.next();
            try
            {
                twitterlistener.lookedUpFriendships(responselist);
            }
            catch (Exception exception) { }
        }

    }

    ncTask(List list, long al[])
    {
        this$0 = final_asynctwitterimpl;
        val$ids = al;
        super(final_asynctwitterimpl, TwitterMethod.this, list);
    }
}
