package com.tencent.connect.auth;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

final class n extends Handler
{
  private m a;

  public n(m paramm, Looper paramLooper)
  {
    super(paramLooper);
    this.a = paramm;
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    do
    {
      return;
      m.a(this.a, (String)paramMessage.obj);
      return;
      this.a.onCancel();
      return;
    }
    while ((AuthDialog.a() == null) || (AuthDialog.a().get() == null));
    AuthDialog.a((Context)AuthDialog.a().get(), (String)paramMessage.obj);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.n
 * JD-Core Version:    0.6.2
 */