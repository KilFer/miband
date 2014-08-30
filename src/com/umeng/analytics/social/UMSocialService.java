package com.umeng.analytics.social;

import android.content.Context;
import android.util.Log;

public abstract class UMSocialService
{
  private static void a(Context paramContext, UMSocialService.b paramb, String paramString, UMPlatformData[] paramArrayOfUMPlatformData)
  {
    if (paramArrayOfUMPlatformData != null);
    while (true)
    {
      int i;
      int j;
      try
      {
        i = paramArrayOfUMPlatformData.length;
        j = 0;
        break label90;
        new q(f.a(paramContext, paramString, paramArrayOfUMPlatformData), null, paramArrayOfUMPlatformData).execute(new Void[0]);
        return;
        if (!paramArrayOfUMPlatformData[j].isValid())
          throw new a("parameter is not valid.");
      }
      catch (a locala)
      {
        Log.e("MobclickAgent", "unable send event.", locala);
        return;
        j++;
      }
      catch (Exception localException)
      {
        Log.e("MobclickAgent", "", localException);
        return;
      }
      label90: if (j < i);
    }
  }

  public static void share(Context paramContext, String paramString, UMPlatformData[] paramArrayOfUMPlatformData)
  {
    a(paramContext, null, paramString, paramArrayOfUMPlatformData);
  }

  public static void share(Context paramContext, UMPlatformData[] paramArrayOfUMPlatformData)
  {
    a(paramContext, null, null, paramArrayOfUMPlatformData);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.social.UMSocialService
 * JD-Core Version:    0.6.2
 */