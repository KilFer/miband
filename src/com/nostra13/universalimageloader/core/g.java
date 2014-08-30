package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.InputStream;

final class g
  implements ImageDownloader
{
  private final ImageDownloader a;

  public g(ImageDownloader paramImageDownloader)
  {
    this.a = paramImageDownloader;
  }

  public final InputStream getStream(String paramString, Object paramObject)
  {
    switch (f.a[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.ofUri(paramString).ordinal()])
    {
    default:
      return this.a.getStream(paramString, paramObject);
    case 1:
    case 2:
    }
    throw new IllegalStateException();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.g
 * JD-Core Version:    0.6.2
 */