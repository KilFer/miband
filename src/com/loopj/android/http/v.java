package com.loopj.android.http;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

final class v
  implements HttpEntity
{
  private static final String a = "JsonStreamerEntity";
  private static final UnsupportedOperationException b = new UnsupportedOperationException("Unsupported operation in this implementation.");
  private static final int c = 4096;
  private static final StringBuilder e = new StringBuilder(128);
  private static final byte[] f = "true".getBytes();
  private static final byte[] g = "false".getBytes();
  private static final byte[] h = "null".getBytes();
  private static final byte[] i = a("name");
  private static final byte[] j = a("type");
  private static final byte[] k = a("contents");
  private static final byte[] l = a("_elapsed");
  private static final Header m = new BasicHeader("Content-Type", "application/json");
  private static final Header n = new BasicHeader("Content-Encoding", "gzip");
  private final byte[] d = new byte[4096];
  private final Map<String, Object> o = new HashMap();
  private final Header p;
  private final ResponseHandlerInterface q;

  public v(ResponseHandlerInterface paramResponseHandlerInterface, boolean paramBoolean)
  {
    this.q = paramResponseHandlerInterface;
    if (paramBoolean);
    for (Header localHeader = n; ; localHeader = null)
    {
      this.p = localHeader;
      return;
    }
  }

  private static void a(OutputStream paramOutputStream)
  {
    paramOutputStream.write(34);
  }

  private void a(OutputStream paramOutputStream, RequestParams.FileWrapper paramFileWrapper)
  {
    a(paramOutputStream, paramFileWrapper.file.getName(), paramFileWrapper.contentType);
    int i1 = (int)paramFileWrapper.file.length();
    FileInputStream localFileInputStream = new FileInputStream(paramFileWrapper.file);
    Base64OutputStream localBase64OutputStream = new Base64OutputStream(paramOutputStream, 18);
    int i2 = 0;
    while (true)
    {
      int i3 = localFileInputStream.read(this.d);
      if (i3 == -1)
      {
        AsyncHttpClient.silentCloseOutputStream(localBase64OutputStream);
        paramOutputStream.write(34);
        AsyncHttpClient.silentCloseInputStream(localFileInputStream);
        return;
      }
      localBase64OutputStream.write(this.d, 0, i3);
      i2 += i3;
      this.q.sendProgressMessage(i2, i1);
    }
  }

  private void a(OutputStream paramOutputStream, RequestParams.StreamWrapper paramStreamWrapper)
  {
    a(paramOutputStream, paramStreamWrapper.name, paramStreamWrapper.contentType);
    Base64OutputStream localBase64OutputStream = new Base64OutputStream(paramOutputStream, 18);
    while (true)
    {
      int i1 = paramStreamWrapper.inputStream.read(this.d);
      if (i1 == -1)
      {
        AsyncHttpClient.silentCloseOutputStream(localBase64OutputStream);
        paramOutputStream.write(34);
        if (paramStreamWrapper.autoClose)
          AsyncHttpClient.silentCloseInputStream(paramStreamWrapper.inputStream);
        return;
      }
      localBase64OutputStream.write(this.d, 0, i1);
    }
  }

  private static void a(OutputStream paramOutputStream, String paramString1, String paramString2)
  {
    paramOutputStream.write(i);
    paramOutputStream.write(58);
    paramOutputStream.write(a(paramString1));
    paramOutputStream.write(44);
    paramOutputStream.write(j);
    paramOutputStream.write(58);
    paramOutputStream.write(a(paramString2));
    paramOutputStream.write(44);
    paramOutputStream.write(k);
    paramOutputStream.write(58);
    paramOutputStream.write(34);
  }

  private static byte[] a(String paramString)
  {
    if (paramString == null)
      return h;
    e.append('"');
    int i1 = paramString.length();
    int i2 = -1;
    while (true)
    {
      int i3 = i2 + 1;
      if (i3 >= i1)
        e.append('"');
      try
      {
        byte[] arrayOfByte = e.toString().getBytes();
        return arrayOfByte;
        int i4 = paramString.charAt(i3);
        String str;
        int i5;
        switch (i4)
        {
        default:
          if (((i4 >= 0) && (i4 <= 31)) || ((i4 >= 127) && (i4 <= 159)) || ((i4 >= 8192) && (i4 <= 8447)))
          {
            str = Integer.toHexString(i4);
            e.append("\\u");
            i5 = 4 - str.length();
          }
          break;
        case 34:
        case 92:
        case 8:
        case 12:
        case 10:
        case 13:
        case 9:
          for (int i6 = 0; ; i6++)
          {
            if (i6 >= i5)
            {
              e.append(str.toUpperCase(Locale.US));
              i2 = i3;
              break;
              e.append("\\\"");
              i2 = i3;
              break;
              e.append("\\\\");
              i2 = i3;
              break;
              e.append("\\b");
              i2 = i3;
              break;
              e.append("\\f");
              i2 = i3;
              break;
              e.append("\\n");
              i2 = i3;
              break;
              e.append("\\r");
              i2 = i3;
              break;
              e.append("\\t");
              i2 = i3;
              break;
            }
            e.append('0');
          }
        }
        e.append(i4);
        i2 = i3;
      }
      finally
      {
        e.setLength(0);
      }
    }
  }

  public final void a(String paramString, Object paramObject)
  {
    this.o.put(paramString, paramObject);
  }

  public final void consumeContent()
  {
  }

  public final InputStream getContent()
  {
    throw b;
  }

  public final Header getContentEncoding()
  {
    return this.p;
  }

  public final long getContentLength()
  {
    return -1L;
  }

  public final Header getContentType()
  {
    return m;
  }

  public final boolean isChunked()
  {
    return false;
  }

  public final boolean isRepeatable()
  {
    return false;
  }

  public final boolean isStreaming()
  {
    return false;
  }

  public final void writeTo(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null)
      throw new IllegalStateException("Output stream cannot be null.");
    long l1 = System.currentTimeMillis();
    if (this.p != null)
      paramOutputStream = new GZIPOutputStream(paramOutputStream, 4096);
    paramOutputStream.write(123);
    Iterator localIterator = this.o.keySet().iterator();
    String str;
    Object localObject;
    do
    {
      if (!localIterator.hasNext())
      {
        paramOutputStream.write(l);
        paramOutputStream.write(58);
        long l2 = System.currentTimeMillis() - l1;
        paramOutputStream.write((l2 + "}").getBytes());
        Log.i("JsonStreamerEntity", "Uploaded JSON in " + Math.floor(l2 / 1000L) + " seconds");
        paramOutputStream.flush();
        AsyncHttpClient.silentCloseOutputStream(paramOutputStream);
        return;
      }
      str = (String)localIterator.next();
      localObject = this.o.get(str);
    }
    while (localObject == null);
    paramOutputStream.write(a(str));
    paramOutputStream.write(58);
    boolean bool = localObject instanceof RequestParams.FileWrapper;
    if ((bool) || ((localObject instanceof RequestParams.StreamWrapper)))
    {
      paramOutputStream.write(123);
      if (bool)
      {
        a(paramOutputStream, (RequestParams.FileWrapper)localObject);
        label251: paramOutputStream.write(125);
      }
    }
    while (true)
    {
      paramOutputStream.write(44);
      break;
      a(paramOutputStream, (RequestParams.StreamWrapper)localObject);
      break label251;
      if ((localObject instanceof Boolean))
      {
        if (((Boolean)localObject).booleanValue());
        for (byte[] arrayOfByte = f; ; arrayOfByte = g)
        {
          paramOutputStream.write(arrayOfByte);
          break;
        }
      }
      if ((localObject instanceof Long))
        paramOutputStream.write(((Number)localObject).longValue().getBytes());
      else if ((localObject instanceof Double))
        paramOutputStream.write(((Number)localObject).doubleValue().getBytes());
      else if ((localObject instanceof Float))
        paramOutputStream.write(((Number)localObject).floatValue().getBytes());
      else if ((localObject instanceof Integer))
        paramOutputStream.write(((Number)localObject).intValue().getBytes());
      else
        paramOutputStream.write(localObject.toString().getBytes());
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.v
 * JD-Core Version:    0.6.2
 */