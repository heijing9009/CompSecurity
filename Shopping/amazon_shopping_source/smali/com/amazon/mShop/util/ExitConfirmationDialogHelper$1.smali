.class final Lcom/amazon/mShop/util/ExitConfirmationDialogHelper$1;
.super Ljava/lang/Object;
.source "ExitConfirmationDialogHelper.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/ExitConfirmationDialogHelper;->create(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/mShop/AmazonAlertDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$refMarkerCancel:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/mShop/util/ExitConfirmationDialogHelper$1;->val$refMarkerCancel:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/mShop/util/ExitConfirmationDialogHelper$1;->val$refMarkerCancel:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 45
    return-void
.end method
