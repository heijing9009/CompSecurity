.class Lcom/amazon/identity/auth/device/DeviceDataLogic$4;
.super Ljava/lang/Object;
.source "DeviceDataLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/DeviceDataLogic$DeviceDataCreator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/DeviceDataLogic;-><init>(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/DeviceDataLogic;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/DeviceDataLogic;)V
    .locals 0

    .prologue
    .line 101
    iput-object p1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic$4;->this$0:Lcom/amazon/identity/auth/device/DeviceDataLogic;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public makeDeviceDataInfo(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Lcom/amazon/identity/auth/device/DeviceDataInfo;
    .locals 3
    .param p1, "key"    # Lcom/amazon/identity/auth/device/utils/KeyInfo;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
        }
    .end annotation

    .prologue
    .line 105
    new-instance v0, Lcom/amazon/identity/auth/device/DeviceDataInfo;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/DeviceDataLogic$4;->this$0:Lcom/amazon/identity/auth/device/DeviceDataLogic;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/DeviceDataLogic;->access$100(Lcom/amazon/identity/auth/device/DeviceDataLogic;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/DeviceDataInfo;-><init>(Ljava/lang/String;Z)V

    return-object v0
.end method
