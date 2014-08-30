package cn.com.smartdevices.bracelet.chart.deprecated;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import cn.com.smartdevices.bracelet.chart.base.BarChart.YAxis;

final class a extends BarChart.YAxis
{
  private static float a = 24.0F;
  private static float b = 1440.0F;
  private int c = 0;
  private float d;
  private Paint e = new TextPaint(1);
  private Paint f;
  private Paint g;
  private RectF h;

  public a(DynamicDetailChartOld paramDynamicDetailChartOld)
  {
    this.value = 24;
    this.offset = this.c;
    this.e.setColor(1308622847);
    this.e.setTextSize(9.0F * this.mDensity);
    this.f = new Paint(1);
    this.f.setColor(452984831);
    this.g = new Paint(1);
    this.g.setColor(872415231);
    this.g.setStrokeWidth(1.0F);
    this.g.setStyle(Paint.Style.STROKE);
  }

  private float d()
  {
    return this.d * this.value;
  }

  private float e()
  {
    int j = -this.offset % this.value;
    if (f())
      j = -this.offset % this.value + this.value;
    return j * this.d + this.mScroll % this.d;
  }

  private boolean f()
  {
    return (this.mScroll - this.c * this.d < 0.0F) && ((this.mScroll - this.c * this.d) % d() < 0.0F);
  }

  private int g()
  {
    return this.offset / this.value;
  }

  private float h()
  {
    float f1 = -g() * d();
    if (f())
      f1 = -g() * d() + this.d * this.c;
    return f1;
  }

  public final void a()
  {
    this.mScroll = ((this.c - this.offset) * this.d);
    DynamicDetailChartOld.a(this.i, this.mScroll);
  }

  public final float b()
  {
    return this.mScroll - this.c * this.d;
  }

  public final float c()
  {
    return this.c * this.d;
  }

  protected final void doScroll(float paramFloat)
  {
    this.offset = (-(int)(this.mScroll / this.d) + this.c);
  }

  protected final void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat)
  {
    this.h.bottom = paramRectF.bottom;
    RectF localRectF1 = this.h;
    localRectF1.bottom -= DynamicDetailChartOld.a(this.i);
    RectF localRectF2 = this.h;
    localRectF2.bottom += b();
    paramCanvas.drawRoundRect(this.h, this.h.width() / 2.0F, this.h.width() / 2.0F, this.f);
    paramCanvas.drawRoundRect(this.h, this.h.width() / 2.0F, this.h.width() / 2.0F, this.g);
    Rect localRect = new Rect();
    int j = 0;
    if (j >= this.value - this.offset)
      return;
    int k = j + this.offset % this.value;
    if (k < 0)
      k += this.value;
    if (k > this.value)
      k %= this.value;
    if (k == this.value)
      k = 0;
    if (this.mScroll / this.d % 1.0F == 0.0F);
    for (float f1 = 0.0F; ; f1 = this.mScroll % this.d)
    {
      String str = String.valueOf(k);
      this.e.getTextBounds(str, 0, str.length(), localRect);
      paramCanvas.drawText(str, (this.stroke - localRect.width()) / 2.0F + paramRectF.left, f1 + (j * this.d + (this.d + localRect.height()) / 2.0F + paramRectF.top + this.mPaddingTop), this.e);
      j++;
      break;
    }
  }

  protected final void onRectChanged(RectF paramRectF)
  {
    this.d = ((paramRectF.height() - this.mPaddingTop - this.mPaddingBottom - DynamicDetailChartOld.a(this.i)) / this.value);
    a();
    this.h = new RectF(paramRectF);
    float f1 = this.h.width() / 2.0F;
    RectF localRectF = this.h;
    localRectF.top -= f1;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.a
 * JD-Core Version:    0.6.2
 */