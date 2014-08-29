.class final Lcn/com/smartdevices/bracelet/view/l;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/animation/Animator$AnimatorListener;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/view/DynamicView;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/view/DynamicView;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/view/l;->a:Lcn/com/smartdevices/bracelet/view/DynamicView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAnimationCancel(Landroid/animation/Animator;)V
    .locals 0

    return-void
.end method

.method public final onAnimationEnd(Landroid/animation/Animator;)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/view/l;->a:Lcn/com/smartdevices/bracelet/view/DynamicView;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/view/DynamicView;->f(Lcn/com/smartdevices/bracelet/view/DynamicView;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/view/l;->a:Lcn/com/smartdevices/bracelet/view/DynamicView;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/view/DynamicView;->g(Lcn/com/smartdevices/bracelet/view/DynamicView;)V

    return-void
.end method

.method public final onAnimationRepeat(Landroid/animation/Animator;)V
    .locals 0

    return-void
.end method

.method public final onAnimationStart(Landroid/animation/Animator;)V
    .locals 3

    const/4 v2, 0x0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/view/l;->a:Lcn/com/smartdevices/bracelet/view/DynamicView;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/view/DynamicView;->e(Lcn/com/smartdevices/bracelet/view/DynamicView;)Landroid/view/View;

    move-result-object v0

    const/high16 v1, -0x3d4c0000

    invoke-virtual {v0, v1}, Landroid/view/View;->setRotationY(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/view/l;->a:Lcn/com/smartdevices/bracelet/view/DynamicView;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/view/DynamicView;->e(Lcn/com/smartdevices/bracelet/view/DynamicView;)Landroid/view/View;

    move-result-object v0

    const/high16 v1, 0x43960000

    invoke-virtual {v0, v1}, Landroid/view/View;->setTranslationY(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/view/l;->a:Lcn/com/smartdevices/bracelet/view/DynamicView;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/view/DynamicView;->e(Lcn/com/smartdevices/bracelet/view/DynamicView;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setAlpha(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/view/l;->a:Lcn/com/smartdevices/bracelet/view/DynamicView;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/view/DynamicView;->b(Lcn/com/smartdevices/bracelet/view/DynamicView;)Landroid/view/ViewGroup;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setAlpha(F)V

    return-void
.end method
