.class final Lcom/tencent/stat/r;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/tencent/stat/b;


# instance fields
.field private synthetic a:Ljava/util/List;

.field private synthetic b:I

.field private synthetic c:Lcom/tencent/stat/q;


# direct methods
.method constructor <init>(Lcom/tencent/stat/q;Ljava/util/List;I)V
    .locals 0

    iput-object p1, p0, Lcom/tencent/stat/r;->c:Lcom/tencent/stat/q;

    iput-object p2, p0, Lcom/tencent/stat/r;->a:Ljava/util/List;

    iput p3, p0, Lcom/tencent/stat/r;->b:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 3

    const/4 v2, -0x1

    iget-object v0, p0, Lcom/tencent/stat/r;->c:Lcom/tencent/stat/q;

    iget-object v0, v0, Lcom/tencent/stat/q;->b:Lcom/tencent/stat/StatStore;

    iget-object v1, p0, Lcom/tencent/stat/r;->a:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcom/tencent/stat/StatStore;->a(Ljava/util/List;)V

    iget-object v0, p0, Lcom/tencent/stat/r;->c:Lcom/tencent/stat/q;

    iget v0, v0, Lcom/tencent/stat/q;->a:I

    if-ne v0, v2, :cond_2

    iget-object v0, p0, Lcom/tencent/stat/r;->c:Lcom/tencent/stat/q;

    iget v0, v0, Lcom/tencent/stat/q;->a:I

    :goto_0
    if-eq v0, v2, :cond_0

    if-lez v0, :cond_1

    :cond_0
    iget-object v1, p0, Lcom/tencent/stat/r;->c:Lcom/tencent/stat/q;

    iget-object v1, v1, Lcom/tencent/stat/q;->b:Lcom/tencent/stat/StatStore;

    invoke-virtual {v1, v0}, Lcom/tencent/stat/StatStore;->a(I)V

    :cond_1
    return-void

    :cond_2
    iget-object v0, p0, Lcom/tencent/stat/r;->c:Lcom/tencent/stat/q;

    iget v0, v0, Lcom/tencent/stat/q;->a:I

    iget-object v1, p0, Lcom/tencent/stat/r;->a:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    sub-int/2addr v0, v1

    goto :goto_0
.end method

.method public final b()V
    .locals 3

    iget-object v0, p0, Lcom/tencent/stat/r;->c:Lcom/tencent/stat/q;

    iget-object v0, v0, Lcom/tencent/stat/q;->b:Lcom/tencent/stat/StatStore;

    iget v1, v0, Lcom/tencent/stat/StatStore;->a:I

    iget v2, p0, Lcom/tencent/stat/r;->b:I

    add-int/2addr v1, v2

    iput v1, v0, Lcom/tencent/stat/StatStore;->a:I

    iget-object v0, p0, Lcom/tencent/stat/r;->c:Lcom/tencent/stat/q;

    iget-object v0, v0, Lcom/tencent/stat/q;->b:Lcom/tencent/stat/StatStore;

    iget-object v1, p0, Lcom/tencent/stat/r;->a:Ljava/util/List;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/tencent/stat/StatStore;->a(Ljava/util/List;I)V

    return-void
.end method
