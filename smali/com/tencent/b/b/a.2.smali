.class public final Lcom/tencent/b/b/a;
.super Ljava/lang/Object;


# static fields
.field private static a:Lcom/tencent/b/b/a;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    sput-object v0, Lcom/tencent/b/b/a;->a:Lcom/tencent/b/b/a;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic a(Ljava/lang/String;)I
    .locals 4

    const/4 v0, 0x0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    move v1, v0

    :goto_0
    if-ge v0, v2, :cond_0

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v3

    invoke-static {v3}, Lcom/tencent/b/b/s;->a(C)I

    move-result v3

    add-int/2addr v1, v3

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    shl-int/lit8 v0, v2, 0x7

    add-int/2addr v0, v2

    xor-int/2addr v0, v1

    return v0
.end method

.method public static declared-synchronized a()Lcom/tencent/b/b/a;
    .locals 2

    const-class v1, Lcom/tencent/b/b/a;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/tencent/b/b/a;->a:Lcom/tencent/b/b/a;

    if-nez v0, :cond_0

    new-instance v0, Lcom/tencent/b/b/a;

    invoke-direct {v0}, Lcom/tencent/b/b/a;-><init>()V

    sput-object v0, Lcom/tencent/b/b/a;->a:Lcom/tencent/b/b/a;

    :cond_0
    sget-object v0, Lcom/tencent/b/b/a;->a:Lcom/tencent/b/b/a;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public final a(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 8

    const/16 v7, 0x1b

    const/4 v3, 0x1

    const/4 v1, 0x0

    invoke-static {p1}, Lcom/tencent/b/b/s;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return v1

    :cond_1
    invoke-static {p2}, Lcom/tencent/b/b/s;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/tencent/b/b/g;

    invoke-direct {v0, p0, v1}, Lcom/tencent/b/b/g;-><init>(Lcom/tencent/b/b/a;B)V

    iget-object v0, v0, Lcom/tencent/b/b/g;->a:Lcom/tencent/b/b/a;

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v4

    move v0, v1

    move v2, v1

    :goto_1
    if-ge v0, v4, :cond_2

    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v5

    invoke-static {v5}, Lcom/tencent/b/b/s;->a(C)I

    move-result v5

    add-int/2addr v2, v5

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_2
    shl-int/lit8 v0, v4, 0x7

    add-int/2addr v0, v4

    xor-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x9

    add-int/lit8 v2, v2, 0xa

    div-int/lit8 v2, v2, 0x3

    add-int/lit8 v2, v2, 0x24

    and-int/lit8 v2, v2, 0x1f

    const/4 v4, 0x4

    invoke-virtual {p2, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    sget-object v5, Lcom/tencent/b/b/s;->a:Ljava/lang/String;

    invoke-virtual {v5, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    if-eq v4, v2, :cond_3

    move v0, v1

    :goto_2
    if-eqz v0, :cond_0

    move v0, v1

    move v2, v1

    :goto_3
    if-ge v0, v7, :cond_d

    shr-int/lit8 v4, v2, 0x8

    and-int/lit16 v4, v4, 0xff

    sget-object v5, Lcom/tencent/b/b/s;->b:[I

    invoke-virtual {p2, v0}, Ljava/lang/String;->charAt(I)C

    move-result v6

    invoke-static {v6}, Lcom/tencent/b/b/s;->a(C)I

    move-result v6

    xor-int/2addr v2, v6

    and-int/lit16 v2, v2, 0xff

    aget v2, v5, v2

    xor-int/2addr v2, v4

    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    :cond_3
    mul-int/lit8 v2, v0, 0x5

    add-int/lit8 v2, v2, 0xb

    div-int/lit8 v2, v2, 0x5

    and-int/lit8 v2, v2, 0x1f

    const/4 v4, 0x7

    invoke-virtual {p2, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    sget-object v5, Lcom/tencent/b/b/s;->a:Ljava/lang/String;

    invoke-virtual {v5, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    if-eq v4, v2, :cond_4

    move v0, v1

    goto :goto_2

    :cond_4
    add-int/lit8 v2, v0, 0xa

    div-int/lit8 v2, v2, 0x3

    shl-int/lit8 v2, v2, 0x3

    and-int/lit8 v2, v2, 0x1f

    const/16 v4, 0xc

    invoke-virtual {p2, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    sget-object v5, Lcom/tencent/b/b/s;->a:Ljava/lang/String;

    invoke-virtual {v5, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    if-eq v4, v2, :cond_5

    move v0, v1

    goto :goto_2

    :cond_5
    mul-int/lit8 v2, v0, 0x3

    add-int/lit8 v2, v2, 0x13

    div-int/lit8 v2, v2, 0x9

    and-int/lit8 v2, v2, 0x1f

    const/16 v4, 0xe

    invoke-virtual {p2, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    sget-object v5, Lcom/tencent/b/b/s;->a:Ljava/lang/String;

    invoke-virtual {v5, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    if-eq v4, v2, :cond_6

    move v0, v1

    goto :goto_2

    :cond_6
    mul-int/lit8 v2, v0, 0x3

    add-int/lit8 v2, v2, 0x27

    div-int/lit8 v2, v2, 0x8

    and-int/lit8 v2, v2, 0x1f

    const/16 v4, 0x13

    invoke-virtual {p2, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    sget-object v5, Lcom/tencent/b/b/s;->a:Ljava/lang/String;

    invoke-virtual {v5, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    if-eq v4, v2, :cond_7

    move v0, v1

    goto :goto_2

    :cond_7
    div-int/lit8 v2, v0, 0x17

    add-int/lit8 v2, v2, 0x43

    div-int/lit8 v2, v2, 0x7

    and-int/lit8 v2, v2, 0x1f

    const/16 v4, 0x15

    invoke-virtual {p2, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    sget-object v5, Lcom/tencent/b/b/s;->a:Ljava/lang/String;

    invoke-virtual {v5, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    if-eq v4, v2, :cond_8

    move v0, v1

    goto/16 :goto_2

    :cond_8
    add-int/lit8 v0, v0, 0x17

    div-int/lit8 v0, v0, 0x6

    add-int/lit8 v0, v0, 0x3

    mul-int/lit8 v0, v0, 0x7

    and-int/lit8 v0, v0, 0x1f

    const/16 v2, 0x1a

    invoke-virtual {p2, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    sget-object v4, Lcom/tencent/b/b/s;->a:Ljava/lang/String;

    invoke-virtual {v4, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    if-eq v2, v0, :cond_9

    move v0, v1

    goto/16 :goto_2

    :cond_9
    move v0, v1

    move v2, v1

    :goto_4
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v4

    if-ge v0, v4, :cond_a

    shr-int/lit8 v4, v2, 0x8

    and-int/lit16 v4, v4, 0xff

    sget-object v5, Lcom/tencent/b/b/s;->b:[I

    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v6

    invoke-static {v6}, Lcom/tencent/b/b/s;->a(C)I

    move-result v6

    xor-int/2addr v2, v6

    and-int/lit16 v2, v2, 0xff

    aget v2, v5, v2

    xor-int/2addr v2, v4

    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    :cond_a
    and-int/lit8 v0, v2, 0x1f

    invoke-virtual {p2, v1}, Ljava/lang/String;->charAt(I)C

    move-result v4

    sget-object v5, Lcom/tencent/b/b/s;->a:Ljava/lang/String;

    invoke-virtual {v5, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    if-eq v4, v0, :cond_b

    move v0, v1

    goto/16 :goto_2

    :cond_b
    shr-int/lit8 v0, v2, 0x5

    and-int/lit8 v0, v0, 0x1f

    invoke-virtual {p2, v3}, Ljava/lang/String;->charAt(I)C

    move-result v2

    sget-object v4, Lcom/tencent/b/b/s;->a:Ljava/lang/String;

    invoke-virtual {v4, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    if-eq v2, v0, :cond_c

    move v0, v1

    goto/16 :goto_2

    :cond_c
    move v0, v3

    goto/16 :goto_2

    :cond_d
    and-int/lit8 v0, v2, 0x1f

    invoke-virtual {p2, v7}, Ljava/lang/String;->charAt(I)C

    move-result v4

    sget-object v5, Lcom/tencent/b/b/s;->a:Ljava/lang/String;

    invoke-virtual {v5, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    if-eq v4, v0, :cond_e

    move v0, v1

    :goto_5
    if-eqz v0, :cond_0

    move v1, v3

    goto/16 :goto_0

    :cond_e
    shr-int/lit8 v0, v2, 0x5

    and-int/lit8 v0, v0, 0x1f

    const/16 v2, 0x1c

    invoke-virtual {p2, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    sget-object v4, Lcom/tencent/b/b/s;->a:Ljava/lang/String;

    invoke-virtual {v4, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    if-eq v2, v0, :cond_f

    move v0, v1

    goto :goto_5

    :cond_f
    move v0, v3

    goto :goto_5
.end method
