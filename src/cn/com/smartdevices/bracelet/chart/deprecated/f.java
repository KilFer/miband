package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import java.util.Iterator;
import java.util.List;

final class f
  implements ChartDataLoader.LoadCallback
{
  f(DynamicDetailChartViewOld paramDynamicDetailChartViewOld, ChartDataLoader.LoadCallback paramLoadCallback)
  {
  }

  public final boolean hasData(int paramInt)
  {
    return this.b.hasData(paramInt);
  }

  public final ChartDataLoader.ItemData loadData(int paramInt)
  {
    return this.b.loadData(paramInt);
  }

  public final void onDataLoaded(ChartDataLoader.ItemData paramItemData)
  {
    DynamicDetailChartViewOld.DynamicDetailChartData localDynamicDetailChartData;
    Iterator localIterator1;
    Iterator localIterator2;
    if (paramItemData != null)
    {
      localDynamicDetailChartData = (DynamicDetailChartViewOld.DynamicDetailChartData)paramItemData;
      localIterator1 = localDynamicDetailChartData.sleepData.iterator();
      if (localIterator1.hasNext())
        break label106;
      localIterator2 = localDynamicDetailChartData.stepData.iterator();
    }
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        DynamicDetailChartViewOld.a(this.a, localDynamicDetailChartData);
        if (DynamicDetailChartViewOld.b(this.a) == paramItemData.index)
          onToItem(paramItemData.index);
        if (DynamicDetailChartViewOld.c(this.a))
          this.a.refresh(true);
        DynamicDetailChartViewOld.a(this.a, true);
        return;
        label106: DynamicDetailChartViewOld.DynamicDetailChartSleepData localDynamicDetailChartSleepData = (DynamicDetailChartViewOld.DynamicDetailChartSleepData)localIterator1.next();
        localDynamicDetailChartSleepData.index += 1440 * paramItemData.index;
        break;
      }
      DynamicDetailChartViewOld.DynamicDetailChartStepData localDynamicDetailChartStepData = (DynamicDetailChartViewOld.DynamicDetailChartStepData)localIterator2.next();
      localDynamicDetailChartStepData.index += 24 * paramItemData.index;
    }
  }

  public final void onToItem(int paramInt)
  {
    this.b.onToItem(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.f
 * JD-Core Version:    0.6.2
 */