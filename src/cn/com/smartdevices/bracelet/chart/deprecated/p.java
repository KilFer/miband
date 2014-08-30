package cn.com.smartdevices.bracelet.chart.deprecated;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller.ScrollingListener;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;

final class p
  implements ChartScroller.ScrollingListener
{
  p(StatisticChartViewOld paramStatisticChartViewOld)
  {
  }

  public final void onFinish()
  {
    Debug.i("Chart.StatisticChartView", "Scroll OnFinish!!");
    StatisticChartViewOld.d(this.a).onToItem(((StatisticChartOld)StatisticChartViewOld.a(this.a)).itemOffset());
    if (StatisticChartViewOld.e(this.a))
      StatisticChartViewOld.a(this.a, false);
    StatisticChartViewOld.a(this.a, 0);
  }

  public final void onJustify()
  {
    Debug.i("Chart.StatisticChartView", "Scroll OnJustify!!");
    if (Math.abs(StatisticChartViewOld.b(this.a)) > 1)
      StatisticChartViewOld.c(this.a).scrollX(((StatisticChartOld)StatisticChartViewOld.a(this.a)).justified());
  }

  public final boolean onScrollX(int paramInt)
  {
    ((StatisticChartOld)StatisticChartViewOld.a(this.a)).scroll(paramInt);
    this.a.postInvalidateOnAnimation();
    StatisticChartViewOld localStatisticChartViewOld = this.a;
    StatisticChartViewOld.a(localStatisticChartViewOld, paramInt + StatisticChartViewOld.b(localStatisticChartViewOld));
    return true;
  }

  public final boolean onScrollY(int paramInt)
  {
    return true;
  }

  public final void onStart()
  {
    Debug.i("Chart.StatisticChartView", "Scroll OnStart!!");
    StatisticChartViewOld.a(this.a, true);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.p
 * JD-Core Version:    0.6.2
 */