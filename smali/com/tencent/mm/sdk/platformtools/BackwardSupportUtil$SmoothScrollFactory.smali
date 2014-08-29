.class public Lcom/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory;
.super Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static scrollTo(Landroid/widget/ListView;I)V
    .locals 2

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x8

    if-lt v0, v1, :cond_0

    new-instance v0, Lcom/tencent/mm/sdk/platformtools/x;

    invoke-direct {v0}, Lcom/tencent/mm/sdk/platformtools/x;-><init>()V

    invoke-virtual {v0, p0, p1}, Lcom/tencent/mm/sdk/platformtools/x;->doScroll(Landroid/widget/ListView;I)V

    :goto_0
    return-void

    :cond_0
    new-instance v0, Lcom/tencent/mm/sdk/platformtools/w;

    invoke-direct {v0}, Lcom/tencent/mm/sdk/platformtools/w;-><init>()V

    invoke-virtual {v0, p0, p1}, Lcom/tencent/mm/sdk/platformtools/w;->doScroll(Landroid/widget/ListView;I)V

    goto :goto_0
.end method

.method public static scrollToTop(Landroid/widget/ListView;)V
    .locals 2

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x8

    if-lt v0, v1, :cond_0

    new-instance v0, Lcom/tencent/mm/sdk/platformtools/x;

    invoke-direct {v0}, Lcom/tencent/mm/sdk/platformtools/x;-><init>()V

    invoke-virtual {v0, p0}, Lcom/tencent/mm/sdk/platformtools/x;->doScroll(Landroid/widget/ListView;)V

    :goto_0
    return-void

    :cond_0
    new-instance v0, Lcom/tencent/mm/sdk/platformtools/w;

    invoke-direct {v0}, Lcom/tencent/mm/sdk/platformtools/w;-><init>()V

    invoke-virtual {v0, p0}, Lcom/tencent/mm/sdk/platformtools/w;->doScroll(Landroid/widget/ListView;)V

    goto :goto_0
.end method
