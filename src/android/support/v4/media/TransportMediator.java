package android.support.v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;
import android.view.Window;
import java.util.ArrayList;

public class TransportMediator extends TransportController
{
  public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 64;
  public static final int FLAG_KEY_MEDIA_NEXT = 128;
  public static final int FLAG_KEY_MEDIA_PAUSE = 16;
  public static final int FLAG_KEY_MEDIA_PLAY = 4;
  public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8;
  public static final int FLAG_KEY_MEDIA_PREVIOUS = 1;
  public static final int FLAG_KEY_MEDIA_REWIND = 2;
  public static final int FLAG_KEY_MEDIA_STOP = 32;
  public static final int KEYCODE_MEDIA_PAUSE = 127;
  public static final int KEYCODE_MEDIA_PLAY = 126;
  public static final int KEYCODE_MEDIA_RECORD = 130;
  final TransportPerformer a;
  final KeyEvent.Callback b = new b(this);
  private Context c;
  private AudioManager d;
  private View e;
  private Object f;
  private d g;
  private ArrayList<TransportStateListener> h = new ArrayList();
  private c i = new c(this);

  public TransportMediator(Activity paramActivity, TransportPerformer paramTransportPerformer)
  {
    this(paramActivity, null, paramTransportPerformer);
  }

  private TransportMediator(Activity paramActivity, View paramView, TransportPerformer paramTransportPerformer)
  {
    if (paramActivity != null);
    for (Object localObject = paramActivity; ; localObject = paramView.getContext())
    {
      this.c = ((Context)localObject);
      this.a = paramTransportPerformer;
      this.d = ((AudioManager)this.c.getSystemService("audio"));
      if (paramActivity != null)
        paramView = paramActivity.getWindow().getDecorView();
      this.e = paramView;
      this.f = KeyEventCompat.getKeyDispatcherState(this.e);
      if (Build.VERSION.SDK_INT < 18)
        break;
      this.g = new d(this.c, this.d, this.e, this.i);
      return;
    }
    this.g = null;
  }

  public TransportMediator(View paramView, TransportPerformer paramTransportPerformer)
  {
    this(null, paramView, paramTransportPerformer);
  }

  static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return false;
    case 79:
    case 85:
    case 86:
    case 87:
    case 88:
    case 89:
    case 90:
    case 91:
    case 126:
    case 127:
    case 130:
    }
    return true;
  }

  private TransportStateListener[] a()
  {
    if (this.h.size() <= 0)
      return null;
    TransportStateListener[] arrayOfTransportStateListener = new TransportStateListener[this.h.size()];
    this.h.toArray(arrayOfTransportStateListener);
    return arrayOfTransportStateListener;
  }

  private void b()
  {
    TransportStateListener[] arrayOfTransportStateListener = a();
    if (arrayOfTransportStateListener != null)
    {
      int j = arrayOfTransportStateListener.length;
      for (int k = 0; k < j; k++)
        arrayOfTransportStateListener[k].onPlayingChanged(this);
    }
  }

  private void c()
  {
    TransportStateListener[] arrayOfTransportStateListener = a();
    if (arrayOfTransportStateListener != null)
    {
      int j = arrayOfTransportStateListener.length;
      for (int k = 0; k < j; k++)
        arrayOfTransportStateListener[k].onTransportControlsChanged(this);
    }
  }

  private void d()
  {
    if (this.g != null)
      this.g.a(this.a.onIsPlaying(), this.a.onGetCurrentPosition(), this.a.onGetTransportControlFlags());
  }

  public void destroy()
  {
    this.g.b();
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return KeyEventCompat.dispatch(paramKeyEvent, this.b, this.f, this);
  }

  public int getBufferPercentage()
  {
    return this.a.onGetBufferPercentage();
  }

  public long getCurrentPosition()
  {
    return this.a.onGetCurrentPosition();
  }

  public long getDuration()
  {
    return this.a.onGetDuration();
  }

  public Object getRemoteControlClient()
  {
    if (this.g != null)
      return this.g.a();
    return null;
  }

  public int getTransportControlFlags()
  {
    return this.a.onGetTransportControlFlags();
  }

  public boolean isPlaying()
  {
    return this.a.onIsPlaying();
  }

  public void pausePlaying()
  {
    if (this.g != null)
      this.g.f();
    this.a.onPause();
    d();
    b();
  }

  public void refreshState()
  {
    d();
    b();
    TransportStateListener[] arrayOfTransportStateListener = a();
    if (arrayOfTransportStateListener != null)
    {
      int j = arrayOfTransportStateListener.length;
      for (int k = 0; k < j; k++)
        arrayOfTransportStateListener[k].onTransportControlsChanged(this);
    }
  }

  public void registerStateListener(TransportStateListener paramTransportStateListener)
  {
    this.h.add(paramTransportStateListener);
  }

  public void seekTo(long paramLong)
  {
    this.a.onSeekTo(paramLong);
  }

  public void startPlaying()
  {
    if (this.g != null)
      this.g.e();
    this.a.onStart();
    d();
    b();
  }

  public void stopPlaying()
  {
    if (this.g != null)
      this.g.g();
    this.a.onStop();
    d();
    b();
  }

  public void unregisterStateListener(TransportStateListener paramTransportStateListener)
  {
    this.h.remove(paramTransportStateListener);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.TransportMediator
 * JD-Core Version:    0.6.2
 */