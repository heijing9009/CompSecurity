// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cardinalblue.android.piccollage.view.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.cardinalblue.android.b.k;
import com.cardinalblue.android.piccollage.activities.PublicCollageActivity;
import com.cardinalblue.android.piccollage.controller.FeedAccessorFactory;

// Referenced classes of package com.cardinalblue.android.piccollage.view.fragments:
//            o, j

class a
    implements android.widget.terView.OnItemClickListener
{

    final o a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (!k.b(a.getActivity()))
        {
            k.a(a.getActivity(), 0x7f07021d, 1);
            return;
        } else
        {
            adapterview = new Intent(a.getActivity(), com/cardinalblue/android/piccollage/activities/PublicCollageActivity);
            adapterview.setAction("piccollage.intent.action.VIEW_MULTIPLE_COLLAGES");
            adapterview.putExtra("position", i);
            adapterview.putExtra("web_photos_data", o.b(a).a());
            adapterview.putExtra("extra_start_from", o.a(a));
            adapterview.putExtra("feed_accessor", FeedAccessorFactory.a(8, null));
            a.startActivityForResult(adapterview, 1);
            return;
        }
    }

    ssorFactory(o o1)
    {
        a = o1;
        super();
    }
}
