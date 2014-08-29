.class public Lcn/com/smartdevices/bracelet/location/GetLocationHelper;
.super Ljava/lang/Object;


# static fields
.field private static final a:Ljava/lang/String; = "GetLocationHelper"


# instance fields
.field private b:Lcn/com/smartdevices/bracelet/location/LocationManager;

.field private c:Lcn/com/smartdevices/bracelet/location/GetLocationHelper$ILocationGetter;

.field private d:D

.field private e:D


# direct methods
.method public constructor <init>()V
    .locals 2

    const-wide/16 v0, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-wide v0, p0, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->d:D

    iput-wide v0, p0, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->e:D

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)D
    .locals 2

    iget-wide v0, p0, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->d:D

    return-wide v0
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    invoke-static {p1}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static a(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string v1, "status"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "OK"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v1, "result"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_0

    const-string v1, "addressComponent"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "city"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;D)V
    .locals 0

    iput-wide p1, p0, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->d:D

    return-void
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)D
    .locals 2

    iget-wide v0, p0, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->e:D

    return-wide v0
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;D)V
    .locals 0

    iput-wide p1, p0, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->e:D

    return-void
.end method

.method static synthetic c(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)Lcn/com/smartdevices/bracelet/location/GetLocationHelper$ILocationGetter;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->c:Lcn/com/smartdevices/bracelet/location/GetLocationHelper$ILocationGetter;

    return-object v0
.end method


# virtual methods
.method public getSystemLocation(Landroid/content/Context;Lcn/com/smartdevices/bracelet/location/GetLocationHelper$ILocationGetter;)V
    .locals 6

    iput-object p2, p0, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->c:Lcn/com/smartdevices/bracelet/location/GetLocationHelper$ILocationGetter;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->b:Lcn/com/smartdevices/bracelet/location/LocationManager;

    if-nez v0, :cond_0

    new-instance v0, Lcn/com/smartdevices/bracelet/location/LocationManager;

    invoke-direct {v0, p1}, Lcn/com/smartdevices/bracelet/location/LocationManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->b:Lcn/com/smartdevices/bracelet/location/LocationManager;

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->b:Lcn/com/smartdevices/bracelet/location/LocationManager;

    new-instance v1, Lcn/com/smartdevices/bracelet/location/a;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/location/a;-><init>(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)V

    invoke-virtual {v0, p1, v1}, Lcn/com/smartdevices/bracelet/location/LocationManager;->getLocation(Landroid/content/Context;Lcn/com/smartdevices/bracelet/location/LocationManager$LocationResult;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->c:Lcn/com/smartdevices/bracelet/location/GetLocationHelper$ILocationGetter;

    const-string v1, ""

    new-instance v2, Ljava/lang/StringBuilder;

    iget-wide v3, p0, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->e:D

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    iget-wide v4, p0, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->d:D

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v2, v3}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper$ILocationGetter;->onLocationGet(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    return-void
.end method
