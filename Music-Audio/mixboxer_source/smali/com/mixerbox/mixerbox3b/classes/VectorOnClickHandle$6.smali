.class final Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$6;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$b:Ljava/lang/String;

.field final synthetic val$id:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 471
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$6;->val$id:Ljava/lang/String;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$6;->val$b:Ljava/lang/String;

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 486
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 487
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$6;->ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$6;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080049

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 488
    return-void
.end method

.method public final onSuccess(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 474
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 475
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$6;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDJs:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$6;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDJs:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 476
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$6;->ctx:Landroid/content/Context;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getDJs(Landroid/content/Context;)V

    .line 478
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$6;->ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$6;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800e9

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 479
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 480
    const-string v1, "dj_id"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$6;->val$id:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 481
    const-string v1, "follow"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$6;->val$b:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 482
    const-string v1, "action:follow"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 483
    return-void
.end method
