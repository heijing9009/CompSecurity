.class Lco/vine/android/ActivityAdapter$1;
.super Ljava/lang/Object;
.source "ActivityAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ActivityAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ActivityAdapter;


# direct methods
.method constructor <init>(Lco/vine/android/ActivityAdapter;)V
    .locals 0

    .prologue
    .line 113
    iput-object p1, p0, Lco/vine/android/ActivityAdapter$1;->this$0:Lco/vine/android/ActivityAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 116
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    .line 117
    .local v0, "postId":J
    iget-object v2, p0, Lco/vine/android/ActivityAdapter$1;->this$0:Lco/vine/android/ActivityAdapter;

    # getter for: Lco/vine/android/ActivityAdapter;->mContext:Landroid/content/Context;
    invoke-static {v2}, Lco/vine/android/ActivityAdapter;->access$000(Lco/vine/android/ActivityAdapter;)Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, v0, v1}, Lco/vine/android/SingleActivity;->start(Landroid/content/Context;J)V

    .line 118
    return-void
.end method
