// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.NetWorkUtil;
import com.aio.downloader.utils.publicTools;
import java.util.List;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_Gridview_Adapter

class val.mHas_apk
    implements android.view.iew_Adapter._cls7
{

    final Home_Gridview_Adapter this$0;
    private final String val$mHas_apk;
    private final int val$myPosition;

    public void onClick(View view)
    {
        Home_Gridview_Adapter.access$2(Home_Gridview_Adapter.this).edit().putString("appname", ((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(val$myPosition)).getTitle()).commit();
        if (!val$mHas_apk.equals("1")) goto _L2; else goto _L1
_L1:
        (new Thread(new Runnable() {

            final Home_Gridview_Adapter._cls7 this$1;
            private final int val$myPosition;

            public void run()
            {
                Log.e("bbb", (new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(((DownloadMovieItem)Home_Gridview_Adapter.access$9(this$0).get(myPosition)).getId()).append("&from=apk").toString());
                publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(((DownloadMovieItem)Home_Gridview_Adapter.access$9(this$0).get(myPosition)).getId()).append("&from=apk").toString());
            }

            
            {
                this$1 = Home_Gridview_Adapter._cls7.this;
                myPosition = i;
                super();
            }
        })).start();
        if (Home_Gridview_Adapter.access$10(Home_Gridview_Adapter.this).getBoolean("isopen", false) && NetWorkUtil.getAPNType(Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this)) != 1)
        {
            Home_Gridview_Adapter.access$11(Home_Gridview_Adapter.this);
            return;
        }
        if (Home_Gridview_Adapter.access$12(Home_Gridview_Adapter.this).queryfile(((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(val$myPosition)).getId()) == null)
        {
            MydownloadApk(((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(val$myPosition)).getId(), ((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(val$myPosition)).getTitle(), ((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(val$myPosition)).getIcon(), ((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(val$myPosition)).getSerial());
        } else
        {
            try
            {
                Toast.makeText(Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this), "It has been in downloading list already.", 1).show();
            }
            // Misplaced declaration of an exception variable
            catch (View view) { }
        }
_L4:
        (new Handler()).post(new Runnable() {

            final Home_Gridview_Adapter._cls7 this$1;

            public void run()
            {
                Home_Gridview_Adapter.access$5(this$0).dismiss();
            }

            
            {
                this$1 = Home_Gridview_Adapter._cls7.this;
                super();
            }
        });
        return;
_L2:
        if (val$mHas_apk.equals("0"))
        {
            (new Thread(new Runnable() {

                final Home_Gridview_Adapter._cls7 this$1;
                private final int val$myPosition;

                public void run()
                {
                    try
                    {
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(((DownloadMovieItem)Home_Gridview_Adapter.access$9(this$0).get(myPosition)).getId()).append("&from=google").toString());
                        return;
                    }
                    catch (Exception exception)
                    {
                        return;
                    }
                }

            
            {
                this$1 = Home_Gridview_Adapter._cls7.this;
                myPosition = i;
                super();
            }
            })).start();
            view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(val$myPosition)).getId()).toString()));
            Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this).startActivity(view);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }


    _cls3.this._cls1()
    {
        this$0 = final_home_gridview_adapter;
        val$myPosition = i;
        val$mHas_apk = String.this;
        super();
    }
}
