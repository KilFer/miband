.class public Lcom/google/zxing/qrcode/detector/FinderPatternFinder;
.super Ljava/lang/Object;


# static fields
.field protected static final MAX_MODULES:I = 0x39

.field protected static final MIN_SKIP:I = 0x3

.field private static final a:I = 0x2

.field private static final b:I = 0x8


# instance fields
.field private final c:Lcom/google/zxing/common/BitMatrix;

.field private final d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/zxing/qrcode/detector/FinderPattern;",
            ">;"
        }
    .end annotation
.end field

.field private e:Z

.field private final f:[I

.field private final g:Lcom/google/zxing/ResultPointCallback;


# direct methods
.method public constructor <init>(Lcom/google/zxing/common/BitMatrix;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;-><init>(Lcom/google/zxing/common/BitMatrix;Lcom/google/zxing/ResultPointCallback;)V

    return-void
.end method

.method public constructor <init>(Lcom/google/zxing/common/BitMatrix;Lcom/google/zxing/ResultPointCallback;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->c:Lcom/google/zxing/common/BitMatrix;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    const/4 v0, 0x5

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->f:[I

    iput-object p2, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->g:Lcom/google/zxing/ResultPointCallback;

    return-void
.end method

.method private a(IIII)F
    .locals 11

    const/4 v10, 0x4

    const/4 v9, 0x3

    const/4 v8, 0x1

    const/4 v7, 0x0

    const/high16 v0, 0x7fc00000

    iget-object v2, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->c:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v2}, Lcom/google/zxing/common/BitMatrix;->getHeight()I

    move-result v3

    invoke-direct {p0}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->a()[I

    move-result-object v4

    move v1, p1

    :goto_0
    if-ltz v1, :cond_0

    invoke-virtual {v2, p2, v1}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v5

    if-eqz v5, :cond_0

    const/4 v5, 0x2

    aget v6, v4, v5

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v5

    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    :cond_0
    if-gez v1, :cond_2

    :cond_1
    :goto_1
    return v0

    :cond_2
    :goto_2
    if-ltz v1, :cond_3

    invoke-virtual {v2, p2, v1}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v5

    if-nez v5, :cond_3

    aget v5, v4, v8

    if-gt v5, p3, :cond_3

    aget v5, v4, v8

    add-int/lit8 v5, v5, 0x1

    aput v5, v4, v8

    add-int/lit8 v1, v1, -0x1

    goto :goto_2

    :cond_3
    if-ltz v1, :cond_1

    aget v5, v4, v8

    if-gt v5, p3, :cond_1

    :goto_3
    if-ltz v1, :cond_4

    invoke-virtual {v2, p2, v1}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v5

    if-eqz v5, :cond_4

    aget v5, v4, v7

    if-gt v5, p3, :cond_4

    aget v5, v4, v7

    add-int/lit8 v5, v5, 0x1

    aput v5, v4, v7

    add-int/lit8 v1, v1, -0x1

    goto :goto_3

    :cond_4
    aget v1, v4, v7

    if-gt v1, p3, :cond_1

    add-int/lit8 v1, p1, 0x1

    :goto_4
    if-ge v1, v3, :cond_5

    invoke-virtual {v2, p2, v1}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v5

    if-eqz v5, :cond_5

    const/4 v5, 0x2

    aget v6, v4, v5

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v5

    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    :cond_5
    if-eq v1, v3, :cond_1

    :goto_5
    if-ge v1, v3, :cond_6

    invoke-virtual {v2, p2, v1}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v5

    if-nez v5, :cond_6

    aget v5, v4, v9

    if-ge v5, p3, :cond_6

    aget v5, v4, v9

    add-int/lit8 v5, v5, 0x1

    aput v5, v4, v9

    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_6
    if-eq v1, v3, :cond_1

    aget v5, v4, v9

    if-ge v5, p3, :cond_1

    :goto_6
    if-ge v1, v3, :cond_7

    invoke-virtual {v2, p2, v1}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v5

    if-eqz v5, :cond_7

    aget v5, v4, v10

    if-ge v5, p3, :cond_7

    aget v5, v4, v10

    add-int/lit8 v5, v5, 0x1

    aput v5, v4, v10

    add-int/lit8 v1, v1, 0x1

    goto :goto_6

    :cond_7
    aget v2, v4, v10

    if-ge v2, p3, :cond_1

    aget v2, v4, v7

    aget v3, v4, v8

    add-int/2addr v2, v3

    const/4 v3, 0x2

    aget v3, v4, v3

    add-int/2addr v2, v3

    aget v3, v4, v9

    add-int/2addr v2, v3

    aget v3, v4, v10

    add-int/2addr v2, v3

    sub-int/2addr v2, p4

    invoke-static {v2}, Ljava/lang/Math;->abs(I)I

    move-result v2

    mul-int/lit8 v2, v2, 0x5

    mul-int/lit8 v3, p4, 0x2

    if-ge v2, v3, :cond_1

    invoke-static {v4}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->foundPatternCross([I)Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-static {v4, v1}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->a([II)F

    move-result v0

    goto/16 :goto_1
.end method

.method private static a([II)F
    .locals 3

    const/4 v0, 0x4

    aget v0, p0, v0

    sub-int v0, p1, v0

    const/4 v1, 0x3

    aget v1, p0, v1

    sub-int/2addr v0, v1

    int-to-float v0, v0

    const/4 v1, 0x2

    aget v1, p0, v1

    int-to-float v1, v1

    const/high16 v2, 0x40000000

    div-float/2addr v1, v2

    sub-float/2addr v0, v1

    return v0
.end method

.method private a()[I
    .locals 3

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->f:[I

    aput v2, v0, v2

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->f:[I

    const/4 v1, 0x1

    aput v2, v0, v1

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->f:[I

    const/4 v1, 0x2

    aput v2, v0, v1

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->f:[I

    const/4 v1, 0x3

    aput v2, v0, v1

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->f:[I

    const/4 v1, 0x4

    aput v2, v0, v1

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->f:[I

    return-object v0
.end method

.method private b(IIII)F
    .locals 11

    const/4 v10, 0x4

    const/4 v9, 0x3

    const/4 v8, 0x1

    const/4 v7, 0x0

    const/high16 v0, 0x7fc00000

    iget-object v2, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->c:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v2}, Lcom/google/zxing/common/BitMatrix;->getWidth()I

    move-result v3

    invoke-direct {p0}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->a()[I

    move-result-object v4

    move v1, p1

    :goto_0
    if-ltz v1, :cond_0

    invoke-virtual {v2, v1, p2}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v5

    if-eqz v5, :cond_0

    const/4 v5, 0x2

    aget v6, v4, v5

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v5

    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    :cond_0
    if-gez v1, :cond_2

    :cond_1
    :goto_1
    return v0

    :cond_2
    :goto_2
    if-ltz v1, :cond_3

    invoke-virtual {v2, v1, p2}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v5

    if-nez v5, :cond_3

    aget v5, v4, v8

    if-gt v5, p3, :cond_3

    aget v5, v4, v8

    add-int/lit8 v5, v5, 0x1

    aput v5, v4, v8

    add-int/lit8 v1, v1, -0x1

    goto :goto_2

    :cond_3
    if-ltz v1, :cond_1

    aget v5, v4, v8

    if-gt v5, p3, :cond_1

    :goto_3
    if-ltz v1, :cond_4

    invoke-virtual {v2, v1, p2}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v5

    if-eqz v5, :cond_4

    aget v5, v4, v7

    if-gt v5, p3, :cond_4

    aget v5, v4, v7

    add-int/lit8 v5, v5, 0x1

    aput v5, v4, v7

    add-int/lit8 v1, v1, -0x1

    goto :goto_3

    :cond_4
    aget v1, v4, v7

    if-gt v1, p3, :cond_1

    add-int/lit8 v1, p1, 0x1

    :goto_4
    if-ge v1, v3, :cond_5

    invoke-virtual {v2, v1, p2}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v5

    if-eqz v5, :cond_5

    const/4 v5, 0x2

    aget v6, v4, v5

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v5

    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    :cond_5
    if-eq v1, v3, :cond_1

    :goto_5
    if-ge v1, v3, :cond_6

    invoke-virtual {v2, v1, p2}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v5

    if-nez v5, :cond_6

    aget v5, v4, v9

    if-ge v5, p3, :cond_6

    aget v5, v4, v9

    add-int/lit8 v5, v5, 0x1

    aput v5, v4, v9

    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_6
    if-eq v1, v3, :cond_1

    aget v5, v4, v9

    if-ge v5, p3, :cond_1

    :goto_6
    if-ge v1, v3, :cond_7

    invoke-virtual {v2, v1, p2}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v5

    if-eqz v5, :cond_7

    aget v5, v4, v10

    if-ge v5, p3, :cond_7

    aget v5, v4, v10

    add-int/lit8 v5, v5, 0x1

    aput v5, v4, v10

    add-int/lit8 v1, v1, 0x1

    goto :goto_6

    :cond_7
    aget v2, v4, v10

    if-ge v2, p3, :cond_1

    aget v2, v4, v7

    aget v3, v4, v8

    add-int/2addr v2, v3

    const/4 v3, 0x2

    aget v3, v4, v3

    add-int/2addr v2, v3

    aget v3, v4, v9

    add-int/2addr v2, v3

    aget v3, v4, v10

    add-int/2addr v2, v3

    sub-int/2addr v2, p4

    invoke-static {v2}, Ljava/lang/Math;->abs(I)I

    move-result v2

    mul-int/lit8 v2, v2, 0x5

    if-ge v2, p4, :cond_1

    invoke-static {v4}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->foundPatternCross([I)Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-static {v4, v1}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->a([II)F

    move-result v0

    goto/16 :goto_1
.end method

.method private b()I
    .locals 7

    const/4 v6, 0x1

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-gt v0, v6, :cond_0

    move v0, v2

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    iget-object v1, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move-object v1, v0

    :cond_1
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->a()I

    move-result v4

    const/4 v5, 0x2

    if-lt v4, v5, :cond_1

    if-nez v1, :cond_2

    move-object v1, v0

    goto :goto_1

    :cond_2
    iput-boolean v6, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->e:Z

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getX()F

    move-result v2

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getX()F

    move-result v3

    sub-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Math;->abs(F)F

    move-result v2

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getY()F

    move-result v1

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getY()F

    move-result v0

    sub-float v0, v1, v0

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    sub-float v0, v2, v0

    float-to-int v0, v0

    div-int/lit8 v0, v0, 0x2

    goto :goto_0

    :cond_3
    move v0, v2

    goto :goto_0
.end method

.method private c()Z
    .locals 9

    const/4 v2, 0x0

    const/4 v4, 0x0

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v5

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    move v1, v2

    move v3, v4

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->a()I

    move-result v7

    const/4 v8, 0x2

    if-lt v7, v8, :cond_4

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v0

    add-float/2addr v0, v1

    move v1, v3

    :goto_1
    move v3, v1

    move v1, v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x3

    if-ge v3, v0, :cond_2

    :cond_1
    :goto_2
    return v4

    :cond_2
    int-to-float v0, v5

    div-float v3, v1, v0

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_3
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v0

    sub-float/2addr v0, v3

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    add-float/2addr v2, v0

    goto :goto_3

    :cond_3
    const v0, 0x3d4ccccd

    mul-float/2addr v0, v1

    cmpg-float v0, v2, v0

    if-gtz v0, :cond_1

    const/4 v4, 0x1

    goto :goto_2

    :cond_4
    move v0, v1

    move v1, v3

    goto :goto_1
.end method

.method private d()[Lcom/google/zxing/qrcode/detector/FinderPattern;
    .locals 10

    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v2, 0x0

    const/4 v4, 0x0

    const/4 v7, 0x3

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v5

    if-ge v5, v7, :cond_0

    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_0
    if-le v5, v7, :cond_2

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    move v1, v2

    move v3, v2

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v0

    add-float/2addr v3, v0

    mul-float/2addr v0, v0

    add-float/2addr v0, v1

    move v1, v0

    goto :goto_0

    :cond_1
    int-to-float v0, v5

    div-float/2addr v3, v0

    int-to-float v0, v5

    div-float v0, v1, v0

    mul-float v1, v3, v3

    sub-float/2addr v0, v1

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v0

    double-to-float v0, v0

    iget-object v1, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    new-instance v5, Lcom/google/zxing/qrcode/detector/d;

    invoke-direct {v5, v3, v4}, Lcom/google/zxing/qrcode/detector/d;-><init>(FB)V

    invoke-static {v1, v5}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    const v1, 0x3e4ccccd

    mul-float/2addr v1, v3

    invoke-static {v1, v0}, Ljava/lang/Math;->max(FF)F

    move-result v5

    move v1, v4

    :goto_1
    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_2

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-le v0, v7, :cond_2

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v0

    sub-float/2addr v0, v3

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    cmpl-float v0, v0, v5

    if-lez v0, :cond_5

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    add-int/lit8 v0, v1, -0x1

    :goto_2
    add-int/lit8 v1, v0, 0x1

    goto :goto_1

    :cond_2
    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-le v0, v7, :cond_4

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v0

    add-float/2addr v2, v0

    goto :goto_3

    :cond_3
    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    int-to-float v0, v0

    div-float v0, v2, v0

    iget-object v1, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    new-instance v2, Lcom/google/zxing/qrcode/detector/c;

    invoke-direct {v2, v0, v4}, Lcom/google/zxing/qrcode/detector/c;-><init>(FB)V

    invoke-static {v1, v2}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    iget-object v1, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    invoke-interface {v0, v7, v1}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    :cond_4
    new-array v1, v7, [Lcom/google/zxing/qrcode/detector/FinderPattern;

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    aput-object v0, v1, v4

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    aput-object v0, v1, v8

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    aput-object v0, v1, v9

    return-object v1

    :cond_5
    move v0, v1

    goto :goto_2
.end method

.method protected static foundPatternCross([I)Z
    .locals 6

    const/4 v1, 0x1

    const/4 v0, 0x0

    move v2, v0

    move v3, v0

    :goto_0
    const/4 v4, 0x5

    if-ge v2, v4, :cond_2

    aget v4, p0, v2

    if-nez v4, :cond_1

    :cond_0
    :goto_1
    return v0

    :cond_1
    add-int/2addr v3, v4

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_2
    const/4 v2, 0x7

    if-lt v3, v2, :cond_0

    shl-int/lit8 v2, v3, 0x8

    div-int/lit8 v2, v2, 0x7

    div-int/lit8 v3, v2, 0x2

    aget v4, p0, v0

    shl-int/lit8 v4, v4, 0x8

    sub-int v4, v2, v4

    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v4

    if-ge v4, v3, :cond_0

    aget v4, p0, v1

    shl-int/lit8 v4, v4, 0x8

    sub-int v4, v2, v4

    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v4

    if-ge v4, v3, :cond_0

    mul-int/lit8 v4, v2, 0x3

    const/4 v5, 0x2

    aget v5, p0, v5

    shl-int/lit8 v5, v5, 0x8

    sub-int/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v4

    mul-int/lit8 v5, v3, 0x3

    if-ge v4, v5, :cond_0

    const/4 v4, 0x3

    aget v4, p0, v4

    shl-int/lit8 v4, v4, 0x8

    sub-int v4, v2, v4

    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v4

    if-ge v4, v3, :cond_0

    const/4 v4, 0x4

    aget v4, p0, v4

    shl-int/lit8 v4, v4, 0x8

    sub-int/2addr v2, v4

    invoke-static {v2}, Ljava/lang/Math;->abs(I)I

    move-result v2

    if-ge v2, v3, :cond_0

    move v0, v1

    goto :goto_1
.end method


# virtual methods
.method final b(Ljava/util/Map;)Lcom/google/zxing/qrcode/detector/FinderPatternInfo;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Lcom/google/zxing/DecodeHintType;",
            "*>;)",
            "Lcom/google/zxing/qrcode/detector/FinderPatternInfo;"
        }
    .end annotation

    if-eqz p1, :cond_2

    sget-object v0, Lcom/google/zxing/DecodeHintType;->TRY_HARDER:Lcom/google/zxing/DecodeHintType;

    invoke-interface {p1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    const/4 v0, 0x1

    :goto_0
    iget-object v1, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->c:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v1}, Lcom/google/zxing/common/BitMatrix;->getHeight()I

    move-result v6

    iget-object v1, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->c:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v1}, Lcom/google/zxing/common/BitMatrix;->getWidth()I

    move-result v7

    mul-int/lit8 v1, v6, 0x3

    div-int/lit16 v1, v1, 0xe4

    const/4 v2, 0x3

    if-lt v1, v2, :cond_0

    if-eqz v0, :cond_16

    :cond_0
    const/4 v0, 0x3

    :goto_1
    const/4 v4, 0x0

    const/4 v1, 0x5

    new-array v8, v1, [I

    add-int/lit8 v3, v0, -0x1

    move v1, v0

    :goto_2
    if-ge v3, v6, :cond_e

    if-nez v4, :cond_e

    const/4 v0, 0x0

    const/4 v2, 0x0

    aput v2, v8, v0

    const/4 v0, 0x1

    const/4 v2, 0x0

    aput v2, v8, v0

    const/4 v0, 0x2

    const/4 v2, 0x0

    aput v2, v8, v0

    const/4 v0, 0x3

    const/4 v2, 0x0

    aput v2, v8, v0

    const/4 v0, 0x4

    const/4 v2, 0x0

    aput v2, v8, v0

    const/4 v0, 0x0

    const/4 v2, 0x0

    :goto_3
    if-ge v2, v7, :cond_c

    iget-object v5, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->c:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v5, v2, v3}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v5

    if-eqz v5, :cond_3

    and-int/lit8 v5, v0, 0x1

    const/4 v9, 0x1

    if-ne v5, v9, :cond_1

    add-int/lit8 v0, v0, 0x1

    :cond_1
    aget v5, v8, v0

    add-int/lit8 v5, v5, 0x1

    aput v5, v8, v0

    :goto_4
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    :cond_2
    const/4 v0, 0x0

    goto :goto_0

    :cond_3
    and-int/lit8 v5, v0, 0x1

    if-nez v5, :cond_b

    const/4 v5, 0x4

    if-ne v0, v5, :cond_a

    invoke-static {v8}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->foundPatternCross([I)Z

    move-result v0

    if-eqz v0, :cond_9

    invoke-virtual {p0, v8, v3, v2}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->handlePossibleCenter([III)Z

    move-result v0

    if-eqz v0, :cond_8

    const/4 v5, 0x2

    iget-boolean v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->e:Z

    if-eqz v0, :cond_4

    invoke-direct {p0}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->c()Z

    move-result v0

    :goto_5
    const/4 v1, 0x0

    const/4 v4, 0x0

    const/4 v9, 0x0

    aput v9, v8, v4

    const/4 v4, 0x1

    const/4 v9, 0x0

    aput v9, v8, v4

    const/4 v4, 0x2

    const/4 v9, 0x0

    aput v9, v8, v4

    const/4 v4, 0x3

    const/4 v9, 0x0

    aput v9, v8, v4

    const/4 v4, 0x4

    const/4 v9, 0x0

    aput v9, v8, v4

    move v4, v0

    move v0, v1

    move v1, v5

    goto :goto_4

    :cond_4
    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_7

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    move-object v1, v0

    :cond_5
    :goto_6
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->a()I

    move-result v10

    const/4 v11, 0x2

    if-lt v10, v11, :cond_5

    if-nez v1, :cond_6

    move-object v1, v0

    goto :goto_6

    :cond_6
    const/4 v9, 0x1

    iput-boolean v9, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->e:Z

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getX()F

    move-result v9

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getX()F

    move-result v10

    sub-float/2addr v9, v10

    invoke-static {v9}, Ljava/lang/Math;->abs(F)F

    move-result v9

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getY()F

    move-result v1

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getY()F

    move-result v0

    sub-float v0, v1, v0

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    sub-float v0, v9, v0

    float-to-int v0, v0

    div-int/lit8 v0, v0, 0x2

    :goto_7
    const/4 v1, 0x2

    aget v1, v8, v1

    if-le v0, v1, :cond_15

    const/4 v1, 0x2

    aget v1, v8, v1

    sub-int/2addr v0, v1

    add-int/lit8 v0, v0, -0x2

    add-int v1, v3, v0

    add-int/lit8 v0, v7, -0x1

    :goto_8
    move v2, v0

    move v3, v1

    move v0, v4

    goto :goto_5

    :cond_7
    const/4 v0, 0x0

    goto :goto_7

    :cond_8
    const/4 v0, 0x0

    const/4 v5, 0x2

    aget v5, v8, v5

    aput v5, v8, v0

    const/4 v0, 0x1

    const/4 v5, 0x3

    aget v5, v8, v5

    aput v5, v8, v0

    const/4 v0, 0x2

    const/4 v5, 0x4

    aget v5, v8, v5

    aput v5, v8, v0

    const/4 v0, 0x3

    const/4 v5, 0x1

    aput v5, v8, v0

    const/4 v0, 0x4

    const/4 v5, 0x0

    aput v5, v8, v0

    const/4 v0, 0x3

    goto/16 :goto_4

    :cond_9
    const/4 v0, 0x0

    const/4 v5, 0x2

    aget v5, v8, v5

    aput v5, v8, v0

    const/4 v0, 0x1

    const/4 v5, 0x3

    aget v5, v8, v5

    aput v5, v8, v0

    const/4 v0, 0x2

    const/4 v5, 0x4

    aget v5, v8, v5

    aput v5, v8, v0

    const/4 v0, 0x3

    const/4 v5, 0x1

    aput v5, v8, v0

    const/4 v0, 0x4

    const/4 v5, 0x0

    aput v5, v8, v0

    const/4 v0, 0x3

    goto/16 :goto_4

    :cond_a
    add-int/lit8 v0, v0, 0x1

    aget v5, v8, v0

    add-int/lit8 v5, v5, 0x1

    aput v5, v8, v0

    goto/16 :goto_4

    :cond_b
    aget v5, v8, v0

    add-int/lit8 v5, v5, 0x1

    aput v5, v8, v0

    goto/16 :goto_4

    :cond_c
    invoke-static {v8}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->foundPatternCross([I)Z

    move-result v0

    if-eqz v0, :cond_d

    invoke-virtual {p0, v8, v3, v7}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->handlePossibleCenter([III)Z

    move-result v0

    if-eqz v0, :cond_d

    const/4 v0, 0x0

    aget v1, v8, v0

    iget-boolean v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->e:Z

    if-eqz v0, :cond_d

    invoke-direct {p0}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->c()Z

    move-result v4

    :cond_d
    add-int/2addr v3, v1

    goto/16 :goto_2

    :cond_e
    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    const/4 v0, 0x3

    if-ge v3, v0, :cond_f

    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_f
    const/4 v0, 0x3

    if-le v3, v0, :cond_11

    const/4 v1, 0x0

    const/4 v0, 0x0

    iget-object v2, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    move v2, v1

    move v1, v0

    :goto_9
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_10

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v0

    add-float/2addr v2, v0

    mul-float/2addr v0, v0

    add-float/2addr v0, v1

    move v1, v0

    goto :goto_9

    :cond_10
    int-to-float v0, v3

    div-float/2addr v2, v0

    int-to-float v0, v3

    div-float v0, v1, v0

    mul-float v1, v2, v2

    sub-float/2addr v0, v1

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v0

    double-to-float v0, v0

    iget-object v1, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    new-instance v3, Lcom/google/zxing/qrcode/detector/d;

    const/4 v4, 0x0

    invoke-direct {v3, v2, v4}, Lcom/google/zxing/qrcode/detector/d;-><init>(FB)V

    invoke-static {v1, v3}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    const v1, 0x3e4ccccd

    mul-float/2addr v1, v2

    invoke-static {v1, v0}, Ljava/lang/Math;->max(FF)F

    move-result v3

    const/4 v1, 0x0

    :goto_a
    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_11

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v4, 0x3

    if-le v0, v4, :cond_11

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v0

    sub-float/2addr v0, v2

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    cmpl-float v0, v0, v3

    if-lez v0, :cond_14

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    add-int/lit8 v0, v1, -0x1

    :goto_b
    add-int/lit8 v1, v0, 0x1

    goto :goto_a

    :cond_11
    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x3

    if-le v0, v1, :cond_13

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move v1, v0

    :goto_c
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_12

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v0

    add-float/2addr v0, v1

    move v1, v0

    goto :goto_c

    :cond_12
    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    int-to-float v0, v0

    div-float v0, v1, v0

    iget-object v1, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    new-instance v2, Lcom/google/zxing/qrcode/detector/c;

    const/4 v3, 0x0

    invoke-direct {v2, v0, v3}, Lcom/google/zxing/qrcode/detector/c;-><init>(FB)V

    invoke-static {v1, v2}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    const/4 v1, 0x3

    iget-object v2, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-interface {v0, v1, v2}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    :cond_13
    const/4 v0, 0x3

    new-array v1, v0, [Lcom/google/zxing/qrcode/detector/FinderPattern;

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    const/4 v3, 0x0

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    aput-object v0, v1, v2

    const/4 v2, 0x1

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    const/4 v3, 0x1

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    aput-object v0, v1, v2

    const/4 v2, 0x2

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    const/4 v3, 0x2

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    aput-object v0, v1, v2

    invoke-static {v1}, Lcom/google/zxing/ResultPoint;->orderBestPatterns([Lcom/google/zxing/ResultPoint;)V

    new-instance v0, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;

    invoke-direct {v0, v1}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;-><init>([Lcom/google/zxing/qrcode/detector/FinderPattern;)V

    return-object v0

    :cond_14
    move v0, v1

    goto :goto_b

    :cond_15
    move v0, v2

    move v1, v3

    goto/16 :goto_8

    :cond_16
    move v0, v1

    goto/16 :goto_1
.end method

.method protected getImage()Lcom/google/zxing/common/BitMatrix;
    .locals 1

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->c:Lcom/google/zxing/common/BitMatrix;

    return-object v0
.end method

.method protected getPossibleCenters()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/google/zxing/qrcode/detector/FinderPattern;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    return-object v0
.end method

.method protected handlePossibleCenter([III)Z
    .locals 11

    const/4 v0, 0x0

    aget v0, p1, v0

    const/4 v1, 0x1

    aget v1, p1, v1

    add-int/2addr v0, v1

    const/4 v1, 0x2

    aget v1, p1, v1

    add-int/2addr v0, v1

    const/4 v1, 0x3

    aget v1, p1, v1

    add-int/2addr v0, v1

    const/4 v1, 0x4

    aget v1, p1, v1

    add-int v3, v0, v1

    invoke-static {p1, p3}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->a([II)F

    move-result v2

    float-to-int v1, v2

    const/4 v0, 0x2

    aget v4, p1, v0

    iget-object v5, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->c:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v5}, Lcom/google/zxing/common/BitMatrix;->getHeight()I

    move-result v6

    invoke-direct {p0}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->a()[I

    move-result-object v7

    move v0, p2

    :goto_0
    if-ltz v0, :cond_0

    invoke-virtual {v5, v1, v0}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v8

    if-eqz v8, :cond_0

    const/4 v8, 0x2

    aget v9, v7, v8

    add-int/lit8 v9, v9, 0x1

    aput v9, v7, v8

    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_0
    if-gez v0, :cond_1

    const/high16 v0, 0x7fc00000

    move v1, v0

    :goto_1
    invoke-static {v1}, Ljava/lang/Float;->isNaN(F)Z

    move-result v0

    if-nez v0, :cond_22

    float-to-int v2, v2

    float-to-int v4, v1

    const/4 v0, 0x2

    aget v5, p1, v0

    iget-object v6, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->c:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v6}, Lcom/google/zxing/common/BitMatrix;->getWidth()I

    move-result v7

    invoke-direct {p0}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->a()[I

    move-result-object v8

    move v0, v2

    :goto_2
    if-ltz v0, :cond_10

    invoke-virtual {v6, v0, v4}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v9

    if-eqz v9, :cond_10

    const/4 v9, 0x2

    aget v10, v8, v9

    add-int/lit8 v10, v10, 0x1

    aput v10, v8, v9

    add-int/lit8 v0, v0, -0x1

    goto :goto_2

    :cond_1
    :goto_3
    if-ltz v0, :cond_2

    invoke-virtual {v5, v1, v0}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v8

    if-nez v8, :cond_2

    const/4 v8, 0x1

    aget v8, v7, v8

    if-gt v8, v4, :cond_2

    const/4 v8, 0x1

    aget v9, v7, v8

    add-int/lit8 v9, v9, 0x1

    aput v9, v7, v8

    add-int/lit8 v0, v0, -0x1

    goto :goto_3

    :cond_2
    if-ltz v0, :cond_3

    const/4 v8, 0x1

    aget v8, v7, v8

    if-le v8, v4, :cond_4

    :cond_3
    const/high16 v0, 0x7fc00000

    move v1, v0

    goto :goto_1

    :cond_4
    :goto_4
    if-ltz v0, :cond_5

    invoke-virtual {v5, v1, v0}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v8

    if-eqz v8, :cond_5

    const/4 v8, 0x0

    aget v8, v7, v8

    if-gt v8, v4, :cond_5

    const/4 v8, 0x0

    aget v9, v7, v8

    add-int/lit8 v9, v9, 0x1

    aput v9, v7, v8

    add-int/lit8 v0, v0, -0x1

    goto :goto_4

    :cond_5
    const/4 v0, 0x0

    aget v0, v7, v0

    if-le v0, v4, :cond_6

    const/high16 v0, 0x7fc00000

    move v1, v0

    goto :goto_1

    :cond_6
    add-int/lit8 v0, p2, 0x1

    :goto_5
    if-ge v0, v6, :cond_7

    invoke-virtual {v5, v1, v0}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v8

    if-eqz v8, :cond_7

    const/4 v8, 0x2

    aget v9, v7, v8

    add-int/lit8 v9, v9, 0x1

    aput v9, v7, v8

    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    :cond_7
    if-ne v0, v6, :cond_8

    const/high16 v0, 0x7fc00000

    move v1, v0

    goto/16 :goto_1

    :cond_8
    :goto_6
    if-ge v0, v6, :cond_9

    invoke-virtual {v5, v1, v0}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v8

    if-nez v8, :cond_9

    const/4 v8, 0x3

    aget v8, v7, v8

    if-ge v8, v4, :cond_9

    const/4 v8, 0x3

    aget v9, v7, v8

    add-int/lit8 v9, v9, 0x1

    aput v9, v7, v8

    add-int/lit8 v0, v0, 0x1

    goto :goto_6

    :cond_9
    if-eq v0, v6, :cond_a

    const/4 v8, 0x3

    aget v8, v7, v8

    if-lt v8, v4, :cond_b

    :cond_a
    const/high16 v0, 0x7fc00000

    move v1, v0

    goto/16 :goto_1

    :cond_b
    :goto_7
    if-ge v0, v6, :cond_c

    invoke-virtual {v5, v1, v0}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v8

    if-eqz v8, :cond_c

    const/4 v8, 0x4

    aget v8, v7, v8

    if-ge v8, v4, :cond_c

    const/4 v8, 0x4

    aget v9, v7, v8

    add-int/lit8 v9, v9, 0x1

    aput v9, v7, v8

    add-int/lit8 v0, v0, 0x1

    goto :goto_7

    :cond_c
    const/4 v1, 0x4

    aget v1, v7, v1

    if-lt v1, v4, :cond_d

    const/high16 v0, 0x7fc00000

    move v1, v0

    goto/16 :goto_1

    :cond_d
    const/4 v1, 0x0

    aget v1, v7, v1

    const/4 v4, 0x1

    aget v4, v7, v4

    add-int/2addr v1, v4

    const/4 v4, 0x2

    aget v4, v7, v4

    add-int/2addr v1, v4

    const/4 v4, 0x3

    aget v4, v7, v4

    add-int/2addr v1, v4

    const/4 v4, 0x4

    aget v4, v7, v4

    add-int/2addr v1, v4

    sub-int/2addr v1, v3

    invoke-static {v1}, Ljava/lang/Math;->abs(I)I

    move-result v1

    mul-int/lit8 v1, v1, 0x5

    mul-int/lit8 v4, v3, 0x2

    if-lt v1, v4, :cond_e

    const/high16 v0, 0x7fc00000

    move v1, v0

    goto/16 :goto_1

    :cond_e
    invoke-static {v7}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->foundPatternCross([I)Z

    move-result v1

    if-eqz v1, :cond_f

    invoke-static {v7, v0}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->a([II)F

    move-result v0

    move v1, v0

    goto/16 :goto_1

    :cond_f
    const/high16 v0, 0x7fc00000

    move v1, v0

    goto/16 :goto_1

    :cond_10
    if-gez v0, :cond_12

    const/high16 v0, 0x7fc00000

    move v2, v0

    :goto_8
    invoke-static {v2}, Ljava/lang/Float;->isNaN(F)Z

    move-result v0

    if-nez v0, :cond_22

    int-to-float v0, v3

    const/high16 v3, 0x40e00000

    div-float v5, v0, v3

    const/4 v4, 0x0

    const/4 v0, 0x0

    move v3, v0

    :goto_9
    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v3, v0, :cond_23

    iget-object v0, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    invoke-virtual {v0, v5, v1, v2}, Lcom/google/zxing/qrcode/detector/FinderPattern;->a(FFF)Z

    move-result v6

    if-eqz v6, :cond_21

    iget-object v4, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-virtual {v0, v1, v2, v5}, Lcom/google/zxing/qrcode/detector/FinderPattern;->b(FFF)Lcom/google/zxing/qrcode/detector/FinderPattern;

    move-result-object v0

    invoke-interface {v4, v3, v0}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    const/4 v0, 0x1

    :goto_a
    if-nez v0, :cond_11

    new-instance v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    invoke-direct {v0, v2, v1, v5}, Lcom/google/zxing/qrcode/detector/FinderPattern;-><init>(FFF)V

    iget-object v1, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->d:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v1, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->g:Lcom/google/zxing/ResultPointCallback;

    if-eqz v1, :cond_11

    iget-object v1, p0, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->g:Lcom/google/zxing/ResultPointCallback;

    invoke-interface {v1, v0}, Lcom/google/zxing/ResultPointCallback;->foundPossibleResultPoint(Lcom/google/zxing/ResultPoint;)V

    :cond_11
    const/4 v0, 0x1

    :goto_b
    return v0

    :cond_12
    :goto_c
    if-ltz v0, :cond_13

    invoke-virtual {v6, v0, v4}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v9

    if-nez v9, :cond_13

    const/4 v9, 0x1

    aget v9, v8, v9

    if-gt v9, v5, :cond_13

    const/4 v9, 0x1

    aget v10, v8, v9

    add-int/lit8 v10, v10, 0x1

    aput v10, v8, v9

    add-int/lit8 v0, v0, -0x1

    goto :goto_c

    :cond_13
    if-ltz v0, :cond_14

    const/4 v9, 0x1

    aget v9, v8, v9

    if-le v9, v5, :cond_15

    :cond_14
    const/high16 v0, 0x7fc00000

    move v2, v0

    goto :goto_8

    :cond_15
    :goto_d
    if-ltz v0, :cond_16

    invoke-virtual {v6, v0, v4}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v9

    if-eqz v9, :cond_16

    const/4 v9, 0x0

    aget v9, v8, v9

    if-gt v9, v5, :cond_16

    const/4 v9, 0x0

    aget v10, v8, v9

    add-int/lit8 v10, v10, 0x1

    aput v10, v8, v9

    add-int/lit8 v0, v0, -0x1

    goto :goto_d

    :cond_16
    const/4 v0, 0x0

    aget v0, v8, v0

    if-le v0, v5, :cond_17

    const/high16 v0, 0x7fc00000

    move v2, v0

    goto/16 :goto_8

    :cond_17
    add-int/lit8 v0, v2, 0x1

    :goto_e
    if-ge v0, v7, :cond_18

    invoke-virtual {v6, v0, v4}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v2

    if-eqz v2, :cond_18

    const/4 v2, 0x2

    aget v9, v8, v2

    add-int/lit8 v9, v9, 0x1

    aput v9, v8, v2

    add-int/lit8 v0, v0, 0x1

    goto :goto_e

    :cond_18
    if-ne v0, v7, :cond_19

    const/high16 v0, 0x7fc00000

    move v2, v0

    goto/16 :goto_8

    :cond_19
    :goto_f
    if-ge v0, v7, :cond_1a

    invoke-virtual {v6, v0, v4}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v2

    if-nez v2, :cond_1a

    const/4 v2, 0x3

    aget v2, v8, v2

    if-ge v2, v5, :cond_1a

    const/4 v2, 0x3

    aget v9, v8, v2

    add-int/lit8 v9, v9, 0x1

    aput v9, v8, v2

    add-int/lit8 v0, v0, 0x1

    goto :goto_f

    :cond_1a
    if-eq v0, v7, :cond_1b

    const/4 v2, 0x3

    aget v2, v8, v2

    if-lt v2, v5, :cond_1c

    :cond_1b
    const/high16 v0, 0x7fc00000

    move v2, v0

    goto/16 :goto_8

    :cond_1c
    :goto_10
    if-ge v0, v7, :cond_1d

    invoke-virtual {v6, v0, v4}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v2

    if-eqz v2, :cond_1d

    const/4 v2, 0x4

    aget v2, v8, v2

    if-ge v2, v5, :cond_1d

    const/4 v2, 0x4

    aget v9, v8, v2

    add-int/lit8 v9, v9, 0x1

    aput v9, v8, v2

    add-int/lit8 v0, v0, 0x1

    goto :goto_10

    :cond_1d
    const/4 v2, 0x4

    aget v2, v8, v2

    if-lt v2, v5, :cond_1e

    const/high16 v0, 0x7fc00000

    move v2, v0

    goto/16 :goto_8

    :cond_1e
    const/4 v2, 0x0

    aget v2, v8, v2

    const/4 v4, 0x1

    aget v4, v8, v4

    add-int/2addr v2, v4

    const/4 v4, 0x2

    aget v4, v8, v4

    add-int/2addr v2, v4

    const/4 v4, 0x3

    aget v4, v8, v4

    add-int/2addr v2, v4

    const/4 v4, 0x4

    aget v4, v8, v4

    add-int/2addr v2, v4

    sub-int/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Math;->abs(I)I

    move-result v2

    mul-int/lit8 v2, v2, 0x5

    if-lt v2, v3, :cond_1f

    const/high16 v0, 0x7fc00000

    move v2, v0

    goto/16 :goto_8

    :cond_1f
    invoke-static {v8}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->foundPatternCross([I)Z

    move-result v2

    if-eqz v2, :cond_20

    invoke-static {v8, v0}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;->a([II)F

    move-result v0

    move v2, v0

    goto/16 :goto_8

    :cond_20
    const/high16 v0, 0x7fc00000

    move v2, v0

    goto/16 :goto_8

    :cond_21
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto/16 :goto_9

    :cond_22
    const/4 v0, 0x0

    goto/16 :goto_b

    :cond_23
    move v0, v4

    goto/16 :goto_a
.end method
