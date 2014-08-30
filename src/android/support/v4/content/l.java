package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class l extends Handler
{
  l(LocalBroadcastManager paramLocalBroadcastManager, Looper paramLooper)
  {
    super(paramLooper);
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      super.handleMessage(paramMessage);
      return;
    case 1:
    }
    LocalBroadcastManager.a(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.l
 * JD-Core Version:    0.6.2
 */