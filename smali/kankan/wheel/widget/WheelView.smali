.class public Lkankan/wheel/widget/WheelView;
.super Landroid/view/View;


# static fields
.field private static final a:[I = null

.field private static final b:I = 0xa

.field private static final c:I = 0xa

.field private static final d:I = 0x5

.field private static final e:Ljava/lang/String; = "WheelView"


# instance fields
.field private A:F

.field private B:Lkankan/wheel/widget/WheelScroller$ScrollingListener;

.field private C:Landroid/database/DataSetObserver;

.field private f:I

.field private g:I

.field private h:I

.field private i:Landroid/graphics/drawable/Drawable;

.field private j:Landroid/graphics/drawable/GradientDrawable;

.field private k:Landroid/graphics/drawable/GradientDrawable;

.field private l:Lkankan/wheel/widget/WheelScroller;

.field private m:Z

.field private n:I

.field private o:Z

.field private p:Landroid/widget/LinearLayout;

.field private q:I

.field private r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

.field private s:Lkankan/wheel/widget/WheelRecycle;

.field private t:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lkankan/wheel/widget/OnWheelChangedListener;",
            ">;"
        }
    .end annotation
.end field

.field private u:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lkankan/wheel/widget/OnWheelScrollListener;",
            ">;"
        }
    .end annotation
.end field

.field private v:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lkankan/wheel/widget/OnWheelClickedListener;",
            ">;"
        }
    .end annotation
.end field

.field private w:I

.field private x:Landroid/graphics/Paint;

.field private y:Ljava/lang/String;

.field private z:F


# direct methods
.method static constructor <clinit>()V
    .locals 4

    const v3, 0xaaaaaa

    const/4 v0, 0x3

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, -0xeeeeef

    aput v2, v0, v1

    const/4 v1, 0x1

    aput v3, v0, v1

    const/4 v1, 0x2

    aput v3, v0, v1

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    iput v1, p0, Lkankan/wheel/widget/WheelView;->f:I

    const/4 v0, 0x5

    iput v0, p0, Lkankan/wheel/widget/WheelView;->g:I

    iput v1, p0, Lkankan/wheel/widget/WheelView;->h:I

    iput-boolean v1, p0, Lkankan/wheel/widget/WheelView;->o:Z

    new-instance v0, Lkankan/wheel/widget/WheelRecycle;

    invoke-direct {v0, p0}, Lkankan/wheel/widget/WheelRecycle;-><init>(Lkankan/wheel/widget/WheelView;)V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->s:Lkankan/wheel/widget/WheelRecycle;

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->t:Ljava/util/List;

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->u:Ljava/util/List;

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->v:Ljava/util/List;

    const v0, 0x7f0200b4

    iput v0, p0, Lkankan/wheel/widget/WheelView;->w:I

    const-string v0, ""

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->y:Ljava/lang/String;

    const/high16 v0, 0x42480000

    iput v0, p0, Lkankan/wheel/widget/WheelView;->z:F

    const/high16 v0, 0x42a00000

    iput v0, p0, Lkankan/wheel/widget/WheelView;->A:F

    new-instance v0, Lkankan/wheel/widget/c;

    invoke-direct {v0, p0}, Lkankan/wheel/widget/c;-><init>(Lkankan/wheel/widget/WheelView;)V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->B:Lkankan/wheel/widget/WheelScroller$ScrollingListener;

    new-instance v0, Lkankan/wheel/widget/d;

    invoke-direct {v0, p0}, Lkankan/wheel/widget/d;-><init>(Lkankan/wheel/widget/WheelView;)V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->C:Landroid/database/DataSetObserver;

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->a()V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    iput v1, p0, Lkankan/wheel/widget/WheelView;->f:I

    const/4 v0, 0x5

    iput v0, p0, Lkankan/wheel/widget/WheelView;->g:I

    iput v1, p0, Lkankan/wheel/widget/WheelView;->h:I

    iput-boolean v1, p0, Lkankan/wheel/widget/WheelView;->o:Z

    new-instance v0, Lkankan/wheel/widget/WheelRecycle;

    invoke-direct {v0, p0}, Lkankan/wheel/widget/WheelRecycle;-><init>(Lkankan/wheel/widget/WheelView;)V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->s:Lkankan/wheel/widget/WheelRecycle;

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->t:Ljava/util/List;

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->u:Ljava/util/List;

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->v:Ljava/util/List;

    const v0, 0x7f0200b4

    iput v0, p0, Lkankan/wheel/widget/WheelView;->w:I

    const-string v0, ""

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->y:Ljava/lang/String;

    const/high16 v0, 0x42480000

    iput v0, p0, Lkankan/wheel/widget/WheelView;->z:F

    const/high16 v0, 0x42a00000

    iput v0, p0, Lkankan/wheel/widget/WheelView;->A:F

    new-instance v0, Lkankan/wheel/widget/c;

    invoke-direct {v0, p0}, Lkankan/wheel/widget/c;-><init>(Lkankan/wheel/widget/WheelView;)V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->B:Lkankan/wheel/widget/WheelScroller$ScrollingListener;

    new-instance v0, Lkankan/wheel/widget/d;

    invoke-direct {v0, p0}, Lkankan/wheel/widget/d;-><init>(Lkankan/wheel/widget/WheelView;)V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->C:Landroid/database/DataSetObserver;

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->a()V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2, p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    iput v1, p0, Lkankan/wheel/widget/WheelView;->f:I

    const/4 v0, 0x5

    iput v0, p0, Lkankan/wheel/widget/WheelView;->g:I

    iput v1, p0, Lkankan/wheel/widget/WheelView;->h:I

    iput-boolean v1, p0, Lkankan/wheel/widget/WheelView;->o:Z

    new-instance v0, Lkankan/wheel/widget/WheelRecycle;

    invoke-direct {v0, p0}, Lkankan/wheel/widget/WheelRecycle;-><init>(Lkankan/wheel/widget/WheelView;)V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->s:Lkankan/wheel/widget/WheelRecycle;

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->t:Ljava/util/List;

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->u:Ljava/util/List;

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->v:Ljava/util/List;

    const v0, 0x7f0200b4

    iput v0, p0, Lkankan/wheel/widget/WheelView;->w:I

    const-string v0, ""

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->y:Ljava/lang/String;

    const/high16 v0, 0x42480000

    iput v0, p0, Lkankan/wheel/widget/WheelView;->z:F

    const/high16 v0, 0x42a00000

    iput v0, p0, Lkankan/wheel/widget/WheelView;->A:F

    new-instance v0, Lkankan/wheel/widget/c;

    invoke-direct {v0, p0}, Lkankan/wheel/widget/c;-><init>(Lkankan/wheel/widget/WheelView;)V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->B:Lkankan/wheel/widget/WheelScroller$ScrollingListener;

    new-instance v0, Lkankan/wheel/widget/d;

    invoke-direct {v0, p0}, Lkankan/wheel/widget/d;-><init>(Lkankan/wheel/widget/WheelView;)V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->C:Landroid/database/DataSetObserver;

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->a()V

    return-void
.end method

