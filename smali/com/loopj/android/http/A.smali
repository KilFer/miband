.class final Lcom/loopj/android/http/A;
.super Ljava/lang/Object;

# interfaces
.implements Lorg/apache/http/HttpEntity;


# static fields
.field private static final a:Ljava/lang/String; = "SimpleMultipartEntity"

.field private static final b:Ljava/lang/String; = "\r\n"

.field private static final c:[B

.field private static final d:[B

.field private static final e:[C


# instance fields
.field private final f:Ljava/lang/String;

.field private final g:[B

.field private final h:[B

.field private i:Z

.field private final j:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/loopj/android/http/B;",
            ">;"
        }
    .end annotation
.end field

.field private final k:Ljava/io/ByteArrayOutputStream;

.field private final l:Lcom/loopj/android/http/ResponseHandlerInterface;

.field private m:I

.field private n:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-string v0, "\r\n"

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    sput-object v0, Lcom/loopj/android/http/A;->c:[B

    const-string v0, "Content-Transfer-Encoding: binary\r\n"

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    sput-object v0, Lcom/loopj/android/http/A;->d:[B

    const-string v0, "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    invoke-virtual {v0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    sput-object v0, Lcom/loopj/android/http/A;->e:[C

    return-void
.end method

.method public constructor <init>(Lcom/loopj/android/http/ResponseHandlerInterface;)V
    .locals 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/loopj/android/http/A;->j:Ljava/util/List;

    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    iput-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    new-instance v2, Ljava/util/Random;

    invoke-direct {v2}, Ljava/util/Random;-><init>()V

    const/4 v0, 0x0

    :goto_0
    const/16 v3, 0x1e

    if-lt v0, v3, :cond_0

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/loopj/android/http/A;->f:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "--"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/loopj/android/http/A;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\r\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    iput-object v0, p0, Lcom/loopj/android/http/A;->g:[B

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "--"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/loopj/android/http/A;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "--\r\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    iput-object v0, p0, Lcom/loopj/android/http/A;->h:[B

    iput-object p1, p0, Lcom/loopj/android/http/A;->l:Lcom/loopj/android/http/ResponseHandlerInterface;

    return-void

    :cond_0
    sget-object v3, Lcom/loopj/android/http/A;->e:[C

    sget-object v4, Lcom/loopj/android/http/A;->e:[C

    array-length v4, v4

    invoke-virtual {v2, v4}, Ljava/util/Random;->nextInt(I)I

    move-result v4

    aget-char v3, v3, v4

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method private static a(Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    if-nez p0, :cond_0

    const-string p0, "application/octet-stream"

    :cond_0
    return-object p0
.end method

.method private a(I)V
    .locals 3

    iget v0, p0, Lcom/loopj/android/http/A;->m:I

    add-int/2addr v0, p1

    iput v0, p0, Lcom/loopj/android/http/A;->m:I

    iget-object v0, p0, Lcom/loopj/android/http/A;->l:Lcom/loopj/android/http/ResponseHandlerInterface;

    iget v1, p0, Lcom/loopj/android/http/A;->m:I

    iget v2, p0, Lcom/loopj/android/http/A;->n:I

    invoke-interface {v0, v1, v2}, Lcom/loopj/android/http/ResponseHandlerInterface;->sendProgressMessage(II)V

    return-void
.end method

.method static synthetic a(Lcom/loopj/android/http/A;I)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/loopj/android/http/A;->a(I)V

    return-void
.end method

.method private a(Ljava/lang/String;Ljava/io/File;)V
    .locals 1

    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lcom/loopj/android/http/A;->a(Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)V

    return-void
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    :try_start_0
    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    iget-object v1, p0, Lcom/loopj/android/http/A;->g:[B

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Content-Disposition: form-data; name=\""

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\"\r\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    invoke-direct {p0, p3}, Lcom/loopj/android/http/A;->b(Ljava/lang/String;)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    sget-object v1, Lcom/loopj/android/http/A;->c:[B

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {p2}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    sget-object v1, Lcom/loopj/android/http/A;->c:[B

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "SimpleMultipartEntity"

    const-string v2, "addPart ByteArrayOutputStream exception"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method static synthetic a()[B
    .locals 1

    sget-object v0, Lcom/loopj/android/http/A;->d:[B

    return-object v0
.end method

.method static synthetic a(Lcom/loopj/android/http/A;)[B
    .locals 1

    iget-object v0, p0, Lcom/loopj/android/http/A;->g:[B

    return-object v0
.end method

.method static synthetic a(Lcom/loopj/android/http/A;Ljava/lang/String;)[B
    .locals 1

    invoke-direct {p0, p1}, Lcom/loopj/android/http/A;->b(Ljava/lang/String;)[B

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Lcom/loopj/android/http/A;Ljava/lang/String;Ljava/lang/String;)[B
    .locals 1

    invoke-static {p1, p2}, Lcom/loopj/android/http/A;->b(Ljava/lang/String;Ljava/lang/String;)[B

    move-result-object v0

    return-object v0
.end method

.method static synthetic b()[B
    .locals 1

    sget-object v0, Lcom/loopj/android/http/A;->c:[B

    return-object v0
.end method

.method private b(Ljava/lang/String;)[B
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Content-Type: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p1}, Lcom/loopj/android/http/A;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\r\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    return-object v0
.end method

.method private static b(Ljava/lang/String;Ljava/lang/String;)[B
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Content-Disposition: form-data; name=\""

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\"; filename=\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\"\r\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    return-object v0
.end method

.method private static c(Ljava/lang/String;)[B
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Content-Disposition: form-data; name=\""

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\"\r\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public final a(Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)V
    .locals 3

    iget-object v0, p0, Lcom/loopj/android/http/A;->j:Ljava/util/List;

    new-instance v1, Lcom/loopj/android/http/B;

    invoke-static {p3}, Lcom/loopj/android/http/A;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, p0, p1, p2, v2}, Lcom/loopj/android/http/B;-><init>(Lcom/loopj/android/http/A;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    const-string v0, "text/plain; charset=UTF-8"

    :try_start_0
    iget-object v1, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    iget-object v2, p0, Lcom/loopj/android/http/A;->g:[B

    invoke-virtual {v1, v2}, Ljava/io/ByteArrayOutputStream;->write([B)V

    iget-object v1, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Content-Disposition: form-data; name=\""

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\"\r\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/ByteArrayOutputStream;->write([B)V

    iget-object v1, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    invoke-direct {p0, v0}, Lcom/loopj/android/http/A;->b(Ljava/lang/String;)[B

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/io/ByteArrayOutputStream;->write([B)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    sget-object v1, Lcom/loopj/android/http/A;->c:[B

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {p2}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    sget-object v1, Lcom/loopj/android/http/A;->c:[B

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "SimpleMultipartEntity"

    const-string v2, "addPart ByteArrayOutputStream exception"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public final a(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;Ljava/lang/String;)V
    .locals 4

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    iget-object v1, p0, Lcom/loopj/android/http/A;->g:[B

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    invoke-static {p1, p2}, Lcom/loopj/android/http/A;->b(Ljava/lang/String;Ljava/lang/String;)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    invoke-direct {p0, p4}, Lcom/loopj/android/http/A;->b(Ljava/lang/String;)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    sget-object v1, Lcom/loopj/android/http/A;->d:[B

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    sget-object v1, Lcom/loopj/android/http/A;->c:[B

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V

    const/16 v0, 0x1000

    new-array v0, v0, [B

    :goto_0
    invoke-virtual {p3, v0}, Ljava/io/InputStream;->read([B)I

    move-result v1

    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    sget-object v1, Lcom/loopj/android/http/A;->c:[B

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write([B)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->flush()V

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    invoke-static {v0}, Lcom/loopj/android/http/AsyncHttpClient;->silentCloseOutputStream(Ljava/io/OutputStream;)V

    return-void

    :cond_0
    iget-object v2, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    const/4 v3, 0x0

    invoke-virtual {v2, v0, v3, v1}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    goto :goto_0
.end method

.method public final a(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/loopj/android/http/A;->i:Z

    return-void
.end method

.method public final consumeContent()V
    .locals 2

    invoke-virtual {p0}, Lcom/loopj/android/http/A;->isStreaming()Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Streaming entity does not implement #consumeContent()"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    return-void
.end method

.method public final getContent()Ljava/io/InputStream;
    .locals 2

    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "getContent() is not supported. Use writeTo() instead."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public final getContentEncoding()Lorg/apache/http/Header;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method public final getContentLength()J
    .locals 8

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->size()I

    move-result v0

    int-to-long v0, v0

    iget-object v2, p0, Lcom/loopj/android/http/A;->j:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move-wide v1, v0

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/loopj/android/http/A;->h:[B

    array-length v0, v0

    int-to-long v3, v0

    add-long v0, v1, v3

    :goto_1
    return-wide v0

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/loopj/android/http/B;

    iget-object v4, v0, Lcom/loopj/android/http/B;->a:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->length()J

    move-result-wide v4

    sget-object v6, Lcom/loopj/android/http/A;->c:[B

    array-length v6, v6

    int-to-long v6, v6

    add-long/2addr v4, v6

    iget-object v0, v0, Lcom/loopj/android/http/B;->b:[B

    array-length v0, v0

    int-to-long v6, v0

    add-long/2addr v4, v6

    const-wide/16 v6, 0x0

    cmp-long v0, v4, v6

    if-gez v0, :cond_1

    const-wide/16 v0, -0x1

    goto :goto_1

    :cond_1
    add-long v0, v1, v4

    move-wide v1, v0

    goto :goto_0
.end method

.method public final getContentType()Lorg/apache/http/Header;
    .locals 4

    new-instance v0, Lorg/apache/http/message/BasicHeader;

    const-string v1, "Content-Type"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "multipart/form-data; boundary="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/loopj/android/http/A;->f:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lorg/apache/http/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public final isChunked()Z
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public final isRepeatable()Z
    .locals 1

    iget-boolean v0, p0, Lcom/loopj/android/http/A;->i:Z

    return v0
.end method

.method public final isStreaming()Z
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public final writeTo(Ljava/io/OutputStream;)V
    .locals 7

    const/4 v6, 0x0

    iput v6, p0, Lcom/loopj/android/http/A;->m:I

    invoke-virtual {p0}, Lcom/loopj/android/http/A;->getContentLength()J

    move-result-wide v0

    long-to-int v0, v0

    iput v0, p0, Lcom/loopj/android/http/A;->n:I

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0, p1}, Ljava/io/ByteArrayOutputStream;->writeTo(Ljava/io/OutputStream;)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->k:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->size()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/loopj/android/http/A;->a(I)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->j:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/loopj/android/http/A;->h:[B

    invoke-virtual {p1, v0}, Ljava/io/OutputStream;->write([B)V

    iget-object v0, p0, Lcom/loopj/android/http/A;->h:[B

    array-length v0, v0

    invoke-direct {p0, v0}, Lcom/loopj/android/http/A;->a(I)V

    return-void

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/loopj/android/http/B;

    iget-object v2, v0, Lcom/loopj/android/http/B;->b:[B

    invoke-virtual {p1, v2}, Ljava/io/OutputStream;->write([B)V

    iget-object v2, v0, Lcom/loopj/android/http/B;->c:Lcom/loopj/android/http/A;

    iget-object v3, v0, Lcom/loopj/android/http/B;->b:[B

    array-length v3, v3

    invoke-direct {v2, v3}, Lcom/loopj/android/http/A;->a(I)V

    new-instance v2, Ljava/io/FileInputStream;

    iget-object v3, v0, Lcom/loopj/android/http/B;->a:Ljava/io/File;

    invoke-direct {v2, v3}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    const/16 v3, 0x1000

    new-array v3, v3, [B

    :goto_1
    invoke-virtual {v2, v3}, Ljava/io/FileInputStream;->read([B)I

    move-result v4

    const/4 v5, -0x1

    if-ne v4, v5, :cond_1

    sget-object v3, Lcom/loopj/android/http/A;->c:[B

    invoke-virtual {p1, v3}, Ljava/io/OutputStream;->write([B)V

    iget-object v0, v0, Lcom/loopj/android/http/B;->c:Lcom/loopj/android/http/A;

    sget-object v3, Lcom/loopj/android/http/A;->c:[B

    array-length v3, v3

    invoke-direct {v0, v3}, Lcom/loopj/android/http/A;->a(I)V

    invoke-virtual {p1}, Ljava/io/OutputStream;->flush()V

    invoke-static {v2}, Lcom/loopj/android/http/AsyncHttpClient;->silentCloseInputStream(Ljava/io/InputStream;)V

    goto :goto_0

    :cond_1
    invoke-virtual {p1, v3, v6, v4}, Ljava/io/OutputStream;->write([BII)V

    iget-object v5, v0, Lcom/loopj/android/http/B;->c:Lcom/loopj/android/http/A;

    invoke-direct {v5, v4}, Lcom/loopj/android/http/A;->a(I)V

    goto :goto_1
.end method
