package cn.com.smartdevices.bracelet.location;

import android.content.Context;
import android.location.LocationListener;
import android.os.Handler;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.UserLocationData;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Timer;

public class LocationManager
{
  protected static final String TAG = "LocationManager";
  private static final int i = 10000;
  private static final boolean j = true;
  private static final int k = 1;
  Timer a;
  android.location.LocationManager b;
  LocationManager.LocationResult c;
  boolean d = false;
  boolean e = false;
  Context f;
  LocationListener g = new c(this);
  LocationListener h = new d(this);
  private final Handler l;

  public LocationManager(Context paramContext)
  {
    this.f = paramContext;
    new e(this);
  }

  private void a(PersonInfo paramPersonInfo)
  {
    new HashMap().put("location", URLEncoder.encode(paramPersonInfo.location.toString()));
    WebAPI.sendLocation(Keeper.readLoginData(), paramPersonInfo.location, new f(this));
  }

  public boolean getLocation(Context paramContext, LocationManager.LocationResult paramLocationResult)
  {
    this.f = paramContext;
    this.c = paramLocationResult;
    if (this.b == null)
    {
      this.b = ((android.location.LocationManager)paramContext.getSystemService("location"));
      Debug.i("LocationManager", "lm == null !!!!!!!!!!!!!!" + this.b);
    }
    try
    {
      this.d = this.b.isProviderEnabled("gps");
      this.e = this.b.isProviderEnabled("network");
      Debug.i("LocationManager", "getLocation!!!!!!!!!!!!!!gps_enabled " + this.d + " network_enabled " + this.e);
      if ((!this.d) && (!this.e))
        return false;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
      if (this.d)
        this.b.requestLocationUpdates("gps", 0L, 0.0F, this.g);
      if (this.e)
        this.b.requestLocationUpdates("network", 0L, 0.0F, this.h);
      this.a = new Timer();
      this.a.schedule(new g(this), 10000L);
    }
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.location.LocationManager
 * JD-Core Version:    0.6.2
 */