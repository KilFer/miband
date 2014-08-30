package com.tencent.b.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f$c extends BroadcastReceiver
{
  private int a = 4;
  private List<ScanResult> b = null;
  private boolean c = false;

  public f$c(f paramf)
  {
  }

  private void a(List<ScanResult> paramList)
  {
    if (paramList == null)
      return;
    if (this.c)
    {
      if (this.b == null)
        this.b = new ArrayList();
      int i = this.b.size();
      Iterator localIterator2 = paramList.iterator();
      label49: ScanResult localScanResult2;
      if (localIterator2.hasNext())
        localScanResult2 = (ScanResult)localIterator2.next();
      for (int j = 0; ; j++)
        if (j < i)
        {
          if (((ScanResult)this.b.get(j)).BSSID.equals(localScanResult2.BSSID))
            this.b.remove(j);
        }
        else
        {
          this.b.add(localScanResult2);
          break label49;
          break;
        }
    }
    if (this.b == null)
      this.b = new ArrayList();
    while (true)
    {
      Iterator localIterator1 = paramList.iterator();
      while (localIterator1.hasNext())
      {
        ScanResult localScanResult1 = (ScanResult)localIterator1.next();
        this.b.add(localScanResult1);
      }
      break;
      this.b.clear();
    }
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED"))
    {
      this.a = paramIntent.getIntExtra("wifi_state", 4);
      if (f.b(this.d) != null)
        f.b(this.d).b(this.a);
    }
    List localList;
    if ((paramIntent.getAction().equals("android.net.wifi.SCAN_RESULTS")) || (paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")))
    {
      WifiManager localWifiManager = f.c(this.d);
      localList = null;
      if (localWifiManager != null)
        localList = f.c(this.d).getScanResults();
      if ((!paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) || ((localList != null) && ((localList == null) || (localList.size() != 0))));
    }
    else
    {
      return;
    }
    if ((!this.c) && (this.b != null) && (this.b.size() >= 4) && (localList != null) && (localList.size() <= 2))
    {
      a(localList);
      this.c = true;
      this.d.a(0L);
      return;
    }
    a(localList);
    this.c = false;
    f.a(this.d, new f.b(this.d, this.b, System.currentTimeMillis(), this.a));
    if (f.b(this.d) != null)
      f.b(this.d).a(f.d(this.d));
    this.d.a(20000L * f.e(this.d));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.f.c
 * JD-Core Version:    0.6.2
 */