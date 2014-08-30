package cn.com.smartdevices.bracelet.activity;

import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import com.xiaomi.account.openauth.AuthorizeApi;

final class g extends AsyncTask<Void, Void, String>
{
  g(LoginActivity paramLoginActivity)
  {
  }

  private String a()
  {
    try
    {
      String str = AuthorizeApi.doHttpGet(this.a, LoginActivity.b(), this.a.a.longValue(), this.a.d, this.a.b, this.a.c);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }

  private void a(String paramString)
  {
    super.onPostExecute(paramString);
    Debug.i("LoginActivity", "get user phone: " + paramString);
    LoginActivity.a(this.a, WebRes.parseXiaoMiUserPhone(paramString));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.g
 * JD-Core Version:    0.6.2
 */