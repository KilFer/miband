package cn.com.smartdevices.bracelet.activity;

import android.os.AsyncTask;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.LoginInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import com.xiaomi.account.openauth.AuthorizeApi;
import org.json.JSONException;
import org.json.JSONObject;

final class e extends AsyncTask<Void, Void, String>
{
  e(LoginActivity paramLoginActivity)
  {
  }

  private String a()
  {
    try
    {
      String str = AuthorizeApi.doHttpGet(this.a, LoginActivity.a(), this.a.a.longValue(), this.a.d, this.a.b, this.a.c);
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
    Debug.i("LoginActivity", "getXiaoMiUserInfo: " + paramString);
    if (("".equals(paramString)) || (paramString == null))
    {
      LoginActivity.g(this.a);
      Toast.makeText(this.a, 2131492876, 1).show();
      return;
    }
    try
    {
      int j = new JSONObject(paramString).getInt("code");
      i = j;
      if (i == 21308)
      {
        LoginActivity.g(this.a);
        Debug.i("LoginActivity", "code =" + i);
        Toast.makeText(this.a, 2131493017, 1).show();
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        localJSONException.printStackTrace();
        int i = -1;
      }
      WebRes.parseXiaoMiUserProfile(LoginActivity.h(this.a), paramString);
      PersonInfo localPersonInfo = Keeper.readPersonInfo();
      localPersonInfo.nickname = LoginActivity.h(this.a).miliaoNick;
      Keeper.keepPersonInfo(localPersonInfo);
      WebAPI.sendLoginResult(LoginActivity.h(this.a), Keeper.readDeviceId(), new f(this));
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.e
 * JD-Core Version:    0.6.2
 */