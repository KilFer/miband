package com.tencent.connect.auth;

import android.os.Handler;
import android.os.Message;

final class k
{
  private k(AuthDialog paramAuthDialog)
  {
  }

  public final void a()
  {
    a(null);
  }

  public final void a(String paramString)
  {
    AuthDialog.f(this.a).obtainMessage(2, null).sendToTarget();
    this.a.dismiss();
  }

  public final void b(String paramString)
  {
    AuthDialog.f(this.a).obtainMessage(3, paramString).sendToTarget();
  }

  public final void c(String paramString)
  {
    AuthDialog.f(this.a).obtainMessage(4, paramString).sendToTarget();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.k
 * JD-Core Version:    0.6.2
 */