package cn.com.smartdevices.bracelet.chart;

import android.graphics.Canvas;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import java.util.Iterator;
import java.util.List;

class b extends BarChart
{
  private b(DynamicDetailChart paramDynamicDetailChart)
  {
  }

  protected void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat)
  {
    synchronized (this.mItems)
    {
      Iterator localIterator1 = this.mItems.iterator();
      int i = 0;
      Iterator localIterator2;
      int j;
      if (!localIterator1.hasNext())
      {
        localIterator2 = this.mItems.iterator();
        j = 0;
      }
      BarChart.BarItem localBarItem;
      do
      {
        if (!localIterator2.hasNext())
        {
          return;
          if (!((BarChart.BarItem)localIterator1.next()).needDraw)
            break;
          i++;
          break;
        }
        localBarItem = (BarChart.BarItem)localIterator2.next();
      }
      while (!localBarItem.needDraw);
      float f = paramFloat / (1.0F - j * (0.6F / i));
      if (f > 1.0F)
        f = 1.0F;
      localBarItem.draw(paramCanvas, f);
      j++;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.b
 * JD-Core Version:    0.6.2
 */