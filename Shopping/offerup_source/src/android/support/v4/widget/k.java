// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

// Referenced classes of package android.support.v4.widget:
//            o, n, l, m

public abstract class k extends BaseAdapter
    implements o, Filterable
{

    protected boolean mAutoRequery;
    protected l mChangeObserver;
    protected Context mContext;
    protected Cursor mCursor;
    protected n mCursorFilter;
    protected DataSetObserver mDataSetObserver;
    protected boolean mDataValid;
    protected FilterQueryProvider mFilterQueryProvider;
    protected int mRowIDColumn;

    public k(Context context, Cursor cursor, boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        init(context, cursor, i);
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    public void changeCursor(Cursor cursor)
    {
        cursor = swapCursor(cursor);
        if (cursor != null)
        {
            cursor.close();
        }
    }

    public CharSequence convertToString(Cursor cursor)
    {
        if (cursor == null)
        {
            return "";
        } else
        {
            return cursor.toString();
        }
    }

    public int getCount()
    {
        if (mDataValid && mCursor != null)
        {
            return mCursor.getCount();
        } else
        {
            return 0;
        }
    }

    public Cursor getCursor()
    {
        return mCursor;
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        if (mDataValid)
        {
            mCursor.moveToPosition(i);
            View view1 = view;
            if (view == null)
            {
                view1 = newDropDownView(mContext, mCursor, viewgroup);
            }
            bindView(view1, mContext, mCursor);
            return view1;
        } else
        {
            return null;
        }
    }

    public Filter getFilter()
    {
        if (mCursorFilter == null)
        {
            mCursorFilter = new n(this);
        }
        return mCursorFilter;
    }

    public Object getItem(int i)
    {
        if (mDataValid && mCursor != null)
        {
            mCursor.moveToPosition(i);
            return mCursor;
        } else
        {
            return null;
        }
    }

    public long getItemId(int i)
    {
        long l2 = 0L;
        long l1 = l2;
        if (mDataValid)
        {
            l1 = l2;
            if (mCursor != null)
            {
                l1 = l2;
                if (mCursor.moveToPosition(i))
                {
                    l1 = mCursor.getLong(mRowIDColumn);
                }
            }
        }
        return l1;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (!mDataValid)
        {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!mCursor.moveToPosition(i))
        {
            throw new IllegalStateException((new StringBuilder("couldn't move cursor to position ")).append(i).toString());
        }
        View view1 = view;
        if (view == null)
        {
            view1 = newView(mContext, mCursor, viewgroup);
        }
        bindView(view1, mContext, mCursor);
        return view1;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    void init(Context context, Cursor cursor, int i)
    {
        boolean flag = true;
        int j;
        if ((i & 1) == 1)
        {
            i |= 2;
            mAutoRequery = true;
        } else
        {
            mAutoRequery = false;
        }
        if (cursor == null)
        {
            flag = false;
        }
        mCursor = cursor;
        mDataValid = flag;
        mContext = context;
        if (flag)
        {
            j = cursor.getColumnIndexOrThrow("_id");
        } else
        {
            j = -1;
        }
        mRowIDColumn = j;
        if ((i & 2) == 2)
        {
            mChangeObserver = new l(this);
            mDataSetObserver = new m(this, (byte)0);
        } else
        {
            mChangeObserver = null;
            mDataSetObserver = null;
        }
        if (flag)
        {
            if (mChangeObserver != null)
            {
                cursor.registerContentObserver(mChangeObserver);
            }
            if (mDataSetObserver != null)
            {
                cursor.registerDataSetObserver(mDataSetObserver);
            }
        }
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        return newView(context, cursor, viewgroup);
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewgroup);

    protected void onContentChanged()
    {
        if (mAutoRequery && mCursor != null && !mCursor.isClosed())
        {
            mDataValid = mCursor.requery();
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charsequence)
    {
        if (mFilterQueryProvider != null)
        {
            return mFilterQueryProvider.runQuery(charsequence);
        } else
        {
            return mCursor;
        }
    }

    public Cursor swapCursor(Cursor cursor)
    {
        if (cursor == mCursor)
        {
            return null;
        }
        Cursor cursor1 = mCursor;
        if (cursor1 != null)
        {
            if (mChangeObserver != null)
            {
                cursor1.unregisterContentObserver(mChangeObserver);
            }
            if (mDataSetObserver != null)
            {
                cursor1.unregisterDataSetObserver(mDataSetObserver);
            }
        }
        mCursor = cursor;
        if (cursor != null)
        {
            if (mChangeObserver != null)
            {
                cursor.registerContentObserver(mChangeObserver);
            }
            if (mDataSetObserver != null)
            {
                cursor.registerDataSetObserver(mDataSetObserver);
            }
            mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
            mDataValid = true;
            notifyDataSetChanged();
            return cursor1;
        } else
        {
            mRowIDColumn = -1;
            mDataValid = false;
            notifyDataSetInvalidated();
            return cursor1;
        }
    }
}
