.class public final Lcom/google/zxing/aztec/detector/Detector;
.super Ljava/lang/Object;


# instance fields
.field private final a:Lcom/google/zxing/common/BitMatrix;

.field private b:Z

.field private c:I

.field private d:I

.field private e:I

.field private f:I


# direct methods
.method public constructor <init>(Lcom/google/zxing/common/BitMatrix;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/zxing/aztec/detector/Detector;->a:Lcom/google/zxing/common/BitMatrix;

    return-void
.end method

.method private static a(F)I
    .locals 1

    const/high16 v0, 0x3f000000

    add-float/2addr v0, p0

    float-to-int v0, v0

    return v0
.end method

.method private a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)I
    .locals 12

    invoke-static {p1, p2}, Lcom/google/zxing/aztec/detector/Detector;->b(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)F

    move-result v4

    iget v0, p2, Lcom/google/zxing/aztec/detector/a;->a:I

    iget v1, p1, Lcom/google/zxing/aztec/detector/a;->a:I

    sub-int/2addr v0, v1

    int-to-float v0, v0

    div-float v5, v0, v4

    iget v0, p2, Lcom/google/zxing/aztec/detector/a;->b:I

    iget v1, p1, Lcom/google/zxing/aztec/detector/a;->b:I

    sub-int/2addr v0, v1

    int-to-float v0, v0

    div-float v6, v0, v4

    const/4 v3, 0x0

    iget v0, p1, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v2, v0

    iget v0, p1, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v1, v0

    iget-object v0, p0, Lcom/google/zxing/aztec/detector/Detector;->a:Lcom/google/zxing/common/BitMatrix;

    iget v7, p1, Lcom/google/zxing/aztec/detector/a;->a:I

    iget v8, p1, Lcom/google/zxing/aztec/detector/a;->b:I

    invoke-virtual {v0, v7, v8}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v7

    const/4 v0, 0x0

    move v11, v0

    move v0, v3

    move v3, v2

    move v2, v1

    move v1, v11

    :goto_0
    int-to-float v8, v1

    cmpg-float v8, v8, v4

    if-gez v8, :cond_1

    add-float/2addr v3, v5

    add-float/2addr v2, v6

    iget-object v8, p0, Lcom/google/zxing/aztec/detector/Detector;->a:Lcom/google/zxing/common/BitMatrix;

    const/high16 v9, 0x3f000000

    add-float/2addr v9, v3

    float-to-int v9, v9

    const/high16 v10, 0x3f000000

    add-float/2addr v10, v2

    float-to-int v10, v10

    invoke-virtual {v8, v9, v10}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v8

    if-eq v8, v7, :cond_0

    add-int/lit8 v0, v0, 0x1

    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_1
    int-to-float v0, v0

    div-float/2addr v0, v4

    float-to-double v1, v0

    const-wide v3, 0x3fb999999999999aL

    cmpl-double v1, v1, v3

    if-lez v1, :cond_2

    float-to-double v1, v0

    const-wide v3, 0x3feccccccccccccdL

    cmpg-double v1, v1, v3

    if-gez v1, :cond_2

    const/4 v0, 0x0

    :goto_1
    return v0

    :cond_2
    float-to-double v0, v0

    const-wide v2, 0x3fb999999999999aL

    cmpg-double v0, v0, v2

    if-gtz v0, :cond_4

    if-eqz v7, :cond_3

    const/4 v0, 0x1

    goto :goto_1

    :cond_3
    const/4 v0, -0x1

    goto :goto_1

    :cond_4
    if-eqz v7, :cond_5

    const/4 v0, -0x1

    goto :goto_1

    :cond_5
    const/4 v0, 0x1

    goto :goto_1
.end method

.method private a()Lcom/google/zxing/aztec/detector/a;
    .locals 12

    const/high16 v11, 0x40800000

    const/high16 v10, 0x3f000000

    const/4 v9, -0x1

    const/4 v8, 0x1

    const/4 v7, 0x0

    :try_start_0
    new-instance v0, Lcom/google/zxing/common/detector/WhiteRectangleDetector;

    iget-object v1, p0, Lcom/google/zxing/aztec/detector/Detector;->a:Lcom/google/zxing/common/BitMatrix;

    invoke-direct {v0, v1}, Lcom/google/zxing/common/detector/WhiteRectangleDetector;-><init>(Lcom/google/zxing/common/BitMatrix;)V

    invoke-virtual {v0}, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->detect()[Lcom/google/zxing/ResultPoint;

    move-result-object v0

    const/4 v1, 0x0

    aget-object v3, v0, v1

    const/4 v1, 0x1

    aget-object v2, v0, v1

    const/4 v1, 0x2

    aget-object v1, v0, v1

    const/4 v4, 0x3

    aget-object v0, v0, v4
    :try_end_0
    .catch Lcom/google/zxing/NotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    invoke-virtual {v3}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v4

    invoke-virtual {v0}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v5

    add-float/2addr v4, v5

    invoke-virtual {v2}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v5

    add-float/2addr v4, v5

    invoke-virtual {v1}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v5

    add-float/2addr v4, v5

    div-float/2addr v4, v11

    add-float/2addr v4, v10

    float-to-int v4, v4

    invoke-virtual {v3}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v3

    invoke-virtual {v0}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v0

    add-float/2addr v0, v3

    invoke-virtual {v2}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v2

    add-float/2addr v0, v2

    invoke-virtual {v1}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v1

    add-float/2addr v0, v1

    div-float/2addr v0, v11

    add-float/2addr v0, v10

    float-to-int v0, v0

    :try_start_1
    new-instance v1, Lcom/google/zxing/common/detector/WhiteRectangleDetector;

    iget-object v2, p0, Lcom/google/zxing/aztec/detector/Detector;->a:Lcom/google/zxing/common/BitMatrix;

    const/16 v3, 0xf

    invoke-direct {v1, v2, v3, v4, v0}, Lcom/google/zxing/common/detector/WhiteRectangleDetector;-><init>(Lcom/google/zxing/common/BitMatrix;III)V

    invoke-virtual {v1}, Lcom/google/zxing/common/detector/WhiteRectangleDetector;->detect()[Lcom/google/zxing/ResultPoint;

    move-result-object v5

    const/4 v1, 0x0

    aget-object v3, v5, v1

    const/4 v1, 0x1

    aget-object v2, v5, v1

    const/4 v1, 0x2

    aget-object v1, v5, v1

    const/4 v6, 0x3

    aget-object v0, v5, v6
    :try_end_1
    .catch Lcom/google/zxing/NotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    :goto_1
    invoke-virtual {v3}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v4

    invoke-virtual {v0}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v5

    add-float/2addr v4, v5

    invoke-virtual {v2}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v5

    add-float/2addr v4, v5

    invoke-virtual {v1}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v5

    add-float/2addr v4, v5

    div-float/2addr v4, v11

    add-float/2addr v4, v10

    float-to-int v4, v4

    invoke-virtual {v3}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v3

    invoke-virtual {v0}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v0

    add-float/2addr v0, v3

    invoke-virtual {v2}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v2

    add-float/2addr v0, v2

    invoke-virtual {v1}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v1

    add-float/2addr v0, v1

    div-float/2addr v0, v11

    add-float/2addr v0, v10

    float-to-int v0, v0

    new-instance v1, Lcom/google/zxing/aztec/detector/a;

    invoke-direct {v1, v4, v0, v7}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    return-object v1

    :catch_0
    move-exception v0

    iget-object v0, p0, Lcom/google/zxing/aztec/detector/Detector;->a:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v0}, Lcom/google/zxing/common/BitMatrix;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    iget-object v1, p0, Lcom/google/zxing/aztec/detector/Detector;->a:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v1}, Lcom/google/zxing/common/BitMatrix;->getHeight()I

    move-result v1

    div-int/lit8 v4, v1, 0x2

    new-instance v1, Lcom/google/zxing/aztec/detector/a;

    add-int/lit8 v2, v0, 0x7

    add-int/lit8 v3, v4, -0x7

    invoke-direct {v1, v2, v3, v7}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    invoke-direct {p0, v1, v7, v8, v9}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/zxing/aztec/detector/a;->a()Lcom/google/zxing/ResultPoint;

    move-result-object v3

    new-instance v1, Lcom/google/zxing/aztec/detector/a;

    add-int/lit8 v2, v0, 0x7

    add-int/lit8 v5, v4, 0x7

    invoke-direct {v1, v2, v5, v7}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    invoke-direct {p0, v1, v7, v8, v8}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/zxing/aztec/detector/a;->a()Lcom/google/zxing/ResultPoint;

    move-result-object v2

    new-instance v1, Lcom/google/zxing/aztec/detector/a;

    add-int/lit8 v5, v0, -0x7

    add-int/lit8 v6, v4, 0x7

    invoke-direct {v1, v5, v6, v7}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    invoke-direct {p0, v1, v7, v9, v8}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/zxing/aztec/detector/a;->a()Lcom/google/zxing/ResultPoint;

    move-result-object v1

    new-instance v5, Lcom/google/zxing/aztec/detector/a;

    add-int/lit8 v0, v0, -0x7

    add-int/lit8 v4, v4, -0x7

    invoke-direct {v5, v0, v4, v7}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    invoke-direct {p0, v5, v7, v9, v9}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/zxing/aztec/detector/a;->a()Lcom/google/zxing/ResultPoint;

    move-result-object v0

    goto/16 :goto_0

    :catch_1
    move-exception v1

    new-instance v1, Lcom/google/zxing/aztec/detector/a;

    add-int/lit8 v2, v4, 0x7

    add-int/lit8 v3, v0, -0x7

    invoke-direct {v1, v2, v3, v7}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    invoke-direct {p0, v1, v7, v8, v9}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/zxing/aztec/detector/a;->a()Lcom/google/zxing/ResultPoint;

    move-result-object v3

    new-instance v1, Lcom/google/zxing/aztec/detector/a;

    add-int/lit8 v2, v4, 0x7

    add-int/lit8 v5, v0, 0x7

    invoke-direct {v1, v2, v5, v7}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    invoke-direct {p0, v1, v7, v8, v8}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/zxing/aztec/detector/a;->a()Lcom/google/zxing/ResultPoint;

    move-result-object v2

    new-instance v1, Lcom/google/zxing/aztec/detector/a;

    add-int/lit8 v5, v4, -0x7

    add-int/lit8 v6, v0, 0x7

    invoke-direct {v1, v5, v6, v7}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    invoke-direct {p0, v1, v7, v9, v8}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/zxing/aztec/detector/a;->a()Lcom/google/zxing/ResultPoint;

    move-result-object v1

    new-instance v5, Lcom/google/zxing/aztec/detector/a;

    add-int/lit8 v4, v4, -0x7

    add-int/lit8 v0, v0, -0x7

    invoke-direct {v5, v4, v0, v7}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    invoke-direct {p0, v5, v7, v9, v9}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/zxing/aztec/detector/a;->a()Lcom/google/zxing/ResultPoint;

    move-result-object v0

    goto/16 :goto_1
