.class final Lcom/google/zxing/pdf417/encoder/a;
.super Ljava/lang/Object;


# instance fields
.field private final a:[Lcom/google/zxing/pdf417/encoder/b;

.field private b:I

.field private final c:I

.field private final d:I


# direct methods
.method constructor <init>(II)V
    .locals 6

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    add-int/lit8 v0, p1, 0x2

    new-array v0, v0, [Lcom/google/zxing/pdf417/encoder/b;

    iput-object v0, p0, Lcom/google/zxing/pdf417/encoder/a;->a:[Lcom/google/zxing/pdf417/encoder/b;

    iget-object v0, p0, Lcom/google/zxing/pdf417/encoder/a;->a:[Lcom/google/zxing/pdf417/encoder/b;

    array-length v2, v0

    move v0, v1

    :goto_0
    if-ge v0, v2, :cond_0

    iget-object v3, p0, Lcom/google/zxing/pdf417/encoder/a;->a:[Lcom/google/zxing/pdf417/encoder/b;

    new-instance v4, Lcom/google/zxing/pdf417/encoder/b;

    add-int/lit8 v5, p2, 0x4

    mul-int/lit8 v5, v5, 0x11

    add-int/lit8 v5, v5, 0x1

    invoke-direct {v4, v5}, Lcom/google/zxing/pdf417/encoder/b;-><init>(I)V

    aput-object v4, v3, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    mul-int/lit8 v0, p2, 0x11

    iput v0, p0, Lcom/google/zxing/pdf417/encoder/a;->d:I

    add-int/lit8 v0, p1, 0x2

    iput v0, p0, Lcom/google/zxing/pdf417/encoder/a;->c:I

    iput v1, p0, Lcom/google/zxing/pdf417/encoder/a;->b:I

    return-void
.end method

.method private a(IIB)V
    .locals 1

    iget-object v0, p0, Lcom/google/zxing/pdf417/encoder/a;->a:[Lcom/google/zxing/pdf417/encoder/b;

    aget-object v0, v0, p2

    invoke-virtual {v0, p1, p3}, Lcom/google/zxing/pdf417/encoder/b;->a(IB)V

    return-void
.end method

.method private a(IIZ)V
    .locals 2

    if-eqz p3, :cond_0

    const/4 v0, 0x1

    :goto_0
    int-to-byte v0, v0

    iget-object v1, p0, Lcom/google/zxing/pdf417/encoder/a;->a:[Lcom/google/zxing/pdf417/encoder/b;

    aget-object v1, v1, p2

    invoke-virtual {v1, p1, v0}, Lcom/google/zxing/pdf417/encoder/b;->a(IB)V

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private a(I)[[B
    .locals 1

    invoke-virtual {p0, p1, p1}, Lcom/google/zxing/pdf417/encoder/a;->a(II)[[B

    move-result-object v0

    return-object v0
.end method

.method private c()[[B
    .locals 1

    const/4 v0, 0x1

    invoke-virtual {p0, v0, v0}, Lcom/google/zxing/pdf417/encoder/a;->a(II)[[B

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method final a()V
    .locals 1

    iget v0, p0, Lcom/google/zxing/pdf417/encoder/a;->b:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/zxing/pdf417/encoder/a;->b:I

    return-void
.end method

.method final a(II)[[B
    .locals 6

    iget v0, p0, Lcom/google/zxing/pdf417/encoder/a;->c:I

    mul-int/2addr v0, p2

    iget v1, p0, Lcom/google/zxing/pdf417/encoder/a;->d:I

    mul-int/2addr v1, p1

    filled-new-array {v0, v1}, [I

    move-result-object v0

    sget-object v1, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[B

    iget v1, p0, Lcom/google/zxing/pdf417/encoder/a;->c:I

    mul-int v2, v1, p2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v2, :cond_0

    sub-int v3, v2, v1

    add-int/lit8 v3, v3, -0x1

    iget-object v4, p0, Lcom/google/zxing/pdf417/encoder/a;->a:[Lcom/google/zxing/pdf417/encoder/b;

    div-int v5, v1, p2

    aget-object v4, v4, v5

    invoke-virtual {v4, p1}, Lcom/google/zxing/pdf417/encoder/b;->a(I)[B

    move-result-object v4

    aput-object v4, v0, v3

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_0
    return-object v0
.end method

.method final b()Lcom/google/zxing/pdf417/encoder/b;
    .locals 2

    iget-object v0, p0, Lcom/google/zxing/pdf417/encoder/a;->a:[Lcom/google/zxing/pdf417/encoder/b;

    iget v1, p0, Lcom/google/zxing/pdf417/encoder/a;->b:I

    aget-object v0, v0, v1

    return-object v0
.end method
