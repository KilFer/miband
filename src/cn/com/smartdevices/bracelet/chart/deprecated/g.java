package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;

final class g
  implements ChartDataLoader.LoadCallback
{
  g(DynamicDetailChartViewOld paramDynamicDetailChartViewOld, ChartDataLoader.LoadCallback paramLoadCallback)
  {
  }

  public final boolean hasData(int paramInt)
  {
    return this.b.hasData(paramInt);
  }

  public final ChartDataLoader.ItemData loadData(int paramInt)
  {
    return this.a.loadDayActiveData(paramInt);
  }

  public final void onDataLoaded(ChartDataLoader.ItemData paramItemData)
  {
  }

  public final void onToItem(int paramInt)
  {
    this.b.onToItem(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.g
 * JD-Core Version:    0.6.2
 */