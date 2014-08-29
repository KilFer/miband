.class final Lu/aly/aU;
.super Lu/aly/dj;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lu/aly/dj",
        "<",
        "Lu/aly/au;",
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

    invoke-direct {p0}, Lu/aly/aU;-><init>()V

    return-void
.end method

.method private static a(Lu/aly/cy;Lu/aly/au;)V
    .locals 2

    check-cast p0, Lu/aly/de;

    iget-wide v0, p1, Lu/aly/au;->b:J

    invoke-virtual {p0, v0, v1}, Lu/aly/de;->a(J)V

    iget-object v0, p1, Lu/aly/au;->c:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lu/aly/de;->a(Ljava/lang/String;)V

    new-instance v0, Ljava/util/BitSet;

    invoke-direct {v0}, Ljava/util/BitSet;-><init>()V

    invoke-virtual {p1}, Lu/aly/au;->e()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/BitSet;->set(I)V

    :cond_0
    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lu/aly/de;->a(Ljava/util/BitSet;I)V

    invoke-virtual {p1}, Lu/aly/au;->e()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p1, Lu/aly/au;->a:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lu/aly/de;->a(Ljava/lang/String;)V

    :cond_1
    return-void
.end method

.method private static b(Lu/aly/cy;Lu/aly/au;)V
    .locals 3

    const/4 v2, 0x1

    check-cast p0, Lu/aly/de;

    invoke-virtual {p0}, Lu/aly/de;->x()J

    move-result-wide v0

    iput-wide v0, p1, Lu/aly/au;->b:J

    invoke-virtual {p1, v2}, Lu/aly/au;->b(Z)V

    invoke-virtual {p0}, Lu/aly/de;->z()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p1, Lu/aly/au;->c:Ljava/lang/String;

    invoke-virtual {p1, v2}, Lu/aly/au;->c(Z)V

    invoke-virtual {p0, v2}, Lu/aly/de;->b(I)Ljava/util/BitSet;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/BitSet;->get(I)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lu/aly/de;->z()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p1, Lu/aly/au;->a:Ljava/lang/String;

    invoke-virtual {p1, v2}, Lu/aly/au;->a(Z)V

    :cond_0
    return-void
.end method


# virtual methods
.method public final synthetic a(Lu/aly/cy;Lu/aly/bz;)V
    .locals 3

    const/4 v2, 0x1

    check-cast p2, Lu/aly/au;

    check-cast p1, Lu/aly/de;

    invoke-virtual {p1}, Lu/aly/de;->x()J

    move-result-wide v0

    iput-wide v0, p2, Lu/aly/au;->b:J

    invoke-virtual {p2, v2}, Lu/aly/au;->b(Z)V

    invoke-virtual {p1}, Lu/aly/de;->z()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p2, Lu/aly/au;->c:Ljava/lang/String;

    invoke-virtual {p2, v2}, Lu/aly/au;->c(Z)V

    invoke-virtual {p1, v2}, Lu/aly/de;->b(I)Ljava/util/BitSet;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/BitSet;->get(I)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lu/aly/de;->z()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p2, Lu/aly/au;->a:Ljava/lang/String;

    invoke-virtual {p2, v2}, Lu/aly/au;->a(Z)V

    :cond_0
    return-void
.end method

.method public final synthetic b(Lu/aly/cy;Lu/aly/bz;)V
    .locals 2

    check-cast p2, Lu/aly/au;

    check-cast p1, Lu/aly/de;

    iget-wide v0, p2, Lu/aly/au;->b:J

    invoke-virtual {p1, v0, v1}, Lu/aly/de;->a(J)V

    iget-object v0, p2, Lu/aly/au;->c:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lu/aly/de;->a(Ljava/lang/String;)V

    new-instance v0, Ljava/util/BitSet;

    invoke-direct {v0}, Ljava/util/BitSet;-><init>()V

    invoke-virtual {p2}, Lu/aly/au;->e()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/BitSet;->set(I)V

    :cond_0
    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1}, Lu/aly/de;->a(Ljava/util/BitSet;I)V

    invoke-virtual {p2}, Lu/aly/au;->e()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p2, Lu/aly/au;->a:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lu/aly/de;->a(Ljava/lang/String;)V

    :cond_1
    return-void
.end method
