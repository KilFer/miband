package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import cn.com.smartdevices.bracelet.chart.base.Renderer;

public class DynamicDetailChartOld$DynamicDetailBarItem extends BarChart.BarItem
{
  boolean a;

  protected void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat)
  {
    if (!this.needDraw);
    Paint localPaint;
    float f2;
    float f3;
    do
    {
      return;
      float f1 = paramRectF.height() / 2.0F;
      if (f1 > 30.0F * this.mDensity)
        f1 = 30.0F * this.mDensity;
      RectF localRectF = new RectF(paramRectF);
      localRectF.left -= f1;
      localRectF.right = (localRectF.left + paramFloat * localRectF.width());
      paramCanvas.save();
      paramCanvas.clipRect(paramRectF);
      paramCanvas.drawRoundRect(localRectF, f1, f1, this.mRenderer.paint);
      paramCanvas.restore();
      localPaint = new Paint(1);
      localPaint.setTextSize(8.5F * this.mDensity);
      localPaint.setColor(-1);
      localPaint.setTypeface(Typeface.DEFAULT_BOLD);
      Rect localRect = new Rect();
      localPaint.getTextBounds(String.valueOf(this.value), 0, String.valueOf(this.value).length(), localRect);
      f2 = paramFloat * (paramRectF.right - localRect.width() - 10.0F * this.mDensity);
      f3 = paramRectF.top + 13.5F * this.mDensity;
    }
    while ((this.value < 500) || (!this.a));
    paramCanvas.save();
    paramCanvas.clipRect(paramRectF);
    paramCanvas.drawText(String.valueOf(this.value), f2, f3, localPaint);
    paramCanvas.restore();
  }

  protected void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat, boolean paramBoolean)
  {
    if (!this.needDraw)
      return;
    if (paramBoolean)
    {
      float f = paramRectF.height() / 2.0F;
      RectF localRectF = new RectF(paramRectF);
      localRectF.right = (f + localRectF.right);
      paramCanvas.save();
      paramCanvas.clipRect(paramRectF);
      paramCanvas.drawRoundRect(localRectF, f, f, this.mRenderer.paint);
      paramCanvas.restore();
      return;
    }
    draw(paramCanvas, paramRectF, paramFloat);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.DynamicDetailChartOld.DynamicDetailBarItem
 * JD-Core Version:    0.6.2
 */