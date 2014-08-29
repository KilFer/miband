.class public Lcom/loopj/android/http/AsyncHttpRequest;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final a:Lorg/apache/http/impl/client/AbstractHttpClient;

.field private final b:Lorg/apache/http/protocol/HttpContext;

.field private final c:Lorg/apache/http/client/methods/HttpUriRequest;

.field private final d:Lcom/loopj/android/http/ResponseHandlerInterface;

.field private e:I

.field private f:Z

.field private g:Z

.field private h:Z


# direct methods
.method public constructor <init>(Lorg/apache/http/impl/client/AbstractHttpClient;Lorg/apache/http/protocol/HttpContext;Lorg/apache/http/client/methods/HttpUriRequest;Lcom/loopj/android/http/ResponseHandlerInterface;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->f:Z

    iput-boolean v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->g:Z

    iput-boolean v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->h:Z

    iput-object p1, p0, Lcom/loopj/android/http/AsyncHttpRequest;->a:Lorg/apache/http/impl/client/AbstractHttpClient;

    iput-object p2, p0, Lcom/loopj/android/http/AsyncHttpRequest;->b:Lorg/apache/http/protocol/HttpContext;

    iput-object p3, p0, Lcom/loopj/android/http/AsyncHttpRequest;->c:Lorg/apache/http/client/methods/HttpUriRequest;

    iput-object p4, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    return-void
.end method

.method private a()V
    .locals 3

    invoke-virtual {p0}, Lcom/loopj/android/http/AsyncHttpRequest;->isCancelled()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->c:Lorg/apache/http/client/methods/HttpUriRequest;

    invoke-interface {v0}, Lorg/apache/http/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_2

    new-instance v0, Ljava/net/MalformedURLException;

    const-string v1, "No valid URI scheme was provided"

    invoke-direct {v0, v1}, Ljava/net/MalformedURLException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    iget-object v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->a:Lorg/apache/http/impl/client/AbstractHttpClient;

    iget-object v1, p0, Lcom/loopj/android/http/AsyncHttpRequest;->c:Lorg/apache/http/client/methods/HttpUriRequest;

    iget-object v2, p0, Lcom/loopj/android/http/AsyncHttpRequest;->b:Lorg/apache/http/protocol/HttpContext;

    invoke-virtual {v0, v1, v2}, Lorg/apache/http/impl/client/AbstractHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    invoke-virtual {p0}, Lcom/loopj/android/http/AsyncHttpRequest;->isCancelled()Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    invoke-interface {v1, v0}, Lcom/loopj/android/http/ResponseHandlerInterface;->sendResponseMessage(Lorg/apache/http/HttpResponse;)V

    goto :goto_0
.end method

.method private b()V
    .locals 7

    const/4 v1, 0x1

    const/4 v0, 0x0

    iget-object v2, p0, Lcom/loopj/android/http/AsyncHttpRequest;->a:Lorg/apache/http/impl/client/AbstractHttpClient;

    invoke-virtual {v2}, Lorg/apache/http/impl/client/AbstractHttpClient;->getHttpRequestRetryHandler()Lorg/apache/http/client/HttpRequestRetryHandler;

    move-result-object v3

    move v2, v1

    :cond_0
    :goto_0
    if-nez v2, :cond_1

    :goto_1
    throw v0

    :cond_1
    :try_start_0
    invoke-virtual {p0}, Lcom/loopj/android/http/AsyncHttpRequest;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->c:Lorg/apache/http/client/methods/HttpUriRequest;

    invoke-interface {v0}, Lorg/apache/http/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_2

    new-instance v0, Ljava/net/MalformedURLException;

    const-string v2, "No valid URI scheme was provided"

    invoke-direct {v0, v2}, Ljava/net/MalformedURLException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/net/UnknownHostException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    :catch_0
    move-exception v0

    :try_start_1
    new-instance v2, Ljava/io/IOException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "UnknownHostException exception: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/net/UnknownHostException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    iget v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    if-lez v0, :cond_4

    iget v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    iget-object v4, p0, Lcom/loopj/android/http/AsyncHttpRequest;->b:Lorg/apache/http/protocol/HttpContext;

    invoke-interface {v3, v2, v0, v4}, Lorg/apache/http/client/HttpRequestRetryHandler;->retryRequest(Ljava/io/IOException;ILorg/apache/http/protocol/HttpContext;)Z

    move-result v0

    if-eqz v0, :cond_4

    move v0, v1

    :goto_2
    move-object v6, v2

    move v2, v0

    move-object v0, v6

    :goto_3
    if-eqz v2, :cond_0

    iget-object v4, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    iget v5, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    invoke-interface {v4, v5}, Lcom/loopj/android/http/ResponseHandlerInterface;->sendRetryMessage(I)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    :catch_1
    move-exception v0

    move-object v1, v0

    const-string v0, "AsyncHttpRequest"

    const-string v2, "Unhandled exception origin cause"

    invoke-static {v0, v2, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    new-instance v0, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Unhandled exception: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    :try_start_2
    iget-object v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->a:Lorg/apache/http/impl/client/AbstractHttpClient;

    iget-object v2, p0, Lcom/loopj/android/http/AsyncHttpRequest;->c:Lorg/apache/http/client/methods/HttpUriRequest;

    iget-object v4, p0, Lcom/loopj/android/http/AsyncHttpRequest;->b:Lorg/apache/http/protocol/HttpContext;

    invoke-virtual {v0, v2, v4}, Lorg/apache/http/impl/client/AbstractHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    invoke-virtual {p0}, Lcom/loopj/android/http/AsyncHttpRequest;->isCancelled()Z

    move-result v2

    if-nez v2, :cond_3

    iget-object v2, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    invoke-interface {v2, v0}, Lcom/loopj/android/http/ResponseHandlerInterface;->sendResponseMessage(Lorg/apache/http/HttpResponse;)V
    :try_end_2
    .catch Ljava/net/UnknownHostException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    :cond_3
    return-void

    :cond_4
    const/4 v0, 0x0

    goto :goto_2

    :catch_2
    move-exception v0

    :try_start_3
    new-instance v2, Ljava/io/IOException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "NPE in HttpClient: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/NullPointerException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    iget v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    iget-object v4, p0, Lcom/loopj/android/http/AsyncHttpRequest;->b:Lorg/apache/http/protocol/HttpContext;

    invoke-interface {v3, v2, v0, v4}, Lorg/apache/http/client/HttpRequestRetryHandler;->retryRequest(Ljava/io/IOException;ILorg/apache/http/protocol/HttpContext;)Z

    move-result v0

    move-object v6, v2

    move v2, v0

    move-object v0, v6

    goto :goto_3

    :catch_3
    move-exception v0

    invoke-virtual {p0}, Lcom/loopj/android/http/AsyncHttpRequest;->isCancelled()Z

    move-result v2

    if-nez v2, :cond_3

    iget v2, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    iget-object v4, p0, Lcom/loopj/android/http/AsyncHttpRequest;->b:Lorg/apache/http/protocol/HttpContext;

    invoke-interface {v3, v0, v2, v4}, Lorg/apache/http/client/HttpRequestRetryHandler;->retryRequest(Ljava/io/IOException;ILorg/apache/http/protocol/HttpContext;)Z
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    move-result v2

    goto/16 :goto_3
.end method

.method private declared-synchronized c()V
    .locals 1

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->h:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->f:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->g:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->g:Z

    iget-object v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    invoke-interface {v0}, Lcom/loopj/android/http/ResponseHandlerInterface;->sendCancelMessage()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public cancel(Z)Z
    .locals 1

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->f:Z

    iget-object v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->c:Lorg/apache/http/client/methods/HttpUriRequest;

    invoke-interface {v0}, Lorg/apache/http/client/methods/HttpUriRequest;->abort()V

    invoke-virtual {p0}, Lcom/loopj/android/http/AsyncHttpRequest;->isCancelled()Z

    move-result v0

    return v0
.end method

.method public isCancelled()Z
    .locals 1

    iget-boolean v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->f:Z

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/loopj/android/http/AsyncHttpRequest;->c()V

    :cond_0
    iget-boolean v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->f:Z

    return v0
.end method

.method public isDone()Z
    .locals 1

    invoke-virtual {p0}, Lcom/loopj/android/http/AsyncHttpRequest;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->h:Z

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public run()V
    .locals 9

    const/4 v2, 0x0

    const/4 v4, 0x0

    const/4 v1, 0x1

    invoke-virtual {p0}, Lcom/loopj/android/http/AsyncHttpRequest;->isCancelled()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    invoke-interface {v0}, Lcom/loopj/android/http/ResponseHandlerInterface;->sendStartMessage()V

    :cond_2
    invoke-virtual {p0}, Lcom/loopj/android/http/AsyncHttpRequest;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->a:Lorg/apache/http/impl/client/AbstractHttpClient;

    invoke-virtual {v0}, Lorg/apache/http/impl/client/AbstractHttpClient;->getHttpRequestRetryHandler()Lorg/apache/http/client/HttpRequestRetryHandler;

    move-result-object v5

    move-object v0, v4

    move v3, v1

    :cond_3
    :goto_1
    if-nez v3, :cond_6

    :goto_2
    throw v0
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    move-exception v0

    invoke-virtual {p0}, Lcom/loopj/android/http/AsyncHttpRequest;->isCancelled()Z

    move-result v3

    if-nez v3, :cond_9

    iget-object v3, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    if-eqz v3, :cond_9

    iget-object v3, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    invoke-interface {v3, v2, v4, v4, v0}, Lcom/loopj/android/http/ResponseHandlerInterface;->sendFailureMessage(I[Lorg/apache/http/Header;[BLjava/lang/Throwable;)V

    :cond_4
    :goto_3
    invoke-virtual {p0}, Lcom/loopj/android/http/AsyncHttpRequest;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    invoke-interface {v0}, Lcom/loopj/android/http/ResponseHandlerInterface;->sendFinishMessage()V

    :cond_5
    iput-boolean v1, p0, Lcom/loopj/android/http/AsyncHttpRequest;->h:Z

    goto :goto_0

    :cond_6
    :try_start_1
    invoke-virtual {p0}, Lcom/loopj/android/http/AsyncHttpRequest;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->c:Lorg/apache/http/client/methods/HttpUriRequest;

    invoke-interface {v0}, Lorg/apache/http/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_7

    new-instance v0, Ljava/net/MalformedURLException;

    const-string v3, "No valid URI scheme was provided"

    invoke-direct {v0, v3}, Ljava/net/MalformedURLException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1
    .catch Ljava/net/UnknownHostException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/NullPointerException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    :catch_1
    move-exception v0

    :try_start_2
    new-instance v3, Ljava/io/IOException;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "UnknownHostException exception: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/net/UnknownHostException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v3, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    iget v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    if-lez v0, :cond_8

    iget v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    iget-object v6, p0, Lcom/loopj/android/http/AsyncHttpRequest;->b:Lorg/apache/http/protocol/HttpContext;

    invoke-interface {v5, v3, v0, v6}, Lorg/apache/http/client/HttpRequestRetryHandler;->retryRequest(Ljava/io/IOException;ILorg/apache/http/protocol/HttpContext;)Z

    move-result v0

    if-eqz v0, :cond_8

    move v0, v1

    :goto_4
    move-object v8, v3

    move v3, v0

    move-object v0, v8

    :goto_5
    if-eqz v3, :cond_3

    iget-object v6, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    if-eqz v6, :cond_3

    iget-object v6, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    iget v7, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    invoke-interface {v6, v7}, Lcom/loopj/android/http/ResponseHandlerInterface;->sendRetryMessage(I)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_1

    :catch_2
    move-exception v0

    move-object v3, v0

    :try_start_3
    const-string v0, "AsyncHttpRequest"

    const-string v5, "Unhandled exception origin cause"

    invoke-static {v0, v5, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    new-instance v0, Ljava/io/IOException;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Unhandled exception: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    goto/16 :goto_2

    :cond_7
    :try_start_4
    iget-object v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->a:Lorg/apache/http/impl/client/AbstractHttpClient;

    iget-object v3, p0, Lcom/loopj/android/http/AsyncHttpRequest;->c:Lorg/apache/http/client/methods/HttpUriRequest;

    iget-object v6, p0, Lcom/loopj/android/http/AsyncHttpRequest;->b:Lorg/apache/http/protocol/HttpContext;

    invoke-virtual {v0, v3, v6}, Lorg/apache/http/impl/client/AbstractHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    invoke-virtual {p0}, Lcom/loopj/android/http/AsyncHttpRequest;->isCancelled()Z

    move-result v3

    if-nez v3, :cond_4

    iget-object v3, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/loopj/android/http/AsyncHttpRequest;->d:Lcom/loopj/android/http/ResponseHandlerInterface;

    invoke-interface {v3, v0}, Lcom/loopj/android/http/ResponseHandlerInterface;->sendResponseMessage(Lorg/apache/http/HttpResponse;)V
    :try_end_4
    .catch Ljava/net/UnknownHostException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/NullPointerException; {:try_start_4 .. :try_end_4} :catch_3
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    goto/16 :goto_3

    :catch_3
    move-exception v0

    :try_start_5
    new-instance v3, Ljava/io/IOException;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "NPE in HttpClient: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/NullPointerException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v3, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    iget v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    iget-object v6, p0, Lcom/loopj/android/http/AsyncHttpRequest;->b:Lorg/apache/http/protocol/HttpContext;

    invoke-interface {v5, v3, v0, v6}, Lorg/apache/http/client/HttpRequestRetryHandler;->retryRequest(Ljava/io/IOException;ILorg/apache/http/protocol/HttpContext;)Z

    move-result v0

    move-object v8, v3

    move v3, v0

    move-object v0, v8

    goto :goto_5

    :cond_8
    move v0, v2

    goto :goto_4

    :catch_4
    move-exception v0

    invoke-virtual {p0}, Lcom/loopj/android/http/AsyncHttpRequest;->isCancelled()Z

    move-result v3

    if-nez v3, :cond_4

    iget v3, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/loopj/android/http/AsyncHttpRequest;->e:I

    iget-object v6, p0, Lcom/loopj/android/http/AsyncHttpRequest;->b:Lorg/apache/http/protocol/HttpContext;

    invoke-interface {v5, v0, v3, v6}, Lorg/apache/http/client/HttpRequestRetryHandler;->retryRequest(Ljava/io/IOException;ILorg/apache/http/protocol/HttpContext;)Z
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_2
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0

    move-result v3

    goto/16 :goto_5

    :cond_9
    const-string v2, "AsyncHttpRequest"

    const-string v3, "makeRequestWithRetries returned error, but handler is null"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_3
.end method