// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import android.support.v7.app.AlertDialog;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadStrategy;

// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            ManualUploadAction

class loadRequest
    implements Runnable
{

    final ManualUploadAction this$0;
    final loadRequest val$uploadRequest;

    public void run()
    {
        (new android.support.v7.app.init>(ManualUploadAction.access$500(ManualUploadAction.this))).etTitle(0x7f0e0183).etMessage(0x7f0e0182).etPositiveButton(0x7f0e0093, new loadDialogClickListener(ManualUploadAction.this, val$uploadRequest)).etNegativeButton(0x7f0e01a3, new loadDialogClickListener(ManualUploadAction.this, val$uploadRequest, UploadStrategy.WIFI_ONLY, stUploadAction.WIRELESS_SETTINGS)).reate().show();
    }

    loadRequest()
    {
        this$0 = final_manualuploadaction;
        val$uploadRequest = loadRequest.this;
        super();
    }
}
