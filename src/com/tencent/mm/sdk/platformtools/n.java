package com.tencent.mm.sdk.platformtools;

import java.util.Comparator;

final class n
  implements Comparator<ObserverPool.Listener>
{
  n(ObserverPool paramObserverPool)
  {
  }

  private static int a(ObserverPool.Listener paramListener1, ObserverPool.Listener paramListener2)
  {
    return ObserverPool.Listener.a(paramListener2) - ObserverPool.Listener.a(paramListener1);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.n
 * JD-Core Version:    0.6.2
 */