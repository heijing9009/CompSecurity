// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import android.widget.ListView;

public class 
    implements butterknife..ViewBinder
{

    public void bind(butterknife..ViewBinder viewbinder,  , Object obj)
    {
        . = (ListView)viewbinder.listView((View)viewbinder.listView(obj, 0x7f10059d, "field 'listView'"), 0x7f10059d, "field 'listView'");
    }

    public volatile void bind(butterknife..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
