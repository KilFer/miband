.class final Lcn/com/smartdevices/bracelet/location/e;
.super Landroid/os/Handler;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/location/LocationManager;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/location/LocationManager;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/location/e;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public final handleMessage(Landroid/os/Message;)V
    .locals 2

    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    const-string v0, "LocationManager"

    const-string v1, "update location"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcn/com/smartdevices/bracelet/model/PersonInfo;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/location/e;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    invoke-static {v1, v0}, Lcn/com/smartdevices/bracelet/location/LocationManager;->a(Lcn/com/smartdevices/bracelet/location/LocationManager;Lcn/com/smartdevices/bracelet/model/PersonInfo;)V

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
