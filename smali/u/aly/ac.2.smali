.class public Lu/aly/ac;
.super Lu/aly/am;

# interfaces
.implements Lu/aly/p;


# direct methods
.method public constructor <init>()V
    .locals 2

    invoke-direct {p0}, Lu/aly/am;-><init>()V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lu/aly/ac;->a(J)Lu/aly/am;

    sget-object v0, Lu/aly/an;->a:Lu/aly/an;

    invoke-virtual {p0, v0}, Lu/aly/ac;->a(Lu/aly/an;)Lu/aly/am;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Lu/aly/ac;-><init>()V

    invoke-virtual {p0, p1}, Lu/aly/ac;->a(Ljava/lang/String;)Lu/aly/am;

    return-void
.end method

.method public constructor <init>(Ljava/lang/Throwable;)V
    .locals 1

    invoke-direct {p0}, Lu/aly/ac;-><init>()V

    invoke-static {p1}, Lu/aly/ac;->a(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lu/aly/ac;->a(Ljava/lang/String;)Lu/aly/am;

    return-void
.end method

.method private static a(Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 4

    const/4 v0, 0x0

    if-nez p0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    :try_start_0
    new-instance v2, Ljava/io/StringWriter;

    invoke-direct {v2}, Ljava/io/StringWriter;-><init>()V

    new-instance v3, Ljava/io/PrintWriter;

    invoke-direct {v3, v2}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V

    invoke-virtual {p0, v3}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintWriter;)V

    invoke-virtual {p0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    :goto_1
    if-nez v1, :cond_1

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3}, Ljava/io/PrintWriter;->close()V

    invoke-virtual {v2}, Ljava/io/Writer;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v1

    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    :cond_1
    :try_start_1
    invoke-virtual {v1, v3}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintWriter;)V

    invoke-virtual {v1}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v1

    goto :goto_1
.end method


# virtual methods
.method public a(Z)Lu/aly/ac;
    .locals 1

    if-eqz p1, :cond_0

    sget-object v0, Lu/aly/an;->a:Lu/aly/an;

    :goto_0
    invoke-virtual {p0, v0}, Lu/aly/ac;->a(Lu/aly/an;)Lu/aly/am;

    return-object p0

    :cond_0
    sget-object v0, Lu/aly/an;->b:Lu/aly/an;

    goto :goto_0
.end method

.method public a(Lu/aly/bf;Ljava/lang/String;)V
    .locals 4

    const/4 v1, 0x0

    invoke-virtual {p1}, Lu/aly/bf;->s()I

    move-result v0

    if-lez v0, :cond_1

    invoke-virtual {p1}, Lu/aly/bf;->u()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-nez v0, :cond_3

    :cond_1
    move-object v0, v1

    :goto_0
    if-nez v0, :cond_2

    new-instance v0, Lu/aly/av;

    invoke-direct {v0}, Lu/aly/av;-><init>()V

    invoke-virtual {v0, p2}, Lu/aly/av;->a(Ljava/lang/String;)Lu/aly/av;

    invoke-virtual {p1, v0}, Lu/aly/bf;->a(Lu/aly/av;)V

    :cond_2
    invoke-virtual {v0, p0}, Lu/aly/av;->a(Lu/aly/am;)V

    return-void

    :cond_3
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lu/aly/av;

    invoke-virtual {v0}, Lu/aly/av;->c()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    goto :goto_0
.end method
