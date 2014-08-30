package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleFwUpgradeTask;
import cn.com.smartdevices.bracelet.BleTask.BleSetDesiredLatency;
import cn.com.smartdevices.bracelet.BleTask.BleTogglePairTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

public abstract class BaseBleActivity extends Activity
{
  public static final int MSG_UPDATE_PRESSED_TIME = 520;
  public static final int UPDATE_PRESSED_TIMEOUT = 2000;
  private static final int a = 1;
  private static final int b = 2;
  private static final int c = 3;
  private static final int d = 4;
  private static final int e = 5;
  private static final int f = 8;
  private static final int g = 10;
  private static final int h = 11;
  private static final int i = 12;
  private static final int j = 13;
  private static int o = -1;
  private long k = -1L;
  private Handler l = null;
  private BroadcastReceiver m = null;
  private String n = "BaseBleActivity";
  private boolean p = false;
  private int q = 1;
  private int r = -1;

  private void a()
  {
    this.l = new j(this);
    this.m = new k(this);
    IntentFilter localIntentFilter1 = new IntentFilter();
    localIntentFilter1.addAction(BLEService.INTENT_ACTION_DEVICE_FOUND);
    localIntentFilter1.addAction(MiLiProfile.INTENT_ACTION_DEVICE_STATUS_CHANGED);
    localIntentFilter1.addAction(BLEService.INTENT_ACTION_DEVICE_CONNECTED);
    localIntentFilter1.addAction(MiLiProfile.INTENT_ACTION_INITIALIZATION_SUCCESS);
    localIntentFilter1.addAction(MiLiProfile.INTENT_ACTION_INITIALIZATION_FAILED);
    localIntentFilter1.addAction(BLEService.INTENT_ACTION_DEVICE_DISCONNECTED);
    localIntentFilter1.addAction(BLEService.INTENT_ACTION_DEVICE_CONNECTION_FAILED);
    localIntentFilter1.addAction(MiLiProfile.INTENT_ACTION_DEVICE_BATTERY_STATUS_CHANGED);
    LocalBroadcastManager.getInstance(this).registerReceiver(this.m, localIntentFilter1);
    IntentFilter localIntentFilter2 = new IntentFilter();
    localIntentFilter2.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    registerReceiver(this.m, localIntentFilter2);
  }

