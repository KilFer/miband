package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import java.util.concurrent.locks.ReentrantLock;

final class k
{
  final String a;
  final String b;
  final ImageAware c;
  final ImageSize d;
  final DisplayImageOptions e;
  final ImageLoadingListener f;
  final ImageLoadingProgressListener g;
  final ReentrantLock h;

  public k(String paramString1, ImageAware paramImageAware, ImageSize paramImageSize, String paramString2, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener, ImageLoadingProgressListener paramImageLoadingProgressListener, ReentrantLock paramReentrantLock)
  {
    this.a = paramString1;
    this.c = paramImageAware;
    this.d = paramImageSize;
    this.e = paramDisplayImageOptions;
    this.f = paramImageLoadingListener;
    this.g = paramImageLoadingProgressListener;
    this.h = paramReentrantLock;
    this.b = paramString2;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.k
 * JD-Core Version:    0.6.2
 */