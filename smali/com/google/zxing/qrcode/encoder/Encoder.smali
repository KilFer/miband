.class public final Lcom/google/zxing/qrcode/encoder/Encoder;
.super Ljava/lang/Object;


# static fields
.field private static final a:[I

.field private static b:Ljava/lang/String; = "ISO-8859-1"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/16 v0, 0x60

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/google/zxing/qrcode/encoder/Encoder;->a:[I

    return-void

    :array_0
    .array-data 4
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        0x24
        -0x1
        -0x1
        -0x1
        0x25
        0x26
        -0x1
        -0x1
        -0x1
        -0x1
        0x27
        0x28
        -0x1
        0x29
        0x2a
        0x2b
        0x0
        0x1
        0x2
        0x3
        0x4
        0x5
        0x6
        0x7
        0x8
        0x9
        0x2c
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
        0xa
        0xb
        0xc
        0xd
        0xe
        0xf
        0x10
        0x11
        0x12
        0x13
        0x14
        0x15
        0x16
        0x17
        0x18
        0x19
        0x1a
        0x1b
        0x1c
        0x1d
        0x1e
        0x1f
        0x20
        0x21
        0x22
        0x23
        -0x1
        -0x1
        -0x1
        -0x1
        -0x1
    .end array-data
.end method

.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static a(I)I
    .locals 1

    sget-object v0, Lcom/google/zxing/qrcode/encoder/Encoder;->a:[I

    array-length v0, v0

    if-ge p0, v0, :cond_0

    sget-object v0, Lcom/google/zxing/qrcode/encoder/Encoder;->a:[I

    aget v0, v0, p0

    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method private static a(ILcom/google/zxing/qrcode/decoder/Version;Lcom/google/zxing/qrcode/decoder/Mode;)I
    .locals 1

    invoke-virtual {p2, p1}, Lcom/google/zxing/qrcode/decoder/Mode;->getCharacterCountBits(Lcom/google/zxing/qrcode/decoder/Version;)I

    move-result v0

    add-int/lit8 v0, v0, 0x4

    add-int/2addr v0, p0

    add-int/lit8 v0, v0, 0x7

    div-int/lit8 v0, v0, 0x8

    return v0
.end method

.method private static a(Lcom/google/zxing/common/BitArray;Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;ILcom/google/zxing/qrcode/encoder/ByteMatrix;)I
    .locals 18

    const v7, 0x7fffffff

    const/4 v6, -0x1

    const/4 v5, 0x0

    :goto_0
    const/16 v4, 0x8

    if-ge v5, v4, :cond_e

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, p2

    move-object/from16 v3, p3

    invoke-static {v0, v1, v2, v5, v3}, Lcom/google/zxing/qrcode/encoder/d;->a(Lcom/google/zxing/common/BitArray;Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;IILcom/google/zxing/qrcode/encoder/ByteMatrix;)V

    invoke-static/range {p3 .. p3}, Lcom/google/zxing/qrcode/encoder/a;->a(Lcom/google/zxing/qrcode/encoder/ByteMatrix;)I

    move-result v4

    add-int/lit8 v10, v4, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {p3 .. p3}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getArray()[[B

    move-result-object v11

    invoke-virtual/range {p3 .. p3}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getWidth()I

    move-result v12

    invoke-virtual/range {p3 .. p3}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getHeight()I

    move-result v13

    const/4 v4, 0x0

    move v9, v4

    :goto_1
    add-int/lit8 v4, v13, -0x1

    if-ge v9, v4, :cond_2

    const/4 v4, 0x0

    move/from16 v17, v4

    move v4, v8

    move/from16 v8, v17

    :goto_2
    add-int/lit8 v14, v12, -0x1

    if-ge v8, v14, :cond_1

    aget-object v14, v11, v9

    aget-byte v14, v14, v8

    aget-object v15, v11, v9

    add-int/lit8 v16, v8, 0x1

    aget-byte v15, v15, v16

    if-ne v14, v15, :cond_0

    add-int/lit8 v15, v9, 0x1

    aget-object v15, v11, v15

    aget-byte v15, v15, v8

    if-ne v14, v15, :cond_0

    add-int/lit8 v15, v9, 0x1

    aget-object v15, v11, v15

    add-int/lit8 v16, v8, 0x1

    aget-byte v15, v15, v16

    if-ne v14, v15, :cond_0

    add-int/lit8 v4, v4, 0x3

    :cond_0
    add-int/lit8 v8, v8, 0x1

    goto :goto_2

    :cond_1
    add-int/lit8 v8, v9, 0x1

    move v9, v8

    move v8, v4

    goto :goto_1

    :cond_2
    add-int/2addr v10, v8

    const/4 v8, 0x0

    invoke-virtual/range {p3 .. p3}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getArray()[[B

    move-result-object v11

    invoke-virtual/range {p3 .. p3}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getWidth()I

    move-result v12

    invoke-virtual/range {p3 .. p3}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getHeight()I

    move-result v13

    const/4 v4, 0x0

    move v9, v4

    :goto_3
    if-ge v9, v13, :cond_a

    const/4 v4, 0x0

    move/from16 v17, v4

    move v4, v8

    move/from16 v8, v17

    :goto_4
    if-ge v8, v12, :cond_9

    add-int/lit8 v14, v8, 0x6

    if-ge v14, v12, :cond_5

    aget-object v14, v11, v9

    aget-byte v14, v14, v8

    const/4 v15, 0x1

    if-ne v14, v15, :cond_5

    aget-object v14, v11, v9

    add-int/lit8 v15, v8, 0x1

    aget-byte v14, v14, v15

    if-nez v14, :cond_5

    aget-object v14, v11, v9

    add-int/lit8 v15, v8, 0x2

    aget-byte v14, v14, v15

    const/4 v15, 0x1

    if-ne v14, v15, :cond_5

    aget-object v14, v11, v9

    add-int/lit8 v15, v8, 0x3

    aget-byte v14, v14, v15

    const/4 v15, 0x1

    if-ne v14, v15, :cond_5

    aget-object v14, v11, v9

    add-int/lit8 v15, v8, 0x4

    aget-byte v14, v14, v15

    const/4 v15, 0x1

    if-ne v14, v15, :cond_5

    aget-object v14, v11, v9

    add-int/lit8 v15, v8, 0x5

    aget-byte v14, v14, v15

    if-nez v14, :cond_5

    aget-object v14, v11, v9

    add-int/lit8 v15, v8, 0x6

    aget-byte v14, v14, v15

    const/4 v15, 0x1

    if-ne v14, v15, :cond_5

    add-int/lit8 v14, v8, 0xa

    if-ge v14, v12, :cond_3

    aget-object v14, v11, v9

    add-int/lit8 v15, v8, 0x7

    aget-byte v14, v14, v15

    if-nez v14, :cond_3

    aget-object v14, v11, v9

    add-int/lit8 v15, v8, 0x8

    aget-byte v14, v14, v15

    if-nez v14, :cond_3

    aget-object v14, v11, v9

    add-int/lit8 v15, v8, 0x9

    aget-byte v14, v14, v15

    if-nez v14, :cond_3

    aget-object v14, v11, v9

    add-int/lit8 v15, v8, 0xa

    aget-byte v14, v14, v15

    if-eqz v14, :cond_4

    :cond_3
    add-int/lit8 v14, v8, -0x4

    if-ltz v14, :cond_5

    aget-object v14, v11, v9

    add-int/lit8 v15, v8, -0x1

    aget-byte v14, v14, v15

    if-nez v14, :cond_5

    aget-object v14, v11, v9

    add-int/lit8 v15, v8, -0x2

    aget-byte v14, v14, v15

    if-nez v14, :cond_5

    aget-object v14, v11, v9

    add-int/lit8 v15, v8, -0x3

    aget-byte v14, v14, v15

    if-nez v14, :cond_5

    aget-object v14, v11, v9

    add-int/lit8 v15, v8, -0x4

    aget-byte v14, v14, v15

    if-nez v14, :cond_5

    :cond_4
    add-int/lit8 v4, v4, 0x28

    :cond_5
    add-int/lit8 v14, v9, 0x6

    if-ge v14, v13, :cond_8

    aget-object v14, v11, v9

    aget-byte v14, v14, v8

    const/4 v15, 0x1

    if-ne v14, v15, :cond_8

    add-int/lit8 v14, v9, 0x1

    aget-object v14, v11, v14

    aget-byte v14, v14, v8

    if-nez v14, :cond_8

    add-int/lit8 v14, v9, 0x2

    aget-object v14, v11, v14

    aget-byte v14, v14, v8

    const/4 v15, 0x1

    if-ne v14, v15, :cond_8

    add-int/lit8 v14, v9, 0x3

    aget-object v14, v11, v14

    aget-byte v14, v14, v8

    const/4 v15, 0x1

    if-ne v14, v15, :cond_8

    add-int/lit8 v14, v9, 0x4

    aget-object v14, v11, v14

    aget-byte v14, v14, v8

    const/4 v15, 0x1

    if-ne v14, v15, :cond_8

    add-int/lit8 v14, v9, 0x5

    aget-object v14, v11, v14

    aget-byte v14, v14, v8

    if-nez v14, :cond_8

    add-int/lit8 v14, v9, 0x6

    aget-object v14, v11, v14

    aget-byte v14, v14, v8

    const/4 v15, 0x1

    if-ne v14, v15, :cond_8

    add-int/lit8 v14, v9, 0xa

    if-ge v14, v13, :cond_6

    add-int/lit8 v14, v9, 0x7

    aget-object v14, v11, v14

    aget-byte v14, v14, v8

    if-nez v14, :cond_6

    add-int/lit8 v14, v9, 0x8

    aget-object v14, v11, v14

    aget-byte v14, v14, v8

    if-nez v14, :cond_6

    add-int/lit8 v14, v9, 0x9

    aget-object v14, v11, v14

    aget-byte v14, v14, v8

    if-nez v14, :cond_6

    add-int/lit8 v14, v9, 0xa

    aget-object v14, v11, v14

    aget-byte v14, v14, v8

    if-eqz v14, :cond_7

    :cond_6
    add-int/lit8 v14, v9, -0x4

    if-ltz v14, :cond_8

    add-int/lit8 v14, v9, -0x1

    aget-object v14, v11, v14

    aget-byte v14, v14, v8

    if-nez v14, :cond_8

    add-int/lit8 v14, v9, -0x2

    aget-object v14, v11, v14

    aget-byte v14, v14, v8

    if-nez v14, :cond_8

    add-int/lit8 v14, v9, -0x3

    aget-object v14, v11, v14

    aget-byte v14, v14, v8

    if-nez v14, :cond_8

    add-int/lit8 v14, v9, -0x4

    aget-object v14, v11, v14

    aget-byte v14, v14, v8

    if-nez v14, :cond_8

    :cond_7
    add-int/lit8 v4, v4, 0x28

    :cond_8
    add-int/lit8 v8, v8, 0x1

    goto/16 :goto_4

    :cond_9
    add-int/lit8 v8, v9, 0x1

    move v9, v8

    move v8, v4

    goto/16 :goto_3

    :cond_a
    add-int/2addr v10, v8

    const/4 v8, 0x0

    invoke-virtual/range {p3 .. p3}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getArray()[[B

    move-result-object v11

    invoke-virtual/range {p3 .. p3}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getWidth()I

    move-result v12

    invoke-virtual/range {p3 .. p3}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getHeight()I

    move-result v13

    const/4 v4, 0x0

    move v9, v4

    :goto_5
    if-ge v9, v13, :cond_d

    const/4 v4, 0x0

    move/from16 v17, v4

    move v4, v8

    move/from16 v8, v17

    :goto_6
    if-ge v8, v12, :cond_c

    aget-object v14, v11, v9

    aget-byte v14, v14, v8

    const/4 v15, 0x1

    if-ne v14, v15, :cond_b

    add-int/lit8 v4, v4, 0x1

    :cond_b
    add-int/lit8 v8, v8, 0x1

    goto :goto_6

    :cond_c
    add-int/lit8 v8, v9, 0x1

    move v9, v8

    move v8, v4

    goto :goto_5

    :cond_d
    invoke-virtual/range {p3 .. p3}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getHeight()I

    move-result v4

    invoke-virtual/range {p3 .. p3}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getWidth()I

    move-result v9

    mul-int/2addr v4, v9

    int-to-double v8, v8

    int-to-double v11, v4

    div-double/2addr v8, v11

    const-wide/high16 v11, 0x4059000000000000L

    mul-double/2addr v8, v11

    const-wide/high16 v11, 0x4049000000000000L

    sub-double/2addr v8, v11

    double-to-int v4, v8

    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v4

    div-int/lit8 v4, v4, 0x5

    mul-int/lit8 v4, v4, 0xa

    add-int/2addr v4, v10

    if-ge v4, v7, :cond_f

    move v6, v4

    move v4, v5

    :goto_7
    add-int/lit8 v5, v5, 0x1

    move v7, v6

    move v6, v4

    goto/16 :goto_0

    :cond_e
    return v6

    :cond_f
    move v4, v6

    move v6, v7

    goto :goto_7
.end method

.method private static a(Lcom/google/zxing/qrcode/encoder/ByteMatrix;)I
    .locals 12

    const/4 v2, 0x0

    const/4 v11, 0x1

    invoke-static {p0}, Lcom/google/zxing/qrcode/encoder/a;->a(Lcom/google/zxing/qrcode/encoder/ByteMatrix;)I

    move-result v0

    add-int/lit8 v4, v0, 0x0

    invoke-virtual {p0}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getArray()[[B

    move-result-object v5

    invoke-virtual {p0}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getWidth()I

    move-result v6

    invoke-virtual {p0}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getHeight()I

    move-result v7

    move v3, v2

    move v0, v2

    :goto_0
    add-int/lit8 v1, v7, -0x1

    if-ge v3, v1, :cond_2

    move v1, v2

    :goto_1
    add-int/lit8 v8, v6, -0x1

    if-ge v1, v8, :cond_1

    aget-object v8, v5, v3

    aget-byte v8, v8, v1

    aget-object v9, v5, v3

    add-int/lit8 v10, v1, 0x1

    aget-byte v9, v9, v10

    if-ne v8, v9, :cond_0

    add-int/lit8 v9, v3, 0x1

    aget-object v9, v5, v9

    aget-byte v9, v9, v1

    if-ne v8, v9, :cond_0

    add-int/lit8 v9, v3, 0x1

    aget-object v9, v5, v9

    add-int/lit8 v10, v1, 0x1

    aget-byte v9, v9, v10

    if-ne v8, v9, :cond_0

    add-int/lit8 v0, v0, 0x3

    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_1
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    goto :goto_0

    :cond_2
    add-int/2addr v4, v0

    invoke-virtual {p0}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getArray()[[B

    move-result-object v5

    invoke-virtual {p0}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getWidth()I

    move-result v6

    invoke-virtual {p0}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getHeight()I

    move-result v7

    move v3, v2

    move v0, v2

    :goto_2
    if-ge v3, v7, :cond_a

    move v1, v2

    :goto_3
    if-ge v1, v6, :cond_9

    add-int/lit8 v8, v1, 0x6

    if-ge v8, v6, :cond_5

    aget-object v8, v5, v3

    aget-byte v8, v8, v1

    if-ne v8, v11, :cond_5

    aget-object v8, v5, v3

    add-int/lit8 v9, v1, 0x1

    aget-byte v8, v8, v9

    if-nez v8, :cond_5

    aget-object v8, v5, v3

    add-int/lit8 v9, v1, 0x2

    aget-byte v8, v8, v9

    if-ne v8, v11, :cond_5

    aget-object v8, v5, v3

    add-int/lit8 v9, v1, 0x3

    aget-byte v8, v8, v9

    if-ne v8, v11, :cond_5

    aget-object v8, v5, v3

    add-int/lit8 v9, v1, 0x4

    aget-byte v8, v8, v9

    if-ne v8, v11, :cond_5

    aget-object v8, v5, v3

    add-int/lit8 v9, v1, 0x5

    aget-byte v8, v8, v9

    if-nez v8, :cond_5

    aget-object v8, v5, v3

    add-int/lit8 v9, v1, 0x6

    aget-byte v8, v8, v9

    if-ne v8, v11, :cond_5

    add-int/lit8 v8, v1, 0xa

    if-ge v8, v6, :cond_3

    aget-object v8, v5, v3

    add-int/lit8 v9, v1, 0x7

    aget-byte v8, v8, v9

    if-nez v8, :cond_3

    aget-object v8, v5, v3

    add-int/lit8 v9, v1, 0x8

    aget-byte v8, v8, v9

    if-nez v8, :cond_3

    aget-object v8, v5, v3

    add-int/lit8 v9, v1, 0x9

    aget-byte v8, v8, v9

    if-nez v8, :cond_3

    aget-object v8, v5, v3

    add-int/lit8 v9, v1, 0xa

    aget-byte v8, v8, v9

    if-eqz v8, :cond_4

    :cond_3
    add-int/lit8 v8, v1, -0x4

    if-ltz v8, :cond_5

    aget-object v8, v5, v3

    add-int/lit8 v9, v1, -0x1

    aget-byte v8, v8, v9

    if-nez v8, :cond_5

    aget-object v8, v5, v3

    add-int/lit8 v9, v1, -0x2

    aget-byte v8, v8, v9

    if-nez v8, :cond_5

    aget-object v8, v5, v3

    add-int/lit8 v9, v1, -0x3

    aget-byte v8, v8, v9

    if-nez v8, :cond_5

    aget-object v8, v5, v3

    add-int/lit8 v9, v1, -0x4

    aget-byte v8, v8, v9

    if-nez v8, :cond_5

    :cond_4
    add-int/lit8 v0, v0, 0x28

    :cond_5
    add-int/lit8 v8, v3, 0x6

    if-ge v8, v7, :cond_8

    aget-object v8, v5, v3

    aget-byte v8, v8, v1

    if-ne v8, v11, :cond_8

    add-int/lit8 v8, v3, 0x1

    aget-object v8, v5, v8

    aget-byte v8, v8, v1

    if-nez v8, :cond_8

    add-int/lit8 v8, v3, 0x2

    aget-object v8, v5, v8

    aget-byte v8, v8, v1

    if-ne v8, v11, :cond_8

    add-int/lit8 v8, v3, 0x3

    aget-object v8, v5, v8

    aget-byte v8, v8, v1

    if-ne v8, v11, :cond_8

    add-int/lit8 v8, v3, 0x4

    aget-object v8, v5, v8

    aget-byte v8, v8, v1

    if-ne v8, v11, :cond_8

    add-int/lit8 v8, v3, 0x5

    aget-object v8, v5, v8

    aget-byte v8, v8, v1

    if-nez v8, :cond_8

    add-int/lit8 v8, v3, 0x6

    aget-object v8, v5, v8

    aget-byte v8, v8, v1

    if-ne v8, v11, :cond_8

    add-int/lit8 v8, v3, 0xa

    if-ge v8, v7, :cond_6

    add-int/lit8 v8, v3, 0x7

    aget-object v8, v5, v8

    aget-byte v8, v8, v1

    if-nez v8, :cond_6

    add-int/lit8 v8, v3, 0x8

    aget-object v8, v5, v8

    aget-byte v8, v8, v1

    if-nez v8, :cond_6

    add-int/lit8 v8, v3, 0x9

    aget-object v8, v5, v8

    aget-byte v8, v8, v1

    if-nez v8, :cond_6

    add-int/lit8 v8, v3, 0xa

    aget-object v8, v5, v8

    aget-byte v8, v8, v1

    if-eqz v8, :cond_7

    :cond_6
    add-int/lit8 v8, v3, -0x4

    if-ltz v8, :cond_8

    add-int/lit8 v8, v3, -0x1

    aget-object v8, v5, v8

    aget-byte v8, v8, v1

    if-nez v8, :cond_8

    add-int/lit8 v8, v3, -0x2

    aget-object v8, v5, v8

    aget-byte v8, v8, v1

    if-nez v8, :cond_8

    add-int/lit8 v8, v3, -0x3

    aget-object v8, v5, v8

    aget-byte v8, v8, v1

    if-nez v8, :cond_8

    add-int/lit8 v8, v3, -0x4

    aget-object v8, v5, v8

    aget-byte v8, v8, v1

    if-nez v8, :cond_8

    :cond_7
    add-int/lit8 v0, v0, 0x28

    :cond_8
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_3

    :cond_9
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    goto/16 :goto_2

    :cond_a
    add-int/2addr v4, v0

    invoke-virtual {p0}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getArray()[[B

    move-result-object v5

    invoke-virtual {p0}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getWidth()I

    move-result v6

    invoke-virtual {p0}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getHeight()I

    move-result v7

    move v3, v2

    move v0, v2

    :goto_4
    if-ge v3, v7, :cond_d

    move v1, v2

    :goto_5
    if-ge v1, v6, :cond_c

    aget-object v8, v5, v3

    aget-byte v8, v8, v1

    if-ne v8, v11, :cond_b

    add-int/lit8 v0, v0, 0x1

    :cond_b
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_c
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    goto :goto_4

    :cond_d
    invoke-virtual {p0}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getHeight()I

    move-result v1

    invoke-virtual {p0}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;->getWidth()I

    move-result v2

    mul-int/2addr v1, v2

    int-to-double v2, v0

    int-to-double v0, v1

    div-double v0, v2, v0

    const-wide/high16 v2, 0x4059000000000000L

    mul-double/2addr v0, v2

    const-wide/high16 v2, 0x4049000000000000L

    sub-double/2addr v0, v2

    double-to-int v0, v0

    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v0

    div-int/lit8 v0, v0, 0x5

    mul-int/lit8 v0, v0, 0xa

    add-int/2addr v0, v4

    return v0
.end method

.method private static a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/zxing/qrcode/decoder/Mode;
    .locals 6

    const/4 v3, 0x1

    const/4 v0, 0x0

    const-string v1, "Shift_JIS"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-static {p0}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/google/zxing/qrcode/decoder/Mode;->KANJI:Lcom/google/zxing/qrcode/decoder/Mode;

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/google/zxing/qrcode/decoder/Mode;->BYTE:Lcom/google/zxing/qrcode/decoder/Mode;

    goto :goto_0

    :cond_1
    move v1, v0

    move v2, v0

    :goto_1
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    if-ge v0, v4, :cond_4

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0x30

    if-lt v4, v5, :cond_2

    const/16 v5, 0x39

    if-gt v4, v5, :cond_2

    move v2, v3

    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_2
    invoke-static {v4}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(I)I

    move-result v1

    const/4 v4, -0x1

    if-eq v1, v4, :cond_3

    move v1, v3

    goto :goto_2

    :cond_3
    sget-object v0, Lcom/google/zxing/qrcode/decoder/Mode;->BYTE:Lcom/google/zxing/qrcode/decoder/Mode;

    goto :goto_0

    :cond_4
    if-eqz v1, :cond_5

    sget-object v0, Lcom/google/zxing/qrcode/decoder/Mode;->ALPHANUMERIC:Lcom/google/zxing/qrcode/decoder/Mode;

    goto :goto_0

    :cond_5
    if-eqz v2, :cond_6

    sget-object v0, Lcom/google/zxing/qrcode/decoder/Mode;->NUMERIC:Lcom/google/zxing/qrcode/decoder/Mode;

    goto :goto_0

    :cond_6
    sget-object v0, Lcom/google/zxing/qrcode/decoder/Mode;->BYTE:Lcom/google/zxing/qrcode/decoder/Mode;

    goto :goto_0
.end method

.method private static a(IIII[I[I)V
    .locals 9

    const/4 v8, 0x0

    if-lt p3, p2, :cond_0

    new-instance v0, Lcom/google/zxing/WriterException;

    const-string v1, "Block ID too large"

    invoke-direct {v0, v1}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    rem-int v0, p0, p2

    sub-int v1, p2, v0

    div-int v2, p0, p2

    add-int/lit8 v3, v2, 0x1

    div-int v4, p1, p2

    add-int/lit8 v5, v4, 0x1

    sub-int/2addr v2, v4

    sub-int/2addr v3, v5

    if-eq v2, v3, :cond_1

    new-instance v0, Lcom/google/zxing/WriterException;

    const-string v1, "EC bytes mismatch"

    invoke-direct {v0, v1}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    add-int v6, v1, v0

    if-eq p2, v6, :cond_2

    new-instance v0, Lcom/google/zxing/WriterException;

    const-string v1, "RS blocks mismatch"

    invoke-direct {v0, v1}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    add-int v6, v4, v2

    mul-int/2addr v6, v1

    add-int v7, v5, v3

    mul-int/2addr v0, v7

    add-int/2addr v0, v6

    if-eq p0, v0, :cond_3

    new-instance v0, Lcom/google/zxing/WriterException;

    const-string v1, "Total bytes mismatch"

    invoke-direct {v0, v1}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    if-ge p3, v1, :cond_4

    aput v4, p4, v8

    aput v2, p5, v8

    :goto_0
    return-void

    :cond_4
    aput v5, p4, v8

    aput v3, p5, v8

    goto :goto_0
.end method

.method private static a(IILcom/google/zxing/qrcode/decoder/Mode;Lcom/google/zxing/common/BitArray;)V
    .locals 5

    const/4 v4, 0x1

    invoke-static {p1}, Lcom/google/zxing/qrcode/decoder/Version;->getVersionForNumber(I)Lcom/google/zxing/qrcode/decoder/Version;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/google/zxing/qrcode/decoder/Mode;->getCharacterCountBits(Lcom/google/zxing/qrcode/decoder/Version;)I

    move-result v0

    shl-int v1, v4, v0

    add-int/lit8 v1, v1, -0x1

    if-le p0, v1, :cond_0

    new-instance v1, Lcom/google/zxing/WriterException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "is bigger than"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    shl-int v0, v4, v0

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_0
    invoke-virtual {p3, p0, v0}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    return-void
.end method

.method private static a(ILcom/google/zxing/common/BitArray;)V
    .locals 5

    const/16 v4, 0x8

    const/4 v0, 0x0

    shl-int/lit8 v2, p0, 0x3

    invoke-virtual {p1}, Lcom/google/zxing/common/BitArray;->getSize()I

    move-result v1

    if-le v1, v2, :cond_0

    new-instance v0, Lcom/google/zxing/WriterException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "data bits cannot fit in the QR Code"

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/google/zxing/common/BitArray;->getSize()I

    move-result v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " > "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    move v1, v0

    :goto_0
    const/4 v3, 0x4

    if-ge v1, v3, :cond_1

    invoke-virtual {p1}, Lcom/google/zxing/common/BitArray;->getSize()I

    move-result v3

    if-ge v3, v2, :cond_1

    invoke-virtual {p1, v0}, Lcom/google/zxing/common/BitArray;->appendBit(Z)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_1
    invoke-virtual {p1}, Lcom/google/zxing/common/BitArray;->getSize()I

    move-result v1

    and-int/lit8 v1, v1, 0x7

    if-lez v1, :cond_2

    :goto_1
    if-ge v1, v4, :cond_2

    invoke-virtual {p1, v0}, Lcom/google/zxing/common/BitArray;->appendBit(Z)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_2
    invoke-virtual {p1}, Lcom/google/zxing/common/BitArray;->getSizeInBytes()I

    move-result v1

    sub-int v3, p0, v1

    move v1, v0

    :goto_2
    if-ge v1, v3, :cond_4

    and-int/lit8 v0, v1, 0x1

    if-nez v0, :cond_3

    const/16 v0, 0xec

    :goto_3
    invoke-virtual {p1, v0, v4}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_2

    :cond_3
    const/16 v0, 0x11

    goto :goto_3

    :cond_4
    invoke-virtual {p1}, Lcom/google/zxing/common/BitArray;->getSize()I

    move-result v0

    if-eq v0, v2, :cond_5

    new-instance v0, Lcom/google/zxing/WriterException;

    const-string v1, "Bits size does not equal capacity"

    invoke-direct {v0, v1}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_5
    return-void
.end method

.method private static a(ILcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;Lcom/google/zxing/qrcode/decoder/Mode;Lcom/google/zxing/qrcode/encoder/QRCode;)V
    .locals 7

    invoke-virtual {p3, p1}, Lcom/google/zxing/qrcode/encoder/QRCode;->setECLevel(Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;)V

    invoke-virtual {p3, p2}, Lcom/google/zxing/qrcode/encoder/QRCode;->setMode(Lcom/google/zxing/qrcode/decoder/Mode;)V

    const/4 v0, 0x1

    :goto_0
    const/16 v1, 0x28

    if-gt v0, v1, :cond_1

    invoke-static {v0}, Lcom/google/zxing/qrcode/decoder/Version;->getVersionForNumber(I)Lcom/google/zxing/qrcode/decoder/Version;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/decoder/Version;->getTotalCodewords()I

    move-result v2

    invoke-virtual {v1, p1}, Lcom/google/zxing/qrcode/decoder/Version;->getECBlocksForLevel(Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;)Lcom/google/zxing/qrcode/decoder/Version$ECBlocks;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/zxing/qrcode/decoder/Version$ECBlocks;->getTotalECCodewords()I

    move-result v4

    invoke-virtual {v3}, Lcom/google/zxing/qrcode/decoder/Version$ECBlocks;->getNumBlocks()I

    move-result v3

    sub-int v5, v2, v4

    invoke-virtual {p2, v1}, Lcom/google/zxing/qrcode/decoder/Mode;->getCharacterCountBits(Lcom/google/zxing/qrcode/decoder/Version;)I

    move-result v6

    add-int/lit8 v6, v6, 0x4

    add-int/2addr v6, p0

    add-int/lit8 v6, v6, 0x7

    div-int/lit8 v6, v6, 0x8

    if-lt v5, v6, :cond_0

    invoke-virtual {p3, v0}, Lcom/google/zxing/qrcode/encoder/QRCode;->setVersion(I)V

    invoke-virtual {p3, v2}, Lcom/google/zxing/qrcode/encoder/QRCode;->setNumTotalBytes(I)V

    invoke-virtual {p3, v5}, Lcom/google/zxing/qrcode/encoder/QRCode;->setNumDataBytes(I)V

    invoke-virtual {p3, v3}, Lcom/google/zxing/qrcode/encoder/QRCode;->setNumRSBlocks(I)V

    invoke-virtual {p3, v4}, Lcom/google/zxing/qrcode/encoder/QRCode;->setNumECBytes(I)V

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/decoder/Version;->getDimensionForVersion()I

    move-result v0

    invoke-virtual {p3, v0}, Lcom/google/zxing/qrcode/encoder/QRCode;->setMatrixWidth(I)V

    return-void

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    new-instance v0, Lcom/google/zxing/WriterException;

    const-string v1, "Cannot find proper rs block info (input data too big?)"

    invoke-direct {v0, v1}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private static a(Lcom/google/zxing/common/BitArray;IIILcom/google/zxing/common/BitArray;)V
    .locals 16

    invoke-virtual/range {p0 .. p0}, Lcom/google/zxing/common/BitArray;->getSizeInBytes()I

    move-result v1

    move/from16 v0, p2

    if-eq v1, v0, :cond_0

    new-instance v1, Lcom/google/zxing/WriterException;

    const-string v2, "Number of bits and data bytes does not match"

    invoke-direct {v1, v2}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_0
    const/4 v4, 0x0

    const/4 v3, 0x0

    const/4 v2, 0x0

    new-instance v6, Ljava/util/ArrayList;

    move/from16 v0, p3

    invoke-direct {v6, v0}, Ljava/util/ArrayList;-><init>(I)V

    const/4 v1, 0x0

    move v5, v4

    move v4, v3

    move v3, v2

    :goto_0
    move/from16 v0, p3

    if-ge v1, v0, :cond_6

    const/4 v2, 0x1

    new-array v7, v2, [I

    const/4 v2, 0x1

    new-array v2, v2, [I

    move/from16 v0, p3

    if-lt v1, v0, :cond_1

    new-instance v1, Lcom/google/zxing/WriterException;

    const-string v2, "Block ID too large"

    invoke-direct {v1, v2}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_1
    rem-int v8, p1, p3

    sub-int v9, p3, v8

    div-int v10, p1, p3

    add-int/lit8 v11, v10, 0x1

    div-int v12, p2, p3

    add-int/lit8 v13, v12, 0x1

    sub-int/2addr v10, v12

    sub-int/2addr v11, v13

    if-eq v10, v11, :cond_2

    new-instance v1, Lcom/google/zxing/WriterException;

    const-string v2, "EC bytes mismatch"

    invoke-direct {v1, v2}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_2
    add-int v14, v9, v8

    move/from16 v0, p3

    if-eq v0, v14, :cond_3

    new-instance v1, Lcom/google/zxing/WriterException;

    const-string v2, "RS blocks mismatch"

    invoke-direct {v1, v2}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_3
    add-int v14, v12, v10

    mul-int/2addr v14, v9

    add-int v15, v13, v11

    mul-int/2addr v8, v15

    add-int/2addr v8, v14

    move/from16 v0, p1

    if-eq v0, v8, :cond_4

    new-instance v1, Lcom/google/zxing/WriterException;

    const-string v2, "Total bytes mismatch"

    invoke-direct {v1, v2}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_4
    if-ge v1, v9, :cond_5

    const/4 v8, 0x0

    aput v12, v7, v8

    const/4 v8, 0x0

    aput v10, v2, v8

    :goto_1
    const/4 v8, 0x0

    aget v8, v7, v8

    new-array v9, v8, [B

    mul-int/lit8 v10, v5, 0x8

    const/4 v11, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v10, v9, v11, v8}, Lcom/google/zxing/common/BitArray;->toBytes(I[BII)V

    const/4 v10, 0x0

    aget v2, v2, v10

    invoke-static {v9, v2}, Lcom/google/zxing/qrcode/encoder/Encoder;->a([BI)[B

    move-result-object v2

    new-instance v10, Lcom/google/zxing/qrcode/encoder/a;

    invoke-direct {v10, v9, v2}, Lcom/google/zxing/qrcode/encoder/a;-><init>([B[B)V

    invoke-interface {v6, v10}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    invoke-static {v4, v8}, Ljava/lang/Math;->max(II)I

    move-result v4

    array-length v2, v2

    invoke-static {v3, v2}, Ljava/lang/Math;->max(II)I

    move-result v2

    const/4 v3, 0x0

    aget v3, v7, v3

    add-int/2addr v3, v5

    add-int/lit8 v1, v1, 0x1

    move v5, v3

    move v3, v2

    goto/16 :goto_0

    :cond_5
    const/4 v8, 0x0

    aput v13, v7, v8

    const/4 v8, 0x0

    aput v11, v2, v8

    goto :goto_1

    :cond_6
    move/from16 v0, p2

    if-eq v0, v5, :cond_7

    new-instance v1, Lcom/google/zxing/WriterException;

    const-string v2, "Data bytes does not match offset"

    invoke-direct {v1, v2}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_7
    const/4 v1, 0x0

    move v2, v1

    :goto_2
    if-ge v2, v4, :cond_a

    invoke-interface {v6}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_8
    :goto_3
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_9

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/zxing/qrcode/encoder/a;

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/encoder/a;->a()[B

    move-result-object v1

    array-length v7, v1

    if-ge v2, v7, :cond_8

    aget-byte v1, v1, v2

    const/16 v7, 0x8

    move-object/from16 v0, p4

    invoke-virtual {v0, v1, v7}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    goto :goto_3

    :cond_9
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_2

    :cond_a
    const/4 v1, 0x0

    move v2, v1

    :goto_4
    if-ge v2, v3, :cond_d

    invoke-interface {v6}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_b
    :goto_5
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_c

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/zxing/qrcode/encoder/a;

    invoke-virtual {v1}, Lcom/google/zxing/qrcode/encoder/a;->b()[B

    move-result-object v1

    array-length v5, v1

    if-ge v2, v5, :cond_b

    aget-byte v1, v1, v2

    const/16 v5, 0x8

    move-object/from16 v0, p4

    invoke-virtual {v0, v1, v5}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    goto :goto_5

    :cond_c
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_4

    :cond_d
    invoke-virtual/range {p4 .. p4}, Lcom/google/zxing/common/BitArray;->getSizeInBytes()I

    move-result v1

    move/from16 v0, p1

    if-eq v0, v1, :cond_e

    new-instance v1, Lcom/google/zxing/WriterException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Interleaving error: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move/from16 v0, p1

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " and "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual/range {p4 .. p4}, Lcom/google/zxing/common/BitArray;->getSizeInBytes()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " differ."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_e
    return-void
.end method

.method private static a(Lcom/google/zxing/common/CharacterSetECI;Lcom/google/zxing/common/BitArray;)V
    .locals 2

    sget-object v0, Lcom/google/zxing/qrcode/decoder/Mode;->ECI:Lcom/google/zxing/qrcode/decoder/Mode;

    invoke-virtual {v0}, Lcom/google/zxing/qrcode/decoder/Mode;->getBits()I

    move-result v0

    const/4 v1, 0x4

    invoke-virtual {p1, v0, v1}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    invoke-virtual {p0}, Lcom/google/zxing/common/CharacterSetECI;->getValue()I

    move-result v0

    const/16 v1, 0x8

    invoke-virtual {p1, v0, v1}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    return-void
.end method

.method private static a(Lcom/google/zxing/qrcode/decoder/Mode;Lcom/google/zxing/common/BitArray;)V
    .locals 2

    invoke-virtual {p0}, Lcom/google/zxing/qrcode/decoder/Mode;->getBits()I

    move-result v0

    const/4 v1, 0x4

    invoke-virtual {p1, v0, v1}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    return-void
.end method

.method private static a(Ljava/lang/CharSequence;Lcom/google/zxing/common/BitArray;)V
    .locals 5

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_2

    invoke-interface {p0, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    add-int/lit8 v2, v2, -0x30

    add-int/lit8 v3, v0, 0x2

    if-ge v3, v1, :cond_0

    add-int/lit8 v3, v0, 0x1

    invoke-interface {p0, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    add-int/lit8 v3, v3, -0x30

    add-int/lit8 v4, v0, 0x2

    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v4

    add-int/lit8 v4, v4, -0x30

    mul-int/lit8 v2, v2, 0x64

    mul-int/lit8 v3, v3, 0xa

    add-int/2addr v2, v3

    add-int/2addr v2, v4

    const/16 v3, 0xa

    invoke-virtual {p1, v2, v3}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v0, v0, 0x3

    goto :goto_0

    :cond_0
    add-int/lit8 v3, v0, 0x1

    if-ge v3, v1, :cond_1

    add-int/lit8 v3, v0, 0x1

    invoke-interface {p0, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    add-int/lit8 v3, v3, -0x30

    mul-int/lit8 v2, v2, 0xa

    add-int/2addr v2, v3

    const/4 v3, 0x7

    invoke-virtual {p1, v2, v3}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v0, v0, 0x2

    goto :goto_0

    :cond_1
    const/4 v3, 0x4

    invoke-virtual {p1, v2, v3}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_2
    return-void
.end method

.method private static a(Ljava/lang/String;Lcom/google/zxing/common/BitArray;)V
    .locals 7

    const v6, 0x8140

    const/4 v1, -0x1

    :try_start_0
    const-string v0, "Shift_JIS"

    invoke-virtual {p0, v0}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    array-length v4, v3

    const/4 v0, 0x0

    move v2, v0

    :goto_0
    if-ge v2, v4, :cond_2

    aget-byte v0, v3, v2

    and-int/lit16 v0, v0, 0xff

    add-int/lit8 v5, v2, 0x1

    aget-byte v5, v3, v5

    and-int/lit16 v5, v5, 0xff

    shl-int/lit8 v0, v0, 0x8

    or-int/2addr v0, v5

    if-lt v0, v6, :cond_0

    const v5, 0x9ffc

    if-gt v0, v5, :cond_0

    sub-int/2addr v0, v6

    :goto_1
    if-ne v0, v1, :cond_1

    new-instance v0, Lcom/google/zxing/WriterException;

    const-string v1, "Invalid byte sequence"

    invoke-direct {v0, v1}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/google/zxing/WriterException;

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_0
    const v5, 0xe040

    if-lt v0, v5, :cond_3

    const v5, 0xebbf

    if-gt v0, v5, :cond_3

    const v5, 0xc140

    sub-int/2addr v0, v5

    goto :goto_1

    :cond_1
    shr-int/lit8 v5, v0, 0x8

    mul-int/lit16 v5, v5, 0xc0

    and-int/lit16 v0, v0, 0xff

    add-int/2addr v0, v5

    const/16 v5, 0xd

    invoke-virtual {p1, v0, v5}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v0, v2, 0x2

    move v2, v0

    goto :goto_0

    :cond_2
    return-void

    :cond_3
    move v0, v1

    goto :goto_1
.end method

.method private static a(Ljava/lang/String;Lcom/google/zxing/common/BitArray;Ljava/lang/String;)V
    .locals 5

    :try_start_0
    invoke-virtual {p0, p2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    array-length v2, v1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_0

    aget-byte v3, v1, v0

    const/16 v4, 0x8

    invoke-virtual {p1, v3, v4}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/google/zxing/WriterException;

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_0
    return-void
.end method

.method private static a(Ljava/lang/String;Lcom/google/zxing/qrcode/decoder/Mode;Lcom/google/zxing/common/BitArray;Ljava/lang/String;)V
    .locals 7

    const v6, 0x8140

    const/4 v0, 0x0

    const/4 v2, -0x1

    sget-object v1, Lcom/google/zxing/qrcode/encoder/b;->a:[I

    invoke-virtual {p1}, Lcom/google/zxing/qrcode/decoder/Mode;->ordinal()I

    move-result v3

    aget v1, v1, v3

    packed-switch v1, :pswitch_data_0

    new-instance v0, Lcom/google/zxing/WriterException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Invalid mode: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v1

    :goto_0
    if-ge v0, v1, :cond_7

    invoke-interface {p0, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    add-int/lit8 v2, v2, -0x30

    add-int/lit8 v3, v0, 0x2

    if-ge v3, v1, :cond_0

    add-int/lit8 v3, v0, 0x1

    invoke-interface {p0, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    add-int/lit8 v3, v3, -0x30

    add-int/lit8 v4, v0, 0x2

    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v4

    add-int/lit8 v4, v4, -0x30

    mul-int/lit8 v2, v2, 0x64

    mul-int/lit8 v3, v3, 0xa

    add-int/2addr v2, v3

    add-int/2addr v2, v4

    const/16 v3, 0xa

    invoke-virtual {p2, v2, v3}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v0, v0, 0x3

    goto :goto_0

    :cond_0
    add-int/lit8 v3, v0, 0x1

    if-ge v3, v1, :cond_1

    add-int/lit8 v3, v0, 0x1

    invoke-interface {p0, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    add-int/lit8 v3, v3, -0x30

    mul-int/lit8 v2, v2, 0xa

    add-int/2addr v2, v3

    const/4 v3, 0x7

    invoke-virtual {p2, v2, v3}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v0, v0, 0x2

    goto :goto_0

    :cond_1
    const/4 v3, 0x4

    invoke-virtual {p2, v2, v3}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :pswitch_1
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v1

    :goto_1
    if-ge v0, v1, :cond_7

    invoke-interface {p0, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    invoke-static {v3}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(I)I

    move-result v3

    if-ne v3, v2, :cond_2

    new-instance v0, Lcom/google/zxing/WriterException;

    invoke-direct {v0}, Lcom/google/zxing/WriterException;-><init>()V

    throw v0

    :cond_2
    add-int/lit8 v4, v0, 0x1

    if-ge v4, v1, :cond_4

    add-int/lit8 v4, v0, 0x1

    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v4

    invoke-static {v4}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(I)I

    move-result v4

    if-ne v4, v2, :cond_3

    new-instance v0, Lcom/google/zxing/WriterException;

    invoke-direct {v0}, Lcom/google/zxing/WriterException;-><init>()V

    throw v0

    :cond_3
    mul-int/lit8 v3, v3, 0x2d

    add-int/2addr v3, v4

    const/16 v4, 0xb

    invoke-virtual {p2, v3, v4}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v0, v0, 0x2

    goto :goto_1

    :cond_4
    const/4 v4, 0x6

    invoke-virtual {p2, v3, v4}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :pswitch_2
    :try_start_0
    invoke-virtual {p0, p3}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    array-length v2, v1

    :goto_2
    if-ge v0, v2, :cond_7

    aget-byte v3, v1, v0

    const/16 v4, 0x8

    invoke-virtual {p2, v3, v4}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :catch_0
    move-exception v0

    new-instance v1, Lcom/google/zxing/WriterException;

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v1

    :pswitch_3
    :try_start_1
    const-string v1, "Shift_JIS"

    invoke-virtual {p0, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v3

    array-length v4, v3

    :goto_3
    if-ge v0, v4, :cond_7

    aget-byte v1, v3, v0

    and-int/lit16 v1, v1, 0xff

    add-int/lit8 v5, v0, 0x1

    aget-byte v5, v3, v5

    and-int/lit16 v5, v5, 0xff

    shl-int/lit8 v1, v1, 0x8

    or-int/2addr v1, v5

    if-lt v1, v6, :cond_5

    const v5, 0x9ffc

    if-gt v1, v5, :cond_5

    sub-int/2addr v1, v6

    :goto_4
    if-ne v1, v2, :cond_6

    new-instance v0, Lcom/google/zxing/WriterException;

    const-string v1, "Invalid byte sequence"

    invoke-direct {v0, v1}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v0

    :catch_1
    move-exception v0

    new-instance v1, Lcom/google/zxing/WriterException;

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_5
    const v5, 0xe040

    if-lt v1, v5, :cond_8

    const v5, 0xebbf

    if-gt v1, v5, :cond_8

    const v5, 0xc140

    sub-int/2addr v1, v5

    goto :goto_4

    :cond_6
    shr-int/lit8 v5, v1, 0x8

    mul-int/lit16 v5, v5, 0xc0

    and-int/lit16 v1, v1, 0xff

    add-int/2addr v1, v5

    const/16 v5, 0xd

    invoke-virtual {p2, v1, v5}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v0, v0, 0x2

    goto :goto_3

    :cond_7
    return-void

    :cond_8
    move v1, v2

    goto :goto_4

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method private static a(Ljava/lang/String;)Z
    .locals 6

    const/4 v0, 0x0

    :try_start_0
    const-string v1, "Shift_JIS"

    invoke-virtual {p0, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    array-length v3, v2

    rem-int/lit8 v1, v3, 0x2

    if-eqz v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    move v1, v0

    :goto_1
    if-ge v1, v3, :cond_4

    aget-byte v4, v2, v1

    and-int/lit16 v4, v4, 0xff

    const/16 v5, 0x81

    if-lt v4, v5, :cond_2

    const/16 v5, 0x9f

    if-le v4, v5, :cond_3

    :cond_2
    const/16 v5, 0xe0

    if-lt v4, v5, :cond_0

    const/16 v5, 0xeb

    if-gt v4, v5, :cond_0

    :cond_3
    add-int/lit8 v1, v1, 0x2

    goto :goto_1

    :cond_4
    const/4 v0, 0x1

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private static a([BI)[B
    .locals 5

    const/4 v0, 0x0

    array-length v2, p0

    add-int v1, v2, p1

    new-array v3, v1, [I

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_0

    aget-byte v4, p0, v1

    and-int/lit16 v4, v4, 0xff

    aput v4, v3, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_0
    new-instance v1, Lcom/google/zxing/common/reedsolomon/ReedSolomonEncoder;

    sget-object v4, Lcom/google/zxing/common/reedsolomon/GenericGF;->QR_CODE_FIELD_256:Lcom/google/zxing/common/reedsolomon/GenericGF;

    invoke-direct {v1, v4}, Lcom/google/zxing/common/reedsolomon/ReedSolomonEncoder;-><init>(Lcom/google/zxing/common/reedsolomon/GenericGF;)V

    invoke-virtual {v1, v3, p1}, Lcom/google/zxing/common/reedsolomon/ReedSolomonEncoder;->encode([II)V

    new-array v1, p1, [B

    :goto_1
    if-ge v0, p1, :cond_1

    add-int v4, v2, v0

    aget v4, v3, v4

    int-to-byte v4, v4

    aput-byte v4, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_1
    return-object v1
.end method

.method private static b(Ljava/lang/CharSequence;Lcom/google/zxing/common/BitArray;)V
    .locals 5

    const/4 v4, -0x1

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_3

    invoke-interface {p0, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    invoke-static {v2}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(I)I

    move-result v2

    if-ne v2, v4, :cond_0

    new-instance v0, Lcom/google/zxing/WriterException;

    invoke-direct {v0}, Lcom/google/zxing/WriterException;-><init>()V

    throw v0

    :cond_0
    add-int/lit8 v3, v0, 0x1

    if-ge v3, v1, :cond_2

    add-int/lit8 v3, v0, 0x1

    invoke-interface {p0, v3}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    invoke-static {v3}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(I)I

    move-result v3

    if-ne v3, v4, :cond_1

    new-instance v0, Lcom/google/zxing/WriterException;

    invoke-direct {v0}, Lcom/google/zxing/WriterException;-><init>()V

    throw v0

    :cond_1
    mul-int/lit8 v2, v2, 0x2d

    add-int/2addr v2, v3

    const/16 v3, 0xb

    invoke-virtual {p1, v2, v3}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v0, v0, 0x2

    goto :goto_0

    :cond_2
    const/4 v3, 0x6

    invoke-virtual {p1, v2, v3}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_3
    return-void
.end method

.method public static chooseMode(Ljava/lang/String;)Lcom/google/zxing/qrcode/decoder/Mode;
    .locals 1

    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/zxing/qrcode/decoder/Mode;

    move-result-object v0

    return-object v0
.end method

.method public static encode(Ljava/lang/String;Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;Lcom/google/zxing/qrcode/encoder/QRCode;)V
    .locals 1

    const/4 v0, 0x0

    invoke-static {p0, p1, v0, p2}, Lcom/google/zxing/qrcode/encoder/Encoder;->encode(Ljava/lang/String;Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;Ljava/util/Map;Lcom/google/zxing/qrcode/encoder/QRCode;)V

    return-void
.end method

.method public static encode(Ljava/lang/String;Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;Ljava/util/Map;Lcom/google/zxing/qrcode/encoder/QRCode;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;",
            "Ljava/util/Map",
            "<",
            "Lcom/google/zxing/EncodeHintType;",
            "*>;",
            "Lcom/google/zxing/qrcode/encoder/QRCode;",
            ")V"
        }
    .end annotation

    const/4 v9, 0x1

    const/4 v1, 0x0

    const/4 v7, -0x1

    const/4 v8, 0x4

    if-nez p2, :cond_1

    const/4 v0, 0x0

    :goto_0
    if-nez v0, :cond_0

    const-string v0, "ISO-8859-1"

    :cond_0
    invoke-static {p0, v0}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/zxing/qrcode/decoder/Mode;

    move-result-object v2

    new-instance v3, Lcom/google/zxing/common/BitArray;

    invoke-direct {v3}, Lcom/google/zxing/common/BitArray;-><init>()V

    sget-object v4, Lcom/google/zxing/qrcode/encoder/b;->a:[I

    invoke-virtual {v2}, Lcom/google/zxing/qrcode/decoder/Mode;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    new-instance v0, Lcom/google/zxing/WriterException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "Invalid mode: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    sget-object v0, Lcom/google/zxing/EncodeHintType;->CHARACTER_SET:Lcom/google/zxing/EncodeHintType;

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0

    :pswitch_0
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v4

    :goto_1
    if-ge v1, v4, :cond_7

    invoke-interface {p0, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v5

    add-int/lit8 v5, v5, -0x30

    add-int/lit8 v6, v1, 0x2

    if-ge v6, v4, :cond_2

    add-int/lit8 v6, v1, 0x1

    invoke-interface {p0, v6}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v6

    add-int/lit8 v6, v6, -0x30

    add-int/lit8 v7, v1, 0x2

    invoke-interface {p0, v7}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v7

    add-int/lit8 v7, v7, -0x30

    mul-int/lit8 v5, v5, 0x64

    mul-int/lit8 v6, v6, 0xa

    add-int/2addr v5, v6

    add-int/2addr v5, v7

    const/16 v6, 0xa

    invoke-virtual {v3, v5, v6}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v1, v1, 0x3

    goto :goto_1

    :cond_2
    add-int/lit8 v6, v1, 0x1

    if-ge v6, v4, :cond_3

    add-int/lit8 v6, v1, 0x1

    invoke-interface {p0, v6}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v6

    add-int/lit8 v6, v6, -0x30

    mul-int/lit8 v5, v5, 0xa

    add-int/2addr v5, v6

    const/4 v6, 0x7

    invoke-virtual {v3, v5, v6}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v1, v1, 0x2

    goto :goto_1

    :cond_3
    invoke-virtual {v3, v5, v8}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :pswitch_1
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v4

    :goto_2
    if-ge v1, v4, :cond_7

    invoke-interface {p0, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v5

    invoke-static {v5}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(I)I

    move-result v5

    if-ne v5, v7, :cond_4

    new-instance v0, Lcom/google/zxing/WriterException;

    invoke-direct {v0}, Lcom/google/zxing/WriterException;-><init>()V

    throw v0

    :cond_4
    add-int/lit8 v6, v1, 0x1

    if-ge v6, v4, :cond_6

    add-int/lit8 v6, v1, 0x1

    invoke-interface {p0, v6}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v6

    invoke-static {v6}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(I)I

    move-result v6

    if-ne v6, v7, :cond_5

    new-instance v0, Lcom/google/zxing/WriterException;

    invoke-direct {v0}, Lcom/google/zxing/WriterException;-><init>()V

    throw v0

    :cond_5
    mul-int/lit8 v5, v5, 0x2d

    add-int/2addr v5, v6

    const/16 v6, 0xb

    invoke-virtual {v3, v5, v6}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v1, v1, 0x2

    goto :goto_2

    :cond_6
    const/4 v6, 0x6

    invoke-virtual {v3, v5, v6}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :pswitch_2
    invoke-static {p0, v3, v0}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(Ljava/lang/String;Lcom/google/zxing/common/BitArray;Ljava/lang/String;)V

    :cond_7
    :goto_3
    invoke-virtual {v3}, Lcom/google/zxing/common/BitArray;->getSize()I

    move-result v1

    invoke-static {v1, p1, v2, p3}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(ILcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;Lcom/google/zxing/qrcode/decoder/Mode;Lcom/google/zxing/qrcode/encoder/QRCode;)V

    new-instance v1, Lcom/google/zxing/common/BitArray;

    invoke-direct {v1}, Lcom/google/zxing/common/BitArray;-><init>()V

    sget-object v4, Lcom/google/zxing/qrcode/decoder/Mode;->BYTE:Lcom/google/zxing/qrcode/decoder/Mode;

    if-ne v2, v4, :cond_8

    const-string v4, "ISO-8859-1"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_8

    invoke-static {v0}, Lcom/google/zxing/common/CharacterSetECI;->getCharacterSetECIByName(Ljava/lang/String;)Lcom/google/zxing/common/CharacterSetECI;

    move-result-object v0

    if-eqz v0, :cond_8

    sget-object v4, Lcom/google/zxing/qrcode/decoder/Mode;->ECI:Lcom/google/zxing/qrcode/decoder/Mode;

    invoke-virtual {v4}, Lcom/google/zxing/qrcode/decoder/Mode;->getBits()I

    move-result v4

    invoke-virtual {v1, v4, v8}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    invoke-virtual {v0}, Lcom/google/zxing/common/CharacterSetECI;->getValue()I

    move-result v0

    const/16 v4, 0x8

    invoke-virtual {v1, v0, v4}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    :cond_8
    invoke-virtual {v2}, Lcom/google/zxing/qrcode/decoder/Mode;->getBits()I

    move-result v0

    invoke-virtual {v1, v0, v8}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    sget-object v0, Lcom/google/zxing/qrcode/decoder/Mode;->BYTE:Lcom/google/zxing/qrcode/decoder/Mode;

    if-ne v2, v0, :cond_9

    invoke-virtual {v3}, Lcom/google/zxing/common/BitArray;->getSizeInBytes()I

    move-result v0

    :goto_4
    invoke-virtual {p3}, Lcom/google/zxing/qrcode/encoder/QRCode;->getVersion()I

    move-result v4

    invoke-static {v4}, Lcom/google/zxing/qrcode/decoder/Version;->getVersionForNumber(I)Lcom/google/zxing/qrcode/decoder/Version;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/google/zxing/qrcode/decoder/Mode;->getCharacterCountBits(Lcom/google/zxing/qrcode/decoder/Version;)I

    move-result v2

    shl-int v4, v9, v2

    add-int/lit8 v4, v4, -0x1

    if-le v0, v4, :cond_a

    new-instance v1, Lcom/google/zxing/WriterException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "is bigger than"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    shl-int v2, v9, v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v1

    :pswitch_3
    invoke-static {p0, v3}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(Ljava/lang/String;Lcom/google/zxing/common/BitArray;)V

    goto :goto_3

    :cond_9
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    goto :goto_4

    :cond_a
    invoke-virtual {v1, v0, v2}, Lcom/google/zxing/common/BitArray;->appendBits(II)V

    invoke-virtual {v1, v3}, Lcom/google/zxing/common/BitArray;->appendBitArray(Lcom/google/zxing/common/BitArray;)V

    invoke-virtual {p3}, Lcom/google/zxing/qrcode/encoder/QRCode;->getNumDataBytes()I

    move-result v0

    invoke-static {v0, v1}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(ILcom/google/zxing/common/BitArray;)V

    new-instance v0, Lcom/google/zxing/common/BitArray;

    invoke-direct {v0}, Lcom/google/zxing/common/BitArray;-><init>()V

    invoke-virtual {p3}, Lcom/google/zxing/qrcode/encoder/QRCode;->getNumTotalBytes()I

    move-result v2

    invoke-virtual {p3}, Lcom/google/zxing/qrcode/encoder/QRCode;->getNumDataBytes()I

    move-result v3

    invoke-virtual {p3}, Lcom/google/zxing/qrcode/encoder/QRCode;->getNumRSBlocks()I

    move-result v4

    invoke-static {v1, v2, v3, v4, v0}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(Lcom/google/zxing/common/BitArray;IIILcom/google/zxing/common/BitArray;)V

    new-instance v1, Lcom/google/zxing/qrcode/encoder/ByteMatrix;

    invoke-virtual {p3}, Lcom/google/zxing/qrcode/encoder/QRCode;->getMatrixWidth()I

    move-result v2

    invoke-virtual {p3}, Lcom/google/zxing/qrcode/encoder/QRCode;->getMatrixWidth()I

    move-result v3

    invoke-direct {v1, v2, v3}, Lcom/google/zxing/qrcode/encoder/ByteMatrix;-><init>(II)V

    invoke-virtual {p3}, Lcom/google/zxing/qrcode/encoder/QRCode;->getVersion()I

    move-result v2

    invoke-static {v0, p1, v2, v1}, Lcom/google/zxing/qrcode/encoder/Encoder;->a(Lcom/google/zxing/common/BitArray;Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;ILcom/google/zxing/qrcode/encoder/ByteMatrix;)I

    move-result v2

    invoke-virtual {p3, v2}, Lcom/google/zxing/qrcode/encoder/QRCode;->setMaskPattern(I)V

    invoke-virtual {p3}, Lcom/google/zxing/qrcode/encoder/QRCode;->getVersion()I

    move-result v2

    invoke-virtual {p3}, Lcom/google/zxing/qrcode/encoder/QRCode;->getMaskPattern()I

    move-result v3

    invoke-static {v0, p1, v2, v3, v1}, Lcom/google/zxing/qrcode/encoder/d;->a(Lcom/google/zxing/common/BitArray;Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;IILcom/google/zxing/qrcode/encoder/ByteMatrix;)V

    invoke-virtual {p3, v1}, Lcom/google/zxing/qrcode/encoder/QRCode;->setMatrix(Lcom/google/zxing/qrcode/encoder/ByteMatrix;)V

    invoke-virtual {p3}, Lcom/google/zxing/qrcode/encoder/QRCode;->isValid()Z

    move-result v0

    if-nez v0, :cond_b

    new-instance v0, Lcom/google/zxing/WriterException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Invalid QR code: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3}, Lcom/google/zxing/qrcode/encoder/QRCode;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/zxing/WriterException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_b
    return-void

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
