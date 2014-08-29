.class final Lcn/com/smartdevices/bracelet/location/g;
.super Ljava/util/TimerTask;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/location/LocationManager;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/location/LocationManager;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 7

    const/4 v1, 0x0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/location/LocationManager;->b:Landroid/location/LocationManager;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v2, v2, Lcn/com/smartdevices/bracelet/location/LocationManager;->g:Landroid/location/LocationListener;

    invoke-virtual {v0, v2}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/location/LocationManager;->b:Landroid/location/LocationManager;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v2, v2, Lcn/com/smartdevices/bracelet/location/LocationManager;->h:Landroid/location/LocationListener;

    invoke-virtual {v0, v2}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-boolean v0, v0, Lcn/com/smartdevices/bracelet/location/LocationManager;->d:Z

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/location/LocationManager;->b:Landroid/location/LocationManager;

    const-string v2, "gps"

    invoke-virtual {v0, v2}, Landroid/location/LocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v0

    :goto_0
    iget-object v2, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-boolean v2, v2, Lcn/com/smartdevices/bracelet/location/LocationManager;->e:Z

    if-eqz v2, :cond_4

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v2, v2, Lcn/com/smartdevices/bracelet/location/LocationManager;->b:Landroid/location/LocationManager;

    const-string v3, "network"

    invoke-virtual {v2, v3}, Landroid/location/LocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v2

    :goto_1
    const-string v3, "LocationManager"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "net_loc = "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " , gps location ="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz v0, :cond_1

    if-eqz v2, :cond_1

    invoke-virtual {v0}, Landroid/location/Location;->getTime()J

    move-result-wide v3

    invoke-virtual {v2}, Landroid/location/Location;->getTime()J

    move-result-wide v5

    cmp-long v1, v3, v5

    if-lez v1, :cond_0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/location/LocationManager;->c:Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v2, v2, Lcn/com/smartdevices/bracelet/location/LocationManager;->f:Landroid/content/Context;

    invoke-virtual {v1, v0, v2}, Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;->gotLocation(Landroid/location/Location;Landroid/content/Context;)V

    :goto_2
    return-void

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/location/LocationManager;->c:Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/location/LocationManager;->f:Landroid/content/Context;

    invoke-virtual {v0, v2, v1}, Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;->gotLocation(Landroid/location/Location;Landroid/content/Context;)V

    goto :goto_2

    :cond_1
    if-eqz v0, :cond_2

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/location/LocationManager;->c:Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v2, v2, Lcn/com/smartdevices/bracelet/location/LocationManager;->f:Landroid/content/Context;

    invoke-virtual {v1, v0, v2}, Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;->gotLocation(Landroid/location/Location;Landroid/content/Context;)V

    goto :goto_2

    :cond_2
    if-eqz v2, :cond_3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/location/LocationManager;->c:Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/location/LocationManager;->f:Landroid/content/Context;

    invoke-virtual {v0, v2, v1}, Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;->gotLocation(Landroid/location/Location;Landroid/content/Context;)V

    goto :goto_2

    :cond_3
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/location/LocationManager;->c:Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/location/g;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v2, v2, Lcn/com/smartdevices/bracelet/location/LocationManager;->f:Landroid/content/Context;

    invoke-virtual {v0, v1, v2}, Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;->gotLocation(Landroid/location/Location;Landroid/content/Context;)V

    goto :goto_2

    :cond_4
    move-object v2, v1

    goto :goto_1

    :cond_5
    move-object v0, v1

    goto/16 :goto_0
.end method
