// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.photoselector;

import android.util.Log;
import android.widget.GridView;
import com.fotoable.photoselector.model.GroupGridAdapter;

// Referenced classes of package com.pipcamera.activity.photoselector:
//            PhotoSelectorGridFragment

class a
    implements android.view.outListener
{

    final GridView a;
    final PhotoSelectorGridFragment b;

    public void onGlobalLayout()
    {
        if (b.a.getNumColumns() == 0)
        {
            int i = (int)Math.floor(a.getWidth() / (PhotoSelectorGridFragment.a(b) + PhotoSelectorGridFragment.b(b)));
            if (i > 0)
            {
                int j = a.getWidth() / i;
                int k = PhotoSelectorGridFragment.b(b);
                b.a.setNumColumns(i);
                b.a.setItemHeight(j - k);
                Log.d("PhotoSelectorGridFragment", (new StringBuilder()).append("onCreateView - numColumns set to ").append(i).toString());
            }
        }
    }

    (PhotoSelectorGridFragment photoselectorgridfragment, GridView gridview)
    {
        b = photoselectorgridfragment;
        a = gridview;
        super();
    }
}
