package com.tencent.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.tencent.a.a.c;
import java.util.List;

public class SystemUtils
{
  public static final String QQ_SHARE_CALLBACK_ACTION = "shareToQQ";
  public static final String QQ_VERSION_NAME_4_1_0 = "4.1.0";
  public static final String QQ_VERSION_NAME_4_2_0 = "4.2.0";
  public static final String QQ_VERSION_NAME_4_3_0 = "4.3.0";
  public static final String QQ_VERSION_NAME_4_5_0 = "4.5.0";
  public static final String QQ_VERSION_NAME_4_6_0 = "4.6.0";
  public static final String QZONE_SHARE_CALLBACK_ACTION = "shareToQzone";

  public static boolean checkMobileQQ(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo("com.tencent.mobileqq", 0);
      localPackageInfo1 = localPackageInfo2;
      bool = false;
      if (localPackageInfo1 != null)
        str = localPackageInfo1.versionName;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        boolean bool;
        String str;
        Log.d("MobileQQ verson", str);
        String[] arrayOfString = str.split("\\.");
        int i = Integer.parseInt(arrayOfString[0]);
        int j = Integer.parseInt(arrayOfString[1]);
        if (i <= 4)
        {
          bool = false;
          if (i == 4)
          {
            bool = false;
            if (j <= 0);
          }
        }
        else
        {
          bool = true;
        }
        return bool;
        localNameNotFoundException = localNameNotFoundException;
        Log.d("checkMobileQQ", "error");
        localNameNotFoundException.printStackTrace();
        PackageInfo localPackageInfo1 = null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }

  public static int compareQQVersion(Context paramContext, String paramString)
  {
    return compareVersion(getAppVersionName(paramContext, "com.tencent.mobileqq"), paramString);
  }

  public static int compareVersion(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null))
      return 0;
    if ((paramString1 != null) && (paramString2 == null))
      return 1;
    if ((paramString1 == null) && (paramString2 != null))
      return -1;
    String[] arrayOfString1 = paramString1.split("\\.");
    String[] arrayOfString2 = paramString2.split("\\.");
    for (int i = 0; ; i++)
    {
      int k;
      int m;
      try
      {
        if ((i < arrayOfString1.length) && (i < arrayOfString2.length))
        {
          k = Integer.parseInt(arrayOfString1[i]);
          m = Integer.parseInt(arrayOfString2[i]);
          if (k < m)
            return -1;
        }
        else
        {
          if (arrayOfString1.length > i)
            return 1;
          int j = arrayOfString2.length;
          if (j <= i)
            break;
          return -1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return paramString1.compareTo(paramString2);
      }
      if (k > m)
        return 1;
    }
  }

  public static String getAppName(Context paramContext)
  {
    return paramContext.getApplicationInfo().loadLabel(paramContext.getPackageManager()).toString();
  }

  // ERROR //
  public static String getAppSignatureMD5(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 117
    //   2: ldc 119
    //   4: invokestatic 125	com/tencent/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: invokevirtual 128	android/content/Context:getPackageName	()Ljava/lang/String;
    //   11: astore 5
    //   13: aload_0
    //   14: invokevirtual 42	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   17: aload 5
    //   19: bipush 64
    //   21: invokevirtual 50	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   24: getfield 132	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   27: astore 6
    //   29: ldc 134
    //   31: invokestatic 140	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   34: astore 7
    //   36: aload 7
    //   38: aload 6
    //   40: iconst_0
    //   41: aaload
    //   42: invokevirtual 146	android/content/pm/Signature:toByteArray	()[B
    //   45: invokevirtual 150	java/security/MessageDigest:update	([B)V
    //   48: aload 7
    //   50: invokevirtual 153	java/security/MessageDigest:digest	()[B
    //   53: invokestatic 159	com/tencent/utils/Util:toHexString	([B)Ljava/lang/String;
    //   56: astore 8
    //   58: aload 7
    //   60: invokevirtual 162	java/security/MessageDigest:reset	()V
    //   63: aload 7
    //   65: new 164	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   72: aload 5
    //   74: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 171
    //   79: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 8
    //   84: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc 171
    //   89: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_1
    //   93: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokevirtual 175	java/lang/String:getBytes	()[B
    //   102: invokevirtual 150	java/security/MessageDigest:update	([B)V
    //   105: aload 7
    //   107: invokevirtual 153	java/security/MessageDigest:digest	()[B
    //   110: invokestatic 159	com/tencent/utils/Util:toHexString	([B)Ljava/lang/String;
    //   113: astore 9
    //   115: aload 9
    //   117: astore_3
    //   118: aload 7
    //   120: invokevirtual 162	java/security/MessageDigest:reset	()V
    //   123: aload_3
    //   124: areturn
    //   125: astore_2
    //   126: ldc 177
    //   128: astore_3
    //   129: aload_2
    //   130: astore 4
    //   132: aload 4
    //   134: invokevirtual 84	java/lang/Exception:printStackTrace	()V
    //   137: ldc 117
    //   139: ldc 179
    //   141: aload 4
    //   143: invokestatic 182	com/tencent/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   146: aload_3
    //   147: areturn
    //   148: astore 4
    //   150: goto -18 -> 132
    //
    // Exception table:
    //   from	to	target	type
    //   7	115	125	java/lang/Exception
    //   118	123	148	java/lang/Exception
  }

  public static String getAppVersionName(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      String str = localPackageManager.getPackageInfo(paramString, 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  public static String getRealPathFromUri(Activity paramActivity, Uri paramUri)
  {
    Cursor localCursor = paramActivity.managedQuery(paramUri, new String[] { "_data" }, null, null, null);
    String str = null;
    if (localCursor != null)
    {
      int i = localCursor.getColumnIndexOrThrow("_data");
      localCursor.moveToFirst();
      str = localCursor.getString(i);
    }
    return str;
  }

  public static boolean isActivityExist(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null));
    while (paramContext.getPackageManager().queryIntentActivities(paramIntent, 0).size() == 0)
      return false;
    return true;
  }

  public static boolean isAppSignatureValid(Context paramContext, String paramString1, String paramString2)
  {
    c.a("openSDK_LOG", "OpenUi, validateAppSignatureForPackage");
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString1, 64);
      Signature[] arrayOfSignature = localPackageInfo.signatures;
      int i = arrayOfSignature.length;
      for (int j = 0; ; j++)
      {
        boolean bool = false;
        if (j < i)
        {
          if (Util.encrypt(arrayOfSignature[j].toCharsString()).equals(paramString2))
            bool = true;
        }
        else
          return bool;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.utils.SystemUtils
 * JD-Core Version:    0.6.2
 */