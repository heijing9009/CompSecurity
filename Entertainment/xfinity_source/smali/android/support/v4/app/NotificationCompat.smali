.class public Landroid/support/v4/app/NotificationCompat;
.super Ljava/lang/Object;
.source "NotificationCompat.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/app/NotificationCompat$Action;,
        Landroid/support/v4/app/NotificationCompat$InboxStyle;,
        Landroid/support/v4/app/NotificationCompat$BigTextStyle;,
        Landroid/support/v4/app/NotificationCompat$BigPictureStyle;,
        Landroid/support/v4/app/NotificationCompat$Style;,
        Landroid/support/v4/app/NotificationCompat$Builder;,
        Landroid/support/v4/app/NotificationCompat$NotificationCompatImplJellybean;,
        Landroid/support/v4/app/NotificationCompat$NotificationCompatImplIceCreamSandwich;,
        Landroid/support/v4/app/NotificationCompat$NotificationCompatImplHoneycomb;,
        Landroid/support/v4/app/NotificationCompat$NotificationCompatImplGingerbread;,
        Landroid/support/v4/app/NotificationCompat$NotificationCompatImplBase;,
        Landroid/support/v4/app/NotificationCompat$NotificationCompatImpl;
    }
.end annotation


# static fields
.field private static final IMPL:Landroid/support/v4/app/NotificationCompat$NotificationCompatImpl;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 168
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    .line 169
    new-instance v0, Landroid/support/v4/app/NotificationCompat$NotificationCompatImplJellybean;

    invoke-direct {v0}, Landroid/support/v4/app/NotificationCompat$NotificationCompatImplJellybean;-><init>()V

    sput-object v0, Landroid/support/v4/app/NotificationCompat;->IMPL:Landroid/support/v4/app/NotificationCompat$NotificationCompatImpl;

    .line 179
    :goto_0
    return-void

    .line 170
    :cond_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_1

    .line 171
    new-instance v0, Landroid/support/v4/app/NotificationCompat$NotificationCompatImplIceCreamSandwich;

    invoke-direct {v0}, Landroid/support/v4/app/NotificationCompat$NotificationCompatImplIceCreamSandwich;-><init>()V

    sput-object v0, Landroid/support/v4/app/NotificationCompat;->IMPL:Landroid/support/v4/app/NotificationCompat$NotificationCompatImpl;

    goto :goto_0

    .line 172
    :cond_1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_2

    .line 173
    new-instance v0, Landroid/support/v4/app/NotificationCompat$NotificationCompatImplHoneycomb;

    invoke-direct {v0}, Landroid/support/v4/app/NotificationCompat$NotificationCompatImplHoneycomb;-><init>()V

    sput-object v0, Landroid/support/v4/app/NotificationCompat;->IMPL:Landroid/support/v4/app/NotificationCompat$NotificationCompatImpl;

    goto :goto_0

    .line 174
    :cond_2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x9

    if-lt v0, v1, :cond_3

    .line 175
    new-instance v0, Landroid/support/v4/app/NotificationCompat$NotificationCompatImplGingerbread;

    invoke-direct {v0}, Landroid/support/v4/app/NotificationCompat$NotificationCompatImplGingerbread;-><init>()V

    sput-object v0, Landroid/support/v4/app/NotificationCompat;->IMPL:Landroid/support/v4/app/NotificationCompat$NotificationCompatImpl;

    goto :goto_0

    .line 177
    :cond_3
    new-instance v0, Landroid/support/v4/app/NotificationCompat$NotificationCompatImplBase;

    invoke-direct {v0}, Landroid/support/v4/app/NotificationCompat$NotificationCompatImplBase;-><init>()V

    sput-object v0, Landroid/support/v4/app/NotificationCompat;->IMPL:Landroid/support/v4/app/NotificationCompat$NotificationCompatImpl;

    goto :goto_0
.end method

.method static synthetic access$000()Landroid/support/v4/app/NotificationCompat$NotificationCompatImpl;
    .locals 1

    .prologue
    .line 34
    sget-object v0, Landroid/support/v4/app/NotificationCompat;->IMPL:Landroid/support/v4/app/NotificationCompat$NotificationCompatImpl;

    return-object v0
.end method
