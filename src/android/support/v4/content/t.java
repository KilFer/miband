package android.support.v4.content;

import android.os.Handler;
import android.os.Message;

final class t extends Handler
{
  public final void handleMessage(Message paramMessage)
  {
    j localj = (j)paramMessage.obj;
    switch (paramMessage.what)
    {
    default:
      return;
    case 1:
      ModernAsyncTask.c(localj.a, localj.b[0]);
      return;
    case 2:
    }
    ModernAsyncTask.b();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.t
 * JD-Core Version:    0.6.2
 */