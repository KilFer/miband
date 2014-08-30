package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.common.RC4;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.event.Event;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

final class c
{
  private static StatLogger a = StatCommonHelper.getLogger();
  private static long b;
  private static c e = null;
  private static Context f = null;
  private DefaultHttpClient c = null;
  private Handler d = null;

  private c()
  {
    try
    {
      HandlerThread localHandlerThread = new HandlerThread("StatDispatcher");
      localHandlerThread.start();
      localHandlerThread.getId();
      this.d = new Handler(localHandlerThread.getLooper());
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, 10000);
      this.c = new DefaultHttpClient(localBasicHttpParams);
      this.c.setKeepAliveStrategy(new d(this));
      if (StatConfig.b() != null)
        this.c.getParams().setParameter("http.route.default-proxy", StatConfig.b());
      return;
    }
    catch (Throwable localThrowable)
    {
      a.e(localThrowable);
    }
  }

  static Context a()
  {
    return f;
  }

  static void a(Context paramContext)
  {
    f = paramContext.getApplicationContext();
  }

  static c b()
  {
    if (e == null)
      e = new c();
    return e;
  }

  final void a(Event paramEvent, b paramb)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramEvent.toJsonString();
    b(Arrays.asList(arrayOfString), paramb);
  }

  final void a(List<String> paramList, b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    for (int i = 0; i < paramList.size(); i++)
    {
      localStringBuilder.append((String)paramList.get(i));
      if (i != -1 + paramList.size())
        localStringBuilder.append(",");
    }
    localStringBuilder.append("]");
    String str = StatConfig.getStatReportUrl();
    a.i("[" + str + "]Send request(" + localStringBuilder.toString().length() + "bytes):" + localStringBuilder.toString());
    HttpPost localHttpPost = new HttpPost(str);
    HttpHost localHttpHost;
    ByteArrayOutputStream localByteArrayOutputStream;
    byte[] arrayOfByte1;
    int k;
    HttpResponse localHttpResponse;
    HttpEntity localHttpEntity;
    int m;
    long l;
    try
    {
      localHttpPost.addHeader("Accept-Encoding", "gzip");
      localHttpPost.setHeader("Connection", "Keep-Alive");
      localHttpPost.removeHeaders("Cache-Control");
      localHttpHost = StatCommonHelper.getHttpProxy(f);
      int j = 0;
      if (localHttpHost != null)
      {
        this.c.getParams().setParameter("http.route.default-proxy", StatCommonHelper.getHttpProxy(f));
        localHttpPost.addHeader("X-Online-Host", "pingma.qq.com:80");
        localHttpPost.addHeader("Accept", "*/*");
        localHttpPost.addHeader("Content-Type", "json");
        j = 1;
      }
      localByteArrayOutputStream = new ByteArrayOutputStream();
      arrayOfByte1 = localStringBuilder.toString().getBytes("UTF-8");
      k = arrayOfByte1.length;
      if (localStringBuilder.length() < 256)
      {
        if (localHttpHost == null)
          localHttpPost.addHeader("Content-Encoding", "rc4");
        while (true)
        {
          localHttpPost.setEntity(new ByteArrayEntity(RC4.encrypt(arrayOfByte1)));
          localHttpResponse = this.c.execute(localHttpPost);
          if (j != 0)
            this.c.getParams().removeParameter("http.route.default-proxy");
          localHttpEntity = localHttpResponse.getEntity();
          m = localHttpResponse.getStatusLine().getStatusCode();
          l = localHttpEntity.getContentLength();
          a.i("recv response status code:" + m + ", content length:" + l);
          if (l != 0L)
            break label621;
          EntityUtils.toString(localHttpEntity);
          if (m != 200)
            break;
          if (paramb == null)
            return;
          paramb.a();
          return;
          localHttpPost.addHeader("X-Content-Encoding", "rc4");
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable = localThrowable;
      a.e(localThrowable);
      if (paramb == null)
        return;
      paramb.b();
      return;
    }
    finally
    {
    }
    if (localHttpHost == null)
      localHttpPost.addHeader("Content-Encoding", "rc4,gzip");
    while (true)
    {
      localByteArrayOutputStream.write(new byte[4]);
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(arrayOfByte1);
      localGZIPOutputStream.close();
      arrayOfByte1 = localByteArrayOutputStream.toByteArray();
      ByteBuffer.wrap(arrayOfByte1, 0, 4).putInt(k);
      a.d("before Gzip:" + k + " bytes, after Gzip:" + arrayOfByte1.length + " bytes");
      break;
      localHttpPost.addHeader("X-Content-Encoding", "rc4,gzip");
    }
    a.error("Server response error code:" + m);
    return;
    label621: if (l > 0L)
    {
      InputStream localInputStream = localHttpEntity.getContent();
      DataInputStream localDataInputStream = new DataInputStream(localInputStream);
      Object localObject2 = new byte[(int)localHttpEntity.getContentLength()];
      localDataInputStream.readFully((byte[])localObject2);
      Header localHeader = localHttpResponse.getFirstHeader("Content-Encoding");
      if (localHeader != null)
      {
        if (localHeader.getValue().equalsIgnoreCase("gzip,rc4"))
        {
          byte[] arrayOfByte2 = RC4.decrypt(StatCommonHelper.deocdeGZipContent((byte[])localObject2));
          localObject2 = arrayOfByte2;
        }
      }
      else
        if (m != 200)
          break label885;
      while (true)
      {
        try
        {
          a.d(new String((byte[])localObject2, "UTF-8"));
          JSONObject localJSONObject = new JSONObject(new String((byte[])localObject2, "UTF-8")).getJSONObject("cfg");
          if (localJSONObject != null)
            StatConfig.a(localJSONObject);
          if (paramb != null)
            paramb.a();
          localInputStream.close();
          return;
          if (localHeader.getValue().equalsIgnoreCase("rc4,gzip"))
          {
            localObject2 = StatCommonHelper.deocdeGZipContent(RC4.decrypt((byte[])localObject2));
            break;
          }
          if (localHeader.getValue().equalsIgnoreCase("gzip"))
          {
            localObject2 = StatCommonHelper.deocdeGZipContent((byte[])localObject2);
            break;
          }
          if (!localHeader.getValue().equalsIgnoreCase("rc4"))
            break;
          localObject2 = RC4.decrypt((byte[])localObject2);
        }
        catch (JSONException localJSONException)
        {
          a.i(localJSONException.toString());
          continue;
        }
        label885: a.error("Server response error code:" + m + ", error:" + new String((byte[])localObject2, "UTF-8"));
      }
    }
    EntityUtils.toString(localHttpEntity);
  }

  final void b(List<String> paramList, b paramb)
  {
    if ((paramList.isEmpty()) || (this.d == null))
      return;
    this.d.post(new e(this, paramList, paramb));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.c
 * JD-Core Version:    0.6.2
 */