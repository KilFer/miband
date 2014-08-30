package com.tencent.connect.auth;

import android.text.TextUtils;
import com.tencent.a.a.c;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

final class a
  implements IUiListener
{
  a(AuthAgent paramAuthAgent)
  {
  }

  public final void onCancel()
  {
  }

  public final void onComplete(Object paramObject)
  {
    if (paramObject == null)
      AuthAgent.e(this.a);
    while (true)
    {
      this.a.writeEncryToken(AuthAgent.f(this.a));
      return;
      JSONObject localJSONObject = (JSONObject)paramObject;
      try
      {
        String str2 = localJSONObject.getString("encry_token");
        str1 = str2;
        if (!TextUtils.isEmpty(str1))
        {
          c.b("openSDK_LOG", "OpenUi, EncrytokenListener() onComplete validToken");
          AuthAgent.a(this.a, str1);
        }
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          localJSONException.printStackTrace();
          c.a("openSDK_LOG", "OpenUi, EncrytokenListener() onComplete error", localJSONException);
          String str1 = null;
        }
        c.b("openSDK_LOG", "OpenUi, EncrytokenListener() onComplete relogin");
        AuthAgent.e(this.a);
      }
    }
  }

  public final void onError(UiError paramUiError)
  {
    c.b("openSDK_LOG", "AuthAgent, EncrytokenListener() onError relogin");
    AuthAgent.e(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.a
 * JD-Core Version:    0.6.2
 */