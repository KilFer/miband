package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.assist.FlushedInputStream;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.InputStream;

final class h
  implements ImageDownloader
{
  private final ImageDownloader a;

  public h(ImageDownloader paramImageDownloader)
  {
    this.a = paramImageDownloader;
  }

  public final InputStream getStream(String paramString, Object paramObject)
  {
    InputStream localInputStream = this.a.getStream(paramString, paramObject);
    switch (f.a[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.ofUri(paramString).ordinal()])
    {
    default:
      return localInputStream;
    case 1:
    case 2:
    }
    return new FlushedInputStream(localInputStream);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.h
 * JD-Core Version:    0.6.2
 */