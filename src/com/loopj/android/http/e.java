package com.loopj.android.http;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

final class e extends HttpEntityWrapper
{
  public e(HttpEntity paramHttpEntity)
  {
    super(paramHttpEntity);
  }

  public final InputStream getContent()
  {
    return new GZIPInputStream(this.wrappedEntity.getContent());
  }

  public final long getContentLength()
  {
    return -1L;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.e
 * JD-Core Version:    0.6.2
 */