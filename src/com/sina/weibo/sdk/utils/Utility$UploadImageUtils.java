package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class Utility$UploadImageUtils
{
  private static void revitionImageSize(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0)
      throw new IllegalArgumentException("size must be greater than 0!");
    if (!Utility.access$0(paramString))
    {
      if (paramString == null)
        paramString = "null";
      throw new FileNotFoundException(paramString);
    }
    if (!BitmapHelper.verifyBitmap(paramString))
      throw new IOException("");
    FileInputStream localFileInputStream = new FileInputStream(paramString);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(localFileInputStream, null, localOptions);
    Bitmap localBitmap;
    label177: FileOutputStream localFileOutputStream;
    try
    {
      localFileInputStream.close();
      i = 0;
      if ((localOptions.outWidth >> i <= paramInt1) && (localOptions.outHeight >> i <= paramInt1))
      {
        localOptions.inSampleSize = ((int)Math.pow(2.0D, i));
        localOptions.inJustDecodeBounds = false;
        localBitmap = safeDecodeBimtapFile(paramString, localOptions);
        if (localBitmap != null)
          break label177;
        throw new IOException("Bitmap decode error!");
      }
    }
    catch (Exception localException1)
    {
      while (true)
      {
        int i;
        localException1.printStackTrace();
        continue;
        i++;
      }
      Utility.access$1(paramString);
      Utility.access$2(paramString);
      localFileOutputStream = new FileOutputStream(paramString);
      if (localOptions.outMimeType == null)
        break label240;
    }
    if (localOptions.outMimeType.contains("png"))
      localBitmap.compress(Bitmap.CompressFormat.PNG, paramInt2, localFileOutputStream);
    try
    {
      while (true)
      {
        localFileOutputStream.close();
        localBitmap.recycle();
        return;
        label240: localBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt2, localFileOutputStream);
      }
    }
    catch (Exception localException2)
    {
      while (true)
        localException2.printStackTrace();
    }
  }

  // ERROR //
  private static void revitionImageSizeHD(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifgt +13 -> 14
    //   4: new 14	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 16
    //   10: invokespecial 19	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_0
    //   15: invokestatic 25	com/sina/weibo/sdk/utils/Utility:access$0	(Ljava/lang/String;)Z
    //   18: ifne +19 -> 37
    //   21: aload_0
    //   22: ifnonnull +6 -> 28
    //   25: ldc 27
    //   27: astore_0
    //   28: new 29	java/io/FileNotFoundException
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 30	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   36: athrow
    //   37: aload_0
    //   38: invokestatic 35	com/sina/weibo/sdk/utils/BitmapHelper:verifyBitmap	(Ljava/lang/String;)Z
    //   41: ifne +13 -> 54
    //   44: new 37	java/io/IOException
    //   47: dup
    //   48: ldc 39
    //   50: invokespecial 40	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   53: athrow
    //   54: iload_1
    //   55: iconst_2
    //   56: imul
    //   57: istore_3
    //   58: new 42	java/io/FileInputStream
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 43	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   66: astore 4
    //   68: new 45	android/graphics/BitmapFactory$Options
    //   71: dup
    //   72: invokespecial 46	android/graphics/BitmapFactory$Options:<init>	()V
    //   75: astore 5
    //   77: aload 5
    //   79: iconst_1
    //   80: putfield 50	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   83: aload 4
    //   85: aconst_null
    //   86: aload 5
    //   88: invokestatic 56	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   91: pop
    //   92: aload 4
    //   94: invokevirtual 59	java/io/FileInputStream:close	()V
    //   97: iconst_0
    //   98: istore 8
    //   100: aload 5
    //   102: getfield 63	android/graphics/BitmapFactory$Options:outWidth	I
    //   105: iload 8
    //   107: ishr
    //   108: iload_3
    //   109: if_icmpgt +69 -> 178
    //   112: aload 5
    //   114: getfield 66	android/graphics/BitmapFactory$Options:outHeight	I
    //   117: iload 8
    //   119: ishr
    //   120: iload_3
    //   121: if_icmpgt +57 -> 178
    //   124: aload 5
    //   126: ldc2_w 67
    //   129: iload 8
    //   131: i2d
    //   132: invokestatic 74	java/lang/Math:pow	(DD)D
    //   135: d2i
    //   136: putfield 77	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   139: aload 5
    //   141: iconst_0
    //   142: putfield 50	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   145: aload_0
    //   146: aload 5
    //   148: invokestatic 81	com/sina/weibo/sdk/utils/Utility$UploadImageUtils:safeDecodeBimtapFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   151: astore 9
    //   153: aload 9
    //   155: ifnonnull +29 -> 184
    //   158: new 37	java/io/IOException
    //   161: dup
    //   162: ldc 83
    //   164: invokespecial 40	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   167: athrow
    //   168: astore 7
    //   170: aload 7
    //   172: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   175: goto -78 -> 97
    //   178: iinc 8 1
    //   181: goto -81 -> 100
    //   184: aload_0
    //   185: invokestatic 89	com/sina/weibo/sdk/utils/Utility:access$1	(Ljava/lang/String;)Z
    //   188: pop
    //   189: aload_0
    //   190: invokestatic 92	com/sina/weibo/sdk/utils/Utility:access$2	(Ljava/lang/String;)V
    //   193: aload 9
    //   195: invokevirtual 133	android/graphics/Bitmap:getWidth	()I
    //   198: aload 9
    //   200: invokevirtual 136	android/graphics/Bitmap:getHeight	()I
    //   203: if_icmple +175 -> 378
    //   206: aload 9
    //   208: invokevirtual 133	android/graphics/Bitmap:getWidth	()I
    //   211: istore 11
    //   213: iload_1
    //   214: i2f
    //   215: iload 11
    //   217: i2f
    //   218: fdiv
    //   219: fstore 12
    //   221: fload 12
    //   223: fconst_1
    //   224: fcmpg
    //   225: ifge +99 -> 324
    //   228: fload 12
    //   230: fstore 17
    //   232: fload 17
    //   234: aload 9
    //   236: invokevirtual 133	android/graphics/Bitmap:getWidth	()I
    //   239: i2f
    //   240: fmul
    //   241: f2i
    //   242: fload 17
    //   244: aload 9
    //   246: invokevirtual 136	android/graphics/Bitmap:getHeight	()I
    //   249: i2f
    //   250: fmul
    //   251: f2i
    //   252: getstatic 142	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   255: invokestatic 146	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   258: astore 19
    //   260: aload 19
    //   262: ifnonnull +8 -> 270
    //   265: aload 9
    //   267: invokevirtual 123	android/graphics/Bitmap:recycle	()V
    //   270: new 148	android/graphics/Canvas
    //   273: dup
    //   274: aload 19
    //   276: invokespecial 151	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   279: astore 20
    //   281: new 153	android/graphics/Matrix
    //   284: dup
    //   285: invokespecial 154	android/graphics/Matrix:<init>	()V
    //   288: astore 21
    //   290: aload 21
    //   292: fload 17
    //   294: fload 17
    //   296: invokevirtual 158	android/graphics/Matrix:setScale	(FF)V
    //   299: aload 20
    //   301: aload 9
    //   303: aload 21
    //   305: new 160	android/graphics/Paint
    //   308: dup
    //   309: invokespecial 161	android/graphics/Paint:<init>	()V
    //   312: invokevirtual 165	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   315: aload 9
    //   317: invokevirtual 123	android/graphics/Bitmap:recycle	()V
    //   320: aload 19
    //   322: astore 9
    //   324: new 94	java/io/FileOutputStream
    //   327: dup
    //   328: aload_0
    //   329: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   332: astore 13
    //   334: aload 5
    //   336: getfield 99	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   339: ifnull +67 -> 406
    //   342: aload 5
    //   344: getfield 99	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   347: ldc 101
    //   349: invokevirtual 107	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   352: ifeq +54 -> 406
    //   355: aload 9
    //   357: getstatic 113	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   360: iload_2
    //   361: aload 13
    //   363: invokevirtual 119	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   366: pop
    //   367: aload 13
    //   369: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   372: aload 9
    //   374: invokevirtual 123	android/graphics/Bitmap:recycle	()V
    //   377: return
    //   378: aload 9
    //   380: invokevirtual 136	android/graphics/Bitmap:getHeight	()I
    //   383: istore 11
    //   385: goto -172 -> 213
    //   388: astore 18
    //   390: invokestatic 170	java/lang/System:gc	()V
    //   393: ldc2_w 171
    //   396: fload 17
    //   398: f2d
    //   399: dmul
    //   400: d2f
    //   401: fstore 17
    //   403: goto -171 -> 232
    //   406: aload 9
    //   408: getstatic 126	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   411: iload_2
    //   412: aload 13
    //   414: invokevirtual 119	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   417: pop
    //   418: goto -51 -> 367
    //   421: astore 15
    //   423: aload 15
    //   425: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   428: goto -56 -> 372
    //
    // Exception table:
    //   from	to	target	type
    //   92	97	168	java/lang/Exception
    //   232	260	388	java/lang/OutOfMemoryError
    //   367	372	421	java/lang/Exception
  }

  public static boolean revitionPostImageSize(Context paramContext, String paramString)
  {
    try
    {
      if (NetworkHelper.isWifiValid(paramContext))
        revitionImageSizeHD(paramString, 1600, 75);
      else
        revitionImageSize(paramString, 1024, 75);
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return false;
    }
    return true;
  }

  private static Bitmap safeDecodeBimtapFile(String paramString, BitmapFactory.Options paramOptions)
  {
    Object localObject1 = null;
    BitmapFactory.Options localOptions;
    if (paramOptions == null)
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 1;
    }
    while (true)
    {
      int i = 0;
      Object localObject2 = null;
      while (true)
      {
        if (i >= 5)
          return localObject2;
        try
        {
          FileInputStream localFileInputStream = new FileInputStream(paramString);
          try
          {
            Bitmap localBitmap = BitmapFactory.decodeStream(localFileInputStream, null, paramOptions);
            localObject2 = localBitmap;
            try
            {
              localFileInputStream.close();
              return localObject2;
            }
            catch (IOException localIOException2)
            {
              localIOException2.printStackTrace();
              return localObject2;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            localObject3 = localFileInputStream;
            localObject4 = localObject2;
            localObject5 = localOutOfMemoryError1;
          }
          ((OutOfMemoryError)localObject5).printStackTrace();
          localOptions.inSampleSize <<= 1;
          try
          {
            ((FileInputStream)localObject3).close();
            i++;
            localObject1 = localObject3;
            localObject2 = localObject4;
          }
          catch (IOException localIOException1)
          {
            while (true)
              localIOException1.printStackTrace();
          }
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          return localObject2;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          while (true)
          {
            Object localObject4 = localObject2;
            Object localObject5 = localOutOfMemoryError2;
            Object localObject3 = localObject1;
          }
        }
      }
      localOptions = paramOptions;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.utils.Utility.UploadImageUtils
 * JD-Core Version:    0.6.2
 */