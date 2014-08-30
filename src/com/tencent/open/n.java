package com.tencent.open;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

final class n extends a.a
{
  private n(TDialog paramTDialog)
  {
  }

  private void a()
  {
    Log.d("TDialog", "onCancelAddShare");
    d("cancel");
  }

  private void a(String paramString)
  {
    Log.d("TDialog", "onAddShare");
    c(paramString);
  }

  private void b()
  {
    d("");
  }

  private void b(String paramString)
  {
    c(paramString);
  }

  private void c()
  {
    Log.d("TDialog", "onCancelInvite");
    d("");
  }

  private void c(String paramString)
  {
    TDialog.a(this.a).obtainMessage(1, paramString).sendToTarget();
    Log.e("onComplete", paramString);
    this.a.dismiss();
  }

  private void d(String paramString)
  {
    Log.d("TDialog", "onCancel --msg = " + paramString);
    TDialog.a(this.a).obtainMessage(2, paramString).sendToTarget();
    this.a.dismiss();
  }

  private void e(String paramString)
  {
    TDialog.a(this.a).obtainMessage(3, paramString).sendToTarget();
  }

  private void f(String paramString)
  {
    TDialog.a(this.a).obtainMessage(4, paramString).sendToTarget();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.n
 * JD-Core Version:    0.6.2
 */