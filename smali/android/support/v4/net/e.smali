.class final Landroid/support/v4/net/e;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/support/v4/net/b;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/net/ConnectivityManager;)Z
    .locals 1

    invoke-virtual {p1}, Landroid/net/ConnectivityManager;->isActiveNetworkMetered()Z

    move-result v0

    return v0
.end method
