package com.loopj.android.http;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

final class A
  implements HttpEntity
{
  private static final String a = "SimpleMultipartEntity";
  private static final String b = "\r\n";
  private static final byte[] c = "\r\n".getBytes();
  private static final byte[] d = "Content-Transfer-Encoding: binary\r\n".getBytes();
  private static final char[] e = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private final String f;
  private final byte[] g;
  private final byte[] h;
  private boolean i;
  private final List<B> j = new ArrayList();
  private final ByteArrayOutputStream k = new ByteArrayOutputStream();
  private final ResponseHandlerInterface l;
  private int m;
  private int n;

  public A(ResponseHandlerInterface paramResponseHandlerInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Random localRandom = new Random();
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= 30)
      {
        this.f = localStringBuilder.toString();
        this.g = ("--" + this.f + "\r\n").getBytes();
        this.h = ("--" + this.f + "--\r\n").getBytes();
        this.l = paramResponseHandlerInterface;
        return;
      }
      localStringBuilder.append(e[localRandom.nextInt(e.length)]);
    }
  }

  private static String a(String paramString)
  {
    if (paramString == null)
      paramString = "application/octet-stream";
    return paramString;
  }

  private void a(int paramInt)
  {
    this.m = (paramInt + this.m);
    this.l.sendProgressMessage(this.m, this.n);
  }

  private void a(String paramString, File paramFile)
  {
    a(paramString, paramFile, null);
  }

  private void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      this.k.write(this.g);
      this.k.write(("Content-Disposition: form-data; name=\"" + paramString1 + "\"\r\n").getBytes());
      this.k.write(b(paramString3));
      this.k.write(c);
      this.k.write(paramString2.getBytes());
      this.k.write(c);
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("SimpleMultipartEntity", "addPart ByteArrayOutputStream exception", localIOException);
    }
  }

  private byte[] b(String paramString)
  {
    return ("Content-Type: " + a(paramString) + "\r\n").getBytes();
  }

  private static byte[] b(String paramString1, String paramString2)
  {
    return ("Content-Disposition: form-data; name=\"" + paramString1 + "\"; filename=\"" + paramString2 + "\"\r\n").getBytes();
  }

  private static byte[] c(String paramString)
  {
    return ("Content-Disposition: form-data; name=\"" + paramString + "\"\r\n").getBytes();
  }

  public final void a(String paramString1, File paramFile, String paramString2)
  {
    this.j.add(new B(this, paramString1, paramFile, a(paramString2)));
  }

  public final void a(String paramString1, String paramString2)
  {
    try
    {
      this.k.write(this.g);
      this.k.write(("Content-Disposition: form-data; name=\"" + paramString1 + "\"\r\n").getBytes());
      this.k.write(b("text/plain; charset=UTF-8"));
      this.k.write(c);
      this.k.write(paramString2.getBytes());
      this.k.write(c);
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("SimpleMultipartEntity", "addPart ByteArrayOutputStream exception", localIOException);
    }
  }

  public final void a(String paramString1, String paramString2, InputStream paramInputStream, String paramString3)
  {
    this.k.write(this.g);
    this.k.write(b(paramString1, paramString2));
    this.k.write(b(paramString3));
    this.k.write(d);
    this.k.write(c);
    byte[] arrayOfByte = new byte[4096];
    while (true)
    {
      int i1 = paramInputStream.read(arrayOfByte);
      if (i1 == -1)
      {
        this.k.write(c);
        this.k.flush();
        AsyncHttpClient.silentCloseOutputStream(this.k);
        return;
      }
      this.k.write(arrayOfByte, 0, i1);
    }
  }

  public final void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public final void consumeContent()
  {
    if (isStreaming())
      throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
  }

  public final InputStream getContent()
  {
    throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
  }

  public final Header getContentEncoding()
  {
    return null;
  }

  public final long getContentLength()
  {
    long l1 = this.k.size();
    Iterator localIterator = this.j.iterator();
    long l3;
    for (long l2 = l1; ; l2 += l3)
    {
      if (!localIterator.hasNext())
        return l2 + this.h.length;
      B localB = (B)localIterator.next();
      l3 = localB.a.length() + c.length + localB.b.length;
      if (l3 < 0L)
        return -1L;
    }
  }

  public final Header getContentType()
  {
    return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.f);
  }

  public final boolean isChunked()
  {
    return false;
  }

  public final boolean isRepeatable()
  {
    return this.i;
  }

  public final boolean isStreaming()
  {
    return false;
  }

  public final void writeTo(OutputStream paramOutputStream)
  {
    this.m = 0;
    this.n = ((int)getContentLength());
    this.k.writeTo(paramOutputStream);
    a(this.k.size());
    Iterator localIterator = this.j.iterator();
    if (!localIterator.hasNext())
    {
      paramOutputStream.write(this.h);
      a(this.h.length);
      return;
    }
    B localB = (B)localIterator.next();
    paramOutputStream.write(localB.b);
    localB.c.a(localB.b.length);
    FileInputStream localFileInputStream = new FileInputStream(localB.a);
    byte[] arrayOfByte = new byte[4096];
    while (true)
    {
      int i1 = localFileInputStream.read(arrayOfByte);
      if (i1 == -1)
      {
        paramOutputStream.write(c);
        localB.c.a(c.length);
        paramOutputStream.flush();
        AsyncHttpClient.silentCloseInputStream(localFileInputStream);
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i1);
      localB.c.a(i1);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.A
 * JD-Core Version:    0.6.2
 */