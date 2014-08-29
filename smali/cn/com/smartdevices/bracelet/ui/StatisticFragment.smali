.class public Lcn/com/smartdevices/bracelet/ui/StatisticFragment;
.super Landroid/app/Fragment;

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field private static final a:Ljava/lang/String; = "Statistic.Main"

.field private static final b:I = 0x1

.field private static final c:I = 0x10

.field private static final d:I = 0x100

.field private static final e:I = 0xb

.field private static final f:I = 0x7

.field private static final g:I = 0x5


# instance fields
.field private A:Z

.field private B:Ljava/lang/String;

.field private C:Ljava/lang/String;

.field private D:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;",
            ">;"
        }
    .end annotation
.end field

.field private E:Landroid/view/View;

.field private F:Landroid/widget/TextView;

.field private G:Landroid/widget/TextView;

.field private H:Landroid/view/View;

.field private I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

.field private J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

.field private K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

.field private L:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

.field private M:Landroid/widget/ImageButton;

.field private N:Landroid/view/View;

.field private O:Landroid/view/View;

.field private P:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private Q:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private R:Landroid/view/View;

.field private S:Landroid/view/View;

.field private T:I

.field private U:I

.field private V:Landroid/animation/Animator;

.field private W:Landroid/animation/Animator;

.field private X:Z

.field private Y:Z

.field private Z:Lcn/com/smartdevices/bracelet/model/SportDay;

.field private aa:I

.field private h:I

.field private i:I

.field private j:Lcn/com/smartdevices/bracelet/DataManager;

.field private k:Lcn/com/smartdevices/bracelet/model/SportDay;

.field private l:Lcn/com/smartdevices/bracelet/model/SportDay;

.field private m:Lcn/com/smartdevices/bracelet/model/SportDay;

.field private n:Lcn/com/smartdevices/bracelet/model/SportDay;

.field private o:Lcn/com/smartdevices/bracelet/model/SportDay;

.field private p:Lcn/com/smartdevices/bracelet/model/SportDay;

.field private q:I

.field private r:I

.field private s:I

.field private t:I

.field private u:I

.field private v:Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

.field private w:Lcn/com/smartdevices/bracelet/ui/bM;

.field private x:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcn/com/smartdevices/bracelet/ui/bM;",
            ">;"
        }
    .end annotation
.end field

.field private y:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

.field private z:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    return-void
.end method

