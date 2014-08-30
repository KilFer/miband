package cn.com.smartdevices.bracelet.chart.deprecated;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller.ScrollingListener;
import cn.com.smartdevices.bracelet.chart.base.ColorRenderer;
import cn.com.smartdevices.bracelet.chart.base.Renderer;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import java.util.ArrayList;
import java.util.List;

public class StatisticChartViewOld extends BaseChartView<StatisticChartOld>
{
  private static final String a = "Chart.StatisticChartView";
  private Renderer b = new ColorRenderer(-859373824);
  private Renderer c = new ColorRenderer(-868140594);
  private List<StatisticChartOld.StatisticBarItem> d;
  private List<StatisticChartOld.StatisticBarItem> e;
  private List<StatisticChartOld.DateItem> f;
  private boolean g;
  private ChartScroller.ScrollingListener h = new p(this);

  public StatisticChartViewOld(Context paramContext)
  {
    this(paramContext, null);
  }

  public StatisticChartViewOld(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public StatisticChartViewOld(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mChart = new StatisticChartOld(paramContext);
    ((StatisticChartOld)this.mChart).setContainerView(this);
    this.d = new ArrayList();
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.mScroller = new ChartScroller(getContext(), this.h);
    this.g = true;
    setLayerType(1, null);
  }

  private void a()
  {
    ((StatisticChartOld)this.mChart).fillStepData(this.d);
    ((StatisticChartOld)this.mChart).fillSleepData(this.e);
    ((StatisticChartOld)this.mChart).fillDates(this.f);
    ((StatisticChartOld)this.mChart).notifyChanged();
  }

  private void a(StatisticChartViewOld.StatisticChartData paramStatisticChartData)
  {
    StatisticChartOld.StatisticBarItem localStatisticBarItem1 = new StatisticChartOld.StatisticBarItem();
    localStatisticBarItem1.value = paramStatisticChartData.stepValue;
    localStatisticBarItem1.index = paramStatisticChartData.index;
    localStatisticBarItem1.setRenderer(this.b);
    this.d.add(localStatisticBarItem1);
    StatisticChartOld.StatisticBarItem localStatisticBarItem2 = new StatisticChartOld.StatisticBarItem();
    localStatisticBarItem2.value = paramStatisticChartData.sleepValue;
    localStatisticBarItem2.index = paramStatisticChartData.index;
    localStatisticBarItem2.setRenderer(this.c);
    this.e.add(localStatisticBarItem2);
    StatisticChartOld.DateItem localDateItem = new StatisticChartOld.DateItem();
    localDateItem.a = paramStatisticChartData.index;
    localDateItem.b = paramStatisticChartData.date;
    this.f.add(localDateItem);
  }

  public void clearData()
  {
    this.e.clear();
    this.d.clear();
    this.f.clear();
    ((StatisticChartOld)this.mChart).fillStepData(this.d);
    ((StatisticChartOld)this.mChart).fillSleepData(this.e);
    ((StatisticChartOld)this.mChart).fillDates(this.f);
    this.mLoader.clearData();
    this.g = true;
    ((StatisticChartOld)this.mChart).notifyChanged();
  }

  public void loadData(int paramInt)
  {
    for (int i = -1; ; i++)
    {
      if (i > 8)
        return;
      if ((this.mLoader.getItemData(paramInt - i) == null) && (this.mLoader.hasItemData(paramInt - i)))
      {
        this.mLoader.putItemData(paramInt - i, new StatisticChartViewOld.StatisticChartData());
        this.mLoader.loadItemData(paramInt - i);
      }
    }
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
        this.mScroller.scrollX(((StatisticChartOld)this.mChart).offsetScroll(f1));
      }
    }
  }

  public void setDataLoader(ChartDataLoader paramChartDataLoader)
  {
    this.mLoader = paramChartDataLoader;
    ChartDataLoader.LoadCallback localLoadCallback = paramChartDataLoader.getLoadCallback();
    this.mLoader.setLoadCallback(new q(this, localLoadCallback));
    ((StatisticChartOld)this.mChart).setLoadCallback(new r(this, localLoadCallback));
  }

  public void setMode(int paramInt)
  {
  }

  public void setStepGoal(int paramInt)
  {
    ((StatisticChartOld)this.mChart).setStepGoal(paramInt);
    refresh();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.StatisticChartViewOld
 * JD-Core Version:    0.6.2
 */