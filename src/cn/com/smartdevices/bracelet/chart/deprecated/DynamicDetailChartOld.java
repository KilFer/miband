package cn.com.smartdevices.bracelet.chart.deprecated;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import cn.com.smartdevices.bracelet.chart.base.BarChart.Axis;
import cn.com.smartdevices.bracelet.chart.typeface.MIUITextStyle;
import cn.com.smartdevices.bracelet.chart.typeface.TypefaceManager;
import java.util.List;

public class DynamicDetailChartOld extends BarChart
{
  private static final String a = "Chart.DynamicDetailChart";
  private static final int b = 1500;
  private c c;
  private d d;
  private float e = 1.0F;
  private float f = 1.0F;
  private float g;
  private int h;
  private String i;
  private String j;
  private int k;
  private String l;
  private String m;
  private String n;
  private String o;
  private Paint p;
  private Paint q;
  private Paint r;

  public DynamicDetailChartOld(Context paramContext)
  {
    super(paramContext);
    this.mYAxis = new a(this);
    this.mYAxis.stroke = ((int)(17.0F * this.mDensity));
    this.mYAxis.setPadding(0.0F, 0.0F, 0.0F, (int)(15.0F * this.mDensity));
    this.c = new c(this, (byte)0);
    this.c.setPadding(0.0F, 0.0F, (int)(60.0F * this.mDensity), 0.0F);
    this.c.setMaxItemValue(3);
    this.c.setItemPadding(1.0F);
    this.d = new d(this, (byte)0);
    this.d.setPadding(0.0F, 0.0F, 0.0F, 0.0F);
    this.d.setMaxItemValue(1500);
    this.d.setItemPadding(1.0F);
    this.p = new Paint();
    this.p.setColor(1308622847);
    this.p.setStrokeWidth(1.0F);
    this.q = new Paint(1);
    this.q.setColor(-2130706433);
    this.r = new Paint(1);
    this.r.setColor(-1);
    Typeface localTypeface = TypefaceManager.getInstance().getTypeface(this.mContext, MIUITextStyle.NORMAL);
    if (localTypeface != null)
      this.r.setTypeface(localTypeface);
    this.r.setTextSize(13.0F * this.mDensity);
    this.g = (69.0F * this.mDensity);
  }

  private void a(Canvas paramCanvas, float paramFloat)
  {
    a locala = (a)this.mYAxis;
    Rect localRect = new Rect();
    this.q.setTextSize(11.0F * this.mDensity);
    if (this.i != null)
    {
      float f10 = this.mRect.left;
      float f11 = paramFloat * this.mRect.right;
      float f12 = this.h / 1440.0F * (this.mRect.height() - this.g - locala.getPaddingBottom()) + locala.b() + this.p.getStrokeWidth() / 2.0F;
      paramCanvas.drawLine(f10, f12, f11, f12, this.p);
      this.q.getTextBounds(this.i, 0, this.i.length(), localRect);
      float f13 = f10 + 55.0F * this.mDensity;
      float f14 = paramFloat * (f12 + localRect.height() + 8.0F * this.mDensity);
      paramCanvas.drawText(this.i, f13, f14, this.r);
      paramCanvas.drawText(this.j, f13 + localRect.width() + 5.0F * this.mDensity, f14, this.q);
    }
    if (this.l != null)
    {
      float f5 = this.mRect.left;
      float f6 = paramFloat * this.mRect.right;
      float f7 = this.k / 1440.0F * (this.mRect.height() - this.g - locala.getPaddingBottom()) + locala.b() + this.p.getStrokeWidth() / 2.0F;
      if ((int)f7 > 1)
        paramCanvas.drawLine(f5, f7, f6, f7, this.p);
      this.q.getTextBounds(this.l, 0, this.l.length(), localRect);
      float f8 = f5 + 55.0F * this.mDensity;
      float f9 = paramFloat * (f7 + localRect.height() + 8.0F * this.mDensity);
      paramCanvas.drawText(this.l, f8, f9, this.r);
      paramCanvas.drawText(this.m, f8 + localRect.width() + 5.0F * this.mDensity, f9, this.q);
    }
    if (this.n == null)
      this.n = "";
    RectF localRectF = this.mYAxis.getRect();
    this.q.getTextBounds(this.n, 0, this.n.length(), localRect);
    float f1 = localRectF.centerX() - localRect.width() / 2;
    float f2 = localRectF.bottom - this.g + localRect.height() + 10.0F * this.mDensity + locala.b();
    paramCanvas.drawText(this.n, f1, f2, this.q);
    this.q.setTextSize(18.0F * this.mDensity);
    if (this.o == null)
      this.o = "";
    int i1 = localRect.height();
    this.q.getTextBounds(this.o, 0, this.o.length(), localRect);
    float f3 = localRectF.centerX() - localRect.width() / 2;
    float f4 = localRectF.bottom - this.g + i1 + localRect.height() + 18.0F * this.mDensity + locala.b();
    paramCanvas.drawText(this.o, f3, f4, this.q);
  }

  public void addSleepData(List<DynamicDetailChartOld.DynamicDetailBarItem> paramList)
  {
    this.c.addItems(paramList);
  }

  public void addStepData(List<DynamicDetailChartOld.DynamicDetailBarItem> paramList)
  {
    this.d.addItems(paramList);
  }

  public void clearSleepData()
  {
    this.c.clearItems();
    this.h = 0;
    this.k = 0;
    this.i = null;
    this.l = null;
  }

