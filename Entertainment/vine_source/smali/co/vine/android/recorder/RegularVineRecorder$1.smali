.class Lco/vine/android/recorder/RegularVineRecorder$1;
.super Ljava/lang/Object;
.source "RegularVineRecorder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/RegularVineRecorder;->showCameraFailedToast()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/RegularVineRecorder;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/RegularVineRecorder;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lco/vine/android/recorder/RegularVineRecorder$1;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$1;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder;->mToast:Landroid/widget/Toast;

    if-eqz v0, :cond_0

    .line 80
    iget-object v0, p0, Lco/vine/android/recorder/RegularVineRecorder$1;->this$0:Lco/vine/android/recorder/RegularVineRecorder;

    iget-object v0, v0, Lco/vine/android/recorder/RegularVineRecorder;->mToast:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 82
    :cond_0
    return-void
.end method
