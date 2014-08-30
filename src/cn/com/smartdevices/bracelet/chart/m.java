package cn.com.smartdevices.bracelet.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BarChart.XAxis;
import java.util.Iterator;
import java.util.List;

final class m extends BarChart.XAxis
{
  private Paint a = new TextPaint(1);
  private Paint b;

  public m(StatisticChart paramStatisticChart)
  {
    this.a.setColor(1711276032);
    this.a.setTextSize(9.0F * this.mDensity);
    this.b = new Paint();
    this.b.setColor(-855310);
  }

  private void a(Canvas paramCanvas, RectF paramRectF, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = 255;
    int j = 128;
    if (paramFloat2 > -1.0F)
    {
      i = (int)(255.0F * paramFloat1);
      j = (int)(128.0F * paramFloat1);
    }
    if (paramFloat3 > -1.0F)
    {
      i = (int)(255.0F * (1.0F - paramFloat1));
      j = (int)(128.0F * (1.0F - paramFloat1));
    }
    int k = 0x799ED | i << 24;
    int m = j << 24;
    Rect localRect = new Rect();
    while (true)
    {
      synchronized (StatisticChart.b(this.c))
      {
        Iterator localIterator = StatisticChart.b(this.c).iterator();
        if (!localIterator.hasNext())
          return;
        StatisticChart.DateItem localDateItem = (StatisticChart.DateItem)localIterator.next();
        if ((localDateItem.a > 1 + (this.offset + (-1 + StatisticChart.c(this.c)) / 2)) || (localDateItem.a < this.offset + (-1 + StatisticChart.c(this.c)) / 2 - StatisticChart.c(this.c)))
          continue;
        float f1 = paramRectF.right - this.mPaddingRight + (-1 + localDateItem.a) * StatisticChart.a(this.c) + this.mScroll - (-1 + StatisticChart.c(this.c)) / 2 * StatisticChart.a(this.c);
        float f2 = paramRectF.top;
        if (localDateItem.a == this.offset)
        {
          this.a.setColor(k);
          this.a.getTextBounds(localDateItem.b, 0, localDateItem.b.length(), localRect);
          float f3 = f1 + (StatisticChart.a(this.c) - localRect.width()) / 2.0F;
          float f4 = f2 + (this.stroke + localRect.height()) / 2.0F;
          paramCanvas.drawText(localDateItem.b, f3, f4, this.a);
        }
      }
      this.a.setColor(m);
    }
  }

  private void b(Canvas paramCanvas, RectF paramRectF, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = 255;
    int j = 128;
    if (paramFloat2 > -1.0F)
    {
      i = (int)(255.0F * paramFloat1);
      j = (int)(128.0F * paramFloat1);
    }
    if (paramFloat3 > -1.0F)
    {
      i = (int)(255.0F * (1.0F - paramFloat1));
      j = (int)(128.0F * (1.0F - paramFloat1));
    }
    int k = 0x799ED | i << 24;
    int m = j << 24;
    Rect localRect = new Rect();
    while (true)
    {
      synchronized (StatisticChart.b(this.c))
      {
        Iterator localIterator = StatisticChart.b(this.c).iterator();
        if (!localIterator.hasNext())
          return;
        StatisticChart.DateItem localDateItem = (StatisticChart.DateItem)localIterator.next();
        if ((localDateItem.a > 1 + (this.offset + (-1 + StatisticChart.c(this.c)) / 2)) || (localDateItem.a < this.offset + (-1 + StatisticChart.c(this.c)) / 2 - StatisticChart.c(this.c)))
          continue;
        float f1 = paramRectF.right - this.mPaddingRight + (-1 + localDateItem.a) * StatisticChart.a(this.c) + this.mScroll - (-1 + StatisticChart.c(this.c)) / 2 * StatisticChart.a(this.c);
        float f2 = paramRectF.top;
        if (localDateItem.a == this.offset)
        {
          this.a.setColor(k);
          this.a.getTextBounds(localDateItem.b, 0, localDateItem.b.length(), localRect);
          float f3 = f1 + (StatisticChart.a(this.c) - localRect.width()) / 2.0F;
          float f4 = f2 + (this.stroke + localRect.height()) / 2.0F;
          paramCanvas.drawText(localDateItem.b, f3, f4, this.a);
        }
      }
      this.a.setColor(m);
    }
  }

  public final void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    b(paramCanvas, this.mRect, paramFloat1, paramFloat2, paramFloat3);
  }

  protected final void doScroll(float paramFloat)
  {
    this.offset = (-Math.round(this.mScroll / StatisticChart.a(this.c)));
    Debug.i("Chart.StatisticChart", "DateLine Offset : " + this.offset);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.m
 * JD-Core Version:    0.6.2
 */