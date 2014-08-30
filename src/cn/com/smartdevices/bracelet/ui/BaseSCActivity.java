package cn.com.smartdevices.bracelet.ui;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleStatisticTask;
import cn.com.smartdevices.bracelet.BleTask.BleStopSynDataTask;
import cn.com.smartdevices.bracelet.BleTask.BleSyncDataTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.analysis.ActiveItem;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import cn.com.smartdevices.bracelet.eventbus.EventBatteryStatus;
import cn.com.smartdevices.bracelet.eventbus.EventBtOnOff;
import cn.com.smartdevices.bracelet.lua.LuaEvent;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ReportData;
import cn.com.smartdevices.bracelet.model.ReportInfo;
import cn.com.smartdevices.bracelet.model.SportDay;
import cn.com.smartdevices.bracelet.model.UploadData;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.Progress;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import de.greenrobot.event.EventBus;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;

public class BaseSCActivity extends BaseBleActivity
{
  private static final int a = 8193;
  private static final int b = 10000;
  private static final int c = 12;
  private static final int d = 1;
  private static final int e = 4096;
  private static final int f = 4097;
  private static final int g = 4098;
  private static final int h = 4099;
  private static final int i = 4104;
  private static final int j = 4112;
  private static final int k = 4113;
  public static BaseSCActivity.ConnStatus mConnStatus = new BaseSCActivity.ConnStatus();
  private float A = 1.0F;
  private int B = 1;
  private boolean C = false;
  private Handler l = null;
  private BraceletBtInfo m;
  private int n = 0;
  private final int o;
  private String p = "BaseSCActivity";
  private BroadcastReceiver q = null;
  private Context r = null;
  private boolean s = false;
  private int t = 12;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private float z = 0.0F;

  private void a()
  {
    Debug.i(this.p, "==============================enterInForeground==========================");
    Debug.f(this.p, "==============================enterInForeground==========================");
    this.x = false;
    e();
  }

  private void a(int paramInt1, int paramInt2)
  {
    new Thread(new v(this, 0, 0)).start();
  }

  private void a(int paramInt, Object paramObject)
  {
    Debug.i(this.p, "onStatusChanged:" + paramInt);
    mConnStatus.a = paramInt;
    mConnStatus.b = paramObject;
    IMiLiProfile.Progress localProgress;
    int i1;
    switch (paramInt)
    {
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    default:
    case 9:
    case 10:
      while (true)
      {
        BaseSCActivity.ConnStatus localConnStatus = new BaseSCActivity.ConnStatus();
        localConnStatus.b = mConnStatus.b;
        localConnStatus.a = mConnStatus.a;
        EventBus.getDefault().postSticky(localConnStatus);
        return;
        this.s = false;
        this.t = 12;
        if (this.l != null)
        {
          this.l.sendEmptyMessageDelayed(4112, 1000L);
          continue;
          MiLiProfile localMiLiProfile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
          localProgress = localMiLiProfile.getActivitySyncingProgress();
          if (localProgress.total != -1)
            break;
          this.t = (-1 + this.t);
          if (this.t > 0)
            break label454;
          Debug.i(this.p, "sync data block for 12s,quit now!!!");
          mConnStatus.b = Integer.valueOf(0);
          localMiLiProfile.stopGetActivities();
          new BleStopSynDataTask(null).work();
        }
      }
      if (localProgress.total == 0)
      {
        this.t = 12;
        i1 = 100;
      }
      break;
    case 11:
    }
    while (true)
    {
      Debug.i(this.p, "sync data progress:" + localProgress.toString() + ", " + i1 + "%");
      if (i1 < (int)this.z)
        i1 = (int)this.z;
      mConnStatus.b = Integer.valueOf(i1);
      if ((this.s) || (this.l == null))
        break;
      this.l.sendEmptyMessageDelayed(4112, 1000L);
      break;
      this.t = 12;
      i1 = 100 * localProgress.progress / localProgress.total;
      continue;
      this.l.removeMessages(4113);
      this.z = 0.0F;
      this.t = 12;
      this.s = true;
      if (this.l == null)
        break;
      this.l.removeMessages(4112);
      this.l.sendEmptyMessage(4099);
      break;
      label454: i1 = 0;
    }
  }

  private void a(String paramString)
  {
    Debug.i(this.p, "bracelet statistic info:" + paramString);
    WebAPI.statisticBracelet(Keeper.readLoginData(), Keeper.readDeviceId(), paramString, new q(this));
  }

