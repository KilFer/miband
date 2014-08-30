package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.assist.FailReason.FailType;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.IoUtils.CopyListener;
import com.nostra13.universalimageloader.utils.L;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

final class l
  implements IoUtils.CopyListener, Runnable
{
  private static final String f = "ImageLoader is paused. Waiting...  [%s]";
  private static final String g = ".. Resume loading [%s]";
  private static final String h = "Delay %d ms before loading...  [%s]";
  private static final String i = "Start display image task [%s]";
  private static final String j = "Image already is loading. Waiting... [%s]";
  private static final String k = "...Get cached bitmap from memory after waiting. [%s]";
  private static final String l = "Load image from network [%s]";
  private static final String m = "Load image from disk cache [%s]";
  private static final String n = "Resize image in disk cache [%s]";
  private static final String o = "PreProcess image before caching in memory [%s]";
  private static final String p = "PostProcess image before displaying [%s]";
  private static final String q = "Cache image in memory [%s]";
  private static final String r = "Cache image on disk [%s]";
  private static final String s = "Process image before cache on disk [%s]";
  private static final String t = "ImageAware is reused for another image. Task is cancelled. [%s]";
  private static final String u = "ImageAware was collected by GC. Task is cancelled. [%s]";
  private static final String v = "Task was interrupted [%s]";
  private static final String w = "Pre-processor returned null [%s]";
  private static final String x = "Post-processor returned null [%s]";
  private static final String y = "Bitmap processor for disk cache returned null [%s]";
  private final k A;
  private final Handler B;
  private final ImageLoaderConfiguration C;
  private final ImageDownloader D;
  private final ImageDownloader E;
  private final ImageDownloader F;
  private final ImageDecoder G;
  private final String H;
  private final ImageSize I;
  private final boolean J;
  private LoadedFrom K = LoadedFrom.NETWORK;
  final String a;
  final ImageAware b;
  final DisplayImageOptions c;
  final ImageLoadingListener d;
  final ImageLoadingProgressListener e;
  private final c z;

  public l(c paramc, k paramk, Handler paramHandler)
  {
    this.z = paramc;
    this.A = paramk;
    this.B = paramHandler;
    this.C = paramc.a;
    this.D = this.C.n;
    this.E = this.C.q;
    this.F = this.C.r;
    this.G = this.C.o;
    this.a = paramk.a;
    this.H = paramk.b;
    this.b = paramk.c;
    this.I = paramk.d;
    this.c = paramk.e;
    this.d = paramk.f;
    this.e = paramk.g;
    this.J = this.c.a();
  }

  private Bitmap a(String paramString)
  {
    ViewScaleType localViewScaleType = this.b.getScaleType();
    ImageDecodingInfo localImageDecodingInfo = new ImageDecodingInfo(this.H, paramString, this.a, this.I, localViewScaleType, h(), this.c);
    return this.G.decode(localImageDecodingInfo);
  }

  private void a(FailReason.FailType paramFailType, Throwable paramThrowable)
  {
    if ((this.J) || (p()) || (j()))
      return;
    a(new n(this, paramFailType, paramThrowable), false, this.B, this.z);
  }

  static void a(Runnable paramRunnable, boolean paramBoolean, Handler paramHandler, c paramc)
  {
    if (paramBoolean)
    {
      paramRunnable.run();
      return;
    }
    if (paramHandler == null)
    {
      paramc.a(paramRunnable);
      return;
    }
    paramHandler.post(paramRunnable);
  }

  private boolean a(int paramInt1, int paramInt2)
  {
    File localFile = this.C.m.get(this.a);
    if ((localFile != null) && (localFile.exists()))
    {
      ImageSize localImageSize = new ImageSize(paramInt1, paramInt2);
      DisplayImageOptions localDisplayImageOptions = new DisplayImageOptions.Builder().cloneFrom(this.c).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
      ImageDecodingInfo localImageDecodingInfo = new ImageDecodingInfo(this.H, ImageDownloader.Scheme.FILE.wrap(localFile.getAbsolutePath()), this.a, localImageSize, ViewScaleType.FIT_INSIDE, h(), localDisplayImageOptions);
      Bitmap localBitmap1 = this.G.decode(localImageDecodingInfo);
      if ((localBitmap1 != null) && (this.C.d != null))
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = this.H;
        L.d("Process image before cache on disk [%s]", arrayOfObject1);
        localBitmap1 = this.C.d.process(localBitmap1);
        if (localBitmap1 == null)
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = this.H;
          L.e("Bitmap processor for disk cache returned null [%s]", arrayOfObject2);
        }
      }
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap2 != null)
      {
        boolean bool = this.C.m.save(this.a, localBitmap2);
        localBitmap2.recycle();
        return bool;
      }
    }
    return false;
  }

  private boolean b()
  {
    AtomicBoolean localAtomicBoolean = this.z.d();
    if (localAtomicBoolean.get());
    synchronized (this.z.e())
    {
      if (localAtomicBoolean.get())
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = this.H;
        L.d("ImageLoader is paused. Waiting...  [%s]", arrayOfObject1);
      }
      try
      {
        this.z.e().wait();
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = this.H;
        L.d(".. Resume loading [%s]", arrayOfObject3);
        return j();
      }
      catch (InterruptedException localInterruptedException)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.H;
        L.e("Task was interrupted [%s]", arrayOfObject2);
        return true;
      }
    }
  }

  private boolean b(int paramInt1, int paramInt2)
  {
    if ((this.J) || (p()) || (j()))
      return false;
    if (this.e != null)
      a(new m(this, paramInt1, paramInt2), false, this.B, this.z);
    return true;
  }

  private boolean c()
  {
    if (this.c.shouldDelayBeforeLoading())
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(this.c.getDelayBeforeLoading());
      arrayOfObject1[1] = this.H;
      L.d("Delay %d ms before loading...  [%s]", arrayOfObject1);
      try
      {
        Thread.sleep(this.c.getDelayBeforeLoading());
        return j();
      }
      catch (InterruptedException localInterruptedException)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.H;
        L.e("Task was interrupted [%s]", arrayOfObject2);
        return true;
      }
    }
    return false;
  }

  // ERROR //
  private Bitmap d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 123	com/nostra13/universalimageloader/core/l:C	Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;
    //   4: getfield 228	com/nostra13/universalimageloader/core/ImageLoaderConfiguration:m	Lcom/nostra13/universalimageloader/cache/disc/DiskCache;
    //   7: aload_0
    //   8: getfield 146	com/nostra13/universalimageloader/core/l:a	Ljava/lang/String;
    //   11: invokeinterface 234 2 0
    //   16: astore 10
    //   18: aload 10
    //   20: ifnull +312 -> 332
    //   23: aload 10
    //   25: invokevirtual 239	java/io/File:exists	()Z
    //   28: ifeq +304 -> 332
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: astore 15
    //   37: aload 15
    //   39: iconst_0
    //   40: aload_0
    //   41: getfield 150	com/nostra13/universalimageloader/core/l:H	Ljava/lang/String;
    //   44: aastore
    //   45: ldc 33
    //   47: aload 15
    //   49: invokestatic 293	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: aload_0
    //   53: getstatic 363	com/nostra13/universalimageloader/core/assist/LoadedFrom:DISC_CACHE	Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;
    //   56: putfield 111	com/nostra13/universalimageloader/core/l:K	Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;
    //   59: aload_0
    //   60: invokespecial 365	com/nostra13/universalimageloader/core/l:i	()V
    //   63: aload_0
    //   64: getstatic 271	com/nostra13/universalimageloader/core/download/ImageDownloader$Scheme:FILE	Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;
    //   67: aload 10
    //   69: invokevirtual 275	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   72: invokevirtual 279	com/nostra13/universalimageloader/core/download/ImageDownloader$Scheme:wrap	(Ljava/lang/String;)Ljava/lang/String;
    //   75: invokespecial 367	com/nostra13/universalimageloader/core/l:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   78: astore 16
    //   80: aload 16
    //   82: astore_2
    //   83: aload_2
    //   84: ifnull +17 -> 101
    //   87: aload_2
    //   88: invokevirtual 370	android/graphics/Bitmap:getWidth	()I
    //   91: ifle +10 -> 101
    //   94: aload_2
    //   95: invokevirtual 373	android/graphics/Bitmap:getHeight	()I
    //   98: ifgt +127 -> 225
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: astore 12
    //   107: aload 12
    //   109: iconst_0
    //   110: aload_0
    //   111: getfield 150	com/nostra13/universalimageloader/core/l:H	Ljava/lang/String;
    //   114: aastore
    //   115: ldc 30
    //   117: aload 12
    //   119: invokestatic 293	com/nostra13/universalimageloader/utils/L:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_0
    //   123: getstatic 109	com/nostra13/universalimageloader/core/assist/LoadedFrom:NETWORK	Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;
    //   126: putfield 111	com/nostra13/universalimageloader/core/l:K	Lcom/nostra13/universalimageloader/core/assist/LoadedFrom;
    //   129: aload_0
    //   130: getfield 146	com/nostra13/universalimageloader/core/l:a	Ljava/lang/String;
    //   133: astore 13
    //   135: aload_0
    //   136: getfield 162	com/nostra13/universalimageloader/core/l:c	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   139: invokevirtual 376	com/nostra13/universalimageloader/core/DisplayImageOptions:isCacheOnDisk	()Z
    //   142: ifeq +46 -> 188
    //   145: aload_0
    //   146: invokespecial 378	com/nostra13/universalimageloader/core/l:e	()Z
    //   149: ifeq +39 -> 188
    //   152: aload_0
    //   153: getfield 123	com/nostra13/universalimageloader/core/l:C	Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;
    //   156: getfield 228	com/nostra13/universalimageloader/core/ImageLoaderConfiguration:m	Lcom/nostra13/universalimageloader/cache/disc/DiskCache;
    //   159: aload_0
    //   160: getfield 146	com/nostra13/universalimageloader/core/l:a	Ljava/lang/String;
    //   163: invokeinterface 234 2 0
    //   168: astore 14
    //   170: aload 14
    //   172: ifnull +16 -> 188
    //   175: getstatic 271	com/nostra13/universalimageloader/core/download/ImageDownloader$Scheme:FILE	Lcom/nostra13/universalimageloader/core/download/ImageDownloader$Scheme;
    //   178: aload 14
    //   180: invokevirtual 275	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   183: invokevirtual 279	com/nostra13/universalimageloader/core/download/ImageDownloader$Scheme:wrap	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 13
    //   188: aload_0
    //   189: invokespecial 365	com/nostra13/universalimageloader/core/l:i	()V
    //   192: aload_0
    //   193: aload 13
    //   195: invokespecial 367	com/nostra13/universalimageloader/core/l:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   198: astore_2
    //   199: aload_2
    //   200: ifnull +17 -> 217
    //   203: aload_2
    //   204: invokevirtual 370	android/graphics/Bitmap:getWidth	()I
    //   207: ifle +10 -> 217
    //   210: aload_2
    //   211: invokevirtual 373	android/graphics/Bitmap:getHeight	()I
    //   214: ifgt +11 -> 225
    //   217: aload_0
    //   218: getstatic 384	com/nostra13/universalimageloader/core/assist/FailReason$FailType:DECODING_ERROR	Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;
    //   221: aconst_null
    //   222: invokespecial 386	com/nostra13/universalimageloader/core/l:a	(Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;Ljava/lang/Throwable;)V
    //   225: aload_2
    //   226: areturn
    //   227: astore 9
    //   229: aconst_null
    //   230: astore_2
    //   231: aload_0
    //   232: getstatic 389	com/nostra13/universalimageloader/core/assist/FailReason$FailType:NETWORK_DENIED	Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;
    //   235: aconst_null
    //   236: invokespecial 386	com/nostra13/universalimageloader/core/l:a	(Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;Ljava/lang/Throwable;)V
    //   239: aload_2
    //   240: areturn
    //   241: astore 8
    //   243: aload 8
    //   245: athrow
    //   246: astore 6
    //   248: aconst_null
    //   249: astore_2
    //   250: aload 6
    //   252: astore 7
    //   254: aload 7
    //   256: invokestatic 392	com/nostra13/universalimageloader/utils/L:e	(Ljava/lang/Throwable;)V
    //   259: aload_0
    //   260: getstatic 395	com/nostra13/universalimageloader/core/assist/FailReason$FailType:IO_ERROR	Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;
    //   263: aload 7
    //   265: invokespecial 386	com/nostra13/universalimageloader/core/l:a	(Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;Ljava/lang/Throwable;)V
    //   268: aload_2
    //   269: areturn
    //   270: astore 4
    //   272: aconst_null
    //   273: astore_2
    //   274: aload 4
    //   276: astore 5
    //   278: aload 5
    //   280: invokestatic 392	com/nostra13/universalimageloader/utils/L:e	(Ljava/lang/Throwable;)V
    //   283: aload_0
    //   284: getstatic 398	com/nostra13/universalimageloader/core/assist/FailReason$FailType:OUT_OF_MEMORY	Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;
    //   287: aload 5
    //   289: invokespecial 386	com/nostra13/universalimageloader/core/l:a	(Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;Ljava/lang/Throwable;)V
    //   292: aload_2
    //   293: areturn
    //   294: astore_1
    //   295: aconst_null
    //   296: astore_2
    //   297: aload_1
    //   298: astore_3
    //   299: aload_3
    //   300: invokestatic 392	com/nostra13/universalimageloader/utils/L:e	(Ljava/lang/Throwable;)V
    //   303: aload_0
    //   304: getstatic 401	com/nostra13/universalimageloader/core/assist/FailReason$FailType:UNKNOWN	Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;
    //   307: aload_3
    //   308: invokespecial 386	com/nostra13/universalimageloader/core/l:a	(Lcom/nostra13/universalimageloader/core/assist/FailReason$FailType;Ljava/lang/Throwable;)V
    //   311: aload_2
    //   312: areturn
    //   313: astore_3
    //   314: goto -15 -> 299
    //   317: astore 5
    //   319: goto -41 -> 278
    //   322: astore 7
    //   324: goto -70 -> 254
    //   327: astore 11
    //   329: goto -98 -> 231
    //   332: aconst_null
    //   333: astore_2
    //   334: goto -251 -> 83
    //
    // Exception table:
    //   from	to	target	type
    //   0	18	227	java/lang/IllegalStateException
    //   23	80	227	java/lang/IllegalStateException
    //   0	18	241	com/nostra13/universalimageloader/core/p
    //   23	80	241	com/nostra13/universalimageloader/core/p
    //   87	101	241	com/nostra13/universalimageloader/core/p
    //   101	170	241	com/nostra13/universalimageloader/core/p
    //   175	188	241	com/nostra13/universalimageloader/core/p
    //   188	199	241	com/nostra13/universalimageloader/core/p
    //   203	217	241	com/nostra13/universalimageloader/core/p
    //   217	225	241	com/nostra13/universalimageloader/core/p
    //   0	18	246	java/io/IOException
    //   23	80	246	java/io/IOException
    //   0	18	270	java/lang/OutOfMemoryError
    //   23	80	270	java/lang/OutOfMemoryError
    //   0	18	294	java/lang/Throwable
    //   23	80	294	java/lang/Throwable
    //   87	101	313	java/lang/Throwable
    //   101	170	313	java/lang/Throwable
    //   175	188	313	java/lang/Throwable
    //   188	199	313	java/lang/Throwable
    //   203	217	313	java/lang/Throwable
    //   217	225	313	java/lang/Throwable
    //   87	101	317	java/lang/OutOfMemoryError
    //   101	170	317	java/lang/OutOfMemoryError
    //   175	188	317	java/lang/OutOfMemoryError
    //   188	199	317	java/lang/OutOfMemoryError
    //   203	217	317	java/lang/OutOfMemoryError
    //   217	225	317	java/lang/OutOfMemoryError
    //   87	101	322	java/io/IOException
    //   101	170	322	java/io/IOException
    //   175	188	322	java/io/IOException
    //   188	199	322	java/io/IOException
    //   203	217	322	java/io/IOException
    //   217	225	322	java/io/IOException
    //   87	101	327	java/lang/IllegalStateException
    //   101	170	327	java/lang/IllegalStateException
    //   175	188	327	java/lang/IllegalStateException
    //   188	199	327	java/lang/IllegalStateException
    //   203	217	327	java/lang/IllegalStateException
    //   217	225	327	java/lang/IllegalStateException
  }

  private boolean e()
  {
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this.H;
    L.d("Cache image on disk [%s]", arrayOfObject1);
    try
    {
      InputStream localInputStream = h().getStream(this.a, this.c.getExtraForDownloader());
      boolean bool = this.C.m.save(this.a, localInputStream, this);
      if (bool)
      {
        int i1 = this.C.b;
        int i2 = this.C.c;
        if ((i1 > 0) || (i2 > 0))
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = this.H;
          L.d("Resize image in disk cache [%s]", arrayOfObject2);
          File localFile = this.C.m.get(this.a);
          if ((localFile != null) && (localFile.exists()))
          {
            ImageSize localImageSize = new ImageSize(i1, i2);
            DisplayImageOptions localDisplayImageOptions = new DisplayImageOptions.Builder().cloneFrom(this.c).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
            ImageDecodingInfo localImageDecodingInfo = new ImageDecodingInfo(this.H, ImageDownloader.Scheme.FILE.wrap(localFile.getAbsolutePath()), this.a, localImageSize, ViewScaleType.FIT_INSIDE, h(), localDisplayImageOptions);
            Bitmap localBitmap = this.G.decode(localImageDecodingInfo);
            if ((localBitmap != null) && (this.C.d != null))
            {
              Object[] arrayOfObject3 = new Object[1];
              arrayOfObject3[0] = this.H;
              L.d("Process image before cache on disk [%s]", arrayOfObject3);
              localBitmap = this.C.d.process(localBitmap);
              if (localBitmap == null)
              {
                Object[] arrayOfObject4 = new Object[1];
                arrayOfObject4[0] = this.H;
                L.e("Bitmap processor for disk cache returned null [%s]", arrayOfObject4);
              }
            }
            if (localBitmap != null)
            {
              this.C.m.save(this.a, localBitmap);
              localBitmap.recycle();
            }
          }
        }
      }
      return bool;
    }
    catch (IOException localIOException)
    {
      L.e(localIOException);
    }
    return false;
  }

  private boolean f()
  {
    InputStream localInputStream = h().getStream(this.a, this.c.getExtraForDownloader());
    return this.C.m.save(this.a, localInputStream, this);
  }

  private void g()
  {
    if ((this.J) || (p()))
      return;
    a(new o(this), false, this.B, this.z);
  }

  private ImageDownloader h()
  {
    if (this.z.f())
      return this.E;
    if (this.z.g())
      return this.F;
    return this.D;
  }

  private void i()
  {
    if (l())
      throw new p(this);
    if (n())
      throw new p(this);
  }

  private boolean j()
  {
    return (l()) || (n());
  }

  private void k()
  {
    if (l())
      throw new p(this);
  }

  private boolean l()
  {
    if (this.b.isCollected())
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.H;
      L.d("ImageAware was collected by GC. Task is cancelled. [%s]", arrayOfObject);
      return true;
    }
    return false;
  }

  private void m()
  {
    if (n())
      throw new p(this);
  }

  private boolean n()
  {
    String str = this.z.a(this.b);
    if (!this.H.equals(str));
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.H;
      L.d("ImageAware is reused for another image. Task is cancelled. [%s]", arrayOfObject);
      return true;
    }
    return false;
  }

  private void o()
  {
    if (p())
      throw new p(this);
  }

  private boolean p()
  {
    if (Thread.interrupted())
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.H;
      L.d("Task was interrupted [%s]", arrayOfObject);
      return true;
    }
    return false;
  }

  final String a()
  {
    return this.a;
  }

  public final boolean onBytesCopied(int paramInt1, int paramInt2)
  {
    if ((this.J) || (p()) || (j()))
      return false;
    if (this.e != null)
      a(new m(this, paramInt1, paramInt2), false, this.B, this.z);
    return true;
  }

  public final void run()
  {
    if (b());
    while (c())
      return;
    ReentrantLock localReentrantLock = this.A.h;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this.H;
    L.d("Start display image task [%s]", arrayOfObject1);
    if (localReentrantLock.isLocked())
    {
      Object[] arrayOfObject8 = new Object[1];
      arrayOfObject8[0] = this.H;
      L.d("Image already is loading. Waiting... [%s]", arrayOfObject8);
    }
    localReentrantLock.lock();
    try
    {
      i();
      Object localObject2 = (Bitmap)this.C.l.get(this.H);
      if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled()))
      {
        Bitmap localBitmap = d();
        localObject2 = localBitmap;
        if (localObject2 == null)
          return;
        i();
        o();
        if (this.c.shouldPreProcess())
        {
          Object[] arrayOfObject5 = new Object[1];
          arrayOfObject5[0] = this.H;
          L.d("PreProcess image before caching in memory [%s]", arrayOfObject5);
          localObject2 = this.c.getPreProcessor().process((Bitmap)localObject2);
          if (localObject2 == null)
          {
            Object[] arrayOfObject6 = new Object[1];
            arrayOfObject6[0] = this.H;
            L.e("Pre-processor returned null [%s]", arrayOfObject6);
          }
        }
        if ((localObject2 != null) && (this.c.isCacheInMemory()))
        {
          Object[] arrayOfObject4 = new Object[1];
          arrayOfObject4[0] = this.H;
          L.d("Cache image in memory [%s]", arrayOfObject4);
          this.C.l.put(this.H, localObject2);
        }
      }
      while (true)
      {
        if ((localObject2 != null) && (this.c.shouldPostProcess()))
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = this.H;
          L.d("PostProcess image before displaying [%s]", arrayOfObject2);
          localObject2 = this.c.getPostProcessor().process((Bitmap)localObject2);
          if (localObject2 == null)
          {
            Object[] arrayOfObject3 = new Object[1];
            arrayOfObject3[0] = this.H;
            L.e("Post-processor returned null [%s]", arrayOfObject3);
          }
        }
        i();
        o();
        localReentrantLock.unlock();
        a(new b((Bitmap)localObject2, this.A, this.z, this.K), this.J, this.B, this.z);
        return;
        this.K = LoadedFrom.MEMORY_CACHE;
        Object[] arrayOfObject7 = new Object[1];
        arrayOfObject7[0] = this.H;
        L.d("...Get cached bitmap from memory after waiting. [%s]", arrayOfObject7);
      }
    }
    catch (p localp)
    {
      if (!this.J)
      {
        boolean bool = p();
        if (!bool)
          break label450;
      }
      while (true)
      {
        return;
        label450: a(new o(this), false, this.B, this.z);
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.l
 * JD-Core Version:    0.6.2
 */