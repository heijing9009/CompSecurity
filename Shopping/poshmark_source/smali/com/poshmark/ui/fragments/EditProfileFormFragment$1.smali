.class Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;
.super Ljava/lang/Object;
.source "EditProfileFormFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/EditProfileFormFragment;->loadUserProfile()V
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
        "Lcom/poshmark/user/UserInfoDetails;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)V
    .locals 0

    .prologue
    .line 170
    iput-object p1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/user/UserInfoDetails;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 173
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/user/UserInfoDetails;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 174
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->hideProgressDialog()V

    .line 175
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 176
    iget-object v1, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/user/UserInfoDetails;

    iput-object v0, v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->userProfile:Lcom/poshmark/user/UserInfoDetails;

    .line 177
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/EditProfileFormFragment;->updateView()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->access$000(Lcom/poshmark/ui/fragments/EditProfileFormFragment;)V

    .line 190
    :cond_0
    :goto_0
    return-void

    .line 180
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_USER_PROFILE:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    const v5, 0x7f0600eb

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    new-instance v2, Lcom/poshmark/ui/fragments/EditProfileFormFragment$1$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/EditProfileFormFragment$1$1;-><init>(Lcom/poshmark/ui/fragments/EditProfileFormFragment$1;)V

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/fragments/EditProfileFormFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;)V

    goto :goto_0
.end method
