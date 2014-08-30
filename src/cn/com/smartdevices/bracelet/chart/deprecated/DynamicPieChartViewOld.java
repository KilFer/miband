package cn.com.smartdevices.bracelet.chart.deprecated;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;

public class DynamicPieChartViewOld extends BaseChartView<DynamicPieChartOld>
{
  private static final String a = "Chart.DynamicPieChartView";
  private long b;
  private long c;
  private Animator d;

  public DynamicPieChartViewOld(Context paramContext)
  {
    this(paramContext, null);
  }

  public DynamicPieChartViewOld(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DynamicPieChartViewOld(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mChart = new DynamicPieChartOld(paramContext);
    this.mInterpolator = new OvershootInterpolator();
    this.mDuration = 1L;
  }

  private void a()
  {
    float f1 = 1.0F;
    float f2 = (float)Math.abs(this.c - this.b) / ((DynamicPieChartOld)this.mChart).getMaxValue();
    if (f2 > f1)
      f2 = f1;
    this.mDuration = (()(800.0D * Math.sqrt(f2)));
    if (this.mDuration == 0L)
      this.mDuration = 1L;
    if (f2 < f1)
      f1 = (float)Math.sqrt(6.0F * (f1 - f2));
    this.mInterpolator = new OvershootInterpolator(f1);
  }

  private Animator b()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addListener(new l(this));
    localValueAnimator.addUpdateListener(new m(this));
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
      long l2 = this.b + ()((float)(this.c - this.b) * this.mAnimFactor);
      ((DynamicPieChartOld)this.mChart).setValue((float)l2);
      ((DynamicPieChartOld)this.mChart).draw(paramCanvas, 1.0F);
      return;
    }
    long l1 = this.c;
    ((DynamicPieChartOld)this.mChart).setValue((float)l1);
    ((DynamicPieChartOld)this.mChart).draw(paramCanvas, this.mAnimFactor);
  }

  public void setMaxValue(long paramLong)
  {
    ((DynamicPieChartOld)this.mChart).setMaxValue(paramLong);
  }

  public void setValue(long paramLong)
  {
    float f1 = 1.0F;
    this.b = this.c;
    this.c = paramLong;
    float f2 = (float)Math.abs(this.c - this.b) / ((DynamicPieChartOld)this.mChart).getMaxValue();
    if (f2 > f1)
      f2 = f1;
    this.mDuration = (()(800.0D * Math.sqrt(f2)));
    if (this.mDuration == 0L)
      this.mDuration = 1L;
    if (f2 < f1)
      f1 = (float)Math.sqrt(6.0F * (f1 - f2));
    this.mInterpolator = new OvershootInterpolator(f1);
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
      localValueAnimator.addListener(new l(this));
      localValueAnimator.addUpdateListener(new m(this));
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

  public void updateMode(int paramInt)
  {
    ((DynamicPieChartOld)this.mChart).updateMode(paramInt);
    invalidate();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.DynamicPieChartViewOld
 * JD-Core Version:    0.6.2
 */