package cn.com.smartdevices.bracelet.ui;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleTogglePairTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.activity.BraceletNotFoundActivity;
import cn.com.smartdevices.bracelet.activity.MultiBraceletErrActivity;
import cn.com.smartdevices.bracelet.chart.LinePieChartView;
import cn.com.smartdevices.bracelet.lua.LuaEvent;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.SystemInfo;
import cn.com.smartdevices.bracelet.view.Util;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.gatt.IGattCallback;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import com.xiaomi.hm.view.GifImageType;
import com.xiaomi.hm.view.GifView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class SearchSingleBraceletActivity extends BaseBleActivity
  implements View.OnClickListener
{
  public static final long CONNECT_TIME_OUT = 60000L;
  public static final int MSG_DEVICE_CONNECTION_FAILED = 4115;
  public static final int NEED_EXIT = 1;
  public static final int NEED_RESEARCH = 0;
  public static final String REF_NOT_KNOCKED = "REF_NOT_KNOCKED";
  private static final String a = "SearchSingleBraceletActivity";
  private static final int b = 2000;
  private static final int f = 4103;
  private static final int g = 4117;
  private static Handler h = null;
  private static final long p = 10000L;
  private static final long q = 1000L;
  private static final int r = 60000;
  private boolean A = false;
  private boolean B;
  private LinePieChartView C;
  private ImageView D;
  private boolean E;
  private ImageButton F;
  private View G;
  private final int c;
  private final int d;
  private final int e;
  private ListView i = null;
  private ArrayList<bc> j = new ArrayList();
  private bd k = null;
  private Context l = null;
  private int m = 0;
  public boolean mDevMode = false;
  private final int n;
  private BluetoothDevice o = null;
  private bc s;
  private TextView t;
  private TextView u;
  private TextView v;
  private TextView w;
  private View x;
  private BraceletBtInfo y;
  private GifView z;

  private void a()
  {
    this.k = new bd(this);
    this.G = findViewById(2131165278);
    this.i = ((ListView)findViewById(2131165279));
    this.i.setAdapter(this.k);
    this.i.setOnItemClickListener(new aY(this));
    this.z = ((GifView)findViewById(2131165275));
    this.x = findViewById(2131165272);
    this.t = ((TextView)findViewById(2131165270));
    this.u = ((TextView)findViewById(2131165271));
    this.v = ((TextView)findViewById(2131165276));
    this.v.setText(Html.fromHtml("<u>" + getString(2131493184) + "</u>"));
    this.v.setOnClickListener(this);
    this.v.setVisibility(0);
    this.w = ((TextView)findViewById(2131165277));
    this.w.setOnClickListener(this);
    this.w.setVisibility(8);
    this.D = ((ImageView)findViewById(2131165274));
    this.F = ((ImageButton)findViewById(2131165269));
    this.F.setOnClickListener(this);
    this.C = ((LinePieChartView)findViewById(2131165273));
    this.C.setMode(0);
    this.C.showLoading();
    findViewById(2131165230).setOnClickListener(this);
  }

  private void a(BluetoothDevice paramBluetoothDevice)
  {
    this.o = paramBluetoothDevice;
    Utils.connect(paramBluetoothDevice, false);
    h.sendEmptyMessage(4097);
    h.sendEmptyMessageDelayed(4115, 60000L);
  }

  private void a(IMiLiProfile.DeviceInfo paramDeviceInfo)
  {
    LoginData localLoginData = Keeper.readLoginData();
    BraceletBtInfo localBraceletBtInfo = Keeper.readBraceletBtInfo();
    String str = Keeper.readDeviceId();
    SystemInfo localSystemInfo = new SystemInfo();
    localSystemInfo.deviceId = str;
    localSystemInfo.braceletMacAddress = localBraceletBtInfo.address;
    localSystemInfo.miuiVersionCode = Utils.getMiuiVersionCode(this.l);
    localSystemInfo.miuiVersionName = Utils.getMiuiVersionName(this.l);
    localSystemInfo.phoneBrand = Build.BRAND;
    localSystemInfo.phoneModel = Build.MODEL;
    localSystemInfo.phoneSystem = Build.VERSION.SDK_INT;
    try
    {
      localSystemInfo.softVersion = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
      label119: localSystemInfo.fwVersion = paramDeviceInfo.getFirmwareVersionStr();
      Debug.i("SearchSingleBraceletActivity", "updateSystemInfo:\n" + localSystemInfo.toString());
      WebAPI.updateSystemInfo(localLoginData, localSystemInfo, 0, new ba(this));
      return;
    }
    catch (Exception localException)
    {
      break label119;
    }
  }

  private void a(boolean paramBoolean)
  {
    this.z.setVisibility(0);
    this.z.setGifImage(2130837530);
    this.z.setOnClickListener(this);
    this.z.setGifImageType(GifImageType.COVER);
    this.z.setLoopNumber(4096);
    this.t.setText(2131492954);
    this.u.setText(2131492943);
    this.v.setVisibility(4);
    this.w.setVisibility(0);
    this.w.setText(Html.fromHtml("<u>我的手环怎么没有亮灯</u>"));
    this.C.setVisibility(4);
    this.D.setVisibility(4);
    this.E = true;
  }

  private void b()
  {
    this.z.setVisibility(0);
    this.z.setGifImage(2130837530);
    this.z.setOnClickListener(this);
    this.z.setGifImageType(GifImageType.COVER);
    this.z.setLoopNumber(4096);
  }

  private void c()
  {
    this.z.setVisibility(8);
  }

  private boolean d()
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if ((localBluetoothAdapter != null) && (!localBluetoothAdapter.isEnabled()))
    {
      startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 8193);
      return false;
    }
    return true;
  }

  private void e()
  {
    h = new aZ(this);
    Debug.i("SearchSingleBraceletActivity", "mHandler = " + h);
  }

  private static void f()
  {
    if (BraceletApp.BLEService != null)
      BraceletApp.BLEService.stopScan();
    if (h != null)
    {
      h.removeMessages(4100);
      h.removeMessages(4103);
      h.removeMessages(4117);
      h.removeMessages(4115);
      return;
    }
    Debug.i("SearchSingleBraceletActivity", "mHandler is NULL!!!!!!!!!!!!!!!!!");
  }

  private static void g()
  {
    IGattCallback localIGattCallback = BraceletApp.BLEService.getDefaultPeripheral();
    if (localIGattCallback != null)
    {
      ((MiLiProfile)localIGattCallback).setAutoReconnect(false);
      localIGattCallback.disconnect();
      Debug.i("SearchSingleBraceletActivity", "\n    =============== disconnect BLE =============== \n");
    }
  }

  private void h()
  {
    if (BraceletApp.BLEService != null)
    {
      Debug.i("SearchSingleBraceletActivity", "startScanBracelet");
      if (this.j != null)
      {
        this.j.clear();
        this.k.notifyDataSetChanged();
      }
      h.removeMessages(4100);
      BLEService localBLEService = BraceletApp.BLEService;
      UUID[] arrayOfUUID = new UUID[1];
      arrayOfUUID[0] = MiLiProfile.UUID_SERVICE_MILI_SERVICE;
      localBLEService.setServiceFilter(arrayOfUUID);
      BraceletApp.BLEService.startScan(60000);
      h.removeMessages(4103);
      h.sendEmptyMessageDelayed(4103, 60000L);
      h.removeMessages(4117);
      h.sendEmptyMessageDelayed(4117, 10000L);
      return;
    }
    h.sendEmptyMessageDelayed(4100, 200L);
  }

  private void i()
  {
    f();
    g();
    Intent localIntent = new Intent(this.l, MultiBraceletErrActivity.class);
    localIntent.setFlags(67108864);
    if (this.B)
      localIntent.putExtra("REF_NOT_KNOCKED", 2131493021);
    startActivity(localIntent);
    finish();
  }

  private void j()
  {
    f();
    g();
    startActivity(new Intent(this.l, BraceletNotFoundActivity.class));
    finish();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Debug.i("SearchSingleBraceletActivity", "requestCode =" + paramInt1 + ", resultCode=" + paramInt2);
    if (paramInt1 == 8193)
      switch (paramInt2)
      {
      default:
      case -1:
      case 0:
      }
    while (true)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      h();
      continue;
      Toast.makeText(this, getString(2131492877), 1).show();
      finish();
    }
  }

  public void onAuthenticationFailed()
  {
    super.onAuthenticationFailed();
    Debug.i("SearchSingleBraceletActivity", "onAuthenticationFailed");
    this.z.setVisibility(0);
    this.z.setGifImage(2130837530);
    this.z.setOnClickListener(this);
    this.z.setGifImageType(GifImageType.COVER);
    this.z.setLoopNumber(4096);
    this.t.setText(2131492954);
    this.u.setText(2131492943);
    this.v.setVisibility(4);
    this.w.setVisibility(0);
    this.w.setText(Html.fromHtml("<u>我的手环怎么没有亮灯</u>"));
    this.C.setVisibility(4);
    this.D.setVisibility(4);
    this.E = true;
    if (this.mDevMode)
      Toast.makeText(this.l, 2131493128, 1).show();
  }

  public void onBackPressed()
  {
    Keeper.keepBraceletBtInfo(new BraceletBtInfo());
    if (!this.mDevMode)
    {
      super.onBackPressed();
      return;
    }
    BleTogglePairTask.waitingNotify(Integer.valueOf(13));
    finish();
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165230:
      f();
      finish();
      return;
    case 2131165269:
      if (BraceletApp.BLEService != null)
        BraceletApp.BLEService.stopScan();
      if (this.j != null)
        this.j.clear();
      if (this.mDevMode);
      for (boolean bool = false; ; bool = true)
      {
        setDevelopUI(bool);
        if (!d())
          break;
        h();
        return;
      }
    case 2131165277:
      i();
      BleTogglePairTask.waitingNotify(Integer.valueOf(13));
      return;
    case 2131165276:
    }
    f();
    g();
    finish();
    startActivity(new Intent(this, MainUIActivity.class));
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903053);
    getWindow().setWindowAnimations(2131623943);
    Debug.i("SearchSingleBraceletActivity", "onCreate");
    this.l = this;
    h = new aZ(this);
    Debug.i("SearchSingleBraceletActivity", "mHandler = " + h);
    this.k = new bd(this);
    this.G = findViewById(2131165278);
    this.i = ((ListView)findViewById(2131165279));
    this.i.setAdapter(this.k);
    this.i.setOnItemClickListener(new aY(this));
    this.z = ((GifView)findViewById(2131165275));
    this.x = findViewById(2131165272);
    this.t = ((TextView)findViewById(2131165270));
    this.u = ((TextView)findViewById(2131165271));
    this.v = ((TextView)findViewById(2131165276));
    this.v.setText(Html.fromHtml("<u>" + getString(2131493184) + "</u>"));
    this.v.setOnClickListener(this);
    this.v.setVisibility(0);
    this.w = ((TextView)findViewById(2131165277));
    this.w.setOnClickListener(this);
    this.w.setVisibility(8);
    this.D = ((ImageView)findViewById(2131165274));
    this.F = ((ImageButton)findViewById(2131165269));
    this.F.setOnClickListener(this);
    this.C = ((LinePieChartView)findViewById(2131165273));
    this.C.setMode(0);
    this.C.showLoading();
    findViewById(2131165230).setOnClickListener(this);
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.mDevMode = localIntent.getBooleanExtra("REF_SEARCH_DEV_MODE", false);
      Debug.i("SearchSingleBraceletActivity", "mDevMode = " + this.mDevMode);
    }
    while (true)
    {
      setDevelopUI(this.mDevMode);
      return;
      this.mDevMode = false;
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return true;
  }

  protected void onDestroy()
  {
    super.onDestroy();
    Debug.i("SearchSingleBraceletActivity", "onDestroy");
    f();
    if (this.z != null);
    try
    {
      this.z.destroy();
      this.z = null;
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public void onDeviceConnected()
  {
    super.onDeviceConnected();
    Debug.i("SearchSingleBraceletActivity", "search single 已连上设备! MSG_DEVICE_CONNECTED");
  }

  public void onDeviceConnectionFailed()
  {
    super.onDeviceConnectionFailed();
    Util.hideProgressDialog();
    Debug.i("SearchSingleBraceletActivity", "onDeviceConnectionFailed");
    i();
  }

  public void onDeviceDisconnected()
  {
    super.onDeviceDisconnected();
    Util.hideProgressDialog();
    Debug.i("SearchSingleBraceletActivity", "onDeviceDisconnected");
    i();
  }

  public void onDeviceFound(BluetoothDevice paramBluetoothDevice, int paramInt)
  {
    bc localbc = new bc(this);
    localbc.a = paramBluetoothDevice;
    localbc.b = paramInt;
    this.j.add(localbc);
    Debug.i("SearchSingleBraceletActivity", "found mili:" + localbc.a.getAddress() + ", " + localbc.a.getName() + ", " + localbc.b + ", divice count:" + this.j.size());
    Debug.f("SearchSingleBraceletActivity", "found mili:" + localbc.a.getAddress() + ", " + localbc.a.getName() + ", " + localbc.b + ", divice count:" + this.j.size() + ", mBtDevice = " + localbc);
    Collections.sort(this.j, new be(this, (byte)0));
    this.k.notifyDataSetChanged();
    if ((this.y != null) && (localbc.a.getAddress().equals(this.y.address)))
    {
      Debug.i("SearchSingleBraceletActivity", "FOUND last device:" + this.y.address);
      this.s = localbc;
      h.removeMessages(4103);
      h.sendEmptyMessage(4103);
      if (BraceletApp.BLEService != null)
        BraceletApp.BLEService.stopScan();
    }
    while (true)
    {
      return;
      if (this.s == null)
        this.s = localbc;
      while (this.A)
      {
        h.removeMessages(4103);
        h.sendEmptyMessageDelayed(4103, 1000L);
        return;
        if (localbc.b == 0)
        {
          Debug.i("SearchSingleBraceletActivity", "Found a connect device : " + localbc.a.getName() + "," + localbc.a.getName() + "," + localbc.b);
          this.s = localbc;
          h.removeMessages(4103);
          h.sendEmptyMessage(4103);
          return;
        }
        if (localbc.b > this.s.b)
        {
          Debug.i("SearchSingleBraceletActivity", "Found a bigger signal : " + localbc.b);
          this.s = localbc;
        }
      }
    }
  }

  protected void onHideApp()
  {
    Debug.i("SearchSingleBraceletActivity", "onHideApp: finish()");
    g();
    finish();
    Debug.i("SearchSingleBraceletActivity", "**********************************************************");
    Debug.i("SearchSingleBraceletActivity", "*************** Bracelet app, Exit whole process");
    Debug.i("SearchSingleBraceletActivity", "**********************************************************");
    System.exit(-1);
  }

  public void onInitializationFailed()
  {
    super.onInitializationFailed();
    Util.hideProgressDialog();
    Debug.i("SearchSingleBraceletActivity", "onInitializationFailed");
    i();
  }

  public void onInitializationSuccess()
  {
    super.onInitializationSuccess();
    Debug.i("SearchSingleBraceletActivity", "onInitializationSuccess");
    f();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool1 = true;
    switch (paramMenuItem.getItemId())
    {
    default:
      bool1 = super.onOptionsItemSelected(paramMenuItem);
      return bool1;
    case 2131165688:
    }
    if (BraceletApp.BLEService != null)
      BraceletApp.BLEService.stopScan();
    if (this.mDevMode);
    for (boolean bool2 = false; ; bool2 = bool1)
    {
      setDevelopUI(bool2);
      if (!d())
        break;
      h();
      return bool1;
    }
  }

  protected void onPause()
  {
    super.onPause();
    Debug.i("SearchSingleBraceletActivity", "onPause");
    String str = "PageSearchSingleBracelet";
    if (this.mDevMode)
      str = "PageSearchMultiBracelet";
    UmengAnalytics.endPage(str);
    UmengAnalytics.startSession(this);
  }

  public void onResetAuthentiacationSuccess()
  {
    super.onResetAuthentiacationSuccess();
    Debug.i("SearchSingleBraceletActivity", "onResetAuthentiacationSuccess");
  }

  public void onResetAuthenticationFailed()
  {
    super.onResetAuthenticationFailed();
    Debug.i("SearchSingleBraceletActivity", "onResetAuthentiacationFailed");
    if (this.mDevMode)
      Toast.makeText(this.l, 2131493021, 0).show();
    this.B = true;
  }

  protected void onResume()
  {
    super.onResume();
    this.B = false;
    this.z.restartGifAnimation();
    Debug.i("SearchSingleBraceletActivity", "onResume");
    String str = "PageSearchSingleBracelet";
    if (this.mDevMode)
      str = "PageSearchMultiBracelet";
    UmengAnalytics.startPage(str);
    UmengAnalytics.startSession(this);
  }

  public void onTogglePairProgress(int paramInt)
  {
    super.onTogglePairProgress(paramInt);
  }

  public void onTogglePairResult(IMiLiProfile.DeviceInfo paramDeviceInfo)
  {
    super.onTogglePairResult(paramDeviceInfo);
    if (paramDeviceInfo == null)
    {
      Debug.i("SearchSingleBraceletActivity", "onTogglePairResult : DeviceInfo = " + paramDeviceInfo);
      i();
      return;
    }
    Debug.i("SearchSingleBraceletActivity", "onTogglePairResult: Compaire OK!");
    if (isDestroyed())
    {
      Debug.i("SearchSingleBraceletActivity", "onTogglePairResult: Compaire OK!, But the activity has been destroyed");
      return;
    }
    BraceletBtInfo localBraceletBtInfo1 = new BraceletBtInfo();
    localBraceletBtInfo1.name = this.o.getName();
    localBraceletBtInfo1.address = this.o.getAddress();
    Keeper.keepBraceletBtInfo(localBraceletBtInfo1);
    Keeper.keepDeviceId(paramDeviceInfo.deviceID);
    LoginData localLoginData = Keeper.readLoginData();
    BraceletBtInfo localBraceletBtInfo2 = Keeper.readBraceletBtInfo();
    String str = Keeper.readDeviceId();
    SystemInfo localSystemInfo = new SystemInfo();
    localSystemInfo.deviceId = str;
    localSystemInfo.braceletMacAddress = localBraceletBtInfo2.address;
    localSystemInfo.miuiVersionCode = Utils.getMiuiVersionCode(this.l);
    localSystemInfo.miuiVersionName = Utils.getMiuiVersionName(this.l);
    localSystemInfo.phoneBrand = Build.BRAND;
    localSystemInfo.phoneModel = Build.MODEL;
    localSystemInfo.phoneSystem = Build.VERSION.SDK_INT;
    try
    {
      localSystemInfo.softVersion = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
      label222: localSystemInfo.fwVersion = paramDeviceInfo.getFirmwareVersionStr();
      Debug.i("SearchSingleBraceletActivity", "updateSystemInfo:\n" + localSystemInfo.toString());
      WebAPI.updateSystemInfo(localLoginData, localSystemInfo, 0, new ba(this));
      LuaEvent.getInstance(this.l).setDefaultMsgs();
      this.C.dismissLoading();
      if (isDestroyed())
      {
        Debug.i("SearchSingleBraceletActivity", "onTogglePairResult: Compaire OK!, But the activity has been destroyed");
        return;
      }
      int i1;
      if (!this.E)
      {
        this.C.showNormalLine();
        this.t.setText(2131492944);
        this.u.setText(2131493185);
        this.D.setImageResource(2130837646);
        this.F.setVisibility(8);
        this.v.setVisibility(8);
        i1 = 2000;
        Keeper.keepIsPlayEnterAnimation(Boolean.valueOf(true));
        Keeper.keepPlayEnterAnimationType(2);
      }
      while (isDestroyed())
      {
        Debug.i("SearchSingleBraceletActivity", "onTogglePairResult: Compaire OK!, But the activity has been destroyed");
        return;
        Keeper.keepIsPlayEnterAnimation(Boolean.valueOf(true));
        Keeper.keepPlayEnterAnimationType(1);
        i1 = 0;
      }
      h.postDelayed(new bb(this), i1);
      return;
    }
    catch (Exception localException)
    {
      break label222;
    }
  }

  protected void setDevelopUI(boolean paramBoolean)
  {
    this.mDevMode = paramBoolean;
    this.j.clear();
    this.k.notifyDataSetChanged();
    if (this.mDevMode)
    {
      this.x.setVisibility(8);
      this.G.setVisibility(0);
      this.y = null;
    }
    while (true)
    {
      g();
      f();
      if (d())
        h();
      return;
      this.y = Keeper.readBraceletBtInfo();
      this.x.setVisibility(0);
      this.G.setVisibility(8);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.SearchSingleBraceletActivity
 * JD-Core Version:    0.6.2
 */