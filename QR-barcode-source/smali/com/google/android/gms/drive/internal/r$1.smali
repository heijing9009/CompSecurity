.class Lcom/google/android/gms/drive/internal/r$1;
.super Lcom/google/android/gms/drive/internal/o$d;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gms/drive/internal/r;->reopenForWrite(Lcom/google/android/gms/common/api/GoogleApiClient;)Lcom/google/android/gms/common/api/PendingResult;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic OL:Lcom/google/android/gms/drive/internal/r;


# direct methods
.method constructor <init>(Lcom/google/android/gms/drive/internal/r;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/drive/internal/r$1;->OL:Lcom/google/android/gms/drive/internal/r;

    invoke-direct {p0}, Lcom/google/android/gms/drive/internal/o$d;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic a(Lcom/google/android/gms/common/api/Api$a;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    check-cast p1, Lcom/google/android/gms/drive/internal/q;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/drive/internal/r$1;->a(Lcom/google/android/gms/drive/internal/q;)V

    return-void
.end method

.method protected a(Lcom/google/android/gms/drive/internal/q;)V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    invoke-virtual {p1}, Lcom/google/android/gms/drive/internal/q;->hY()Lcom/google/android/gms/drive/internal/ab;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/drive/internal/OpenContentsRequest;

    iget-object v2, p0, Lcom/google/android/gms/drive/internal/r$1;->OL:Lcom/google/android/gms/drive/internal/r;

    invoke-virtual {v2}, Lcom/google/android/gms/drive/internal/r;->getDriveId()Lcom/google/android/gms/drive/DriveId;

    move-result-object v2

    const/high16 v3, 0x20000000

    iget-object v4, p0, Lcom/google/android/gms/drive/internal/r$1;->OL:Lcom/google/android/gms/drive/internal/r;

    invoke-static {v4}, Lcom/google/android/gms/drive/internal/r;->a(Lcom/google/android/gms/drive/internal/r;)Lcom/google/android/gms/drive/Contents;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gms/drive/Contents;->getRequestId()I

    move-result v4

    invoke-direct {v1, v2, v3, v4}, Lcom/google/android/gms/drive/internal/OpenContentsRequest;-><init>(Lcom/google/android/gms/drive/DriveId;II)V

    new-instance v2, Lcom/google/android/gms/drive/internal/av;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v3}, Lcom/google/android/gms/drive/internal/av;-><init>(Lcom/google/android/gms/common/api/BaseImplementation$b;Lcom/google/android/gms/drive/DriveFile$DownloadProgressListener;)V

    invoke-interface {v0, v1, v2}, Lcom/google/android/gms/drive/internal/ab;->a(Lcom/google/android/gms/drive/internal/OpenContentsRequest;Lcom/google/android/gms/drive/internal/ac;)V

    return-void
.end method
