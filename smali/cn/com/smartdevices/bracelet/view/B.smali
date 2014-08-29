.class final Lcn/com/smartdevices/bracelet/view/B;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcn/com/smartdevices/bracelet/view/E;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static a(Lcn/com/smartdevices/bracelet/view/E;Lcn/com/smartdevices/bracelet/view/E;)I
    .locals 2

    iget v0, p0, Lcn/com/smartdevices/bracelet/view/E;->b:I

    iget v1, p1, Lcn/com/smartdevices/bracelet/view/E;->b:I

    sub-int/2addr v0, v1

    return v0
.end method


# virtual methods
.method public final bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 2

    check-cast p1, Lcn/com/smartdevices/bracelet/view/E;

    check-cast p2, Lcn/com/smartdevices/bracelet/view/E;

    iget v0, p1, Lcn/com/smartdevices/bracelet/view/E;->b:I

    iget v1, p2, Lcn/com/smartdevices/bracelet/view/E;->b:I

    sub-int/2addr v0, v1

    return v0
.end method
