.class public Lcom/a9/vs/mobile/library/impl/jni/MobileUtils;
.super Ljava/lang/Object;
.source "MobileUtils.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 55
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_MobileUtils()J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/MobileUtils;-><init>(JZ)V

    .line 56
    return-void
.end method

.method protected constructor <init>(JZ)V
    .locals 0
    .param p1, "cPtr"    # J
    .param p3, "cMemoryOwn"    # Z

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/MobileUtils;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/MobileUtils;->swigCPtr:J

    .line 18
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/MobileUtils;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/MobileUtils;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MobileUtils;->swigCPtr:J

    goto :goto_0
.end method

.method public static getDataDumpLocation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->MobileUtils_getDataDumpLocation()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static setDataDumpLocation(Ljava/lang/String;)V
    .locals 0
    .param p0, "a_path"    # Ljava/lang/String;

    .prologue
    .line 43
    invoke-static {p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->MobileUtils_setDataDumpLocation(Ljava/lang/String;)V

    .line 44
    return-void
.end method

.method public static setupLogging(Ljava/lang/String;Z)Z
    .locals 1
    .param p0, "a_logFile"    # Ljava/lang/String;
    .param p1, "a_printToScreen"    # Z

    .prologue
    .line 39
    invoke-static {p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->MobileUtils_setupLogging(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public static testNEON(Lcom/a9/vs/mobile/library/impl/jni/NEONAccelerationResult;)V
    .locals 2
    .param p0, "a_result"    # Lcom/a9/vs/mobile/library/impl/jni/NEONAccelerationResult;

    .prologue
    .line 51
    invoke-static {p0}, Lcom/a9/vs/mobile/library/impl/jni/NEONAccelerationResult;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/NEONAccelerationResult;)J

    move-result-wide v0

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->MobileUtils_testNEON(JLcom/a9/vs/mobile/library/impl/jni/NEONAccelerationResult;)V

    .line 52
    return-void
.end method


# virtual methods
.method public declared-synchronized delete()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 29
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MobileUtils;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MobileUtils;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MobileUtils;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MobileUtils;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_MobileUtils(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/MobileUtils;->swigCPtr:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 36
    :cond_1
    monitor-exit p0

    return-void

    .line 29
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected finalize()V
    .locals 0

    .prologue
    .line 25
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/MobileUtils;->delete()V

    .line 26
    return-void
.end method