.end method

.method private a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;
    .locals 4

    iget v0, p1, Lcom/google/zxing/aztec/detector/a;->a:I

    add-int/2addr v0, p3

    iget v1, p1, Lcom/google/zxing/aztec/detector/a;->b:I

    add-int/2addr v1, p4

    :goto_0
    invoke-direct {p0, v0, v1}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/google/zxing/aztec/detector/Detector;->a:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v2, v0, v1}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v2

    if-ne v2, p2, :cond_0

    add-int/2addr v0, p3

    add-int/2addr v1, p4

    goto :goto_0

    :cond_0
    sub-int/2addr v0, p3

    sub-int/2addr v1, p4

    :goto_1
    invoke-direct {p0, v0, v1}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/google/zxing/aztec/detector/Detector;->a:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v2, v0, v1}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v2

    if-ne v2, p2, :cond_1

    add-int/2addr v0, p3

    goto :goto_1

    :cond_1
    sub-int v2, v0, p3

    move v0, v1

    :goto_2
    invoke-direct {p0, v2, v0}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/google/zxing/aztec/detector/Detector;->a:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v1, v2, v0}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v1

    if-ne v1, p2, :cond_2

    add-int/2addr v0, p4

    goto :goto_2

    :cond_2
    sub-int/2addr v0, p4

    new-instance v1, Lcom/google/zxing/aztec/detector/a;

    const/4 v3, 0x0

    invoke-direct {v1, v2, v0, v3}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    return-object v1
.end method

.method private a(Lcom/google/zxing/common/BitMatrix;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)Lcom/google/zxing/common/BitMatrix;
    .locals 21

    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/google/zxing/aztec/detector/Detector;->b:Z

    if-eqz v1, :cond_0

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    mul-int/lit8 v1, v1, 0x4

    add-int/lit8 v3, v1, 0xb

    :goto_0
    invoke-static {}, Lcom/google/zxing/common/GridSampler;->getInstance()Lcom/google/zxing/common/GridSampler;

    move-result-object v1

    const/high16 v5, 0x3f000000

    const/high16 v6, 0x3f000000

    int-to-float v2, v3

    const/high16 v4, 0x3f000000

    sub-float v7, v2, v4

    const/high16 v8, 0x3f000000

    int-to-float v2, v3

    const/high16 v4, 0x3f000000

    sub-float v9, v2, v4

    int-to-float v2, v3

    const/high16 v4, 0x3f000000

    sub-float v10, v2, v4

    const/high16 v11, 0x3f000000

    int-to-float v2, v3

    const/high16 v4, 0x3f000000

    sub-float v12, v2, v4

    invoke-virtual/range {p2 .. p2}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v13

    invoke-virtual/range {p2 .. p2}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v14

    invoke-virtual/range {p5 .. p5}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v15

    invoke-virtual/range {p5 .. p5}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v16

    invoke-virtual/range {p4 .. p4}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v17

    invoke-virtual/range {p4 .. p4}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v18

    invoke-virtual/range {p3 .. p3}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v19

    invoke-virtual/range {p3 .. p3}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v20

    move-object/from16 v2, p1

    move v4, v3

    invoke-virtual/range {v1 .. v20}, Lcom/google/zxing/common/GridSampler;->sampleGrid(Lcom/google/zxing/common/BitMatrix;IIFFFFFFFFFFFFFFFF)Lcom/google/zxing/common/BitMatrix;

    move-result-object v1

    return-object v1

    :cond_0
    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    const/4 v2, 0x4

    if-gt v1, v2, :cond_1

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    mul-int/lit8 v1, v1, 0x4

    add-int/lit8 v3, v1, 0xf

    goto :goto_0

    :cond_1
    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    mul-int/lit8 v1, v1, 0x4

    move-object/from16 v0, p0

    iget v2, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    add-int/lit8 v2, v2, -0x4

    div-int/lit8 v2, v2, 0x8

    add-int/lit8 v2, v2, 0x1

    mul-int/lit8 v2, v2, 0x2

    add-int/2addr v1, v2

    add-int/lit8 v3, v1, 0xf

    goto :goto_0
.end method

