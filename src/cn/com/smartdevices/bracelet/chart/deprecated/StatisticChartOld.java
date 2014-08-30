package cn.com.smartdevices.bracelet.chart.deprecated;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import cn.com.smartdevices.bracelet.chart.base.BarChart.Axis;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;
import java.util.ArrayList;
import java.util.List;

public class StatisticChartOld extends BarChart
{
  public static final int BAR_ITEM_SIZE = 8;
  private static final String a = "Chart.StatisticChart";
  private static float b;
  private o c;
  private o d;
  private float e = 3.0F;
  private float f = 2.0F;
  private Paint g;
  private int h;
  private int i;
  private Paint j;
  private Paint k;
  private Bitmap l;
  private Bitmap m;
  private Paint n;
  private List<StatisticChartOld.DateItem> o;
  private View p;

  public StatisticChartOld(Context paramContext)
  {
    super(paramContext);
    this.mPaddingRight = ((int)(22.0F * this.mDensity));
    this.mXAxis = new n(this);
    this.mXAxis.stroke = ((int)(14.0F * this.mDensity));
    this.mXAxis.setPadding(0.0F, 0.0F, this.mPaddingRight, 0.0F);
    this.h = 10000;
    this.i = 100;
    this.c = new o(this, (byte)0);
    this.c.setMaxItemValue((int)(1.6D * this.h));
    this.c.setItemPadding(1.0F);
    this.d = new o(this, (byte)0);
    this.d.setMaxItemValue((int)(1.2D * this.i));
    this.d.setItemPadding(1.0F);
    this.g = new Paint();
    this.g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    this.j = new Paint();
    this.j.setColor(-2130710528);
    this.j.setStrokeWidth(1.0F);
    this.k = new Paint();
    this.k.setColor(-2130706433);
    this.k.setStrokeWidth(1.0F);
    this.n = new Paint(1);
    this.n.setDither(true);
    this.l = ((BitmapDrawable)paramContext.getResources().getDrawable(2130837575)).getBitmap();
    this.m = ((BitmapDrawable)paramContext.getResources().getDrawable(2130837574)).getBitmap();
    this.o = new ArrayList();
  }

  private void a(Canvas paramCanvas)
  {
    this.g.setColor(-2134442240);
    RectF localRectF1 = new RectF(this.c.getRect());
    localRectF1.right -= b;
    paramCanvas.drawRect(localRectF1, this.g);
    this.g.setColor(-2143209010);
    RectF localRectF2 = new RectF(this.d.getRect());
    localRectF2.right -= b;
    paramCanvas.drawRect(localRectF2, this.g);
  }

  private void b(Canvas paramCanvas)
  {
    float f1 = this.mRect.right - 19.0F * this.mDensity;
    RectF localRectF1 = this.c.getRect();
    float f2 = localRectF1.bottom - this.h / this.c.getMaxItemValue() * localRectF1.height();
    paramCanvas.drawLine(0.0F, f2, f1, f2, this.j);
    ChartUtil.drawBitmapCenter(paramCanvas, (int)f1, (int)f2, this.mDensityScale, false, true, this.l, this.n);
    RectF localRectF2 = this.d.getRect();
    float f3 = localRectF2.bottom - this.i / this.d.getMaxItemValue() * localRectF2.height();
    paramCanvas.drawLine(0.0F, f3, f1, f3, this.k);
    ChartUtil.drawBitmapCenter(paramCanvas, (int)f1, (int)f3, this.mDensityScale, false, true, this.m, this.n);
  }

  protected void doScroll(float paramFloat)
  {
    if (this.mLoadCallback == null)
      return;
    n localn = (n)this.mXAxis;
    int i1 = localn.offset;
    localn.scrollTo(this.mScroll);
    int i2 = localn.offset;
    int i3 = 0;
    int i6;
    if (paramFloat < 0.0F)
    {
      int i7 = i2 + 1;
      int i8 = i1;
      while (true)
      {
        if (i7 <= i1)
        {
          i6 = i8 - 1;
          Debug.i("Chart.StatisticChart", "ScrollTo : " + this.mScroll);
          if (i3 != 0)
          {
            this.mScroll = (-i6 * b);
            localn.scrollTo(this.mScroll);
            ((StatisticChartViewOld.StatisticChartLoadCallback)this.mLoadCallback).onOverScrolled();
          }
          this.mLoadCallback.loadData(localn.offset);
          return;
        }
        if (!this.mLoadCallback.hasData(i7))
        {
          Debug.w("Chart.StatisticChart", "No Item Data : " + i7);
          i3 = 1;
          i8 = i7;
        }
        i7--;
      }
    }
    int i4 = i2 - 1;
    int i5 = i1;
    while (true)
    {
      if (i4 >= i1)
      {
        i6 = i5 + 1;
        break;
      }
      if (!this.mLoadCallback.hasData(i4))
      {
        Debug.w("Chart.StatisticChart", "No Item Data : " + i4);
        i3 = 1;
        i5 = i4;
      }
      i4++;
    }
  }

