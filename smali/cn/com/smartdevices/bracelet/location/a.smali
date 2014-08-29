.class final Lcn/com/smartdevices/bracelet/location/a;
.super Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/location/a;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;-><init>()V

    return-void
.end method


# virtual methods
.method public final gotLocation(Landroid/location/Location;Landroid/content/Context;)V
    .locals 6

    if-nez p1, :cond_0

    const-string v0, "GetLocationHelper"

    const-string v1, "Can\'t get network/gps loaction"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/a;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->c(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)Lcn/com/smartdevices/bracelet/location/GetLocationHelper$ILocationGetter;

    move-result-object v0

    const-string v1, ""

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/location/a;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->b(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)D

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/location/a;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-static {v4}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->a(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v2, v3}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper$ILocationGetter;->onLocationGet(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    const-string v0, "GetLocationHelper"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Get NetWork /GPS location: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Lcn/com/smartdevices/bracelet/location/b;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/location/a;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-direct {v0, v1}, Lcn/com/smartdevices/bracelet/location/b;-><init>(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)V

    const/4 v1, 0x1

    new-array v1, v1, [Landroid/location/Location;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/location/b;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method
