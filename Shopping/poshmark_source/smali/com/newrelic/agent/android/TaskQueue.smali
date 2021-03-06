.class public Lcom/newrelic/agent/android/TaskQueue;
.super Lcom/newrelic/agent/android/harvest/HarvestAdapter;
.source "TaskQueue.java"


# static fields
.field private static final DEQUEUE_PERIOD_MS:J = 0x3e8L

.field private static dequeueFuture:Ljava/util/concurrent/Future;

.field private static final dequeueTask:Ljava/lang/Runnable;

.field private static final queue:Ljava/util/concurrent/ConcurrentLinkedQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentLinkedQueue",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private static final queueExecutor:Ljava/util/concurrent/ScheduledExecutorService;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 27
    new-instance v0, Lcom/newrelic/agent/android/util/NamedThreadFactory;

    const-string v1, "TaskQueue"

    invoke-direct {v0, v1}, Lcom/newrelic/agent/android/util/NamedThreadFactory;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newSingleThreadScheduledExecutor(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    sput-object v0, Lcom/newrelic/agent/android/TaskQueue;->queueExecutor:Ljava/util/concurrent/ScheduledExecutorService;

    .line 28
    new-instance v0, Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentLinkedQueue;-><init>()V

    sput-object v0, Lcom/newrelic/agent/android/TaskQueue;->queue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    .line 29
    new-instance v0, Lcom/newrelic/agent/android/TaskQueue$1;

    invoke-direct {v0}, Lcom/newrelic/agent/android/TaskQueue$1;-><init>()V

    sput-object v0, Lcom/newrelic/agent/android/TaskQueue;->dequeueTask:Ljava/lang/Runnable;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/HarvestAdapter;-><init>()V

    return-void
.end method

.method static synthetic access$000()V
    .locals 0

    .prologue
    .line 23
    invoke-static {}, Lcom/newrelic/agent/android/TaskQueue;->dequeue()V

    return-void
.end method

.method public static backgroundDequeue()V
    .locals 2

    .prologue
    .line 50
    sget-object v0, Lcom/newrelic/agent/android/TaskQueue;->queueExecutor:Ljava/util/concurrent/ScheduledExecutorService;

    sget-object v1, Lcom/newrelic/agent/android/TaskQueue;->dequeueTask:Ljava/lang/Runnable;

    invoke-interface {v0, v1}, Ljava/util/concurrent/ScheduledExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 51
    return-void
.end method

.method public static clear()V
    .locals 1

    .prologue
    .line 159
    sget-object v0, Lcom/newrelic/agent/android/TaskQueue;->queue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v0}, Ljava/util/concurrent/ConcurrentLinkedQueue;->clear()V

    .line 160
    return-void
.end method

