.class Lco/vine/android/recorder/VineRecorder$30;
.super Ljava/lang/Object;
.source "VineRecorder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/VineRecorder;->adjustBoundaries(Lco/vine/android/recorder/CameraSetting;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/VineRecorder;

.field final synthetic val$bottomMaskParams:Landroid/widget/RelativeLayout$LayoutParams;

.field final synthetic val$cameraViewParams:Landroid/widget/RelativeLayout$LayoutParams;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/VineRecorder;Landroid/widget/RelativeLayout$LayoutParams;Landroid/widget/RelativeLayout$LayoutParams;)V
    .locals 0

    .prologue
    .line 1873
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder$30;->this$0:Lco/vine/android/recorder/VineRecorder;

    iput-object p2, p0, Lco/vine/android/recorder/VineRecorder$30;->val$cameraViewParams:Landroid/widget/RelativeLayout$LayoutParams;

    iput-object p3, p0, Lco/vine/android/recorder/VineRecorder$30;->val$bottomMaskParams:Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 1876
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder$30;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v0, v1, Lco/vine/android/recorder/VineRecorder;->mCameraView:Landroid/view/View;

    .line 1877
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 1878
    const-string v1, "Setting preview sizes to {} {}."

    iget-object v2, p0, Lco/vine/android/recorder/VineRecorder$30;->val$cameraViewParams:Landroid/widget/RelativeLayout$LayoutParams;

    iget v2, v2, Landroid/widget/RelativeLayout$LayoutParams;->width:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/recorder/VineRecorder$30;->val$cameraViewParams:Landroid/widget/RelativeLayout$LayoutParams;

    iget v3, v3, Landroid/widget/RelativeLayout$LayoutParams;->height:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v1, v2, v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1879
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder$30;->val$cameraViewParams:Landroid/widget/RelativeLayout$LayoutParams;

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1881
    :cond_0
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder$30;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v0, v1, Lco/vine/android/recorder/VineRecorder;->mBottomMaskView:Landroid/view/View;

    .line 1882
    if-eqz v0, :cond_1

    .line 1883
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder$30;->val$bottomMaskParams:Landroid/widget/RelativeLayout$LayoutParams;

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1885
    :cond_1
    return-void
.end method
