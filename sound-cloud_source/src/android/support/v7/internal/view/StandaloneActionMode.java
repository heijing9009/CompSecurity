// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.view.menu.l;
import android.support.v7.internal.view.menu.q;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class StandaloneActionMode extends ActionMode
    implements android.support.v7.internal.view.menu.f.a
{

    private android.support.v7.view.ActionMode.Callback mCallback;
    private Context mContext;
    private ActionBarContextView mContextView;
    private WeakReference mCustomView;
    private boolean mFinished;
    private boolean mFocusable;
    private f mMenu;

    public StandaloneActionMode(Context context, ActionBarContextView actionbarcontextview, android.support.v7.view.ActionMode.Callback callback, boolean flag)
    {
        mContext = context;
        mContextView = actionbarcontextview;
        mCallback = callback;
        context = new f(actionbarcontextview.getContext());
        context.e = 1;
        mMenu = context;
        mMenu.a(this);
        mFocusable = flag;
    }

    public void finish()
    {
        if (mFinished)
        {
            return;
        } else
        {
            mFinished = true;
            mContextView.sendAccessibilityEvent(32);
            mCallback.onDestroyActionMode(this);
            return;
        }
    }

    public View getCustomView()
    {
        if (mCustomView != null)
        {
            return (View)mCustomView.get();
        } else
        {
            return null;
        }
    }

    public Menu getMenu()
    {
        return mMenu;
    }

    public MenuInflater getMenuInflater()
    {
        return new MenuInflater(mContextView.getContext());
    }

    public CharSequence getSubtitle()
    {
        return mContextView.getSubtitle();
    }

    public CharSequence getTitle()
    {
        return mContextView.getTitle();
    }

    public void invalidate()
    {
        mCallback.onPrepareActionMode(this, mMenu);
    }

    public boolean isTitleOptional()
    {
        return mContextView.isTitleOptional();
    }

    public boolean isUiFocusable()
    {
        return mFocusable;
    }

    public void onCloseMenu(f f1, boolean flag)
    {
    }

    public void onCloseSubMenu(q q1)
    {
    }

    public boolean onMenuItemSelected(f f1, MenuItem menuitem)
    {
        return mCallback.onActionItemClicked(this, menuitem);
    }

    public void onMenuModeChange(f f1)
    {
        invalidate();
        mContextView.showOverflowMenu();
    }

    public boolean onSubMenuSelected(q q1)
    {
        if (!q1.hasVisibleItems())
        {
            return true;
        } else
        {
            (new l(mContextView.getContext(), q1)).show();
            return true;
        }
    }

    public void setCustomView(View view)
    {
        mContextView.setCustomView(view);
        if (view != null)
        {
            view = new WeakReference(view);
        } else
        {
            view = null;
        }
        mCustomView = view;
    }

    public void setSubtitle(int i)
    {
        setSubtitle(((CharSequence) (mContext.getString(i))));
    }

    public void setSubtitle(CharSequence charsequence)
    {
        mContextView.setSubtitle(charsequence);
    }

    public void setTitle(int i)
    {
        setTitle(((CharSequence) (mContext.getString(i))));
    }

    public void setTitle(CharSequence charsequence)
    {
        mContextView.setTitle(charsequence);
    }

    public void setTitleOptionalHint(boolean flag)
    {
        super.setTitleOptionalHint(flag);
        mContextView.setTitleOptional(flag);
    }
}
