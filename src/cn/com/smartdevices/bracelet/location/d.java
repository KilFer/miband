package cn.com.smartdevices.bracelet.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.Timer;

final class d
  implements LocationListener
{
  d(LocationManager paramLocationManager)
  {
  }

  public final void onLocationChanged(Location paramLocation)
  {
    this.a.a.cancel();
    this.a.c.gotLocation(paramLocation, this.a.f);
    this.a.b.removeUpdates(this);
    this.a.b.removeUpdates(this.a.g);
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
 * Qualified Name:     cn.com.smartdevices.bracelet.location.d
 * JD-Core Version:    0.6.2
 */