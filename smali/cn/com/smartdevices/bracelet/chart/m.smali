.class final Lcn/com/smartdevices/bracelet/chart/m;
.super Lcn/com/smartdevices/bracelet/chart/base/BarChart$XAxis;


# instance fields
.field private a:Landroid/graphics/Paint;

.field private b:Landroid/graphics/Paint;

.field private synthetic c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;


# direct methods
.method public constructor <init>(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)V
    .locals 3

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$XAxis;-><init>()V

    new-instance v0, Landroid/text/TextPaint;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/text/TextPaint;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/m;->a:Landroid/graphics/Paint;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/m;->a:Landroid/graphics/Paint;

    const/high16 v1, 0x66000000

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/m;->a:Landroid/graphics/Paint;

    const/high16 v1, 0x41100000

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/m;->mDensity:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/m;->b:Landroid/graphics/Paint;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/m;->b:Landroid/graphics/Paint;

    const v1, -0xd0d0e

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    return-void
.end method

.method private a(Landroid/graphics/Canvas;Landroid/graphics/RectF;FFF)V
    .locals 12

    const/16 v1, 0xff

    const/16 v0, 0x80

    const/high16 v2, -0x40800000

    cmpl-float v2, p4, v2

    if-lez v2, :cond_0

    const/high16 v0, 0x437f0000

    mul-float/2addr v0, p3

    float-to-int v1, v0

    const/high16 v0, 0x43000000

    mul-float/2addr v0, p3

    float-to-int v0, v0

    :cond_0
    const/high16 v2, -0x40800000

    cmpl-float v2, p5, v2

    if-lez v2, :cond_1

    const/high16 v0, 0x3f800000

    sub-float/2addr v0, p3

    const/high16 v1, 0x437f0000

    mul-float/2addr v0, v1

    float-to-int v1, v0

    const/high16 v0, 0x3f800000

    sub-float/2addr v0, p3

    const/high16 v2, 0x43000000

    mul-float/2addr v0, v2

    float-to-int v0, v0

    :cond_1
    shl-int/lit8 v1, v1, 0x18

    const v2, 0x799ed

    or-int/2addr v1, v2

    shl-int/lit8 v2, v0, 0x18

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->b(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)Ljava/util/List;

    move-result-object v4

    monitor-enter v4

    :try_start_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->b(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_2
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-nez v0, :cond_3

    monitor-exit v4

    return-void

    :cond_3
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;

    iget v6, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;->a:I

    iget v7, p0, Lcn/com/smartdevices/bracelet/chart/m;->offset:I

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->c(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)I

    move-result v8

    add-int/lit8 v8, v8, -0x1

    div-int/lit8 v8, v8, 0x2

    add-int/2addr v7, v8

    add-int/lit8 v7, v7, 0x1

    if-gt v6, v7, :cond_2

    iget v6, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;->a:I

    iget v7, p0, Lcn/com/smartdevices/bracelet/chart/m;->offset:I

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->c(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)I

    move-result v8

    add-int/lit8 v8, v8, -0x1

    div-int/lit8 v8, v8, 0x2

    add-int/2addr v7, v8

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->c(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)I

    move-result v8

    sub-int/2addr v7, v8

    if-lt v6, v7, :cond_2

    iget v6, p2, Landroid/graphics/RectF;->right:F

    iget v7, p0, Lcn/com/smartdevices/bracelet/chart/m;->mPaddingRight:F

    sub-float/2addr v6, v7

    iget v7, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;->a:I

    add-int/lit8 v7, v7, -0x1

    int-to-float v7, v7

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->a(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)F

    move-result v8

    mul-float/2addr v7, v8

    add-float/2addr v6, v7

    iget v7, p0, Lcn/com/smartdevices/bracelet/chart/m;->mScroll:F

    add-float/2addr v6, v7

    iget-object v7, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v7}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->c(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)I

    move-result v7

    add-int/lit8 v7, v7, -0x1

    div-int/lit8 v7, v7, 0x2

    int-to-float v7, v7

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->a(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)F

    move-result v8

    mul-float/2addr v7, v8

    sub-float/2addr v6, v7

    iget v7, p2, Landroid/graphics/RectF;->top:F

    iget v8, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;->a:I

    iget v9, p0, Lcn/com/smartdevices/bracelet/chart/m;->offset:I

    if-ne v8, v9, :cond_4

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->a:Landroid/graphics/Paint;

    invoke-virtual {v8, v1}, Landroid/graphics/Paint;->setColor(I)V

    :goto_1
    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->a:Landroid/graphics/Paint;

    iget-object v9, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;->b:Ljava/lang/String;

    const/4 v10, 0x0

    iget-object v11, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;->b:Ljava/lang/String;

    invoke-virtual {v11}, Ljava/lang/String;->length()I

    move-result v11

    invoke-virtual {v8, v9, v10, v11, v3}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->a(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)F

    move-result v8

    invoke-virtual {v3}, Landroid/graphics/Rect;->width()I

    move-result v9

    int-to-float v9, v9

    sub-float/2addr v8, v9

    const/high16 v9, 0x40000000

    div-float/2addr v8, v9

    add-float/2addr v6, v8

    iget v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->stroke:I

    invoke-virtual {v3}, Landroid/graphics/Rect;->height()I

    move-result v9

    add-int/2addr v8, v9

    int-to-float v8, v8

    const/high16 v9, 0x40000000

    div-float/2addr v8, v9

    add-float/2addr v7, v8

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;->b:Ljava/lang/String;

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->a:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v6, v7, v8}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto/16 :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v4

    throw v0

    :cond_4
    :try_start_1
    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->a:Landroid/graphics/Paint;

    invoke-virtual {v8, v2}, Landroid/graphics/Paint;->setColor(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1
.end method

.method private b(Landroid/graphics/Canvas;Landroid/graphics/RectF;FFF)V
    .locals 12

    const/16 v1, 0xff

    const/16 v0, 0x80

    const/high16 v2, -0x40800000

    cmpl-float v2, p4, v2

    if-lez v2, :cond_0

    const/high16 v0, 0x437f0000

    mul-float/2addr v0, p3

    float-to-int v1, v0

    const/high16 v0, 0x43000000

    mul-float/2addr v0, p3

    float-to-int v0, v0

    :cond_0
    const/high16 v2, -0x40800000

    cmpl-float v2, p5, v2

    if-lez v2, :cond_1

    const/high16 v0, 0x3f800000

    sub-float/2addr v0, p3

    const/high16 v1, 0x437f0000

    mul-float/2addr v0, v1

    float-to-int v1, v0

    const/high16 v0, 0x3f800000

    sub-float/2addr v0, p3

    const/high16 v2, 0x43000000

    mul-float/2addr v0, v2

    float-to-int v0, v0

    :cond_1
    shl-int/lit8 v1, v1, 0x18

    const v2, 0x799ed

    or-int/2addr v1, v2

    shl-int/lit8 v2, v0, 0x18

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->b(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)Ljava/util/List;

    move-result-object v4

    monitor-enter v4

    :try_start_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->b(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_2
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-nez v0, :cond_3

    monitor-exit v4

    return-void

    :cond_3
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;

    iget v6, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;->a:I

    iget v7, p0, Lcn/com/smartdevices/bracelet/chart/m;->offset:I

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->c(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)I

    move-result v8

    add-int/lit8 v8, v8, -0x1

    div-int/lit8 v8, v8, 0x2

    add-int/2addr v7, v8

    add-int/lit8 v7, v7, 0x1

    if-gt v6, v7, :cond_2

    iget v6, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;->a:I

    iget v7, p0, Lcn/com/smartdevices/bracelet/chart/m;->offset:I

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->c(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)I

    move-result v8

    add-int/lit8 v8, v8, -0x1

    div-int/lit8 v8, v8, 0x2

    add-int/2addr v7, v8

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->c(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)I

    move-result v8

    sub-int/2addr v7, v8

    if-lt v6, v7, :cond_2

    iget v6, p2, Landroid/graphics/RectF;->right:F

    iget v7, p0, Lcn/com/smartdevices/bracelet/chart/m;->mPaddingRight:F

    sub-float/2addr v6, v7

    iget v7, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;->a:I

    add-int/lit8 v7, v7, -0x1

    int-to-float v7, v7

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->a(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)F

    move-result v8

    mul-float/2addr v7, v8

    add-float/2addr v6, v7

    iget v7, p0, Lcn/com/smartdevices/bracelet/chart/m;->mScroll:F

    add-float/2addr v6, v7

    iget-object v7, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v7}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->c(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)I

    move-result v7

    add-int/lit8 v7, v7, -0x1

    div-int/lit8 v7, v7, 0x2

    int-to-float v7, v7

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->a(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)F

    move-result v8

    mul-float/2addr v7, v8

    sub-float/2addr v6, v7

    iget v7, p2, Landroid/graphics/RectF;->top:F

    iget v8, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;->a:I

    iget v9, p0, Lcn/com/smartdevices/bracelet/chart/m;->offset:I

    if-ne v8, v9, :cond_4

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->a:Landroid/graphics/Paint;

    invoke-virtual {v8, v1}, Landroid/graphics/Paint;->setColor(I)V

    :goto_1
    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->a:Landroid/graphics/Paint;

    iget-object v9, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;->b:Ljava/lang/String;

    const/4 v10, 0x0

    iget-object v11, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;->b:Ljava/lang/String;

    invoke-virtual {v11}, Ljava/lang/String;->length()I

    move-result v11

    invoke-virtual {v8, v9, v10, v11, v3}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->a(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)F

    move-result v8

    invoke-virtual {v3}, Landroid/graphics/Rect;->width()I

    move-result v9

    int-to-float v9, v9

    sub-float/2addr v8, v9

    const/high16 v9, 0x40000000

    div-float/2addr v8, v9

    add-float/2addr v6, v8

    iget v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->stroke:I

    invoke-virtual {v3}, Landroid/graphics/Rect;->height()I

    move-result v9

    add-int/2addr v8, v9

    int-to-float v8, v8

    const/high16 v9, 0x40000000

    div-float/2addr v8, v9

    add-float/2addr v7, v8

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$DateItem;->b:Ljava/lang/String;

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->a:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v6, v7, v8}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto/16 :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v4

    throw v0

    :cond_4
    :try_start_1
    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/m;->a:Landroid/graphics/Paint;

    invoke-virtual {v8, v2}, Landroid/graphics/Paint;->setColor(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1
.end method


# virtual methods
.method public final a(Landroid/graphics/Canvas;FFF)V
    .locals 6

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/m;->mRect:Landroid/graphics/RectF;

    move-object v0, p0

    move-object v1, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lcn/com/smartdevices/bracelet/chart/m;->b(Landroid/graphics/Canvas;Landroid/graphics/RectF;FFF)V

    return-void
.end method

.method protected final doScroll(F)V
    .locals 3

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/m;->mScroll:F

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/m;->c:Lcn/com/smartdevices/bracelet/chart/StatisticChart;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChart;->a(Lcn/com/smartdevices/bracelet/chart/StatisticChart;)F

    move-result v1

    div-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    neg-int v0, v0

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/m;->offset:I

    const-string v0, "Chart.StatisticChart"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "DateLine Offset : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/m;->offset:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
