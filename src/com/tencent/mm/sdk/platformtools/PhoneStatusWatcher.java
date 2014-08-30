package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.util.LinkedList;
import java.util.List;

public class PhoneStatusWatcher
{
  private static boolean a;
  private TelephonyManager b;
  private PhoneStateListener c;
  private List<PhoneStatusWatcher.PhoneCallListener> d = new LinkedList();

  public static boolean isCalling()
  {
    return a;
  }

  public void addPhoneCallListener(PhoneStatusWatcher.PhoneCallListener paramPhoneCallListener)
  {
    this.d.add(paramPhoneCallListener);
  }

  public void begin(Context paramContext)
  {
    if (this.b == null)
      this.b = ((TelephonyManager)paramContext.getSystemService("phone"));
    if (this.c == null)
      this.c = new p(this);
    this.b.listen(this.c, 32);
  }

  public void clearPhoneCallListener()
  {
    this.d.clear();
  }

  public void end()
  {
    if (this.b != null)
    {
      this.b.listen(this.c, 0);
      this.c = null;
    }
  }

  public void removePhoneCallListener(PhoneStatusWatcher.PhoneCallListener paramPhoneCallListener)
  {
    this.d.remove(paramPhoneCallListener);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PhoneStatusWatcher
 * JD-Core Version:    0.6.2
 */