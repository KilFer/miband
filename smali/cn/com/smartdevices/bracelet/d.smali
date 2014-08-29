.class final Lcn/com/smartdevices/bracelet/d;
.super Ljava/util/TimerTask;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    new-instance v0, Lcn/com/smartdevices/bracelet/BleTask/BleInComingCallTask;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcn/com/smartdevices/bracelet/BleTask/BleInComingCallTask;-><init>(Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;)V

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/BleTask/BleInComingCallTask;->work()V

    return-void
.end method
