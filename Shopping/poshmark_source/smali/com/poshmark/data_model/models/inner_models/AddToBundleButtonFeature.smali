.class public Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;
.super Ljava/lang/Object;
.source "AddToBundleButtonFeature.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature$Feature;
    }
.end annotation


# instance fields
.field android:Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature$Feature;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    return-void
.end method


# virtual methods
.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;->android:Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature$Feature;

    if-nez v0, :cond_0

    .line 18
    const/4 v0, 0x0

    .line 20
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;->android:Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature$Feature;->title:Ljava/lang/String;

    goto :goto_0
.end method

.method public isEnabled()Z
    .locals 1

    .prologue
    .line 9
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;->android:Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature$Feature;

    if-nez v0, :cond_0

    .line 10
    const/4 v0, 0x0

    .line 12
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;->android:Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature$Feature;

    iget-boolean v0, v0, Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature$Feature;->enabled:Z

    goto :goto_0
.end method