.method private static dequeue()V
    .locals 3

    .prologue
    .line 94
    sget-object v2, Lcom/newrelic/agent/android/TaskQueue;->queue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v2}, Ljava/util/concurrent/ConcurrentLinkedQueue;->size()I

    move-result v2

    if-nez v2, :cond_0

    .line 144
    .local v0, "e":Ljava/lang/Exception;
    :goto_0
    return-void

    .line 102
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    const/4 v2, 0x0

    invoke-static {v2}, Lcom/newrelic/agent/android/Measurements;->setBroadcastNewMeasurements(Z)V

    .line 103
    .restart local v0    # "e":Ljava/lang/Exception;
    :cond_1
    :goto_1
    sget-object v2, Lcom/newrelic/agent/android/TaskQueue;->queue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v2}, Ljava/util/concurrent/ConcurrentLinkedQueue;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_6

    .line 105
    :try_start_0
    sget-object v2, Lcom/newrelic/agent/android/TaskQueue;->queue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v2}, Ljava/util/concurrent/ConcurrentLinkedQueue;->remove()Ljava/lang/Object;

    move-result-object v1

    .line 108
    .local v1, "object":Ljava/lang/Object;
    instance-of v2, v1, Lcom/newrelic/agent/android/tracing/ActivityTrace;

    .end local v0    # "e":Ljava/lang/Exception;
    if-eqz v2, :cond_2

    .line 109
    check-cast v1, Lcom/newrelic/agent/android/tracing/ActivityTrace;

    .end local v1    # "object":Ljava/lang/Object;
    invoke-static {v1}, Lcom/newrelic/agent/android/harvest/Harvest;->addActivityTrace(Lcom/newrelic/agent/android/tracing/ActivityTrace;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 135
    .restart local v0    # "e":Ljava/lang/Exception;
    :catch_0
    move-exception v0

    .line 136
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 137
    invoke-static {v0}, Lcom/newrelic/agent/android/harvest/AgentHealth;->noticeException(Ljava/lang/Exception;)V

    goto :goto_1

    .line 114
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "object":Ljava/lang/Object;
    :cond_2
    :try_start_1
    instance-of v2, v1, Lcom/newrelic/agent/android/metric/Metric;

    if-eqz v2, :cond_3

    .line 115
    check-cast v1, Lcom/newrelic/agent/android/metric/Metric;

    .end local v1    # "object":Ljava/lang/Object;
    invoke-static {v1}, Lcom/newrelic/agent/android/harvest/Harvest;->addMetric(Lcom/newrelic/agent/android/metric/Metric;)V

    goto :goto_1

    .line 120
    .restart local v1    # "object":Ljava/lang/Object;
    :cond_3
    instance-of v2, v1, Lcom/newrelic/agent/android/harvest/AgentHealthException;

    if-eqz v2, :cond_4

    .line 121
    check-cast v1, Lcom/newrelic/agent/android/harvest/AgentHealthException;

    .end local v1    # "object":Ljava/lang/Object;
    invoke-static {v1}, Lcom/newrelic/agent/android/harvest/Harvest;->addAgentHealthException(Lcom/newrelic/agent/android/harvest/AgentHealthException;)V

    goto :goto_1

    .line 126
    .restart local v1    # "object":Ljava/lang/Object;
    :cond_4
    instance-of v2, v1, Lcom/newrelic/agent/android/tracing/Trace;

    if-eqz v2, :cond_5

    .line 127
    check-cast v1, Lcom/newrelic/agent/android/tracing/Trace;

    .end local v1    # "object":Ljava/lang/Object;
    invoke-static {v1}, Lcom/newrelic/agent/android/Measurements;->addTracedMethod(Lcom/newrelic/agent/android/tracing/Trace;)V

    goto :goto_1

    .line 132
    .restart local v1    # "object":Ljava/lang/Object;
    :cond_5
    instance-of v2, v1, Lcom/newrelic/agent/android/measurement/http/HttpTransactionMeasurement;

    if-eqz v2, :cond_1

    .line 133
    check-cast v1, Lcom/newrelic/agent/android/measurement/http/HttpTransactionMeasurement;

    .end local v1    # "object":Ljava/lang/Object;
    invoke-static {v1}, Lcom/newrelic/agent/android/Measurements;->addHttpTransaction(Lcom/newrelic/agent/android/measurement/http/HttpTransactionMeasurement;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 142
    .restart local v0    # "e":Ljava/lang/Exception;
    :cond_6
    invoke-static {}, Lcom/newrelic/agent/android/Measurements;->broadcast()V

    .line 143
    const/4 v2, 0x1

    invoke-static {v2}, Lcom/newrelic/agent/android/Measurements;->setBroadcastNewMeasurements(Z)V

    goto :goto_0
.end method

.method public static queue(Ljava/lang/Object;)V
    .locals 1
    .param p0, "object"    # Ljava/lang/Object;

    .prologue
    .line 43
    sget-object v0, Lcom/newrelic/agent/android/TaskQueue;->queue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v0, p0}, Ljava/util/concurrent/ConcurrentLinkedQueue;->add(Ljava/lang/Object;)Z

    .line 44
    return-void
.end method

.method public static size()I
    .locals 1

    .prologue
    .line 152
    sget-object v0, Lcom/newrelic/agent/android/TaskQueue;->queue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v0}, Ljava/util/concurrent/ConcurrentLinkedQueue;->size()I

    move-result v0

    return v0
.end method

.method public static start()V
    .locals 7

    .prologue
    .line 71
    sget-object v0, Lcom/newrelic/agent/android/TaskQueue;->dequeueFuture:Ljava/util/concurrent/Future;

    if-eqz v0, :cond_0

    .line 75
    :goto_0
    return-void

    .line 74
    :cond_0
    sget-object v0, Lcom/newrelic/agent/android/TaskQueue;->queueExecutor:Ljava/util/concurrent/ScheduledExecutorService;

    sget-object v1, Lcom/newrelic/agent/android/TaskQueue;->dequeueTask:Ljava/lang/Runnable;

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x3e8

    sget-object v6, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    move-result-object v0

    sput-object v0, Lcom/newrelic/agent/android/TaskQueue;->dequeueFuture:Ljava/util/concurrent/Future;

    goto :goto_0
.end method

.method public static stop()V
    .locals 2

    .prologue
    .line 81
    sget-object v0, Lcom/newrelic/agent/android/TaskQueue;->dequeueFuture:Ljava/util/concurrent/Future;

    if-nez v0, :cond_0

    .line 86
    :goto_0
    return-void

    .line 84
    :cond_0
    sget-object v0, Lcom/newrelic/agent/android/TaskQueue;->dequeueFuture:Ljava/util/concurrent/Future;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Ljava/util/concurrent/Future;->cancel(Z)Z

    .line 85
    const/4 v0, 0x0

    sput-object v0, Lcom/newrelic/agent/android/TaskQueue;->dequeueFuture:Ljava/util/concurrent/Future;

    goto :goto_0
.end method

.method public static synchronousDequeue()V
    .locals 4

    .prologue
    .line 57
    sget-object v2, Lcom/newrelic/agent/android/TaskQueue;->queueExecutor:Ljava/util/concurrent/ScheduledExecutorService;

    sget-object v3, Lcom/newrelic/agent/android/TaskQueue;->dequeueTask:Ljava/lang/Runnable;

    invoke-interface {v2, v3}, Ljava/util/concurrent/ScheduledExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    move-result-object v1

    .line 59
    .local v1, "future":Ljava/util/concurrent/Future;
    :try_start_0
    invoke-interface {v1}, Ljava/util/concurrent/Future;->get()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_1

    .line 65
    :goto_0
    return-void

    .line 60
    :catch_0
    move-exception v0

    .line 61
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0

    .line 62
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :catch_1
    move-exception v0

    .line 63
    .local v0, "e":Ljava/util/concurrent/ExecutionException;
    invoke-virtual {v0}, Ljava/util/concurrent/ExecutionException;->printStackTrace()V

    goto :goto_0
.end method
