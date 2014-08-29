.class final Lcom/nineoldandroids/view/i;
.super Lcom/nineoldandroids/view/ViewPropertyAnimator;


# static fields
.field private static final l:I = 0x0

.field private static final m:I = 0x1

.field private static final n:I = 0x2

.field private static final o:I = 0x4

.field private static final p:I = 0x8

.field private static final q:I = 0x10

.field private static final r:I = 0x20

.field private static final s:I = 0x40

.field private static final t:I = 0x80

.field private static final u:I = 0x100

.field private static final v:I = 0x200

.field private static final w:I = 0x1ff


# instance fields
.field private final a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

.field private final b:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private c:J

.field private d:Z

.field private e:J

.field private f:Z

.field private g:Landroid/view/animation/Interpolator;

.field private h:Z

.field private i:Lcom/nineoldandroids/animation/Animator$AnimatorListener;

.field private j:Lcom/nineoldandroids/view/k;

.field private k:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/nineoldandroids/view/l;",
            ">;"
        }
    .end annotation
.end field

.field private x:Ljava/lang/Runnable;

.field private y:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lcom/nineoldandroids/animation/Animator;",
            "Lcom/nineoldandroids/view/m;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Landroid/view/View;)V
    .locals 3

    const/4 v2, 0x0

    invoke-direct {p0}, Lcom/nineoldandroids/view/ViewPropertyAnimator;-><init>()V

    iput-boolean v2, p0, Lcom/nineoldandroids/view/i;->d:Z

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/nineoldandroids/view/i;->e:J

    iput-boolean v2, p0, Lcom/nineoldandroids/view/i;->f:Z

    iput-boolean v2, p0, Lcom/nineoldandroids/view/i;->h:Z

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/nineoldandroids/view/i;->i:Lcom/nineoldandroids/animation/Animator$AnimatorListener;

    new-instance v0, Lcom/nineoldandroids/view/k;

    invoke-direct {v0, p0, v2}, Lcom/nineoldandroids/view/k;-><init>(Lcom/nineoldandroids/view/i;B)V

    iput-object v0, p0, Lcom/nineoldandroids/view/i;->j:Lcom/nineoldandroids/view/k;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/nineoldandroids/view/i;->k:Ljava/util/ArrayList;

    new-instance v0, Lcom/nineoldandroids/view/j;

    invoke-direct {v0, p0}, Lcom/nineoldandroids/view/j;-><init>(Lcom/nineoldandroids/view/i;)V

    iput-object v0, p0, Lcom/nineoldandroids/view/i;->x:Ljava/lang/Runnable;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/nineoldandroids/view/i;->y:Ljava/util/HashMap;

    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/nineoldandroids/view/i;->b:Ljava/lang/ref/WeakReference;

    invoke-static {p1}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->wrap(Landroid/view/View;)Lcom/nineoldandroids/view/animation/AnimatorProxy;

    move-result-object v0

    iput-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    return-void
.end method

.method private a(I)F
    .locals 1

    sparse-switch p1, :sswitch_data_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :sswitch_0
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->getTranslationX()F

    move-result v0

    goto :goto_0

    :sswitch_1
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->getTranslationY()F

    move-result v0

    goto :goto_0

    :sswitch_2
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->getRotation()F

    move-result v0

    goto :goto_0

    :sswitch_3
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->getRotationX()F

    move-result v0

    goto :goto_0

    :sswitch_4
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->getRotationY()F

    move-result v0

    goto :goto_0

    :sswitch_5
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->getScaleX()F

    move-result v0

    goto :goto_0

    :sswitch_6
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->getScaleY()F

    move-result v0

    goto :goto_0

    :sswitch_7
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->getX()F

    move-result v0

    goto :goto_0

    :sswitch_8
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->getY()F

    move-result v0

    goto :goto_0

    :sswitch_9
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->getAlpha()F

    move-result v0

    goto :goto_0

    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x2 -> :sswitch_1
        0x4 -> :sswitch_5
        0x8 -> :sswitch_6
        0x10 -> :sswitch_2
        0x20 -> :sswitch_3
        0x40 -> :sswitch_4
        0x80 -> :sswitch_7
        0x100 -> :sswitch_8
        0x200 -> :sswitch_9
    .end sparse-switch
