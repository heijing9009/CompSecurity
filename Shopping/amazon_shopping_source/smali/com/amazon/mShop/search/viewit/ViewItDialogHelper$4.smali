.class Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$4;
.super Ljava/lang/Object;
.source "ViewItDialogHelper.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->showPublicDataMatrixInfoDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)V
    .locals 0

    .prologue
    .line 339
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 342
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->dismissPublicDataMatrixInfoDialog()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->access$500(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)V

    .line 343
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->clearErrorWindow()V

    .line 344
    return-void
.end method
