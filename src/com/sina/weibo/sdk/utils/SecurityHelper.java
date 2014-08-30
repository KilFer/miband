package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.sina.weibo.sdk.api.share.ApiUtils;
import com.sina.weibo.sdk.api.share.ApiUtils.WeiboInfo;

public class SecurityHelper
{
  private static final String WEIBO_MD5_SIGNATURE = "18da2bf10352443a00a5e046d9fca6bd";

  public static boolean checkResponseAppLegal(Context paramContext, Intent paramIntent)
  {
    ApiUtils.WeiboInfo localWeiboInfo = ApiUtils.queryWeiboInfo(paramContext);
    if ((localWeiboInfo != null) && (localWeiboInfo.supportApi <= 10352));
    String str;
    do
    {
      do
        return true;
      while (localWeiboInfo == null);
      str = paramIntent.getStringExtra("_weibo_appPackage");
    }
    while ((str != null) && (paramIntent.getStringExtra("_weibo_transaction") != null) && (ApiUtils.validateWeiboSign(paramContext, str)));
    return false;
  }

  public static boolean containSign(Signature[] paramArrayOfSignature, String paramString)
  {
    if ((paramArrayOfSignature == null) || (paramString == null));
    while (true)
    {
      return false;
      int i = paramArrayOfSignature.length;
      for (int j = 0; j < i; j++)
        if (paramString.equals(MD5.hexdigest(paramArrayOfSignature[j].toByteArray())))
          return true;
    }
  }

  public static boolean validateAppSignatureForIntent(Context paramContext, Intent paramIntent)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null);
    ResolveInfo localResolveInfo;
    do
    {
      return false;
      localResolveInfo = localPackageManager.resolveActivity(paramIntent, 0);
    }
    while (localResolveInfo == null);
    String str = localResolveInfo.activityInfo.packageName;
    try
    {
      boolean bool = containSign(localPackageManager.getPackageInfo(str, 64).signatures, "18da2bf10352443a00a5e046d9fca6bd");
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.utils.SecurityHelper
 * JD-Core Version:    0.6.2
 */