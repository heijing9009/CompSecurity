.class public interface abstract Lcom/localytics/android/AnalyticsListener;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/localytics/android/BaseHandler$BaseListener;


# virtual methods
.method public abstract localyticsDidTagEvent(Ljava/lang/String;Ljava/util/Map;J)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;J)V"
        }
    .end annotation
.end method

.method public abstract localyticsSessionDidOpen(ZZZ)V
.end method

.method public abstract localyticsSessionWillClose()V
.end method

.method public abstract localyticsSessionWillOpen(ZZZ)V
.end method
