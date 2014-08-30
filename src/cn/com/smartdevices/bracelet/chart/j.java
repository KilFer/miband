package cn.com.smartdevices.bracelet.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import cn.com.smartdevices.bracelet.chart.base.BarChart.XAxis;

final class j extends BarChart.XAxis
{
  private static int b = 18;
  private static int c = 1;
  float a;
  private Paint d = new TextPaint();

  public j(DynamicShareChart paramDynamicShareChart)
  {
    this.value = 18;
    this.offset = 1;
    this.d.setColor(-1);
    this.d.setTextSize(6.5F * this.mDensity);
    this.d.setAntiAlias(true);
  }

  protected final void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat)
  {
    Rect localRect = new Rect();
    for (int i = 0; ; i++)
    {
      if (i >= paramFloat * this.value)
        return;
      int j = i + this.offset % this.value;
      if (j % 2 == 0)
      {
        String str = String.valueOf(j);
        this.d.getTextBounds(str, 0, str.length(), localRect);
        paramCanvas.drawText(str, i * this.a + (this.a - localRect.width()) / 2.0F + paramRectF.left, (this.stroke + localRect.height()) / 2.0F + paramRectF.top, this.d);
      }
    }
  }

  protected final void onRectChanged(RectF paramRectF)
  {
    this.a = (paramRectF.width() / this.value);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.j
 * JD-Core Version:    0.6.2
 */