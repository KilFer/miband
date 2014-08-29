.class final Lcn/com/smartdevices/bracelet/chart/deprecated/d;
.super Lcn/com/smartdevices/bracelet/chart/deprecated/b;


# instance fields
.field private a:F

.field private b:I

.field private c:I

.field private synthetic d:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;


# direct methods
.method private constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)V
    .locals 1

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;B)V

    const/16 v0, 0xa

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->c:I

    return-void
.end method

.method synthetic constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;B)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)V

    return-void
.end method

.method private a(I)F
    .locals 3

    if-gtz p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->a:F

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->c:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->c:I

    sub-int/2addr v2, p1

    add-int/lit8 v2, v2, 0x1

    add-int/2addr v1, v2

    mul-int/2addr v1, p1

    int-to-float v1, v1

    const/high16 v2, 0x40000000

    div-float/2addr v1, v2

    mul-float/2addr v0, v1

    goto :goto_0
.end method

.method private a()V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    const/16 v1, 0x5dc

    iput v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mMaxItemValue:I

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mItems:Ljava/util/List;

    monitor-enter v3

    :try_start_0
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mItems:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-nez v1, :cond_1

    monitor-exit v3

    return-void

    :cond_1
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    move-object v0, v1

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;

    move-object v2, v0

    iget v2, v2, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->index:I

    if-ltz v2, :cond_0

    iget v2, v1, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    iget v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mMaxItemValue:I

    if-le v2, v5, :cond_0

    iget v1, v1, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mMaxItemValue:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v1

    monitor-exit v3

    throw v1
.end method

.method private b()V
    .locals 3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mRect:Landroid/graphics/RectF;

    if-eqz v0, :cond_0

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mMaxItemValue:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->c:I

    div-int/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->b:I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mRect:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->width()F

    move-result v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingLeft:F

    sub-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingRight:F

    sub-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->b:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->c:I

    mul-int/2addr v1, v2

    int-to-float v1, v1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mMaxItemValue:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    mul-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->c:I

    add-int/lit8 v1, v1, 0x1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->c:I

    mul-int/2addr v1, v2

    int-to-float v1, v1

    const/high16 v2, 0x40000000

    div-float/2addr v1, v2

    div-float/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->a:F

    :cond_0
    return-void
.end method


# virtual methods
.method protected final itemHeight(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->d(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;

    iget v1, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->scope:I

    int-to-float v1, v1

    const/high16 v2, 0x41c00000

    div-float/2addr v1, v2

    invoke-virtual {p1}, Landroid/graphics/RectF;->height()F

    move-result v2

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingTop:F

    sub-float/2addr v2, v3

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingBottom:F

    sub-float/2addr v2, v3

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)F

    move-result v3

    sub-float/2addr v2, v3

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->getPaddingBottom()F

    move-result v0

    sub-float v0, v2, v0

    mul-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mItemPadding:F

    const/high16 v2, 0x40000000

    mul-float/2addr v1, v2

    sub-float/2addr v0, v1

    return v0
.end method

.method protected final itemOffsetX(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method protected final itemOffsetY(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->d(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;

    iget v1, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->index:I

    int-to-float v1, v1

    const/high16 v2, 0x41c00000

    div-float/2addr v1, v2

    invoke-virtual {p1}, Landroid/graphics/RectF;->height()F

    move-result v2

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingTop:F

    sub-float/2addr v2, v3

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingBottom:F

    sub-float/2addr v2, v3

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)F

    move-result v3

    sub-float/2addr v2, v3

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->getPaddingBottom()F

    move-result v3

    sub-float/2addr v2, v3

    mul-float/2addr v1, v2

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->b()F

    move-result v0

    add-float/2addr v0, v1

    return v0
.end method

.method protected final itemWidth(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 4

    iget v0, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mMaxItemValue:I

    if-lt v0, v1, :cond_0

    invoke-virtual {p1}, Landroid/graphics/RectF;->width()F

    move-result v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingLeft:F

    sub-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingRight:F

    sub-float/2addr v0, v1

    :goto_0
    return v0

    :cond_0
    iget v0, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->b:I

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, -0x1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->b:I

    div-int/2addr v0, v1

    iget v1, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    add-int/lit8 v1, v1, -0x1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->b:I

    rem-int/2addr v1, v2

    add-int/lit8 v1, v1, 0x1

    int-to-float v1, v1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->b:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    add-int/lit8 v2, v0, -0x1

    invoke-direct {p0, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->a(I)F

    move-result v2

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->a(I)F

    move-result v3

    add-int/lit8 v0, v0, -0x1

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->a(I)F

    move-result v0

    sub-float v0, v3, v0

    mul-float/2addr v0, v1

    add-float/2addr v0, v2

    goto :goto_0
.end method

.method protected final onItemsChanged(Ljava/util/List;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;",
            ">;)V"
        }
    .end annotation

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->onItemsChanged(Ljava/util/List;)V

    const/16 v1, 0x5dc

    iput v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mMaxItemValue:I

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mItems:Ljava/util/List;

    monitor-enter v3

    :try_start_0
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mItems:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-nez v1, :cond_1

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->b()V

    return-void

    :cond_1
    :try_start_1
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    move-object v0, v1

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;

    move-object v2, v0

    iget v2, v2, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->index:I

    if-ltz v2, :cond_0

    iget v2, v1, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    iget v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mMaxItemValue:I

    if-le v2, v5, :cond_0

    iget v1, v1, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mMaxItemValue:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v1

    monitor-exit v3

    throw v1
.end method

.method protected final onRectChanged(Landroid/graphics/RectF;)V
    .locals 0

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->onRectChanged(Landroid/graphics/RectF;)V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->b()V

    return-void
.end method