  private void a(int paramInt)
  {
    Debug.f(this.n, "onBatteryLowNotification:" + paramInt);
    if (this.r == paramInt)
      return;
    this.r = paramInt;
    NotificationManager localNotificationManager = (NotificationManager)getSystemService("notification");
    String str1 = getString(2131492933);
    String str2 = getString(2131492934);
    if (paramInt == 0)
    {
      str1 = getString(2131492935);
      str2 = getString(2131492936);
    }
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this).setSmallIcon(2130837508).setContentTitle(str1).setContentText(str2).setAutoCancel(true);
    localBuilder.setVibrate(new long[] { 100L, 500L, 500L, 500L });
    localBuilder.setContentIntent(PendingIntent.getBroadcast(this, 0, new Intent("ACTION_BATTERY_LOW"), 268435456));
    localNotificationManager.notify(this.q, localBuilder.build());
  }

  private void b()
  {
    ((NotificationManager)getSystemService("notification")).cancel(this.q);
  }

  private void b(int paramInt)
  {
    Debug.i(this.n, "onDeviceStatusChanged:" + paramInt);
    Debug.f(this.n, "onDeviceStatusChanged:" + paramInt);
    switch (paramInt)
    {
    case 3:
    case 4:
    case 7:
    default:
      return;
    case 8:
      onDeviceSetLatencySuccess();
      return;
    case 1:
      onFwUpgradeFailed();
      return;
    case 2:
      onFwUpgradeSuccess();
      return;
    case 6:
      onAuthenticationFailed();
      return;
    case 5:
      onAuthenticationSuccess();
      return;
    case 11:
      onSendFwInfoFailed();
      return;
    case 12:
      onSendFwInfoSuccess();
      return;
    case 9:
      onResetAuthenticationFailed();
      return;
    case 10:
    }
    onResetAuthentiacationSuccess();
  }

  private void c()
  {
    new BleTogglePairTask(Keeper.readPersonInfo(), new l(this)).work();
  }

  public static int getDeviceStatus()
  {
    if (BraceletApp.BLEService != null)
    {
      if ((MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral() != null)
        return o;
      return -1;
    }
    return -1;
  }

  public static int getProfileStatus()
  {
    if (BraceletApp.BLEService != null)
    {
      MiLiProfile localMiLiProfile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
      if (localMiLiProfile != null)
      {
        int i1 = localMiLiProfile.getProfileState();
        if (i1 == 1)
          return 0;
        if (i1 == 2)
          return 1;
        if (i1 == 0)
          return -1;
      }
    }
    return -1;
  }

  public void onAuthenticationFailed()
  {
    BleTogglePairTask.waitingNotify(Integer.valueOf(6));
  }

  public void onAuthenticationSuccess()
  {
    BleTogglePairTask.waitingNotify(Integer.valueOf(5));
    setLatency(39);
  }

  public void onBackPressed()
  {
    long l1 = System.currentTimeMillis();
    if (this.k == -1L)
    {
      Toast.makeText(this, 2131493083, 0).show();
      this.k = l1;
      this.l.sendEmptyMessageDelayed(520, 2000L);
    }
    while (l1 - this.k >= 2000L)
      return;
    this.k = -1L;
    onHideApp();
  }

  public void onBtOff()
  {
  }

  public void onBtOn()
  {
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Debug.i(this.n, "onCreate");
    this.l = new j(this);
    this.m = new k(this);
    IntentFilter localIntentFilter1 = new IntentFilter();
    localIntentFilter1.addAction(BLEService.INTENT_ACTION_DEVICE_FOUND);
    localIntentFilter1.addAction(MiLiProfile.INTENT_ACTION_DEVICE_STATUS_CHANGED);
    localIntentFilter1.addAction(BLEService.INTENT_ACTION_DEVICE_CONNECTED);
    localIntentFilter1.addAction(MiLiProfile.INTENT_ACTION_INITIALIZATION_SUCCESS);
    localIntentFilter1.addAction(MiLiProfile.INTENT_ACTION_INITIALIZATION_FAILED);
    localIntentFilter1.addAction(BLEService.INTENT_ACTION_DEVICE_DISCONNECTED);
    localIntentFilter1.addAction(BLEService.INTENT_ACTION_DEVICE_CONNECTION_FAILED);
    localIntentFilter1.addAction(MiLiProfile.INTENT_ACTION_DEVICE_BATTERY_STATUS_CHANGED);
    LocalBroadcastManager.getInstance(this).registerReceiver(this.m, localIntentFilter1);
    IntentFilter localIntentFilter2 = new IntentFilter();
    localIntentFilter2.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    registerReceiver(this.m, localIntentFilter2);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    Debug.i(this.n, "onDestory");
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.m);
    unregisterReceiver(this.m);
    this.l.removeCallbacksAndMessages(null);
    this.l = null;
    o = -1;
    this.r = -1;
  }

  public void onDeviceBatteryStatusChanged(byte paramByte, int paramInt)
  {
    Debug.i(this.n, "onDeviceBatteryStatusChanged:" + paramByte + "," + paramInt);
    Debug.f(this.n, "onDeviceBatteryStatusChanged:" + paramByte + "," + paramInt);
    if (paramByte == 1)
    {
      Debug.f(this.n, "onBatteryLowNotification:" + paramInt);
      if (this.r != paramInt)
      {
        this.r = paramInt;
        localNotificationManager = (NotificationManager)getSystemService("notification");
        str1 = getString(2131492933);
        str2 = getString(2131492934);
        if (paramInt == 0)
        {
          str1 = getString(2131492935);
          str2 = getString(2131492936);
        }
        localBuilder = new NotificationCompat.Builder(this).setSmallIcon(2130837508).setContentTitle(str1).setContentText(str2).setAutoCancel(true);
        localBuilder.setVibrate(new long[] { 100L, 500L, 500L, 500L });
        localBuilder.setContentIntent(PendingIntent.getBroadcast(this, 0, new Intent("ACTION_BATTERY_LOW"), 268435456));
        localNotificationManager.notify(this.q, localBuilder.build());
      }
    }
    while (paramByte != 2)
    {
      NotificationManager localNotificationManager;
      String str1;
      String str2;
      NotificationCompat.Builder localBuilder;
      return;
    }
    ((NotificationManager)getSystemService("notification")).cancel(this.q);
  }

  public void onDeviceConnected()
  {
    this.p = false;
    o = 4;
  }

  public void onDeviceConnectionFailed()
  {
    this.p = false;
    o = 5;
  }

  public void onDeviceDisconnected()
  {
    this.p = false;
    o = 6;
  }

  public abstract void onDeviceFound(BluetoothDevice paramBluetoothDevice, int paramInt);

  public void onDeviceSetLatencySuccess()
  {
    BleSetDesiredLatency.waitingNotify(Integer.valueOf(8));
  }

  public void onFwUpgradeFailed()
  {
    BleFwUpgradeTask.waitingNotify(Integer.valueOf(1));
  }

  public void onFwUpgradeSuccess()
  {
    BleFwUpgradeTask.waitingNotify(Integer.valueOf(2));
  }

  protected void onHideApp()
  {
    moveTaskToBack(true);
  }

  public void onInitializationFailed()
  {
    this.p = false;
    o = 1;
  }

  public void onInitializationSuccess()
  {
    if (!this.p)
    {
      this.p = true;
      o = 0;
      new BleTogglePairTask(Keeper.readPersonInfo(), new l(this)).work();
    }
  }

  public void onResetAuthentiacationSuccess()
  {
    BleTogglePairTask.waitingNotify(Integer.valueOf(10));
    setLatency(39);
  }

  public void onResetAuthenticationFailed()
  {
    BleTogglePairTask.waitingNotify(Integer.valueOf(9));
  }

  public void onSendFwInfoFailed()
  {
    BleFwUpgradeTask.waitingNotify(Integer.valueOf(11));
  }

  public void onSendFwInfoSuccess()
  {
    BleFwUpgradeTask.waitingNotify(Integer.valueOf(12));
  }

  public void onTogglePairProgress(int paramInt)
  {
  }

  public void onTogglePairResult(IMiLiProfile.DeviceInfo paramDeviceInfo)
  {
  }

  protected void setLatency(int paramInt)
  {
    Debug.f(this.n, "current latency level set level:" + paramInt);
    PowerManager.WakeLock localWakeLock = ((PowerManager)getSystemService("power")).newWakeLock(1, "setLatency");
    Debug.f(this.n, "waklock acquire......" + paramInt);
    localWakeLock.acquire();
    new BleSetDesiredLatency(paramInt, new m(this, paramInt, localWakeLock)).workX();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.BaseBleActivity
 * JD-Core Version:    0.6.2
 */