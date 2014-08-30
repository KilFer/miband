package com.loopj.android.http;

import android.util.Log;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class AsyncHttpRequest
  implements Runnable
{
  private final AbstractHttpClient a;
  private final HttpContext b;
  private final HttpUriRequest c;
  private final ResponseHandlerInterface d;
  private int e;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;

  public AsyncHttpRequest(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    this.a = paramAbstractHttpClient;
    this.b = paramHttpContext;
    this.c = paramHttpUriRequest;
    this.d = paramResponseHandlerInterface;
  }

  private void a()
  {
    if (isCancelled());
    HttpResponse localHttpResponse;
    do
    {
      return;
      if (this.c.getURI().getScheme() == null)
        throw new MalformedURLException("No valid URI scheme was provided");
      localHttpResponse = this.a.execute(this.c, this.b);
    }
    while ((isCancelled()) || (this.d == null));
    this.d.sendResponseMessage(localHttpResponse);
  }

  private void b()
  {
    Object localObject1 = null;
    HttpRequestRetryHandler localHttpRequestRetryHandler = this.a.getHttpRequestRetryHandler();
    boolean bool1 = true;
    if (!bool1)
      label16: throw ((Throwable)localObject1);
    while (true)
    {
      IOException localIOException3;
      boolean bool3;
      try
      {
        if (!isCancelled())
          if (this.c.getURI().getScheme() == null)
            throw new MalformedURLException("No valid URI scheme was provided");
      }
      catch (UnknownHostException localUnknownHostException)
      {
        localIOException3 = new IOException("UnknownHostException exception: " + localUnknownHostException.getMessage());
        if (this.e > 0)
        {
          int k = 1 + this.e;
          this.e = k;
          if (localHttpRequestRetryHandler.retryRequest(localIOException3, k, this.b))
          {
            bool3 = true;
            break label353;
            if ((!bool1) || (this.d == null))
              break;
            this.d.sendRetryMessage(this.e);
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("AsyncHttpRequest", "Unhandled exception origin cause", localException);
        localObject1 = new IOException("Unhandled exception: " + localException.getMessage());
        break label16;
        HttpResponse localHttpResponse = this.a.execute(this.c, this.b);
        if ((!isCancelled()) && (this.d != null))
          this.d.sendResponseMessage(localHttpResponse);
        return;
        bool3 = false;
      }
      catch (NullPointerException localNullPointerException)
      {
        IOException localIOException2 = new IOException("NPE in HttpClient: " + localNullPointerException.getMessage());
        int j = 1 + this.e;
        this.e = j;
        bool1 = localHttpRequestRetryHandler.retryRequest(localIOException2, j, this.b);
        localObject1 = localIOException2;
        continue;
      }
      catch (IOException localIOException1)
      {
        if (isCancelled())
          continue;
        int i = 1 + this.e;
        this.e = i;
        boolean bool2 = localHttpRequestRetryHandler.retryRequest(localIOException1, i, this.b);
        bool1 = bool2;
        continue;
      }
      label353: bool1 = bool3;
      Object localObject2 = localIOException3;
    }
  }

  private void c()
  {
    try
    {
      if ((!this.h) && (this.f) && (!this.g))
      {
        this.g = true;
        if (this.d != null)
          this.d.sendCancelMessage();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean cancel(boolean paramBoolean)
  {
    this.f = true;
    this.c.abort();
    return isCancelled();
  }

  public boolean isCancelled()
  {
    if (this.f)
      c();
    return this.f;
  }

  public boolean isDone()
  {
    return (isCancelled()) || (this.h);
  }

  public void run()
  {
    if (isCancelled());
    do
    {
      return;
      if (this.d != null)
        this.d.sendStartMessage();
    }
    while (isCancelled());
    boolean bool1;
    label79: IOException localIOException4;
    boolean bool3;
    while (true)
    {
      HttpRequestRetryHandler localHttpRequestRetryHandler;
      Object localObject1;
      try
      {
        localHttpRequestRetryHandler = this.a.getHttpRequestRetryHandler();
        bool1 = true;
        localObject1 = null;
        break label458;
        throw ((Throwable)localObject1);
      }
      catch (IOException localIOException1)
      {
        if (isCancelled())
          break label446;
      }
      if (this.d != null)
      {
        this.d.sendFailureMessage(0, null, null, localIOException1);
        if (isCancelled())
          break label456;
        if (this.d != null)
          this.d.sendFinishMessage();
        this.h = true;
      }
      label446: label456: label458: 
      do
      {
        while (true)
        {
          try
          {
            if (isCancelled())
              break label79;
            if (this.c.getURI().getScheme() == null)
              throw new MalformedURLException("No valid URI scheme was provided");
          }
          catch (UnknownHostException localUnknownHostException)
          {
            localIOException4 = new IOException("UnknownHostException exception: " + localUnknownHostException.getMessage());
            if (this.e <= 0)
              break label477;
            int k = 1 + this.e;
            this.e = k;
            if (!localHttpRequestRetryHandler.retryRequest(localIOException4, k, this.b))
              break label477;
            bool3 = true;
            break label466;
            if ((!bool1) || (this.d == null))
              break label458;
            this.d.sendRetryMessage(this.e);
          }
          catch (Exception localException)
          {
            Log.e("AsyncHttpRequest", "Unhandled exception origin cause", localException);
            localObject1 = new IOException("Unhandled exception: " + localException.getMessage());
            break;
            HttpResponse localHttpResponse = this.a.execute(this.c, this.b);
            if ((isCancelled()) || (this.d == null))
              break label79;
            this.d.sendResponseMessage(localHttpResponse);
            break label79;
          }
          catch (NullPointerException localNullPointerException)
          {
            IOException localIOException3 = new IOException("NPE in HttpClient: " + localNullPointerException.getMessage());
            int j = 1 + this.e;
            this.e = j;
            bool1 = localHttpRequestRetryHandler.retryRequest(localIOException3, j, this.b);
            localObject1 = localIOException3;
            continue;
          }
          catch (IOException localIOException2)
          {
          }
          if (isCancelled())
            break label79;
          int i = 1 + this.e;
          this.e = i;
          boolean bool2 = localHttpRequestRetryHandler.retryRequest(localIOException2, i, this.b);
          bool1 = bool2;
        }
        Log.e("AsyncHttpRequest", "makeRequestWithRetries returned error, but handler is null", localIOException1);
        break label79;
        break;
      }
      while (bool1);
    }
    while (true)
    {
      label466: bool1 = bool3;
      Object localObject2 = localIOException4;
      break;
      label477: bool3 = false;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.AsyncHttpRequest
 * JD-Core Version:    0.6.2
 */