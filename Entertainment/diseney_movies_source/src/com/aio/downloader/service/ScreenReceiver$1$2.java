// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.aio.downloader.dialog.CleanerUPDialog;
import com.aio.downloader.utils.Myutils;
import com.umeng.analytics.MobclickAgent;
import java.io.File;

// Referenced classes of package com.aio.downloader.service:
//            ScreenReceiver

class val.dialog
    implements android.view.r
{

    final kTrace this$1;
    private final CleanerUPDialog val$dialog;

    public void onClick(View view)
    {
        MobclickAgent.onEvent(ScreenReceiver.access$0(_fld0), "cleanerupdate_click");
        view = null;
        android.content.pm.PackageInfo packageinfo = ScreenReceiver.access$0(_fld0).getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        view = packageinfo;
_L1:
        android.content.pm.NotFoundException notfoundexception;
        if (view == null)
        {
            if (ScreenReceiver.access$1(_fld0).exists())
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ScreenReceiver.access$2(_fld0)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                ScreenReceiver.access$0(_fld0).startActivity(view);
            } else
            if (ScreenReceiver.access$3(_fld0).exists())
            {
                (new AsyncTask() {

                    final ScreenReceiver._cls1._cls2 this$2;

                    protected volatile transient Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected transient Void doInBackground(Void avoid[])
                    {
                        Myutils.copyfile(ScreenReceiver.access$3(this$0), ScreenReceiver.access$1(this$0), Boolean.valueOf(false));
                        return null;
                    }

                    protected volatile void onPostExecute(Object obj)
                    {
                        onPostExecute((Void)obj);
                    }

                    protected void onPostExecute(Void void1)
                    {
                        super.onPostExecute(void1);
                        void1 = new Intent("android.intent.action.VIEW");
                        void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(ScreenReceiver.access$2(this$0)).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                        void1.addFlags(0x10000000);
                        ScreenReceiver.access$0(this$0).startActivity(void1);
                    }

            
            {
                this$2 = ScreenReceiver._cls1._cls2.this;
                super();
            }
                }).execute(new Void[0]);
            }
        }
        val$dialog.dismiss();
        return;
        notfoundexception;
        notfoundexception.printStackTrace();
          goto _L1
    }


    is._cls0()
    {
        this$1 = final__pcls0;
        val$dialog = CleanerUPDialog.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/service/ScreenReceiver$1

/* anonymous class */
    class ScreenReceiver._cls1 extends Handler
    {

        final ScreenReceiver this$0;

        public void handleMessage(final Message dialog)
        {
            super.handleMessage(dialog);
            dialog = new CleanerUPDialog(ScreenReceiver.access$0(ScreenReceiver.this), 0x7f0c000e);
            dialog.setCanceledOnTouchOutside(false);
            dialog.getWindow().setType(2003);
            dialog.show();
            Button button = (Button)dialog.findViewById(0x7f070141);
            Button button1 = (Button)dialog.findViewById(0x7f070142);
            button.setOnClickListener(new ScreenReceiver._cls1._cls1());
            button1.setOnClickListener(dialog. new ScreenReceiver._cls1._cls2());
        }


            
            {
                this$0 = ScreenReceiver.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/service/ScreenReceiver$1$1

/* anonymous class */
        class ScreenReceiver._cls1._cls1
            implements android.view.View.OnClickListener
        {

            final ScreenReceiver._cls1 this$1;
            private final CleanerUPDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

                    
                    {
                        this$1 = ScreenReceiver._cls1.this;
                        dialog = cleanerupdialog;
                        super();
                    }
        }

    }

}
