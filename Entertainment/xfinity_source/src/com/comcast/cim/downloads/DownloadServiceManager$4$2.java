// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import com.penthera.virtuososdk.client.IQueueObserver;
import com.penthera.virtuososdk.client.IVirtuosoAsset;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;
import com.penthera.virtuososdk.client.Virtuoso;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadServiceManager

class val.file
    implements Runnable
{

    final leProgressUpdated this$1;
    final IVirtuosoAsset val$file;

    public void run()
    {
        DownloadFile downloadfile = DownloadServiceManager.access$800(_fld0, val$file);
        DownloadServiceManager.access$900(_fld0).put(val$file.uuid(), downloadfile);
        onFileProgressUpdated(downloadfile);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$file = IVirtuosoAsset.this;
        super();
    }

    // Unreferenced inner class com/comcast/cim/downloads/DownloadServiceManager$4

/* anonymous class */
    class DownloadServiceManager._cls4
        implements IQueueObserver
    {

        final DownloadServiceManager this$0;

        public void downloadEngineDidFinishDownloadingFile(final IVirtuosoIdentifier file)
        {
            DownloadServiceManager.access$000().debug("Callback downloadEngineDidFinishDownloadingFile");
            if (file.type() == 4)
            {
                file = (IVirtuosoAsset)file;
                backgroundExecutor.execute(new DownloadServiceManager._cls4._cls3());
            }
        }

        public void downloadEngineDidStartDownloadingFile(final IVirtuosoIdentifier file)
        {
            DownloadServiceManager.access$000().debug("Callback downloadEngineDidStartDownloadingFile");
            if (file.type() == 4)
            {
                file = (IVirtuosoAsset)file;
                backgroundExecutor.execute(new DownloadServiceManager._cls4._cls1());
            }
        }

        public void downloadEngineFileWithError(final IVirtuosoIdentifier file)
        {
            DownloadServiceManager.access$000().debug("Callback downloadEngineFileWithError");
            if (file.type() == 4)
            {
                file = (IVirtuosoAsset)file;
                backgroundExecutor.execute(new DownloadServiceManager._cls4._cls4());
            }
        }

        public void downloadEngineProgressUpdatedForFile(IVirtuosoIdentifier ivirtuosoidentifier)
        {
            DownloadServiceManager.access$000().debug("Callback downloadEngineProgressUpdatedForFile");
            if (ivirtuosoidentifier.type() == 4)
            {
                ivirtuosoidentifier = (IVirtuosoAsset)ivirtuosoidentifier;
                backgroundExecutor.execute(ivirtuosoidentifier. new DownloadServiceManager._cls4._cls2());
            }
        }

        public void engineDownloadQueueChanged()
        {
            backgroundExecutor.execute(new DownloadServiceManager._cls4._cls6(DownloadServiceManager.access$500(DownloadServiceManager.this).queuedRootList(), DownloadServiceManager.access$900(DownloadServiceManager.this)));
        }

        public void fragmentComplete(final IVirtuosoIdentifier file)
        {
            DownloadServiceManager.access$000().debug("Callback downloadEngineProgressUpdatedForFile");
            if (file.type() == 4)
            {
                file = (IVirtuosoAsset)file;
                backgroundExecutor.execute(new DownloadServiceManager._cls4._cls5());
            }
        }

            
            {
                this$0 = DownloadServiceManager.this;
                super();
            }

        // Unreferenced inner class com/comcast/cim/downloads/DownloadServiceManager$4$1

/* anonymous class */
        class DownloadServiceManager._cls4._cls1
            implements Runnable
        {

            final DownloadServiceManager._cls4 this$1;
            final IVirtuosoAsset val$file;

            public void run()
            {
                DownloadFile downloadfile = DownloadServiceManager.access$800(this$0, file);
                DownloadServiceManager.access$900(this$0).put(file.uuid(), downloadfile);
                onFileDownloadStarted(downloadfile);
            }

                    
                    {
                        this$1 = DownloadServiceManager._cls4.this;
                        file = ivirtuosoasset;
                        super();
                    }
        }


        // Unreferenced inner class com/comcast/cim/downloads/DownloadServiceManager$4$3

/* anonymous class */
        class DownloadServiceManager._cls4._cls3
            implements Runnable
        {

            final DownloadServiceManager._cls4 this$1;
            final IVirtuosoAsset val$file;

            public void run()
            {
                DownloadServiceManager.access$000().debug((new StringBuilder()).append("File Progress is : ").append(file.currentSize()).append(":").append(file.expectedSize()).append(", percent complete: ").append(file.fractionComplete()).toString());
                DownloadFile downloadfile = DownloadServiceManager.access$800(this$0, file);
                DownloadServiceManager.access$900(this$0).put(file.uuid(), downloadfile);
                onFileDownloadFinished(downloadfile);
            }

                    
                    {
                        this$1 = DownloadServiceManager._cls4.this;
                        file = ivirtuosoasset;
                        super();
                    }
        }


        // Unreferenced inner class com/comcast/cim/downloads/DownloadServiceManager$4$4

/* anonymous class */
        class DownloadServiceManager._cls4._cls4
            implements Runnable
        {

            final DownloadServiceManager._cls4 this$1;
            final IVirtuosoAsset val$file;

            public void run()
            {
                DownloadFile downloadfile = DownloadServiceManager.access$800(this$0, file);
                DownloadServiceManager.access$900(this$0).put(file.uuid(), downloadfile);
                onFileDownloadError(downloadfile);
            }

                    
                    {
                        this$1 = DownloadServiceManager._cls4.this;
                        file = ivirtuosoasset;
                        super();
                    }
        }


        // Unreferenced inner class com/comcast/cim/downloads/DownloadServiceManager$4$5

/* anonymous class */
        class DownloadServiceManager._cls4._cls5
            implements Runnable
        {

            final DownloadServiceManager._cls4 this$1;
            final IVirtuosoAsset val$file;

            public void run()
            {
                DownloadFile downloadfile = DownloadServiceManager.access$800(this$0, file);
                DownloadServiceManager.access$900(this$0).put(file.uuid(), downloadfile);
                onFileProgressUpdated(downloadfile);
            }

                    
                    {
                        this$1 = DownloadServiceManager._cls4.this;
                        file = ivirtuosoasset;
                        super();
                    }
        }


        // Unreferenced inner class com/comcast/cim/downloads/DownloadServiceManager$4$6

/* anonymous class */
        class DownloadServiceManager._cls4._cls6 extends DownloadServiceManager.UpdateDownloadableFileMapTask
        {

            final DownloadServiceManager._cls4 this$1;

            protected void onFileMapRetrieved()
            {
                DownloadServiceManager.access$1002(this$0, true);
            }

                    
                    {
                        this$1 = DownloadServiceManager._cls4.this;
                        super(this$0, list, map);
                    }
        }

    }

}
