.class Landroid/support/v4/widget/r;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/support/v4/widget/p;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/content/Context;Landroid/view/animation/Interpolator;)Ljava/lang/Object;
    .locals 1

    if-eqz p2, :cond_0

    new-instance v0, Landroid/widget/OverScroller;

    invoke-direct {v0, p1, p2}, Landroid/widget/OverScroller;-><init>(Landroid/content/Context;Landroid/view/animation/Interpolator;)V

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Landroid/widget/OverScroller;

    invoke-direct {v0, p1}, Landroid/widget/OverScroller;-><init>(Landroid/content/Context;)V

    goto :goto_0
.end method

.method public final a(Ljava/lang/Object;III)V
    .locals 0

    check-cast p1, Landroid/widget/OverScroller;

    invoke-virtual {p1, p2, p3, p4}, Landroid/widget/OverScroller;->notifyHorizontalEdgeReached(III)V

    return-void
.end method

.method public final a(Ljava/lang/Object;IIII)V
    .locals 0

    check-cast p1, Landroid/widget/OverScroller;

    invoke-virtual {p1, p2, p3, p4, p5}, Landroid/widget/OverScroller;->startScroll(IIII)V

    return-void
.end method

.method public final a(Ljava/lang/Object;IIIII)V
    .locals 6

    move-object v0, p1

    check-cast v0, Landroid/widget/OverScroller;

    move v1, p2

    move v2, p3

    move v3, p4

    move v4, p5

    move v5, p6

    invoke-virtual/range {v0 .. v5}, Landroid/widget/OverScroller;->startScroll(IIIII)V

    return-void
.end method

.method public final a(Ljava/lang/Object;IIIIIIII)V
    .locals 9

    move-object v0, p1

    check-cast v0, Landroid/widget/OverScroller;

    move v1, p2

    move v2, p3

    move v3, p4

    move v4, p5

    move v5, p6

    move/from16 v6, p7

    move/from16 v7, p8

    move/from16 v8, p9

    invoke-virtual/range {v0 .. v8}, Landroid/widget/OverScroller;->fling(IIIIIIII)V

    return-void
.end method

.method public final a(Ljava/lang/Object;IIIIIIIIII)V
    .locals 11

    move-object v0, p1

    check-cast v0, Landroid/widget/OverScroller;

    move v1, p2

    move v2, p3

    move v3, p4

    move/from16 v4, p5

    move/from16 v5, p6

    move/from16 v6, p7

    move/from16 v7, p8

    move/from16 v8, p9

    move/from16 v9, p10

    move/from16 v10, p11

    invoke-virtual/range {v0 .. v10}, Landroid/widget/OverScroller;->fling(IIIIIIIIII)V

    return-void
.end method

.method public final a(Ljava/lang/Object;)Z
    .locals 1

    check-cast p1, Landroid/widget/OverScroller;

    invoke-virtual {p1}, Landroid/widget/OverScroller;->isFinished()Z

    move-result v0

    return v0
.end method

.method public final b(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Landroid/widget/OverScroller;

    invoke-virtual {p1}, Landroid/widget/OverScroller;->getCurrX()I

    move-result v0

    return v0
.end method

.method public final b(Ljava/lang/Object;III)V
    .locals 0

    check-cast p1, Landroid/widget/OverScroller;

    invoke-virtual {p1, p2, p3, p4}, Landroid/widget/OverScroller;->notifyVerticalEdgeReached(III)V

    return-void
.end method

.method public final c(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Landroid/widget/OverScroller;

    invoke-virtual {p1}, Landroid/widget/OverScroller;->getCurrY()I

    move-result v0

    return v0
.end method

.method public d(Ljava/lang/Object;)F
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public final e(Ljava/lang/Object;)Z
    .locals 1

    check-cast p1, Landroid/widget/OverScroller;

    invoke-virtual {p1}, Landroid/widget/OverScroller;->computeScrollOffset()Z

    move-result v0

    return v0
.end method

.method public final f(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Landroid/widget/OverScroller;

    invoke-virtual {p1}, Landroid/widget/OverScroller;->abortAnimation()V

    return-void
.end method

.method public final g(Ljava/lang/Object;)Z
    .locals 1

    check-cast p1, Landroid/widget/OverScroller;

    invoke-virtual {p1}, Landroid/widget/OverScroller;->isOverScrolled()Z

    move-result v0

    return v0
.end method

.method public final h(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Landroid/widget/OverScroller;

    invoke-virtual {p1}, Landroid/widget/OverScroller;->getFinalX()I

    move-result v0

    return v0
.end method

.method public final i(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Landroid/widget/OverScroller;

    invoke-virtual {p1}, Landroid/widget/OverScroller;->getFinalY()I

    move-result v0

    return v0
.end method
