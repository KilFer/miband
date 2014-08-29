.class final Landroid/support/v4/view/j;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/support/v4/view/i;


# static fields
.field private static final e:I

.field private static final f:I

.field private static final g:I

.field private static final h:I = 0x1

.field private static final i:I = 0x2

.field private static final j:I = 0x3


# instance fields
.field private A:Landroid/view/VelocityTracker;

.field private a:I

.field private b:I

.field private c:I

.field private d:I

.field private final k:Landroid/os/Handler;

.field private final l:Landroid/view/GestureDetector$OnGestureListener;

.field private m:Landroid/view/GestureDetector$OnDoubleTapListener;

.field private n:Z

.field private o:Z

.field private p:Z

.field private q:Z

.field private r:Z

.field private s:Landroid/view/MotionEvent;

.field private t:Landroid/view/MotionEvent;

.field private u:Z

.field private v:F

.field private w:F

.field private x:F

.field private y:F

.field private z:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    invoke-static {}, Landroid/view/ViewConfiguration;->getLongPressTimeout()I

    move-result v0

    sput v0, Landroid/support/v4/view/j;->e:I

    invoke-static {}, Landroid/view/ViewConfiguration;->getTapTimeout()I

    move-result v0

    sput v0, Landroid/support/v4/view/j;->f:I

    invoke-static {}, Landroid/view/ViewConfiguration;->getDoubleTapTimeout()I

    move-result v0

    sput v0, Landroid/support/v4/view/j;->g:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;Landroid/os/Handler;)V
    .locals 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-eqz p3, :cond_1

    new-instance v0, Landroid/support/v4/view/k;

    invoke-direct {v0, p0, p3}, Landroid/support/v4/view/k;-><init>(Landroid/support/v4/view/j;Landroid/os/Handler;)V

    iput-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    :goto_0
    iput-object p2, p0, Landroid/support/v4/view/j;->l:Landroid/view/GestureDetector$OnGestureListener;

    instance-of v0, p2, Landroid/view/GestureDetector$OnDoubleTapListener;

    if-eqz v0, :cond_0

    check-cast p2, Landroid/view/GestureDetector$OnDoubleTapListener;

    iput-object p2, p0, Landroid/support/v4/view/j;->m:Landroid/view/GestureDetector$OnDoubleTapListener;

    :cond_0
    if-nez p1, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Context must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    new-instance v0, Landroid/support/v4/view/k;

    invoke-direct {v0, p0}, Landroid/support/v4/view/k;-><init>(Landroid/support/v4/view/j;)V

    iput-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    goto :goto_0

    :cond_2
    iget-object v0, p0, Landroid/support/v4/view/j;->l:Landroid/view/GestureDetector$OnGestureListener;

    if-nez v0, :cond_3

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "OnGestureListener must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/view/j;->z:Z

    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v1

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledDoubleTapSlop()I

    move-result v2

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMinimumFlingVelocity()I

    move-result v3

    iput v3, p0, Landroid/support/v4/view/j;->c:I

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMaximumFlingVelocity()I

    move-result v0

    iput v0, p0, Landroid/support/v4/view/j;->d:I

    mul-int v0, v1, v1

    iput v0, p0, Landroid/support/v4/view/j;->a:I

    mul-int v0, v2, v2

    iput v0, p0, Landroid/support/v4/view/j;->b:I

    return-void
.end method

.method static synthetic a(Landroid/support/v4/view/j;)Landroid/view/MotionEvent;
    .locals 1

    iget-object v0, p0, Landroid/support/v4/view/j;->s:Landroid/view/MotionEvent;

    return-object v0
.end method

.method private a()V
    .locals 3

    const/4 v2, 0x0

    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    invoke-virtual {v0}, Landroid/view/VelocityTracker;->recycle()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    iput-boolean v2, p0, Landroid/support/v4/view/j;->u:Z

    iput-boolean v2, p0, Landroid/support/v4/view/j;->n:Z

    iput-boolean v2, p0, Landroid/support/v4/view/j;->q:Z

    iput-boolean v2, p0, Landroid/support/v4/view/j;->r:Z

    iput-boolean v2, p0, Landroid/support/v4/view/j;->o:Z

    iget-boolean v0, p0, Landroid/support/v4/view/j;->p:Z

    if-eqz v0, :cond_0

    iput-boolean v2, p0, Landroid/support/v4/view/j;->p:Z

    :cond_0
    return-void
