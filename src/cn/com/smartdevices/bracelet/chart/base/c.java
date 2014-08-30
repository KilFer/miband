package cn.com.smartdevices.bracelet.chart.base;

import android.os.Handler;
import android.os.Message;
import android.widget.Scroller;

final class c extends Handler
{
  c(ChartScroller paramChartScroller)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    ChartScroller.a(this.a).computeScrollOffset();
    int i = ChartScroller.a(this.a).getCurrX();
    int j = ChartScroller.b(this.a) - i;
    ChartScroller.a(this.a, i);
    if (j != 0)
      ChartScroller.d(this.a).onScrollX(j);
    int k = ChartScroller.a(this.a).getCurrY();
    int m = ChartScroller.c(this.a) - k;
    ChartScroller.b(this.a, k);
    if (m != 0)
      ChartScroller.d(this.a).onScrollY(m);
    if ((ChartScroller.e(this.a)) && (Math.abs(i - ChartScroller.a(this.a).getFinalX()) <= 0))
    {
      ChartScroller.a(this.a).getFinalX();
      ChartScroller.a(this.a).forceFinished(true);
    }
    if ((!ChartScroller.e(this.a)) && (Math.abs(k - ChartScroller.a(this.a).getFinalY()) <= 0))
    {
      ChartScroller.a(this.a).getFinalY();
      ChartScroller.a(this.a).forceFinished(true);
    }
    if (!ChartScroller.a(this.a).isFinished())
    {
      ChartScroller.f(this.a).sendEmptyMessage(paramMessage.what);
      return;
    }
    if (paramMessage.what == 0)
    {
      ChartScroller.g(this.a);
      return;
    }
    this.a.a();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.base.c
 * JD-Core Version:    0.6.2
 */