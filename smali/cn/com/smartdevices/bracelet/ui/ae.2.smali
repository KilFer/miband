.class final Lcn/com/smartdevices/bracelet/ui/ae;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/ui/FwUpgradeActivity;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/FwUpgradeActivity;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/ae;->a:Lcn/com/smartdevices/bracelet/ui/FwUpgradeActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/ae;->a:Lcn/com/smartdevices/bracelet/ui/FwUpgradeActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/FwUpgradeActivity;->f(Lcn/com/smartdevices/bracelet/ui/FwUpgradeActivity;)Landroid/widget/TextView;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    return-void
.end method

.method public final onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0

    return-void
.end method

.method public final onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0

    return-void
.end method
