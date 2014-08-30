package com.tencent.open;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.ServerSetting;
import com.tencent.utils.SystemUtils;
import com.tencent.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class SocialApiIml extends BaseApi
{
  private Activity a;
  private ProgressDialog b;

  public SocialApiIml(Context paramContext, QQAuth paramQQAuth, QQToken paramQQToken)
  {
    super(paramContext, paramQQAuth, paramQQToken);
  }

  public SocialApiIml(Context paramContext, QQToken paramQQToken)
  {
    super(paramContext, paramQQToken);
  }

  private static c a(Bundle paramBundle, String paramString1, String paramString2, IUiListener paramIUiListener)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(Constants.PACKAGE_QZONE, "com.tencent.open.agent.AgentActivity");
    c localc = new c();
    localc.a = localIntent;
    localc.c = paramBundle;
    localc.d = paramString2;
    localc.e = paramIUiListener;
    localc.b = paramString1;
    return localc;
  }

  private void a(Activity paramActivity, Intent paramIntent, String paramString1, Bundle paramBundle, String paramString2, IUiListener paramIUiListener)
  {
    Log.i("SocialApiIml", "SocialApiIml handleIntent " + paramString1 + " params=" + paramBundle + " activityIntent=" + paramIntent);
    if (paramIntent != null)
    {
      paramIntent.putExtra("key_action", paramString1);
      paramIntent.putExtra("key_params", paramBundle);
      this.mActivityIntent = paramIntent;
      startAssitActivity(paramActivity, paramIUiListener);
    }
    k localk;
    do
    {
      return;
      Intent localIntent1 = getTargetActivityIntent("com.tencent.open.agent.AgentActivity");
      localk = new k(this, paramIUiListener, paramString1, paramString2, paramBundle);
      Intent localIntent2 = getTargetActivityIntent("com.tencent.open.agent.EncryTokenActivity");
      if ((localIntent2 == null) || (localIntent1 == null) || (localIntent1.getComponent() == null) || (localIntent2.getComponent() == null) || (!localIntent1.getComponent().getPackageName().equals(localIntent2.getComponent().getPackageName())))
        break;
      localIntent2.putExtra("oauth_consumer_key", this.mToken.getAppId());
      localIntent2.putExtra("openid", this.mToken.getOpenId());
      localIntent2.putExtra("access_token", this.mToken.getAccessToken());
      localIntent2.putExtra("key_action", "action_check_token");
      this.mActivityIntent = localIntent2;
    }
    while (!hasActivityForIntent());
    startAssitActivity(paramActivity, localk);
    return;
    String str = Util.encrypt("tencent&sdk&qazxc***14969%%" + this.mToken.getAccessToken() + this.mToken.getAppId() + this.mToken.getOpenId() + "qzone3.4");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("encry_token", str);
      localk.onComplete(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  private void a(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    Intent localIntent = getAgentIntentWithTarget("com.tencent.open.agent.voice");
    String str = ServerSetting.getInstance().getEnvUrl(this.mContext, "http://qzs.qq.com/open/mobile/not_support.html?");
    if ((localIntent == null) && (a()))
    {
      if ((this.b == null) || (!this.b.isShowing()))
      {
        this.b = new ProgressDialog(paramActivity);
        this.b.setTitle("请稍候");
        this.b.show();
      }
      a(paramActivity, "action_voice", new SocialApiIml.a(this, a(paramBundle, "action_voice", str, paramIUiListener)));
      return;
    }
    a(paramActivity, localIntent, "action_voice", paramBundle, str, paramIUiListener);
  }

  private void a(Activity paramActivity, String paramString, Bundle paramBundle, IUiListener paramIUiListener)
  {
    this.a = paramActivity;
    Intent localIntent = getAgentIntentWithTarget("com.tencent.open.agent.RequestFreegiftActivity");
    paramBundle.putAll(composeActivityParams());
    if ("action_ask".equals(paramString))
      paramBundle.putString("type", "request");
    while (true)
    {
      a(paramActivity, localIntent, paramString, paramBundle, ServerSetting.getInstance().getEnvUrl(this.mContext, "http://qzs.qq.com/open/mobile/request/sdk_request.html?"), paramIUiListener);
      return;
      if ("action_gift".equals(paramString))
        paramBundle.putString("type", "freegift");
    }
  }

  private void a(Context paramContext, String paramString1, Bundle paramBundle, String paramString2, IUiListener paramIUiListener)
  {
    com.tencent.a.a.c.a("openSDK_LOG", "OpenUi, showDialog --start");
    CookieSyncManager.createInstance(paramContext);
    paramBundle.putString("oauth_consumer_key", this.mToken.getAppId());
    if (this.mToken.isSessionValid())
      paramBundle.putString("access_token", this.mToken.getAccessToken());
    String str1 = this.mToken.getOpenId();
    if (str1 != null)
      paramBundle.putString("openid", str1);
    try
    {
      paramBundle.putString("pf", this.mContext.getSharedPreferences("pfStore", 0).getString("pf", "openmobile_android"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(Util.encodeUrl(paramBundle));
      str2 = localStringBuilder.toString();
      com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, showDialog TDialog");
      if (("action_challenge".equals(paramString1)) || ("action_brag".equals(paramString1)))
      {
        com.tencent.a.a.c.b("openSDK_LOG", "OpenUi, showDialog PKDialog");
        new PKDialog(this.a, paramString1, str2, paramIUiListener, this.mToken).show();
        return;
      }
    }
    catch (Exception localException)
    {
      String str2;
      while (true)
      {
        localException.printStackTrace();
        paramBundle.putString("pf", "openmobile_android");
      }
      new TDialog(this.a, paramString1, str2, paramIUiListener, this.mToken).show();
    }
  }

  private void c()
  {
    if ((!this.a.isFinishing()) && (this.b != null) && (this.b.isShowing()))
    {
      this.b.dismiss();
      this.b = null;
    }
  }

  protected void a(Activity paramActivity, String paramString, IUiListener paramIUiListener)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(Constants.PACKAGE_QZONE, "com.tencent.open.agent.AgentActivity");
    localIntent.putExtra("key_action", "action_check");
    Bundle localBundle = new Bundle();
    localBundle.putString("apiName", paramString);
    localIntent.putExtra("key_params", localBundle);
    this.mActivityIntent = localIntent;
    startAssitActivity(paramActivity, paramIUiListener);
  }

  protected boolean a()
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(Constants.PACKAGE_QZONE, "com.tencent.open.agent.CheckFunctionActivity");
    return SystemUtils.isActivityExist(this.mContext, localIntent);
  }

  public void ask(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    a(paramActivity, "action_ask", paramBundle, paramIUiListener);
  }

  public void brag(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    this.a = paramActivity;
    Intent localIntent = getAgentIntentWithTarget("com.tencent.open.agent.BragActivity");
    paramBundle.putAll(composeActivityParams());
    a(paramActivity, localIntent, "action_brag", paramBundle, ServerSetting.getInstance().getEnvUrl(this.mContext, "http://qzs.qq.com/open/mobile/brag/sdk_brag.html?"), paramIUiListener);
  }

  public void challenge(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    this.a = paramActivity;
    Intent localIntent = getAgentIntentWithTarget("com.tencent.open.agent.ChallengeActivity");
    paramBundle.putAll(composeActivityParams());
    a(paramActivity, localIntent, "action_challenge", paramBundle, ServerSetting.getInstance().getEnvUrl(this.mContext, "http://qzs.qq.com/open/mobile/brag/sdk_brag.html?"), paramIUiListener);
  }

  public void gift(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    a(paramActivity, "action_gift", paramBundle, paramIUiListener);
  }

  public void grade(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    this.a = paramActivity;
    paramBundle.putAll(composeActivityParams());
    paramBundle.putString("version", Util.getAppVersion(paramActivity));
    Intent localIntent = getAgentIntentWithTarget("com.tencent.open.agent.AppGradeActivity");
    if ((localIntent == null) && (a()))
    {
      this.b = new ProgressDialog(paramActivity);
      this.b.setMessage("请稍候...");
      this.b.show();
      a(paramActivity, "action_grade", new SocialApiIml.a(this, a(paramBundle, "action_grade", "http://qzs.qq.com/open/mobile/rate/sdk_rate.html?", paramIUiListener)));
      return;
    }
    a(paramActivity, localIntent, "action_grade", paramBundle, "http://qzs.qq.com/open/mobile/rate/sdk_rate.html?", paramIUiListener);
  }

  public void invite(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    this.a = paramActivity;
    Intent localIntent = getAgentIntentWithTarget("com.tencent.open.agent.AppInvitationActivity");
    paramBundle.putAll(composeActivityParams());
    a(paramActivity, localIntent, "action_invite", paramBundle, ServerSetting.getInstance().getEnvUrl(this.mContext, "http://qzs.qq.com/open/mobile/invite/sdk_invite.html?"), paramIUiListener);
  }

  public void reactive(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    this.a = paramActivity;
    Intent localIntent = getAgentIntentWithTarget("com.tencent.open.agent.ReactiveActivity");
    paramBundle.putAll(composeActivityParams());
    String str = ServerSetting.getInstance().getEnvUrl(this.mContext, "http://qzs.qq.com/open/mobile/reactive/sdk_reactive.html?");
    if ((localIntent == null) && (a()))
    {
      this.b = new ProgressDialog(paramActivity);
      this.b.setMessage("请稍候...");
      this.b.show();
      paramBundle.putString("type", "reactive");
      a(paramActivity, "action_reactive", new SocialApiIml.a(this, a(paramBundle, "action_reactive", str, paramIUiListener)));
      return;
    }
    paramBundle.putString("sendImg", paramBundle.getString("img"));
    paramBundle.remove("img");
    a(paramActivity, localIntent, "action_reactive", paramBundle, str, paramIUiListener);
  }

  public void story(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    this.a = paramActivity;
    Intent localIntent = getAgentIntentWithTarget("com.tencent.open.agent.SendStoryActivity");
    paramBundle.putAll(composeActivityParams());
    a(paramActivity, localIntent, "action_story", paramBundle, ServerSetting.getInstance().getEnvUrl(this.mContext, "http://qzs.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), paramIUiListener);
  }

  public void voice(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    Log.v("voice", "voice params=" + paramBundle);
    this.a = paramActivity;
    paramBundle.putAll(composeActivityParams());
    paramBundle.putString("version", Util.getAppVersion(paramActivity));
    if (!b.a())
    {
      paramIUiListener.onError(new UiError(-12, "检测不到SD卡，无法发送语音！", "检测不到SD卡，无法发送语音！"));
      return;
    }
    if (paramBundle.containsKey("image_date"))
    {
      Bitmap localBitmap = (Bitmap)paramBundle.getParcelable("image_date");
      if (localBitmap != null)
      {
        this.b = new ProgressDialog(paramActivity);
        this.b.setTitle("请稍候，正在查询…");
        this.b.show();
        new b(new i(this, paramBundle, paramActivity, paramIUiListener)).execute(new Bitmap[] { localBitmap });
        return;
      }
    }
    a(paramActivity, paramBundle, paramIUiListener);
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
 * Qualified Name:     com.tencent.open.SocialApiIml
 * JD-Core Version:    0.6.2
 */