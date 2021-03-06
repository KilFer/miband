.class public Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;
.super Lcn/com/smartdevices/bracelet/chart/base/BaseChart;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcn/com/smartdevices/bracelet/chart/base/BaseChart",
        "<",
        "Lcn/com/smartdevices/bracelet/chart/base/Chart$Item;",
        ">;"
    }
.end annotation


# instance fields
.field public index:I

.field public needDraw:Z

.field public scope:I

.field public value:I


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/base/BaseChart;-><init>()V

    return-void
.end method


# virtual methods
.method protected draw(Landroid/graphics/Canvas;Landroid/graphics/RectF;F)V
    .locals 6

    const/high16 v4, 0x40000000

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->needDraw:Z

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget v0, p2, Landroid/graphics/RectF;->left:F

    invoke-virtual {p2}, Landroid/graphics/RectF;->width()F

    move-result v1

    div-float/2addr v1, v4

    add-float/2addr v1, v0

    iget v2, p2, Landroid/graphics/RectF;->bottom:F

    iget v0, p2, Landroid/graphics/RectF;->left:F

    invoke-virtual {p2}, Landroid/graphics/RectF;->width()F

    move-result v3

    div-float/2addr v3, v4

    add-float/2addr v3, v0

    iget v0, p2, Landroid/graphics/RectF;->bottom:F

    invoke-virtual {p2}, Landroid/graphics/RectF;->height()F

    move-result v4

    mul-float/2addr v4, p3

    sub-float v4, v0, v4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->mRenderer:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/base/Renderer;->paint:Landroid/graphics/Paint;

    invoke-virtual {p2}, Landroid/graphics/RectF;->width()F

    move-result v5

    invoke-virtual {v0, v5}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->mRenderer:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    iget-object v5, v0, Lcn/com/smartdevices/bracelet/chart/base/Renderer;->paint:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    goto :goto_0
.end method

.method protected draw(Landroid/graphics/Canvas;Landroid/graphics/RectF;FZ)V
    .locals 6

    const/high16 v4, 0x40000000

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->needDraw:Z

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    if-eqz p4, :cond_1

    iget v0, p2, Landroid/graphics/RectF;->left:F

    invoke-virtual {p2}, Landroid/graphics/RectF;->width()F

    move-result v1

    div-float/2addr v1, v4

    add-float/2addr v1, v0

    iget v2, p2, Landroid/graphics/RectF;->top:F

    iget v0, p2, Landroid/graphics/RectF;->left:F

    invoke-virtual {p2}, Landroid/graphics/RectF;->width()F

    move-result v3

    div-float/2addr v3, v4

    add-float/2addr v3, v0

    iget v0, p2, Landroid/graphics/RectF;->top:F

    invoke-virtual {p2}, Landroid/graphics/RectF;->height()F

    move-result v4

    mul-float/2addr v4, p3

    add-float/2addr v4, v0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->mRenderer:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/base/Renderer;->paint:Landroid/graphics/Paint;

    invoke-virtual {p2}, Landroid/graphics/RectF;->width()F

    move-result v5

    invoke-virtual {v0, v5}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->mRenderer:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    iget-object v5, v0, Lcn/com/smartdevices/bracelet/chart/base/Renderer;->paint:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    goto :goto_0

    :cond_1
    invoke-virtual {p0, p1, p2, p3}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->draw(Landroid/graphics/Canvas;Landroid/graphics/RectF;F)V

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Value : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " , "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Index : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->index:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " , "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Scope : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->scope:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " , "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "NeedDrow : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-boolean v2, p0, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->needDraw:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
