// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.aio.downloader.activity.FunGifActivity;
import com.aio.downloader.model.Fun_appModel;
import com.aio.downloader.utils.publicTools;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_app_Listview_Adapter

class this._cls1 extends Thread
{

    final l_gif this$1;

    public void run()
    {
        super.run();
        Log.e("www", (new StringBuilder("url=+")).append(l_gif).toString());
        publicTools.getUrl(l_gif);
    }

    l.ppp()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/Home_app_Listview_Adapter$9

/* anonymous class */
    class Home_app_Listview_Adapter._cls9
        implements android.view.View.OnClickListener
    {

        final Home_app_Listview_Adapter this$0;
        private String url_gif;
        private final int val$ppp;

        public void onClick(View view)
        {
            url_gif = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(ppp)).getSerial()).toString();
            (new Home_app_Listview_Adapter._cls9._cls1()).start();
            view = new Intent(Home_app_Listview_Adapter.access$0(Home_app_Listview_Adapter.this), com/aio/downloader/activity/FunGifActivity);
            view.putExtra("fullpath", ((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(ppp)).getImg_src());
            view.putExtra("apath", ((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(ppp)).getThu_path());
            view.putExtra("detailtitle", ((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(ppp)).getTitle());
            view.putExtra("detailcount", ((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(ppp)).getImg_count());
            Home_app_Listview_Adapter.access$0(Home_app_Listview_Adapter.this).startActivity(view);
        }


            
            {
                this$0 = final_home_app_listview_adapter;
                ppp = I.this;
                super();
            }
    }

}
