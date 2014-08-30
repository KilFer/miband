package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import cn.com.smartdevices.bracelet.Debug;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.xiaomi.hm.health.R.styleable;

public class SlidingUpPanelLayout extends ViewGroup
{
  private static final int[] DEFAULT_ATTRS = { 16842927 };
  private static final int DEFAULT_FADE_COLOR = -1728053248;
  private static final int DEFAULT_MIN_FLING_VELOCITY = 400;
  private static final boolean DEFAULT_OVERLAY_FLAG = false;
  private static final int DEFAULT_PANEL_HEIGHT = 68;
  private static final int DEFAULT_PARALAX_OFFSET = 0;
  private static final int DEFAULT_SHADOW_HEIGHT = 4;
  private static final int ONE_PAGE_ITEMS = 8;
  private static final String TAG = "chenee";
  private Boolean isPressed = Boolean.valueOf(false);
  private LuaListAdapter listAdapter = null;
  private float mAnchorPoint = 0.0F;
  private boolean mCanSlide;
  private int mCoveredFadeColor = -1728053248;
  private final Paint mCoveredFadePaint = new Paint();
  private final ViewDragHelper mDragHelper;
  private View mDragView;
  private int mDragViewResId = -1;
  private boolean mFirstLayout = true;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private boolean mIsSlidingEnabled;
  private boolean mIsSlidingUp;
  private boolean mIsUnableToDrag;
  private boolean mIsUsingDragViewTouchEvents;
  private View mMainView;
  private int mMinFlingVelocity = 400;
  private boolean mOverlayContent = false;
  private int mPanelHeight = -1;
  private SlidingUpPanelLayout.PanelSlideListener mPanelSlideListener;
  private int mParalaxOffset = -1;
  private final int mScrollTouchSlop;
  private final Drawable mShadowDrawable;
  private int mShadowHeight = -1;
  private float mSlideOffset;
  private int mSlideRange;
  private n mSlideState = n.b;
  private View mSlideableView;
  private final Rect mTmpRect = new Rect();

