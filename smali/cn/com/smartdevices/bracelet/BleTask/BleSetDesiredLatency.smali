.class public Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;
.super Lcn/com/smartdevices/bracelet/BleTask/BleTask;


# static fields
.field public static TAG:Ljava/lang/String; = null

.field private static final b:I = 0x2

.field private static c:Ljava/lang/Object;

.field protected static waitingResult:Ljava/lang/Object;


# instance fields
.field private a:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-string v0, "BleTaskX"

    sput-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->c:Ljava/lang/Object;

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->waitingResult:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(ILcn/com/smartdevices/bracelet/BleTask/BleCallBack;)V
    .locals 1

    invoke-direct {p0, p2}, Lcn/com/smartdevices/bracelet/BleTask/BleTask;-><init>(Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;)V

    const/4 v0, 0x0

    iput v0, p0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->a:I

    iput p1, p0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->a:I

    return-void
.end method

.method private a(I)V
    .locals 7

    const/16 v4, 0x3e8

    const/16 v1, 0x27

    const/4 v6, -0x1

    const/4 v3, 0x0

    sget-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v5, "value:"

    invoke-direct {v2, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v5, "value:"

    invoke-direct {v2, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->waitingResult:Ljava/lang/Object;

    if-ne p1, v1, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->gattPeripheral:Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    const/16 v2, 0x31

    move v5, v3

    invoke-virtual/range {v0 .. v5}, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->_setLEParams(IIIII)Z

    move-result v3

    :cond_0
    :goto_0
    if-eqz v3, :cond_1

    sget-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->waitingResult:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-ne v0, v6, :cond_1

    sget-object v1, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->c:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    const-string v2, "before waiting..."

    invoke-static {v0, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :try_start_1
    sget-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->c:Ljava/lang/Object;

    const-wide/16 v2, 0x2710

    invoke-virtual {v0, v2, v3}, Ljava/lang/Object;->wait(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :goto_1
    :try_start_2
    sget-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "after waiting..."

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v3, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->waitingResult:Ljava/lang/Object;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->gattPeripheral:Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->_getLEParams()Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$LEParams;

    move-result-object v0

    sget-object v1, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "out setLatency!\n"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "out setLatency!\n"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    return-void

    :cond_2
    const/16 v0, 0x1e0

    if-ne p1, v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->gattPeripheral:Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    const/16 v1, 0x1cc

    const/16 v2, 0x1f4

    move v5, v3

    invoke-virtual/range {v0 .. v5}, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->_setLEParams(IIIII)Z

    move-result v3

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0

    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method private static a(J)V
    .locals 4

    sget-object v1, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->c:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    const-string v2, "before waiting..."

    invoke-static {v0, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :try_start_1
    sget-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->c:Ljava/lang/Object;

    const-wide/16 v2, 0x2710

    invoke-virtual {v0, v2, v3}, Ljava/lang/Object;->wait(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :goto_0
    :try_start_2
    sget-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "after waiting..."

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v3, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->waitingResult:Ljava/lang/Object;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public static waitingNotify(Ljava/lang/Object;)V
    .locals 3

    sget-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "waitingNotify:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->c:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    sput-object p0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->waitingResult:Ljava/lang/Object;

    sget-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->c:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public doWork(Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;)V
    .locals 13

    const/16 v2, 0x31

    const/4 v12, -0x1

    const/16 v11, 0x8

    const/16 v1, 0x27

    const/4 v3, 0x0

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;->sendOnStartMessage()V

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->gattPeripheral:Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->_getLEParams()Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$LEParams;

    move-result-object v0

    if-eqz v0, :cond_3

    sget-object v4, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "set latency:"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v6, p0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->a:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\n"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v4, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "set latency:"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v6, p0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->a:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\n"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    iget v4, p0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->a:I

    if-ne v4, v1, :cond_2

    iget v4, v0, Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$LEParams;->connInt:I

    if-lt v4, v1, :cond_3

    iget v0, v0, Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$LEParams;->connInt:I

    if-gt v0, v2, :cond_3

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;->sendOnFinishMessage(Ljava/lang/Object;)V

    :cond_1
    :goto_0
    return-void

    :cond_2
    iget v4, p0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->a:I

    const/16 v5, 0x1e0

    if-ne v4, v5, :cond_3

    iget v4, v0, Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$LEParams;->connInt:I

    const/16 v5, 0x1cc

    if-lt v4, v5, :cond_3

    iget v0, v0, Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$LEParams;->connInt:I

    const/16 v4, 0x1f4

    if-gt v0, v4, :cond_3

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;->sendOnFinishMessage(Ljava/lang/Object;)V

    goto :goto_0

    :cond_3
    move v0, v3

    :goto_1
    add-int/lit8 v10, v0, 0x1

    const/4 v4, 0x2

    if-lt v0, v4, :cond_5

    :cond_4
    if-eqz p1, :cond_1

    sget-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->waitingResult:Ljava/lang/Object;

    invoke-virtual {p1, v0}, Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;->sendOnFinishMessage(Ljava/lang/Object;)V

    goto :goto_0

    :cond_5
    iget v0, p0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->a:I

    sget-object v4, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "value:"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v4, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "value:"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    sput-object v4, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->waitingResult:Ljava/lang/Object;

    if-ne v0, v1, :cond_7

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->gattPeripheral:Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    const/16 v4, 0x3e8

    move v5, v3

    invoke-virtual/range {v0 .. v5}, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->_setLEParams(IIIII)Z

    move-result v0

    :goto_2
    if-eqz v0, :cond_6

    sget-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->waitingResult:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-ne v0, v12, :cond_6

    const-wide/16 v4, 0x2710

    invoke-static {v4, v5}, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->a(J)V

    :cond_6
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->gattPeripheral:Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->_getLEParams()Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$LEParams;

    move-result-object v0

    sget-object v4, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "out setLatency!\n"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v4, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "out setLatency!\n"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v4, v0}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->waitingResult:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-eq v0, v11, :cond_4

    move v0, v10

    goto/16 :goto_1

    :cond_7
    const/16 v4, 0x1e0

    if-ne v0, v4, :cond_8

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->gattPeripheral:Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    const/16 v5, 0x1cc

    const/16 v6, 0x1f4

    const/16 v8, 0x3e8

    move v7, v3

    move v9, v3

    invoke-virtual/range {v4 .. v9}, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->_setLEParams(IIIII)Z

    move-result v0

    goto :goto_2

    :cond_8
    move v0, v3

    goto :goto_2
.end method
