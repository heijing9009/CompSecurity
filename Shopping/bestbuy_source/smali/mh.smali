.class final Lmh;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/hardware/Camera$AutoFocusCallback;


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Landroid/os/Handler;

.field private c:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lmh;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lmh;->a:Ljava/lang/String;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method a(Landroid/os/Handler;I)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lmh;->b:Landroid/os/Handler;

    .line 34
    iput p2, p0, Lmh;->c:I

    .line 35
    return-void
.end method

.method public onAutoFocus(ZLandroid/hardware/Camera;)V
    .locals 4

    .prologue
    .line 38
    iget-object v0, p0, Lmh;->b:Landroid/os/Handler;

    if-eqz v0, :cond_0

    .line 39
    iget-object v0, p0, Lmh;->b:Landroid/os/Handler;

    iget v1, p0, Lmh;->c:I

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 43
    iget-object v1, p0, Lmh;->b:Landroid/os/Handler;

    const-wide/16 v2, 0x5dc

    invoke-virtual {v1, v0, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 44
    const/4 v0, 0x0

    iput-object v0, p0, Lmh;->b:Landroid/os/Handler;

    .line 48
    :cond_0
    return-void
.end method
