package cn.com.smartdevices.bracelet.chart;

import cn.com.smartdevices.bracelet.chart.base.BarChart.BarItem;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.LoadCallback;

public abstract interface DynamicDetailChartView$DynamicDetailChartLoadCallback extends ChartDataLoader.LoadCallback
{
  public abstract void onTouchItem(int paramInt1, BarChart.BarItem paramBarItem, int paramInt2, float paramFloat1, float paramFloat2);

  public abstract void onTouchNothing(float paramFloat1, float paramFloat2);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartLoadCallback
 * JD-Core Version:    0.6.2
 */