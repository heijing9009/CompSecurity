.class public abstract Lcom/google/android/gms/internal/je;
.super Landroid/os/Binder;

# interfaces
.implements Lcom/google/android/gms/internal/jd;


# direct methods
.method public static a(Landroid/os/IBinder;)Lcom/google/android/gms/internal/jd;
    .locals 2

    if-nez p0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, "com.google.android.gms.location.places.internal.IPlacesCallbacks"

    invoke-interface {p0, v0}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/google/android/gms/internal/jd;

    if-eqz v1, :cond_1

    check-cast v0, Lcom/google/android/gms/internal/jd;

    goto :goto_0

    :cond_1
    new-instance v0, Lcom/google/android/gms/internal/jf;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/jf;-><init>(Landroid/os/IBinder;)V

    goto :goto_0
.end method


# virtual methods
.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .locals 3

    const/4 v1, 0x1

    sparse-switch p1, :sswitch_data_0

    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v0

    :goto_0
    return v0

    :sswitch_0
    const-string v0, "com.google.android.gms.location.places.internal.IPlacesCallbacks"

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    move v0, v1

    goto :goto_0

    :sswitch_1
    const-string v0, "com.google.android.gms.location.places.internal.IPlacesCallbacks"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/google/android/gms/internal/hb;->CREATOR:Lcom/google/android/gms/internal/ji;

    invoke-static {p2}, Lcom/google/android/gms/internal/ji;->a(Landroid/os/Parcel;)Lcom/google/android/gms/internal/hb;

    move-result-object v0

    :goto_1
    invoke-virtual {p0, v2, v0}, Lcom/google/android/gms/internal/je;->a(ILcom/google/android/gms/internal/hb;)V

    move v0, v1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_1
        0x5f4e5446 -> :sswitch_0
    .end sparse-switch
.end method
