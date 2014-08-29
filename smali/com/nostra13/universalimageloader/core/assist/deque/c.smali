.class final Lcom/nostra13/universalimageloader/core/assist/deque/c;
.super Lcom/nostra13/universalimageloader/core/assist/deque/b;


# instance fields
.field private synthetic a:Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque;


# direct methods
.method private constructor <init>(Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque;)V
    .locals 0

    iput-object p1, p0, Lcom/nostra13/universalimageloader/core/assist/deque/c;->a:Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque;

    invoke-direct {p0, p1}, Lcom/nostra13/universalimageloader/core/assist/deque/b;-><init>(Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque;B)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/nostra13/universalimageloader/core/assist/deque/c;-><init>(Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque;)V

    return-void
.end method


# virtual methods
.method final a()Lcom/nostra13/universalimageloader/core/assist/deque/a;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/nostra13/universalimageloader/core/assist/deque/a",
            "<TE;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/nostra13/universalimageloader/core/assist/deque/c;->a:Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque;

    iget-object v0, v0, Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque;->b:Lcom/nostra13/universalimageloader/core/assist/deque/a;

    return-object v0
.end method

.method final a(Lcom/nostra13/universalimageloader/core/assist/deque/a;)Lcom/nostra13/universalimageloader/core/assist/deque/a;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/nostra13/universalimageloader/core/assist/deque/a",
            "<TE;>;)",
            "Lcom/nostra13/universalimageloader/core/assist/deque/a",
            "<TE;>;"
        }
    .end annotation

    iget-object v0, p1, Lcom/nostra13/universalimageloader/core/assist/deque/a;->b:Lcom/nostra13/universalimageloader/core/assist/deque/a;

    return-object v0
.end method
