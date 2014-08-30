package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextPaint;
import cn.com.smartdevices.bracelet.chart.base.BarChart.XAxis;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;

final class a extends BarChart.XAxis
{
  private int a = 0;
  private float b;
  private Paint c = new TextPaint(1);
  private Paint d;
  private Bitmap e;
  private Bitmap f;

  public a(DynamicDetailChart paramDynamicDetailChart, Context paramContext)
  {
    super(paramContext);
    this.value = 24;
    this.offset = this.a;
    this.c.setColor(1711276032);
    this.c.setTextSize(9.0F * this.mDensity);
    this.d = new Paint();
    this.d.setColor(-855310);
  }

  private void a(Canvas paramCanvas, RectF paramRectF)
  {
    if (DynamicDetailChart.d(this.g) == DynamicDetailChart.e(this.g))
      return;
    Rect localRect = new Rect();
    float f1 = paramRectF.left + 8.0F * this.mDensity;
    float f2 = paramRectF.centerY();
    ChartUtil.drawBitmapCenter(paramCanvas, f1, f2, this.mDensityScale, false, true, this.e, null);
    String str1 = ChartData.formatTime(DynamicDetailChart.d(this.g));
    this.c.getTextBounds(str1, 0, str1.length(), localRect);
    localRect.offset((int)(f1 + 15.0F * this.mDensity), (int)(f2 + localRect.height() / 2 - 0.66D * this.mDensity));
    ChartUtil.drawTextCenter(paramCanvas, new RectF(localRect), str1, this.c);
    float f3 = paramRectF.right - 8.0F * this.mDensity - this.f.getWidth() * this.mDensityScale;
    float f4 = paramRectF.centerY();
    ChartUtil.drawBitmapCenter(paramCanvas, f3, f4, this.mDensityScale, false, true, this.f, null);
    String str2 = ChartData.formatTime(DynamicDetailChart.e(this.g));
    this.c.getTextBounds(str2, 0, str2.length(), localRect);
    localRect.offset((int)(f3 - localRect.width() - 6.0F * this.mDensity), (int)(f4 + localRect.height() / 2 - 0.66D * this.mDensity));
    ChartUtil.drawTextCenter(paramCanvas, new RectF(localRect), str2, this.c);
  }

  private void b(Canvas paramCanvas, RectF paramRectF)
  {
    if (DynamicDetailChart.a(this.g) == DynamicDetailChart.b(this.g))
      return;
    Rect localRect = new Rect();
    if (1 + (DynamicDetailChart.b(this.g) - DynamicDetailChart.a(this.g)) >= 20);
    for (int i = 1; ; i = 0)
    {
      int j = 0;
      label54: int k;
      float f1;
      if (j < 1 + (DynamicDetailChart.b(this.g) - DynamicDetailChart.a(this.g)))
      {
        k = j + DynamicDetailChart.a(this.g);
        if (k < 0)
          k += 24;
        if (k % 2 == 0)
        {
          if (this.mScroll / this.b % 1.0F != 0.0F)
            break label220;
          f1 = 0.0F;
          label122: if (i != 0)
            break label234;
        }
      }
      label220: label234: for (String str = ChartData.formatTime(k * 60); ; str = String.valueOf(k))
      {
        this.c.getTextBounds(str, 0, str.length(), localRect);
        paramCanvas.drawText(str, f1 + (j * this.b + (this.b - localRect.width()) / 2.0F + paramRectF.left + this.mPaddingLeft), (this.stroke + localRect.height()) / 2.0F + paramRectF.top, this.c);
        j++;
        break label54;
        break;
        f1 = this.mScroll % this.b;
        break label122;
      }
    }
  }

  private void d()
  {
    if (this.e == null)
      this.e = ((BitmapDrawable)this.mContext.getResources().getDrawable(2130837602)).getBitmap();
    if (this.f == null)
      this.f = ((BitmapDrawable)this.mContext.getResources().getDrawable(2130837601)).getBitmap();
  }

