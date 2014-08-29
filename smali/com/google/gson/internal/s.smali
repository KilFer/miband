.class final Lcom/google/gson/internal/s;
.super Lcom/google/gson/internal/v;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/gson/internal/LinkedTreeMap",
        "<TK;TV;>.com/google/gson/internal/v<",
        "Ljava/util/Map$Entry",
        "<TK;TV;>;>;"
    }
.end annotation


# instance fields
.field private synthetic a:Lcom/google/gson/internal/r;


# direct methods
.method constructor <init>(Lcom/google/gson/internal/r;)V
    .locals 2

    iget-object v0, p1, Lcom/google/gson/internal/r;->a:Lcom/google/gson/internal/LinkedTreeMap;

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/google/gson/internal/v;-><init>(Lcom/google/gson/internal/LinkedTreeMap;B)V

    return-void
.end method

.method private b()Ljava/util/Map$Entry;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map$Entry",
            "<TK;TV;>;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/gson/internal/s;->a()Lcom/google/gson/internal/w;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public final synthetic next()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/google/gson/internal/s;->a()Lcom/google/gson/internal/w;

    move-result-object v0

    return-object v0
.end method
