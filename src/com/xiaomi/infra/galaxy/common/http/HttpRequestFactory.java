package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.HttpMethodName;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.util.HttpUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.params.HttpParams;

class HttpRequestFactory
{
  private static final String DEFAULT_ENCODING = "UTF-8";
  public static final Log log = LogFactory.getLog(HttpRequestFactory.class);

  private void configureHeaders(HttpRequestBase paramHttpRequestBase, BasicGalaxyRequest paramBasicGalaxyRequest, ExecutionContext paramExecutionContext, ClientConfiguration paramClientConfiguration)
  {
    URI localURI = paramBasicGalaxyRequest.getEndpoint();
    String str = localURI.getHost();
    if (HttpUtils.isUsingNonDefaultPort(localURI))
      str = str + ":" + localURI.getPort();
    paramHttpRequestBase.addHeader("Host", str);
    Iterator localIterator = paramBasicGalaxyRequest.getHeaders().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((!((String)localEntry.getKey()).equalsIgnoreCase("Content-Length")) && (!((String)localEntry.getKey()).equalsIgnoreCase("Host")))
        paramHttpRequestBase.addHeader((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    if ((paramHttpRequestBase.getHeaders("Content-Type") == null) || (paramHttpRequestBase.getHeaders("Content-Type").length == 0))
      paramHttpRequestBase.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + "UTF-8".toLowerCase());
    if ((paramExecutionContext != null) && (paramExecutionContext.getContextUserAgent() != null))
      paramHttpRequestBase.addHeader("User-Agent", createUserAgentString(paramClientConfiguration, paramExecutionContext.getContextUserAgent()));
  }

  private String createUserAgentString(ClientConfiguration paramClientConfiguration, String paramString)
  {
    if (paramClientConfiguration.getUserAgent().contains(paramString))
      return paramClientConfiguration.getUserAgent();
    return paramClientConfiguration.getUserAgent() + " " + paramString;
  }

  private HttpEntity newBufferedHttpEntity(HttpEntity paramHttpEntity)
  {
    try
    {
      BufferedHttpEntity localBufferedHttpEntity = new BufferedHttpEntity(paramHttpEntity);
      return localBufferedHttpEntity;
    }
    catch (IOException localIOException)
    {
      log.error(localIOException);
      throw new GalaxyClientException(ReturnCode.HTTP_ERROR, "Unable to create HTTP entity: " + localIOException.getMessage(), localIOException);
    }
  }

  private HttpEntity newStringEntity(String paramString)
  {
    try
    {
      StringEntity localStringEntity = new StringEntity(paramString);
      return localStringEntity;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      log.error(localUnsupportedEncodingException);
      throw new GalaxyClientException(ReturnCode.HTTP_ERROR, "Unable to create HTTP entity: " + localUnsupportedEncodingException.getMessage(), localUnsupportedEncodingException);
    }
  }

  HttpRequestBase createHttpRequest(BasicGalaxyRequest paramBasicGalaxyRequest, ClientConfiguration paramClientConfiguration, HttpEntity paramHttpEntity, ExecutionContext paramExecutionContext)
  {
    String str1 = paramBasicGalaxyRequest.getEndpoint().toString();
    label91: int i;
    label107: int j;
    label120: HttpPost localHttpPost;
    label217: Object localObject1;
    if ((paramBasicGalaxyRequest.getResourcePath() != null) && (paramBasicGalaxyRequest.getResourcePath().length() > 0))
      if (paramBasicGalaxyRequest.getResourcePath().startsWith("/"))
      {
        if (str1.endsWith("/"))
          str1 = str1.substring(0, -1 + str1.length());
        str1 = str1 + HttpUtils.urlEncode(paramBasicGalaxyRequest.getResourcePath(), true);
        String str2 = HttpUtils.encodeParameters(paramBasicGalaxyRequest);
        if (paramBasicGalaxyRequest.getContent() == null)
          break label304;
        i = 1;
        if (paramBasicGalaxyRequest.getHttpMethod() != HttpMethodName.POST)
          break label310;
        j = 1;
        int k;
        if (j != 0)
        {
          k = 0;
          if (i == 0);
        }
        else
        {
          k = 1;
        }
        if ((str2 != null) && (k != 0))
          str1 = str1 + "?" + str2;
        if (paramBasicGalaxyRequest.getHttpMethod() != HttpMethodName.POST)
          break label332;
        localHttpPost = new HttpPost(str1);
        if ((paramBasicGalaxyRequest.getContent() != null) || (str2 == null))
          break label316;
        localHttpPost.setEntity(newStringEntity(str2));
        localObject1 = localHttpPost;
      }
    while (true)
    {
      configureHeaders((HttpRequestBase)localObject1, paramBasicGalaxyRequest, paramExecutionContext, paramClientConfiguration);
      return localObject1;
      if (str1.endsWith("/"))
        break;
      str1 = str1 + "/";
      break;
      if (str1.endsWith("/"))
        break label91;
      str1 = str1 + "/";
      break label91;
      label304: i = 0;
      break label107;
      label310: j = 0;
      break label120;
      label316: localHttpPost.setEntity(new RepeatableInputStreamRequestEntity(paramBasicGalaxyRequest));
      break label217;
      label332: if (paramBasicGalaxyRequest.getHttpMethod() == HttpMethodName.PUT)
      {
        HttpPut localHttpPut = new HttpPut(str1);
        localHttpPut.getParams().setParameter("http.protocol.expect-continue", Boolean.valueOf(true));
        if (paramHttpEntity != null)
        {
          localHttpPut.setEntity(paramHttpEntity);
          localObject1 = localHttpPut;
        }
        else
        {
          if (paramBasicGalaxyRequest.getContent() != null)
          {
            Object localObject2 = new RepeatableInputStreamRequestEntity(paramBasicGalaxyRequest);
            if (paramBasicGalaxyRequest.getHeaders().get("Content-Length") == null)
              localObject2 = newBufferedHttpEntity((HttpEntity)localObject2);
            localHttpPut.setEntity((HttpEntity)localObject2);
          }
          localObject1 = localHttpPut;
        }
      }
      else if (paramBasicGalaxyRequest.getHttpMethod() == HttpMethodName.GET)
      {
        localObject1 = new HttpGet(str1);
      }
      else if (paramBasicGalaxyRequest.getHttpMethod() == HttpMethodName.DELETE)
      {
        localObject1 = new HttpDelete(str1);
      }
      else
      {
        if (paramBasicGalaxyRequest.getHttpMethod() != HttpMethodName.HEAD)
          break label513;
        localObject1 = new HttpHead(str1);
      }
    }
    label513: throw new GalaxyClientException(ReturnCode.HTTP_ERROR, "Unknown HTTP method name: " + paramBasicGalaxyRequest.getHttpMethod());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.http.HttpRequestFactory
 * JD-Core Version:    0.6.2
 */