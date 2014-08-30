package com.tencent.b.b;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
import java.util.Iterator;

public final class e
{
  private static LocationManager b = null;
  private static float d;
  private Context a = null;
  private p c = null;
  private e.b e = null;
  private e.a f = null;
  private boolean g = false;
  private byte[] h = new byte[0];
  private int i = 1024;
  private long j = 0L;
  private boolean k;
  private int l = 0;
  private int m = 0;

  private void b()
  {
    this.m = 0;
    this.l = 0;
    GpsStatus localGpsStatus = b.getGpsStatus(null);
    if (localGpsStatus == null);
    while (true)
    {
      return;
      int n = localGpsStatus.getMaxSatellites();
      Iterator localIterator = localGpsStatus.getSatellites().iterator();
      if (localIterator != null)
        while ((localIterator.hasNext()) && (this.l <= n))
        {
          this.l = (1 + this.l);
          if (((GpsSatellite)localIterator.next()).usedInFix())
            this.m = (1 + this.m);
        }
    }
  }

  public final void a()
  {
    synchronized (this.h)
    {
      if (!this.g)
        return;
      if ((b != null) && (this.c != null))
      {
        b.removeGpsStatusListener(this.c);
        b.removeUpdates(this.c);
      }
      this.g = false;
      return;
    }
  }

  public final boolean a(e.b paramb, Context paramContext)
  {
    synchronized (this.h)
    {
      if (this.g)
        return true;
      if ((paramContext == null) || (paramb == null))
        return false;
      this.a = paramContext;
      this.e = paramb;
      try
      {
        b = (LocationManager)this.a.getSystemService("location");
        this.c = new p(this, (byte)0);
        if (b != null)
        {
          p localp = this.c;
          if (localp != null);
        }
        else
        {
          return false;
        }
      }
      catch (Exception localException1)
      {
        return false;
      }
      try
      {
        b.requestLocationUpdates("gps", 1000L, 0.0F, this.c);
        b.addGpsStatusListener(this.c);
        if (b.isProviderEnabled("gps"));
        for (this.i = 4; ; this.i = 0)
        {
          this.g = true;
          return this.g;
        }
      }
      catch (Exception localException2)
      {
        return false;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.e
 * JD-Core Version:    0.6.2
 */