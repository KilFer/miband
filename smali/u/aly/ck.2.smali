.class public Lu/aly/ck;
.super Lu/aly/cm;


# instance fields
.field public final a:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<+",
            "Lu/aly/cd;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(BLjava/lang/Class;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(B",
            "Ljava/lang/Class",
            "<+",
            "Lu/aly/cd;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0, p1}, Lu/aly/cm;-><init>(B)V

    iput-object p2, p0, Lu/aly/ck;->a:Ljava/lang/Class;

    return-void
.end method
