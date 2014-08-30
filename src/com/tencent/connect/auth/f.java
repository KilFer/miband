package com.tencent.connect.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.tauth.IUiListener;

final class f
  implements DialogInterface.OnCancelListener
{
  f(c paramc, IUiListener paramIUiListener, Object paramObject)
  {
  }

  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a != null)
      this.a.onComplete(this.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.f
 * JD-Core Version:    0.6.2
 */