package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;

final class q
  implements ChartDataLoader.LoadCallback
{
  q(StatisticChartViewOld paramStatisticChartViewOld, ChartDataLoader.LoadCallback paramLoadCallback)
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
    if (paramItemData != null)
    {
      StatisticChartViewOld.a(this.a, (StatisticChartViewOld.StatisticChartData)paramItemData);
      StatisticChartViewOld.f(this.a);
      this.a.refresh();
      if ((StatisticChartViewOld.g(this.a)) && (paramItemData.index == 0))
      {
        onToItem(paramItemData.index);
        StatisticChartViewOld.b(this.a, false);
      }
    }
  }

  public final void onToItem(int paramInt)
  {
    this.b.onToItem(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.q
 * JD-Core Version:    0.6.2
 */