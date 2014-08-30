package com.nostra13.universalimageloader.cache.disc.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public abstract class BaseDiscCache
  implements DiskCache
{
  public static final int DEFAULT_BUFFER_SIZE = 32768;
  public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
  public static final int DEFAULT_COMPRESS_QUALITY = 100;
  private static final String a = " argument must be not null";
  private static final String b = ".tmp";
  protected int bufferSize = 32768;
  protected final File cacheDir;
  protected Bitmap.CompressFormat compressFormat = DEFAULT_COMPRESS_FORMAT;
  protected int compressQuality = 100;
  protected final FileNameGenerator fileNameGenerator;
  protected final File reserveCacheDir;

  public BaseDiscCache(File paramFile)
  {
    this(paramFile, null);
  }

  public BaseDiscCache(File paramFile1, File paramFile2)
  {
    this(paramFile1, paramFile2, DefaultConfigurationFactory.createFileNameGenerator());
  }

  public BaseDiscCache(File paramFile1, File paramFile2, FileNameGenerator paramFileNameGenerator)
  {
    if (paramFile1 == null)
      throw new IllegalArgumentException("cacheDir argument must be not null");
    if (paramFileNameGenerator == null)
      throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    this.cacheDir = paramFile1;
    this.reserveCacheDir = paramFile2;
    this.fileNameGenerator = paramFileNameGenerator;
  }

  public void clear()
  {
    File[] arrayOfFile = this.cacheDir.listFiles();
    if (arrayOfFile != null)
    {
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
        arrayOfFile[j].delete();
    }
  }

  public void close()
  {
  }

  public File get(String paramString)
  {
    return getFile(paramString);
  }

  public File getDirectory()
  {
    return this.cacheDir;
  }

  protected File getFile(String paramString)
  {
    String str = this.fileNameGenerator.generate(paramString);
    File localFile = this.cacheDir;
    if ((!this.cacheDir.exists()) && (!this.cacheDir.mkdirs()) && (this.reserveCacheDir != null) && ((this.reserveCacheDir.exists()) || (this.reserveCacheDir.mkdirs())))
      localFile = this.reserveCacheDir;
    return new File(localFile, str);
  }

  public boolean remove(String paramString)
  {
    return getFile(paramString).delete();
  }

  public boolean save(String paramString, Bitmap paramBitmap)
  {
    File localFile1 = getFile(paramString);
    File localFile2 = new File(localFile1.getAbsolutePath() + ".tmp");
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localFile2), this.bufferSize);
    try
    {
      boolean bool1 = paramBitmap.compress(this.compressFormat, this.compressQuality, localBufferedOutputStream);
      boolean bool2 = bool1;
      IoUtils.closeSilently(localBufferedOutputStream);
      if ((bool2) && (!localFile2.renameTo(localFile1)))
        bool2 = false;
      if (!bool2)
        localFile2.delete();
      paramBitmap.recycle();
      return bool2;
    }
    finally
    {
      IoUtils.closeSilently(localBufferedOutputStream);
      localFile2.delete();
    }
  }

  // ERROR //
  public boolean save(String paramString, java.io.InputStream paramInputStream, com.nostra13.universalimageloader.utils.IoUtils.CopyListener paramCopyListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 91	com/nostra13/universalimageloader/cache/disc/impl/BaseDiscCache:getFile	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore 4
    //   7: new 77	java/io/File
    //   10: dup
    //   11: new 114	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   18: aload 4
    //   20: invokevirtual 119	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   23: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 20
    //   28: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 5
    //   39: new 129	java/io/BufferedOutputStream
    //   42: dup
    //   43: new 131	java/io/FileOutputStream
    //   46: dup
    //   47: aload 5
    //   49: invokespecial 133	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   52: aload_0
    //   53: getfield 55	com/nostra13/universalimageloader/cache/disc/impl/BaseDiscCache:bufferSize	I
    //   56: invokespecial 136	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   59: astore 6
    //   61: aload_2
    //   62: aload 6
    //   64: aload_3
    //   65: aload_0
    //   66: getfield 55	com/nostra13/universalimageloader/cache/disc/impl/BaseDiscCache:bufferSize	I
    //   69: invokestatic 160	com/nostra13/universalimageloader/utils/IoUtils:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;Lcom/nostra13/universalimageloader/utils/IoUtils$CopyListener;I)Z
    //   72: istore 11
    //   74: iload 11
    //   76: istore 9
    //   78: aload 6
    //   80: invokestatic 148	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   83: aload_2
    //   84: invokestatic 148	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   87: iload 9
    //   89: ifeq +16 -> 105
    //   92: aload 5
    //   94: aload 4
    //   96: invokevirtual 152	java/io/File:renameTo	(Ljava/io/File;)Z
    //   99: ifne +6 -> 105
    //   102: iconst_0
    //   103: istore 9
    //   105: iload 9
    //   107: ifne +9 -> 116
    //   110: aload 5
    //   112: invokevirtual 85	java/io/File:delete	()Z
    //   115: pop
    //   116: iload 9
    //   118: ireturn
    //   119: astore 7
    //   121: aload 6
    //   123: invokestatic 148	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   126: aload 7
    //   128: athrow
    //   129: astore 8
    //   131: iconst_0
    //   132: istore 9
    //   134: aload_2
    //   135: invokestatic 148	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   138: iload 9
    //   140: ifeq +16 -> 156
    //   143: aload 5
    //   145: aload 4
    //   147: invokevirtual 152	java/io/File:renameTo	(Ljava/io/File;)Z
    //   150: ifne +6 -> 156
    //   153: iconst_0
    //   154: istore 9
    //   156: iload 9
    //   158: ifne +9 -> 167
    //   161: aload 5
    //   163: invokevirtual 85	java/io/File:delete	()Z
    //   166: pop
    //   167: aload 8
    //   169: athrow
    //   170: astore 8
    //   172: goto -38 -> 134
    //
    // Exception table:
    //   from	to	target	type
    //   61	74	119	finally
    //   39	61	129	finally
    //   121	129	129	finally
    //   78	83	170	finally
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
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.BaseDiscCache
 * JD-Core Version:    0.6.2
 */