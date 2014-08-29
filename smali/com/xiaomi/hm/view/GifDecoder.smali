.class public Lcom/xiaomi/hm/view/GifDecoder;
.super Ljava/lang/Thread;


# static fields
.field private static final H:I = 0x1000

.field private static final N:I = 0xf

.field public static final STATUS_FINISH:I = -0x1

.field public static final STATUS_FORMAT_ERROR:I = 0x1

.field public static final STATUS_OPEN_ERROR:I = 0x2

.field public static final STATUS_PARSING:I


# instance fields
.field private A:[B

.field private B:I

.field private C:I

.field private D:I

.field private E:Z

.field private F:I

.field private G:I

.field private I:[S

.field private J:[B

.field private K:[B

.field private L:[B

.field private M:I

.field private O:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Lcom/xiaomi/hm/view/GifFrame;",
            ">;"
        }
    .end annotation
.end field

.field private final P:Ljava/util/concurrent/locks/ReentrantLock;

.field private final Q:Ljava/util/concurrent/locks/Condition;

.field private final R:Ljava/util/concurrent/locks/Condition;

.field private S:I

.field private T:Z

.field private U:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/xiaomi/hm/view/GifFrame;",
            ">;"
        }
    .end annotation
.end field

.field private V:I

.field private W:Z

.field private X:Lcom/xiaomi/hm/view/GifAction;

.field private Y:[B

.field private Z:Z

.field private a:Ljava/io/InputStream;

.field private aa:I

.field private ab:Landroid/content/res/Resources;

.field private ac:I

.field private ad:Ljava/lang/String;

.field private ae:[I

.field private af:[I

.field private b:Ljava/io/InputStream;

.field private c:I

.field private d:Z

.field private e:I

.field private f:I

.field private g:[I

.field private h:[I

.field public height:I

.field private i:[I

.field public isDestroy:Z

.field private j:I

.field private k:I

.field private l:I

.field private m:I

.field private n:Z

.field private o:Z

.field private p:I

.field private q:I

.field private r:I

.field private s:I

.field private t:I

.field private u:I

.field private v:I

.field private w:I

.field public width:I

.field private x:I

.field private y:Landroid/graphics/Bitmap;

.field private z:Landroid/graphics/Bitmap;


# direct methods
.method public constructor <init>(Lcom/xiaomi/hm/view/GifAction;)V
    .locals 5

    const/16 v4, 0x100

    const/4 v3, 0x0

    const/4 v2, 0x0

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    iput-boolean v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->isDestroy:Z

    const/4 v0, 0x1

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->f:I

    new-array v0, v4, [B

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->A:[B

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->B:I

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->C:I

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->D:I

    iput-boolean v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->E:Z

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->F:I

    new-instance v0, Ljava/util/concurrent/ArrayBlockingQueue;

    const/16 v1, 0xf

    invoke-direct {v0, v1}, Ljava/util/concurrent/ArrayBlockingQueue;-><init>(I)V

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->Q:Ljava/util/concurrent/locks/Condition;

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->R:Ljava/util/concurrent/locks/Condition;

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->S:I

    iput-boolean v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->T:Z

    new-instance v0, Ljava/util/ArrayList;

    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->U:Ljava/util/ArrayList;

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->V:I

    iput-boolean v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->W:Z

    iput-object v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    iput-object v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->Y:[B

    iput-boolean v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->Z:Z

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->aa:I

    iput-object v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->ab:Landroid/content/res/Resources;

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->ac:I

    iput-object v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->ad:Ljava/lang/String;

    iput-object v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->ae:[I

    new-array v0, v4, [I

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->af:[I

    iput-object p1, p0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    return-void
.end method

.method public constructor <init>(Lcom/xiaomi/hm/view/GifAction;Z)V
    .locals 5

    const/16 v4, 0x100

    const/4 v3, 0x0

    const/4 v2, 0x0

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    iput-boolean v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->isDestroy:Z

    const/4 v0, 0x1

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->f:I

    new-array v0, v4, [B

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->A:[B

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->B:I

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->C:I

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->D:I

    iput-boolean v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->E:Z

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->F:I

    new-instance v0, Ljava/util/concurrent/ArrayBlockingQueue;

    const/16 v1, 0xf

    invoke-direct {v0, v1}, Ljava/util/concurrent/ArrayBlockingQueue;-><init>(I)V

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->Q:Ljava/util/concurrent/locks/Condition;

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->R:Ljava/util/concurrent/locks/Condition;

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->S:I

    iput-boolean v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->T:Z

    new-instance v0, Ljava/util/ArrayList;

    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->U:Ljava/util/ArrayList;

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->V:I

    iput-boolean v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->W:Z

    iput-object v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    iput-object v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->Y:[B

    iput-boolean v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->Z:Z

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->aa:I

    iput-object v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->ab:Landroid/content/res/Resources;

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->ac:I

    iput-object v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->ad:Ljava/lang/String;

    iput-object v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->ae:[I

    new-array v0, v4, [I

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->af:[I

    iput-object p1, p0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    iput-boolean p2, p0, Lcom/xiaomi/hm/view/GifDecoder;->Z:Z

    return-void
.end method

.method private a()V
    .locals 2

    new-instance v0, Ljava/io/ByteArrayInputStream;

    iget-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->Y:[B

    invoke-direct {v0, v1}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;

    return-void
.end method

.method private a(I)[I
    .locals 9

    const/4 v1, 0x0

    mul-int/lit8 v2, p1, 0x3

    new-array v3, v2, [B

    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;

    invoke-virtual {v0, v3}, Ljava/io/InputStream;->read([B)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :goto_0
    if-ge v0, v2, :cond_1

    const/4 v0, 0x1

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->af:[I

    return-object v0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    move v0, v1

    goto :goto_0

    :cond_1
    move v0, v1

    :goto_1
    if-ge v0, p1, :cond_0

    add-int/lit8 v2, v1, 0x1

    aget-byte v1, v3, v1

    and-int/lit16 v4, v1, 0xff

    add-int/lit8 v1, v2, 0x1

    aget-byte v2, v3, v2

    and-int/lit16 v5, v2, 0xff

    add-int/lit8 v2, v1, 0x1

    aget-byte v1, v3, v1

    and-int/lit16 v6, v1, 0xff

    iget-object v7, p0, Lcom/xiaomi/hm/view/GifDecoder;->af:[I

    add-int/lit8 v1, v0, 0x1

    const/high16 v8, -0x1000000

    shl-int/lit8 v4, v4, 0x10

    or-int/2addr v4, v8

    shl-int/lit8 v5, v5, 0x8

    or-int/2addr v4, v5

    or-int/2addr v4, v6

    aput v4, v7, v0

    move v0, v1

    move v1, v2

    goto :goto_1
.end method

.method private b()V
    .locals 2

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->ab:Landroid/content/res/Resources;

    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->ac:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;

    return-void
.end method

.method private c()V
    .locals 2

    :try_start_0
    new-instance v0, Ljava/io/FileInputStream;

    iget-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->ad:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "open failed"

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private d()V
    .locals 2

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    iput-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;

    :cond_0
    iput-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->Y:[B

    const/4 v0, 0x0

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->U:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->U:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    iput-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->U:Ljava/util/ArrayList;

    :cond_1
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->clear()V

    iput-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    :cond_2
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private e()V
    .locals 12

    const/4 v9, 0x4

    const/4 v11, 0x1

    const/4 v10, 0x2

    const/4 v8, 0x0

    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->ae:[I

    if-nez v0, :cond_0

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->height:I

    mul-int/2addr v0, v1

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->ae:[I

    :cond_0
    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->D:I

    if-lez v0, :cond_3

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->D:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_2

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    add-int/lit8 v0, v0, -0x2

    if-gtz v0, :cond_1

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->z:Landroid/graphics/Bitmap;

    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->z:Landroid/graphics/Bitmap;

    :cond_2
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->z:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->z:Landroid/graphics/Bitmap;

    iget-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->ae:[I

    const/4 v2, 0x0

    iget v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    const/4 v4, 0x0

    const/4 v5, 0x0

    iget v6, p0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    iget v7, p0, Lcom/xiaomi/hm/view/GifDecoder;->height:I

    invoke-virtual/range {v0 .. v7}, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->D:I

    if-ne v0, v10, :cond_3

    iget-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->E:Z

    if-nez v0, :cond_d

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->l:I

    :goto_0
    move v2, v8

    :goto_1
    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->x:I

    if-lt v2, v1, :cond_4

    :cond_3
    const/16 v1, 0x8

    move v4, v8

    move v0, v8

    move v2, v11

    :goto_2
    iget v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->t:I

    if-lt v4, v3, :cond_6

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->ae:[I

    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    iget v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->height:I

    sget-object v3, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    invoke-static {v0, v1, v2, v3}, Landroid/graphics/Bitmap;->createBitmap([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->y:Landroid/graphics/Bitmap;

    :goto_3
    return-void

    :cond_4
    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->v:I

    add-int/2addr v1, v2

    iget v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    mul-int/2addr v1, v3

    iget v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->u:I

    add-int/2addr v1, v3

    iget v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->w:I

    add-int/2addr v3, v1

    :goto_4
    if-lt v1, v3, :cond_5

    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_1

    :cond_5
    iget-object v4, p0, Lcom/xiaomi/hm/view/GifDecoder;->ae:[I

    aput v0, v4, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    :cond_6
    iget-boolean v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->o:Z

    if-eqz v3, :cond_c

    iget v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->t:I

    if-lt v0, v3, :cond_7

    add-int/lit8 v2, v2, 0x1

    packed-switch v2, :pswitch_data_0

    :cond_7
    :goto_5
    add-int v3, v0, v1

    move v5, v3

    move v6, v1

    move v7, v2

    :goto_6
    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->r:I

    add-int/2addr v0, v1

    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->height:I

    if-ge v0, v1, :cond_8

    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    mul-int v2, v0, v1

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->q:I

    add-int/2addr v0, v2

    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->s:I

    add-int/2addr v1, v0

    iget v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    add-int/2addr v3, v2

    if-ge v3, v1, :cond_b

    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    add-int/2addr v1, v2

    move v3, v1

    :goto_7
    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->s:I

    mul-int/2addr v1, v4

    :goto_8
    if-lt v0, v3, :cond_9

    :cond_8
    add-int/lit8 v4, v4, 0x1

    move v0, v5

    move v1, v6

    move v2, v7

    goto :goto_2

    :pswitch_0
    move v0, v9

    goto :goto_5

    :pswitch_1
    move v0, v10

    move v1, v9

    goto :goto_5

    :pswitch_2
    move v0, v11

    move v1, v10

    goto :goto_5

    :cond_9
    iget-object v8, p0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    add-int/lit8 v2, v1, 0x1

    aget-byte v1, v8, v1

    and-int/lit16 v1, v1, 0xff

    iget-object v8, p0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    aget v1, v8, v1

    if-eqz v1, :cond_a

    iget-object v8, p0, Lcom/xiaomi/hm/view/GifDecoder;->ae:[I

    aput v1, v8, v0
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/StackOverflowError; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    :cond_a
    add-int/lit8 v0, v0, 0x1

    move v1, v2

    goto :goto_8

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/OutOfMemoryError;->printStackTrace()V

    goto :goto_3

    :catch_1
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/StackOverflowError;->printStackTrace()V

    goto :goto_3

    :catch_2
    move-exception v0

    const-string v1, "GifView decode setpixel"

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_3

    :cond_b
    move v3, v1

    goto :goto_7

    :cond_c
    move v5, v0

    move v6, v1

    move v7, v2

    move v0, v4

    goto :goto_6

    :cond_d
    move v0, v8

    goto/16 :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private f()I
    .locals 8

    const/4 v7, 0x4

    const/4 v6, 0x0

    const/4 v5, 0x2

    const/4 v1, 0x1

    const/4 v0, 0x0

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    iget-boolean v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->T:Z

    if-nez v2, :cond_0

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    :cond_0
    iput-object v6, p0, Lcom/xiaomi/hm/view/GifDecoder;->g:[I

    iput-object v6, p0, Lcom/xiaomi/hm/view/GifDecoder;->h:[I

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->S:I

    iget-object v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;

    if-eqz v2, :cond_b

    const-string v2, ""

    move-object v3, v2

    move v2, v0

    :goto_0
    const/4 v4, 0x6

    if-lt v2, v4, :cond_7

    const-string v2, "GIF"

    invoke-virtual {v3, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_8

    iput v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    :cond_1
    :goto_1
    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->i()Z

    move-result v0

    if-nez v0, :cond_2

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->m()V

    iget-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->T:Z

    if-nez v0, :cond_2

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    if-gez v0, :cond_2

    iput v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    invoke-interface {v0, v7}, Lcom/xiaomi/hm/view/GifAction;->parseReturn(I)V

    :cond_2
    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_3
    :goto_2
    iput-object v6, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;

    iget-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->Z:Z

    if-eqz v0, :cond_6

    iget-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->W:Z

    if-nez v0, :cond_6

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    const/16 v2, 0xf

    if-gt v0, v2, :cond_a

    :try_start_1
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lockInterruptibly()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->W:Z

    const/4 v0, -0x1

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    const/4 v2, 0x2

    invoke-interface {v0, v2}, Lcom/xiaomi/hm/view/GifAction;->parseReturn(I)V

    :cond_4
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->Q:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signal()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    :cond_5
    :goto_3
    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->aa:I

    packed-switch v0, :pswitch_data_0

    :goto_4
    iput-boolean v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->T:Z

    iget-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->isDestroy:Z

    if-nez v0, :cond_6

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->f()I

    :cond_6
    :goto_5
    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    return v0

    :cond_7
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v3

    int-to-char v3, v3

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_0

    :cond_8
    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v2

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v2

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->height:I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v2

    and-int/lit16 v3, v2, 0x80

    if-eqz v3, :cond_9

    move v0, v1

    :cond_9
    iput-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->d:Z

    and-int/lit8 v0, v2, 0x7

    shl-int v0, v5, v0

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->e:I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v0

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->j:I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    iget-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->d:Z

    if-eqz v0, :cond_1

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->i()Z

    move-result v0

    if-nez v0, :cond_1

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->e:I

    invoke-direct {p0, v0}, Lcom/xiaomi/hm/view/GifDecoder;->a(I)[I

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->g:[I

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->g:[I

    iget v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->j:I

    aget v0, v0, v2

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->k:I

    goto/16 :goto_1

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_2

    :catch_1
    move-exception v0

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto :goto_3

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0

    :cond_a
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->U:Ljava/util/ArrayList;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->U:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    goto/16 :goto_3

    :pswitch_0
    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->b()V

    goto/16 :goto_4

    :pswitch_1
    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->c()V

    goto/16 :goto_4

    :pswitch_2
    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->a()V

    goto/16 :goto_4

    :cond_b
    iput v5, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    invoke-interface {v0, v7}, Lcom/xiaomi/hm/view/GifAction;->parseReturn(I)V

    goto/16 :goto_5

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private g()V
    .locals 3

    const/4 v2, 0x1

    iget-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->Z:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->W:Z

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    const/16 v1, 0xf

    if-gt v0, v1, :cond_4

    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lockInterruptibly()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->W:Z

    const/4 v0, -0x1

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    const/4 v1, 0x2

    invoke-interface {v0, v1}, Lcom/xiaomi/hm/view/GifAction;->parseReturn(I)V

    :cond_2
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->Q:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signal()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    :cond_3
    :goto_1
    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->aa:I

    packed-switch v0, :pswitch_data_0

    :goto_2
    iput-boolean v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->T:Z

    iget-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->isDestroy:Z

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->f()I

    goto :goto_0

    :catch_0
    move-exception v0

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto :goto_1

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0

    :cond_4
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->U:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->U:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    goto :goto_1

    :pswitch_0
    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->b()V

    goto :goto_2

    :pswitch_1
    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->c()V

    goto :goto_2

    :pswitch_2
    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->a()V

    goto :goto_2

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private h()V
    .locals 22

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->s:I

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->t:I

    mul-int v15, v1, v2

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    if-eqz v1, :cond_0

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    array-length v1, v1

    if-ge v1, v15, :cond_1

    :cond_0
    new-array v1, v15, [B

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    :cond_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->I:[S

    if-nez v1, :cond_2

    const/16 v1, 0x1000

    new-array v1, v1, [S

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->I:[S

    :cond_2
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    if-nez v1, :cond_3

    const/16 v1, 0x1000

    new-array v1, v1, [B

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    :cond_3
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    if-nez v1, :cond_4

    const/16 v1, 0x1001

    new-array v1, v1, [B

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    :cond_4
    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v16

    const/4 v1, 0x1

    shl-int v17, v1, v16

    add-int/lit8 v18, v17, 0x1

    add-int/lit8 v11, v17, 0x2

    const/4 v10, -0x1

    add-int/lit8 v3, v16, 0x1

    const/4 v1, 0x1

    shl-int/2addr v1, v3

    add-int/lit8 v4, v1, -0x1

    const/4 v1, 0x0

    :goto_0
    move/from16 v0, v17

    if-lt v1, v0, :cond_6

    const/4 v12, 0x0

    const/4 v1, 0x0

    move v5, v12

    move v6, v12

    move v7, v12

    move v14, v1

    move v2, v12

    move v8, v12

    move v1, v12

    :goto_1
    if-lt v14, v15, :cond_7

    :cond_5
    move v1, v12

    :goto_2
    if-lt v1, v15, :cond_e

    return-void

    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->I:[S

    const/4 v5, 0x0

    aput-short v5, v2, v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    int-to-byte v5, v1

    aput-byte v5, v2, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_7
    if-nez v5, :cond_10

    if-ge v8, v3, :cond_9

    if-nez v2, :cond_8

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->l()I

    move-result v2

    if-lez v2, :cond_5

    const/4 v1, 0x0

    :cond_8
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/xiaomi/hm/view/GifDecoder;->A:[B

    aget-byte v9, v9, v1

    and-int/lit16 v9, v9, 0xff

    shl-int/2addr v9, v8

    add-int/2addr v7, v9

    add-int/lit8 v8, v8, 0x8

    add-int/lit8 v1, v1, 0x1

    add-int/lit8 v2, v2, -0x1

    goto :goto_1

    :cond_9
    and-int v9, v7, v4

    shr-int/2addr v7, v3

    sub-int/2addr v8, v3

    if-gt v9, v11, :cond_5

    move/from16 v0, v18

    if-eq v9, v0, :cond_5

    move/from16 v0, v17

    if-ne v9, v0, :cond_a

    add-int/lit8 v3, v16, 0x1

    const/4 v4, 0x1

    shl-int/2addr v4, v3

    add-int/lit8 v4, v4, -0x1

    add-int/lit8 v11, v17, 0x2

    const/4 v10, -0x1

    goto :goto_1

    :cond_a
    const/4 v13, -0x1

    if-ne v10, v13, :cond_b

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    add-int/lit8 v6, v5, 0x1

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    aget-byte v13, v13, v9

    aput-byte v13, v10, v5

    move v5, v6

    move v10, v9

    move v6, v9

    goto :goto_1

    :cond_b
    if-ne v9, v11, :cond_f

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    move-object/from16 v19, v0

    add-int/lit8 v13, v5, 0x1

    int-to-byte v6, v6

    aput-byte v6, v19, v5

    move v6, v10

    :goto_3
    move/from16 v0, v17

    if-gt v6, v0, :cond_d

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    aget-byte v5, v5, v6

    and-int/lit16 v6, v5, 0xff

    const/16 v5, 0x1000

    if-ge v11, v5, :cond_5

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    move-object/from16 v19, v0

    add-int/lit8 v5, v13, 0x1

    int-to-byte v0, v6

    move/from16 v20, v0

    aput-byte v20, v19, v13

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/xiaomi/hm/view/GifDecoder;->I:[S

    int-to-short v10, v10

    aput-short v10, v13, v11

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    int-to-byte v13, v6

    aput-byte v13, v10, v11

    add-int/lit8 v10, v11, 0x1

    and-int v11, v10, v4

    if-nez v11, :cond_c

    const/16 v11, 0x1000

    if-ge v10, v11, :cond_c

    add-int/lit8 v3, v3, 0x1

    add-int/2addr v4, v10

    :cond_c
    move/from16 v21, v5

    move v5, v7

    move v7, v9

    move v9, v4

    move v4, v6

    move v6, v8

    move v8, v3

    move/from16 v3, v21

    :goto_4
    add-int/lit8 v11, v3, -0x1

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    add-int/lit8 v3, v12, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    move-object/from16 v19, v0

    aget-byte v19, v19, v11

    aput-byte v19, v13, v12

    add-int/lit8 v12, v14, 0x1

    move v14, v12

    move v12, v3

    move v3, v8

    move v8, v6

    move v6, v4

    move v4, v9

    move/from16 v21, v7

    move v7, v5

    move v5, v11

    move v11, v10

    move/from16 v10, v21

    goto/16 :goto_1

    :cond_d
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    move-object/from16 v19, v0

    add-int/lit8 v5, v13, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    move-object/from16 v20, v0

    aget-byte v20, v20, v6

    aput-byte v20, v19, v13

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/xiaomi/hm/view/GifDecoder;->I:[S

    aget-short v6, v13, v6

    move v13, v5

    goto :goto_3

    :cond_e
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    const/4 v3, 0x0

    aput-byte v3, v2, v1

    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_2

    :cond_f
    move v13, v5

    move v6, v9

    goto/16 :goto_3

    :cond_10
    move v9, v4

    move v4, v6

    move v6, v8

    move v8, v3

    move v3, v5

    move v5, v7

    move v7, v10

    move v10, v11

    goto :goto_4
.end method

.method private i()Z
    .locals 1

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private j()V
    .locals 3

    const/4 v2, 0x0

    const/4 v1, 0x0

    iput v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    iget-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->T:Z

    if-nez v0, :cond_0

    iput v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    :cond_0
    iput-object v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->g:[I

    iput-object v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->h:[I

    iput v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->S:I

    return-void
.end method

.method private k()I
    .locals 2

    const/4 v0, 0x0

    :try_start_0
    iget-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;

    invoke-virtual {v1}, Ljava/io/InputStream;->read()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :goto_0
    return v0

    :catch_0
    move-exception v1

    const/4 v1, 0x1

    iput v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    goto :goto_0
.end method

.method private l()I
    .locals 4

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v0

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->B:I

    const/4 v0, 0x0

    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->B:I

    if-lez v1, :cond_1

    :goto_0
    :try_start_0
    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->B:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    if-lt v0, v1, :cond_2

    :cond_0
    :goto_1
    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->B:I

    if-ge v0, v1, :cond_1

    const/4 v1, 0x1

    iput v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    :cond_1
    return v0

    :cond_2
    :try_start_1
    iget-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;

    iget-object v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->A:[B

    iget v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->B:I

    sub-int/2addr v3, v0

    invoke-virtual {v1, v2, v0, v3}, Ljava/io/InputStream;->read([BII)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result v1

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    add-int/2addr v0, v1

    goto :goto_0

    :catch_0
    move-exception v1

    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method

.method private m()V
    .locals 24

    const/4 v1, 0x0

    move/from16 v16, v1

    :cond_0
    :goto_0
    :sswitch_0
    if-nez v16, :cond_1

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->i()Z

    move-result v1

    if-nez v1, :cond_1

    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->isDestroy:Z

    if-eqz v1, :cond_2

    :cond_1
    return-void

    :cond_2
    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    const/4 v1, 0x1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    goto :goto_0

    :sswitch_1
    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->q:I

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->r:I

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->s:I

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->t:I

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v2

    and-int/lit16 v1, v2, 0x80

    if-eqz v1, :cond_11

    const/4 v1, 0x1

    :goto_1
    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->n:Z

    and-int/lit8 v1, v2, 0x40

    if-eqz v1, :cond_12

    const/4 v1, 0x1

    :goto_2
    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->o:Z

    const/4 v1, 0x2

    and-int/lit8 v2, v2, 0x7

    shl-int/2addr v1, v2

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->p:I

    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->n:Z

    if-eqz v1, :cond_13

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->p:I

    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Lcom/xiaomi/hm/view/GifDecoder;->a(I)[I

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->h:[I

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->h:[I

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    :cond_3
    :goto_3
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->E:Z

    if-eqz v2, :cond_4

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    if-eqz v2, :cond_4

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    array-length v2, v2

    if-lez v2, :cond_4

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    array-length v2, v2

    move-object/from16 v0, p0

    iget v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->G:I

    if-le v2, v3, :cond_4

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->G:I

    aget v1, v1, v2

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    move-object/from16 v0, p0

    iget v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->G:I

    const/4 v4, 0x0

    aput v4, v2, v3

    :cond_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    if-nez v2, :cond_5

    const/4 v2, 0x1

    move-object/from16 v0, p0

    iput v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    :cond_5
    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->i()Z

    move-result v2

    if-nez v2, :cond_0

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->s:I

    move-object/from16 v0, p0

    iget v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->t:I

    mul-int v17, v2, v3

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    if-eqz v2, :cond_6

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    array-length v2, v2

    move/from16 v0, v17

    if-ge v2, v0, :cond_7

    :cond_6
    move/from16 v0, v17

    new-array v2, v0, [B

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    :cond_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->I:[S

    if-nez v2, :cond_8

    const/16 v2, 0x1000

    new-array v2, v2, [S

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->I:[S

    :cond_8
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    if-nez v2, :cond_9

    const/16 v2, 0x1000

    new-array v2, v2, [B

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    :cond_9
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    if-nez v2, :cond_a

    const/16 v2, 0x1001

    new-array v2, v2, [B

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    :cond_a
    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v18

    const/4 v2, 0x1

    shl-int v19, v2, v18

    add-int/lit8 v20, v19, 0x1

    add-int/lit8 v12, v19, 0x2

    const/4 v11, -0x1

    add-int/lit8 v4, v18, 0x1

    const/4 v2, 0x1

    shl-int/2addr v2, v4

    add-int/lit8 v5, v2, -0x1

    const/4 v2, 0x0

    :goto_4
    move/from16 v0, v19

    if-lt v2, v0, :cond_14

    const/4 v13, 0x0

    const/4 v2, 0x0

    move v6, v13

    move v7, v13

    move v8, v13

    move v15, v2

    move v3, v13

    move v9, v13

    move v2, v13

    :goto_5
    move/from16 v0, v17

    if-lt v15, v0, :cond_15

    :cond_b
    move v2, v13

    :goto_6
    move/from16 v0, v17

    if-lt v2, v0, :cond_1c

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->u()V

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->i()Z

    move-result v2

    if-nez v2, :cond_0

    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->T:Z

    if-nez v2, :cond_c

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    add-int/lit8 v2, v2, 0x1

    move-object/from16 v0, p0

    iput v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    :cond_c
    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->e()V

    :try_start_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantLock;->lockInterruptibly()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    :goto_7
    :try_start_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    if-eqz v2, :cond_d

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    invoke-interface {v2}, Ljava/util/Queue;->size()I

    move-result v2

    const/16 v3, 0xf

    if-ge v2, v3, :cond_1d

    :cond_d
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    if-eqz v2, :cond_f

    new-instance v2, Lcom/xiaomi/hm/view/GifFrame;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->y:Landroid/graphics/Bitmap;

    move-object/from16 v0, p0

    iget v4, v0, Lcom/xiaomi/hm/view/GifDecoder;->F:I

    invoke-direct {v2, v3, v4}, Lcom/xiaomi/hm/view/GifFrame;-><init>(Landroid/graphics/Bitmap;I)V

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    invoke-interface {v3, v2}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    move-object/from16 v0, p0

    iget-boolean v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->T:Z

    if-nez v3, :cond_e

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->U:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_e
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->Q:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Condition;->signal()V

    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->T:Z

    if-nez v2, :cond_f

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->S:I

    if-ltz v2, :cond_f

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->S:I

    add-int/lit8 v2, v2, 0x1

    move-object/from16 v0, p0

    iput v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->S:I

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->S:I

    const/16 v3, 0xf

    if-lt v2, v3, :cond_1e

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    const/4 v3, 0x3

    invoke-interface {v2, v3}, Lcom/xiaomi/hm/view/GifAction;->parseReturn(I)V

    const/4 v2, -0x1

    move-object/from16 v0, p0

    iput v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->S:I
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :cond_f
    :goto_8
    :try_start_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    :goto_9
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->E:Z

    if-eqz v2, :cond_10

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    move-object/from16 v0, p0

    iget v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->G:I

    aput v1, v2, v3

    :cond_10
    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->C:I

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->D:I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->q:I

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->u:I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->r:I

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->v:I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->s:I

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->w:I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->t:I

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->x:I

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->y:Landroid/graphics/Bitmap;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->z:Landroid/graphics/Bitmap;

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->k:I

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->l:I

    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->C:I

    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->E:Z

    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->F:I

    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->h:[I

    goto/16 :goto_0

    :cond_11
    const/4 v1, 0x0

    goto/16 :goto_1

    :cond_12
    const/4 v1, 0x0

    goto/16 :goto_2

    :cond_13
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->g:[I

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->j:I

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->G:I

    if-ne v1, v2, :cond_3

    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->k:I

    goto/16 :goto_3

    :cond_14
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->I:[S

    const/4 v6, 0x0

    aput-short v6, v3, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    int-to-byte v6, v2

    aput-byte v6, v3, v2

    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_4

    :cond_15
    if-nez v6, :cond_25

    if-ge v9, v4, :cond_17

    if-nez v3, :cond_16

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->l()I

    move-result v3

    if-lez v3, :cond_b

    const/4 v2, 0x0

    :cond_16
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/xiaomi/hm/view/GifDecoder;->A:[B

    aget-byte v10, v10, v2

    and-int/lit16 v10, v10, 0xff

    shl-int/2addr v10, v9

    add-int/2addr v8, v10

    add-int/lit8 v9, v9, 0x8

    add-int/lit8 v2, v2, 0x1

    add-int/lit8 v3, v3, -0x1

    goto/16 :goto_5

    :cond_17
    and-int v10, v8, v5

    shr-int/2addr v8, v4

    sub-int/2addr v9, v4

    if-gt v10, v12, :cond_b

    move/from16 v0, v20

    if-eq v10, v0, :cond_b

    move/from16 v0, v19

    if-ne v10, v0, :cond_18

    add-int/lit8 v4, v18, 0x1

    const/4 v5, 0x1

    shl-int/2addr v5, v4

    add-int/lit8 v5, v5, -0x1

    add-int/lit8 v12, v19, 0x2

    const/4 v11, -0x1

    goto/16 :goto_5

    :cond_18
    const/4 v14, -0x1

    if-ne v11, v14, :cond_19

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    add-int/lit8 v7, v6, 0x1

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    aget-byte v14, v14, v10

    aput-byte v14, v11, v6

    move v6, v7

    move v11, v10

    move v7, v10

    goto/16 :goto_5

    :cond_19
    if-ne v10, v12, :cond_24

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    move-object/from16 v21, v0

    add-int/lit8 v14, v6, 0x1

    int-to-byte v7, v7

    aput-byte v7, v21, v6

    move v7, v11

    :goto_a
    move/from16 v0, v19

    if-gt v7, v0, :cond_1b

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    aget-byte v6, v6, v7

    and-int/lit16 v7, v6, 0xff

    const/16 v6, 0x1000

    if-ge v12, v6, :cond_b

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    move-object/from16 v21, v0

    add-int/lit8 v6, v14, 0x1

    int-to-byte v0, v7

    move/from16 v22, v0

    aput-byte v22, v21, v14

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xiaomi/hm/view/GifDecoder;->I:[S

    int-to-short v11, v11

    aput-short v11, v14, v12

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    int-to-byte v14, v7

    aput-byte v14, v11, v12

    add-int/lit8 v11, v12, 0x1

    and-int v12, v11, v5

    if-nez v12, :cond_1a

    const/16 v12, 0x1000

    if-ge v11, v12, :cond_1a

    add-int/lit8 v4, v4, 0x1

    add-int/2addr v5, v11

    :cond_1a
    move/from16 v23, v6

    move v6, v8

    move v8, v10

    move v10, v5

    move v5, v7

    move v7, v9

    move v9, v4

    move/from16 v4, v23

    :goto_b
    add-int/lit8 v12, v4, -0x1

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    add-int/lit8 v4, v13, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    move-object/from16 v21, v0

    aget-byte v21, v21, v12

    aput-byte v21, v14, v13

    add-int/lit8 v13, v15, 0x1

    move v15, v13

    move v13, v4

    move v4, v9

    move v9, v7

    move v7, v5

    move v5, v10

    move/from16 v23, v8

    move v8, v6

    move v6, v12

    move v12, v11

    move/from16 v11, v23

    goto/16 :goto_5

    :cond_1b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    move-object/from16 v21, v0

    add-int/lit8 v6, v14, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    move-object/from16 v22, v0

    aget-byte v22, v22, v7

    aput-byte v22, v21, v14

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xiaomi/hm/view/GifDecoder;->I:[S

    aget-short v7, v14, v7

    move v14, v6

    goto :goto_a

    :cond_1c
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    const/4 v4, 0x0

    aput-byte v4, v3, v2

    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_6

    :cond_1d
    :try_start_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->R:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Condition;->await()V
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_7

    :catch_0
    move-exception v2

    :try_start_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->R:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Condition;->signal()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    goto/16 :goto_9

    :catch_1
    move-exception v2

    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_9

    :cond_1e
    :try_start_6
    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->S:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_f

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    const/4 v3, 0x1

    invoke-interface {v2, v3}, Lcom/xiaomi/hm/view/GifAction;->parseReturn(I)V
    :try_end_6
    .catch Ljava/lang/InterruptedException; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto/16 :goto_8

    :catchall_0
    move-exception v2

    :try_start_7
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v3}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v2
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1

    :sswitch_2
    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v1

    sparse-switch v1, :sswitch_data_1

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->u()V

    goto/16 :goto_0

    :sswitch_3
    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v1

    and-int/lit8 v2, v1, 0x1c

    shr-int/lit8 v2, v2, 0x2

    move-object/from16 v0, p0

    iput v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->C:I

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->C:I

    if-nez v2, :cond_1f

    const/4 v2, 0x1

    move-object/from16 v0, p0

    iput v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->C:I

    :cond_1f
    and-int/lit8 v1, v1, 0x1

    if-eqz v1, :cond_21

    const/4 v1, 0x1

    :goto_c
    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->E:Z

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v1

    mul-int/lit8 v1, v1, 0xa

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->F:I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->F:I

    if-nez v1, :cond_20

    const/16 v1, 0x64

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->F:I

    :cond_20
    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->G:I

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    goto/16 :goto_0

    :cond_21
    const/4 v1, 0x0

    goto :goto_c

    :sswitch_4
    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->l()I

    const-string v2, ""

    const/4 v1, 0x0

    :goto_d
    const/16 v3, 0xb

    if-lt v1, v3, :cond_22

    const-string v1, "NETSCAPE2.0"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_23

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->r()V

    goto/16 :goto_0

    :cond_22
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->A:[B

    aget-byte v2, v2, v1

    int-to-char v2, v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    add-int/lit8 v1, v1, 0x1

    goto :goto_d

    :cond_23
    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->u()V

    goto/16 :goto_0

    :sswitch_5
    const/4 v1, 0x1

    move/from16 v16, v1

    goto/16 :goto_0

    :cond_24
    move v14, v6

    move v7, v10

    goto/16 :goto_a

    :cond_25
    move v10, v5

    move v5, v7

    move v7, v9

    move v9, v4

    move v4, v6

    move v6, v8

    move v8, v11

    move v11, v12

    goto/16 :goto_b

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0x21 -> :sswitch_2
        0x2c -> :sswitch_1
        0x3b -> :sswitch_5
    .end sparse-switch

    :sswitch_data_1
    .sparse-switch
        0xf9 -> :sswitch_3
        0xff -> :sswitch_4
    .end sparse-switch
.end method

.method private n()V
    .locals 3

    const/4 v0, 0x1

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v1

    and-int/lit8 v2, v1, 0x1c

    shr-int/lit8 v2, v2, 0x2

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->C:I

    iget v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->C:I

    if-nez v2, :cond_0

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->C:I

    :cond_0
    and-int/lit8 v1, v1, 0x1

    if-eqz v1, :cond_2

    :goto_0
    iput-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->E:Z

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v0

    mul-int/lit8 v0, v0, 0xa

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->F:I

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->F:I

    if-nez v0, :cond_1

    const/16 v0, 0x64

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->F:I

    :cond_1
    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v0

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->G:I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    return-void

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private o()V
    .locals 5

    const/4 v0, 0x1

    const/4 v1, 0x0

    const-string v2, ""

    move-object v3, v2

    move v2, v1

    :goto_0
    const/4 v4, 0x6

    if-lt v2, v4, :cond_1

    const-string v2, "GIF"

    invoke-virtual {v3, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    :cond_0
    :goto_1
    return-void

    :cond_1
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v4, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v3

    int-to-char v3, v3

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_2
    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v2

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v2

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->height:I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v2

    and-int/lit16 v3, v2, 0x80

    if-eqz v3, :cond_3

    :goto_2
    iput-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->d:Z

    const/4 v0, 0x2

    and-int/lit8 v1, v2, 0x7

    shl-int/2addr v0, v1

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->e:I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v0

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->j:I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    iget-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->d:Z

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->i()Z

    move-result v0

    if-nez v0, :cond_0

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->e:I

    invoke-direct {p0, v0}, Lcom/xiaomi/hm/view/GifDecoder;->a(I)[I

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->g:[I

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->g:[I

    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->j:I

    aget v0, v0, v1

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->k:I

    goto :goto_1

    :cond_3
    move v0, v1

    goto :goto_2
.end method

.method private p()V
    .locals 23

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->q:I

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->r:I

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->s:I

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->t:I

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v2

    and-int/lit16 v1, v2, 0x80

    if-eqz v1, :cond_4

    const/4 v1, 0x1

    :goto_0
    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->n:Z

    and-int/lit8 v1, v2, 0x40

    if-eqz v1, :cond_5

    const/4 v1, 0x1

    :goto_1
    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->o:Z

    const/4 v1, 0x2

    and-int/lit8 v2, v2, 0x7

    shl-int/2addr v1, v2

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->p:I

    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->n:Z

    if-eqz v1, :cond_6

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->p:I

    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Lcom/xiaomi/hm/view/GifDecoder;->a(I)[I

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->h:[I

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->h:[I

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    :cond_0
    :goto_2
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->E:Z

    if-eqz v2, :cond_1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    if-eqz v2, :cond_1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    array-length v2, v2

    if-lez v2, :cond_1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    array-length v2, v2

    move-object/from16 v0, p0

    iget v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->G:I

    if-le v2, v3, :cond_1

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->G:I

    aget v1, v1, v2

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    move-object/from16 v0, p0

    iget v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->G:I

    const/4 v4, 0x0

    aput v4, v2, v3

    :cond_1
    move v9, v1

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    if-nez v1, :cond_2

    const/4 v1, 0x1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    :cond_2
    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->i()Z

    move-result v1

    if-eqz v1, :cond_7

    :cond_3
    :goto_3
    return-void

    :cond_4
    const/4 v1, 0x0

    goto :goto_0

    :cond_5
    const/4 v1, 0x0

    goto :goto_1

    :cond_6
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->g:[I

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->j:I

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->G:I

    if-ne v1, v2, :cond_0

    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->k:I

    goto :goto_2

    :cond_7
    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->s:I

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->t:I

    mul-int v16, v1, v2

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    if-eqz v1, :cond_8

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    array-length v1, v1

    move/from16 v0, v16

    if-ge v1, v0, :cond_9

    :cond_8
    move/from16 v0, v16

    new-array v1, v0, [B

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    :cond_9
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->I:[S

    if-nez v1, :cond_a

    const/16 v1, 0x1000

    new-array v1, v1, [S

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->I:[S

    :cond_a
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    if-nez v1, :cond_b

    const/16 v1, 0x1000

    new-array v1, v1, [B

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    :cond_b
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    if-nez v1, :cond_c

    const/16 v1, 0x1001

    new-array v1, v1, [B

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    :cond_c
    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v17

    const/4 v1, 0x1

    shl-int v18, v1, v17

    add-int/lit8 v19, v18, 0x1

    add-int/lit8 v12, v18, 0x2

    const/4 v11, -0x1

    add-int/lit8 v3, v17, 0x1

    const/4 v1, 0x1

    shl-int/2addr v1, v3

    add-int/lit8 v4, v1, -0x1

    const/4 v1, 0x0

    :goto_4
    move/from16 v0, v18

    if-lt v1, v0, :cond_18

    const/4 v13, 0x0

    const/4 v1, 0x0

    move v5, v13

    move v6, v13

    move v7, v13

    move v15, v1

    move v8, v13

    move v2, v13

    move v1, v13

    :goto_5
    move/from16 v0, v16

    if-lt v15, v0, :cond_19

    :cond_d
    move v1, v13

    :goto_6
    move/from16 v0, v16

    if-lt v1, v0, :cond_20

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->u()V

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->i()Z

    move-result v1

    if-nez v1, :cond_3

    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->T:Z

    if-nez v1, :cond_e

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    add-int/lit8 v1, v1, 0x1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    :cond_e
    :try_start_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->ae:[I

    if-nez v1, :cond_f

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->height:I

    mul-int/2addr v1, v2

    new-array v1, v1, [I

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->ae:[I

    :cond_f
    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->D:I

    if-lez v1, :cond_13

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->D:I

    const/4 v2, 0x3

    if-ne v1, v2, :cond_11

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    add-int/lit8 v1, v1, -0x2

    if-gtz v1, :cond_10

    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->z:Landroid/graphics/Bitmap;

    :cond_10
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->z:Landroid/graphics/Bitmap;

    :cond_11
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->z:Landroid/graphics/Bitmap;

    if-eqz v1, :cond_13

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->z:Landroid/graphics/Bitmap;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->ae:[I

    const/4 v3, 0x0

    move-object/from16 v0, p0

    iget v4, v0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget v7, v0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    move-object/from16 v0, p0

    iget v8, v0, Lcom/xiaomi/hm/view/GifDecoder;->height:I

    invoke-virtual/range {v1 .. v8}, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->D:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_13

    const/4 v1, 0x0

    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->E:Z

    if-nez v2, :cond_12

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->l:I

    :cond_12
    const/4 v2, 0x0

    move v3, v2

    :goto_7
    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->x:I

    if-lt v3, v2, :cond_21

    :cond_13
    const/4 v3, 0x1

    const/16 v2, 0x8

    const/4 v1, 0x0

    const/4 v5, 0x0

    :goto_8
    move-object/from16 v0, p0

    iget v4, v0, Lcom/xiaomi/hm/view/GifDecoder;->t:I

    if-lt v5, v4, :cond_23

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->ae:[I

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    move-object/from16 v0, p0

    iget v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->height:I

    sget-object v4, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    invoke-static {v1, v2, v3, v4}, Landroid/graphics/Bitmap;->createBitmap([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->y:Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/StackOverflowError; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    :goto_9
    :try_start_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->lockInterruptibly()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_4

    :goto_a
    :try_start_2
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    if-eqz v1, :cond_14

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    invoke-interface {v1}, Ljava/util/Queue;->size()I

    move-result v1

    const/16 v2, 0xf

    if-ge v1, v2, :cond_28

    :cond_14
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    if-eqz v1, :cond_16

    new-instance v1, Lcom/xiaomi/hm/view/GifFrame;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->y:Landroid/graphics/Bitmap;

    move-object/from16 v0, p0

    iget v3, v0, Lcom/xiaomi/hm/view/GifDecoder;->F:I

    invoke-direct {v1, v2, v3}, Lcom/xiaomi/hm/view/GifFrame;-><init>(Landroid/graphics/Bitmap;I)V

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    invoke-interface {v2, v1}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->T:Z

    if-nez v2, :cond_15

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->U:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_15
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->Q:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Condition;->signal()V

    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->T:Z

    if-nez v1, :cond_16

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->S:I

    if-ltz v1, :cond_16

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->S:I

    add-int/lit8 v1, v1, 0x1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->S:I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->S:I

    const/16 v2, 0xf

    if-lt v1, v2, :cond_29

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    const/4 v2, 0x3

    invoke-interface {v1, v2}, Lcom/xiaomi/hm/view/GifAction;->parseReturn(I)V

    const/4 v1, -0x1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->S:I
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_3
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :cond_16
    :goto_b
    :try_start_3
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_4

    :goto_c
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->E:Z

    if-eqz v1, :cond_17

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->G:I

    aput v9, v1, v2

    :cond_17
    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->C:I

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->D:I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->q:I

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->u:I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->r:I

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->v:I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->s:I

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->w:I

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->t:I

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->x:I

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->y:Landroid/graphics/Bitmap;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->z:Landroid/graphics/Bitmap;

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->k:I

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->l:I

    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->C:I

    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->E:Z

    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->F:I

    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->h:[I

    goto/16 :goto_3

    :cond_18
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->I:[S

    const/4 v5, 0x0

    aput-short v5, v2, v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    int-to-byte v5, v1

    aput-byte v5, v2, v1

    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_4

    :cond_19
    if-nez v5, :cond_2d

    if-ge v8, v3, :cond_1b

    if-nez v2, :cond_1a

    invoke-direct/range {p0 .. p0}, Lcom/xiaomi/hm/view/GifDecoder;->l()I

    move-result v2

    if-lez v2, :cond_d

    const/4 v1, 0x0

    :cond_1a
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/xiaomi/hm/view/GifDecoder;->A:[B

    aget-byte v10, v10, v1

    and-int/lit16 v10, v10, 0xff

    shl-int/2addr v10, v8

    add-int/2addr v7, v10

    add-int/lit8 v8, v8, 0x8

    add-int/lit8 v1, v1, 0x1

    add-int/lit8 v2, v2, -0x1

    goto/16 :goto_5

    :cond_1b
    and-int v10, v7, v4

    shr-int/2addr v7, v3

    sub-int/2addr v8, v3

    if-gt v10, v12, :cond_d

    move/from16 v0, v19

    if-eq v10, v0, :cond_d

    move/from16 v0, v18

    if-ne v10, v0, :cond_1c

    add-int/lit8 v3, v17, 0x1

    const/4 v4, 0x1

    shl-int/2addr v4, v3

    add-int/lit8 v4, v4, -0x1

    add-int/lit8 v12, v18, 0x2

    const/4 v11, -0x1

    goto/16 :goto_5

    :cond_1c
    const/4 v14, -0x1

    if-ne v11, v14, :cond_1d

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    add-int/lit8 v6, v5, 0x1

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    aget-byte v14, v14, v10

    aput-byte v14, v11, v5

    move v5, v6

    move v11, v10

    move v6, v10

    goto/16 :goto_5

    :cond_1d
    if-ne v10, v12, :cond_2c

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    move-object/from16 v20, v0

    add-int/lit8 v14, v5, 0x1

    int-to-byte v6, v6

    aput-byte v6, v20, v5

    move v6, v11

    :goto_d
    move/from16 v0, v18

    if-gt v6, v0, :cond_1f

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    aget-byte v5, v5, v6

    and-int/lit16 v6, v5, 0xff

    const/16 v5, 0x1000

    if-ge v12, v5, :cond_d

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    move-object/from16 v20, v0

    add-int/lit8 v5, v14, 0x1

    int-to-byte v0, v6

    move/from16 v21, v0

    aput-byte v21, v20, v14

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xiaomi/hm/view/GifDecoder;->I:[S

    int-to-short v11, v11

    aput-short v11, v14, v12

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    int-to-byte v14, v6

    aput-byte v14, v11, v12

    add-int/lit8 v11, v12, 0x1

    and-int v12, v11, v4

    if-nez v12, :cond_1e

    const/16 v12, 0x1000

    if-ge v11, v12, :cond_1e

    add-int/lit8 v3, v3, 0x1

    add-int/2addr v4, v11

    :cond_1e
    move/from16 v22, v5

    move v5, v7

    move v7, v10

    move v10, v4

    move v4, v6

    move v6, v8

    move v8, v3

    move/from16 v3, v22

    :goto_e
    add-int/lit8 v12, v3, -0x1

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    add-int/lit8 v3, v13, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    move-object/from16 v20, v0

    aget-byte v20, v20, v12

    aput-byte v20, v14, v13

    add-int/lit8 v13, v15, 0x1

    move v15, v13

    move v13, v3

    move v3, v8

    move v8, v6

    move v6, v4

    move v4, v10

    move/from16 v22, v7

    move v7, v5

    move v5, v12

    move v12, v11

    move/from16 v11, v22

    goto/16 :goto_5

    :cond_1f
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xiaomi/hm/view/GifDecoder;->K:[B

    move-object/from16 v20, v0

    add-int/lit8 v5, v14, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xiaomi/hm/view/GifDecoder;->J:[B

    move-object/from16 v21, v0

    aget-byte v21, v21, v6

    aput-byte v21, v20, v14

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xiaomi/hm/view/GifDecoder;->I:[S

    aget-short v6, v14, v6

    move v14, v5

    goto :goto_d

    :cond_20
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    const/4 v3, 0x0

    aput-byte v3, v2, v1

    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_6

    :cond_21
    :try_start_4
    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->v:I

    add-int/2addr v2, v3

    move-object/from16 v0, p0

    iget v4, v0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    mul-int/2addr v2, v4

    move-object/from16 v0, p0

    iget v4, v0, Lcom/xiaomi/hm/view/GifDecoder;->u:I

    add-int/2addr v2, v4

    move-object/from16 v0, p0

    iget v4, v0, Lcom/xiaomi/hm/view/GifDecoder;->w:I

    add-int/2addr v4, v2

    :goto_f
    if-lt v2, v4, :cond_22

    add-int/lit8 v2, v3, 0x1

    move v3, v2

    goto/16 :goto_7

    :cond_22
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/xiaomi/hm/view/GifDecoder;->ae:[I

    aput v1, v5, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_f

    :cond_23
    move-object/from16 v0, p0

    iget-boolean v4, v0, Lcom/xiaomi/hm/view/GifDecoder;->o:Z

    if-eqz v4, :cond_2b

    move-object/from16 v0, p0

    iget v4, v0, Lcom/xiaomi/hm/view/GifDecoder;->t:I

    if-lt v1, v4, :cond_24

    add-int/lit8 v3, v3, 0x1

    packed-switch v3, :pswitch_data_0

    :cond_24
    :goto_10
    add-int v4, v1, v2

    move v6, v4

    move v7, v2

    move v8, v3

    :goto_11
    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->r:I

    add-int/2addr v1, v2

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->height:I

    if-ge v1, v2, :cond_25

    move-object/from16 v0, p0

    iget v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    mul-int v3, v1, v2

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->q:I

    add-int v2, v3, v1

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->s:I

    add-int/2addr v1, v2

    move-object/from16 v0, p0

    iget v4, v0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    add-int/2addr v4, v3

    if-ge v4, v1, :cond_2a

    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    add-int/2addr v1, v3

    move v4, v1

    :goto_12
    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->s:I

    mul-int/2addr v1, v5

    move v3, v2

    :goto_13
    if-lt v3, v4, :cond_26

    :cond_25
    add-int/lit8 v5, v5, 0x1

    move v1, v6

    move v2, v7

    move v3, v8

    goto/16 :goto_8

    :pswitch_0
    const/4 v1, 0x4

    goto :goto_10

    :pswitch_1
    const/4 v1, 0x2

    const/4 v2, 0x4

    goto :goto_10

    :pswitch_2
    const/4 v1, 0x1

    const/4 v2, 0x2

    goto :goto_10

    :cond_26
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/xiaomi/hm/view/GifDecoder;->L:[B

    add-int/lit8 v2, v1, 0x1

    aget-byte v1, v10, v1

    and-int/lit16 v1, v1, 0xff

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/xiaomi/hm/view/GifDecoder;->i:[I

    aget v1, v10, v1

    if-eqz v1, :cond_27

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/xiaomi/hm/view/GifDecoder;->ae:[I

    aput v1, v10, v3
    :try_end_4
    .catch Ljava/lang/OutOfMemoryError; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/lang/StackOverflowError; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    :cond_27
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    move v1, v2

    goto :goto_13

    :catch_0
    move-exception v1

    invoke-virtual {v1}, Ljava/lang/OutOfMemoryError;->printStackTrace()V

    goto/16 :goto_9

    :catch_1
    move-exception v1

    invoke-virtual {v1}, Ljava/lang/StackOverflowError;->printStackTrace()V

    goto/16 :goto_9

    :catch_2
    move-exception v1

    const-string v2, "GifView decode setpixel"

    invoke-virtual {v1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_9

    :cond_28
    :try_start_5
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->R:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Condition;->await()V
    :try_end_5
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_5} :catch_3
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto/16 :goto_a

    :catch_3
    move-exception v1

    :try_start_6
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->R:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Condition;->signal()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    :try_start_7
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_4

    goto/16 :goto_c

    :catch_4
    move-exception v1

    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_c

    :cond_29
    :try_start_8
    move-object/from16 v0, p0

    iget v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->S:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_16

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    const/4 v2, 0x1

    invoke-interface {v1, v2}, Lcom/xiaomi/hm/view/GifAction;->parseReturn(I)V
    :try_end_8
    .catch Ljava/lang/InterruptedException; {:try_start_8 .. :try_end_8} :catch_3
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto/16 :goto_b

    :catchall_0
    move-exception v1

    :try_start_9
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v1
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_4

    :cond_2a
    move v4, v1

    goto/16 :goto_12

    :cond_2b
    move v6, v1

    move v7, v2

    move v8, v3

    move v1, v5

    goto/16 :goto_11

    :cond_2c
    move v14, v5

    move v6, v10

    goto/16 :goto_d

    :cond_2d
    move v10, v4

    move v4, v6

    move v6, v8

    move v8, v3

    move v3, v5

    move v5, v7

    move v7, v11

    move v11, v12

    goto/16 :goto_e

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private q()V
    .locals 2

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v0

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->width:I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->s()I

    move-result v0

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->height:I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v1

    and-int/lit16 v0, v1, 0x80

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->d:Z

    const/4 v0, 0x2

    and-int/lit8 v1, v1, 0x7

    shl-int/2addr v0, v1

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->e:I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v0

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->j:I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private r()V
    .locals 4

    const/4 v3, 0x1

    :cond_0
    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->l()I

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->A:[B

    const/4 v1, 0x0

    aget-byte v0, v0, v1

    if-ne v0, v3, :cond_1

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->A:[B

    aget-byte v0, v0, v3

    and-int/lit16 v0, v0, 0xff

    iget-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->A:[B

    const/4 v2, 0x2

    aget-byte v1, v1, v2

    and-int/lit16 v1, v1, 0xff

    shl-int/lit8 v1, v1, 0x8

    or-int/2addr v0, v1

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->f:I

    :cond_1
    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->B:I

    if-lez v0, :cond_2

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->i()Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_2
    return-void
.end method

.method private s()I
    .locals 2

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v0

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->k()I

    move-result v1

    shl-int/lit8 v1, v1, 0x8

    or-int/2addr v0, v1

    return v0
.end method

.method private t()V
    .locals 2

    const/4 v1, 0x0

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->C:I

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->D:I

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->q:I

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->u:I

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->r:I

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->v:I

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->s:I

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->w:I

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->t:I

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->x:I

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->y:Landroid/graphics/Bitmap;

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->z:Landroid/graphics/Bitmap;

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->k:I

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->l:I

    iput v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->C:I

    iput-boolean v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->E:Z

    iput v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->F:I

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->h:[I

    return-void
.end method

.method private u()V
    .locals 1

    :cond_0
    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->l()I

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->B:I

    if-lez v0, :cond_1

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->i()Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_1
    return-void
.end method


# virtual methods
.method public destroy()V
    .locals 2

    const/4 v1, 0x0

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->isDestroy:Z

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    iput-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->a:Ljava/io/InputStream;

    :cond_0
    iput-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->Y:[B

    const/4 v0, 0x0

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->U:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->U:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    iput-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->U:Ljava/util/ArrayList;

    :cond_1
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->clear()V

    iput-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    :cond_2
    iput-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public getCurrentFrame()Lcom/xiaomi/hm/view/GifFrame;
    .locals 4

    const/4 v1, 0x0

    const/4 v2, 0x0

    iget-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->W:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->size()I

    move-result v0

    if-nez v0, :cond_1

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->V:I

    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    if-lt v0, v1, :cond_0

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->V:I

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    invoke-interface {v0}, Lcom/xiaomi/hm/view/GifAction;->loopEnd()V

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->U:Ljava/util/ArrayList;

    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->V:I

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/hm/view/GifFrame;

    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->V:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->V:I

    :goto_0
    return-object v0

    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lockInterruptibly()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :goto_1
    :try_start_1
    iget-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->W:Z

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->size()I

    move-result v0

    if-eqz v0, :cond_4

    :cond_2
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->O:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/hm/view/GifFrame;

    iget-object v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->R:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Condition;->signal()V

    iget v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->V:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->V:I

    iget-boolean v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->T:Z

    if-eqz v2, :cond_3

    iget v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->V:I

    iget v3, p0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    if-lt v2, v3, :cond_3

    iget-object v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->X:Lcom/xiaomi/hm/view/GifAction;

    invoke-interface {v2}, Lcom/xiaomi/hm/view/GifAction;->loopEnd()V

    const/4 v2, 0x0

    iput v2, p0, Lcom/xiaomi/hm/view/GifDecoder;->V:I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :cond_3
    iget-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto :goto_0

    :cond_4
    :try_start_2
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->Q:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->await()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    :catch_0
    move-exception v0

    :try_start_3
    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->Q:Ljava/util/concurrent/locks/Condition;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signal()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    move-object v0, v1

    goto :goto_0

    :catch_1
    move-exception v0

    iget-object v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    move-object v0, v1

    goto :goto_0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->P:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v0
.end method

.method public getFrameCount()I
    .locals 2

    const/4 v0, -0x1

    iget-boolean v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->T:Z

    if-nez v1, :cond_0

    iget v1, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    if-eq v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->M:I

    goto :goto_0
.end method

.method public getFrameImage()Landroid/graphics/Bitmap;
    .locals 1

    invoke-virtual {p0}, Lcom/xiaomi/hm/view/GifDecoder;->getCurrentFrame()Lcom/xiaomi/hm/view/GifFrame;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, v0, Lcom/xiaomi/hm/view/GifFrame;->image:Landroid/graphics/Bitmap;

    goto :goto_0
.end method

.method public getImage()Landroid/graphics/Bitmap;
    .locals 1

    invoke-virtual {p0}, Lcom/xiaomi/hm/view/GifDecoder;->getFrameImage()Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public getInputStream()Ljava/io/InputStream;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method public getLoopCount()I
    .locals 1

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->f:I

    return v0
.end method

.method public getStatus()I
    .locals 1

    iget v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->c:I

    return v0
.end method

.method public next()Lcom/xiaomi/hm/view/GifFrame;
    .locals 1

    invoke-virtual {p0}, Lcom/xiaomi/hm/view/GifDecoder;->getCurrentFrame()Lcom/xiaomi/hm/view/GifFrame;

    move-result-object v0

    return-object v0
.end method

.method public run()V
    .locals 3

    :try_start_0
    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->f()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "GifView decode run"

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public setGifImage(Landroid/content/res/Resources;I)V
    .locals 1

    iput-object p1, p0, Lcom/xiaomi/hm/view/GifDecoder;->ab:Landroid/content/res/Resources;

    iput p2, p0, Lcom/xiaomi/hm/view/GifDecoder;->ac:I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->b()V

    const/4 v0, 0x1

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->aa:I

    return-void
.end method

.method public setGifImage(Ljava/lang/String;)V
    .locals 1

    iput-object p1, p0, Lcom/xiaomi/hm/view/GifDecoder;->ad:Ljava/lang/String;

    const/4 v0, 0x2

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->aa:I

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->c()V

    return-void
.end method

.method public setGifImage([B)V
    .locals 1

    iput-object p1, p0, Lcom/xiaomi/hm/view/GifDecoder;->Y:[B

    invoke-direct {p0}, Lcom/xiaomi/hm/view/GifDecoder;->a()V

    const/4 v0, 0x3

    iput v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->aa:I

    return-void
.end method

.method public setLoopAnimation()V
    .locals 1

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xiaomi/hm/view/GifDecoder;->Z:Z

    return-void
.end method
