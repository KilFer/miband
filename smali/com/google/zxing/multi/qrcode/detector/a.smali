.class final Lcom/google/zxing/multi/qrcode/detector/a;
.super Lcom/google/zxing/qrcode/detector/FinderPatternFinder;


# static fields
.field private static final a:[Lcom/google/zxing/qrcode/detector/FinderPatternInfo;

.field private static final b:F = 180.0f

.field private static final c:F = 9.0f

.field private static final d:F = 0.05f

.field private static final e:F = 0.5f


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    new-array v0, v0, [Lcom/google/zxing/qrcode/detector/FinderPatternInfo;

    sput-object v0, Lcom/google/zxing/multi/qrcode/detector/a;->a:[Lcom/google/zxing/qrcode/detector/FinderPatternInfo;

    return-void
.end method

.method private constructor <init>(Lcom/google/zxing/common/BitMatrix;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;-><init>(Lcom/google/zxing/common/BitMatrix;)V

    return-void
.end method

.method constructor <init>(Lcom/google/zxing/common/BitMatrix;Lcom/google/zxing/ResultPointCallback;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/google/zxing/qrcode/detector/FinderPatternFinder;-><init>(Lcom/google/zxing/common/BitMatrix;Lcom/google/zxing/ResultPointCallback;)V

    return-void
.end method

.method private a()[[Lcom/google/zxing/qrcode/detector/FinderPattern;
    .locals 15

    invoke-virtual {p0}, Lcom/google/zxing/multi/qrcode/detector/a;->getPossibleCenters()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v7

    const/4 v0, 0x3

    if-ge v7, v0, :cond_0

    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_0
    const/4 v0, 0x3

    if-ne v7, v0, :cond_1

    const/4 v0, 0x1

    new-array v1, v0, [[Lcom/google/zxing/qrcode/detector/FinderPattern;

    const/4 v2, 0x0

    const/4 v0, 0x3

    new-array v3, v0, [Lcom/google/zxing/qrcode/detector/FinderPattern;

    const/4 v4, 0x0

    const/4 v0, 0x0

    invoke-interface {v6, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    aput-object v0, v3, v4

    const/4 v4, 0x1

    const/4 v0, 0x1

    invoke-interface {v6, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    aput-object v0, v3, v4

    const/4 v4, 0x2

    const/4 v0, 0x2

    invoke-interface {v6, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    aput-object v0, v3, v4

    aput-object v3, v1, v2

    move-object v0, v1

    :goto_0
    return-object v0

    :cond_1
    new-instance v0, Lcom/google/zxing/multi/qrcode/detector/c;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/google/zxing/multi/qrcode/detector/c;-><init>(B)V

    invoke-static {v6, v0}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    const/4 v0, 0x0

    move v5, v0

    :goto_1
    add-int/lit8 v0, v7, -0x2

    if-ge v5, v0, :cond_7

    invoke-interface {v6, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/zxing/qrcode/detector/FinderPattern;

    if-eqz v0, :cond_6

    add-int/lit8 v1, v5, 0x1

    move v4, v1

    :goto_2
    add-int/lit8 v1, v7, -0x1

    if-ge v4, v1, :cond_6

    invoke-interface {v6, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/zxing/qrcode/detector/FinderPattern;

    if-eqz v1, :cond_5

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v2

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v3

    sub-float/2addr v2, v3

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v3

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v9

    invoke-static {v3, v9}, Ljava/lang/Math;->min(FF)F

    move-result v3

    div-float/2addr v2, v3

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v3

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v9

    sub-float/2addr v3, v9

    invoke-static {v3}, Ljava/lang/Math;->abs(F)F

    move-result v3

    const/high16 v9, 0x3f000000

    cmpl-float v3, v3, v9

    if-lez v3, :cond_2

    const v3, 0x3d4ccccd

    cmpl-float v2, v2, v3

    if-gez v2, :cond_6

    :cond_2
    add-int/lit8 v2, v4, 0x1

    move v3, v2

    :goto_3
    if-ge v3, v7, :cond_5

    invoke-interface {v6, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/zxing/qrcode/detector/FinderPattern;

    if-eqz v2, :cond_4

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v9

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v10

    sub-float/2addr v9, v10

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v10

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v11

    invoke-static {v10, v11}, Ljava/lang/Math;->min(FF)F

    move-result v10

    div-float/2addr v9, v10

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v10

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v11

    sub-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Math;->abs(F)F

    move-result v10

    const/high16 v11, 0x3f000000

    cmpl-float v10, v10, v11

    if-lez v10, :cond_3

    const v10, 0x3d4ccccd

    cmpl-float v9, v9, v10

    if-gez v9, :cond_5

    :cond_3
    const/4 v9, 0x3

    new-array v9, v9, [Lcom/google/zxing/qrcode/detector/FinderPattern;

    const/4 v10, 0x0

    aput-object v0, v9, v10

    const/4 v10, 0x1

    aput-object v1, v9, v10

    const/4 v10, 0x2

    aput-object v2, v9, v10

    invoke-static {v9}, Lcom/google/zxing/ResultPoint;->orderBestPatterns([Lcom/google/zxing/ResultPoint;)V

    new-instance v2, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;

    invoke-direct {v2, v9}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;-><init>([Lcom/google/zxing/qrcode/detector/FinderPattern;)V

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;->getTopLeft()Lcom/google/zxing/qrcode/detector/FinderPattern;

    move-result-object v10

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;->getBottomLeft()Lcom/google/zxing/qrcode/detector/FinderPattern;

    move-result-object v11

    invoke-static {v10, v11}, Lcom/google/zxing/ResultPoint;->distance(Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)F

    move-result v10

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;->getTopRight()Lcom/google/zxing/qrcode/detector/FinderPattern;

    move-result-object v11

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;->getBottomLeft()Lcom/google/zxing/qrcode/detector/FinderPattern;

    move-result-object v12

    invoke-static {v11, v12}, Lcom/google/zxing/ResultPoint;->distance(Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)F

    move-result v11

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;->getTopLeft()Lcom/google/zxing/qrcode/detector/FinderPattern;

    move-result-object v12

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;->getTopRight()Lcom/google/zxing/qrcode/detector/FinderPattern;

    move-result-object v2

    invoke-static {v12, v2}, Lcom/google/zxing/ResultPoint;->distance(Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)F

    move-result v2

    add-float v12, v10, v2

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v13

    const/high16 v14, 0x40000000

    mul-float/2addr v13, v14

    div-float/2addr v12, v13

    const/high16 v13, 0x43340000

    cmpl-float v13, v12, v13

    if-gtz v13, :cond_4

    const/high16 v13, 0x41100000

    cmpg-float v12, v12, v13

    if-ltz v12, :cond_4

    sub-float v12, v10, v2

    invoke-static {v10, v2}, Ljava/lang/Math;->min(FF)F

    move-result v13

    div-float/2addr v12, v13

    invoke-static {v12}, Ljava/lang/Math;->abs(F)F

    move-result v12

    const v13, 0x3dcccccd

    cmpl-float v12, v12, v13

    if-gez v12, :cond_4

    mul-float/2addr v10, v10

    mul-float/2addr v2, v2

    add-float/2addr v2, v10

    float-to-double v12, v2

    invoke-static {v12, v13}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v12

    double-to-float v2, v12

    sub-float v10, v11, v2

    invoke-static {v11, v2}, Ljava/lang/Math;->min(FF)F

    move-result v2

    div-float v2, v10, v2

    invoke-static {v2}, Ljava/lang/Math;->abs(F)F

    move-result v2

    const v10, 0x3dcccccd

    cmpl-float v2, v2, v10

    if-gez v2, :cond_4

    invoke-interface {v8, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_4
    add-int/lit8 v2, v3, 0x1

    move v3, v2

    goto/16 :goto_3

    :cond_5
    add-int/lit8 v1, v4, 0x1

    move v4, v1

    goto/16 :goto_2

    :cond_6
    add-int/lit8 v0, v5, 0x1

    move v5, v0

    goto/16 :goto_1

    :cond_7
    invoke-interface {v8}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_8

    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v0

    new-array v0, v0, [[Lcom/google/zxing/qrcode/detector/FinderPattern;

    invoke-interface {v8, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[Lcom/google/zxing/qrcode/detector/FinderPattern;

    goto/16 :goto_0

    :cond_8
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0
.end method


# virtual methods
.method public final a(Ljava/util/Map;)[Lcom/google/zxing/qrcode/detector/FinderPatternInfo;
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Lcom/google/zxing/DecodeHintType;",
            "*>;)[",
            "Lcom/google/zxing/qrcode/detector/FinderPatternInfo;"
        }
    .end annotation

    if-eqz p1, :cond_2

    sget-object v1, Lcom/google/zxing/DecodeHintType;->TRY_HARDER:Lcom/google/zxing/DecodeHintType;

    move-object/from16 v0, p1

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    const/4 v1, 0x1

    :goto_0
    invoke-virtual/range {p0 .. p0}, Lcom/google/zxing/multi/qrcode/detector/a;->getImage()Lcom/google/zxing/common/BitMatrix;

    move-result-object v5

    invoke-virtual {v5}, Lcom/google/zxing/common/BitMatrix;->getHeight()I

    move-result v6

    invoke-virtual {v5}, Lcom/google/zxing/common/BitMatrix;->getWidth()I

    move-result v7

    int-to-float v2, v6

    const/high16 v3, 0x43640000

    div-float/2addr v2, v3

    const/high16 v3, 0x40400000

    mul-float/2addr v2, v3

    float-to-int v2, v2

    const/4 v3, 0x3

    if-lt v2, v3, :cond_0

    if-eqz v1, :cond_18

    :cond_0
    const/4 v1, 0x3

    :goto_1
    const/4 v2, 0x5

    new-array v8, v2, [I

    add-int/lit8 v2, v1, -0x1

    move v4, v2

    :goto_2
    if-ge v4, v6, :cond_b

    const/4 v2, 0x0

    const/4 v3, 0x0

    aput v3, v8, v2

    const/4 v2, 0x1

    const/4 v3, 0x0

    aput v3, v8, v2

    const/4 v2, 0x2

    const/4 v3, 0x0

    aput v3, v8, v2

    const/4 v2, 0x3

    const/4 v3, 0x0

    aput v3, v8, v2

    const/4 v2, 0x4

    const/4 v3, 0x0

    aput v3, v8, v2

    const/4 v2, 0x0

    const/4 v3, 0x0

    :goto_3
    if-ge v3, v7, :cond_9

    invoke-virtual {v5, v3, v4}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v9

    if-eqz v9, :cond_3

    and-int/lit8 v9, v2, 0x1

    const/4 v10, 0x1

    if-ne v9, v10, :cond_1

    add-int/lit8 v2, v2, 0x1

    :cond_1
    aget v9, v8, v2

    add-int/lit8 v9, v9, 0x1

    aput v9, v8, v2

    :goto_4
    add-int/lit8 v3, v3, 0x1

    goto :goto_3

    :cond_2
    const/4 v1, 0x0

    goto :goto_0

    :cond_3
    and-int/lit8 v9, v2, 0x1

    if-nez v9, :cond_8

    const/4 v9, 0x4

    if-ne v2, v9, :cond_7

    invoke-static {v8}, Lcom/google/zxing/multi/qrcode/detector/a;->foundPatternCross([I)Z

    move-result v2

    if-eqz v2, :cond_6

    move-object/from16 v0, p0

    invoke-virtual {v0, v8, v4, v3}, Lcom/google/zxing/multi/qrcode/detector/a;->handlePossibleCenter([III)Z

    move-result v2

    if-nez v2, :cond_17

    :cond_4
    add-int/lit8 v3, v3, 0x1

    if-ge v3, v7, :cond_5

    invoke-virtual {v5, v3, v4}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v2

    if-eqz v2, :cond_4

    :cond_5
    add-int/lit8 v2, v3, -0x1

    :goto_5
    const/4 v3, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    aput v10, v8, v9

    const/4 v9, 0x1

    const/4 v10, 0x0

    aput v10, v8, v9

    const/4 v9, 0x2

    const/4 v10, 0x0

    aput v10, v8, v9

    const/4 v9, 0x3

    const/4 v10, 0x0

    aput v10, v8, v9

    const/4 v9, 0x4

    const/4 v10, 0x0

    aput v10, v8, v9

    move/from16 v16, v2

    move v2, v3

    move/from16 v3, v16

    goto :goto_4

    :cond_6
    const/4 v2, 0x0

    const/4 v9, 0x2

    aget v9, v8, v9

    aput v9, v8, v2

    const/4 v2, 0x1

    const/4 v9, 0x3

    aget v9, v8, v9

    aput v9, v8, v2

    const/4 v2, 0x2

    const/4 v9, 0x4

    aget v9, v8, v9

    aput v9, v8, v2

    const/4 v2, 0x3

    const/4 v9, 0x1

    aput v9, v8, v2

    const/4 v2, 0x4

    const/4 v9, 0x0

    aput v9, v8, v2

    const/4 v2, 0x3

    goto :goto_4

    :cond_7
    add-int/lit8 v2, v2, 0x1

    aget v9, v8, v2

    add-int/lit8 v9, v9, 0x1

    aput v9, v8, v2

    goto :goto_4

    :cond_8
    aget v9, v8, v2

    add-int/lit8 v9, v9, 0x1

    aput v9, v8, v2

    goto :goto_4

    :cond_9
    invoke-static {v8}, Lcom/google/zxing/multi/qrcode/detector/a;->foundPatternCross([I)Z

    move-result v2

    if-eqz v2, :cond_a

    move-object/from16 v0, p0

    invoke-virtual {v0, v8, v4, v7}, Lcom/google/zxing/multi/qrcode/detector/a;->handlePossibleCenter([III)Z

    :cond_a
    add-int v2, v4, v1

    move v4, v2

    goto/16 :goto_2

    :cond_b
    invoke-virtual/range {p0 .. p0}, Lcom/google/zxing/multi/qrcode/detector/a;->getPossibleCenters()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v8

    const/4 v1, 0x3

    if-ge v8, v1, :cond_c

    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v1

    throw v1

    :cond_c
    const/4 v1, 0x3

    if-ne v8, v1, :cond_d

    const/4 v1, 0x1

    new-array v2, v1, [[Lcom/google/zxing/qrcode/detector/FinderPattern;

    const/4 v3, 0x0

    const/4 v1, 0x3

    new-array v4, v1, [Lcom/google/zxing/qrcode/detector/FinderPattern;

    const/4 v5, 0x0

    const/4 v1, 0x0

    invoke-interface {v7, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/zxing/qrcode/detector/FinderPattern;

    aput-object v1, v4, v5

    const/4 v5, 0x1

    const/4 v1, 0x1

    invoke-interface {v7, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/zxing/qrcode/detector/FinderPattern;

    aput-object v1, v4, v5

    const/4 v5, 0x2

    const/4 v1, 0x2

    invoke-interface {v7, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/zxing/qrcode/detector/FinderPattern;

    aput-object v1, v4, v5

    aput-object v4, v2, v3

    move-object v1, v2

    :goto_6
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    array-length v4, v1

    const/4 v2, 0x0

    :goto_7
    if-ge v2, v4, :cond_15

    aget-object v5, v1, v2

    invoke-static {v5}, Lcom/google/zxing/ResultPoint;->orderBestPatterns([Lcom/google/zxing/ResultPoint;)V

    new-instance v6, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;

    invoke-direct {v6, v5}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;-><init>([Lcom/google/zxing/qrcode/detector/FinderPattern;)V

    invoke-interface {v3, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_7

    :cond_d
    new-instance v1, Lcom/google/zxing/multi/qrcode/detector/c;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Lcom/google/zxing/multi/qrcode/detector/c;-><init>(B)V

    invoke-static {v7, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    const/4 v1, 0x0

    move v4, v1

    :goto_8
    add-int/lit8 v1, v8, -0x2

    if-ge v4, v1, :cond_13

    invoke-interface {v7, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    move-object v3, v1

    check-cast v3, Lcom/google/zxing/qrcode/detector/FinderPattern;

    if-eqz v3, :cond_12

    add-int/lit8 v1, v4, 0x1

    move v6, v1

    :goto_9
    add-int/lit8 v1, v8, -0x1

    if-ge v6, v1, :cond_12

    invoke-interface {v7, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/zxing/qrcode/detector/FinderPattern;

    if-eqz v1, :cond_11

    invoke-virtual {v3}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v2

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v5

    sub-float/2addr v2, v5

    invoke-virtual {v3}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v5

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v10

    invoke-static {v5, v10}, Ljava/lang/Math;->min(FF)F

    move-result v5

    div-float/2addr v2, v5

    invoke-virtual {v3}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v5

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v10

    sub-float/2addr v5, v10

    invoke-static {v5}, Ljava/lang/Math;->abs(F)F

    move-result v5

    const/high16 v10, 0x3f000000

    cmpl-float v5, v5, v10

    if-lez v5, :cond_e

    const v5, 0x3d4ccccd

    cmpl-float v2, v2, v5

    if-gez v2, :cond_12

    :cond_e
    add-int/lit8 v2, v6, 0x1

    move v5, v2

    :goto_a
    if-ge v5, v8, :cond_11

    invoke-interface {v7, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/zxing/qrcode/detector/FinderPattern;

    if-eqz v2, :cond_10

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v10

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v11

    sub-float/2addr v10, v11

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v11

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v12

    invoke-static {v11, v12}, Ljava/lang/Math;->min(FF)F

    move-result v11

    div-float/2addr v10, v11

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v11

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v12

    sub-float/2addr v11, v12

    invoke-static {v11}, Ljava/lang/Math;->abs(F)F

    move-result v11

    const/high16 v12, 0x3f000000

    cmpl-float v11, v11, v12

    if-lez v11, :cond_f

    const v11, 0x3d4ccccd

    cmpl-float v10, v10, v11

    if-gez v10, :cond_11

    :cond_f
    const/4 v10, 0x3

    new-array v10, v10, [Lcom/google/zxing/qrcode/detector/FinderPattern;

    const/4 v11, 0x0

    aput-object v3, v10, v11

    const/4 v11, 0x1

    aput-object v1, v10, v11

    const/4 v11, 0x2

    aput-object v2, v10, v11

    invoke-static {v10}, Lcom/google/zxing/ResultPoint;->orderBestPatterns([Lcom/google/zxing/ResultPoint;)V

    new-instance v2, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;

    invoke-direct {v2, v10}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;-><init>([Lcom/google/zxing/qrcode/detector/FinderPattern;)V

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;->getTopLeft()Lcom/google/zxing/qrcode/detector/FinderPattern;

    move-result-object v11

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;->getBottomLeft()Lcom/google/zxing/qrcode/detector/FinderPattern;

    move-result-object v12

    invoke-static {v11, v12}, Lcom/google/zxing/ResultPoint;->distance(Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)F

    move-result v11

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;->getTopRight()Lcom/google/zxing/qrcode/detector/FinderPattern;

    move-result-object v12

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;->getBottomLeft()Lcom/google/zxing/qrcode/detector/FinderPattern;

    move-result-object v13

    invoke-static {v12, v13}, Lcom/google/zxing/ResultPoint;->distance(Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)F

    move-result v12

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;->getTopLeft()Lcom/google/zxing/qrcode/detector/FinderPattern;

    move-result-object v13

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/detector/FinderPatternInfo;->getTopRight()Lcom/google/zxing/qrcode/detector/FinderPattern;

    move-result-object v2

    invoke-static {v13, v2}, Lcom/google/zxing/ResultPoint;->distance(Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)F

    move-result v2

    add-float v13, v11, v2

    invoke-virtual {v3}, Lcom/google/zxing/qrcode/detector/FinderPattern;->getEstimatedModuleSize()F

    move-result v14

    const/high16 v15, 0x40000000

    mul-float/2addr v14, v15

    div-float/2addr v13, v14

    const/high16 v14, 0x43340000

    cmpl-float v14, v13, v14

    if-gtz v14, :cond_10

    const/high16 v14, 0x41100000

    cmpg-float v13, v13, v14

    if-ltz v13, :cond_10

    sub-float v13, v11, v2

    invoke-static {v11, v2}, Ljava/lang/Math;->min(FF)F

    move-result v14

    div-float/2addr v13, v14

    invoke-static {v13}, Ljava/lang/Math;->abs(F)F

    move-result v13

    const v14, 0x3dcccccd

    cmpl-float v13, v13, v14

    if-gez v13, :cond_10

    mul-float/2addr v11, v11

    mul-float/2addr v2, v2

    add-float/2addr v2, v11

    float-to-double v13, v2

    invoke-static {v13, v14}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v13

    double-to-float v2, v13

    sub-float v11, v12, v2

    invoke-static {v12, v2}, Ljava/lang/Math;->min(FF)F

    move-result v2

    div-float v2, v11, v2

    invoke-static {v2}, Ljava/lang/Math;->abs(F)F

    move-result v2

    const v11, 0x3dcccccd

    cmpl-float v2, v2, v11

    if-gez v2, :cond_10

    invoke-interface {v9, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_10
    add-int/lit8 v2, v5, 0x1

    move v5, v2

    goto/16 :goto_a

    :cond_11
    add-int/lit8 v1, v6, 0x1

    move v6, v1

    goto/16 :goto_9

    :cond_12
    add-int/lit8 v1, v4, 0x1

    move v4, v1

    goto/16 :goto_8

    :cond_13
    invoke-interface {v9}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_14

    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v1

    new-array v1, v1, [[Lcom/google/zxing/qrcode/detector/FinderPattern;

    invoke-interface {v9, v1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [[Lcom/google/zxing/qrcode/detector/FinderPattern;

    goto/16 :goto_6

    :cond_14
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v1

    throw v1

    :cond_15
    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_16

    sget-object v1, Lcom/google/zxing/multi/qrcode/detector/a;->a:[Lcom/google/zxing/qrcode/detector/FinderPatternInfo;

    :goto_b
    return-object v1

    :cond_16
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v1

    new-array v1, v1, [Lcom/google/zxing/qrcode/detector/FinderPatternInfo;

    invoke-interface {v3, v1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lcom/google/zxing/qrcode/detector/FinderPatternInfo;

    goto :goto_b

    :cond_17
    move v2, v3

    goto/16 :goto_5

    :cond_18
    move v1, v2

    goto/16 :goto_1
.end method
