package com.sina.weibo.sdk.auth;

import android.content.Context;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.UIUtils;
import com.sina.weibo.sdk.utils.Utility;
import java.util.LinkedHashMap;

public class WeiboAuth
{
  private static final String OAUTH2_BASE_URL = "https://open.weibo.cn/oauth2/authorize?";
  public static final int OBTAIN_AUTH_CODE = 0;
  public static final int OBTAIN_AUTH_TOKEN = 1;
  public static final String TAG = "Weibo_web_login";
  private WeiboAuth.AuthInfo mAuthInfo;
  private Context mContext;

  public WeiboAuth(Context paramContext, WeiboAuth.AuthInfo paramAuthInfo)
  {
    this.mContext = paramContext;
    this.mAuthInfo = paramAuthInfo;
  }

  public WeiboAuth(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.mContext = paramContext;
    this.mAuthInfo = new WeiboAuth.AuthInfo(paramContext, paramString1, paramString2, paramString3);
  }

  private void startDialog(WeiboAuthListener paramWeiboAuthListener, int paramInt)
  {
    if (paramWeiboAuthListener == null)
      return;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("client_id", WeiboAuth.AuthInfo.access$0(this.mAuthInfo));
    localLinkedHashMap.put("redirect_uri", WeiboAuth.AuthInfo.access$1(this.mAuthInfo));
    localLinkedHashMap.put("scope", WeiboAuth.AuthInfo.access$2(this.mAuthInfo));
    localLinkedHashMap.put("response_type", "code");
    localLinkedHashMap.put("display", "mobile");
    if (1 == paramInt)
    {
      localLinkedHashMap.put("packagename", WeiboAuth.AuthInfo.access$3(this.mAuthInfo));
      localLinkedHashMap.put("key_hash", WeiboAuth.AuthInfo.access$4(this.mAuthInfo));
    }
    String str1 = "https://open.weibo.cn/oauth2/authorize?" + Utility.packUrl(localLinkedHashMap);
    if (!NetworkHelper.hasInternetPermission(this.mContext))
    {
      UIUtils.showAlert(this.mContext, "Error", "Application requires permission to access the Internet");
      return;
    }
    if (NetworkHelper.isNetworkAvailable(this.mContext))
    {
      new WeiboDialog(this.mContext, str1, paramWeiboAuthListener, this).show();
      return;
    }
    String str2 = ResourceManager.getString(this.mContext, 2);
    LogUtil.i("Weibo_web_login", "String: " + str2);
    UIUtils.showToast(this.mContext, str2, 0);
  }

  public void anthorize(WeiboAuthListener paramWeiboAuthListener)
  {
    authorize(paramWeiboAuthListener, 1);
  }

  public void authorize(WeiboAuthListener paramWeiboAuthListener, int paramInt)
  {
    startDialog(paramWeiboAuthListener, paramInt);
  }

  public WeiboAuth.AuthInfo getAuthInfo()
  {
    return this.mAuthInfo;
  }

  public void setAuthInfo(WeiboAuth.AuthInfo paramAuthInfo)
  {
    this.mAuthInfo = paramAuthInfo;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.auth.WeiboAuth
 * JD-Core Version:    0.6.2
 */