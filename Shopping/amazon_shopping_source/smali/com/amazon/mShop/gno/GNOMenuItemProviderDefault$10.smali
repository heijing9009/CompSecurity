.class Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$10;
.super Ljava/lang/Object;
.source "GNOMenuItemProviderDefault.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->getAppstoreItem(Landroid/content/Context;)Lcom/amazon/mShop/gno/GNODrawerItem;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;)V
    .locals 0

    .prologue
    .line 504
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$10;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()Ljava/lang/Boolean;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 507
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 504
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$10;->call()Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method
