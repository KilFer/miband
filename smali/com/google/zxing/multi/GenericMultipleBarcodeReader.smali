.class public final Lcom/google/zxing/multi/GenericMultipleBarcodeReader;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/zxing/multi/MultipleBarcodeReader;


# static fields
.field private static final a:I = 0x64


# instance fields
.field private final b:Lcom/google/zxing/Reader;


# direct methods
.method public constructor <init>(Lcom/google/zxing/Reader;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/zxing/multi/GenericMultipleBarcodeReader;->b:Lcom/google/zxing/Reader;

    return-void
.end method

.method private static a(Lcom/google/zxing/Result;II)Lcom/google/zxing/Result;
    .locals 7

    invoke-virtual {p0}, Lcom/google/zxing/Result;->getResultPoints()[Lcom/google/zxing/ResultPoint;

    move-result-object v1

    if-nez v1, :cond_0

    :goto_0
    return-object p0

    :cond_0
    array-length v0, v1

    new-array v2, v0, [Lcom/google/zxing/ResultPoint;

    const/4 v0, 0x0

    :goto_1
    array-length v3, v1

    if-ge v0, v3, :cond_1

    aget-object v3, v1, v0

    new-instance v4, Lcom/google/zxing/ResultPoint;

    invoke-virtual {v3}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v5

    int-to-float v6, p1

    add-float/2addr v5, v6

    invoke-virtual {v3}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v3

    int-to-float v6, p2

    add-float/2addr v3, v6

    invoke-direct {v4, v5, v3}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v4, v2, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_1
    new-instance v0, Lcom/google/zxing/Result;

    invoke-virtual {p0}, Lcom/google/zxing/Result;->getText()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/google/zxing/Result;->getRawBytes()[B

    move-result-object v3

    invoke-virtual {p0}, Lcom/google/zxing/Result;->getBarcodeFormat()Lcom/google/zxing/BarcodeFormat;

    move-result-object v4

    invoke-direct {v0, v1, v3, v2, v4}, Lcom/google/zxing/Result;-><init>(Ljava/lang/String;[B[Lcom/google/zxing/ResultPoint;Lcom/google/zxing/BarcodeFormat;)V

    move-object p0, v0

    goto :goto_0
.end method

.method private a(Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;Ljava/util/List;II)V
    .locals 18
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/zxing/BinaryBitmap;",
            "Ljava/util/Map",
            "<",
            "Lcom/google/zxing/DecodeHintType;",
            "*>;",
            "Ljava/util/List",
            "<",
            "Lcom/google/zxing/Result;",
            ">;II)V"
        }
    .end annotation

    move/from16 v6, p5

    move/from16 v5, p4

    move-object/from16 v4, p3

    move-object/from16 v3, p2

    move-object/from16 v1, p0

    :goto_0
    :try_start_0
    iget-object v2, v1, Lcom/google/zxing/multi/GenericMultipleBarcodeReader;->b:Lcom/google/zxing/Reader;

    move-object/from16 v0, p1

    invoke-interface {v2, v0, v3}, Lcom/google/zxing/Reader;->decode(Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;)Lcom/google/zxing/Result;
    :try_end_0
    .catch Lcom/google/zxing/ReaderException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v7

    const/4 v8, 0x0

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_d

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/zxing/Result;

    invoke-virtual {v2}, Lcom/google/zxing/Result;->getText()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7}, Lcom/google/zxing/Result;->getText()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v2, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v2, 0x1

    :goto_1
    if-eqz v2, :cond_2

    :cond_1
    :goto_2
    return-void

    :cond_2
    invoke-virtual {v7}, Lcom/google/zxing/Result;->getResultPoints()[Lcom/google/zxing/ResultPoint;

    move-result-object v8

    if-nez v8, :cond_5

    move-object v2, v7

    :goto_3
    invoke-interface {v4, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-virtual {v7}, Lcom/google/zxing/Result;->getResultPoints()[Lcom/google/zxing/ResultPoint;

    move-result-object v12

    if-eqz v12, :cond_1

    array-length v2, v12

    if-eqz v2, :cond_1

    invoke-virtual/range {p1 .. p1}, Lcom/google/zxing/BinaryBitmap;->getWidth()I

    move-result v14

    invoke-virtual/range {p1 .. p1}, Lcom/google/zxing/BinaryBitmap;->getHeight()I

    move-result v15

    int-to-float v10, v14

    int-to-float v8, v15

    const/4 v9, 0x0

    const/4 v13, 0x0

    array-length v0, v12

    move/from16 v16, v0

    const/4 v2, 0x0

    move v11, v2

    :goto_4
    move/from16 v0, v16

    if-ge v11, v0, :cond_7

    aget-object v2, v12, v11

    invoke-virtual {v2}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v7

    invoke-virtual {v2}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v2

    cmpg-float v17, v7, v10

    if-gez v17, :cond_3

    move v10, v7

    :cond_3
    cmpg-float v17, v2, v8

    if-gez v17, :cond_4

    move v8, v2

    :cond_4
    cmpl-float v17, v7, v9

    if-lez v17, :cond_c

    :goto_5
    cmpl-float v9, v2, v13

    if-lez v9, :cond_b

    :goto_6
    add-int/lit8 v9, v11, 0x1

    move v11, v9

    move v13, v2

    move v9, v7

    goto :goto_4

    :cond_5
    array-length v2, v8

    new-array v9, v2, [Lcom/google/zxing/ResultPoint;

    const/4 v2, 0x0

    :goto_7
    array-length v10, v8

    if-ge v2, v10, :cond_6

    aget-object v10, v8, v2

    new-instance v11, Lcom/google/zxing/ResultPoint;

    invoke-virtual {v10}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v12

    int-to-float v13, v5

    add-float/2addr v12, v13

    invoke-virtual {v10}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v10

    int-to-float v13, v6

    add-float/2addr v10, v13

    invoke-direct {v11, v12, v10}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v11, v9, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_7

    :cond_6
    new-instance v2, Lcom/google/zxing/Result;

    invoke-virtual {v7}, Lcom/google/zxing/Result;->getText()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7}, Lcom/google/zxing/Result;->getRawBytes()[B

    move-result-object v10

    invoke-virtual {v7}, Lcom/google/zxing/Result;->getBarcodeFormat()Lcom/google/zxing/BarcodeFormat;

    move-result-object v11

    invoke-direct {v2, v8, v10, v9, v11}, Lcom/google/zxing/Result;-><init>(Ljava/lang/String;[B[Lcom/google/zxing/ResultPoint;Lcom/google/zxing/BarcodeFormat;)V

    goto :goto_3

    :cond_7
    const/high16 v2, 0x42c80000

    cmpl-float v2, v10, v2

    if-lez v2, :cond_8

    const/4 v2, 0x0

    const/4 v7, 0x0

    float-to-int v10, v10

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v7, v10, v15}, Lcom/google/zxing/BinaryBitmap;->crop(IIII)Lcom/google/zxing/BinaryBitmap;

    move-result-object v2

    invoke-direct/range {v1 .. v6}, Lcom/google/zxing/multi/GenericMultipleBarcodeReader;->a(Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;Ljava/util/List;II)V

    :cond_8
    const/high16 v2, 0x42c80000

    cmpl-float v2, v8, v2

    if-lez v2, :cond_9

    const/4 v2, 0x0

    const/4 v7, 0x0

    float-to-int v8, v8

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v7, v14, v8}, Lcom/google/zxing/BinaryBitmap;->crop(IIII)Lcom/google/zxing/BinaryBitmap;

    move-result-object v2

    invoke-direct/range {v1 .. v6}, Lcom/google/zxing/multi/GenericMultipleBarcodeReader;->a(Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;Ljava/util/List;II)V

    :cond_9
    add-int/lit8 v2, v14, -0x64

    int-to-float v2, v2

    cmpg-float v2, v9, v2

    if-gez v2, :cond_a

    float-to-int v2, v9

    const/4 v7, 0x0

    float-to-int v8, v9

    sub-int v8, v14, v8

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v7, v8, v15}, Lcom/google/zxing/BinaryBitmap;->crop(IIII)Lcom/google/zxing/BinaryBitmap;

    move-result-object v8

    float-to-int v2, v9

    add-int v11, v5, v2

    move-object v7, v1

    move-object v9, v3

    move-object v10, v4

    move v12, v6

    invoke-direct/range {v7 .. v12}, Lcom/google/zxing/multi/GenericMultipleBarcodeReader;->a(Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;Ljava/util/List;II)V

    :cond_a
    add-int/lit8 v2, v15, -0x64

    int-to-float v2, v2

    cmpg-float v2, v13, v2

    if-gez v2, :cond_1

    const/4 v2, 0x0

    float-to-int v7, v13

    float-to-int v8, v13

    sub-int v8, v15, v8

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v7, v14, v8}, Lcom/google/zxing/BinaryBitmap;->crop(IIII)Lcom/google/zxing/BinaryBitmap;

    move-result-object p1

    float-to-int v2, v13

    add-int/2addr v6, v2

    goto/16 :goto_0

    :catch_0
    move-exception v1

    goto/16 :goto_2

    :cond_b
    move v2, v13

    goto/16 :goto_6

    :cond_c
    move v7, v9

    goto/16 :goto_5

    :cond_d
    move v2, v8

    goto/16 :goto_1
.end method


# virtual methods
.method public final decodeMultiple(Lcom/google/zxing/BinaryBitmap;)[Lcom/google/zxing/Result;
    .locals 1

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/google/zxing/multi/GenericMultipleBarcodeReader;->decodeMultiple(Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;)[Lcom/google/zxing/Result;

    move-result-object v0

    return-object v0
.end method

.method public final decodeMultiple(Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;)[Lcom/google/zxing/Result;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/zxing/BinaryBitmap;",
            "Ljava/util/Map",
            "<",
            "Lcom/google/zxing/DecodeHintType;",
            "*>;)[",
            "Lcom/google/zxing/Result;"
        }
    .end annotation

    const/4 v4, 0x0

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v5, v4

    invoke-direct/range {v0 .. v5}, Lcom/google/zxing/multi/GenericMultipleBarcodeReader;->a(Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;Ljava/util/List;II)V

    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_0
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v0

    new-array v0, v0, [Lcom/google/zxing/Result;

    invoke-interface {v3, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/zxing/Result;

    return-object v0
.end method