.method static synthetic A(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Landroid/animation/Animator;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->W:Landroid/animation/Animator;

    return-object v0
.end method

.method static synthetic B(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Z
    .locals 1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->A:Z

    return v0
.end method

.method static synthetic C(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Lcn/com/smartdevices/bracelet/chart/StatisticChartView;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    return-object v0
.end method

.method static synthetic D(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Lcn/com/smartdevices/bracelet/chart/StatisticChartView;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    return-object v0
.end method

.method static synthetic E(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Landroid/view/View;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->N:Landroid/view/View;

    return-object v0
.end method

.method static synthetic F(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Landroid/view/View;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->O:Landroid/view/View;

    return-object v0
.end method

.method private a(IIJ)Landroid/animation/Animator;
    .locals 4

    const/4 v3, 0x0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    const-wide/16 v1, 0x145

    invoke-virtual {v0, v1, v2, v3, v3}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->animRefreshTo(JFF)Landroid/animation/Animator;

    move-result-object v0

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bI;

    const-wide/16 v2, 0x28a

    invoke-direct {v1, p0, v2, v3}, Lcn/com/smartdevices/bracelet/ui/bI;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;J)V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    new-instance v1, Landroid/view/animation/AccelerateInterpolator;

    const/high16 v2, 0x3fc00000

    invoke-direct {v1, v2}, Landroid/view/animation/AccelerateInterpolator;-><init>(F)V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->setFirstAnim(Landroid/animation/Animator;)V

    const/4 v0, 0x2

    new-array v1, v0, [Landroid/view/View;

    const/4 v0, 0x0

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->E:Landroid/view/View;

    aput-object v2, v1, v0

    const/4 v2, 0x1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    aput-object v0, v1, v2

    invoke-static {p1, p2, v1}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animColorTrans(II[Landroid/view/View;)Landroid/animation/Animator;

    move-result-object v0

    const-wide/16 v1, 0x1b0

    invoke-static {v0, v1, v2}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->addAnim(Landroid/animation/Animator;J)V

    invoke-static {}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->build()Landroid/animation/AnimatorSet;

    move-result-object v0

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bJ;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/ui/bJ;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    return-object v0
.end method

.method private a(Lcn/com/smartdevices/bracelet/chart/StatisticChartView;Lcn/com/smartdevices/bracelet/chart/StatisticChartView;IIIII)Landroid/animation/Animator;
    .locals 5

    const/high16 v3, 0x3f800000

    int-to-float v0, p3

    int-to-float v1, p4

    div-float/2addr v0, v1

    invoke-static {p1, v0, v3}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animScaleX(Landroid/view/View;FF)Landroid/animation/Animator;

    move-result-object v0

    int-to-float v1, p4

    int-to-float v2, p3

    div-float/2addr v1, v2

    invoke-static {p2, v3, v1}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animScaleX(Landroid/view/View;FF)Landroid/animation/Animator;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {p2, v3, v2}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animFade(Landroid/view/View;FF)Landroid/animation/Animator;

    move-result-object v2

    int-to-long v3, p7

    invoke-static {v0, v3, v4}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->setFirstAnim(Landroid/animation/Animator;J)V

    int-to-long v3, p7

    invoke-static {v1, v3, v4}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->addAnim(Landroid/animation/Animator;J)V

    int-to-long v0, p7

    invoke-static {v2, v0, v1}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->addAnim(Landroid/animation/Animator;J)V

    int-to-long v0, p7

    int-to-float v2, p5

    int-to-float v3, p6

    invoke-virtual {p1, v0, v1, v2, v3}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->animRefresh(JFF)Landroid/animation/Animator;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->addAnim(Landroid/animation/Animator;)V

    invoke-static {}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->build()Landroid/animation/AnimatorSet;

    move-result-object v0

    new-instance v1, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bK;

    invoke-direct {v1, p0, p1, p2}, Lcn/com/smartdevices/bracelet/ui/bK;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;Lcn/com/smartdevices/bracelet/chart/StatisticChartView;Lcn/com/smartdevices/bracelet/chart/StatisticChartView;)V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    return-object v0
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;Lcn/com/smartdevices/bracelet/chart/StatisticChartView;Lcn/com/smartdevices/bracelet/chart/StatisticChartView;IIIII)Landroid/animation/Animator;
    .locals 6

    const/high16 v4, 0x3f800000

    const/16 v0, 0x1c2

    int-to-float v1, p3

    int-to-float v2, p4

    div-float/2addr v1, v2

    invoke-static {p1, v1, v4}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animScaleX(Landroid/view/View;FF)Landroid/animation/Animator;

    move-result-object v1

    int-to-float v2, p4

    int-to-float v3, p3

    div-float/2addr v2, v3

    invoke-static {p2, v4, v2}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animScaleX(Landroid/view/View;FF)Landroid/animation/Animator;

    move-result-object v2

    const/4 v3, 0x0

    invoke-static {p2, v4, v3}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animFade(Landroid/view/View;FF)Landroid/animation/Animator;

    move-result-object v3

    int-to-long v4, v0

    invoke-static {v1, v4, v5}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->setFirstAnim(Landroid/animation/Animator;J)V

    int-to-long v4, v0

    invoke-static {v2, v4, v5}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->addAnim(Landroid/animation/Animator;J)V

    int-to-long v1, v0

    invoke-static {v3, v1, v2}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->addAnim(Landroid/animation/Animator;J)V

    int-to-long v0, v0

    int-to-float v2, p5

    int-to-float v3, p6

    invoke-virtual {p1, v0, v1, v2, v3}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->animRefresh(JFF)Landroid/animation/Animator;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->addAnim(Landroid/animation/Animator;)V

    invoke-static {}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->build()Landroid/animation/AnimatorSet;

    move-result-object v0

    new-instance v1, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bK;

    invoke-direct {v1, p0, p1, p2}, Lcn/com/smartdevices/bracelet/ui/bK;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;Lcn/com/smartdevices/bracelet/chart/StatisticChartView;Lcn/com/smartdevices/bracelet/chart/StatisticChartView;)V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    return-object v0
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Ljava/util/HashMap;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->D:Ljava/util/HashMap;

    return-object v0
.end method

.method private a()V
    .locals 4

    const/16 v3, 0x100

    const/16 v2, 0x10

    const/4 v1, 0x1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v0, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v0, v2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v0, v3}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, v2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, v3}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    return-void
.end method

.method private a(IIII)V
    .locals 6

    const/4 v1, 0x0

    const/16 v5, 0x10

    const/4 v4, 0x0

    const/4 v3, 0x1

    if-ne p1, v5, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v0, p3}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    move-object v2, v0

    :goto_0
    if-ne p2, v5, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v0, p4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    move-object v1, v0

    :cond_0
    :goto_1
    sparse-switch p4, :sswitch_data_0

    :goto_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->x:Landroid/util/SparseArray;

    invoke-virtual {v0, p4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/ui/bM;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->w:Lcn/com/smartdevices/bracelet/ui/bM;

    iput-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->S:Landroid/view/View;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->R:Landroid/view/View;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->y:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->z:Landroid/util/SparseArray;

    invoke-virtual {v0, p4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    invoke-virtual {v0, v2}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->setLoadCallback(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setDataLoader(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    sparse-switch p4, :sswitch_data_1

    :goto_3
    return-void

    :cond_1
    if-ne p1, v3, :cond_3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, p3}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    move-object v2, v0

    goto :goto_0

    :cond_2
    if-ne p2, v3, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, p4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    move-object v1, v0

    goto :goto_1

    :sswitch_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->O:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setEnabled(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->N:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setEnabled(Z)V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    const-string v3, "level"

    const-string v4, "EventStatisticLevelDaily"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    const-string v4, "EventStatistic"

    invoke-static {v3, v4, v0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->event(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_2

    :sswitch_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->O:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setEnabled(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->N:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setEnabled(Z)V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    const-string v3, "level"

    const-string v4, "EventStatisticLevelWeekly"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    const-string v4, "EventStatistic"

    invoke-static {v3, v4, v0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->event(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_2

    :sswitch_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->O:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setEnabled(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->N:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setEnabled(Z)V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    const-string v3, "level"

    const-string v4, "EventStatisticLevelMonthly"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    const-string v4, "EventStatistic"

    invoke-static {v3, v4, v0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->event(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_2

    :sswitch_3
    const/16 v1, 0xb

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->updateBarItemCount(I)V

    goto :goto_3

    :sswitch_4
    const/4 v1, 0x7

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->updateBarItemCount(I)V

    goto/16 :goto_3

    :sswitch_5
    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->updateBarItemCount(I)V

    goto/16 :goto_3

    :cond_3
    move-object v2, v1

    goto/16 :goto_0

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x10 -> :sswitch_1
        0x100 -> :sswitch_2
    .end sparse-switch

    :sswitch_data_1
    .sparse-switch
        0x1 -> :sswitch_3
        0x10 -> :sswitch_4
        0x100 -> :sswitch_5
    .end sparse-switch
.end method

.method private a(IIZ)V
    .locals 2

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    invoke-direct {p0, v0, v1, p1, p2}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(IIII)V

    return-void
.end method

.method private static a(ILcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;Landroid/util/SparseArray;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;",
            "Landroid/util/SparseArray",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;",
            ">;)V"
        }
    .end annotation

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/data/AsyncChartDataLoader;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/chart/data/AsyncChartDataLoader;-><init>()V

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/data/AsyncChartDataLoader;->setLoadCallback(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V

    invoke-virtual {p2, p0, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    return-void
.end method

.method private a(IZ)V
    .locals 8

    const/4 v7, 0x1

    const/4 v6, 0x0

    const/4 v2, 0x0

    const/16 v0, 0x10

    if-ne p1, v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->M:Landroid/widget/ImageButton;

    const v1, 0x7f020024

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageResource(I)V

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->U:I

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->T:I

    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    const-string v4, "mode"

    const-string v5, "EventModeSleep"

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    const-string v5, "EventStatistic"

    invoke-static {v4, v5, v3}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->event(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)V

    move v3, v1

    move v1, v0

    :goto_0
    if-eqz p2, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->E:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundColor(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundColor(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setMode(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setMode(I)V

    :goto_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(Lcn/com/smartdevices/bracelet/model/SportDay;)V

    return-void

    :cond_0
    if-ne p1, v7, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->M:Landroid/widget/ImageButton;

    const v1, 0x7f020021

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageResource(I)V

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->T:I

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->U:I

    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    const-string v4, "mode"

    const-string v5, "EventModeStep"

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    const-string v5, "EventStatistic"

    invoke-static {v4, v5, v3}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->event(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)V

    move v3, v1

    move v1, v0

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    const-wide/16 v4, 0x145

    invoke-virtual {v0, v4, v5, v6, v6}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->animRefreshTo(JFF)Landroid/animation/Animator;

    move-result-object v0

    new-instance v4, Lcn/com/smartdevices/bracelet/ui/bI;

    const-wide/16 v5, 0x28a

    invoke-direct {v4, p0, v5, v6}, Lcn/com/smartdevices/bracelet/ui/bI;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;J)V

    invoke-virtual {v0, v4}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    new-instance v4, Landroid/view/animation/AccelerateInterpolator;

    const/high16 v5, 0x3fc00000

    invoke-direct {v4, v5}, Landroid/view/animation/AccelerateInterpolator;-><init>(F)V

    invoke-virtual {v0, v4}, Landroid/animation/Animator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->setFirstAnim(Landroid/animation/Animator;)V

    const/4 v0, 0x2

    new-array v4, v0, [Landroid/view/View;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->E:Landroid/view/View;

    aput-object v0, v4, v2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    aput-object v0, v4, v7

    invoke-static {v3, v1, v4}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animColorTrans(II[Landroid/view/View;)Landroid/animation/Animator;

    move-result-object v0

    const-wide/16 v1, 0x1b0

    invoke-static {v0, v1, v2}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->addAnim(Landroid/animation/Animator;J)V

    invoke-static {}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->build()Landroid/animation/AnimatorSet;

    move-result-object v0

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bJ;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/ui/bJ;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->V:Landroid/animation/Animator;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->V:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    goto :goto_1

    :cond_2
    move v1, v2

    move v3, v2

    goto/16 :goto_0
.end method

.method private a(Landroid/view/View;)V
    .locals 11

    const/4 v10, 0x3

    const/16 v9, 0x100

    const/16 v8, 0x10

    const/4 v7, 0x1

    const v0, 0x7f07002d

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->E:Landroid/view/View;

    const v0, 0x7f07002e

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->F:Landroid/widget/TextView;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->F:Landroid/widget/TextView;

    invoke-virtual {v0, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f07009d

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->G:Landroid/widget/TextView;

    const v0, 0x7f07009e

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->H:Landroid/view/View;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->H:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f070115

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    const v0, 0x7f070116

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    const v0, 0x7f0700a0

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->M:Landroid/widget/ImageButton;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->M:Landroid/widget/ImageButton;

    invoke-virtual {v0, p0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f07011d

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->O:Landroid/view/View;

    const v0, 0x7f07011e

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->N:Landroid/view/View;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->O:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->N:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f070117

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const v1, 0x7f070118

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    const v2, 0x7f070119

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    const v3, 0x7f07011a

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    const v4, 0x7f07011b

    invoke-virtual {p1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    const v5, 0x7f07011c

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    new-instance v6, Landroid/util/SparseArray;

    invoke-direct {v6, v10}, Landroid/util/SparseArray;-><init>(I)V

    iput-object v6, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    new-instance v6, Landroid/util/SparseArray;

    invoke-direct {v6, v10}, Landroid/util/SparseArray;-><init>(I)V

    iput-object v6, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    iget-object v6, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v6, v7, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v0, v8, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v0, v9, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, v7, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, v8, v4}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, v9, v5}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v0, v7}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v0, v8}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v0, v9}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, v7}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, v8}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, v9}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    return-void
.end method

.method private static a(Lcn/com/smartdevices/bracelet/chart/StatisticChartView;I)V
    .locals 1

    sparse-switch p1, :sswitch_data_0

    :goto_0
    return-void

    :sswitch_0
    const/16 v0, 0xb

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->updateBarItemCount(I)V

    goto :goto_0

    :sswitch_1
    const/4 v0, 0x7

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->updateBarItemCount(I)V

    goto :goto_0

    :sswitch_2
    const/4 v0, 0x5

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->updateBarItemCount(I)V

    goto :goto_0

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x10 -> :sswitch_1
        0x100 -> :sswitch_2
    .end sparse-switch
.end method

.method private a(Lcn/com/smartdevices/bracelet/chart/StatisticChartView;Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;I)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->z:Landroid/util/SparseArray;

    invoke-virtual {v0, p3}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    invoke-virtual {v0, p2}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->setLoadCallback(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V

    invoke-virtual {p1, v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setDataLoader(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;)V

    return-void
.end method

.method private a(Lcn/com/smartdevices/bracelet/model/SportDay;)V
    .locals 6

    const/16 v5, 0x10

    const/4 v4, 0x0

    const/4 v3, 0x1

    const/4 v0, 0x0

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    if-ne v1, v5, :cond_3

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->w:Lcn/com/smartdevices/bracelet/ui/bM;

    if-eqz v1, :cond_5

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->B:Ljava/lang/String;

    new-array v1, v3, [Ljava/lang/Object;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->w:Lcn/com/smartdevices/bracelet/ui/bM;

    invoke-virtual {v2, p1}, Lcn/com/smartdevices/bracelet/ui/bM;->a(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    :goto_0
    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    if-ne v0, v3, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->k:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {p1, v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v0

    if-nez v0, :cond_2

    :cond_0
    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    if-ne v0, v5, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->k:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {p1, v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->offsetWeek(Lcn/com/smartdevices/bracelet/model/SportDay;)I

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    const/16 v2, 0x100

    if-ne v0, v2, :cond_4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->k:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {p1, v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->offsetMonth(Lcn/com/smartdevices/bracelet/model/SportDay;)I

    move-result v0

    if-nez v0, :cond_4

    :cond_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->G:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    :goto_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->F:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void

    :cond_3
    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    if-ne v1, v3, :cond_5

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->w:Lcn/com/smartdevices/bracelet/ui/bM;

    if-eqz v1, :cond_5

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->C:Ljava/lang/String;

    new-array v1, v3, [Ljava/lang/Object;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->w:Lcn/com/smartdevices/bracelet/ui/bM;

    invoke-virtual {v2, p1}, Lcn/com/smartdevices/bracelet/ui/bM;->a(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    goto :goto_0

    :cond_4
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->G:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1

    :cond_5
    move-object v1, v0

    goto :goto_0
.end method

.method private a(Lcn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus;)V
    .locals 6

    const v5, 0x7f0c011d

    const/4 v4, 0x1

    const/4 v3, 0x0

    const-string v0, "Statistic.Main"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Current Sync Status : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget v0, p1, Lcn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus;->a:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->G:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/Utils;->getSyncTime(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_0
    return-void

    :pswitch_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->G:Landroid/widget/TextView;

    new-array v1, v4, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-virtual {p0, v5, v1}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    :pswitch_1
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->G:Landroid/widget/TextView;

    new-array v2, v4, [Ljava/lang/Object;

    iget-object v0, p1, Lcn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus;->b:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Integer;

    aput-object v0, v2, v3

    invoke-virtual {p0, v5, v2}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x9
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->aa:I

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;Landroid/animation/Animator;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->W:Landroid/animation/Animator;

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->v:Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;Lcn/com/smartdevices/bracelet/model/SportDay;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Z:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;Z)V
    .locals 1

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->A:Z

    return-void
.end method

.method private a(Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->F:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method private b(Lcn/com/smartdevices/bracelet/chart/StatisticChartView;Lcn/com/smartdevices/bracelet/chart/StatisticChartView;IIIII)Landroid/animation/Animator;
    .locals 5

    const/high16 v4, 0x3f800000

    int-to-float v0, p3

    int-to-float v1, p4

    div-float/2addr v0, v1

    const/4 v1, 0x0

    invoke-static {p1, v1, v4}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animFade(Landroid/view/View;FF)Landroid/animation/Animator;

    move-result-object v1

    invoke-static {p1, v0, v4}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animScaleX(Landroid/view/View;FF)Landroid/animation/Animator;

    move-result-object v0

    int-to-float v2, p4

    int-to-float v3, p3

    div-float/2addr v2, v3

    invoke-static {p2, v4, v2}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animScaleX(Landroid/view/View;FF)Landroid/animation/Animator;

    move-result-object v2

    int-to-long v3, p7

    invoke-static {v0, v3, v4}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->setFirstAnim(Landroid/animation/Animator;J)V

    int-to-long v3, p7

    invoke-static {v1, v3, v4}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->addAnim(Landroid/animation/Animator;J)V

    int-to-long v0, p7

    invoke-static {v2, v0, v1}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->addAnim(Landroid/animation/Animator;J)V

    int-to-long v0, p7

    int-to-float v2, p5

    int-to-float v3, p6

    invoke-virtual {p2, v0, v1, v2, v3}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->animRefreshTo(JFF)Landroid/animation/Animator;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->addAnim(Landroid/animation/Animator;)V

    invoke-static {}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->build()Landroid/animation/AnimatorSet;

    move-result-object v0

    new-instance v1, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bL;

    invoke-direct {v1, p0, p1, p2}, Lcn/com/smartdevices/bracelet/ui/bL;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;Lcn/com/smartdevices/bracelet/chart/StatisticChartView;Lcn/com/smartdevices/bracelet/chart/StatisticChartView;)V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    return-object v0
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;Lcn/com/smartdevices/bracelet/chart/StatisticChartView;Lcn/com/smartdevices/bracelet/chart/StatisticChartView;IIIII)Landroid/animation/Animator;
    .locals 6

    const/high16 v5, 0x3f800000

    const/16 v0, 0x1c2

    int-to-float v1, p3

    int-to-float v2, p4

    div-float/2addr v1, v2

    const/4 v2, 0x0

    invoke-static {p1, v2, v5}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animFade(Landroid/view/View;FF)Landroid/animation/Animator;

    move-result-object v2

    invoke-static {p1, v1, v5}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animScaleX(Landroid/view/View;FF)Landroid/animation/Animator;

    move-result-object v1

    int-to-float v3, p4

    int-to-float v4, p3

    div-float/2addr v3, v4

    invoke-static {p2, v5, v3}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animScaleX(Landroid/view/View;FF)Landroid/animation/Animator;

    move-result-object v3

    int-to-long v4, v0

    invoke-static {v1, v4, v5}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->setFirstAnim(Landroid/animation/Animator;J)V

    int-to-long v4, v0

    invoke-static {v2, v4, v5}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->addAnim(Landroid/animation/Animator;J)V

    int-to-long v1, v0

    invoke-static {v3, v1, v2}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->addAnim(Landroid/animation/Animator;J)V

    int-to-long v0, v0

    int-to-float v2, p5

    int-to-float v3, p6

    invoke-virtual {p2, v0, v1, v2, v3}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->animRefreshTo(JFF)Landroid/animation/Animator;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->addAnim(Landroid/animation/Animator;)V

    invoke-static {}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil$AnimSetBuilder;->build()Landroid/animation/AnimatorSet;

    move-result-object v0

    new-instance v1, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bL;

    invoke-direct {v1, p0, p1, p2}, Lcn/com/smartdevices/bracelet/ui/bL;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;Lcn/com/smartdevices/bracelet/chart/StatisticChartView;Lcn/com/smartdevices/bracelet/chart/StatisticChartView;)V

    invoke-virtual {v0, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    return-object v0
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Z:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object v0
.end method

.method private b()V
    .locals 6

    const/16 v5, 0x100

    const/16 v4, 0x10

    const/4 v3, 0x3

    const/4 v2, 0x1

    new-instance v0, Lcn/com/smartdevices/bracelet/ui/bH;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/ui/bH;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->y:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0, v3}, Landroid/util/SparseArray;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->z:Landroid/util/SparseArray;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->y:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->z:Landroid/util/SparseArray;

    invoke-static {v2, v0, v1}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(ILcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;Landroid/util/SparseArray;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->y:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->z:Landroid/util/SparseArray;

    invoke-static {v4, v0, v1}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(ILcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;Landroid/util/SparseArray;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->y:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->z:Landroid/util/SparseArray;

    invoke-static {v5, v0, v1}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(ILcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;Landroid/util/SparseArray;)V

    invoke-static {}, Lcn/com/smartdevices/bracelet/Keeper;->readPersonInfo()Lcn/com/smartdevices/bracelet/model/PersonInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/PersonInfo;->getDaySportGoalSteps()I

    move-result v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setStepGoal(I)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setStepGoal(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->attach()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->attach()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setVisibility(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0, v3}, Landroid/util/SparseArray;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->x:Landroid/util/SparseArray;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->x:Landroid/util/SparseArray;

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bN;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/ui/bN;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)V

    invoke-virtual {v0, v2, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->x:Landroid/util/SparseArray;

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bP;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/ui/bP;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)V

    invoke-virtual {v0, v4, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->x:Landroid/util/SparseArray;

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bO;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/ui/bO;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)V

    invoke-virtual {v0, v5, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    return-void
.end method

.method private b(IZ)V
    .locals 2

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    invoke-direct {p0, v0, v1, p1, p1}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(IIII)V

    return-void
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->q:I

    return-void
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;Lcn/com/smartdevices/bracelet/model/SportDay;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-void
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;Z)V
    .locals 1

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->X:Z

    return-void
.end method

.method static synthetic c(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->aa:I

    return v0
.end method

.method private c()Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;
    .locals 1

    new-instance v0, Lcn/com/smartdevices/bracelet/ui/bH;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/ui/bH;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)V

    return-object v0
.end method

.method static synthetic c(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->r:I

    return-void
.end method

.method static synthetic c(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;Lcn/com/smartdevices/bracelet/model/SportDay;)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(Lcn/com/smartdevices/bracelet/model/SportDay;)V

    return-void
.end method

.method static synthetic d(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object v0
.end method

.method private d()V
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->w:Lcn/com/smartdevices/bracelet/ui/bM;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    invoke-virtual {v0, v1, v2}, Lcn/com/smartdevices/bracelet/ui/bM;->a(Lcn/com/smartdevices/bracelet/model/SportDay;I)Lcn/com/smartdevices/bracelet/model/ShareData;

    move-result-object v0

    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    const-class v3, Lcn/com/smartdevices/bracelet/ui/ShareActivity;

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    const-string v2, "share_data"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method static synthetic d(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->t:I

    return-void
.end method

.method private e()Lcn/com/smartdevices/bracelet/model/ShareData;
    .locals 3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->w:Lcn/com/smartdevices/bracelet/ui/bM;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    invoke-virtual {v0, v1, v2}, Lcn/com/smartdevices/bracelet/ui/bM;->a(Lcn/com/smartdevices/bracelet/model/SportDay;I)Lcn/com/smartdevices/bracelet/model/ShareData;

    move-result-object v0

    return-object v0
.end method

.method static synthetic e(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->l:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object v0
.end method

.method static synthetic e(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->u:I

    return-void
.end method

.method static synthetic f(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Lcn/com/smartdevices/bracelet/DataManager;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->j:Lcn/com/smartdevices/bracelet/DataManager;

    return-object v0
.end method

.method private f()V
    .locals 5

    const/16 v3, 0x10

    const/4 v2, 0x1

    const/4 v1, 0x0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->V:Landroid/animation/Animator;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->V:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->isStarted()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->W:Landroid/animation/Animator;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->W:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->isStarted()Z

    move-result v0

    if-nez v0, :cond_0

    :cond_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    if-ne v0, v3, :cond_4

    iput v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    :cond_3
    :goto_1
    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    iget-boolean v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->A:Z

    invoke-direct {p0, v1, v2}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(IZ)V

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget-boolean v4, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->A:Z

    invoke-direct {p0, v0, v1, v2, v3}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(IIII)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->S:Landroid/view/View;

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->R:Landroid/view/View;

    check-cast v1, Landroid/view/ViewGroup;

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animInfoSwitch(Landroid/view/ViewGroup;Landroid/view/ViewGroup;)V

    goto :goto_0

    :cond_4
    if-ne v0, v2, :cond_3

    iput v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    goto :goto_1
.end method

.method static synthetic g(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->n:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object v0
.end method

.method private g()V
    .locals 6

    const/16 v3, 0x10

    const/4 v5, 0x1

    const/4 v4, 0x0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->W:Landroid/animation/Animator;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->W:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->isStarted()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->V:Landroid/animation/Animator;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->V:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->isStarted()Z

    move-result v0

    if-nez v0, :cond_0

    :cond_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->q:I

    invoke-virtual {v0, v1, v2}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->getBarItem(II)Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->v:Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->v:Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->v:Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->getRect()Landroid/graphics/RectF;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/RectF;->height()F

    move-result v0

    float-to-int v0, v0

    iput v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->t:I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->v:Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    iget v1, v0, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->v:Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$StatisticBarItem;

    iget v0, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$StatisticBarItem;->value1:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->t:I

    int-to-float v2, v2

    int-to-float v0, v0

    int-to-float v1, v1

    div-float/2addr v0, v1

    mul-float/2addr v0, v2

    float-to-int v0, v0

    iput v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->u:I

    :goto_1
    const-string v0, "Statistic.Main"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "BarItem Height : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->t:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    const/16 v2, 0x100

    if-ne v1, v2, :cond_6

    iput v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->l:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->offsetWeek(Lcn/com/smartdevices/bracelet/model/SportDay;)I

    move-result v1

    iput v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    const-string v1, "Statistic.Main"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Offset Week From Month : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->L:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    :cond_3
    :goto_2
    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->q:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->r:I

    if-eq v1, v2, :cond_4

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->p:Lcn/com/smartdevices/bracelet/model/SportDay;

    :cond_4
    const v1, 0x7fffffff

    iput v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->r:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget-boolean v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->A:Z

    invoke-direct {p0, v0, v1, v2}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(IIZ)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0, v4}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0, v4}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->clearData()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->loadStatisticData(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->offsetTo(I)V

    iput-boolean v5, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->X:Z

    iput-boolean v5, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Y:Z

    goto/16 :goto_0

    :cond_5
    iput v4, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->t:I

    iput v4, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->u:I

    goto/16 :goto_1

    :cond_6
    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    if-ne v1, v3, :cond_3

    iput v5, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->l:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->offsetDay(Lcn/com/smartdevices/bracelet/model/SportDay;)I

    move-result v1

    iput v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    const-string v1, "Statistic.Main"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Offset Day : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->L:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    goto :goto_2
.end method

.method static synthetic h(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Landroid/util/SparseArray;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    return-object v0
.end method

.method private h()V
    .locals 7

    const v6, 0x7fffffff

    const/16 v2, 0x10

    const/4 v5, 0x1

    const/4 v4, 0x0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->W:Landroid/animation/Animator;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->W:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->isStarted()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->V:Landroid/animation/Animator;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->V:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->isStarted()Z

    move-result v0

    if-nez v0, :cond_0

    :cond_2
    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    if-ne v1, v5, :cond_4

    iput v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->l:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->offsetWeek(Lcn/com/smartdevices/bracelet/model/SportDay;)I

    move-result v1

    iput v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    const-string v1, "Statistic.Main"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Offset Week From Day : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->L:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    :cond_3
    :goto_1
    iput v6, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->q:I

    iput v6, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->r:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->p:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget-boolean v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->A:Z

    invoke-direct {p0, v0, v1, v2}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(IIZ)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0, v4}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0, v4}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->clearData()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->loadStatisticData(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->offsetTo(I)V

    iput-boolean v5, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->X:Z

    iput-boolean v4, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Y:Z

    goto :goto_0

    :cond_4
    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    if-ne v1, v2, :cond_3

    const/16 v1, 0x100

    iput v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->l:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->offsetMonth(Lcn/com/smartdevices/bracelet/model/SportDay;)I

    move-result v1

    iput v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    const-string v1, "Statistic.Main"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Offset Month : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->L:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    goto :goto_1
.end method

.method static synthetic i(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Landroid/util/SparseArray;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    return-object v0
.end method

.method private i()V
    .locals 3

    const-string v0, "Statistic.Main"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Current Index : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->q:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Last Index : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->r:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "Statistic.Main"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Current Day : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Last Day : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->p:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic j(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->k:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object v0
.end method

.method static synthetic k(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    return v0
.end method

.method static synthetic l(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->r:I

    return v0
.end method

.method static synthetic m(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->p:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object v0
.end method

.method static synthetic n(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->o:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object v0
.end method

.method static synthetic o(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Lcn/com/smartdevices/bracelet/ui/bM;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->w:Lcn/com/smartdevices/bracelet/ui/bM;

    return-object v0
.end method

.method static synthetic p(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Lcn/com/smartdevices/bracelet/chart/StatisticChartView;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    return-object v0
.end method

.method static synthetic q(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Z
    .locals 1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->X:Z

    return v0
.end method

.method static synthetic r(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Landroid/view/View;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->S:Landroid/view/View;

    return-object v0
.end method

.method static synthetic s(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Landroid/view/View;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->R:Landroid/view/View;

    return-object v0
.end method

.method static synthetic t(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Z
    .locals 1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Y:Z

    return v0
.end method

.method static synthetic u(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Lcn/com/smartdevices/bracelet/chart/StatisticChartView;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->L:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    return-object v0
.end method

.method static synthetic v(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->t:I

    return v0
.end method

.method static synthetic w(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->u:I

    return v0
.end method

.method static synthetic x(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    return v0
.end method

.method static synthetic y(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    return v0
.end method

.method static synthetic z(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->v:Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    return-object v0
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 11

    const/4 v10, 0x3

    const/16 v9, 0x100

    const/16 v8, 0x10

    const/4 v7, 0x1

    invoke-super {p0, p1}, Landroid/app/Fragment;->onActivityCreated(Landroid/os/Bundle;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v0, 0x7f07002d

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->E:Landroid/view/View;

    const v0, 0x7f07002e

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->F:Landroid/widget/TextView;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->F:Landroid/widget/TextView;

    invoke-virtual {v0, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f07009d

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->G:Landroid/widget/TextView;

    const v0, 0x7f07009e

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->H:Landroid/view/View;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->H:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f070115

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    const v0, 0x7f070116

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    const v0, 0x7f0700a0

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->M:Landroid/widget/ImageButton;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->M:Landroid/widget/ImageButton;

    invoke-virtual {v0, p0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f07011d

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->O:Landroid/view/View;

    const v0, 0x7f07011e

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->N:Landroid/view/View;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->O:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->N:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f070117

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const v2, 0x7f070118

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    const v3, 0x7f070119

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    const v4, 0x7f07011a

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    const v5, 0x7f07011b

    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    const v6, 0x7f07011c

    invoke-virtual {v1, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    new-instance v6, Landroid/util/SparseArray;

    invoke-direct {v6, v10}, Landroid/util/SparseArray;-><init>(I)V

    iput-object v6, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    new-instance v6, Landroid/util/SparseArray;

    invoke-direct {v6, v10}, Landroid/util/SparseArray;-><init>(I)V

    iput-object v6, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    iget-object v6, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v6, v7, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v0, v8, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v0, v9, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, v7, v4}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, v8, v5}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, v9, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v0, v7}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v0, v8}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->P:Landroid/util/SparseArray;

    invoke-virtual {v0, v9}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, v7}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, v8}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Q:Landroid/util/SparseArray;

    invoke-virtual {v0, v9}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->dismissChildren(Landroid/view/ViewGroup;)V

    new-instance v0, Lcn/com/smartdevices/bracelet/ui/bH;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/ui/bH;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->y:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0, v10}, Landroid/util/SparseArray;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->z:Landroid/util/SparseArray;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->y:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->z:Landroid/util/SparseArray;

    invoke-static {v7, v0, v1}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(ILcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;Landroid/util/SparseArray;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->y:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->z:Landroid/util/SparseArray;

    invoke-static {v8, v0, v1}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(ILcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;Landroid/util/SparseArray;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->y:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->z:Landroid/util/SparseArray;

    invoke-static {v9, v0, v1}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(ILcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;Landroid/util/SparseArray;)V

    invoke-static {}, Lcn/com/smartdevices/bracelet/Keeper;->readPersonInfo()Lcn/com/smartdevices/bracelet/model/PersonInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/PersonInfo;->getDaySportGoalSteps()I

    move-result v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v1, v7}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setStepGoal(I)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v1, v7}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setStepGoal(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->attach()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->attach()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setVisibility(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0, v10}, Landroid/util/SparseArray;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->x:Landroid/util/SparseArray;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->x:Landroid/util/SparseArray;

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bN;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/ui/bN;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)V

    invoke-virtual {v0, v7, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->x:Landroid/util/SparseArray;

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bP;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/ui/bP;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)V

    invoke-virtual {v0, v8, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->x:Landroid/util/SparseArray;

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bO;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/ui/bO;-><init>(Lcn/com/smartdevices/bracelet/ui/StatisticFragment;)V

    invoke-virtual {v0, v9, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    iput-boolean v7, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->A:Z

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    iget-boolean v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->A:Z

    invoke-direct {p0, v0, v1}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(IZ)V

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget-boolean v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->A:Z

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    invoke-direct {p0, v1, v2, v0, v0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(IIII)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->clearData()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->loadStatisticData(I)V

    invoke-static {}, Lde/greenrobot/event/EventBus;->getDefault()Lde/greenrobot/event/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lde/greenrobot/event/EventBus;->register(Ljava/lang/Object;)V

    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 8

    const/16 v7, 0x100

    const v6, 0x7fffffff

    const/16 v3, 0x10

    const/4 v5, 0x1

    const/4 v4, 0x0

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    :cond_0
    :goto_0
    return-void

    :sswitch_0
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    goto :goto_0

    :sswitch_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->w:Lcn/com/smartdevices/bracelet/ui/bM;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    invoke-virtual {v0, v1, v2}, Lcn/com/smartdevices/bracelet/ui/bM;->a(Lcn/com/smartdevices/bracelet/model/SportDay;I)Lcn/com/smartdevices/bracelet/model/ShareData;

    move-result-object v0

    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    const-class v3, Lcn/com/smartdevices/bracelet/ui/ShareActivity;

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    const-string v2, "share_data"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    :sswitch_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->V:Landroid/animation/Animator;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->V:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->isStarted()Z

    move-result v0

    if-nez v0, :cond_0

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->W:Landroid/animation/Animator;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->W:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->isStarted()Z

    move-result v0

    if-nez v0, :cond_0

    :cond_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0, v4}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0, v4}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    if-ne v0, v3, :cond_4

    iput v5, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    :cond_3
    :goto_1
    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    iget-boolean v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->A:Z

    invoke-direct {p0, v1, v2}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(IZ)V

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget-boolean v4, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->A:Z

    invoke-direct {p0, v0, v1, v2, v3}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(IIII)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->S:Landroid/view/View;

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->R:Landroid/view/View;

    check-cast v1, Landroid/view/ViewGroup;

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/chart/util/AnimUtil;->animInfoSwitch(Landroid/view/ViewGroup;Landroid/view/ViewGroup;)V

    goto :goto_0

    :cond_4
    if-ne v0, v5, :cond_3

    iput v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    goto :goto_1

    :sswitch_3
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->W:Landroid/animation/Animator;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->W:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->isStarted()Z

    move-result v0

    if-nez v0, :cond_0

    :cond_5
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->V:Landroid/animation/Animator;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->V:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->isStarted()Z

    move-result v0

    if-nez v0, :cond_0

    :cond_6
    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    if-ne v1, v5, :cond_8

    iput v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->l:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->offsetWeek(Lcn/com/smartdevices/bracelet/model/SportDay;)I

    move-result v1

    iput v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    const-string v1, "Statistic.Main"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Offset Week From Day : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->L:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    :cond_7
    :goto_2
    iput v6, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->q:I

    iput v6, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->r:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->p:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget-boolean v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->A:Z

    invoke-direct {p0, v0, v1, v2}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(IIZ)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0, v4}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0, v4}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->clearData()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->loadStatisticData(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->offsetTo(I)V

    iput-boolean v5, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->X:Z

    iput-boolean v4, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Y:Z

    goto/16 :goto_0

    :cond_8
    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    if-ne v1, v3, :cond_7

    iput v7, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->l:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->offsetMonth(Lcn/com/smartdevices/bracelet/model/SportDay;)I

    move-result v1

    iput v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    const-string v1, "Statistic.Main"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Offset Month : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->L:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    goto :goto_2

    :sswitch_4
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->W:Landroid/animation/Animator;

    if-eqz v0, :cond_9

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->W:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->isStarted()Z

    move-result v0

    if-nez v0, :cond_0

    :cond_9
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->V:Landroid/animation/Animator;

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->V:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->isStarted()Z

    move-result v0

    if-nez v0, :cond_0

    :cond_a
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->q:I

    invoke-virtual {v0, v1, v2}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->getBarItem(II)Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->v:Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->v:Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    if-eqz v0, :cond_d

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->v:Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->getRect()Landroid/graphics/RectF;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/RectF;->height()F

    move-result v0

    float-to-int v0, v0

    iput v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->t:I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->v:Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    iget v1, v0, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->v:Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$StatisticBarItem;

    iget v0, v0, Lcn/com/smartdevices/bracelet/chart/StatisticChart$StatisticBarItem;->value1:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->t:I

    int-to-float v2, v2

    int-to-float v0, v0

    int-to-float v1, v1

    div-float/2addr v0, v1

    mul-float/2addr v0, v2

    float-to-int v0, v0

    iput v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->u:I

    :goto_3
    const-string v0, "Statistic.Main"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "BarItem Height : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->t:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    if-ne v1, v7, :cond_e

    iput v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->l:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->offsetWeek(Lcn/com/smartdevices/bracelet/model/SportDay;)I

    move-result v1

    iput v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    const-string v1, "Statistic.Main"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Offset Week From Month : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->L:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    :cond_b
    :goto_4
    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->q:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->r:I

    if-eq v1, v2, :cond_c

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->p:Lcn/com/smartdevices/bracelet/model/SportDay;

    :cond_c
    iput v6, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->r:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget-boolean v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->A:Z

    invoke-direct {p0, v0, v1, v2}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(IIZ)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0, v4}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0, v4}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->setScrollable(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->clearData()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->loadStatisticData(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->offsetTo(I)V

    iput-boolean v5, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->X:Z

    iput-boolean v5, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->Y:Z

    goto/16 :goto_0

    :cond_d
    iput v4, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->t:I

    iput v4, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->u:I

    goto :goto_3

    :cond_e
    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    if-ne v1, v3, :cond_b

    iput v5, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->l:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->offsetDay(Lcn/com/smartdevices/bracelet/model/SportDay;)I

    move-result v1

    iput v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    const-string v1, "Statistic.Main"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Offset Day : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->s:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->L:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    goto :goto_4

    nop

    :sswitch_data_0
    .sparse-switch
        0x7f07002e -> :sswitch_0
        0x7f07009e -> :sswitch_1
        0x7f0700a0 -> :sswitch_2
        0x7f07011d -> :sswitch_3
        0x7f07011e -> :sswitch_4
    .end sparse-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4

    const/4 v3, 0x1

    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    const-string v1, "Mode"

    invoke-virtual {v0, v1, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    const-string v0, "Statistic.Main"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Mode : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->h:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    iput v3, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->i:I

    invoke-static {}, Lcn/com/smartdevices/bracelet/DataManager;->getInstance()Lcn/com/smartdevices/bracelet/DataManager;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->j:Lcn/com/smartdevices/bracelet/DataManager;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->j:Lcn/com/smartdevices/bracelet/DataManager;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/DataManager;->getToday()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->k:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->j:Lcn/com/smartdevices/bracelet/DataManager;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/DataManager;->getCurDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->l:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->j:Lcn/com/smartdevices/bracelet/DataManager;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/DataManager;->getStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->n:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->j:Lcn/com/smartdevices/bracelet/DataManager;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/DataManager;->getStopDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->o:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->l:Lcn/com/smartdevices/bracelet/model/SportDay;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    const-string v0, "Statistic.Main"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Today : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->k:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " , StartDay : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->n:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " , StopDay : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->o:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " , CurrentDay : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->m:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    const v0, 0x7f0c010e

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->B:Ljava/lang/String;

    const v0, 0x7f0c0110

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->C:Ljava/lang/String;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->D:Ljava/util/HashMap;

    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    const v0, 0x7f030044

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080034

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    iput v2, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->T:I

    const v2, 0x7f080035

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    iput v1, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->U:I

    return-object v0
.end method

.method public onDestroy()V
    .locals 1

    invoke-static {}, Lde/greenrobot/event/EventBus;->getDefault()Lde/greenrobot/event/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lde/greenrobot/event/EventBus;->unregister(Ljava/lang/Object;)V

    invoke-super {p0}, Landroid/app/Fragment;->onDestroy()V

    return-void
.end method

.method public onDetach()V
    .locals 1

    invoke-super {p0}, Landroid/app/Fragment;->onDetach()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->I:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->detach()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->J:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->detach()V

    return-void
.end method

.method public onEvent(Lcn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus;)V
    .locals 3

    const-string v0, "Statistic.Main"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "On BLE Status Changed : "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p1, Lcn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus;->a:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(Lcn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus;)V

    iget v0, p1, Lcn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus;->a:I

    const/16 v1, 0xb

    if-ne v0, v1, :cond_0

    iget-object v0, p1, Lcn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus;->b:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->A:Z

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->D:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->getDataLoader()Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    move-result-object v0

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->cancel()V

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->clearData()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->clearData()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->K:Lcn/com/smartdevices/bracelet/chart/StatisticChartView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/StatisticChartView;->loadStatisticData(I)V

    :cond_0
    return-void
.end method

.method public onPause()V
    .locals 1

    invoke-super {p0}, Landroid/app/Fragment;->onPause()V

    const-string v0, "PageStatistic"

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->endPage(Ljava/lang/String;)V

    return-void
.end method

.method public onResume()V
    .locals 1

    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;->mConnStatus:Lcn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus;

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/ui/StatisticFragment;->a(Lcn/com/smartdevices/bracelet/ui/BaseSCActivity$ConnStatus;)V

    const-string v0, "PageStatistic"

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->startPage(Ljava/lang/String;)V

    return-void
.end method
