.class final Lcn/com/smartdevices/bracelet/ui/W;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/ui/DynamicFragment;

.field private final synthetic b:Z

.field private final synthetic c:Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$IRealtimeStepsChangedCB;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/DynamicFragment;ZLcom/xiaomi/hm/bleservice/profile/IMiLiProfile$IRealtimeStepsChangedCB;)V
    .locals 0

    iput-boolean p2, p0, Lcn/com/smartdevices/bracelet/ui/W;->b:Z

    iput-object p3, p0, Lcn/com/smartdevices/bracelet/ui/W;->c:Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$IRealtimeStepsChangedCB;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/BLEService;->getDefaultPeripheral()Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    if-eqz v0, :cond_0

    iget-boolean v1, p0, Lcn/com/smartdevices/bracelet/ui/W;->b:Z

    if-eqz v1, :cond_2

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->getRealtimeSteps()I

    move-result v1

    const/4 v2, -0x1

    if-eq v1, v2, :cond_2

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/W;->c:Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$IRealtimeStepsChangedCB;

    invoke-interface {v2, v1}, Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$IRealtimeStepsChangedCB;->process(I)V

    :cond_2
    iget-boolean v1, p0, Lcn/com/smartdevices/bracelet/ui/W;->b:Z

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/W;->c:Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$IRealtimeStepsChangedCB;

    invoke-virtual {v0, v1, v2}, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->enableRealtimeStepNotification(ZLcom/xiaomi/hm/bleservice/profile/IMiLiProfile$IRealtimeStepsChangedCB;)Z

    goto :goto_0
.end method
