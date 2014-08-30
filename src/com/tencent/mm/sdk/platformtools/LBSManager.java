package com.tencent.mm.sdk.platformtools;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import java.util.LinkedList;
import java.util.List;

public class LBSManager extends BroadcastReceiver
{
  public static final String FILTER_GPS = "filter_gps";
  public static final int INVALID_ACC = -1000;
  public static final float INVALID_LAT = -1000.0F;
  public static final float INVALID_LNG = -1000.0F;
  public static final int MM_SOURCE_HARDWARE = 0;
  public static final int MM_SOURCE_NET = 1;
  public static final int MM_SOURCE_REPORT_HARWARE = 3;
  public static final int MM_SOURCE_REPORT_NETWORK = 4;
  private static f b;
  boolean a;
  private LBSManager.OnLocationGotListener c;
  private LocationManager d;
  private Context e;
  private PendingIntent f;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private int j;
  private MTimerHandler k = new MTimerHandler(new e(this), false);

  public LBSManager(Context paramContext, LBSManager.OnLocationGotListener paramOnLocationGotListener)
  {
    this.c = paramOnLocationGotListener;
    this.a = false;
    this.j = 0;
    this.e = paramContext;
    PhoneUtil.getSignalStrength(paramContext);
    this.d = ((LocationManager)paramContext.getSystemService("location"));
    a();
    this.f = PendingIntent.getBroadcast(paramContext, 0, new Intent("filter_gps"), 134217728);
  }

