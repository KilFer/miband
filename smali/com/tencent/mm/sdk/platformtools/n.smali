.class final Lcom/tencent/mm/sdk/platformtools/n;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/tencent/mm/sdk/platformtools/ObserverPool$Listener;",
        ">;"
    }
.end annotation


# instance fields
.field private synthetic a:Lcom/tencent/mm/sdk/platformtools/ObserverPool;


# direct methods
.method constructor <init>(Lcom/tencent/mm/sdk/platformtools/ObserverPool;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static a(Lcom/tencent/mm/sdk/platformtools/ObserverPool$Listener;Lcom/tencent/mm/sdk/platformtools/ObserverPool$Listener;)I
    .locals 2

    invoke-static {p1}, Lcom/tencent/mm/sdk/platformtools/ObserverPool$Listener;->a(Lcom/tencent/mm/sdk/platformtools/ObserverPool$Listener;)I

    move-result v0

    invoke-static {p0}, Lcom/tencent/mm/sdk/platformtools/ObserverPool$Listener;->a(Lcom/tencent/mm/sdk/platformtools/ObserverPool$Listener;)I

    move-result v1

    sub-int/2addr v0, v1

    return v0
.end method


# virtual methods
.method public final synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 2

    check-cast p1, Lcom/tencent/mm/sdk/platformtools/ObserverPool$Listener;

    check-cast p2, Lcom/tencent/mm/sdk/platformtools/ObserverPool$Listener;

    invoke-static {p2}, Lcom/tencent/mm/sdk/platformtools/ObserverPool$Listener;->a(Lcom/tencent/mm/sdk/platformtools/ObserverPool$Listener;)I

    move-result v0

    invoke-static {p1}, Lcom/tencent/mm/sdk/platformtools/ObserverPool$Listener;->a(Lcom/tencent/mm/sdk/platformtools/ObserverPool$Listener;)I

    move-result v1

    sub-int/2addr v0, v1

    return v0
.end method
