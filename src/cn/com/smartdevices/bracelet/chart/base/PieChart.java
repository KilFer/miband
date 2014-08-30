package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

public abstract class PieChart extends BaseChart<Chart.Item>
{
  protected float mMaxValue;
  protected float mRadius;
  protected float mRate;
  protected float mRotate;
  protected float mValue;

  public PieChart(Context paramContext)
  {
    super(paramContext);
  }

  protected void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat)
  {
    drawPie(paramCanvas, paramRectF, paramRectF.left + this.mRadius, paramRectF.top + this.mRadius, this.mRadius, this.mRate, paramFloat);
  }

  protected abstract void drawPie(Canvas paramCanvas, RectF paramRectF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5);

  public float getMaxValue()
  {
    return this.mMaxValue;
  }

  protected void onRectChanged(RectF paramRectF)
  {
    this.mRadius = (Math.min(paramRectF.width(), paramRectF.height()) / 2.0F);
  }

  public void rotate(float paramFloat)
  {
    this.mRotate = paramFloat;
  }

  public void setMaxValue(long paramLong)
  {
    this.mMaxValue = ((float)paramLong);
    updateRate();
  }

  public void setValue(float paramFloat)
  {
    this.mValue = paramFloat;
    updateRate();
  }

  protected void updateRate()
  {
    if (this.mMaxValue == 0.0F)
    {
      this.mRate = 0.0F;
      return;
    }
    if (this.mValue >= this.mMaxValue)
    {
      this.mRate = 1.0F;
      return;
    }
    this.mRate = (this.mValue / this.mMaxValue);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.base.PieChart
 * JD-Core Version:    0.6.2
 */