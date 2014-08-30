package com.tencent.mm.sdk.platformtools;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

final class t extends PhoneStateListener
{
  t(s params)
  {
  }

  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (s.a(this.a) == 2)
      s.a(paramSignalStrength.getCdmaDbm());
    if (s.a(this.a) == 1)
      s.a(-113 + (paramSignalStrength.getGsmSignalStrength() << 1));
    if (s.b(this.a) != null)
      s.b(this.a).listen(s.c(this.a), 0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.t
 * JD-Core Version:    0.6.2
 */