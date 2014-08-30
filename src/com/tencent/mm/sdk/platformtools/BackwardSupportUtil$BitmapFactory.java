package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BackwardSupportUtil$BitmapFactory
{
  public static Bitmap decodeFile(String paramString, float paramFloat)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    float f = 160.0F * paramFloat;
    localOptions.inDensity = ((int)f);
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
    if (localBitmap != null)
      localBitmap.setDensity((int)f);
    return localBitmap;
  }

  public static Bitmap decodeStream(InputStream paramInputStream)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 160;
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    return BitmapFactory.decodeStream(paramInputStream, null, localOptions);
  }

  public static Bitmap decodeStream(InputStream paramInputStream, float paramFloat)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = ((int)(160.0F * paramFloat));
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    return BitmapFactory.decodeStream(paramInputStream, null, localOptions);
  }

  public static int fromDPToPix(Context paramContext, float paramFloat)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return Math.round(paramFloat * localDisplayMetrics.densityDpi / 160.0F);
  }

  public static Bitmap getBitmapFromURL(String paramString)
  {
    try
    {
      Log.d("MicroMsg.SDK.BackwardSupportUtil", "get bitmap from url:" + paramString);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.connect();
      InputStream localInputStream = localHttpURLConnection.getInputStream();
      Bitmap localBitmap = decodeStream(localInputStream);
      localInputStream.close();
      return localBitmap;
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      Log.e("MicroMsg.SDK.BackwardSupportUtil", "get bitmap from url failed");
      localIOException.printStackTrace();
      return null;
    }
    finally
    {
    }
  }

  public static String getDisplayDensityType(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    Configuration localConfiguration = paramContext.getResources().getConfiguration();
    String str1;
    StringBuilder localStringBuilder;
    if (localDisplayMetrics.density < 1.0F)
    {
      str1 = "" + "LDPI";
      localStringBuilder = new StringBuilder().append(str1);
      if (localConfiguration.orientation != 2)
        break label140;
    }
    label140: for (String str2 = "_L"; ; str2 = "_P")
    {
      return str2;
      if (localDisplayMetrics.density >= 1.5F)
      {
        str1 = "" + "HDPI";
        break;
      }
      str1 = "" + "MDPI";
      break;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory
 * JD-Core Version:    0.6.2
 */