.end method

.method private a()V
    .locals 6

    const/4 v1, 0x0

    const/4 v0, 0x1

    new-array v0, v0, [F

    const/high16 v2, 0x3f800000

    aput v2, v0, v1

    invoke-static {v0}, Lcom/nineoldandroids/animation/ValueAnimator;->ofFloat([F)Lcom/nineoldandroids/animation/ValueAnimator;

    move-result-object v4

    iget-object v0, p0, Lcom/nineoldandroids/view/i;->k:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/nineoldandroids/view/i;->k:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v5

    move v2, v1

    move v3, v1

    :goto_0
    if-lt v2, v5, :cond_3

    iget-object v1, p0, Lcom/nineoldandroids/view/i;->y:Ljava/util/HashMap;

    new-instance v2, Lcom/nineoldandroids/view/m;

    invoke-direct {v2, v3, v0}, Lcom/nineoldandroids/view/m;-><init>(ILjava/util/ArrayList;)V

    invoke-virtual {v1, v4, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/nineoldandroids/view/i;->j:Lcom/nineoldandroids/view/k;

    invoke-virtual {v4, v0}, Lcom/nineoldandroids/animation/ValueAnimator;->addUpdateListener(Lcom/nineoldandroids/animation/ValueAnimator$AnimatorUpdateListener;)V

    iget-object v0, p0, Lcom/nineoldandroids/view/i;->j:Lcom/nineoldandroids/view/k;

    invoke-virtual {v4, v0}, Lcom/nineoldandroids/animation/ValueAnimator;->addListener(Lcom/nineoldandroids/animation/Animator$AnimatorListener;)V

    iget-boolean v0, p0, Lcom/nineoldandroids/view/i;->f:Z

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/nineoldandroids/view/i;->e:J

    invoke-virtual {v4, v0, v1}, Lcom/nineoldandroids/animation/ValueAnimator;->setStartDelay(J)V

    :cond_0
    iget-boolean v0, p0, Lcom/nineoldandroids/view/i;->d:Z

    if-eqz v0, :cond_1

    iget-wide v0, p0, Lcom/nineoldandroids/view/i;->c:J

    invoke-virtual {v4, v0, v1}, Lcom/nineoldandroids/animation/ValueAnimator;->setDuration(J)Lcom/nineoldandroids/animation/ValueAnimator;

    :cond_1
    iget-boolean v0, p0, Lcom/nineoldandroids/view/i;->h:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/nineoldandroids/view/i;->g:Landroid/view/animation/Interpolator;

    invoke-virtual {v4, v0}, Lcom/nineoldandroids/animation/ValueAnimator;->setInterpolator(Landroid/view/animation/Interpolator;)V

    :cond_2
    invoke-virtual {v4}, Lcom/nineoldandroids/animation/ValueAnimator;->start()V

    return-void

    :cond_3
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/nineoldandroids/view/l;

    iget v1, v1, Lcom/nineoldandroids/view/l;->a:I

    or-int/2addr v3, v1

    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_0
.end method

.method private a(IF)V
    .locals 2

    invoke-direct {p0, p1}, Lcom/nineoldandroids/view/i;->a(I)F

    move-result v0

    sub-float v1, p2, v0

    invoke-direct {p0, p1, v0, v1}, Lcom/nineoldandroids/view/i;->a(IFF)V

    return-void
.end method

.method private a(IFF)V
    .locals 8

    const/4 v4, 0x0

    iget-object v0, p0, Lcom/nineoldandroids/view/i;->y:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->size()I

    move-result v0

    if-lez v0, :cond_1

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/nineoldandroids/view/i;->y:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-nez v0, :cond_3

    move-object v2, v3

    :goto_0
    if-eqz v2, :cond_1

    invoke-virtual {v2}, Lcom/nineoldandroids/animation/Animator;->cancel()V

    :cond_1
    new-instance v0, Lcom/nineoldandroids/view/l;

    invoke-direct {v0, p1, p2, p3}, Lcom/nineoldandroids/view/l;-><init>(IFF)V

    iget-object v1, p0, Lcom/nineoldandroids/view/i;->k:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/nineoldandroids/view/i;->b:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    if-eqz v0, :cond_2

    iget-object v1, p0, Lcom/nineoldandroids/view/i;->x:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    iget-object v1, p0, Lcom/nineoldandroids/view/i;->x:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    :cond_2
    return-void

    :cond_3
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object v2, v0

    check-cast v2, Lcom/nineoldandroids/animation/Animator;

    iget-object v0, p0, Lcom/nineoldandroids/view/i;->y:Ljava/util/HashMap;

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/nineoldandroids/view/m;

    iget v1, v0, Lcom/nineoldandroids/view/m;->a:I

    and-int/2addr v1, p1

    if-eqz v1, :cond_4

    iget-object v1, v0, Lcom/nineoldandroids/view/m;->b:Ljava/util/ArrayList;

    if-eqz v1, :cond_4

    iget-object v1, v0, Lcom/nineoldandroids/view/m;->b:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v7

    move v5, v4

    :goto_1
    if-lt v5, v7, :cond_5

    :cond_4
    move v1, v4

    :goto_2
    if-eqz v1, :cond_0

    iget v0, v0, Lcom/nineoldandroids/view/m;->a:I

    if-nez v0, :cond_0

    goto :goto_0

    :cond_5
    iget-object v1, v0, Lcom/nineoldandroids/view/m;->b:Ljava/util/ArrayList;

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/nineoldandroids/view/l;

    iget v1, v1, Lcom/nineoldandroids/view/l;->a:I

    if-ne v1, p1, :cond_6

    iget-object v1, v0, Lcom/nineoldandroids/view/m;->b:Ljava/util/ArrayList;

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    iget v1, v0, Lcom/nineoldandroids/view/m;->a:I

    xor-int/lit8 v5, p1, -0x1

    and-int/2addr v1, v5

    iput v1, v0, Lcom/nineoldandroids/view/m;->a:I

    const/4 v1, 0x1

    goto :goto_2

    :cond_6
    add-int/lit8 v1, v5, 0x1

    move v5, v1

    goto :goto_1
.end method

.method static synthetic a(Lcom/nineoldandroids/view/i;)V
    .locals 0

    invoke-direct {p0}, Lcom/nineoldandroids/view/i;->a()V

    return-void
.end method

.method static synthetic a(Lcom/nineoldandroids/view/i;IF)V
    .locals 1

    sparse-switch p1, :sswitch_data_0

    :goto_0
    return-void

    :sswitch_0
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setTranslationX(F)V

    goto :goto_0

    :sswitch_1
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setTranslationY(F)V

    goto :goto_0

    :sswitch_2
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setRotation(F)V

    goto :goto_0

    :sswitch_3
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setRotationX(F)V

    goto :goto_0

    :sswitch_4
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setRotationY(F)V

    goto :goto_0

    :sswitch_5
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setScaleX(F)V

    goto :goto_0

    :sswitch_6
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setScaleY(F)V

    goto :goto_0

    :sswitch_7
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setX(F)V

    goto :goto_0

    :sswitch_8
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setY(F)V

    goto :goto_0

    :sswitch_9
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setAlpha(F)V

    goto :goto_0

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x2 -> :sswitch_1
        0x4 -> :sswitch_5
        0x8 -> :sswitch_6
        0x10 -> :sswitch_2
        0x20 -> :sswitch_3
        0x40 -> :sswitch_4
        0x80 -> :sswitch_7
        0x100 -> :sswitch_8
        0x200 -> :sswitch_9
    .end sparse-switch
.end method

.method static synthetic a(Lcom/nineoldandroids/view/i;Lcom/nineoldandroids/animation/Animator$AnimatorListener;)V
    .locals 1

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/nineoldandroids/view/i;->i:Lcom/nineoldandroids/animation/Animator$AnimatorListener;

    return-void
.end method

.method static synthetic b(Lcom/nineoldandroids/view/i;)Lcom/nineoldandroids/animation/Animator$AnimatorListener;
    .locals 1

    iget-object v0, p0, Lcom/nineoldandroids/view/i;->i:Lcom/nineoldandroids/animation/Animator$AnimatorListener;

    return-object v0
.end method

.method private b(IF)V
    .locals 1

    invoke-direct {p0, p1}, Lcom/nineoldandroids/view/i;->a(I)F

    move-result v0

    invoke-direct {p0, p1, v0, p2}, Lcom/nineoldandroids/view/i;->a(IFF)V

    return-void
.end method

.method static synthetic c(Lcom/nineoldandroids/view/i;)Ljava/util/HashMap;
    .locals 1

    iget-object v0, p0, Lcom/nineoldandroids/view/i;->y:Ljava/util/HashMap;

    return-object v0
.end method

.method private c(IF)V
    .locals 1

    sparse-switch p1, :sswitch_data_0

    :goto_0
    return-void

    :sswitch_0
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setTranslationX(F)V

    goto :goto_0

    :sswitch_1
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setTranslationY(F)V

    goto :goto_0

    :sswitch_2
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setRotation(F)V

    goto :goto_0

    :sswitch_3
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setRotationX(F)V

    goto :goto_0

    :sswitch_4
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setRotationY(F)V

    goto :goto_0

    :sswitch_5
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setScaleX(F)V

    goto :goto_0

    :sswitch_6
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setScaleY(F)V

    goto :goto_0

    :sswitch_7
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setX(F)V

    goto :goto_0

    :sswitch_8
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setY(F)V

    goto :goto_0

    :sswitch_9
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->a:Lcom/nineoldandroids/view/animation/AnimatorProxy;

    invoke-virtual {v0, p2}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setAlpha(F)V

    goto :goto_0

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x2 -> :sswitch_1
        0x4 -> :sswitch_5
        0x8 -> :sswitch_6
        0x10 -> :sswitch_2
        0x20 -> :sswitch_3
        0x40 -> :sswitch_4
        0x80 -> :sswitch_7
        0x100 -> :sswitch_8
        0x200 -> :sswitch_9
    .end sparse-switch
.end method

.method static synthetic d(Lcom/nineoldandroids/view/i;)Ljava/lang/ref/WeakReference;
    .locals 1

    iget-object v0, p0, Lcom/nineoldandroids/view/i;->b:Ljava/lang/ref/WeakReference;

    return-object v0
.end method


# virtual methods
.method public final alpha(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/16 v0, 0x200

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->a(IF)V

    return-object p0
.end method

.method public final alphaBy(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/16 v0, 0x200

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->b(IF)V

    return-object p0
.end method

.method public final cancel()V
    .locals 2

    iget-object v0, p0, Lcom/nineoldandroids/view/i;->y:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->size()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/nineoldandroids/view/i;->y:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-nez v0, :cond_2

    :cond_0
    iget-object v0, p0, Lcom/nineoldandroids/view/i;->k:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    iget-object v0, p0, Lcom/nineoldandroids/view/i;->b:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    if-eqz v0, :cond_1

    iget-object v1, p0, Lcom/nineoldandroids/view/i;->x:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    :cond_1
    return-void

    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/nineoldandroids/animation/Animator;

    invoke-virtual {v0}, Lcom/nineoldandroids/animation/Animator;->cancel()V

    goto :goto_0
.end method

.method public final getDuration()J
    .locals 2

    iget-boolean v0, p0, Lcom/nineoldandroids/view/i;->d:Z

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/nineoldandroids/view/i;->c:J

    :goto_0
    return-wide v0

    :cond_0
    new-instance v0, Lcom/nineoldandroids/animation/ValueAnimator;

    invoke-direct {v0}, Lcom/nineoldandroids/animation/ValueAnimator;-><init>()V

    invoke-virtual {v0}, Lcom/nineoldandroids/animation/ValueAnimator;->getDuration()J

    move-result-wide v0

    goto :goto_0
.end method

.method public final getStartDelay()J
    .locals 2

    iget-boolean v0, p0, Lcom/nineoldandroids/view/i;->f:Z

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/nineoldandroids/view/i;->e:J

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
.end method

.method public final rotation(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/16 v0, 0x10

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->a(IF)V

    return-object p0
.end method

.method public final rotationBy(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/16 v0, 0x10

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->b(IF)V

    return-object p0
.end method

.method public final rotationX(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/16 v0, 0x20

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->a(IF)V

    return-object p0
.end method

.method public final rotationXBy(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/16 v0, 0x20

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->b(IF)V

    return-object p0
.end method

.method public final rotationY(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/16 v0, 0x40

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->a(IF)V

    return-object p0
.end method

.method public final rotationYBy(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/16 v0, 0x40

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->b(IF)V

    return-object p0
.end method

.method public final scaleX(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/4 v0, 0x4

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->a(IF)V

    return-object p0
.end method

.method public final scaleXBy(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/4 v0, 0x4

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->b(IF)V

    return-object p0
.end method

.method public final scaleY(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/16 v0, 0x8

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->a(IF)V

    return-object p0
.end method

.method public final scaleYBy(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/16 v0, 0x8

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->b(IF)V

    return-object p0
.end method

.method public final setDuration(J)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 3

    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Animators cannot have negative duration: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/nineoldandroids/view/i;->d:Z

    iput-wide p1, p0, Lcom/nineoldandroids/view/i;->c:J

    return-object p0
.end method

.method public final setInterpolator(Landroid/view/animation/Interpolator;)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/nineoldandroids/view/i;->h:Z

    iput-object p1, p0, Lcom/nineoldandroids/view/i;->g:Landroid/view/animation/Interpolator;

    return-object p0
.end method

.method public final setListener(Lcom/nineoldandroids/animation/Animator$AnimatorListener;)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 0

    iput-object p1, p0, Lcom/nineoldandroids/view/i;->i:Lcom/nineoldandroids/animation/Animator$AnimatorListener;

    return-object p0
.end method

.method public final setStartDelay(J)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 3

    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Animators cannot have negative duration: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/nineoldandroids/view/i;->f:Z

    iput-wide p1, p0, Lcom/nineoldandroids/view/i;->e:J

    return-object p0
.end method

.method public final start()V
    .locals 0

    invoke-direct {p0}, Lcom/nineoldandroids/view/i;->a()V

    return-void
.end method

.method public final translationX(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/4 v0, 0x1

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->a(IF)V

    return-object p0
.end method

.method public final translationXBy(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/4 v0, 0x1

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->b(IF)V

    return-object p0
.end method

.method public final translationY(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/4 v0, 0x2

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->a(IF)V

    return-object p0
.end method

.method public final translationYBy(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/4 v0, 0x2

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->b(IF)V

    return-object p0
.end method

.method public final x(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/16 v0, 0x80

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->a(IF)V

    return-object p0
.end method

.method public final xBy(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/16 v0, 0x80

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->b(IF)V

    return-object p0
.end method

.method public final y(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/16 v0, 0x100

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->a(IF)V

    return-object p0
.end method

.method public final yBy(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;
    .locals 1

    const/16 v0, 0x100

    invoke-direct {p0, v0, p1}, Lcom/nineoldandroids/view/i;->b(IF)V

    return-object p0
.end method
