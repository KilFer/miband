package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

final class f extends ByteArrayOutputStream
{
  f(e parame, int paramInt)
  {
    super(paramInt);
  }

  public final String toString()
  {
    int i;
    if ((this.count > 0) && (this.buf[(-1 + this.count)] == 13))
      i = -1 + this.count;
    try
    {
      while (true)
      {
        String str = new String(this.buf, 0, i, e.a(this.a).name());
        return str;
        i = this.count;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError(localUnsupportedEncodingException);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.ext.f
 * JD-Core Version:    0.6.2
 */