.class Lco/vine/android/util/ConversationMenuHelper$2;
.super Ljava/lang/Object;
.source "ConversationMenuHelper.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/ConversationMenuHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/util/ConversationMenuHelper;


# direct methods
.method constructor <init>(Lco/vine/android/util/ConversationMenuHelper;)V
    .locals 0

    .prologue
    .line 171
    iput-object p1, p0, Lco/vine/android/util/ConversationMenuHelper$2;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 178
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$2;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    # getter for: Lco/vine/android/util/ConversationMenuHelper;->mTapToStartText:Landroid/widget/TextView;
    invoke-static {v0}, Lco/vine/android/util/ConversationMenuHelper;->access$000(Lco/vine/android/util/ConversationMenuHelper;)Landroid/widget/TextView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 179
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 183
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 174
    return-void
.end method
