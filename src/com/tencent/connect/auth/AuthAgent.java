package com.tencent.connect.auth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.BaseApi.ApiTask;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.HttpUtils;
import com.tencent.utils.ServerSetting;
import com.tencent.utils.SystemUtils;
import com.tencent.utils.Util;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthAgent extends BaseApi
{
  private IUiListener a;
  private String b;
  private Activity c;
  private IUiListener d = new a(this);
  private Handler e = new b(this);

  public AuthAgent(Context paramContext, QQToken paramQQToken)
  {
    super(paramContext, paramQQToken);
  }

  private int a(boolean paramBoolean, IUiListener paramIUiListener)
  {
    com.tencent.a.a.c.a("openSDK_LOG", "OpenUi, showDialog --start");
    CookieSyncManager.createInstance(this.mContext);
    Bundle localBundle = composeCGIParams();
    if (paramBoolean)
      localBundle.putString("isadd", "1");
    localBundle.putString("scope", this.b);
    localBundle.putString("client_id", this.mToken.getAppId());
    if (isOEM)
      localBundle.putString("pf", "desktop_m_qq-" + installChannel + "-android" + "-" + registerChannel + "-" + businessId);
    while (true)
    {
      String str1 = System.currentTimeMillis() / 1000L;
      localBundle.putString("sign", SystemUtils.getAppSignatureMD5(this.mContext, str1));
      localBundle.putString("time", str1);
      localBundle.putString("display", "mobile");
      localBundle.putString("response_type", "token");
      localBundle.putString("redirect_uri", "auth://tauth.qq.com/");
      localBundle.putString("cancel_display", "1");
      localBundle.putString("switch", "1");
      localBundle.putString("status_userip", Util.getUserIp());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ServerSetting.getInstance().getEnvUrl(this.mContext, "https://openmobile.qq.com/oauth2.0/m_authorize?"));
      localStringBuilder.append(Util.encodeUrl(localBundle));
      String str2 = localStringBuilder.toString();
      i locali = new i(this, this.mContext, paramIUiListener, true);
      com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, showDialog TDialog");
      new AuthDialog(this.c, "action_login", str2, locali, this.mToken).show();
      return 2;
      localBundle.putString("pf", "openmobile_android");
    }
  }

  private void a()
  {
    this.mToken.setAccessToken("", "0");
    this.mToken.setOpenId("");
    doLogin(this.c, this.b, this.a, true);
  }

  private void a(String paramString)
  {
    com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, EncrytokenListener() validToken()");
    Bundle localBundle = composeCGIParams();
    localBundle.putString("encrytoken", paramString);
    HttpUtils.requestAsync(this.mToken, this.mContext, "https://openmobile.qq.com/user/user_login_statis", localBundle, "POST", new h(this));
  }

  private boolean a(Activity paramActivity, boolean paramBoolean)
  {
    Intent localIntent = getTargetActivityIntent("com.tencent.open.agent.AgentActivity");
    if (localIntent != null)
    {
      Bundle localBundle = composeCGIParams();
      if (paramBoolean)
        localBundle.putString("isadd", "1");
      localBundle.putString("scope", this.b);
      localBundle.putString("client_id", this.mToken.getAppId());
      if (isOEM)
        localBundle.putString("pf", "desktop_m_qq-" + installChannel + "-android" + "-" + registerChannel + "-" + businessId);
      while (true)
      {
        localBundle.putString("need_pay", "1");
        localBundle.putString("oauth_app_name", SystemUtils.getAppName(this.mContext));
        String str = System.currentTimeMillis() / 1000L;
        localBundle.putString("sign", SystemUtils.getAppSignatureMD5(this.mContext, str));
        localBundle.putString("time", str);
        localIntent.putExtra("key_action", "action_login");
        localIntent.putExtra("key_params", localBundle);
        this.mActivityIntent = localIntent;
        if (!hasActivityForIntent())
          break;
        this.a = new c(this, this.a);
        startAssitActivity(paramActivity, this.a);
        return true;
        localBundle.putString("pf", "openmobile_android");
      }
    }
    return false;
  }

  public int doLogin(Activity paramActivity, String paramString, IUiListener paramIUiListener)
  {
    return doLogin(paramActivity, paramString, paramIUiListener, false, false);
  }

  public int doLogin(Activity paramActivity, String paramString, IUiListener paramIUiListener, boolean paramBoolean)
  {
    return doLogin(paramActivity, paramString, paramIUiListener, paramBoolean, false);
  }

  public int doLogin(Activity paramActivity, String paramString, IUiListener paramIUiListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramString;
    this.c = paramActivity;
    this.a = paramIUiListener;
    if (!paramBoolean1)
    {
      String str4 = this.mToken.getAccessToken();
      String str5 = this.mToken.getOpenId();
      String str6 = this.mToken.getAppId();
      if ((!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty(str6)))
      {
        Intent localIntent2 = getTargetActivityIntent("com.tencent.open.agent.AgentActivity");
        Intent localIntent3 = getTargetActivityIntent("com.tencent.open.agent.EncryTokenActivity");
        if ((localIntent3 != null) && (localIntent2 != null) && (localIntent2.getComponent() != null) && (localIntent3.getComponent() != null) && (localIntent2.getComponent().getPackageName().equals(localIntent3.getComponent().getPackageName())))
        {
          localIntent3.putExtra("oauth_consumer_key", str6);
          localIntent3.putExtra("openid", str5);
          localIntent3.putExtra("access_token", str4);
          localIntent3.putExtra("key_action", "action_check_token");
          this.mActivityIntent = localIntent3;
          if (hasActivityForIntent())
            startAssitActivity(paramActivity, this.d);
        }
        while (true)
        {
          return 3;
          String str7 = Util.encrypt("tencent&sdk&qazxc***14969%%" + str4 + str6 + str5 + "qzone3.4");
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("encry_token", str7);
            this.d.onComplete(localJSONObject);
          }
          catch (JSONException localJSONException)
          {
            while (true)
              localJSONException.printStackTrace();
          }
        }
      }
    }
    Intent localIntent1 = getTargetActivityIntent("com.tencent.open.agent.AgentActivity");
    Bundle localBundle2;
    if (localIntent1 != null)
    {
      localBundle2 = composeCGIParams();
      if (paramBoolean2)
        localBundle2.putString("isadd", "1");
      localBundle2.putString("scope", this.b);
      localBundle2.putString("client_id", this.mToken.getAppId());
      if (isOEM)
      {
        localBundle2.putString("pf", "desktop_m_qq-" + installChannel + "-android" + "-" + registerChannel + "-" + businessId);
        localBundle2.putString("need_pay", "1");
        localBundle2.putString("oauth_app_name", SystemUtils.getAppName(this.mContext));
        String str3 = System.currentTimeMillis() / 1000L;
        localBundle2.putString("sign", SystemUtils.getAppSignatureMD5(this.mContext, str3));
        localBundle2.putString("time", str3);
        localIntent1.putExtra("key_action", "action_login");
        localIntent1.putExtra("key_params", localBundle2);
        this.mActivityIntent = localIntent1;
        if (!hasActivityForIntent())
          break label585;
        this.a = new c(this, this.a);
        startAssitActivity(paramActivity, this.a);
      }
    }
    label585: for (int i = 1; ; i = 0)
    {
      if (i == 0)
        break label591;
      if (paramBoolean1)
        Util.reportBernoulli(paramActivity, "10785", 0L, this.mToken.getAppId());
      com.tencent.a.a.c.a("openSDK_LOG", "OpenUi, showUi, return Constants.UI_ACTIVITY");
      return 1;
      localBundle2.putString("pf", "openmobile_android");
      break;
    }
    label591: this.a = new c(this, this.a);
    IUiListener localIUiListener = this.a;
    com.tencent.a.a.c.a("openSDK_LOG", "OpenUi, showDialog --start");
    CookieSyncManager.createInstance(this.mContext);
    Bundle localBundle1 = composeCGIParams();
    if (paramBoolean2)
      localBundle1.putString("isadd", "1");
    localBundle1.putString("scope", this.b);
    localBundle1.putString("client_id", this.mToken.getAppId());
    if (isOEM)
      localBundle1.putString("pf", "desktop_m_qq-" + installChannel + "-android" + "-" + registerChannel + "-" + businessId);
    while (true)
    {
      String str1 = System.currentTimeMillis() / 1000L;
      localBundle1.putString("sign", SystemUtils.getAppSignatureMD5(this.mContext, str1));
      localBundle1.putString("time", str1);
      localBundle1.putString("display", "mobile");
      localBundle1.putString("response_type", "token");
      localBundle1.putString("redirect_uri", "auth://tauth.qq.com/");
      localBundle1.putString("cancel_display", "1");
      localBundle1.putString("switch", "1");
      localBundle1.putString("status_userip", Util.getUserIp());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ServerSetting.getInstance().getEnvUrl(this.mContext, "https://openmobile.qq.com/oauth2.0/m_authorize?"));
      localStringBuilder.append(Util.encodeUrl(localBundle1));
      String str2 = localStringBuilder.toString();
      i locali = new i(this, this.mContext, localIUiListener, true);
      com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, showDialog TDialog");
      new AuthDialog(this.c, "action_login", str2, locali, this.mToken).show();
      return 2;
      localBundle1.putString("pf", "openmobile_android");
    }
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.mTaskList.iterator();
    BaseApi.ApiTask localApiTask;
    do
    {
      boolean bool = localIterator.hasNext();
      localIUiListener = null;
      if (!bool)
        break;
      localApiTask = (BaseApi.ApiTask)localIterator.next();
    }
    while (localApiTask.mRequestCode != paramInt1);
    IUiListener localIUiListener = localApiTask.mListener;
    this.mTaskList.remove(localApiTask);
    if (localIUiListener == null)
      return;
    int i;
    String str1;
    if (paramInt2 == -1)
    {
      i = paramIntent.getIntExtra("key_error_code", 0);
      if (i == 0)
      {
        str1 = paramIntent.getStringExtra("key_response");
        if (str1 == null);
      }
    }
    while (true)
    {
      try
      {
        JSONObject localJSONObject = Util.parseJson(str1);
        if (localIUiListener == this.a)
        {
          String str2 = localJSONObject.getString("access_token");
          String str3 = localJSONObject.getString("expires_in");
          String str4 = localJSONObject.getString("openid");
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)))
          {
            this.mToken.setAccessToken(str2, str3);
            this.mToken.setOpenId(str4);
          }
        }
        localIUiListener.onComplete(localJSONObject);
        com.tencent.a.a.c.a().b();
        return;
      }
      catch (JSONException localJSONException)
      {
        localIUiListener.onError(new UiError(-4, "服务器返回数据格式有误!", str1));
        com.tencent.a.a.c.a("openSDK_LOG", "OpenUi, onActivityResult, json error", localJSONException);
        continue;
      }
      com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, onActivityResult, onComplete");
      localIUiListener.onComplete(new JSONObject());
      continue;
      com.tencent.a.a.c.d("openSDK_LOG", "OpenUi, onActivityResult, onError = " + i);
      localIUiListener.onError(new UiError(i, paramIntent.getStringExtra("key_error_msg"), paramIntent.getStringExtra("key_error_detail")));
      continue;
      com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, onActivityResult, Constants.ACTIVITY_CANCEL");
      localIUiListener.onCancel();
    }
  }

  public void writeEncryToken(Context paramContext)
  {
    String str1 = this.mToken.getAccessToken();
    String str2 = this.mToken.getAppId();
    String str3 = this.mToken.getOpenId();
    if ((str1 != null) && (str1.length() > 0) && (str2 != null) && (str2.length() > 0) && (str3 != null) && (str3.length() > 0));
    for (String str4 = Util.encrypt("tencent&sdk&qazxc***14969%%" + str1 + str2 + str3 + "qzone3.4"); ; str4 = null)
    {
      WebView localWebView = new WebView(paramContext);
      WebSettings localWebSettings = localWebView.getSettings();
      localWebSettings.setDomStorageEnabled(true);
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setDatabaseEnabled(true);
      String str5 = "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.mToken.getOpenId() + "_" + this.mToken.getAppId() + "\"]=\"" + str4 + "\";</script></head><body></body></html>";
      String str6 = ServerSetting.getInstance().getEnvUrl(paramContext, "http://qzs.qq.com");
      localWebView.loadDataWithBaseURL(str6, str5, "text/html", "utf-8", str6);
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.AuthAgent
 * JD-Core Version:    0.6.2
 */