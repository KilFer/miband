package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.DynamicDetailChartView;
import cn.com.smartdevices.bracelet.chart.data.ChartDataLoader;

final class L extends Handler
{
  L(DynamicDetailFragment paramDynamicDetailFragment)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    DynamicDetailFragment.a(this.a, DynamicDetailFragment.a(this.a).getToday());
    DynamicDetailFragment.b(this.a, DynamicDetailFragment.a(this.a).getCurDay());
    DynamicDetailFragment.c(this.a, DynamicDetailFragment.b(this.a));
    DynamicDetailFragment.d(this.a, DynamicDetailFragment.a(this.a).getStartDay());
    DynamicDetailFragment.e(this.a, DynamicDetailFragment.a(this.a).getStopDay());
    Debug.i("Dynamic.Detail", "Today : " + DynamicDetailFragment.c(this.a) + " , StartDay : " + DynamicDetailFragment.d(this.a) + " , StopDay : " + DynamicDetailFragment.e(this.a) + " , CurrentDay : " + DynamicDetailFragment.f(this.a));
    DynamicDetailFragment.g(this.a).getDataLoader().cancel();
    DynamicDetailFragment.g(this.a).clearData();
    if (DynamicDetailFragment.h(this.a) == 16)
      DynamicDetailFragment.g(this.a).loadDynamicData(0, new int[] { -1 });
    while (DynamicDetailFragment.h(this.a) != 1)
      return;
    DynamicDetailFragment.g(this.a).loadDynamicData(0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.L
 * JD-Core Version:    0.6.2
 */