package cn.com.smartdevices.bracelet.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.Debug;
import java.util.Timer;

final class c
  implements LocationListener
{
  c(LocationManager paramLocationManager)
  {
  }

  public final void onLocationChanged(Location paramLocation)
  {
    Debug.i("LocationManager", "Location listener GPS on Location Changed.");
    this.a.a.cancel();
    this.a.c.gotLocation(paramLocation, this.a.f);
    this.a.b.removeUpdates(this);
    this.a.b.removeUpdates(this.a.h);
  }

  public final void onProviderDisabled(String paramString)
  {
  }

  public final void onProviderEnabled(String paramString)
  {
  }

  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.location.c
 * JD-Core Version:    0.6.2
 */