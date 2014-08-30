package com.tencent.mm.sdk.platformtools;

import android.telephony.PhoneStateListener;
import java.util.Iterator;
import java.util.List;

final class p extends PhoneStateListener
{
  p(PhoneStatusWatcher paramPhoneStatusWatcher)
  {
  }

  public final void onCallStateChanged(int paramInt, String paramString)
  {
    Iterator localIterator = PhoneStatusWatcher.a(this.a).iterator();
    while (localIterator.hasNext())
      ((PhoneStatusWatcher.PhoneCallListener)localIterator.next()).onPhoneCall(paramInt);
    super.onCallStateChanged(paramInt, paramString);
    switch (paramInt)
    {
    default:
      return;
    case 0:
      PhoneStatusWatcher.a(false);
      return;
    case 1:
    case 2:
    }
    PhoneStatusWatcher.a(true);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.p
 * JD-Core Version:    0.6.2
 */