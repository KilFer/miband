package cn.com.smartdevices.bracelet.ui;

import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

final class bB extends AsyncTask<String, String, String>
{
  private bB(SettingFragment paramSettingFragment)
  {
  }

  private String a()
  {
    MiLiProfile localMiLiProfile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
    int i = 0;
    while (true)
    {
      if (i >= 10);
      while (true)
      {
        return null;
        if (!isCancelled())
          break;
        Debug.i("SettingFragment", "ShowOffNofifyTask isCancelled");
      }
      localMiLiProfile._sendNotification((byte)0);
      Debug.i("SettingFragment", "vibrate : " + i);
      try
      {
        Thread.sleep(3000L);
        i++;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          localInterruptedException.printStackTrace();
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bB
 * JD-Core Version:    0.6.2
 */