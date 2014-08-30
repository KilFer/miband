package com.tencent.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsynLoadImg
{
  private static String c;
  private String a;
  private AsynLoadImgBack b;
  private long d;
  private Activity e;
  private Handler f;
  private Runnable g = new b(this);

  public AsynLoadImg(Activity paramActivity)
  {
    this.f = new a(this, paramActivity.getMainLooper());
  }

  public static Bitmap getbitmap(String paramString)
  {
    Log.v("AsynLoadImg", "getbitmap:" + paramString);
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.connect();
      InputStream localInputStream = localHttpURLConnection.getInputStream();
      Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
      localInputStream.close();
      Log.v("AsynLoadImg", "image download finished." + paramString);
      return localBitmap;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      Log.v("AsynLoadImg", "getbitmap bmp fail---");
    }
    return null;
  }

  public void save(String paramString, AsynLoadImgBack paramAsynLoadImgBack)
  {
    Log.v("AsynLoadImg", "--save---");
    if ((paramString == null) || (paramString.equals("")))
    {
      paramAsynLoadImgBack.saved(1, null);
      return;
    }
    if (!Util.hasSDCard())
    {
      paramAsynLoadImgBack.saved(2, null);
      return;
    }
    c = Environment.getExternalStorageDirectory() + "/tmp/";
    this.d = System.currentTimeMillis();
    this.a = paramString;
    this.b = paramAsynLoadImgBack;
    new Thread(this.g).start();
  }

  public boolean saveFile(Bitmap paramBitmap, String paramString)
  {
    String str1 = c;
    try
    {
      File localFile = new File(str1);
      if (!localFile.exists())
        localFile.mkdir();
      String str2 = str1 + paramString;
      Log.v("AsynLoadImg", "saveFile:" + paramString);
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str2)));
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 80, localBufferedOutputStream);
      localBufferedOutputStream.flush();
      localBufferedOutputStream.close();
      return true;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      Log.v("AsynLoadImg", "saveFile bmp fail---");
    }
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.utils.AsynLoadImg
 * JD-Core Version:    0.6.2
 */