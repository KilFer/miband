package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import cn.com.smartdevices.bracelet.chart.base.BarChart.Axis;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;
import java.util.ArrayList;
import java.util.List;

public class StatisticChart extends BarChart
{
  private static final String a = "Chart.StatisticChart";
  private static final int b = 8000;
  private static final int c = 480;
  private static final float d = 2.5F;
  private static final float e = 1.5F;
  private int f;
  private int g;
  private float h;
  private int i;
  private float j;
  private float k;
  private o l;
  private n m;
  private List<StatisticChart.DateItem> n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private Paint v;

  public StatisticChart(Context paramContext)
  {
    super(paramContext);
    this.mPaddingLeft = (1.83F * this.mDensity);
    this.mPaddingRight = (1.83F * this.mDensity);
    this.mXAxis = new m(this);
    this.mXAxis.stroke = ((int)(28.0F * this.mDensity));
    this.mXAxis.setPadding(this.mPaddingLeft, 0.0F, this.mPaddingRight, 0.0F);
    this.l = new o(this, (byte)0);
    this.l.setItemPadding(0.83F * this.mDensity);
    this.l.setPadding(0.0F, (int)(30.0F * this.mDensity), 0.0F, 0.0F);
    setStepGoal(8000);
    this.m = new n(this, '\000');
    this.m.setItemPadding(0.83F * this.mDensity);
    this.m.setPadding(0.0F, (int)(100.0F * this.mDensity), 0.0F, 0.0F);
    setSleepGoal(480);
    this.n = new ArrayList();
    this.p = -6184010;
    this.q = -9407601;
    this.r = -7236695;
    this.s = -10131322;
    this.t = -4529939;
    this.u = -10569770;
    this.v = new Paint();
    this.v.setColor(872415231);
  }

  private void a()
  {
    if ((this.g > 0) && (this.mRect != null))
    {
      this.h = ((this.mRect.width() - this.mPaddingLeft - this.mPaddingRight) / this.g);
      Debug.i("Chart.StatisticChart", "Update Bar Item Width : " + this.h);
      this.j = ((int)(this.mRect.centerX() - this.h / 2.0F));
      this.k = ((int)(this.mRect.centerX() + this.h / 2.0F));
    }
  }

