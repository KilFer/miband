.class final Lcom/tencent/mm/sdk/platformtools/u;
.super Landroid/os/Handler;


# instance fields
.field private synthetic a:Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;


# direct methods
.method constructor <init>(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)V
    .locals 0

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public final handleMessage(Landroid/os/Message;)V
    .locals 1

    if-eqz p1, :cond_0

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    if-eqz v0, :cond_0

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread$ThreadObject;

    invoke-interface {v0}, Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread$ThreadObject;->onPostExecute()Z

    :cond_0
    return-void
.end method
