package cn.com.smartdevices.bracelet.upgrade;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

public class WebServiceClient
{
  public static final String URL_OTA = "http://ota.app-xae.xiaomi.com/ota_testhm.php";
  public static final String URL_SMARTDEVICES_WEB_SERVICE = "http://ota.app-xae.xiaomi.com/soft_testhm.php";
  public static final String URL_UPGRADE_TEST = "http://10.12.5.10/tmp/";
  private static final int a = 60000;
  private static final int b = 60000;
  private static final String c = "1.0";
  private static final String d = "ch";
  private static final String e = "en";
  private static WebServiceClient f;
  private HttpClient g = new DefaultHttpClient();
  private Context h;

  private WebServiceClient(Context paramContext)
  {
    HttpParams localHttpParams = this.g.getParams();
    localHttpParams.setIntParameter("http.socket.timeout", 60000);
    localHttpParams.setIntParameter("http.connection.timeout", 60000);
    this.h = paramContext;
  }

  private static String a(String paramString, ArrayList<NameValuePair> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    if (!localIterator.hasNext())
      return paramString;
    NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString));
    if (i == 0);
    for (String str = "?"; ; str = "&")
    {
      paramString = str + localNameValuePair.getName() + "=" + localNameValuePair.getValue();
      i++;
      break;
    }
  }

  private ArrayList<NameValuePair> a()
  {
    ArrayList localArrayList = new ArrayList();
    TelephonyManager localTelephonyManager = (TelephonyManager)this.h.getSystemService("phone");
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    String str9;
    if (localTelephonyManager != null)
    {
      String str11 = localTelephonyManager.getDeviceId();
      String str12 = localTelephonyManager.getSimSerialNumber();
      String str13 = ((WifiManager)this.h.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      String str14 = Settings.Secure.getString(this.h.getContentResolver(), "android_id");
      str1 = new UUID(str13.hashCode() << 32 | str14.hashCode(), str11.hashCode() << 32 | str12.hashCode()).toString();
      str2 = Build.VERSION.RELEASE;
      str3 = Build.VERSION.SDK_INT;
      str4 = Build.MODEL;
      str5 = this.h.getPackageName();
      str6 = this.h.getString(2131492870);
      str7 = UpgradeUtil.getApkVersionCode(this.h, this.h.getPackageName());
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      Display localDisplay = ((Activity)this.h).getWindowManager().getDefaultDisplay();
      localDisplay.getMetrics(localDisplayMetrics);
      str8 = localDisplay.getWidth();
      str9 = localDisplay.getHeight();
      if (!((Activity)this.h).getResources().getConfiguration().locale.getLanguage().equals(Locale.CHINESE.toString()))
        break label581;
    }
    label581: for (String str10 = "ch"; ; str10 = "en")
    {
      localArrayList.add(new BasicNameValuePair("devicecode", str1));
      localArrayList.add(new BasicNameValuePair("os", str2));
      localArrayList.add(new BasicNameValuePair("osversion", str3));
      localArrayList.add(new BasicNameValuePair("devicetype", str4));
      localArrayList.add(new BasicNameValuePair("package", str5));
      localArrayList.add(new BasicNameValuePair("software", str6));
      localArrayList.add(new BasicNameValuePair("softv", str7));
      localArrayList.add(new BasicNameValuePair("channel", "HHCN"));
      localArrayList.add(new BasicNameValuePair("ie", "UTF-8"));
      localArrayList.add(new BasicNameValuePair("w", str8));
      localArrayList.add(new BasicNameValuePair("h", str9));
      localArrayList.add(new BasicNameValuePair("v", "1.0"));
      localArrayList.add(new BasicNameValuePair("l", str10));
      return localArrayList;
      str1 = "null";
      break;
    }
  }

  public static WebServiceClient getInstance(Context paramContext)
  {
    if (f == null)
      f = new WebServiceClient(paramContext);
    return f;
  }

  public InputStream get(String paramString, ArrayList<NameValuePair> paramArrayList)
  {
    try
    {
      Iterator localIterator = paramArrayList.iterator();
      int i = 0;
      if (!localIterator.hasNext())
      {
        HttpGet localHttpGet = new HttpGet(paramString);
        HttpResponse localHttpResponse = this.g.execute(localHttpGet);
        if (localHttpResponse.getStatusLine().getStatusCode() == 200)
          return localHttpResponse.getEntity().getContent();
      }
      else
      {
        NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString));
        if (i == 0);
        for (String str = "?"; ; str = "&")
        {
          paramString = str + localNameValuePair.getName() + "=" + localNameValuePair.getValue();
          i++;
          break;
        }
      }
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      localClientProtocolException.printStackTrace();
      return null;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }

  public InputStream post(String paramString, ArrayList<NameValuePair> paramArrayList)
  {
    HttpPost localHttpPost = new HttpPost(paramString);
    while (true)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        TelephonyManager localTelephonyManager = (TelephonyManager)this.h.getSystemService("phone");
        if (localTelephonyManager == null)
          break label711;
        String str1 = localTelephonyManager.getDeviceId();
        String str2 = localTelephonyManager.getSimSerialNumber();
        String str3 = ((WifiManager)this.h.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        String str4 = Settings.Secure.getString(this.h.getContentResolver(), "android_id");
        str5 = new UUID(str3.hashCode() << 32 | str4.hashCode(), str1.hashCode() << 32 | str2.hashCode()).toString();
        String str6 = Build.VERSION.RELEASE;
        String str7 = Build.VERSION.SDK_INT;
        String str8 = Build.MODEL;
        String str9 = this.h.getPackageName();
        String str10 = this.h.getString(2131492870);
        String str11 = UpgradeUtil.getApkVersionCode(this.h, this.h.getPackageName());
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        Display localDisplay = ((Activity)this.h).getWindowManager().getDefaultDisplay();
        localDisplay.getMetrics(localDisplayMetrics);
        String str12 = localDisplay.getWidth();
        String str13 = localDisplay.getHeight();
        String str14;
        if (((Activity)this.h).getResources().getConfiguration().locale.getLanguage().equals(Locale.CHINESE.toString()))
        {
          str14 = "ch";
          BasicNameValuePair localBasicNameValuePair = new BasicNameValuePair("devicecode", str5);
          localArrayList.add(localBasicNameValuePair);
          localArrayList.add(new BasicNameValuePair("os", str6));
          localArrayList.add(new BasicNameValuePair("osversion", str7));
          localArrayList.add(new BasicNameValuePair("devicetype", str8));
          localArrayList.add(new BasicNameValuePair("package", str9));
          localArrayList.add(new BasicNameValuePair("software", str10));
          localArrayList.add(new BasicNameValuePair("softv", str11));
          localArrayList.add(new BasicNameValuePair("channel", "HHCN"));
          localArrayList.add(new BasicNameValuePair("ie", "UTF-8"));
          localArrayList.add(new BasicNameValuePair("w", str12));
          localArrayList.add(new BasicNameValuePair("h", str13));
          localArrayList.add(new BasicNameValuePair("v", "1.0"));
          localArrayList.add(new BasicNameValuePair("l", str14));
          if (paramArrayList != null)
            localArrayList.addAll(paramArrayList);
          localHttpPost.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
          HttpResponse localHttpResponse = this.g.execute(localHttpPost);
          if (localHttpResponse.getStatusLine().getStatusCode() == 200)
            return localHttpResponse.getEntity().getContent();
        }
        else
        {
          str14 = "en";
          continue;
        }
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        localClientProtocolException.printStackTrace();
        return null;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return null;
      label711: String str5 = "null";
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.upgrade.WebServiceClient
 * JD-Core Version:    0.6.2
 */