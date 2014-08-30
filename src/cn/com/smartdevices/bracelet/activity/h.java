package cn.com.smartdevices.bracelet.activity;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils.OperationCallback;

final class h
  implements Utils.OperationCallback
{
  h(LoginActivity paramLoginActivity)
  {
  }

  public final void onFailure()
  {
    Debug.i("LoginActivity", "Update sh fail ");
    LoginActivity.j(this.a);
  }

  public final void onSuccess()
  {
    Debug.i("LoginActivity", "Update sh ok");
    LoginActivity.j(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.h
 * JD-Core Version:    0.6.2
 */