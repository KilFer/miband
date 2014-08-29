.class final Lcn/com/smartdevices/bracelet/view/n;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/view/DynamicView$FlowBgView;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/view/DynamicView$FlowBgView;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/view/n;->a:Lcn/com/smartdevices/bracelet/view/DynamicView$FlowBgView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 4

    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/view/n;->a:Lcn/com/smartdevices/bracelet/view/DynamicView$FlowBgView;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/view/DynamicView$FlowBgView;->a(Lcn/com/smartdevices/bracelet/view/DynamicView$FlowBgView;)F

    move-result v1

    const v2, 0x3e478084

    const v3, 0x3f4e1fdf

    mul-float/2addr v0, v3

    add-float/2addr v0, v2

    mul-float/2addr v0, v1

    float-to-int v0, v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/view/n;->a:Lcn/com/smartdevices/bracelet/view/DynamicView$FlowBgView;

    int-to-float v0, v0

    invoke-static {v1, v0}, Lcn/com/smartdevices/bracelet/view/DynamicView$FlowBgView;->a(Lcn/com/smartdevices/bracelet/view/DynamicView$FlowBgView;F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/view/n;->a:Lcn/com/smartdevices/bracelet/view/DynamicView$FlowBgView;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/compat/Compat;->postOnAnimationInvalidate(Landroid/view/View;)V

    return-void
.end method
