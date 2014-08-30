package com.sina.weibo.sdk.auth.sso;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuth;
import com.sina.weibo.sdk.auth.WeiboAuth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboDialogException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.SecurityHelper;
import java.util.Iterator;
import java.util.List;

public class SsoHandler
{
  private static final String DEFAULT_SINA_WEIBO_PACKAGE_NAME = "com.sina.weibo";
  private static final String DEFAULT_WEIBO_REMOTE_SSO_SERVICE_NAME = "com.sina.weibo.remotessoservice";
  private static final int REQUEST_CODE_SSO_AUTH = 32973;
  private static final String TAG = "Weibo_SSO_login";
  private Activity mAuthActivity;
  private WeiboAuthListener mAuthListener;
  private ServiceConnection mConnection = new SsoHandler.1(this);
  private int mSSOAuthRequestCode;
  private WeiboAuth mWeibo;

  public SsoHandler(Activity paramActivity, WeiboAuth paramWeiboAuth)
  {
    this.mAuthActivity = paramActivity;
    this.mWeibo = paramWeiboAuth;
  }

  private boolean bindRemoteSSOService(Context paramContext, String paramString)
  {
    int i = 1;
    if ((TextUtils.isEmpty(paramString)) || (paramString.trim().equals("")))
      paramString = "com.sina.weibo";
    Intent localIntent = new Intent("com.sina.weibo.remotessoservice");
    localIntent.setPackage(paramString);
    boolean bool;
    if (!paramContext.bindService(localIntent, this.mConnection, i))
      bool = paramContext.bindService(new Intent("com.sina.weibo.remotessoservice"), this.mConnection, i);
    return bool;
  }

  public static ComponentName isServiceExisted(Context paramContext, String paramString)
  {
    Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647).iterator();
    ComponentName localComponentName;
    do
    {
      if (!localIterator.hasNext())
        return null;
      localComponentName = ((ActivityManager.RunningServiceInfo)localIterator.next()).service;
    }
    while ((!localComponentName.getPackageName().equals(paramString)) || (!localComponentName.getClassName().equals(paramString + ".business.RemoteSSOService")));
    return localComponentName;
  }

  private boolean startSingleSignOn(String paramString1, String paramString2)
  {
    boolean bool = true;
    Intent localIntent = new Intent();
    localIntent.setClassName(paramString1, paramString2);
    localIntent.putExtras(this.mWeibo.getAuthInfo().getAuthBundle());
    localIntent.putExtra("_weibo_command_type", 3);
    localIntent.putExtra("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
    if (!SecurityHelper.validateAppSignatureForIntent(this.mAuthActivity, localIntent))
      return false;
    try
    {
      this.mAuthActivity.startActivityForResult(localIntent, this.mSSOAuthRequestCode);
      this.mAuthActivity.getApplicationContext().unbindService(this.mConnection);
      return bool;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      while (true)
        bool = false;
    }
  }

  public void authorize(int paramInt, WeiboAuthListener paramWeiboAuthListener, String paramString)
  {
    this.mSSOAuthRequestCode = paramInt;
    this.mAuthListener = paramWeiboAuthListener;
    if ((!bindRemoteSSOService(this.mAuthActivity.getApplicationContext(), paramString)) && (this.mWeibo != null))
      this.mWeibo.anthorize(this.mAuthListener);
  }

  public void authorize(WeiboAuthListener paramWeiboAuthListener)
  {
    authorize(32973, paramWeiboAuthListener, null);
  }

  public void authorize(WeiboAuthListener paramWeiboAuthListener, String paramString)
  {
    authorize(32973, paramWeiboAuthListener, paramString);
  }

  public void authorizeCallBack(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == this.mSSOAuthRequestCode)
    {
      if (paramInt2 != -1)
        break label259;
      if (SecurityHelper.checkResponseAppLegal(this.mAuthActivity, paramIntent))
        break label25;
    }
    label25: 
    while (paramInt2 != 0)
    {
      return;
      String str1 = paramIntent.getStringExtra("error");
      if (str1 == null)
        str1 = paramIntent.getStringExtra("error_type");
      if (str1 != null)
      {
        if ((str1.equals("access_denied")) || (str1.equals("OAuthAccessDeniedException")))
        {
          LogUtil.d("Weibo_SSO_login", "Login canceled by user.");
          this.mAuthListener.onCancel();
          return;
        }
        String str2 = paramIntent.getStringExtra("error_description");
        if (str2 != null)
          str1 = str1 + ":" + str2;
        LogUtil.d("Weibo_SSO_login", "Login failed: " + str1);
        this.mAuthListener.onWeiboException(new WeiboDialogException(str1, paramInt2, str2));
        return;
      }
      Bundle localBundle = paramIntent.getExtras();
      Oauth2AccessToken localOauth2AccessToken = Oauth2AccessToken.parseAccessToken(localBundle);
      if ((localOauth2AccessToken != null) && (localOauth2AccessToken.isSessionValid()))
      {
        LogUtil.d("Weibo_SSO_login", "Login Success! " + localOauth2AccessToken.toString());
        this.mAuthListener.onComplete(localBundle);
        return;
      }
      LogUtil.d("Weibo_SSO_login", "Failed to receive access token by SSO");
      this.mWeibo.anthorize(this.mAuthListener);
      return;
    }
    label259: if (paramIntent != null)
    {
      LogUtil.d("Weibo_SSO_login", "Login failed: " + paramIntent.getStringExtra("error"));
      this.mAuthListener.onWeiboException(new WeiboDialogException(paramIntent.getStringExtra("error"), paramIntent.getIntExtra("error_code", -1), paramIntent.getStringExtra("failing_url")));
      return;
    }
    LogUtil.d("Weibo_SSO_login", "Login canceled by user.");
    this.mAuthListener.onCancel();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.auth.sso.SsoHandler
 * JD-Core Version:    0.6.2
 */