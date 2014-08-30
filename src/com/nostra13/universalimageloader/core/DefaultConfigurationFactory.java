package com.nostra13.universalimageloader.core;

import android.content.Context;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefaultConfigurationFactory
{
  private static File a(Context paramContext)
  {
    Object localObject = StorageUtils.getCacheDirectory(paramContext, false);
    File localFile = new File((File)localObject, "uil-images");
    if ((localFile.exists()) || (localFile.mkdir()))
      localObject = localFile;
    return localObject;
  }

  private static ThreadFactory a(int paramInt, String paramString)
  {
    return new a(paramInt, paramString);
  }

  public static BitmapDisplayer createBitmapDisplayer()
  {
    return new SimpleBitmapDisplayer();
  }

  public static DiskCache createDiskCache(Context paramContext, FileNameGenerator paramFileNameGenerator, long paramLong, int paramInt)
  {
    File localFile1 = StorageUtils.getCacheDirectory(paramContext, false);
    File localFile2 = new File(localFile1, "uil-images");
    if ((localFile2.exists()) || (localFile2.mkdir()));
    for (File localFile3 = localFile2; ; localFile3 = localFile1)
    {
      if ((paramLong > 0L) || (paramInt > 0))
      {
        LruDiscCache localLruDiscCache = new LruDiscCache(StorageUtils.getIndividualCacheDirectory(paramContext), paramFileNameGenerator, paramLong, paramInt);
        localLruDiscCache.setReserveCacheDir(localFile3);
        return localLruDiscCache;
      }
      return new UnlimitedDiscCache(StorageUtils.getCacheDirectory(paramContext), localFile3, paramFileNameGenerator);
    }
  }

  public static Executor createExecutor(int paramInt1, int paramInt2, QueueProcessingType paramQueueProcessingType)
  {
    int i;
    if (paramQueueProcessingType == QueueProcessingType.LIFO)
    {
      i = 1;
      if (i == 0)
        break label56;
    }
    label56: for (Object localObject = new LIFOLinkedBlockingDeque(); ; localObject = new LinkedBlockingQueue())
    {
      BlockingQueue localBlockingQueue = (BlockingQueue)localObject;
      return new ThreadPoolExecutor(paramInt1, paramInt1, 0L, TimeUnit.MILLISECONDS, localBlockingQueue, a(paramInt2, "uil-pool-"));
      i = 0;
      break;
    }
  }

  public static FileNameGenerator createFileNameGenerator()
  {
    return new HashCodeFileNameGenerator();
  }

  public static ImageDecoder createImageDecoder(boolean paramBoolean)
  {
    return new BaseImageDecoder(paramBoolean);
  }

  public static ImageDownloader createImageDownloader(Context paramContext)
  {
    return new BaseImageDownloader(paramContext);
  }

  public static MemoryCache createMemoryCache(int paramInt)
  {
    if (paramInt == 0)
      paramInt = (int)(Runtime.getRuntime().maxMemory() / 8L);
    return new LruMemoryCache(paramInt);
  }

  public static Executor createTaskDistributor()
  {
    return Executors.newCachedThreadPool(a(5, "uil-pool-d-"));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.DefaultConfigurationFactory
 * JD-Core Version:    0.6.2
 */