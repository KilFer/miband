package com.handmark.pulltorefresh.library.extras;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnPullEventListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.State;
import java.util.HashMap;

public class SoundPullEventListener<V extends View>
  implements PullToRefreshBase.OnPullEventListener<V>
{
  private final Context a;
  private final HashMap<PullToRefreshBase.State, Integer> b;
  private MediaPlayer c;

  public SoundPullEventListener(Context paramContext)
  {
    this.a = paramContext;
    this.b = new HashMap();
  }

  private void a(int paramInt)
  {
    if (this.c != null)
    {
      this.c.stop();
      this.c.release();
    }
    this.c = MediaPlayer.create(this.a, paramInt);
    if (this.c != null)
      this.c.start();
  }

  public void addSoundEvent(PullToRefreshBase.State paramState, int paramInt)
  {
    this.b.put(paramState, Integer.valueOf(paramInt));
  }

  public void clearSounds()
  {
    this.b.clear();
  }

  public MediaPlayer getCurrentMediaPlayer()
  {
    return this.c;
  }

  public final void onPullEvent(PullToRefreshBase<V> paramPullToRefreshBase, PullToRefreshBase.State paramState, PullToRefreshBase.Mode paramMode)
  {
    Integer localInteger = (Integer)this.b.get(paramState);
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      if (this.c != null)
      {
        this.c.stop();
        this.c.release();
      }
      this.c = MediaPlayer.create(this.a, i);
      if (this.c != null)
        this.c.start();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.extras.SoundPullEventListener
 * JD-Core Version:    0.6.2
 */