.method private a([Lcom/google/zxing/aztec/detector/a;)V
    .locals 13

    const/4 v3, 0x4

    const/4 v10, 0x3

    const/4 v2, 0x2

    const/4 v5, 0x1

    const/4 v6, 0x0

    aget-object v0, p1, v6

    aget-object v1, p1, v5

    iget v4, p0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v4, v4, 0x2

    add-int/lit8 v4, v4, 0x1

    invoke-direct {p0, v0, v1, v4}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;I)[Z

    move-result-object v1

    aget-object v0, p1, v5

    aget-object v4, p1, v2

    iget v7, p0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v7, v7, 0x2

    add-int/lit8 v7, v7, 0x1

    invoke-direct {p0, v0, v4, v7}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;I)[Z

    move-result-object v4

    aget-object v0, p1, v2

    aget-object v7, p1, v10

    iget v8, p0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v8, v8, 0x2

    add-int/lit8 v8, v8, 0x1

    invoke-direct {p0, v0, v7, v8}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;I)[Z

    move-result-object v7

    aget-object v0, p1, v10

    aget-object v8, p1, v6

    iget v9, p0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v9, v9, 0x2

    add-int/lit8 v9, v9, 0x1

    invoke-direct {p0, v0, v8, v9}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;I)[Z

    move-result-object v8

    aget-boolean v0, v1, v6

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v0, v0, 0x2

    aget-boolean v0, v1, v0

    if-eqz v0, :cond_0

    iput v6, p0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    :goto_0
    iget-boolean v0, p0, Lcom/google/zxing/aztec/detector/Detector;->b:Z

    if-eqz v0, :cond_5

    const/16 v0, 0x1c

    new-array v9, v0, [Z

    move v0, v6

    :goto_1
    const/4 v10, 0x7

    if-ge v0, v10, :cond_4

    add-int/lit8 v10, v0, 0x2

    aget-boolean v10, v1, v10

    aput-boolean v10, v9, v0

    add-int/lit8 v10, v0, 0x7

    add-int/lit8 v11, v0, 0x2

    aget-boolean v11, v4, v11

    aput-boolean v11, v9, v10

    add-int/lit8 v10, v0, 0xe

    add-int/lit8 v11, v0, 0x2

    aget-boolean v11, v7, v11

    aput-boolean v11, v9, v10

    add-int/lit8 v10, v0, 0x15

    add-int/lit8 v11, v0, 0x2

    aget-boolean v11, v8, v11

    aput-boolean v11, v9, v10

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_0
    aget-boolean v0, v4, v6

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v0, v0, 0x2

    aget-boolean v0, v4, v0

    if-eqz v0, :cond_1

    iput v5, p0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    goto :goto_0

    :cond_1
    aget-boolean v0, v7, v6

    if-eqz v0, :cond_2

    iget v0, p0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v0, v0, 0x2

    aget-boolean v0, v7, v0

    if-eqz v0, :cond_2

    iput v2, p0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    goto :goto_0

    :cond_2
    aget-boolean v0, v8, v6

    if-eqz v0, :cond_3

    iget v0, p0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v0, v0, 0x2

    aget-boolean v0, v8, v0

    if-eqz v0, :cond_3

    iput v10, p0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    goto :goto_0

    :cond_3
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_4
    const/16 v0, 0x1c

    new-array v0, v0, [Z

    move v1, v6

    :goto_2
    const/16 v4, 0x1c

    if-ge v1, v4, :cond_9

    iget v4, p0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    mul-int/lit8 v4, v4, 0x7

    add-int/2addr v4, v1

    rem-int/lit8 v4, v4, 0x1c

    aget-boolean v4, v9, v4

    aput-boolean v4, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_5
    const/16 v0, 0x28

    new-array v9, v0, [Z

    move v0, v6

    :goto_3
    const/16 v10, 0xb

    if-ge v0, v10, :cond_8

    const/4 v10, 0x5

    if-ge v0, v10, :cond_6

    add-int/lit8 v10, v0, 0x2

    aget-boolean v10, v1, v10

    aput-boolean v10, v9, v0

    add-int/lit8 v10, v0, 0xa

    add-int/lit8 v11, v0, 0x2

    aget-boolean v11, v4, v11

    aput-boolean v11, v9, v10

    add-int/lit8 v10, v0, 0x14

    add-int/lit8 v11, v0, 0x2

    aget-boolean v11, v7, v11

    aput-boolean v11, v9, v10

    add-int/lit8 v10, v0, 0x1e

    add-int/lit8 v11, v0, 0x2

    aget-boolean v11, v8, v11

    aput-boolean v11, v9, v10

    :cond_6
    const/4 v10, 0x5

    if-le v0, v10, :cond_7

    add-int/lit8 v10, v0, -0x1

    add-int/lit8 v11, v0, 0x2

    aget-boolean v11, v1, v11

    aput-boolean v11, v9, v10

    add-int/lit8 v10, v0, 0xa

    add-int/lit8 v10, v10, -0x1

    add-int/lit8 v11, v0, 0x2

    aget-boolean v11, v4, v11

    aput-boolean v11, v9, v10

    add-int/lit8 v10, v0, 0x14

    add-int/lit8 v10, v10, -0x1

    add-int/lit8 v11, v0, 0x2

    aget-boolean v11, v7, v11

    aput-boolean v11, v9, v10

    add-int/lit8 v10, v0, 0x1e

    add-int/lit8 v10, v10, -0x1

    add-int/lit8 v11, v0, 0x2

    aget-boolean v11, v8, v11

    aput-boolean v11, v9, v10

    :cond_7
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    :cond_8
    const/16 v0, 0x28

    new-array v0, v0, [Z

    move v1, v6

    :goto_4
    const/16 v4, 0x28

    if-ge v1, v4, :cond_9

    iget v4, p0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    mul-int/lit8 v4, v4, 0xa

    add-int/2addr v4, v1

    rem-int/lit8 v4, v4, 0x28

    aget-boolean v4, v9, v4

    aput-boolean v4, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    :cond_9
    iget-boolean v1, p0, Lcom/google/zxing/aztec/detector/Detector;->b:Z

    if-eqz v1, :cond_b

    const/4 v1, 0x7

    move v4, v1

    move v1, v2

    :goto_5
    sub-int v10, v4, v1

    new-array v11, v4, [I

    move v9, v6

    :goto_6
    if-ge v9, v4, :cond_d

    move v7, v5

    move v8, v5

    :goto_7
    if-gt v7, v3, :cond_c

    mul-int/lit8 v12, v9, 0x4

    add-int/lit8 v12, v12, 0x4

    sub-int/2addr v12, v7

    aget-boolean v12, v0, v12

    if-eqz v12, :cond_a

    aget v12, v11, v9

    add-int/2addr v12, v8

    aput v12, v11, v9

    :cond_a
    shl-int/lit8 v8, v8, 0x1

    add-int/lit8 v7, v7, 0x1

    goto :goto_7

    :cond_b
    const/16 v1, 0xa

    move v4, v1

    move v1, v3

    goto :goto_5

    :cond_c
    add-int/lit8 v7, v9, 0x1

    move v9, v7

    goto :goto_6

    :cond_d
    :try_start_0
    new-instance v4, Lcom/google/zxing/common/reedsolomon/ReedSolomonDecoder;

    sget-object v7, Lcom/google/zxing/common/reedsolomon/GenericGF;->AZTEC_PARAM:Lcom/google/zxing/common/reedsolomon/GenericGF;

    invoke-direct {v4, v7}, Lcom/google/zxing/common/reedsolomon/ReedSolomonDecoder;-><init>(Lcom/google/zxing/common/reedsolomon/GenericGF;)V

    invoke-virtual {v4, v11, v10}, Lcom/google/zxing/common/reedsolomon/ReedSolomonDecoder;->decode([II)V
    :try_end_0
    .catch Lcom/google/zxing/common/reedsolomon/ReedSolomonException; {:try_start_0 .. :try_end_0} :catch_0

    move v9, v6

    :goto_8
    if-ge v9, v1, :cond_10

    move v7, v5

    move v8, v5

    :goto_9
    if-gt v7, v3, :cond_f

    shl-int/lit8 v4, v9, 0x2

    add-int/lit8 v4, v4, 0x4

    sub-int v10, v4, v7

    aget v4, v11, v9

    and-int/2addr v4, v8

    if-ne v4, v8, :cond_e

    move v4, v5

    :goto_a
    aput-boolean v4, v0, v10

    shl-int/lit8 v8, v8, 0x1

    add-int/lit8 v4, v7, 0x1

    move v7, v4

    goto :goto_9

    :catch_0
    move-exception v0

    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_e
    move v4, v6

    goto :goto_a

    :cond_f
    add-int/lit8 v4, v9, 0x1

    move v9, v4

    goto :goto_8

    :cond_10
    iget-boolean v1, p0, Lcom/google/zxing/aztec/detector/Detector;->b:Z

    if-eqz v1, :cond_12

    const/4 v1, 0x6

    :goto_b
    if-ge v6, v2, :cond_13

    iget v3, p0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    shl-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    aget-boolean v3, v0, v6

    if-eqz v3, :cond_11

    iget v3, p0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    :cond_11
    add-int/lit8 v6, v6, 0x1

    goto :goto_b

    :cond_12
    const/4 v2, 0x5

    const/16 v1, 0xb

    goto :goto_b

    :cond_13
    move v3, v2

    :goto_c
    add-int v4, v2, v1

    if-ge v3, v4, :cond_15

    iget v4, p0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    shl-int/lit8 v4, v4, 0x1

    iput v4, p0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    aget-boolean v4, v0, v3

    if-eqz v4, :cond_14

    iget v4, p0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    add-int/lit8 v4, v4, 0x1

    iput v4, p0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    :cond_14
    add-int/lit8 v3, v3, 0x1

    goto :goto_c

    :cond_15
    iget v0, p0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    iget v0, p0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    return-void
.end method

.method private a([Z)V
    .locals 4

    iget-boolean v0, p0, Lcom/google/zxing/aztec/detector/Detector;->b:Z

    if-eqz v0, :cond_1

    const/4 v1, 0x2

    const/4 v0, 0x6

    :goto_0
    const/4 v2, 0x0

    :goto_1
    if-ge v2, v1, :cond_2

    iget v3, p0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    shl-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    aget-boolean v3, p1, v2

    if-eqz v3, :cond_0

    iget v3, p0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    :cond_1
    const/4 v1, 0x5

    const/16 v0, 0xb

    goto :goto_0

    :cond_2
    move v2, v1

    :goto_2
    add-int v3, v1, v0

    if-ge v2, v3, :cond_4

    iget v3, p0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    shl-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    aget-boolean v3, p1, v2

    if-eqz v3, :cond_3

    iget v3, p0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    :cond_4
    iget v0, p0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    iget v0, p0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    return-void
.end method

.method private static a([ZZ)V
    .locals 11

    const/4 v1, 0x4

    const/4 v4, 0x0

    const/4 v3, 0x1

    if-eqz p1, :cond_1

    const/4 v2, 0x7

    const/4 v0, 0x2

    :goto_0
    sub-int v8, v2, v0

    new-array v9, v2, [I

    move v7, v4

    :goto_1
    if-ge v7, v2, :cond_3

    move v5, v3

    move v6, v3

    :goto_2
    if-gt v5, v1, :cond_2

    mul-int/lit8 v10, v7, 0x4

    add-int/lit8 v10, v10, 0x4

    sub-int/2addr v10, v5

    aget-boolean v10, p0, v10

    if-eqz v10, :cond_0

    aget v10, v9, v7

    add-int/2addr v10, v6

    aput v10, v9, v7

    :cond_0
    shl-int/lit8 v6, v6, 0x1

    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    :cond_1
    const/16 v0, 0xa

    move v2, v0

    move v0, v1

    goto :goto_0

    :cond_2
    add-int/lit8 v5, v7, 0x1

    move v7, v5

    goto :goto_1

    :cond_3
    :try_start_0
    new-instance v2, Lcom/google/zxing/common/reedsolomon/ReedSolomonDecoder;

    sget-object v5, Lcom/google/zxing/common/reedsolomon/GenericGF;->AZTEC_PARAM:Lcom/google/zxing/common/reedsolomon/GenericGF;

    invoke-direct {v2, v5}, Lcom/google/zxing/common/reedsolomon/ReedSolomonDecoder;-><init>(Lcom/google/zxing/common/reedsolomon/GenericGF;)V

    invoke-virtual {v2, v9, v8}, Lcom/google/zxing/common/reedsolomon/ReedSolomonDecoder;->decode([II)V
    :try_end_0
    .catch Lcom/google/zxing/common/reedsolomon/ReedSolomonException; {:try_start_0 .. :try_end_0} :catch_0

    move v7, v4

    :goto_3
    if-ge v7, v0, :cond_6

    move v5, v3

    move v6, v3

    :goto_4
    if-gt v5, v1, :cond_5

    shl-int/lit8 v2, v7, 0x2

    add-int/lit8 v2, v2, 0x4

    sub-int v8, v2, v5

    aget v2, v9, v7

    and-int/2addr v2, v6

    if-ne v2, v6, :cond_4

    move v2, v3

    :goto_5
    aput-boolean v2, p0, v8

    shl-int/lit8 v6, v6, 0x1

    add-int/lit8 v2, v5, 0x1

    move v5, v2

    goto :goto_4

    :catch_0
    move-exception v0

    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_4
    move v2, v4

    goto :goto_5

    :cond_5
    add-int/lit8 v2, v7, 0x1

    move v7, v2

    goto :goto_3

    :cond_6
    return-void
.end method

.method private a(II)Z
    .locals 1

    if-ltz p1, :cond_0

    iget-object v0, p0, Lcom/google/zxing/aztec/detector/Detector;->a:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v0}, Lcom/google/zxing/common/BitMatrix;->getWidth()I

    move-result v0

    if-ge p1, v0, :cond_0

    if-lez p2, :cond_0

    iget-object v0, p0, Lcom/google/zxing/aztec/detector/Detector;->a:Lcom/google/zxing/common/BitMatrix;

    invoke-virtual {v0}, Lcom/google/zxing/common/BitMatrix;->getHeight()I

    move-result v0

    if-ge p2, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)Z
    .locals 7

    const/4 v0, 0x0

    new-instance v1, Lcom/google/zxing/aztec/detector/a;

    iget v2, p1, Lcom/google/zxing/aztec/detector/a;->a:I

    add-int/lit8 v2, v2, -0x3

    iget v3, p1, Lcom/google/zxing/aztec/detector/a;->b:I

    add-int/lit8 v3, v3, 0x3

    invoke-direct {v1, v2, v3, v0}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    new-instance v2, Lcom/google/zxing/aztec/detector/a;

    iget v3, p2, Lcom/google/zxing/aztec/detector/a;->a:I

    add-int/lit8 v3, v3, -0x3

    iget v4, p2, Lcom/google/zxing/aztec/detector/a;->b:I

    add-int/lit8 v4, v4, -0x3

    invoke-direct {v2, v3, v4, v0}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    new-instance v3, Lcom/google/zxing/aztec/detector/a;

    iget v4, p3, Lcom/google/zxing/aztec/detector/a;->a:I

    add-int/lit8 v4, v4, 0x3

    iget v5, p3, Lcom/google/zxing/aztec/detector/a;->b:I

    add-int/lit8 v5, v5, -0x3

    invoke-direct {v3, v4, v5, v0}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    new-instance v4, Lcom/google/zxing/aztec/detector/a;

    iget v5, p4, Lcom/google/zxing/aztec/detector/a;->a:I

    add-int/lit8 v5, v5, 0x3

    iget v6, p4, Lcom/google/zxing/aztec/detector/a;->b:I

    add-int/lit8 v6, v6, 0x3

    invoke-direct {v4, v5, v6, v0}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    invoke-direct {p0, v4, v1}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)I

    move-result v5

    if-nez v5, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-direct {p0, v1, v2}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)I

    move-result v1

    if-ne v1, v5, :cond_0

    invoke-direct {p0, v2, v3}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)I

    move-result v1

    if-ne v1, v5, :cond_0

    invoke-direct {p0, v3, v4}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)I

    move-result v1

    if-ne v1, v5, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method private a(Lcom/google/zxing/aztec/detector/a;)[Lcom/google/zxing/aztec/detector/a;
    .locals 17

    const/4 v2, 0x1

    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput v3, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    move-object/from16 v4, p1

    move-object/from16 v6, p1

    move-object/from16 v8, p1

    :goto_0
    move-object/from16 v0, p0

    iget v3, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    const/16 v5, 0x9

    if-ge v3, v5, :cond_3

    const/4 v3, 0x1

    const/4 v5, -0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v6, v2, v3, v5}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v7

    const/4 v3, 0x1

    const/4 v5, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v2, v3, v5}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v5

    const/4 v3, -0x1

    const/4 v9, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v1, v2, v3, v9}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v3

    const/4 v9, -0x1

    const/4 v10, -0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v8, v2, v9, v10}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v9

    move-object/from16 v0, p0

    iget v10, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    const/4 v11, 0x2

    if-le v10, v11, :cond_0

    invoke-static {v9, v7}, Lcom/google/zxing/aztec/detector/Detector;->b(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)F

    move-result v10

    move-object/from16 v0, p0

    iget v11, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    int-to-float v11, v11

    mul-float/2addr v10, v11

    invoke-static {v8, v6}, Lcom/google/zxing/aztec/detector/Detector;->b(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)F

    move-result v11

    move-object/from16 v0, p0

    iget v12, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    add-int/lit8 v12, v12, 0x2

    int-to-float v12, v12

    mul-float/2addr v11, v12

    div-float/2addr v10, v11

    float-to-double v11, v10

    const-wide/high16 v13, 0x3fe8000000000000L

    cmpg-double v11, v11, v13

    if-ltz v11, :cond_3

    float-to-double v10, v10

    const-wide/high16 v12, 0x3ff4000000000000L

    cmpl-double v10, v10, v12

    if-gtz v10, :cond_3

    new-instance v10, Lcom/google/zxing/aztec/detector/a;

    iget v11, v7, Lcom/google/zxing/aztec/detector/a;->a:I

    add-int/lit8 v11, v11, -0x3

    iget v12, v7, Lcom/google/zxing/aztec/detector/a;->b:I

    add-int/lit8 v12, v12, 0x3

    const/4 v13, 0x0

    invoke-direct {v10, v11, v12, v13}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    new-instance v11, Lcom/google/zxing/aztec/detector/a;

    iget v12, v5, Lcom/google/zxing/aztec/detector/a;->a:I

    add-int/lit8 v12, v12, -0x3

    iget v13, v5, Lcom/google/zxing/aztec/detector/a;->b:I

    add-int/lit8 v13, v13, -0x3

    const/4 v14, 0x0

    invoke-direct {v11, v12, v13, v14}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    new-instance v12, Lcom/google/zxing/aztec/detector/a;

    iget v13, v3, Lcom/google/zxing/aztec/detector/a;->a:I

    add-int/lit8 v13, v13, 0x3

    iget v14, v3, Lcom/google/zxing/aztec/detector/a;->b:I

    add-int/lit8 v14, v14, -0x3

    const/4 v15, 0x0

    invoke-direct {v12, v13, v14, v15}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    new-instance v13, Lcom/google/zxing/aztec/detector/a;

    iget v14, v9, Lcom/google/zxing/aztec/detector/a;->a:I

    add-int/lit8 v14, v14, 0x3

    iget v15, v9, Lcom/google/zxing/aztec/detector/a;->b:I

    add-int/lit8 v15, v15, 0x3

    const/16 v16, 0x0

    invoke-direct/range {v13 .. v16}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    move-object/from16 v0, p0

    invoke-direct {v0, v13, v10}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)I

    move-result v14

    if-eqz v14, :cond_1

    move-object/from16 v0, p0

    invoke-direct {v0, v10, v11}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)I

    move-result v10

    if-ne v10, v14, :cond_1

    move-object/from16 v0, p0

    invoke-direct {v0, v11, v12}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)I

    move-result v10

    if-ne v10, v14, :cond_1

    move-object/from16 v0, p0

    invoke-direct {v0, v12, v13}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)I

    move-result v10

    if-ne v10, v14, :cond_1

    const/4 v10, 0x1

    :goto_1
    if-eqz v10, :cond_3

    :cond_0
    if-nez v2, :cond_2

    const/4 v2, 0x1

    :goto_2
    move-object/from16 v0, p0

    iget v4, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    add-int/lit8 v4, v4, 0x1

    move-object/from16 v0, p0

    iput v4, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    move-object/from16 p1, v3

    move-object v4, v5

    move-object v6, v7

    move-object v8, v9

    goto/16 :goto_0

    :cond_1
    const/4 v10, 0x0

    goto :goto_1

    :cond_2
    const/4 v2, 0x0

    goto :goto_2

    :cond_3
    move-object/from16 v0, p0

    iget v2, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    const/4 v3, 0x5

    if-eq v2, v3, :cond_4

    move-object/from16 v0, p0

    iget v2, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    const/4 v3, 0x7

    if-eq v2, v3, :cond_4

    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v2

    throw v2

    :cond_4
    move-object/from16 v0, p0

    iget v2, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    const/4 v3, 0x5

    if-ne v2, v3, :cond_6

    const/4 v2, 0x1

    :goto_3
    move-object/from16 v0, p0

    iput-boolean v2, v0, Lcom/google/zxing/aztec/detector/Detector;->b:Z

    const/high16 v2, 0x3fc00000

    move-object/from16 v0, p0

    iget v3, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v3, v3, 0x2

    add-int/lit8 v3, v3, -0x3

    int-to-float v3, v3

    div-float/2addr v2, v3

    iget v3, v6, Lcom/google/zxing/aztec/detector/a;->a:I

    move-object/from16 v0, p1

    iget v5, v0, Lcom/google/zxing/aztec/detector/a;->a:I

    sub-int/2addr v3, v5

    iget v5, v6, Lcom/google/zxing/aztec/detector/a;->b:I

    move-object/from16 v0, p1

    iget v7, v0, Lcom/google/zxing/aztec/detector/a;->b:I

    sub-int/2addr v5, v7

    move-object/from16 v0, p1

    iget v7, v0, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v7, v7

    int-to-float v9, v3

    mul-float/2addr v9, v2

    sub-float/2addr v7, v9

    const/high16 v9, 0x3f000000

    add-float/2addr v7, v9

    float-to-int v7, v7

    move-object/from16 v0, p1

    iget v9, v0, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v9, v9

    int-to-float v10, v5

    mul-float/2addr v10, v2

    sub-float/2addr v9, v10

    const/high16 v10, 0x3f000000

    add-float/2addr v9, v10

    float-to-int v9, v9

    iget v10, v6, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v10, v10

    int-to-float v3, v3

    mul-float/2addr v3, v2

    add-float/2addr v3, v10

    const/high16 v10, 0x3f000000

    add-float/2addr v3, v10

    float-to-int v3, v3

    iget v6, v6, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v6, v6

    int-to-float v5, v5

    mul-float/2addr v5, v2

    add-float/2addr v5, v6

    const/high16 v6, 0x3f000000

    add-float/2addr v5, v6

    float-to-int v5, v5

    iget v6, v4, Lcom/google/zxing/aztec/detector/a;->a:I

    iget v10, v8, Lcom/google/zxing/aztec/detector/a;->a:I

    sub-int/2addr v6, v10

    iget v10, v4, Lcom/google/zxing/aztec/detector/a;->b:I

    iget v11, v8, Lcom/google/zxing/aztec/detector/a;->b:I

    sub-int/2addr v10, v11

    iget v11, v8, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v11, v11

    int-to-float v12, v6

    mul-float/2addr v12, v2

    sub-float/2addr v11, v12

    const/high16 v12, 0x3f000000

    add-float/2addr v11, v12

    float-to-int v11, v11

    iget v8, v8, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v8, v8

    int-to-float v12, v10

    mul-float/2addr v12, v2

    sub-float/2addr v8, v12

    const/high16 v12, 0x3f000000

    add-float/2addr v8, v12

    float-to-int v8, v8

    iget v12, v4, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v12, v12

    int-to-float v6, v6

    mul-float/2addr v6, v2

    add-float/2addr v6, v12

    const/high16 v12, 0x3f000000

    add-float/2addr v6, v12

    float-to-int v6, v6

    iget v4, v4, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v4, v4

    int-to-float v10, v10

    mul-float/2addr v2, v10

    add-float/2addr v2, v4

    const/high16 v4, 0x3f000000

    add-float/2addr v2, v4

    float-to-int v2, v2

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v5}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v4

    if-eqz v4, :cond_5

    move-object/from16 v0, p0

    invoke-direct {v0, v6, v2}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v4

    if-eqz v4, :cond_5

    move-object/from16 v0, p0

    invoke-direct {v0, v7, v9}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v4

    if-eqz v4, :cond_5

    move-object/from16 v0, p0

    invoke-direct {v0, v11, v8}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v4

    if-nez v4, :cond_7

    :cond_5
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v2

    throw v2

    :cond_6
    const/4 v2, 0x0

    goto/16 :goto_3

    :cond_7
    new-instance v4, Lcom/google/zxing/aztec/detector/a;

    const/4 v10, 0x0

    invoke-direct {v4, v3, v5, v10}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    new-instance v3, Lcom/google/zxing/aztec/detector/a;

    const/4 v5, 0x0

    invoke-direct {v3, v6, v2, v5}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    new-instance v2, Lcom/google/zxing/aztec/detector/a;

    const/4 v5, 0x0

    invoke-direct {v2, v7, v9, v5}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    new-instance v5, Lcom/google/zxing/aztec/detector/a;

    const/4 v6, 0x0

    invoke-direct {v5, v11, v8, v6}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    const/4 v6, 0x4

    new-array v6, v6, [Lcom/google/zxing/aztec/detector/a;

    const/4 v7, 0x0

    aput-object v4, v6, v7

    const/4 v4, 0x1

    aput-object v3, v6, v4

    const/4 v3, 0x2

    aput-object v2, v6, v3

    const/4 v2, 0x3

    aput-object v5, v6, v2

    return-object v6
.end method

.method private a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;I)[Z
    .locals 10

    const/high16 v9, 0x3f000000

    new-array v3, p3, [Z

    invoke-static {p1, p2}, Lcom/google/zxing/aztec/detector/Detector;->b(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)F

    move-result v0

    add-int/lit8 v1, p3, -0x1

    int-to-float v1, v1

    div-float v1, v0, v1

    iget v2, p2, Lcom/google/zxing/aztec/detector/a;->a:I

    iget v4, p1, Lcom/google/zxing/aztec/detector/a;->a:I

    sub-int/2addr v2, v4

    int-to-float v2, v2

    mul-float/2addr v2, v1

    div-float v4, v2, v0

    iget v2, p2, Lcom/google/zxing/aztec/detector/a;->b:I

    iget v5, p1, Lcom/google/zxing/aztec/detector/a;->b:I

    sub-int/2addr v2, v5

    int-to-float v2, v2

    mul-float/2addr v1, v2

    div-float v5, v1, v0

    iget v0, p1, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v1, v0

    iget v0, p1, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v2, v0

    const/4 v0, 0x0

    :goto_0
    if-ge v0, p3, :cond_0

    iget-object v6, p0, Lcom/google/zxing/aztec/detector/Detector;->a:Lcom/google/zxing/common/BitMatrix;

    add-float v7, v1, v9

    float-to-int v7, v7

    add-float v8, v2, v9

    float-to-int v8, v8

    invoke-virtual {v6, v7, v8}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v6

    aput-boolean v6, v3, v0

    add-float/2addr v1, v4

    add-float/2addr v2, v5

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    return-object v3
.end method

.method private static b(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)F
    .locals 4

    iget v0, p0, Lcom/google/zxing/aztec/detector/a;->a:I

    iget v1, p1, Lcom/google/zxing/aztec/detector/a;->a:I

    sub-int/2addr v0, v1

    iget v1, p0, Lcom/google/zxing/aztec/detector/a;->a:I

    iget v2, p1, Lcom/google/zxing/aztec/detector/a;->a:I

    sub-int/2addr v1, v2

    mul-int/2addr v0, v1

    iget v1, p0, Lcom/google/zxing/aztec/detector/a;->b:I

    iget v2, p1, Lcom/google/zxing/aztec/detector/a;->b:I

    sub-int/2addr v1, v2

    iget v2, p0, Lcom/google/zxing/aztec/detector/a;->b:I

    iget v3, p1, Lcom/google/zxing/aztec/detector/a;->b:I

    sub-int/2addr v2, v3

    mul-int/2addr v1, v2

    add-int/2addr v0, v1

    int-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v0

    double-to-float v0, v0

    return v0
.end method

.method private b([Lcom/google/zxing/aztec/detector/a;)[Lcom/google/zxing/ResultPoint;
    .locals 11

    iget v0, p0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    mul-int/lit8 v1, v0, 0x2

    iget v0, p0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    const/4 v2, 0x4

    if-le v0, v2, :cond_1

    const/4 v0, 0x1

    :goto_0
    add-int/2addr v0, v1

    iget v1, p0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    add-int/lit8 v1, v1, -0x4

    div-int/lit8 v1, v1, 0x8

    add-int/2addr v0, v1

    int-to-float v0, v0

    const/high16 v1, 0x40000000

    iget v2, p0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    div-float v1, v0, v1

    const/4 v0, 0x0

    aget-object v0, p1, v0

    iget v0, v0, Lcom/google/zxing/aztec/detector/a;->a:I

    const/4 v2, 0x2

    aget-object v2, p1, v2

    iget v2, v2, Lcom/google/zxing/aztec/detector/a;->a:I

    sub-int v2, v0, v2

    if-lez v2, :cond_2

    const/4 v0, 0x1

    :goto_1
    add-int/2addr v2, v0

    const/4 v0, 0x0

    aget-object v0, p1, v0

    iget v0, v0, Lcom/google/zxing/aztec/detector/a;->b:I

    const/4 v3, 0x2

    aget-object v3, p1, v3

    iget v3, v3, Lcom/google/zxing/aztec/detector/a;->b:I

    sub-int v3, v0, v3

    if-lez v3, :cond_3

    const/4 v0, 0x1

    :goto_2
    add-int/2addr v0, v3

    const/4 v3, 0x2

    aget-object v3, p1, v3

    iget v3, v3, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v3, v3

    int-to-float v4, v2

    mul-float/2addr v4, v1

    sub-float/2addr v3, v4

    const/high16 v4, 0x3f000000

    add-float/2addr v3, v4

    float-to-int v3, v3

    const/4 v4, 0x2

    aget-object v4, p1, v4

    iget v4, v4, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v4, v4

    int-to-float v5, v0

    mul-float/2addr v5, v1

    sub-float/2addr v4, v5

    const/high16 v5, 0x3f000000

    add-float/2addr v4, v5

    float-to-int v4, v4

    const/4 v5, 0x0

    aget-object v5, p1, v5

    iget v5, v5, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v5, v5

    int-to-float v2, v2

    mul-float/2addr v2, v1

    add-float/2addr v2, v5

    const/high16 v5, 0x3f000000

    add-float/2addr v2, v5

    float-to-int v2, v2

    const/4 v5, 0x0

    aget-object v5, p1, v5

    iget v5, v5, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v5, v5

    int-to-float v0, v0

    mul-float/2addr v0, v1

    add-float/2addr v0, v5

    const/high16 v5, 0x3f000000

    add-float/2addr v0, v5

    float-to-int v5, v0

    const/4 v0, 0x1

    aget-object v0, p1, v0

    iget v0, v0, Lcom/google/zxing/aztec/detector/a;->a:I

    const/4 v6, 0x3

    aget-object v6, p1, v6

    iget v6, v6, Lcom/google/zxing/aztec/detector/a;->a:I

    sub-int v6, v0, v6

    if-lez v6, :cond_4

    const/4 v0, 0x1

    :goto_3
    add-int/2addr v6, v0

    const/4 v0, 0x1

    aget-object v0, p1, v0

    iget v0, v0, Lcom/google/zxing/aztec/detector/a;->b:I

    const/4 v7, 0x3

    aget-object v7, p1, v7

    iget v7, v7, Lcom/google/zxing/aztec/detector/a;->b:I

    sub-int v7, v0, v7

    if-lez v7, :cond_5

    const/4 v0, 0x1

    :goto_4
    add-int/2addr v0, v7

    const/4 v7, 0x3

    aget-object v7, p1, v7

    iget v7, v7, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v7, v7

    int-to-float v8, v6

    mul-float/2addr v8, v1

    sub-float/2addr v7, v8

    const/high16 v8, 0x3f000000

    add-float/2addr v7, v8

    float-to-int v7, v7

    const/4 v8, 0x3

    aget-object v8, p1, v8

    iget v8, v8, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v8, v8

    int-to-float v9, v0

    mul-float/2addr v9, v1

    sub-float/2addr v8, v9

    const/high16 v9, 0x3f000000

    add-float/2addr v8, v9

    float-to-int v8, v8

    const/4 v9, 0x1

    aget-object v9, p1, v9

    iget v9, v9, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v9, v9

    int-to-float v6, v6

    mul-float/2addr v6, v1

    add-float/2addr v6, v9

    const/high16 v9, 0x3f000000

    add-float/2addr v6, v9

    float-to-int v6, v6

    const/4 v9, 0x1

    aget-object v9, p1, v9

    iget v9, v9, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v9, v9

    int-to-float v0, v0

    mul-float/2addr v0, v1

    add-float/2addr v0, v9

    const/high16 v1, 0x3f000000

    add-float/2addr v0, v1

    float-to-int v0, v0

    invoke-direct {p0, v2, v5}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-direct {p0, v6, v0}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-direct {p0, v3, v4}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-direct {p0, v7, v8}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v1

    if-nez v1, :cond_6

    :cond_0
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_1
    const/4 v0, 0x0

    goto/16 :goto_0

    :cond_2
    const/4 v0, -0x1

    goto/16 :goto_1

    :cond_3
    const/4 v0, -0x1

    goto/16 :goto_2

    :cond_4
    const/4 v0, -0x1

    goto :goto_3

    :cond_5
    const/4 v0, -0x1

    goto :goto_4

    :cond_6
    const/4 v1, 0x4

    new-array v1, v1, [Lcom/google/zxing/ResultPoint;

    const/4 v9, 0x0

    new-instance v10, Lcom/google/zxing/ResultPoint;

    int-to-float v2, v2

    int-to-float v5, v5

    invoke-direct {v10, v2, v5}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v10, v1, v9

    const/4 v2, 0x1

    new-instance v5, Lcom/google/zxing/ResultPoint;

    int-to-float v6, v6

    int-to-float v0, v0

    invoke-direct {v5, v6, v0}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v5, v1, v2

    const/4 v0, 0x2

    new-instance v2, Lcom/google/zxing/ResultPoint;

    int-to-float v3, v3

    int-to-float v4, v4

    invoke-direct {v2, v3, v4}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v2, v1, v0

    const/4 v0, 0x3

    new-instance v2, Lcom/google/zxing/ResultPoint;

    int-to-float v3, v7

    int-to-float v4, v8

    invoke-direct {v2, v3, v4}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v2, v1, v0

    return-object v1
.end method


# virtual methods
.method public final detect()Lcom/google/zxing/aztec/AztecDetectorResult;
    .locals 22

    invoke-direct/range {p0 .. p0}, Lcom/google/zxing/aztec/detector/Detector;->a()Lcom/google/zxing/aztec/detector/a;

    move-result-object v2

    const/4 v1, 0x1

    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput v3, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    move-object v4, v2

    move-object v6, v2

    move-object v8, v2

    :goto_0
    move-object/from16 v0, p0

    iget v3, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    const/16 v5, 0x9

    if-ge v3, v5, :cond_3

    const/4 v3, 0x1

    const/4 v5, -0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v8, v1, v3, v5}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v9

    const/4 v3, 0x1

    const/4 v5, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v6, v1, v3, v5}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v7

    const/4 v3, -0x1

    const/4 v5, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v1, v3, v5}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v5

    const/4 v3, -0x1

    const/4 v10, -0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v2, v1, v3, v10}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;ZII)Lcom/google/zxing/aztec/detector/a;

    move-result-object v3

    move-object/from16 v0, p0

    iget v10, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    const/4 v11, 0x2

    if-le v10, v11, :cond_0

    invoke-static {v3, v9}, Lcom/google/zxing/aztec/detector/Detector;->b(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)F

    move-result v10

    move-object/from16 v0, p0

    iget v11, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    int-to-float v11, v11

    mul-float/2addr v10, v11

    invoke-static {v2, v8}, Lcom/google/zxing/aztec/detector/Detector;->b(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)F

    move-result v11

    move-object/from16 v0, p0

    iget v12, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    add-int/lit8 v12, v12, 0x2

    int-to-float v12, v12

    mul-float/2addr v11, v12

    div-float/2addr v10, v11

    float-to-double v11, v10

    const-wide/high16 v13, 0x3fe8000000000000L

    cmpg-double v11, v11, v13

    if-ltz v11, :cond_3

    float-to-double v10, v10

    const-wide/high16 v12, 0x3ff4000000000000L

    cmpl-double v10, v10, v12

    if-gtz v10, :cond_3

    new-instance v10, Lcom/google/zxing/aztec/detector/a;

    iget v11, v9, Lcom/google/zxing/aztec/detector/a;->a:I

    add-int/lit8 v11, v11, -0x3

    iget v12, v9, Lcom/google/zxing/aztec/detector/a;->b:I

    add-int/lit8 v12, v12, 0x3

    const/4 v13, 0x0

    invoke-direct {v10, v11, v12, v13}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    new-instance v11, Lcom/google/zxing/aztec/detector/a;

    iget v12, v7, Lcom/google/zxing/aztec/detector/a;->a:I

    add-int/lit8 v12, v12, -0x3

    iget v13, v7, Lcom/google/zxing/aztec/detector/a;->b:I

    add-int/lit8 v13, v13, -0x3

    const/4 v14, 0x0

    invoke-direct {v11, v12, v13, v14}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    new-instance v12, Lcom/google/zxing/aztec/detector/a;

    iget v13, v5, Lcom/google/zxing/aztec/detector/a;->a:I

    add-int/lit8 v13, v13, 0x3

    iget v14, v5, Lcom/google/zxing/aztec/detector/a;->b:I

    add-int/lit8 v14, v14, -0x3

    const/4 v15, 0x0

    invoke-direct {v12, v13, v14, v15}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    new-instance v13, Lcom/google/zxing/aztec/detector/a;

    iget v14, v3, Lcom/google/zxing/aztec/detector/a;->a:I

    add-int/lit8 v14, v14, 0x3

    iget v15, v3, Lcom/google/zxing/aztec/detector/a;->b:I

    add-int/lit8 v15, v15, 0x3

    const/16 v16, 0x0

    invoke-direct/range {v13 .. v16}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    move-object/from16 v0, p0

    invoke-direct {v0, v13, v10}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)I

    move-result v14

    if-eqz v14, :cond_1

    move-object/from16 v0, p0

    invoke-direct {v0, v10, v11}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)I

    move-result v10

    if-ne v10, v14, :cond_1

    move-object/from16 v0, p0

    invoke-direct {v0, v11, v12}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)I

    move-result v10

    if-ne v10, v14, :cond_1

    move-object/from16 v0, p0

    invoke-direct {v0, v12, v13}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;)I

    move-result v10

    if-ne v10, v14, :cond_1

    const/4 v10, 0x1

    :goto_1
    if-eqz v10, :cond_3

    :cond_0
    if-nez v1, :cond_2

    const/4 v1, 0x1

    :goto_2
    move-object/from16 v0, p0

    iget v2, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    add-int/lit8 v2, v2, 0x1

    move-object/from16 v0, p0

    iput v2, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    move-object v2, v3

    move-object v4, v5

    move-object v6, v7

    move-object v8, v9

    goto/16 :goto_0

    :cond_1
    const/4 v10, 0x0

    goto :goto_1

    :cond_2
    const/4 v1, 0x0

    goto :goto_2

    :cond_3
    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    const/4 v3, 0x5

    if-eq v1, v3, :cond_4

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    const/4 v3, 0x7

    if-eq v1, v3, :cond_4

    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v1

    throw v1

    :cond_4
    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    const/4 v3, 0x5

    if-ne v1, v3, :cond_6

    const/4 v1, 0x1

    :goto_3
    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/google/zxing/aztec/detector/Detector;->b:Z

    const/high16 v1, 0x3fc00000

    move-object/from16 v0, p0

    iget v3, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v3, v3, 0x2

    add-int/lit8 v3, v3, -0x3

    int-to-float v3, v3

    div-float/2addr v1, v3

    iget v3, v8, Lcom/google/zxing/aztec/detector/a;->a:I

    iget v5, v4, Lcom/google/zxing/aztec/detector/a;->a:I

    sub-int/2addr v3, v5

    iget v5, v8, Lcom/google/zxing/aztec/detector/a;->b:I

    iget v7, v4, Lcom/google/zxing/aztec/detector/a;->b:I

    sub-int/2addr v5, v7

    iget v7, v4, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v7, v7

    int-to-float v9, v3

    mul-float/2addr v9, v1

    sub-float/2addr v7, v9

    const/high16 v9, 0x3f000000

    add-float/2addr v7, v9

    float-to-int v7, v7

    iget v4, v4, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v4, v4

    int-to-float v9, v5

    mul-float/2addr v9, v1

    sub-float/2addr v4, v9

    const/high16 v9, 0x3f000000

    add-float/2addr v4, v9

    float-to-int v4, v4

    iget v9, v8, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v9, v9

    int-to-float v3, v3

    mul-float/2addr v3, v1

    add-float/2addr v3, v9

    const/high16 v9, 0x3f000000

    add-float/2addr v3, v9

    float-to-int v3, v3

    iget v8, v8, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v8, v8

    int-to-float v5, v5

    mul-float/2addr v5, v1

    add-float/2addr v5, v8

    const/high16 v8, 0x3f000000

    add-float/2addr v5, v8

    float-to-int v5, v5

    iget v8, v6, Lcom/google/zxing/aztec/detector/a;->a:I

    iget v9, v2, Lcom/google/zxing/aztec/detector/a;->a:I

    sub-int/2addr v8, v9

    iget v9, v6, Lcom/google/zxing/aztec/detector/a;->b:I

    iget v10, v2, Lcom/google/zxing/aztec/detector/a;->b:I

    sub-int/2addr v9, v10

    iget v10, v2, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v10, v10

    int-to-float v11, v8

    mul-float/2addr v11, v1

    sub-float/2addr v10, v11

    const/high16 v11, 0x3f000000

    add-float/2addr v10, v11

    float-to-int v10, v10

    iget v2, v2, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v2, v2

    int-to-float v11, v9

    mul-float/2addr v11, v1

    sub-float/2addr v2, v11

    const/high16 v11, 0x3f000000

    add-float/2addr v2, v11

    float-to-int v2, v2

    iget v11, v6, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v11, v11

    int-to-float v8, v8

    mul-float/2addr v8, v1

    add-float/2addr v8, v11

    const/high16 v11, 0x3f000000

    add-float/2addr v8, v11

    float-to-int v8, v8

    iget v6, v6, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v6, v6

    int-to-float v9, v9

    mul-float/2addr v1, v9

    add-float/2addr v1, v6

    const/high16 v6, 0x3f000000

    add-float/2addr v1, v6

    float-to-int v1, v1

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v5}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v6

    if-eqz v6, :cond_5

    move-object/from16 v0, p0

    invoke-direct {v0, v8, v1}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v6

    if-eqz v6, :cond_5

    move-object/from16 v0, p0

    invoke-direct {v0, v7, v4}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v6

    if-eqz v6, :cond_5

    move-object/from16 v0, p0

    invoke-direct {v0, v10, v2}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v6

    if-nez v6, :cond_7

    :cond_5
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v1

    throw v1

    :cond_6
    const/4 v1, 0x0

    goto/16 :goto_3

    :cond_7
    new-instance v6, Lcom/google/zxing/aztec/detector/a;

    const/4 v9, 0x0

    invoke-direct {v6, v3, v5, v9}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    new-instance v3, Lcom/google/zxing/aztec/detector/a;

    const/4 v5, 0x0

    invoke-direct {v3, v8, v1, v5}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    new-instance v1, Lcom/google/zxing/aztec/detector/a;

    const/4 v5, 0x0

    invoke-direct {v1, v7, v4, v5}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    new-instance v4, Lcom/google/zxing/aztec/detector/a;

    const/4 v5, 0x0

    invoke-direct {v4, v10, v2, v5}, Lcom/google/zxing/aztec/detector/a;-><init>(IIB)V

    const/4 v2, 0x4

    new-array v5, v2, [Lcom/google/zxing/aztec/detector/a;

    const/4 v2, 0x0

    aput-object v6, v5, v2

    const/4 v2, 0x1

    aput-object v3, v5, v2

    const/4 v2, 0x2

    aput-object v1, v5, v2

    const/4 v1, 0x3

    aput-object v4, v5, v1

    const/4 v1, 0x0

    aget-object v1, v5, v1

    const/4 v2, 0x1

    aget-object v2, v5, v2

    move-object/from16 v0, p0

    iget v3, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v3, v3, 0x2

    add-int/lit8 v3, v3, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v1, v2, v3}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;I)[Z

    move-result-object v2

    const/4 v1, 0x1

    aget-object v1, v5, v1

    const/4 v3, 0x2

    aget-object v3, v5, v3

    move-object/from16 v0, p0

    iget v4, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v4, v4, 0x2

    add-int/lit8 v4, v4, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v1, v3, v4}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;I)[Z

    move-result-object v3

    const/4 v1, 0x2

    aget-object v1, v5, v1

    const/4 v4, 0x3

    aget-object v4, v5, v4

    move-object/from16 v0, p0

    iget v6, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v6, v6, 0x2

    add-int/lit8 v6, v6, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v1, v4, v6}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;I)[Z

    move-result-object v4

    const/4 v1, 0x3

    aget-object v1, v5, v1

    const/4 v6, 0x0

    aget-object v6, v5, v6

    move-object/from16 v0, p0

    iget v7, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v7, v7, 0x2

    add-int/lit8 v7, v7, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v1, v6, v7}, Lcom/google/zxing/aztec/detector/Detector;->a(Lcom/google/zxing/aztec/detector/a;Lcom/google/zxing/aztec/detector/a;I)[Z

    move-result-object v6

    const/4 v1, 0x0

    aget-boolean v1, v2, v1

    if-eqz v1, :cond_8

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v1, v1, 0x2

    aget-boolean v1, v2, v1

    if-eqz v1, :cond_8

    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput v1, v0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    :goto_4
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/google/zxing/aztec/detector/Detector;->b:Z

    if-eqz v1, :cond_d

    const/16 v1, 0x1c

    new-array v7, v1, [Z

    const/4 v1, 0x0

    :goto_5
    const/4 v8, 0x7

    if-ge v1, v8, :cond_c

    add-int/lit8 v8, v1, 0x2

    aget-boolean v8, v2, v8

    aput-boolean v8, v7, v1

    add-int/lit8 v8, v1, 0x7

    add-int/lit8 v9, v1, 0x2

    aget-boolean v9, v3, v9

    aput-boolean v9, v7, v8

    add-int/lit8 v8, v1, 0xe

    add-int/lit8 v9, v1, 0x2

    aget-boolean v9, v4, v9

    aput-boolean v9, v7, v8

    add-int/lit8 v8, v1, 0x15

    add-int/lit8 v9, v1, 0x2

    aget-boolean v9, v6, v9

    aput-boolean v9, v7, v8

    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_8
    const/4 v1, 0x0

    aget-boolean v1, v3, v1

    if-eqz v1, :cond_9

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v1, v1, 0x2

    aget-boolean v1, v3, v1

    if-eqz v1, :cond_9

    const/4 v1, 0x1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    goto :goto_4

    :cond_9
    const/4 v1, 0x0

    aget-boolean v1, v4, v1

    if-eqz v1, :cond_a

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v1, v1, 0x2

    aget-boolean v1, v4, v1

    if-eqz v1, :cond_a

    const/4 v1, 0x2

    move-object/from16 v0, p0

    iput v1, v0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    goto :goto_4

    :cond_a
    const/4 v1, 0x0

    aget-boolean v1, v6, v1

    if-eqz v1, :cond_b

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    mul-int/lit8 v1, v1, 0x2

    aget-boolean v1, v6, v1

    if-eqz v1, :cond_b

    const/4 v1, 0x3

    move-object/from16 v0, p0

    iput v1, v0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    goto :goto_4

    :cond_b
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v1

    throw v1

    :cond_c
    const/16 v1, 0x1c

    new-array v1, v1, [Z

    const/4 v2, 0x0

    :goto_6
    const/16 v3, 0x1c

    if-ge v2, v3, :cond_11

    move-object/from16 v0, p0

    iget v3, v0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    mul-int/lit8 v3, v3, 0x7

    add-int/2addr v3, v2

    rem-int/lit8 v3, v3, 0x1c

    aget-boolean v3, v7, v3

    aput-boolean v3, v1, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_6

    :cond_d
    const/16 v1, 0x28

    new-array v7, v1, [Z

    const/4 v1, 0x0

    :goto_7
    const/16 v8, 0xb

    if-ge v1, v8, :cond_10

    const/4 v8, 0x5

    if-ge v1, v8, :cond_e

    add-int/lit8 v8, v1, 0x2

    aget-boolean v8, v2, v8

    aput-boolean v8, v7, v1

    add-int/lit8 v8, v1, 0xa

    add-int/lit8 v9, v1, 0x2

    aget-boolean v9, v3, v9

    aput-boolean v9, v7, v8

    add-int/lit8 v8, v1, 0x14

    add-int/lit8 v9, v1, 0x2

    aget-boolean v9, v4, v9

    aput-boolean v9, v7, v8

    add-int/lit8 v8, v1, 0x1e

    add-int/lit8 v9, v1, 0x2

    aget-boolean v9, v6, v9

    aput-boolean v9, v7, v8

    :cond_e
    const/4 v8, 0x5

    if-le v1, v8, :cond_f

    add-int/lit8 v8, v1, -0x1

    add-int/lit8 v9, v1, 0x2

    aget-boolean v9, v2, v9

    aput-boolean v9, v7, v8

    add-int/lit8 v8, v1, 0xa

    add-int/lit8 v8, v8, -0x1

    add-int/lit8 v9, v1, 0x2

    aget-boolean v9, v3, v9

    aput-boolean v9, v7, v8

    add-int/lit8 v8, v1, 0x14

    add-int/lit8 v8, v8, -0x1

    add-int/lit8 v9, v1, 0x2

    aget-boolean v9, v4, v9

    aput-boolean v9, v7, v8

    add-int/lit8 v8, v1, 0x1e

    add-int/lit8 v8, v8, -0x1

    add-int/lit8 v9, v1, 0x2

    aget-boolean v9, v6, v9

    aput-boolean v9, v7, v8

    :cond_f
    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    :cond_10
    const/16 v1, 0x28

    new-array v1, v1, [Z

    const/4 v2, 0x0

    :goto_8
    const/16 v3, 0x28

    if-ge v2, v3, :cond_11

    move-object/from16 v0, p0

    iget v3, v0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    mul-int/lit8 v3, v3, 0xa

    add-int/2addr v3, v2

    rem-int/lit8 v3, v3, 0x28

    aget-boolean v3, v7, v3

    aput-boolean v3, v1, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_8

    :cond_11
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/google/zxing/aztec/detector/Detector;->b:Z

    invoke-static {v1, v2}, Lcom/google/zxing/aztec/detector/Detector;->a([ZZ)V

    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/google/zxing/aztec/detector/Detector;->b:Z

    if-eqz v2, :cond_13

    const/4 v2, 0x2

    const/4 v3, 0x6

    :goto_9
    const/4 v4, 0x0

    :goto_a
    if-ge v4, v2, :cond_14

    move-object/from16 v0, p0

    iget v6, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    shl-int/lit8 v6, v6, 0x1

    move-object/from16 v0, p0

    iput v6, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    aget-boolean v6, v1, v4

    if-eqz v6, :cond_12

    move-object/from16 v0, p0

    iget v6, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    add-int/lit8 v6, v6, 0x1

    move-object/from16 v0, p0

    iput v6, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    :cond_12
    add-int/lit8 v4, v4, 0x1

    goto :goto_a

    :cond_13
    const/4 v2, 0x5

    const/16 v3, 0xb

    goto :goto_9

    :cond_14
    move v4, v2

    :goto_b
    add-int v6, v2, v3

    if-ge v4, v6, :cond_16

    move-object/from16 v0, p0

    iget v6, v0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    shl-int/lit8 v6, v6, 0x1

    move-object/from16 v0, p0

    iput v6, v0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    aget-boolean v6, v1, v4

    if-eqz v6, :cond_15

    move-object/from16 v0, p0

    iget v6, v0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    add-int/lit8 v6, v6, 0x1

    move-object/from16 v0, p0

    iput v6, v0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    :cond_15
    add-int/lit8 v4, v4, 0x1

    goto :goto_b

    :cond_16
    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    add-int/lit8 v1, v1, 0x1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    add-int/lit8 v1, v1, 0x1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    mul-int/lit8 v2, v1, 0x2

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    const/4 v3, 0x4

    if-le v1, v3, :cond_18

    const/4 v1, 0x1

    :goto_c
    add-int/2addr v1, v2

    move-object/from16 v0, p0

    iget v2, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    add-int/lit8 v2, v2, -0x4

    div-int/lit8 v2, v2, 0x8

    add-int/2addr v1, v2

    int-to-float v1, v1

    const/high16 v2, 0x40000000

    move-object/from16 v0, p0

    iget v3, v0, Lcom/google/zxing/aztec/detector/Detector;->e:I

    int-to-float v3, v3

    mul-float/2addr v2, v3

    div-float v2, v1, v2

    const/4 v1, 0x0

    aget-object v1, v5, v1

    iget v1, v1, Lcom/google/zxing/aztec/detector/a;->a:I

    const/4 v3, 0x2

    aget-object v3, v5, v3

    iget v3, v3, Lcom/google/zxing/aztec/detector/a;->a:I

    sub-int v3, v1, v3

    if-lez v3, :cond_19

    const/4 v1, 0x1

    :goto_d
    add-int/2addr v3, v1

    const/4 v1, 0x0

    aget-object v1, v5, v1

    iget v1, v1, Lcom/google/zxing/aztec/detector/a;->b:I

    const/4 v4, 0x2

    aget-object v4, v5, v4

    iget v4, v4, Lcom/google/zxing/aztec/detector/a;->b:I

    sub-int v4, v1, v4

    if-lez v4, :cond_1a

    const/4 v1, 0x1

    :goto_e
    add-int/2addr v1, v4

    const/4 v4, 0x2

    aget-object v4, v5, v4

    iget v4, v4, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v4, v4

    int-to-float v6, v3

    mul-float/2addr v6, v2

    sub-float/2addr v4, v6

    const/high16 v6, 0x3f000000

    add-float/2addr v4, v6

    float-to-int v4, v4

    const/4 v6, 0x2

    aget-object v6, v5, v6

    iget v6, v6, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v6, v6

    int-to-float v7, v1

    mul-float/2addr v7, v2

    sub-float/2addr v6, v7

    const/high16 v7, 0x3f000000

    add-float/2addr v6, v7

    float-to-int v6, v6

    const/4 v7, 0x0

    aget-object v7, v5, v7

    iget v7, v7, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v7, v7

    int-to-float v3, v3

    mul-float/2addr v3, v2

    add-float/2addr v3, v7

    const/high16 v7, 0x3f000000

    add-float/2addr v3, v7

    float-to-int v3, v3

    const/4 v7, 0x0

    aget-object v7, v5, v7

    iget v7, v7, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v7, v7

    int-to-float v1, v1

    mul-float/2addr v1, v2

    add-float/2addr v1, v7

    const/high16 v7, 0x3f000000

    add-float/2addr v1, v7

    float-to-int v7, v1

    const/4 v1, 0x1

    aget-object v1, v5, v1

    iget v1, v1, Lcom/google/zxing/aztec/detector/a;->a:I

    const/4 v8, 0x3

    aget-object v8, v5, v8

    iget v8, v8, Lcom/google/zxing/aztec/detector/a;->a:I

    sub-int v8, v1, v8

    if-lez v8, :cond_1b

    const/4 v1, 0x1

    :goto_f
    add-int/2addr v8, v1

    const/4 v1, 0x1

    aget-object v1, v5, v1

    iget v1, v1, Lcom/google/zxing/aztec/detector/a;->b:I

    const/4 v9, 0x3

    aget-object v9, v5, v9

    iget v9, v9, Lcom/google/zxing/aztec/detector/a;->b:I

    sub-int v9, v1, v9

    if-lez v9, :cond_1c

    const/4 v1, 0x1

    :goto_10
    add-int/2addr v1, v9

    const/4 v9, 0x3

    aget-object v9, v5, v9

    iget v9, v9, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v9, v9

    int-to-float v10, v8

    mul-float/2addr v10, v2

    sub-float/2addr v9, v10

    const/high16 v10, 0x3f000000

    add-float/2addr v9, v10

    float-to-int v9, v9

    const/4 v10, 0x3

    aget-object v10, v5, v10

    iget v10, v10, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v10, v10

    int-to-float v11, v1

    mul-float/2addr v11, v2

    sub-float/2addr v10, v11

    const/high16 v11, 0x3f000000

    add-float/2addr v10, v11

    float-to-int v10, v10

    const/4 v11, 0x1

    aget-object v11, v5, v11

    iget v11, v11, Lcom/google/zxing/aztec/detector/a;->a:I

    int-to-float v11, v11

    int-to-float v8, v8

    mul-float/2addr v8, v2

    add-float/2addr v8, v11

    const/high16 v11, 0x3f000000

    add-float/2addr v8, v11

    float-to-int v8, v8

    const/4 v11, 0x1

    aget-object v5, v5, v11

    iget v5, v5, Lcom/google/zxing/aztec/detector/a;->b:I

    int-to-float v5, v5

    int-to-float v1, v1

    mul-float/2addr v1, v2

    add-float/2addr v1, v5

    const/high16 v2, 0x3f000000

    add-float/2addr v1, v2

    float-to-int v1, v1

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v7}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v2

    if-eqz v2, :cond_17

    move-object/from16 v0, p0

    invoke-direct {v0, v8, v1}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v2

    if-eqz v2, :cond_17

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v6}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v2

    if-eqz v2, :cond_17

    move-object/from16 v0, p0

    invoke-direct {v0, v9, v10}, Lcom/google/zxing/aztec/detector/Detector;->a(II)Z

    move-result v2

    if-nez v2, :cond_1d

    :cond_17
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v1

    throw v1

    :cond_18
    const/4 v1, 0x0

    goto/16 :goto_c

    :cond_19
    const/4 v1, -0x1

    goto/16 :goto_d

    :cond_1a
    const/4 v1, -0x1

    goto/16 :goto_e

    :cond_1b
    const/4 v1, -0x1

    goto :goto_f

    :cond_1c
    const/4 v1, -0x1

    goto :goto_10

    :cond_1d
    const/4 v2, 0x4

    new-array v0, v2, [Lcom/google/zxing/ResultPoint;

    move-object/from16 v21, v0

    const/4 v2, 0x0

    new-instance v5, Lcom/google/zxing/ResultPoint;

    int-to-float v3, v3

    int-to-float v7, v7

    invoke-direct {v5, v3, v7}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v5, v21, v2

    const/4 v2, 0x1

    new-instance v3, Lcom/google/zxing/ResultPoint;

    int-to-float v5, v8

    int-to-float v1, v1

    invoke-direct {v3, v5, v1}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v3, v21, v2

    const/4 v1, 0x2

    new-instance v2, Lcom/google/zxing/ResultPoint;

    int-to-float v3, v4

    int-to-float v4, v6

    invoke-direct {v2, v3, v4}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v2, v21, v1

    const/4 v1, 0x3

    new-instance v2, Lcom/google/zxing/ResultPoint;

    int-to-float v3, v9

    int-to-float v4, v10

    invoke-direct {v2, v3, v4}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v2, v21, v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/zxing/aztec/detector/Detector;->a:Lcom/google/zxing/common/BitMatrix;

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    rem-int/lit8 v1, v1, 0x4

    aget-object v4, v21, v1

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    add-int/lit8 v1, v1, 0x3

    rem-int/lit8 v1, v1, 0x4

    aget-object v20, v21, v1

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    add-int/lit8 v1, v1, 0x2

    rem-int/lit8 v1, v1, 0x4

    aget-object v18, v21, v1

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->f:I

    add-int/lit8 v1, v1, 0x1

    rem-int/lit8 v1, v1, 0x4

    aget-object v16, v21, v1

    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/google/zxing/aztec/detector/Detector;->b:Z

    if-eqz v1, :cond_1e

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    mul-int/lit8 v1, v1, 0x4

    add-int/lit8 v3, v1, 0xb

    :goto_11
    invoke-static {}, Lcom/google/zxing/common/GridSampler;->getInstance()Lcom/google/zxing/common/GridSampler;

    move-result-object v1

    const/high16 v5, 0x3f000000

    const/high16 v6, 0x3f000000

    int-to-float v7, v3

    const/high16 v8, 0x3f000000

    sub-float/2addr v7, v8

    const/high16 v8, 0x3f000000

    int-to-float v9, v3

    const/high16 v10, 0x3f000000

    sub-float/2addr v9, v10

    int-to-float v10, v3

    const/high16 v11, 0x3f000000

    sub-float/2addr v10, v11

    const/high16 v11, 0x3f000000

    int-to-float v12, v3

    const/high16 v13, 0x3f000000

    sub-float/2addr v12, v13

    invoke-virtual {v4}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v13

    invoke-virtual {v4}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v14

    invoke-virtual/range {v16 .. v16}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v15

    invoke-virtual/range {v16 .. v16}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v16

    invoke-virtual/range {v18 .. v18}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v17

    invoke-virtual/range {v18 .. v18}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v18

    invoke-virtual/range {v20 .. v20}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v19

    invoke-virtual/range {v20 .. v20}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v20

    move v4, v3

    invoke-virtual/range {v1 .. v20}, Lcom/google/zxing/common/GridSampler;->sampleGrid(Lcom/google/zxing/common/BitMatrix;IIFFFFFFFFFFFFFFFF)Lcom/google/zxing/common/BitMatrix;

    move-result-object v2

    new-instance v1, Lcom/google/zxing/aztec/AztecDetectorResult;

    move-object/from16 v0, p0

    iget-boolean v4, v0, Lcom/google/zxing/aztec/detector/Detector;->b:Z

    move-object/from16 v0, p0

    iget v5, v0, Lcom/google/zxing/aztec/detector/Detector;->d:I

    move-object/from16 v0, p0

    iget v6, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    move-object/from16 v3, v21

    invoke-direct/range {v1 .. v6}, Lcom/google/zxing/aztec/AztecDetectorResult;-><init>(Lcom/google/zxing/common/BitMatrix;[Lcom/google/zxing/ResultPoint;ZII)V

    return-object v1

    :cond_1e
    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    const/4 v3, 0x4

    if-gt v1, v3, :cond_1f

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    mul-int/lit8 v1, v1, 0x4

    add-int/lit8 v3, v1, 0xf

    goto :goto_11

    :cond_1f
    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    mul-int/lit8 v1, v1, 0x4

    move-object/from16 v0, p0

    iget v3, v0, Lcom/google/zxing/aztec/detector/Detector;->c:I

    add-int/lit8 v3, v3, -0x4

    div-int/lit8 v3, v3, 0x8

    add-int/lit8 v3, v3, 0x1

    mul-int/lit8 v3, v3, 0x2

    add-int/2addr v1, v3

    add-int/lit8 v3, v1, 0xf

    goto :goto_11
.end method
