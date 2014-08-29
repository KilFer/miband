.class final Lcom/tencent/stat/l;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Ljava/util/List;

.field private synthetic b:I

.field private synthetic c:Lcom/tencent/stat/StatStore;


# direct methods
.method constructor <init>(Lcom/tencent/stat/StatStore;Ljava/util/List;I)V
    .locals 0

    iput-object p1, p0, Lcom/tencent/stat/l;->c:Lcom/tencent/stat/StatStore;

    iput-object p2, p0, Lcom/tencent/stat/l;->a:Ljava/util/List;

    iput p3, p0, Lcom/tencent/stat/l;->b:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    iget-object v0, p0, Lcom/tencent/stat/l;->c:Lcom/tencent/stat/StatStore;

    iget-object v1, p0, Lcom/tencent/stat/l;->a:Ljava/util/List;

    iget v2, p0, Lcom/tencent/stat/l;->b:I

    invoke-static {v0, v1, v2}, Lcom/tencent/stat/StatStore;->a(Lcom/tencent/stat/StatStore;Ljava/util/List;I)V

    return-void
.end method
