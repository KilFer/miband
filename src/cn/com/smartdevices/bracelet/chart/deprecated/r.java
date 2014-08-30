package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.chart.base.ChartScroller;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;

final class r
  implements StatisticChartViewOld.StatisticChartLoadCallback
{
  r(StatisticChartViewOld paramStatisticChartViewOld, ChartDataLoader.LoadCallback paramLoadCallback)
  {
  }

  public final boolean hasData(int paramInt)
  {
    return this.b.hasData(paramInt);
  }

  public final ChartDataLoader.ItemData loadData(int paramInt)
  {
    this.a.loadData(paramInt);
    return null;
  }

  public final void onDataLoaded(ChartDataLoader.ItemData paramItemData)
  {
  }

  public final void onOverScrolled()
  {
    StatisticChartViewOld.c(this.a).forceFinishScrolling();
  }

  public final void onToItem(int paramInt)
  {
    this.b.onToItem(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.r
 * JD-Core Version:    0.6.2
 */