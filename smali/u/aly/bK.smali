.class final Lu/aly/bK;
.super Lu/aly/dj;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lu/aly/dj",
        "<",
        "Lu/aly/ay;",
        ">;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lu/aly/dj;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(B)V
    .locals 0

    invoke-direct {p0}, Lu/aly/bK;-><init>()V

    return-void
.end method

.method private static a(Lu/aly/cy;Lu/aly/ay;)V
    .locals 2

    check-cast p0, Lu/aly/de;

    iget-object v0, p1, Lu/aly/ay;->a:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lu/aly/de;->a(Ljava/lang/String;)V

    iget-wide v0, p1, Lu/aly/ay;->b:J

    invoke-virtual {p0, v0, v1}, Lu/aly/de;->a(J)V

    return-void
.end method

.method private static b(Lu/aly/cy;Lu/aly/ay;)V
    .locals 3

    const/4 v2, 0x1

    check-cast p0, Lu/aly/de;

    invoke-virtual {p0}, Lu/aly/de;->z()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p1, Lu/aly/ay;->a:Ljava/lang/String;

    invoke-virtual {p1, v2}, Lu/aly/ay;->a(Z)V

    invoke-virtual {p0}, Lu/aly/de;->x()J

    move-result-wide v0

    iput-wide v0, p1, Lu/aly/ay;->b:J

    invoke-virtual {p1, v2}, Lu/aly/ay;->b(Z)V

    return-void
.end method


# virtual methods
.method public final synthetic a(Lu/aly/cy;Lu/aly/bz;)V
    .locals 3

    const/4 v2, 0x1

    check-cast p2, Lu/aly/ay;

    check-cast p1, Lu/aly/de;

    invoke-virtual {p1}, Lu/aly/de;->z()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p2, Lu/aly/ay;->a:Ljava/lang/String;

    invoke-virtual {p2, v2}, Lu/aly/ay;->a(Z)V

    invoke-virtual {p1}, Lu/aly/de;->x()J

    move-result-wide v0

    iput-wide v0, p2, Lu/aly/ay;->b:J

    invoke-virtual {p2, v2}, Lu/aly/ay;->b(Z)V

    return-void
.end method

.method public final synthetic b(Lu/aly/cy;Lu/aly/bz;)V
    .locals 2

    check-cast p2, Lu/aly/ay;

    check-cast p1, Lu/aly/de;

    iget-object v0, p2, Lu/aly/ay;->a:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lu/aly/de;->a(Ljava/lang/String;)V

    iget-wide v0, p2, Lu/aly/ay;->b:J

    invoke-virtual {p1, v0, v1}, Lu/aly/de;->a(J)V

    return-void
.end method
