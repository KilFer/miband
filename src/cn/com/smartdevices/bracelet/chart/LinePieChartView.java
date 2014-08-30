package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;

public class LinePieChartView extends BaseChartView<LinePieChart>
{
  private static final String a = "LinePieChartView";
  private float b;
  private Animator c;

  public LinePieChartView(Context paramContext)
  {
    this(paramContext, null);
  }

  public LinePieChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public LinePieChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mChart = new LinePieChart(paramContext);
    this.mInterpolator = new DecelerateInterpolator();
    this.mDuration = 1L;
  }

  private void a()
  {
    float f = this.b / ((LinePieChart)this.mChart).getMaxValue();
    if (f > 1.0F)
      f = 1.0F;
    this.mDuration = (()(800.0D * Math.sqrt(f)));
    if (this.mDuration == 0L)
      this.mDuration = 1L;
  }

  private Animator b()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addListener(new k(this));
    localValueAnimator.addUpdateListener(new l(this));
    localValueAnimator.setDuration(3500L);
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.setRepeatMode(1);
    localValueAnimator.setRepeatCount(-1);
    return localValueAnimator;
  }

  public void dismissLoading()
  {
    if (this.c != null)
    {
      this.c.end();
      ((LinePieChart)this.mChart).dismissLoading();
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mAnimFactor < 1.0F)
    {
      float f2 = this.b * this.mAnimFactor;
      ((LinePieChart)this.mChart).setValue(f2);
      ((LinePieChart)this.mChart).draw(paramCanvas, 1.0F);
      return;
    }
    float f1 = this.b;
    ((LinePieChart)this.mChart).setValue(f1);
    ((LinePieChart)this.mChart).draw(paramCanvas, this.mAnimFactor);
  }

  public void setMaxValue(long paramLong)
  {
    ((LinePieChart)this.mChart).setMaxValue(paramLong);
  }

  public void setMode(int paramInt)
  {
    ((LinePieChart)this.mChart).setMode(paramInt);
    invalidate();
  }

  public void setValue(long paramLong)
  {
    this.b = ((float)paramLong);
    float f = this.b / ((LinePieChart)this.mChart).getMaxValue();
    if (f > 1.0F)
      f = 1.0F;
    this.mDuration = (()(800.0D * Math.sqrt(f)));
    if (this.mDuration == 0L)
      this.mDuration = 1L;
  }

  public void showLoading()
  {
    showLoading(0L);
  }

  public void showLoading(long paramLong)
  {
    if (this.c == null)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.addListener(new k(this));
      localValueAnimator.addUpdateListener(new l(this));
      localValueAnimator.setDuration(3500L);
      localValueAnimator.setInterpolator(new LinearInterpolator());
      localValueAnimator.setRepeatMode(1);
      localValueAnimator.setRepeatCount(-1);
      this.c = localValueAnimator;
    }
    if (!this.c.isStarted())
    {
      if (paramLong > 0L)
        this.c.setStartDelay(paramLong);
      this.c.start();
    }
  }

  public void showNormalLine()
  {
    ((LinePieChart)this.mChart).setMode(0);
    refresh(false);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.LinePieChartView
 * JD-Core Version:    0.6.2
 */