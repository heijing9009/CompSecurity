.class Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;
.super Ljava/lang/Object;
.source "Variant.java"


# instance fields
.field private final cacheKey:Ljava/lang/String;

.field private final entry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

.field private final variantKey:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;)V
    .locals 0
    .param p1, "variantKey"    # Ljava/lang/String;
    .param p2, "cacheKey"    # Ljava/lang/String;
    .param p3, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;->variantKey:Ljava/lang/String;

    .line 40
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;->cacheKey:Ljava/lang/String;

    .line 41
    iput-object p3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;->entry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    .line 42
    return-void
.end method


# virtual methods
.method public getCacheKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;->cacheKey:Ljava/lang/String;

    return-object v0
.end method

.method public getEntry()Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/Variant;->entry:Lcom/comcast/cim/httpcomponentsandroid/client/cache/HttpCacheEntry;

    return-object v0
.end method
