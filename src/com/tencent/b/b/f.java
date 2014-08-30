package com.tencent.b.b;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;

public final class f
{
  private Context a = null;
  private WifiManager b = null;
  private f.c c = null;
  private Handler d = null;
  private Runnable e = new w(this);
  private int f = 1;
  private f.a g = null;
  private f.b h = null;
  private boolean i = false;
  private byte[] j = new byte[0];

  public final void a()
  {
    synchronized (this.j)
    {
      if (!this.i)
        return;
      if ((this.a == null) || (this.c == null))
        return;
    }
    try
    {
      this.a.unregisterReceiver(this.c);
      label50: this.d.removeCallbacks(this.e);
      this.i = false;
      return;
    }
    catch (Exception localException)
    {
      break label50;
    }
  }

  public final void a(long paramLong)
  {
    if ((this.d != null) && (this.i))
    {
      this.d.removeCallbacks(this.e);
      this.d.postDelayed(this.e, paramLong);
    }
  }

  public final boolean a(Context paramContext, f.a parama, int paramInt)
  {
    synchronized (this.j)
    {
      if (this.i)
        return true;
      if ((paramContext == null) || (parama == null))
        return false;
      this.d = new Handler(Looper.getMainLooper());
      this.a = paramContext;
      this.g = parama;
      this.f = 1;
      try
      {
        this.b = ((WifiManager)this.a.getSystemService("wifi"));
        IntentFilter localIntentFilter = new IntentFilter();
        this.c = new f.c(this);
        if (this.b != null)
        {
          f.c localc = this.c;
          if (localc != null);
        }
        else
        {
          return false;
        }
        localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        localIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        this.a.registerReceiver(this.c, localIntentFilter);
        a(0L);
        this.i = true;
        return this.i;
      }
      catch (Exception localException)
      {
        return false;
      }
    }
  }

  public final boolean b()
  {
    return this.i;
  }

  public final boolean c()
  {
    if ((this.a == null) || (this.b == null))
      return false;
    return this.b.isWifiEnabled();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.f
 * JD-Core Version:    0.6.2
 */