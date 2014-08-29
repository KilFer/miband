.class public Lcom/google/zxing/qrcode/QRCodeReader;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/zxing/Reader;


# static fields
.field private static final a:[Lcom/google/zxing/ResultPoint;


# instance fields
.field private final b:Lcom/google/zxing/qrcode/decoder/Decoder;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    new-array v0, v0, [Lcom/google/zxing/ResultPoint;

    sput-object v0, Lcom/google/zxing/qrcode/QRCodeReader;->a:[Lcom/google/zxing/ResultPoint;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/google/zxing/qrcode/decoder/Decoder;

    invoke-direct {v0}, Lcom/google/zxing/qrcode/decoder/Decoder;-><init>()V

    iput-object v0, p0, Lcom/google/zxing/qrcode/QRCodeReader;->b:Lcom/google/zxing/qrcode/decoder/Decoder;

    return-void
.end method

.method private static a([ILcom/google/zxing/common/BitMatrix;)F
    .locals 10

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {p1}, Lcom/google/zxing/common/BitMatrix;->getHeight()I

    move-result v7

    invoke-virtual {p1}, Lcom/google/zxing/common/BitMatrix;->getWidth()I

    move-result v8

    aget v3, p0, v2

    aget v0, p0, v1

    move v4, v1

    move v5, v0

    move v6, v3

    move v0, v2

    :goto_0
    if-ge v6, v8, :cond_1

    if-ge v5, v7, :cond_1

    invoke-virtual {p1, v6, v5}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v3

    if-eq v4, v3, :cond_4

    add-int/lit8 v3, v0, 0x1

    const/4 v0, 0x5

    if-eq v3, v0, :cond_1

    if-nez v4, :cond_0

    move v0, v1

    :goto_1
    move v9, v3

    move v3, v0

    move v0, v9

    :goto_2
    add-int/lit8 v6, v6, 0x1

    add-int/lit8 v4, v5, 0x1

    move v5, v4

    move v4, v3

    goto :goto_0

    :cond_0
    move v0, v2

    goto :goto_1

    :cond_1
    if-eq v6, v8, :cond_2

    if-ne v5, v7, :cond_3

    :cond_2
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_3
    aget v0, p0, v2

    sub-int v0, v6, v0

    int-to-float v0, v0

    const/high16 v1, 0x40e00000

    div-float/2addr v0, v1

    return v0

    :cond_4
    move v3, v4

    goto :goto_2
.end method

.method private static a(Lcom/google/zxing/common/BitMatrix;)Lcom/google/zxing/common/BitMatrix;
    .locals 12

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/google/zxing/common/BitMatrix;->getTopLeftOnBit()[I

    move-result-object v7

    invoke-virtual {p0}, Lcom/google/zxing/common/BitMatrix;->getBottomRightOnBit()[I

    move-result-object v8

    if-eqz v7, :cond_0

    if-nez v8, :cond_1

    :cond_0
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_1
    invoke-virtual {p0}, Lcom/google/zxing/common/BitMatrix;->getHeight()I

    move-result v9

    invoke-virtual {p0}, Lcom/google/zxing/common/BitMatrix;->getWidth()I

    move-result v10

    aget v3, v7, v2

    aget v0, v7, v1

    move v4, v1

    move v5, v0

    move v6, v3

    move v0, v2

    :goto_0
    if-ge v6, v10, :cond_3

    if-ge v5, v9, :cond_3

    invoke-virtual {p0, v6, v5}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v3

    if-eq v4, v3, :cond_d

    add-int/lit8 v3, v0, 0x1

    const/4 v0, 0x5

    if-eq v3, v0, :cond_3

    if-nez v4, :cond_2

    move v0, v1

    :goto_1
    move v11, v3

    move v3, v0

    move v0, v11

    :goto_2
    add-int/lit8 v6, v6, 0x1

    add-int/lit8 v4, v5, 0x1

    move v5, v4

    move v4, v3

    goto :goto_0

    :cond_2
    move v0, v2

    goto :goto_1

    :cond_3
    if-eq v6, v10, :cond_4

    if-ne v5, v9, :cond_5

    :cond_4
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_5
    aget v0, v7, v2

    sub-int v0, v6, v0

    int-to-float v0, v0

    const/high16 v3, 0x40e00000

    div-float v3, v0, v3

    aget v4, v7, v1

    aget v1, v8, v1

    aget v5, v7, v2

    aget v0, v8, v2

    sub-int v6, v1, v4

    sub-int v7, v0, v5

    if-eq v6, v7, :cond_6

    sub-int v0, v1, v4

    add-int/2addr v0, v5

    :cond_6
    sub-int/2addr v0, v5

    add-int/lit8 v0, v0, 0x1

    int-to-float v0, v0

    div-float/2addr v0, v3

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v6

    sub-int v0, v1, v4

    add-int/lit8 v0, v0, 0x1

    int-to-float v0, v0

    div-float/2addr v0, v3

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v7

    if-lez v6, :cond_7

    if-gtz v7, :cond_8

    :cond_7
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_8
    if-eq v7, v6, :cond_9

    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_9
    const/high16 v0, 0x40000000

    div-float v0, v3, v0

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    add-int/2addr v4, v0

    add-int/2addr v5, v0

    new-instance v8, Lcom/google/zxing/common/BitMatrix;

    invoke-direct {v8, v6, v7}, Lcom/google/zxing/common/BitMatrix;-><init>(II)V

    move v1, v2

    :goto_3
    if-ge v1, v7, :cond_c

    int-to-float v0, v1

    mul-float/2addr v0, v3

    float-to-int v0, v0

    add-int v9, v4, v0

    move v0, v2

    :goto_4
    if-ge v0, v6, :cond_b

    int-to-float v10, v0

    mul-float/2addr v10, v3

    float-to-int v10, v10

    add-int/2addr v10, v5

    invoke-virtual {p0, v10, v9}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v10

    if-eqz v10, :cond_a

    invoke-virtual {v8, v0, v1}, Lcom/google/zxing/common/BitMatrix;->set(II)V

    :cond_a
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    :cond_b
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_3

    :cond_c
    return-object v8

    :cond_d
    move v3, v4

    goto :goto_2
.end method


# virtual methods
.method public decode(Lcom/google/zxing/BinaryBitmap;)Lcom/google/zxing/Result;
    .locals 1

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/google/zxing/qrcode/QRCodeReader;->decode(Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;)Lcom/google/zxing/Result;

    move-result-object v0

    return-object v0
.end method

.method public decode(Lcom/google/zxing/BinaryBitmap;Ljava/util/Map;)Lcom/google/zxing/Result;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/zxing/BinaryBitmap;",
            "Ljava/util/Map",
            "<",
            "Lcom/google/zxing/DecodeHintType;",
            "*>;)",
            "Lcom/google/zxing/Result;"
        }
    .end annotation

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz p2, :cond_f

    sget-object v0, Lcom/google/zxing/DecodeHintType;->PURE_BARCODE:Lcom/google/zxing/DecodeHintType;

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_f

    invoke-virtual {p1}, Lcom/google/zxing/BinaryBitmap;->getBlackMatrix()Lcom/google/zxing/common/BitMatrix;

    move-result-object v7

    invoke-virtual {v7}, Lcom/google/zxing/common/BitMatrix;->getTopLeftOnBit()[I

    move-result-object v8

    invoke-virtual {v7}, Lcom/google/zxing/common/BitMatrix;->getBottomRightOnBit()[I

    move-result-object v9

    if-eqz v8, :cond_0

    if-nez v9, :cond_1

    :cond_0
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_1
    invoke-virtual {v7}, Lcom/google/zxing/common/BitMatrix;->getHeight()I

    move-result v10

    invoke-virtual {v7}, Lcom/google/zxing/common/BitMatrix;->getWidth()I

    move-result v11

    aget v3, v8, v2

    aget v0, v8, v1

    move v4, v1

    move v5, v0

    move v6, v3

    move v0, v2

    :goto_0
    if-ge v6, v11, :cond_3

    if-ge v5, v10, :cond_3

    invoke-virtual {v7, v6, v5}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v3

    if-eq v4, v3, :cond_10

    add-int/lit8 v3, v0, 0x1

    const/4 v0, 0x5

    if-eq v3, v0, :cond_3

    if-nez v4, :cond_2

    move v0, v1

    :goto_1
    move v12, v3

    move v3, v0

    move v0, v12

    :goto_2
    add-int/lit8 v6, v6, 0x1

    add-int/lit8 v4, v5, 0x1

    move v5, v4

    move v4, v3

    goto :goto_0

    :cond_2
    move v0, v2

    goto :goto_1

    :cond_3
    if-eq v6, v11, :cond_4

    if-ne v5, v10, :cond_5

    :cond_4
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_5
    aget v0, v8, v2

    sub-int v0, v6, v0

    int-to-float v0, v0

    const/high16 v3, 0x40e00000

    div-float v3, v0, v3

    aget v4, v8, v1

    aget v1, v9, v1

    aget v5, v8, v2

    aget v0, v9, v2

    sub-int v6, v1, v4

    sub-int v8, v0, v5

    if-eq v6, v8, :cond_6

    sub-int v0, v1, v4

    add-int/2addr v0, v5

    :cond_6
    sub-int/2addr v0, v5

    add-int/lit8 v0, v0, 0x1

    int-to-float v0, v0

    div-float/2addr v0, v3

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v6

    sub-int v0, v1, v4

    add-int/lit8 v0, v0, 0x1

    int-to-float v0, v0

    div-float/2addr v0, v3

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v8

    if-lez v6, :cond_7

    if-gtz v8, :cond_8

    :cond_7
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_8
    if-eq v8, v6, :cond_9

    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_9
    const/high16 v0, 0x40000000

    div-float v0, v3, v0

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    add-int/2addr v4, v0

    add-int/2addr v5, v0

    new-instance v9, Lcom/google/zxing/common/BitMatrix;

    invoke-direct {v9, v6, v8}, Lcom/google/zxing/common/BitMatrix;-><init>(II)V

    move v1, v2

    :goto_3
    if-ge v1, v8, :cond_c

    int-to-float v0, v1

    mul-float/2addr v0, v3

    float-to-int v0, v0

    add-int v10, v4, v0

    move v0, v2

    :goto_4
    if-ge v0, v6, :cond_b

    int-to-float v11, v0

    mul-float/2addr v11, v3

    float-to-int v11, v11

    add-int/2addr v11, v5

    invoke-virtual {v7, v11, v10}, Lcom/google/zxing/common/BitMatrix;->get(II)Z

    move-result v11

    if-eqz v11, :cond_a

    invoke-virtual {v9, v0, v1}, Lcom/google/zxing/common/BitMatrix;->set(II)V

    :cond_a
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    :cond_b
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_3

    :cond_c
    iget-object v0, p0, Lcom/google/zxing/qrcode/QRCodeReader;->b:Lcom/google/zxing/qrcode/decoder/Decoder;

    invoke-virtual {v0, v9, p2}, Lcom/google/zxing/qrcode/decoder/Decoder;->decode(Lcom/google/zxing/common/BitMatrix;Ljava/util/Map;)Lcom/google/zxing/common/DecoderResult;

    move-result-object v1

    sget-object v0, Lcom/google/zxing/qrcode/QRCodeReader;->a:[Lcom/google/zxing/ResultPoint;

    :goto_5
    new-instance v2, Lcom/google/zxing/Result;

    invoke-virtual {v1}, Lcom/google/zxing/common/DecoderResult;->getText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1}, Lcom/google/zxing/common/DecoderResult;->getRawBytes()[B

    move-result-object v4

    sget-object v5, Lcom/google/zxing/BarcodeFormat;->QR_CODE:Lcom/google/zxing/BarcodeFormat;

    invoke-direct {v2, v3, v4, v0, v5}, Lcom/google/zxing/Result;-><init>(Ljava/lang/String;[B[Lcom/google/zxing/ResultPoint;Lcom/google/zxing/BarcodeFormat;)V

    invoke-virtual {v1}, Lcom/google/zxing/common/DecoderResult;->getByteSegments()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_d

    sget-object v3, Lcom/google/zxing/ResultMetadataType;->BYTE_SEGMENTS:Lcom/google/zxing/ResultMetadataType;

    invoke-virtual {v2, v3, v0}, Lcom/google/zxing/Result;->putMetadata(Lcom/google/zxing/ResultMetadataType;Ljava/lang/Object;)V

    :cond_d
    invoke-virtual {v1}, Lcom/google/zxing/common/DecoderResult;->getECLevel()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_e

    sget-object v1, Lcom/google/zxing/ResultMetadataType;->ERROR_CORRECTION_LEVEL:Lcom/google/zxing/ResultMetadataType;

    invoke-virtual {v2, v1, v0}, Lcom/google/zxing/Result;->putMetadata(Lcom/google/zxing/ResultMetadataType;Ljava/lang/Object;)V

    :cond_e
    return-object v2

    :cond_f
    new-instance v0, Lcom/google/zxing/qrcode/detector/Detector;

    invoke-virtual {p1}, Lcom/google/zxing/BinaryBitmap;->getBlackMatrix()Lcom/google/zxing/common/BitMatrix;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/zxing/qrcode/detector/Detector;-><init>(Lcom/google/zxing/common/BitMatrix;)V

    invoke-virtual {v0, p2}, Lcom/google/zxing/qrcode/detector/Detector;->detect(Ljava/util/Map;)Lcom/google/zxing/common/DetectorResult;

    move-result-object v0

    iget-object v1, p0, Lcom/google/zxing/qrcode/QRCodeReader;->b:Lcom/google/zxing/qrcode/decoder/Decoder;

    invoke-virtual {v0}, Lcom/google/zxing/common/DetectorResult;->getBits()Lcom/google/zxing/common/BitMatrix;

    move-result-object v2

    invoke-virtual {v1, v2, p2}, Lcom/google/zxing/qrcode/decoder/Decoder;->decode(Lcom/google/zxing/common/BitMatrix;Ljava/util/Map;)Lcom/google/zxing/common/DecoderResult;

    move-result-object v1

    invoke-virtual {v0}, Lcom/google/zxing/common/DetectorResult;->getPoints()[Lcom/google/zxing/ResultPoint;

    move-result-object v0

    goto :goto_5

    :cond_10
    move v3, v4

    goto/16 :goto_2
.end method

.method protected getDecoder()Lcom/google/zxing/qrcode/decoder/Decoder;
    .locals 1

    iget-object v0, p0, Lcom/google/zxing/qrcode/QRCodeReader;->b:Lcom/google/zxing/qrcode/decoder/Decoder;

    return-object v0
.end method

.method public reset()V
    .locals 0

    return-void
.end method
