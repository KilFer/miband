.class Lcn/com/smartdevices/bracelet/chart/deprecated/b;
.super Lcn/com/smartdevices/bracelet/chart/base/BarChart;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;


# direct methods
.method private constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/base/BarChart;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;B)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)V

    return-void
.end method


# virtual methods
.method public notifyChanged()V
    .locals 1

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->mNeedRealign:Z

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/chart/base/BarChart;->notifyChanged()V

    return-void
.end method

.method protected realignItems(Landroid/graphics/RectF;Ljava/util/List;)V
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/RectF;",
            "Ljava/util/List",
            "<+",
            "Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;",
            ">;)V"
        }
    .end annotation

    const/4 v11, 0x1

    const/high16 v10, 0x3f800000

    const/high16 v9, 0x42700000

    const/4 v8, 0x0

    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_2
    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-nez v0, :cond_3

    iput-boolean v8, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->mNeedRealign:Z

    goto :goto_0

    :cond_3
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->getRect()Landroid/graphics/RectF;

    move-result-object v0

    if-nez v0, :cond_8

    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->setRect(Landroid/graphics/RectF;)V

    move-object v2, v0

    :goto_2
    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->mNeedRealign:Z

    if-nez v0, :cond_4

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->getRect()Landroid/graphics/RectF;

    move-result-object v0

    if-nez v0, :cond_9

    :cond_4
    invoke-virtual {p0, p1, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->itemWidth(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F

    move-result v3

    invoke-virtual {p0, p1, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->itemHeight(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F

    move-result v0

    move v12, v0

    move v0, v3

    move v3, v12

    :goto_3
    iget v4, p1, Landroid/graphics/RectF;->top:F

    iget v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->mItemPadding:F

    add-float/2addr v4, v5

    iget v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->mPaddingTop:F

    add-float/2addr v4, v5

    iput v4, v2, Landroid/graphics/RectF;->top:F

    iget v4, v2, Landroid/graphics/RectF;->top:F

    add-float/2addr v4, v3

    iput v4, v2, Landroid/graphics/RectF;->bottom:F

    iget-boolean v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->mMirrored:Z

    if-nez v4, :cond_a

    iget v4, p1, Landroid/graphics/RectF;->left:F

    iget v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->mPaddingLeft:F

    add-float/2addr v4, v5

    iput v4, v2, Landroid/graphics/RectF;->left:F

    iget v4, v2, Landroid/graphics/RectF;->left:F

    add-float/2addr v0, v4

    iput v0, v2, Landroid/graphics/RectF;->right:F

    :goto_4
    instance-of v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/c;

    if-nez v0, :cond_6

    move-object v0, v1

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;

    iput-boolean v11, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->a:Z

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v4}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)I

    move-result v4

    div-int/lit8 v5, v4, 0x3c

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v4}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)I

    move-result v4

    rem-int/lit8 v4, v4, 0x3c

    iget-object v7, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v7}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)I

    move-result v7

    if-gez v7, :cond_5

    add-int/lit8 v5, v5, -0x1

    add-int/lit8 v4, v4, 0x3c

    :cond_5
    iget v7, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->index:I

    if-ne v7, v5, :cond_b

    iget v5, v2, Landroid/graphics/RectF;->top:F

    int-to-float v4, v4

    div-float/2addr v4, v9

    mul-float/2addr v3, v4

    add-float/2addr v3, v5

    sub-float/2addr v3, v10

    iput v3, v2, Landroid/graphics/RectF;->bottom:F

    iput-boolean v8, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->a:Z

    :cond_6
    :goto_5
    invoke-virtual {p0, p1, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->itemOffsetX(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F

    move-result v0

    invoke-virtual {p0, p1, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->itemOffsetY(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F

    move-result v3

    invoke-virtual {v2, v0, v3}, Landroid/graphics/RectF;->offset(FF)V

    iput-boolean v11, v1, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->needDraw:Z

    iget v0, v2, Landroid/graphics/RectF;->bottom:F

    iget v3, p1, Landroid/graphics/RectF;->top:F

    cmpg-float v0, v0, v3

    if-ltz v0, :cond_7

    iget v0, v2, Landroid/graphics/RectF;->top:F

    iget v2, p1, Landroid/graphics/RectF;->bottom:F

    cmpl-float v0, v0, v2

    if-lez v0, :cond_2

    :cond_7
    iput-boolean v8, v1, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->needDraw:Z

    goto/16 :goto_1

    :cond_8
    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->getRect()Landroid/graphics/RectF;

    move-result-object v0

    move-object v2, v0

    goto/16 :goto_2

    :cond_9
    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->getRect()Landroid/graphics/RectF;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/RectF;->width()F

    move-result v3

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->getRect()Landroid/graphics/RectF;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/RectF;->height()F

    move-result v0

    move v12, v0

    move v0, v3

    move v3, v12

    goto/16 :goto_3

    :cond_a
    iget v4, p1, Landroid/graphics/RectF;->right:F

    iget v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->mPaddingRight:F

    sub-float/2addr v4, v5

    iput v4, v2, Landroid/graphics/RectF;->right:F

    iget v4, v2, Landroid/graphics/RectF;->right:F

    sub-float v0, v4, v0

    iput v0, v2, Landroid/graphics/RectF;->left:F

    goto :goto_4

    :cond_b
    iget v4, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->index:I

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v5}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->c(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)I

    move-result v5

    div-int/lit8 v5, v5, 0x3c

    if-ne v4, v5, :cond_6

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v4}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->c(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)I

    move-result v4

    int-to-float v4, v4

    rem-float/2addr v4, v9

    div-float/2addr v4, v9

    mul-float/2addr v3, v4

    add-float/2addr v3, v10

    iput v3, v2, Landroid/graphics/RectF;->top:F

    iput-boolean v8, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->a:Z

    goto :goto_5
.end method
