package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BarChart.XAxis;
import java.util.Iterator;
import java.util.List;

final class n extends BarChart.XAxis
{
  private Paint a = new TextPaint(1);

  public n(StatisticChartOld paramStatisticChartOld)
  {
    this.a.setColor(-1);
    this.a.setTextSize(8.0F * this.mDensity);
  }

  protected final void doScroll(float paramFloat)
  {
    this.offset = (-Math.round(this.mScroll / StatisticChartOld.a()));
    Debug.i("Chart.StatisticChart", "DateLine Offset : " + this.offset);
  }

  protected final void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat)
  {
    paramCanvas.save();
    RectF localRectF = new RectF(paramRectF);
    paramRectF.right -= this.mPaddingRight;
    paramCanvas.clipRect(localRectF);
    Rect localRect = new Rect();
    while (true)
    {
      synchronized (StatisticChartOld.a(this.b))
      {
        Iterator localIterator = StatisticChartOld.a(this.b).iterator();
        if (!localIterator.hasNext())
        {
          paramCanvas.restore();
          return;
        }
        StatisticChartOld.DateItem localDateItem = (StatisticChartOld.DateItem)localIterator.next();
        if ((localDateItem.a > 1 + this.offset) || (localDateItem.a < -8 + this.offset))
          continue;
        float f1 = paramRectF.right - this.mPaddingRight + (-1 + localDateItem.a) * StatisticChartOld.a() + this.mScroll;
        float f2 = paramRectF.top;
        if (f1 <= this.mRect.right - this.mPaddingRight - 2.0F * StatisticChartOld.a())
        {
          this.a.setTextSize(8.0F * this.mDensity);
          this.a.getTextBounds(localDateItem.b, 0, localDateItem.b.length(), localRect);
          float f3 = f1 + (StatisticChartOld.a() - localRect.width()) / 2.0F;
          float f4 = f2 + (this.stroke + localRect.height()) / 2.0F;
          paramCanvas.drawText(localDateItem.b, f3, f4, this.a);
        }
      }
      this.a.setTextSize(10.0F * this.mDensity);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.n
 * JD-Core Version:    0.6.2
 */