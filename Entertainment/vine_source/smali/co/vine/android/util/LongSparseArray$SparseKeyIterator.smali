.class public Lco/vine/android/util/LongSparseArray$SparseKeyIterator;
.super Ljava/lang/Object;
.source "LongSparseArray.java"

# interfaces
.implements Ljava/util/Iterator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/LongSparseArray;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "SparseKeyIterator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Iterator",
        "<",
        "Ljava/lang/Long;",
        ">;"
    }
.end annotation


# instance fields
.field public index:I

.field final synthetic this$0:Lco/vine/android/util/LongSparseArray;


# direct methods
.method public constructor <init>(Lco/vine/android/util/LongSparseArray;)V
    .locals 0

    .prologue
    .line 73
    .local p0, "this":Lco/vine/android/util/LongSparseArray$SparseKeyIterator;, "Lco/vine/android/util/LongSparseArray<TT;>.SparseKeyIterator;"
    iput-object p1, p0, Lco/vine/android/util/LongSparseArray$SparseKeyIterator;->this$0:Lco/vine/android/util/LongSparseArray;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public hasNext()Z
    .locals 2

    .prologue
    .line 79
    .local p0, "this":Lco/vine/android/util/LongSparseArray$SparseKeyIterator;, "Lco/vine/android/util/LongSparseArray<TT;>.SparseKeyIterator;"
    iget v0, p0, Lco/vine/android/util/LongSparseArray$SparseKeyIterator;->index:I

    iget-object v1, p0, Lco/vine/android/util/LongSparseArray$SparseKeyIterator;->this$0:Lco/vine/android/util/LongSparseArray;

    invoke-virtual {v1}, Lco/vine/android/util/LongSparseArray;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public next()Ljava/lang/Long;
    .locals 2

    .prologue
    .line 84
    .local p0, "this":Lco/vine/android/util/LongSparseArray$SparseKeyIterator;, "Lco/vine/android/util/LongSparseArray<TT;>.SparseKeyIterator;"
    iget v0, p0, Lco/vine/android/util/LongSparseArray$SparseKeyIterator;->index:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lco/vine/android/util/LongSparseArray$SparseKeyIterator;->index:I

    .line 85
    iget-object v0, p0, Lco/vine/android/util/LongSparseArray$SparseKeyIterator;->this$0:Lco/vine/android/util/LongSparseArray;

    iget v1, p0, Lco/vine/android/util/LongSparseArray$SparseKeyIterator;->index:I

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1}, Lco/vine/android/util/LongSparseArray;->keyAt(I)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic next()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 73
    .local p0, "this":Lco/vine/android/util/LongSparseArray$SparseKeyIterator;, "Lco/vine/android/util/LongSparseArray<TT;>.SparseKeyIterator;"
    invoke-virtual {p0}, Lco/vine/android/util/LongSparseArray$SparseKeyIterator;->next()Ljava/lang/Long;

    move-result-object v0

    return-object v0
.end method

.method public remove()V
    .locals 1

    .prologue
    .line 90
    .local p0, "this":Lco/vine/android/util/LongSparseArray$SparseKeyIterator;, "Lco/vine/android/util/LongSparseArray<TT;>.SparseKeyIterator;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method
