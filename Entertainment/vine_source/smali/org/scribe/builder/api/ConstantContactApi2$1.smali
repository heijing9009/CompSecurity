.class Lorg/scribe/builder/api/ConstantContactApi2$1;
.super Ljava/lang/Object;
.source "ConstantContactApi2.java"

# interfaces
.implements Lorg/scribe/extractors/AccessTokenExtractor;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/scribe/builder/api/ConstantContactApi2;->getAccessTokenExtractor()Lorg/scribe/extractors/AccessTokenExtractor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/scribe/builder/api/ConstantContactApi2;


# direct methods
.method constructor <init>(Lorg/scribe/builder/api/ConstantContactApi2;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lorg/scribe/builder/api/ConstantContactApi2$1;->this$0:Lorg/scribe/builder/api/ConstantContactApi2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public extract(Ljava/lang/String;)Lorg/scribe/model/Token;
    .locals 6
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 39
    const-string v3, "Response body is incorrect. Can\'t extract a token from an empty string"

    invoke-static {p1, v3}, Lorg/scribe/utils/Preconditions;->checkEmptyString(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    const-string v1, "\"access_token\"\\s*:\\s*\"([^&\"]+)\""

    .line 42
    .local v1, "regex":Ljava/lang/String;
    invoke-static {v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 43
    .local v0, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 45
    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lorg/scribe/utils/OAuthEncoder;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 46
    .local v2, "token":Ljava/lang/String;
    new-instance v3, Lorg/scribe/model/Token;

    const-string v4, ""

    invoke-direct {v3, v2, v4, p1}, Lorg/scribe/model/Token;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v3

    .line 50
    .end local v2    # "token":Ljava/lang/String;
    :cond_0
    new-instance v3, Lorg/scribe/exceptions/OAuthException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Response body is incorrect. Can\'t extract a token from this: \'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-direct {v3, v4, v5}, Lorg/scribe/exceptions/OAuthException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v3
.end method
