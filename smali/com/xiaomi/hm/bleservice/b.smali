.class final Lcom/xiaomi/hm/bleservice/b;
.super Landroid/os/Handler;


# instance fields
.field private synthetic a:Lcom/xiaomi/hm/bleservice/BLEService;


# direct methods
.method constructor <init>(Lcom/xiaomi/hm/bleservice/BLEService;Landroid/os/Looper;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/hm/bleservice/b;->a:Lcom/xiaomi/hm/bleservice/BLEService;

    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public final handleMessage(Landroid/os/Message;)V
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/hm/bleservice/b;->a:Lcom/xiaomi/hm/bleservice/BLEService;

    # invokes: Lcom/xiaomi/hm/bleservice/BLEService;->handleMessage(Landroid/os/Message;)V
    invoke-static {v0, p1}, Lcom/xiaomi/hm/bleservice/BLEService;->access$0(Lcom/xiaomi/hm/bleservice/BLEService;Landroid/os/Message;)V

    return-void
.end method
