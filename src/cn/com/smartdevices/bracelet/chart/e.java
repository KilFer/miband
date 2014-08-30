package cn.com.smartdevices.bracelet.chart;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.base.ChartScroller.ScrollingListener;

final class e
  implements ChartScroller.ScrollingListener
{
  e(DynamicDetailChartView paramDynamicDetailChartView)
  {
  }

  public final void onFinish()
  {
    Debug.i("Chart.DynamicDetailChartView", "Scroll OnFinish!!");
  }

  public final void onJustify()
  {
    Debug.i("Chart.DynamicDetailChartView", "Scroll OnJustify!!");
  }

  public final boolean onScrollX(int paramInt)
  {
    return false;
  }

  public final boolean onScrollY(int paramInt)
  {
    int i = (int)((DynamicDetailChart)DynamicDetailChartView.a(this.a)).getScroll();
    int j = (int)((DynamicDetailChart)DynamicDetailChartView.a(this.a)).getEdgeLength();
    Debug.i("Chart.DynamicDetailChartView", "Scrolled : " + i + " Edge : " + j + " Distance : " + paramInt);
    if (((i == 0) && (paramInt > 0)) || ((i == j) && (paramInt < 0)))
      return false;
    ((DynamicDetailChart)DynamicDetailChartView.a(this.a)).scroll(paramInt);
    this.a.postInvalidateOnAnimation();
    return true;
  }

  public final void onStart()
  {
    Debug.i("Chart.DynamicDetailChartView", "Scroll OnStart!!");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.e
 * JD-Core Version:    0.6.2
 */