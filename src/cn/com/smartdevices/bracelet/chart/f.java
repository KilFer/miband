package cn.com.smartdevices.bracelet.chart;

import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class f
  implements ChartDataLoader.LoadCallback
{
  f(DynamicDetailChartView paramDynamicDetailChartView)
  {
  }

  public final boolean hasData(int paramInt)
  {
    return DynamicDetailChartView.b(this.a).hasData(paramInt);
  }

  public final ChartDataLoader.ItemData loadData(int paramInt)
  {
    return DynamicDetailChartView.b(this.a).loadData(paramInt);
  }

  public final void onDataLoaded(ChartDataLoader.ItemData paramItemData)
  {
    DynamicDetailChartView.DynamicDetailChartData localDynamicDetailChartData;
    Iterator localIterator2;
    Iterator localIterator1;
    if (paramItemData != null)
    {
      localDynamicDetailChartData = (DynamicDetailChartView.DynamicDetailChartData)paramItemData;
      if (DynamicDetailChartView.c(this.a) == 16)
      {
        localIterator2 = localDynamicDetailChartData.sleepData.iterator();
        if (localIterator2.hasNext())
          break label139;
      }
      if (DynamicDetailChartView.c(this.a) == 1)
        localIterator1 = localDynamicDetailChartData.stepData.iterator();
    }
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        DynamicDetailChartView.d(this.a).remove(Integer.valueOf(paramItemData.index));
        if (!DynamicDetailChartView.d(this.a).isEmpty())
          break label206;
        onToItem(DynamicDetailChartView.e(this.a));
        DynamicDetailChartView.a(this.a, localDynamicDetailChartData, true);
        DynamicDetailChartView.b(this.a).onDataLoaded(paramItemData);
        return;
        label139: DynamicDetailChartView.DynamicDetailChartSleepData localDynamicDetailChartSleepData = (DynamicDetailChartView.DynamicDetailChartSleepData)localIterator2.next();
        localDynamicDetailChartSleepData.index += 1440 * paramItemData.index;
        break;
      }
      DynamicDetailChartView.DynamicDetailChartStepData localDynamicDetailChartStepData = (DynamicDetailChartView.DynamicDetailChartStepData)localIterator1.next();
      localDynamicDetailChartStepData.index += 24 * paramItemData.index;
    }
    label206: DynamicDetailChartView.a(this.a, localDynamicDetailChartData, false);
  }

  public final void onToItem(int paramInt)
  {
    DynamicDetailChartView.b(this.a).onToItem(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.f
 * JD-Core Version:    0.6.2
 */