  private float e()
  {
    return this.b * this.value;
  }

  private float f()
  {
    int i = -this.offset % this.value;
    if (g())
      i = -this.offset % this.value + this.value;
    return i * this.b + this.mScroll % this.b;
  }

  private boolean g()
  {
    return (this.mScroll - this.a * this.b < 0.0F) && ((this.mScroll - this.a * this.b) % e() < 0.0F);
  }

  private int h()
  {
    return this.offset / this.value;
  }

  private float i()
  {
    float f1 = -h() * e();
    if (g())
      f1 = -h() * e() + this.b * this.a;
    return f1;
  }

  public final void a()
  {
    this.mScroll = ((this.a - this.offset) * this.b);
    DynamicDetailChart.a(this.g, this.mScroll);
  }

  public final float b()
  {
    return this.mScroll - this.a * this.b;
  }

  public final float c()
  {
    return this.a * this.b;
  }

  protected final void doScroll(float paramFloat)
  {
    this.offset = (-(int)(this.mScroll / this.b) + this.a);
  }

  protected final void draw(Canvas paramCanvas, RectF paramRectF, float paramFloat)
  {
    paramCanvas.drawRect(paramRectF, this.d);
    if (DynamicDetailChart.c(this.g) == 16)
    {
      if (this.e == null)
        this.e = ((BitmapDrawable)this.mContext.getResources().getDrawable(2130837602)).getBitmap();
      if (this.f == null)
        this.f = ((BitmapDrawable)this.mContext.getResources().getDrawable(2130837601)).getBitmap();
      if (DynamicDetailChart.d(this.g) != DynamicDetailChart.e(this.g))
      {
        localRect = new Rect();
        f1 = paramRectF.left + 8.0F * this.mDensity;
        f2 = paramRectF.centerY();
        ChartUtil.drawBitmapCenter(paramCanvas, f1, f2, this.mDensityScale, false, true, this.e, null);
        str1 = ChartData.formatTime(DynamicDetailChart.d(this.g));
        this.c.getTextBounds(str1, 0, str1.length(), localRect);
        localRect.offset((int)(f1 + 15.0F * this.mDensity), (int)(f2 + localRect.height() / 2 - 0.66D * this.mDensity));
        ChartUtil.drawTextCenter(paramCanvas, new RectF(localRect), str1, this.c);
        f3 = paramRectF.right - 8.0F * this.mDensity - this.f.getWidth() * this.mDensityScale;
        f4 = paramRectF.centerY();
        ChartUtil.drawBitmapCenter(paramCanvas, f3, f4, this.mDensityScale, false, true, this.f, null);
        str2 = ChartData.formatTime(DynamicDetailChart.e(this.g));
        this.c.getTextBounds(str2, 0, str2.length(), localRect);
        localRect.offset((int)(f3 - localRect.width() - 6.0F * this.mDensity), (int)(f4 + localRect.height() / 2 - 0.66D * this.mDensity));
        ChartUtil.drawTextCenter(paramCanvas, new RectF(localRect), str2, this.c);
      }
    }
    while (DynamicDetailChart.c(this.g) != 1)
    {
      Rect localRect;
      float f1;
      float f2;
      String str1;
      float f3;
      float f4;
      String str2;
      return;
    }
    b(paramCanvas, paramRectF);
  }

  public final void notifyChanged()
  {
    if ((this.mRect != null) && (DynamicDetailChart.a(this.g) != DynamicDetailChart.b(this.g)))
      this.b = ((this.mRect.width() - this.mPaddingLeft - this.mPaddingRight) / (1 + (DynamicDetailChart.b(this.g) - DynamicDetailChart.a(this.g))));
  }

  protected final void onRectChanged(RectF paramRectF)
  {
    a();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.a
 * JD-Core Version:    0.6.2
 */