.class final Lcn/com/smartdevices/bracelet/chart/k;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/animation/Animator$AnimatorListener;


# instance fields
.field private synthetic a:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/chart/LinePieChartView;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/k;->a:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onAnimationCancel(Landroid/animation/Animator;)V
    .locals 0

    return-void
.end method

.method public final onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/k;->a:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/LinePieChartView;->a(Lcn/com/smartdevices/bracelet/chart/LinePieChartView;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/LinePieChart;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/LinePieChart;->dismissLoading()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/k;->a:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/LinePieChartView;->a(Lcn/com/smartdevices/bracelet/chart/LinePieChartView;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/LinePieChart;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/LinePieChart;->rotate(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/k;->a:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/LinePieChartView;->postInvalidateOnAnimation()V

    return-void
.end method

.method public final onAnimationRepeat(Landroid/animation/Animator;)V
    .locals 0

    return-void
.end method

.method public final onAnimationStart(Landroid/animation/Animator;)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/k;->a:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/LinePieChartView;->a(Lcn/com/smartdevices/bracelet/chart/LinePieChartView;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/LinePieChart;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/LinePieChart;->showLoading()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/k;->a:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/LinePieChartView;->a(Lcn/com/smartdevices/bracelet/chart/LinePieChartView;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/LinePieChart;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/LinePieChart;->rotate(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/k;->a:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/LinePieChartView;->postInvalidateOnAnimation()V

    return-void
.end method
