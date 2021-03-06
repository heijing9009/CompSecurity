.class public Lcom/aio/downloader/unstall/Unstall;
.super Landroid/app/Activity;
.source "Unstall.java"

# interfaces
.implements Lcom/facebook/ads/AdListener;


# instance fields
.field adView:Lcom/google/ads/AdView;

.field private adapter:Lcom/aio/downloader/unstall/MyAdapter;

.field adviewscanner:Landroid/widget/LinearLayout;

.field private header_left_uninstall:Lcom/aio/downloader/views/LImageButton;

.field private infos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/unstall/Info;",
            ">;"
        }
    .end annotation
.end field

.field private isfa:Z

.field private isshow:Z

.field private lv_uninstall:Landroid/widget/ListView;

.field private nativeAd:Lcom/facebook/ads/NativeAd;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 34
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 35
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/unstall/Unstall;->infos:Ljava/util/List;

    .line 42
    iput-boolean v1, p0, Lcom/aio/downloader/unstall/Unstall;->isfa:Z

    .line 43
    iput-boolean v1, p0, Lcom/aio/downloader/unstall/Unstall;->isshow:Z

    .line 34
    return-void
.end method

.method private facebookad()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 161
    invoke-virtual {p0}, Lcom/aio/downloader/unstall/Unstall;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 162
    const v4, 0x7f03003e

    .line 161
    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 164
    .local v2, "viewtop":Landroid/view/View;
    iget-object v3, p0, Lcom/aio/downloader/unstall/Unstall;->lv_uninstall:Landroid/widget/ListView;

    const/4 v4, 0x0

    invoke-virtual {v3, v2, v5, v4}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 166
    const v3, 0x7f0701a6

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 165
    check-cast v1, Landroid/widget/ImageView;

    .line 168
    .local v1, "iv_fb_fragment":Landroid/widget/ImageView;
    iget-object v3, p0, Lcom/aio/downloader/unstall/Unstall;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3}, Lcom/facebook/ads/NativeAd;->getAdCoverImage()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 169
    .local v0, "adCover":Lcom/facebook/ads/NativeAd$Image;
    invoke-static {v0, v1}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 171
    iget-object v3, p0, Lcom/aio/downloader/unstall/Unstall;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 173
    return-void
.end method


