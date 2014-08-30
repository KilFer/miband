package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import cn.com.smartdevices.bracelet.chart.base.Renderer;

public class StatisticChartOld$StatisticBarItem extends BarChart.BarItem
{
  protected void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat)
  {
    if ((!this.needDraw) && (paramRectF.height() == 0.0F))
      return;
    float f1 = paramRectF.left + paramRectF.width() / 2.0F;
    float f2 = paramRectF.bottom;
    float f3 = paramRectF.bottom - paramFloat * paramRectF.height();
    this.mRenderer.paint.setStrokeWidth(paramRectF.width());
    paramCanvas.drawLine(f1, f2, f1, f3, this.mRenderer.paint);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.StatisticChartOld.StatisticBarItem
 * JD-Core Version:    0.6.2
 */