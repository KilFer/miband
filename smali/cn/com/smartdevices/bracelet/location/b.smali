.class final Lcn/com/smartdevices/bracelet/location/b;
.super Landroid/os/AsyncTask;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Landroid/location/Location;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/location/b;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method private varargs a([Landroid/location/Location;)Ljava/lang/String;
    .locals 5

    const/4 v0, 0x0

    const/4 v1, 0x0

    aget-object v1, p1, v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/location/b;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-virtual {v1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v3

    invoke-static {v2, v3, v4}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->a(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;D)V

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/location/b;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-virtual {v1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v3

    invoke-static {v2, v3, v4}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->b(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;D)V

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "http://api.map.baidu.com/geocoder?location="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/location/b;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->a(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/location/b;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->b(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&output=json&key=1ab613f0f0f131440ea55220ad3aa251"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "GetLocationHelper"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "request Str ="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v2, Lorg/apache/http/client/methods/HttpPost;

    invoke-direct {v2, v1}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    :try_start_0
    new-instance v1, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v1}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>()V

    invoke-virtual {v1, v2}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v1

    invoke-interface {v1}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v2

    invoke-interface {v2}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v2

    const/16 v3, 0xc8

    if-ne v2, v3, :cond_0

    invoke-interface {v1}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v1

    invoke-static {v1}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v0

    :cond_0
    :goto_0
    return-object v0

    :catch_0
    move-exception v1

    invoke-virtual {v1}, Lorg/apache/http/client/ClientProtocolException;->printStackTrace()V

    goto :goto_0

    :catch_1
    move-exception v1

    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    :catch_2
    move-exception v1

    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method private a(Ljava/lang/String;)V
    .locals 6

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/b;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-static {v0, p1}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->a(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "GetLocationHelper"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "get city:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/location/b;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->c(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)Lcn/com/smartdevices/bracelet/location/GetLocationHelper$ILocationGetter;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/location/b;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->b(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)D

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/location/b;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-static {v4}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->a(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v0, v2, v3}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper$ILocationGetter;->onLocationGet(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method protected final varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, [Landroid/location/Location;

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/location/b;->a([Landroid/location/Location;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected final synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 6

    check-cast p1, Ljava/lang/String;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/location/b;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-static {v0, p1}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->a(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "GetLocationHelper"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "get city:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/location/b;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->c(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)Lcn/com/smartdevices/bracelet/location/GetLocationHelper$ILocationGetter;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/location/b;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->b(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)D

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/location/b;->a:Lcn/com/smartdevices/bracelet/location/GetLocationHelper;

    invoke-static {v4}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper;->a(Lcn/com/smartdevices/bracelet/location/GetLocationHelper;)D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v0, v2, v3}, Lcn/com/smartdevices/bracelet/location/GetLocationHelper$ILocationGetter;->onLocationGet(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
