.class final Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory$18;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 230
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 232
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 233
    return-void
.end method
