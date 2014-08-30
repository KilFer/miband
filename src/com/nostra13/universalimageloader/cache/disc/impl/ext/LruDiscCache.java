package com.nostra13.universalimageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.IoUtils.CopyListener;
import com.nostra13.universalimageloader.utils.L;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LruDiscCache
  implements DiskCache
{
  public static final int DEFAULT_BUFFER_SIZE = 32768;
  public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
  public static final int DEFAULT_COMPRESS_QUALITY = 100;
  private static final String a = " argument must be not null";
  private static final String b = " argument must be positive number";
  protected int bufferSize = 32768;
  private File c;
  protected DiskLruCache cache;
  protected Bitmap.CompressFormat compressFormat = DEFAULT_COMPRESS_FORMAT;
  protected int compressQuality = 100;
  protected final FileNameGenerator fileNameGenerator;

  public LruDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator, long paramLong)
  {
    this(paramFile, paramFileNameGenerator, paramLong, 0);
  }

  public LruDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator, long paramLong, int paramInt)
  {
    if (paramFile == null)
      throw new IllegalArgumentException("cacheDir argument must be not null");
    if (paramLong < 0L)
      throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
    if (paramInt < 0)
      throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
    if (paramFileNameGenerator == null)
      throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    if (paramLong == 0L);
    for (long l = 9223372036854775807L; ; l = paramLong)
    {
      if (paramInt == 0);
      for (int i = 2147483647; ; i = paramInt)
      {
        this.fileNameGenerator = paramFileNameGenerator;
        a(paramFile, this.c, l, i);
        return;
      }
    }
  }

  private String a(String paramString)
  {
    return this.fileNameGenerator.generate(paramString);
  }

  private void a(File paramFile1, File paramFile2, long paramLong, int paramInt)
  {
    File localFile = paramFile1;
    while (true)
      try
      {
        this.cache = DiskLruCache.a(localFile, 1, 1, paramLong, paramInt);
        return;
      }
      catch (IOException localIOException)
      {
        L.e(localIOException);
        if (paramFile2 != null)
        {
          localFile = paramFile2;
          paramFile2 = null;
        }
      }
  }

  public void clear()
  {
    try
    {
      this.cache.d();
      return;
    }
    catch (IOException localIOException)
    {
      L.e(localIOException);
      return;
    }
    finally
    {
      a(this.cache.a(), this.c, this.cache.b(), this.cache.c());
    }
  }

  public void close()
  {
    try
    {
      this.cache.close();
      this.cache = null;
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        L.e(localIOException);
    }
  }

  // ERROR //
  public File get(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 89	com/nostra13/universalimageloader/cache/disc/impl/ext/LruDiscCache:cache	Lcom/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache;
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 115	com/nostra13/universalimageloader/cache/disc/impl/ext/LruDiscCache:a	(Ljava/lang/String;)Ljava/lang/String;
    //   9: invokevirtual 118	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache:a	(Ljava/lang/String;)Lcom/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Snapshot;
    //   12: astore 7
    //   14: aload 7
    //   16: astore_3
    //   17: aconst_null
    //   18: astore 6
    //   20: aload_3
    //   21: ifnonnull +14 -> 35
    //   24: aload_3
    //   25: ifnull +7 -> 32
    //   28: aload_3
    //   29: invokevirtual 121	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Snapshot:close	()V
    //   32: aload 6
    //   34: areturn
    //   35: aload_3
    //   36: iconst_0
    //   37: invokevirtual 125	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Snapshot:getFile	(I)Ljava/io/File;
    //   40: astore 8
    //   42: aload 8
    //   44: astore 6
    //   46: goto -22 -> 24
    //   49: astore 5
    //   51: aconst_null
    //   52: astore_3
    //   53: aload 5
    //   55: invokestatic 95	com/nostra13/universalimageloader/utils/L:e	(Ljava/lang/Throwable;)V
    //   58: aconst_null
    //   59: astore 6
    //   61: aload_3
    //   62: ifnull -30 -> 32
    //   65: aload_3
    //   66: invokevirtual 121	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Snapshot:close	()V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_3
    //   74: aload_2
    //   75: astore 4
    //   77: aload_3
    //   78: ifnull +7 -> 85
    //   81: aload_3
    //   82: invokevirtual 121	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Snapshot:close	()V
    //   85: aload 4
    //   87: athrow
    //   88: astore 4
    //   90: goto -13 -> 77
    //   93: astore 5
    //   95: goto -42 -> 53
    //
    // Exception table:
    //   from	to	target	type
    //   0	14	49	java/io/IOException
    //   0	14	71	finally
    //   35	42	88	finally
    //   53	58	88	finally
    //   35	42	93	java/io/IOException
  }

  public File getDirectory()
  {
    return this.cache.a();
  }

  public boolean remove(String paramString)
  {
    try
    {
      boolean bool = this.cache.c(a(paramString));
      return bool;
    }
    catch (IOException localIOException)
    {
      L.e(localIOException);
    }
    return false;
  }

  public boolean save(String paramString, Bitmap paramBitmap)
  {
    DiskLruCache.Editor localEditor = this.cache.b(a(paramString));
    if (localEditor == null)
      return false;
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localEditor.newOutputStream(0), this.bufferSize);
    boolean bool;
    try
    {
      bool = paramBitmap.compress(this.compressFormat, this.compressQuality, localBufferedOutputStream);
      IoUtils.closeSilently(localBufferedOutputStream);
      if (bool)
      {
        localEditor.commit();
        return bool;
      }
    }
    finally
    {
      IoUtils.closeSilently(localBufferedOutputStream);
    }
    localEditor.abort();
    return bool;
  }

  public boolean save(String paramString, InputStream paramInputStream, IoUtils.CopyListener paramCopyListener)
  {
    DiskLruCache.Editor localEditor = this.cache.b(a(paramString));
    if (localEditor == null)
      return false;
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localEditor.newOutputStream(0), this.bufferSize);
    try
    {
      boolean bool = IoUtils.copyStream(paramInputStream, localBufferedOutputStream, paramCopyListener, this.bufferSize);
      IoUtils.closeSilently(localBufferedOutputStream);
      if (bool)
      {
        localEditor.commit();
        return bool;
      }
      localEditor.abort();
      return bool;
    }
    finally
    {
      IoUtils.closeSilently(localBufferedOutputStream);
      localEditor.abort();
    }
  }

  public void setBufferSize(int paramInt)
  {
    this.bufferSize = paramInt;
  }

  public void setCompressFormat(Bitmap.CompressFormat paramCompressFormat)
  {
    this.compressFormat = paramCompressFormat;
  }

  public void setCompressQuality(int paramInt)
  {
    this.compressQuality = paramInt;
  }

  public void setReserveCacheDir(File paramFile)
  {
    this.c = paramFile;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiscCache
 * JD-Core Version:    0.6.2
 */