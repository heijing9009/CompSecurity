// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kik.android.chat.fragment;

import android.view.View;
import kik.a.d.k;

// Referenced classes of package kik.android.chat.fragment:
//            KikDefaultContactsListFragment

final class kv
    implements android.view.View.OnClickListener
{

    final KikDefaultContactsListFragment a;

    kv(KikDefaultContactsListFragment kikdefaultcontactslistfragment)
    {
        a = kikdefaultcontactslistfragment;
        super();
    }

    public final void onClick(View view)
    {
        view = (k)view.getTag();
        a.a(view);
    }
}
