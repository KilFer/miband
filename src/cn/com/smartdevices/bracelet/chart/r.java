package cn.com.smartdevices.bracelet.chart;

import cn.com.smartdevices.bracelet.chart.base.ChartScroller;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;

final class r
  implements StatisticChartView.StatisticChartLoadCallback
{
  r(StatisticChartView paramStatisticChartView)
  {
  }

  public final boolean hasData(int paramInt)
  {
    return StatisticChartView.f(this.a).hasData(paramInt);
  }

  public final ChartDataLoader.ItemData loadData(int paramInt)
  {
    this.a.loadStatisticData(paramInt);
    StatisticChartView.b(this.a, false);
    return null;
  }

  public final void onDataLoaded(ChartDataLoader.ItemData paramItemData)
  {
  }

  public final void onOverScrolled()
  {
    StatisticChartView.c(this.a).forceFinishScrolling();
  }

  public final void onToItem(int paramInt)
  {
    StatisticChartView.f(this.a).onToItem(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.r
 * JD-Core Version:    0.6.2
 */