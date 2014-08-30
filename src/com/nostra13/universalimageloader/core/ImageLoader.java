package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.imageaware.NonViewAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.L;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;

public class ImageLoader
{
  public static final String TAG = ImageLoader.class.getSimpleName();
  private static String a = "Initialize ImageLoader with configuration";
  private static String b = "Destroy ImageLoader";
  private static String c = "Load image from memory cache [%s]";
  private static final String d = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
  private static final String e = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
  private static final String f = "ImageLoader must be init with configuration before using";
  private static final String g = "ImageLoader configuration can not be initialized with null";
  private static volatile ImageLoader k;
  private ImageLoaderConfiguration h;
  private c i;
  private final ImageLoadingListener j = new SimpleImageLoadingListener();

  private static Handler a(DisplayImageOptions paramDisplayImageOptions)
  {
    Handler localHandler = paramDisplayImageOptions.getHandler();
    if (paramDisplayImageOptions.a())
      localHandler = null;
    while ((localHandler != null) || (Looper.myLooper() != Looper.getMainLooper()))
      return localHandler;
    return new Handler();
  }

  private void a()
  {
    if (this.h == null)
      throw new IllegalStateException("ImageLoader must be init with configuration before using");
  }

  public static ImageLoader getInstance()
  {
    if (k == null);
    try
    {
      if (k == null)
        k = new ImageLoader();
      return k;
    }
    finally
    {
    }
  }

  public void cancelDisplayTask(ImageView paramImageView)
  {
    this.i.b(new ImageViewAware(paramImageView));
  }

  public void cancelDisplayTask(ImageAware paramImageAware)
  {
    this.i.b(paramImageAware);
  }

  public void clearDiscCache()
  {
    clearDiskCache();
  }

  public void clearDiskCache()
  {
    a();
    this.h.m.clear();
  }

  public void clearMemoryCache()
  {
    a();
    this.h.l.clear();
  }

  public void denyNetworkDownloads(boolean paramBoolean)
  {
    this.i.a(paramBoolean);
  }

  public void destroy()
  {
    if (this.h != null)
      L.d("Destroy ImageLoader", new Object[0]);
    stop();
    this.h.m.close();
    this.i = null;
    this.h = null;
  }

  public void displayImage(String paramString, ImageView paramImageView)
  {
    displayImage(paramString, new ImageViewAware(paramImageView), null, null, null);
  }

  public void displayImage(String paramString, ImageView paramImageView, DisplayImageOptions paramDisplayImageOptions)
  {
    displayImage(paramString, new ImageViewAware(paramImageView), paramDisplayImageOptions, null, null);
  }

  public void displayImage(String paramString, ImageView paramImageView, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    displayImage(paramString, paramImageView, paramDisplayImageOptions, paramImageLoadingListener, null);
  }

  public void displayImage(String paramString, ImageView paramImageView, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener, ImageLoadingProgressListener paramImageLoadingProgressListener)
  {
    displayImage(paramString, new ImageViewAware(paramImageView), paramDisplayImageOptions, paramImageLoadingListener, paramImageLoadingProgressListener);
  }

  public void displayImage(String paramString, ImageView paramImageView, ImageLoadingListener paramImageLoadingListener)
  {
    displayImage(paramString, new ImageViewAware(paramImageView), null, paramImageLoadingListener, null);
  }

  public void displayImage(String paramString, ImageAware paramImageAware)
  {
    displayImage(paramString, paramImageAware, null, null, null);
  }

  public void displayImage(String paramString, ImageAware paramImageAware, DisplayImageOptions paramDisplayImageOptions)
  {
    displayImage(paramString, paramImageAware, paramDisplayImageOptions, null, null);
  }

  public void displayImage(String paramString, ImageAware paramImageAware, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    displayImage(paramString, paramImageAware, paramDisplayImageOptions, paramImageLoadingListener, null);
  }

