.class public Lcn/com/smartdevices/bracelet/location/LocationManager;
.super Ljava/lang/Object;


# static fields
.field protected static final TAG:Ljava/lang/String; = "LocationManager"

.field private static final i:I = 0x2710

.field private static final j:Z = true

.field private static final k:I = 0x1


# instance fields
.field a:Ljava/util/Timer;

.field b:Landroid/location/LocationManager;

.field c:Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;

.field d:Z

.field e:Z

.field f:Landroid/content/Context;

.field g:Landroid/location/LocationListener;

.field h:Landroid/location/LocationListener;

.field private final l:Landroid/os/Handler;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->d:Z

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->e:Z

    new-instance v0, Lcn/com/smartdevices/bracelet/location/c;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/location/c;-><init>(Lcn/com/smartdevices/bracelet/location/LocationManager;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->g:Landroid/location/LocationListener;

    new-instance v0, Lcn/com/smartdevices/bracelet/location/d;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/location/d;-><init>(Lcn/com/smartdevices/bracelet/location/LocationManager;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->h:Landroid/location/LocationListener;

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->f:Landroid/content/Context;

    new-instance v0, Lcn/com/smartdevices/bracelet/location/e;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/location/e;-><init>(Lcn/com/smartdevices/bracelet/location/LocationManager;)V

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/location/LocationManager;Lcn/com/smartdevices/bracelet/model/PersonInfo;)V
    .locals 3

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    const-string v1, "location"

    iget-object v2, p1, Lcn/com/smartdevices/bracelet/model/PersonInfo;->location:Lcn/com/smartdevices/bracelet/model/UserLocationData;

    invoke-virtual {v2}, Lcn/com/smartdevices/bracelet/model/UserLocationData;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {}, Lcn/com/smartdevices/bracelet/Keeper;->readLoginData()Lcn/com/smartdevices/bracelet/model/LoginData;

    move-result-object v0

    iget-object v1, p1, Lcn/com/smartdevices/bracelet/model/PersonInfo;->location:Lcn/com/smartdevices/bracelet/model/UserLocationData;

    new-instance v2, Lcn/com/smartdevices/bracelet/location/f;

    invoke-direct {v2, p0}, Lcn/com/smartdevices/bracelet/location/f;-><init>(Lcn/com/smartdevices/bracelet/location/LocationManager;)V

    invoke-static {v0, v1, v2}, Lcn/com/smartdevices/bracelet/webapi/WebAPI;->sendLocation(Lcn/com/smartdevices/bracelet/model/LoginData;Lcn/com/smartdevices/bracelet/model/UserLocationData;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    return-void
.end method

.method private a(Lcn/com/smartdevices/bracelet/model/PersonInfo;)V
    .locals 3

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    const-string v1, "location"

    iget-object v2, p1, Lcn/com/smartdevices/bracelet/model/PersonInfo;->location:Lcn/com/smartdevices/bracelet/model/UserLocationData;

    invoke-virtual {v2}, Lcn/com/smartdevices/bracelet/model/UserLocationData;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {}, Lcn/com/smartdevices/bracelet/Keeper;->readLoginData()Lcn/com/smartdevices/bracelet/model/LoginData;

    move-result-object v0

    iget-object v1, p1, Lcn/com/smartdevices/bracelet/model/PersonInfo;->location:Lcn/com/smartdevices/bracelet/model/UserLocationData;

    new-instance v2, Lcn/com/smartdevices/bracelet/location/f;

    invoke-direct {v2, p0}, Lcn/com/smartdevices/bracelet/location/f;-><init>(Lcn/com/smartdevices/bracelet/location/LocationManager;)V

    invoke-static {v0, v1, v2}, Lcn/com/smartdevices/bracelet/webapi/WebAPI;->sendLocation(Lcn/com/smartdevices/bracelet/model/LoginData;Lcn/com/smartdevices/bracelet/model/UserLocationData;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    return-void
.end method


# virtual methods
.method public getLocation(Landroid/content/Context;Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;)Z
    .locals 6

    const-wide/16 v2, 0x0

    const/4 v4, 0x0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->f:Landroid/content/Context;

    iput-object p2, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->c:Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->b:Landroid/location/LocationManager;

    if-nez v0, :cond_0

    const-string v0, "location"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->b:Landroid/location/LocationManager;

    const-string v0, "LocationManager"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v5, "lm == null !!!!!!!!!!!!!!"

    invoke-direct {v1, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->b:Landroid/location/LocationManager;

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    :try_start_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->b:Landroid/location/LocationManager;

    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->d:Z

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->b:Landroid/location/LocationManager;

    const-string v1, "network"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->e:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    const-string v0, "LocationManager"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v5, "getLocation!!!!!!!!!!!!!!gps_enabled "

    invoke-direct {v1, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-boolean v5, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->d:Z

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v5, " network_enabled "

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v5, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->e:Z

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->d:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->e:Z

    if-nez v0, :cond_1

    const/4 v0, 0x0

    :goto_1
    return v0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    :cond_1
    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->d:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->b:Landroid/location/LocationManager;

    const-string v1, "gps"

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->g:Landroid/location/LocationListener;

    invoke-virtual/range {v0 .. v5}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;)V

    :cond_2
    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->e:Z

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->b:Landroid/location/LocationManager;

    const-string v1, "network"

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->h:Landroid/location/LocationListener;

    invoke-virtual/range {v0 .. v5}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;)V

    :cond_3
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->a:Ljava/util/Timer;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/LocationManager;->a:Ljava/util/Timer;

    new-instance v1, Lcn/com/smartdevices/bracelet/location/g;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/location/g;-><init>(Lcn/com/smartdevices/bracelet/location/LocationManager;)V

    const-wide/16 v2, 0x2710

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    const/4 v0, 0x1

    goto :goto_1
.end method
