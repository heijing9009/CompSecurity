.class final Lcom/roidapp/cloudlib/google/a;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic a:Lcom/roidapp/cloudlib/google/GoogleAuthActivity;


# direct methods
.method constructor <init>(Lcom/roidapp/cloudlib/google/GoogleAuthActivity;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/roidapp/cloudlib/google/a;->a:Lcom/roidapp/cloudlib/google/GoogleAuthActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    .prologue
    .line 55
    iget-object v0, p0, Lcom/roidapp/cloudlib/google/a;->a:Lcom/roidapp/cloudlib/google/GoogleAuthActivity;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.settings.WIFI_SETTINGS"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/roidapp/cloudlib/google/GoogleAuthActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 56
    return-void
.end method
