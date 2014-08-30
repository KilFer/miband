package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.utils.DiskCacheUtils;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;
import java.io.File;
import java.util.List;

public class BraceletImageLoader
{
  private static BraceletImageLoader c = null;
  private static Drawable d;
  private DisplayImageOptions a = null;
  private ImageLoader b = null;

  private BraceletImageLoader(Context paramContext)
  {
    File localFile = new File(((BraceletApp)paramContext).getStoragePath());
    ImageLoaderConfiguration localImageLoaderConfiguration = new ImageLoaderConfiguration.Builder(paramContext).threadPriority(5).denyCacheImageMultipleSizesInMemory().discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).memoryCache(new LruMemoryCache(4194304)).memoryCacheSize(4194304).discCache(new UnlimitedDiscCache(localFile)).discCacheSize(52428800).discCacheFileCount(1000).writeDebugLogs().build();
    this.b = ImageLoader.getInstance();
    this.b.init(localImageLoaderConfiguration);
    this.a = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).build();
  }

  private void a(Context paramContext)
  {
    File localFile = new File(((BraceletApp)paramContext).getStoragePath());
    ImageLoaderConfiguration localImageLoaderConfiguration = new ImageLoaderConfiguration.Builder(paramContext).threadPriority(5).denyCacheImageMultipleSizesInMemory().discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).memoryCache(new LruMemoryCache(4194304)).memoryCacheSize(4194304).discCache(new UnlimitedDiscCache(localFile)).discCacheSize(52428800).discCacheFileCount(1000).writeDebugLogs().build();
    this.b = ImageLoader.getInstance();
    this.b.init(localImageLoaderConfiguration);
    this.a = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).build();
  }

  public static BraceletImageLoader getInstance()
  {
    return c;
  }

  public static void init(Context paramContext)
  {
    c = new BraceletImageLoader(paramContext);
    paramContext.getResources().getDrawable(2130837590);
  }

  public void displayImage(String paramString, ImageView paramImageView)
  {
    this.b.displayImage(paramString, paramImageView, this.a);
  }

  public void displayImage(String paramString, ImageView paramImageView, ImageLoadingListener paramImageLoadingListener)
  {
    this.b.displayImage(paramString, paramImageView, this.a, paramImageLoadingListener);
  }

  public void displayRoundImage(String paramString, ImageView paramImageView)
  {
    DisplayImageOptions localDisplayImageOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).displayer(new BraceletImageLoader.RoundBitmapDisplayer(this)).build();
    this.b.displayImage(paramString, paramImageView, localDisplayImageOptions);
  }

  public File getDiscCache(String paramString)
  {
    return DiskCacheUtils.findInCache(paramString, this.b.getDiscCache());
  }

  public List<Bitmap> getMemoryCache(String paramString)
  {
    return MemoryCacheUtils.findCachedBitmapsForImageUri(paramString, this.b.getMemoryCache());
  }

  public void loadImageAsync(String paramString, ImageSize paramImageSize, ImageLoadingListener paramImageLoadingListener)
  {
    this.b.loadImage(paramString, paramImageSize, paramImageLoadingListener);
  }

  public void loadImageAsync(String paramString, ImageLoadingListener paramImageLoadingListener)
  {
    this.b.loadImage(paramString, paramImageLoadingListener);
  }

  public void loadImageAsyncOnDisc(String paramString, ImageLoadingListener paramImageLoadingListener)
  {
    DisplayImageOptions localDisplayImageOptions = new DisplayImageOptions.Builder().cacheInMemory(false).cacheOnDisc(true).build();
    this.b.loadImage(paramString, localDisplayImageOptions, paramImageLoadingListener);
  }

  public Bitmap loadImageSync(String paramString)
  {
    return this.b.loadImageSync(paramString);
  }

  public Bitmap loadImageSync(String paramString, ImageSize paramImageSize)
  {
    return this.b.loadImageSync(paramString, paramImageSize);
  }

  public void removeImageCache(String paramString)
  {
    MemoryCacheUtils.removeFromCache(paramString, this.b.getMemoryCache());
    DiskCacheUtils.removeFromCache(paramString, this.b.getDiscCache());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BraceletImageLoader
 * JD-Core Version:    0.6.2
 */