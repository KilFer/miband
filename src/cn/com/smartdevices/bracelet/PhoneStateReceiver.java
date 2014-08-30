package cn.com.smartdevices.bracelet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import java.util.Timer;
import java.util.TimerTask;

public class PhoneStateReceiver extends BroadcastReceiver
{
  private static final String a = "PhoneState";
  private static Timer b = null;
  private static TimerTask c = null;

  private static void a()
  {
    Debug.i("PhoneState", "in stopTimerTask");
    if (b != null)
    {
      Debug.i("PhoneState", "cancel timer...");
      b.cancel();
      b.purge();
      b = null;
    }
    if (c != null)
    {
      Debug.i("PhoneState", "canel task...");
      c.cancel();
      c = null;
    }
  }

  private static void a(int paramInt)
  {
    Debug.i("PhoneState", "in startTimerTask");
    b = new Timer();
    c = new d();
    b.schedule(c, paramInt);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    PersonInfo localPersonInfo = Keeper.readPersonInfo();
    if (!localPersonInfo.isInComingCallEnabled())
      return;
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getCallState())
    {
    default:
      return;
    case 0:
      Debug.i("PhoneState", "incoming IDLE");
      a();
      return;
    case 1:
      Debug.i("PhoneState", "RINGING :" + paramIntent.getStringExtra("incoming_number"));
      int i = 1000 * localPersonInfo.getInComingCallTime();
      Debug.i("PhoneState", "in startTimerTask");
      b = new Timer();
      c = new d();
      b.schedule(c, i);
      return;
    case 2:
    }
    Debug.i("PhoneState", "incoming ACCEPT :" + paramIntent.getStringExtra("incoming_number"));
    a();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.PhoneStateReceiver
 * JD-Core Version:    0.6.2
 */