package com.xiaomi.channel.sdk;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import java.io.File;

public class ShareUtils
{
  public static Bitmap compressBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((i < paramInt1) && (j < paramInt1))
      return paramBitmap;
    Rect localRect1 = new Rect(0, 0, i, j);
    Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
    new Canvas(localBitmap).drawBitmap(paramBitmap, localRect1, localRect2, new Paint());
    return localBitmap;
  }

  public static Bitmap compressBitmapWithNoDistortion(Bitmap paramBitmap, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((i < paramInt1) && (j < paramInt1))
      return paramBitmap;
    if (i / paramInt1 > j / paramInt2);
    for (double d = i / paramInt1; ; d = j / paramInt2)
      return compressBitmap(paramBitmap, (int)(i / d), (int)(j / d), paramConfig);
  }

  public static void createDirForNewFile(String paramString)
  {
    File localFile = new File(paramString.substring(0, paramString.lastIndexOf("/")));
    if (!localFile.exists())
      localFile.mkdirs();
  }

  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null)
      return null;
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1);
    for (Bitmap.Config localConfig = Bitmap.Config.ARGB_8888; ; localConfig = Bitmap.Config.RGB_565)
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
  }

  public static File getTmpImgFile()
  {
    try
    {
      File localFile1 = new File(new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "miliaoshare"), "images");
      Object localObject;
      if (!localFile1.isDirectory())
      {
        boolean bool = localFile1.mkdirs();
        localObject = null;
        if (!bool);
      }
      else
      {
        File localFile2 = new File(localFile1, "sharedSourceImgTmp.jpg");
        localObject = localFile2;
      }
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public static boolean saveBitmap(Bitmap paramBitmap, String paramString)
  {
    return saveBitmap(paramBitmap, paramString, Bitmap.CompressFormat.PNG, 100);
  }

  // ERROR //
  public static boolean saveBitmap(Bitmap paramBitmap, String paramString, Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokestatic 143	com/xiaomi/channel/sdk/ShareUtils:createDirForNewFile	(Ljava/lang/String;)V
    //   7: new 47	java/io/File
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore 11
    //   17: aload 11
    //   19: invokevirtual 65	java/io/File:exists	()Z
    //   22: ifne +9 -> 31
    //   25: aload 11
    //   27: invokevirtual 146	java/io/File:createNewFile	()Z
    //   30: pop
    //   31: new 148	java/io/FileOutputStream
    //   34: dup
    //   35: aload 11
    //   37: invokespecial 151	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   40: astore 6
    //   42: aload_0
    //   43: aload_2
    //   44: iload_3
    //   45: aload 6
    //   47: invokevirtual 155	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   50: istore 13
    //   52: aload 6
    //   54: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   57: iload 13
    //   59: ireturn
    //   60: astore 9
    //   62: aload 4
    //   64: ifnull +8 -> 72
    //   67: aload 4
    //   69: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   72: iconst_0
    //   73: ireturn
    //   74: astore 5
    //   76: aconst_null
    //   77: astore 6
    //   79: aload 5
    //   81: astore 7
    //   83: aload 6
    //   85: ifnull +8 -> 93
    //   88: aload 6
    //   90: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   93: aload 7
    //   95: athrow
    //   96: astore 14
    //   98: iload 13
    //   100: ireturn
    //   101: astore 10
    //   103: goto -31 -> 72
    //   106: astore 8
    //   108: goto -15 -> 93
    //   111: astore 7
    //   113: goto -30 -> 83
    //   116: astore 12
    //   118: aload 6
    //   120: astore 4
    //   122: goto -60 -> 62
    //
    // Exception table:
    //   from	to	target	type
    //   3	31	60	java/io/IOException
    //   31	42	60	java/io/IOException
    //   3	31	74	finally
    //   31	42	74	finally
    //   52	57	96	java/io/IOException
    //   67	72	101	java/io/IOException
    //   88	93	106	java/io/IOException
    //   42	52	111	finally
    //   42	52	116	java/io/IOException
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.sdk.ShareUtils
 * JD-Core Version:    0.6.2
 */