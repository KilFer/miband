.class final Lcom/xiaomi/hm/bleservice/d;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lcom/xiaomi/hm/bleservice/c;

.field private final synthetic b:Landroid/content/Context;

.field private final synthetic c:Landroid/content/Intent;


# direct methods
.method constructor <init>(Lcom/xiaomi/hm/bleservice/c;Landroid/content/Context;Landroid/content/Intent;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/hm/bleservice/d;->a:Lcom/xiaomi/hm/bleservice/c;

    iput-object p2, p0, Lcom/xiaomi/hm/bleservice/d;->b:Landroid/content/Context;

    iput-object p3, p0, Lcom/xiaomi/hm/bleservice/d;->c:Landroid/content/Intent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    iget-object v0, p0, Lcom/xiaomi/hm/bleservice/d;->a:Lcom/xiaomi/hm/bleservice/c;

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/c;->a(Lcom/xiaomi/hm/bleservice/c;)Lcom/xiaomi/hm/bleservice/BLEService;

    move-result-object v0

    iget-object v1, p0, Lcom/xiaomi/hm/bleservice/d;->b:Landroid/content/Context;

    iget-object v2, p0, Lcom/xiaomi/hm/bleservice/d;->c:Landroid/content/Intent;

    # invokes: Lcom/xiaomi/hm/bleservice/BLEService;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    invoke-static {v0, v1, v2}, Lcom/xiaomi/hm/bleservice/BLEService;->access$2(Lcom/xiaomi/hm/bleservice/BLEService;Landroid/content/Context;Landroid/content/Intent;)V

    return-void
.end method
