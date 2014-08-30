package com.xiaomi.market.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Field;

public class s
{
  static boolean a = false;
  static boolean b = false;
  protected static final int bd = 1000000;
  protected static final int be = 1000;
  private static String c = "MarketSdkUtils";

  static
  {
    boolean bool1;
    boolean bool3;
    if (!new File("/sdcard/com.xiaomi.market.sdk/sdk_debug").exists())
    {
      bool1 = false;
      a = bool1;
      boolean bool2 = new File("/sdcard/com.xiaomi.market.sdk/sdk_staging").exists();
      bool3 = false;
      if (bool2)
        break label50;
    }
    while (true)
    {
      b = bool3;
      return;
      bool1 = true;
      break;
      label50: bool3 = true;
    }
  }

  static int a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Class[] arrayOfClass = Class.forName(paramString1 + ".R").getClasses();
      for (int j = 0; ; j++)
      {
        int k = arrayOfClass.length;
        Class localClass = null;
        if (j >= k);
        while (true)
        {
          if (localClass == null)
          {
            if (a)
              Log.d("MarketSdkUtils", "[get resource id] : return id from R$class");
            localClass = Class.forName(paramString1 + ".R$" + paramString2);
          }
          i = 0;
          if (localClass != null)
          {
            int m = localClass.getField(paramString3).getInt(localClass);
            i = m;
          }
          if (a)
            Log.d("MarketSdkUtils", "[get resource id] : id = " + i);
          return i;
          if (!arrayOfClass[j].getName().split("\\$")[1].equals(paramString2))
            break;
          localClass = arrayOfClass[j];
        }
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.e("MarketSdkUtils", "[get resource id] : id = 0" + "\nerror: " + localException.toString());
        int i = 0;
      }
    }
  }

  public static String a(long paramLong, Context paramContext)
  {
    if (paramLong < 0L)
      return "";
    String str;
    int i;
    if (paramLong > 1000000L)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Double.valueOf(paramLong / 1000000.0D);
      str = String.format("%.1f", arrayOfObject2);
      i = a(paramContext.getPackageName(), "string", "xiaomi_megabytes_unit");
    }
    while (true)
    {
      return paramContext.getString(i, new Object[] { str });
      if (paramLong > 1000L)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Double.valueOf(paramLong / 1000.0D);
        str = String.format("%.1f", arrayOfObject1);
        i = a(paramContext.getPackageName(), "string", "xiaomi_kilobytes_unit");
      }
      else
      {
        str = String.valueOf(paramLong);
        i = a(paramContext.getPackageName(), "string", "xiaomi_bytes_unit");
      }
    }
  }

  static boolean a(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.xiaomi.market", 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  static boolean a(boolean paramBoolean)
  {
    String str = Environment.getExternalStorageState();
    if ("mounted".equals(str))
      return true;
    "mounted_ro".equals(str);
    return false;
  }

  static boolean b(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting());
  }

  static boolean c(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.getType() == 1);
  }

  private static boolean d(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int i = localPackageManager.getPackageInfo("com.miui.cloudservice", 0).applicationInfo.flags;
      int j = i & 0x1;
      boolean bool = false;
      if (j != 0)
        bool = true;
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  private static boolean e(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.getType() == 0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.s
 * JD-Core Version:    0.6.2
 */