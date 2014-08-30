package cn.com.smartdevices.bracelet.chart.base;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;

public abstract class BaseChartView<T extends BaseChart<? extends Chart.Item>> extends View
{
  private static final String a = "Chart.BaseView";
  protected Animator mAnim;
  protected float mAnimFactor = 1.0F;
  protected T mChart;
  protected long mDuration = 500L;
  protected Interpolator mInterpolator = new LinearInterpolator();
  protected boolean mIsAttached = true;
  protected boolean mIsScrollingPerformed;
  protected ChartDataLoader mLoader;
  protected boolean mScrollable;
  protected ChartScroller mScroller;
  protected int mScrollingOffset;

  public BaseChartView(Context paramContext)
  {
    this(paramContext, null);
  }

  public BaseChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public BaseChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      animRefresh();
      if (!this.mAnim.isStarted())
        this.mAnim.start();
      return;
    }
    this.mAnimFactor = paramFloat;
    postInvalidateOnAnimation();
  }

  public Animator animRefresh()
  {
    if (this.mAnim == null)
      this.mAnim = animRefresh(this.mDuration);
    return this.mAnim;
  }

  public Animator animRefresh(long paramLong)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F });
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.setInterpolator(this.mInterpolator);
    localValueAnimator.addUpdateListener(new a(this));
    return localValueAnimator;
  }

  public void attach()
  {
    this.mIsAttached = true;
  }

  public void detach()
  {
    this.mIsAttached = false;
  }

  public ChartDataLoader getDataLoader()
  {
    return this.mLoader;
  }

  public boolean isAttached()
  {
    return this.mIsAttached;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    this.mChart.draw(paramCanvas, this.mAnimFactor);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect();
    localRect.left = getPaddingLeft();
    localRect.top = getPaddingTop();
    localRect.right = (paramInt1 - getPaddingRight());
    localRect.bottom = (paramInt2 - getPaddingBottom());
    this.mChart.setRect(localRect);
  }

  public void refresh()
  {
    a(1.0F, false);
  }

  public void refresh(float paramFloat)
  {
    a(paramFloat, false);
  }

  public void refresh(boolean paramBoolean)
  {
    if (paramBoolean);
    for (float f = 0.0F; ; f = 1.0F)
    {
      a(f, paramBoolean);
      return;
    }
  }

  public void setDataLoader(ChartDataLoader paramChartDataLoader)
  {
    this.mLoader = paramChartDataLoader;
  }

  public void setScrollable(boolean paramBoolean)
  {
    this.mScrollable = paramBoolean;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.base.BaseChartView
 * JD-Core Version:    0.6.2
 */