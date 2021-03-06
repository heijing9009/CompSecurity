// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.worklight.androidgap.plugin;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.worklight.androidgap.NoSuchResourceException;
import com.worklight.androidgap.WLDroidGap;
import com.worklight.common.WLUtils;

public class WLMenuItem
{

    private String callback;
    private boolean hasChanged;
    private int id;
    private String imagePath;
    private boolean isEnabled;
    private String javascriptId;
    private String title;

    public WLMenuItem(int i, String s, String s1, String s2, String s3, boolean flag)
    {
        id = i;
        javascriptId = s;
        callback = s1;
        title = s2;
        isEnabled = flag;
        setImagePath(s3);
        hasChanged = true;
    }

    private void setChanged()
    {
        hasChanged = true;
    }

    public String getCallback()
    {
        return callback;
    }

    public int getId()
    {
        return id;
    }

    public Drawable getImage(WLDroidGap wldroidgap)
    {
        Object obj = null;
        if (imagePath != null)
        {
            obj = wldroidgap.getResources();
            try
            {
                obj = ((Resources) (obj)).getDrawable(WLUtils.getResourceId(wldroidgap, "drawable", imagePath));
            }
            // Misplaced declaration of an exception variable
            catch (WLDroidGap wldroidgap)
            {
                WLUtils.error(wldroidgap.getMessage());
                return null;
            }
        }
        return ((Drawable) (obj));
    }

    public String getImagePath()
    {
        return imagePath;
    }

    public String getJavaScriptId()
    {
        return javascriptId;
    }

    public String getTitle()
    {
        return title;
    }

    public boolean hasChanged()
    {
        return hasChanged;
    }

    public boolean isEnabled()
    {
        return isEnabled;
    }

    public void setEnabled(boolean flag)
    {
        isEnabled = flag;
        setChanged();
    }

    public void setImagePath(String s)
    {
        if (s != null && !s.equals(imagePath))
        {
            imagePath = s;
            setChanged();
        }
    }

    public void setTitle(String s)
    {
        title = s;
        setChanged();
    }

    public void unsetChanged()
    {
        hasChanged = false;
    }
}
