.class Lcom/localytics/android/AnalyticsHandler$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/localytics/android/AnalyticsHandler;


# direct methods
.method constructor <init>(Lcom/localytics/android/AnalyticsHandler;)V
    .locals 0

    .prologue
    .line 164
    iput-object p1, p0, Lcom/localytics/android/AnalyticsHandler$1;->this$0:Lcom/localytics/android/AnalyticsHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler$1;->this$0:Lcom/localytics/android/AnalyticsHandler;

    # invokes: Lcom/localytics/android/AnalyticsHandler;->_isPushDisabled()Z
    invoke-static {v0}, Lcom/localytics/android/AnalyticsHandler;->access$000(Lcom/localytics/android/AnalyticsHandler;)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 164
    invoke-virtual {p0}, Lcom/localytics/android/AnalyticsHandler$1;->call()Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method
