.class final Lcn/com/smartdevices/bracelet/location/c;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/location/LocationListener;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/location/LocationManager;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/location/LocationManager;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/location/c;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onLocationChanged(Landroid/location/Location;)V
    .locals 2

    const-string v0, "LocationManager"

    const-string v1, "Location listener GPS on Location Changed."

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/c;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/location/LocationManager;->a:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/c;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/location/LocationManager;->c:Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/location/c;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/location/LocationManager;->f:Landroid/content/Context;

    invoke-virtual {v0, p1, v1}, Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;->gotLocation(Landroid/location/Location;Landroid/content/Context;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/c;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/location/LocationManager;->b:Landroid/location/LocationManager;

    invoke-virtual {v0, p0}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/c;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/location/LocationManager;->b:Landroid/location/LocationManager;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/location/c;->a:Lcn/com/smartdevices/bracelet/location/LocationManager;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/location/LocationManager;->h:Landroid/location/LocationListener;

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V

    return-void
.end method

.method public final onProviderDisabled(Ljava/lang/String;)V
    .locals 0

    return-void
.end method

.method public final onProviderEnabled(Ljava/lang/String;)V
    .locals 0

    return-void
.end method

.method public final onStatusChanged(Ljava/lang/String;ILandroid/os/Bundle;)V
    .locals 0

    return-void
.end method
