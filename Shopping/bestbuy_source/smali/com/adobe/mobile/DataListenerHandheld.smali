.class public final Lcom/adobe/mobile/DataListenerHandheld;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static handleRequest(Latz;Lqm;Landroid/content/Context;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 39
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    if-nez p0, :cond_1

    .line 40
    :cond_0
    const-string v0, "Wearable - GoogleApiClient or Context or DataMap is null"

    new-array v1, v4, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 62
    :goto_0
    return-void

    .line 44
    :cond_1
    invoke-static {p0}, Lcom/adobe/mobile/WearableDataRequest;->createRequestFromDataMap(Latz;)Lcom/adobe/mobile/WearableDataRequest;

    move-result-object v0

    .line 45
    if-nez v0, :cond_2

    .line 46
    const-string v0, "Wearable - Invalid data request (%s)"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    invoke-virtual {p0}, Latz;->toString()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 49
    :cond_2
    const-wide/16 v2, 0x3a98

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {p1, v2, v3, v1}, Lqm;->a(JLjava/util/concurrent/TimeUnit;)Lpp;

    move-result-object v1

    .line 51
    invoke-virtual {v1}, Lpp;->b()Z

    move-result v1

    if-nez v1, :cond_3

    .line 52
    const-string v0, "Wearable - Failed to setup connection"

    new-array v1, v4, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 56
    :cond_3
    invoke-virtual {v0, p2}, Lcom/adobe/mobile/WearableDataRequest;->handle(Landroid/content/Context;)Latz;

    move-result-object v0

    .line 58
    const-string v1, "/abdmobile/data/response"

    invoke-static {v1}, Laui;->a(Ljava/lang/String;)Laui;

    move-result-object v1

    .line 59
    invoke-virtual {v1}, Laui;->a()Latz;

    move-result-object v2

    invoke-virtual {v2, v0}, Latz;->a(Latz;)V

    .line 61
    sget-object v0, Lauj;->a:Latr;

    invoke-virtual {v1}, Laui;->b()Lcom/google/android/gms/wearable/PutDataRequest;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Latr;->a(Lqm;Lcom/google/android/gms/wearable/PutDataRequest;)Lqq;

    goto :goto_0
.end method

.method public static onDataChanged(Latw;Lqm;Landroid/content/Context;)V
    .locals 4

    .prologue
    .line 65
    if-nez p0, :cond_1

    .line 86
    :cond_0
    return-void

    .line 68
    :cond_1
    invoke-virtual {p0}, Latw;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Latv;

    .line 69
    invoke-interface {v0}, Latv;->c()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_2

    .line 70
    invoke-interface {v0}, Latv;->b()Latx;

    move-result-object v0

    .line 71
    if-eqz v0, :cond_2

    .line 74
    invoke-interface {v0}, Latx;->b()Landroid/net/Uri;

    move-result-object v2

    .line 75
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 79
    invoke-virtual {v2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v2

    const-string v3, "/abdmobile/data/request"

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 80
    invoke-static {v0}, Laua;->a(Latx;)Laua;

    move-result-object v0

    invoke-virtual {v0}, Laua;->a()Latz;

    move-result-object v0

    .line 81
    invoke-static {v0, p1, p2}, Lcom/adobe/mobile/DataListenerHandheld;->handleRequest(Latz;Lqm;Landroid/content/Context;)V

    goto :goto_0
.end method
