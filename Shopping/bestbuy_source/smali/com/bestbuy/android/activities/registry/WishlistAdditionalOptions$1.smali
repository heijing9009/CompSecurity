.class Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/app/DatePickerDialog$OnDateSetListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;)V
    .locals 0

    .prologue
    .line 120
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions$1;->a:Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a()V
    .locals 3

    .prologue
    .line 132
    const-string v0, "MM/dd/yyyy"

    .line 133
    new-instance v1, Ljava/text/SimpleDateFormat;

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v1, v0, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions$1;->a:Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->b(Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;)Landroid/widget/EditText;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions$1;->a:Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;

    invoke-static {v2}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->a(Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;)Ljava/util/Calendar;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 135
    return-void
.end method


# virtual methods
.method public onDateSet(Landroid/widget/DatePicker;III)V
    .locals 2

    .prologue
    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions$1;->a:Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->a(Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;)Ljava/util/Calendar;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1, p2}, Ljava/util/Calendar;->set(II)V

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions$1;->a:Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->a(Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;)Ljava/util/Calendar;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1, p3}, Ljava/util/Calendar;->set(II)V

    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions$1;->a:Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->a(Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;)Ljava/util/Calendar;

    move-result-object v0

    const/4 v1, 0x5

    invoke-virtual {v0, v1, p4}, Ljava/util/Calendar;->set(II)V

    .line 128
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions$1;->a()V

    .line 129
    return-void
.end method
