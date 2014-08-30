package com.loopj.android.http;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

final class z
  implements HttpRequestRetryHandler
{
  private static final HashSet<Class<?>> a = new HashSet();
  private static final HashSet<Class<?>> b = new HashSet();
  private final int c;
  private final int d;

  static
  {
    a.add(NoHttpResponseException.class);
    a.add(UnknownHostException.class);
    a.add(SocketException.class);
    b.add(InterruptedIOException.class);
    b.add(SSLException.class);
  }

  public z(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }

  static void a(Class<?> paramClass)
  {
    a.add(paramClass);
  }

  private static boolean a(HashSet<Class<?>> paramHashSet, Throwable paramThrowable)
  {
    Iterator localIterator = paramHashSet.iterator();
    do
      if (!localIterator.hasNext())
        return false;
    while (!((Class)localIterator.next()).isInstance(paramThrowable));
    return true;
  }

  static void b(Class<?> paramClass)
  {
    b.add(paramClass);
  }

  public final boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    boolean bool1 = true;
    Boolean localBoolean = (Boolean)paramHttpContext.getAttribute("http.request_sent");
    boolean bool2;
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      bool2 = bool1;
      if (paramInt <= this.c)
        break label71;
      bool1 = false;
    }
    while (true)
    {
      if ((!bool1) || ((HttpUriRequest)paramHttpContext.getAttribute("http.request") != null))
        break label105;
      return false;
      bool2 = false;
      break;
      label71: if (!a(a, paramIOException))
        if (a(b, paramIOException))
          bool1 = false;
        else if (bool2);
    }
    label105: if (bool1)
      SystemClock.sleep(this.d);
    while (true)
    {
      return bool1;
      paramIOException.printStackTrace();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.z
 * JD-Core Version:    0.6.2
 */