.end method

.method private a(Landroid/content/Context;)V
    .locals 4

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Context must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Landroid/support/v4/view/j;->l:Landroid/view/GestureDetector$OnGestureListener;

    if-nez v0, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "OnGestureListener must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/view/j;->z:Z

    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v1

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledDoubleTapSlop()I

    move-result v2

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMinimumFlingVelocity()I

    move-result v3

    iput v3, p0, Landroid/support/v4/view/j;->c:I

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledMaximumFlingVelocity()I

    move-result v0

    iput v0, p0, Landroid/support/v4/view/j;->d:I

    mul-int v0, v1, v1

    iput v0, p0, Landroid/support/v4/view/j;->a:I

    mul-int v0, v2, v2

    iput v0, p0, Landroid/support/v4/view/j;->b:I

    return-void
.end method

.method static synthetic a(Landroid/support/v4/view/j;Z)Z
    .locals 1

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/view/j;->o:Z

    return v0
.end method

.method private a(Landroid/view/MotionEvent;Landroid/view/MotionEvent;Landroid/view/MotionEvent;)Z
    .locals 5

    const/4 v0, 0x0

    iget-boolean v1, p0, Landroid/support/v4/view/j;->r:Z

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p3}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v1

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v3

    sub-long/2addr v1, v3

    sget v3, Landroid/support/v4/view/j;->g:I

    int-to-long v3, v3

    cmp-long v1, v1, v3

    if-gtz v1, :cond_0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {p3}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    float-to-int v2, v2

    sub-int/2addr v1, v2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    float-to-int v2, v2

    invoke-virtual {p3}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    float-to-int v3, v3

    sub-int/2addr v2, v3

    mul-int/2addr v1, v1

    mul-int/2addr v2, v2

    add-int/2addr v1, v2

    iget v2, p0, Landroid/support/v4/view/j;->b:I

    if-ge v1, v2, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method static synthetic b(Landroid/support/v4/view/j;)Landroid/view/GestureDetector$OnGestureListener;
    .locals 1

    iget-object v0, p0, Landroid/support/v4/view/j;->l:Landroid/view/GestureDetector$OnGestureListener;

    return-object v0
.end method

.method private c()V
    .locals 3

    const/4 v2, 0x0

    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    iput-boolean v2, p0, Landroid/support/v4/view/j;->u:Z

    iput-boolean v2, p0, Landroid/support/v4/view/j;->q:Z

    iput-boolean v2, p0, Landroid/support/v4/view/j;->r:Z

    iput-boolean v2, p0, Landroid/support/v4/view/j;->o:Z

    iget-boolean v0, p0, Landroid/support/v4/view/j;->p:Z

    if-eqz v0, :cond_0

    iput-boolean v2, p0, Landroid/support/v4/view/j;->p:Z

    :cond_0
    return-void
.end method

.method static synthetic c(Landroid/support/v4/view/j;)V
    .locals 2

    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/view/j;->o:Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/view/j;->p:Z

    iget-object v0, p0, Landroid/support/v4/view/j;->l:Landroid/view/GestureDetector$OnGestureListener;

    iget-object v1, p0, Landroid/support/v4/view/j;->s:Landroid/view/MotionEvent;

    invoke-interface {v0, v1}, Landroid/view/GestureDetector$OnGestureListener;->onLongPress(Landroid/view/MotionEvent;)V

    return-void
.end method

.method static synthetic d(Landroid/support/v4/view/j;)Landroid/view/GestureDetector$OnDoubleTapListener;
    .locals 1

    iget-object v0, p0, Landroid/support/v4/view/j;->m:Landroid/view/GestureDetector$OnDoubleTapListener;

    return-object v0
.end method

.method private d()V
    .locals 2

    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/view/j;->o:Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/view/j;->p:Z

    iget-object v0, p0, Landroid/support/v4/view/j;->l:Landroid/view/GestureDetector$OnGestureListener;

    iget-object v1, p0, Landroid/support/v4/view/j;->s:Landroid/view/MotionEvent;

    invoke-interface {v0, v1}, Landroid/view/GestureDetector$OnGestureListener;->onLongPress(Landroid/view/MotionEvent;)V

    return-void
.end method

.method static synthetic e(Landroid/support/v4/view/j;)Z
    .locals 1

    iget-boolean v0, p0, Landroid/support/v4/view/j;->n:Z

    return v0
