.class Lcom/poshmark/utils/FeedItemLinearLayout$1;
.super Ljava/lang/Object;
.source "FeedItemLinearLayout.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/FeedItemLinearLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/FeedItemLinearLayout;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/FeedItemLinearLayout;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Lcom/poshmark/utils/FeedItemLinearLayout$1;->this$0:Lcom/poshmark/utils/FeedItemLinearLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 73
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/ListingSocial;

    .line 74
    .local v1, "feedItem":Lcom/poshmark/data_model/models/ListingSocial;
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 75
    .local v2, "parentActivity":Lcom/poshmark/ui/PMActivity;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 76
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "ID"

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    const-class v3, Lcom/poshmark/ui/fragments/CommentFragment;

    invoke-virtual {v2, v0, v3, v1}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 78
    return-void
.end method
