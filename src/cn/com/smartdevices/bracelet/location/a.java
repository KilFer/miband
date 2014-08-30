package cn.com.smartdevices.bracelet.location;

import android.content.Context;
import android.location.Location;
import cn.com.smartdevices.bracelet.Debug;

final class a extends LocationManager.LocationResult
{
  a(GetLocationHelper paramGetLocationHelper)
  {
  }

  public final void gotLocation(Location paramLocation, Context paramContext)
  {
    if (paramLocation == null)
    {
      Debug.i("GetLocationHelper", "Can't get network/gps loaction");
      GetLocationHelper.c(this.a).onLocationGet("", GetLocationHelper.b(this.a), GetLocationHelper.a(this.a));
      return;
    }
    Debug.i("GetLocationHelper", "Get NetWork /GPS location: " + paramLocation.getLatitude() + ", " + paramLocation.getLongitude());
    new b(this.a).execute(new Location[] { paramLocation });
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.location.a
 * JD-Core Version:    0.6.2
 */