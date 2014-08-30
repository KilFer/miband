package cn.com.smartdevices.bracelet.location;

import android.location.Location;
import cn.com.smartdevices.bracelet.Debug;
import java.util.TimerTask;

final class g extends TimerTask
{
  g(LocationManager paramLocationManager)
  {
  }

  public final void run()
  {
    this.a.b.removeUpdates(this.a.g);
    this.a.b.removeUpdates(this.a.h);
    if (this.a.d);
    for (Location localLocation1 = this.a.b.getLastKnownLocation("gps"); ; localLocation1 = null)
    {
      if (this.a.e);
      for (Location localLocation2 = this.a.b.getLastKnownLocation("network"); ; localLocation2 = null)
      {
        Debug.i("LocationManager", "net_loc = " + localLocation2 + " , gps location =" + localLocation1);
        if ((localLocation1 != null) && (localLocation2 != null))
        {
          if (localLocation1.getTime() > localLocation2.getTime())
          {
            this.a.c.gotLocation(localLocation1, this.a.f);
            return;
          }
          this.a.c.gotLocation(localLocation2, this.a.f);
          return;
        }
        if (localLocation1 != null)
        {
          this.a.c.gotLocation(localLocation1, this.a.f);
          return;
        }
        if (localLocation2 != null)
        {
          this.a.c.gotLocation(localLocation2, this.a.f);
          return;
        }
        this.a.c.gotLocation(null, this.a.f);
        return;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.location.g
 * JD-Core Version:    0.6.2
 */