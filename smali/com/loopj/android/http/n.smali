.class final Lcom/loopj/android/http/n;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:Lcom/loopj/android/http/m;

.field private final synthetic b:I

.field private final synthetic c:[Lorg/apache/http/Header;

.field private final synthetic d:Ljava/lang/Throwable;

.field private final synthetic e:Ljava/lang/String;

.field private final synthetic f:Ljava/lang/Object;


# direct methods
.method constructor <init>(Lcom/loopj/android/http/m;I[Lorg/apache/http/Header;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/Object;)V
    .locals 0

    iput-object p1, p0, Lcom/loopj/android/http/n;->a:Lcom/loopj/android/http/m;

    iput p2, p0, Lcom/loopj/android/http/n;->b:I

    iput-object p3, p0, Lcom/loopj/android/http/n;->c:[Lorg/apache/http/Header;

    iput-object p4, p0, Lcom/loopj/android/http/n;->d:Ljava/lang/Throwable;

    iput-object p5, p0, Lcom/loopj/android/http/n;->e:Ljava/lang/String;

    iput-object p6, p0, Lcom/loopj/android/http/n;->f:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 6

    iget-object v0, p0, Lcom/loopj/android/http/n;->a:Lcom/loopj/android/http/m;

    iget-object v0, v0, Lcom/loopj/android/http/m;->a:Lcom/loopj/android/http/BaseJsonHttpResponseHandler;

    iget v1, p0, Lcom/loopj/android/http/n;->b:I

    iget-object v2, p0, Lcom/loopj/android/http/n;->c:[Lorg/apache/http/Header;

    iget-object v3, p0, Lcom/loopj/android/http/n;->d:Ljava/lang/Throwable;

    iget-object v4, p0, Lcom/loopj/android/http/n;->e:Ljava/lang/String;

    iget-object v5, p0, Lcom/loopj/android/http/n;->f:Ljava/lang/Object;

    invoke-virtual/range {v0 .. v5}, Lcom/loopj/android/http/BaseJsonHttpResponseHandler;->onFailure(I[Lorg/apache/http/Header;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method
