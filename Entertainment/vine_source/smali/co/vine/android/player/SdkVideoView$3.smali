.class Lco/vine/android/player/SdkVideoView$3;
.super Ljava/lang/Object;
.source "SdkVideoView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/player/SdkVideoView;->setKeepScreenOn(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/player/SdkVideoView;

.field final synthetic val$keepScreenOn:Z


# direct methods
.method constructor <init>(Lco/vine/android/player/SdkVideoView;Z)V
    .locals 0

    .prologue
    .line 455
    iput-object p1, p0, Lco/vine/android/player/SdkVideoView$3;->this$0:Lco/vine/android/player/SdkVideoView;

    iput-boolean p2, p0, Lco/vine/android/player/SdkVideoView$3;->val$keepScreenOn:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 458
    iget-object v0, p0, Lco/vine/android/player/SdkVideoView$3;->this$0:Lco/vine/android/player/SdkVideoView;

    iget-boolean v1, p0, Lco/vine/android/player/SdkVideoView$3;->val$keepScreenOn:Z

    # invokes: Landroid/view/View;->setKeepScreenOn(Z)V
    invoke-static {v0, v1}, Lco/vine/android/player/SdkVideoView;->access$1601(Lco/vine/android/player/SdkVideoView;Z)V

    .line 459
    return-void
.end method
