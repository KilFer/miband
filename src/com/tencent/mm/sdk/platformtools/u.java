package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.Message;

final class u extends Handler
{
  u(QueueWorkerThread paramQueueWorkerThread)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null))
      ((QueueWorkerThread.ThreadObject)paramMessage.obj).onPostExecute();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.u
 * JD-Core Version:    0.6.2
 */