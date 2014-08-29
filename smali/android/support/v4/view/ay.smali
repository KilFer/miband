.class final Landroid/support/v4/view/ay;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Landroid/support/v4/view/aC;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static a(Landroid/support/v4/view/aC;Landroid/support/v4/view/aC;)I
    .locals 2

    iget v0, p0, Landroid/support/v4/view/aC;->b:I

    iget v1, p1, Landroid/support/v4/view/aC;->b:I

    sub-int/2addr v0, v1

    return v0
.end method


# virtual methods
.method public final bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 2

    check-cast p1, Landroid/support/v4/view/aC;

    check-cast p2, Landroid/support/v4/view/aC;

    iget v0, p1, Landroid/support/v4/view/aC;->b:I

    iget v1, p2, Landroid/support/v4/view/aC;->b:I

    sub-int/2addr v0, v1

    return v0
.end method
