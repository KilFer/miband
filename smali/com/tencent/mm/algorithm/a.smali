.class final Lcom/tencent/mm/algorithm/a;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Ljava/util/Map$Entry",
        "<TK;",
        "Lcom/tencent/mm/algorithm/LRUMap",
        "<TK;TO;>.TimeVal<TO;>;>;>;"
    }
.end annotation


# instance fields
.field private synthetic a:Lcom/tencent/mm/algorithm/LRUMap;


# direct methods
.method constructor <init>(Lcom/tencent/mm/algorithm/LRUMap;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static a(Ljava/util/Map$Entry;Ljava/util/Map$Entry;)I
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map$Entry",
            "<TK;",
            "Lcom/tencent/mm/algorithm/LRUMap",
            "<TK;TO;>.TimeVal<TO;>;>;",
            "Ljava/util/Map$Entry",
            "<TK;",
            "Lcom/tencent/mm/algorithm/LRUMap",
            "<TK;TO;>.TimeVal<TO;>;>;)I"
        }
    .end annotation

    invoke-interface {p0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/tencent/mm/algorithm/LRUMap$TimeVal;

    iget-object v1, v0, Lcom/tencent/mm/algorithm/LRUMap$TimeVal;->t:Ljava/lang/Long;

    invoke-interface {p1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/tencent/mm/algorithm/LRUMap$TimeVal;

    iget-object v0, v0, Lcom/tencent/mm/algorithm/LRUMap$TimeVal;->t:Ljava/lang/Long;

    invoke-virtual {v1, v0}, Ljava/lang/Long;->compareTo(Ljava/lang/Long;)I

    move-result v0

    return v0
.end method


# virtual methods
.method public final synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 2

    check-cast p1, Ljava/util/Map$Entry;

    check-cast p2, Ljava/util/Map$Entry;

    invoke-interface {p1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/tencent/mm/algorithm/LRUMap$TimeVal;

    iget-object v1, v0, Lcom/tencent/mm/algorithm/LRUMap$TimeVal;->t:Ljava/lang/Long;

    invoke-interface {p2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/tencent/mm/algorithm/LRUMap$TimeVal;

    iget-object v0, v0, Lcom/tencent/mm/algorithm/LRUMap$TimeVal;->t:Ljava/lang/Long;

    invoke-virtual {v1, v0}, Ljava/lang/Long;->compareTo(Ljava/lang/Long;)I

    move-result v0

    return v0
.end method
