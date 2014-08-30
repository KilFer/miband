package cn.com.smartdevices.bracelet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SystemBindReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (!str.equals("com.xiaomi.hm.health.ACTION_DEVICE_BIND_APPLICATION"))
      str.equals("com.xiaomi.hm.health.ACTION_DEVICE_UNBIND_APPLICATION");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.SystemBindReceiver
 * JD-Core Version:    0.6.2
 */