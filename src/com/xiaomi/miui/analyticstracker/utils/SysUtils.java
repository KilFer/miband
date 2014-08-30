package com.xiaomi.miui.analyticstracker.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public class SysUtils
{
  public static String getAppPackageName(Context paramContext)
  {
    return paramContext.getApplicationInfo().packageName;
  }

  public static String getAppVersion(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(getAppPackageName(paramContext), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return "unknown";
  }

  public static String getIMEI(Context paramContext)
  {
    String str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    if (TextUtils.isEmpty(str))
      str = "null";
    return str;
  }

  public static String getModel(Context paramContext)
  {
    return Build.MODEL;
  }

  public static String getRomVersion(Context paramContext)
  {
    return Build.VERSION.INCREMENTAL;
  }

  public static boolean isWifiConnected(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    return (localNetworkInfo != null) && (!localConnectivityManager.isActiveNetworkMetered()) && (localNetworkInfo.isConnected());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.utils.SysUtils
 * JD-Core Version:    0.6.2
 */