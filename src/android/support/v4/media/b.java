package android.support.v4.media;

import android.view.KeyEvent;
import android.view.KeyEvent.Callback;

final class b
  implements KeyEvent.Callback
{
  b(TransportMediator paramTransportMediator)
  {
  }

  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (TransportMediator.a(paramInt))
      return this.a.a.onMediaButtonDown(paramInt, paramKeyEvent);
    return false;
  }

  public final boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }

  public final boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    return false;
  }

  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (TransportMediator.a(paramInt))
      return this.a.a.onMediaButtonUp(paramInt, paramKeyEvent);
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.b
 * JD-Core Version:    0.6.2
 */