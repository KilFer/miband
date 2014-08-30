package cn.com.smartdevices.bracelet.chart;

import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;
import java.util.ArrayList;

final class q
  implements ChartDataLoader.LoadCallback
{
  q(StatisticChartView paramStatisticChartView)
  {
  }

  public final boolean hasData(int paramInt)
  {
    return StatisticChartView.f(this.a).hasData(paramInt);
  }

  public final ChartDataLoader.ItemData loadData(int paramInt)
  {
    ChartDataLoader.ItemData localItemData = StatisticChartView.d(this.a).getItemData(paramInt);
    if (localItemData == null)
      localItemData = StatisticChartView.f(this.a).loadData(paramInt);
    return localItemData;
  }

  public final void onDataLoaded(ChartDataLoader.ItemData paramItemData)
  {
    if (!StatisticChartView.b(this.a, paramItemData.index))
    {
      StatisticChartView.a(this.a, (StatisticChartView.StatisticChartData)paramItemData);
      StatisticChartView.g(this.a);
    }
    StatisticChartView.h(this.a).remove(Integer.valueOf(paramItemData.index));
    if (StatisticChartView.h(this.a).size() == 0)
    {
      if (StatisticChartView.i(this.a))
        onToItem(StatisticChartView.j(this.a));
      StatisticChartView.f(this.a).onDataLoaded(paramItemData);
    }
  }

  public final void onToItem(int paramInt)
  {
    StatisticChartView.f(this.a).onToItem(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.q
 * JD-Core Version:    0.6.2
 */