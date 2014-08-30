package cn.com.smartdevices.bracelet.chart;

import android.graphics.Canvas;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import cn.com.smartdevices.bracelet.chart.base.BarChart.Axis;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import java.util.Iterator;
import java.util.List;

class n extends BarChart
{
  private n(StatisticChart paramStatisticChart)
  {
  }

  public final void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    synchronized (this.mItems)
    {
      Iterator localIterator = this.mItems.iterator();
      BarChart.BarItem localBarItem;
      do
      {
        if (!localIterator.hasNext())
          return;
        localBarItem = (BarChart.BarItem)localIterator.next();
      }
      while (!localBarItem.needDraw);
      ((StatisticChart.StatisticBarItem)localBarItem).draw(paramCanvas, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
    }
  }

  protected float itemOffsetX(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    return (StatisticChart.d(this.a) + paramBarItem.index) * StatisticChart.a(this.a) + StatisticChart.e(this.a).getScroll();
  }

  protected float itemWidth(RectF paramRectF, BarChart.BarItem paramBarItem)
  {
    return StatisticChart.a(this.a) - 2.0F * this.mItemPadding;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.n
 * JD-Core Version:    0.6.2
 */