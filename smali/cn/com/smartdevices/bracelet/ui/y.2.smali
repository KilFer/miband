.class final Lcn/com/smartdevices/bracelet/ui/y;
.super Lcom/loopj/android/http/AsyncHttpResponseHandler;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/y;->a:Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;

    invoke-direct {p0}, Lcom/loopj/android/http/AsyncHttpResponseHandler;-><init>()V

    return-void
.end method


# virtual methods
.method public final onFailure(I[Lorg/apache/http/Header;[BLjava/lang/Throwable;)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/y;->a:Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;->i(Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;)V

    return-void
.end method

.method public final onSuccess(I[Lorg/apache/http/Header;[B)V
    .locals 2

    if-eqz p3, :cond_0

    array-length v0, p3

    if-gtz v0, :cond_1

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/y;->a:Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;->i(Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;)V

    :goto_0
    return-void

    :cond_1
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, p3}, Ljava/lang/String;-><init>([B)V

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/webapi/WebRes;->parseWeixinQR(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/y;->a:Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;

    invoke-static {v1, v0}, Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;->a(Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/y;->a:Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;->h(Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;)Landroid/os/Handler;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/y;->a:Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;->i(Lcn/com/smartdevices/bracelet/ui/BindWeixinActivity;)V

    goto :goto_0
.end method
