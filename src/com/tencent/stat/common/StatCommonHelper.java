package com.tencent.stat.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class StatCommonHelper
{
  private static String a = null;
  private static String b = null;
  private static String c = null;
  private static String d;
  private static Random e = null;
  private static StatLogger f = null;

  private static Random a()
  {
    if (e == null)
      e = new Random();
    return e;
  }

  public static boolean checkPermission(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0;
  }

  public static boolean checkPhoneState(Context paramContext)
  {
    return paramContext.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", paramContext.getPackageName()) == 0;
  }

  public static Long convertStringToLong(String paramString1, String paramString2, int paramInt1, int paramInt2, Long paramLong)
  {
    if ((paramString1 == null) || (paramString2 == null));
    String[] arrayOfString;
    do
    {
      return paramLong;
      if ((paramString2.equalsIgnoreCase(".")) || (paramString2.equalsIgnoreCase("|")))
        paramString2 = "\\" + paramString2;
      arrayOfString = paramString1.split(paramString2);
    }
    while (arrayOfString.length != paramInt2);
    try
    {
      Object localObject = Long.valueOf(0L);
      int i = 0;
      while (i < arrayOfString.length)
      {
        Long localLong = Long.valueOf(paramInt1 * (((Long)localObject).longValue() + Long.valueOf(arrayOfString[i]).longValue()));
        i++;
        localObject = localLong;
      }
      return localObject;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return paramLong;
  }

  public static String decode(String paramString)
  {
    if (paramString == null)
      paramString = null;
    while (Build.VERSION.SDK_INT < 8)
      return paramString;
    try
    {
      String str = new String(RC4.decrypt(StatBase64.decode(paramString.getBytes("UTF-8"), 0)), "UTF-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
      f.e(localThrowable);
    }
    return paramString;
  }

  public static byte[] deocdeGZipContent(byte[] paramArrayOfByte)
  {
    GZIPInputStream localGZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(paramArrayOfByte));
    byte[] arrayOfByte = new byte[4096];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length << 1);
    while (true)
    {
      int i = localGZIPInputStream.read(arrayOfByte);
      if (i == -1)
        break;
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }

  public static String encode(String paramString)
  {
    if (paramString == null)
      paramString = null;
    while (Build.VERSION.SDK_INT < 8)
      return paramString;
    try
    {
      String str = new String(StatBase64.encode(RC4.encrypt(paramString.getBytes("UTF-8")), 0), "UTF-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
      f.e(localThrowable);
    }
    return paramString;
  }

  public static String getActivityName(Context paramContext)
  {
    if (paramContext == null)
      return null;
    return paramContext.getClass().getName();
  }

  public static String getAppKey(Context paramContext)
  {
    if (b != null)
      return b;
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (localApplicationInfo != null)
      {
        String str = localApplicationInfo.metaData.getString("TA_APPKEY");
        if (str == null)
          break label60;
        b = str;
        return str;
      }
    }
    catch (Exception localException)
    {
      f.w("Could not read APPKEY meta-data from AndroidManifest.xml");
    }
    while (true)
    {
      return null;
      label60: f.w("Could not read APPKEY meta-data from AndroidManifest.xml");
    }
  }

  // ERROR //
  public static String getAppVersion(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 39	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: aload_0
    //   5: invokevirtual 43	android/content/Context:getPackageName	()Ljava/lang/String;
    //   8: iconst_0
    //   9: invokevirtual 207	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   12: getfield 212	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +10 -> 27
    //   20: aload_2
    //   21: invokevirtual 216	java/lang/String:length	()I
    //   24: ifne +6 -> 30
    //   27: ldc 218
    //   29: astore_2
    //   30: aload_2
    //   31: areturn
    //   32: astore_1
    //   33: ldc 220
    //   35: astore_2
    //   36: aload_1
    //   37: astore_3
    //   38: getstatic 25	com/tencent/stat/common/StatCommonHelper:f	Lcom/tencent/stat/common/StatLogger;
    //   41: aload_3
    //   42: invokevirtual 223	com/tencent/stat/common/StatLogger:e	(Ljava/lang/Exception;)V
    //   45: aload_2
    //   46: areturn
    //   47: astore_3
    //   48: goto -10 -> 38
    //
    // Exception table:
    //   from	to	target	type
    //   0	16	32	java/lang/Exception
    //   20	27	47	java/lang/Exception
  }

  public static String getCurAppVersion(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      if (str == null)
        str = "";
      return str;
    }
    catch (Exception localException)
    {
      f.e(localException);
    }
    return "";
  }

  public static String getDateFormat(long paramLong)
  {
    return new SimpleDateFormat("yyyyMMdd").format(new Date(paramLong));
  }

  public static String getDeviceID(Context paramContext)
  {
    if (checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
    {
      String str = "";
      if (checkPhoneState(paramContext))
        str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      if (str != null)
        return str;
      f.error("deviceId is null");
      return null;
    }
    f.e("Could not get permission of android.permission.READ_PHONE_STATE");
    return null;
  }

  public static DisplayMetrics getDisplayMetrics(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }

  public static String getExternalStorageInfo(Context paramContext)
  {
    try
    {
      if (checkPermission(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE"))
      {
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          String str = Environment.getExternalStorageDirectory().getPath();
          if (str == null)
            return null;
          StatFs localStatFs = new StatFs(str);
          long l1 = localStatFs.getBlockCount() * localStatFs.getBlockSize() / 1000000L;
          long l2 = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize() / 1000000L;
          return String.valueOf(l2) + "/" + String.valueOf(l1);
        }
      }
      else
      {
        f.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static HttpHost getHttpProxy(Context paramContext)
  {
    if (paramContext == null)
      return null;
    if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0)
      return null;
    String str;
    do
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo == null)
          return null;
        if ((localNetworkInfo.getTypeName() != null) && (localNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")))
          return null;
        str = localNetworkInfo.getExtraInfo();
        if (str == null)
          return null;
        if ((str.equals("cmwap")) || (str.equals("3gwap")) || (str.equals("uniwap")))
        {
          HttpHost localHttpHost1 = new HttpHost("10.0.0.172", 80);
          return localHttpHost1;
        }
      }
      catch (Exception localException)
      {
        f.e(localException);
        return null;
      }
    while (!str.equals("ctwap"));
    HttpHost localHttpHost2 = new HttpHost("10.0.0.200", 80);
    return localHttpHost2;
  }

  public static String getInstallChannel(Context paramContext)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (localApplicationInfo != null)
      {
        Object localObject = localApplicationInfo.metaData.get("InstallChannel");
        if (localObject != null)
          return localObject.toString();
        f.e("Could not read InstallChannel meta-data from AndroidManifest.xml");
      }
      return null;
    }
    catch (Exception localException)
    {
      while (true)
        f.e("Could not read InstallChannel meta-data from AndroidManifest.xml");
    }
  }

  public static String getLinkedWay(Context paramContext)
  {
    if (checkPermission(paramContext, "android.permission.ACCESS_WIFI_STATE"))
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
      {
        String str1 = localNetworkInfo.getTypeName();
        String str2 = localNetworkInfo.getExtraInfo();
        if (str1 != null)
        {
          if (str1.equalsIgnoreCase("WIFI"))
            str1 = "WIFI";
          do
          {
            return str1;
            if (str1.equalsIgnoreCase("MOBILE"))
            {
              if (str2 != null)
                return str2;
              return "MOBILE";
            }
          }
          while (str2 == null);
          return str2;
        }
      }
    }
    else
    {
      f.e("can not get the permission of android.permission.ACCESS_WIFI_STATE");
    }
    return null;
  }

  public static StatLogger getLogger()
  {
    if (f == null)
    {
      StatLogger localStatLogger = new StatLogger("MtaSDK");
      f = localStatLogger;
      localStatLogger.setDebugEnable(false);
    }
    return f;
  }

  public static String getMacId(Context paramContext)
  {
    if ((c == null) || ("" == c))
      c = getWifiMacAddress(paramContext);
    return c;
  }

  public static int getNextSessionID()
  {
    return a().nextInt(2147483647);
  }

  public static long getSDKLongVersion(String paramString)
  {
    return convertStringToLong(paramString, ".", 100, 3, Long.valueOf(0L)).longValue();
  }

  public static String getSimOperator(Context paramContext)
  {
    if (checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
    {
      if (!checkPhoneState(paramContext))
        break label52;
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      try
      {
        String str = localTelephonyManager.getSimOperator();
        return str;
      }
      catch (Exception localException)
      {
        f.e(localException);
        return null;
      }
    }
    f.e("Could not get permission of android.permission.READ_PHONE_STATE");
    label52: return null;
  }

  public static Integer getTelephonyNetworkType(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (localTelephonyManager != null)
      return Integer.valueOf(localTelephonyManager.getNetworkType());
    return null;
  }

  public static long getTomorrowStartMilliseconds()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return 86400000L + localCalendar.getTimeInMillis();
  }

  public static String getUserID(Context paramContext)
  {
    if ((a != null) && (a.trim().length() != 0))
      return a;
    a = getDeviceID(paramContext);
    if ((a == null) || (a.trim().length() == 0))
      a = Integer.toString(a().nextInt(2147483647));
    return a;
  }

  public static String getWifiMacAddress(Context paramContext)
  {
    if (checkPermission(paramContext, "android.permission.ACCESS_WIFI_STATE"))
      try
      {
        WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
        if (localWifiManager == null)
          return "";
        String str = localWifiManager.getConnectionInfo().getMacAddress();
        return str;
      }
      catch (Exception localException)
      {
        f.e(localException);
        return "";
      }
    f.e("Could not get permission of android.permission.ACCESS_WIFI_STATE");
    return "";
  }

  public static int hasRootAccess(Context paramContext)
  {
    if (f.a())
      return 1;
    return 0;
  }

  public static boolean isNetworkAvailable(Context paramContext)
  {
    if (checkPermission(paramContext, "android.permission.INTERNET"))
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
        return true;
      f.w("Network error");
      return false;
    }
    f.warn("can not get the permisson of android.permission.INTERNET");
    return false;
  }

  public static boolean isWiFiActive(Context paramContext)
  {
    if (checkPermission(paramContext, "android.permission.ACCESS_WIFI_STATE"))
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      boolean bool = false;
      NetworkInfo[] arrayOfNetworkInfo;
      if (localConnectivityManager != null)
      {
        arrayOfNetworkInfo = localConnectivityManager.getAllNetworkInfo();
        bool = false;
        if (arrayOfNetworkInfo == null);
      }
      for (int i = 0; ; i++)
      {
        int j = arrayOfNetworkInfo.length;
        bool = false;
        if (i < j)
        {
          if ((arrayOfNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI")) && (arrayOfNetworkInfo[i].isConnected()))
            bool = true;
        }
        else
          return bool;
      }
    }
    f.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
    return false;
  }

  public static boolean isWifiNet(Context paramContext)
  {
    if (checkPermission(paramContext, "android.permission.INTERNET"))
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return (localNetworkInfo != null) && (localNetworkInfo.isAvailable()) && (localNetworkInfo.getTypeName().equalsIgnoreCase("WIFI"));
    }
    f.warn("can not get the permisson of android.permission.INTERNET");
    return false;
  }

  public static void jsonPut(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
      paramJSONObject.put(paramString1, paramString2);
  }

  public static String md5sum(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = localMessageDigest.digest();
      StringBuffer localStringBuffer = new StringBuffer();
      for (int i = 0; i < arrayOfByte.length; i++)
      {
        int j = 0xFF & arrayOfByte[i];
        if (j < 16)
          localStringBuffer.append("0");
        localStringBuffer.append(Integer.toHexString(j));
      }
      String str = localStringBuffer.toString();
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      f.e(localNoSuchAlgorithmException);
    }
    return "0";
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.common.StatCommonHelper
 * JD-Core Version:    0.6.2
 */