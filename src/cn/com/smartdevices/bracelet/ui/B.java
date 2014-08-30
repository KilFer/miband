package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;

final class B extends Handler
{
  B(BraceletSettingsFragment paramBraceletSettingsFragment)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return;
    case 4098:
    }
    BraceletSettingsFragment.a(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.B
 * JD-Core Version:    0.6.2
 */