// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe;

import android.content.DialogInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.sponsorpay.publisher.SponsorPayPublisher;
import com.sponsorpay.utils.SponsorPayLogger;

// Referenced classes of package com.sponsorpay.publisher.mbe:
//            SPBrandEngageClient

class this._cls1
    implements android.content.Listener
{

    final is._cls0 this$1;

    public void onCancel(DialogInterface dialoginterface)
    {
        SPBrandEngageClient.access$10(_fld0, false);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/sponsorpay/publisher/mbe/SPBrandEngageClient$7

/* anonymous class */
    class SPBrandEngageClient._cls7 extends WebChromeClient
    {

        final SPBrandEngageClient this$0;

        private void showJSDialog(String s, String s1)
        {
            SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("js alert - ")).append(s1).toString());
            if (!SPBrandEngageClient.access$17(SPBrandEngageClient.this))
            {
                SPBrandEngageClient.access$10(SPBrandEngageClient.this, true);
                if (SPBrandEngageClient.access$16(SPBrandEngageClient.this) == null)
                {
                    s = SPBrandEngageClient.access$12(SPBrandEngageClient.this);
                } else
                {
                    s = SPBrandEngageClient.access$16(SPBrandEngageClient.this);
                }
                s = new android.app.AlertDialog.Builder(s);
                s.setTitle(SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.MBE_FORFEIT_DIALOG_TITLE)).setMessage(s1).setPositiveButton("OK", new SPBrandEngageClient._cls7._cls1()).setNegativeButton("Cancel", new SPBrandEngageClient._cls7._cls2()).setOnCancelListener(new SPBrandEngageClient._cls7._cls3());
                s.show();
            }
        }

        public boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
        {
            SponsorPayLogger.d("SPBrandEngageClient", (new StringBuilder("js alert - ")).append(s1).toString());
            showJSDialog(s, s1);
            jsresult.cancel();
            return true;
        }


            
            {
                this$0 = SPBrandEngageClient.this;
                super();
            }

        // Unreferenced inner class com/sponsorpay/publisher/mbe/SPBrandEngageClient$7$1

/* anonymous class */
        class SPBrandEngageClient._cls7._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final SPBrandEngageClient._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                SPBrandEngageClient.access$14(this$0, "CLOSE_ABORTED");
                SPBrandEngageClient.access$10(this$0, false);
            }

                    
                    {
                        this$1 = SPBrandEngageClient._cls7.this;
                        super();
                    }
        }


        // Unreferenced inner class com/sponsorpay/publisher/mbe/SPBrandEngageClient$7$2

/* anonymous class */
        class SPBrandEngageClient._cls7._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final SPBrandEngageClient._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                SPBrandEngageClient.access$10(this$0, false);
            }

                    
                    {
                        this$1 = SPBrandEngageClient._cls7.this;
                        super();
                    }
        }

    }

}
