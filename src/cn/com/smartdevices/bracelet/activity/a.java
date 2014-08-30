package cn.com.smartdevices.bracelet.activity;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.Utils;

final class a extends Handler
{
  a(LoginActivity paramLoginActivity)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default:
      return;
    case 256:
    }
    Utils.showProgressDialog(this.a, 2131493086);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.a
 * JD-Core Version:    0.6.2
 */