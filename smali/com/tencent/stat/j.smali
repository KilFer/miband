.class final Lcom/tencent/stat/j;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/tencent/stat/b;


# instance fields
.field private synthetic a:Lcom/tencent/stat/h;


# direct methods
.method constructor <init>(Lcom/tencent/stat/h;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    invoke-static {}, Lcom/tencent/stat/StatStore;->getInstance()Lcom/tencent/stat/StatStore;

    move-result-object v0

    invoke-virtual {v0}, Lcom/tencent/stat/StatStore;->getNumStoredEvents()I

    move-result v0

    invoke-static {}, Lcom/tencent/stat/StatConfig;->getMaxBatchReportCount()I

    move-result v1

    if-lt v0, v1, :cond_0

    invoke-static {}, Lcom/tencent/stat/StatStore;->getInstance()Lcom/tencent/stat/StatStore;

    move-result-object v0

    invoke-static {}, Lcom/tencent/stat/StatConfig;->getMaxBatchReportCount()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/tencent/stat/StatStore;->a(I)V

    :cond_0
    return-void
.end method

.method public final b()V
    .locals 0

    return-void
.end method
