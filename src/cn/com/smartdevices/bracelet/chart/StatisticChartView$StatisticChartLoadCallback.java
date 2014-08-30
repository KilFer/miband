package cn.com.smartdevices.bracelet.chart;

import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;

public abstract interface StatisticChartView$StatisticChartLoadCallback extends ChartDataLoader.LoadCallback
{
  public abstract void onOverScrolled();
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.StatisticChartView.StatisticChartLoadCallback
 * JD-Core Version:    0.6.2
 */