# virtual methods
.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 136
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 141
    iget-object v0, p0, Lcom/aio/downloader/unstall/Unstall;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/unstall/Unstall;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 155
    :cond_0
    :goto_0
    return-void

    .line 146
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/unstall/Unstall;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 150
    :try_start_0
    invoke-direct {p0}, Lcom/aio/downloader/unstall/Unstall;->facebookad()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 154
    :goto_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/unstall/Unstall;->isfa:Z

    goto :goto_0

    .line 151
    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 48
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 49
    const v0, 0x7f0300b6

    invoke-virtual {p0, v0}, Lcom/aio/downloader/unstall/Unstall;->setContentView(I)V

    .line 52
    const v0, 0x7f0703dd

    invoke-virtual {p0, v0}, Lcom/aio/downloader/unstall/Unstall;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/unstall/Unstall;->adviewscanner:Landroid/widget/LinearLayout;

    .line 53
    new-instance v0, Lcom/google/ads/AdView;

    sget-object v1, Lcom/google/ads/AdSize;->SMART_BANNER:Lcom/google/ads/AdSize;

    .line 54
    const-string v2, "ca-app-pub-2192624499353475/5842010949"

    invoke-direct {v0, p0, v1, v2}, Lcom/google/ads/AdView;-><init>(Landroid/app/Activity;Lcom/google/ads/AdSize;Ljava/lang/String;)V

    .line 53
    iput-object v0, p0, Lcom/aio/downloader/unstall/Unstall;->adView:Lcom/google/ads/AdView;

    .line 55
    iget-object v0, p0, Lcom/aio/downloader/unstall/Unstall;->adviewscanner:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/aio/downloader/unstall/Unstall;->adView:Lcom/google/ads/AdView;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 56
    iget-object v0, p0, Lcom/aio/downloader/unstall/Unstall;->adView:Lcom/google/ads/AdView;

    new-instance v1, Lcom/google/ads/AdRequest;

    invoke-direct {v1}, Lcom/google/ads/AdRequest;-><init>()V

    invoke-virtual {v0, v1}, Lcom/google/ads/AdView;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 58
    new-instance v0, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/unstall/Unstall;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "340186902832477_388101491374351"

    invoke-direct {v0, v1, v2}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/unstall/Unstall;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 59
    iget-object v0, p0, Lcom/aio/downloader/unstall/Unstall;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 60
    iget-object v0, p0, Lcom/aio/downloader/unstall/Unstall;->nativeAd:Lcom/facebook/ads/NativeAd;

    sget-object v1, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 62
    const v0, 0x7f0703da

    invoke-virtual {p0, v0}, Lcom/aio/downloader/unstall/Unstall;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/aio/downloader/unstall/Unstall;->lv_uninstall:Landroid/widget/ListView;

    .line 63
    const v0, 0x7f0703d9

    invoke-virtual {p0, v0}, Lcom/aio/downloader/unstall/Unstall;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/unstall/Unstall;->header_left_uninstall:Lcom/aio/downloader/views/LImageButton;

    .line 64
    iget-object v0, p0, Lcom/aio/downloader/unstall/Unstall;->header_left_uninstall:Lcom/aio/downloader/views/LImageButton;

    new-instance v1, Lcom/aio/downloader/unstall/Unstall$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/unstall/Unstall$1;-><init>(Lcom/aio/downloader/unstall/Unstall;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 86
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 179
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 128
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 129
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 130
    return-void
.end method

.method protected onResume()V
    .locals 7

    .prologue
    .line 91
    iget-object v4, p0, Lcom/aio/downloader/unstall/Unstall;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->clear()V

    .line 92
    invoke-virtual {p0}, Lcom/aio/downloader/unstall/Unstall;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 94
    .local v3, "pm":Landroid/content/pm/PackageManager;
    const/16 v4, 0x2000

    invoke-virtual {v3, v4}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v0

    .line 95
    .local v0, "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v4

    if-lt v1, v4, :cond_0

    .line 111
    const-string v4, "qqq"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "infos.size()="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, p0, Lcom/aio/downloader/unstall/Unstall;->infos:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 112
    const/4 v1, 0x0

    :goto_1
    iget-object v4, p0, Lcom/aio/downloader/unstall/Unstall;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-lt v1, v4, :cond_3

    .line 115
    new-instance v4, Lcom/aio/downloader/unstall/MyAdapter;

    iget-object v5, p0, Lcom/aio/downloader/unstall/Unstall;->infos:Ljava/util/List;

    invoke-direct {v4, p0, v5}, Lcom/aio/downloader/unstall/MyAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    iput-object v4, p0, Lcom/aio/downloader/unstall/Unstall;->adapter:Lcom/aio/downloader/unstall/MyAdapter;

    .line 120
    iget-object v4, p0, Lcom/aio/downloader/unstall/Unstall;->lv_uninstall:Landroid/widget/ListView;

    iget-object v5, p0, Lcom/aio/downloader/unstall/Unstall;->adapter:Lcom/aio/downloader/unstall/MyAdapter;

    invoke-virtual {v4, v5}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 121
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 122
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 123
    return-void

    .line 96
    :cond_0
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    iget v4, v4, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v4, v4, 0x1

    if-nez v4, :cond_2

    .line 97
    new-instance v2, Lcom/aio/downloader/unstall/Info;

    invoke-direct {v2}, Lcom/aio/downloader/unstall/Info;-><init>()V

    .line 98
    .local v2, "info":Lcom/aio/downloader/unstall/Info;
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v3, v4}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v4

    invoke-interface {v4}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/aio/downloader/unstall/Info;->setName(Ljava/lang/String;)V

    .line 99
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v4, v3}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/aio/downloader/unstall/Info;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 100
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    iget-object v4, v4, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v2, v4}, Lcom/aio/downloader/unstall/Info;->setPackagename(Ljava/lang/String;)V

    .line 101
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    iget-object v4, v4, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const-string v5, "com.aio.downloader"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 102
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    iget-object v4, v4, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    .line 103
    const-string v5, "com.evzapp.cleanmaster"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 104
    iget-object v4, p0, Lcom/aio/downloader/unstall/Unstall;->infos:Ljava/util/List;

    invoke-interface {v4, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 107
    :cond_1
    sget-object v5, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    iget-object v4, v4, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v6, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "============"

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 95
    .end local v2    # "info":Lcom/aio/downloader/unstall/Info;
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_0

    .line 113
    :cond_3
    sget-object v5, Ljava/lang/System;->out:Ljava/io/PrintStream;

    iget-object v4, p0, Lcom/aio/downloader/unstall/Unstall;->infos:Ljava/util/List;

    invoke-interface {v4, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 112
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_1
.end method
