package com.tencent.open;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import java.lang.ref.WeakReference;

final class p extends Handler
{
  private o a;

  public p(o paramo, Looper paramLooper)
  {
    super(paramLooper);
    this.a = paramo;
  }

  public final void handleMessage(Message paramMessage)
  {
    Log.d("TAG", "--handleMessage--msg.WHAT = " + paramMessage.what);
    switch (paramMessage.what)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    do
    {
      do
      {
        do
        {
          return;
          o.a(this.a, (String)paramMessage.obj);
          return;
          this.a.onCancel();
          return;
        }
        while ((TDialog.a() == null) || (TDialog.a().get() == null));
        TDialog.a((Context)TDialog.a().get(), (String)paramMessage.obj);
        return;
      }
      while ((TDialog.b() == null) || (TDialog.b().get() == null));
      ((View)TDialog.b().get()).setVisibility(8);
      return;
    }
    while ((TDialog.a() == null) || (TDialog.a().get() == null));
    TDialog.b((Context)TDialog.a().get(), (String)paramMessage.obj);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.p
 * JD-Core Version:    0.6.2
 */