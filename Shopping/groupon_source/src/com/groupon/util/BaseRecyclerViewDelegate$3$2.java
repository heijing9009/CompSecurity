// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import com.groupon.db.models.Pagination;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.view.GrouponSwipeRefreshLayoutV3;
import java.util.List;

// Referenced classes of package com.groupon.util:
//            Function2, BaseRecyclerViewDelegate, LoaderCallbacksUtil

class this._cls1
    implements Function2
{

    final is._cls0 this$1;

    public volatile void execute(Object obj, Object obj1)
        throws Exception
    {
        execute((Runnable)obj, (Exception)obj1);
    }

    public void execute(Runnable runnable, Exception exception)
    {
        runnable = BaseRecyclerViewDelegate.access$000(_fld0).getList();
        if (runnable.size() > 0)
        {
            int i = runnable.size() - 1;
            if (runnable.get(i) instanceof Pagination)
            {
                runnable.remove(i);
            }
            BaseRecyclerViewDelegate.access$000(_fld0).setList(runnable);
        }
        BaseRecyclerViewDelegate.access$702(_fld0, false);
    }

    l.context()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/util/BaseRecyclerViewDelegate$3

/* anonymous class */
    class BaseRecyclerViewDelegate._cls3
        implements Function2
    {

        final BaseRecyclerViewDelegate this$0;
        final Context val$context;

        public volatile void execute(Object obj, Object obj1)
            throws Exception
        {
            execute((Runnable)obj, (Exception)obj1);
        }

        public void execute(Runnable runnable, Exception exception)
        {
            if (!BaseRecyclerViewDelegate.access$300(BaseRecyclerViewDelegate.this))
            {
                LoaderCallbacksUtil.showGenericErrorMessage(runnable, exception, context, BaseRecyclerViewDelegate.access$400(BaseRecyclerViewDelegate.this), BaseRecyclerViewDelegate.access$500(BaseRecyclerViewDelegate.this), new BaseRecyclerViewDelegate._cls3._cls1(), new BaseRecyclerViewDelegate._cls3._cls2());
            }
        }

            
            {
                this$0 = final_baserecyclerviewdelegate;
                context = Context.this;
                super();
            }

        // Unreferenced inner class com/groupon/util/BaseRecyclerViewDelegate$3$1

/* anonymous class */
        class BaseRecyclerViewDelegate._cls3._cls1
            implements Function2
        {

            final BaseRecyclerViewDelegate._cls3 this$1;

            public volatile void execute(Object obj, Object obj1)
                throws Exception
            {
                execute((Runnable)obj, (Exception)obj1);
            }

            public void execute(Runnable runnable, Exception exception)
            {
                if (BaseRecyclerViewDelegate.access$600(this$0) != null && BaseRecyclerViewDelegate.access$600(this$0).isEnabled())
                {
                    BaseRecyclerViewDelegate.access$600(this$0).setRefreshing(true);
                }
                BaseRecyclerViewDelegate.access$702(this$0, false);
            }

                    
                    {
                        this$1 = BaseRecyclerViewDelegate._cls3.this;
                        super();
                    }
        }

    }

}
