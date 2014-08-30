package com.tencent.tauth;

import android.location.Location;
import com.tencent.a.a.c;
import com.tencent.b.a.a.b;
import com.tencent.b.a.a.d;

public class SosoLocationListener extends b
{
  private LbsAgent.OnGetLocationListener a;

  public SosoLocationListener(LbsAgent.OnGetLocationListener paramOnGetLocationListener)
  {
    super(1, 0, 0, 8);
    this.a = paramOnGetLocationListener;
  }

  public void onLocationDataUpdate(byte[] paramArrayOfByte, int paramInt)
  {
    super.onLocationDataUpdate(paramArrayOfByte, paramInt);
    c.c("openSDK_LOG", "location: onLocationDataUpdate = " + paramArrayOfByte);
  }

  public void onLocationUpdate(d paramd)
  {
    c.c("openSDK_LOG", "location: onLocationUpdate = " + paramd);
    super.onLocationUpdate(paramd);
    if (paramd == null);
    Location localLocation;
    do
    {
      return;
      localLocation = new Location("passive");
      localLocation.setLatitude(paramd.b);
      localLocation.setLongitude(paramd.c);
    }
    while (this.a == null);
    this.a.onLocationUpdate(localLocation);
  }

  public void onStatusUpdate(int paramInt)
  {
    c.c("openSDK_LOG", "location: onStatusUpdate = " + paramInt);
    super.onStatusUpdate(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.tauth.SosoLocationListener
 * JD-Core Version:    0.6.2
 */