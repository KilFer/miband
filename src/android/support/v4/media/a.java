package android.support.v4.media;

import android.view.KeyEvent;

final class a
{
  a(TransportMediator paramTransportMediator)
  {
  }

  public final long a()
  {
    return this.a.a.onGetCurrentPosition();
  }

  public final void a(int paramInt)
  {
    this.a.a.onAudioFocusChange(paramInt);
  }

  public final void a(long paramLong)
  {
    this.a.a.onSeekTo(paramLong);
  }

  public final void a(KeyEvent paramKeyEvent)
  {
    paramKeyEvent.dispatch(this.a.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.a
 * JD-Core Version:    0.6.2
 */