.class Lio/branch/referral/ServerRequestGetReferralCount;
.super Lio/branch/referral/ServerRequest;
.source "ServerRequestGetReferralCount.java"


# instance fields
.field callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lio/branch/referral/Branch$BranchReferralStateChangedListener;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "callback"    # Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    .prologue
    .line 27
    sget-object v0, Lio/branch/referral/Defines$RequestPath;->Referrals:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v0}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lio/branch/referral/ServerRequest;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 28
    iput-object p2, p0, Lio/branch/referral/ServerRequestGetReferralCount;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    .line 29
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V
    .locals 0
    .param p1, "requestPath"    # Ljava/lang/String;
    .param p2, "post"    # Lorg/json/JSONObject;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    .line 32
    invoke-direct {p0, p1, p2, p3}, Lio/branch/referral/ServerRequest;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .line 33
    return-void
.end method


# virtual methods
.method public clearCallbacks()V
    .locals 1

    .prologue
    .line 93
    const/4 v0, 0x0

    iput-object v0, p0, Lio/branch/referral/ServerRequestGetReferralCount;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    .line 94
    return-void
.end method

.method public getRequestUrl()Ljava/lang/String;
    .locals 2

    .prologue
    .line 37
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-super {p0}, Lio/branch/referral/ServerRequest;->getRequestUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lio/branch/referral/ServerRequestGetReferralCount;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v1}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public handleErrors(Landroid/content/Context;)Z
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 77
    invoke-super {p0, p1}, Lio/branch/referral/ServerRequest;->doesAppHasInternetPermission(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 78
    iget-object v1, p0, Lio/branch/referral/ServerRequestGetReferralCount;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    if-eqz v1, :cond_0

    .line 79
    iget-object v1, p0, Lio/branch/referral/ServerRequestGetReferralCount;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    new-instance v2, Lio/branch/referral/BranchError;

    const-string v3, "Trouble retrieving referral counts."

    const/16 v4, -0x66

    invoke-direct {v2, v3, v4}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v1, v0, v2}, Lio/branch/referral/Branch$BranchReferralStateChangedListener;->onStateChanged(ZLio/branch/referral/BranchError;)V

    .line 81
    :cond_0
    const/4 v0, 0x1

    .line 83
    :cond_1
    return v0
.end method

.method public handleFailure(ILjava/lang/String;)V
    .locals 5
    .param p1, "statusCode"    # I
    .param p2, "causeMsg"    # Ljava/lang/String;

    .prologue
    .line 70
    iget-object v0, p0, Lio/branch/referral/ServerRequestGetReferralCount;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    if-eqz v0, :cond_0

    .line 71
    iget-object v0, p0, Lio/branch/referral/ServerRequestGetReferralCount;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    const/4 v1, 0x0

    new-instance v2, Lio/branch/referral/BranchError;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Trouble retrieving referral counts. "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, p1}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v0, v1, v2}, Lio/branch/referral/Branch$BranchReferralStateChangedListener;->onStateChanged(ZLio/branch/referral/BranchError;)V

    .line 73
    :cond_0
    return-void
.end method

.method public isGetRequest()Z
    .locals 1

    .prologue
    .line 88
    const/4 v0, 0x1

    return v0
.end method

.method public onRequestSucceeded(Lio/branch/referral/ServerResponse;Lio/branch/referral/Branch;)V
    .locals 9
    .param p1, "resp"    # Lio/branch/referral/ServerResponse;
    .param p2, "branch"    # Lio/branch/referral/Branch;

    .prologue
    .line 42
    const/4 v6, 0x0

    .line 43
    .local v6, "updateListener":Z
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v7

    invoke-virtual {v7}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v3

    .line 44
    .local v3, "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 45
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 48
    .local v2, "key":Ljava/lang/String;
    :try_start_0
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v7

    invoke-virtual {v7, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 49
    .local v0, "counts":Lorg/json/JSONObject;
    sget-object v7, Lio/branch/referral/Defines$Jsonkey;->Total:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v7}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v7}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v4

    .line 50
    .local v4, "total":I
    sget-object v7, Lio/branch/referral/Defines$Jsonkey;->Unique:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v7}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v7}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v5

    .line 52
    .local v5, "unique":I
    iget-object v7, p0, Lio/branch/referral/ServerRequestGetReferralCount;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v7, v2}, Lio/branch/referral/PrefHelper;->getActionTotalCount(Ljava/lang/String;)I

    move-result v7

    if-ne v4, v7, :cond_0

    iget-object v7, p0, Lio/branch/referral/ServerRequestGetReferralCount;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v7, v2}, Lio/branch/referral/PrefHelper;->getActionUniqueCount(Ljava/lang/String;)I

    move-result v7

    if-eq v5, v7, :cond_1

    .line 53
    :cond_0
    const/4 v6, 0x1

    .line 55
    :cond_1
    iget-object v7, p0, Lio/branch/referral/ServerRequestGetReferralCount;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v7, v2, v4}, Lio/branch/referral/PrefHelper;->setActionTotalCount(Ljava/lang/String;I)V

    .line 56
    iget-object v7, p0, Lio/branch/referral/ServerRequestGetReferralCount;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v7, v2, v5}, Lio/branch/referral/PrefHelper;->setActionUniqueCount(Ljava/lang/String;I)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 57
    .end local v0    # "counts":Lorg/json/JSONObject;
    .end local v4    # "total":I
    .end local v5    # "unique":I
    :catch_0
    move-exception v1

    .line 58
    .local v1, "e":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0

    .line 62
    .end local v1    # "e":Lorg/json/JSONException;
    .end local v2    # "key":Ljava/lang/String;
    :cond_2
    iget-object v7, p0, Lio/branch/referral/ServerRequestGetReferralCount;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    if-eqz v7, :cond_3

    .line 63
    iget-object v7, p0, Lio/branch/referral/ServerRequestGetReferralCount;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    const/4 v8, 0x0

    invoke-interface {v7, v6, v8}, Lio/branch/referral/Branch$BranchReferralStateChangedListener;->onStateChanged(ZLio/branch/referral/BranchError;)V

    .line 66
    :cond_3
    return-void
.end method
