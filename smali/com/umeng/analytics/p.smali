.class final Lcom/umeng/analytics/p;
.super Lcom/umeng/analytics/f;


# instance fields
.field private synthetic a:Lcom/umeng/analytics/d;

.field private final synthetic b:Ljava/lang/String;

.field private final synthetic c:Ljava/util/HashMap;

.field private final synthetic d:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/umeng/analytics/d;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/umeng/analytics/p;->a:Lcom/umeng/analytics/d;

    iput-object p2, p0, Lcom/umeng/analytics/p;->b:Ljava/lang/String;

    iput-object p3, p0, Lcom/umeng/analytics/p;->c:Ljava/util/HashMap;

    iput-object p4, p0, Lcom/umeng/analytics/p;->d:Ljava/lang/String;

    invoke-direct {p0}, Lcom/umeng/analytics/f;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 4

    iget-object v0, p0, Lcom/umeng/analytics/p;->a:Lcom/umeng/analytics/d;

    invoke-static {v0}, Lcom/umeng/analytics/d;->a(Lcom/umeng/analytics/d;)Lu/aly/n;

    move-result-object v0

    iget-object v1, p0, Lcom/umeng/analytics/p;->b:Ljava/lang/String;

    iget-object v2, p0, Lcom/umeng/analytics/p;->c:Ljava/util/HashMap;

    iget-object v3, p0, Lcom/umeng/analytics/p;->d:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Lu/aly/n;->a(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V

    return-void
.end method
