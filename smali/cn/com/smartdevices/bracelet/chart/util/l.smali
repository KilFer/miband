.class final Lcn/com/smartdevices/bracelet/chart/util/l;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# instance fields
.field private final synthetic a:I

.field private final synthetic b:I

.field private final synthetic c:I

.field private final synthetic d:I

.field private final synthetic e:I

.field private final synthetic f:I

.field private final synthetic g:[Landroid/view/View;


# direct methods
.method constructor <init>(IIIIII[Landroid/view/View;)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/chart/util/l;->a:I

    iput p2, p0, Lcn/com/smartdevices/bracelet/chart/util/l;->b:I

    iput p3, p0, Lcn/com/smartdevices/bracelet/chart/util/l;->c:I

    iput p4, p0, Lcn/com/smartdevices/bracelet/chart/util/l;->d:I

    iput p5, p0, Lcn/com/smartdevices/bracelet/chart/util/l;->e:I

    iput p6, p0, Lcn/com/smartdevices/bracelet/chart/util/l;->f:I

    iput-object p7, p0, Lcn/com/smartdevices/bracelet/chart/util/l;->g:[Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 6

    const/high16 v5, 0x3f800000

    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/util/l;->a:I

    int-to-float v1, v1

    mul-float/2addr v1, v0

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/util/l;->b:I

    int-to-float v2, v2

    sub-float v3, v5, v0

    mul-float/2addr v2, v3

    add-float/2addr v1, v2

    float-to-int v1, v1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/util/l;->c:I

    int-to-float v2, v2

    mul-float/2addr v2, v0

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/util/l;->d:I

    int-to-float v3, v3

    sub-float v4, v5, v0

    mul-float/2addr v3, v4

    add-float/2addr v2, v3

    float-to-int v2, v2

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/util/l;->e:I

    int-to-float v3, v3

    mul-float/2addr v3, v0

    iget v4, p0, Lcn/com/smartdevices/bracelet/chart/util/l;->f:I

    int-to-float v4, v4

    sub-float v0, v5, v0

    mul-float/2addr v0, v4

    add-float/2addr v0, v3

    float-to-int v0, v0

    invoke-static {v1, v2, v0}, Landroid/graphics/Color;->rgb(III)I

    move-result v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/util/l;->g:[Landroid/view/View;

    array-length v3, v2

    const/4 v0, 0x0

    :goto_0
    if-lt v0, v3, :cond_0

    return-void

    :cond_0
    aget-object v4, v2, v0

    invoke-virtual {v4, v1}, Landroid/view/View;->setBackgroundColor(I)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method
