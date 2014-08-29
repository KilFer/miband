.class public final Lcom/google/zxing/common/HybridBinarizer;
.super Lcom/google/zxing/common/GlobalHistogramBinarizer;


# static fields
.field private static final a:I = 0x3

.field private static final b:I = 0x8

.field private static final c:I = 0x7

.field private static final d:I = 0x28


# instance fields
.field private e:Lcom/google/zxing/common/BitMatrix;


# direct methods
.method public constructor <init>(Lcom/google/zxing/LuminanceSource;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/google/zxing/common/GlobalHistogramBinarizer;-><init>(Lcom/google/zxing/LuminanceSource;)V

    return-void
.end method

.method private static a([BIIIILcom/google/zxing/common/BitMatrix;)V
    .locals 7

    const/16 v6, 0x8

    const/4 v1, 0x0

    mul-int v0, p2, p4

    add-int/2addr v0, p1

    move v2, v0

    move v3, v1

    :goto_0
    if-ge v3, v6, :cond_2

    move v0, v1

    :goto_1
    if-ge v0, v6, :cond_1

    add-int v4, v2, v0

    aget-byte v4, p0, v4

    and-int/lit16 v4, v4, 0xff

    if-gt v4, p3, :cond_0

    add-int v4, p1, v0

    add-int v5, p2, v3

    invoke-virtual {p5, v4, v5}, Lcom/google/zxing/common/BitMatrix;->set(II)V

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_1
    add-int/lit8 v3, v3, 0x1

    add-int v0, v2, p4

    move v2, v0

    goto :goto_0

    :cond_2
    return-void
.end method

.method private static a([BIIII[[ILcom/google/zxing/common/BitMatrix;)V
    .locals 12

    const/4 v5, 0x0

    :goto_0
    if-ge v5, p2, :cond_a

    shl-int/lit8 v1, v5, 0x3

    add-int/lit8 v2, v1, 0x8

    move/from16 v0, p4

    if-lt v2, v0, :cond_0

    add-int/lit8 v1, p4, -0x8

    :cond_0
    const/4 v7, 0x0

    :goto_1
    if-ge v7, p1, :cond_9

    shl-int/lit8 v2, v7, 0x3

    add-int/lit8 v3, v2, 0x8

    if-lt v3, p3, :cond_b

    add-int/lit8 v2, p3, -0x8

    move v8, v2

    :goto_2
    const/4 v2, 0x1

    if-le v7, v2, :cond_1

    move v2, v7

    :goto_3
    add-int/lit8 v3, p1, -0x2

    if-ge v2, v3, :cond_2

    move v6, v2

    :goto_4
    const/4 v2, 0x1

    if-le v5, v2, :cond_3

    move v2, v5

    :goto_5
    add-int/lit8 v3, p2, -0x2

    if-ge v2, v3, :cond_4

    :goto_6
    const/4 v4, 0x0

    const/4 v3, -0x2

    :goto_7
    const/4 v9, 0x2

    if-gt v3, v9, :cond_5

    add-int v9, v2, v3

    aget-object v9, p5, v9

    add-int/lit8 v10, v6, -0x2

    aget v10, v9, v10

    add-int/lit8 v11, v6, -0x1

    aget v11, v9, v11

    add-int/2addr v10, v11

    aget v11, v9, v6

    add-int/2addr v10, v11

    add-int/lit8 v11, v6, 0x1

    aget v11, v9, v11

    add-int/2addr v10, v11

    add-int/lit8 v11, v6, 0x2

    aget v9, v9, v11

    add-int/2addr v9, v10

    add-int/2addr v4, v9

    add-int/lit8 v3, v3, 0x1

    goto :goto_7

    :cond_1
    const/4 v2, 0x2

    goto :goto_3

    :cond_2
    add-int/lit8 v2, p1, -0x3

    move v6, v2

    goto :goto_4

    :cond_3
    const/4 v2, 0x2

    goto :goto_5

    :cond_4
    add-int/lit8 v2, p2, -0x3

    goto :goto_6

    :cond_5
    div-int/lit8 v6, v4, 0x19

    const/4 v3, 0x0

    mul-int v2, v1, p3

    add-int/2addr v2, v8

    move v4, v3

    move v3, v2

    :goto_8
    const/16 v2, 0x8

    if-ge v4, v2, :cond_8

    const/4 v2, 0x0

    :goto_9
    const/16 v9, 0x8

    if-ge v2, v9, :cond_7

    add-int v9, v3, v2

    aget-byte v9, p0, v9

    and-int/lit16 v9, v9, 0xff

    if-gt v9, v6, :cond_6

    add-int v9, v8, v2

    add-int v10, v1, v4

    move-object/from16 v0, p6

    invoke-virtual {v0, v9, v10}, Lcom/google/zxing/common/BitMatrix;->set(II)V

    :cond_6
    add-int/lit8 v2, v2, 0x1

    goto :goto_9

    :cond_7
    add-int/lit8 v4, v4, 0x1

    add-int v2, v3, p3

    move v3, v2

    goto :goto_8

    :cond_8
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    :cond_9
    add-int/lit8 v5, v5, 0x1

    goto/16 :goto_0

    :cond_a
    return-void

    :cond_b
    move v8, v2

    goto :goto_2
.end method

.method private static a([BIIII)[[I
    .locals 11

    filled-new-array {p2, p1}, [I

    move-result-object v0

    sget-object v1, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[I

    const/4 v1, 0x0

    move v10, v1

    :goto_0
    if-ge v10, p2, :cond_7

    shl-int/lit8 v1, v10, 0x3

    add-int/lit8 v2, v1, 0x8

    if-lt v2, p4, :cond_0

    add-int/lit8 v1, p4, -0x8

    :cond_0
    const/4 v2, 0x0

    move v9, v2

    :goto_1
    if-ge v9, p1, :cond_6

    shl-int/lit8 v2, v9, 0x3

    add-int/lit8 v3, v2, 0x8

    if-lt v3, p3, :cond_1

    add-int/lit8 v2, p3, -0x8

    :cond_1
    const/4 v6, 0x0

    const/16 v5, 0xff

    const/4 v4, 0x0

    const/4 v3, 0x0

    mul-int v7, v1, p3

    add-int/2addr v2, v7

    move v7, v3

    move v8, v2

    move v3, v4

    move v4, v5

    move v5, v6

    :goto_2
    const/16 v2, 0x8

    if-ge v7, v2, :cond_4

    const/4 v2, 0x0

    move v6, v5

    move v5, v2

    :goto_3
    const/16 v2, 0x8

    if-ge v5, v2, :cond_3

    add-int v2, v8, v5

    aget-byte v2, p0, v2

    and-int/lit16 v2, v2, 0xff

    add-int/2addr v6, v2

    if-ge v2, v4, :cond_2

    move v4, v2

    :cond_2
    if-le v2, v3, :cond_9

    :goto_4
    add-int/lit8 v3, v5, 0x1

    move v5, v3

    move v3, v2

    goto :goto_3

    :cond_3
    add-int/lit8 v2, v7, 0x1

    add-int v5, v8, p3

    move v7, v2

    move v8, v5

    move v5, v6

    goto :goto_2

    :cond_4
    shr-int/lit8 v2, v5, 0x6

    sub-int/2addr v3, v4

    const/16 v5, 0x18

    if-gt v3, v5, :cond_5

    shr-int/lit8 v3, v4, 0x1

    if-lez v10, :cond_8

    if-lez v9, :cond_8

    add-int/lit8 v2, v10, -0x1

    aget-object v2, v0, v2

    aget v2, v2, v9

    aget-object v5, v0, v10

    add-int/lit8 v6, v9, -0x1

    aget v5, v5, v6

    mul-int/lit8 v5, v5, 0x2

    add-int/2addr v2, v5

    add-int/lit8 v5, v10, -0x1

    aget-object v5, v0, v5

    add-int/lit8 v6, v9, -0x1

    aget v5, v5, v6

    add-int/2addr v2, v5

    shr-int/lit8 v2, v2, 0x2

    if-ge v4, v2, :cond_8

    :cond_5
    :goto_5
    aget-object v3, v0, v10

    aput v2, v3, v9

    add-int/lit8 v2, v9, 0x1

    move v9, v2

    goto :goto_1

    :cond_6
    add-int/lit8 v1, v10, 0x1

    move v10, v1

    goto :goto_0

    :cond_7
    return-object v0

    :cond_8
    move v2, v3

    goto :goto_5

    :cond_9
    move v2, v3

    goto :goto_4
.end method


# virtual methods
.method public final createBinarizer(Lcom/google/zxing/LuminanceSource;)Lcom/google/zxing/Binarizer;
    .locals 1

    new-instance v0, Lcom/google/zxing/common/HybridBinarizer;

    invoke-direct {v0, p1}, Lcom/google/zxing/common/HybridBinarizer;-><init>(Lcom/google/zxing/LuminanceSource;)V

    return-object v0
.end method

.method public final getBlackMatrix()Lcom/google/zxing/common/BitMatrix;
    .locals 19

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/zxing/common/HybridBinarizer;->e:Lcom/google/zxing/common/BitMatrix;

    if-eqz v1, :cond_0

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/zxing/common/HybridBinarizer;->e:Lcom/google/zxing/common/BitMatrix;

    :goto_0
    return-object v1

    :cond_0
    invoke-virtual/range {p0 .. p0}, Lcom/google/zxing/common/HybridBinarizer;->getLuminanceSource()Lcom/google/zxing/LuminanceSource;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/zxing/LuminanceSource;->getWidth()I

    move-result v2

    const/16 v3, 0x28

    if-lt v2, v3, :cond_13

    invoke-virtual {v1}, Lcom/google/zxing/LuminanceSource;->getHeight()I

    move-result v2

    const/16 v3, 0x28

    if-lt v2, v3, :cond_13

    invoke-virtual {v1}, Lcom/google/zxing/LuminanceSource;->getMatrix()[B

    move-result-object v14

    invoke-virtual {v1}, Lcom/google/zxing/LuminanceSource;->getWidth()I

    move-result v15

    invoke-virtual {v1}, Lcom/google/zxing/LuminanceSource;->getHeight()I

    move-result v16

    shr-int/lit8 v1, v15, 0x3

    and-int/lit8 v2, v15, 0x7

    if-eqz v2, :cond_19

    add-int/lit8 v1, v1, 0x1

    move v13, v1

    :goto_1
    shr-int/lit8 v1, v16, 0x3

    and-int/lit8 v2, v16, 0x7

    if-eqz v2, :cond_18

    add-int/lit8 v1, v1, 0x1

    move v2, v1

    :goto_2
    filled-new-array {v2, v13}, [I

    move-result-object v1

    sget-object v3, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-static {v3, v1}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [[I

    const/4 v3, 0x0

    move v12, v3

    :goto_3
    if-ge v12, v2, :cond_8

    shl-int/lit8 v3, v12, 0x3

    add-int/lit8 v4, v3, 0x8

    move/from16 v0, v16

    if-lt v4, v0, :cond_1

    add-int/lit8 v3, v16, -0x8

    :cond_1
    const/4 v4, 0x0

    move v11, v4

    :goto_4
    if-ge v11, v13, :cond_7

    shl-int/lit8 v4, v11, 0x3

    add-int/lit8 v5, v4, 0x8

    if-lt v5, v15, :cond_2

    add-int/lit8 v4, v15, -0x8

    :cond_2
    const/4 v8, 0x0

    const/16 v7, 0xff

    const/4 v6, 0x0

    const/4 v5, 0x0

    mul-int v9, v3, v15

    add-int/2addr v4, v9

    move v9, v4

    move v10, v5

    move v5, v6

    move v6, v7

    move v7, v8

    :goto_5
    const/16 v4, 0x8

    if-ge v10, v4, :cond_5

    const/4 v4, 0x0

    move v8, v7

    move v7, v4

    :goto_6
    const/16 v4, 0x8

    if-ge v7, v4, :cond_4

    add-int v4, v9, v7

    aget-byte v4, v14, v4

    and-int/lit16 v4, v4, 0xff

    add-int/2addr v8, v4

    if-ge v4, v6, :cond_3

    move v6, v4

    :cond_3
    if-le v4, v5, :cond_17

    :goto_7
    add-int/lit8 v5, v7, 0x1

    move v7, v5

    move v5, v4

    goto :goto_6

    :cond_4
    add-int/lit8 v7, v10, 0x1

    add-int v4, v9, v15

    move v9, v4

    move v10, v7

    move v7, v8

    goto :goto_5

    :cond_5
    shr-int/lit8 v4, v7, 0x6

    sub-int/2addr v5, v6

    const/16 v7, 0x18

    if-gt v5, v7, :cond_6

    shr-int/lit8 v5, v6, 0x1

    if-lez v12, :cond_16

    if-lez v11, :cond_16

    add-int/lit8 v4, v12, -0x1

    aget-object v4, v1, v4

    aget v4, v4, v11

    aget-object v7, v1, v12

    add-int/lit8 v8, v11, -0x1

    aget v7, v7, v8

    mul-int/lit8 v7, v7, 0x2

    add-int/2addr v4, v7

    add-int/lit8 v7, v12, -0x1

    aget-object v7, v1, v7

    add-int/lit8 v8, v11, -0x1

    aget v7, v7, v8

    add-int/2addr v4, v7

    shr-int/lit8 v4, v4, 0x2

    if-ge v6, v4, :cond_16

    :cond_6
    :goto_8
    aget-object v5, v1, v12

    aput v4, v5, v11

    add-int/lit8 v4, v11, 0x1

    move v11, v4

    goto :goto_4

    :cond_7
    add-int/lit8 v3, v12, 0x1

    move v12, v3

    goto :goto_3

    :cond_8
    new-instance v11, Lcom/google/zxing/common/BitMatrix;

    move/from16 v0, v16

    invoke-direct {v11, v15, v0}, Lcom/google/zxing/common/BitMatrix;-><init>(II)V

    const/4 v3, 0x0

    move v5, v3

    :goto_9
    if-ge v5, v2, :cond_12

    shl-int/lit8 v3, v5, 0x3

    add-int/lit8 v4, v3, 0x8

    move/from16 v0, v16

    if-lt v4, v0, :cond_14

    add-int/lit8 v3, v16, -0x8

    move v4, v3

    :goto_a
    const/4 v9, 0x0

    :goto_b
    if-ge v9, v13, :cond_11

    shl-int/lit8 v3, v9, 0x3

    add-int/lit8 v6, v3, 0x8

    if-lt v6, v15, :cond_15

    add-int/lit8 v3, v15, -0x8

    move v10, v3

    :goto_c
    const/4 v3, 0x1

    if-le v9, v3, :cond_9

    move v3, v9

    :goto_d
    add-int/lit8 v6, v13, -0x2

    if-ge v3, v6, :cond_a

    move v8, v3

    :goto_e
    const/4 v3, 0x1

    if-le v5, v3, :cond_b

    move v3, v5

    :goto_f
    add-int/lit8 v6, v2, -0x2

    if-ge v3, v6, :cond_c

    :goto_10
    const/4 v7, 0x0

    const/4 v6, -0x2

    :goto_11
    const/4 v12, 0x2

    if-gt v6, v12, :cond_d

    add-int v12, v3, v6

    aget-object v12, v1, v12

    add-int/lit8 v17, v8, -0x2

    aget v17, v12, v17

    add-int/lit8 v18, v8, -0x1

    aget v18, v12, v18

    add-int v17, v17, v18

    aget v18, v12, v8

    add-int v17, v17, v18

    add-int/lit8 v18, v8, 0x1

    aget v18, v12, v18

    add-int v17, v17, v18

    add-int/lit8 v18, v8, 0x2

    aget v12, v12, v18

    add-int v12, v12, v17

    add-int/2addr v7, v12

    add-int/lit8 v6, v6, 0x1

    goto :goto_11

    :cond_9
    const/4 v3, 0x2

    goto :goto_d

    :cond_a
    add-int/lit8 v3, v13, -0x3

    move v8, v3

    goto :goto_e

    :cond_b
    const/4 v3, 0x2

    goto :goto_f

    :cond_c
    add-int/lit8 v3, v2, -0x3

    goto :goto_10

    :cond_d
    div-int/lit8 v8, v7, 0x19

    const/4 v6, 0x0

    mul-int v3, v4, v15

    add-int/2addr v3, v10

    move v7, v6

    move v6, v3

    :goto_12
    const/16 v3, 0x8

    if-ge v7, v3, :cond_10

    const/4 v3, 0x0

    :goto_13
    const/16 v12, 0x8

    if-ge v3, v12, :cond_f

    add-int v12, v6, v3

    aget-byte v12, v14, v12

    and-int/lit16 v12, v12, 0xff

    if-gt v12, v8, :cond_e

    add-int v12, v10, v3

    add-int v17, v4, v7

    move/from16 v0, v17

    invoke-virtual {v11, v12, v0}, Lcom/google/zxing/common/BitMatrix;->set(II)V

    :cond_e
    add-int/lit8 v3, v3, 0x1

    goto :goto_13

    :cond_f
    add-int/lit8 v7, v7, 0x1

    add-int v3, v6, v15

    move v6, v3

    goto :goto_12

    :cond_10
    add-int/lit8 v9, v9, 0x1

    goto :goto_b

    :cond_11
    add-int/lit8 v3, v5, 0x1

    move v5, v3

    goto/16 :goto_9

    :cond_12
    move-object/from16 v0, p0

    iput-object v11, v0, Lcom/google/zxing/common/HybridBinarizer;->e:Lcom/google/zxing/common/BitMatrix;

    :goto_14
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/zxing/common/HybridBinarizer;->e:Lcom/google/zxing/common/BitMatrix;

    goto/16 :goto_0

    :cond_13
    invoke-super/range {p0 .. p0}, Lcom/google/zxing/common/GlobalHistogramBinarizer;->getBlackMatrix()Lcom/google/zxing/common/BitMatrix;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/google/zxing/common/HybridBinarizer;->e:Lcom/google/zxing/common/BitMatrix;

    goto :goto_14

    :cond_14
    move v4, v3

    goto/16 :goto_a

    :cond_15
    move v10, v3

    goto/16 :goto_c

    :cond_16
    move v4, v5

    goto/16 :goto_8

    :cond_17
    move v4, v5

    goto/16 :goto_7

    :cond_18
    move v2, v1

    goto/16 :goto_2

    :cond_19
    move v13, v1

    goto/16 :goto_1
.end method
