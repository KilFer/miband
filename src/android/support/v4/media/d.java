package android.support.v4.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.OnGetPlaybackPositionListener;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnWindowAttachListener;
import android.view.ViewTreeObserver.OnWindowFocusChangeListener;

final class d
  implements RemoteControlClient.OnGetPlaybackPositionListener, RemoteControlClient.OnPlaybackPositionUpdateListener
{
  final c a;
  private Context b;
  private AudioManager c;
  private View d;
  private String e;
  private IntentFilter f;
  private Intent g;
  private ViewTreeObserver.OnWindowAttachListener h = new e(this);
  private ViewTreeObserver.OnWindowFocusChangeListener i = new f(this);
  private BroadcastReceiver j = new g(this);
  private AudioManager.OnAudioFocusChangeListener k = new h(this);
  private PendingIntent l;
  private RemoteControlClient m;
  private boolean n;
  private int o = 0;
  private boolean p;

  public d(Context paramContext, AudioManager paramAudioManager, View paramView, c paramc)
  {
    this.b = paramContext;
    this.c = paramAudioManager;
    this.d = paramView;
    this.a = paramc;
    this.e = (paramContext.getPackageName() + ":transport:" + System.identityHashCode(this));
    this.g = new Intent(this.e);
    this.g.setPackage(paramContext.getPackageName());
    this.f = new IntentFilter();
    this.f.addAction(this.e);
    this.d.getViewTreeObserver().addOnWindowAttachListener(this.h);
    this.d.getViewTreeObserver().addOnWindowFocusChangeListener(this.i);
  }

  private void j()
  {
    if (!this.p)
    {
      this.p = true;
      this.c.requestAudioFocus(this.k, 3, 1);
    }
  }

  private void k()
  {
    if (this.p)
    {
      this.p = false;
      this.c.abandonAudioFocus(this.k);
    }
  }

  public final Object a()
  {
    return this.m;
  }

  public final void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    RemoteControlClient localRemoteControlClient;
    int i1;
    if (this.m != null)
    {
      localRemoteControlClient = this.m;
      if (!paramBoolean)
        break label47;
      i1 = 3;
      if (!paramBoolean)
        break label53;
    }
    label47: label53: for (float f1 = 1.0F; ; f1 = 0.0F)
    {
      localRemoteControlClient.setPlaybackState(i1, paramLong, f1);
      this.m.setTransportControlFlags(paramInt);
      return;
      i1 = 1;
      break;
    }
  }

  public final void b()
  {
    i();
    this.d.getViewTreeObserver().removeOnWindowAttachListener(this.h);
    this.d.getViewTreeObserver().removeOnWindowFocusChangeListener(this.i);
  }

  final void c()
  {
    this.b.registerReceiver(this.j, this.f);
    this.l = PendingIntent.getBroadcast(this.b, 0, this.g, 268435456);
    this.m = new RemoteControlClient(this.l);
    this.m.setOnGetPlaybackPositionListener(this);
    this.m.setPlaybackPositionUpdateListener(this);
  }

  final void d()
  {
    if (!this.n)
    {
      this.n = true;
      this.c.registerMediaButtonEventReceiver(this.l);
      this.c.registerRemoteControlClient(this.m);
      if (this.o == 3)
        j();
    }
  }

  public final void e()
  {
    if (this.o != 3)
    {
      this.o = 3;
      this.m.setPlaybackState(3);
    }
    if (this.n)
      j();
  }

  public final void f()
  {
    if (this.o == 3)
    {
      this.o = 2;
      this.m.setPlaybackState(2);
    }
    k();
  }

  public final void g()
  {
    if (this.o != 1)
    {
      this.o = 1;
      this.m.setPlaybackState(1);
    }
    k();
  }

  final void h()
  {
    k();
    if (this.n)
    {
      this.n = false;
      this.c.unregisterRemoteControlClient(this.m);
      this.c.unregisterMediaButtonEventReceiver(this.l);
    }
  }

  final void i()
  {
    h();
    if (this.l != null)
    {
      this.b.unregisterReceiver(this.j);
      this.l.cancel();
      this.l = null;
      this.m = null;
    }
  }

  public final long onGetPlaybackPosition()
  {
    return this.a.b();
  }

  public final void onPlaybackPositionUpdate(long paramLong)
  {
    this.a.b(paramLong);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.d
 * JD-Core Version:    0.6.2
 */