.class Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;
.super Lcom/facebook/share/internal/LikeActionController$AbstractRequestWrapper;
.source "SourceFile"


# instance fields
.field likeCountStringWithLike:Ljava/lang/String;

.field likeCountStringWithoutLike:Ljava/lang/String;

.field socialSentenceStringWithLike:Ljava/lang/String;

.field socialSentenceStringWithoutLike:Ljava/lang/String;

.field final synthetic this$0:Lcom/facebook/share/internal/LikeActionController;


# direct methods
.method constructor <init>(Lcom/facebook/share/internal/LikeActionController;Ljava/lang/String;Lcom/facebook/share/widget/LikeView$ObjectType;)V
    .locals 4

    .prologue
    .line 1507
    iput-object p1, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->this$0:Lcom/facebook/share/internal/LikeActionController;

    .line 1508
    invoke-direct {p0, p1, p2, p3}, Lcom/facebook/share/internal/LikeActionController$AbstractRequestWrapper;-><init>(Lcom/facebook/share/internal/LikeActionController;Ljava/lang/String;Lcom/facebook/share/widget/LikeView$ObjectType;)V

    .line 1501
    iget-object v0, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->this$0:Lcom/facebook/share/internal/LikeActionController;

    # getter for: Lcom/facebook/share/internal/LikeActionController;->likeCountStringWithLike:Ljava/lang/String;
    invoke-static {v0}, Lcom/facebook/share/internal/LikeActionController;->access$700(Lcom/facebook/share/internal/LikeActionController;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->likeCountStringWithLike:Ljava/lang/String;

    .line 1502
    iget-object v0, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->this$0:Lcom/facebook/share/internal/LikeActionController;

    # getter for: Lcom/facebook/share/internal/LikeActionController;->likeCountStringWithoutLike:Ljava/lang/String;
    invoke-static {v0}, Lcom/facebook/share/internal/LikeActionController;->access$800(Lcom/facebook/share/internal/LikeActionController;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->likeCountStringWithoutLike:Ljava/lang/String;

    .line 1503
    iget-object v0, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->this$0:Lcom/facebook/share/internal/LikeActionController;

    # getter for: Lcom/facebook/share/internal/LikeActionController;->socialSentenceWithLike:Ljava/lang/String;
    invoke-static {v0}, Lcom/facebook/share/internal/LikeActionController;->access$900(Lcom/facebook/share/internal/LikeActionController;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->socialSentenceStringWithLike:Ljava/lang/String;

    .line 1504
    iget-object v0, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->this$0:Lcom/facebook/share/internal/LikeActionController;

    # getter for: Lcom/facebook/share/internal/LikeActionController;->socialSentenceWithoutLike:Ljava/lang/String;
    invoke-static {v0}, Lcom/facebook/share/internal/LikeActionController;->access$1000(Lcom/facebook/share/internal/LikeActionController;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->socialSentenceStringWithoutLike:Ljava/lang/String;

    .line 1510
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 1511
    const-string v1, "fields"

    const-string v2, "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1519
    new-instance v1, Lcom/facebook/GraphRequest;

    invoke-static {}, Lcom/facebook/AccessToken;->getCurrentAccessToken()Lcom/facebook/AccessToken;

    move-result-object v2

    sget-object v3, Lcom/facebook/HttpMethod;->GET:Lcom/facebook/HttpMethod;

    invoke-direct {v1, v2, p2, v0, v3}, Lcom/facebook/GraphRequest;-><init>(Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/HttpMethod;)V

    invoke-virtual {p0, v1}, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->setRequest(Lcom/facebook/GraphRequest;)V

    .line 1524
    return-void
.end method


# virtual methods
.method protected processError(Lcom/facebook/FacebookRequestError;)V
    .locals 6

    .prologue
    .line 1557
    sget-object v0, Lcom/facebook/LoggingBehavior;->REQUESTS:Lcom/facebook/LoggingBehavior;

    # getter for: Lcom/facebook/share/internal/LikeActionController;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/facebook/share/internal/LikeActionController;->access$100()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Error fetching engagement for object \'%s\' with type \'%s\' : %s"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->objectId:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    iget-object v5, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->objectType:Lcom/facebook/share/widget/LikeView$ObjectType;

    aput-object v5, v3, v4

    const/4 v4, 0x2

    aput-object p1, v3, v4

    invoke-static {v0, v1, v2, v3}, Lcom/facebook/internal/Logger;->log(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1563
    iget-object v0, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->this$0:Lcom/facebook/share/internal/LikeActionController;

    const-string v1, "get_engagement"

    # invokes: Lcom/facebook/share/internal/LikeActionController;->logAppEventForError(Ljava/lang/String;Lcom/facebook/FacebookRequestError;)V
    invoke-static {v0, v1, p1}, Lcom/facebook/share/internal/LikeActionController;->access$2400(Lcom/facebook/share/internal/LikeActionController;Ljava/lang/String;Lcom/facebook/FacebookRequestError;)V

    .line 1564
    return-void
.end method

.method protected processSuccess(Lcom/facebook/GraphResponse;)V
    .locals 3

    .prologue
    .line 1528
    invoke-virtual {p1}, Lcom/facebook/GraphResponse;->getJSONObject()Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "engagement"

    invoke-static {v0, v1}, Lcom/facebook/internal/Utility;->tryGetJSONObjectFromResponse(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 1531
    if-eqz v0, :cond_0

    .line 1533
    const-string v1, "count_string_with_like"

    iget-object v2, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->likeCountStringWithLike:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->likeCountStringWithLike:Ljava/lang/String;

    .line 1538
    const-string v1, "count_string_without_like"

    iget-object v2, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->likeCountStringWithoutLike:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->likeCountStringWithoutLike:Ljava/lang/String;

    .line 1543
    const-string v1, "social_sentence_with_like"

    iget-object v2, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->socialSentenceStringWithLike:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->socialSentenceStringWithLike:Ljava/lang/String;

    .line 1548
    const-string v1, "social_sentence_without_like"

    iget-object v2, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->socialSentenceStringWithoutLike:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/share/internal/LikeActionController$GetEngagementRequestWrapper;->socialSentenceStringWithoutLike:Ljava/lang/String;

    .line 1553
    :cond_0
    return-void
.end method
