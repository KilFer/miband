package cn.com.smartdevices.bracelet.activity;

import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONObject;

final class f extends AsyncHttpResponseHandler
{
  f(e parame)
  {
  }

  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    String str = Utils.getStringFromBytes(paramArrayOfByte);
    Debug.i("LoginActivity", "fail, content =" + str + " statusCode=" + paramInt);
    LoginActivity.i(e.a(this.a));
  }

  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    String str1 = Utils.getStringFromBytes(paramArrayOfByte);
    Debug.i("LoginActivity", "login result content =" + str1);
    WebStatus localWebStatus = WebRes.getWebStatus(str1);
    if (!localWebStatus.success())
    {
      Toast.makeText(e.a(this.a), e.a(this.a).getString(2131492876) + "，" + e.a(this.a).getString(2131493073) + ":" + localWebStatus.code, 1).show();
      LoginActivity.g(e.a(this.a));
      return;
    }
    while (true)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(str1).optJSONObject("data");
        if (localJSONObject == null)
          break;
        Long localLong = Long.valueOf(Long.parseLong(localJSONObject.optString("userid")));
        String str2 = localJSONObject.optString("security");
        Keeper.keepLoginData(localLong.longValue(), str2);
        if (localJSONObject.optString("hasBinded").equals("1"))
        {
          bool = true;
          PersonInfo localPersonInfo = Keeper.readPersonInfo();
          if (bool)
            localPersonInfo = WebRes.parseBindedUserInfo(localJSONObject.toString(), localPersonInfo);
          localPersonInfo.uid = localLong.longValue();
          Keeper.keepPersonInfo(localPersonInfo);
          LoginActivity.a(e.a(this.a), bool);
          return;
        }
      }
      catch (Exception localException)
      {
        Debug.i("LoginActivity", "Catched exception: " + localException);
        localException.printStackTrace();
        LoginActivity.i(e.a(this.a));
        return;
      }
      boolean bool = false;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.f
 * JD-Core Version:    0.6.2
 */