  public void draw(Canvas paramCanvas, float paramFloat)
  {
    this.d.draw(paramCanvas, paramFloat);
    this.c.draw(paramCanvas, paramFloat);
    this.g.setColor(-2134442240);
    RectF localRectF1 = new RectF(this.c.getRect());
    localRectF1.right -= b;
    paramCanvas.drawRect(localRectF1, this.g);
    this.g.setColor(-2143209010);
    RectF localRectF2 = new RectF(this.d.getRect());
    localRectF2.right -= b;
    paramCanvas.drawRect(localRectF2, this.g);
    float f1 = this.mRect.right - 19.0F * this.mDensity;
    RectF localRectF3 = this.c.getRect();
    float f2 = localRectF3.bottom - this.h / this.c.getMaxItemValue() * localRectF3.height();
    paramCanvas.drawLine(0.0F, f2, f1, f2, this.j);
    ChartUtil.drawBitmapCenter(paramCanvas, (int)f1, (int)f2, this.mDensityScale, false, true, this.l, this.n);
    RectF localRectF4 = this.d.getRect();
    float f3 = localRectF4.bottom - this.i / this.d.getMaxItemValue() * localRectF4.height();
    paramCanvas.drawLine(0.0F, f3, f1, f3, this.k);
    ChartUtil.drawBitmapCenter(paramCanvas, (int)f1, (int)f3, this.mDensityScale, false, true, this.m, this.n);
    super.draw(paramCanvas, paramFloat);
  }

  public void fillDates(List<StatisticChartOld.DateItem> paramList)
  {
    synchronized (this.o)
    {
      this.o.clear();
      this.o.addAll(paramList);
      return;
    }
  }

  public void fillSleepData(List<StatisticChartOld.StatisticBarItem> paramList)
  {
    this.d.fillItems(paramList);
  }

  public void fillStepData(List<StatisticChartOld.StatisticBarItem> paramList)
  {
    this.c.fillItems(paramList);
  }

  public int itemOffset()
  {
    return ((n)this.mXAxis).offset;
  }

  public int justified()
  {
    int i1 = (int)(this.mScroll % b);
    if (Math.abs(i1) > b / 2.0F)
    {
      if (i1 > 0)
        i1 = (int)-(b - i1);
    }
    else
      return i1;
    return (int)(b + i1);
  }

  public void notifyChanged()
  {
    this.c.notifyChanged();
    this.d.notifyChanged();
  }

  public int offsetScroll(float paramFloat)
  {
    return -(int)((int)((this.mRect.right - this.mPaddingRight - paramFloat) / b) * b);
  }

  public void onRectChanged(RectF paramRectF)
  {
    super.onRectChanged(paramRectF);
    b = 45.0F * this.mDensity;
    RectF localRectF1 = new RectF(paramRectF);
    localRectF1.top += 3.0F * this.mDensity;
    paramRectF.right -= this.mPaddingRight;
    paramRectF.bottom *= this.e / (this.e + this.f);
    this.c.setRect(localRectF1);
    RectF localRectF2 = new RectF(paramRectF);
    localRectF2.top = (localRectF1.bottom + 3.0F * this.mDensity);
    paramRectF.right -= this.mPaddingRight;
    this.d.setRect(localRectF2);
  }

  public void setContainerView(View paramView)
  {
  }

  public void setStepGoal(int paramInt)
  {
    this.h = paramInt;
    this.c.setMaxItemValue((int)(1.6D * this.h));
    notifyChanged();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.StatisticChartOld
 * JD-Core Version:    0.6.2
 */