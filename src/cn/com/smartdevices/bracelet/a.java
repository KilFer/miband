package cn.com.smartdevices.bracelet;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.hm.bleservice.BLEService.BLEServiceBinder;

final class a
  implements ServiceConnection
{
  a(BraceletApp paramBraceletApp)
  {
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if ((paramIBinder instanceof BLEService.BLEServiceBinder))
      BraceletApp.BLEService = ((BLEService.BLEServiceBinder)paramIBinder).getService();
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    BraceletApp.BLEService = null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.a
 * JD-Core Version:    0.6.2
 */