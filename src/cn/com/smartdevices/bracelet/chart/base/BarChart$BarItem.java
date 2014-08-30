package cn.com.smartdevices.bracelet.chart.base;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class BarChart$BarItem extends BaseChart<Chart.Item>
{
  public int index;
  public boolean needDraw;
  public int scope;
  public int value;

  protected void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat)
  {
    if (!this.needDraw)
      return;
    float f1 = paramRectF.left + paramRectF.width() / 2.0F;
    float f2 = paramRectF.bottom;
    float f3 = paramRectF.left + paramRectF.width() / 2.0F;
    float f4 = paramRectF.bottom - paramFloat * paramRectF.height();
    this.mRenderer.paint.setStrokeWidth(paramRectF.width());
    paramCanvas.drawLine(f1, f2, f3, f4, this.mRenderer.paint);
  }

  protected void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat, boolean paramBoolean)
  {
    if (!this.needDraw)
      return;
    if (paramBoolean)
    {
      float f1 = paramRectF.left + paramRectF.width() / 2.0F;
      float f2 = paramRectF.top;
      float f3 = paramRectF.left + paramRectF.width() / 2.0F;
      float f4 = paramRectF.top + paramFloat * paramRectF.height();
      this.mRenderer.paint.setStrokeWidth(paramRectF.width());
      paramCanvas.drawLine(f1, f2, f3, f4, this.mRenderer.paint);
      return;
    }
    draw(paramCanvas, paramRectF, paramFloat);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Value : " + this.value).append(" , ");
    localStringBuilder.append("Index : " + this.index).append(" , ");
    localStringBuilder.append("Scope : " + this.scope).append(" , ");
    localStringBuilder.append("NeedDrow : " + this.needDraw);
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem
 * JD-Core Version:    0.6.2
 */