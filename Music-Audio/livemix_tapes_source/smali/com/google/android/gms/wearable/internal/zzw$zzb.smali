.class public Lcom/google/android/gms/wearable/internal/zzw$zzb;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/wearable/DataApi$DataItemResult;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/wearable/internal/zzw;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "zzb"
.end annotation


# instance fields
.field private final zzQA:Lcom/google/android/gms/common/api/Status;

.field private final zzbam:Lcom/google/android/gms/wearable/DataItem;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/common/api/Status;Lcom/google/android/gms/wearable/DataItem;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/wearable/internal/zzw$zzb;->zzQA:Lcom/google/android/gms/common/api/Status;

    iput-object p2, p0, Lcom/google/android/gms/wearable/internal/zzw$zzb;->zzbam:Lcom/google/android/gms/wearable/DataItem;

    return-void
.end method


# virtual methods
.method public getDataItem()Lcom/google/android/gms/wearable/DataItem;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/zzw$zzb;->zzbam:Lcom/google/android/gms/wearable/DataItem;

    return-object v0
.end method

.method public getStatus()Lcom/google/android/gms/common/api/Status;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/zzw$zzb;->zzQA:Lcom/google/android/gms/common/api/Status;

    return-object v0
.end method
