.class final Lcom/xiaomi/market/sdk/v;
.super Landroid/os/AsyncTask;


# direct methods
.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(B)V
    .locals 0

    invoke-direct {p0}, Lcom/xiaomi/market/sdk/v;-><init>()V

    return-void
.end method

.method private static varargs a()Ljava/lang/Boolean;
    .locals 2

    invoke-static {}, Lcom/xiaomi/market/sdk/XiaomiUpdateAgent;->b()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/market/sdk/m;->i(Landroid/content/Context;)Lcom/xiaomi/market/sdk/m;

    move-result-object v0

    invoke-static {}, Lcom/xiaomi/market/sdk/XiaomiUpdateAgent;->c()Lcom/xiaomi/market/sdk/q;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/market/sdk/m;->a(Lcom/xiaomi/market/sdk/q;)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method private static a(Ljava/lang/Boolean;)V
    .locals 1

    invoke-virtual {p0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Lcom/xiaomi/market/sdk/t;->a()V

    :cond_0
    return-void
.end method


# virtual methods
.method protected final varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2

    invoke-static {}, Lcom/xiaomi/market/sdk/XiaomiUpdateAgent;->b()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/market/sdk/m;->i(Landroid/content/Context;)Lcom/xiaomi/market/sdk/m;

    move-result-object v0

    invoke-static {}, Lcom/xiaomi/market/sdk/XiaomiUpdateAgent;->c()Lcom/xiaomi/market/sdk/q;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/market/sdk/m;->a(Lcom/xiaomi/market/sdk/q;)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method protected final synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 1

    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Lcom/xiaomi/market/sdk/t;->a()V

    :cond_0
    return-void
.end method
