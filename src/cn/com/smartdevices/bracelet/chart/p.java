package cn.com.smartdevices.bracelet.chart;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller.ScrollingListener;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;

final class p
  implements ChartScroller.ScrollingListener
{
  p(StatisticChartView paramStatisticChartView)
  {
  }

  public final void onFinish()
  {
    Debug.i("Chart.StatisticChartView", "Scroll OnFinish!!");
    StatisticChartView.d(this.a).onToItem(((StatisticChart)StatisticChartView.a(this.a)).itemOffset());
    if (StatisticChartView.e(this.a))
      StatisticChartView.a(this.a, false);
    StatisticChartView.a(this.a, 0);
  }

  public final void onJustify()
  {
    Debug.i("Chart.StatisticChartView", "Scroll OnJustify!!");
    if (Math.abs(StatisticChartView.b(this.a)) > 1)
      StatisticChartView.c(this.a).scrollX(((StatisticChart)StatisticChartView.a(this.a)).justified());
  }

  public final boolean onScrollX(int paramInt)
  {
    ((StatisticChart)StatisticChartView.a(this.a)).scroll(paramInt);
    this.a.postInvalidateOnAnimation();
    StatisticChartView localStatisticChartView = this.a;
    StatisticChartView.a(localStatisticChartView, paramInt + StatisticChartView.b(localStatisticChartView));
    return true;
  }

  public final boolean onScrollY(int paramInt)
  {
    return true;
  }

  public final void onStart()
  {
    Debug.i("Chart.StatisticChartView", "Scroll OnStart!!");
    StatisticChartView.a(this.a, true);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.p
 * JD-Core Version:    0.6.2
 */