  public SlidingUpPanelLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public SlidingUpPanelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SlidingUpPanelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
    {
      this.mShadowDrawable = null;
      this.mScrollTouchSlop = 0;
      this.mDragHelper = null;
      return;
    }
    boolean bool;
    float f;
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, DEFAULT_ATTRS);
      if (localTypedArray1 != null)
      {
        int i = localTypedArray1.getInt(0, 0);
        if ((i != 48) && (i != 80))
          throw new IllegalArgumentException("gravity must be set to either top or bottom");
        if (i == 80)
        {
          bool = true;
          this.mIsSlidingUp = bool;
        }
      }
      else
      {
        localTypedArray1.recycle();
        TypedArray localTypedArray2 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SlidingUpPanelLayout);
        if (localTypedArray2 != null)
        {
          this.mPanelHeight = localTypedArray2.getDimensionPixelSize(0, -1);
          this.mShadowHeight = localTypedArray2.getDimensionPixelSize(1, -1);
          this.mParalaxOffset = localTypedArray2.getDimensionPixelSize(2, -1);
          this.mMinFlingVelocity = localTypedArray2.getInt(4, 400);
          this.mCoveredFadeColor = localTypedArray2.getColor(3, -1728053248);
          this.mDragViewResId = localTypedArray2.getResourceId(5, -1);
          this.mOverlayContent = localTypedArray2.getBoolean(6, false);
        }
        localTypedArray2.recycle();
      }
    }
    else
    {
      f = paramContext.getResources().getDisplayMetrics().density;
      if (this.mPanelHeight == -1)
        this.mPanelHeight = ((int)(0.5F + 68.0F * f));
      if (this.mShadowHeight == -1)
        this.mShadowHeight = ((int)(0.5F + 4.0F * f));
      if (this.mParalaxOffset == -1)
        this.mParalaxOffset = ((int)(0.0F * f));
      if (this.mShadowHeight <= 0)
        break label475;
      if (!this.mIsSlidingUp)
        break label459;
      this.mShadowDrawable = getResources().getDrawable(2130837505);
    }
    while (true)
    {
      setWillNotDraw(false);
      this.mDragHelper = ViewDragHelper.create(this, 0.5F, new l(this, (byte)0));
      this.mDragHelper.setMinVelocity(f * this.mMinFlingVelocity);
      this.mCanSlide = true;
      this.mIsSlidingEnabled = true;
      this.mScrollTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
      return;
      bool = false;
      break;
      label459: this.mShadowDrawable = getResources().getDrawable(2130837516);
      continue;
      label475: this.mShadowDrawable = null;
    }
  }

  private boolean collapsePane(View paramView, int paramInt)
  {
    return (this.mFirstLayout) || (smoothSlideTo(1.0F, paramInt));
  }

  private boolean expandPane(View paramView, int paramInt, float paramFloat)
  {
    return (this.mFirstLayout) || (smoothSlideTo(paramFloat, paramInt));
  }

  private int getSlidingTop()
  {
    if (this.mSlideableView != null)
    {
      if (this.mIsSlidingUp)
        return getMeasuredHeight() - getPaddingBottom() - this.mSlideableView.getMeasuredHeight();
      return getPaddingTop();
    }
    return getMeasuredHeight() - getPaddingBottom();
  }

  private static boolean hasOpaqueBackground(View paramView)
  {
    Drawable localDrawable = paramView.getBackground();
    return (localDrawable != null) && (localDrawable.getOpacity() == -1);
  }

  private boolean innerListViewNeedSlide(float paramFloat)
  {
    return (this.mInitialMotionY - paramFloat > this.mScrollTouchSlop) && (this.listAdapter.getCount() >= 8);
  }

  private boolean isDragViewUnder(int paramInt1, int paramInt2)
  {
    View localView;
    if (this.mDragView != null)
    {
      localView = this.mDragView;
      if (localView != null)
        break label26;
    }
    label26: int[] arrayOfInt1;
    int i;
    int j;
    do
    {
      return false;
      localView = this.mSlideableView;
      break;
      arrayOfInt1 = new int[2];
      localView.getLocationOnScreen(arrayOfInt1);
      int[] arrayOfInt2 = new int[2];
      getLocationOnScreen(arrayOfInt2);
      i = paramInt1 + arrayOfInt2[0];
      j = paramInt2 + arrayOfInt2[1];
    }
    while ((i < arrayOfInt1[0]) || (i >= arrayOfInt1[0] + localView.getWidth()) || (j < arrayOfInt1[1]) || (j >= arrayOfInt1[1] + localView.getHeight()));
    return true;
  }

  private void onPanelDragged(int paramInt)
  {
    int i = getSlidingTop();
    if (this.mIsSlidingUp);
    int j;
    for (float f = (paramInt - i) / this.mSlideRange; ; f = (i - paramInt) / this.mSlideRange)
    {
      this.mSlideOffset = f;
      dispatchOnPanelSlide(this.mSlideableView);
      if (this.mParalaxOffset > 0)
      {
        j = getCurrentParalaxOffset();
        if (Build.VERSION.SDK_INT < 11)
          break;
        this.mMainView.setTranslationY(j);
      }
      return;
    }
    AnimatorProxy.wrap(this.mMainView).setTranslationY(j);
  }

  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    ViewGroup localViewGroup;
    int i;
    int j;
    if ((paramView instanceof ViewGroup))
    {
      localViewGroup = (ViewGroup)paramView;
      i = paramView.getScrollX();
      j = paramView.getScrollY();
    }
    for (int k = -1 + localViewGroup.getChildCount(); ; k--)
    {
      if (k < 0)
        if ((!paramBoolean) || (!ViewCompat.canScrollHorizontally(paramView, -paramInt1)))
          break;
      View localView;
      do
      {
        return true;
        localView = localViewGroup.getChildAt(k);
      }
      while ((paramInt2 + i >= localView.getLeft()) && (paramInt2 + i < localView.getRight()) && (paramInt3 + j >= localView.getTop()) && (paramInt3 + j < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2 + i - localView.getLeft(), paramInt3 + j - localView.getTop())));
    }
    return false;
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof SlidingUpPanelLayout.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }

  public boolean collapsePane()
  {
    return collapsePane(this.mSlideableView, 0);
  }

  public void computeScroll()
  {
    if (this.mDragHelper == null);
    while (!this.mDragHelper.continueSettling(true))
      return;
    if (!this.mCanSlide)
    {
      this.mDragHelper.abort();
      return;
    }
    ViewCompat.postInvalidateOnAnimation(this);
  }

  void dispatchOnPanelAnchored(View paramView)
  {
    if (this.mPanelSlideListener != null)
      this.mPanelSlideListener.onPanelAnchored(paramView);
    sendAccessibilityEvent(32);
  }

  void dispatchOnPanelCollapsed(View paramView)
  {
    if (this.mPanelSlideListener != null)
      this.mPanelSlideListener.onPanelCollapsed(paramView);
    sendAccessibilityEvent(32);
  }

  void dispatchOnPanelExpanded(View paramView)
  {
    if (this.mPanelSlideListener != null)
      this.mPanelSlideListener.onPanelExpanded(paramView);
    sendAccessibilityEvent(32);
  }

  void dispatchOnPanelLastOffset(View paramView)
  {
    if (this.mPanelSlideListener != null)
      this.mPanelSlideListener.onLastSlideOffset(paramView, this.mSlideOffset);
  }

  void dispatchOnPanelSlide(View paramView)
  {
    if (this.mPanelSlideListener != null)
      this.mPanelSlideListener.onPanelSlide(paramView, this.isPressed, this.mSlideOffset);
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.mSlideableView == null)
      return;
    int i = this.mSlideableView.getRight();
    int j;
    if (this.mIsSlidingUp)
      j = this.mSlideableView.getTop() - this.mShadowHeight;
    for (int k = this.mSlideableView.getTop(); ; k = this.mSlideableView.getBottom() + this.mShadowHeight)
    {
      int m = this.mSlideableView.getLeft();
      if (this.mShadowDrawable == null)
        break;
      this.mShadowDrawable.setBounds(m, j, i, k);
      this.mShadowDrawable.draw(paramCanvas);
      return;
      j = this.mSlideableView.getBottom();
    }
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    SlidingUpPanelLayout.LayoutParams localLayoutParams = (SlidingUpPanelLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramCanvas.save(2);
    if ((this.mCanSlide) && (!localLayoutParams.slideable) && (this.mSlideableView != null))
      if (!this.mOverlayContent)
      {
        paramCanvas.getClipBounds(this.mTmpRect);
        if (this.mIsSlidingUp)
        {
          this.mTmpRect.bottom = Math.min(this.mTmpRect.bottom, this.mSlideableView.getTop());
          paramCanvas.clipRect(this.mTmpRect);
        }
      }
      else
      {
        if (this.mSlideOffset >= 1.0F)
          break label211;
      }
    label211: for (int j = 1; ; j = 0)
    {
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i);
      if (j != 0)
      {
        int k = (int)(((0xFF000000 & this.mCoveredFadeColor) >>> 24) * (1.0F - this.mSlideOffset)) << 24 | 0xFFFFFF & this.mCoveredFadeColor;
        this.mCoveredFadePaint.setColor(k);
        paramCanvas.drawRect(this.mTmpRect, this.mCoveredFadePaint);
      }
      return bool;
      this.mTmpRect.top = Math.max(this.mTmpRect.top, this.mSlideableView.getBottom());
      break;
    }
  }

  public boolean expandPane()
  {
    return expandPane(0.0F);
  }

  public boolean expandPane(float paramFloat)
  {
    if (!isPaneVisible())
      showPane();
    return expandPane(this.mSlideableView, 0, paramFloat);
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new SlidingUpPanelLayout.LayoutParams();
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new SlidingUpPanelLayout.LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
      return new SlidingUpPanelLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    return new SlidingUpPanelLayout.LayoutParams(paramLayoutParams);
  }

  public int getCoveredFadeColor()
  {
    return this.mCoveredFadeColor;
  }

  public int getCurrentParalaxOffset()
  {
    int i = (int)(this.mParalaxOffset * (1.0F - this.mSlideOffset));
    if (this.mIsSlidingUp)
      i = -i;
    return i;
  }

  public int getPanelHeight()
  {
    return this.mPanelHeight;
  }

  int getPullDownDistance()
  {
    if (this.mPanelSlideListener != null)
      return this.mPanelSlideListener.onGetPullDownDistance();
    return 0;
  }

  Boolean getPullDownDockEnable()
  {
    if (this.mPanelSlideListener != null)
      return this.mPanelSlideListener.onGetPullDownDockEnable();
    return Boolean.valueOf(true);
  }

  float getSlideThreshhold()
  {
    if (this.mPanelSlideListener != null)
      return this.mPanelSlideListener.onGetThreshhold();
    return 0.0F;
  }

  float getSlideThreshhold2()
  {
    if (this.mPanelSlideListener != null)
      return this.mPanelSlideListener.onGetThreshhold2();
    return 0.0F;
  }

  public Boolean getSlidingEnable()
  {
    return Boolean.valueOf(this.mIsSlidingEnabled);
  }

  public void hidePane()
  {
    if (this.mSlideableView == null)
      return;
    this.mSlideableView.setVisibility(8);
    requestLayout();
  }

  public boolean isAnchored()
  {
    return this.mSlideState == n.c;
  }

  public boolean isCollapsed()
  {
    return this.mSlideState == n.b;
  }

  public boolean isExpanded()
  {
    return this.mSlideState == n.a;
  }

  public boolean isOverlayed()
  {
    return this.mOverlayContent;
  }

  public boolean isPaneVisible()
  {
    if (getChildCount() < 2);
    while (getChildAt(1).getVisibility() != 0)
      return false;
    return true;
  }

  public boolean isSlideable()
  {
    return this.mCanSlide;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (this.mDragViewResId != -1)
      this.mDragView = findViewById(this.mDragViewResId);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    boolean bool1;
    if ((!this.mCanSlide) || (!this.mIsSlidingEnabled) || ((this.mIsUnableToDrag) && (i != 0)))
    {
      this.mDragHelper.cancel();
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    if ((i == 3) || (i == 1))
    {
      this.mDragHelper.cancel();
      return false;
    }
    label108: boolean bool2;
    switch (i)
    {
    case 1:
    default:
      bool2 = false;
    case 0:
    case 2:
    }
    while (true)
    {
      if (!this.mDragHelper.shouldInterceptTouchEvent(paramMotionEvent))
      {
        bool1 = false;
        if (!bool2)
          break;
      }
      return true;
      this.mIsUnableToDrag = false;
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      if ((!isDragViewUnder((int)f1, (int)f2)) || (this.mIsUsingDragViewTouchEvents))
        break label108;
      bool2 = true;
      continue;
      float f3 = Math.abs(f1 - this.mInitialMotionX);
      float f4 = Math.abs(f2 - this.mInitialMotionY);
      int j = this.mDragHelper.getTouchSlop();
      if ((isExpanded()) && (this.listAdapter != null) && (innerListViewNeedSlide(f2)))
      {
        setSlidingEnabled(false);
        return false;
      }
      if (this.mIsUsingDragViewTouchEvents)
      {
        if ((f3 > this.mScrollTouchSlop) && (f4 < this.mScrollTouchSlop))
          return super.onInterceptTouchEvent(paramMotionEvent);
        if (f4 <= this.mScrollTouchSlop);
      }
      for (bool2 = isDragViewUnder((int)f1, (int)f2); ((f4 > j) && (f3 > f4)) || (!isDragViewUnder((int)f1, (int)f2)); bool2 = false)
      {
        this.mDragHelper.cancel();
        this.mIsUnableToDrag = true;
        return false;
      }
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getSlidingTop();
    int m = getChildCount();
    if (this.mFirstLayout);
    int n;
    switch ($SWITCH_TABLE$cn$com$smartdevices$bracelet$lua$SlidingUpPanelLayout$SlideState()[this.mSlideState.ordinal()])
    {
    case 2:
    default:
      this.mSlideOffset = 1.0F;
      n = 0;
      if (n >= m)
      {
        if (this.mFirstLayout)
          updateObscuredViewVisibility();
        this.mFirstLayout = false;
        return;
      }
      break;
    case 1:
      if (this.mCanSlide);
      for (float f2 = 0.0F; ; f2 = 1.0F)
      {
        this.mSlideOffset = f2;
        break;
      }
    case 3:
      if (this.mCanSlide);
      for (float f1 = this.mAnchorPoint; ; f1 = 1.0F)
      {
        this.mSlideOffset = f1;
        break;
      }
    }
    View localView = getChildAt(n);
    SlidingUpPanelLayout.LayoutParams localLayoutParams;
    int i1;
    int i4;
    label238: int i2;
    if (localView.getVisibility() != 8)
    {
      localLayoutParams = (SlidingUpPanelLayout.LayoutParams)localView.getLayoutParams();
      i1 = localView.getMeasuredHeight();
      if (localLayoutParams.slideable)
        this.mSlideRange = (i1 - this.mPanelHeight);
      if (!this.mIsSlidingUp)
        break label281;
      if (!localLayoutParams.slideable)
        break label274;
      i4 = k + (int)(this.mSlideRange * this.mSlideOffset);
      i2 = i4;
    }
    label274: label281: label337: 
    while (true)
    {
      int i3 = i2 + i1;
      localView.layout(i, i2, i + localView.getMeasuredWidth(), i3);
      n++;
      break;
      i4 = j;
      break label238;
      if (localLayoutParams.slideable);
      for (i2 = k - (int)(this.mSlideRange * this.mSlideOffset); ; i2 = j)
      {
        if ((localLayoutParams.slideable) || (this.mOverlayContent))
          break label337;
        i2 += this.mPanelHeight;
        break;
      }
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    if (i != 1073741824)
      throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
    if (k != 1073741824)
      throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
    int n = m - getPaddingTop() - getPaddingBottom();
    int i1 = this.mPanelHeight;
    int i2 = getChildCount();
    int i3;
    if (i2 > 2)
    {
      Debug.e("chenee", "onMeasure: More than two child views are not supported.");
      i3 = i1;
    }
    while (true)
    {
      this.mSlideableView = null;
      this.mCanSlide = false;
      int i4 = 0;
      if (i4 >= i2)
      {
        setMeasuredDimension(j, m);
        return;
        if (getChildAt(1).getVisibility() == 8)
          i3 = 0;
      }
      else
      {
        View localView = getChildAt(i4);
        SlidingUpPanelLayout.LayoutParams localLayoutParams = (SlidingUpPanelLayout.LayoutParams)localView.getLayoutParams();
        if (localView.getVisibility() == 8)
          localLayoutParams.dimWhenOffset = false;
        int i6;
        label245: int i7;
        while (true)
        {
          i4++;
          break;
          if (i4 != 1)
            break label277;
          localLayoutParams.slideable = true;
          localLayoutParams.dimWhenOffset = true;
          this.mSlideableView = localView;
          this.mCanSlide = true;
          i5 = n;
          if (localLayoutParams.width != -2)
            break label300;
          i6 = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
          if (localLayoutParams.height != -2)
            break label338;
          i7 = View.MeasureSpec.makeMeasureSpec(i5, -2147483648);
          label265: localView.measure(i6, i7);
        }
        label277: if (!this.mOverlayContent);
        for (int i5 = n - i3; ; i5 = n)
        {
          this.mMainView = localView;
          break;
          label300: if (localLayoutParams.width == -1)
          {
            i6 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
            break label245;
          }
          i6 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);
          break label245;
          label338: if (localLayoutParams.height == -1)
          {
            i7 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            break label265;
          }
          i7 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
          break label265;
        }
        i3 = i1;
      }
    }
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SlidingUpPanelLayout.SavedState localSavedState = (SlidingUpPanelLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    this.mSlideState = localSavedState.a;
  }

  protected Parcelable onSaveInstanceState()
  {
    SlidingUpPanelLayout.SavedState localSavedState = new SlidingUpPanelLayout.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.mSlideState;
    return localSavedState;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt2 != paramInt4)
      this.mFirstLayout = true;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.mCanSlide) || (!this.mIsSlidingEnabled))
      return super.onTouchEvent(paramMotionEvent);
    this.mDragHelper.processTouchEvent(paramMotionEvent);
    switch (0xFF & paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      return true;
      float f5 = paramMotionEvent.getX();
      float f6 = paramMotionEvent.getY();
      this.mInitialMotionX = f5;
      this.mInitialMotionY = f6;
      continue;
      dispatchOnPanelLastOffset(this.mSlideableView);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = f1 - this.mInitialMotionX;
      float f4 = f2 - this.mInitialMotionY;
      int i = this.mDragHelper.getTouchSlop();
      if (this.mDragView != null);
      for (View localView = this.mDragView; ; localView = this.mSlideableView)
      {
        if ((f3 * f3 + f4 * f4 >= i * i) || (!isDragViewUnder((int)f1, (int)f2)))
          break label216;
        localView.playSoundEffect(0);
        if ((isExpanded()) || (isAnchored()))
          break label218;
        expandPane(this.mAnchorPoint);
        break;
      }
      label216: continue;
      label218: collapsePane();
    }
  }

  void setAllChildrenVisible()
  {
    int i = getChildCount();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return;
      View localView = getChildAt(j);
      if (localView.getVisibility() == 4)
        localView.setVisibility(0);
    }
  }

  public void setAnchorPoint(float paramFloat)
  {
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F))
      this.mAnchorPoint = paramFloat;
  }

  public void setCoveredFadeColor(int paramInt)
  {
    this.mCoveredFadeColor = paramInt;
    invalidate();
  }

  public void setDragView(View paramView)
  {
    this.mDragView = paramView;
  }

  public void setEnableDragViewTouchEvents(boolean paramBoolean)
  {
    this.mIsUsingDragViewTouchEvents = paramBoolean;
  }

  public void setListAdapter(LuaListAdapter paramLuaListAdapter)
  {
    this.listAdapter = paramLuaListAdapter;
  }

  public void setOverlayed(boolean paramBoolean)
  {
    this.mOverlayContent = paramBoolean;
  }

  public void setPanelHeight(int paramInt)
  {
    this.mPanelHeight = paramInt;
    requestLayout();
  }

  public void setPanelSlideListener(SlidingUpPanelLayout.PanelSlideListener paramPanelSlideListener)
  {
    this.mPanelSlideListener = paramPanelSlideListener;
  }

  public void setSlidingEnabled(boolean paramBoolean)
  {
    Debug.i("chenee", "setSlidingEnabled  = " + paramBoolean);
    this.mIsSlidingEnabled = paramBoolean;
  }

  public void showPane()
  {
    if (getChildCount() < 2)
      return;
    getChildAt(1).setVisibility(0);
    requestLayout();
  }

  public boolean smoothSlideTo(float paramFloat, int paramInt)
  {
    if (!this.mCanSlide)
      return false;
    int i = getSlidingTop();
    if (this.mIsSlidingUp);
    for (int j = (int)(i + paramFloat * this.mSlideRange); this.mDragHelper.smoothSlideViewTo(this.mSlideableView, this.mSlideableView.getLeft(), j); j = (int)(i - paramFloat * this.mSlideRange))
    {
      setAllChildrenVisible();
      ViewCompat.postInvalidateOnAnimation(this);
      return true;
    }
    return false;
  }

  void updateObscuredViewVisibility()
  {
    if (getChildCount() == 0)
      return;
    int i = getPaddingLeft();
    int j = getWidth() - getPaddingRight();
    int k = getPaddingTop();
    int m = getHeight() - getPaddingBottom();
    int i3;
    int i2;
    int i1;
    int n;
    if ((this.mSlideableView != null) && (hasOpaqueBackground(this.mSlideableView)))
    {
      i3 = this.mSlideableView.getLeft();
      i2 = this.mSlideableView.getRight();
      i1 = this.mSlideableView.getTop();
      n = this.mSlideableView.getBottom();
    }
    while (true)
    {
      View localView = getChildAt(0);
      int i4 = Math.max(i, localView.getLeft());
      int i5 = Math.max(k, localView.getTop());
      int i6 = Math.min(j, localView.getRight());
      int i7 = Math.min(m, localView.getBottom());
      int i8 = 0;
      if (i4 >= i3)
      {
        i8 = 0;
        if (i5 >= i1)
        {
          i8 = 0;
          if (i6 <= i2)
          {
            i8 = 0;
            if (i7 <= n)
              i8 = 4;
          }
        }
      }
      localView.setVisibility(i8);
      return;
      n = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout
 * JD-Core Version:    0.6.2
 */