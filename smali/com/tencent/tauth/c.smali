.class final Lcom/tencent/tauth/c;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private synthetic a:[Ljava/lang/String;

.field private synthetic b:Ljava/lang/String;

.field private synthetic c:Lcom/tencent/tauth/LocationApi;


# direct methods
.method constructor <init>(Lcom/tencent/tauth/LocationApi;[Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/tencent/tauth/c;->c:Lcom/tencent/tauth/LocationApi;

    iput-object p2, p0, Lcom/tencent/tauth/c;->a:[Ljava/lang/String;

    iput-object p3, p0, Lcom/tencent/tauth/c;->b:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    iget-object v0, p0, Lcom/tencent/tauth/c;->a:[Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/tauth/c;->a:[Ljava/lang/String;

    array-length v0, v0

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    const-string v0, "search_nearby"

    iget-object v1, p0, Lcom/tencent/tauth/c;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "id_search_nearby"

    :goto_1
    iget-object v1, p0, Lcom/tencent/tauth/c;->c:Lcom/tencent/tauth/LocationApi;

    invoke-static {v1}, Lcom/tencent/tauth/LocationApi;->d(Lcom/tencent/tauth/LocationApi;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/tencent/tauth/c;->c:Lcom/tencent/tauth/LocationApi;

    invoke-static {v2}, Lcom/tencent/tauth/LocationApi;->e(Lcom/tencent/tauth/LocationApi;)Lcom/tencent/connect/auth/QQToken;

    move-result-object v2

    iget-object v3, p0, Lcom/tencent/tauth/c;->a:[Ljava/lang/String;

    invoke-static {v1, v2, v0, v3}, Lcom/tencent/connect/a/a;->a(Landroid/content/Context;Lcom/tencent/connect/auth/QQToken;Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    const-string v0, "id_delete_location"

    goto :goto_1
.end method
