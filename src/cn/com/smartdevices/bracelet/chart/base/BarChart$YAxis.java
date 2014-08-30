package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

public class BarChart$YAxis extends BarChart.Axis
{
  public BarChart$YAxis()
  {
  }

  public BarChart$YAxis(Context paramContext)
  {
    super(paramContext);
  }

  protected void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat)
  {
    paramCanvas.drawRect(paramRectF, this.mRenderer.paint);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.base.BarChart.YAxis
 * JD-Core Version:    0.6.2
 */