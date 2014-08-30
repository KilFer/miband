package android.support.v4.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;

final class g extends BroadcastReceiver
{
  g(d paramd)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      KeyEvent localKeyEvent = (KeyEvent)paramIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
      this.a.a.b(localKeyEvent);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      Log.w("TransportController", localClassCastException);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.g
 * JD-Core Version:    0.6.2
 */