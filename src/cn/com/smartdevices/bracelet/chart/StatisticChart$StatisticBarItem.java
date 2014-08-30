package cn.com.smartdevices.bracelet.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import cn.com.smartdevices.bracelet.chart.base.Renderer;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;

public class StatisticChart$StatisticBarItem extends BarChart.BarItem
{
  public int value1;

  public void draw(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    draw(paramCanvas, this.mRect, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
  }

  protected void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if ((!this.needDraw) && (paramRectF.height() == 0.0F))
      return;
    float f3;
    float f4;
    float f1;
    float f2;
    label39: label71: float f6;
    float f8;
    float f9;
    float f10;
    StatisticChart localStatisticChart;
    int k;
    int j;
    Paint localPaint;
    label218: float f11;
    float f12;
    int m;
    int n;
    if (paramFloat2 == -1.0F)
    {
      f3 = 0.0F;
      f4 = 0.0F;
      f1 = paramFloat3;
      f2 = paramFloat5;
      if (paramFloat3 != -1.0F)
        break label419;
      f1 = paramRectF.height();
      f2 = paramRectF.height() * (this.value1 / this.value);
      float f5 = f3 + paramFloat1 * (f1 - f3);
      f6 = f4 + paramFloat1 * (f2 - f4);
      float f7 = paramRectF.width();
      f8 = paramRectF.left + paramRectF.width() / 2.0F;
      f9 = paramRectF.bottom;
      f10 = paramRectF.bottom - f5;
      this.mRenderer.paint.setStrokeWidth(f7);
      localStatisticChart = (StatisticChart)getParent();
      if (StatisticChart.f(localStatisticChart) != 16)
        break label446;
      k = StatisticChart.g(localStatisticChart);
      j = StatisticChart.h(localStatisticChart);
      int i5 = this.value1;
      localPaint = null;
      if (i5 >= 0)
      {
        int i6 = this.value;
        localPaint = null;
        if (i6 > 0)
        {
          localPaint = new Paint();
          localPaint.setStrokeWidth(f7);
        }
      }
      f11 = StatisticChart.k(localStatisticChart);
      f12 = StatisticChart.l(localStatisticChart);
      if ((paramRectF.right >= f11) && (paramRectF.left <= f12))
        break label488;
      m = StatisticChart.m(localStatisticChart);
      n = StatisticChart.m(localStatisticChart);
      if (paramFloat2 <= -1.0F)
        break label656;
      m = StatisticChart.n(localStatisticChart);
    }
    label656: for (int i1 = k; ; i1 = j)
    {
      int i2;
      if (paramFloat3 > -1.0F)
        i2 = StatisticChart.n(localStatisticChart);
      while (true)
      {
        int i3 = ChartUtil.colorToColor(i1, k, paramFloat1);
        this.mRenderer.paint.setColor(i3);
        if (localPaint != null)
          localPaint.setColor(ChartUtil.colorToColor(m, i2, paramFloat1));
        paramCanvas.drawLine(f8, f9, f8, f10, this.mRenderer.paint);
        if (localPaint == null)
          break;
        paramCanvas.drawLine(f8, f9, f8, paramRectF.bottom - f6, localPaint);
        return;
        f1 = paramRectF.height();
        f2 = paramRectF.height() * (this.value1 / this.value);
        f3 = paramFloat2;
        f4 = paramFloat4;
        break label39;
        label419: f3 = paramRectF.height();
        f4 = paramRectF.height() * (this.value1 / this.value);
        break label71;
        label446: int i = StatisticChart.f(localStatisticChart);
        j = 0;
        k = 0;
        localPaint = null;
        if (i != 1)
          break label218;
        k = StatisticChart.i(localStatisticChart);
        j = StatisticChart.j(localStatisticChart);
        localPaint = null;
        break label218;
        label488: float f13;
        label507: float f14;
        int i4;
        if (paramRectF.left < f11)
        {
          f13 = f11 - paramRectF.left;
          f14 = paramRectF.width() / 2.0F;
          if (f13 < f14)
            break label586;
          i4 = StatisticChart.m(localStatisticChart);
        }
        while (true)
        {
          this.mRenderer.paint.setColor(j);
          if (localPaint == null)
            break;
          localPaint.setColor(i4);
          break;
          boolean bool = paramRectF.right < f12;
          f13 = 0.0F;
          if (!bool)
            break label507;
          f13 = paramRectF.right - f12;
          break label507;
          label586: if (f13 == 0.0F)
          {
            i4 = StatisticChart.n(localStatisticChart);
            j = k;
          }
          else
          {
            float f15 = f13 / f14;
            j = ChartUtil.colorToColor(k, j, f15);
            i4 = ChartUtil.colorToColor(StatisticChart.n(localStatisticChart), StatisticChart.m(localStatisticChart), f15);
          }
        }
        i2 = n;
        k = j;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.StatisticChart.StatisticBarItem
 * JD-Core Version:    0.6.2
 */