package com.xiaomi.miui.analyticstracker.service;

import android.util.Base64;
import android.util.Log;
import com.xiaomi.miui.analyticstracker.utils.SaltGenerate;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class XiaomiServer
{
  private static final String a = "http://tracking.miui.com/tracks";
  private static final String b = "XIAOMI_SERVER";
  private static final String c = "_app_package_";
  private static final String d = "miui-track_danfa_";
  private static final String e = "t";
  private static final String f = "value";
  private static final String g = "s";
  private static XiaomiServer h;
  private static Object i = new Object();
  private HttpPost j;
  private HttpClient k;

  public static XiaomiServer getInstance()
  {
    if (h == null);
    synchronized (i)
    {
      if (h == null)
        h = new XiaomiServer();
      return h;
    }
  }

  public void close()
  {
    this.j = null;
    this.k = null;
  }

  public void init()
  {
    this.k = new DefaultHttpClient();
    this.j = new HttpPost("http://tracking.miui.com/tracks");
  }

  public boolean send(Map<String, Object> paramMap)
  {
    HttpClient localHttpClient = this.k;
    boolean bool = false;
    if (localHttpClient != null)
    {
      HttpPost localHttpPost = this.j;
      bool = false;
      if (localHttpPost != null)
      {
        bool = false;
        if (paramMap != null)
        {
          JSONObject localJSONObject = new JSONObject(paramMap);
          String str1 = new String(Base64.encodeToString(localJSONObject.toString().getBytes(), 2));
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(new BasicNameValuePair("t", "miui-track_danfa_" + localJSONObject.optString("_app_package_", "null")));
          localLinkedList.add(new BasicNameValuePair("value", str1));
          localLinkedList.add(new BasicNameValuePair("s", SaltGenerate.getKeyFromParams(localLinkedList)));
          try
          {
            this.j.setEntity(new UrlEncodedFormEntity(localLinkedList, "UTF-8"));
            HttpResponse localHttpResponse = this.k.execute(this.j);
            int m = localHttpResponse.getStatusLine().getStatusCode();
            bool = false;
            if (200 == m)
            {
              String str2 = new JSONObject(EntityUtils.toString(localHttpResponse.getEntity())).getString("status");
              if (str2.equals("ok"))
              {
                bool = true;
                Log.i("XIAOMI_SERVER", localJSONObject.optString("_app_package_", "null") + " sent OK.");
                return bool;
              }
              Log.i("XIAOMI_SERVER", str2);
              return false;
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
            return bool;
          }
          catch (ClientProtocolException localClientProtocolException)
          {
            localClientProtocolException.printStackTrace();
            return bool;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
            return bool;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            return bool;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return bool;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.service.XiaomiServer
 * JD-Core Version:    0.6.2
 */