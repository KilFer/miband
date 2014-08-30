package com.tencent.connect.auth;

import android.app.Dialog;
import android.view.View;
import com.tencent.tauth.IUiListener;

final class e extends g
{
  e(c paramc, Dialog paramDialog, IUiListener paramIUiListener, Object paramObject)
  {
    super(paramc, paramDialog);
  }

  public final void onClick(View paramView)
  {
    if ((this.a != null) && (this.a.isShowing()))
      this.a.dismiss();
    if (this.b != null)
      this.b.onComplete(this.c);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.e
 * JD-Core Version:    0.6.2
 */