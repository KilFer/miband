.class final Lu/aly/C;
.super Lu/aly/dj;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lu/aly/dj",
        "<",
        "Lu/aly/ah;",
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

    invoke-direct {p0}, Lu/aly/C;-><init>()V

    return-void
.end method

.method private static a(Lu/aly/cy;Lu/aly/ah;)V
    .locals 2

    check-cast p0, Lu/aly/de;

    iget-wide v0, p1, Lu/aly/ah;->a:J

    invoke-virtual {p0, v0, v1}, Lu/aly/de;->a(J)V

    return-void
.end method

.method private static b(Lu/aly/cy;Lu/aly/ah;)V
    .locals 2

    check-cast p0, Lu/aly/de;

    invoke-virtual {p0}, Lu/aly/de;->x()J

    move-result-wide v0

    iput-wide v0, p1, Lu/aly/ah;->a:J

    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lu/aly/ah;->a(Z)V

    return-void
.end method


# virtual methods
.method public final synthetic a(Lu/aly/cy;Lu/aly/bz;)V
    .locals 2

    check-cast p2, Lu/aly/ah;

    check-cast p1, Lu/aly/de;

    invoke-virtual {p1}, Lu/aly/de;->x()J

    move-result-wide v0

    iput-wide v0, p2, Lu/aly/ah;->a:J

    const/4 v0, 0x1

    invoke-virtual {p2, v0}, Lu/aly/ah;->a(Z)V

    return-void
.end method

.method public final synthetic b(Lu/aly/cy;Lu/aly/bz;)V
    .locals 2

    check-cast p2, Lu/aly/ah;

    check-cast p1, Lu/aly/de;

    iget-wide v0, p2, Lu/aly/ah;->a:J

    invoke-virtual {p1, v0, v1}, Lu/aly/de;->a(J)V

    return-void
.end method
