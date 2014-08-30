package com.tencent.mm.sdk.platformtools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class z
  implements MediaPlayer.OnCompletionListener
{
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.z
 * JD-Core Version:    0.6.2
 */