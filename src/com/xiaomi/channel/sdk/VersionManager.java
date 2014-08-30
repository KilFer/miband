package com.xiaomi.channel.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;

public class VersionManager
{
  public static final int MILIAO_AVAILABLE = -90003;
  public static final int MILIAO_NOT_INSTALLED = -90001;
  public static final int MILIAO_TOO_OLD = -90002;
  private static final String a = "com.xiaomi.channel";

  private static boolean a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    while (true)
    {
      return false;
      List localList = paramContext.getPackageManager().getInstalledPackages(0);
      if (localList != null)
        for (int i = 0; i < localList.size(); i++)
          if (paramString.equals(((PackageInfo)localList.get(i)).packageName))
            return true;
    }
  }

  public static int checkMiliaoVersion(Context paramContext)
  {
    boolean bool = TextUtils.isEmpty("com.xiaomi.channel");
    int i = 0;
    List localList;
    int n;
    if (!bool)
    {
      localList = paramContext.getPackageManager().getInstalledPackages(0);
      i = 0;
      if (localList != null)
        n = 0;
    }
    while (true)
    {
      int i1 = localList.size();
      i = 0;
      if (n >= i1)
        label50: if (i == 0)
          break;
      else
        try
        {
          Uri localUri = Uri.parse("content://com.xiaomi.channel.providers.AccountProvider/getInfo");
          localCursor = paramContext.getContentResolver().query(localUri, new String[] { "code", "version" }, null, null, null);
          if (localCursor == null);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          try
          {
            int k;
            if (localCursor.moveToFirst())
              k = localCursor.getInt(0);
            int j;
            switch (k)
            {
            default:
              if ((localCursor != null) && (!localCursor.isClosed()))
                localCursor.close();
              j = -90002;
              return j;
              if ("com.xiaomi.channel".equals(((PackageInfo)localList.get(n)).packageName))
              {
                i = 1;
                break label50;
              }
              n++;
              break;
            case 10001:
              int m = localCursor.getInt(1);
              if (m > 0);
              for (j = -90003; ; j = -90002)
              {
                return j;
                localIllegalArgumentException = localIllegalArgumentException;
                Log.e("miliao_sdk_log", localIllegalArgumentException.toString());
                break;
              }
            }
          }
          catch (Exception localException)
          {
            while (true)
            {
              Log.e("miliao_sdk_log", localException.toString());
              if ((localCursor != null) && (!localCursor.isClosed()))
                localCursor.close();
            }
          }
          finally
          {
            Cursor localCursor;
            if ((localCursor != null) && (!localCursor.isClosed()))
              localCursor.close();
          }
        }
    }
    return -90001;
  }

  public static boolean isMiliaoVersionAvailable(Context paramContext)
  {
    List localList = paramContext.getPackageManager().getInstalledPackages(0);
    if (localList != null);
    for (int i = 0; ; i++)
    {
      if (i >= localList.size());
      PackageInfo localPackageInfo;
      do
      {
        return false;
        localPackageInfo = (PackageInfo)localList.get(i);
        if (!"com.xiaomi.channel".equals(localPackageInfo.packageName))
          break;
      }
      while (localPackageInfo.versionCode < 1060);
      return true;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.sdk.VersionManager
 * JD-Core Version:    0.6.2
 */