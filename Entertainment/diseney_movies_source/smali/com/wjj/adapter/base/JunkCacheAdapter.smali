.class public Lcom/wjj/adapter/base/JunkCacheAdapter;
.super Lcom/wjj/adapter/base/MyBaseAdapter;
.source "JunkCacheAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/wjj/adapter/base/MyBaseAdapter",
        "<",
        "Lcom/wjj/eneity/RubSoftware;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Lcom/wjj/adapter/base/MyBaseAdapter;-><init>(Landroid/content/Context;)V

    .line 19
    return-void
.end method


# virtual methods
.method public MygetView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 24
    if-nez p2, :cond_0

    .line 25
    iget-object v2, p0, Lcom/wjj/adapter/base/JunkCacheAdapter;->inflater:Landroid/view/LayoutInflater;

    const v3, 0x7f030061

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 26
    new-instance v1, Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;

    invoke-direct {v1, p0, p2}, Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;-><init>(Lcom/wjj/adapter/base/JunkCacheAdapter;Landroid/view/View;)V

    .line 27
    .local v1, "viewholder":Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 31
    :goto_0
    iget-object v2, p0, Lcom/wjj/adapter/base/JunkCacheAdapter;->list:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wjj/eneity/RubSoftware;

    .line 32
    .local v0, "sw":Lcom/wjj/eneity/RubSoftware;
    iget-object v2, v1, Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 34
    iget-object v2, v1, Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;->tv_appname:Landroid/widget/TextView;

    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v4, v0, Lcom/wjj/eneity/RubSoftware;->softname:Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "\'s Cache"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 35
    iget-object v2, v1, Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;->iv_icon:Landroid/widget/ImageView;

    iget-object v3, v0, Lcom/wjj/eneity/RubSoftware;->icon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 36
    iget-object v2, v1, Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;->tv_appsize:Landroid/widget/TextView;

    new-instance v3, Ljava/lang/StringBuilder;

    iget-wide v4, v0, Lcom/wjj/eneity/RubSoftware;->allcache:J

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 37
    iget-object v2, v1, Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    iget-boolean v3, v0, Lcom/wjj/eneity/RubSoftware;->ischecked:Z

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 40
    return-object p2

    .line 29
    .end local v0    # "sw":Lcom/wjj/eneity/RubSoftware;
    .end local v1    # "viewholder":Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;

    .restart local v1    # "viewholder":Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;
    goto :goto_0
.end method