  private void a(Canvas paramCanvas)
  {
    RectF localRectF = this.l.getRect();
    int i1 = this.l.getMaxItemValue();
    float f1 = localRectF.bottom;
    if ((i1 > 0) && (o.a(this.l) > 0.0F))
      f1 -= ChartUtil.itemLevelSize(i1, this.f, o.a(this.l), o.b(this.l));
    float[] arrayOfFloat = new float['È'];
    float f2 = this.mRect.width() / 50.0F;
    float f3 = 2.0F * f2 / 3.0F;
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= 50)
      {
        paramCanvas.drawLines(arrayOfFloat, this.v);
        return;
      }
      float f4 = this.mRect.left + f2 * i2;
      float f5 = f4 + f3;
      arrayOfFloat[(i2 << 2)] = f4;
      arrayOfFloat[(1 + (i2 << 2))] = f1;
      arrayOfFloat[(2 + (i2 << 2))] = f5;
      arrayOfFloat[(3 + (i2 << 2))] = f1;
    }
  }

  private void b(Canvas paramCanvas)
  {
    RectF localRectF = new RectF(this.mRect);
    localRectF.left = (this.mRect.centerX() - this.h / 2.0F);
    localRectF.right = (this.mRect.centerX() + this.h / 2.0F);
    localRectF.bottom = this.mXAxis.getRect().top;
    new Paint();
    Path localPath = new Path();
    localPath.moveTo(localRectF.left + (localRectF.width() - 12.0F * this.mDensity) / 2.0F, localRectF.bottom);
    localPath.lineTo(localRectF.centerX(), localRectF.bottom - 6.0F * this.mDensity);
    localPath.lineTo(localRectF.right - (localRectF.width() - 12.0F * this.mDensity) / 2.0F, localRectF.bottom);
    localPath.close();
    Paint localPaint = new Paint(1);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setColor(-855310);
    paramCanvas.drawPath(localPath, localPaint);
  }

  public void clearData()
  {
    offsetTo(0);
  }

  protected void doScroll(float paramFloat)
  {
    Debug.i("Chart.StatisticChart", "Scroll : " + paramFloat);
    if (this.mLoadCallback == null)
      return;
    int i1 = this.mXAxis.offset;
    this.mXAxis.scrollTo(this.mScroll);
    int i2 = this.mXAxis.offset;
    int i3 = 0;
    int i6;
    if (paramFloat < 0.0F)
    {
      if ((i2 == i1) && (this.mScroll / this.h < i2))
        i2++;
      int i8 = i1;
      for (int i9 = i2; ; i9--)
      {
        if (i9 <= i1)
        {
          i6 = i8 - 1;
          if (i3 != 0)
          {
            this.mScroll = (-i6 * this.h);
            this.mXAxis.scrollTo(this.mScroll);
            int i7 = this.mXAxis.offset;
            ((StatisticChartView.StatisticChartLoadCallback)this.mLoadCallback).onOverScrolled();
            i2 = i7;
          }
          Debug.i("Chart.StatisticChart", "ScrollTo : " + this.mScroll);
          if (i2 == i1)
            break;
          this.mLoadCallback.loadData(i2);
          return;
        }
        if (!this.mLoadCallback.hasData(i9))
        {
          Debug.w("Chart.StatisticChart", "No Item Data : " + i9);
          i3 = 1;
          i8 = i9;
        }
      }
    }
    if ((i2 == i1) && (-(this.mScroll / this.h) < i2))
      i2--;
    int i4 = i1;
    for (int i5 = i2; ; i5++)
    {
      if (i5 >= i1)
      {
        i6 = i4 + 1;
        break;
      }
      if (!this.mLoadCallback.hasData(i5))
      {
        Debug.w("Chart.StatisticChart", "No Item Data : " + i5);
        i3 = 1;
        i4 = i5;
      }
    }
  }

  public void draw(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    ((m)this.mXAxis).a(paramCanvas, paramFloat1, paramFloat2, paramFloat3);
    if (this.o == 16)
      this.m.a(paramCanvas, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
    while (this.o != 1)
    {
      RectF localRectF2 = new RectF(this.mRect);
      localRectF2.left = (this.mRect.centerX() - this.h / 2.0F);
      localRectF2.right = (this.mRect.centerX() + this.h / 2.0F);
      localRectF2.bottom = this.mXAxis.getRect().top;
      new Paint();
      Path localPath = new Path();
      localPath.moveTo(localRectF2.left + (localRectF2.width() - 12.0F * this.mDensity) / 2.0F, localRectF2.bottom);
      localPath.lineTo(localRectF2.centerX(), localRectF2.bottom - 6.0F * this.mDensity);
      localPath.lineTo(localRectF2.right - (localRectF2.width() - 12.0F * this.mDensity) / 2.0F, localRectF2.bottom);
      localPath.close();
      Paint localPaint = new Paint(1);
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setColor(-855310);
      paramCanvas.drawPath(localPath, localPaint);
      return;
    }
    RectF localRectF1 = this.l.getRect();
    int i1 = this.l.getMaxItemValue();
    float f1 = localRectF1.bottom;
    if ((i1 > 0) && (o.a(this.l) > 0.0F))
      f1 -= ChartUtil.itemLevelSize(i1, this.f, o.a(this.l), o.b(this.l));
    float[] arrayOfFloat = new float['È'];
    float f2 = this.mRect.width() / 50.0F;
    float f3 = 2.0F * f2 / 3.0F;
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= 50)
      {
        paramCanvas.drawLines(arrayOfFloat, this.v);
        this.l.a(paramCanvas, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
        break;
      }
      float f4 = this.mRect.left + f2 * i2;
      float f5 = f4 + f3;
      arrayOfFloat[(i2 << 2)] = f4;
      arrayOfFloat[(1 + (i2 << 2))] = f1;
      arrayOfFloat[(2 + (i2 << 2))] = f5;
      arrayOfFloat[(3 + (i2 << 2))] = f1;
    }
  }

  public void fillDates(List<StatisticChart.DateItem> paramList)
  {
    synchronized (this.n)
    {
      this.n.clear();
      this.n.addAll(paramList);
      return;
    }
  }

  public void fillSleepData(List<StatisticChart.StatisticBarItem> paramList)
  {
    this.m.fillItems(paramList);
  }

  public void fillStepData(List<StatisticChart.StatisticBarItem> paramList)
  {
    this.l.fillItems(paramList);
  }

  public int getBarItemCount()
  {
    return this.g;
  }

  public float getBarItemWidth()
  {
    return this.h;
  }

  public int itemOffset()
  {
    return this.mXAxis.offset;
  }

  public int justified()
  {
    int i1 = (int)(this.mScroll % this.h);
    if (Math.abs(i1) > this.h / 2.0F)
    {
      if (i1 > 0)
        i1 = (int)-(this.h - i1);
    }
    else
      return i1;
    return (int)(this.h + i1);
  }

  public void notifyChanged()
  {
    this.l.notifyChanged();
    this.m.notifyChanged();
  }

  public int offsetScrolled(float paramFloat)
  {
    float f1 = this.mRect.centerX() - this.h / 2.0F;
    float f2 = this.mRect.centerX() + this.h / 2.0F;
    int i1;
    if (paramFloat < f1)
      i1 = -Math.round((1 + (int)((f1 - paramFloat) / this.h)) * this.h);
    boolean bool;
    do
    {
      return i1;
      bool = paramFloat < f2;
      i1 = 0;
    }
    while (!bool);
    return -Math.round((-1 + -(int)((paramFloat - f2) / this.h)) * this.h);
  }

  public void offsetTo(int paramInt)
  {
    this.mScroll = (paramInt * this.h);
    this.mXAxis.scrollTo(this.mScroll);
  }

  public void onRectChanged(RectF paramRectF)
  {
    super.onRectChanged(paramRectF);
    a();
    RectF localRectF1 = this.mXAxis.getRect();
    RectF localRectF2 = new RectF(paramRectF);
    paramRectF.left += this.mPaddingLeft;
    paramRectF.right -= this.mPaddingRight;
    localRectF2.bottom = localRectF1.top;
    this.l.setRect(localRectF2);
    RectF localRectF3 = new RectF(paramRectF);
    paramRectF.left += this.mPaddingLeft;
    paramRectF.right -= this.mPaddingRight;
    localRectF3.bottom = localRectF1.top;
    this.m.setRect(localRectF3);
  }

  public void setMode(int paramInt)
  {
    this.o = paramInt;
  }

  public void setSleepGoal(int paramInt)
  {
    this.m.setMaxItemValue((int)(1.5F * paramInt));
  }

  public void setStepGoal(int paramInt)
  {
    int i1 = 8000;
    if (paramInt < i1);
    while (true)
    {
      this.l.setMaxItemValue((int)(2.5F * i1));
      this.f = paramInt;
      return;
      i1 = paramInt;
    }
  }

  public void updateBarItemCount(int paramInt)
  {
    this.g = paramInt;
    Debug.i("Chart.StatisticChart", "Update Bar Item Count : " + paramInt);
    this.i = ((-1 + this.g) / 2);
    a();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.StatisticChart
 * JD-Core Version:    0.6.2
 */