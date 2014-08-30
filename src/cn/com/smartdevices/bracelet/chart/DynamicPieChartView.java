package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;

public class DynamicPieChartView extends BaseChartView<DynamicPieChart>
{
  private static final String a = "Chart.DynamicPieChartView";
  private long b;
  private long c;
  private Animator d;

  public DynamicPieChartView(Context paramContext)
  {
    this(paramContext, null);
  }

  public DynamicPieChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DynamicPieChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mChart = new DynamicPieChart(paramContext, this);
    this.mInterpolator = new DecelerateInterpolator();
    this.mDuration = 1L;
  }

  private void a()
  {
    float f = (float)Math.abs(this.c) / ((DynamicPieChart)this.mChart).getMaxValue();
    if (f > 1.0F)
      f = 1.0F;
    this.mDuration = (()(800.0D * Math.sqrt(f)));
    if (this.mDuration == 0L)
      this.mDuration = 1L;
    this.mAnim = animRefresh(this.mDuration);
  }

  private Animator b()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addListener(new h(this));
    localValueAnimator.addUpdateListener(new i(this));
    localValueAnimator.setDuration(3500L);
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.setRepeatMode(1);
    localValueAnimator.setRepeatCount(-1);
    return localValueAnimator;
  }

  public void dismissLoading()
  {
    if (this.d != null)
      this.d.end();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mAnimFactor < 1.0F)
    {
      long l2 = 0L + ()((float)this.c * this.mAnimFactor);
      ((DynamicPieChart)this.mChart).setValue((float)l2);
      ((DynamicPieChart)this.mChart).draw(paramCanvas, 1.0F);
      return;
    }
    long l1 = this.c;
    ((DynamicPieChart)this.mChart).setValue((float)l1);
    ((DynamicPieChart)this.mChart).draw(paramCanvas, this.mAnimFactor);
  }

  public void setMaxValue(long paramLong)
  {
    ((DynamicPieChart)this.mChart).setMaxValue(paramLong);
  }

  public void setMode(int paramInt)
  {
    ((DynamicPieChart)this.mChart).setMode(paramInt);
    invalidate();
  }

  public void setValue(long paramLong)
  {
    this.c = paramLong;
    float f = (float)Math.abs(this.c) / ((DynamicPieChart)this.mChart).getMaxValue();
    if (f > 1.0F)
      f = 1.0F;
    this.mDuration = (()(800.0D * Math.sqrt(f)));
    if (this.mDuration == 0L)
      this.mDuration = 1L;
    this.mAnim = animRefresh(this.mDuration);
  }

  public void showLoading()
  {
    showLoading(0L);
  }

  public void showLoading(long paramLong)
  {
    if (this.d == null)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.addListener(new h(this));
      localValueAnimator.addUpdateListener(new i(this));
      localValueAnimator.setDuration(3500L);
      localValueAnimator.setInterpolator(new LinearInterpolator());
      localValueAnimator.setRepeatMode(1);
      localValueAnimator.setRepeatCount(-1);
      this.d = localValueAnimator;
    }
    if (!this.d.isStarted())
    {
      if (paramLong > 0L)
        this.d.setStartDelay(paramLong);
      this.d.start();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.DynamicPieChartView
 * JD-Core Version:    0.6.2
 */