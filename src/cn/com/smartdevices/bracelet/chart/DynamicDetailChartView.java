package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.BarChart;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItemComparator;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller.ScrollingListener;
import cn.com.smartdevices.bracelet.chart.base.ColorRenderer;
import cn.com.smartdevices.bracelet.chart.base.Renderer;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DynamicDetailChartView extends BaseChartView<DynamicDetailChart>
{
  private static final String a = "Chart.DynamicDetailChartView";
  private Renderer b = new ColorRenderer(1308622847);
  private Renderer c = new ColorRenderer(-2130706433);
  private Renderer d = new ColorRenderer(-1711303168);
  private Renderer e = new ColorRenderer(452984831);
  private Renderer f = new ColorRenderer(-855638017);
  private Renderer g = new ColorRenderer(-855638017);
  private Renderer h = new ColorRenderer(-27136);
  private Renderer i = new ColorRenderer(872415231);
  private Renderer j = new ColorRenderer(1308622847);
  private Renderer k = new ColorRenderer(-855638017);
  private ChartScroller l;
  private int m;
  private ArrayList<Integer> n;
  private int o;
  private DynamicDetailChartView.DynamicDetailChartLoadCallback p;
  private ChartScroller.ScrollingListener q = new e(this);

  public DynamicDetailChartView(Context paramContext)
  {
    this(paramContext, null);
  }

  public DynamicDetailChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DynamicDetailChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mChart = new DynamicDetailChart(paramContext);
    this.mInterpolator = new AccelerateDecelerateInterpolator();
    new ChartScroller(getContext(), this.q);
    this.n = new ArrayList();
  }

  private List<BarChart.BarItem> a(List<BarChart.BarItem> paramList, int paramInt1, int paramInt2)
  {
    Collections.sort(paramList, new BarChart.BarItemComparator());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    Object localObject = null;
    while (true)
    {
      if (!localIterator.hasNext())
        return localArrayList;
      BarChart.BarItem localBarItem = (BarChart.BarItem)localIterator.next();
      Debug.i("Chart.DynamicDetailChartView", "Sleep : " + localBarItem.index + " , " + localBarItem.scope + " , " + localBarItem.value);
      if (localBarItem.index >= paramInt1)
        if (localObject != null)
        {
          int i2 = localObject.index + localObject.scope;
          if ((i2 == localBarItem.index) && (localObject.value == localBarItem.value))
          {
            DynamicDetailChart.DynamicDetailBarItem localDynamicDetailBarItem3 = new DynamicDetailChart.DynamicDetailBarItem();
            localDynamicDetailBarItem3.index = localObject.index;
            localDynamicDetailBarItem3.scope = (localBarItem.index + localBarItem.scope - localObject.index);
            localDynamicDetailBarItem3.value = localBarItem.value;
            localDynamicDetailBarItem3.setRenderer(localBarItem.getRenderer());
            Debug.i("Chart.DynamicDetailChartView", "Sleep Merge : " + localDynamicDetailBarItem3.index + " , " + localDynamicDetailBarItem3.scope + " , " + localDynamicDetailBarItem3.value);
            localArrayList.remove(localObject);
            localArrayList.add(localDynamicDetailBarItem3);
            localObject = localDynamicDetailBarItem3;
          }
          else
          {
            if ((i2 != localBarItem.index) && (i2 > paramInt1) && (i2 < paramInt2))
            {
              DynamicDetailChart.DynamicDetailBarItem localDynamicDetailBarItem2 = new DynamicDetailChart.DynamicDetailBarItem();
              localDynamicDetailBarItem2.index = i2;
              localDynamicDetailBarItem2.scope = (localBarItem.index - i2);
              localDynamicDetailBarItem2.value = 1;
              localDynamicDetailBarItem2.setRenderer(this.d);
              Debug.i("Chart.DynamicDetailChartView", "Sleep Active : " + localDynamicDetailBarItem2.index + " , " + localDynamicDetailBarItem2.scope + " , " + localDynamicDetailBarItem2.value);
              localArrayList.add(localDynamicDetailBarItem2);
            }
            localArrayList.add(localBarItem);
            localObject = localBarItem;
          }
        }
        else
        {
          int i1 = localBarItem.index + localBarItem.scope;
          if ((localBarItem.index > paramInt1) && (i1 < paramInt2))
          {
            DynamicDetailChart.DynamicDetailBarItem localDynamicDetailBarItem1 = new DynamicDetailChart.DynamicDetailBarItem();
            localDynamicDetailBarItem1.index = paramInt1;
            localDynamicDetailBarItem1.scope = (localBarItem.index - paramInt1);
            localDynamicDetailBarItem1.value = 1;
            localDynamicDetailBarItem1.setRenderer(this.d);
            Debug.i("Chart.DynamicDetailChartView", "Sleep Active : " + localDynamicDetailBarItem1.index + " , " + localDynamicDetailBarItem1.scope + " , " + localDynamicDetailBarItem1.value);
            localArrayList.add(localDynamicDetailBarItem1);
          }
          localArrayList.add(localBarItem);
          localObject = localBarItem;
        }
    }
  }

  private void a(DynamicDetailChartView.DynamicDetailChartData paramDynamicDetailChartData, boolean paramBoolean)
  {
    if (this.o == 16)
      bindSleepData(paramDynamicDetailChartData.sleepData, paramBoolean);
    if (this.o == 1)
      bindStepData(paramDynamicDetailChartData.stepData);
    ((DynamicDetailChart)this.mChart).notifyChanged();
  }

  public void bindSleepData(List<DynamicDetailChartView.DynamicDetailChartSleepData> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    ArrayList localArrayList2;
    if (!localIterator.hasNext())
    {
      localArrayList2 = new ArrayList();
      localArrayList2.addAll(((DynamicDetailChart)this.mChart).getSleepChart().getItems());
      localArrayList2.addAll(localArrayList1);
      if (!paramBoolean)
        ((DynamicDetailChart)this.mChart).fillSleepData(localArrayList2);
    }
    else
    {
      DynamicDetailChartView.DynamicDetailChartSleepData localDynamicDetailChartSleepData = (DynamicDetailChartView.DynamicDetailChartSleepData)localIterator.next();
      DynamicDetailChart.DynamicDetailBarItem localDynamicDetailBarItem = new DynamicDetailChart.DynamicDetailBarItem();
      localDynamicDetailBarItem.index = localDynamicDetailChartSleepData.index;
      localDynamicDetailBarItem.scope = localDynamicDetailChartSleepData.length;
      localDynamicDetailBarItem.value = localDynamicDetailChartSleepData.mode;
      switch (localDynamicDetailChartSleepData.mode)
      {
      default:
      case 3:
      case 2:
      case 1:
      case 4:
      }
      while (true)
      {
        localArrayList1.add(localDynamicDetailBarItem);
        break;
        localDynamicDetailBarItem.setRenderer(this.b);
        continue;
        localDynamicDetailBarItem.setRenderer(this.c);
        continue;
        localDynamicDetailBarItem.setRenderer(this.d);
        continue;
        localDynamicDetailBarItem.setRenderer(this.e);
      }
    }
    List localList = a(localArrayList2, ((DynamicDetailChart)this.mChart).getStartTimeIndex(), ((DynamicDetailChart)this.mChart).getEndTimeIndex());
    ((DynamicDetailChart)this.mChart).fillSleepData(localList);
  }

  public void bindStepData(List<DynamicDetailChartView.DynamicDetailChartStepData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        ((DynamicDetailChart)this.mChart).addStepData(localArrayList);
        return;
      }
      DynamicDetailChartView.DynamicDetailChartStepData localDynamicDetailChartStepData = (DynamicDetailChartView.DynamicDetailChartStepData)localIterator.next();
      DynamicDetailChart.DynamicDetailBarItem localDynamicDetailBarItem = new DynamicDetailChart.DynamicDetailBarItem();
      localDynamicDetailBarItem.value = localDynamicDetailChartStepData.step;
      localDynamicDetailBarItem.index = localDynamicDetailChartStepData.index;
      localDynamicDetailBarItem.scope = 1;
      localDynamicDetailBarItem.setRenderer(this.j);
      localArrayList.add(localDynamicDetailBarItem);
    }
  }

  public void clearData()
  {
    this.n.clear();
    this.mLoader.clearData();
    ((DynamicDetailChart)this.mChart).clearStepData();
    ((DynamicDetailChart)this.mChart).clearSleepData();
    ((DynamicDetailChart)this.mChart).notifyChanged();
  }

  public ChartDataLoader.ItemData loadDynamicData(int paramInt)
  {
    return loadDynamicData(paramInt, null);
  }

  public ChartDataLoader.ItemData loadDynamicData(int paramInt, int[] paramArrayOfInt)
  {
    this.m = paramInt;
    ChartDataLoader.ItemData localItemData = this.mLoader.getItemData(paramInt);
    if ((localItemData == null) && (this.mLoader.hasItemData(paramInt)))
      this.n.add(Integer.valueOf(paramInt));
    int i3;
    Iterator localIterator;
    if (paramArrayOfInt != null)
    {
      int i2 = paramArrayOfInt.length;
      i3 = 0;
      if (i3 < i2);
    }
    else
    {
      localIterator = this.n.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        return localItemData;
        int i4 = paramArrayOfInt[i3];
        if ((this.mLoader.getItemData(i4) == null) && (this.mLoader.hasItemData(i4)))
          this.n.add(Integer.valueOf(i4));
        i3++;
        break;
      }
      int i1 = ((Integer)localIterator.next()).intValue();
      this.mLoader.putItemData(i1, new DynamicDetailChartView.DynamicDetailChartData());
      this.mLoader.loadItemData(i1);
    }
  }

  public void notifyChanged()
  {
    ((DynamicDetailChart)this.mChart).notifyChanged();
  }

  public boolean onTouch(float paramFloat1, float paramFloat2)
  {
    Debug.i("Chart.DynamicDetailChartView", "On Touch : " + paramFloat1 + "," + paramFloat2);
    Iterator localIterator2;
    boolean bool2;
    boolean bool1;
    if (this.o == 16)
    {
      localIterator2 = ((DynamicDetailChart)this.mChart).getSleepChart().getItems().iterator();
      bool2 = false;
      if (!localIterator2.hasNext())
      {
        refresh();
        bool1 = bool2;
      }
    }
    label132: int i1;
    do
    {
      return bool1;
      BarChart.BarItem localBarItem2 = (BarChart.BarItem)localIterator2.next();
      RectF localRectF2;
      switch (localBarItem2.value)
      {
      default:
        localRectF2 = localBarItem2.getRect();
        if ((paramFloat1 < localRectF2.left) || (paramFloat1 > localRectF2.right))
          break;
        switch (localBarItem2.value)
        {
        default:
        case 3:
        case 2:
        case 1:
        case 4:
        }
      case 3:
      case 2:
      case 1:
      case 4:
        while (true)
        {
          int i3 = localBarItem2.index + (int)((paramFloat1 - localRectF2.left) / localRectF2.width() * localBarItem2.scope);
          this.p.onTouchItem(localBarItem2.index, localBarItem2, i3, paramFloat1, paramFloat2);
          bool2 = true;
          break;
          localBarItem2.setRenderer(this.b);
          break label132;
          localBarItem2.setRenderer(this.c);
          break label132;
          localBarItem2.setRenderer(this.d);
          break label132;
          localBarItem2.setRenderer(this.e);
          break label132;
          localBarItem2.setRenderer(this.f);
          continue;
          localBarItem2.setRenderer(this.g);
          continue;
          localBarItem2.setRenderer(this.h);
          continue;
          localBarItem2.setRenderer(this.i);
        }
        i1 = this.o;
        bool1 = false;
      }
    }
    while (i1 != 1);
    Iterator localIterator1 = ((DynamicDetailChart)this.mChart).getStepChart().getItems().iterator();
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        refresh();
        return bool1;
      }
      BarChart.BarItem localBarItem1 = (BarChart.BarItem)localIterator1.next();
      localBarItem1.setRenderer(this.j);
      RectF localRectF1 = localBarItem1.getRect();
      if ((paramFloat1 >= localRectF1.left) && (paramFloat1 <= localRectF1.right))
      {
        localBarItem1.setRenderer(this.k);
        int i2 = 60 * localBarItem1.index;
        this.p.onTouchItem(localBarItem1.index, localBarItem1, i2, paramFloat1, paramFloat2);
        bool1 = true;
      }
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!this.mScrollable)
      bool = false;
    float f1;
    float f2;
    do
    {
      return bool;
      if (getParent() != null)
        getParent().requestDisallowInterceptTouchEvent(bool);
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      switch (paramMotionEvent.getAction())
      {
      default:
        return bool;
      case 0:
      case 2:
      case 1:
      case 3:
      }
    }
    while (onTouch(f1, f2));
    this.p.onTouchNothing(f1, f2);
    return bool;
    onTouch(-1.0F, -1.0F);
    this.p.onTouchNothing(f1, f2);
    return bool;
  }

  public void refresh()
  {
    if (animRefresh().isStarted())
      return;
    super.refresh();
  }

  public void refresh(boolean paramBoolean)
  {
    super.refresh(paramBoolean);
  }

  public void setDataLoader(ChartDataLoader paramChartDataLoader)
  {
    this.mLoader = paramChartDataLoader;
    this.p = ((DynamicDetailChartView.DynamicDetailChartLoadCallback)paramChartDataLoader.getLoadCallback());
    this.mLoader.setLoadCallback(new f(this));
    ((DynamicDetailChart)this.mChart).setLoadCallback(new g(this));
  }

  public void setMode(int paramInt)
  {
    this.o = paramInt;
    ((DynamicDetailChart)this.mChart).setMode(this.o);
  }

  public void setOffset(int paramInt)
  {
    ((DynamicDetailChart)this.mChart).setOffset(paramInt);
  }

  public void setStartEndTimeIndex(int paramInt1, int paramInt2)
  {
    ((DynamicDetailChart)this.mChart).setStartEndTimeIndex(paramInt1, paramInt2);
  }

  public void setStepItemSelection(int paramInt)
  {
    Iterator localIterator = ((DynamicDetailChart)this.mChart).getStepChart().getItems().iterator();
    BarChart.BarItem localBarItem;
    do
    {
      if (!localIterator.hasNext())
        return;
      localBarItem = (BarChart.BarItem)localIterator.next();
    }
    while (localBarItem.index != paramInt);
    localBarItem.setRenderer(this.k);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.DynamicDetailChartView
 * JD-Core Version:    0.6.2
 */