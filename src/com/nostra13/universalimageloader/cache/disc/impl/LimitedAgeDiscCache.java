package com.nostra13.universalimageloader.cache.disc.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.utils.IoUtils.CopyListener;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LimitedAgeDiscCache extends BaseDiscCache
{
  private final long a;
  private final Map<File, Long> b = Collections.synchronizedMap(new HashMap());

  public LimitedAgeDiscCache(File paramFile, long paramLong)
  {
    this(paramFile, null, DefaultConfigurationFactory.createFileNameGenerator(), paramLong);
  }

  public LimitedAgeDiscCache(File paramFile1, File paramFile2, long paramLong)
  {
    this(paramFile1, paramFile2, DefaultConfigurationFactory.createFileNameGenerator(), paramLong);
  }

  public LimitedAgeDiscCache(File paramFile1, File paramFile2, FileNameGenerator paramFileNameGenerator, long paramLong)
  {
    super(paramFile1, paramFile2, paramFileNameGenerator);
    this.a = (1000L * paramLong);
  }

  private void a(String paramString)
  {
    File localFile = getFile(paramString);
    long l = System.currentTimeMillis();
    localFile.setLastModified(l);
    this.b.put(localFile, Long.valueOf(l));
  }

  public void clear()
  {
    super.clear();
    this.b.clear();
  }

  public File get(String paramString)
  {
    File localFile = super.get(paramString);
    Long localLong;
    int i;
    if ((localFile != null) && (localFile.exists()))
    {
      localLong = (Long)this.b.get(localFile);
      if (localLong != null)
        break label80;
      i = 0;
      localLong = Long.valueOf(localFile.lastModified());
      if (System.currentTimeMillis() - localLong.longValue() <= this.a)
        break label86;
      localFile.delete();
      this.b.remove(localFile);
    }
    label80: label86: 
    while (i != 0)
    {
      return localFile;
      i = 1;
      break;
    }
    this.b.put(localFile, localLong);
    return localFile;
  }

  public boolean remove(String paramString)
  {
    this.b.remove(getFile(paramString));
    return super.remove(paramString);
  }

  public boolean save(String paramString, Bitmap paramBitmap)
  {
    boolean bool = super.save(paramString, paramBitmap);
    a(paramString);
    return bool;
  }

  public boolean save(String paramString, InputStream paramInputStream, IoUtils.CopyListener paramCopyListener)
  {
    boolean bool = super.save(paramString, paramInputStream, paramCopyListener);
    a(paramString);
    return bool;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.LimitedAgeDiscCache
 * JD-Core Version:    0.6.2
 */