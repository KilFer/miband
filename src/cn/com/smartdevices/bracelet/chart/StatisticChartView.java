package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller.ScrollingListener;
import cn.com.smartdevices.bracelet.chart.base.ColorRenderer;
import cn.com.smartdevices.bracelet.chart.base.Renderer;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StatisticChartView extends BaseChartView<StatisticChart>
{
  private static final String a = "Chart.StatisticChartView";
  private Renderer b = new ColorRenderer(0);
  private Renderer c = new ColorRenderer(0);
  private List<StatisticChart.StatisticBarItem> d;
  private List<StatisticChart.StatisticBarItem> e;
  private List<StatisticChart.DateItem> f;
  private int g;
  private ArrayList<Integer> h;
  private ChartDataLoader.LoadCallback i;
  private boolean j;
  private float k;
  private float l;
  private float m;
  private float n;
  private ChartScroller.ScrollingListener o = new p(this);

  public StatisticChartView(Context paramContext)
  {
    this(paramContext, null);
  }

  public StatisticChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public StatisticChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mChart = new StatisticChart(paramContext);
    this.mInterpolator = new AccelerateDecelerateInterpolator();
    this.d = new ArrayList();
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.mScroller = new ChartScroller(getContext(), this.o);
    this.h = new ArrayList();
  }

  private void a()
  {
    ((StatisticChart)this.mChart).fillStepData(this.d);
    ((StatisticChart)this.mChart).fillSleepData(this.e);
    ((StatisticChart)this.mChart).fillDates(this.f);
    ((StatisticChart)this.mChart).notifyChanged();
  }

  private void a(StatisticChartView.StatisticChartData paramStatisticChartData)
  {
    StatisticChart.StatisticBarItem localStatisticBarItem1 = new StatisticChart.StatisticBarItem();
    localStatisticBarItem1.value = paramStatisticChartData.stepValue;
    localStatisticBarItem1.index = paramStatisticChartData.index;
    localStatisticBarItem1.setRenderer(this.b);
    localStatisticBarItem1.setParent(this.mChart);
    this.d.add(localStatisticBarItem1);
    StatisticChart.StatisticBarItem localStatisticBarItem2 = new StatisticChart.StatisticBarItem();
    localStatisticBarItem2.value = paramStatisticChartData.sleepValue;
    localStatisticBarItem2.value1 = paramStatisticChartData.sleepDeepValue;
    localStatisticBarItem2.index = paramStatisticChartData.index;
    localStatisticBarItem2.setRenderer(this.c);
    localStatisticBarItem2.setParent(this.mChart);
    this.e.add(localStatisticBarItem2);
    StatisticChart.DateItem localDateItem = new StatisticChart.DateItem();
    localDateItem.a = paramStatisticChartData.index;
    localDateItem.b = paramStatisticChartData.date;
    this.f.add(localDateItem);
  }

  private boolean a(int paramInt)
  {
    Iterator localIterator = this.d.iterator();
    do
      if (!localIterator.hasNext())
        return false;
    while (((BarChart.BarItem)localIterator.next()).index != paramInt);
    return true;
  }

  public Animator animRefresh()
  {
    this.k = -1.0F;
    this.l = -1.0F;
    this.m = -1.0F;
    this.n = -1.0F;
    return super.animRefresh();
  }

  public Animator animRefresh(long paramLong, float paramFloat1, float paramFloat2)
  {
    this.k = paramFloat1;
    this.l = -1.0F;
    this.m = paramFloat2;
    this.n = -1.0F;
    return animRefresh(paramLong);
  }

  public Animator animRefreshTo(long paramLong, float paramFloat1, float paramFloat2)
  {
    this.k = -1.0F;
    this.l = paramFloat1;
    this.m = -1.0F;
    this.n = paramFloat2;
    return animRefresh(paramLong);
  }

  public void clearData()
  {
    this.e.clear();
    this.d.clear();
    this.f.clear();
    ((StatisticChart)this.mChart).fillStepData(this.d);
    ((StatisticChart)this.mChart).fillSleepData(this.e);
    ((StatisticChart)this.mChart).fillDates(this.f);
    this.h.clear();
    ((StatisticChart)this.mChart).clearData();
    ((StatisticChart)this.mChart).notifyChanged();
  }

  public BarChart.BarItem getBarItem(int paramInt1, int paramInt2)
  {
    List localList;
    if (paramInt1 == 16)
      localList = this.e;
    while (true)
    {
      Iterator localIterator = localList.iterator();
      BarChart.BarItem localBarItem;
      do
      {
        if (!localIterator.hasNext())
        {
          return null;
          if (paramInt1 != 1)
            break label68;
          localList = this.d;
          break;
        }
        localBarItem = (BarChart.BarItem)localIterator.next();
      }
      while (localBarItem.index != paramInt2);
      return localBarItem;
      label68: localList = null;
    }
  }

  public float getBarItemWidth()
  {
    return ((StatisticChart)this.mChart).getBarItemWidth();
  }

  public void loadStatisticData(int paramInt)
  {
    this.g = paramInt;
    this.j = true;
    int i1 = -1 + (1 + ((StatisticChart)this.mChart).getBarItemCount()) / 2;
    int i2 = -1;
    Iterator localIterator;
    if (i2 > ((StatisticChart)this.mChart).getBarItemCount())
      if (this.h.size() > 0)
        localIterator = this.h.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        return;
        int i3 = i1 + (paramInt - i2);
        Debug.i("Chart.StatisticChartView", "Offset : " + i3);
        if ((!this.h.contains(Integer.valueOf(i3))) && (this.i.hasData(i3)))
          this.h.add(Integer.valueOf(i3));
        i2++;
        break;
      }
      int i4 = ((Integer)localIterator.next()).intValue();
      this.mLoader.loadItemData(i4);
    }
  }

  public void offsetTo(int paramInt)
  {
    ((StatisticChart)this.mChart).offsetTo(-paramInt);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    ((StatisticChart)this.mChart).draw(paramCanvas, this.mAnimFactor, this.k, this.l, this.m, this.n);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollable)
      return false;
    if (getParent() != null)
      getParent().requestDisallowInterceptTouchEvent(true);
    switch (paramMotionEvent.getAction())
    {
    default:
    case 1:
    }
    while (true)
    {
      return this.mScroller.onTouchEvent(paramMotionEvent);
      if (!this.mIsScrollingPerformed)
      {
        float f1 = paramMotionEvent.getX();
        this.mScroller.scrollX(((StatisticChart)this.mChart).offsetScrolled(f1));
      }
    }
  }

  public void refresh()
  {
    this.k = -1.0F;
    this.l = -1.0F;
    this.m = -1.0F;
    this.n = -1.0F;
    super.refresh();
  }

  public void setDataLoader(ChartDataLoader paramChartDataLoader)
  {
    this.i = paramChartDataLoader.getLoadCallback();
    this.mLoader = paramChartDataLoader;
    this.mLoader.setLoadCallback(new q(this));
    ((StatisticChart)this.mChart).setLoadCallback(new r(this));
  }

  public void setMode(int paramInt)
  {
    ((StatisticChart)this.mChart).setMode(paramInt);
  }

  public void setStepGoal(int paramInt)
  {
    ((StatisticChart)this.mChart).setStepGoal(paramInt);
  }

  public void updateBarItemCount(int paramInt)
  {
    ((StatisticChart)this.mChart).updateBarItemCount(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.StatisticChartView
 * JD-Core Version:    0.6.2
 */