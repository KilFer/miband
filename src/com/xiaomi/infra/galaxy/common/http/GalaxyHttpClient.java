package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.GalaxyServiceException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.model.GalaxyMarshaller;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;

public class GalaxyHttpClient
{
  private static final int MAX_BACKOFF_IN_MILLISECONDS = 20000;
  private static GalaxyBackoffStrategy galaxyBackoffStrategy = GalaxyBackoffStrategy.getInstance();
  private static AbstractHttpClientFactory httpClientFactory;
  private static HttpRequestFactory httpRequestFactory;
  public static final Log log = LogFactory.getLog(GalaxyHttpClient.class);
  private final ClientConfiguration config;
  public AtomicBoolean isShutdown;
  private HttpClient keepAliveHttpClient;

  static
  {
    httpRequestFactory = new HttpRequestFactory();
  }

  public GalaxyHttpClient(ClientConfiguration paramClientConfiguration)
  {
    this.config = paramClientConfiguration;
    if (this.config.isKeepAlive())
    {
      this.keepAliveHttpClient = httpClientFactory.createHttpClient(this.config);
      this.isShutdown = new AtomicBoolean(false);
      return;
    }
    this.isShutdown = new AtomicBoolean(true);
  }

  // ERROR //
  private <T> T executeHelper(BasicGalaxyRequest paramBasicGalaxyRequest, Class<T> paramClass, ExecutionContext paramExecutionContext, HttpClient paramHttpClient)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 81	com/xiaomi/infra/galaxy/common/http/GalaxyHttpClient:setUserAgent	(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)V
    //   5: new 83	java/util/HashMap
    //   8: dup
    //   9: invokespecial 84	java/util/HashMap:<init>	()V
    //   12: astore 5
    //   14: aload 5
    //   16: aload_1
    //   17: invokevirtual 90	com/xiaomi/infra/galaxy/common/BasicGalaxyRequest:getParameters	()Ljava/util/Map;
    //   20: invokeinterface 96 2 0
    //   25: new 83	java/util/HashMap
    //   28: dup
    //   29: invokespecial 84	java/util/HashMap:<init>	()V
    //   32: astore 6
    //   34: aload 6
    //   36: aload_1
    //   37: invokevirtual 99	com/xiaomi/infra/galaxy/common/BasicGalaxyRequest:getHeaders	()Ljava/util/Map;
    //   40: invokeinterface 96 2 0
    //   45: aconst_null
    //   46: astore 7
    //   48: iconst_0
    //   49: istore 8
    //   51: iload 8
    //   53: ifle +15 -> 68
    //   56: aload_1
    //   57: aload 5
    //   59: invokevirtual 102	com/xiaomi/infra/galaxy/common/BasicGalaxyRequest:setParameters	(Ljava/util/Map;)V
    //   62: aload_1
    //   63: aload 6
    //   65: invokevirtual 105	com/xiaomi/infra/galaxy/common/BasicGalaxyRequest:setHeaders	(Ljava/util/Map;)V
    //   68: aload_3
    //   69: invokevirtual 111	com/xiaomi/infra/galaxy/common/http/ExecutionContext:getSigner	()Lcom/xiaomi/infra/galaxy/common/auth/Signer;
    //   72: ifnull +24 -> 96
    //   75: aload_3
    //   76: invokevirtual 115	com/xiaomi/infra/galaxy/common/http/ExecutionContext:getCredentials	()Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;
    //   79: ifnull +17 -> 96
    //   82: aload_3
    //   83: invokevirtual 111	com/xiaomi/infra/galaxy/common/http/ExecutionContext:getSigner	()Lcom/xiaomi/infra/galaxy/common/auth/Signer;
    //   86: aload_1
    //   87: aload_3
    //   88: invokevirtual 115	com/xiaomi/infra/galaxy/common/http/ExecutionContext:getCredentials	()Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;
    //   91: invokeinterface 121 3 0
    //   96: getstatic 38	com/xiaomi/infra/galaxy/common/http/GalaxyHttpClient:httpRequestFactory	Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;
    //   99: aload_1
    //   100: aload_0
    //   101: getfield 50	com/xiaomi/infra/galaxy/common/http/GalaxyHttpClient:config	Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    //   104: aload 7
    //   106: aload_3
    //   107: invokevirtual 125	com/xiaomi/infra/galaxy/common/http/HttpRequestFactory:createHttpRequest	(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Lorg/apache/http/HttpEntity;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;)Lorg/apache/http/client/methods/HttpRequestBase;
    //   110: astore 12
    //   112: aload 12
    //   114: astore 10
    //   116: aload 10
    //   118: instanceof 127
    //   121: ifeq +278 -> 399
    //   124: aload 10
    //   126: checkcast 127	org/apache/http/HttpEntityEnclosingRequest
    //   129: invokeinterface 131 1 0
    //   134: astore 17
    //   136: aload 17
    //   138: astore 13
    //   140: iload 8
    //   142: ifle +10 -> 152
    //   145: aload_0
    //   146: iload 8
    //   148: aconst_null
    //   149: invokespecial 135	com/xiaomi/infra/galaxy/common/http/GalaxyHttpClient:pauseExponentially	(ILcom/xiaomi/infra/galaxy/common/GalaxyServiceException;)V
    //   152: aload 13
    //   154: ifnull +36 -> 190
    //   157: aload 13
    //   159: invokeinterface 141 1 0
    //   164: astore 14
    //   166: iload 8
    //   168: ifle +54 -> 222
    //   171: aload 14
    //   173: invokevirtual 146	java/io/InputStream:markSupported	()Z
    //   176: ifeq +14 -> 190
    //   179: aload 14
    //   181: invokevirtual 149	java/io/InputStream:reset	()V
    //   184: aload 14
    //   186: iconst_m1
    //   187: invokevirtual 153	java/io/InputStream:mark	(I)V
    //   190: aload 4
    //   192: aload 10
    //   194: invokeinterface 159 2 0
    //   199: astore 15
    //   201: aload_0
    //   202: aload 15
    //   204: invokespecial 163	com/xiaomi/infra/galaxy/common/http/GalaxyHttpClient:isRequestSuccessful	(Lorg/apache/http/HttpResponse;)Z
    //   207: ifeq +119 -> 326
    //   210: aload_0
    //   211: aload_1
    //   212: aload_2
    //   213: aload 10
    //   215: aload 15
    //   217: aload_3
    //   218: invokespecial 167	com/xiaomi/infra/galaxy/common/http/GalaxyHttpClient:handleResponse	(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;Lorg/apache/http/client/methods/HttpRequestBase;Lorg/apache/http/HttpResponse;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;)Ljava/lang/Object;
    //   221: areturn
    //   222: aload 14
    //   224: invokevirtual 146	java/io/InputStream:markSupported	()Z
    //   227: ifeq -37 -> 190
    //   230: aload 14
    //   232: iconst_m1
    //   233: invokevirtual 153	java/io/InputStream:mark	(I)V
    //   236: goto -46 -> 190
    //   239: astore 9
    //   241: aload 13
    //   243: astore 7
    //   245: getstatic 31	com/xiaomi/infra/galaxy/common/http/GalaxyHttpClient:log	Lorg/apache/commons/logging/Log;
    //   248: new 169	java/lang/StringBuilder
    //   251: dup
    //   252: ldc 171
    //   254: invokespecial 174	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   257: aload 9
    //   259: invokevirtual 178	java/io/IOException:getMessage	()Ljava/lang/String;
    //   262: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: aload 9
    //   270: invokeinterface 191 3 0
    //   275: aload_0
    //   276: aload 10
    //   278: aload 9
    //   280: iload 8
    //   282: invokespecial 195	com/xiaomi/infra/galaxy/common/http/GalaxyHttpClient:shouldRetry	(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/Exception;I)Z
    //   285: ifne +88 -> 373
    //   288: new 197	com/xiaomi/infra/galaxy/common/GalaxyClientException
    //   291: dup
    //   292: getstatic 203	com/xiaomi/infra/galaxy/common/constants/ReturnCode:HTTP_ERROR	Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;
    //   295: new 169	java/lang/StringBuilder
    //   298: dup
    //   299: ldc 171
    //   301: invokespecial 174	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   304: aload 9
    //   306: invokevirtual 178	java/io/IOException:getMessage	()Ljava/lang/String;
    //   309: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: aload 9
    //   317: invokespecial 206	com/xiaomi/infra/galaxy/common/GalaxyClientException:<init>	(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   320: athrow
    //   321: astore 11
    //   323: aload 11
    //   325: athrow
    //   326: aload_0
    //   327: aload 10
    //   329: aconst_null
    //   330: iload 8
    //   332: invokespecial 195	com/xiaomi/infra/galaxy/common/http/GalaxyHttpClient:shouldRetry	(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/Exception;I)Z
    //   335: ifne +15 -> 350
    //   338: aload_0
    //   339: aload_1
    //   340: aload_2
    //   341: aload 10
    //   343: aload 15
    //   345: aload_3
    //   346: invokespecial 167	com/xiaomi/infra/galaxy/common/http/GalaxyHttpClient:handleResponse	(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;Lorg/apache/http/client/methods/HttpRequestBase;Lorg/apache/http/HttpResponse;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;)Ljava/lang/Object;
    //   349: areturn
    //   350: aload_0
    //   351: aload_1
    //   352: aconst_null
    //   353: invokespecial 210	com/xiaomi/infra/galaxy/common/http/GalaxyHttpClient:resetRequestAfterError	(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Exception;)V
    //   356: iload 8
    //   358: iconst_1
    //   359: iadd
    //   360: istore 16
    //   362: aload 13
    //   364: astore 7
    //   366: iload 16
    //   368: istore 8
    //   370: goto -319 -> 51
    //   373: aload_0
    //   374: aload_1
    //   375: aload 9
    //   377: invokespecial 210	com/xiaomi/infra/galaxy/common/http/GalaxyHttpClient:resetRequestAfterError	(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Exception;)V
    //   380: iinc 8 1
    //   383: goto -332 -> 51
    //   386: astore 9
    //   388: aconst_null
    //   389: astore 10
    //   391: goto -146 -> 245
    //   394: astore 9
    //   396: goto -151 -> 245
    //   399: aload 7
    //   401: astore 13
    //   403: goto -263 -> 140
    //
    // Exception table:
    //   from	to	target	type
    //   145	152	239	java/io/IOException
    //   157	166	239	java/io/IOException
    //   171	190	239	java/io/IOException
    //   190	222	239	java/io/IOException
    //   222	236	239	java/io/IOException
    //   326	350	239	java/io/IOException
    //   350	356	239	java/io/IOException
    //   68	96	321	finally
    //   96	112	321	finally
    //   116	136	321	finally
    //   145	152	321	finally
    //   157	166	321	finally
    //   171	190	321	finally
    //   190	222	321	finally
    //   222	236	321	finally
    //   245	321	321	finally
    //   326	350	321	finally
    //   350	356	321	finally
    //   373	380	321	finally
    //   68	96	386	java/io/IOException
    //   96	112	386	java/io/IOException
    //   116	136	394	java/io/IOException
  }

  private <T> T handleResponse(BasicGalaxyRequest paramBasicGalaxyRequest, Class<T> paramClass, HttpRequestBase paramHttpRequestBase, HttpResponse paramHttpResponse, ExecutionContext paramExecutionContext)
  {
    GalaxyMarshaller localGalaxyMarshaller = paramExecutionContext.getMarshaller();
    InputStream localInputStream = paramHttpResponse.getEntity().getContent();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    while (true)
    {
      int i = localInputStream.read(arrayOfByte);
      if (i <= 0)
        break;
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    String str = new String(localByteArrayOutputStream.toString("UTF-8"));
    if (paramClass.isAssignableFrom(String.class))
      return str;
    if (StringUtils.isBlank(str))
      return localGalaxyMarshaller.unmarshall(paramClass, localGalaxyMarshaller.marshall(ReturnCode.RESPONSE_IS_BLANK.getResult()));
    return localGalaxyMarshaller.unmarshall(paramClass, str);
  }

  public static boolean isRequestEntityTooLargeException(GalaxyServiceException paramGalaxyServiceException)
  {
    if (paramGalaxyServiceException == null)
      return false;
    return "Request entity too large".equals(paramGalaxyServiceException.getErrorCode());
  }

  private boolean isRequestSuccessful(HttpResponse paramHttpResponse)
  {
    return paramHttpResponse.getStatusLine().getStatusCode() / 100 == 2;
  }

  public static boolean isThrottlingException(GalaxyServiceException paramGalaxyServiceException)
  {
    if (paramGalaxyServiceException == null);
    while ((!"Throttling".equals(paramGalaxyServiceException.getErrorCode())) && (!"ThrottlingException".equals(paramGalaxyServiceException.getErrorCode())) && (!"ProvisionedThroughputExceededException".equals(paramGalaxyServiceException.getErrorCode())))
      return false;
    return true;
  }

  private void pauseExponentially(int paramInt, GalaxyServiceException paramGalaxyServiceException)
  {
    long l = Math.min(galaxyBackoffStrategy.getBackoffPeriod(paramInt), 20000L);
    if (log.isDebugEnabled())
      log.debug("Retriable error detected, will retry in " + l + "ms, attempt number: " + paramInt);
    try
    {
      Thread.sleep(l);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      log.error("thread interrupted!", localInterruptedException);
      Thread.currentThread().interrupt();
      throw new GalaxyClientException(ReturnCode.HTTP_ERROR, localInterruptedException.getMessage(), localInterruptedException);
    }
  }

  private void resetRequestAfterError(BasicGalaxyRequest paramBasicGalaxyRequest, Exception paramException)
  {
    if (paramBasicGalaxyRequest.getContent() == null)
      return;
    if (!paramBasicGalaxyRequest.getContent().markSupported())
      throw new GalaxyClientException(ReturnCode.HTTP_ERROR, "Encountered an exception and stream is not resettable", paramException);
    try
    {
      paramBasicGalaxyRequest.getContent().reset();
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new GalaxyClientException(ReturnCode.HTTP_ERROR, "Encountered an exception and couldn't reset the stream to retry", paramException);
  }

  public static void setHttpClientFactory(AbstractHttpClientFactory paramAbstractHttpClientFactory)
  {
    httpClientFactory = paramAbstractHttpClientFactory;
  }

  private void setUserAgent(BasicGalaxyRequest paramBasicGalaxyRequest)
  {
    String str = this.config.getUserAgent();
    if (!str.equals(ClientConfiguration.DEFAULT_USER_AGENT))
      str = str + ", " + ClientConfiguration.DEFAULT_USER_AGENT;
    if (str != null)
      paramBasicGalaxyRequest.addHeader("User-Agent", str);
  }

  private boolean shouldRetry(HttpRequestBase paramHttpRequestBase, Exception paramException, int paramInt)
  {
    if (paramInt >= this.config.getMaxErrorRetry());
    GalaxyServiceException localGalaxyServiceException;
    do
    {
      do
      {
        do
        {
          return false;
          if (!(paramHttpRequestBase instanceof HttpEntityEnclosingRequest))
            break;
          HttpEntity localHttpEntity = ((HttpEntityEnclosingRequest)paramHttpRequestBase).getEntity();
          if ((localHttpEntity == null) || (localHttpEntity.isRepeatable()))
            break;
        }
        while (!log.isDebugEnabled());
        log.debug("Entity not repeatable");
        return false;
        if ((paramException instanceof IOException))
        {
          if (log.isDebugEnabled())
            log.debug("Retrying on " + paramException.getClass().getName() + ": " + paramException.getMessage());
          return true;
        }
      }
      while (!(paramException instanceof GalaxyServiceException));
      localGalaxyServiceException = (GalaxyServiceException)paramException;
      if ((localGalaxyServiceException.getStatusCode() == 500) || (localGalaxyServiceException.getStatusCode() == 503))
        return true;
      if (isThrottlingException(localGalaxyServiceException))
        return true;
    }
    while (!isClockSkewError(localGalaxyServiceException));
    return true;
  }

  private void shutdown(HttpClient paramHttpClient)
  {
    if (paramHttpClient != null)
      paramHttpClient.getConnectionManager().shutdown();
  }

  public <T> T execute(BasicGalaxyRequest paramBasicGalaxyRequest, Class<T> paramClass, ExecutionContext paramExecutionContext)
  {
    if (paramExecutionContext == null)
      throw new GalaxyClientException(ReturnCode.PARAMETER_IS_INVALID, "Internal SDK Error: No execution context parameter specified.");
    HttpClient localHttpClient;
    if (this.config.isKeepAlive())
    {
      if (this.isShutdown.compareAndSet(true, false))
        this.keepAliveHttpClient = httpClientFactory.createHttpClient(this.config);
      localHttpClient = this.keepAliveHttpClient;
    }
    try
    {
      while (true)
      {
        Object localObject2 = executeHelper(paramBasicGalaxyRequest, paramClass, paramExecutionContext, localHttpClient);
        return localObject2;
        localHttpClient = httpClientFactory.createHttpClient(this.config);
      }
    }
    catch (GalaxyClientException localGalaxyClientException)
    {
      throw localGalaxyClientException;
    }
    finally
    {
      if (!this.config.isKeepAlive())
        shutdown(localHttpClient);
    }
  }

  public HttpClient getKeepAliveHttpClient()
  {
    return this.keepAliveHttpClient;
  }

  public boolean isClockSkewError(GalaxyServiceException paramGalaxyServiceException)
  {
    if (paramGalaxyServiceException == null);
    while ((!"RequestTimeTooSkewed".equals(paramGalaxyServiceException.getErrorCode())) && (!"RequestExpired".equals(paramGalaxyServiceException.getErrorCode())) && (!"InvalidSignatureException".equals(paramGalaxyServiceException.getErrorCode())) && (!"SignatureDoesNotMatch".equals(paramGalaxyServiceException.getErrorCode())))
      return false;
    return true;
  }

  public void shutdown()
  {
    if (!this.isShutdown.compareAndSet(false, true))
      shutdown(this.keepAliveHttpClient);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.http.GalaxyHttpClient
 * JD-Core Version:    0.6.2
 */