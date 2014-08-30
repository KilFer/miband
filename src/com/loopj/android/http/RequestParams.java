package com.loopj.android.http;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class RequestParams
{
  public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
  protected static final String LOG_TAG = "RequestParams";
  protected boolean autoCloseInputStreams;
  protected String contentEncoding = "UTF-8";
  protected final ConcurrentHashMap<String, RequestParams.FileWrapper> fileParams = new ConcurrentHashMap();
  protected boolean isRepeatable;
  protected final ConcurrentHashMap<String, RequestParams.StreamWrapper> streamParams = new ConcurrentHashMap();
  protected final ConcurrentHashMap<String, String> urlParams = new ConcurrentHashMap();
  protected final ConcurrentHashMap<String, Object> urlParamsWithObjects = new ConcurrentHashMap();
  protected boolean useJsonStreamer;

  public RequestParams()
  {
    this(null);
  }

  public RequestParams(String paramString1, String paramString2)
  {
    this(new y(paramString1, paramString2));
  }

  public RequestParams(Map<String, String> paramMap)
  {
    Iterator localIterator;
    if (paramMap != null)
      localIterator = paramMap.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
  }

  public RequestParams(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    if (i % 2 != 0)
      throw new IllegalArgumentException("Supplied arguments must be even");
    for (int j = 0; ; j += 2)
    {
      if (j >= i)
        return;
      put(String.valueOf(paramArrayOfObject[j]), String.valueOf(paramArrayOfObject[(j + 1)]));
    }
  }

  private List<BasicNameValuePair> a(String paramString, Object paramObject)
  {
    LinkedList localLinkedList = new LinkedList();
    Map localMap;
    Iterator localIterator2;
    if ((paramObject instanceof Map))
    {
      localMap = (Map)paramObject;
      ArrayList localArrayList = new ArrayList(localMap.keySet());
      Collections.sort(localArrayList);
      localIterator2 = localArrayList.iterator();
      if (localIterator2.hasNext());
    }
    while (true)
    {
      return localLinkedList;
      Object localObject1 = localIterator2.next();
      if (!(localObject1 instanceof String))
        break;
      Object localObject2 = localMap.get(localObject1);
      if (localObject2 == null)
        break;
      if (paramString == null);
      for (String str = (String)localObject1; ; str = String.format("%s[%s]", new Object[] { paramString, localObject1 }))
      {
        localLinkedList.addAll(a(str, localObject2));
        break;
      }
      if ((paramObject instanceof List))
      {
        List localList = (List)paramObject;
        int k = localList.size();
        for (int m = 0; m < k; m++)
        {
          Object[] arrayOfObject3 = new Object[2];
          arrayOfObject3[0] = paramString;
          arrayOfObject3[1] = Integer.valueOf(m);
          localLinkedList.addAll(a(String.format("%s[%d]", arrayOfObject3), localList.get(m)));
        }
      }
      else if ((paramObject instanceof Object[]))
      {
        Object[] arrayOfObject1 = (Object[])paramObject;
        int i = arrayOfObject1.length;
        for (int j = 0; j < i; j++)
        {
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = paramString;
          arrayOfObject2[1] = Integer.valueOf(j);
          localLinkedList.addAll(a(String.format("%s[%d]", arrayOfObject2), arrayOfObject1[j]));
        }
      }
      else
      {
        if (!(paramObject instanceof Set))
          break label360;
        Iterator localIterator1 = ((Set)paramObject).iterator();
        while (localIterator1.hasNext())
          localLinkedList.addAll(a(paramString, localIterator1.next()));
      }
    }
    label360: localLinkedList.add(new BasicNameValuePair(paramString, paramObject.toString()));
    return localLinkedList;
  }

  private HttpEntity a()
  {
    try
    {
      UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(getParamsList(), this.contentEncoding);
      return localUrlEncodedFormEntity;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Log.e("RequestParams", "createFormEntity failed", localUnsupportedEncodingException);
    }
    return null;
  }

  private HttpEntity a(ResponseHandlerInterface paramResponseHandlerInterface)
  {
    boolean bool;
    v localv;
    Iterator localIterator1;
    label46: Iterator localIterator2;
    label70: Iterator localIterator3;
    label94: Iterator localIterator4;
    if ((this.fileParams.isEmpty()) && (this.streamParams.isEmpty()))
    {
      bool = false;
      localv = new v(paramResponseHandlerInterface, bool);
      localIterator1 = this.urlParams.entrySet().iterator();
      if (localIterator1.hasNext())
        break label135;
      localIterator2 = this.urlParamsWithObjects.entrySet().iterator();
      if (localIterator2.hasNext())
        break label171;
      localIterator3 = this.fileParams.entrySet().iterator();
      if (localIterator3.hasNext())
        break label207;
      localIterator4 = this.streamParams.entrySet().iterator();
    }
    while (true)
    {
      if (!localIterator4.hasNext())
      {
        return localv;
        bool = true;
        break;
        label135: Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
        localv.a((String)localEntry1.getKey(), localEntry1.getValue());
        break label46;
        label171: Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
        localv.a((String)localEntry2.getKey(), localEntry2.getValue());
        break label70;
        label207: Map.Entry localEntry3 = (Map.Entry)localIterator3.next();
        localv.a((String)localEntry3.getKey(), localEntry3.getValue());
        break label94;
      }
      Map.Entry localEntry4 = (Map.Entry)localIterator4.next();
      RequestParams.StreamWrapper localStreamWrapper = (RequestParams.StreamWrapper)localEntry4.getValue();
      if (localStreamWrapper.inputStream != null)
        localv.a((String)localEntry4.getKey(), RequestParams.StreamWrapper.a(localStreamWrapper.inputStream, localStreamWrapper.name, localStreamWrapper.contentType, localStreamWrapper.autoClose));
    }
  }

  private HttpEntity b(ResponseHandlerInterface paramResponseHandlerInterface)
  {
    A localA = new A(paramResponseHandlerInterface);
    localA.a(this.isRepeatable);
    Iterator localIterator1 = this.urlParams.entrySet().iterator();
    Iterator localIterator2;
    label55: Iterator localIterator3;
    label79: Iterator localIterator4;
    if (!localIterator1.hasNext())
    {
      localIterator2 = a(null, this.urlParamsWithObjects).iterator();
      if (localIterator2.hasNext())
        break label153;
      localIterator3 = this.streamParams.entrySet().iterator();
      if (localIterator3.hasNext())
        break label182;
      localIterator4 = this.fileParams.entrySet().iterator();
    }
    while (true)
    {
      if (!localIterator4.hasNext())
      {
        return localA;
        Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
        localA.a((String)localEntry1.getKey(), (String)localEntry1.getValue());
        break;
        label153: BasicNameValuePair localBasicNameValuePair = (BasicNameValuePair)localIterator2.next();
        localA.a(localBasicNameValuePair.getName(), localBasicNameValuePair.getValue());
        break label55;
        label182: Map.Entry localEntry2 = (Map.Entry)localIterator3.next();
        RequestParams.StreamWrapper localStreamWrapper = (RequestParams.StreamWrapper)localEntry2.getValue();
        if (localStreamWrapper.inputStream == null)
          break label79;
        localA.a((String)localEntry2.getKey(), localStreamWrapper.name, localStreamWrapper.inputStream, localStreamWrapper.contentType);
        break label79;
      }
      Map.Entry localEntry3 = (Map.Entry)localIterator4.next();
      RequestParams.FileWrapper localFileWrapper = (RequestParams.FileWrapper)localEntry3.getValue();
      localA.a((String)localEntry3.getKey(), localFileWrapper.file, localFileWrapper.contentType);
    }
  }

  public void add(String paramString1, String paramString2)
  {
    Object localObject;
    if ((paramString1 != null) && (paramString2 != null))
    {
      localObject = this.urlParamsWithObjects.get(paramString1);
      if (localObject == null)
      {
        localObject = new HashSet();
        put(paramString1, localObject);
      }
      if (!(localObject instanceof List))
        break label54;
      ((List)localObject).add(paramString2);
    }
    label54: 
    while (!(localObject instanceof Set))
      return;
    ((Set)localObject).add(paramString2);
  }

  public HttpEntity getEntity(ResponseHandlerInterface paramResponseHandlerInterface)
  {
    if (this.useJsonStreamer)
    {
      boolean bool;
      v localv;
      Iterator localIterator5;
      label56: Iterator localIterator6;
      label80: Iterator localIterator7;
      label104: Iterator localIterator8;
      if ((this.fileParams.isEmpty()) && (this.streamParams.isEmpty()))
      {
        bool = false;
        localv = new v(paramResponseHandlerInterface, bool);
        localIterator5 = this.urlParams.entrySet().iterator();
        if (localIterator5.hasNext())
          break label147;
        localIterator6 = this.urlParamsWithObjects.entrySet().iterator();
        if (localIterator6.hasNext())
          break label184;
        localIterator7 = this.fileParams.entrySet().iterator();
        if (localIterator7.hasNext())
          break label221;
        localIterator8 = this.streamParams.entrySet().iterator();
      }
      while (true)
      {
        if (!localIterator8.hasNext())
        {
          return localv;
          bool = true;
          break;
          label147: Map.Entry localEntry4 = (Map.Entry)localIterator5.next();
          localv.a((String)localEntry4.getKey(), localEntry4.getValue());
          break label56;
          label184: Map.Entry localEntry5 = (Map.Entry)localIterator6.next();
          localv.a((String)localEntry5.getKey(), localEntry5.getValue());
          break label80;
          label221: Map.Entry localEntry6 = (Map.Entry)localIterator7.next();
          localv.a((String)localEntry6.getKey(), localEntry6.getValue());
          break label104;
        }
        Map.Entry localEntry7 = (Map.Entry)localIterator8.next();
        RequestParams.StreamWrapper localStreamWrapper2 = (RequestParams.StreamWrapper)localEntry7.getValue();
        if (localStreamWrapper2.inputStream != null)
          localv.a((String)localEntry7.getKey(), RequestParams.StreamWrapper.a(localStreamWrapper2.inputStream, localStreamWrapper2.name, localStreamWrapper2.contentType, localStreamWrapper2.autoClose));
      }
    }
    if ((this.streamParams.isEmpty()) && (this.fileParams.isEmpty()))
      return a();
    A localA = new A(paramResponseHandlerInterface);
    localA.a(this.isRepeatable);
    Iterator localIterator1 = this.urlParams.entrySet().iterator();
    Iterator localIterator2;
    label411: Iterator localIterator3;
    label435: Iterator localIterator4;
    if (!localIterator1.hasNext())
    {
      localIterator2 = a(null, this.urlParamsWithObjects).iterator();
      if (localIterator2.hasNext())
        break label509;
      localIterator3 = this.streamParams.entrySet().iterator();
      if (localIterator3.hasNext())
        break label538;
      localIterator4 = this.fileParams.entrySet().iterator();
    }
    while (true)
    {
      if (!localIterator4.hasNext())
      {
        return localA;
        Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
        localA.a((String)localEntry1.getKey(), (String)localEntry1.getValue());
        break;
        label509: BasicNameValuePair localBasicNameValuePair = (BasicNameValuePair)localIterator2.next();
        localA.a(localBasicNameValuePair.getName(), localBasicNameValuePair.getValue());
        break label411;
        label538: Map.Entry localEntry2 = (Map.Entry)localIterator3.next();
        RequestParams.StreamWrapper localStreamWrapper1 = (RequestParams.StreamWrapper)localEntry2.getValue();
        if (localStreamWrapper1.inputStream == null)
          break label435;
        localA.a((String)localEntry2.getKey(), localStreamWrapper1.name, localStreamWrapper1.inputStream, localStreamWrapper1.contentType);
        break label435;
      }
      Map.Entry localEntry3 = (Map.Entry)localIterator4.next();
      RequestParams.FileWrapper localFileWrapper = (RequestParams.FileWrapper)localEntry3.getValue();
      localA.a((String)localEntry3.getKey(), localFileWrapper.file, localFileWrapper.contentType);
    }
  }

  protected String getParamString()
  {
    return URLEncodedUtils.format(getParamsList(), this.contentEncoding);
  }

  protected List<BasicNameValuePair> getParamsList()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.urlParams.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localLinkedList.addAll(a(null, this.urlParamsWithObjects));
        return localLinkedList;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localLinkedList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
  }

  public void put(String paramString, int paramInt)
  {
    if (paramString != null)
      this.urlParams.put(paramString, String.valueOf(paramInt));
  }

  public void put(String paramString, long paramLong)
  {
    if (paramString != null)
      this.urlParams.put(paramString, String.valueOf(paramLong));
  }

  public void put(String paramString, File paramFile)
  {
    put(paramString, paramFile, null);
  }

  public void put(String paramString1, File paramFile, String paramString2)
  {
    if ((paramFile == null) || (!paramFile.exists()))
      throw new FileNotFoundException();
    if (paramString1 != null)
      this.fileParams.put(paramString1, new RequestParams.FileWrapper(paramFile, paramString2));
  }

  public void put(String paramString, InputStream paramInputStream)
  {
    put(paramString, paramInputStream, null);
  }

  public void put(String paramString1, InputStream paramInputStream, String paramString2)
  {
    put(paramString1, paramInputStream, paramString2, null);
  }

  public void put(String paramString1, InputStream paramInputStream, String paramString2, String paramString3)
  {
    put(paramString1, paramInputStream, paramString2, paramString3, this.autoCloseInputStreams);
  }

  public void put(String paramString1, InputStream paramInputStream, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramString1 != null) && (paramInputStream != null))
      this.streamParams.put(paramString1, RequestParams.StreamWrapper.a(paramInputStream, paramString2, paramString3, paramBoolean));
  }

  public void put(String paramString, Object paramObject)
  {
    if ((paramString != null) && (paramObject != null))
      this.urlParamsWithObjects.put(paramString, paramObject);
  }

  public void put(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
      this.urlParams.put(paramString1, paramString2);
  }

  public void remove(String paramString)
  {
    this.urlParams.remove(paramString);
    this.streamParams.remove(paramString);
    this.fileParams.remove(paramString);
    this.urlParamsWithObjects.remove(paramString);
  }

  public void setAutoCloseInputStreams(boolean paramBoolean)
  {
    this.autoCloseInputStreams = paramBoolean;
  }

  public void setContentEncoding(String paramString)
  {
    if (paramString != null)
    {
      this.contentEncoding = paramString;
      return;
    }
    Log.d("RequestParams", "setContentEncoding called with null attribute");
  }

  public void setHttpEntityIsRepeatable(boolean paramBoolean)
  {
    this.isRepeatable = paramBoolean;
  }

  public void setUseJsonStreamer(boolean paramBoolean)
  {
    this.useJsonStreamer = paramBoolean;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.urlParams.entrySet().iterator();
    Iterator localIterator2;
    label44: Iterator localIterator3;
    label68: Iterator localIterator4;
    if (!localIterator1.hasNext())
    {
      localIterator2 = this.streamParams.entrySet().iterator();
      if (localIterator2.hasNext())
        break label173;
      localIterator3 = this.fileParams.entrySet().iterator();
      if (localIterator3.hasNext())
        break label234;
      localIterator4 = a(null, this.urlParamsWithObjects).iterator();
    }
    while (true)
    {
      if (!localIterator4.hasNext())
      {
        return localStringBuilder.toString();
        Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
        if (localStringBuilder.length() > 0)
          localStringBuilder.append("&");
        localStringBuilder.append((String)localEntry1.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append((String)localEntry1.getValue());
        break;
        label173: Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
        if (localStringBuilder.length() > 0)
          localStringBuilder.append("&");
        localStringBuilder.append((String)localEntry2.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append("STREAM");
        break label44;
        label234: Map.Entry localEntry3 = (Map.Entry)localIterator3.next();
        if (localStringBuilder.length() > 0)
          localStringBuilder.append("&");
        localStringBuilder.append((String)localEntry3.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append("FILE");
        break label68;
      }
      BasicNameValuePair localBasicNameValuePair = (BasicNameValuePair)localIterator4.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append("&");
      localStringBuilder.append(localBasicNameValuePair.getName());
      localStringBuilder.append("=");
      localStringBuilder.append(localBasicNameValuePair.getValue());
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.RequestParams
 * JD-Core Version:    0.6.2
 */