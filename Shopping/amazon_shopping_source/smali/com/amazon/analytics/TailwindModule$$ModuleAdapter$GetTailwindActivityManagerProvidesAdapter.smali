.class public final Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetTailwindActivityManagerProvidesAdapter;
.super Ldagger/internal/ProvidesBinding;
.source "TailwindModule$$ModuleAdapter.java"

# interfaces
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/analytics/TailwindModule$$ModuleAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "GetTailwindActivityManagerProvidesAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ProvidesBinding",
        "<",
        "Lcom/amazon/analytics/TailwindActivityManager;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/analytics/TailwindActivityManager;",
        ">;"
    }
.end annotation


# instance fields
.field private activityManager:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Landroid/app/ActivityManager;",
            ">;"
        }
    .end annotation
.end field

.field private final module:Lcom/amazon/analytics/TailwindModule;


# direct methods
.method public constructor <init>(Lcom/amazon/analytics/TailwindModule;)V
    .locals 4
    .param p1, "module"    # Lcom/amazon/analytics/TailwindModule;

    .prologue
    .line 63
    const-string/jumbo v0, "com.amazon.analytics.TailwindActivityManager"

    const/4 v1, 0x1

    const-string/jumbo v2, "com.amazon.analytics.TailwindModule"

    const-string/jumbo v3, "getTailwindActivityManager"

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/ProvidesBinding;-><init>(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .line 64
    iput-object p1, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetTailwindActivityManagerProvidesAdapter;->module:Lcom/amazon/analytics/TailwindModule;

    .line 65
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetTailwindActivityManagerProvidesAdapter;->setLibrary(Z)V

    .line 66
    return-void
.end method


# virtual methods
.method public attach(Ldagger/internal/Linker;)V
    .locals 3
    .param p1, "linker"    # Ldagger/internal/Linker;

    .prologue
    .line 75
    const-string/jumbo v0, "android.app.ActivityManager"

    const-class v1, Lcom/amazon/analytics/TailwindModule;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetTailwindActivityManagerProvidesAdapter;->activityManager:Ldagger/internal/Binding;

    .line 76
    return-void
.end method

.method public get()Lcom/amazon/analytics/TailwindActivityManager;
    .locals 2

    .prologue
    .line 93
    iget-object v1, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetTailwindActivityManagerProvidesAdapter;->module:Lcom/amazon/analytics/TailwindModule;

    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetTailwindActivityManagerProvidesAdapter;->activityManager:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    invoke-virtual {v1, v0}, Lcom/amazon/analytics/TailwindModule;->getTailwindActivityManager(Landroid/app/ActivityManager;)Lcom/amazon/analytics/TailwindActivityManager;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 57
    invoke-virtual {p0}, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetTailwindActivityManagerProvidesAdapter;->get()Lcom/amazon/analytics/TailwindActivityManager;

    move-result-object v0

    return-object v0
.end method

.method public getDependencies(Ljava/util/Set;Ljava/util/Set;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ldagger/internal/Binding",
            "<*>;>;",
            "Ljava/util/Set",
            "<",
            "Ldagger/internal/Binding",
            "<*>;>;)V"
        }
    .end annotation

    .prologue
    .line 84
    .local p1, "getBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    .local p2, "injectMembersBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    iget-object v0, p0, Lcom/amazon/analytics/TailwindModule$$ModuleAdapter$GetTailwindActivityManagerProvidesAdapter;->activityManager:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 85
    return-void
.end method
