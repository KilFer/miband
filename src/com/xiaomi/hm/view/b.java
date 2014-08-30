package com.xiaomi.hm.view;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

final class b extends Handler
{
  b(GifView paramGifView)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    try
    {
      GifView.a(this.a);
      return;
    }
    catch (Exception localException)
    {
      Log.e("GifView", localException.toString());
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.view.b
 * JD-Core Version:    0.6.2
 */