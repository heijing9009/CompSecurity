.class public Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;
.super Landroid/database/ContentObserver;
.source "BaseCursorAdapterFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/BaseCursorAdapterFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "ChangeObserver"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/BaseCursorAdapterFragment;


# direct methods
.method public constructor <init>(Lco/vine/android/BaseCursorAdapterFragment;Landroid/os/Handler;)V
    .locals 0
    .param p2, "handler"    # Landroid/os/Handler;

    .prologue
    .line 52
    iput-object p1, p0, Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;->this$0:Lco/vine/android/BaseCursorAdapterFragment;

    .line 53
    invoke-direct {p0, p2}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    .line 54
    return-void
.end method


# virtual methods
.method public deliverSelfNotifications()Z
    .locals 1

    .prologue
    .line 58
    const/4 v0, 0x1

    return v0
.end method

.method public onChange(Z)V
    .locals 1
    .param p1, "selfChange"    # Z

    .prologue
    .line 63
    iget-object v0, p0, Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;->this$0:Lco/vine/android/BaseCursorAdapterFragment;

    iget-boolean v0, v0, Lco/vine/android/BaseCursorAdapterFragment;->mRefreshing:Z

    if-nez v0, :cond_0

    .line 64
    iget-object v0, p0, Lco/vine/android/BaseCursorAdapterFragment$ChangeObserver;->this$0:Lco/vine/android/BaseCursorAdapterFragment;

    invoke-virtual {v0}, Lco/vine/android/BaseCursorAdapterFragment;->handleContentChanged()V

    .line 66
    :cond_0
    return-void
.end method