  private boolean a()
  {
    LocationManager localLocationManager = this.d;
    boolean bool = false;
    if (localLocationManager != null);
    try
    {
      this.d.sendExtraCommand("gps", "force_xtra_injection", null);
      this.d.sendExtraCommand("gps", "force_time_injection", null);
      bool = true;
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private void b()
  {
    this.k.stopTimer();
    this.a = true;
  }

  public static void setLocationCache(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
      return;
    Log.v("MicroMsg.LBSManager", "setLocationCache [" + paramFloat1 + "," + paramFloat2 + "] acc:" + paramInt1 + " source:" + paramInt2);
    if (b == null)
      b = new f();
    b.a = paramFloat1;
    b.b = paramFloat2;
    b.c = paramInt1;
    b.d = System.currentTimeMillis();
    b.e = paramInt2;
  }

  public String getTelLocation()
  {
    return PhoneUtil.getCellXml(PhoneUtil.getCellInfoList(this.e));
  }

  public String getWIFILocation()
  {
    WifiManager localWifiManager = (WifiManager)this.e.getSystemService("wifi");
    if (localWifiManager == null)
    {
      Log.e("MicroMsg.LBSManager", "no wifi service");
      return "";
    }
    if (localWifiManager.getConnectionInfo() == null)
    {
      Log.e("MicroMsg.LBSManager", "WIFILocation wifi info null");
      return "";
    }
    LinkedList localLinkedList = new LinkedList();
    List localList = localWifiManager.getScanResults();
    if (localList != null)
      for (int m = 0; m < localList.size(); m++)
        localLinkedList.add(new PhoneUtil.MacInfo(((ScanResult)localList.get(m)).BSSID, ((ScanResult)localList.get(m)).level));
    return PhoneUtil.getMacXml(localLinkedList);
  }

  public boolean isGpsEnable()
  {
    try
    {
      boolean bool = this.d.isProviderEnabled("gps");
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }

  public boolean isNetworkPrividerEnable()
  {
    try
    {
      boolean bool = this.d.isProviderEnabled("network");
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Location localLocation = (Location)paramIntent.getExtras().get("location");
    this.j = (1 + this.j);
    boolean bool;
    int m;
    String str1;
    String str2;
    if (localLocation != null)
    {
      bool = "gps".equals(localLocation.getProvider());
      if (((bool) && (localLocation.getAccuracy() <= 200.0F)) || ((!bool) && (localLocation.getAccuracy() <= 1000.0F) && (localLocation.getAccuracy() > 0.0F)))
      {
        if (!bool)
          break label276;
        m = 0;
        setLocationCache((float)localLocation.getLatitude(), (float)localLocation.getLongitude(), (int)localLocation.getAccuracy(), m);
        if ((this.c != null) && ((!this.a) || (!this.h) || (!this.i)))
        {
          str1 = Util.nullAsNil(getWIFILocation());
          str2 = Util.nullAsNil(getTelLocation());
          if (this.a)
            break label282;
          b();
          this.a = true;
          Log.v("MicroMsg.LBSManager", "location by provider ok:[" + localLocation.getLatitude() + " , " + localLocation.getLongitude() + "]  accuracy:" + localLocation.getAccuracy() + "  retry count:" + this.j + " isGpsProvider:" + bool);
          this.c.onLocationGot((float)localLocation.getLatitude(), (float)localLocation.getLongitude(), (int)localLocation.getAccuracy(), m, str1, str2, true);
        }
      }
    }
    label276: label282: 
    do
    {
      return;
      m = 1;
      break;
      if ((!this.h) && (m == 0))
      {
        this.h = true;
        Log.v("MicroMsg.LBSManager", "report location by GPS ok:[" + localLocation.getLatitude() + " , " + localLocation.getLongitude() + "]  accuracy:" + localLocation.getAccuracy() + "  retry count:" + this.j + " isGpsProvider:" + bool);
        this.c.onLocationGot((float)localLocation.getLatitude(), (float)localLocation.getLongitude(), (int)localLocation.getAccuracy(), 3, str1, str2, true);
        return;
      }
    }
    while ((this.i) || (m != 1));
    this.i = true;
    Log.v("MicroMsg.LBSManager", "report location by Network ok:[" + localLocation.getLatitude() + " , " + localLocation.getLongitude() + "]  accuracy:" + localLocation.getAccuracy() + "  retry count:" + this.j + " isGpsProvider:" + bool);
    this.c.onLocationGot((float)localLocation.getLatitude(), (float)localLocation.getLongitude(), (int)localLocation.getAccuracy(), 4, str1, str2, true);
  }

  public void removeGpsUpdate()
  {
    Log.v("MicroMsg.LBSManager", "removed gps update");
    if (this.d != null)
      this.d.removeUpdates(this.f);
    try
    {
      this.e.unregisterReceiver(this);
      return;
    }
    catch (Exception localException)
    {
      Log.v("MicroMsg.LBSManager", "location receiver has already unregistered");
    }
  }

  public void removeListener()
  {
    Log.v("MicroMsg.LBSManager", "removed gps update on destroy");
    removeGpsUpdate();
    if (this.k != null)
      b();
    this.c = null;
    this.e = null;
    this.k = null;
    this.d = null;
  }

  public void requestGpsUpdate()
  {
    requestGpsUpdate(500);
  }

  public void requestGpsUpdate(int paramInt)
  {
    if ((!isGpsEnable()) && (!isNetworkPrividerEnable()))
      return;
    if (paramInt > 0);
    while (true)
    {
      Log.v("MicroMsg.LBSManager", "requested gps update");
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("filter_gps");
      this.e.registerReceiver(this, localIntentFilter);
      if (isGpsEnable())
        this.d.requestLocationUpdates("gps", paramInt, 0.0F, this.f);
      if (!isNetworkPrividerEnable())
        break;
      this.d.requestLocationUpdates("network", paramInt, 0.0F, this.f);
      return;
      paramInt = 500;
    }
  }

  public void resetForContinueGetLocation()
  {
    this.h = false;
    this.i = false;
  }

  public void start()
  {
    String str1 = Util.nullAsNil(getWIFILocation());
    String str2 = Util.nullAsNil(getTelLocation());
    int m;
    if ((isGpsEnable()) || (isNetworkPrividerEnable()))
    {
      m = 1;
      if ((m == 0) || (this.g))
        break label73;
      this.g = true;
      this.j = 0;
      requestGpsUpdate();
      this.k.startTimer(3000L);
    }
    label73: label245: 
    do
    {
      do
      {
        return;
        m = 0;
        break;
        int n;
        if (b == null)
          n = 0;
        while (true)
        {
          if (n == 0)
            break label245;
          if (this.c == null)
            break;
          this.a = true;
          Log.v("MicroMsg.LBSManager", "location by GPS cache ok:[" + b.a + " , " + b.b + "]  accuracy:" + b.c + " source:" + b.e);
          this.c.onLocationGot(b.a, b.b, b.c, b.e, str1, str2, true);
          return;
          if ((System.currentTimeMillis() - b.d > 180000L) || (b.c <= 0))
            n = 0;
          else
            n = 1;
        }
        this.a = true;
        if ((!str1.equals("")) || (!str2.equals("")))
          break label306;
        Log.v("MicroMsg.LBSManager", "get location by network failed");
      }
      while (this.c == null);
      this.c.onLocationGot(-1000.0F, -1000.0F, -1000, 0, "", "", false);
      return;
      Log.v("MicroMsg.LBSManager", "get location by network ok, macs : " + str1 + " cell ids :" + str2);
    }
    while (this.c == null);
    label306: this.c.onLocationGot(-1000.0F, -1000.0F, -1000, 0, str1, str2, true);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.LBSManager
 * JD-Core Version:    0.6.2
 */