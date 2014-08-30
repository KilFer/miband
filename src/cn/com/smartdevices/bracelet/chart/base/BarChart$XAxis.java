package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

public class BarChart$XAxis extends BarChart.Axis
{
  public BarChart$XAxis()
  {
  }

  public BarChart$XAxis(Context paramContext)
  {
    super(paramContext);
  }

  protected void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat)
  {
    paramCanvas.drawRect(paramRectF, this.mRenderer.paint);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.base.BarChart.XAxis
 * JD-Core Version:    0.6.2
 */