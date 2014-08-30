package com.tencent.tauth;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.utils.HttpUtils;
import com.tencent.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationApi extends BaseApi
  implements LbsAgent.OnGetLocationListener
{
  private static final String a = "http://fusion.qq.com/cgi-bin/qzapps/mapp_lbs_getnear.cgi";
  private static final String b = "http://fusion.qq.com/cgi-bin/qzapps/mapp_lbs_delete.cgi";
  private static final int c = 101;
  private static final int d = 103;
  private static final int e = 104;
  private static final String f = "search_nearby";
  private static final String g = "delete_location";
  private static final String h = "id_search_nearby";
  private static final String i = "id_delete_location";
  private static final int j = 1;
  private HandlerThread k;
  private Handler l;
  private Handler m;
  private LbsAgent n;
  private Bundle o;
  private IUiListener p;

  public LocationApi(Context paramContext, QQAuth paramQQAuth, QQToken paramQQToken)
  {
    super(paramContext, paramQQAuth, paramQQToken);
    a();
  }

  public LocationApi(Context paramContext, QQToken paramQQToken)
  {
    super(paramContext, paramQQToken);
    a();
  }

  private void a()
  {
    this.n = new LbsAgent();
    this.k = new HandlerThread("get_location");
    this.k.start();
    this.l = new Handler(this.k.getLooper());
    this.m = new a(this, this.mContext.getMainLooper());
  }

  private void a(int paramInt, String paramString)
  {
    this.n.removeUpdate();
    if (this.p == null)
      return;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", paramInt);
      localJSONObject.put("errMsg", paramString);
      this.p.onComplete(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  private void a(Location paramLocation)
  {
    com.tencent.a.a.c.b("openSDK_LOG", "location: search mParams: " + this.o);
    Bundle localBundle;
    if (this.o != null)
    {
      localBundle = new Bundle(this.o);
      localBundle.putAll(composeCGIParams());
    }
    while (true)
    {
      String str1 = String.valueOf(paramLocation.getLatitude());
      String str2 = String.valueOf(paramLocation.getLongitude());
      localBundle.putString("appid", this.mToken.getAppId());
      if (!localBundle.containsKey("latitude"))
        localBundle.putString("latitude", str1);
      if (!localBundle.containsKey("longitude"))
        localBundle.putString("longitude", str2);
      if (!localBundle.containsKey("page"))
        localBundle.putString("page", String.valueOf(1));
      localBundle.putString("encrytoken", Util.encrypt("tencent&sdk&qazxc***14969%%" + this.mToken.getAccessToken() + this.mToken.getAppId() + this.mToken.getOpenId() + "qzone3.4"));
      com.tencent.a.a.c.b("openSDK_LOG", "location: search params: " + localBundle);
      e locale = new e(this, this.p);
      HttpUtils.requestAsync(this.mToken, this.mContext, "http://fusion.qq.com/cgi-bin/qzapps/mapp_lbs_getnear.cgi", localBundle, "GET", locale);
      return;
      localBundle = composeCGIParams();
    }
  }

  private void a(String paramString, String[] paramArrayOfString)
  {
    this.l.post(new c(this, paramArrayOfString, paramString));
  }

  private void c()
  {
    this.n.removeUpdate();
  }

  private boolean d()
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)this.mContext.getSystemService("connectivity");
    if (localConnectivityManager != null)
    {
      NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      return (localNetworkInfo != null) && (localNetworkInfo.isAvailable());
    }
    return false;
  }

  private static JSONObject e()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", -9);
      localJSONObject.put("errMsg", "网络连接异常，请检查后重试!");
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }

  public void deleteLocation(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    if (!d())
    {
      if (paramIUiListener != null)
        paramIUiListener.onComplete(e());
      return;
    }
    Bundle localBundle;
    if (paramBundle != null)
    {
      localBundle = new Bundle(paramBundle);
      localBundle.putAll(composeCGIParams());
    }
    while (true)
    {
      localBundle.putString("appid", this.mToken.getAppId());
      localBundle.putString("timestamp", String.valueOf(System.currentTimeMillis()));
      localBundle.putString("encrytoken", Util.encrypt("tencent&sdk&qazxc***14969%%" + this.mToken.getAccessToken() + this.mToken.getAppId() + this.mToken.getOpenId() + "qzone3.4"));
      com.tencent.a.a.c.b("openSDK_LOG", "location: delete params: " + localBundle);
      e locale = new e(this, paramIUiListener);
      HttpUtils.requestAsync(this.mToken, this.mContext, "http://fusion.qq.com/cgi-bin/qzapps/mapp_lbs_delete.cgi", localBundle, "GET", locale);
      String[] arrayOfString = { "success" };
      this.l.post(new c(this, arrayOfString, "delete_location"));
      return;
      localBundle = composeCGIParams();
    }
  }

  public void onLocationUpdate(Location paramLocation)
  {
    com.tencent.a.a.c.b("openSDK_LOG", "location: search mParams: " + this.o);
    Bundle localBundle;
    if (this.o != null)
    {
      localBundle = new Bundle(this.o);
      localBundle.putAll(composeCGIParams());
    }
    while (true)
    {
      String str1 = String.valueOf(paramLocation.getLatitude());
      String str2 = String.valueOf(paramLocation.getLongitude());
      localBundle.putString("appid", this.mToken.getAppId());
      if (!localBundle.containsKey("latitude"))
        localBundle.putString("latitude", str1);
      if (!localBundle.containsKey("longitude"))
        localBundle.putString("longitude", str2);
      if (!localBundle.containsKey("page"))
        localBundle.putString("page", String.valueOf(1));
      localBundle.putString("encrytoken", Util.encrypt("tencent&sdk&qazxc***14969%%" + this.mToken.getAccessToken() + this.mToken.getAppId() + this.mToken.getOpenId() + "qzone3.4"));
      com.tencent.a.a.c.b("openSDK_LOG", "location: search params: " + localBundle);
      e locale = new e(this, this.p);
      HttpUtils.requestAsync(this.mToken, this.mContext, "http://fusion.qq.com/cgi-bin/qzapps/mapp_lbs_getnear.cgi", localBundle, "GET", locale);
      this.n.removeUpdate();
      this.m.removeMessages(101);
      return;
      localBundle = composeCGIParams();
    }
  }

  public void searchNearby(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    if (!d())
    {
      if (paramIUiListener != null)
        paramIUiListener.onComplete(e());
      return;
    }
    this.o = paramBundle;
    this.p = paramIUiListener;
    this.l.post(new b(this));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.tauth.LocationApi
 * JD-Core Version:    0.6.2
 */