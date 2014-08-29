.class final Lcn/com/smartdevices/bracelet/chart/deprecated/a;
.super Lcn/com/smartdevices/bracelet/chart/base/BarChart$YAxis;


# static fields
.field private static a:F = 24.0f

.field private static b:F = 1440.0f


# instance fields
.field private c:I

.field private d:F

.field private e:Landroid/graphics/Paint;

.field private f:Landroid/graphics/Paint;

.field private g:Landroid/graphics/Paint;

.field private h:Landroid/graphics/RectF;

.field private synthetic i:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;


# direct methods
.method public constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)V
    .locals 4

    const/4 v3, 0x1

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->i:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$YAxis;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->c:I

    const/16 v0, 0x18

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->value:I

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->c:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->offset:I

    new-instance v0, Landroid/text/TextPaint;

    invoke-direct {v0, v3}, Landroid/text/TextPaint;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->e:Landroid/graphics/Paint;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->e:Landroid/graphics/Paint;

    const v1, 0x4dffffff

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->e:Landroid/graphics/Paint;

    const/high16 v1, 0x41100000

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->mDensity:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0, v3}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->f:Landroid/graphics/Paint;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->f:Landroid/graphics/Paint;

    const v1, 0x1affffff

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0, v3}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->g:Landroid/graphics/Paint;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->g:Landroid/graphics/Paint;

    const v1, 0x33ffffff

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->g:Landroid/graphics/Paint;

    const/high16 v1, 0x3f800000

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->g:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/chart/deprecated/a;I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->c:I

    return-void
.end method

.method private d()F
    .locals 2

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d:F

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->value:I

    int-to-float v1, v1

    mul-float/2addr v0, v1

    return v0
.end method

.method private e()F
    .locals 3

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->offset:I

    neg-int v0, v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->value:I

    rem-int/2addr v0, v1

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->f()Z

    move-result v1

    if-eqz v1, :cond_0

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->offset:I

    neg-int v0, v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->value:I

    rem-int/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->value:I

    add-int/2addr v0, v1

    :cond_0
    int-to-float v0, v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d:F

    mul-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->mScroll:F

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d:F

    rem-float/2addr v1, v2

    add-float/2addr v0, v1

    return v0
.end method

.method private f()Z
    .locals 4

    const/4 v3, 0x0

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->mScroll:F

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->c:I

    int-to-float v1, v1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d:F

    mul-float/2addr v1, v2

    sub-float/2addr v0, v1

    cmpg-float v0, v0, v3

    if-gez v0, :cond_0

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->mScroll:F

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->c:I

    int-to-float v1, v1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d:F

    mul-float/2addr v1, v2

    sub-float/2addr v0, v1

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d()F

    move-result v1

    rem-float/2addr v0, v1

    cmpg-float v0, v0, v3

    if-gez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private g()I
    .locals 2

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->offset:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->value:I

    div-int/2addr v0, v1

    return v0
.end method

.method private h()F
    .locals 3

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->g()I

    move-result v0

    neg-int v0, v0

    int-to-float v0, v0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d()F

    move-result v1

    mul-float/2addr v0, v1

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->f()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->g()I

    move-result v0

    neg-int v0, v0

    int-to-float v0, v0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d()F

    move-result v1

    mul-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d:F

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->c:I

    int-to-float v2, v2

    mul-float/2addr v1, v2

    add-float/2addr v0, v1

    :cond_0
    return v0
.end method


# virtual methods
.method public final a()V
    .locals 2

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->c:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->offset:I

    sub-int/2addr v0, v1

    int-to-float v0, v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d:F

    mul-float/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->mScroll:F

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->i:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->mScroll:F

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;F)V

    return-void
.end method

.method public final b()F
    .locals 3

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->mScroll:F

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->c:I

    int-to-float v1, v1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d:F

    mul-float/2addr v1, v2

    sub-float/2addr v0, v1

    return v0
.end method

.method public final c()F
    .locals 2

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->c:I

    int-to-float v0, v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d:F

    mul-float/2addr v0, v1

    return v0
.end method

.method protected final doScroll(F)V
    .locals 2

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->mScroll:F

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d:F

    div-float/2addr v0, v1

    float-to-int v0, v0

    neg-int v0, v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->c:I

    add-int/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->offset:I

    return-void
.end method