  public void clearStepData()
  {
    this.d.clearItems();
    this.o = null;
  }

  protected void doScroll(float paramFloat)
  {
    Debug.w("Chart.DynamicDetailChart", "Scroll :" + paramFloat);
    if (this.mLoadCallback == null)
      return;
    a locala = (a)this.mYAxis;
    if (this.mScroll > 0.0F)
      this.mScroll = 0.0F;
    if (this.mScroll < locala.c())
      this.mScroll = locala.c();
    Debug.w("Chart.DynamicDetailChart", "ScrollTo : " + this.mScroll);
    locala.scrollTo(this.mScroll);
  }

  public void draw(Canvas paramCanvas, float paramFloat)
  {
    this.c.draw(paramCanvas, paramFloat);
    this.d.draw(paramCanvas, paramFloat);
    super.draw(paramCanvas, paramFloat);
    a locala = (a)this.mYAxis;
    Rect localRect = new Rect();
    this.q.setTextSize(11.0F * this.mDensity);
    if (this.i != null)
    {
      float f10 = this.mRect.left;
      float f11 = paramFloat * this.mRect.right;
      float f12 = this.h / 1440.0F * (this.mRect.height() - this.g - locala.getPaddingBottom()) + locala.b() + this.p.getStrokeWidth() / 2.0F;
      paramCanvas.drawLine(f10, f12, f11, f12, this.p);
      this.q.getTextBounds(this.i, 0, this.i.length(), localRect);
      float f13 = f10 + 55.0F * this.mDensity;
      float f14 = paramFloat * (f12 + localRect.height() + 8.0F * this.mDensity);
      paramCanvas.drawText(this.i, f13, f14, this.r);
      paramCanvas.drawText(this.j, f13 + localRect.width() + 5.0F * this.mDensity, f14, this.q);
    }
    if (this.l != null)
    {
      float f5 = this.mRect.left;
      float f6 = paramFloat * this.mRect.right;
      float f7 = this.k / 1440.0F * (this.mRect.height() - this.g - locala.getPaddingBottom()) + locala.b() + this.p.getStrokeWidth() / 2.0F;
      if ((int)f7 > 1)
        paramCanvas.drawLine(f5, f7, f6, f7, this.p);
      this.q.getTextBounds(this.l, 0, this.l.length(), localRect);
      float f8 = f5 + 55.0F * this.mDensity;
      float f9 = paramFloat * (f7 + localRect.height() + 8.0F * this.mDensity);
      paramCanvas.drawText(this.l, f8, f9, this.r);
      paramCanvas.drawText(this.m, f8 + localRect.width() + 5.0F * this.mDensity, f9, this.q);
    }
    if (this.n == null)
      this.n = "";
    RectF localRectF = this.mYAxis.getRect();
    this.q.getTextBounds(this.n, 0, this.n.length(), localRect);
    float f1 = localRectF.centerX() - localRect.width() / 2;
    float f2 = localRectF.bottom - this.g + localRect.height() + 10.0F * this.mDensity + locala.b();
    paramCanvas.drawText(this.n, f1, f2, this.q);
    this.q.setTextSize(18.0F * this.mDensity);
    if (this.o == null)
      this.o = "";
    int i1 = localRect.height();
    this.q.getTextBounds(this.o, 0, this.o.length(), localRect);
    float f3 = localRectF.centerX() - localRect.width() / 2;
    float f4 = localRectF.bottom - this.g + i1 + localRect.height() + 18.0F * this.mDensity + locala.b();
    paramCanvas.drawText(this.o, f3, f4, this.q);
  }

  public void fillSleepData(List<DynamicDetailChartOld.DynamicDetailBarItem> paramList)
  {
    this.c.fillItems(paramList);
  }

  public void fillStepData(List<DynamicDetailChartOld.DynamicDetailBarItem> paramList)
  {
    this.d.fillItems(paramList);
  }

  public float getEdgeLength()
  {
    return ((a)this.mYAxis).c();
  }

  public void notifyChanged()
  {
    this.c.notifyChanged();
    this.d.notifyChanged();
  }

  protected void onRectChanged(RectF paramRectF)
  {
    super.onRectChanged(paramRectF);
    RectF localRectF1 = new RectF(this.mYAxis.getRect());
    localRectF1.offset((paramRectF.width() - this.mYAxis.stroke) / (this.e + this.f) * this.f, 0.0F);
    this.mYAxis.setRect(localRectF1);
    RectF localRectF2 = new RectF(paramRectF);
    localRectF2.left = (localRectF1.right + 1.0F * this.mDensity);
    this.d.setRect(localRectF2);
    RectF localRectF3 = new RectF(paramRectF);
    localRectF3.left = (localRectF1.right + 1.0F * this.mDensity);
    this.c.setRect(localRectF3);
  }

  public void setOffset(int paramInt)
  {
    a locala = (a)this.mYAxis;
    a.a(locala, paramInt);
    locala.offset = 0;
    locala.a();
  }

  public void setSleepRiseTime(int paramInt, String paramString1, String paramString2)
  {
    this.k = paramInt;
    this.l = paramString1;
    this.m = paramString2;
  }

  public void setSleepStartTime(int paramInt, String paramString1, String paramString2)
  {
    this.h = paramInt;
    this.i = paramString1;
    this.j = paramString2;
  }

  public void setStepTime(String paramString1, String paramString2)
  {
    this.n = paramString1;
    this.o = paramString2;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.DynamicDetailChartOld
 * JD-Core Version:    0.6.2
 */