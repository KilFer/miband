.class public Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;
.super Landroid/view/ViewGroup;


# static fields
.field private static synthetic $SWITCH_TABLE$cn$com$smartdevices$bracelet$lua$SlidingUpPanelLayout$SlideState:[I = null

.field private static final DEFAULT_ATTRS:[I

.field private static final DEFAULT_FADE_COLOR:I = -0x67000000

.field private static final DEFAULT_MIN_FLING_VELOCITY:I = 0x190

.field private static final DEFAULT_OVERLAY_FLAG:Z = false

.field private static final DEFAULT_PANEL_HEIGHT:I = 0x44

.field private static final DEFAULT_PARALAX_OFFSET:I = 0x0

.field private static final DEFAULT_SHADOW_HEIGHT:I = 0x4

.field private static final ONE_PAGE_ITEMS:I = 0x8

.field private static final TAG:Ljava/lang/String; = "chenee"


# instance fields
.field private isPressed:Ljava/lang/Boolean;

.field private listAdapter:Lcn/com/smartdevices/bracelet/lua/LuaListAdapter;

.field private mAnchorPoint:F

.field private mCanSlide:Z

.field private mCoveredFadeColor:I

.field private final mCoveredFadePaint:Landroid/graphics/Paint;

.field private final mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

.field private mDragView:Landroid/view/View;

.field private mDragViewResId:I

.field private mFirstLayout:Z

.field private mInitialMotionX:F

.field private mInitialMotionY:F

.field private mIsSlidingEnabled:Z

.field private mIsSlidingUp:Z

.field private mIsUnableToDrag:Z

.field private mIsUsingDragViewTouchEvents:Z

.field private mMainView:Landroid/view/View;

.field private mMinFlingVelocity:I

.field private mOverlayContent:Z

.field private mPanelHeight:I

.field private mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

.field private mParalaxOffset:I

.field private final mScrollTouchSlop:I

.field private final mShadowDrawable:Landroid/graphics/drawable/Drawable;

.field private mShadowHeight:I

.field private mSlideOffset:F

.field private mSlideRange:I

.field private mSlideState:Lcn/com/smartdevices/bracelet/lua/n;

.field private mSlideableView:Landroid/view/View;

.field private final mTmpRect:Landroid/graphics/Rect;


# direct methods
.method static synthetic $SWITCH_TABLE$cn$com$smartdevices$bracelet$lua$SlidingUpPanelLayout$SlideState()[I
    .locals 3

    sget-object v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->$SWITCH_TABLE$cn$com$smartdevices$bracelet$lua$SlidingUpPanelLayout$SlideState:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcn/com/smartdevices/bracelet/lua/n;->values()[Lcn/com/smartdevices/bracelet/lua/n;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcn/com/smartdevices/bracelet/lua/n;->c:Lcn/com/smartdevices/bracelet/lua/n;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/lua/n;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_2

    :goto_1
    :try_start_1
    sget-object v1, Lcn/com/smartdevices/bracelet/lua/n;->b:Lcn/com/smartdevices/bracelet/lua/n;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/lua/n;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_1

    :goto_2
    :try_start_2
    sget-object v1, Lcn/com/smartdevices/bracelet/lua/n;->a:Lcn/com/smartdevices/bracelet/lua/n;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/lua/n;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_0

    :goto_3
    sput-object v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->$SWITCH_TABLE$cn$com$smartdevices$bracelet$lua$SlidingUpPanelLayout$SlideState:[I

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_3

    :catch_1
    move-exception v1

    goto :goto_2

    :catch_2
    move-exception v1

    goto :goto_1
.end method

.method static constructor <clinit>()V
    .locals 3

    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x10100af

    aput v2, v0, v1

    sput-object v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->DEFAULT_ATTRS:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 8

    const/high16 v7, 0x3f000000

    const/4 v6, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    const/4 v5, -0x1

    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    const/16 v0, 0x190

    iput v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mMinFlingVelocity:I

    const/high16 v0, -0x67000000

    iput v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCoveredFadeColor:I

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCoveredFadePaint:Landroid/graphics/Paint;

    iput v5, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelHeight:I

    iput v5, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mShadowHeight:I

    iput v5, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mParalaxOffset:I

    iput-boolean v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mOverlayContent:Z

    iput v5, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragViewResId:I

    sget-object v0, Lcn/com/smartdevices/bracelet/lua/n;->b:Lcn/com/smartdevices/bracelet/lua/n;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideState:Lcn/com/smartdevices/bracelet/lua/n;

    const/4 v0, 0x0

    iput v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mAnchorPoint:F

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->isPressed:Ljava/lang/Boolean;

    iput-object v6, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->listAdapter:Lcn/com/smartdevices/bracelet/lua/LuaListAdapter;

    iput-boolean v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mFirstLayout:Z

    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mTmpRect:Landroid/graphics/Rect;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->isInEditMode()Z

    move-result v0

    if-eqz v0, :cond_0

    iput-object v6, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mShadowDrawable:Landroid/graphics/drawable/Drawable;

    iput v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mScrollTouchSlop:I

    iput-object v6, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    :goto_0
    return-void

    :cond_0
    if-eqz p2, :cond_4

    sget-object v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->DEFAULT_ATTRS:[I

    invoke-virtual {p1, p2, v0}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v3

    if-eqz v3, :cond_2

    invoke-virtual {v3, v2, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v0

    const/16 v4, 0x30

    if-eq v0, v4, :cond_1

    const/16 v4, 0x50

    if-eq v0, v4, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "gravity must be set to either top or bottom"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    const/16 v4, 0x50

    if-ne v0, v4, :cond_8

    move v0, v1

    :goto_1
    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsSlidingUp:Z

    :cond_2
    invoke-virtual {v3}, Landroid/content/res/TypedArray;->recycle()V

    sget-object v0, Lcom/xiaomi/hm/health/R$styleable;->SlidingUpPanelLayout:[I

    invoke-virtual {p1, p2, v0}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v3

    iput v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelHeight:I

    invoke-virtual {v0, v1, v5}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v3

    iput v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mShadowHeight:I

    const/4 v3, 0x2

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v3

    iput v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mParalaxOffset:I

    const/4 v3, 0x4

    const/16 v4, 0x190

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    iput v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mMinFlingVelocity:I

    const/4 v3, 0x3

    const/high16 v4, -0x67000000

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v3

    iput v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCoveredFadeColor:I

    const/4 v3, 0x5

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    iput v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragViewResId:I

    const/4 v3, 0x6

    invoke-virtual {v0, v3, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    iput-boolean v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mOverlayContent:Z

    :cond_3
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    :cond_4
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    iget v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelHeight:I

    if-ne v3, v5, :cond_5

    const/high16 v3, 0x42880000

    mul-float/2addr v3, v0

    add-float/2addr v3, v7

    float-to-int v3, v3

    iput v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelHeight:I

    :cond_5
    iget v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mShadowHeight:I

    if-ne v3, v5, :cond_6

    const/high16 v3, 0x40800000

    mul-float/2addr v3, v0

    add-float/2addr v3, v7

    float-to-int v3, v3

    iput v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mShadowHeight:I

    :cond_6
    iget v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mParalaxOffset:I

    if-ne v3, v5, :cond_7

    const/4 v3, 0x0

    mul-float/2addr v3, v0

    float-to-int v3, v3

    iput v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mParalaxOffset:I

    :cond_7
    iget v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mShadowHeight:I

    if-lez v3, :cond_a

    iget-boolean v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsSlidingUp:Z

    if-eqz v3, :cond_9

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f020001

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    iput-object v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mShadowDrawable:Landroid/graphics/drawable/Drawable;

    :goto_2
    invoke-virtual {p0, v2}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->setWillNotDraw(Z)V

    new-instance v3, Lcn/com/smartdevices/bracelet/lua/l;

    invoke-direct {v3, p0, v2}, Lcn/com/smartdevices/bracelet/lua/l;-><init>(Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;B)V

    invoke-static {p0, v7, v3}, Landroid/support/v4/widget/ViewDragHelper;->create(Landroid/view/ViewGroup;FLandroid/support/v4/widget/ViewDragHelper$Callback;)Landroid/support/v4/widget/ViewDragHelper;

    move-result-object v2

    iput-object v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    iget v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mMinFlingVelocity:I

    int-to-float v3, v3

    mul-float/2addr v0, v3

    invoke-virtual {v2, v0}, Landroid/support/v4/widget/ViewDragHelper;->setMinVelocity(F)V

    iput-boolean v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCanSlide:Z

    iput-boolean v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsSlidingEnabled:Z

    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v0

    iput v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mScrollTouchSlop:I

    goto/16 :goto_0

    :cond_8
    move v0, v2

    goto/16 :goto_1

    :cond_9
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f02000c

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    iput-object v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mShadowDrawable:Landroid/graphics/drawable/Drawable;

    goto :goto_2

    :cond_a
    iput-object v6, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mShadowDrawable:Landroid/graphics/drawable/Drawable;

    goto :goto_2
.end method

.method static synthetic access$0(Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;)Z
    .locals 1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsUnableToDrag:Z

    return v0
.end method

.method static synthetic access$1(Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;)F
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mAnchorPoint:F

    return v0
.end method

.method static synthetic access$10(Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;)Z
    .locals 1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsSlidingUp:Z

    return v0
.end method

.method static synthetic access$11(Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;)I
    .locals 1

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getSlidingTop()I

    move-result v0

    return v0
.end method

.method static synthetic access$12(Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;)I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelHeight:I

    return v0
.end method

.method static synthetic access$2(Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;)I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideRange:I

    return v0
.end method

.method static synthetic access$3(Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;)Landroid/support/v4/widget/ViewDragHelper;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    return-object v0
.end method

.method static synthetic access$4(Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;)F
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideOffset:F

    return v0
.end method

.method static synthetic access$5(Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;)Lcn/com/smartdevices/bracelet/lua/n;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideState:Lcn/com/smartdevices/bracelet/lua/n;

    return-object v0
.end method

.method static synthetic access$6(Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;)Landroid/view/View;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$7(Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;Lcn/com/smartdevices/bracelet/lua/n;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideState:Lcn/com/smartdevices/bracelet/lua/n;

    return-void
.end method

.method static synthetic access$8(Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;Ljava/lang/Boolean;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->isPressed:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$9(Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;I)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->onPanelDragged(I)V

    return-void
.end method

.method private collapsePane(Landroid/view/View;I)Z
    .locals 1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mFirstLayout:Z

    if-nez v0, :cond_0

    const/high16 v0, 0x3f800000

    invoke-virtual {p0, v0, p2}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->smoothSlideTo(FI)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private expandPane(Landroid/view/View;IF)Z
    .locals 1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mFirstLayout:Z

    if-nez v0, :cond_0

    invoke-virtual {p0, p3, p2}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->smoothSlideTo(FI)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private getSlidingTop()I
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsSlidingUp:Z

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getMeasuredHeight()I

    move-result v0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getPaddingBottom()I

    move-result v1

    sub-int/2addr v0, v1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v1

    sub-int/2addr v0, v1

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getPaddingTop()I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getMeasuredHeight()I

    move-result v0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getPaddingBottom()I

    move-result v1

    sub-int/2addr v0, v1

    goto :goto_0
.end method

.method private static hasOpaqueBackground(Landroid/view/View;)Z
    .locals 2

    invoke-virtual {p0}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private innerListViewNeedSlide(F)Z
    .locals 2

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mInitialMotionY:F

    sub-float/2addr v0, p1

    iget v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mScrollTouchSlop:I

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->listAdapter:Lcn/com/smartdevices/bracelet/lua/LuaListAdapter;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/lua/LuaListAdapter;->getCount()I

    move-result v0

    const/16 v1, 0x8

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isDragViewUnder(II)Z
    .locals 8

    const/4 v4, 0x2

    const/4 v1, 0x1

    const/4 v0, 0x0

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragView:Landroid/view/View;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragView:Landroid/view/View;

    :goto_0
    if-nez v2, :cond_2

    :cond_0
    :goto_1
    return v0

    :cond_1
    iget-object v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    goto :goto_0

    :cond_2
    new-array v3, v4, [I

    invoke-virtual {v2, v3}, Landroid/view/View;->getLocationOnScreen([I)V

    new-array v4, v4, [I

    invoke-virtual {p0, v4}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getLocationOnScreen([I)V

    aget v5, v4, v0

    add-int/2addr v5, p1

    aget v4, v4, v1

    add-int/2addr v4, p2

    aget v6, v3, v0

    if-lt v5, v6, :cond_0

    aget v6, v3, v0

    invoke-virtual {v2}, Landroid/view/View;->getWidth()I

    move-result v7

    add-int/2addr v6, v7

    if-ge v5, v6, :cond_0

    aget v5, v3, v1

    if-lt v4, v5, :cond_0

    aget v3, v3, v1

    invoke-virtual {v2}, Landroid/view/View;->getHeight()I

    move-result v2

    add-int/2addr v2, v3

    if-ge v4, v2, :cond_0

    move v0, v1

    goto :goto_1
.end method

.method private onPanelDragged(I)V
    .locals 3

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getSlidingTop()I

    move-result v0

    iget-boolean v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsSlidingUp:Z

    if-eqz v1, :cond_1

    sub-int v0, p1, v0

    int-to-float v0, v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideRange:I

    int-to-float v1, v1

    div-float/2addr v0, v1

    :goto_0
    iput v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideOffset:F

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->dispatchOnPanelSlide(Landroid/view/View;)V

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mParalaxOffset:I

    if-lez v0, :cond_0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getCurrentParalaxOffset()I

    move-result v0

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xb

    if-lt v1, v2, :cond_2

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mMainView:Landroid/view/View;

    int-to-float v0, v0

    invoke-virtual {v1, v0}, Landroid/view/View;->setTranslationY(F)V

    :cond_0
    :goto_1
    return-void

    :cond_1
    sub-int/2addr v0, p1

    int-to-float v0, v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideRange:I

    int-to-float v1, v1

    div-float/2addr v0, v1

    goto :goto_0

    :cond_2
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mMainView:Landroid/view/View;

    invoke-static {v1}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->wrap(Landroid/view/View;)Lcom/nineoldandroids/view/animation/AnimatorProxy;

    move-result-object v1

    int-to-float v0, v0

    invoke-virtual {v1, v0}, Lcom/nineoldandroids/view/animation/AnimatorProxy;->setTranslationY(F)V

    goto :goto_1
.end method


# virtual methods
.method protected canScroll(Landroid/view/View;ZIII)Z
    .locals 10

    const/4 v2, 0x1

    instance-of v0, p1, Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    move-object v6, p1

    check-cast v6, Landroid/view/ViewGroup;

    invoke-virtual {p1}, Landroid/view/View;->getScrollX()I

    move-result v8

    invoke-virtual {p1}, Landroid/view/View;->getScrollY()I

    move-result v9

    invoke-virtual {v6}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    move v7, v0

    :goto_0
    if-gez v7, :cond_2

    :cond_0
    if-eqz p2, :cond_4

    neg-int v0, p3

    invoke-static {p1, v0}, Landroid/support/v4/view/ViewCompat;->canScrollHorizontally(Landroid/view/View;I)Z

    move-result v0

    if-eqz v0, :cond_4

    :cond_1
    :goto_1
    return v2

    :cond_2
    invoke-virtual {v6, v7}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    add-int v0, p4, v8

    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v3

    if-lt v0, v3, :cond_3

    add-int v0, p4, v8

    invoke-virtual {v1}, Landroid/view/View;->getRight()I

    move-result v3

    if-ge v0, v3, :cond_3

    add-int v0, p5, v9

    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v3

    if-lt v0, v3, :cond_3

    add-int v0, p5, v9

    invoke-virtual {v1}, Landroid/view/View;->getBottom()I

    move-result v3

    if-ge v0, v3, :cond_3

    add-int v0, p4, v8

    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v3

    sub-int v4, v0, v3

    add-int v0, p5, v9

    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v3

    sub-int v5, v0, v3

    move-object v0, p0

    move v3, p3

    invoke-virtual/range {v0 .. v5}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->canScroll(Landroid/view/View;ZIII)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_3
    add-int/lit8 v0, v7, -0x1

    move v7, v0

    goto :goto_0

    :cond_4
    const/4 v2, 0x0

    goto :goto_1
.end method

.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .locals 1

    instance-of v0, p1, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;

    if-eqz v0, :cond_0

    invoke-super {p0, p1}, Landroid/view/ViewGroup;->checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public collapsePane()Z
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->collapsePane(Landroid/view/View;I)Z

    move-result v0

    return v0
.end method

.method public computeScroll()V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/ViewDragHelper;->continueSettling(Z)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCanSlide:Z

    if-nez v0, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v0}, Landroid/support/v4/widget/ViewDragHelper;->abort()V

    goto :goto_0

    :cond_2
    invoke-static {p0}, Landroid/support/v4/view/ViewCompat;->postInvalidateOnAnimation(Landroid/view/View;)V

    goto :goto_0
.end method

.method dispatchOnPanelAnchored(Landroid/view/View;)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    invoke-interface {v0, p1}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;->onPanelAnchored(Landroid/view/View;)V

    :cond_0
    const/16 v0, 0x20

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->sendAccessibilityEvent(I)V

    return-void
.end method

.method dispatchOnPanelCollapsed(Landroid/view/View;)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    invoke-interface {v0, p1}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;->onPanelCollapsed(Landroid/view/View;)V

    :cond_0
    const/16 v0, 0x20

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->sendAccessibilityEvent(I)V

    return-void
.end method

.method dispatchOnPanelExpanded(Landroid/view/View;)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    invoke-interface {v0, p1}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;->onPanelExpanded(Landroid/view/View;)V

    :cond_0
    const/16 v0, 0x20

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->sendAccessibilityEvent(I)V

    return-void
.end method

.method dispatchOnPanelLastOffset(Landroid/view/View;)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    iget v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideOffset:F

    invoke-interface {v0, p1, v1}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;->onLastSlideOffset(Landroid/view/View;F)V

    :cond_0
    return-void
.end method

.method dispatchOnPanelSlide(Landroid/view/View;)V
    .locals 3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->isPressed:Ljava/lang/Boolean;

    iget v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideOffset:F

    invoke-interface {v0, p1, v1, v2}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;->onPanelSlide(Landroid/view/View;Ljava/lang/Boolean;F)V

    :cond_0
    return-void
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .locals 5

    invoke-super {p0, p1}, Landroid/view/ViewGroup;->draw(Landroid/graphics/Canvas;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v2

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsSlidingUp:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mShadowHeight:I

    sub-int v1, v0, v1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v0

    :goto_1
    iget-object v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v3

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mShadowDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mShadowDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v4, v3, v1, v2, v0}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mShadowDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getBottom()I

    move-result v1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getBottom()I

    move-result v0

    iget v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mShadowHeight:I

    add-int/2addr v0, v3

    goto :goto_1
.end method

.method protected drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z
    .locals 6

    const/high16 v5, 0x3f800000

    invoke-virtual {p2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;

    const/4 v1, 0x2

    invoke-virtual {p1, v1}, Landroid/graphics/Canvas;->save(I)I

    move-result v2

    const/4 v1, 0x0

    iget-boolean v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCanSlide:Z

    if-eqz v3, :cond_3

    iget-boolean v0, v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;->slideable:Z

    if-nez v0, :cond_3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    if-eqz v0, :cond_3

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mOverlayContent:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mTmpRect:Landroid/graphics/Rect;

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->getClipBounds(Landroid/graphics/Rect;)Z

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsSlidingUp:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mTmpRect:Landroid/graphics/Rect;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mTmpRect:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->bottom:I

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getTop()I

    move-result v4

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v3

    iput v3, v0, Landroid/graphics/Rect;->bottom:I

    :goto_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mTmpRect:Landroid/graphics/Rect;

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->clipRect(Landroid/graphics/Rect;)Z

    :cond_0
    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideOffset:F

    cmpg-float v0, v0, v5

    if-gez v0, :cond_3

    const/4 v0, 0x1

    :goto_1
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/ViewGroup;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    move-result v1

    invoke-virtual {p1, v2}, Landroid/graphics/Canvas;->restoreToCount(I)V

    if-eqz v0, :cond_1

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCoveredFadeColor:I

    const/high16 v2, -0x1000000

    and-int/2addr v0, v2

    ushr-int/lit8 v0, v0, 0x18

    int-to-float v0, v0

    iget v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideOffset:F

    sub-float v2, v5, v2

    mul-float/2addr v0, v2

    float-to-int v0, v0

    shl-int/lit8 v0, v0, 0x18

    iget v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCoveredFadeColor:I

    const v3, 0xffffff

    and-int/2addr v2, v3

    or-int/2addr v0, v2

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCoveredFadePaint:Landroid/graphics/Paint;

    invoke-virtual {v2, v0}, Landroid/graphics/Paint;->setColor(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mTmpRect:Landroid/graphics/Rect;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCoveredFadePaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v2}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    :cond_1
    return v1

    :cond_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mTmpRect:Landroid/graphics/Rect;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mTmpRect:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->top:I

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getBottom()I

    move-result v4

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v3

    iput v3, v0, Landroid/graphics/Rect;->top:I

    goto :goto_0

    :cond_3
    move v0, v1

    goto :goto_1
.end method

.method public expandPane()Z
    .locals 1

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->expandPane(F)Z

    move-result v0

    return v0
.end method

.method public expandPane(F)Z
    .locals 2

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->isPaneVisible()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->showPane()V

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1, p1}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->expandPane(Landroid/view/View;IF)Z

    move-result v0

    return v0
.end method

.method protected generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .locals 1

    new-instance v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;-><init>()V

    return-object v0
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .locals 2

    new-instance v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .locals 1

    instance-of v0, p1, Landroid/view/ViewGroup$MarginLayoutParams;

    if-eqz v0, :cond_0

    new-instance v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;

    check-cast p1, Landroid/view/ViewGroup$MarginLayoutParams;

    invoke-direct {v0, p1}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;

    invoke-direct {v0, p1}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0
.end method

.method public getCoveredFadeColor()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCoveredFadeColor:I

    return v0
.end method

.method public getCurrentParalaxOffset()I
    .locals 3

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mParalaxOffset:I

    int-to-float v0, v0

    const/high16 v1, 0x3f800000

    iget v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideOffset:F

    sub-float/2addr v1, v2

    mul-float/2addr v0, v1

    float-to-int v0, v0

    iget-boolean v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsSlidingUp:Z

    if-eqz v1, :cond_0

    neg-int v0, v0

    :cond_0
    return v0
.end method

.method public getPanelHeight()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelHeight:I

    return v0
.end method

.method getPullDownDistance()I
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    invoke-interface {v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;->onGetPullDownDistance()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method getPullDownDockEnable()Ljava/lang/Boolean;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    invoke-interface {v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;->onGetPullDownDockEnable()Ljava/lang/Boolean;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method

.method getSlideThreshhold()F
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    invoke-interface {v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;->onGetThreshhold()F

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method getSlideThreshhold2()F
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    invoke-interface {v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;->onGetThreshhold2()F

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSlidingEnable()Ljava/lang/Boolean;
    .locals 1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsSlidingEnabled:Z

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public hidePane()V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->requestLayout()V

    goto :goto_0
.end method

.method public isAnchored()Z
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideState:Lcn/com/smartdevices/bracelet/lua/n;

    sget-object v1, Lcn/com/smartdevices/bracelet/lua/n;->c:Lcn/com/smartdevices/bracelet/lua/n;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isCollapsed()Z
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideState:Lcn/com/smartdevices/bracelet/lua/n;

    sget-object v1, Lcn/com/smartdevices/bracelet/lua/n;->b:Lcn/com/smartdevices/bracelet/lua/n;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isExpanded()Z
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideState:Lcn/com/smartdevices/bracelet/lua/n;

    sget-object v1, Lcn/com/smartdevices/bracelet/lua/n;->a:Lcn/com/smartdevices/bracelet/lua/n;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isOverlayed()Z
    .locals 1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mOverlayContent:Z

    return v0
.end method

.method public isPaneVisible()Z
    .locals 4

    const/4 v1, 0x1

    const/4 v0, 0x0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getChildCount()I

    move-result v2

    const/4 v3, 0x2

    if-ge v2, v3, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getVisibility()I

    move-result v2

    if-nez v2, :cond_0

    move v0, v1

    goto :goto_0
.end method

.method public isSlideable()Z
    .locals 1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCanSlide:Z

    return v0
.end method

.method protected onAttachedToWindow()V
    .locals 1

    invoke-super {p0}, Landroid/view/ViewGroup;->onAttachedToWindow()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mFirstLayout:Z

    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    invoke-super {p0}, Landroid/view/ViewGroup;->onDetachedFromWindow()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mFirstLayout:Z

    return-void
.end method

.method protected onFinishInflate()V
    .locals 2

    invoke-super {p0}, Landroid/view/ViewGroup;->onFinishInflate()V

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragViewResId:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragViewResId:I

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragView:Landroid/view/View;

    :cond_0
    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 9

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    invoke-static {p1}, Landroid/support/v4/view/MotionEventCompat;->getActionMasked(Landroid/view/MotionEvent;)I

    move-result v0

    iget-boolean v5, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCanSlide:Z

    if-eqz v5, :cond_0

    iget-boolean v5, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsSlidingEnabled:Z

    if-eqz v5, :cond_0

    iget-boolean v5, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsUnableToDrag:Z

    if-eqz v5, :cond_2

    if-eqz v0, :cond_2

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v0}, Landroid/support/v4/widget/ViewDragHelper;->cancel()V

    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v2

    :cond_1
    :goto_0
    return v2

    :cond_2
    const/4 v5, 0x3

    if-eq v0, v5, :cond_3

    if-ne v0, v1, :cond_4

    :cond_3
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v0}, Landroid/support/v4/widget/ViewDragHelper;->cancel()V

    goto :goto_0

    :cond_4
    packed-switch v0, :pswitch_data_0

    :cond_5
    :pswitch_0
    move v0, v2

    :cond_6
    :goto_1
    iget-object v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v3, p1}, Landroid/support/v4/widget/ViewDragHelper;->shouldInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v3

    if-nez v3, :cond_7

    if-eqz v0, :cond_1

    :cond_7
    move v2, v1

    goto :goto_0

    :pswitch_1
    iput-boolean v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsUnableToDrag:Z

    iput v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mInitialMotionX:F

    iput v4, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mInitialMotionY:F

    float-to-int v0, v3

    float-to-int v3, v4

    invoke-direct {p0, v0, v3}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->isDragViewUnder(II)Z

    move-result v0

    if-eqz v0, :cond_5

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsUsingDragViewTouchEvents:Z

    if-nez v0, :cond_5

    move v0, v1

    goto :goto_1

    :pswitch_2
    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mInitialMotionX:F

    sub-float v0, v3, v0

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v5

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mInitialMotionY:F

    sub-float v0, v4, v0

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v6

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v0}, Landroid/support/v4/widget/ViewDragHelper;->getTouchSlop()I

    move-result v7

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->isExpanded()Z

    move-result v0

    if-eqz v0, :cond_8

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->listAdapter:Lcn/com/smartdevices/bracelet/lua/LuaListAdapter;

    if-eqz v0, :cond_8

    invoke-direct {p0, v4}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->innerListViewNeedSlide(F)Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-virtual {p0, v2}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->setSlidingEnabled(Z)V

    goto :goto_0

    :cond_8
    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsUsingDragViewTouchEvents:Z

    if-eqz v0, :cond_c

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mScrollTouchSlop:I

    int-to-float v0, v0

    cmpl-float v0, v5, v0

    if-lez v0, :cond_9

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mScrollTouchSlop:I

    int-to-float v0, v0

    cmpg-float v0, v6, v0

    if-gez v0, :cond_9

    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v2

    goto :goto_0

    :cond_9
    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mScrollTouchSlop:I

    int-to-float v0, v0

    cmpl-float v0, v6, v0

    if-lez v0, :cond_c

    float-to-int v0, v3

    float-to-int v8, v4

    invoke-direct {p0, v0, v8}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->isDragViewUnder(II)Z

    move-result v0

    :goto_2
    int-to-float v7, v7

    cmpl-float v7, v6, v7

    if-lez v7, :cond_a

    cmpl-float v5, v5, v6

    if-gtz v5, :cond_b

    :cond_a
    float-to-int v3, v3

    float-to-int v4, v4

    invoke-direct {p0, v3, v4}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->isDragViewUnder(II)Z

    move-result v3

    if-nez v3, :cond_6

    :cond_b
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v0}, Landroid/support/v4/widget/ViewDragHelper;->cancel()V

    iput-boolean v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsUnableToDrag:Z

    goto/16 :goto_0

    :cond_c
    move v0, v2

    goto :goto_2

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method protected onLayout(ZIIII)V
    .locals 10

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getPaddingLeft()I

    move-result v4

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getPaddingTop()I

    move-result v1

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getSlidingTop()I

    move-result v5

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getChildCount()I

    move-result v6

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mFirstLayout:Z

    if-eqz v0, :cond_0

    invoke-static {}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->$SWITCH_TABLE$cn$com$smartdevices$bracelet$lua$SlidingUpPanelLayout$SlideState()[I

    move-result-object v0

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideState:Lcn/com/smartdevices/bracelet/lua/n;

    invoke-virtual {v2}, Lcn/com/smartdevices/bracelet/lua/n;->ordinal()I

    move-result v2

    aget v0, v0, v2

    packed-switch v0, :pswitch_data_0

    :pswitch_0
    const/high16 v0, 0x3f800000

    iput v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideOffset:F

    :cond_0
    :goto_0
    const/4 v0, 0x0

    move v3, v0

    :goto_1
    if-lt v3, v6, :cond_4

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mFirstLayout:Z

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->updateObscuredViewVisibility()V

    :cond_1
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mFirstLayout:Z

    return-void

    :pswitch_1
    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCanSlide:Z

    if-eqz v0, :cond_2

    const/4 v0, 0x0

    :goto_2
    iput v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideOffset:F

    goto :goto_0

    :cond_2
    const/high16 v0, 0x3f800000

    goto :goto_2

    :pswitch_2
    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCanSlide:Z

    if-eqz v0, :cond_3

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mAnchorPoint:F

    :goto_3
    iput v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideOffset:F

    goto :goto_0

    :cond_3
    const/high16 v0, 0x3f800000

    goto :goto_3

    :cond_4
    invoke-virtual {p0, v3}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    invoke-virtual {v7}, Landroid/view/View;->getVisibility()I

    move-result v0

    const/16 v2, 0x8

    if-eq v0, v2, :cond_7

    invoke-virtual {v7}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;

    invoke-virtual {v7}, Landroid/view/View;->getMeasuredHeight()I

    move-result v8

    iget-boolean v2, v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;->slideable:Z

    if-eqz v2, :cond_5

    iget v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelHeight:I

    sub-int v2, v8, v2

    iput v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideRange:I

    :cond_5
    iget-boolean v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsSlidingUp:Z

    if-eqz v2, :cond_9

    iget-boolean v0, v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;->slideable:Z

    if-eqz v0, :cond_8

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideRange:I

    int-to-float v0, v0

    iget v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideOffset:F

    mul-float/2addr v0, v2

    float-to-int v0, v0

    add-int/2addr v0, v5

    :goto_4
    move v2, v0

    :cond_6
    :goto_5
    add-int v0, v2, v8

    invoke-virtual {v7}, Landroid/view/View;->getMeasuredWidth()I

    move-result v8

    add-int/2addr v8, v4

    invoke-virtual {v7, v4, v2, v8, v0}, Landroid/view/View;->layout(IIII)V

    :cond_7
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_1

    :cond_8
    move v0, v1

    goto :goto_4

    :cond_9
    iget-boolean v2, v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;->slideable:Z

    if-eqz v2, :cond_a

    iget v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideRange:I

    int-to-float v2, v2

    iget v9, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideOffset:F

    mul-float/2addr v2, v9

    float-to-int v2, v2

    sub-int v2, v5, v2

    :goto_6
    iget-boolean v0, v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;->slideable:Z

    if-nez v0, :cond_6

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mOverlayContent:Z

    if-nez v0, :cond_6

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelHeight:I

    add-int/2addr v2, v0

    goto :goto_5

    :cond_a
    move v2, v1

    goto :goto_6

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method protected onMeasure(II)V
    .locals 12

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v0

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v6

    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v7

    const/high16 v2, 0x40000000

    if-eq v0, v2, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Width must have an exact value or MATCH_PARENT"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    const/high16 v0, 0x40000000

    if-eq v1, v0, :cond_1

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Height must have an exact value or MATCH_PARENT"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getPaddingTop()I

    move-result v0

    sub-int v0, v7, v0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getPaddingBottom()I

    move-result v1

    sub-int v3, v0, v1

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelHeight:I

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getChildCount()I

    move-result v8

    const/4 v1, 0x2

    if-le v8, v1, :cond_2

    const-string v1, "chenee"

    const-string v2, "onMeasure: More than two child views are not supported."

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->e(Ljava/lang/String;Ljava/lang/String;)V

    move v1, v0

    :goto_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCanSlide:Z

    const/4 v0, 0x0

    move v5, v0

    :goto_1
    if-lt v5, v8, :cond_3

    invoke-virtual {p0, v6, v7}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->setMeasuredDimension(II)V

    return-void

    :cond_2
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getVisibility()I

    move-result v1

    const/16 v2, 0x8

    if-ne v1, v2, :cond_b

    const/4 v0, 0x0

    move v1, v0

    goto :goto_0

    :cond_3
    invoke-virtual {p0, v5}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v9

    invoke-virtual {v9}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;

    invoke-virtual {v9}, Landroid/view/View;->getVisibility()I

    move-result v2

    const/16 v4, 0x8

    if-ne v2, v4, :cond_4

    const/4 v2, 0x0

    iput-boolean v2, v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;->dimWhenOffset:Z

    :goto_2
    add-int/lit8 v0, v5, 0x1

    move v5, v0

    goto :goto_1

    :cond_4
    const/4 v2, 0x1

    if-ne v5, v2, :cond_5

    const/4 v2, 0x1

    iput-boolean v2, v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;->slideable:Z

    const/4 v2, 0x1

    iput-boolean v2, v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;->dimWhenOffset:Z

    iput-object v9, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    const/4 v2, 0x1

    iput-boolean v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCanSlide:Z

    move v2, v3

    :goto_3
    iget v4, v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;->width:I

    const/4 v10, -0x2

    if-ne v4, v10, :cond_6

    const/high16 v4, -0x80000000

    invoke-static {v6, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v4

    :goto_4
    iget v10, v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;->height:I

    const/4 v11, -0x2

    if-ne v10, v11, :cond_8

    const/high16 v0, -0x80000000

    invoke-static {v2, v0}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    :goto_5
    invoke-virtual {v9, v4, v0}, Landroid/view/View;->measure(II)V

    goto :goto_2

    :cond_5
    iget-boolean v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mOverlayContent:Z

    if-nez v2, :cond_a

    sub-int v2, v3, v1

    :goto_6
    iput-object v9, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mMainView:Landroid/view/View;

    goto :goto_3

    :cond_6
    iget v4, v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;->width:I

    const/4 v10, -0x1

    if-ne v4, v10, :cond_7

    const/high16 v4, 0x40000000

    invoke-static {v6, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v4

    goto :goto_4

    :cond_7
    iget v4, v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;->width:I

    const/high16 v10, 0x40000000

    invoke-static {v4, v10}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v4

    goto :goto_4

    :cond_8
    iget v10, v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;->height:I

    const/4 v11, -0x1

    if-ne v10, v11, :cond_9

    const/high16 v0, 0x40000000

    invoke-static {v2, v0}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    goto :goto_5

    :cond_9
    iget v0, v0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$LayoutParams;->height:I

    const/high16 v2, 0x40000000

    invoke-static {v0, v2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    goto :goto_5

    :cond_a
    move v2, v3

    goto :goto_6

    :cond_b
    move v1, v0

    goto/16 :goto_0
.end method

.method protected onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 1

    check-cast p1, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$SavedState;

    invoke-virtual {p1}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v0

    invoke-super {p0, v0}, Landroid/view/ViewGroup;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    iget-object v0, p1, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$SavedState;->a:Lcn/com/smartdevices/bracelet/lua/n;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideState:Lcn/com/smartdevices/bracelet/lua/n;

    return-void
.end method

.method protected onSaveInstanceState()Landroid/os/Parcelable;
    .locals 2

    invoke-super {p0}, Landroid/view/ViewGroup;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v0

    new-instance v1, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$SavedState;

    invoke-direct {v1, v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$SavedState;-><init>(Landroid/os/Parcelable;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideState:Lcn/com/smartdevices/bracelet/lua/n;

    iput-object v0, v1, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$SavedState;->a:Lcn/com/smartdevices/bracelet/lua/n;

    return-object v1
.end method

.method protected onSizeChanged(IIII)V
    .locals 1

    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/ViewGroup;->onSizeChanged(IIII)V

    if-eq p2, p4, :cond_0

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mFirstLayout:Z

    :cond_0
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 6

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCanSlide:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsSlidingEnabled:Z

    if-nez v0, :cond_1

    :cond_0
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/ViewDragHelper;->processTouchEvent(Landroid/view/MotionEvent;)V

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    and-int/lit16 v0, v0, 0xff

    packed-switch v0, :pswitch_data_0

    :cond_2
    :goto_1
    const/4 v0, 0x1

    goto :goto_0

    :pswitch_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mInitialMotionX:F

    iput v1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mInitialMotionY:F

    goto :goto_1

    :pswitch_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->dispatchOnPanelLastOffset(Landroid/view/View;)V

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mInitialMotionX:F

    sub-float v3, v1, v0

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mInitialMotionY:F

    sub-float v4, v2, v0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v0}, Landroid/support/v4/widget/ViewDragHelper;->getTouchSlop()I

    move-result v5

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragView:Landroid/view/View;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragView:Landroid/view/View;

    :goto_2
    mul-float/2addr v3, v3

    mul-float/2addr v4, v4

    add-float/2addr v3, v4

    mul-int v4, v5, v5

    int-to-float v4, v4

    cmpg-float v3, v3, v4

    if-gez v3, :cond_2

    float-to-int v1, v1

    float-to-int v2, v2

    invoke-direct {p0, v1, v2}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->isDragViewUnder(II)Z

    move-result v1

    if-eqz v1, :cond_2

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->playSoundEffect(I)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->isExpanded()Z

    move-result v0

    if-nez v0, :cond_4

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->isAnchored()Z

    move-result v0

    if-nez v0, :cond_4

    iget v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mAnchorPoint:F

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->expandPane(F)Z

    goto :goto_1

    :cond_3
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    goto :goto_2

    :cond_4
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->collapsePane()Z

    goto :goto_1

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method setAllChildrenVisible()V
    .locals 6

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getChildCount()I

    move-result v2

    move v0, v1

    :goto_0
    if-lt v0, v2, :cond_0

    return-void

    :cond_0
    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getVisibility()I

    move-result v4

    const/4 v5, 0x4

    if-ne v4, v5, :cond_1

    invoke-virtual {v3, v1}, Landroid/view/View;->setVisibility(I)V

    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public setAnchorPoint(F)V
    .locals 1

    const/4 v0, 0x0

    cmpl-float v0, p1, v0

    if-lez v0, :cond_0

    const/high16 v0, 0x3f800000

    cmpg-float v0, p1, v0

    if-gez v0, :cond_0

    iput p1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mAnchorPoint:F

    :cond_0
    return-void
.end method

.method public setCoveredFadeColor(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCoveredFadeColor:I

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->invalidate()V

    return-void
.end method

.method public setDragView(Landroid/view/View;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragView:Landroid/view/View;

    return-void
.end method

.method public setEnableDragViewTouchEvents(Z)V
    .locals 0

    iput-boolean p1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsUsingDragViewTouchEvents:Z

    return-void
.end method

.method public setListAdapter(Lcn/com/smartdevices/bracelet/lua/LuaListAdapter;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->listAdapter:Lcn/com/smartdevices/bracelet/lua/LuaListAdapter;

    return-void
.end method

.method public setOverlayed(Z)V
    .locals 0

    iput-boolean p1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mOverlayContent:Z

    return-void
.end method

.method public setPanelHeight(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelHeight:I

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->requestLayout()V

    return-void
.end method

.method public setPanelSlideListener(Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mPanelSlideListener:Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout$PanelSlideListener;

    return-void
.end method

.method public setSlidingEnabled(Z)V
    .locals 3

    const-string v0, "chenee"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "setSlidingEnabled  = "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iput-boolean p1, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsSlidingEnabled:Z

    return-void
.end method

.method public showPane()V
    .locals 2

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getChildCount()I

    move-result v0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_0

    :goto_0
    return-void

    :cond_0
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->requestLayout()V

    goto :goto_0
.end method

.method public smoothSlideTo(FI)Z
    .locals 5

    const/4 v1, 0x0

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mCanSlide:Z

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getSlidingTop()I

    move-result v0

    iget-boolean v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mIsSlidingUp:Z

    if-eqz v2, :cond_1

    int-to-float v0, v0

    iget v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideRange:I

    int-to-float v2, v2

    mul-float/2addr v2, p1

    add-float/2addr v0, v2

    float-to-int v0, v0

    :goto_1
    iget-object v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mDragHelper:Landroid/support/v4/widget/ViewDragHelper;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getLeft()I

    move-result v4

    invoke-virtual {v2, v3, v4, v0}, Landroid/support/v4/widget/ViewDragHelper;->smoothSlideViewTo(Landroid/view/View;II)Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->setAllChildrenVisible()V

    invoke-static {p0}, Landroid/support/v4/view/ViewCompat;->postInvalidateOnAnimation(Landroid/view/View;)V

    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    int-to-float v0, v0

    iget v2, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideRange:I

    int-to-float v2, v2

    mul-float/2addr v2, p1

    sub-float/2addr v0, v2

    float-to-int v0, v0

    goto :goto_1

    :cond_2
    move v0, v1

    goto :goto_0
.end method

.method updateObscuredViewVisibility()V
    .locals 11

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getChildCount()I

    move-result v0

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getPaddingLeft()I

    move-result v5

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getWidth()I

    move-result v0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getPaddingRight()I

    move-result v2

    sub-int v6, v0, v2

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getPaddingTop()I

    move-result v7

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getHeight()I

    move-result v0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getPaddingBottom()I

    move-result v2

    sub-int v8, v0, v2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->hasOpaqueBackground(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->mSlideableView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getBottom()I

    move-result v0

    :goto_1
    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/lua/SlidingUpPanelLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v9

    invoke-virtual {v9}, Landroid/view/View;->getLeft()I

    move-result v10

    invoke-static {v5, v10}, Ljava/lang/Math;->max(II)I

    move-result v5

    invoke-virtual {v9}, Landroid/view/View;->getTop()I

    move-result v10

    invoke-static {v7, v10}, Ljava/lang/Math;->max(II)I

    move-result v7

    invoke-virtual {v9}, Landroid/view/View;->getRight()I

    move-result v10

    invoke-static {v6, v10}, Ljava/lang/Math;->min(II)I

    move-result v6

    invoke-virtual {v9}, Landroid/view/View;->getBottom()I

    move-result v10

    invoke-static {v8, v10}, Ljava/lang/Math;->min(II)I

    move-result v8

    if-lt v5, v4, :cond_1

    if-lt v7, v2, :cond_1

    if-gt v6, v3, :cond_1

    if-gt v8, v0, :cond_1

    const/4 v1, 0x4

    :cond_1
    invoke-virtual {v9, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    :cond_2
    move v0, v1

    move v2, v1

    move v3, v1

    move v4, v1

    goto :goto_1
.end method
