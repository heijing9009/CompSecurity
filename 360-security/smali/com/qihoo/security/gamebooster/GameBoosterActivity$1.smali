.class Lcom/qihoo/security/gamebooster/GameBoosterActivity$1;
.super Landroid/content/BroadcastReceiver;
.source "360Security"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/qihoo/security/gamebooster/GameBoosterActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/qihoo/security/gamebooster/GameBoosterActivity;


# direct methods
.method constructor <init>(Lcom/qihoo/security/gamebooster/GameBoosterActivity;)V
    .locals 0

    .prologue
    .line 137
    iput-object p1, p0, Lcom/qihoo/security/gamebooster/GameBoosterActivity$1;->a:Lcom/qihoo/security/gamebooster/GameBoosterActivity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2

    .prologue
    .line 140
    invoke-static {}, Lcom/qihoo/security/gamebooster/b;->a()Lcom/qihoo/security/gamebooster/b;

    move-result-object v0

    iget-object v1, p0, Lcom/qihoo/security/gamebooster/GameBoosterActivity$1;->a:Lcom/qihoo/security/gamebooster/GameBoosterActivity;

    invoke-virtual {v0, v1}, Lcom/qihoo/security/gamebooster/b;->a(Lcom/qihoo/security/gamebooster/h;)V

    .line 141
    return-void
.end method
