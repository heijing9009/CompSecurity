.class final enum Lcom/a/b/aa;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/a/b/aa;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/a/b/aa;

.field public static final enum b:Lcom/a/b/aa;

.field public static final enum c:Lcom/a/b/aa;

.field private static final synthetic g:[Lcom/a/b/aa;


# instance fields
.field final d:I

.field final e:I

.field final f:I


# direct methods
.method static constructor <clinit>()V
    .locals 14

    .prologue
    const/4 v3, 0x3

    const/4 v2, 0x0

    const/4 v11, -0x1

    const/4 v13, 0x2

    const/4 v6, 0x1

    .line 102
    new-instance v0, Lcom/a/b/aa;

    const-string v1, "MICRO"

    const/16 v4, 0x60

    const/16 v5, 0x60

    invoke-direct/range {v0 .. v5}, Lcom/a/b/aa;-><init>(Ljava/lang/String;IIII)V

    sput-object v0, Lcom/a/b/aa;->a:Lcom/a/b/aa;

    .line 103
    new-instance v4, Lcom/a/b/aa;

    const-string v5, "MINI"

    const/16 v8, 0x200

    const/16 v9, 0x180

    move v7, v6

    invoke-direct/range {v4 .. v9}, Lcom/a/b/aa;-><init>(Ljava/lang/String;IIII)V

    sput-object v4, Lcom/a/b/aa;->b:Lcom/a/b/aa;

    .line 104
    new-instance v7, Lcom/a/b/aa;

    const-string v8, "FULL"

    move v9, v13

    move v10, v13

    move v12, v11

    invoke-direct/range {v7 .. v12}, Lcom/a/b/aa;-><init>(Ljava/lang/String;IIII)V

    sput-object v7, Lcom/a/b/aa;->c:Lcom/a/b/aa;

    .line 101
    new-array v0, v3, [Lcom/a/b/aa;

    sget-object v1, Lcom/a/b/aa;->a:Lcom/a/b/aa;

    aput-object v1, v0, v2

    sget-object v1, Lcom/a/b/aa;->b:Lcom/a/b/aa;

    aput-object v1, v0, v6

    sget-object v1, Lcom/a/b/aa;->c:Lcom/a/b/aa;

    aput-object v1, v0, v13

    sput-object v0, Lcom/a/b/aa;->g:[Lcom/a/b/aa;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IIII)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(III)V"
        }
    .end annotation

    .prologue
    .line 110
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 111
    iput p3, p0, Lcom/a/b/aa;->d:I

    .line 112
    iput p4, p0, Lcom/a/b/aa;->e:I

    .line 113
    iput p5, p0, Lcom/a/b/aa;->f:I

    .line 114
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/a/b/aa;
    .locals 1

    .prologue
    .line 101
    const-class v0, Lcom/a/b/aa;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/a/b/aa;

    return-object v0
.end method

.method public static values()[Lcom/a/b/aa;
    .locals 1

    .prologue
    .line 101
    sget-object v0, Lcom/a/b/aa;->g:[Lcom/a/b/aa;

    invoke-virtual {v0}, [Lcom/a/b/aa;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a/b/aa;

    return-object v0
.end method
