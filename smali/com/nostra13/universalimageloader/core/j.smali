.class final Lcom/nostra13/universalimageloader/core/j;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lcom/nostra13/universalimageloader/core/l;

.field private synthetic b:Lcom/nostra13/universalimageloader/core/c;


# direct methods
.method constructor <init>(Lcom/nostra13/universalimageloader/core/c;Lcom/nostra13/universalimageloader/core/l;)V
    .locals 0

    iput-object p1, p0, Lcom/nostra13/universalimageloader/core/j;->b:Lcom/nostra13/universalimageloader/core/c;

    iput-object p2, p0, Lcom/nostra13/universalimageloader/core/j;->a:Lcom/nostra13/universalimageloader/core/l;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/j;->b:Lcom/nostra13/universalimageloader/core/c;

    iget-object v0, v0, Lcom/nostra13/universalimageloader/core/c;->a:Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    iget-object v0, v0, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->m:Lcom/nostra13/universalimageloader/cache/disc/DiskCache;

    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/j;->a:Lcom/nostra13/universalimageloader/core/l;

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/l;->a()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/nostra13/universalimageloader/cache/disc/DiskCache;->get(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/j;->b:Lcom/nostra13/universalimageloader/core/c;

    invoke-static {v1}, Lcom/nostra13/universalimageloader/core/c;->a(Lcom/nostra13/universalimageloader/core/c;)V

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/j;->b:Lcom/nostra13/universalimageloader/core/c;

    invoke-static {v0}, Lcom/nostra13/universalimageloader/core/c;->b(Lcom/nostra13/universalimageloader/core/c;)Ljava/util/concurrent/Executor;

    move-result-object v0

    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/j;->a:Lcom/nostra13/universalimageloader/core/l;

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    :goto_1
    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/j;->b:Lcom/nostra13/universalimageloader/core/c;

    invoke-static {v0}, Lcom/nostra13/universalimageloader/core/c;->c(Lcom/nostra13/universalimageloader/core/c;)Ljava/util/concurrent/Executor;

    move-result-object v0

    iget-object v1, p0, Lcom/nostra13/universalimageloader/core/j;->a:Lcom/nostra13/universalimageloader/core/l;

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    goto :goto_1
.end method
