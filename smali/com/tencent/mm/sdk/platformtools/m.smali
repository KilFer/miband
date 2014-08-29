.class final Lcom/tencent/mm/sdk/platformtools/m;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lcom/tencent/mm/sdk/platformtools/l;


# direct methods
.method constructor <init>(Lcom/tencent/mm/sdk/platformtools/l;)V
    .locals 0

    iput-object p1, p0, Lcom/tencent/mm/sdk/platformtools/m;->a:Lcom/tencent/mm/sdk/platformtools/l;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/m;->a:Lcom/tencent/mm/sdk/platformtools/l;

    iget-object v0, v0, Lcom/tencent/mm/sdk/platformtools/l;->a:Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$IWaitWorkThread;

    invoke-interface {v0}, Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$IWaitWorkThread;->onPostExecute()Z

    return-void
.end method