  public void displayImage(String paramString, ImageAware paramImageAware, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener, ImageLoadingProgressListener paramImageLoadingProgressListener)
  {
    a();
    if (paramImageAware == null)
      throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
    if (paramImageLoadingListener == null);
    for (ImageLoadingListener localImageLoadingListener = this.j; ; localImageLoadingListener = paramImageLoadingListener)
    {
      if (paramDisplayImageOptions == null);
      for (DisplayImageOptions localDisplayImageOptions = this.h.p; ; localDisplayImageOptions = paramDisplayImageOptions)
      {
        if (TextUtils.isEmpty(paramString))
        {
          this.i.b(paramImageAware);
          localImageLoadingListener.onLoadingStarted(paramString, paramImageAware.getWrappedView());
          if (localDisplayImageOptions.shouldShowImageForEmptyUri())
            paramImageAware.setImageDrawable(localDisplayImageOptions.getImageForEmptyUri(this.h.a));
          while (true)
          {
            localImageLoadingListener.onLoadingComplete(paramString, paramImageAware.getWrappedView(), null);
            return;
            paramImageAware.setImageDrawable(null);
          }
        }
        ImageSize localImageSize = ImageSizeUtils.defineTargetSizeForView(paramImageAware, this.h.a());
        String str = MemoryCacheUtils.generateKey(paramString, localImageSize);
        this.i.a(paramImageAware, str);
        localImageLoadingListener.onLoadingStarted(paramString, paramImageAware.getWrappedView());
        Bitmap localBitmap = (Bitmap)this.h.l.get(str);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          L.d("Load image from memory cache [%s]", new Object[] { str });
          if (localDisplayImageOptions.shouldPostProcess())
          {
            k localk2 = new k(paramString, paramImageAware, localImageSize, str, localDisplayImageOptions, localImageLoadingListener, paramImageLoadingProgressListener, this.i.a(paramString));
            q localq = new q(this.i, localBitmap, localk2, a(localDisplayImageOptions));
            if (localDisplayImageOptions.a())
            {
              localq.run();
              return;
            }
            this.i.a(localq);
            return;
          }
          localDisplayImageOptions.getDisplayer().display(localBitmap, paramImageAware, LoadedFrom.MEMORY_CACHE);
          localImageLoadingListener.onLoadingComplete(paramString, paramImageAware.getWrappedView(), localBitmap);
          return;
        }
        if (localDisplayImageOptions.shouldShowImageOnLoading())
          paramImageAware.setImageDrawable(localDisplayImageOptions.getImageOnLoading(this.h.a));
        l locall;
        while (true)
        {
          k localk1 = new k(paramString, paramImageAware, localImageSize, str, localDisplayImageOptions, localImageLoadingListener, paramImageLoadingProgressListener, this.i.a(paramString));
          locall = new l(this.i, localk1, a(localDisplayImageOptions));
          if (!localDisplayImageOptions.a())
            break;
          locall.run();
          return;
          if (localDisplayImageOptions.isResetViewBeforeLoading())
            paramImageAware.setImageDrawable(null);
        }
        this.i.a(locall);
        return;
      }
    }
  }

  public void displayImage(String paramString, ImageAware paramImageAware, ImageLoadingListener paramImageLoadingListener)
  {
    displayImage(paramString, paramImageAware, null, paramImageLoadingListener, null);
  }

  public DiskCache getDiscCache()
  {
    return getDiskCache();
  }

  public DiskCache getDiskCache()
  {
    a();
    return this.h.m;
  }

  public String getLoadingUriForView(ImageView paramImageView)
  {
    return this.i.a(new ImageViewAware(paramImageView));
  }

  public String getLoadingUriForView(ImageAware paramImageAware)
  {
    return this.i.a(paramImageAware);
  }

  public MemoryCache getMemoryCache()
  {
    a();
    return this.h.l;
  }

  public void handleSlowNetwork(boolean paramBoolean)
  {
    this.i.b(paramBoolean);
  }

  public void init(ImageLoaderConfiguration paramImageLoaderConfiguration)
  {
    if (paramImageLoaderConfiguration == null)
      try
      {
        throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
      }
      finally
      {
      }
    if (this.h == null)
    {
      L.d("Initialize ImageLoader with configuration", new Object[0]);
      this.i = new c(paramImageLoaderConfiguration);
      this.h = paramImageLoaderConfiguration;
    }
    while (true)
    {
      return;
      L.w("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
    }
  }

  public boolean isInited()
  {
    return this.h != null;
  }

  public void loadImage(String paramString, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    loadImage(paramString, null, paramDisplayImageOptions, paramImageLoadingListener, null);
  }

  public void loadImage(String paramString, ImageSize paramImageSize, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    loadImage(paramString, paramImageSize, paramDisplayImageOptions, paramImageLoadingListener, null);
  }

  public void loadImage(String paramString, ImageSize paramImageSize, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener, ImageLoadingProgressListener paramImageLoadingProgressListener)
  {
    a();
    if (paramImageSize == null)
      paramImageSize = this.h.a();
    if (paramDisplayImageOptions == null);
    for (DisplayImageOptions localDisplayImageOptions = this.h.p; ; localDisplayImageOptions = paramDisplayImageOptions)
    {
      displayImage(paramString, new NonViewAware(paramString, paramImageSize, ViewScaleType.CROP), localDisplayImageOptions, paramImageLoadingListener, paramImageLoadingProgressListener);
      return;
    }
  }

  public void loadImage(String paramString, ImageSize paramImageSize, ImageLoadingListener paramImageLoadingListener)
  {
    loadImage(paramString, paramImageSize, null, paramImageLoadingListener, null);
  }

  public void loadImage(String paramString, ImageLoadingListener paramImageLoadingListener)
  {
    loadImage(paramString, null, null, paramImageLoadingListener, null);
  }

  public Bitmap loadImageSync(String paramString)
  {
    return loadImageSync(paramString, null, null);
  }

  public Bitmap loadImageSync(String paramString, DisplayImageOptions paramDisplayImageOptions)
  {
    return loadImageSync(paramString, null, paramDisplayImageOptions);
  }

  public Bitmap loadImageSync(String paramString, ImageSize paramImageSize)
  {
    return loadImageSync(paramString, paramImageSize, null);
  }

  public Bitmap loadImageSync(String paramString, ImageSize paramImageSize, DisplayImageOptions paramDisplayImageOptions)
  {
    if (paramDisplayImageOptions == null)
      paramDisplayImageOptions = this.h.p;
    DisplayImageOptions localDisplayImageOptions = new DisplayImageOptions.Builder().cloneFrom(paramDisplayImageOptions).a(true).build();
    e locale = new e((byte)0);
    loadImage(paramString, paramImageSize, localDisplayImageOptions, locale);
    return locale.a();
  }

  public void pause()
  {
    this.i.a();
  }

  public void resume()
  {
    this.i.b();
  }

  public void stop()
  {
    this.i.c();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.ImageLoader
 * JD-Core Version:    0.6.2
 */