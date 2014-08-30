package cn.com.smartdevices.bracelet.chart.deprecated;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller.ScrollingListener;
import cn.com.smartdevices.bracelet.chart.base.ColorRenderer;
import cn.com.smartdevices.bracelet.chart.base.Renderer;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DynamicDetailChartViewOld extends BaseChartView<DynamicDetailChartOld>
{
  private static final String a = "Chart.DynamicDetailChartView";
  private Renderer b = new ColorRenderer(-1287570994);
  private Renderer c = new ColorRenderer(1296120270);
  private Renderer d = new ColorRenderer(-1275104768);
  private Renderer e = new ColorRenderer(-1278804224);
  private Renderer f = new ColorRenderer(1304887040);
  private ChartScroller g;
  private int h;
  private boolean i;
  private ChartScroller.ScrollingListener j = new e(this);

  public DynamicDetailChartViewOld(Context paramContext)
  {
    this(paramContext, null);
  }

  public DynamicDetailChartViewOld(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DynamicDetailChartViewOld(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mChart = new DynamicDetailChartOld(paramContext);
    this.mInterpolator = new DecelerateInterpolator();
    this.mDuration = 500L;
    this.g = new ChartScroller(getContext(), this.j);
  }

  private void a(DynamicDetailChartViewOld.DynamicDetailChartData paramDynamicDetailChartData)
  {
    bindStepData(paramDynamicDetailChartData.stepData);
    bindSleepData(paramDynamicDetailChartData.sleepData);
    ((DynamicDetailChartOld)this.mChart).notifyChanged();
  }

  public void bindSleepData(List<DynamicDetailChartViewOld.DynamicDetailChartSleepData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (!localIterator.hasNext())
    {
      ((DynamicDetailChartOld)this.mChart).addSleepData(localArrayList);
      return;
    }
    DynamicDetailChartViewOld.DynamicDetailChartSleepData localDynamicDetailChartSleepData = (DynamicDetailChartViewOld.DynamicDetailChartSleepData)localIterator.next();
    DynamicDetailChartOld.DynamicDetailBarItem localDynamicDetailBarItem = new DynamicDetailChartOld.DynamicDetailBarItem();
    localDynamicDetailBarItem.value = localDynamicDetailChartSleepData.mode;
    localDynamicDetailBarItem.index = localDynamicDetailChartSleepData.index;
    localDynamicDetailBarItem.scope = localDynamicDetailChartSleepData.length;
    switch (localDynamicDetailChartSleepData.mode)
    {
    default:
    case 3:
    case 2:
    case 1:
    }
    while (true)
    {
      localArrayList.add(localDynamicDetailBarItem);
      break;
      localDynamicDetailBarItem.setRenderer(this.b);
      continue;
      localDynamicDetailBarItem.setRenderer(this.c);
      continue;
      localDynamicDetailBarItem.setRenderer(this.d);
    }
  }

  public void bindStepData(List<DynamicDetailChartViewOld.DynamicDetailChartStepData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (!localIterator.hasNext())
    {
      ((DynamicDetailChartOld)this.mChart).addStepData(localArrayList);
      return;
    }
    DynamicDetailChartViewOld.DynamicDetailChartStepData localDynamicDetailChartStepData = (DynamicDetailChartViewOld.DynamicDetailChartStepData)localIterator.next();
    DynamicDetailChartOld.DynamicDetailBarItem localDynamicDetailBarItem = new DynamicDetailChartOld.DynamicDetailBarItem();
    localDynamicDetailBarItem.value = localDynamicDetailChartStepData.step;
    localDynamicDetailBarItem.index = localDynamicDetailChartStepData.index;
    localDynamicDetailBarItem.scope = 1;
    if (localDynamicDetailBarItem.value >= 500)
      localDynamicDetailBarItem.setRenderer(this.e);
    while (true)
    {
      localArrayList.add(localDynamicDetailBarItem);
      break;
      localDynamicDetailBarItem.setRenderer(this.f);
    }
  }

  public void clearData()
  {
    this.i = false;
    this.mLoader.clearData();
    ((DynamicDetailChartOld)this.mChart).clearStepData();
    ((DynamicDetailChartOld)this.mChart).clearSleepData();
    ((DynamicDetailChartOld)this.mChart).notifyChanged();
  }

  public ChartDataLoader.ItemData loadDayActiveData(int paramInt)
  {
    this.h = paramInt;
    ChartDataLoader.ItemData localItemData = this.mLoader.getItemData(paramInt);
    if ((localItemData == null) && (this.mLoader.hasItemData(paramInt)))
    {
      this.mLoader.putItemData(paramInt, new DynamicDetailChartViewOld.DynamicDetailChartData());
      this.mLoader.loadItemData(paramInt);
    }
    if ((this.mLoader.getItemData(paramInt - 1) == null) && (this.mLoader.hasItemData(paramInt - 1)))
    {
      this.mLoader.putItemData(paramInt - 1, new DynamicDetailChartViewOld.DynamicDetailChartData());
      this.mLoader.loadItemData(paramInt - 1);
      return localItemData;
    }
    this.i = true;
    return localItemData;
  }

  public void notifyChanged()
  {
    ((DynamicDetailChartOld)this.mChart).notifyChanged();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (!this.mScrollable)
      bool = false;
    do
    {
      return bool;
      bool = this.g.onTouchEvent(paramMotionEvent);
      Debug.i("Chart.DynamicDetailChartView", "Consumed : " + bool);
    }
    while (getParent() == null);
    getParent().requestDisallowInterceptTouchEvent(bool);
    return bool;
  }

  public void refresh()
  {
    Debug.w("Chart.DynamicDetailChartView", "Refresh!!");
    if (animRefresh().isStarted())
      return;
    super.refresh();
  }

  public void refresh(boolean paramBoolean)
  {
    Debug.e("Chart.DynamicDetailChartView", "Refresh : " + paramBoolean);
    super.refresh(paramBoolean);
  }

  public void setDataLoader(ChartDataLoader paramChartDataLoader)
  {
    this.mLoader = paramChartDataLoader;
    ChartDataLoader.LoadCallback localLoadCallback = paramChartDataLoader.getLoadCallback();
    this.mLoader.setLoadCallback(new f(this, localLoadCallback));
    ((DynamicDetailChartOld)this.mChart).setLoadCallback(new g(this, localLoadCallback));
  }

  public void setOffset(int paramInt)
  {
    ((DynamicDetailChartOld)this.mChart).setOffset(paramInt);
  }

  public void setSleepRiseTime(int paramInt, String paramString1, String paramString2)
  {
    ((DynamicDetailChartOld)this.mChart).setSleepRiseTime(paramInt, paramString1, paramString2);
  }

  public void setSleepStartTime(int paramInt, String paramString1, String paramString2)
  {
    ((DynamicDetailChartOld)this.mChart).setSleepStartTime(paramInt, paramString1, paramString2);
  }

  public void setStepTime(String paramString1, String paramString2)
  {
    ((DynamicDetailChartOld)this.mChart).setStepTime(paramString1, paramString2);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.DynamicDetailChartViewOld
 * JD-Core Version:    0.6.2
 */