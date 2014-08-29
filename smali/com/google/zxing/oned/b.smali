.class final Lcom/google/zxing/oned/b;
.super Ljava/lang/Object;


# static fields
.field private static final a:[I

.field private static final b:[I


# instance fields
.field private final c:[I

.field private final d:Ljava/lang/StringBuilder;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x3

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/google/zxing/oned/b;->a:[I

    const/16 v0, 0xa

    new-array v0, v0, [I

    fill-array-data v0, :array_1

    sput-object v0, Lcom/google/zxing/oned/b;->b:[I

    return-void

    :array_0
    .array-data 4
        0x1
        0x1
        0x2
    .end array-data

    :array_1
    .array-data 4
        0x18
        0x14
        0x12
        0x11
        0xc
        0x6
        0x3
        0xa
        0x9
        0x5
    .end array-data
.end method

.method constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x4

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/google/zxing/oned/b;->c:[I

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v0, p0, Lcom/google/zxing/oned/b;->d:Ljava/lang/StringBuilder;

    return-void
.end method

.method private static a(I)I
    .locals 2

    const/4 v0, 0x0

    :goto_0
    const/16 v1, 0xa

    if-ge v0, v1, :cond_1

    sget-object v1, Lcom/google/zxing/oned/b;->b:[I

    aget v1, v1, v0

    if-ne p0, v1, :cond_0

    return v0

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0
.end method

.method private a(Lcom/google/zxing/common/BitArray;[ILjava/lang/StringBuilder;)I
    .locals 9

    iget-object v5, p0, Lcom/google/zxing/oned/b;->c:[I

    const/4 v0, 0x0

    const/4 v1, 0x0

    aput v1, v5, v0

    const/4 v0, 0x1

    const/4 v1, 0x0

    aput v1, v5, v0

    const/4 v0, 0x2

    const/4 v1, 0x0

    aput v1, v5, v0

    const/4 v0, 0x3

    const/4 v1, 0x0

    aput v1, v5, v0

    invoke-virtual {p1}, Lcom/google/zxing/common/BitArray;->getSize()I

    move-result v6

    const/4 v0, 0x1

    aget v3, p2, v0

    const/4 v1, 0x0

    const/4 v0, 0x0

    move v4, v0

    :goto_0
    const/4 v0, 0x5

    if-ge v4, v0, :cond_3

    if-ge v3, v6, :cond_3

    sget-object v0, Lcom/google/zxing/oned/UPCEANReader;->e:[[I

    invoke-static {p1, v5, v3, v0}, Lcom/google/zxing/oned/UPCEANReader;->a(Lcom/google/zxing/common/BitArray;[II[[I)I

    move-result v7

    rem-int/lit8 v0, v7, 0xa

    add-int/lit8 v0, v0, 0x30

    int-to-char v0, v0

    invoke-virtual {p3, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    array-length v8, v5

    const/4 v0, 0x0

    move v2, v0

    move v0, v3

    :goto_1
    if-ge v2, v8, :cond_0

    aget v3, v5, v2

    add-int/2addr v3, v0

    add-int/lit8 v0, v2, 0x1

    move v2, v0

    move v0, v3

    goto :goto_1

    :cond_0
    const/16 v2, 0xa

    if-lt v7, v2, :cond_1

    const/4 v2, 0x1

    rsub-int/lit8 v3, v4, 0x4

    shl-int/2addr v2, v3

    or-int/2addr v1, v2

    :cond_1
    const/4 v2, 0x4

    if-eq v4, v2, :cond_2

    invoke-virtual {p1, v0}, Lcom/google/zxing/common/BitArray;->getNextSet(I)I

    move-result v0

    invoke-virtual {p1, v0}, Lcom/google/zxing/common/BitArray;->getNextUnset(I)I

    move-result v0

    :cond_2
    add-int/lit8 v2, v4, 0x1

    move v4, v2

    move v3, v0

    goto :goto_0

    :cond_3
    invoke-virtual {p3}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    const/4 v2, 0x5

    if-eq v0, v2, :cond_4

    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_4
    const/4 v0, 0x0

    move v2, v0

    :goto_2
    const/16 v0, 0xa

    if-ge v2, v0, :cond_6

    sget-object v0, Lcom/google/zxing/oned/b;->b:[I

    aget v0, v0, v2

    if-ne v1, v0, :cond_5

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v4}, Ljava/lang/CharSequence;->length()I

    move-result v5

    const/4 v1, 0x0

    add-int/lit8 v0, v5, -0x2

    :goto_3
    if-ltz v0, :cond_7

    invoke-interface {v4, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v6

    add-int/lit8 v6, v6, -0x30

    add-int/2addr v1, v6

    add-int/lit8 v0, v0, -0x2

    goto :goto_3

    :cond_5
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_2

    :cond_6
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_7
    mul-int/lit8 v1, v1, 0x3

    add-int/lit8 v0, v5, -0x1

    :goto_4
    if-ltz v0, :cond_8

    invoke-interface {v4, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v5

    add-int/lit8 v5, v5, -0x30

    add-int/2addr v1, v5

    add-int/lit8 v0, v0, -0x2

    goto :goto_4

    :cond_8
    mul-int/lit8 v0, v1, 0x3

    rem-int/lit8 v0, v0, 0xa

    if-eq v0, v2, :cond_9

    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_9
    return v3
.end method

.method private static a(Ljava/lang/CharSequence;)I
    .locals 4

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v2

    const/4 v1, 0x0

    add-int/lit8 v0, v2, -0x2

    :goto_0
    if-ltz v0, :cond_0

    invoke-interface {p0, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    add-int/lit8 v3, v3, -0x30

    add-int/2addr v1, v3

    add-int/lit8 v0, v0, -0x2

    goto :goto_0

    :cond_0
    mul-int/lit8 v1, v1, 0x3

    add-int/lit8 v0, v2, -0x1

    :goto_1
    if-ltz v0, :cond_1

    invoke-interface {p0, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    add-int/lit8 v2, v2, -0x30

    add-int/2addr v1, v2

    add-int/lit8 v0, v0, -0x2

    goto :goto_1

    :cond_1
    mul-int/lit8 v0, v1, 0x3

    rem-int/lit8 v0, v0, 0xa

    return v0
.end method

.method private static a(Ljava/lang/String;)Ljava/util/Map;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Map",
            "<",
            "Lcom/google/zxing/ResultMetadataType;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    const/4 v2, 0x0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :cond_0
    :goto_0
    :pswitch_0
    return-object v2

    :pswitch_1
    sget-object v0, Lcom/google/zxing/ResultMetadataType;->ISSUE_NUMBER:Lcom/google/zxing/ResultMetadataType;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    :goto_1
    if-eqz v1, :cond_0

    new-instance v2, Ljava/util/EnumMap;

    const-class v3, Lcom/google/zxing/ResultMetadataType;

    invoke-direct {v2, v3}, Ljava/util/EnumMap;-><init>(Ljava/lang/Class;)V

    invoke-interface {v2, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :pswitch_2
    sget-object v3, Lcom/google/zxing/ResultMetadataType;->SUGGESTED_PRICE:Lcom/google/zxing/ResultMetadataType;

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    sparse-switch v0, :sswitch_data_0

    const-string v0, ""

    :goto_2
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    div-int/lit8 v4, v1, 0x64

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    rem-int/lit8 v1, v1, 0x64

    const/16 v5, 0xa

    if-ge v1, v5, :cond_4

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "0"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_3
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v4, 0x2e

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_4
    move-object v1, v0

    move-object v0, v3

    goto :goto_1

    :sswitch_0
    const-string v0, "\u00a3"

    goto :goto_2

    :sswitch_1
    const-string v0, "$"

    goto :goto_2

    :sswitch_2
    const-string v0, "90000"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    move-object v0, v2

    goto :goto_4

    :cond_1
    const-string v0, "99991"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "0.00"

    goto :goto_4

    :cond_2
    const-string v0, "99990"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "Used"

    goto :goto_4

    :cond_3
    const-string v0, ""

    goto :goto_2

    :cond_4
    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_3

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch

    :sswitch_data_0
    .sparse-switch
        0x30 -> :sswitch_0
        0x35 -> :sswitch_1
        0x39 -> :sswitch_2
    .end sparse-switch
.end method

.method private static b(Ljava/lang/String;)Ljava/lang/Integer;
    .locals 1

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method private static c(Ljava/lang/String;)Ljava/lang/String;
    .locals 5

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    sparse-switch v0, :sswitch_data_0

    const-string v0, ""

    :goto_0
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    div-int/lit8 v2, v1, 0x64

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    rem-int/lit8 v1, v1, 0x64

    const/16 v3, 0xa

    if-ge v1, v3, :cond_3

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "0"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v2, 0x2e

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_2
    return-object v0

    :sswitch_0
    const-string v0, "\u00a3"

    goto :goto_0

    :sswitch_1
    const-string v0, "$"

    goto :goto_0

    :sswitch_2
    const-string v0, "90000"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    goto :goto_2

    :cond_0
    const-string v0, "99991"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "0.00"

    goto :goto_2

    :cond_1
    const-string v0, "99990"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "Used"

    goto :goto_2

    :cond_2
    const-string v0, ""

    goto :goto_0

    :cond_3
    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    :sswitch_data_0
    .sparse-switch
        0x30 -> :sswitch_0
        0x35 -> :sswitch_1
        0x39 -> :sswitch_2
    .end sparse-switch
.end method


# virtual methods
.method final a(ILcom/google/zxing/common/BitArray;I)Lcom/google/zxing/Result;
    .locals 11

    const/4 v0, 0x0

    sget-object v1, Lcom/google/zxing/oned/b;->a:[I

    invoke-static {p2, p3, v0, v1}, Lcom/google/zxing/oned/UPCEANReader;->a(Lcom/google/zxing/common/BitArray;IZ[I)[I

    move-result-object v5

    iget-object v6, p0, Lcom/google/zxing/oned/b;->d:Ljava/lang/StringBuilder;

    const/4 v0, 0x0

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->setLength(I)V

    iget-object v7, p0, Lcom/google/zxing/oned/b;->c:[I

    const/4 v0, 0x0

    const/4 v1, 0x0

    aput v1, v7, v0

    const/4 v0, 0x1

    const/4 v1, 0x0

    aput v1, v7, v0

    const/4 v0, 0x2

    const/4 v1, 0x0

    aput v1, v7, v0

    const/4 v0, 0x3

    const/4 v1, 0x0

    aput v1, v7, v0

    invoke-virtual {p2}, Lcom/google/zxing/common/BitArray;->getSize()I

    move-result v8

    const/4 v0, 0x1

    aget v2, v5, v0

    const/4 v1, 0x0

    const/4 v0, 0x0

    move v3, v1

    move v4, v2

    move v1, v0

    :goto_0
    const/4 v0, 0x5

    if-ge v1, v0, :cond_2

    if-ge v4, v8, :cond_2

    sget-object v0, Lcom/google/zxing/oned/UPCEANReader;->e:[[I

    invoke-static {p2, v7, v4, v0}, Lcom/google/zxing/oned/UPCEANReader;->a(Lcom/google/zxing/common/BitArray;[II[[I)I

    move-result v9

    rem-int/lit8 v0, v9, 0xa

    add-int/lit8 v0, v0, 0x30

    int-to-char v0, v0

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    array-length v10, v7

    const/4 v0, 0x0

    move v2, v0

    move v0, v4

    :goto_1
    if-ge v2, v10, :cond_0

    aget v4, v7, v2

    add-int/2addr v4, v0

    add-int/lit8 v0, v2, 0x1

    move v2, v0

    move v0, v4

    goto :goto_1

    :cond_0
    const/16 v2, 0xa

    if-lt v9, v2, :cond_f

    const/4 v2, 0x1

    rsub-int/lit8 v4, v1, 0x4

    shl-int/2addr v2, v4

    or-int/2addr v2, v3

    :goto_2
    const/4 v3, 0x4

    if-eq v1, v3, :cond_1

    invoke-virtual {p2, v0}, Lcom/google/zxing/common/BitArray;->getNextSet(I)I

    move-result v0

    invoke-virtual {p2, v0}, Lcom/google/zxing/common/BitArray;->getNextUnset(I)I

    move-result v0

    :cond_1
    add-int/lit8 v1, v1, 0x1

    move v3, v2

    move v4, v0

    goto :goto_0

    :cond_2
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    const/4 v1, 0x5

    if-eq v0, v1, :cond_3

    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_3
    const/4 v0, 0x0

    move v2, v0

    :goto_3
    const/16 v0, 0xa

    if-ge v2, v0, :cond_5

    sget-object v0, Lcom/google/zxing/oned/b;->b:[I

    aget v0, v0, v2

    if-ne v3, v0, :cond_4

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/CharSequence;->length()I

    move-result v7

    const/4 v1, 0x0

    add-int/lit8 v0, v7, -0x2

    :goto_4
    if-ltz v0, :cond_6

    invoke-interface {v3, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v8

    add-int/lit8 v8, v8, -0x30

    add-int/2addr v1, v8

    add-int/lit8 v0, v0, -0x2

    goto :goto_4

    :cond_4
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_3

    :cond_5
    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_6
    mul-int/lit8 v1, v1, 0x3

    add-int/lit8 v0, v7, -0x1

    :goto_5
    if-ltz v0, :cond_7

    invoke-interface {v3, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v7

    add-int/lit8 v7, v7, -0x30

    add-int/2addr v1, v7

    add-int/lit8 v0, v0, -0x2

    goto :goto_5

    :cond_7
    mul-int/lit8 v0, v1, 0x3

    rem-int/lit8 v0, v0, 0xa

    if-eq v0, v2, :cond_8

    invoke-static {}, Lcom/google/zxing/NotFoundException;->getNotFoundInstance()Lcom/google/zxing/NotFoundException;

    move-result-object v0

    throw v0

    :cond_8
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :pswitch_0
    const/4 v0, 0x0

    :goto_6
    new-instance v1, Lcom/google/zxing/Result;

    const/4 v2, 0x0

    const/4 v6, 0x2

    new-array v6, v6, [Lcom/google/zxing/ResultPoint;

    const/4 v7, 0x0

    new-instance v8, Lcom/google/zxing/ResultPoint;

    const/4 v9, 0x0

    aget v9, v5, v9

    const/4 v10, 0x1

    aget v5, v5, v10

    add-int/2addr v5, v9

    int-to-float v5, v5

    const/high16 v9, 0x40000000

    div-float/2addr v5, v9

    int-to-float v9, p1

    invoke-direct {v8, v5, v9}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v8, v6, v7

    const/4 v5, 0x1

    new-instance v7, Lcom/google/zxing/ResultPoint;

    int-to-float v4, v4

    int-to-float v8, p1

    invoke-direct {v7, v4, v8}, Lcom/google/zxing/ResultPoint;-><init>(FF)V

    aput-object v7, v6, v5

    sget-object v4, Lcom/google/zxing/BarcodeFormat;->UPC_EAN_EXTENSION:Lcom/google/zxing/BarcodeFormat;

    invoke-direct {v1, v3, v2, v6, v4}, Lcom/google/zxing/Result;-><init>(Ljava/lang/String;[B[Lcom/google/zxing/ResultPoint;Lcom/google/zxing/BarcodeFormat;)V

    if-eqz v0, :cond_9

    invoke-virtual {v1, v0}, Lcom/google/zxing/Result;->putAllMetadata(Ljava/util/Map;)V

    :cond_9
    return-object v1

    :pswitch_1
    sget-object v1, Lcom/google/zxing/ResultMetadataType;->ISSUE_NUMBER:Lcom/google/zxing/ResultMetadataType;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    move-object v2, v1

    move-object v1, v0

    :goto_7
    if-nez v1, :cond_e

    const/4 v0, 0x0

    goto :goto_6

    :pswitch_2
    sget-object v2, Lcom/google/zxing/ResultMetadataType;->SUGGESTED_PRICE:Lcom/google/zxing/ResultMetadataType;

    const/4 v0, 0x0

    invoke-virtual {v3, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    sparse-switch v0, :sswitch_data_0

    const-string v0, ""

    :goto_8
    const/4 v1, 0x1

    invoke-virtual {v3, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    div-int/lit8 v6, v1, 0x64

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    rem-int/lit8 v1, v1, 0x64

    const/16 v7, 0xa

    if-ge v1, v7, :cond_d

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "0"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_9
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v6, 0x2e

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_a
    move-object v1, v0

    goto :goto_7

    :sswitch_0
    const-string v0, "\u00a3"

    goto :goto_8

    :sswitch_1
    const-string v0, "$"

    goto :goto_8

    :sswitch_2
    const-string v0, "90000"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    const/4 v0, 0x0

    goto :goto_a

    :cond_a
    const-string v0, "99991"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    const-string v0, "0.00"

    goto :goto_a

    :cond_b
    const-string v0, "99990"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    const-string v0, "Used"

    goto :goto_a

    :cond_c
    const-string v0, ""

    goto :goto_8

    :cond_d
    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_9

    :cond_e
    new-instance v0, Ljava/util/EnumMap;

    const-class v6, Lcom/google/zxing/ResultMetadataType;

    invoke-direct {v0, v6}, Ljava/util/EnumMap;-><init>(Ljava/lang/Class;)V

    invoke-interface {v0, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_6

    :cond_f
    move v2, v3

    goto/16 :goto_2

    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch

    :sswitch_data_0
    .sparse-switch
        0x30 -> :sswitch_0
        0x35 -> :sswitch_1
        0x39 -> :sswitch_2
    .end sparse-switch
.end method
