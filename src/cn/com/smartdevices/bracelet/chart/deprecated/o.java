package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.Canvas;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import cn.com.smartdevices.bracelet.chart.base.BarChart.Axis;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;

final class o extends BarChart
{
  private o(StatisticChartOld paramStatisticChartOld)
  {
  }

  protected final void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.clipRect(paramRectF);
    super.draw(paramCanvas, paramRectF, paramFloat);
    paramCanvas.restore();
  }

  protected final float itemHeight(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    if (paramBarItem.value >= this.mMaxItemValue)
      return paramRectF.height() - this.mPaddingTop - this.mPaddingBottom;
    return paramBarItem.value / this.mMaxItemValue * (paramRectF.height() - 1.0F * this.mDensity - this.mPaddingTop - this.mPaddingBottom) + 1.0F * this.mDensity;
  }

  protected final float itemOffsetX(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    return paramRectF.width() + (-1 + paramBarItem.index) * StatisticChartOld.a() + StatisticChartOld.b(this.a).getScroll();
  }

  protected final float itemWidth(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    return StatisticChartOld.a() - 2.0F * this.mItemPadding;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.o
 * JD-Core Version:    0.6.2
 */