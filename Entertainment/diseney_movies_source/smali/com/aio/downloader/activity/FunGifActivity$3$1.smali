.class Lcom/aio/downloader/activity/FunGifActivity$3$1;
.super Ljava/lang/Thread;
.source "FunGifActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FunGifActivity$3;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/FunGifActivity$3;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FunGifActivity$3;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FunGifActivity$3$1;->this$1:Lcom/aio/downloader/activity/FunGifActivity$3;

    .line 206
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 211
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 212
    const-string v0, "www"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "url=+"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/FunGifActivity$3$1;->this$1:Lcom/aio/downloader/activity/FunGifActivity$3;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity$3;->url_like:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/FunGifActivity$3;->access$0(Lcom/aio/downloader/activity/FunGifActivity$3;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 213
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity$3$1;->this$1:Lcom/aio/downloader/activity/FunGifActivity$3;

    # getter for: Lcom/aio/downloader/activity/FunGifActivity$3;->url_like:Ljava/lang/String;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunGifActivity$3;->access$0(Lcom/aio/downloader/activity/FunGifActivity$3;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 214
    return-void
.end method
