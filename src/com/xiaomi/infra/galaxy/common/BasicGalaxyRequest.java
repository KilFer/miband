package com.xiaomi.infra.galaxy.common;

import com.xiaomi.infra.galaxy.common.model.Request;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BasicGalaxyRequest
{
  private InputStream content;
  private URI endpoint;
  private Map<String, String> headers = new HashMap();
  private HttpMethodName httpMethod = HttpMethodName.POST;
  private final Request originalRequest;
  private Map<String, String> parameters = new HashMap();
  private String resourcePath;
  private String serviceName;
  private int timeOffset;

  public BasicGalaxyRequest()
  {
    this(null, "");
  }

  public BasicGalaxyRequest(Request paramRequest, String paramString)
  {
    this.serviceName = paramString;
    this.originalRequest = paramRequest;
  }

  public BasicGalaxyRequest(String paramString)
  {
    this(null, paramString);
  }

  public void addHeader(String paramString1, String paramString2)
  {
    this.headers.put(paramString1, paramString2);
  }

  public void addParameter(String paramString1, String paramString2)
  {
    this.parameters.put(paramString1, paramString2);
  }

  public InputStream getContent()
  {
    return this.content;
  }

  public URI getEndpoint()
  {
    return this.endpoint;
  }

  public Map<String, String> getHeaders()
  {
    return this.headers;
  }

  public HttpMethodName getHttpMethod()
  {
    return this.httpMethod;
  }

  public Request getOriginalRequest()
  {
    return this.originalRequest;
  }

  public Map<String, String> getParameters()
  {
    return this.parameters;
  }

  public String getResourcePath()
  {
    return this.resourcePath;
  }

  public String getServiceName()
  {
    return this.serviceName;
  }

  public int getTimeOffset()
  {
    return this.timeOffset;
  }

  public void setContent(InputStream paramInputStream)
  {
    this.content = paramInputStream;
  }

  public void setEndpoint(URI paramURI)
  {
    this.endpoint = paramURI;
  }

  public void setHeaders(Map<String, String> paramMap)
  {
    this.headers.clear();
    this.headers.putAll(paramMap);
  }

  public void setHttpMethod(HttpMethodName paramHttpMethodName)
  {
    this.httpMethod = paramHttpMethodName;
  }

  public void setParameters(Map<String, String> paramMap)
  {
    this.parameters.clear();
    this.parameters.putAll(paramMap);
  }

  public void setResourcePath(String paramString)
  {
    this.resourcePath = paramString;
  }

  public void setTimeOffset(int paramInt)
  {
    this.timeOffset = paramInt;
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(getHttpMethod().toString() + " ");
    localStringBuilder1.append(getEndpoint().toString() + " ");
    StringBuilder localStringBuilder2 = new StringBuilder("/");
    if (getResourcePath() != null);
    for (String str1 = getResourcePath(); ; str1 = "")
    {
      localStringBuilder1.append(str1 + " ");
      if (getParameters().isEmpty())
        break label237;
      localStringBuilder1.append("Parameters: (");
      Iterator localIterator2 = getParameters().keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str4 = (String)localIterator2.next();
        String str5 = (String)getParameters().get(str4);
        localStringBuilder1.append(str4 + ": " + str5 + ", ");
      }
    }
    localStringBuilder1.append(") ");
    label237: if (!getHeaders().isEmpty())
    {
      localStringBuilder1.append("Headers: (");
      Iterator localIterator1 = getHeaders().keySet().iterator();
      while (localIterator1.hasNext())
      {
        String str2 = (String)localIterator1.next();
        String str3 = (String)getHeaders().get(str2);
        localStringBuilder1.append(str2 + ": " + str3 + ", ");
      }
      localStringBuilder1.append(") ");
    }
    return localStringBuilder1.toString();
  }

  public BasicGalaxyRequest withParameter(String paramString1, String paramString2)
  {
    addParameter(paramString1, paramString2);
    return this;
  }

  public BasicGalaxyRequest withTimeOffset(int paramInt)
  {
    setTimeOffset(paramInt);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.BasicGalaxyRequest
 * JD-Core Version:    0.6.2
 */