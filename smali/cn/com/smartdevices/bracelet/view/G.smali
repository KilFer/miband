.class final Lcn/com/smartdevices/bracelet/view/G;
.super Landroid/database/DataSetObserver;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/view/VerticalViewPager;


# direct methods
.method private constructor <init>(Lcn/com/smartdevices/bracelet/view/VerticalViewPager;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/view/G;->a:Lcn/com/smartdevices/bracelet/view/VerticalViewPager;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcn/com/smartdevices/bracelet/view/VerticalViewPager;B)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/view/G;-><init>(Lcn/com/smartdevices/bracelet/view/VerticalViewPager;)V

    return-void
.end method


# virtual methods
.method public final onChanged()V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/view/G;->a:Lcn/com/smartdevices/bracelet/view/VerticalViewPager;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/view/VerticalViewPager;->a()V

    return-void
.end method

.method public final onInvalidated()V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/view/G;->a:Lcn/com/smartdevices/bracelet/view/VerticalViewPager;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/view/VerticalViewPager;->a()V

    return-void
.end method