.method private a(II)I
    .locals 5

    const/high16 v4, 0x40000000

    const/4 v2, -0x2

    const/4 v3, 0x0

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->i:Landroid/graphics/drawable/Drawable;

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iget v1, p0, Lkankan/wheel/widget/WheelView;->w:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->i:Landroid/graphics/drawable/Drawable;

    :cond_0
    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->j:Landroid/graphics/drawable/GradientDrawable;

    if-nez v0, :cond_1

    new-instance v0, Landroid/graphics/drawable/GradientDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/GradientDrawable;-><init>()V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->j:Landroid/graphics/drawable/GradientDrawable;

    :cond_1
    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->k:Landroid/graphics/drawable/GradientDrawable;

    if-nez v0, :cond_2

    new-instance v0, Landroid/graphics/drawable/GradientDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/GradientDrawable;-><init>()V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->k:Landroid/graphics/drawable/GradientDrawable;

    :cond_2
    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-static {p1, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    invoke-static {v3, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/widget/LinearLayout;->measure(II)V

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getMeasuredWidth()I

    move-result v0

    if-ne p2, v4, :cond_4

    :cond_3
    :goto_0
    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    add-int/lit8 v1, p1, -0x14

    invoke-static {v1, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    invoke-static {v3, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/widget/LinearLayout;->measure(II)V

    return p1

    :cond_4
    add-int/lit8 v0, v0, 0x14

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getSuggestedMinimumWidth()I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    const/high16 v1, -0x80000000

    if-ne p2, v1, :cond_5

    if-lt p1, v0, :cond_3

    :cond_5
    move p1, v0

    goto :goto_0
.end method

.method private a(Landroid/widget/LinearLayout;)I
    .locals 2

    const/4 v1, 0x0

    if-eqz p1, :cond_0

    invoke-virtual {p1, v1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1, v1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    iput v0, p0, Lkankan/wheel/widget/WheelView;->h:I

    :cond_0
    iget v0, p0, Lkankan/wheel/widget/WheelView;->h:I

    iget v1, p0, Lkankan/wheel/widget/WheelView;->g:I

    mul-int/2addr v0, v1

    iget v1, p0, Lkankan/wheel/widget/WheelView;->h:I

    mul-int/lit8 v1, v1, 0xa

    div-int/lit8 v1, v1, 0x32

    sub-int/2addr v0, v1

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getSuggestedMinimumHeight()I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method static synthetic a(Lkankan/wheel/widget/WheelView;)I
    .locals 1

    iget v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    return v0
.end method

.method private a()V
    .locals 3

    new-instance v0, Lkankan/wheel/widget/WheelScroller;

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->B:Lkankan/wheel/widget/WheelScroller$ScrollingListener;

    invoke-direct {v0, v1, v2}, Lkankan/wheel/widget/WheelScroller;-><init>(Landroid/content/Context;Lkankan/wheel/widget/WheelScroller$ScrollingListener;)V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->l:Lkankan/wheel/widget/WheelScroller;

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->x:Landroid/graphics/Paint;

    new-instance v0, Lkankan/wheel/widget/e;

    invoke-direct {v0, p0}, Lkankan/wheel/widget/e;-><init>(Lkankan/wheel/widget/WheelView;)V

    invoke-virtual {p0, v0}, Lkankan/wheel/widget/WheelView;->addChangingListener(Lkankan/wheel/widget/OnWheelChangedListener;)V

    return-void
.end method

.method private a(I)V
    .locals 8

    const/4 v1, 0x0

    iget v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    add-int/2addr v0, p1

    iput v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v4

    iget v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    div-int v3, v0, v4

    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    sub-int v2, v0, v3

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    invoke-interface {v0}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getItemsCount()I

    move-result v5

    iget v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    rem-int/2addr v0, v4

    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v6

    div-int/lit8 v7, v4, 0x2

    if-gt v6, v7, :cond_0

    move v0, v1

    :cond_0
    iget-boolean v6, p0, Lkankan/wheel/widget/WheelView;->o:Z

    if-eqz v6, :cond_4

    if-lez v5, :cond_4

    if-lez v0, :cond_2

    add-int/lit8 v2, v2, -0x1

    add-int/lit8 v3, v3, 0x1

    move v0, v2

    move v2, v3

    :goto_0
    if-ltz v0, :cond_3

    rem-int/2addr v0, v5

    :goto_1
    iget v3, p0, Lkankan/wheel/widget/WheelView;->n:I

    iget v5, p0, Lkankan/wheel/widget/WheelView;->f:I

    if-eq v0, v5, :cond_8

    invoke-virtual {p0, v0, v1}, Lkankan/wheel/widget/WheelView;->setCurrentItem(IZ)V

    :goto_2
    mul-int v0, v2, v4

    sub-int v0, v3, v0

    iput v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    iget v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v1

    if-le v0, v1, :cond_1

    iget v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v1

    rem-int/2addr v0, v1

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    :cond_1
    return-void

    :cond_2
    if-gez v0, :cond_a

    add-int/lit8 v2, v2, 0x1

    add-int/lit8 v3, v3, -0x1

    move v0, v2

    move v2, v3

    goto :goto_0

    :cond_3
    add-int/2addr v0, v5

    goto :goto_0

    :cond_4
    if-gez v2, :cond_5

    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    move v2, v0

    move v0, v1

    goto :goto_1

    :cond_5
    if-lt v2, v5, :cond_6

    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    sub-int/2addr v0, v5

    add-int/lit8 v2, v0, 0x1

    add-int/lit8 v0, v5, -0x1

    goto :goto_1

    :cond_6
    if-lez v2, :cond_7

    if-lez v0, :cond_7

    add-int/lit8 v0, v2, -0x1

    add-int/lit8 v2, v3, 0x1

    goto :goto_1

    :cond_7
    add-int/lit8 v5, v5, -0x1

    if-ge v2, v5, :cond_9

    if-gez v0, :cond_9

    add-int/lit8 v0, v2, 0x1

    add-int/lit8 v2, v3, -0x1

    goto :goto_1

    :cond_8
    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->invalidate()V

    goto :goto_2

    :cond_9
    move v0, v2

    move v2, v3

    goto :goto_1

    :cond_a
    move v0, v2

    move v2, v3

    goto :goto_0
.end method

.method private a(Landroid/graphics/Canvas;)V
    .locals 5

    const/4 v4, 0x0

    const-wide/high16 v0, 0x3ff8000000000000L

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v2

    int-to-double v2, v2

    mul-double/2addr v0, v2

    double-to-int v0, v0

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->j:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getWidth()I

    move-result v2

    invoke-virtual {v1, v4, v4, v2, v0}, Landroid/graphics/drawable/GradientDrawable;->setBounds(IIII)V

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->j:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {v1, p1}, Landroid/graphics/drawable/GradientDrawable;->draw(Landroid/graphics/Canvas;)V

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->k:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v2

    sub-int v0, v2, v0

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getWidth()I

    move-result v2

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v3

    invoke-virtual {v1, v4, v0, v2, v3}, Landroid/graphics/drawable/GradientDrawable;->setBounds(IIII)V

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->k:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/GradientDrawable;->draw(Landroid/graphics/Canvas;)V

    return-void
.end method

.method static synthetic a(Lkankan/wheel/widget/WheelView;I)V
    .locals 8

    const/4 v1, 0x0

    iget v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    add-int/2addr v0, p1

    iput v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v4

    iget v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    div-int v3, v0, v4

    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    sub-int v2, v0, v3

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    invoke-interface {v0}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getItemsCount()I

    move-result v5

    iget v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    rem-int/2addr v0, v4

    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v6

    div-int/lit8 v7, v4, 0x2

    if-gt v6, v7, :cond_0

    move v0, v1

    :cond_0
    iget-boolean v6, p0, Lkankan/wheel/widget/WheelView;->o:Z

    if-eqz v6, :cond_4

    if-lez v5, :cond_4

    if-lez v0, :cond_2

    add-int/lit8 v2, v2, -0x1

    add-int/lit8 v3, v3, 0x1

    move v0, v2

    move v2, v3

    :goto_0
    if-ltz v0, :cond_3

    rem-int/2addr v0, v5

    :goto_1
    iget v3, p0, Lkankan/wheel/widget/WheelView;->n:I

    iget v5, p0, Lkankan/wheel/widget/WheelView;->f:I

    if-eq v0, v5, :cond_8

    invoke-virtual {p0, v0, v1}, Lkankan/wheel/widget/WheelView;->setCurrentItem(IZ)V

    :goto_2
    mul-int v0, v2, v4

    sub-int v0, v3, v0

    iput v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    iget v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v1

    if-le v0, v1, :cond_1

    iget v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v1

    rem-int/2addr v0, v1

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    :cond_1
    return-void

    :cond_2
    if-gez v0, :cond_a

    add-int/lit8 v2, v2, 0x1

    add-int/lit8 v3, v3, -0x1

    move v0, v2

    move v2, v3

    goto :goto_0

    :cond_3
    add-int/2addr v0, v5

    goto :goto_0

    :cond_4
    if-gez v2, :cond_5

    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    move v2, v0

    move v0, v1

    goto :goto_1

    :cond_5
    if-lt v2, v5, :cond_6

    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    sub-int/2addr v0, v5

    add-int/lit8 v2, v0, 0x1

    add-int/lit8 v0, v5, -0x1

    goto :goto_1

    :cond_6
    if-lez v2, :cond_7

    if-lez v0, :cond_7

    add-int/lit8 v0, v2, -0x1

    add-int/lit8 v2, v3, 0x1

    goto :goto_1

    :cond_7
    add-int/lit8 v5, v5, -0x1

    if-ge v2, v5, :cond_9

    if-gez v0, :cond_9

    add-int/lit8 v0, v2, 0x1

    add-int/lit8 v2, v3, -0x1

    goto :goto_1

    :cond_8
    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->invalidate()V

    goto :goto_2

    :cond_9
    move v0, v2

    move v2, v3

    goto :goto_1

    :cond_a
    move v0, v2

    move v2, v3

    goto :goto_0
.end method

.method static synthetic a(Lkankan/wheel/widget/WheelView;Z)V
    .locals 0

    iput-boolean p1, p0, Lkankan/wheel/widget/WheelView;->m:Z

    return-void
.end method

.method private a(IZ)Z
    .locals 5

    const/4 v0, 0x0

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    invoke-interface {v1}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getItemsCount()I

    move-result v1

    if-nez v1, :cond_2

    :cond_0
    const/4 v1, 0x0

    :goto_0
    if-eqz v1, :cond_1

    if-eqz p2, :cond_5

    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    :goto_1
    const/4 v0, 0x1

    :cond_1
    return v0

    :cond_2
    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    invoke-interface {v1}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getItemsCount()I

    move-result v1

    invoke-direct {p0, p1}, Lkankan/wheel/widget/WheelView;->b(I)Z

    move-result v2

    if-nez v2, :cond_4

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->s:Lkankan/wheel/widget/WheelRecycle;

    invoke-virtual {v2}, Lkankan/wheel/widget/WheelRecycle;->getEmptyItem()Landroid/view/View;

    move-result-object v2

    iget-object v3, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-interface {v1, v2, v3}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getEmptyItem(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    goto :goto_0

    :cond_3
    add-int/2addr p1, v1

    :cond_4
    if-ltz p1, :cond_3

    rem-int v1, p1, v1

    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    iget-object v3, p0, Lkankan/wheel/widget/WheelView;->s:Lkankan/wheel/widget/WheelRecycle;

    invoke-virtual {v3}, Lkankan/wheel/widget/WheelRecycle;->getItem()Landroid/view/View;

    move-result-object v3

    iget-object v4, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-interface {v2, v1, v3, v4}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getItem(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    goto :goto_0

    :cond_5
    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto :goto_1
.end method

.method static synthetic b(Lkankan/wheel/widget/WheelView;)Lkankan/wheel/widget/WheelScroller;
    .locals 1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->l:Lkankan/wheel/widget/WheelScroller;

    return-object v0
.end method

.method private b()V
    .locals 2

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->i:Landroid/graphics/drawable/Drawable;

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iget v1, p0, Lkankan/wheel/widget/WheelView;->w:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->i:Landroid/graphics/drawable/Drawable;

    :cond_0
    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->j:Landroid/graphics/drawable/GradientDrawable;

    if-nez v0, :cond_1

    new-instance v0, Landroid/graphics/drawable/GradientDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/GradientDrawable;-><init>()V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->j:Landroid/graphics/drawable/GradientDrawable;

    :cond_1
    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->k:Landroid/graphics/drawable/GradientDrawable;

    if-nez v0, :cond_2

    new-instance v0, Landroid/graphics/drawable/GradientDrawable;

    invoke-direct {v0}, Landroid/graphics/drawable/GradientDrawable;-><init>()V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->k:Landroid/graphics/drawable/GradientDrawable;

    :cond_2
    return-void
.end method

.method private b(II)V
    .locals 3

    const/4 v2, 0x0

    add-int/lit8 v0, p1, -0x14

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v2, v2, v0, p2}, Landroid/widget/LinearLayout;->layout(IIII)V

    return-void
.end method

.method private b(Landroid/graphics/Canvas;)V
    .locals 3

    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    iget v1, p0, Lkankan/wheel/widget/WheelView;->q:I

    sub-int/2addr v0, v1

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v1

    mul-int/2addr v0, v1

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v1

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v2

    sub-int/2addr v1, v2

    div-int/lit8 v1, v1, 0x2

    add-int/2addr v0, v1

    const/high16 v1, 0x41200000

    neg-int v0, v0

    iget v2, p0, Lkankan/wheel/widget/WheelView;->n:I

    add-int/2addr v0, v2

    int-to-float v0, v0

    invoke-virtual {p1, v1, v0}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p1}, Landroid/widget/LinearLayout;->draw(Landroid/graphics/Canvas;)V

    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    return-void
.end method

.method static synthetic b(Lkankan/wheel/widget/WheelView;I)V
    .locals 0

    iput p1, p0, Lkankan/wheel/widget/WheelView;->n:I

    return-void
.end method

.method private b(I)Z
    .locals 1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    invoke-interface {v0}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getItemsCount()I

    move-result v0

    if-lez v0, :cond_1

    iget-boolean v0, p0, Lkankan/wheel/widget/WheelView;->o:Z

    if-nez v0, :cond_0

    if-ltz p1, :cond_1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    invoke-interface {v0}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getItemsCount()I

    move-result v0

    if-ge p1, v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private c()I
    .locals 2

    const/4 v1, 0x0

    iget v0, p0, Lkankan/wheel/widget/WheelView;->h:I

    if-eqz v0, :cond_0

    iget v0, p0, Lkankan/wheel/widget/WheelView;->h:I

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v0

    iput v0, p0, Lkankan/wheel/widget/WheelView;->h:I

    iget v0, p0, Lkankan/wheel/widget/WheelView;->h:I

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v0

    iget v1, p0, Lkankan/wheel/widget/WheelView;->g:I

    div-int/2addr v0, v1

    goto :goto_0
.end method

.method private c(I)Landroid/view/View;
    .locals 4

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    invoke-interface {v0}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getItemsCount()I

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    invoke-interface {v0}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getItemsCount()I

    move-result v0

    invoke-direct {p0, p1}, Lkankan/wheel/widget/WheelView;->b(I)Z

    move-result v1

    if-nez v1, :cond_3

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->s:Lkankan/wheel/widget/WheelRecycle;

    invoke-virtual {v1}, Lkankan/wheel/widget/WheelRecycle;->getEmptyItem()Landroid/view/View;

    move-result-object v1

    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-interface {v0, v1, v2}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getEmptyItem(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    goto :goto_0

    :cond_2
    add-int/2addr p1, v0

    :cond_3
    if-ltz p1, :cond_2

    rem-int v0, p1, v0

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->s:Lkankan/wheel/widget/WheelRecycle;

    invoke-virtual {v2}, Lkankan/wheel/widget/WheelRecycle;->getItem()Landroid/view/View;

    move-result-object v2

    iget-object v3, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-interface {v1, v0, v2, v3}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getItem(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    goto :goto_0
.end method

.method private c(Landroid/graphics/Canvas;)V
    .locals 6

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-double v1, v1

    const-wide v3, 0x3ff3333333333333L

    mul-double/2addr v1, v3

    double-to-int v1, v1

    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->i:Landroid/graphics/drawable/Drawable;

    const/4 v3, 0x0

    sub-int v4, v0, v1

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getWidth()I

    move-result v5

    add-int/2addr v1, v0

    invoke-virtual {v2, v3, v4, v5, v1}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->y:Ljava/lang/String;

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getWidth()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    iget v3, p0, Lkankan/wheel/widget/WheelView;->A:F

    add-float/2addr v2, v3

    int-to-float v0, v0

    iget v3, p0, Lkankan/wheel/widget/WheelView;->z:F

    sub-float/2addr v0, v3

    iget-object v3, p0, Lkankan/wheel/widget/WheelView;->x:Landroid/graphics/Paint;

    invoke-virtual {p1, v1, v2, v0, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->i:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    return-void
.end method

.method static synthetic c(Lkankan/wheel/widget/WheelView;)Z
    .locals 1

    iget-boolean v0, p0, Lkankan/wheel/widget/WheelView;->m:Z

    return v0
.end method

.method private d()Lkankan/wheel/widget/ItemsRange;
    .locals 7

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget v1, p0, Lkankan/wheel/widget/WheelView;->f:I

    const/4 v0, 0x1

    :goto_1
    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v2

    mul-int/2addr v2, v0

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v3

    if-lt v2, v3, :cond_3

    iget v2, p0, Lkankan/wheel/widget/WheelView;->n:I

    if-eqz v2, :cond_2

    iget v2, p0, Lkankan/wheel/widget/WheelView;->n:I

    if-lez v2, :cond_1

    add-int/lit8 v1, v1, -0x1

    :cond_1
    add-int/lit8 v0, v0, 0x1

    iget v2, p0, Lkankan/wheel/widget/WheelView;->n:I

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v3

    div-int/2addr v2, v3

    sub-int/2addr v1, v2

    int-to-double v3, v0

    int-to-double v5, v2

    invoke-static {v5, v6}, Ljava/lang/Math;->asin(D)D

    move-result-wide v5

    add-double v2, v3, v5

    double-to-int v0, v2

    :cond_2
    new-instance v2, Lkankan/wheel/widget/ItemsRange;

    invoke-direct {v2, v1, v0}, Lkankan/wheel/widget/ItemsRange;-><init>(II)V

    move-object v0, v2

    goto :goto_0

    :cond_3
    add-int/lit8 v1, v1, -0x1

    add-int/lit8 v0, v0, 0x2

    goto :goto_1
.end method

.method private e()Z
    .locals 9

    const/4 v4, 0x0

    const/4 v1, 0x1

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v0

    if-nez v0, :cond_2

    const/4 v0, 0x0

    :goto_0
    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    if-eqz v2, :cond_7

    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->s:Lkankan/wheel/widget/WheelRecycle;

    iget-object v3, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    iget v5, p0, Lkankan/wheel/widget/WheelView;->q:I

    invoke-virtual {v2, v3, v5, v0}, Lkankan/wheel/widget/WheelRecycle;->recycleItems(Landroid/widget/LinearLayout;ILkankan/wheel/widget/ItemsRange;)I

    move-result v3

    iget v2, p0, Lkankan/wheel/widget/WheelView;->q:I

    if-eq v2, v3, :cond_6

    move v2, v1

    :goto_1
    iput v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    :goto_2
    if-nez v2, :cond_0

    iget v2, p0, Lkankan/wheel/widget/WheelView;->q:I

    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getFirst()I

    move-result v3

    if-ne v2, v3, :cond_8

    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v2}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v2

    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getCount()I

    move-result v3

    if-ne v2, v3, :cond_8

    move v2, v4

    :cond_0
    :goto_3
    iget v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getFirst()I

    move-result v5

    if-le v3, v5, :cond_a

    iget v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getLast()I

    move-result v5

    if-gt v3, v5, :cond_a

    iget v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    add-int/lit8 v3, v3, -0x1

    :goto_4
    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getFirst()I

    move-result v5

    if-ge v3, v5, :cond_9

    :cond_1
    :goto_5
    iget v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v1

    :goto_6
    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getCount()I

    move-result v5

    if-lt v1, v5, :cond_b

    iput v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    return v2

    :cond_2
    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    move v2, v0

    move v0, v1

    :goto_7
    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v3

    mul-int/2addr v3, v0

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v5

    if-lt v3, v5, :cond_5

    iget v3, p0, Lkankan/wheel/widget/WheelView;->n:I

    if-eqz v3, :cond_4

    iget v3, p0, Lkankan/wheel/widget/WheelView;->n:I

    if-lez v3, :cond_3

    add-int/lit8 v2, v2, -0x1

    :cond_3
    add-int/lit8 v0, v0, 0x1

    iget v3, p0, Lkankan/wheel/widget/WheelView;->n:I

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v5

    div-int/2addr v3, v5

    sub-int/2addr v2, v3

    int-to-double v5, v0

    int-to-double v7, v3

    invoke-static {v7, v8}, Ljava/lang/Math;->asin(D)D

    move-result-wide v7

    add-double/2addr v5, v7

    double-to-int v0, v5

    :cond_4
    new-instance v3, Lkankan/wheel/widget/ItemsRange;

    invoke-direct {v3, v2, v0}, Lkankan/wheel/widget/ItemsRange;-><init>(II)V

    move-object v0, v3

    goto/16 :goto_0

    :cond_5
    add-int/lit8 v2, v2, -0x1

    add-int/lit8 v0, v0, 0x2

    goto :goto_7

    :cond_6
    move v2, v4

    goto :goto_1

    :cond_7
    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->g()V

    move v2, v1

    goto :goto_2

    :cond_8
    move v2, v1

    goto :goto_3

    :cond_9
    invoke-direct {p0, v3, v1}, Lkankan/wheel/widget/WheelView;->a(IZ)Z

    move-result v5

    if-eqz v5, :cond_1

    iput v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    add-int/lit8 v3, v3, -0x1

    goto :goto_4

    :cond_a
    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getFirst()I

    move-result v1

    iput v1, p0, Lkankan/wheel/widget/WheelView;->q:I

    goto :goto_5

    :cond_b
    iget v5, p0, Lkankan/wheel/widget/WheelView;->q:I

    add-int/2addr v5, v1

    invoke-direct {p0, v5, v4}, Lkankan/wheel/widget/WheelView;->a(IZ)Z

    move-result v5

    if-nez v5, :cond_c

    iget-object v5, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v5}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v5

    if-nez v5, :cond_c

    add-int/lit8 v3, v3, 0x1

    :cond_c
    add-int/lit8 v1, v1, 0x1

    goto :goto_6
.end method

.method private f()V
    .locals 9

    const/4 v4, 0x0

    const/4 v1, 0x1

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v0

    if-nez v0, :cond_3

    const/4 v0, 0x0

    :goto_0
    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    if-eqz v2, :cond_8

    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->s:Lkankan/wheel/widget/WheelRecycle;

    iget-object v3, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    iget v5, p0, Lkankan/wheel/widget/WheelView;->q:I

    invoke-virtual {v2, v3, v5, v0}, Lkankan/wheel/widget/WheelRecycle;->recycleItems(Landroid/widget/LinearLayout;ILkankan/wheel/widget/ItemsRange;)I

    move-result v3

    iget v2, p0, Lkankan/wheel/widget/WheelView;->q:I

    if-eq v2, v3, :cond_7

    move v2, v1

    :goto_1
    iput v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    :goto_2
    if-nez v2, :cond_0

    iget v2, p0, Lkankan/wheel/widget/WheelView;->q:I

    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getFirst()I

    move-result v3

    if-ne v2, v3, :cond_9

    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v2}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v2

    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getCount()I

    move-result v3

    if-ne v2, v3, :cond_9

    move v2, v4

    :cond_0
    :goto_3
    iget v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getFirst()I

    move-result v5

    if-le v3, v5, :cond_b

    iget v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getLast()I

    move-result v5

    if-gt v3, v5, :cond_b

    iget v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    add-int/lit8 v3, v3, -0x1

    :goto_4
    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getFirst()I

    move-result v5

    if-ge v3, v5, :cond_a

    :cond_1
    :goto_5
    iget v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v1

    :goto_6
    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getCount()I

    move-result v5

    if-lt v1, v5, :cond_c

    iput v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    if-eqz v2, :cond_2

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getWidth()I

    move-result v0

    const/high16 v1, 0x40000000

    invoke-direct {p0, v0, v1}, Lkankan/wheel/widget/WheelView;->a(II)I

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getWidth()I

    move-result v0

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v1

    invoke-direct {p0, v0, v1}, Lkankan/wheel/widget/WheelView;->b(II)V

    :cond_2
    return-void

    :cond_3
    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    move v2, v0

    move v0, v1

    :goto_7
    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v3

    mul-int/2addr v3, v0

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v5

    if-lt v3, v5, :cond_6

    iget v3, p0, Lkankan/wheel/widget/WheelView;->n:I

    if-eqz v3, :cond_5

    iget v3, p0, Lkankan/wheel/widget/WheelView;->n:I

    if-lez v3, :cond_4

    add-int/lit8 v2, v2, -0x1

    :cond_4
    add-int/lit8 v0, v0, 0x1

    iget v3, p0, Lkankan/wheel/widget/WheelView;->n:I

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v5

    div-int/2addr v3, v5

    sub-int/2addr v2, v3

    int-to-double v5, v0

    int-to-double v7, v3

    invoke-static {v7, v8}, Ljava/lang/Math;->asin(D)D

    move-result-wide v7

    add-double/2addr v5, v7

    double-to-int v0, v5

    :cond_5
    new-instance v3, Lkankan/wheel/widget/ItemsRange;

    invoke-direct {v3, v2, v0}, Lkankan/wheel/widget/ItemsRange;-><init>(II)V

    move-object v0, v3

    goto/16 :goto_0

    :cond_6
    add-int/lit8 v2, v2, -0x1

    add-int/lit8 v0, v0, 0x2

    goto :goto_7

    :cond_7
    move v2, v4

    goto/16 :goto_1

    :cond_8
    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->g()V

    move v2, v1

    goto/16 :goto_2

    :cond_9
    move v2, v1

    goto/16 :goto_3

    :cond_a
    invoke-direct {p0, v3, v1}, Lkankan/wheel/widget/WheelView;->a(IZ)Z

    move-result v5

    if-eqz v5, :cond_1

    iput v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    add-int/lit8 v3, v3, -0x1

    goto :goto_4

    :cond_b
    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getFirst()I

    move-result v1

    iput v1, p0, Lkankan/wheel/widget/WheelView;->q:I

    goto :goto_5

    :cond_c
    iget v5, p0, Lkankan/wheel/widget/WheelView;->q:I

    add-int/2addr v5, v1

    invoke-direct {p0, v5, v4}, Lkankan/wheel/widget/WheelView;->a(IZ)Z

    move-result v5

    if-nez v5, :cond_d

    iget-object v5, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v5}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v5

    if-nez v5, :cond_d

    add-int/lit8 v3, v3, 0x1

    :cond_d
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_6
.end method

.method private g()V
    .locals 2

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    if-nez v0, :cond_0

    new-instance v0, Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOrientation(I)V

    :cond_0
    return-void
.end method

.method private h()V
    .locals 4

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->s:Lkankan/wheel/widget/WheelRecycle;

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    iget v2, p0, Lkankan/wheel/widget/WheelView;->q:I

    new-instance v3, Lkankan/wheel/widget/ItemsRange;

    invoke-direct {v3}, Lkankan/wheel/widget/ItemsRange;-><init>()V

    invoke-virtual {v0, v1, v2, v3}, Lkankan/wheel/widget/WheelRecycle;->recycleItems(Landroid/widget/LinearLayout;ILkankan/wheel/widget/ItemsRange;)I

    :goto_0
    iget v0, p0, Lkankan/wheel/widget/WheelView;->g:I

    div-int/lit8 v1, v0, 0x2

    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    add-int/2addr v0, v1

    :goto_1
    iget v2, p0, Lkankan/wheel/widget/WheelView;->f:I

    sub-int/2addr v2, v1

    if-ge v0, v2, :cond_1

    return-void

    :cond_0
    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->g()V

    goto :goto_0

    :cond_1
    const/4 v2, 0x1

    invoke-direct {p0, v0, v2}, Lkankan/wheel/widget/WheelView;->a(IZ)Z

    move-result v2

    if-eqz v2, :cond_2

    iput v0, p0, Lkankan/wheel/widget/WheelView;->q:I

    :cond_2
    add-int/lit8 v0, v0, -0x1

    goto :goto_1
.end method


# virtual methods
.method public addChangingListener(Lkankan/wheel/widget/OnWheelChangedListener;)V
    .locals 1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->t:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public addClickingListener(Lkankan/wheel/widget/OnWheelClickedListener;)V
    .locals 1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->v:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public addScrollingListener(Lkankan/wheel/widget/OnWheelScrollListener;)V
    .locals 1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->u:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public getCurrentItem()I
    .locals 2

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    invoke-interface {v0}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->isNeedLoop()Z

    move-result v0

    if-eqz v0, :cond_0

    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    invoke-interface {v1}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getBASE_BUNDLE()I

    move-result v1

    rem-int/2addr v0, v1

    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    goto :goto_0
.end method

.method public getRealCurrentItem()I
    .locals 1

    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    return v0
.end method

.method public getViewAdapter()Lkankan/wheel/widget/adapters/WheelViewAdapter;
    .locals 1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    return-object v0
.end method

.method public getVisibleItems()I
    .locals 1

    iget v0, p0, Lkankan/wheel/widget/WheelView;->g:I

    return v0
.end method

.method public invalidateWheel(Z)V
    .locals 4

    if-eqz p1, :cond_2

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->s:Lkankan/wheel/widget/WheelRecycle;

    invoke-virtual {v0}, Lkankan/wheel/widget/WheelRecycle;->clearAll()V

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    :cond_0
    const/4 v0, 0x0

    iput v0, p0, Lkankan/wheel/widget/WheelView;->n:I

    :cond_1
    :goto_0
    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->invalidate()V

    return-void

    :cond_2
    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->s:Lkankan/wheel/widget/WheelRecycle;

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    iget v2, p0, Lkankan/wheel/widget/WheelView;->q:I

    new-instance v3, Lkankan/wheel/widget/ItemsRange;

    invoke-direct {v3}, Lkankan/wheel/widget/ItemsRange;-><init>()V

    invoke-virtual {v0, v1, v2, v3}, Lkankan/wheel/widget/WheelRecycle;->recycleItems(Landroid/widget/LinearLayout;ILkankan/wheel/widget/ItemsRange;)I

    goto :goto_0
.end method

.method public isCyclic()Z
    .locals 1

    iget-boolean v0, p0, Lkankan/wheel/widget/WheelView;->o:Z

    return v0
.end method

.method protected notifyChangingListeners(II)V
    .locals 2

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->t:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-nez v0, :cond_0

    return-void

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lkankan/wheel/widget/OnWheelChangedListener;

    invoke-interface {v0, p0, p1, p2}, Lkankan/wheel/widget/OnWheelChangedListener;->onChanged(Lkankan/wheel/widget/WheelView;II)V

    goto :goto_0
.end method

.method protected notifyClickListenersAboutClick(I)V
    .locals 2

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->v:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-nez v0, :cond_0

    return-void

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lkankan/wheel/widget/OnWheelClickedListener;

    invoke-interface {v0, p0, p1}, Lkankan/wheel/widget/OnWheelClickedListener;->onItemClicked(Lkankan/wheel/widget/WheelView;I)V

    goto :goto_0
.end method

.method protected notifyScrollingListenersAboutEnd()V
    .locals 2

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->u:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-nez v0, :cond_0

    return-void

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lkankan/wheel/widget/OnWheelScrollListener;

    invoke-interface {v0, p0}, Lkankan/wheel/widget/OnWheelScrollListener;->onScrollingFinished(Lkankan/wheel/widget/WheelView;)V

    goto :goto_0
.end method

.method protected notifyScrollingListenersAboutStart()V
    .locals 2

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->u:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-nez v0, :cond_0

    return-void

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lkankan/wheel/widget/OnWheelScrollListener;

    invoke-interface {v0, p0}, Lkankan/wheel/widget/OnWheelScrollListener;->onScrollingStarted(Lkankan/wheel/widget/WheelView;)V

    goto :goto_0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 9

    const/4 v1, 0x1

    const/4 v4, 0x0

    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    invoke-interface {v0}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getItemsCount()I

    move-result v0

    if-lez v0, :cond_3

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v0

    if-nez v0, :cond_4

    const/4 v0, 0x0

    :goto_0
    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    if-eqz v2, :cond_9

    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->s:Lkankan/wheel/widget/WheelRecycle;

    iget-object v3, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    iget v5, p0, Lkankan/wheel/widget/WheelView;->q:I

    invoke-virtual {v2, v3, v5, v0}, Lkankan/wheel/widget/WheelRecycle;->recycleItems(Landroid/widget/LinearLayout;ILkankan/wheel/widget/ItemsRange;)I

    move-result v3

    iget v2, p0, Lkankan/wheel/widget/WheelView;->q:I

    if-eq v2, v3, :cond_8

    move v2, v1

    :goto_1
    iput v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    :goto_2
    if-nez v2, :cond_0

    iget v2, p0, Lkankan/wheel/widget/WheelView;->q:I

    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getFirst()I

    move-result v3

    if-ne v2, v3, :cond_a

    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v2}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v2

    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getCount()I

    move-result v3

    if-ne v2, v3, :cond_a

    move v2, v4

    :cond_0
    :goto_3
    iget v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getFirst()I

    move-result v5

    if-le v3, v5, :cond_c

    iget v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getLast()I

    move-result v5

    if-gt v3, v5, :cond_c

    iget v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    add-int/lit8 v3, v3, -0x1

    :goto_4
    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getFirst()I

    move-result v5

    if-ge v3, v5, :cond_b

    :cond_1
    :goto_5
    iget v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v1

    :goto_6
    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getCount()I

    move-result v5

    if-lt v1, v5, :cond_d

    iput v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    if-eqz v2, :cond_2

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getWidth()I

    move-result v0

    const/high16 v1, 0x40000000

    invoke-direct {p0, v0, v1}, Lkankan/wheel/widget/WheelView;->a(II)I

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getWidth()I

    move-result v0

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v1

    invoke-direct {p0, v0, v1}, Lkankan/wheel/widget/WheelView;->b(II)V

    :cond_2
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    iget v1, p0, Lkankan/wheel/widget/WheelView;->q:I

    sub-int/2addr v0, v1

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v1

    mul-int/2addr v0, v1

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v1

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v2

    sub-int/2addr v1, v2

    div-int/lit8 v1, v1, 0x2

    add-int/2addr v0, v1

    const/high16 v1, 0x41200000

    neg-int v0, v0

    iget v2, p0, Lkankan/wheel/widget/WheelView;->n:I

    add-int/2addr v0, v2

    int-to-float v0, v0

    invoke-virtual {p1, v1, v0}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p1}, Landroid/widget/LinearLayout;->draw(Landroid/graphics/Canvas;)V

    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-double v1, v1

    const-wide v5, 0x3ff3333333333333L

    mul-double/2addr v1, v5

    double-to-int v1, v1

    iget-object v2, p0, Lkankan/wheel/widget/WheelView;->i:Landroid/graphics/drawable/Drawable;

    sub-int v3, v0, v1

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getWidth()I

    move-result v5

    add-int/2addr v1, v0

    invoke-virtual {v2, v4, v3, v5, v1}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->y:Ljava/lang/String;

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getWidth()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    iget v3, p0, Lkankan/wheel/widget/WheelView;->A:F

    add-float/2addr v2, v3

    int-to-float v0, v0

    iget v3, p0, Lkankan/wheel/widget/WheelView;->z:F

    sub-float/2addr v0, v3

    iget-object v3, p0, Lkankan/wheel/widget/WheelView;->x:Landroid/graphics/Paint;

    invoke-virtual {p1, v1, v2, v0, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->i:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    :cond_3
    const-wide/high16 v0, 0x3ff8000000000000L

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v2

    int-to-double v2, v2

    mul-double/2addr v0, v2

    double-to-int v0, v0

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->j:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getWidth()I

    move-result v2

    invoke-virtual {v1, v4, v4, v2, v0}, Landroid/graphics/drawable/GradientDrawable;->setBounds(IIII)V

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->j:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {v1, p1}, Landroid/graphics/drawable/GradientDrawable;->draw(Landroid/graphics/Canvas;)V

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->k:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v2

    sub-int v0, v2, v0

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getWidth()I

    move-result v2

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v3

    invoke-virtual {v1, v4, v0, v2, v3}, Landroid/graphics/drawable/GradientDrawable;->setBounds(IIII)V

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->k:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/GradientDrawable;->draw(Landroid/graphics/Canvas;)V

    return-void

    :cond_4
    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    move v2, v0

    move v0, v1

    :goto_7
    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v3

    mul-int/2addr v3, v0

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v5

    if-lt v3, v5, :cond_7

    iget v3, p0, Lkankan/wheel/widget/WheelView;->n:I

    if-eqz v3, :cond_6

    iget v3, p0, Lkankan/wheel/widget/WheelView;->n:I

    if-lez v3, :cond_5

    add-int/lit8 v2, v2, -0x1

    :cond_5
    add-int/lit8 v0, v0, 0x1

    iget v3, p0, Lkankan/wheel/widget/WheelView;->n:I

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v5

    div-int/2addr v3, v5

    sub-int/2addr v2, v3

    int-to-double v5, v0

    int-to-double v7, v3

    invoke-static {v7, v8}, Ljava/lang/Math;->asin(D)D

    move-result-wide v7

    add-double/2addr v5, v7

    double-to-int v0, v5

    :cond_6
    new-instance v3, Lkankan/wheel/widget/ItemsRange;

    invoke-direct {v3, v2, v0}, Lkankan/wheel/widget/ItemsRange;-><init>(II)V

    move-object v0, v3

    goto/16 :goto_0

    :cond_7
    add-int/lit8 v2, v2, -0x1

    add-int/lit8 v0, v0, 0x2

    goto :goto_7

    :cond_8
    move v2, v4

    goto/16 :goto_1

    :cond_9
    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->g()V

    move v2, v1

    goto/16 :goto_2

    :cond_a
    move v2, v1

    goto/16 :goto_3

    :cond_b
    invoke-direct {p0, v3, v1}, Lkankan/wheel/widget/WheelView;->a(IZ)Z

    move-result v5

    if-eqz v5, :cond_1

    iput v3, p0, Lkankan/wheel/widget/WheelView;->q:I

    add-int/lit8 v3, v3, -0x1

    goto/16 :goto_4

    :cond_c
    invoke-virtual {v0}, Lkankan/wheel/widget/ItemsRange;->getFirst()I

    move-result v1

    iput v1, p0, Lkankan/wheel/widget/WheelView;->q:I

    goto/16 :goto_5

    :cond_d
    iget v5, p0, Lkankan/wheel/widget/WheelView;->q:I

    add-int/2addr v5, v1

    invoke-direct {p0, v5, v4}, Lkankan/wheel/widget/WheelView;->a(IZ)Z

    move-result v5

    if-nez v5, :cond_e

    iget-object v5, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v5}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v5

    if-nez v5, :cond_e

    add-int/lit8 v3, v3, 0x1

    :cond_e
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_6
.end method

.method protected onLayout(ZIIII)V
    .locals 2

    sub-int v0, p4, p2

    sub-int v1, p5, p3

    invoke-direct {p0, v0, v1}, Lkankan/wheel/widget/WheelView;->b(II)V

    return-void
.end method

.method protected onMeasure(II)V
    .locals 9

    const/4 v8, 0x0

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v2

    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v3

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v4

    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->s:Lkankan/wheel/widget/WheelRecycle;

    iget-object v5, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    iget v6, p0, Lkankan/wheel/widget/WheelView;->q:I

    new-instance v7, Lkankan/wheel/widget/ItemsRange;

    invoke-direct {v7}, Lkankan/wheel/widget/ItemsRange;-><init>()V

    invoke-virtual {v0, v5, v6, v7}, Lkankan/wheel/widget/WheelRecycle;->recycleItems(Landroid/widget/LinearLayout;ILkankan/wheel/widget/ItemsRange;)I

    :goto_0
    iget v0, p0, Lkankan/wheel/widget/WheelView;->g:I

    div-int/lit8 v5, v0, 0x2

    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    add-int/2addr v0, v5

    :goto_1
    iget v6, p0, Lkankan/wheel/widget/WheelView;->f:I

    sub-int/2addr v6, v5

    if-ge v0, v6, :cond_2

    invoke-direct {p0, v4, v2}, Lkankan/wheel/widget/WheelView;->a(II)I

    move-result v2

    const/high16 v0, 0x40000000

    if-ne v3, v0, :cond_4

    move v0, v1

    :cond_0
    :goto_2
    invoke-virtual {p0, v2, v0}, Lkankan/wheel/widget/WheelView;->setMeasuredDimension(II)V

    return-void

    :cond_1
    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->g()V

    goto :goto_0

    :cond_2
    const/4 v6, 0x1

    invoke-direct {p0, v0, v6}, Lkankan/wheel/widget/WheelView;->a(IZ)Z

    move-result v6

    if-eqz v6, :cond_3

    iput v0, p0, Lkankan/wheel/widget/WheelView;->q:I

    :cond_3
    add-int/lit8 v0, v0, -0x1

    goto :goto_1

    :cond_4
    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->p:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_5

    invoke-virtual {v0, v8}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    if-eqz v4, :cond_5

    invoke-virtual {v0, v8}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    iput v0, p0, Lkankan/wheel/widget/WheelView;->h:I

    :cond_5
    iget v0, p0, Lkankan/wheel/widget/WheelView;->h:I

    iget v4, p0, Lkankan/wheel/widget/WheelView;->g:I

    mul-int/2addr v0, v4

    iget v4, p0, Lkankan/wheel/widget/WheelView;->h:I

    mul-int/lit8 v4, v4, 0xa

    div-int/lit8 v4, v4, 0x32

    sub-int/2addr v0, v4

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getSuggestedMinimumHeight()I

    move-result v4

    invoke-static {v0, v4}, Ljava/lang/Math;->max(II)I

    move-result v0

    const/high16 v4, -0x80000000

    if-ne v3, v4, :cond_0

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    goto :goto_2
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2

    const/4 v0, 0x1

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getViewAdapter()Lkankan/wheel/widget/adapters/WheelViewAdapter;

    move-result-object v1

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    :cond_2
    :goto_1
    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->l:Lkankan/wheel/widget/WheelScroller;

    invoke-virtual {v0, p1}, Lkankan/wheel/widget/WheelScroller;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0

    :pswitch_0
    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    invoke-interface {v1, v0}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    goto :goto_1

    :pswitch_1
    iget-boolean v0, p0, Lkankan/wheel/widget/WheelView;->m:Z

    if-nez v0, :cond_2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    float-to-int v0, v0

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    sub-int/2addr v0, v1

    if-lez v0, :cond_3

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    add-int/2addr v0, v1

    :goto_2
    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v1

    div-int/2addr v0, v1

    if-eqz v0, :cond_2

    iget v1, p0, Lkankan/wheel/widget/WheelView;->f:I

    add-int/2addr v1, v0

    invoke-direct {p0, v1}, Lkankan/wheel/widget/WheelView;->b(I)Z

    move-result v1

    if-eqz v1, :cond_2

    iget v1, p0, Lkankan/wheel/widget/WheelView;->f:I

    add-int/2addr v0, v1

    invoke-virtual {p0, v0}, Lkankan/wheel/widget/WheelView;->notifyClickListenersAboutClick(I)V

    goto :goto_1

    :cond_3
    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    sub-int/2addr v0, v1

    goto :goto_2

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public removeChangingListener(Lkankan/wheel/widget/OnWheelChangedListener;)V
    .locals 1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->t:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    return-void
.end method

.method public removeClickingListener(Lkankan/wheel/widget/OnWheelClickedListener;)V
    .locals 1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->v:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    return-void
.end method

.method public removeScrollingListener(Lkankan/wheel/widget/OnWheelScrollListener;)V
    .locals 1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->u:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    return-void
.end method

.method public scroll(II)V
    .locals 2

    invoke-direct {p0}, Lkankan/wheel/widget/WheelView;->c()I

    move-result v0

    mul-int/2addr v0, p1

    iget v1, p0, Lkankan/wheel/widget/WheelView;->n:I

    sub-int/2addr v0, v1

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->l:Lkankan/wheel/widget/WheelScroller;

    invoke-virtual {v1, v0, p2}, Lkankan/wheel/widget/WheelScroller;->scroll(II)V

    return-void
.end method

.method public setCenterDrawable(I)Lkankan/wheel/widget/WheelView;
    .locals 2

    iput p1, p0, Lkankan/wheel/widget/WheelView;->w:I

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->i:Landroid/graphics/drawable/Drawable;

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iget v1, p0, Lkankan/wheel/widget/WheelView;->w:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lkankan/wheel/widget/WheelView;->i:Landroid/graphics/drawable/Drawable;

    :cond_0
    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->invalidate()V

    return-object p0
.end method

.method public setCenterStyle(Ljava/lang/String;F)Lkankan/wheel/widget/WheelView;
    .locals 6

    const v2, 0x7f08003c

    const/16 v3, 0xa

    const/high16 v5, 0x3fc00000

    move-object v0, p0

    move-object v1, p1

    move v4, p2

    invoke-virtual/range {v0 .. v5}, Lkankan/wheel/widget/WheelView;->setCenterStyle(Ljava/lang/String;IIFF)Lkankan/wheel/widget/WheelView;

    move-result-object v0

    return-object v0
.end method

.method public setCenterStyle(Ljava/lang/String;IF)Lkankan/wheel/widget/WheelView;
    .locals 6

    const/16 v3, 0xa

    const/high16 v5, 0x3fc00000

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v4, p3

    invoke-virtual/range {v0 .. v5}, Lkankan/wheel/widget/WheelView;->setCenterStyle(Ljava/lang/String;IIFF)Lkankan/wheel/widget/WheelView;

    move-result-object v0

    return-object v0
.end method

.method public setCenterStyle(Ljava/lang/String;IIFF)Lkankan/wheel/widget/WheelView;
    .locals 3

    const/4 v2, 0x1

    iput-object p1, p0, Lkankan/wheel/widget/WheelView;->y:Ljava/lang/String;

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    invoke-static {v2, p4, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    iput v0, p0, Lkankan/wheel/widget/WheelView;->A:F

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    invoke-static {v2, p5, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    iput v0, p0, Lkankan/wheel/widget/WheelView;->z:F

    int-to-float v0, p3

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    invoke-static {v2, v0, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->x:Landroid/graphics/Paint;

    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setTextSize(F)V

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->x:Landroid/graphics/Paint;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setFakeBoldText(Z)V

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->x:Landroid/graphics/Paint;

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->x:Landroid/graphics/Paint;

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, p2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    return-object p0
.end method

.method public setCurrentItem(I)Lkankan/wheel/widget/WheelView;
    .locals 1

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lkankan/wheel/widget/WheelView;->setCurrentItem(IZ)V

    return-object p0
.end method

.method public setCurrentItem(IZ)V
    .locals 4

    const/4 v3, 0x0

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    invoke-interface {v0}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getItemsCount()I

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    invoke-interface {v0}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getItemsCount()I

    move-result v0

    if-ltz p1, :cond_2

    if-lt p1, v0, :cond_3

    :cond_2
    iget-boolean v1, p0, Lkankan/wheel/widget/WheelView;->o:Z

    if-eqz v1, :cond_0

    :goto_1
    if-ltz p1, :cond_4

    rem-int/2addr p1, v0

    :cond_3
    iget v1, p0, Lkankan/wheel/widget/WheelView;->f:I

    if-eq p1, v1, :cond_0

    if-eqz p2, :cond_6

    iget v1, p0, Lkankan/wheel/widget/WheelView;->f:I

    sub-int v1, p1, v1

    iget-boolean v2, p0, Lkankan/wheel/widget/WheelView;->o:Z

    if-eqz v2, :cond_7

    iget v2, p0, Lkankan/wheel/widget/WheelView;->f:I

    invoke-static {p1, v2}, Ljava/lang/Math;->min(II)I

    move-result v2

    add-int/2addr v0, v2

    iget v2, p0, Lkankan/wheel/widget/WheelView;->f:I

    invoke-static {p1, v2}, Ljava/lang/Math;->max(II)I

    move-result v2

    sub-int/2addr v0, v2

    invoke-static {v1}, Ljava/lang/Math;->abs(I)I

    move-result v2

    if-ge v0, v2, :cond_7

    if-gez v1, :cond_5

    :goto_2
    invoke-virtual {p0, v0, v3}, Lkankan/wheel/widget/WheelView;->scroll(II)V

    goto :goto_0

    :cond_4
    add-int/2addr p1, v0

    goto :goto_1

    :cond_5
    neg-int v0, v0

    goto :goto_2

    :cond_6
    iput v3, p0, Lkankan/wheel/widget/WheelView;->n:I

    iget v0, p0, Lkankan/wheel/widget/WheelView;->f:I

    iput p1, p0, Lkankan/wheel/widget/WheelView;->f:I

    iget v1, p0, Lkankan/wheel/widget/WheelView;->f:I

    invoke-virtual {p0, v0, v1}, Lkankan/wheel/widget/WheelView;->notifyChangingListeners(II)V

    invoke-virtual {p0}, Lkankan/wheel/widget/WheelView;->invalidate()V

    goto :goto_0

    :cond_7
    move v0, v1

    goto :goto_2
.end method

.method public setCurrentItemLooped(I)Lkankan/wheel/widget/WheelView;
    .locals 3

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    invoke-interface {v0}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->isNeedLoop()Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "WheelView"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "setCurrentItemLooped: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    invoke-interface {v0}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->getInitLoopBase()I

    move-result v0

    add-int/2addr p1, v0

    const-string v0, "WheelView"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, ", after add loopbase:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lkankan/wheel/widget/WheelView;->setCurrentItem(IZ)V

    return-object p0
.end method

.method public setCyclic(Z)V
    .locals 1

    iput-boolean p1, p0, Lkankan/wheel/widget/WheelView;->o:Z

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lkankan/wheel/widget/WheelView;->invalidateWheel(Z)V

    return-void
.end method

.method public setInterpolator(Landroid/view/animation/Interpolator;)V
    .locals 1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->l:Lkankan/wheel/widget/WheelScroller;

    invoke-virtual {v0, p1}, Lkankan/wheel/widget/WheelScroller;->setInterpolator(Landroid/view/animation/Interpolator;)V

    return-void
.end method

.method public setViewAdapter(Lkankan/wheel/widget/adapters/WheelViewAdapter;)Lkankan/wheel/widget/WheelView;
    .locals 2

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->C:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    :cond_0
    iput-object p1, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->r:Lkankan/wheel/widget/adapters/WheelViewAdapter;

    iget-object v1, p0, Lkankan/wheel/widget/WheelView;->C:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Lkankan/wheel/widget/adapters/WheelViewAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    :cond_1
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lkankan/wheel/widget/WheelView;->invalidateWheel(Z)V

    return-object p0
.end method

.method public setVisibleItems(I)Lkankan/wheel/widget/WheelView;
    .locals 0

    iput p1, p0, Lkankan/wheel/widget/WheelView;->g:I

    return-object p0
.end method

.method public stopScrolling()V
    .locals 1

    iget-object v0, p0, Lkankan/wheel/widget/WheelView;->l:Lkankan/wheel/widget/WheelScroller;

    invoke-virtual {v0}, Lkankan/wheel/widget/WheelScroller;->stopScrolling()V

    return-void
.end method
