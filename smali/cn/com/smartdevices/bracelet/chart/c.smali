.class final Lcn/com/smartdevices/bracelet/chart/c;
.super Lcn/com/smartdevices/bracelet/chart/b;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;


# direct methods
.method private constructor <init>(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)V
    .locals 1

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcn/com/smartdevices/bracelet/chart/b;-><init>(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;B)V

    return-void
.end method

.method synthetic constructor <init>(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;B)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/chart/c;-><init>(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)V

    return-void
.end method


# virtual methods
.method protected final itemHeight(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 3

    const/4 v0, 0x0

    iget v1, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    const/4 v2, 0x3

    if-ne v1, v2, :cond_1

    const v0, 0x4344999a

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->mDensity:F

    mul-float/2addr v0, v1

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget v1, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    const/4 v2, 0x2

    if-eq v1, v2, :cond_2

    iget v1, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    const/4 v2, 0x1

    if-eq v1, v2, :cond_2

    iget v1, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    const/4 v2, 0x4

    if-ne v1, v2, :cond_0

    :cond_2
    const/high16 v0, 0x43200000

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->mDensity:F

    mul-float/2addr v0, v1

    goto :goto_0
.end method

.method protected final itemOffsetX(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 3

    iget v0, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->index:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->e(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)I

    move-result v1

    if-gt v0, v1, :cond_0

    iget v0, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->index:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->d(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)I

    move-result v1

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->d(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)I

    move-result v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->e(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)I

    move-result v1

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_1
    invoke-virtual {p1}, Landroid/graphics/RectF;->width()F

    move-result v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->mPaddingLeft:F

    sub-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->mPaddingRight:F

    sub-float/2addr v0, v1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->e(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)I

    move-result v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->d(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)I

    move-result v2

    sub-int/2addr v1, v2

    add-int/lit8 v1, v1, 0x1

    int-to-float v1, v1

    div-float/2addr v0, v1

    iget v1, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->index:I

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->d(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)I

    move-result v2

    sub-int/2addr v1, v2

    int-to-float v1, v1

    mul-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->mPaddingLeft:F

    add-float/2addr v1, v0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->f(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/a;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/a;->b()F

    move-result v0

    add-float/2addr v0, v1

    goto :goto_0
.end method

.method protected final itemOffsetY(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method protected final itemWidth(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 4

    const/high16 v3, 0x3f800000

    iget v0, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->index:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->e(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)I

    move-result v1

    if-gt v0, v1, :cond_0

    iget v0, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->index:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->d(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)I

    move-result v1

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->d(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)I

    move-result v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->e(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)I

    move-result v1

    if-ne v0, v1, :cond_2

    :cond_0
    const/4 v0, 0x0

    :cond_1
    :goto_0
    return v0

    :cond_2
    invoke-virtual {p1}, Landroid/graphics/RectF;->width()F

    move-result v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->mPaddingLeft:F

    sub-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->mPaddingRight:F

    sub-float/2addr v0, v1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->e(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)I

    move-result v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->d(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)I

    move-result v2

    sub-int/2addr v1, v2

    add-int/lit8 v1, v1, 0x1

    int-to-float v1, v1

    div-float/2addr v0, v1

    iget v1, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->scope:I

    int-to-float v1, v1

    mul-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->mItemPadding:F

    const/high16 v2, 0x40000000

    mul-float/2addr v1, v2

    sub-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->mDensity:F

    mul-float/2addr v1, v3

    cmpg-float v1, v0, v1

    if-gez v1, :cond_1

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/c;->mDensity:F

    mul-float/2addr v0, v3

    goto :goto_0
.end method

.method protected final onItemsChanged(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->d(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)I

    move-result v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/c;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;->e(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChart;)I

    move-result v1

    if-ne v0, v1, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/b;->onItemsChanged(Ljava/util/List;)V

    goto :goto_0
.end method
