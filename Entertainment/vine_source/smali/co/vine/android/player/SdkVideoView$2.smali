.class Lco/vine/android/player/SdkVideoView$2;
.super Ljava/lang/Object;
.source "SdkVideoView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/player/SdkVideoView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/player/SdkVideoView;


# direct methods
.method constructor <init>(Lco/vine/android/player/SdkVideoView;)V
    .locals 0

    .prologue
    .line 294
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    const/4 v1, 0x0

    .line 298
    # getter for: Lco/vine/android/player/SdkVideoView;->LOCK:[I
    invoke-static {}, Lco/vine/android/player/SdkVideoView;->access$200()[I

    move-result-object v3

    monitor-enter v3

    .line 299
    :try_start_0
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    # setter for: Lco/vine/android/player/SdkVideoView;->currentView:Landroid/view/View;
    invoke-static {v2}, Lco/vine/android/player/SdkVideoView;->access$302(Landroid/view/View;)Landroid/view/View;

    .line 300
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mUri:Landroid/net/Uri;
    invoke-static {v2}, Lco/vine/android/player/SdkVideoView;->access$400(Lco/vine/android/player/SdkVideoView;)Landroid/net/Uri;

    move-result-object v2

    if-nez v2, :cond_0

    .line 301
    # getter for: Lco/vine/android/player/SdkVideoView;->TAG:Ljava/lang/String;
    invoke-static {}, Lco/vine/android/player/SdkVideoView;->access$500()Ljava/lang/String;

    move-result-object v2

    const-string v4, "mUri  is not ready yet."

    invoke-static {v2, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 303
    monitor-exit v3

    .line 335
    :goto_0
    return-void

    .line 305
    :cond_0
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mSurfaceHolder:Landroid/view/Surface;
    invoke-static {v2}, Lco/vine/android/player/SdkVideoView;->access$600(Lco/vine/android/player/SdkVideoView;)Landroid/view/Surface;

    move-result-object v2

    if-nez v2, :cond_3

    .line 306
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mAutoShow:Z
    invoke-static {v2}, Lco/vine/android/player/SdkVideoView;->access$700(Lco/vine/android/player/SdkVideoView;)Z

    move-result v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v2}, Lco/vine/android/player/SdkVideoView;->getVisibility()I

    move-result v2

    if-eqz v2, :cond_1

    const/4 v1, 0x1

    .line 307
    .local v1, "show":Z
    :cond_1
    # getter for: Lco/vine/android/player/SdkVideoView;->TAG:Ljava/lang/String;
    invoke-static {}, Lco/vine/android/player/SdkVideoView;->access$500()Ljava/lang/String;

    move-result-object v2

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Surface is not ready yet, will autoshow ? "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mAutoShow:Z
    invoke-static {v5}, Lco/vine/android/player/SdkVideoView;->access$700(Lco/vine/android/player/SdkVideoView;)Z

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " & "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v5}, Lco/vine/android/player/SdkVideoView;->getVisibility()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 308
    if-eqz v1, :cond_2

    .line 309
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 311
    :cond_2
    monitor-exit v3

    goto :goto_0

    .line 334
    .end local v1    # "show":Z
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .line 313
    :cond_3
    :try_start_1
    # getter for: Lco/vine/android/player/SdkVideoView;->TAG:Ljava/lang/String;
    invoke-static {}, Lco/vine/android/player/SdkVideoView;->access$500()Ljava/lang/String;

    move-result-object v2

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Opening video: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mUri:Landroid/net/Uri;
    invoke-static {v5}, Lco/vine/android/player/SdkVideoView;->access$400(Lco/vine/android/player/SdkVideoView;)Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 318
    new-instance v0, Landroid/content/Intent;

    const-string v2, "com.android.music.musicservicecommand"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 319
    .local v0, "i":Landroid/content/Intent;
    const-string v2, "command"

    const-string v4, "pause"

    invoke-virtual {v0, v2, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 320
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mContext:Landroid/content/Context;
    invoke-static {v2}, Lco/vine/android/player/SdkVideoView;->access$800(Lco/vine/android/player/SdkVideoView;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 322
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    const/4 v4, 0x0

    # invokes: Lco/vine/android/player/SdkVideoView;->release(Z)V
    invoke-static {v2, v4}, Lco/vine/android/player/SdkVideoView;->access$900(Lco/vine/android/player/SdkVideoView;Z)V

    .line 324
    # getter for: Lco/vine/android/player/SdkVideoView;->USE_EXO:Z
    invoke-static {}, Lco/vine/android/player/SdkVideoView;->access$1000()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 325
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    # invokes: Lco/vine/android/player/SdkVideoView;->openExoPlayer()V
    invoke-static {v2}, Lco/vine/android/player/SdkVideoView;->access$1100(Lco/vine/android/player/SdkVideoView;)V

    .line 326
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mSurfaceHolder:Landroid/view/Surface;
    invoke-static {v2}, Lco/vine/android/player/SdkVideoView;->access$600(Lco/vine/android/player/SdkVideoView;)Landroid/view/Surface;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Surface;->isValid()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 327
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mExoPlayer:Lcom/google/android/exoplayer/ExoPlayer;
    invoke-static {v2}, Lco/vine/android/player/SdkVideoView;->access$1300(Lco/vine/android/player/SdkVideoView;)Lcom/google/android/exoplayer/ExoPlayer;

    move-result-object v2

    iget-object v4, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mExoVideoRenderer:Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;
    invoke-static {v4}, Lco/vine/android/player/SdkVideoView;->access$1200(Lco/vine/android/player/SdkVideoView;)Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;

    move-result-object v4

    sget-object v5, Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;->MSG_SET_SURFACE:Ljava/lang/Object;

    iget-object v6, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    # getter for: Lco/vine/android/player/SdkVideoView;->mSurfaceHolder:Landroid/view/Surface;
    invoke-static {v6}, Lco/vine/android/player/SdkVideoView;->access$600(Lco/vine/android/player/SdkVideoView;)Landroid/view/Surface;

    move-result-object v6

    invoke-virtual {v2, v4, v5, v6}, Lcom/google/android/exoplayer/ExoPlayer;->sendMessage(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 333
    :cond_4
    :goto_1
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    const/4 v4, 0x0

    # setter for: Lco/vine/android/player/SdkVideoView;->mOpenThread:Ljava/lang/Thread;
    invoke-static {v2, v4}, Lco/vine/android/player/SdkVideoView;->access$1502(Lco/vine/android/player/SdkVideoView;Ljava/lang/Thread;)Ljava/lang/Thread;

    .line 334
    monitor-exit v3

    goto/16 :goto_0

    .line 331
    :cond_5
    iget-object v2, p0, Lco/vine/android/player/SdkVideoView$2;->this$0:Lco/vine/android/player/SdkVideoView;

    # invokes: Lco/vine/android/player/SdkVideoView;->openMediaPlayer()V
    invoke-static {v2}, Lco/vine/android/player/SdkVideoView;->access$1400(Lco/vine/android/player/SdkVideoView;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1
.end method
