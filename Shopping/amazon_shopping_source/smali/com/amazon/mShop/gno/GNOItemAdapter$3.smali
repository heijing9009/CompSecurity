.class Lcom/amazon/mShop/gno/GNOItemAdapter$3;
.super Ljava/lang/Object;
.source "GNOItemAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOItemAdapter;->updateVisibleItems()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOItemAdapter;)V
    .locals 0

    .prologue
    .line 156
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$3;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$3;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    # invokes: Lcom/amazon/mShop/gno/GNOItemAdapter;->collectVisibleItems()V
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->access$200(Lcom/amazon/mShop/gno/GNOItemAdapter;)V

    .line 160
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$3;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->notifyDataSetChanged()V

    .line 161
    return-void
.end method
