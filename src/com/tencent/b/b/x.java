package com.tencent.b.b;

import android.telephony.TelephonyManager;
import java.util.List;

final class x extends Thread
{
  x(m paramm)
  {
  }

  public final void run()
  {
    List localList;
    byte[] arrayOfByte;
    if (m.d(this.a) != null)
    {
      localList = m.d(this.a).getNeighboringCellInfo();
      arrayOfByte = m.e(this.a);
      if (localList == null);
    }
    try
    {
      m.f(this.a).clear();
      m.f(this.a).addAll(localList);
      m.g(this.a);
      return;
    }
    finally
    {
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.x
 * JD-Core Version:    0.6.2
 */