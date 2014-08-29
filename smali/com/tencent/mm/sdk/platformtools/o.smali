.class final Lcom/tencent/mm/sdk/platformtools/o;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lcom/tencent/mm/sdk/platformtools/ObserverPool$Event;

.field private synthetic b:Lcom/tencent/mm/sdk/platformtools/ObserverPool;


# direct methods
.method constructor <init>(Lcom/tencent/mm/sdk/platformtools/ObserverPool;Lcom/tencent/mm/sdk/platformtools/ObserverPool$Event;)V
    .locals 0

    iput-object p1, p0, Lcom/tencent/mm/sdk/platformtools/o;->b:Lcom/tencent/mm/sdk/platformtools/ObserverPool;

    iput-object p2, p0, Lcom/tencent/mm/sdk/platformtools/o;->a:Lcom/tencent/mm/sdk/platformtools/ObserverPool$Event;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/o;->b:Lcom/tencent/mm/sdk/platformtools/ObserverPool;

    iget-object v1, p0, Lcom/tencent/mm/sdk/platformtools/o;->a:Lcom/tencent/mm/sdk/platformtools/ObserverPool$Event;

    invoke-virtual {v0, v1}, Lcom/tencent/mm/sdk/platformtools/ObserverPool;->publish(Lcom/tencent/mm/sdk/platformtools/ObserverPool$Event;)Z

    return-void
.end method
