.class public Lcom/localytics/android/PushTrackingActivity;
.super Landroid/app/Activity;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 14
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 16
    invoke-virtual {p0}, Lcom/localytics/android/PushTrackingActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 19
    invoke-static {p0}, Lcom/localytics/android/DatapointHelper;->getLocalyticsAppKeyOrNull(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 20
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 22
    invoke-virtual {p0}, Lcom/localytics/android/PushTrackingActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, v1}, Lcom/localytics/android/Localytics;->integrate(Landroid/content/Context;Ljava/lang/String;)V

    .line 25
    :cond_0
    invoke-static {}, Lcom/localytics/android/Localytics;->openSession()V

    .line 26
    invoke-static {v0}, Lcom/localytics/android/Localytics;->handlePushNotificationOpened(Landroid/content/Intent;)V

    .line 29
    invoke-virtual {p0}, Lcom/localytics/android/PushTrackingActivity;->finish()V

    .line 31
    invoke-virtual {p0}, Lcom/localytics/android/PushTrackingActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {p0}, Lcom/localytics/android/PushTrackingActivity;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    .line 32
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/content/Intent;)Landroid/content/Intent;

    .line 33
    const/high16 v0, 0x24000000

    invoke-virtual {v1, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 34
    invoke-virtual {p0, v1}, Lcom/localytics/android/PushTrackingActivity;->startActivity(Landroid/content/Intent;)V

    .line 35
    return-void
.end method
