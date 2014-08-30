package com.nostra13.universalimageloader.core;

import android.content.Context;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;
import java.util.concurrent.Executor;

public class ImageLoaderConfiguration$Builder
{
  public static final QueueProcessingType DEFAULT_TASK_PROCESSING_TYPE = QueueProcessingType.FIFO;
  public static final int DEFAULT_THREAD_POOL_SIZE = 3;
  public static final int DEFAULT_THREAD_PRIORITY = 4;
  private static final String a = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";
  private static final String b = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";
  private static final String c = "memoryCache() and memoryCacheSize() calls overlap each other";
  private static final String d = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
  private DisplayImageOptions A = null;
  private boolean B = false;
  private Context e;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private BitmapProcessor j = null;
  private Executor k = null;
  private Executor l = null;
  private boolean m = false;
  private boolean n = false;
  private int o = 3;
  private int p = 4;
  private boolean q = false;
  private QueueProcessingType r = DEFAULT_TASK_PROCESSING_TYPE;
  private int s = 0;
  private long t = 0L;
  private int u = 0;
  private MemoryCache v = null;
  private DiskCache w = null;
  private FileNameGenerator x = null;
  private ImageDownloader y = null;
  private ImageDecoder z;

  public ImageLoaderConfiguration$Builder(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
  }

  private void a()
  {
    if (this.k == null)
    {
      this.k = DefaultConfigurationFactory.createExecutor(this.o, this.p, this.r);
      if (this.l != null)
        break label198;
      this.l = DefaultConfigurationFactory.createExecutor(this.o, this.p, this.r);
    }
    while (true)
    {
      if (this.w == null)
      {
        if (this.x == null)
          this.x = DefaultConfigurationFactory.createFileNameGenerator();
        this.w = DefaultConfigurationFactory.createDiskCache(this.e, this.x, this.t, this.u);
      }
      if (this.v == null)
        this.v = DefaultConfigurationFactory.createMemoryCache(this.s);
      if (this.q)
        this.v = new FuzzyKeyMemoryCache(this.v, MemoryCacheUtils.createFuzzyKeyComparator());
      if (this.y == null)
        this.y = DefaultConfigurationFactory.createImageDownloader(this.e);
      if (this.z == null)
        this.z = DefaultConfigurationFactory.createImageDecoder(this.B);
      if (this.A == null)
        this.A = DisplayImageOptions.createSimple();
      return;
      this.m = true;
      break;
      label198: this.n = true;
    }
  }

  public ImageLoaderConfiguration build()
  {
    if (this.k == null)
    {
      this.k = DefaultConfigurationFactory.createExecutor(this.o, this.p, this.r);
      if (this.l != null)
        break label207;
      this.l = DefaultConfigurationFactory.createExecutor(this.o, this.p, this.r);
    }
    while (true)
    {
      if (this.w == null)
      {
        if (this.x == null)
          this.x = DefaultConfigurationFactory.createFileNameGenerator();
        this.w = DefaultConfigurationFactory.createDiskCache(this.e, this.x, this.t, this.u);
      }
      if (this.v == null)
        this.v = DefaultConfigurationFactory.createMemoryCache(this.s);
      if (this.q)
        this.v = new FuzzyKeyMemoryCache(this.v, MemoryCacheUtils.createFuzzyKeyComparator());
      if (this.y == null)
        this.y = DefaultConfigurationFactory.createImageDownloader(this.e);
      if (this.z == null)
        this.z = DefaultConfigurationFactory.createImageDecoder(this.B);
      if (this.A == null)
        this.A = DisplayImageOptions.createSimple();
      return new ImageLoaderConfiguration(this, (byte)0);
      this.m = true;
      break;
      label207: this.n = true;
    }
  }

  public Builder defaultDisplayImageOptions(DisplayImageOptions paramDisplayImageOptions)
  {
    this.A = paramDisplayImageOptions;
    return this;
  }

  public Builder denyCacheImageMultipleSizesInMemory()
  {
    this.q = true;
    return this;
  }

