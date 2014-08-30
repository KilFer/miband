package com.tencent.tauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.a.a.c;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.avatar.QQAvatar;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialApi;
import com.tencent.open.TaskGuide;
import com.tencent.utils.HttpUtils;
import com.tencent.utils.SystemUtils;
import org.json.JSONObject;

public class Tencent
{
  private QQAuth a;
  private Context b;
  private LocationApi c;

  private Tencent(String paramString, Context paramContext)
  {
    this.b = paramContext;
    this.a = QQAuth.createInstance(paramString, paramContext);
  }

  // ERROR //
  private static boolean a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 30	android/content/ComponentName
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 36	android/content/Context:getPackageName	()Ljava/lang/String;
    //   8: ldc 38
    //   10: invokespecial 41	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_0
    //   15: invokevirtual 45	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   18: aload_2
    //   19: iconst_0
    //   20: invokevirtual 51	android/content/pm/PackageManager:getActivityInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   23: pop
    //   24: new 30	android/content/ComponentName
    //   27: dup
    //   28: aload_0
    //   29: invokevirtual 36	android/content/Context:getPackageName	()Ljava/lang/String;
    //   32: ldc 53
    //   34: invokespecial 41	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: astore 8
    //   39: aload_0
    //   40: invokevirtual 45	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   43: aload 8
    //   45: iconst_0
    //   46: invokevirtual 51	android/content/pm/PackageManager:getActivityInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   49: pop
    //   50: iconst_1
    //   51: ireturn
    //   52: astore_3
    //   53: new 55	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 57
    //   59: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload_1
    //   63: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 66
    //   68: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 4
    //   76: new 55	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   83: aload 4
    //   85: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 72
    //   90: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 74
    //   99: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 76
    //   104: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore 5
    //   112: invokestatic 81	com/tencent/a/a/c:a	()Lcom/tencent/a/a/c;
    //   115: pop
    //   116: ldc 83
    //   118: aload 5
    //   120: invokestatic 86	com/tencent/a/a/c:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: iconst_0
    //   124: ireturn
    //   125: astore 9
    //   127: new 55	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   134: ldc 88
    //   136: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc 90
    //   141: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: astore 10
    //   149: invokestatic 81	com/tencent/a/a/c:a	()Lcom/tencent/a/a/c;
    //   152: pop
    //   153: ldc 92
    //   155: aload 10
    //   157: invokestatic 86	com/tencent/a/a/c:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: iconst_0
    //   161: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	24	52	android/content/pm/PackageManager$NameNotFoundException
    //   24	50	125	android/content/pm/PackageManager$NameNotFoundException
  }

  public static Tencent createInstance(String paramString, Context paramContext)
  {
    Tencent localTencent = new Tencent(paramString, paramContext);
    if (!a(paramContext, paramString))
      return null;
    c.a("openSDK_LOG", "createInstance()  --end");
    return localTencent;
  }

  public int ask(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new SocialApi(paramActivity, this.a.getQQToken()).ask(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }

  public int brag(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new SocialApi(paramActivity, this.a.getQQToken()).brag(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }

  public int challenge(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new SocialApi(paramActivity, this.a.getQQToken()).challenge(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }

  public int deleteLocation(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    if (this.c == null)
      this.c = new LocationApi(paramActivity, this.a.getQQToken());
    this.c.deleteLocation(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }

  public String getAccessToken()
  {
    return this.a.getQQToken().getAccessToken();
  }

  public String getAppId()
  {
    return this.a.getQQToken().getAppId();
  }

  public long getExpiresIn()
  {
    return this.a.getQQToken().getExpireTimeInSecond();
  }

  public String getOpenId()
  {
    return this.a.getQQToken().getOpenId();
  }

  public QQToken getQQToken()
  {
    return this.a.getQQToken();
  }

  public int gift(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new SocialApi(paramActivity, this.a.getQQToken()).gift(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }

  public void grade(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new SocialApi(paramActivity, this.a.getQQToken()).grade(paramActivity, paramBundle, paramIUiListener);
  }

  public int invite(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new SocialApi(paramActivity, this.a.getQQToken()).invite(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }

  public boolean isReady()
  {
    return (isSessionValid()) && (getOpenId() != null);
  }

  public boolean isSessionValid()
  {
    return this.a.isSessionValid();
  }

  public boolean isSupportSSOLogin(Activity paramActivity)
  {
    if (SystemUtils.getAppVersionName(paramActivity, "com.tencent.mobileqq") == null)
    {
      Toast.makeText(paramActivity, "没有安装手Q", 0).show();
      return false;
    }
    if (SystemUtils.checkMobileQQ(paramActivity))
    {
      Toast.makeText(paramActivity, "已安装的手Q版本支持SSO登陆", 0).show();
      return true;
    }
    Toast.makeText(paramActivity, "已安装的手Q版本不支持SSO登陆", 0).show();
    return false;
  }

  public int login(Activity paramActivity, String paramString, IUiListener paramIUiListener)
  {
    return this.a.login(paramActivity, paramString, paramIUiListener);
  }

  public int loginWithOEM(Activity paramActivity, String paramString1, IUiListener paramIUiListener, String paramString2, String paramString3, String paramString4)
  {
    return this.a.loginWithOEM(paramActivity, paramString1, paramIUiListener, paramString2, paramString3, paramString4);
  }

  public void logout(Context paramContext)
  {
    this.a.getQQToken().setAccessToken(null, "0");
    this.a.getQQToken().setOpenId(null);
  }

  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }

  public int reAuth(Activity paramActivity, String paramString, IUiListener paramIUiListener)
  {
    return this.a.reAuth(paramActivity, paramString, paramIUiListener);
  }

  public int reactive(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new SocialApi(paramActivity, this.a.getQQToken()).reactive(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }

  public JSONObject request(String paramString1, Bundle paramBundle, String paramString2)
  {
    return HttpUtils.request(this.a.getQQToken(), this.b, paramString1, paramBundle, paramString2);
  }

  public void requestAsync(String paramString1, Bundle paramBundle, String paramString2, IRequestListener paramIRequestListener, Object paramObject)
  {
    HttpUtils.requestAsync(this.a.getQQToken(), this.b, paramString1, paramBundle, paramString2, paramIRequestListener);
  }

  public int searchNearby(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    if (this.c == null)
      this.c = new LocationApi(paramActivity, this.a.getQQToken());
    this.c.searchNearby(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }

  public void setAccessToken(String paramString1, String paramString2)
  {
    c.a("openSDK_LOG", "setAccessToken(), expiresIn = " + paramString2);
    this.a.setAccessToken(paramString1, paramString2);
  }

  public void setAvatar(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    String str = paramBundle.getString("picture");
    int i = paramBundle.getInt("exitAnim");
    new QQAvatar(this.b, this.a.getQQToken()).setAvatar(paramActivity, Uri.parse(str), paramIUiListener, i);
  }

  public void setAvatar(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener, int paramInt1, int paramInt2)
  {
    paramBundle.putInt("exitAnim", paramInt2);
    paramActivity.overridePendingTransition(paramInt1, 0);
    setAvatar(paramActivity, paramBundle, paramIUiListener);
  }

  public void setOpenId(String paramString)
  {
    c.a("openSDK_LOG", "setOpenId() --start");
    this.a.setOpenId(this.b, paramString);
    c.a("openSDK_LOG", "setOpenId() --end");
  }

  public void shareToQQ(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new QQShare(paramActivity, this.a.getQQToken()).shareToQQ(paramActivity, paramBundle, paramIUiListener);
  }

  public void shareToQzone(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new QzoneShare(paramActivity, this.a.getQQToken()).shareToQzone(paramActivity, paramBundle, paramIUiListener);
  }

  public void showTaskGuideWindow(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new TaskGuide(paramActivity, this.a.getQQToken()).showTaskGuideWindow(paramActivity, paramBundle, paramIUiListener);
  }

  public int story(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new SocialApi(paramActivity, this.a.getQQToken()).story(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }

  public void voice(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new SocialApi(paramActivity, this.a.getQQToken()).voice(paramActivity, paramBundle, paramIUiListener);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.tauth.Tencent
 * JD-Core Version:    0.6.2
 */