.method protected final draw(Landroid/graphics/Canvas;Landroid/graphics/RectF;F)V
    .locals 11

    const/4 v3, 0x0

    const/4 v1, 0x0

    const/high16 v10, 0x40000000

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->h:Landroid/graphics/RectF;

    iget v2, p2, Landroid/graphics/RectF;->bottom:F

    iput v2, v0, Landroid/graphics/RectF;->bottom:F

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->h:Landroid/graphics/RectF;

    iget v2, v0, Landroid/graphics/RectF;->bottom:F

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->i:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v4}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)F

    move-result v4

    sub-float/2addr v2, v4

    iput v2, v0, Landroid/graphics/RectF;->bottom:F

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->h:Landroid/graphics/RectF;

    iget v2, v0, Landroid/graphics/RectF;->bottom:F

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->b()F

    move-result v4

    add-float/2addr v2, v4

    iput v2, v0, Landroid/graphics/RectF;->bottom:F

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->h:Landroid/graphics/RectF;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->h:Landroid/graphics/RectF;

    invoke-virtual {v2}, Landroid/graphics/RectF;->width()F

    move-result v2

    div-float/2addr v2, v10

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->h:Landroid/graphics/RectF;

    invoke-virtual {v4}, Landroid/graphics/RectF;->width()F

    move-result v4

    div-float/2addr v4, v10

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->f:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v2, v4, v5}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->h:Landroid/graphics/RectF;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->h:Landroid/graphics/RectF;

    invoke-virtual {v2}, Landroid/graphics/RectF;->width()F

    move-result v2

    div-float/2addr v2, v10

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->h:Landroid/graphics/RectF;

    invoke-virtual {v4}, Landroid/graphics/RectF;->width()F

    move-result v4

    div-float/2addr v4, v10

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->g:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v2, v4, v5}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    new-instance v5, Landroid/graphics/Rect;

    invoke-direct {v5}, Landroid/graphics/Rect;-><init>()V

    move v4, v1

    :goto_0
    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->value:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->offset:I

    sub-int/2addr v0, v2

    if-lt v4, v0, :cond_0

    return-void

    :cond_0
    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->offset:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->value:I

    rem-int/2addr v0, v2

    add-int/2addr v0, v4

    if-gez v0, :cond_1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->value:I

    add-int/2addr v0, v2

    :cond_1
    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->value:I

    if-le v0, v2, :cond_2

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->value:I

    rem-int/2addr v0, v2

    :cond_2
    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->value:I

    if-ne v0, v2, :cond_3

    move v0, v1

    :cond_3
    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->mScroll:F

    iget v6, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d:F

    div-float/2addr v2, v6

    const/high16 v6, 0x3f800000

    rem-float/2addr v2, v6

    cmpl-float v2, v2, v3

    if-nez v2, :cond_4

    move v2, v3

    :goto_1
    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    iget-object v6, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->e:Landroid/graphics/Paint;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v7

    invoke-virtual {v6, v0, v1, v7, v5}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    iget v6, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->stroke:I

    invoke-virtual {v5}, Landroid/graphics/Rect;->width()I

    move-result v7

    sub-int/2addr v6, v7

    int-to-float v6, v6

    div-float/2addr v6, v10

    iget v7, p2, Landroid/graphics/RectF;->left:F

    add-float/2addr v6, v7

    int-to-float v7, v4

    iget v8, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d:F

    mul-float/2addr v7, v8

    iget v8, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d:F

    invoke-virtual {v5}, Landroid/graphics/Rect;->height()I

    move-result v9

    int-to-float v9, v9

    add-float/2addr v8, v9

    div-float/2addr v8, v10

    add-float/2addr v7, v8

    iget v8, p2, Landroid/graphics/RectF;->top:F

    add-float/2addr v7, v8

    iget v8, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->mPaddingTop:F

    add-float/2addr v7, v8

    add-float/2addr v2, v7

    iget-object v7, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->e:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v6, v2, v7}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    add-int/lit8 v0, v4, 0x1

    move v4, v0

    goto :goto_0

    :cond_4
    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->mScroll:F

    iget v6, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d:F

    rem-float/2addr v2, v6

    goto :goto_1
.end method

.method protected final onRectChanged(Landroid/graphics/RectF;)V
    .locals 3

    invoke-virtual {p1}, Landroid/graphics/RectF;->height()F

    move-result v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->mPaddingTop:F

    sub-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->mPaddingBottom:F

    sub-float/2addr v0, v1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->i:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)F

    move-result v1

    sub-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->value:I

    int-to-float v1, v1

    div-float/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->d:F

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->a()V

    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0, p1}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->h:Landroid/graphics/RectF;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->h:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->width()F

    move-result v0

    const/high16 v1, 0x40000000

    div-float/2addr v0, v1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/a;->h:Landroid/graphics/RectF;

    iget v2, v1, Landroid/graphics/RectF;->top:F

    sub-float v0, v2, v0

    iput v0, v1, Landroid/graphics/RectF;->top:F

    return-void
.end method
