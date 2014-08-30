package cn.com.smartdevices.bracelet.chart;

import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader.ItemData;
import java.util.ArrayList;
import java.util.List;

public class DynamicDetailChartView$DynamicDetailChartData extends ChartDataLoader.ItemData
{
  public String date = "";
  public String prevDate = "";
  public List<DynamicDetailChartView.DynamicDetailChartSleepData> sleepData = new ArrayList();
  public List<DynamicDetailChartView.DynamicDetailChartStepData> stepData = new ArrayList();
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.DynamicDetailChartView.DynamicDetailChartData
 * JD-Core Version:    0.6.2
 */