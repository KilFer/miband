package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.BleTask.BleInComingCallTask;
import java.util.TimerTask;

final class d extends TimerTask
{
  public final void run()
  {
    new BleInComingCallTask(null).work();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.d
 * JD-Core Version:    0.6.2
 */