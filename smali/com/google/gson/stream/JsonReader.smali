.class public Lcom/google/gson/stream/JsonReader;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/io/Closeable;


# static fields
.field private static final A:I = 0x6

.field private static final B:I = 0x7

.field private static final a:[C

.field private static final b:J = -0xcccccccccccccccL

.field private static final c:I = 0x0

.field private static final d:I = 0x1

.field private static final e:I = 0x2

.field private static final f:I = 0x3

.field private static final g:I = 0x4

.field private static final h:I = 0x5

.field private static final i:I = 0x6

.field private static final j:I = 0x7

.field private static final k:I = 0x8

.field private static final l:I = 0x9

.field private static final m:I = 0xa

.field private static final n:I = 0xb

.field private static final o:I = 0xc

.field private static final p:I = 0xd

.field private static final q:I = 0xe

.field private static final r:I = 0xf

.field private static final s:I = 0x10

.field private static final t:I = 0x11

.field private static final u:I = 0x0

.field private static final v:I = 0x1

.field private static final w:I = 0x2

.field private static final x:I = 0x3

.field private static final y:I = 0x4

.field private static final z:I = 0x5


# instance fields
.field private final C:Ljava/io/Reader;

.field private D:Z

.field private final E:[C

.field private F:I

.field private G:I

.field private H:I

.field private I:I

.field private J:I

.field private K:J

.field private L:I

.field private M:Ljava/lang/String;

.field private N:[I

.field private O:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-string v0, ")]}\'\n"

    invoke-virtual {v0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    sput-object v0, Lcom/google/gson/stream/JsonReader;->a:[C

    new-instance v0, Lcom/google/gson/stream/a;

    invoke-direct {v0}, Lcom/google/gson/stream/a;-><init>()V

    sput-object v0, Lcom/google/gson/internal/JsonReaderInternalAccess;->INSTANCE:Lcom/google/gson/internal/JsonReaderInternalAccess;

    return-void
.end method

.method public constructor <init>(Ljava/io/Reader;)V
    .locals 3

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean v1, p0, Lcom/google/gson/stream/JsonReader;->D:Z

    const/16 v0, 0x400

    new-array v0, v0, [C

    iput-object v0, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->G:I

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->H:I

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->I:I

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->J:I

    const/16 v0, 0x20

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/google/gson/stream/JsonReader;->N:[I

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->O:I

    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->N:[I

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->O:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->O:I

    const/4 v2, 0x6

    aput v2, v0, v1

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "in == null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iput-object p1, p0, Lcom/google/gson/stream/JsonReader;->C:Ljava/io/Reader;

    return-void
.end method

.method private a()I
    .locals 8

    const/4 v4, 0x7

    const/4 v7, 0x5

    const/4 v1, 0x4

    const/4 v2, 0x2

    const/4 v3, 0x1

    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->N:[I

    iget v5, p0, Lcom/google/gson/stream/JsonReader;->O:I

    add-int/lit8 v5, v5, -0x1

    aget v5, v0, v5

    if-ne v5, v3, :cond_3

    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->N:[I

    iget v6, p0, Lcom/google/gson/stream/JsonReader;->O:I

    add-int/lit8 v6, v6, -0x1

    aput v2, v0, v6

    :cond_0
    :goto_0
    :pswitch_0
    :sswitch_0
    invoke-direct {p0, v3}, Lcom/google/gson/stream/JsonReader;->a(Z)I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->O:I

    if-ne v0, v3, :cond_1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    :cond_1
    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->b()I

    move-result v0

    if-eqz v0, :cond_16

    :cond_2
    :goto_1
    return v0

    :cond_3
    if-ne v5, v2, :cond_4

    invoke-direct {p0, v3}, Lcom/google/gson/stream/JsonReader;->a(Z)I

    move-result v0

    sparse-switch v0, :sswitch_data_1

    const-string v0, "Unterminated array"

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :sswitch_1
    iput v1, p0, Lcom/google/gson/stream/JsonReader;->J:I

    move v0, v1

    goto :goto_1

    :sswitch_2
    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    goto :goto_0

    :cond_4
    const/4 v0, 0x3

    if-eq v5, v0, :cond_5

    if-ne v5, v7, :cond_9

    :cond_5
    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->N:[I

    iget v4, p0, Lcom/google/gson/stream/JsonReader;->O:I

    add-int/lit8 v4, v4, -0x1

    aput v1, v0, v4

    if-ne v5, v7, :cond_6

    invoke-direct {p0, v3}, Lcom/google/gson/stream/JsonReader;->a(Z)I

    move-result v0

    sparse-switch v0, :sswitch_data_2

    const-string v0, "Unterminated object"

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :sswitch_3
    iput v2, p0, Lcom/google/gson/stream/JsonReader;->J:I

    move v0, v2

    goto :goto_1

    :sswitch_4
    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    :cond_6
    :sswitch_5
    invoke-direct {p0, v3}, Lcom/google/gson/stream/JsonReader;->a(Z)I

    move-result v0

    sparse-switch v0, :sswitch_data_3

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    int-to-char v0, v0

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->a(C)Z

    move-result v0

    if-eqz v0, :cond_8

    const/16 v0, 0xe

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    goto :goto_1

    :sswitch_6
    const/16 v0, 0xd

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    goto :goto_1

    :sswitch_7
    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    const/16 v0, 0xc

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    goto :goto_1

    :sswitch_8
    if-eq v5, v7, :cond_7

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->J:I

    move v0, v2

    goto :goto_1

    :cond_7
    const-string v0, "Expected name"

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_8
    const-string v0, "Expected name"

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_9
    if-ne v5, v1, :cond_b

    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->N:[I

    iget v6, p0, Lcom/google/gson/stream/JsonReader;->O:I

    add-int/lit8 v6, v6, -0x1

    aput v7, v0, v6

    invoke-direct {p0, v3}, Lcom/google/gson/stream/JsonReader;->a(Z)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :pswitch_1
    const-string v0, "Expected \':\'"

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :pswitch_2
    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v6, p0, Lcom/google/gson/stream/JsonReader;->G:I

    if-lt v0, v6, :cond_a

    invoke-direct {p0, v3}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_a
    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v6, p0, Lcom/google/gson/stream/JsonReader;->F:I

    aget-char v0, v0, v6

    const/16 v6, 0x3e

    if-ne v0, v6, :cond_0

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    goto/16 :goto_0

    :cond_b
    const/4 v0, 0x6

    if-ne v5, v0, :cond_f

    iget-boolean v0, p0, Lcom/google/gson/stream/JsonReader;->D:Z

    if-eqz v0, :cond_e

    invoke-direct {p0, v3}, Lcom/google/gson/stream/JsonReader;->a(Z)I

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    sget-object v6, Lcom/google/gson/stream/JsonReader;->a:[C

    array-length v6, v6

    add-int/2addr v0, v6

    iget v6, p0, Lcom/google/gson/stream/JsonReader;->G:I

    if-le v0, v6, :cond_c

    sget-object v0, Lcom/google/gson/stream/JsonReader;->a:[C

    array-length v0, v0

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v0

    if-eqz v0, :cond_e

    :cond_c
    const/4 v0, 0x0

    :goto_2
    sget-object v6, Lcom/google/gson/stream/JsonReader;->a:[C

    array-length v6, v6

    if-ge v0, v6, :cond_d

    iget-object v6, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v7, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v7, v0

    aget-char v6, v6, v7

    sget-object v7, Lcom/google/gson/stream/JsonReader;->a:[C

    aget-char v7, v7, v0

    if-ne v6, v7, :cond_e

    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_d
    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    sget-object v6, Lcom/google/gson/stream/JsonReader;->a:[C

    array-length v6, v6

    add-int/2addr v0, v6

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    :cond_e
    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->N:[I

    iget v6, p0, Lcom/google/gson/stream/JsonReader;->O:I

    add-int/lit8 v6, v6, -0x1

    aput v4, v0, v6

    goto/16 :goto_0

    :cond_f
    if-ne v5, v4, :cond_11

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->a(Z)I

    move-result v0

    const/4 v6, -0x1

    if-ne v0, v6, :cond_10

    const/16 v0, 0x11

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    goto/16 :goto_1

    :cond_10
    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    goto/16 :goto_0

    :cond_11
    const/16 v0, 0x8

    if-ne v5, v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "JsonReader is closed"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :sswitch_9
    if-ne v5, v3, :cond_12

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->J:I

    move v0, v1

    goto/16 :goto_1

    :cond_12
    :sswitch_a
    if-eq v5, v3, :cond_13

    if-ne v5, v2, :cond_14

    :cond_13
    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iput v4, p0, Lcom/google/gson/stream/JsonReader;->J:I

    move v0, v4

    goto/16 :goto_1

    :cond_14
    const-string v0, "Unexpected value"

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :sswitch_b
    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    const/16 v0, 0x8

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    goto/16 :goto_1

    :sswitch_c
    iget v0, p0, Lcom/google/gson/stream/JsonReader;->O:I

    if-ne v0, v3, :cond_15

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    :cond_15
    const/16 v0, 0x9

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    goto/16 :goto_1

    :sswitch_d
    const/4 v0, 0x3

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    goto/16 :goto_1

    :sswitch_e
    iput v3, p0, Lcom/google/gson/stream/JsonReader;->J:I

    move v0, v3

    goto/16 :goto_1

    :cond_16
    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->c()I

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    aget-char v0, v0, v1

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->a(C)Z

    move-result v0

    if-nez v0, :cond_17

    const-string v0, "Expected value"

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_17
    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    const/16 v0, 0xa

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    goto/16 :goto_1

    :sswitch_data_0
    .sparse-switch
        0x22 -> :sswitch_c
        0x27 -> :sswitch_b
        0x2c -> :sswitch_a
        0x3b -> :sswitch_a
        0x5b -> :sswitch_d
        0x5d -> :sswitch_9
        0x7b -> :sswitch_e
    .end sparse-switch

    :sswitch_data_1
    .sparse-switch
        0x2c -> :sswitch_0
        0x3b -> :sswitch_2
        0x5d -> :sswitch_1
    .end sparse-switch

    :sswitch_data_2
    .sparse-switch
        0x2c -> :sswitch_5
        0x3b -> :sswitch_4
        0x7d -> :sswitch_3
    .end sparse-switch

    :sswitch_data_3
    .sparse-switch
        0x22 -> :sswitch_6
        0x27 -> :sswitch_7
        0x7d -> :sswitch_8
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x3a
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method static synthetic a(Lcom/google/gson/stream/JsonReader;)I
    .locals 1

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    return v0
.end method

.method static synthetic a(Lcom/google/gson/stream/JsonReader;I)I
    .locals 0

    iput p1, p0, Lcom/google/gson/stream/JsonReader;->J:I

    return p1
.end method

.method private a(Z)I
    .locals 8

    const/16 v7, 0xa

    const/4 v3, 0x1

    const/4 v2, 0x0

    iget-object v5, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->G:I

    :goto_0
    if-ne v1, v0, :cond_0

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    invoke-direct {p0, v3}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v0

    if-eqz v0, :cond_b

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->G:I

    :cond_0
    add-int/lit8 v4, v1, 0x1

    aget-char v1, v5, v1

    if-ne v1, v7, :cond_1

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->H:I

    iput v4, p0, Lcom/google/gson/stream/JsonReader;->I:I

    move v1, v4

    goto :goto_0

    :cond_1
    const/16 v6, 0x20

    if-eq v1, v6, :cond_d

    const/16 v6, 0xd

    if-eq v1, v6, :cond_d

    const/16 v6, 0x9

    if-eq v1, v6, :cond_d

    const/16 v6, 0x2f

    if-ne v1, v6, :cond_9

    iput v4, p0, Lcom/google/gson/stream/JsonReader;->F:I

    if-ne v4, v0, :cond_2

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v0

    iget v4, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v4, v4, 0x1

    iput v4, p0, Lcom/google/gson/stream/JsonReader;->F:I

    if-nez v0, :cond_2

    move v0, v1

    :goto_1
    return v0

    :cond_2
    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    aget-char v0, v5, v0

    sparse-switch v0, :sswitch_data_0

    move v0, v1

    goto :goto_1

    :sswitch_0
    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    const-string v1, "*/"

    :goto_2
    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    add-int/2addr v0, v4

    iget v4, p0, Lcom/google/gson/stream/JsonReader;->G:I

    if-le v0, v4, :cond_3

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v0

    if-eqz v0, :cond_7

    :cond_3
    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v4, p0, Lcom/google/gson/stream/JsonReader;->F:I

    aget-char v0, v0, v4

    if-ne v0, v7, :cond_5

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->H:I

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->I:I

    :cond_4
    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    goto :goto_2

    :cond_5
    move v0, v2

    :goto_3
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    if-ge v0, v4, :cond_6

    iget-object v4, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v6, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v6, v0

    aget-char v4, v4, v6

    invoke-virtual {v1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v6

    if-ne v4, v6, :cond_4

    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    :cond_6
    move v0, v3

    :goto_4
    if-nez v0, :cond_8

    const-string v0, "Unterminated comment"

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_7
    move v0, v2

    goto :goto_4

    :cond_8
    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v1, v0, 0x2

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->G:I

    goto/16 :goto_0

    :sswitch_1
    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->i()V

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->G:I

    goto/16 :goto_0

    :cond_9
    const/16 v0, 0x23

    if-ne v1, v0, :cond_a

    iput v4, p0, Lcom/google/gson/stream/JsonReader;->F:I

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->i()V

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->G:I

    goto/16 :goto_0

    :cond_a
    iput v4, p0, Lcom/google/gson/stream/JsonReader;->F:I

    move v0, v1

    goto/16 :goto_1

    :cond_b
    if-eqz p1, :cond_c

    new-instance v0, Ljava/io/EOFException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "End of input at line "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/EOFException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_c
    const/4 v0, -0x1

    goto/16 :goto_1

    :cond_d
    move v1, v4

    goto/16 :goto_0

    nop

    :sswitch_data_0
    .sparse-switch
        0x2a -> :sswitch_0
        0x2f -> :sswitch_1
    .end sparse-switch
.end method

.method private a(I)V
    .locals 4

    const/4 v3, 0x0

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->O:I

    iget-object v1, p0, Lcom/google/gson/stream/JsonReader;->N:[I

    array-length v1, v1

    if-ne v0, v1, :cond_0

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->O:I

    shl-int/lit8 v0, v0, 0x1

    new-array v0, v0, [I

    iget-object v1, p0, Lcom/google/gson/stream/JsonReader;->N:[I

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->O:I

    invoke-static {v1, v3, v0, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iput-object v0, p0, Lcom/google/gson/stream/JsonReader;->N:[I

    :cond_0
    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->N:[I

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->O:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->O:I

    aput p1, v0, v1

    return-void
.end method

.method private a(C)Z
    .locals 1

    sparse-switch p1, :sswitch_data_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :sswitch_0
    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    :sswitch_1
    const/4 v0, 0x0

    goto :goto_0

    :sswitch_data_0
    .sparse-switch
        0x9 -> :sswitch_1
        0xa -> :sswitch_1
        0xc -> :sswitch_1
        0xd -> :sswitch_1
        0x20 -> :sswitch_1
        0x23 -> :sswitch_0
        0x2c -> :sswitch_1
        0x2f -> :sswitch_0
        0x3a -> :sswitch_1
        0x3b -> :sswitch_0
        0x3d -> :sswitch_0
        0x5b -> :sswitch_1
        0x5c -> :sswitch_0
        0x5d -> :sswitch_1
        0x7b -> :sswitch_1
        0x7d -> :sswitch_1
    .end sparse-switch
.end method

.method private a(Ljava/lang/String;)Z
    .locals 4

    const/4 v1, 0x0

    :goto_0
    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v0, v2

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->G:I

    if-le v0, v2, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v0

    if-eqz v0, :cond_4

    :cond_0
    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    aget-char v0, v0, v2

    const/16 v2, 0xa

    if-ne v0, v2, :cond_2

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->H:I

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->I:I

    :cond_1
    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    goto :goto_0

    :cond_2
    move v0, v1

    :goto_1
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v0, v2, :cond_3

    iget-object v2, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v3, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v3, v0

    aget-char v2, v2, v3

    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v3

    if-ne v2, v3, :cond_1

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_3
    const/4 v1, 0x1

    :cond_4
    return v1
.end method

.method private b()I
    .locals 8

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    aget-char v0, v0, v1

    const/16 v1, 0x74

    if-eq v0, v1, :cond_0

    const/16 v1, 0x54

    if-ne v0, v1, :cond_1

    :cond_0
    const-string v2, "true"

    const-string v1, "TRUE"

    const/4 v0, 0x5

    :goto_0
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    const/4 v4, 0x1

    :goto_1
    if-ge v4, v5, :cond_8

    iget v6, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v6, v4

    iget v7, p0, Lcom/google/gson/stream/JsonReader;->G:I

    if-lt v6, v7, :cond_6

    add-int/lit8 v6, v4, 0x1

    invoke-direct {p0, v6}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v6

    if-nez v6, :cond_6

    move v0, v3

    :goto_2
    return v0

    :cond_1
    const/16 v1, 0x66

    if-eq v0, v1, :cond_2

    const/16 v1, 0x46

    if-ne v0, v1, :cond_3

    :cond_2
    const-string v2, "false"

    const-string v1, "FALSE"

    const/4 v0, 0x6

    goto :goto_0

    :cond_3
    const/16 v1, 0x6e

    if-eq v0, v1, :cond_4

    const/16 v1, 0x4e

    if-ne v0, v1, :cond_5

    :cond_4
    const-string v2, "null"

    const-string v1, "NULL"

    const/4 v0, 0x7

    goto :goto_0

    :cond_5
    move v0, v3

    goto :goto_2

    :cond_6
    iget-object v6, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v7, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v7, v4

    aget-char v6, v6, v7

    invoke-virtual {v2, v4}, Ljava/lang/String;->charAt(I)C

    move-result v7

    if-eq v6, v7, :cond_7

    invoke-virtual {v1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v7

    if-eq v6, v7, :cond_7

    move v0, v3

    goto :goto_2

    :cond_7
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    :cond_8
    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v1, v5

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->G:I

    if-lt v1, v2, :cond_9

    add-int/lit8 v1, v5, 0x1

    invoke-direct {p0, v1}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v1

    if-eqz v1, :cond_a

    :cond_9
    iget-object v1, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v2, v5

    aget-char v1, v1, v2

    invoke-direct {p0, v1}, Lcom/google/gson/stream/JsonReader;->a(C)Z

    move-result v1

    if-eqz v1, :cond_a

    move v0, v3

    goto :goto_2

    :cond_a
    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v1, v5

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    goto :goto_2
.end method

.method static synthetic b(Lcom/google/gson/stream/JsonReader;)I
    .locals 1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->a()I

    move-result v0

    return v0
.end method

.method private b(Ljava/lang/String;)Ljava/io/IOException;
    .locals 3

    new-instance v0, Lcom/google/gson/stream/MalformedJsonException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/gson/stream/MalformedJsonException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private b(C)Ljava/lang/String;
    .locals 7

    iget-object v4, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    :cond_0
    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->G:I

    move v2, v0

    :goto_0
    if-ge v2, v1, :cond_4

    add-int/lit8 v3, v2, 0x1

    aget-char v2, v4, v2

    if-ne v2, p1, :cond_1

    iput v3, p0, Lcom/google/gson/stream/JsonReader;->F:I

    sub-int v1, v3, v0

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v5, v4, v0, v1}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_1
    const/16 v6, 0x5c

    if-ne v2, v6, :cond_2

    iput v3, p0, Lcom/google/gson/stream/JsonReader;->F:I

    sub-int v1, v3, v0

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v5, v4, v0, v1}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->j()C

    move-result v0

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->G:I

    move v2, v0

    goto :goto_0

    :cond_2
    const/16 v6, 0xa

    if-ne v2, v6, :cond_3

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    iput v3, p0, Lcom/google/gson/stream/JsonReader;->I:I

    :cond_3
    move v2, v3

    goto :goto_0

    :cond_4
    sub-int v1, v2, v0

    invoke-virtual {v5, v4, v0, v1}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "Unterminated string"

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v0

    throw v0
.end method

.method private b(I)Z
    .locals 6

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->I:I

    iget v3, p0, Lcom/google/gson/stream/JsonReader;->F:I

    sub-int/2addr v2, v3

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->I:I

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->G:I

    iget v3, p0, Lcom/google/gson/stream/JsonReader;->F:I

    if-eq v2, v3, :cond_3

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->G:I

    iget v3, p0, Lcom/google/gson/stream/JsonReader;->F:I

    sub-int/2addr v2, v3

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->G:I

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v3, p0, Lcom/google/gson/stream/JsonReader;->G:I

    invoke-static {v1, v2, v1, v0, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :goto_0
    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    :cond_0
    iget-object v2, p0, Lcom/google/gson/stream/JsonReader;->C:Ljava/io/Reader;

    iget v3, p0, Lcom/google/gson/stream/JsonReader;->G:I

    array-length v4, v1

    iget v5, p0, Lcom/google/gson/stream/JsonReader;->G:I

    sub-int/2addr v4, v5

    invoke-virtual {v2, v1, v3, v4}, Ljava/io/Reader;->read([CII)I

    move-result v2

    const/4 v3, -0x1

    if-eq v2, v3, :cond_2

    iget v3, p0, Lcom/google/gson/stream/JsonReader;->G:I

    add-int/2addr v2, v3

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->G:I

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    if-nez v2, :cond_1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->I:I

    if-nez v2, :cond_1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->G:I

    if-lez v2, :cond_1

    aget-char v2, v1, v0

    const v3, 0xfeff

    if-ne v2, v3, :cond_1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->I:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->I:I

    add-int/lit8 p1, p1, 0x1

    :cond_1
    iget v2, p0, Lcom/google/gson/stream/JsonReader;->G:I

    if-lt v2, p1, :cond_0

    const/4 v0, 0x1

    :cond_2
    return v0

    :cond_3
    iput v0, p0, Lcom/google/gson/stream/JsonReader;->G:I

    goto :goto_0
.end method

.method private c()I
    .locals 19

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/google/gson/stream/JsonReader;->E:[C

    move-object/from16 v0, p0

    iget v3, v0, Lcom/google/gson/stream/JsonReader;->F:I

    move-object/from16 v0, p0

    iget v2, v0, Lcom/google/gson/stream/JsonReader;->G:I

    const-wide/16 v7, 0x0

    const/4 v6, 0x0

    const/4 v5, 0x1

    const/4 v4, 0x0

    const/4 v1, 0x0

    move v11, v1

    move v1, v2

    move v2, v3

    :goto_0
    add-int v3, v2, v11

    if-ne v3, v1, :cond_1

    array-length v1, v12

    if-ne v11, v1, :cond_0

    const/4 v1, 0x0

    :goto_1
    return v1

    :cond_0
    add-int/lit8 v1, v11, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v1

    if-eqz v1, :cond_12

    move-object/from16 v0, p0

    iget v2, v0, Lcom/google/gson/stream/JsonReader;->F:I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/gson/stream/JsonReader;->G:I

    :cond_1
    add-int v3, v2, v11

    aget-char v3, v12, v3

    sparse-switch v3, :sswitch_data_0

    const/16 v9, 0x30

    if-lt v3, v9, :cond_2

    const/16 v9, 0x39

    if-le v3, v9, :cond_9

    :cond_2
    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/google/gson/stream/JsonReader;->a(C)Z

    move-result v1

    if-eqz v1, :cond_12

    const/4 v1, 0x0

    goto :goto_1

    :sswitch_0
    if-nez v4, :cond_3

    const/4 v4, 0x1

    const/4 v3, 0x1

    move v15, v5

    move v5, v4

    move v4, v15

    move-wide/from16 v16, v7

    move-wide/from16 v6, v16

    :goto_2
    add-int/lit8 v8, v11, 0x1

    move v11, v8

    move v15, v4

    move v4, v3

    move/from16 v16, v5

    move v5, v15

    move-wide/from16 v17, v6

    move-wide/from16 v7, v17

    move/from16 v6, v16

    goto :goto_0

    :cond_3
    const/4 v3, 0x5

    if-ne v4, v3, :cond_4

    const/4 v3, 0x6

    move v4, v5

    move v5, v6

    move-wide v15, v7

    move-wide v6, v15

    goto :goto_2

    :cond_4
    const/4 v1, 0x0

    goto :goto_1

    :sswitch_1
    const/4 v3, 0x5

    if-ne v4, v3, :cond_5

    const/4 v3, 0x6

    move v4, v5

    move v5, v6

    move-wide v15, v7

    move-wide v6, v15

    goto :goto_2

    :cond_5
    const/4 v1, 0x0

    goto :goto_1

    :sswitch_2
    const/4 v3, 0x2

    if-eq v4, v3, :cond_6

    const/4 v3, 0x4

    if-ne v4, v3, :cond_7

    :cond_6
    const/4 v3, 0x5

    move v4, v5

    move v5, v6

    move-wide v15, v7

    move-wide v6, v15

    goto :goto_2

    :cond_7
    const/4 v1, 0x0

    goto :goto_1

    :sswitch_3
    const/4 v3, 0x2

    if-ne v4, v3, :cond_8

    const/4 v3, 0x3

    move v4, v5

    move v5, v6

    move-wide v15, v7

    move-wide v6, v15

    goto :goto_2

    :cond_8
    const/4 v1, 0x0

    goto :goto_1

    :cond_9
    const/4 v9, 0x1

    if-eq v4, v9, :cond_a

    if-nez v4, :cond_b

    :cond_a
    add-int/lit8 v3, v3, -0x30

    neg-int v3, v3

    int-to-long v7, v3

    const/4 v3, 0x2

    move v4, v5

    move v5, v6

    move-wide v15, v7

    move-wide v6, v15

    goto :goto_2

    :cond_b
    const/4 v9, 0x2

    if-ne v4, v9, :cond_f

    const-wide/16 v9, 0x0

    cmp-long v9, v7, v9

    if-nez v9, :cond_c

    const/4 v1, 0x0

    goto/16 :goto_1

    :cond_c
    const-wide/16 v9, 0xa

    mul-long/2addr v9, v7

    add-int/lit8 v3, v3, -0x30

    int-to-long v13, v3

    sub-long/2addr v9, v13

    const-wide v13, -0xcccccccccccccccL

    cmp-long v3, v7, v13

    if-gtz v3, :cond_d

    const-wide v13, -0xcccccccccccccccL

    cmp-long v3, v7, v13

    if-nez v3, :cond_e

    cmp-long v3, v9, v7

    if-gez v3, :cond_e

    :cond_d
    const/4 v3, 0x1

    :goto_3
    and-int/2addr v3, v5

    move v5, v6

    move-wide v6, v9

    move v15, v4

    move v4, v3

    move v3, v15

    goto :goto_2

    :cond_e
    const/4 v3, 0x0

    goto :goto_3

    :cond_f
    const/4 v3, 0x3

    if-ne v4, v3, :cond_10

    const/4 v3, 0x4

    move v4, v5

    move v5, v6

    move-wide v15, v7

    move-wide v6, v15

    goto/16 :goto_2

    :cond_10
    const/4 v3, 0x5

    if-eq v4, v3, :cond_11

    const/4 v3, 0x6

    if-ne v4, v3, :cond_18

    :cond_11
    const/4 v3, 0x7

    move v4, v5

    move v5, v6

    move-wide v15, v7

    move-wide v6, v15

    goto/16 :goto_2

    :cond_12
    const/4 v1, 0x2

    if-ne v4, v1, :cond_15

    if-eqz v5, :cond_15

    const-wide/high16 v1, -0x8000000000000000L

    cmp-long v1, v7, v1

    if-nez v1, :cond_13

    if-eqz v6, :cond_15

    :cond_13
    if-eqz v6, :cond_14

    :goto_4
    move-object/from16 v0, p0

    iput-wide v7, v0, Lcom/google/gson/stream/JsonReader;->K:J

    move-object/from16 v0, p0

    iget v1, v0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v1, v11

    move-object/from16 v0, p0

    iput v1, v0, Lcom/google/gson/stream/JsonReader;->F:I

    const/16 v1, 0xf

    move-object/from16 v0, p0

    iput v1, v0, Lcom/google/gson/stream/JsonReader;->J:I

    goto/16 :goto_1

    :cond_14
    neg-long v7, v7

    goto :goto_4

    :cond_15
    const/4 v1, 0x2

    if-eq v4, v1, :cond_16

    const/4 v1, 0x4

    if-eq v4, v1, :cond_16

    const/4 v1, 0x7

    if-ne v4, v1, :cond_17

    :cond_16
    move-object/from16 v0, p0

    iput v11, v0, Lcom/google/gson/stream/JsonReader;->L:I

    const/16 v1, 0x10

    move-object/from16 v0, p0

    iput v1, v0, Lcom/google/gson/stream/JsonReader;->J:I

    goto/16 :goto_1

    :cond_17
    const/4 v1, 0x0

    goto/16 :goto_1

    :cond_18
    move v3, v4

    move v4, v5

    move v5, v6

    move-wide v15, v7

    move-wide v6, v15

    goto/16 :goto_2

    :sswitch_data_0
    .sparse-switch
        0x2b -> :sswitch_1
        0x2d -> :sswitch_0
        0x2e -> :sswitch_3
        0x45 -> :sswitch_2
        0x65 -> :sswitch_2
    .end sparse-switch
.end method

.method static synthetic c(Lcom/google/gson/stream/JsonReader;)I
    .locals 1

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v0, v0, 0x1

    return v0
.end method

.method private c(C)V
    .locals 5

    iget-object v3, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    :cond_0
    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->G:I

    :goto_0
    if-ge v1, v0, :cond_4

    add-int/lit8 v2, v1, 0x1

    aget-char v1, v3, v1

    if-ne v1, p1, :cond_1

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    return-void

    :cond_1
    const/16 v4, 0x5c

    if-ne v1, v4, :cond_2

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->j()C

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->G:I

    goto :goto_0

    :cond_2
    const/16 v4, 0xa

    if-ne v1, v4, :cond_3

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->H:I

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->I:I

    :cond_3
    move v1, v2

    goto :goto_0

    :cond_4
    iput v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "Unterminated string"

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v0

    throw v0
.end method

.method static synthetic d(Lcom/google/gson/stream/JsonReader;)I
    .locals 1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v0

    return v0
.end method

.method private d()Ljava/lang/String;
    .locals 5

    const/4 v2, 0x0

    const/4 v0, 0x0

    move v1, v2

    :goto_0
    iget v3, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v3, v1

    iget v4, p0, Lcom/google/gson/stream/JsonReader;->G:I

    if-ge v3, v4, :cond_1

    iget-object v3, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v4, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v4, v1

    aget-char v3, v3, v4

    sparse-switch v3, :sswitch_data_0

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :sswitch_0
    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    :cond_0
    :goto_1
    :sswitch_1
    if-nez v0, :cond_4

    new-instance v0, Ljava/lang/String;

    iget-object v2, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v3, p0, Lcom/google/gson/stream/JsonReader;->F:I

    invoke-direct {v0, v2, v3, v1}, Ljava/lang/String;-><init>([CII)V

    :goto_2
    iget v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v1, v2

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    return-object v0

    :cond_1
    iget-object v3, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    array-length v3, v3

    if-ge v1, v3, :cond_2

    add-int/lit8 v3, v1, 0x1

    invoke-direct {p0, v3}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v3

    if-eqz v3, :cond_0

    goto :goto_0

    :cond_2
    if-nez v0, :cond_3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    :cond_3
    iget-object v3, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v4, p0, Lcom/google/gson/stream/JsonReader;->F:I

    invoke-virtual {v0, v3, v4, v1}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;

    iget v3, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v1, v3

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    const/4 v1, 0x1

    invoke-direct {p0, v1}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v1

    if-nez v1, :cond_5

    move v1, v2

    goto :goto_1

    :cond_4
    iget-object v2, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v3, p0, Lcom/google/gson/stream/JsonReader;->F:I

    invoke-virtual {v0, v2, v3, v1}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_2

    :cond_5
    move v1, v2

    goto :goto_0

    nop

    :sswitch_data_0
    .sparse-switch
        0x9 -> :sswitch_1
        0xa -> :sswitch_1
        0xc -> :sswitch_1
        0xd -> :sswitch_1
        0x20 -> :sswitch_1
        0x23 -> :sswitch_0
        0x2c -> :sswitch_1
        0x2f -> :sswitch_0
        0x3a -> :sswitch_1
        0x3b -> :sswitch_0
        0x3d -> :sswitch_0
        0x5b -> :sswitch_1
        0x5c -> :sswitch_0
        0x5d -> :sswitch_1
        0x7b -> :sswitch_1
        0x7d -> :sswitch_1
    .end sparse-switch
.end method

.method private e()V
    .locals 3

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v1, v0

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->G:I

    if-ge v1, v2, :cond_1

    iget-object v1, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v2, v0

    aget-char v1, v1, v2

    sparse-switch v1, :sswitch_data_0

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :sswitch_0
    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    :sswitch_1
    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    :goto_1
    return-void

    :cond_1
    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v0

    if-nez v0, :cond_0

    goto :goto_1

    nop

    :sswitch_data_0
    .sparse-switch
        0x9 -> :sswitch_1
        0xa -> :sswitch_1
        0xc -> :sswitch_1
        0xd -> :sswitch_1
        0x20 -> :sswitch_1
        0x23 -> :sswitch_0
        0x2c -> :sswitch_1
        0x2f -> :sswitch_0
        0x3a -> :sswitch_1
        0x3b -> :sswitch_0
        0x3d -> :sswitch_0
        0x5b -> :sswitch_1
        0x5c -> :sswitch_0
        0x5d -> :sswitch_1
        0x7b -> :sswitch_1
        0x7d -> :sswitch_1
    .end sparse-switch
.end method

.method private f()I
    .locals 1

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v0, v0, 0x1

    return v0
.end method

.method private g()I
    .locals 2

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->I:I

    sub-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x1

    return v0
.end method

.method private h()V
    .locals 1

    iget-boolean v0, p0, Lcom/google/gson/stream/JsonReader;->D:Z

    if-nez v0, :cond_0

    const-string v0, "Use JsonReader.setLenient(true) to accept malformed JSON"

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_0
    return-void
.end method

.method private i()V
    .locals 3

    :goto_0
    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->G:I

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    aget-char v0, v0, v1

    const/16 v1, 0xa

    if-ne v0, v1, :cond_2

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->H:I

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->I:I

    :cond_1
    return-void

    :cond_2
    const/16 v1, 0xd

    if-eq v0, v1, :cond_1

    goto :goto_0
.end method

.method private j()C
    .locals 7

    const/4 v5, 0x4

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->G:I

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "Unterminated escape sequence"

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    aget-char v0, v0, v1

    sparse-switch v0, :sswitch_data_0

    :goto_0
    return v0

    :sswitch_0
    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v0, v0, 0x4

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->G:I

    if-le v0, v1, :cond_1

    invoke-direct {p0, v5}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "Unterminated escape sequence"

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v0

    throw v0

    :cond_1
    const/4 v1, 0x0

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v2, v0, 0x4

    move v6, v0

    move v0, v1

    move v1, v6

    :goto_1
    if-ge v1, v2, :cond_5

    iget-object v3, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    aget-char v3, v3, v1

    shl-int/lit8 v0, v0, 0x4

    int-to-char v0, v0

    const/16 v4, 0x30

    if-lt v3, v4, :cond_2

    const/16 v4, 0x39

    if-gt v3, v4, :cond_2

    add-int/lit8 v3, v3, -0x30

    add-int/2addr v0, v3

    int-to-char v0, v0

    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_2
    const/16 v4, 0x61

    if-lt v3, v4, :cond_3

    const/16 v4, 0x66

    if-gt v3, v4, :cond_3

    add-int/lit8 v3, v3, -0x61

    add-int/lit8 v3, v3, 0xa

    add-int/2addr v0, v3

    int-to-char v0, v0

    goto :goto_2

    :cond_3
    const/16 v4, 0x41

    if-lt v3, v4, :cond_4

    const/16 v4, 0x46

    if-gt v3, v4, :cond_4

    add-int/lit8 v3, v3, -0x41

    add-int/lit8 v3, v3, 0xa

    add-int/2addr v0, v3

    int-to-char v0, v0

    goto :goto_2

    :cond_4
    new-instance v0, Ljava/lang/NumberFormatException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\\u"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    new-instance v2, Ljava/lang/String;

    iget-object v3, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v4, p0, Lcom/google/gson/stream/JsonReader;->F:I

    invoke-direct {v2, v3, v4, v5}, Ljava/lang/String;-><init>([CII)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_5
    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v1, v1, 0x4

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    goto :goto_0

    :sswitch_1
    const/16 v0, 0x9

    goto :goto_0

    :sswitch_2
    const/16 v0, 0x8

    goto :goto_0

    :sswitch_3
    const/16 v0, 0xa

    goto/16 :goto_0

    :sswitch_4
    const/16 v0, 0xd

    goto/16 :goto_0

    :sswitch_5
    const/16 v0, 0xc

    goto/16 :goto_0

    :sswitch_6
    iget v1, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->H:I

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->I:I

    goto/16 :goto_0

    nop

    :sswitch_data_0
    .sparse-switch
        0xa -> :sswitch_6
        0x62 -> :sswitch_2
        0x66 -> :sswitch_5
        0x6e -> :sswitch_3
        0x72 -> :sswitch_4
        0x74 -> :sswitch_1
        0x75 -> :sswitch_0
    .end sparse-switch
.end method

.method private k()V
    .locals 3

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->a(Z)I

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    sget-object v1, Lcom/google/gson/stream/JsonReader;->a:[C

    array-length v1, v1

    add-int/2addr v0, v1

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->G:I

    if-le v0, v1, :cond_1

    sget-object v0, Lcom/google/gson/stream/JsonReader;->a:[C

    array-length v0, v0

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    const/4 v0, 0x0

    :goto_1
    sget-object v1, Lcom/google/gson/stream/JsonReader;->a:[C

    array-length v1, v1

    if-ge v0, v1, :cond_2

    iget-object v1, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v2, v0

    aget-char v1, v1, v2

    sget-object v2, Lcom/google/gson/stream/JsonReader;->a:[C

    aget-char v2, v2, v0

    if-ne v1, v2, :cond_0

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_2
    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    sget-object v1, Lcom/google/gson/stream/JsonReader;->a:[C

    array-length v1, v1

    add-int/2addr v0, v1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    goto :goto_0
.end method


# virtual methods
.method public beginArray()V
    .locals 3

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->a()I

    move-result v0

    :cond_0
    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->a(I)V

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    return-void

    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Expected BEGIN_ARRAY but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/gson/stream/JsonReader;->peek()Lcom/google/gson/stream/JsonToken;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public beginObject()V
    .locals 3

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->a()I

    move-result v0

    :cond_0
    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    const/4 v0, 0x3

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->a(I)V

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    return-void

    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Expected BEGIN_OBJECT but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/gson/stream/JsonReader;->peek()Lcom/google/gson/stream/JsonToken;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public close()V
    .locals 3

    const/4 v2, 0x0

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->J:I

    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->N:[I

    const/16 v1, 0x8

    aput v1, v0, v2

    const/4 v0, 0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->O:I

    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->C:Ljava/io/Reader;

    invoke-virtual {v0}, Ljava/io/Reader;->close()V

    return-void
.end method

.method public endArray()V
    .locals 3

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->a()I

    move-result v0

    :cond_0
    const/4 v1, 0x4

    if-ne v0, v1, :cond_1

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->O:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->O:I

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    return-void

    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Expected END_ARRAY but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/gson/stream/JsonReader;->peek()Lcom/google/gson/stream/JsonToken;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public endObject()V
    .locals 3

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->a()I

    move-result v0

    :cond_0
    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->O:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->O:I

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    return-void

    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Expected END_OBJECT but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/gson/stream/JsonReader;->peek()Lcom/google/gson/stream/JsonToken;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public hasNext()Z
    .locals 2

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->a()I

    move-result v0

    :cond_0
    const/4 v1, 0x2

    if-eq v0, v1, :cond_1

    const/4 v1, 0x4

    if-eq v0, v1, :cond_1

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final isLenient()Z
    .locals 1

    iget-boolean v0, p0, Lcom/google/gson/stream/JsonReader;->D:Z

    return v0
.end method

.method public nextBoolean()Z
    .locals 3

    const/4 v0, 0x0

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->J:I

    if-nez v1, :cond_0

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->a()I

    move-result v1

    :cond_0
    const/4 v2, 0x5

    if-ne v1, v2, :cond_1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v2, 0x6

    if-ne v1, v2, :cond_2

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    goto :goto_0

    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Expected a boolean but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/gson/stream/JsonReader;->peek()Lcom/google/gson/stream/JsonToken;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public nextDouble()D
    .locals 6

    const/16 v5, 0xb

    const/16 v2, 0x8

    const/4 v4, 0x0

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->a()I

    move-result v0

    :cond_0
    const/16 v1, 0xf

    if-ne v0, v1, :cond_1

    iput v4, p0, Lcom/google/gson/stream/JsonReader;->J:I

    iget-wide v0, p0, Lcom/google/gson/stream/JsonReader;->K:J

    long-to-double v0, v0

    :goto_0
    return-wide v0

    :cond_1
    const/16 v1, 0x10

    if-ne v0, v1, :cond_4

    new-instance v0, Ljava/lang/String;

    iget-object v1, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v3, p0, Lcom/google/gson/stream/JsonReader;->L:I

    invoke-direct {v0, v1, v2, v3}, Ljava/lang/String;-><init>([CII)V

    iput-object v0, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->L:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    :cond_2
    :goto_1
    iput v5, p0, Lcom/google/gson/stream/JsonReader;->J:I

    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    iget-boolean v2, p0, Lcom/google/gson/stream/JsonReader;->D:Z

    if-nez v2, :cond_9

    invoke-static {v0, v1}, Ljava/lang/Double;->isNaN(D)Z

    move-result v2

    if-nez v2, :cond_3

    invoke-static {v0, v1}, Ljava/lang/Double;->isInfinite(D)Z

    move-result v2

    if-eqz v2, :cond_9

    :cond_3
    new-instance v2, Lcom/google/gson/stream/MalformedJsonException;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "JSON forbids NaN and infinities: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0, v1}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " at line "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " column "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Lcom/google/gson/stream/MalformedJsonException;-><init>(Ljava/lang/String;)V

    throw v2

    :cond_4
    if-eq v0, v2, :cond_5

    const/16 v1, 0x9

    if-ne v0, v1, :cond_7

    :cond_5
    if-ne v0, v2, :cond_6

    const/16 v0, 0x27

    :goto_2
    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(C)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    goto :goto_1

    :cond_6
    const/16 v0, 0x22

    goto :goto_2

    :cond_7
    const/16 v1, 0xa

    if-ne v0, v1, :cond_8

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->d()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    goto :goto_1

    :cond_8
    if-eq v0, v5, :cond_2

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Expected a double but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/gson/stream/JsonReader;->peek()Lcom/google/gson/stream/JsonToken;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_9
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    iput v4, p0, Lcom/google/gson/stream/JsonReader;->J:I

    goto/16 :goto_0
.end method

.method public nextInt()I
    .locals 6

    const/16 v2, 0x8

    const/4 v5, 0x0

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->a()I

    move-result v0

    :cond_0
    const/16 v1, 0xf

    if-ne v0, v1, :cond_2

    iget-wide v0, p0, Lcom/google/gson/stream/JsonReader;->K:J

    long-to-int v0, v0

    iget-wide v1, p0, Lcom/google/gson/stream/JsonReader;->K:J

    int-to-long v3, v0

    cmp-long v1, v1, v3

    if-eqz v1, :cond_1

    new-instance v0, Ljava/lang/NumberFormatException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Expected an int but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-wide v2, p0, Lcom/google/gson/stream/JsonReader;->K:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iput v5, p0, Lcom/google/gson/stream/JsonReader;->J:I

    :goto_0
    return v0

    :cond_2
    const/16 v1, 0x10

    if-ne v0, v1, :cond_3

    new-instance v0, Ljava/lang/String;

    iget-object v1, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v3, p0, Lcom/google/gson/stream/JsonReader;->L:I

    invoke-direct {v0, v1, v2, v3}, Ljava/lang/String;-><init>([CII)V

    iput-object v0, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->L:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    :goto_1
    const/16 v0, 0xb

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v1

    double-to-int v0, v1

    int-to-double v3, v0

    cmpl-double v1, v3, v1

    if-eqz v1, :cond_7

    new-instance v0, Ljava/lang/NumberFormatException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Expected an int but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    if-eq v0, v2, :cond_4

    const/16 v1, 0x9

    if-ne v0, v1, :cond_6

    :cond_4
    if-ne v0, v2, :cond_5

    const/16 v0, 0x27

    :goto_2
    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(C)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    :try_start_0
    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    const/4 v1, 0x0

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->J:I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    goto :goto_1

    :cond_5
    const/16 v0, 0x22

    goto :goto_2

    :cond_6
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Expected an int but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/gson/stream/JsonReader;->peek()Lcom/google/gson/stream/JsonToken;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_7
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    iput v5, p0, Lcom/google/gson/stream/JsonReader;->J:I

    goto/16 :goto_0
.end method

.method public nextLong()J
    .locals 7

    const/16 v2, 0x8

    const/4 v6, 0x0

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->a()I

    move-result v0

    :cond_0
    const/16 v1, 0xf

    if-ne v0, v1, :cond_1

    iput v6, p0, Lcom/google/gson/stream/JsonReader;->J:I

    iget-wide v0, p0, Lcom/google/gson/stream/JsonReader;->K:J

    :goto_0
    return-wide v0

    :cond_1
    const/16 v1, 0x10

    if-ne v0, v1, :cond_2

    new-instance v0, Ljava/lang/String;

    iget-object v1, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v3, p0, Lcom/google/gson/stream/JsonReader;->L:I

    invoke-direct {v0, v1, v2, v3}, Ljava/lang/String;-><init>([CII)V

    iput-object v0, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->L:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->F:I

    :goto_1
    const/16 v0, 0xb

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v2

    double-to-long v0, v2

    long-to-double v4, v0

    cmpl-double v2, v4, v2

    if-eqz v2, :cond_6

    new-instance v0, Ljava/lang/NumberFormatException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Expected a long but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    if-eq v0, v2, :cond_3

    const/16 v1, 0x9

    if-ne v0, v1, :cond_5

    :cond_3
    if-ne v0, v2, :cond_4

    const/16 v0, 0x27

    :goto_2
    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(C)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    :try_start_0
    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    const/4 v2, 0x0

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->J:I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    goto :goto_1

    :cond_4
    const/16 v0, 0x22

    goto :goto_2

    :cond_5
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Expected a long but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/gson/stream/JsonReader;->peek()Lcom/google/gson/stream/JsonToken;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_6
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    iput v6, p0, Lcom/google/gson/stream/JsonReader;->J:I

    goto/16 :goto_0
.end method

.method public nextName()Ljava/lang/String;
    .locals 3

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->a()I

    move-result v0

    :cond_0
    const/16 v1, 0xe

    if-ne v0, v1, :cond_1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->d()Ljava/lang/String;

    move-result-object v0

    :goto_0
    const/4 v1, 0x0

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->J:I

    return-object v0

    :cond_1
    const/16 v1, 0xc

    if-ne v0, v1, :cond_2

    const/16 v0, 0x27

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(C)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_2
    const/16 v1, 0xd

    if-ne v0, v1, :cond_3

    const/16 v0, 0x22

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(C)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_3
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Expected a name but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/gson/stream/JsonReader;->peek()Lcom/google/gson/stream/JsonToken;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public nextNull()V
    .locals 3

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->a()I

    move-result v0

    :cond_0
    const/4 v1, 0x7

    if-ne v0, v1, :cond_1

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    return-void

    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Expected null but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/gson/stream/JsonReader;->peek()Lcom/google/gson/stream/JsonToken;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public nextString()Ljava/lang/String;
    .locals 4

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->a()I

    move-result v0

    :cond_0
    const/16 v1, 0xa

    if-ne v0, v1, :cond_1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->d()Ljava/lang/String;

    move-result-object v0

    :goto_0
    const/4 v1, 0x0

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->J:I

    return-object v0

    :cond_1
    const/16 v1, 0x8

    if-ne v0, v1, :cond_2

    const/16 v0, 0x27

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(C)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_2
    const/16 v1, 0x9

    if-ne v0, v1, :cond_3

    const/16 v0, 0x22

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonReader;->b(C)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_3
    const/16 v1, 0xb

    if-ne v0, v1, :cond_4

    iget-object v0, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    const/4 v1, 0x0

    iput-object v1, p0, Lcom/google/gson/stream/JsonReader;->M:Ljava/lang/String;

    goto :goto_0

    :cond_4
    const/16 v1, 0xf

    if-ne v0, v1, :cond_5

    iget-wide v0, p0, Lcom/google/gson/stream/JsonReader;->K:J

    invoke-static {v0, v1}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_5
    const/16 v1, 0x10

    if-ne v0, v1, :cond_6

    new-instance v0, Ljava/lang/String;

    iget-object v1, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v3, p0, Lcom/google/gson/stream/JsonReader;->L:I

    invoke-direct {v0, v1, v2, v3}, Ljava/lang/String;-><init>([CII)V

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->L:I

    add-int/2addr v1, v2

    iput v1, p0, Lcom/google/gson/stream/JsonReader;->F:I

    goto :goto_0

    :cond_6
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Expected a string but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/google/gson/stream/JsonReader;->peek()Lcom/google/gson/stream/JsonToken;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at line "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " column "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public peek()Lcom/google/gson/stream/JsonToken;
    .locals 1

    iget v0, p0, Lcom/google/gson/stream/JsonReader;->J:I

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->a()I

    move-result v0

    :cond_0
    packed-switch v0, :pswitch_data_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :pswitch_0
    sget-object v0, Lcom/google/gson/stream/JsonToken;->BEGIN_OBJECT:Lcom/google/gson/stream/JsonToken;

    :goto_0
    return-object v0

    :pswitch_1
    sget-object v0, Lcom/google/gson/stream/JsonToken;->END_OBJECT:Lcom/google/gson/stream/JsonToken;

    goto :goto_0

    :pswitch_2
    sget-object v0, Lcom/google/gson/stream/JsonToken;->BEGIN_ARRAY:Lcom/google/gson/stream/JsonToken;

    goto :goto_0

    :pswitch_3
    sget-object v0, Lcom/google/gson/stream/JsonToken;->END_ARRAY:Lcom/google/gson/stream/JsonToken;

    goto :goto_0

    :pswitch_4
    sget-object v0, Lcom/google/gson/stream/JsonToken;->NAME:Lcom/google/gson/stream/JsonToken;

    goto :goto_0

    :pswitch_5
    sget-object v0, Lcom/google/gson/stream/JsonToken;->BOOLEAN:Lcom/google/gson/stream/JsonToken;

    goto :goto_0

    :pswitch_6
    sget-object v0, Lcom/google/gson/stream/JsonToken;->NULL:Lcom/google/gson/stream/JsonToken;

    goto :goto_0

    :pswitch_7
    sget-object v0, Lcom/google/gson/stream/JsonToken;->STRING:Lcom/google/gson/stream/JsonToken;

    goto :goto_0

    :pswitch_8
    sget-object v0, Lcom/google/gson/stream/JsonToken;->NUMBER:Lcom/google/gson/stream/JsonToken;

    goto :goto_0

    :pswitch_9
    sget-object v0, Lcom/google/gson/stream/JsonToken;->END_DOCUMENT:Lcom/google/gson/stream/JsonToken;

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_5
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_7
        :pswitch_7
        :pswitch_7
        :pswitch_4
        :pswitch_4
        :pswitch_4
        :pswitch_8
        :pswitch_8
        :pswitch_9
    .end packed-switch
.end method

.method public final setLenient(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/google/gson/stream/JsonReader;->D:Z

    return-void
.end method

.method public skipValue()V
    .locals 7

    const/4 v6, 0x3

    const/4 v5, 0x1

    const/4 v1, 0x0

    move v0, v1

    :cond_0
    iget v2, p0, Lcom/google/gson/stream/JsonReader;->J:I

    if-nez v2, :cond_1

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->a()I

    move-result v2

    :cond_1
    if-ne v2, v6, :cond_3

    invoke-direct {p0, v5}, Lcom/google/gson/stream/JsonReader;->a(I)V

    add-int/lit8 v0, v0, 0x1

    :cond_2
    :goto_0
    iput v1, p0, Lcom/google/gson/stream/JsonReader;->J:I

    if-nez v0, :cond_0

    return-void

    :cond_3
    if-ne v2, v5, :cond_4

    invoke-direct {p0, v6}, Lcom/google/gson/stream/JsonReader;->a(I)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_4
    const/4 v3, 0x4

    if-ne v2, v3, :cond_5

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->O:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->O:I

    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_5
    const/4 v3, 0x2

    if-ne v2, v3, :cond_6

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->O:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->O:I

    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_6
    const/16 v3, 0xe

    if-eq v2, v3, :cond_7

    const/16 v3, 0xa

    if-ne v2, v3, :cond_9

    :cond_7
    move v2, v1

    :goto_1
    iget v3, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v3, v2

    iget v4, p0, Lcom/google/gson/stream/JsonReader;->G:I

    if-ge v3, v4, :cond_8

    iget-object v3, p0, Lcom/google/gson/stream/JsonReader;->E:[C

    iget v4, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v4, v2

    aget-char v3, v3, v4

    sparse-switch v3, :sswitch_data_0

    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    :sswitch_0
    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->h()V

    :sswitch_1
    iget v3, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v2, v3

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    goto :goto_0

    :cond_8
    iget v3, p0, Lcom/google/gson/stream/JsonReader;->F:I

    add-int/2addr v2, v3

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    invoke-direct {p0, v5}, Lcom/google/gson/stream/JsonReader;->b(I)Z

    move-result v2

    if-nez v2, :cond_7

    goto :goto_0

    :cond_9
    const/16 v3, 0x8

    if-eq v2, v3, :cond_a

    const/16 v3, 0xc

    if-ne v2, v3, :cond_b

    :cond_a
    const/16 v2, 0x27

    invoke-direct {p0, v2}, Lcom/google/gson/stream/JsonReader;->c(C)V

    goto :goto_0

    :cond_b
    const/16 v3, 0x9

    if-eq v2, v3, :cond_c

    const/16 v3, 0xd

    if-ne v2, v3, :cond_d

    :cond_c
    const/16 v2, 0x22

    invoke-direct {p0, v2}, Lcom/google/gson/stream/JsonReader;->c(C)V

    goto :goto_0

    :cond_d
    const/16 v3, 0x10

    if-ne v2, v3, :cond_2

    iget v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    iget v3, p0, Lcom/google/gson/stream/JsonReader;->L:I

    add-int/2addr v2, v3

    iput v2, p0, Lcom/google/gson/stream/JsonReader;->F:I

    goto :goto_0

    :sswitch_data_0
    .sparse-switch
        0x9 -> :sswitch_1
        0xa -> :sswitch_1
        0xc -> :sswitch_1
        0xd -> :sswitch_1
        0x20 -> :sswitch_1
        0x23 -> :sswitch_0
        0x2c -> :sswitch_1
        0x2f -> :sswitch_0
        0x3a -> :sswitch_1
        0x3b -> :sswitch_0
        0x3d -> :sswitch_0
        0x5b -> :sswitch_1
        0x5c -> :sswitch_0
        0x5d -> :sswitch_1
        0x7b -> :sswitch_1
        0x7d -> :sswitch_1
    .end sparse-switch
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " at line "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/google/gson/stream/JsonReader;->H:I

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " column "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0}, Lcom/google/gson/stream/JsonReader;->g()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