  private void a(boolean paramBoolean)
  {
    String str = Keeper.readLastWeekReportDate();
    ReportData localReportData = DataManager.getInstance().getLastWeekReportData();
    Debug.i("chenee", localReportData.toString());
    if ((!paramBoolean) && ((!localReportData.isValid()) || ((str != null) && (str.equals(localReportData.timeFrom)))))
      return;
    Keeper.KeepLastWeekReportDate(localReportData.timeFrom);
    Debug.i("chenee", "set week report .........................");
    LuaEvent.getInstance(this).setWeekReport(localReportData);
  }

  private boolean a(Context paramContext)
  {
    Debug.i(this.p, "in isBLEServiceRunning............");
    Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647).iterator();
    ActivityManager.RunningServiceInfo localRunningServiceInfo;
    do
    {
      if (!localIterator.hasNext())
        return false;
      localRunningServiceInfo = (ActivityManager.RunningServiceInfo)localIterator.next();
    }
    while ((!localRunningServiceInfo.service.getPackageName().equals(getPackageName())) || (!BLEService.class.getName().equals(localRunningServiceInfo.service.getClassName())));
    return true;
  }

  private void b()
  {
    Debug.i(this.p, "==============================enterInBackground==========================");
    Debug.f(this.p, "==============================enterInBackground==========================");
    this.x = true;
    if (Utils.isBinded())
    {
      d();
      c();
    }
  }

  private void b(boolean paramBoolean)
  {
    String str = Keeper.readLastMonthReportDate();
    ReportData localReportData = DataManager.getInstance().getLastMonthReportData();
    Debug.i("chenee", localReportData.toString());
    if ((!paramBoolean) && ((!localReportData.isValid()) || ((str != null) && (str.equals(localReportData.timeFrom)))))
      return;
    Keeper.KeepLastMonthReportDate(localReportData.timeFrom);
    Debug.i("chenee", "set Month report .........................");
    LuaEvent.getInstance(this).setMonthReport(localReportData);
  }

  private void c()
  {
    AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
    Intent localIntent = new Intent();
    localIntent.setAction("com.xiaomi.hm.health.set_max_latency");
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(this, 0, localIntent, 0);
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAlarmManager.setExact(2, 120000L + SystemClock.elapsedRealtime(), localPendingIntent);
      return;
    }
    localAlarmManager.set(2, 120000L + SystemClock.elapsedRealtime(), localPendingIntent);
  }

  private void c(boolean paramBoolean)
  {
    ReportInfo localReportInfo1 = Keeper.readContinueReachGoalRi();
    ReportData localReportData = DataManager.getInstance().getContinueReachGoalReportData();
    if (!localReportData.isValid());
    ReportInfo localReportInfo2;
    do
    {
      return;
      localReportInfo2 = new ReportInfo();
      localReportInfo2.date = localReportData.timeTo;
      localReportInfo2.reportDate = new SportDay().getKey();
      Debug.i("chenee", localReportInfo1.reportDate + "," + localReportInfo2.reportDate);
    }
    while ((!paramBoolean) && (localReportInfo1.reportDate.equals(localReportInfo2.reportDate)) && (localReportInfo1.date.equals(localReportData.timeTo)));
    Debug.i("chenee", localReportData.toString());
    Keeper.keepContinueReachGoalRi(localReportInfo2);
    Debug.i("chenee", "continue reach goal report .........................");
    LuaEvent.getInstance(this).setContinueReport(localReportData);
  }

  private void d()
  {
    AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
    Intent localIntent = new Intent();
    localIntent.setAction("com.xiaomi.hm.health.set_max_latency");
    localAlarmManager.cancel(PendingIntent.getBroadcast(this, 0, localIntent, 0));
  }

  private void e()
  {
    Debug.i(this.p, "in initBleStatus......");
    Utils.setAutoReconnect(true);
    d();
    Debug.i(this.p, "in isBLEServiceRunning............");
    Iterator localIterator = ((ActivityManager)getSystemService("activity")).getRunningServices(2147483647).iterator();
    int i1;
    if (!localIterator.hasNext())
    {
      i1 = 0;
      label61: if (i1 != 0)
        break label140;
      Debug.i(this.p, "BLEService not running......");
      ((BraceletApp)getApplication()).startBLEService();
      startScanBracelet();
    }
    label140: int i2;
    do
    {
      return;
      ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)localIterator.next();
      if ((!localRunningServiceInfo.service.getPackageName().equals(getPackageName())) || (!BLEService.class.getName().equals(localRunningServiceInfo.service.getClassName())))
        break;
      i1 = 1;
      break label61;
      i2 = getDeviceStatus();
      int i3 = getProfileStatus();
      Debug.i(this.p, "profileStatus:" + i3 + ",deviceStatus:" + i2 + ",connStatus:" + mConnStatus.a);
      Debug.f(this.p, "profileStatus:" + i3 + ",deviceStatus:" + i2 + ",connStatus:" + mConnStatus.a);
      if (i3 != 0)
        break label300;
    }
    while ((mConnStatus.a != -1) && (mConnStatus.a != 8) && (mConnStatus.a != 11));
    setLatency(39);
    f();
    return;
    label300: if ((i2 == -1) && (mConnStatus.a != 3))
    {
      startScanBracelet();
      return;
    }
    a(3, null);
  }

  private void f()
  {
    Debug.i(this.p, "mHandler:" + this.l);
    Debug.f(this.p, "mHandler:" + this.l);
    if (this.l == null);
    do
    {
      return;
      Debug.i(this.p, "last sync time:" + new Date(Keeper.readSyncTime()).toLocaleString() + ",current time:" + new Date().toLocaleString());
      Debug.f(this.p, "last sync time:" + new Date(Keeper.readSyncTime()).toLocaleString() + ",current time:" + new Date().toLocaleString());
    }
    while ((!j()) && (System.currentTimeMillis() - Keeper.readSyncTime() <= 120000L));
    this.B = 1;
    this.l.removeMessages(4104);
    this.l.sendEmptyMessage(4104);
  }

  private void g()
  {
    this.l = new n(this);
    this.q = new o(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    localIntentFilter.addAction("com.xiaomi.hm.health.set_max_latency");
    registerReceiver(this.q, localIntentFilter);
  }

  private static float h()
  {
    long l1 = Keeper.readSyncTime();
    float f1 = 1.0F;
    if (l1 != -1L)
      f1 = 100.0F / (8 + (int)(1.0D + 0.12D * (2 + (1 + 3 * (int)((System.currentTimeMillis() - l1) / 60000L) / 20))));
    return f1;
  }

  private void i()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, FwUpgradeActivity.class);
    startActivity(localIntent);
  }

  private boolean j()
  {
    if (!Utils.isBraceletConnected())
      return false;
    int i1;
    IMiLiProfile.DeviceInfo localDeviceInfo;
    try
    {
      InputStream localInputStream = getResources().getAssets().open("Mili.fw");
      Debug.i(this.p, "new fw length:" + localInputStream.available());
      byte[] arrayOfByte = new byte[localInputStream.available()];
      localInputStream.read(arrayOfByte);
      localInputStream.close();
      i1 = Utils.getFwVersion(arrayOfByte);
      localDeviceInfo = ((MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral()).getCachedDeviceInfo();
      if (localDeviceInfo == null)
        return false;
    }
    catch (Exception localException)
    {
      Debug.i(this.p, localException.getMessage());
      return false;
    }
    Debug.i(this.p, "new fw version:" + i1 + ",fw version:" + localDeviceInfo.firmwareVersion + ",pcb version:" + localDeviceInfo.hardwareVersion);
    if (i1 <= localDeviceInfo.firmwareVersion)
    {
      Debug.i(this.p, "bracelet firmware is the lastest,do nothing!");
      return false;
    }
    if (localDeviceInfo.hardwareVersion != 2)
    {
      Debug.i(this.p, "bracelet PCBVersion is : " + localDeviceInfo.hardwareVersion + ", not PCB 1.4,do nothing!");
      return false;
    }
    return true;
  }

  private void k()
  {
    int i1 = 0;
    int i2 = 1;
    NetworkInfo[] arrayOfNetworkInfo = ((ConnectivityManager)this.r.getSystemService("connectivity")).getAllNetworkInfo();
    for (int i3 = 0; ; i3++)
    {
      if (i3 >= arrayOfNetworkInfo.length)
        i2 = 0;
      while (true)
      {
        if ((i1 != 0) && (i2 != 0) && (Keeper.readPersonInfo().getNeedSyncServer() != 0))
        {
          Debug.i(this.p, "Sync person info when net connected");
          Utils.updateProfile(Keeper.readPersonInfo());
        }
        return;
        if (arrayOfNetworkInfo[i3].getType() == i2)
        {
          if (!arrayOfNetworkInfo[i3].isConnected())
            break;
          i1 = i2;
        }
        else if (arrayOfNetworkInfo[i3].getType() == 9)
        {
          if (!arrayOfNetworkInfo[i3].isConnected())
            break;
          i1 = i2;
          i2 = 0;
        }
        else
        {
          if ((arrayOfNetworkInfo[i3].getType() != 0) || (!arrayOfNetworkInfo[i3].isConnected()))
            break;
          i1 = i2;
          i2 = 0;
        }
      }
    }
  }

  private void l()
  {
    if (Keeper.readPersonInfo().getNeedSyncServer() != 0)
    {
      Debug.i(this.p, "Sync person info when net connected");
      Utils.updateProfile(Keeper.readPersonInfo());
    }
  }

  private void m()
  {
    Debug.i(this.p, "in statisticBracelet");
    if (System.currentTimeMillis() - Keeper.readBraceletStatisticTime() < 21600000L);
    while ((!Utils.isBraceletConnected()) || (!Utils.isNetworkConnected(this)))
      return;
    new BleStatisticTask(new p(this)).work();
  }

  private void n()
  {
    DataManager localDataManager = DataManager.getInstance();
    DaySportData localDaySportData = localDataManager.get(localDataManager.getToday());
    LuaEvent localLuaEvent = LuaEvent.getInstance(this);
    if (localDaySportData == null);
    StepsInfo localStepsInfo;
    int i1;
    ReportData localReportData;
    do
    {
      do
      {
        return;
        localStepsInfo = localDaySportData.getStepsInfo();
      }
      while (localStepsInfo == null);
      i1 = localStepsInfo.getStepsCount();
      SportDay localSportDay = DataManager.getInstance().getStartDay();
      if (new SportDay().addDay(-7).compare(localSportDay) <= 0)
        break;
      localReportData = DataManager.getInstance().getStepRecord();
      Debug.i("chenee", localReportData.toString());
    }
    while (i1 <= localReportData.steps);
    Debug.i("chenee", "newRecordReport .........................");
    localReportData.setStepsInfo(localStepsInfo);
    localLuaEvent.setRecord(localReportData);
    return;
    Debug.i("chenee", "newRecordReport do nothing.........................");
  }

  private void o()
  {
    DataManager localDataManager = DataManager.getInstance();
    DaySportData localDaySportData = localDataManager.get(localDataManager.getToday());
    LuaEvent localLuaEvent = LuaEvent.getInstance(this);
    if (localDaySportData == null);
    while (true)
    {
      return;
      StepsInfo localStepsInfo = localDaySportData.getStepsInfo();
      if (localStepsInfo != null)
      {
        ArrayList localArrayList = localStepsInfo.getActiveList();
        Debug.i("chenee", "Dump ActiveList:");
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          ActiveItem localActiveItem = (ActiveItem)localIterator.next();
          if (localActiveItem.flag == 1)
            localLuaEvent.setGoal();
          else
            localLuaEvent.setStep(localActiveItem);
        }
      }
    }
  }

  private void p()
  {
    DataManager localDataManager = DataManager.getInstance();
    ArrayList localArrayList = localDataManager.getNeedSyncDatas();
    if ((localArrayList == null) || (localArrayList.size() <= 0))
      return;
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = localArrayList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        Debug.f(this.p, localJSONArray.toString());
        WebAPI.syncToServer(Keeper.readLoginData(), Keeper.readDeviceId(), 0, 0, localJSONArray.toString(), new u(this, localDataManager, localArrayList));
        return;
      }
      localJSONArray.put(((UploadData)localIterator.next()).toJSONObject());
    }
  }

  private void q()
  {
    this.s = false;
    this.t = 12;
    if (this.l != null)
      this.l.sendEmptyMessageDelayed(4112, 1000L);
  }

  private void r()
  {
    MiLiProfile localMiLiProfile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
    IMiLiProfile.Progress localProgress = localMiLiProfile.getActivitySyncingProgress();
    int i1;
    if (localProgress.total == -1)
    {
      this.t = (-1 + this.t);
      if (this.t <= 0)
      {
        Debug.i(this.p, "sync data block for 12s,quit now!!!");
        mConnStatus.b = Integer.valueOf(0);
        localMiLiProfile.stopGetActivities();
        new BleStopSynDataTask(null).work();
      }
    }
    else if (localProgress.total == 0)
    {
      this.t = 12;
      i1 = 100;
    }
    while (true)
    {
      Debug.i(this.p, "sync data progress:" + localProgress.toString() + ", " + i1 + "%");
      if (i1 < (int)this.z)
        i1 = (int)this.z;
      mConnStatus.b = Integer.valueOf(i1);
      if ((this.s) || (this.l == null))
        break;
      this.l.sendEmptyMessageDelayed(4112, 1000L);
      return;
      this.t = 12;
      i1 = 100 * localProgress.progress / localProgress.total;
      continue;
      i1 = 0;
    }
  }

  private void s()
  {
    this.l.removeMessages(4113);
    this.z = 0.0F;
    this.t = 12;
    this.s = true;
    if (this.l == null)
      return;
    this.l.removeMessages(4112);
    this.l.sendEmptyMessage(4099);
  }

  public void connect(BluetoothDevice paramBluetoothDevice)
  {
    Debug.i(this.p, "connect:" + paramBluetoothDevice.getName() + ":" + paramBluetoothDevice.getAddress());
    if (this.l == null)
      return;
    this.l.removeMessages(4097);
    a(3, null);
    Utils.connect(paramBluetoothDevice, true);
  }

  public boolean enableBluetooth(boolean paramBoolean)
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if ((localBluetoothAdapter != null) && (!localBluetoothAdapter.isEnabled()))
    {
      if ((!paramBoolean) && (this.y))
        return false;
      startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 8193);
      return false;
    }
    return true;
  }

  public void generateSleepReport()
  {
    DataManager localDataManager = DataManager.getInstance();
    DaySportData localDaySportData = localDataManager.get(localDataManager.getToday());
    LuaEvent localLuaEvent = LuaEvent.getInstance(this);
    if (localDaySportData == null);
    SleepInfo localSleepInfo;
    do
    {
      return;
      localSleepInfo = localDaySportData.getSleepInfo();
    }
    while (localSleepInfo == null);
    Debug.i("chenee", "sleep report .........................");
    localLuaEvent.setSleep(localSleepInfo);
  }

  public boolean isApplicationBroughtToBackground(Context paramContext)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localList != null) && (!localList.isEmpty()))
    {
      ComponentName localComponentName = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity;
      Debug.i(this.p, "topActivity:" + localComponentName.flattenToString());
      Debug.f(this.p, "topActivity:" + localComponentName.flattenToString());
      if (!localComponentName.getPackageName().equals(paramContext.getPackageName()))
        return true;
    }
    return false;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Debug.i(this.p, "onActivityResult");
    if (paramInt1 == 8193);
    switch (paramInt2)
    {
    default:
      return;
    case -1:
      e();
      this.y = false;
      return;
    case 0:
    }
    Toast.makeText(this, getString(2131492877), 1).show();
    onBtOff();
    this.y = true;
  }

  public void onBackPressed()
  {
    super.onBackPressed();
  }

  public void onBtOff()
  {
    super.onBtOff();
    EventBus.getDefault().post(new EventBtOnOff(1));
  }

  public void onBtOn()
  {
    super.onBtOn();
    EventBus.getDefault().post(new EventBtOnOff(0));
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.r = this;
    this.w = true;
    Debug.i(this.p, "onCreate:" + mConnStatus);
    this.m = Keeper.readBraceletBtInfo();
    this.l = new n(this);
    this.q = new o(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    localIntentFilter.addAction("com.xiaomi.hm.health.set_max_latency");
    registerReceiver(this.q, localIntentFilter);
    new Thread(new v(this, 0, 0)).start();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.q);
    Debug.i(this.p, "onDestory..........................................");
    mConnStatus = new BaseSCActivity.ConnStatus();
    this.l.removeCallbacksAndMessages(null);
    this.l = null;
    this.y = false;
  }

  public void onDeviceBatteryStatusChanged(byte paramByte, int paramInt)
  {
    super.onDeviceBatteryStatusChanged(paramByte, paramInt);
    Debug.i(this.p, "onDeviceBatteryStatusChanged:" + paramByte + "," + paramInt);
    EventBus.getDefault().post(new EventBatteryStatus(paramByte, paramInt));
  }

  public void onDeviceConnected()
  {
    super.onDeviceConnected();
  }

  public void onDeviceConnectionFailed()
  {
    super.onDeviceConnectionFailed();
    a(5, null);
  }

  public void onDeviceDisconnected()
  {
    super.onDeviceDisconnected();
    Debug.i(this.p, "onDeviceDisconnected..................................");
    a(7, null);
  }

  public void onDeviceFound(BluetoothDevice paramBluetoothDevice, int paramInt)
  {
    Debug.i(this.p, "MSG_BRACELET_FOUND " + paramBluetoothDevice.getName() + ":" + paramBluetoothDevice.getAddress());
    if ((paramBluetoothDevice.getAddress().equals(this.m.address)) && (this.u))
    {
      Debug.i(this.p, "FOUND last device:" + this.m.address);
      connect(paramBluetoothDevice);
      this.u = false;
    }
  }

  protected void onHideApp()
  {
    super.onHideApp();
  }

  public void onInitializationFailed()
  {
    super.onInitializationFailed();
    a(5, null);
  }

  protected void onPause()
  {
    this.w = false;
    Debug.i(this.p, "onPause====isBroughtToBackground:" + this.v + ",isNewActivity:" + this.w);
    Debug.f(this.p, "onPause====isBroughtToBackground:" + this.v + ",isNewActivity:" + this.w);
    super.onPause();
  }

  protected void onResume()
  {
    super.onResume();
    Debug.i(this.p, "onResume====isBroughtToBackground:" + this.v + "-isNewActivity:" + this.w);
    Debug.f(this.p, "onResume====isBroughtToBackground:" + this.v + "-isNewActivity:" + this.w);
    if (!Utils.isBinded())
      a(1, null);
    while ((!enableBluetooth(false)) || ((!this.v) && (!this.w)))
      return;
    a();
  }

  protected void onStop()
  {
    super.onStop();
    this.v = isApplicationBroughtToBackground(this);
    this.w = false;
    Debug.i(this.p, "onStop====isBroughtToBackground:" + this.v + ",isNewActivity:" + this.w);
    Debug.f(this.p, "onStop====isBroughtToBackground:" + this.v + ",isNewActivity:" + this.w);
    if (this.v)
    {
      this.y = false;
      b();
    }
  }

  public void onTogglePairResult(IMiLiProfile.DeviceInfo paramDeviceInfo)
  {
    super.onTogglePairResult(paramDeviceInfo);
    Debug.i(this.p, "onTogglePairResult:" + paramDeviceInfo);
    Debug.f(this.p, "onTogglePairResult:" + paramDeviceInfo);
    if (paramDeviceInfo == null)
    {
      a(5, null);
      return;
    }
    a(8, null);
    PowerManager localPowerManager = (PowerManager)getSystemService("power");
    d();
    Debug.i(this.p, "isEnterInBackground:" + this.x + ",isScreenOn:" + localPowerManager.isScreenOn());
    Debug.f(this.p, "isEnterInBackground:" + this.x + ",isScreenOn:" + localPowerManager.isScreenOn());
    if ((this.x) || (!localPowerManager.isScreenOn()))
    {
      c();
      return;
    }
    setLatency(39);
    f();
  }

  public void startAnalysisThreadForLuaEvent(boolean paramBoolean)
  {
    new Thread(new s(this, paramBoolean)).start();
  }

  public void startScanBracelet()
  {
    Debug.i(this.p, "startScanBracelet..............................");
    if (this.l == null)
      return;
    a(2, null);
    if (BraceletApp.BLEService != null)
    {
      Debug.i(this.p, "startScanBracelet");
      this.l.removeMessages(4096);
      this.u = true;
      BLEService localBLEService = BraceletApp.BLEService;
      UUID[] arrayOfUUID = new UUID[1];
      arrayOfUUID[0] = MiLiProfile.UUID_SERVICE_MILI_SERVICE;
      localBLEService.setServiceFilter(arrayOfUUID);
      BraceletApp.BLEService.startScan(10000);
      this.l.sendEmptyMessageDelayed(4097, 10000L);
      return;
    }
    this.l.sendEmptyMessageDelayed(4096, 200L);
  }

  public void startSyncData()
  {
    Debug.i(this.p, "startSyncData isSyncDataRunning:" + this.C);
    Debug.f(this.p, "startSyncData isSyncDataRunning:" + this.C);
    if (this.C)
      return;
    this.C = true;
    new BleSyncDataTask(Keeper.readSyncBraceletTime(), new r(this)).work();
  }

  protected void updateDynamicList(boolean paramBoolean)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.BaseSCActivity
 * JD-Core Version:    0.6.2
 */