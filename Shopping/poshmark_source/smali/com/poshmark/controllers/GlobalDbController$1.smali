.class Lcom/poshmark/controllers/GlobalDbController$1;
.super Ljava/lang/Object;
.source "GlobalDbController.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/controllers/GlobalDbController;->reloadCatalog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Lcom/poshmark/data_model/models/Catalog;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/controllers/GlobalDbController;


# direct methods
.method constructor <init>(Lcom/poshmark/controllers/GlobalDbController;)V
    .locals 0

    .prologue
    .line 147
    iput-object p1, p0, Lcom/poshmark/controllers/GlobalDbController$1;->this$0:Lcom/poshmark/controllers/GlobalDbController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/Catalog;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 150
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/Catalog;>;"
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_0

    .line 151
    new-instance v0, Lcom/poshmark/db/CategoriesUpdater;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v1, Lcom/poshmark/data_model/models/Catalog;

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lcom/poshmark/db/CategoriesUpdater;-><init>(Lcom/poshmark/data_model/models/Catalog;Z)V

    .line 152
    .local v0, "updater":Lcom/poshmark/db/CategoriesUpdater;
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    instance-of v2, v0, Landroid/os/AsyncTask;

    if-nez v2, :cond_1

    invoke-virtual {v0, v1}, Lcom/poshmark/db/CategoriesUpdater;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 154
    .end local v0    # "updater":Lcom/poshmark/db/CategoriesUpdater;
    :cond_0
    :goto_0
    return-void

    .line 152
    .restart local v0    # "updater":Lcom/poshmark/db/CategoriesUpdater;
    :cond_1
    check-cast v0, Landroid/os/AsyncTask;

    .end local v0    # "updater":Lcom/poshmark/db/CategoriesUpdater;
    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method