  public Builder discCache(DiskCache paramDiskCache)
  {
    return diskCache(paramDiskCache);
  }

  public Builder discCacheExtraOptions(int paramInt1, int paramInt2, BitmapProcessor paramBitmapProcessor)
  {
    return diskCacheExtraOptions(paramInt1, paramInt2, paramBitmapProcessor);
  }

  public Builder discCacheFileCount(int paramInt)
  {
    return diskCacheFileCount(paramInt);
  }

  public Builder discCacheFileNameGenerator(FileNameGenerator paramFileNameGenerator)
  {
    return diskCacheFileNameGenerator(paramFileNameGenerator);
  }

  public Builder discCacheSize(int paramInt)
  {
    return diskCacheSize(paramInt);
  }

  public Builder diskCache(DiskCache paramDiskCache)
  {
    if ((this.t > 0L) || (this.u > 0))
      L.w("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
    if (this.x != null)
      L.w("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
    this.w = paramDiskCache;
    return this;
  }

  public Builder diskCacheExtraOptions(int paramInt1, int paramInt2, BitmapProcessor paramBitmapProcessor)
  {
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = paramBitmapProcessor;
    return this;
  }

  public Builder diskCacheFileCount(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("maxFileCount must be a positive number");
    if (this.w != null)
      L.w("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
    this.u = paramInt;
    return this;
  }

  public Builder diskCacheFileNameGenerator(FileNameGenerator paramFileNameGenerator)
  {
    if (this.w != null)
      L.w("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
    this.x = paramFileNameGenerator;
    return this;
  }

  public Builder diskCacheSize(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("maxCacheSize must be a positive number");
    if (this.w != null)
      L.w("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
    this.t = paramInt;
    return this;
  }

  public Builder imageDecoder(ImageDecoder paramImageDecoder)
  {
    this.z = paramImageDecoder;
    return this;
  }

  public Builder imageDownloader(ImageDownloader paramImageDownloader)
  {
    this.y = paramImageDownloader;
    return this;
  }

  public Builder memoryCache(MemoryCache paramMemoryCache)
  {
    if (this.s != 0)
      L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
    this.v = paramMemoryCache;
    return this;
  }

  public Builder memoryCacheExtraOptions(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    return this;
  }

  public Builder memoryCacheSize(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException("memoryCacheSize must be a positive number");
    if (this.v != null)
      L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
    this.s = paramInt;
    return this;
  }

  public Builder memoryCacheSizePercentage(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt >= 100))
      throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
    if (this.v != null)
      L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
    this.s = ((int)((float)Runtime.getRuntime().maxMemory() * (paramInt / 100.0F)));
    return this;
  }

  public Builder taskExecutor(Executor paramExecutor)
  {
    if ((this.o != 3) || (this.p != 4) || (this.r != DEFAULT_TASK_PROCESSING_TYPE))
      L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
    this.k = paramExecutor;
    return this;
  }

  public Builder taskExecutorForCachedImages(Executor paramExecutor)
  {
    if ((this.o != 3) || (this.p != 4) || (this.r != DEFAULT_TASK_PROCESSING_TYPE))
      L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
    this.l = paramExecutor;
    return this;
  }

  public Builder tasksProcessingOrder(QueueProcessingType paramQueueProcessingType)
  {
    if ((this.k != null) || (this.l != null))
      L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
    this.r = paramQueueProcessingType;
    return this;
  }

  public Builder threadPoolSize(int paramInt)
  {
    if ((this.k != null) || (this.l != null))
      L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
    this.o = paramInt;
    return this;
  }

  public Builder threadPriority(int paramInt)
  {
    if ((this.k != null) || (this.l != null))
      L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
    if (paramInt <= 0)
    {
      this.p = 1;
      return this;
    }
    if (paramInt > 10)
    {
      this.p = 10;
      return this;
    }
    this.p = paramInt;
    return this;
  }

  public Builder writeDebugLogs()
  {
    this.B = true;
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder
 * JD-Core Version:    0.6.2
 */