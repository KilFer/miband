package com.tencent.mm.sdk.platformtools;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

final class r extends PhoneStateListener
{
  r(q paramq)
  {
  }

  public final void onSignalStrengthChanged(int paramInt)
  {
    super.onSignalStrengthChanged(paramInt);
    q.a(-113 + (paramInt << 1));
    if (q.a(this.a) != null)
      q.a(this.a).listen(q.b(this.a), 0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.r
 * JD-Core Version:    0.6.2
 */