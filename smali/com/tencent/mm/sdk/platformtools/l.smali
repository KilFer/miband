.class final Lcom/tencent/mm/sdk/platformtools/l;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$IWaitWorkThread;

.field private synthetic b:Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;


# direct methods
.method constructor <init>(Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$IWaitWorkThread;)V
    .locals 0

    iput-object p2, p0, Lcom/tencent/mm/sdk/platformtools/l;->a:Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$IWaitWorkThread;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/l;->a:Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$IWaitWorkThread;

    invoke-interface {v0}, Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$IWaitWorkThread;->doInBackground()Z

    new-instance v0, Lcom/tencent/mm/sdk/platformtools/m;

    invoke-direct {v0, p0}, Lcom/tencent/mm/sdk/platformtools/m;-><init>(Lcom/tencent/mm/sdk/platformtools/l;)V

    invoke-static {v0}, Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;->a(Ljava/lang/Runnable;)V

    return-void
.end method
