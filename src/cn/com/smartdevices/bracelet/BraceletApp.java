package cn.com.smartdevices.bracelet;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import cn.com.smartdevices.bracelet.chart.typeface.MIUITextStyleExtractor;
import cn.com.smartdevices.bracelet.chart.typeface.TypefaceManager;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import com.xiaomi.hm.bleservice.BLEService;
import java.io.File;
import java.util.UUID;

public class BraceletApp extends Application
{
  public static BLEService BLEService = null;
  private static final String a = "Millelet";
  private static final String b = "BraceletApp";
  private ServiceConnection c = new a(this);

  public void finishBLEService()
  {
    unbindService(this.c);
    stopService(new Intent(this, BLEService.class));
  }

  public String getStoragePath()
  {
    String str1 = Environment.getExternalStorageState();
    Debug.i("BraceletApp", "ext state =" + str1);
    if ("mounted".equals(str1));
    for (File localFile = getExternalFilesDir("Millelet"); ; localFile = getFilesDir())
    {
      if (localFile == null)
        localFile = getFilesDir();
      if (localFile != null)
        break;
      return Environment.getExternalStorageDirectory().getPath() + "/Millelet";
    }
    String str2 = localFile.getPath();
    Debug.i("BraceletApp", "getStoragePath:" + str2);
    return str2;
  }

  public void onCreate()
  {
    super.onCreate();
    Keeper.init(this);
    Debug.enable(Keeper.readDebugFlag(), Keeper.readFileDebugFlag());
    DataManager.init(this);
    BraceletImageLoader.init(this);
    DaoManager.init(this);
    WebRes.init(this);
    startBLEService();
    String str1 = Keeper.readUUID();
    if ((str1 == null) || (str1.length() <= 0))
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)getSystemService("phone");
      String str2 = localTelephonyManager.getDeviceId();
      String str3 = localTelephonyManager.getSimSerialNumber();
      String str4 = Settings.Secure.getString(getContentResolver(), "android_id");
      String str5 = BluetoothAdapter.getDefaultAdapter().getAddress();
      UUID localUUID = new UUID(str5.hashCode() | str4.hashCode(), str2.hashCode() | str3.hashCode());
      Debug.f("BraceletApp", "\ndeviceId:" + str2 + "\nserialNum:" + str3 + "\nandroidId:" + str4 + "\nmacAddress:" + str5 + "\nuuid:" + localUUID.toString());
      Keeper.keepUUID(localUUID.toString());
    }
    TypefaceManager.addTextStyleExtractor(MIUITextStyleExtractor.getInstance());
    UmengAnalytics.config(true, false, false);
  }

  public void startBLEService()
  {
    BLEService = null;
    Intent localIntent = new Intent(this, BLEService.class);
    startService(localIntent);
    bindService(localIntent, this.c, 1);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BraceletApp
 * JD-Core Version:    0.6.2
 */