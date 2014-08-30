package cn.com.smartdevices.bracelet.chart.deprecated;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;

final class k extends Handler
{
  k(DynamicDetailFragmentOld paramDynamicDetailFragmentOld)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    if (DynamicDetailFragmentOld.f(this.a) == null)
      DynamicDetailFragmentOld.c(this.a, DynamicDetailFragmentOld.e(this.a).getToday());
    if (DynamicDetailFragmentOld.a(this.a) == null)
      DynamicDetailFragmentOld.a(this.a, DynamicDetailFragmentOld.e(this.a).getCurDay());
    DynamicDetailFragmentOld.d(this.a, DynamicDetailFragmentOld.a(this.a));
    DynamicDetailFragmentOld.e(this.a, DynamicDetailFragmentOld.e(this.a).getStartDay());
    DynamicDetailFragmentOld.f(this.a, DynamicDetailFragmentOld.e(this.a).getStopDay());
    Debug.i("DDDD", "Today : " + DynamicDetailFragmentOld.f(this.a) + " , StartDay : " + DynamicDetailFragmentOld.b(this.a) + " , StopDay : " + DynamicDetailFragmentOld.c(this.a) + " , CurrentDay : " + DynamicDetailFragmentOld.h(this.a));
    DynamicDetailFragmentOld.g(this.a).clearData();
    DynamicDetailFragmentOld.g(this.a).loadDayActiveData(0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.k
 * JD-Core Version:    0.6.2
 */