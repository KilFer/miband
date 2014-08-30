package cn.com.smartdevices.bracelet.chart.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;

public class ChartData$TextMarginSpan extends ReplacementSpan
{
  private float a;
  private float b;
  private float c;
  private float d;

  public ChartData$TextMarginSpan(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }

  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCanvas.drawText(paramCharSequence.subSequence(paramInt1, paramInt2).toString(), paramFloat + this.a - this.c, paramInt4 + this.b - this.d, paramPaint);
  }

  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return (int)paramPaint.measureText(paramCharSequence.subSequence(paramInt1, paramInt2).toString());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.util.ChartData.TextMarginSpan
 * JD-Core Version:    0.6.2
 */