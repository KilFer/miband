package com.loopj.android.http;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class AsyncHttpClient
{
  public static final int DEFAULT_MAX_CONNECTIONS = 10;
  public static final int DEFAULT_MAX_RETRIES = 5;
  public static final int DEFAULT_RETRY_SLEEP_TIME_MILLIS = 1500;
  public static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
  public static final int DEFAULT_SOCKET_TIMEOUT = 10000;
  public static final String ENCODING_GZIP = "gzip";
  public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
  public static final String LOG_TAG = "AsyncHttpClient";
  private int a = 10;
  private int b = 10000;
  private final DefaultHttpClient c;
  private final HttpContext d;
  private ExecutorService e;
  private final Map<Context, List<RequestHandle>> f;
  private final Map<String, String> g;
  private boolean h = true;

  public AsyncHttpClient()
  {
    this(false, 80, 443);
  }

  public AsyncHttpClient(int paramInt)
  {
    this(false, paramInt, 443);
  }

  public AsyncHttpClient(int paramInt1, int paramInt2)
  {
    this(false, paramInt1, paramInt2);
  }

  public AsyncHttpClient(SchemeRegistry paramSchemeRegistry)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    ConnManagerParams.setTimeout(localBasicHttpParams, this.b);
    ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(this.a));
    ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 10);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, this.b);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, this.b);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    ThreadSafeClientConnManager localThreadSafeClientConnManager = new ThreadSafeClientConnManager(localBasicHttpParams, paramSchemeRegistry);
    this.e = getDefaultThreadPool();
    this.f = new WeakHashMap();
    this.g = new HashMap();
    this.d = new SyncBasicHttpContext(new BasicHttpContext());
    this.c = new DefaultHttpClient(localThreadSafeClientConnManager, localBasicHttpParams);
    this.c.addRequestInterceptor(new a(this));
    this.c.addResponseInterceptor(new b(this));
    this.c.addRequestInterceptor(new c(this), 0);
    this.c.setHttpRequestRetryHandler(new z(5, 1500));
  }

  public AsyncHttpClient(boolean paramBoolean, int paramInt1, int paramInt2)
  {
  }

  private static HttpEntity a(RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    Object localObject = null;
    if (paramRequestParams != null);
    try
    {
      HttpEntity localHttpEntity = paramRequestParams.getEntity(paramResponseHandlerInterface);
      localObject = localHttpEntity;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      if (paramResponseHandlerInterface != null)
      {
        paramResponseHandlerInterface.sendFailureMessage(0, null, null, localThrowable);
        return null;
      }
      localThrowable.printStackTrace();
    }
    return null;
  }

  private static HttpEntityEnclosingRequestBase a(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, HttpEntity paramHttpEntity)
  {
    if (paramHttpEntity != null)
      paramHttpEntityEnclosingRequestBase.setEntity(paramHttpEntity);
    return paramHttpEntityEnclosingRequestBase;
  }

  private static SchemeRegistry a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
      Log.d("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
    if (paramInt1 <= 0)
    {
      paramInt1 = 80;
      Log.d("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
    }
    if (paramInt2 <= 0)
    {
      paramInt2 = 443;
      Log.d("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
    }
    if (paramBoolean);
    for (SSLSocketFactory localSSLSocketFactory = MySSLSocketFactory.getFixedSocketFactory(); ; localSSLSocketFactory = SSLSocketFactory.getSocketFactory())
    {
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), paramInt1));
      localSchemeRegistry.register(new Scheme("https", localSSLSocketFactory, paramInt2));
      return localSchemeRegistry;
    }
  }

  public static void allowRetryExceptionClass(Class<?> paramClass)
  {
    if (paramClass != null)
      z.a(paramClass);
  }

  public static void blockRetryExceptionClass(Class<?> paramClass)
  {
    if (paramClass != null)
      z.b(paramClass);
  }

  public static String getUrlWithQueryString(boolean paramBoolean, String paramString, RequestParams paramRequestParams)
  {
    if (paramBoolean);
    for (String str1 = paramString.replace(" ", "%20"); ; str1 = paramString)
    {
      String str2;
      StringBuilder localStringBuilder;
      if (paramRequestParams != null)
      {
        str2 = paramRequestParams.getParamString().trim();
        if ((!str2.equals("")) && (!str2.equals("?")))
        {
          localStringBuilder = new StringBuilder(String.valueOf(str1));
          if (!str1.contains("?"))
            break label108;
        }
      }
      label108: for (String str3 = "&"; ; str3 = "?")
      {
        str1 = localStringBuilder.append(str3).toString() + str2;
        return str1;
      }
    }
  }

  public static void silentCloseInputStream(InputStream paramInputStream)
  {
    if (paramInputStream != null);
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      Log.w("AsyncHttpClient", "Cannot close input stream", localIOException);
    }
  }

  public static void silentCloseOutputStream(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null);
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      Log.w("AsyncHttpClient", "Cannot close output stream", localIOException);
    }
  }

  public void addHeader(String paramString1, String paramString2)
  {
    this.g.put(paramString1, paramString2);
  }

  public void cancelAllRequests(boolean paramBoolean)
  {
    Iterator localIterator1 = this.f.values().iterator();
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        this.f.clear();
        return;
      }
      List localList = (List)localIterator1.next();
      if (localList != null)
      {
        Iterator localIterator2 = localList.iterator();
        while (localIterator2.hasNext())
          ((RequestHandle)localIterator2.next()).cancel(paramBoolean);
      }
    }
  }

  public void cancelRequests(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null)
    {
      Log.e("AsyncHttpClient", "Passed null Context to cancelRequests");
      return;
    }
    d locald = new d(this, paramContext, paramBoolean);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      new Thread(locald).start();
      return;
    }
    locald.run();
  }

  public void clearBasicAuth()
  {
    this.c.getCredentialsProvider().clear();
  }

  public RequestHandle delete(Context paramContext, String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    HttpDelete localHttpDelete = new HttpDelete(URI.create(paramString).normalize());
    return sendRequest(this.c, this.d, localHttpDelete, null, paramResponseHandlerInterface, paramContext);
  }

  public RequestHandle delete(Context paramContext, String paramString, Header[] paramArrayOfHeader, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    HttpDelete localHttpDelete = new HttpDelete(getUrlWithQueryString(this.h, paramString, paramRequestParams));
    if (paramArrayOfHeader != null)
      localHttpDelete.setHeaders(paramArrayOfHeader);
    return sendRequest(this.c, this.d, localHttpDelete, null, paramResponseHandlerInterface, paramContext);
  }

  public RequestHandle delete(Context paramContext, String paramString, Header[] paramArrayOfHeader, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    HttpDelete localHttpDelete = new HttpDelete(URI.create(paramString).normalize());
    if (paramArrayOfHeader != null)
      localHttpDelete.setHeaders(paramArrayOfHeader);
    return sendRequest(this.c, this.d, localHttpDelete, null, paramResponseHandlerInterface, paramContext);
  }

  public RequestHandle delete(String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return delete(null, paramString, paramResponseHandlerInterface);
  }

  public RequestHandle get(Context paramContext, String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return sendRequest(this.c, this.d, new HttpGet(getUrlWithQueryString(this.h, paramString, paramRequestParams)), null, paramResponseHandlerInterface, paramContext);
  }

  public RequestHandle get(Context paramContext, String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return get(paramContext, paramString, null, paramResponseHandlerInterface);
  }

  public RequestHandle get(Context paramContext, String paramString, Header[] paramArrayOfHeader, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    HttpGet localHttpGet = new HttpGet(getUrlWithQueryString(this.h, paramString, paramRequestParams));
    if (paramArrayOfHeader != null)
      localHttpGet.setHeaders(paramArrayOfHeader);
    return sendRequest(this.c, this.d, localHttpGet, null, paramResponseHandlerInterface, paramContext);
  }

  public RequestHandle get(String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return get(null, paramString, paramRequestParams, paramResponseHandlerInterface);
  }

  public RequestHandle get(String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return get(null, paramString, null, paramResponseHandlerInterface);
  }

  protected ExecutorService getDefaultThreadPool()
  {
    return Executors.newCachedThreadPool();
  }

  public HttpClient getHttpClient()
  {
    return this.c;
  }

  public HttpContext getHttpContext()
  {
    return this.d;
  }

  public int getMaxConnections()
  {
    return this.a;
  }

  public ExecutorService getThreadPool()
  {
    return this.e;
  }

  public int getTimeout()
  {
    return this.b;
  }

  public RequestHandle head(Context paramContext, String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return sendRequest(this.c, this.d, new HttpHead(getUrlWithQueryString(this.h, paramString, paramRequestParams)), null, paramResponseHandlerInterface, paramContext);
  }

  public RequestHandle head(Context paramContext, String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return head(paramContext, paramString, null, paramResponseHandlerInterface);
  }

  public RequestHandle head(Context paramContext, String paramString, Header[] paramArrayOfHeader, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    HttpHead localHttpHead = new HttpHead(getUrlWithQueryString(this.h, paramString, paramRequestParams));
    if (paramArrayOfHeader != null)
      localHttpHead.setHeaders(paramArrayOfHeader);
    return sendRequest(this.c, this.d, localHttpHead, null, paramResponseHandlerInterface, paramContext);
  }

  public RequestHandle head(String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return head(null, paramString, paramRequestParams, paramResponseHandlerInterface);
  }

  public RequestHandle head(String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return head(null, paramString, null, paramResponseHandlerInterface);
  }

  public boolean isUrlEncodingEnabled()
  {
    return this.h;
  }

  public RequestHandle post(Context paramContext, String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return post(paramContext, paramString, a(paramRequestParams, paramResponseHandlerInterface), null, paramResponseHandlerInterface);
  }

  public RequestHandle post(Context paramContext, String paramString1, HttpEntity paramHttpEntity, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return sendRequest(this.c, this.d, a(new HttpPost(URI.create(paramString1).normalize()), paramHttpEntity), paramString2, paramResponseHandlerInterface, paramContext);
  }

  public RequestHandle post(Context paramContext, String paramString1, Header[] paramArrayOfHeader, RequestParams paramRequestParams, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    HttpPost localHttpPost = new HttpPost(URI.create(paramString1).normalize());
    if (paramRequestParams != null)
      localHttpPost.setEntity(a(paramRequestParams, paramResponseHandlerInterface));
    if (paramArrayOfHeader != null)
      localHttpPost.setHeaders(paramArrayOfHeader);
    return sendRequest(this.c, this.d, localHttpPost, paramString2, paramResponseHandlerInterface, paramContext);
  }

  public RequestHandle post(Context paramContext, String paramString1, Header[] paramArrayOfHeader, HttpEntity paramHttpEntity, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    HttpEntityEnclosingRequestBase localHttpEntityEnclosingRequestBase = a(new HttpPost(URI.create(paramString1).normalize()), paramHttpEntity);
    if (paramArrayOfHeader != null)
      localHttpEntityEnclosingRequestBase.setHeaders(paramArrayOfHeader);
    return sendRequest(this.c, this.d, localHttpEntityEnclosingRequestBase, paramString2, paramResponseHandlerInterface, paramContext);
  }

  public RequestHandle post(String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return post(null, paramString, paramRequestParams, paramResponseHandlerInterface);
  }

  public RequestHandle post(String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return post(null, paramString, null, paramResponseHandlerInterface);
  }

  public RequestHandle put(Context paramContext, String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return put(paramContext, paramString, a(paramRequestParams, paramResponseHandlerInterface), null, paramResponseHandlerInterface);
  }

  public RequestHandle put(Context paramContext, String paramString1, HttpEntity paramHttpEntity, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return sendRequest(this.c, this.d, a(new HttpPut(URI.create(paramString1).normalize()), paramHttpEntity), paramString2, paramResponseHandlerInterface, paramContext);
  }

  public RequestHandle put(Context paramContext, String paramString1, Header[] paramArrayOfHeader, HttpEntity paramHttpEntity, String paramString2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    HttpEntityEnclosingRequestBase localHttpEntityEnclosingRequestBase = a(new HttpPut(URI.create(paramString1).normalize()), paramHttpEntity);
    if (paramArrayOfHeader != null)
      localHttpEntityEnclosingRequestBase.setHeaders(paramArrayOfHeader);
    return sendRequest(this.c, this.d, localHttpEntityEnclosingRequestBase, paramString2, paramResponseHandlerInterface, paramContext);
  }

  public RequestHandle put(String paramString, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return put(null, paramString, paramRequestParams, paramResponseHandlerInterface);
  }

  public RequestHandle put(String paramString, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    return put(null, paramString, null, paramResponseHandlerInterface);
  }

  public void removeHeader(String paramString)
  {
    this.g.remove(paramString);
  }

  protected RequestHandle sendRequest(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, String paramString, ResponseHandlerInterface paramResponseHandlerInterface, Context paramContext)
  {
    if (paramHttpUriRequest == null)
      throw new IllegalArgumentException("HttpUriRequest must not be null");
    if (paramResponseHandlerInterface == null)
      throw new IllegalArgumentException("ResponseHandler must not be null");
    if (paramResponseHandlerInterface.getUseSynchronousMode())
      throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
    if (paramString != null)
      paramHttpUriRequest.setHeader("Content-Type", paramString);
    paramResponseHandlerInterface.setRequestHeaders(paramHttpUriRequest.getAllHeaders());
    paramResponseHandlerInterface.setRequestURI(paramHttpUriRequest.getURI());
    AsyncHttpRequest localAsyncHttpRequest = new AsyncHttpRequest(paramDefaultHttpClient, paramHttpContext, paramHttpUriRequest, paramResponseHandlerInterface);
    this.e.submit(localAsyncHttpRequest);
    RequestHandle localRequestHandle = new RequestHandle(localAsyncHttpRequest);
    Iterator localIterator;
    if (paramContext != null)
    {
      Object localObject = (List)this.f.get(paramContext);
      if (localObject == null)
      {
        localObject = new LinkedList();
        this.f.put(paramContext, localObject);
      }
      if ((paramResponseHandlerInterface instanceof RangeFileAsyncHttpResponseHandler))
        ((RangeFileAsyncHttpResponseHandler)paramResponseHandlerInterface).updateRequestHeaders(paramHttpUriRequest);
      ((List)localObject).add(localRequestHandle);
      localIterator = ((List)localObject).iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
        return localRequestHandle;
      if (((RequestHandle)localIterator.next()).shouldBeGarbageCollected())
        localIterator.remove();
    }
  }

  public void setAuthenticationPreemptive(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.addRequestInterceptor(new PreemtiveAuthorizationHttpRequestInterceptor(), 0);
      return;
    }
    this.c.removeRequestInterceptorByClass(PreemtiveAuthorizationHttpRequestInterceptor.class);
  }

  public void setBasicAuth(String paramString1, String paramString2)
  {
    setBasicAuth(paramString1, paramString2, false);
  }

  public void setBasicAuth(String paramString1, String paramString2, AuthScope paramAuthScope)
  {
    setBasicAuth(paramString1, paramString2, paramAuthScope, false);
  }

  public void setBasicAuth(String paramString1, String paramString2, AuthScope paramAuthScope, boolean paramBoolean)
  {
    UsernamePasswordCredentials localUsernamePasswordCredentials = new UsernamePasswordCredentials(paramString1, paramString2);
    CredentialsProvider localCredentialsProvider = this.c.getCredentialsProvider();
    if (paramAuthScope == null)
      paramAuthScope = AuthScope.ANY;
    localCredentialsProvider.setCredentials(paramAuthScope, localUsernamePasswordCredentials);
    setAuthenticationPreemptive(paramBoolean);
  }

  public void setBasicAuth(String paramString1, String paramString2, boolean paramBoolean)
  {
    setBasicAuth(paramString1, paramString2, null, paramBoolean);
  }

  public void setCookieStore(CookieStore paramCookieStore)
  {
    this.d.setAttribute("http.cookie-store", paramCookieStore);
  }

  public void setEnableRedirects(boolean paramBoolean)
  {
    setEnableRedirects(paramBoolean, paramBoolean, paramBoolean);
  }

  public void setEnableRedirects(boolean paramBoolean1, boolean paramBoolean2)
  {
    setEnableRedirects(paramBoolean1, paramBoolean2, true);
  }

  public void setEnableRedirects(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    HttpParams localHttpParams = this.c.getParams();
    if (paramBoolean2);
    for (boolean bool = false; ; bool = true)
    {
      localHttpParams.setBooleanParameter("http.protocol.reject-relative-redirect", bool);
      this.c.getParams().setBooleanParameter("http.protocol.allow-circular-redirects", paramBoolean3);
      this.c.setRedirectHandler(new w(paramBoolean1));
      return;
    }
  }

  public void setMaxConnections(int paramInt)
  {
    if (paramInt <= 0)
      paramInt = 10;
    this.a = paramInt;
    ConnManagerParams.setMaxConnectionsPerRoute(this.c.getParams(), new ConnPerRouteBean(this.a));
  }

  public void setMaxRetriesAndTimeout(int paramInt1, int paramInt2)
  {
    this.c.setHttpRequestRetryHandler(new z(paramInt1, paramInt2));
  }

  public void setProxy(String paramString, int paramInt)
  {
    HttpHost localHttpHost = new HttpHost(paramString, paramInt);
    this.c.getParams().setParameter("http.route.default-proxy", localHttpHost);
  }

  public void setProxy(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.c.getCredentialsProvider().setCredentials(new AuthScope(paramString1, paramInt), new UsernamePasswordCredentials(paramString2, paramString3));
    HttpHost localHttpHost = new HttpHost(paramString1, paramInt);
    this.c.getParams().setParameter("http.route.default-proxy", localHttpHost);
  }

  public void setRedirectHandler(RedirectHandler paramRedirectHandler)
  {
    this.c.setRedirectHandler(paramRedirectHandler);
  }

  public void setSSLSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.c.getConnectionManager().getSchemeRegistry().register(new Scheme("https", paramSSLSocketFactory, 443));
  }

  public void setThreadPool(ExecutorService paramExecutorService)
  {
    this.e = paramExecutorService;
  }

  public void setTimeout(int paramInt)
  {
    if (paramInt < 1000)
      paramInt = 10000;
    this.b = paramInt;
    HttpParams localHttpParams = this.c.getParams();
    ConnManagerParams.setTimeout(localHttpParams, this.b);
    HttpConnectionParams.setSoTimeout(localHttpParams, this.b);
    HttpConnectionParams.setConnectionTimeout(localHttpParams, this.b);
  }

  public void setURLEncodingEnabled(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public void setUserAgent(String paramString)
  {
    HttpProtocolParams.setUserAgent(this.c.getParams(), paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.AsyncHttpClient
 * JD-Core Version:    0.6.2
 */