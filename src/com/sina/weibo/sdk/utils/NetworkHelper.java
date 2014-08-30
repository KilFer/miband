package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.List;

public class NetworkHelper
{
  public static void clearCookies(Context paramContext, String paramString)
  {
    CookieSyncManager.createInstance(paramContext);
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    localCookieManager.removeSessionCookie();
    localCookieManager.removeAllCookie();
    CookieSyncManager.getInstance().sync();
  }

  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }

  public static NetworkInfo getNetworkInfo(Context paramContext, int paramInt)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(paramInt);
  }

  public static int getNetworkType(Context paramContext)
  {
    NetworkInfo localNetworkInfo;
    if (paramContext != null)
    {
      localNetworkInfo = getActiveNetworkInfo(paramContext);
      if (localNetworkInfo != null);
    }
    else
    {
      return -1;
    }
    return localNetworkInfo.getType();
  }

  public static NetworkInfo.DetailedState getWifiConnectivityState(Context paramContext)
  {
    NetworkInfo localNetworkInfo = getNetworkInfo(paramContext, 1);
    if (localNetworkInfo == null)
      return NetworkInfo.DetailedState.FAILED;
    return localNetworkInfo.getDetailedState();
  }

  public static int getWifiState(Context paramContext)
  {
    WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
    if (localWifiManager == null)
      return 4;
    return localWifiManager.getWifiState();
  }

  public static boolean hasInternetPermission(Context paramContext)
  {
    return (paramContext == null) || (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0);
  }

  public static boolean isMobileNetwork(Context paramContext)
  {
    NetworkInfo localNetworkInfo;
    if (paramContext != null)
    {
      localNetworkInfo = getActiveNetworkInfo(paramContext);
      if (localNetworkInfo != null)
        break label15;
    }
    label15: 
    while ((localNetworkInfo == null) || (localNetworkInfo.getType() != 0) || (!localNetworkInfo.isConnected()))
      return false;
    return true;
  }

  public static boolean isNetworkAvailable(Context paramContext)
  {
    boolean bool1 = false;
    if (paramContext != null)
    {
      NetworkInfo localNetworkInfo = getActiveNetworkInfo(paramContext);
      bool1 = false;
      if (localNetworkInfo != null)
      {
        boolean bool2 = localNetworkInfo.isConnected();
        bool1 = false;
        if (bool2)
          bool1 = true;
      }
    }
    return bool1;
  }

  public static boolean isWifiValid(Context paramContext)
  {
    if (paramContext != null)
    {
      NetworkInfo localNetworkInfo = getActiveNetworkInfo(paramContext);
      return (localNetworkInfo != null) && (1 == localNetworkInfo.getType()) && (localNetworkInfo.isConnected());
    }
    return false;
  }

  public static boolean wifiConnection(Context paramContext, String paramString1, String paramString2)
  {
    WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
    String str1 = "\"" + paramString1 + "\"";
    WifiInfo localWifiInfo = localWifiManager.getConnectionInfo();
    if ((localWifiInfo != null) && ((paramString1.equals(localWifiInfo.getSSID())) || (str1.equals(localWifiInfo.getSSID()))))
      return true;
    List localList = localWifiManager.getScanResults();
    if ((localList != null) && (localList.size() != 0));
    for (int i = -1 + localList.size(); ; i--)
    {
      if (i < 0)
        return false;
      String str2 = ((ScanResult)localList.get(i)).SSID;
      if ((paramString1.equals(str2)) || (str1.equals(str2)))
      {
        WifiConfiguration localWifiConfiguration = new WifiConfiguration();
        localWifiConfiguration.SSID = str1;
        localWifiConfiguration.preSharedKey = ("\"" + paramString2 + "\"");
        localWifiConfiguration.status = 2;
        return localWifiManager.enableNetwork(localWifiManager.addNetwork(localWifiConfiguration), false);
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.utils.NetworkHelper
 * JD-Core Version:    0.6.2
 */