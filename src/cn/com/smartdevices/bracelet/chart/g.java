package cn.com.smartdevices.bracelet.chart;

import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;

final class g
  implements ChartDataLoader.LoadCallback
{
  g(DynamicDetailChartView paramDynamicDetailChartView)
  {
  }

  public final boolean hasData(int paramInt)
  {
    return DynamicDetailChartView.b(this.a).hasData(paramInt);
  }

  public final ChartDataLoader.ItemData loadData(int paramInt)
  {
    return this.a.loadDynamicData(paramInt);
  }

  public final void onDataLoaded(ChartDataLoader.ItemData paramItemData)
  {
  }

  public final void onToItem(int paramInt)
  {
    DynamicDetailChartView.b(this.a).onToItem(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.g
 * JD-Core Version:    0.6.2
 */