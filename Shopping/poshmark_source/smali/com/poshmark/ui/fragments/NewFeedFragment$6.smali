.class Lcom/poshmark/ui/fragments/NewFeedFragment$6;
.super Ljava/lang/Object;
.source "NewFeedFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/NewFeedFragment;->getFeed(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/NewFeedFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/NewFeedFragment;)V
    .locals 0

    .prologue
    .line 286
    iput-object p1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment$6;->this$0:Lcom/poshmark/ui/fragments/NewFeedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 289
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment$6;->this$0:Lcom/poshmark/ui/fragments/NewFeedFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/NewFeedFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 290
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment$6;->this$0:Lcom/poshmark/ui/fragments/NewFeedFragment;

    const/4 v1, 0x0

    # invokes: Lcom/poshmark/ui/fragments/NewFeedFragment;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    invoke-static {v0, p1, v1}, Lcom/poshmark/ui/fragments/NewFeedFragment;->access$200(Lcom/poshmark/ui/fragments/NewFeedFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V

    .line 292
    :cond_0
    return-void
.end method
