.class Lco/vine/android/widget/TypingEditText$TypingHandler;
.super Landroid/os/Handler;
.source "TypingEditText.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/widget/TypingEditText;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TypingHandler"
.end annotation


# static fields
.field public static final TYPING:I = 0x1


# instance fields
.field final synthetic this$0:Lco/vine/android/widget/TypingEditText;


# direct methods
.method public constructor <init>(Lco/vine/android/widget/TypingEditText;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lco/vine/android/widget/TypingEditText$TypingHandler;->this$0:Lco/vine/android/widget/TypingEditText;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    .line 88
    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 92
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 103
    :cond_0
    :goto_0
    return-void

    .line 94
    :pswitch_0
    iget-object v0, p0, Lco/vine/android/widget/TypingEditText$TypingHandler;->this$0:Lco/vine/android/widget/TypingEditText;

    # getter for: Lco/vine/android/widget/TypingEditText;->mListener:Lco/vine/android/widget/TypingEditText$TypingListener;
    invoke-static {v0}, Lco/vine/android/widget/TypingEditText;->access$300(Lco/vine/android/widget/TypingEditText;)Lco/vine/android/widget/TypingEditText$TypingListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 95
    iget-object v0, p0, Lco/vine/android/widget/TypingEditText$TypingHandler;->this$0:Lco/vine/android/widget/TypingEditText;

    # getter for: Lco/vine/android/widget/TypingEditText;->mListener:Lco/vine/android/widget/TypingEditText$TypingListener;
    invoke-static {v0}, Lco/vine/android/widget/TypingEditText;->access$300(Lco/vine/android/widget/TypingEditText;)Lco/vine/android/widget/TypingEditText$TypingListener;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/widget/TypingEditText$TypingHandler;->this$0:Lco/vine/android/widget/TypingEditText;

    invoke-interface {v0, v1}, Lco/vine/android/widget/TypingEditText$TypingListener;->onTypingTimeout(Landroid/view/View;)V

    goto :goto_0

    .line 92
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
