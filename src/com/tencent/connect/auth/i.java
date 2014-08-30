package com.tencent.connect.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.webkit.CookieSyncManager;
import com.tencent.a.a.c;
import com.tencent.connect.a.a;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

final class i
  implements IUiListener
{
  private IUiListener a;
  private boolean b;
  private Context c;

  public i(AuthAgent paramAuthAgent, Context paramContext, IUiListener paramIUiListener, boolean paramBoolean)
  {
    this.c = paramContext;
    this.a = paramIUiListener;
    this.b = true;
    c.b("openSDK_LOG", "OpenUi, TokenListener()");
  }

  public final void onCancel()
  {
    c.b("openSDK_LOG", "OpenUi, TokenListener() onCancel");
    this.a.onCancel();
    c.a().b();
  }

  public final void onComplete(Object paramObject)
  {
    c.b("openSDK_LOG", "OpenUi, TokenListener() onComplete");
    JSONObject localJSONObject = (JSONObject)paramObject;
    try
    {
      String str1 = localJSONObject.getString("access_token");
      String str2 = localJSONObject.getString("expires_in");
      String str3 = localJSONObject.getString("openid");
      if ((str1 != null) && (AuthAgent.a(this.d) != null) && (str3 != null))
      {
        AuthAgent.b(this.d).setAccessToken(str1, str2);
        AuthAgent.c(this.d).setOpenId(str3);
        a.d(this.c, AuthAgent.d(this.d));
      }
      String str4 = localJSONObject.getString("pf");
      if (str4 != null);
      try
      {
        this.c.getSharedPreferences("pfStore", 0).edit().putString("pf", str4).commit();
        if (this.b)
          CookieSyncManager.getInstance().sync();
        this.a.onComplete(localJSONObject);
        c.a().b();
        return;
      }
      catch (Exception localException)
      {
        while (true)
        {
          localException.printStackTrace();
          c.a("openSDK_LOG", "OpenUi, TokenListener() onComplete error", localException);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        localJSONException.printStackTrace();
        c.a("openSDK_LOG", "OpenUi, TokenListener() onComplete error", localJSONException);
      }
    }
  }

  public final void onError(UiError paramUiError)
  {
    c.b("openSDK_LOG", "OpenUi, TokenListener() onError");
    this.a.onError(paramUiError);
    c.a().b();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.i
 * JD-Core Version:    0.6.2
 */