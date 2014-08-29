.class final Lu/aly/cO;
.super Landroid/os/AsyncTask;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Integer;",
        "Ljava/lang/Integer;",
        "Lu/aly/bn$a;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Lu/aly/bm;

.field private b:Lu/aly/bl$a;

.field private synthetic c:Lu/aly/bl;


# direct methods
.method public constructor <init>(Lu/aly/bl;Lu/aly/bm;Lu/aly/bl$a;)V
    .locals 0

    iput-object p1, p0, Lu/aly/cO;->c:Lu/aly/bl;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    iput-object p2, p0, Lu/aly/cO;->a:Lu/aly/bm;

    iput-object p3, p0, Lu/aly/cO;->b:Lu/aly/bl$a;

    return-void
.end method

.method private varargs a()Lu/aly/bn$a;
    .locals 2

    iget-object v0, p0, Lu/aly/cO;->c:Lu/aly/bl;

    iget-object v1, p0, Lu/aly/cO;->a:Lu/aly/bm;

    invoke-virtual {v0, v1}, Lu/aly/bl;->a(Lu/aly/bm;)Lu/aly/bn$a;

    move-result-object v0

    return-object v0
.end method

.method private a(Lu/aly/bn$a;)V
    .locals 1

    iget-object v0, p0, Lu/aly/cO;->b:Lu/aly/bl$a;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lu/aly/cO;->b:Lu/aly/bl$a;

    invoke-interface {v0, p1}, Lu/aly/bl$a;->a(Lu/aly/bn$a;)V

    :cond_0
    return-void
.end method


# virtual methods
.method protected final varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2

    iget-object v0, p0, Lu/aly/cO;->c:Lu/aly/bl;

    iget-object v1, p0, Lu/aly/cO;->a:Lu/aly/bm;

    invoke-virtual {v0, v1}, Lu/aly/bl;->a(Lu/aly/bm;)Lu/aly/bn$a;

    move-result-object v0

    return-object v0
.end method

.method protected final synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 1

    check-cast p1, Lu/aly/bn$a;

    iget-object v0, p0, Lu/aly/cO;->b:Lu/aly/bl$a;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lu/aly/cO;->b:Lu/aly/bl$a;

    invoke-interface {v0, p1}, Lu/aly/bl$a;->a(Lu/aly/bn$a;)V

    :cond_0
    return-void
.end method

.method protected final onPreExecute()V
    .locals 1

    iget-object v0, p0, Lu/aly/cO;->b:Lu/aly/bl$a;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lu/aly/cO;->b:Lu/aly/bl$a;

    invoke-interface {v0}, Lu/aly/bl$a;->a()V

    :cond_0
    return-void
.end method