.end method


# virtual methods
.method public final a(Landroid/view/GestureDetector$OnDoubleTapListener;)V
    .locals 0

    iput-object p1, p0, Landroid/support/v4/view/j;->m:Landroid/view/GestureDetector$OnDoubleTapListener;

    return-void
.end method

.method public final a(Z)V
    .locals 0

    iput-boolean p1, p0, Landroid/support/v4/view/j;->z:Z

    return-void
.end method

.method public final a(Landroid/view/MotionEvent;)Z
    .locals 13

    const/4 v7, 0x0

    const/4 v12, 0x2

    const/4 v11, 0x3

    const/4 v4, 0x1

    const/4 v3, 0x0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v9

    iget-object v0, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    if-nez v0, :cond_0

    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    :cond_0
    iget-object v0, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    invoke-virtual {v0, p1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    and-int/lit16 v0, v9, 0xff

    const/4 v1, 0x6

    if-ne v0, v1, :cond_2

    move v8, v4

    :goto_0
    if-eqz v8, :cond_3

    invoke-static {p1}, Landroid/support/v4/view/MotionEventCompat;->getActionIndex(Landroid/view/MotionEvent;)I

    move-result v0

    :goto_1
    invoke-static {p1}, Landroid/support/v4/view/MotionEventCompat;->getPointerCount(Landroid/view/MotionEvent;)I

    move-result v5

    move v6, v3

    move v1, v7

    move v2, v7

    :goto_2
    if-ge v6, v5, :cond_4

    if-eq v0, v6, :cond_1

    invoke-static {p1, v6}, Landroid/support/v4/view/MotionEventCompat;->getX(Landroid/view/MotionEvent;I)F

    move-result v10

    add-float/2addr v2, v10

    invoke-static {p1, v6}, Landroid/support/v4/view/MotionEventCompat;->getY(Landroid/view/MotionEvent;I)F

    move-result v10

    add-float/2addr v1, v10

    :cond_1
    add-int/lit8 v6, v6, 0x1

    goto :goto_2

    :cond_2
    move v8, v3

    goto :goto_0

    :cond_3
    const/4 v0, -0x1

    goto :goto_1

    :cond_4
    if-eqz v8, :cond_6

    add-int/lit8 v0, v5, -0x1

    :goto_3
    int-to-float v6, v0

    div-float/2addr v2, v6

    int-to-float v0, v0

    div-float/2addr v1, v0

    and-int/lit16 v0, v9, 0xff

    packed-switch v0, :pswitch_data_0

    :cond_5
    :goto_4
    :pswitch_0
    return v3

    :cond_6
    move v0, v5

    goto :goto_3

    :pswitch_1
    iput v2, p0, Landroid/support/v4/view/j;->v:F

    iput v2, p0, Landroid/support/v4/view/j;->x:F

    iput v1, p0, Landroid/support/v4/view/j;->w:F

    iput v1, p0, Landroid/support/v4/view/j;->y:F

    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    invoke-virtual {v0, v4}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    invoke-virtual {v0, v12}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    invoke-virtual {v0, v11}, Landroid/os/Handler;->removeMessages(I)V

    iput-boolean v3, p0, Landroid/support/v4/view/j;->u:Z

    iput-boolean v3, p0, Landroid/support/v4/view/j;->q:Z

    iput-boolean v3, p0, Landroid/support/v4/view/j;->r:Z

    iput-boolean v3, p0, Landroid/support/v4/view/j;->o:Z

    iget-boolean v0, p0, Landroid/support/v4/view/j;->p:Z

    if-eqz v0, :cond_5

    iput-boolean v3, p0, Landroid/support/v4/view/j;->p:Z

    goto :goto_4

    :pswitch_2
    iput v2, p0, Landroid/support/v4/view/j;->v:F

    iput v2, p0, Landroid/support/v4/view/j;->x:F

    iput v1, p0, Landroid/support/v4/view/j;->w:F

    iput v1, p0, Landroid/support/v4/view/j;->y:F

    iget-object v0, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    const/16 v1, 0x3e8

    iget v2, p0, Landroid/support/v4/view/j;->d:I

    int-to-float v2, v2

    invoke-virtual {v0, v1, v2}, Landroid/view/VelocityTracker;->computeCurrentVelocity(IF)V

    invoke-static {p1}, Landroid/support/v4/view/MotionEventCompat;->getActionIndex(Landroid/view/MotionEvent;)I

    move-result v1

    invoke-static {p1, v1}, Landroid/support/v4/view/MotionEventCompat;->getPointerId(Landroid/view/MotionEvent;I)I

    move-result v0

    iget-object v2, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    invoke-static {v2, v0}, Landroid/support/v4/view/VelocityTrackerCompat;->getXVelocity(Landroid/view/VelocityTracker;I)F

    move-result v2

    iget-object v4, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    invoke-static {v4, v0}, Landroid/support/v4/view/VelocityTrackerCompat;->getYVelocity(Landroid/view/VelocityTracker;I)F

    move-result v4

    move v0, v3

    :goto_5
    if-ge v0, v5, :cond_5

    if-eq v0, v1, :cond_7

    invoke-static {p1, v0}, Landroid/support/v4/view/MotionEventCompat;->getPointerId(Landroid/view/MotionEvent;I)I

    move-result v6

    iget-object v8, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    invoke-static {v8, v6}, Landroid/support/v4/view/VelocityTrackerCompat;->getXVelocity(Landroid/view/VelocityTracker;I)F

    move-result v8

    mul-float/2addr v8, v2

    iget-object v9, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    invoke-static {v9, v6}, Landroid/support/v4/view/VelocityTrackerCompat;->getYVelocity(Landroid/view/VelocityTracker;I)F

    move-result v6

    mul-float/2addr v6, v4

    add-float/2addr v6, v8

    cmpg-float v6, v6, v7

    if-gez v6, :cond_7

    iget-object v0, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    invoke-virtual {v0}, Landroid/view/VelocityTracker;->clear()V

    goto :goto_4

    :cond_7
    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    :pswitch_3
    iget-object v0, p0, Landroid/support/v4/view/j;->m:Landroid/view/GestureDetector$OnDoubleTapListener;

    if-eqz v0, :cond_d

    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    invoke-virtual {v0, v11}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v0

    if-eqz v0, :cond_8

    iget-object v5, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    invoke-virtual {v5, v11}, Landroid/os/Handler;->removeMessages(I)V

    :cond_8
    iget-object v5, p0, Landroid/support/v4/view/j;->s:Landroid/view/MotionEvent;

    if-eqz v5, :cond_c

    iget-object v5, p0, Landroid/support/v4/view/j;->t:Landroid/view/MotionEvent;

    if-eqz v5, :cond_c

    if-eqz v0, :cond_c

    iget-object v0, p0, Landroid/support/v4/view/j;->s:Landroid/view/MotionEvent;

    iget-object v5, p0, Landroid/support/v4/view/j;->t:Landroid/view/MotionEvent;

    iget-boolean v6, p0, Landroid/support/v4/view/j;->r:Z

    if-eqz v6, :cond_b

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v6

    invoke-virtual {v5}, Landroid/view/MotionEvent;->getEventTime()J

    move-result-wide v8

    sub-long v5, v6, v8

    sget v7, Landroid/support/v4/view/j;->g:I

    int-to-long v7, v7

    cmp-long v5, v5, v7

    if-gtz v5, :cond_b

    invoke-virtual {v0}, Landroid/view/MotionEvent;->getX()F

    move-result v5

    float-to-int v5, v5

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v6

    float-to-int v6, v6

    sub-int/2addr v5, v6

    invoke-virtual {v0}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    float-to-int v0, v0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v6

    float-to-int v6, v6

    sub-int/2addr v0, v6

    mul-int/2addr v5, v5

    mul-int/2addr v0, v0

    add-int/2addr v0, v5

    iget v5, p0, Landroid/support/v4/view/j;->b:I

    if-ge v0, v5, :cond_b

    move v0, v4

    :goto_6
    if-eqz v0, :cond_c

    iput-boolean v4, p0, Landroid/support/v4/view/j;->u:Z

    iget-object v0, p0, Landroid/support/v4/view/j;->m:Landroid/view/GestureDetector$OnDoubleTapListener;

    iget-object v5, p0, Landroid/support/v4/view/j;->s:Landroid/view/MotionEvent;

    invoke-interface {v0, v5}, Landroid/view/GestureDetector$OnDoubleTapListener;->onDoubleTap(Landroid/view/MotionEvent;)Z

    move-result v0

    or-int/lit8 v0, v0, 0x0

    iget-object v5, p0, Landroid/support/v4/view/j;->m:Landroid/view/GestureDetector$OnDoubleTapListener;

    invoke-interface {v5, p1}, Landroid/view/GestureDetector$OnDoubleTapListener;->onDoubleTapEvent(Landroid/view/MotionEvent;)Z

    move-result v5

    or-int/2addr v0, v5

    :goto_7
    iput v2, p0, Landroid/support/v4/view/j;->v:F

    iput v2, p0, Landroid/support/v4/view/j;->x:F

    iput v1, p0, Landroid/support/v4/view/j;->w:F

    iput v1, p0, Landroid/support/v4/view/j;->y:F

    iget-object v1, p0, Landroid/support/v4/view/j;->s:Landroid/view/MotionEvent;

    if-eqz v1, :cond_9

    iget-object v1, p0, Landroid/support/v4/view/j;->s:Landroid/view/MotionEvent;

    invoke-virtual {v1}, Landroid/view/MotionEvent;->recycle()V

    :cond_9
    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v1

    iput-object v1, p0, Landroid/support/v4/view/j;->s:Landroid/view/MotionEvent;

    iput-boolean v4, p0, Landroid/support/v4/view/j;->q:Z

    iput-boolean v4, p0, Landroid/support/v4/view/j;->r:Z

    iput-boolean v4, p0, Landroid/support/v4/view/j;->n:Z

    iput-boolean v3, p0, Landroid/support/v4/view/j;->p:Z

    iput-boolean v3, p0, Landroid/support/v4/view/j;->o:Z

    iget-boolean v1, p0, Landroid/support/v4/view/j;->z:Z

    if-eqz v1, :cond_a

    iget-object v1, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    invoke-virtual {v1, v12}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v1, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    iget-object v2, p0, Landroid/support/v4/view/j;->s:Landroid/view/MotionEvent;

    invoke-virtual {v2}, Landroid/view/MotionEvent;->getDownTime()J

    move-result-wide v2

    sget v5, Landroid/support/v4/view/j;->f:I

    int-to-long v5, v5

    add-long/2addr v2, v5

    sget v5, Landroid/support/v4/view/j;->e:I

    int-to-long v5, v5

    add-long/2addr v2, v5

    invoke-virtual {v1, v12, v2, v3}, Landroid/os/Handler;->sendEmptyMessageAtTime(IJ)Z

    :cond_a
    iget-object v1, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    iget-object v2, p0, Landroid/support/v4/view/j;->s:Landroid/view/MotionEvent;

    invoke-virtual {v2}, Landroid/view/MotionEvent;->getDownTime()J

    move-result-wide v2

    sget v5, Landroid/support/v4/view/j;->f:I

    int-to-long v5, v5

    add-long/2addr v2, v5

    invoke-virtual {v1, v4, v2, v3}, Landroid/os/Handler;->sendEmptyMessageAtTime(IJ)Z

    iget-object v1, p0, Landroid/support/v4/view/j;->l:Landroid/view/GestureDetector$OnGestureListener;

    invoke-interface {v1, p1}, Landroid/view/GestureDetector$OnGestureListener;->onDown(Landroid/view/MotionEvent;)Z

    move-result v1

    or-int v3, v0, v1

    goto/16 :goto_4

    :cond_b
    move v0, v3

    goto :goto_6

    :cond_c
    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    sget v5, Landroid/support/v4/view/j;->g:I

    int-to-long v5, v5

    invoke-virtual {v0, v11, v5, v6}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    :cond_d
    move v0, v3

    goto :goto_7

    :pswitch_4
    iget-boolean v0, p0, Landroid/support/v4/view/j;->p:Z

    if-nez v0, :cond_5

    iget v0, p0, Landroid/support/v4/view/j;->v:F

    sub-float/2addr v0, v2

    iget v5, p0, Landroid/support/v4/view/j;->w:F

    sub-float/2addr v5, v1

    iget-boolean v6, p0, Landroid/support/v4/view/j;->u:Z

    if-eqz v6, :cond_e

    iget-object v0, p0, Landroid/support/v4/view/j;->m:Landroid/view/GestureDetector$OnDoubleTapListener;

    invoke-interface {v0, p1}, Landroid/view/GestureDetector$OnDoubleTapListener;->onDoubleTapEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    or-int/lit8 v3, v0, 0x0

    goto/16 :goto_4

    :cond_e
    iget-boolean v6, p0, Landroid/support/v4/view/j;->q:Z

    if-eqz v6, :cond_10

    iget v6, p0, Landroid/support/v4/view/j;->x:F

    sub-float v6, v2, v6

    float-to-int v6, v6

    iget v7, p0, Landroid/support/v4/view/j;->y:F

    sub-float v7, v1, v7

    float-to-int v7, v7

    mul-int/2addr v6, v6

    mul-int/2addr v7, v7

    add-int/2addr v6, v7

    iget v7, p0, Landroid/support/v4/view/j;->a:I

    if-le v6, v7, :cond_1a

    iget-object v7, p0, Landroid/support/v4/view/j;->l:Landroid/view/GestureDetector$OnGestureListener;

    iget-object v8, p0, Landroid/support/v4/view/j;->s:Landroid/view/MotionEvent;

    invoke-interface {v7, v8, p1, v0, v5}, Landroid/view/GestureDetector$OnGestureListener;->onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z

    move-result v0

    iput v2, p0, Landroid/support/v4/view/j;->v:F

    iput v1, p0, Landroid/support/v4/view/j;->w:F

    iput-boolean v3, p0, Landroid/support/v4/view/j;->q:Z

    iget-object v1, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    invoke-virtual {v1, v11}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v1, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    invoke-virtual {v1, v4}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v1, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    invoke-virtual {v1, v12}, Landroid/os/Handler;->removeMessages(I)V

    :goto_8
    iget v1, p0, Landroid/support/v4/view/j;->a:I

    if-le v6, v1, :cond_f

    iput-boolean v3, p0, Landroid/support/v4/view/j;->r:Z

    :cond_f
    move v3, v0

    goto/16 :goto_4

    :cond_10
    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v4

    const/high16 v6, 0x3f800000

    cmpl-float v4, v4, v6

    if-gez v4, :cond_11

    invoke-static {v5}, Ljava/lang/Math;->abs(F)F

    move-result v4

    const/high16 v6, 0x3f800000

    cmpl-float v4, v4, v6

    if-ltz v4, :cond_5

    :cond_11
    iget-object v3, p0, Landroid/support/v4/view/j;->l:Landroid/view/GestureDetector$OnGestureListener;

    iget-object v4, p0, Landroid/support/v4/view/j;->s:Landroid/view/MotionEvent;

    invoke-interface {v3, v4, p1, v0, v5}, Landroid/view/GestureDetector$OnGestureListener;->onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z

    move-result v3

    iput v2, p0, Landroid/support/v4/view/j;->v:F

    iput v1, p0, Landroid/support/v4/view/j;->w:F

    goto/16 :goto_4

    :pswitch_5
    iput-boolean v3, p0, Landroid/support/v4/view/j;->n:Z

    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v1

    iget-boolean v0, p0, Landroid/support/v4/view/j;->u:Z

    if-eqz v0, :cond_15

    iget-object v0, p0, Landroid/support/v4/view/j;->m:Landroid/view/GestureDetector$OnDoubleTapListener;

    invoke-interface {v0, p1}, Landroid/view/GestureDetector$OnDoubleTapListener;->onDoubleTapEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    or-int/lit8 v0, v0, 0x0

    :cond_12
    :goto_9
    iget-object v2, p0, Landroid/support/v4/view/j;->t:Landroid/view/MotionEvent;

    if-eqz v2, :cond_13

    iget-object v2, p0, Landroid/support/v4/view/j;->t:Landroid/view/MotionEvent;

    invoke-virtual {v2}, Landroid/view/MotionEvent;->recycle()V

    :cond_13
    iput-object v1, p0, Landroid/support/v4/view/j;->t:Landroid/view/MotionEvent;

    iget-object v1, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    if-eqz v1, :cond_14

    iget-object v1, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    invoke-virtual {v1}, Landroid/view/VelocityTracker;->recycle()V

    const/4 v1, 0x0

    iput-object v1, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    :cond_14
    iput-boolean v3, p0, Landroid/support/v4/view/j;->u:Z

    iput-boolean v3, p0, Landroid/support/v4/view/j;->o:Z

    iget-object v1, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    invoke-virtual {v1, v4}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v1, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    invoke-virtual {v1, v12}, Landroid/os/Handler;->removeMessages(I)V

    move v3, v0

    goto/16 :goto_4

    :cond_15
    iget-boolean v0, p0, Landroid/support/v4/view/j;->p:Z

    if-eqz v0, :cond_16

    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    invoke-virtual {v0, v11}, Landroid/os/Handler;->removeMessages(I)V

    iput-boolean v3, p0, Landroid/support/v4/view/j;->p:Z

    move v0, v3

    goto :goto_9

    :cond_16
    iget-boolean v0, p0, Landroid/support/v4/view/j;->q:Z

    if-eqz v0, :cond_17

    iget-object v0, p0, Landroid/support/v4/view/j;->l:Landroid/view/GestureDetector$OnGestureListener;

    invoke-interface {v0, p1}, Landroid/view/GestureDetector$OnGestureListener;->onSingleTapUp(Landroid/view/MotionEvent;)Z

    move-result v0

    iget-boolean v2, p0, Landroid/support/v4/view/j;->o:Z

    if-eqz v2, :cond_12

    iget-object v2, p0, Landroid/support/v4/view/j;->m:Landroid/view/GestureDetector$OnDoubleTapListener;

    if-eqz v2, :cond_12

    iget-object v2, p0, Landroid/support/v4/view/j;->m:Landroid/view/GestureDetector$OnDoubleTapListener;

    invoke-interface {v2, p1}, Landroid/view/GestureDetector$OnDoubleTapListener;->onSingleTapConfirmed(Landroid/view/MotionEvent;)Z

    goto :goto_9

    :cond_17
    iget-object v0, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    invoke-static {p1, v3}, Landroid/support/v4/view/MotionEventCompat;->getPointerId(Landroid/view/MotionEvent;I)I

    move-result v2

    const/16 v5, 0x3e8

    iget v6, p0, Landroid/support/v4/view/j;->d:I

    int-to-float v6, v6

    invoke-virtual {v0, v5, v6}, Landroid/view/VelocityTracker;->computeCurrentVelocity(IF)V

    invoke-static {v0, v2}, Landroid/support/v4/view/VelocityTrackerCompat;->getYVelocity(Landroid/view/VelocityTracker;I)F

    move-result v5

    invoke-static {v0, v2}, Landroid/support/v4/view/VelocityTrackerCompat;->getXVelocity(Landroid/view/VelocityTracker;I)F

    move-result v0

    invoke-static {v5}, Ljava/lang/Math;->abs(F)F

    move-result v2

    iget v6, p0, Landroid/support/v4/view/j;->c:I

    int-to-float v6, v6

    cmpl-float v2, v2, v6

    if-gtz v2, :cond_18

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v2

    iget v6, p0, Landroid/support/v4/view/j;->c:I

    int-to-float v6, v6

    cmpl-float v2, v2, v6

    if-lez v2, :cond_19

    :cond_18
    iget-object v2, p0, Landroid/support/v4/view/j;->l:Landroid/view/GestureDetector$OnGestureListener;

    iget-object v6, p0, Landroid/support/v4/view/j;->s:Landroid/view/MotionEvent;

    invoke-interface {v2, v6, p1, v0, v5}, Landroid/view/GestureDetector$OnGestureListener;->onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z

    move-result v0

    goto/16 :goto_9

    :pswitch_6
    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    invoke-virtual {v0, v4}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    invoke-virtual {v0, v12}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Landroid/support/v4/view/j;->k:Landroid/os/Handler;

    invoke-virtual {v0, v11}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    invoke-virtual {v0}, Landroid/view/VelocityTracker;->recycle()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/view/j;->A:Landroid/view/VelocityTracker;

    iput-boolean v3, p0, Landroid/support/v4/view/j;->u:Z

    iput-boolean v3, p0, Landroid/support/v4/view/j;->n:Z

    iput-boolean v3, p0, Landroid/support/v4/view/j;->q:Z

    iput-boolean v3, p0, Landroid/support/v4/view/j;->r:Z

    iput-boolean v3, p0, Landroid/support/v4/view/j;->o:Z

    iget-boolean v0, p0, Landroid/support/v4/view/j;->p:Z

    if-eqz v0, :cond_5

    iput-boolean v3, p0, Landroid/support/v4/view/j;->p:Z

    goto/16 :goto_4

    :cond_19
    move v0, v3

    goto/16 :goto_9

    :cond_1a
    move v0, v3

    goto/16 :goto_8

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_5
        :pswitch_4
        :pswitch_6
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public final b()Z
    .locals 1

    iget-boolean v0, p0, Landroid/support/v4/view/j;->z:Z

    return v0
.end method
