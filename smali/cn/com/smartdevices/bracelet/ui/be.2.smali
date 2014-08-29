.class final Lcn/com/smartdevices/bracelet/ui/be;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/Comparator;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;


# direct methods
.method private constructor <init>(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;B)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/ui/be;-><init>(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V

    return-void
.end method


# virtual methods
.method public final compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 2

    check-cast p1, Lcn/com/smartdevices/bracelet/ui/bc;

    check-cast p2, Lcn/com/smartdevices/bracelet/ui/bc;

    iget v0, p2, Lcn/com/smartdevices/bracelet/ui/bc;->b:I

    iget v1, p1, Lcn/com/smartdevices/bracelet/ui/bc;->b:I

    sub-int/2addr v0, v1

    return v0
.end method
