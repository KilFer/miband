.class final Landroid/support/v4/net/m;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/support/v4/net/n;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 0

    invoke-static {}, Landroid/net/TrafficStats;->clearThreadStatsTag()V

    return-void
.end method

.method public final a(I)V
    .locals 0

    invoke-static {p1}, Landroid/net/TrafficStats;->incrementOperationCount(I)V

    return-void
.end method

.method public final a(II)V
    .locals 0

    invoke-static {p1, p2}, Landroid/net/TrafficStats;->incrementOperationCount(II)V

    return-void
.end method

.method public final a(Ljava/net/Socket;)V
    .locals 0

    invoke-static {p1}, Landroid/net/TrafficStats;->tagSocket(Ljava/net/Socket;)V

    return-void
.end method

.method public final b()I
    .locals 1

    invoke-static {}, Landroid/net/TrafficStats;->getThreadStatsTag()I

    move-result v0

    return v0
.end method

.method public final b(I)V
    .locals 0

    invoke-static {p1}, Landroid/net/TrafficStats;->setThreadStatsTag(I)V

    return-void
.end method

.method public final b(Ljava/net/Socket;)V
    .locals 0

    invoke-static {p1}, Landroid/net/TrafficStats;->untagSocket(Ljava/net/Socket;)V

    return-void
.end method
