package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;

final class c extends b
{
  private c(DynamicDetailChartOld paramDynamicDetailChartOld)
  {
    super(paramDynamicDetailChartOld, (byte)0);
  }

  protected final float itemHeight(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    float f;
    if (paramBarItem.index > DynamicDetailChartOld.c(this.a))
      f = 0.0F;
    do
    {
      return f;
      a locala = (a)DynamicDetailChartOld.d(this.a);
      f = paramBarItem.scope / 1440.0F * (paramRectF.height() - this.mPaddingTop - this.mPaddingBottom - DynamicDetailChartOld.a(this.a) - locala.getPaddingBottom());
    }
    while (f >= 1.0F * this.mDensity);
    return 1.0F * this.mDensity;
  }

  protected final float itemOffsetX(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    return 0.0F;
  }

  protected final float itemOffsetY(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    a locala = (a)DynamicDetailChartOld.d(this.a);
    return paramBarItem.index / 1440.0F * (paramRectF.height() - this.mPaddingTop - this.mPaddingBottom - DynamicDetailChartOld.a(this.a) - locala.getPaddingBottom()) + locala.b();
  }

  protected final float itemWidth(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    if (paramBarItem.value >= this.mMaxItemValue)
      return paramRectF.width() - this.mPaddingLeft - this.mPaddingRight;
    return paramBarItem.value / this.mMaxItemValue * (paramRectF.width() - this.mPaddingLeft - this.mPaddingRight);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.c
 * JD-Core Version:    0.6.2
 */