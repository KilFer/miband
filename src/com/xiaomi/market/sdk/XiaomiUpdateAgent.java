package com.xiaomi.market.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Log;
import java.io.File;

public class XiaomiUpdateAgent
{
  private static final String a = "MarketUpdateAgent";
  private static Context b;
  private static boolean c = false;
  private static boolean d = false;
  private static boolean e = false;
  private static q f;
  private static w g;
  private static XiaomiUpdateListener h;
  private static final int i = 0;
  private static final int j = 1;

  static Context a()
  {
    return b;
  }

  static q a(Context paramContext)
  {
    q localq = q.h(paramContext.getPackageName());
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo(localq.packageName, 64);
      localPackageInfo1 = localPackageInfo2;
      if ((localPackageInfo1 != null) && (localPackageInfo1.applicationInfo != null))
      {
        localq.aU = localPackageManager.getApplicationLabel(localPackageInfo1.applicationInfo).toString();
        localq.versionCode = localPackageInfo1.versionCode;
        localq.versionName = localPackageInfo1.versionName;
        localq.aV = b.a(String.valueOf(localPackageInfo1.signatures[0].toChars()));
        localq.sourceDir = localPackageInfo1.applicationInfo.sourceDir;
        localq.aW = b.a(new File(localq.sourceDir));
        return localq;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        Log.e("MarketUpdateAgent", "get package info failed");
        PackageInfo localPackageInfo1 = null;
      }
    }
    return null;
  }

  public static int getSDKVersion()
  {
    return 0;
  }

  public static void setCheckUpdateOnlyWifi(boolean paramBoolean)
  {
    d = paramBoolean;
  }

  public static void setUpdateAutoPopup(boolean paramBoolean)
  {
    c = paramBoolean;
  }

  public static void setUpdateListener(XiaomiUpdateListener paramXiaomiUpdateListener)
  {
    h = paramXiaomiUpdateListener;
  }

  public static void update(Context paramContext)
  {
    if (paramContext == null)
      return;
    b = paramContext;
    j.k();
    new t((byte)0).execute(new Void[0]);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.XiaomiUpdateAgent
 * JD-Core Version:    0.6.2
 */