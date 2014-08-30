package com.tencent.open;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.a.a.c;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

final class k
  implements IUiListener
{
  private IUiListener a;
  private String b;
  private String c;
  private Bundle d;

  k(SocialApiIml paramSocialApiIml, IUiListener paramIUiListener, String paramString1, String paramString2, Bundle paramBundle)
  {
    this.a = paramIUiListener;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramBundle;
  }

  public final void onCancel()
  {
    this.a.onCancel();
  }

  public final void onComplete(Object paramObject)
  {
    JSONObject localJSONObject = (JSONObject)paramObject;
    try
    {
      String str2 = localJSONObject.getString("encry_token");
      str1 = str2;
      this.d.putString("encrytoken", str1);
      SocialApiIml.a(this.e, SocialApiIml.b(this.e), this.b, this.d, this.c, this.a);
      if (TextUtils.isEmpty(str1))
      {
        Log.d("miles", "The token get from qq or qzone is empty. Write temp token to localstorage.");
        this.e.writeEncryToken(SocialApiIml.c(this.e));
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        localJSONException.printStackTrace();
        c.a("openSDK_LOG", "OpenApi, EncrytokenListener() onComplete error", localJSONException);
        String str1 = null;
      }
    }
  }

  public final void onError(UiError paramUiError)
  {
    c.b("openSDK_LOG", "OpenApi, EncryptTokenListener() onError" + paramUiError.errorMessage);
    this.a.onError(paramUiError);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.k
 * JD-Core Version:    0.6.2
 */