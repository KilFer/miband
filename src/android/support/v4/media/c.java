package android.support.v4.media;

import android.view.KeyEvent;

class c
{
  c(TransportMediator paramTransportMediator)
  {
  }

  public long b()
  {
    return this.a.a.onGetCurrentPosition();
  }

  public void b(int paramInt)
  {
    this.a.a.onAudioFocusChange(paramInt);
  }

  public void b(long paramLong)
  {
    this.a.a.onSeekTo(paramLong);
  }

  public void b(KeyEvent paramKeyEvent)
  {
    paramKeyEvent.dispatch(this.a.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.c
 * JD-Core Version:    0.6.2
 */