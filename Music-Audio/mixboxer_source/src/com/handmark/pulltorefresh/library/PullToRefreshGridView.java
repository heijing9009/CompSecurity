// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshAdapterViewBase

public class PullToRefreshGridView extends PullToRefreshAdapterViewBase
{

    public PullToRefreshGridView(Context context)
    {
        super(context);
    }

    public PullToRefreshGridView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PullToRefreshGridView(Context context, PullToRefreshBase.Mode mode)
    {
        super(context, mode);
    }

    public PullToRefreshGridView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationstyle)
    {
        super(context, mode, animationstyle);
    }

    protected volatile View createRefreshableView(Context context, AttributeSet attributeset)
    {
        return createRefreshableView(context, attributeset);
    }

    protected final GridView createRefreshableView(Context context, AttributeSet attributeset)
    {
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            context = new InternalGridViewSDK9(context, attributeset);
        } else
        {
            context = new InternalGridView(context, attributeset);
        }
        context.setId(R.id.gridview);
        return context;
    }

    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
    {
        return PullToRefreshBase.Orientation.VERTICAL;
    }

    private class InternalGridViewSDK9 extends InternalGridView
    {
        private class InternalGridView extends GridView
            implements EmptyViewMethodAccessor
        {

            final PullToRefreshGridView this$0;

            public void setEmptyView(View view)
            {
                PullToRefreshGridView.this.setEmptyView(view);
            }

            public void setEmptyViewInternal(View view)
            {
                super.setEmptyView(view);
            }

            public InternalGridView(Context context, AttributeSet attributeset)
            {
                this$0 = PullToRefreshGridView.this;
                super(context, attributeset);
            }
        }


        final PullToRefreshGridView this$0;

        protected final boolean overScrollBy(int i, int j, int k, int l, int i1, int j1, int k1, 
                int l1, boolean flag)
        {
            boolean flag1 = super.overScrollBy(i, j, k, l, i1, j1, k1, l1, flag);
            OverscrollHelper.overScrollBy(PullToRefreshGridView.this, i, k, j, l, flag);
            return flag1;
        }

        public InternalGridViewSDK9(Context context, AttributeSet attributeset)
        {
            this$0 = PullToRefreshGridView.this;
            super(context, attributeset);
        }
    }

}
