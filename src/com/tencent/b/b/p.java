package com.tencent.b.b;

import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

final class p
  implements GpsStatus.Listener, LocationListener
{
  private p(e parame)
  {
  }

  public final void onGpsStatusChanged(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      e.a(this.a);
      return;
      e.a(this.a, 1);
      continue;
      e.a(this.a, 0);
      continue;
      e.a(this.a, 2);
    }
  }

  public final void onLocationChanged(Location paramLocation)
  {
    double d1;
    double d2;
    int i;
    if (paramLocation != null)
    {
      d1 = paramLocation.getLatitude();
      d2 = paramLocation.getLongitude();
      boolean bool1 = d1 < 29.999998211860657D;
      i = 0;
      if (bool1)
      {
        boolean bool2 = d2 < 103.99999916553497D;
        i = 0;
        if (bool2)
          break label52;
      }
      if (i != 0)
        break label157;
    }
    label52: 
    do
    {
      return;
      boolean bool3 = Math.abs(d1) < 1.0E-008D;
      i = 0;
      if (bool3)
        break;
      boolean bool4 = Math.abs(d2) < 1.0E-008D;
      i = 0;
      if (bool4)
        break;
      boolean bool5 = d1 < -90.0D;
      i = 0;
      if (bool5)
        break;
      boolean bool6 = d1 < 90.0D;
      i = 0;
      if (bool6)
        break;
      boolean bool7 = d2 < -180.0D;
      i = 0;
      if (bool7)
        break;
      boolean bool8 = d2 < 180.0D;
      i = 0;
      if (bool8)
        break;
      i = 1;
      break;
      e.a(this.a, System.currentTimeMillis());
      e.a(this.a);
      e.a(this.a, 2);
      e.a(this.a, new e.a(this.a, paramLocation, e.b(this.a), e.c(this.a), e.d(this.a), e.e(this.a)));
    }
    while (e.f(this.a) == null);
    label157: e.f(this.a).a(e.g(this.a));
  }

  public final void onProviderDisabled(String paramString)
  {
    if (paramString != null);
    try
    {
      boolean bool = paramString.equals("gps");
      if (!bool);
      do
      {
        return;
        e.b(this.a, e.h(this.a));
        e.c(this.a, 0);
      }
      while (e.f(this.a) == null);
      e.f(this.a).a(e.d(this.a));
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public final void onProviderEnabled(String paramString)
  {
    if (paramString != null);
    try
    {
      boolean bool = paramString.equals("gps");
      if (!bool);
      do
      {
        return;
        e.c(this.a, 4);
      }
      while (e.f(this.a) == null);
      e.f(this.a).a(e.d(this.a));
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.p
 * JD-Core Version:    0.6.2
 */