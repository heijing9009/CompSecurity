.class public abstract Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext$Stub;
.super Landroid/os/Binder;
.source "PlaybackSdkEventContext.java"

# interfaces
.implements Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext$Stub$Proxy;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 18
    const-string/jumbo v0, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext"

    invoke-virtual {p0, p0, v0}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 19
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;
    .locals 2
    .param p0, "obj"    # Landroid/os/IBinder;

    .prologue
    .line 26
    if-nez p0, :cond_0

    .line 27
    const/4 v0, 0x0

    .line 33
    :goto_0
    return-object v0

    .line 29
    :cond_0
    const-string/jumbo v1, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 30
    .local v0, "iin":Landroid/os/IInterface;
    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;

    if-eqz v1, :cond_1

    .line 31
    check-cast v0, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext;

    goto :goto_0

    .line 33
    :cond_1
    new-instance v0, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext$Stub$Proxy;

    .end local v0    # "iin":Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_0
.end method


# virtual methods
.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .locals 4
    .param p1, "code"    # I
    .param p2, "data"    # Landroid/os/Parcel;
    .param p3, "reply"    # Landroid/os/Parcel;
    .param p4, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    .line 41
    sparse-switch p1, :sswitch_data_0

    .line 73
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v2

    :goto_0
    return v2

    .line 45
    :sswitch_0
    const-string/jumbo v3, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext"

    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 50
    :sswitch_1
    const-string/jumbo v3, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 51
    invoke-virtual {p0}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext$Stub;->getAsin()Ljava/lang/String;

    move-result-object v0

    .line 52
    .local v0, "_result":Ljava/lang/String;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 53
    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 58
    .end local v0    # "_result":Ljava/lang/String;
    :sswitch_2
    const-string/jumbo v3, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 59
    invoke-virtual {p0}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext$Stub;->getCurrentPosition()J

    move-result-wide v0

    .line 60
    .local v0, "_result":J
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 61
    invoke-virtual {p3, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    goto :goto_0

    .line 66
    .end local v0    # "_result":J
    :sswitch_3
    const-string/jumbo v3, "com.amazon.avod.sdk.internal.aidl.PlaybackSdkEventContext"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 67
    invoke-virtual {p0}, Lcom/amazon/avod/sdk/internal/aidl/PlaybackSdkEventContext$Stub;->getDuration()J

    move-result-wide v0

    .line 68
    .restart local v0    # "_result":J
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 69
    invoke-virtual {p3, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    goto :goto_0

    .line 41
    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_1
        0x2 -> :sswitch_2
        0x3 -> :sswitch_3
        0x5f4e5446 -> :sswitch_0
    .end sparse-switch
.end method
