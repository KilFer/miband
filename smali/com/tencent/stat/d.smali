.class final Lcom/tencent/stat/d;
.super Lorg/apache/http/impl/client/DefaultConnectionKeepAliveStrategy;


# instance fields
.field private synthetic a:Lcom/tencent/stat/c;


# direct methods
.method constructor <init>(Lcom/tencent/stat/c;)V
    .locals 0

    invoke-direct {p0}, Lorg/apache/http/impl/client/DefaultConnectionKeepAliveStrategy;-><init>()V

    return-void
.end method


# virtual methods
.method public final getKeepAliveDuration(Lorg/apache/http/HttpResponse;Lorg/apache/http/protocol/HttpContext;)J
    .locals 4

    invoke-super {p0, p1, p2}, Lorg/apache/http/impl/client/DefaultConnectionKeepAliveStrategy;->getKeepAliveDuration(Lorg/apache/http/HttpResponse;Lorg/apache/http/protocol/HttpContext;)J

    move-result-wide v0

    const-wide/16 v2, -0x1

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const-wide/16 v0, 0x4e20

    :cond_0
    return-wide v0
.end method
