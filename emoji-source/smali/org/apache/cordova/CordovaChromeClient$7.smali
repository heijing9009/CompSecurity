.class Lorg/apache/cordova/CordovaChromeClient$7;
.super Ljava/lang/Object;
.source "CordovaChromeClient.java"

# interfaces
.implements Landroid/content/DialogInterface$OnKeyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/apache/cordova/CordovaChromeClient;->onJsConfirm(Lorg/xwalk/core/XWalkView;Ljava/lang/String;Ljava/lang/String;Lorg/xwalk/core/XWalkJavascriptResult;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/apache/cordova/CordovaChromeClient;

.field final synthetic val$result:Lorg/xwalk/core/XWalkJavascriptResult;


# direct methods
.method constructor <init>(Lorg/apache/cordova/CordovaChromeClient;Lorg/xwalk/core/XWalkJavascriptResult;)V
    .locals 0
    .param p1, "this$0"    # Lorg/apache/cordova/CordovaChromeClient;

    .prologue
    .line 181
    iput-object p1, p0, Lorg/apache/cordova/CordovaChromeClient$7;->this$0:Lorg/apache/cordova/CordovaChromeClient;

    iput-object p2, p0, Lorg/apache/cordova/CordovaChromeClient$7;->val$result:Lorg/xwalk/core/XWalkJavascriptResult;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/content/DialogInterface;ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 184
    const/4 v0, 0x4

    if-ne p2, v0, :cond_0

    .line 186
    iget-object v0, p0, Lorg/apache/cordova/CordovaChromeClient$7;->val$result:Lorg/xwalk/core/XWalkJavascriptResult;

    invoke-interface {v0}, Lorg/xwalk/core/XWalkJavascriptResult;->cancel()V

    .line 187
    const/4 v0, 0x0

    .line 190
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method
