package com.tencent.b.b;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f$b
  implements Cloneable
{
  private List<ScanResult> a = null;

  public f$b(List<ScanResult> paramList, long paramLong, int paramInt)
  {
    if (paramLong != null)
    {
      this.a = new ArrayList();
      Iterator localIterator = paramLong.iterator();
      while (localIterator.hasNext())
      {
        ScanResult localScanResult = (ScanResult)localIterator.next();
        this.a.add(localScanResult);
      }
    }
  }

  public final List<ScanResult> a()
  {
    return this.a;
  }

  public final Object clone()
  {
    try
    {
      localb = (b)super.clone();
      if (this.a != null)
      {
        localb.a = new ArrayList();
        localb.a.addAll(this.a);
      }
      return localb;
    }
    catch (Exception localException)
    {
      while (true)
        b localb = null;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.f.b
 * JD-Core Version:    0.6.2
 */