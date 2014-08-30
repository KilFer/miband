package cn.com.smartdevices.bracelet.ui;

import android.view.ViewTreeObserver.OnPreDrawListener;
import cn.com.smartdevices.bracelet.eventbus.EventBtOnOff;
import de.greenrobot.event.EventBus;

final class aB
  implements ViewTreeObserver.OnPreDrawListener
{
  aB(MainUIActivity paramMainUIActivity)
  {
  }

  public final boolean onPreDraw()
  {
    if (MainUIActivity.o(this.a))
      return true;
    MainUIActivity.b(this.a, true);
    EventBus.getDefault().registerSticky(this.a, "onBleStatusChanged", BaseSCActivity.ConnStatus.class, new Class[0]);
    EventBus.getDefault().register(this.a, "onBtOnOff", EventBtOnOff.class, new Class[0]);
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aB
 * JD-Core Version:    0.6.2
 */