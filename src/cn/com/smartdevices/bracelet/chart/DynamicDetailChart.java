package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import cn.com.smartdevices.bracelet.chart.base.BarChart.Axis;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import java.util.List;

public class DynamicDetailChart extends BarChart
{
  private static final String a = "Chart.DynamicDetailChart";
  private static final int b = 1500;
  private static final float c = 196.60001F;
  private static final float d = 160.0F;
  private c e;
  private d f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;

  public DynamicDetailChart(Context paramContext)
  {
    super(paramContext);
    this.mXAxis = new a(this, paramContext);
    this.mXAxis.stroke = ((int)(28.0F * this.mDensity));
    this.mXAxis.setPadding((int)(2.5D * this.mDensity), 0.0F, (int)(2.5D * this.mDensity), 0.0F);
    this.e = new c(this, (byte)0);
    this.e.setPadding((int)(8.0F * this.mDensity), (int)(130.0F * this.mDensity), (int)(8.0F * this.mDensity), 0.0F);
    this.e.setItemPadding(1.0F);
    this.f = new d(this, (byte)0);
    this.f.setPadding((int)(2.5D * this.mDensity), (int)(95.0F * this.mDensity), (int)(2.5D * this.mDensity), 0.0F);
    this.f.setMaxItemValue(1500);
    this.f.setItemPadding(0.83F * this.mDensity);
  }

  public void addSleepData(List<DynamicDetailChart.DynamicDetailBarItem> paramList)
  {
    this.e.addItems(paramList);
    this.e.sortItems();
  }

  public void addStepData(List<DynamicDetailChart.DynamicDetailBarItem> paramList)
  {
    this.f.addItems(paramList);
  }

  public void clearSleepData()
  {
    this.e.clearItems();
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
  }

  public void clearStepData()
  {
    this.f.clearItems();
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
  }

  protected void doScroll(float paramFloat)
  {
    Debug.w("Chart.DynamicDetailChart", "Scroll :" + paramFloat);
    if (this.mLoadCallback == null)
      return;
    a locala = (a)this.mXAxis;
    if (this.mScroll > 0.0F)
      this.mScroll = 0.0F;
    if (this.mScroll < locala.c())
      this.mScroll = locala.c();
    Debug.w("Chart.DynamicDetailChart", "ScrollTo : " + this.mScroll);
    locala.scrollTo(this.mScroll);
  }

  public void draw(Canvas paramCanvas, float paramFloat)
  {
    this.e.draw(paramCanvas, paramFloat);
    this.f.draw(paramCanvas, paramFloat);
    super.draw(paramCanvas, paramFloat);
  }

  public void fillSleepData(List<BarChart.BarItem> paramList)
  {
    this.e.fillItems(paramList);
  }

  public void fillStepData(List<DynamicDetailChart.DynamicDetailBarItem> paramList)
  {
    this.f.fillItems(paramList);
  }

  public float getEdgeLength()
  {
    return ((a)this.mXAxis).c();
  }

  public int getEndTimeIndex()
  {
    return this.h;
  }

  public BarChart getSleepChart()
  {
    return this.e;
  }

  public int getStartTimeIndex()
  {
    return this.g;
  }

  public BarChart getStepChart()
  {
    return this.f;
  }

  public void justifyStartEndTimeIndex(int paramInt)
  {
    Debug.i("Chart.DynamicDetailChart", "Before, Start : " + this.g + " End : " + this.h + " , StartHour : " + this.i + " EndHour : " + this.j);
    if (this.j - this.i < paramInt - 1)
    {
      this.j = (this.i + (paramInt - 1));
      if (this.j > 23)
      {
        this.j = 23;
        this.i = (this.j - (paramInt - 1));
      }
      this.g = (60 * this.i);
      this.h = (60 * this.j);
    }
    Debug.i("Chart.DynamicDetailChart", "After, Start : " + this.g + " End : " + this.h + " , StartHour : " + this.i + " EndHour : " + this.j);
    ((a)this.mXAxis).notifyChanged();
  }

  public void notifyChanged()
  {
    this.e.notifyChanged();
    this.f.notifyChanged();
  }

  protected void onRectChanged(RectF paramRectF)
  {
    super.onRectChanged(paramRectF);
    RectF localRectF1 = this.mXAxis.getRect();
    RectF localRectF2 = new RectF(paramRectF);
    localRectF2.bottom = localRectF1.top;
    this.f.setRect(localRectF2);
    RectF localRectF3 = new RectF(paramRectF);
    localRectF3.bottom = localRectF1.top;
    this.e.setRect(localRectF3);
  }

  public void setMode(int paramInt)
  {
    this.k = paramInt;
  }

  public void setOffset(int paramInt)
  {
    a locala = (a)this.mXAxis;
    a.a(locala, paramInt);
    locala.offset = 0;
    locala.a();
  }

  public void setStartEndTimeIndex(int paramInt1, int paramInt2)
  {
    Debug.i("Chart.DynamicDetailChart", "Sleep Time : " + paramInt1 + " , " + paramInt2);
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = (this.g / 60);
    this.j = (this.h / 60);
    if (this.g == this.h)
      justifyStartEndTimeIndex(8);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.DynamicDetailChart
 * JD-Core Version:    0.6.2
 */