package cn.com.smartdevices.bracelet.chart.base;

import java.util.Comparator;

public class BarChart$BarItemComparator
  implements Comparator<BarChart.BarItem>
{
  public int compare(BarChart.BarItem paramBarItem1, BarChart.BarItem paramBarItem2)
  {
    return paramBarItem1.index - paramBarItem2.index;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.base.BarChart.BarItemComparator
 * JD-Core Version:    0.6.2
 */