package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class MTimerHandler extends Handler
{
  private static int a;
  private final int b;
  private final boolean c;
  private long d = 0L;
  private final MTimerHandler.CallBack e;

  public MTimerHandler(Looper paramLooper, MTimerHandler.CallBack paramCallBack, boolean paramBoolean)
  {
    super(paramLooper);
    this.e = paramCallBack;
    this.b = a();
    this.c = paramBoolean;
  }

  public MTimerHandler(MTimerHandler.CallBack paramCallBack, boolean paramBoolean)
  {
    this.e = paramCallBack;
    this.b = a();
    this.c = paramBoolean;
  }

  private static int a()
  {
    if (a >= 8192)
      a = 0;
    int i = 1 + a;
    a = i;
    return i;
  }

  protected void finalize()
  {
    stopTimer();
    super.finalize();
  }

  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what != this.b) || (this.e == null));
    while ((!this.e.onTimerExpired()) || (!this.c))
      return;
    sendEmptyMessageDelayed(this.b, this.d);
  }

  public void startTimer(long paramLong)
  {
    this.d = paramLong;
    stopTimer();
    sendEmptyMessageDelayed(this.b, paramLong);
  }

  public void stopTimer()
  {
    removeMessages(this.b);
  }

  public boolean stopped()
  {
    return !hasMessages(this.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MTimerHandler
 * JD-Core Version:    0.6.2
 */