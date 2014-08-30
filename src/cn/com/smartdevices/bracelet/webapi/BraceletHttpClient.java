package cn.com.smartdevices.bracelet.webapi;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.LoginData;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public class BraceletHttpClient
{
  public static AsyncHttpClient client = new AsyncHttpClient();
  public static SyncHttpClient syncClient = new SyncHttpClient();

  static
  {
    client.setTimeout(20000);
    syncClient.setTimeout(20000);
  }

  private static String a(String paramString1, String paramString2)
  {
    return "https://hm.xiaomi.com/" + paramString1 + paramString2;
  }

  public static String getParamString(HashMap<String, String> paramHashMap)
  {
    Iterator localIterator = paramHashMap.entrySet().iterator();
    Object localObject = "?";
    while (true)
    {
      if (!localIterator.hasNext())
        return localObject;
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(localObject)).append((String)localEntry.getKey()).toString())).append("=").toString() + (String)localEntry.getValue();
      if (localIterator.hasNext())
        localObject = str + "&";
      else
        localObject = str;
    }
  }

  public static HashMap<String, String> getSysHm(LoginData paramLoginData)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("userid", paramLoginData.uid);
    localHashMap.put("security", paramLoginData.security);
    localHashMap.put("v", "1.0");
    localHashMap.put("appid", ClientConstant.CLIENT_ID);
    localHashMap.put("callid", System.currentTimeMillis());
    localHashMap.put("lang", Locale.getDefault().getLanguage());
    return localHashMap;
  }

  public static RequestParams getSysRp(LoginData paramLoginData)
  {
    RequestParams localRequestParams = new RequestParams();
    localRequestParams.put("userid", paramLoginData.uid);
    localRequestParams.put("security", paramLoginData.security);
    localRequestParams.put("v", "1.0");
    localRequestParams.put("appid", ClientConstant.CLIENT_ID);
    localRequestParams.put("callid", System.currentTimeMillis());
    localRequestParams.put("lang", Locale.getDefault().getLanguage());
    return localRequestParams;
  }

  public static String getUrl(String paramString)
  {
    String str = "https://hm.xiaomi.com/" + paramString;
    Debug.i("URL", str);
    return str;
  }

  public static String getUrl(String paramString, HashMap<String, String> paramHashMap)
  {
    return a(paramString, getParamString(ClientUtil.getParamMap(paramHashMap)));
  }

  public static String getUrlNoHttps(String paramString)
  {
    String str = "http://hm.xiaomi.com/" + paramString;
    Debug.i("URL", str);
    return str;
  }

  public static String postUrl(String paramString, HashMap<String, String> paramHashMap)
  {
    return a(paramString, getParamString(ClientUtil.getSysParamMap(paramHashMap)));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.webapi.BraceletHttpClient
 * JD-Core Version:    0.6.2
 */