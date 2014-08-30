package cn.com.smartdevices.bracelet.chart;

import android.graphics.Canvas;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import cn.com.smartdevices.bracelet.chart.base.Renderer;

public class DynamicShareChart$DynamicShareBarItem extends BarChart.BarItem
{
  protected void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat)
  {
    if (!this.needDraw)
      return;
    float f = paramRectF.width() / 2.0F;
    RectF localRectF = new RectF(paramRectF);
    localRectF.bottom = (f + localRectF.bottom);
    paramCanvas.save();
    paramCanvas.clipRect(paramRectF);
    paramCanvas.drawRoundRect(localRectF, f, f, this.mRenderer.paint);
    paramCanvas.restore();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.DynamicShareChart.DynamicShareBarItem
 * JD-Core Version:    0.6.2
 */