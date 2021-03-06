.class public Lcom/comcast/cim/cmasl/apachehttp/cache/FileResource;
.super Ljava/lang/Object;
.source "FileResource.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/ThreadSafe;
.end annotation


# instance fields
.field private volatile disposed:Z

.field private final file:Ljava/io/File;


# direct methods
.method public constructor <init>(Ljava/io/File;)V
    .locals 1
    .param p1, "file"    # Ljava/io/File;

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    iput-object p1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/FileResource;->file:Ljava/io/File;

    .line 54
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/FileResource;->disposed:Z

    .line 55
    return-void
.end method


# virtual methods
.method public declared-synchronized dispose()V
    .locals 1

    .prologue
    .line 70
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/FileResource;->disposed:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 75
    :goto_0
    monitor-exit p0

    return-void

    .line 73
    :cond_0
    const/4 v0, 0x1

    :try_start_1
    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/FileResource;->disposed:Z

    .line 74
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/FileResource;->file:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->delete()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 70
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized getFile()Ljava/io/File;
    .locals 1

    .prologue
    .line 58
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/FileResource;->file:Ljava/io/File;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getInputStream()Ljava/io/InputStream;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 62
    monitor-enter p0

    :try_start_0
    new-instance v0, Ljava/io/FileInputStream;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/FileResource;->file:Ljava/io/File;

    invoke-direct {v0, v1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized length()J
    .locals 2

    .prologue
    .line 66
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/FileResource;->file:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->length()J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v0

    monitor-exit p0

    return-wide v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
