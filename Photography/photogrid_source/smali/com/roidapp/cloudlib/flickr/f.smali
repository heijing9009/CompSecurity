.class final Lcom/roidapp/cloudlib/flickr/f;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic a:Lcom/roidapp/cloudlib/flickr/FlickrAuthenActivity;


# direct methods
.method constructor <init>(Lcom/roidapp/cloudlib/flickr/FlickrAuthenActivity;)V
    .locals 0

    .prologue
    .line 215
    iput-object p1, p0, Lcom/roidapp/cloudlib/flickr/f;->a:Lcom/roidapp/cloudlib/flickr/FlickrAuthenActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .prologue
    .line 219
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 220
    iget-object v0, p0, Lcom/roidapp/cloudlib/flickr/f;->a:Lcom/roidapp/cloudlib/flickr/FlickrAuthenActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/roidapp/cloudlib/flickr/FlickrAuthenActivity;->setResult(I)V

    .line 221
    iget-object v0, p0, Lcom/roidapp/cloudlib/flickr/f;->a:Lcom/roidapp/cloudlib/flickr/FlickrAuthenActivity;

    invoke-virtual {v0}, Lcom/roidapp/cloudlib/flickr/FlickrAuthenActivity;->finish()V

    .line 222
    return-void
.end method
